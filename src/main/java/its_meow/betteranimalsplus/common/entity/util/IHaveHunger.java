package its_meow.betteranimalsplus.common.entity.util;

import dev.itsmeow.imdlib.entity.util.IContainerEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.nbt.CompoundNBT;

public interface IHaveHunger<T extends MobEntity> extends IContainerEntity<T> {

    int getHunger();

    void setHunger(int hunger);

    default void writeHunger(CompoundNBT nbt) {
        nbt.putInt("Hunger", getHunger());
    }

    default void readHunger(CompoundNBT nbt) {
        setHunger(nbt.getInt("Hunger"));
    }

    default int getHungerThreshold() {
        return 120;
    }

    default int getEffectiveHunger() {
        return Math.max(0, getHunger() - getHungerThreshold());
    }

    default int getInitialHunger() {
        return 10 + getImplementation().getRNG().nextInt(80);
    }

    default void setInitialHunger() {
        setHunger(getInitialHunger());
    }

    default void resetHunger() {
        setHunger(0);
    }

    default void incrementHunger() {
        setHunger(getHunger() + 1);
    }
}
