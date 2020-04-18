package its_meow.betteranimalsplus.common.entity.util;

import net.minecraft.entity.MobEntity;

public interface IContainerEntity<T extends MobEntity> {

    /* Implemented */

    T getImplementation();

    EntityTypeContainer<?> getContainer();

    /* Default Methods */

    default boolean despawn(double range) {
        return getContainer().despawn && !this.getImplementation().hasCustomName();
    }
    
    public static <T extends MobEntity, C extends EntityTypeContainer<T>> boolean despawn(C container, T impl, double range) {
        return container.despawn && !impl.hasCustomName();
    }

}
