package its_meow.betteranimalsplus.common.entity.util;

import dev.itsmeow.imdlib.entity.util.IContainerEntity;
import dev.itsmeow.imdlib.util.HeadType;
import net.minecraft.entity.MobEntity;

public interface IDropHead<T extends MobEntity> extends IContainerEntity<T> {

    default HeadType getHeadType() {
        return getContainer().getHeadType();
    }

    default void doHeadDrop() {
        getHeadType().drop(getImplementation(), 12);
    }

}
