package dev.itsmeow.betteranimalsplus.util;

import dev.itsmeow.betteranimalsplus.Ref;
import dev.itsmeow.betteranimalsplus.common.entity.util.EntityTypeContainerBAPTameable;
import dev.itsmeow.imdlib.entity.EntityRegistrarHandler;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;

import java.util.function.Function;
import java.util.function.Supplier;

public class EntityRegistrarHandlerBAP extends EntityRegistrarHandler {

    public EntityRegistrarHandlerBAP() {
        super(Ref.MOD_ID);
    }

    public <T extends TamableAnimal> EntityTypeContainerBAPTameable<T> addTame(Class<T> entityClass, EntityType.EntityFactory<T> factory, String name, Supplier<AttributeSupplier.Builder> attributeMap, Function<EntityTypeContainerBAPTameable.Builder<T>, EntityTypeContainerBAPTameable.Builder<T>> transformer) {
        return add(transformer.apply(EntityTypeContainerBAPTameable.Builder.create(entityClass, factory, name, attributeMap, modid)));
    }
}
