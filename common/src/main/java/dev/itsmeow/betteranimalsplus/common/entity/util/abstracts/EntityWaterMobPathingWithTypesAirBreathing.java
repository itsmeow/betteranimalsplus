package dev.itsmeow.betteranimalsplus.common.entity.util.abstracts;

import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public abstract class EntityWaterMobPathingWithTypesAirBreathing extends EntityWaterMobPathingWithTypes {

    private static final DataParameter<Integer> MOISTNESS = EntityDataManager.defineId(EntityWaterMobPathingWithTypesAirBreathing.class, DataSerializers.INT);

    public EntityWaterMobPathingWithTypesAirBreathing(EntityType<? extends EntityWaterMobPathingWithTypesAirBreathing> entityType, World worldIn) {
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
    public void addAdditionalSaveData(CompoundNBT compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Moistness", this.getMoistness());
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT compound) {
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
