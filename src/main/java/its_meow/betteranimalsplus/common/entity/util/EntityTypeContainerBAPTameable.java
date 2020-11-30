package its_meow.betteranimalsplus.common.entity.util;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import dev.itsmeow.imdlib.entity.util.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.util.builder.AbstractEntityBuilder;
import dev.itsmeow.imdlib.entity.util.builder.EntityTypeDefinition;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

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

        protected AbstractEntityBuilderBAPTameable(Class<T> EntityClass, Function<World, T> func, String entityNameIn, String modid) {
            super(EntityClass, func, entityNameIn, modid);
        }

        public B tameItems(String... items) {
            this.defaultTameItems = items;
            return getImplementation();
        }

    }

    public static class Builder<T extends TameableEntity> extends AbstractEntityBuilderBAPTameable<T, EntityTypeContainerBAPTameable<T>, Builder<T>> {

        protected Builder(Class<T> EntityClass, Function<World, T> func, String entityNameIn, String modid) {
            super(EntityClass, func, entityNameIn, modid);
        }

        @Override
        public EntityTypeContainerBAPTameable<T> rawBuild() {
            return new EntityTypeContainerBAPTameable<T>(new TameableEntityTypeDefinition<T>(this));
        }

        @Override
        public Builder<T> getImplementation() {
            return this;
        }

        public static <T extends TameableEntity> Builder<T> create(Class<T> EntityClass, Function<World, T> func, String entityNameIn, String modid) {
            return new Builder<T>(EntityClass, func, entityNameIn, modid);
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
    public void configurationLoad() {
        super.configurationLoad();
        this.tameItemsStore = tameItems.get().toArray(new String[0]);
    }

    @Override
    public void customConfigurationInit(ForgeConfigSpec.Builder builder) {
        super.customConfigurationInit(builder);
        this.tameItems = builder.comment("List of acceptable item IDs to use for taming. Accepts tags by prefixing them with '#'.").worldRestart().defineList("tameItems", Arrays.asList(defaultTameItems), (Predicate<Object>) input -> input instanceof String);
    }

}
