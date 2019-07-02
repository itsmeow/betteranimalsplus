package its_meow.betteranimalsplus.common.entity;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.nbt.NBTTagCompound;
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

    default void writeType(NBTTagCompound compound) {
        compound.setInteger("TypeNumber", this.getTypeNumber());
    }

    default void readType(NBTTagCompound compound) {
        this.setType(compound.getInteger("TypeNumber"));
    }
    
    default int getOffspringType(IVariantTypes parent1, IVariantTypes parent2) {
        return this.getRNGI().nextBoolean() ? parent1.getTypeNumber() : parent2.getTypeNumber();
    }
    
    default int getRandomType() {
        return this.getRNGI().nextInt(getVariantMax()) + 1;
    }

    public static class TypeData implements IEntityLivingData {
        public int typeData;

        public TypeData(int type) {
            this.typeData = type;
        }
    }

    @Nullable
    default IEntityLivingData initData(IEntityLivingData livingdata) {

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
    default IEntityLivingData initData(IEntityLivingData livingdata, int type) {

        if (!this.isChildI()) {
            int i = type;

            if (livingdata instanceof TypeData) {
                i = ((TypeData) livingdata).typeData;
            } else {
                livingdata = new TypeData(i);
            }

            this.setType(i);

        }

        return livingdata;
    }

}
