package its_meow.betteranimalsplus.common.entity.util;

import javax.annotation.Nullable;

import net.minecraft.entity.AgeableEntity.AgeableData;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IWorld;
import net.minecraftforge.common.util.Constants;

public interface IVariantTypes<T extends MobEntity> extends IContainerEntity<T> {

    /* Default Methods */

    default void registerTypeKey() {
        this.getImplementation().getDataManager().register(getContainer().getVariantDataKey(), "");
    }

    default String getVariantString() {
        return this.getImplementation().getDataManager().get(getContainer().getVariantDataKey());
    }

    default IVariantTypes<T> setType(String variantKey) {
        this.getImplementation().getDataManager().set(getContainer().getVariantDataKey(), this.getContainer().getVariant(variantKey).getName());
        return this;
    }

    default IVariantTypes<T> setType(IVariant variant) {
        this.getImplementation().getDataManager().set(getContainer().getVariantDataKey(), variant.getName());
        return this;
    }

    default void writeType(CompoundNBT compound) {
        compound.putString("VariantId", this.getVariant().getName());
    }

    default void readType(CompoundNBT compound) {
        if(compound.contains("TypeNumber", Constants.NBT.TAG_INT)) {
            int oldNumber = compound.getInt("TypeNumber");
            this.setType(this.getContainer().getVariant(oldNumber - 1).getName());
            compound.remove("TypeNumber");
        } else {
            this.setType(compound.getString("VariantId"));
        }
    }

    default IVariant getOffspringType(IVariantTypes<?> parent1, IVariantTypes<?> parent2) {
        return this.getImplementation().getRNG().nextBoolean() ? parent1.getVariant() : parent2.getVariant();
    }

    default IVariant getRandomType() {
        return getContainer().getVariant(this.getImplementation().getRNG().nextInt(getContainer().getVariantMax()));
    }

    public static class TypeData implements ILivingEntityData {
        public String typeData;

        public TypeData(String type) {
            this.typeData = type;
        }
    }

    public static class AgeableTypeData extends AgeableData {
        public String typeData;
        private int inc;
        private boolean bool = true;
        private float num = 0.05F;

        public AgeableTypeData(String type) {
            this.typeData = type;
        }

        public AgeableTypeData(AgeableData data, String type) {
            this.typeData = type;
            this.inc = data.func_226257_a_();
            this.bool = data.func_226261_c_();
            this.num = data.func_226262_d_();
        }

        @Override
        public int func_226257_a_() {
            return this.inc;
        }

        @Override
        public void func_226260_b_() {
            ++this.inc;
        }

        @Override
        public boolean func_226261_c_() {
            return this.bool;
        }

        @Override
        public void func_226259_a_(boolean newBool) {
            this.bool = newBool;
        }

        @Override
        public float func_226262_d_() {
            return this.num;
        }

        @Override
        public void func_226258_a_(float newVal) {
            this.num = newVal;
        }
    }

    @Nullable
    default ILivingEntityData initData(IWorld world, SpawnReason reason, ILivingEntityData livingdata) {
        String variant = this.getRandomType().getName();
        if(livingdata instanceof TypeData) {
            variant = ((TypeData) livingdata).typeData;
        } else {
            livingdata = new TypeData(variant);
        }
        this.setType(variant);
        return livingdata;
    }

    @Nullable
    default ILivingEntityData initAgeableData(IWorld world, SpawnReason reason, ILivingEntityData livingdata) {
        String variant = this.getRandomType().getName();
        if(livingdata instanceof AgeableTypeData) {
            variant = ((AgeableTypeData) livingdata).typeData;
        } else if(livingdata instanceof AgeableData) {
            livingdata = new AgeableTypeData((AgeableData) livingdata, variant);
        } else {
            livingdata = new AgeableTypeData(variant);
        }
        this.setType(variant);
        return livingdata;
    }

    default IVariant getVariant() {
        return this.getContainer().getVariant(this.getVariantString());
    }

    default ResourceLocation getVariantTexture() {
        return getVariant().getTexture();
    }

    default String getVariantName() {
        return getVariant().getName();
    }

}
