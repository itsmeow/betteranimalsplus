package dev.itsmeow.betteranimalsplus.common.entity.util;

import dev.itsmeow.imdlib.entity.interfaces.IContainerEntity;
import dev.itsmeow.imdlib.util.HeadType;
import net.minecraft.world.entity.Mob;

public interface IDropHead<T extends Mob> extends IContainerEntity<T> {

    @Override
    default HeadType getHeadType() {
        return getContainer().getHeadType();
    }

    @Override
    default void doHeadDrop() {
        getHeadType().drop(getImplementation(), 12);
    }

}
