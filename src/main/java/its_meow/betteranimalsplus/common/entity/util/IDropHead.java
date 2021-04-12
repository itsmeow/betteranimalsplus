package its_meow.betteranimalsplus.common.entity.util;

import dev.itsmeow.imdlib.entity.interfaces.IContainerEntity;
import dev.itsmeow.imdlib.util.HeadType;
import net.minecraft.entity.MobEntity;

public interface IDropHead<T extends MobEntity> extends IContainerEntity<T> {

    @Override
    default HeadType getHeadType() {
        return getContainer().getHeadType();
    }

    @Override
    default void doHeadDrop() {
        getHeadType().drop(getImplementation(), 12);
    }

}
