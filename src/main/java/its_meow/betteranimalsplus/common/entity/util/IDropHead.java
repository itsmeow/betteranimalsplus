package its_meow.betteranimalsplus.common.entity.util;

import its_meow.betteranimalsplus.util.HeadType;
import net.minecraft.entity.MobEntity;

public interface IDropHead {

    MobEntity getImplementation();

    EntityTypeContainer<?> getContainer();

    default HeadType getHeadType() {
        return getContainer().getHeadType();
    }

    default void doHeadDrop() {
        getHeadType().drop(getImplementation(), 12);
    }

}
