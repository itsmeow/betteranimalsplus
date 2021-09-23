package dev.itsmeow.betteranimalsplus.common.entity.util;

import dev.itsmeow.imdlib.entity.AbstractEntityBuilder;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.EntityTypeDefinition;
import dev.itsmeow.imdlib.util.config.ConfigBuilder;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class EntityTypeContainerBAPTameable<T extends TamableAnimal> extends EntityTypeContainer<T> {

    protected String[] tameItemsStore;
    protected Supplier<List<? extends String>> tameItems;
    protected String[] defaultTameItems;

    private EntityTypeContainerBAPTameable(TameableEntityTypeDefinition<T> def) {
        super(def);
        this.defaultTameItems = def.getTameItems();
    }

    public String[] getTameItems() {
        return tameItemsStore;
    }

    @Environment(EnvType.CLIENT)
    public void setTameItems(String[] items) {
        this.tameItemsStore = items;
    }

    @Override
    protected void customConfigurationLoad() {
        super.customConfigurationLoad();
        this.tameItemsStore = tameItems.get().toArray(new String[0]);
    }

    @Override
    protected void customConfigurationInit(ConfigBuilder builder) {
        super.customConfigurationInit(builder);
        this.tameItems = builder.defineList("taming_items", "List of acceptable item IDs to use for taming. Accepts tags by prefixing them with '#'.", Arrays.asList(defaultTameItems), input -> input instanceof String);
    }

    protected static class TameableEntityTypeDefinition<T extends TamableAnimal> extends EntityTypeDefinition<T> {
        AbstractEntityBuilderBAPTameable<T, ?, ?> builder;

        public TameableEntityTypeDefinition(AbstractEntityBuilderBAPTameable<T, ?, ?> builder) {
            super(builder);
            this.builder = builder;
        }

        public String[] getTameItems() {
            return builder.defaultTameItems;
        }

    }

    public static abstract class AbstractEntityBuilderBAPTameable<T extends TamableAnimal, C extends EntityTypeContainerBAPTameable<T>, B extends AbstractEntityBuilderBAPTameable<T, C, B>> extends AbstractEntityBuilder<T, C, B> {
        protected String[] defaultTameItems;

        protected AbstractEntityBuilderBAPTameable(Class<T> EntityClass, EntityType.EntityFactory<T> factory, String entityNameIn, Supplier<AttributeSupplier.Builder> attributeMap, String modid) {
            super(EntityClass, factory, entityNameIn, attributeMap, modid);
        }

        public B tameItems(String... items) {
            this.defaultTameItems = items;
            return getImplementation();
        }

    }

    public static class Builder<T extends TamableAnimal> extends AbstractEntityBuilderBAPTameable<T, EntityTypeContainerBAPTameable<T>, Builder<T>> {

        protected Builder(Class<T> EntityClass, EntityType.EntityFactory<T> factory, String entityNameIn, Supplier<AttributeSupplier.Builder> attributeMap, String modid) {
            super(EntityClass, factory, entityNameIn, attributeMap, modid);
        }

        public static <T extends TamableAnimal> Builder<T> create(Class<T> EntityClass, EntityType.EntityFactory<T> factory, String entityNameIn, Supplier<AttributeSupplier.Builder> attributeMap, String modid) {
            return new Builder<>(EntityClass, factory, entityNameIn, attributeMap, modid);
        }

        @Override
        public EntityTypeContainerBAPTameable<T> rawBuild() {
            return new EntityTypeContainerBAPTameable<>(new TameableEntityTypeDefinition<>(this));
        }

        @Override
        public Builder<T> getImplementation() {
            return this;
        }

    }

}