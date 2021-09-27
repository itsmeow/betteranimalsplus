package dev.itsmeow.betteranimalsplus.common.entity.util.abstracts;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public abstract class EntityWaterMobPathingWithTypesAirBreathing extends EntityWaterMobPathingWithTypes {

    private static final EntityDataAccessor<Integer> MOISTNESS = SynchedEntityData.defineId(EntityWaterMobPathingWithTypesAirBreathing.class, EntityDataSerializers.INT);

    public EntityWaterMobPathingWithTypesAirBreathing(EntityType<? extends EntityWaterMobPathingWithTypesAirBreathing> entityType, Level worldIn) {
        super(entityType, worldIn);
    }

    @Override
    public boolean canBreatheUnderwater() {
        return false;
    }

    @Override
    protected void handleAirSupply(int p_209207_1_) {
    }

    public int getMoistness() {
        return this.entityData.get(MOISTNESS);
    }

    public void setMoistness(int p_211137_1_) {
        this.entityData.set(MOISTNESS, p_211137_1_);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(MOISTNESS, 2400);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Moistness", this.getMoistness());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setMoistness(compound.getInt("Moistness"));
    }

    @Override
    public int getMaxAirSupply() {
        return 4800;
    }

    @Override
    protected int increaseAirSupply(int currentAir) {
        return this.getMaxAirSupply();
    }

    @Override
    public void tick() {
        super.tick();
        if(!this.isNoAi()) {
            if(this.isInWaterRainOrBubble()) {
                this.setMoistness(2400);
            } else {
                this.setMoistness(this.getMoistness() - 1);
                if(this.getMoistness() <= 0) {
                    this.hurt(DamageSource.DRY_OUT, 1.0F);
                }
            }

        }
    }

}
