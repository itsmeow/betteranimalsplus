package dev.itsmeow.betteranimalsplus.common.entity.util.abstracts;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class EntityTameableFlyingWithTypes extends EntityTameableWithTypes {

    protected static final DataParameter<Boolean> FLYING = EntityDataManager.defineId(EntityTameableFlyingWithTypes.class, DataSerializers.BOOLEAN);
    private final GroundPathNavigator walkNav;
    private FlyingPathNavigator flyNav;
    private final MovementController moveCtrlGrnd;

    public EntityTameableFlyingWithTypes(EntityType<? extends EntityTameableFlyingWithTypes> type, World worldIn) {
        super(type, worldIn);
        this.walkNav = new GroundPathNavigator(this, worldIn);
        walkNav.setCanFloat(false);
        this.moveCtrlGrnd = new MovementController(this);
    }

    protected abstract MovementController getFlightMoveController();
    
    @Override
    protected PathNavigator createNavigation(World worldIn) {
        FlyingPathNavigator nav = new FlyingPathNavigator(this, worldIn);
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
    public boolean causeFallDamage(float distance, float damageMultiplier) {
        if(!this.getFlying()) {
            return super.causeFallDamage(distance, damageMultiplier);
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
    public void addAdditionalSaveData(CompoundNBT compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("IsFlying", this.entityData.get(FLYING));
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT compound) {
        super.readAdditionalSaveData(compound);
        this.entityData.set(FLYING, compound.getBoolean("IsFlying"));
    }

    @Override
    public boolean isIgnoringBlockTriggers() {
        return !this.getFlying();
    }
}
