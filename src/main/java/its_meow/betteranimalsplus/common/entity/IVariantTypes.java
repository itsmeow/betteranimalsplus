package its_meow.betteranimalsplus.common.entity;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.entity.ILivingEntityData;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.EntityDataManager;

public interface IVariantTypes {

    /* Methods from superclass */

    boolean isChildI();

    Random getRNGI();

    EntityDataManager getDataManagerI();

    /* Implemented */

    int getVariantMax();

    DataParameter<Integer> getDataKey();

    /* Default Methods */

    default void registerTypeKey() {
        this.getDataManagerI().register(getDataKey(), Integer.valueOf(0));
    }

    default int getTypeNumber() {
        return this.getDataManagerI().get(this.getDataKey()).intValue();
    }

    default IVariantTypes setType(int typeId) {
        this.getDataManagerI().set(this.getDataKey(), Integer.valueOf(typeId));
        return this;
    }

    default void writeType(CompoundNBT compound) {
        compound.putInt("TypeNumber", this.getTypeNumber());
    }

    default void readType(CompoundNBT compound) {
        this.setType(compound.getInt("TypeNumber"));
    }
    
    default int getOffspringType(IVariantTypes parent1, IVariantTypes parent2) {
        return this.getRNGI().nextBoolean() ? parent1.getTypeNumber() : parent2.getTypeNumber();
    }

    default int getRandomType() {
        return this.getRNGI().nextInt(getVariantMax()) + 1;
    }

    public static class TypeData implements ILivingEntityData {
        public int typeData;

        public TypeData(int type) {
            this.typeData = type;
        }
    }

    @Nullable
    default ILivingEntityData initData(ILivingEntityData livingdata) {

        if (!this.isChildI()) {
            int i = this.getRandomType();

            if (livingdata instanceof TypeData) {
                i = ((TypeData) livingdata).typeData;
            } else {
                livingdata = new TypeData(i);
            }

            this.setType(i);

        }

        return livingdata;
    }
    
    @Nullable
    default ILivingEntityData initData(ILivingEntityData livingdata, int type) {

        if (!this.isChildI()) {
            int i = type;
            livingdata = new TypeData(i);
            this.setType(i);

        }

        return livingdata;
    }

}
