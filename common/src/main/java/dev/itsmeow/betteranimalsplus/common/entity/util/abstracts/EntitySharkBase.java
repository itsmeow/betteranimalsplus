package dev.itsmeow.betteranimalsplus.common.entity.util.abstracts;

import dev.itsmeow.betteranimalsplus.common.entity.util.IHaveHunger;
import dev.itsmeow.betteranimalsplus.init.ModTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

public abstract class EntitySharkBase extends EntityWaterMobPathingWithSelectiveTypes implements Enemy, IHaveHunger<EntityWaterMobPathing> {

    private int hunger = 0;

    public EntitySharkBase(EntityType<? extends EntitySharkBase> type, Level world) {
        super(type, world);
    }

    @Override
    public void positionRider(Entity passenger) {
        if(this.hasPassenger(passenger)) {
            BlockPos pos = this.blockPosition().relative(this.getDirection()).subtract(this.blockPosition());
            pos = pos.offset(pos.getX(), 0, pos.getZ());
            passenger.setPos(this.getX() + this.getDeltaMovement().x() + pos.getX(), this.getY() - (this.getBbHeight() / 2) + this.getDeltaMovement().y(), this.getZ() + this.getDeltaMovement().z() + pos.getZ());
            if (passenger instanceof LivingEntity && (this.getTarget() == null || this.getTarget() != passenger)) {
                this.setTarget((LivingEntity) passenger);
            }
            if (this.level.isClientSide) {
                this.onPassengerTurned(passenger);
            }
        }
    }

    public boolean isPeaceful() {
        return this.level.getDifficulty() == Difficulty.PEACEFUL;
    }

    @Override
    public Entity getControllingPassenger() {
        return null;
    }

    @Override
    public boolean rideableUnderWater() {
        return true;
    }

    @Override
    public void setTarget(LivingEntity entitylivingbaseIn) {
        if(!this.isPeaceful()) {
            if(entitylivingbaseIn instanceof ServerPlayer) {
                ModTriggers.SHARK_TARGETED.trigger((ServerPlayer) entitylivingbaseIn);
            }
            super.setTarget(entitylivingbaseIn);
        }
    }

    @Override
    public int getHunger() {
        return hunger;
    }

    @Override
    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    @Override
    public void tick() {
        super.tick();
        if(this.tickCount % 20 == 0) {
            this.incrementHunger();
        }
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, SpawnGroupData livingdata, CompoundTag compound) {
        this.setInitialHunger();
        return super.finalizeSpawn(world, difficulty, reason, livingdata, compound);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        this.writeHunger(compound);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.readHunger(compound);
    }
}
