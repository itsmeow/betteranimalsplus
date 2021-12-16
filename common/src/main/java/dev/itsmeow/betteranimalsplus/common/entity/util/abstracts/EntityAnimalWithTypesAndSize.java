package dev.itsmeow.betteranimalsplus.common.entity.util.abstracts;

import dev.itsmeow.imdlib.entity.util.variant.IVariant;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

public abstract class EntityAnimalWithTypesAndSize extends EntityAnimalWithTypes {

    protected static final EntityDataAccessor<Float> SIZE = SynchedEntityData.defineId(EntityAnimalWithTypesAndSize.class, EntityDataSerializers.FLOAT);

    public EntityAnimalWithTypesAndSize(EntityType<? extends EntityAnimalWithTypes> entityType, Level worldIn) {
        super(entityType, worldIn);
        this.setSize(0.35F);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SIZE, 1F);
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        float size = this.entityData.get(SIZE);
        return EntityDimensions.scalable(size, size).scale(this.getScale());
    }

    public void setSize(float size) {
        this.entityData.set(SIZE, size);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putFloat("Size", this.getDimensions(Pose.STANDING).width);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        float size = compound.getFloat("Size");
        this.setSize(size);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, SpawnGroupData livingdata, CompoundTag compound) {
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

        public AgeableSizeTypeData(AgeableMobGroupData ageable, IVariant type, float size) {
            super(ageable, type);
            this.size = size;
        }
    }

}
