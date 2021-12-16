package dev.itsmeow.betteranimalsplus.common.entity.util.abstracts;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public abstract class EntityTameableFlyingWithTypes extends EntityTameableWithTypes {

    protected static final EntityDataAccessor<Boolean> FLYING = SynchedEntityData.defineId(EntityTameableFlyingWithTypes.class, EntityDataSerializers.BOOLEAN);
    private final GroundPathNavigation walkNav;
    private FlyingPathNavigation flyNav;
    private final MoveControl moveCtrlGrnd;

    public EntityTameableFlyingWithTypes(EntityType<? extends EntityTameableFlyingWithTypes> type, Level worldIn) {
        super(type, worldIn);
        this.walkNav = new GroundPathNavigation(this, worldIn);
        walkNav.setCanFloat(false);
        this.moveCtrlGrnd = new MoveControl(this);
    }

    protected abstract MoveControl getFlightMoveController();
    
    @Override
    protected PathNavigation createNavigation(Level worldIn) {
        FlyingPathNavigation nav = new FlyingPathNavigation(this, worldIn);
        nav.setCanOpenDoors(false);
        nav.setCanFloat(false);
        nav.setCanPassDoors(true);
        this.flyNav = nav;
        return nav;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(FLYING, false);
    }

    @Override
    public boolean onClimbable() {
        return false;
    }

    @Override
    protected void doPush(Entity entityIn) {
        if(!this.getFlying()) {
            super.doPush(entityIn);
        }
    }

    @Override
    protected void pushEntities() {
        if(!this.getFlying()) {
            super.pushEntities();
        }
    }

    @Override
    public boolean causeFallDamage(float f, float g, DamageSource damageSource) {
        if(!this.getFlying()) {
            return super.causeFallDamage(f, g, damageSource);
        }
        return false;
    }

    @Override
    protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
        if(!this.getFlying()) {
            super.checkFallDamage(y, onGroundIn, state, pos);
        }
    }

    public boolean getFlying() {
        return this.entityData.get(FLYING);
    }

    public void setFlying(boolean isFlying) {
        this.entityData.set(FLYING, isFlying);
        if(isFlying) {
            this.navigation = flyNav;
            this.moveControl = getFlightMoveController();
            if(level.isEmptyBlock(this.blockPosition().above())) {
                this.setPos(this.getX(), this.getY() + 1, this.getZ());
            }
        } else {
            this.navigation = walkNav;
            this.moveControl = moveCtrlGrnd;
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("IsFlying", this.entityData.get(FLYING));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.entityData.set(FLYING, compound.getBoolean("IsFlying"));
    }

    @Override
    public boolean isIgnoringBlockTriggers() {
        return !this.getFlying();
    }
}
