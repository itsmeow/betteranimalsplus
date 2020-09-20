package its_meow.betteranimalsplus.common.entity.util;

import java.util.function.BiFunction;
import java.util.function.Function;

import dev.itsmeow.imdlib.entity.util.builder.EntityTypeDefinition;
import its_meow.betteranimalsplus.common.item.IContainerItem;
import its_meow.betteranimalsplus.common.item.IContainerItem.ITooltipFunction;
import net.minecraft.entity.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;

public class EntityTypeContainerBAPContainable<T extends MobEntity & IContainable, I extends Item & IContainerItem<T>> extends EntityTypeContainerBAP<T> {

    protected DataParameter<Boolean> fromContainerDataKey;
    protected I containerItem;
    protected Item emptyContainerItem;

    protected EntityTypeContainerBAPContainable(ContainableEntityTypeDefinition<T, I, EntityTypeContainerBAPContainable<T, I>> def) {
        super(def);
        this.containerItem = def.getContainerSupplier().apply(this, def.getTooltipFunction());
        this.emptyContainerItem = def.getEmptyContainerSupplier().apply(this);
    }

    protected static class ContainableEntityTypeDefinition<T extends MobEntity & IContainable, I extends Item & IContainerItem<T>, C extends EntityTypeContainerBAPContainable<T, I>> extends EntityTypeDefinition<T> {
        AbstractEntityBuilderBAPContainable<T, I, C, ?> builder;

        public ContainableEntityTypeDefinition(AbstractEntityBuilderBAPContainable<T, I, C, ?> builder) {
            super(builder);
            this.builder = builder;
        }

        public ITooltipFunction getTooltipFunction() {
            return builder.tooltipFinal;
        }

        public BiFunction<C, ITooltipFunction, I> getContainerSupplier() {
            return builder.containerSupplier;
        }

        public Function<C, Item> getEmptyContainerSupplier() {
            return builder.emptyContainerSupplier;
        }

    }

    public static abstract class AbstractEntityBuilderBAPContainable<T extends MobEntity & IContainable, I extends Item & IContainerItem<T>, C extends EntityTypeContainerBAPContainable<T, I>, B extends AbstractEntityBuilderBAPContainable<T, I, C, B>> extends AbstractEntityBuilderBAP<T, C, B> {

        protected ITooltipFunction tooltip;
        protected ITooltipFunction tooltipFinal;
        protected BiFunction<C, ITooltipFunction, I> containerSupplier;
        protected Function<C, Item> emptyContainerSupplier;

        protected AbstractEntityBuilderBAPContainable(Class<T> EntityClass, Function<World, T> func, String entityNameIn) {
            super(EntityClass, func, entityNameIn);
        }

        public B containers(BiFunction<C, ITooltipFunction, I> containerSupplier, Function<C, Item> emptyContainerSupplier) {
            return containers(containerSupplier, emptyContainerSupplier, null);
        }

        public B containers(BiFunction<C, ITooltipFunction, I> containerSupplier, Function<C, Item> emptyContainerSupplier, ITooltipFunction tooltip) {
            this.containerSupplier = containerSupplier;
            this.emptyContainerSupplier = emptyContainerSupplier;
            this.tooltip = tooltip;
            return getImplementation();
        }

        @Override
        public void preBuild() {
            if(variantCount > 0) {
                if(this.tooltip == null) {
                    this.tooltipFinal = IContainerItem.VARIANT_TOOLTIP;
                } else {
                    this.tooltipFinal = (container, stack, worldIn, tooltip) -> {
                        IContainerItem.VARIANT_TOOLTIP.addInformation(container, stack, worldIn, tooltip);
                        this.tooltip.addInformation(container, stack, worldIn, tooltip);
                    };
                }
            } else if(this.tooltip != null) {
                this.tooltipFinal = this.tooltip;
            } else if(this.tooltip == null) {
                this.tooltipFinal = (container, stack, world, tooltip) -> {
                };
            }
        }
    }

    public static class Builder<T extends MobEntity & IContainable, I extends Item & IContainerItem<T>> extends AbstractEntityBuilderBAPContainable<T, I, EntityTypeContainerBAPContainable<T, I>, Builder<T, I>> {

        protected Builder(Class<T> EntityClass, Function<World, T> func, String entityNameIn) {
            super(EntityClass, func, entityNameIn);
        }

        @Override
        public EntityTypeContainerBAPContainable<T, I> rawBuild() {
            return new EntityTypeContainerBAPContainable<T, I>(new ContainableEntityTypeDefinition<T, I, EntityTypeContainerBAPContainable<T, I>>(this));
        }

        @Override
        public Builder<T, I> getImplementation() {
            return this;
        }

        public static <T extends MobEntity & IContainable, I extends Item & IContainerItem<T>> Builder<T, I> create(Class<T> EntityClass, Function<World, T> func, String entityNameIn) {
            return new Builder<T, I>(EntityClass, func, entityNameIn);
        }
    }

    public DataParameter<Boolean> getFromContainerDataKey() {
        if(this.fromContainerDataKey == null) {
            this.fromContainerDataKey = EntityDataManager.<Boolean>createKey(this.entityClass, DataSerializers.BOOLEAN);
        }
        return this.fromContainerDataKey;
    }

    public I getContainerItem() {
        return this.containerItem;
    }

    public Item getEmptyContainerItem() {
        return this.emptyContainerItem;
    }

}
