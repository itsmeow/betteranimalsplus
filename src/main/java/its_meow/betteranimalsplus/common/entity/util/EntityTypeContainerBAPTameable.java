package its_meow.betteranimalsplus.common.entity.util;


import dev.itsmeow.imdlib.entity.AbstractEntityBuilder;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.EntityTypeDefinition;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

import java.util.Arrays;
import java.util.List;

public class EntityTypeContainerBAPTameable<T extends TameableEntity> extends EntityTypeContainer<T> {

    protected String[] tameItemsStore;
    protected ConfigValue<List<? extends String>> tameItems;
    protected String[] defaultTameItems;

    private EntityTypeContainerBAPTameable(TameableEntityTypeDefinition<T> def) {
        super(def);
        this.defaultTameItems = def.getTameItems();
    }

    protected static class TameableEntityTypeDefinition<T extends TameableEntity> extends EntityTypeDefinition<T> {
        AbstractEntityBuilderBAPTameable<T, ?, ?> builder;

        public TameableEntityTypeDefinition(AbstractEntityBuilderBAPTameable<T, ?, ?> builder) {
            super(builder);
            this.builder = builder;
        }

        public String[] getTameItems() {
            return builder.defaultTameItems;
        }

    }

    public static abstract class AbstractEntityBuilderBAPTameable<T extends TameableEntity, C extends EntityTypeContainerBAPTameable<T>, B extends AbstractEntityBuilderBAPTameable<T, C, B>> extends AbstractEntityBuilder<T, C, B> {
        protected String[] defaultTameItems;

        protected AbstractEntityBuilderBAPTameable(Class<T> EntityClass, EntityType.IFactory<T> factory, String entityNameIn, String modid) {
            super(EntityClass, factory, entityNameIn, modid);
        }

        public B tameItems(String... items) {
            this.defaultTameItems = items;
            return getImplementation();
        }

    }

    public static class Builder<T extends TameableEntity> extends AbstractEntityBuilderBAPTameable<T, EntityTypeContainerBAPTameable<T>, Builder<T>> {

        protected Builder(Class<T> EntityClass, EntityType.IFactory<T> factory, String entityNameIn, String modid) {
            super(EntityClass, factory, entityNameIn, modid);
        }

        @Override
        public EntityTypeContainerBAPTameable<T> rawBuild() {
            return new EntityTypeContainerBAPTameable<>(new TameableEntityTypeDefinition<>(this));
        }

        @Override
        public Builder<T> getImplementation() {
            return this;
        }

        public static <T extends TameableEntity> Builder<T> create(Class<T> EntityClass, EntityType.IFactory<T> factory, String entityNameIn, String modid) {
            return new Builder<>(EntityClass, factory, entityNameIn, modid);
        }

    }

    public String[] getTameItems() {
        return tameItemsStore;
    }

    @OnlyIn(Dist.CLIENT)
    public void setTameItems(String[] items) {
        this.tameItemsStore = items;
    }

    @Override
    protected void customConfigurationLoad() {
        super.customConfigurationLoad();
        this.tameItemsStore = tameItems.get().toArray(new String[0]);
    }

    @Override
    protected void customConfigurationInit(ForgeConfigSpec.Builder builder) {
        super.customConfigurationInit(builder);
        this.tameItems = builder.comment("List of acceptable item IDs to use for taming. Accepts tags by prefixing them with '#'.").worldRestart().defineList("taming_items", Arrays.asList(defaultTameItems), input -> input instanceof String);
    }

}
