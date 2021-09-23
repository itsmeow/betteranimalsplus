package dev.itsmeow.betteranimalsplus.common.entity.util.abstracts;

import dev.itsmeow.imdlib.entity.util.variant.IVariant;
import net.minecraft.entity.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

import dev.itsmeow.imdlib.entity.interfaces.IVariantTypes.AgeableTypeData;
import net.minecraft.entity.AgeableEntity.AgeableData;

public abstract class EntityAnimalWithTypesAndSize extends EntityAnimalWithTypes {

    protected static final DataParameter<Float> SIZE = EntityDataManager.defineId(EntityAnimalWithTypesAndSize.class, DataSerializers.FLOAT);

    public EntityAnimalWithTypesAndSize(EntityType<? extends EntityAnimalWithTypes> entityType, World worldIn) {
        super(entityType, worldIn);
        this.setSize(0.35F);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SIZE, 1F);
    }

    @Override
    public EntitySize getDimensions(Pose pose) {
        float size = this.entityData.get(SIZE);
        return EntitySize.scalable(size, size).scale(this.getScale());
    }

    public void setSize(float size) {
        this.entityData.set(SIZE, size);
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT compound) {
        super.addAdditionalSaveData(compound);
        compound.putFloat("Size", this.getDimensions(Pose.STANDING).width);
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT compound) {
        super.readAdditionalSaveData(compound);
        float size = compound.getFloat("Size");
        this.setSize(size);
    }

    @Override
    @Nullable
    public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData livingdata, CompoundNBT compound) {
        livingdata = super.finalizeSpawn(world, difficulty, reason, livingdata, compound);
        if(!this.isBaby()) {
            IVariant i = this.getRandomType();
            float rand = this.getRandomizedSize();

            if(livingdata instanceof AgeableSizeTypeData) {
                i = ((AgeableSizeTypeData) livingdata).typeData;
                rand = ((AgeableSizeTypeData) livingdata).size;
            } else {
                livingdata = new AgeableSizeTypeData(i, rand);
            }

            this.setType(i);
            this.setSize(rand);
        }
        return livingdata;
    }

    protected abstract float getRandomizedSize();

    public static class AgeableSizeTypeData extends AgeableTypeData {

        public float size;

        public AgeableSizeTypeData(IVariant type, float size) {
            super(type);
            this.size = size;
        }

        public AgeableSizeTypeData(AgeableData ageable, IVariant type, float size) {
            super(ageable, type);
            this.size = size;
        }
    }

}
