package dev.itsmeow.betteranimalsplus.common.entity.ai;

import dev.itsmeow.betteranimalsplus.common.entity.EntityLammergeier;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;

import java.util.EnumSet;

public class EntityAIFollowOwnerFlying extends Goal {

    private final EntityLammergeier tameable;
    private LivingEntity owner;
    final Level world;
    private final double followSpeed;
    private final FlyingPathNavigation petPathfinder;
    private int timeToRecalcPath;
    final float maxDist;
    final float minDist;
    private float oldWaterCost;

    public EntityAIFollowOwnerFlying(EntityLammergeier tameableIn, double followSpeedIn, float minDistIn, float maxDistIn) {
        // super(tameableIn, followSpeedIn, minDistIn, maxDistIn);
        this.tameable = tameableIn;
        this.world = tameableIn.level;
        this.followSpeed = followSpeedIn;
        this.petPathfinder = (FlyingPathNavigation) tameableIn.getNavigation();
        this.minDist = minDistIn;
        this.maxDist = maxDistIn;
        this.setFlags(EnumSet.of(Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        LivingEntity entitylivingbase = this.tameable.getOwner();

        if (entitylivingbase == null) {
            return false;
        } else if (entitylivingbase instanceof Player && entitylivingbase.isSpectator()) {
            return false;
        } else if (this.tameable.isInSittingPose() || this.tameable.isOrderedToSit()) { // it's actually sitting not sleeping
            return false;
        } else if (this.tameable.distanceToSqr(entitylivingbase) < this.minDist * this.minDist) {
            return false;
        } else if (this.tameable.getTarget() != null && this.tameable.getTarget().isAlive()) {
            return false;
        } else if (!this.tameable.getNavigation().isDone()) {
            return false;
        } else {
            this.owner = entitylivingbase;
            return true;
        }
    }

    @Override
    public boolean canContinueToUse() {
        if (this.tameable.getTarget() != null && this.tameable.getTarget().isAlive()) {
            return false;
        }
        return !this.petPathfinder.isDone() && this.tameable.distanceToSqr(this.owner) > this.maxDist * this.maxDist && !this.tameable.isInSittingPose() && !this.tameable.isOrderedToSit(); // sitting not sleeping
    }

    @Override
    public void start() {
        this.timeToRecalcPath = 0;
        this.oldWaterCost = this.tameable.getPathfindingMalus(BlockPathTypes.WATER);
        this.tameable.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
    }

    @Override
    public void stop() {
        this.owner = null;
        this.petPathfinder.stop();
        this.tameable.setPathfindingMalus(BlockPathTypes.WATER, this.oldWaterCost);
    }

    @Override
    public void tick() {
        this.tameable.getLookControl().setLookAt(this.owner, 10.0F, 20);

        if (!this.tameable.isInSittingPose() && !this.tameable.isOrderedToSit()) { // sitting not sleeping
            if (--this.timeToRecalcPath <= 0) {
                this.timeToRecalcPath = 10;
                this.tameable.getMoveControl().setWantedPosition(this.owner.getX(), this.owner.getY() + 2, this.owner.getZ(), this.followSpeed);
                if(tameable.distanceTo(this.owner) > 100 || this.tameable.getCommandSenderWorld() != this.owner.getCommandSenderWorld()) {
                    if (!this.tameable.isLeashed() && this.tameable.getVehicle() == null) {
                        // Distance too large, teleport!
                        if (this.tameable.distanceToSqr(this.owner) >= 144.0D || this.tameable.getCommandSenderWorld() != this.owner.getCommandSenderWorld()) {
                            int i = Mth.floor(this.owner.getX()) - 2;
                            int j = Mth.floor(this.owner.getZ()) - 2;
                            int k = Mth.floor(this.owner.getBoundingBox().minY);

                            for (int l = 0; l <= 4; ++l) {
                                for (int i1 = 0; i1 <= 4; ++i1) {
                                    if ((l < 1 || i1 < 1 || l > 3 || i1 > 3) && this.isTeleportFriendlyBlock(i, j, k, l, i1)) {
                                        this.tameable.moveTo(i + l + 0.5F, k, j + i1 + 0.5F, this.tameable.getYRot(), this.tameable.getXRot());
                                        this.petPathfinder.stop();
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    protected boolean isTeleportFriendlyBlock(int x, int p_192381_2_, int y, int p_192381_4_, int p_192381_5_) {
        BlockPos blockpos = new BlockPos(x + p_192381_4_, y - 1, p_192381_2_ + p_192381_5_);
        BlockState iblockstate = this.world.getBlockState(blockpos);
        return iblockstate.canOcclude() && iblockstate.isValidSpawn(tameable.level, blockpos, this.tameable.getType()) && this.world.isEmptyBlock(blockpos.above()) && this.world.isEmptyBlock(blockpos.above(2));
    }
}