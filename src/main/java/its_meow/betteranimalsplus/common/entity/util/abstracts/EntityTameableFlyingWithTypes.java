package its_meow.betteranimalsplus.common.entity.util.abstracts;

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

    protected static final DataParameter<Boolean> FLYING = EntityDataManager.<Boolean>createKey(EntityTameableFlyingWithTypes.class, DataSerializers.BOOLEAN);
    private final GroundPathNavigator walkNav;
    private FlyingPathNavigator flyNav;
    private final MovementController moveCtrlGrnd;

    public EntityTameableFlyingWithTypes(EntityType<? extends EntityTameableFlyingWithTypes> type, World worldIn) {
        super(type, worldIn);
        this.walkNav = new GroundPathNavigator(this, worldIn);
        walkNav.setCanSwim(false);
        this.moveCtrlGrnd = new MovementController(this);
    }

    protected abstract MovementController getFlightMoveController();
    
    @Override
    protected PathNavigator createNavigator(World worldIn) {
        FlyingPathNavigator nav = new FlyingPathNavigator(this, worldIn);
        nav.setCanOpenDoors(false);
        nav.setCanSwim(false);
        nav.setCanEnterDoors(true);
        this.flyNav = nav;
        return nav;
    }

    /*@Override
    public void travel(Vec3d p_213352_1_) {
        if(this.isInWater()) {
            this.moveRelative(0.02F, p_213352_1_);
            this.move(MoverType.SELF, this.getMotion());
            this.setMotion(this.getMotion().scale((double) 0.8F));
        } else if(this.isInLava()) {
            this.moveRelative(0.02F, p_213352_1_);
            this.move(MoverType.SELF, this.getMotion());
            this.setMotion(this.getMotion().scale(0.5D));
        } else {
            BlockPos ground = new BlockPos(this.posX, this.getBoundingBox().minY - 1.0D, this.posZ);
            float f = 0.91F;
            if(this.onGround) {
                f = this.world.getBlockState(ground).getSlipperiness(world, ground, this) * 0.91F;
            }

            float f1 = 0.16277137F / (f * f * f);
            f = 0.91F;
            if(this.onGround) {
                f = this.world.getBlockState(ground).getSlipperiness(world, ground, this) * 0.91F;
            }

            this.moveRelative(this.onGround ? 0.1F * f1 : 0.02F, p_213352_1_);
            this.move(MoverType.SELF, this.getMotion());
            this.setMotion(this.getMotion().scale((double) f));
        }

        this.prevLimbSwingAmount = this.limbSwingAmount;
        double d1 = this.posX - this.prevPosX;
        double d0 = this.posZ - this.prevPosZ;
        float f2 = MathHelper.sqrt(d1 * d1 + d0 * d0) * 4.0F;
        if(f2 > 1.0F) {
            f2 = 1.0F;
        }

        this.limbSwingAmount += (f2 - this.limbSwingAmount) * 0.4F;
        this.limbSwing += this.limbSwingAmount;
    }*/

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(FLYING, false);
    }

    @Override
    public boolean isOnLadder() {
        return false;
    }

    @Override
    protected void collideWithEntity(Entity entityIn) {
        if(!this.getFlying()) {
            super.collideWithEntity(entityIn);
        }
    }

    @Override
    protected void collideWithNearbyEntities() {
        if(!this.getFlying()) {
            super.collideWithNearbyEntities();
        }
    }

    @Override
    public boolean onLivingFall(float distance, float damageMultiplier) {
        if(!this.getFlying()) {
            return super.onLivingFall(distance, damageMultiplier);
        }
        return false;
    }

    @Override
    protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
        if(!this.getFlying()) {
            super.updateFallState(y, onGroundIn, state, pos);
        }
    }

    public boolean getFlying() {
        return this.dataManager.get(FLYING);
    }

    public void setFlying(boolean isFlying) {
        this.dataManager.set(FLYING, isFlying);
        if(isFlying) {
            this.navigator = flyNav;
            this.moveController = getFlightMoveController();
        } else if(!isFlying) {
            this.navigator = walkNav;
            this.moveController = moveCtrlGrnd;
        }
    }

    @Override
    public boolean writeUnlessRemoved(CompoundNBT compound) {
        compound.putBoolean("IsFlying", this.dataManager.get(FLYING));
        return super.writeUnlessRemoved(compound);
    }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        this.dataManager.set(FLYING, compound.getBoolean("IsFlying"));
    }

    @Override
    public boolean doesEntityNotTriggerPressurePlate() {
        return !this.getFlying();
    }
}
