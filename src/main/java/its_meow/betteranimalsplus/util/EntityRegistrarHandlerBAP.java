package its_meow.betteranimalsplus.util;

import dev.itsmeow.imdlib.entity.EntityRegistrarHandler;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.entity.util.EntityTypeContainerBAPTameable;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.passive.TameableEntity;

import java.util.function.Function;
import java.util.function.Supplier;

public class EntityRegistrarHandlerBAP extends EntityRegistrarHandler {

    public EntityRegistrarHandlerBAP() {
        super(Ref.MOD_ID);
    }

    public <T extends TameableEntity> EntityTypeContainerBAPTameable<T> addTame(Class<T> entityClass, EntityType.IFactory<T> factory, String name, Supplier<AttributeModifierMap.MutableAttribute> attributeMap, Function<EntityTypeContainerBAPTameable.Builder<T>, EntityTypeContainerBAPTameable.Builder<T>> transformer) {
        return add(transformer.apply(EntityTypeContainerBAPTameable.Builder.create(entityClass, factory, name, attributeMap, modid)));
    }
}
