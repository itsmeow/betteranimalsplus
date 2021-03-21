package its_meow.betteranimalsplus.common.entity.ai;

import its_meow.betteranimalsplus.common.entity.EntityLammergeier;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.EnumSet;

public class EntityAIFollowOwnerFlying extends Goal {

    private final EntityLammergeier tameable;
    private LivingEntity owner;
    final World world;
    private final double followSpeed;
    private final FlyingPathNavigator petPathfinder;
    private int timeToRecalcPath;
    final float maxDist;
    final float minDist;
    private float oldWaterCost;

    public EntityAIFollowOwnerFlying(EntityLammergeier tameableIn, double followSpeedIn, float minDistIn, float maxDistIn) {
        // super(tameableIn, followSpeedIn, minDistIn, maxDistIn);
        this.tameable = tameableIn;
        this.world = tameableIn.world;
        this.followSpeed = followSpeedIn;
        this.petPathfinder = (FlyingPathNavigator) tameableIn.getNavigator();
        this.minDist = minDistIn;
        this.maxDist = maxDistIn;
        this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
    }

    @Override
    public boolean shouldExecute() {
        LivingEntity entitylivingbase = this.tameable.getOwner();

        if (entitylivingbase == null) {
            return false;
        } else if (entitylivingbase instanceof PlayerEntity && entitylivingbase.isSpectator()) {
            return false;
        } else if (this.tameable.isEntitySleeping() || this.tameable.isQueuedToSit()) { // it's actually sitting not sleeping
            return false;
        } else if (this.tameable.getDistanceSq(entitylivingbase) < this.minDist * this.minDist) {
            return false;
        } else if (this.tameable.getAttackTarget() != null && this.tameable.getAttackTarget().isAlive()) {
            return false;
        } else if (!this.tameable.getNavigator().noPath()) {
            return false;
        } else {
            this.owner = entitylivingbase;
            return true;
        }
    }

    @Override
    public boolean shouldContinueExecuting() {
        if (this.tameable.getAttackTarget() != null && this.tameable.getAttackTarget().isAlive()) {
            return false;
        }
        return !this.petPathfinder.noPath() && this.tameable.getDistanceSq(this.owner) > this.maxDist * this.maxDist && !this.tameable.isEntitySleeping() && !this.tameable.isQueuedToSit(); // sitting not sleeping
    }

    @Override
    public void startExecuting() {
        this.timeToRecalcPath = 0;
        this.oldWaterCost = this.tameable.getPathPriority(PathNodeType.WATER);
        this.tameable.setPathPriority(PathNodeType.WATER, 0.0F);
    }

    @Override
    public void resetTask() {
        this.owner = null;
        this.petPathfinder.clearPath();
        this.tameable.setPathPriority(PathNodeType.WATER, this.oldWaterCost);
    }

    @Override
    public void tick() {
        this.tameable.getLookController().setLookPositionWithEntity(this.owner, 10.0F, 20);

        if (!this.tameable.isEntitySleeping() && !this.tameable.isQueuedToSit()) { // sitting not sleeping
            if (--this.timeToRecalcPath <= 0) {
                this.timeToRecalcPath = 10;
                this.tameable.getMoveHelper().setMoveTo(this.owner.getPosX(), this.owner.getPosY() + 2, this.owner.getPosZ(), this.followSpeed);
                if(tameable.getDistance(this.owner) > 100 || this.tameable.getEntityWorld() != this.owner.getEntityWorld()) {
                    if (!this.tameable.getLeashed() && this.tameable.getRidingEntity() == null) {
                        // Distance too large, teleport!
                        if (this.tameable.getDistanceSq(this.owner) >= 144.0D || this.tameable.getEntityWorld() != this.owner.getEntityWorld()) {
                            int i = MathHelper.floor(this.owner.getPosX()) - 2;
                            int j = MathHelper.floor(this.owner.getPosZ()) - 2;
                            int k = MathHelper.floor(this.owner.getBoundingBox().minY);

                            for (int l = 0; l <= 4; ++l) {
                                for (int i1 = 0; i1 <= 4; ++i1) {
                                    if ((l < 1 || i1 < 1 || l > 3 || i1 > 3) && this.isTeleportFriendlyBlock(i, j, k, l, i1)) {
                                        this.tameable.setLocationAndAngles(i + l + 0.5F, k, j + i1 + 0.5F, this.tameable.rotationYaw, this.tameable.rotationPitch);
                                        this.petPathfinder.clearPath();
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
        return iblockstate.isSolid() && iblockstate.canEntitySpawn(tameable.world, blockpos, this.tameable.getType()) && this.world.isAirBlock(blockpos.up()) && this.world.isAirBlock(blockpos.up(2));
    }
}