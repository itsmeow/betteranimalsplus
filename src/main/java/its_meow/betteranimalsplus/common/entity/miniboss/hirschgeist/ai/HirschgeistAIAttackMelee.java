package its_meow.betteranimalsplus.common.entity.miniboss.hirschgeist.ai;

import java.util.EnumSet;

import its_meow.betteranimalsplus.common.entity.miniboss.hirschgeist.EntityHirschgeist;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.pathfinding.Path;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class HirschgeistAIAttackMelee extends Goal {

    World world;
    protected EntityHirschgeist attacker;
    /**
     * An amount of decrementing ticks that allows the entity to attack once the
     * tick reaches 0.
     */
    protected int attackTick;
    /** The speed with which the mob will approach the target */
    double speedTowardsTarget;
    /**
     * When true, the mob will continue chasing its target, even if it can't find a
     * path to them right now.
     */
    boolean longMemory = true;
    /** The PathEntity of our entity. */
    Path path;
    private int delayCounter;
    private double targetX;
    private double targetY;
    private double targetZ;
    protected final int attackInterval = 20;
    private int failedPathFindingPenalty = 0;
    private boolean canPenalize = false;

    public HirschgeistAIAttackMelee(EntityHirschgeist creature, double speedIn) {
        this.attacker = creature;
        this.world = creature.world;
        this.speedTowardsTarget = speedIn;
        this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.TARGET));
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    @Override
    public boolean shouldExecute() {
        LivingEntity entitylivingbase = this.attacker.getAttackTarget();

        if (entitylivingbase == null) {
            return false;
        } else if (this.attacker.isDaytime()) {
            return false;
        } else if (!entitylivingbase.isAlive()) {
            return false;
        } else {
            if (this.canPenalize) {
                if (--this.delayCounter <= 0) {
                    this.path = this.attacker.getNavigator().getPathToEntityLiving(entitylivingbase, 100);
                    this.delayCounter = 4 + this.attacker.getRNG().nextInt(7);
                    return this.path != null;
                } else {
                    return true;
                }
            }
            this.path = this.attacker.getNavigator().getPathToEntityLiving(entitylivingbase, 100);

            if (this.path != null) {
                return true;
            } else {
                return this.getAttackReachSqr(entitylivingbase) >= this.attacker.getDistanceSq(entitylivingbase.posX,
                        entitylivingbase.getBoundingBox().minY, entitylivingbase.posZ);
            }
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    @Override
    public boolean shouldContinueExecuting() {
        LivingEntity entitylivingbase = this.attacker.getAttackTarget();

        if (entitylivingbase == null) {
            return false;
        } else if (this.attacker.isDaytime()) {
            return false;
        } else if (!entitylivingbase.isAlive()) {
            return false;
        } else if (!this.longMemory) {
            return !this.attacker.getNavigator().noPath();
        } else {
            return !(entitylivingbase instanceof PlayerEntity) || !((PlayerEntity) entitylivingbase).isSpectator()
                    && !((PlayerEntity) entitylivingbase).isCreative();
        }
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    @Override
    public void startExecuting() {
        this.attacker.getNavigator().setPath(this.path, this.speedTowardsTarget);
        this.delayCounter = 0;
    }

    /**
     * Reset the task's internal state. Called when this task is interrupted by
     * another one
     */
    @Override
    public void resetTask() {
        LivingEntity entitylivingbase = this.attacker.getAttackTarget();

        if (entitylivingbase instanceof PlayerEntity && (((PlayerEntity) entitylivingbase).isSpectator()
                || ((PlayerEntity) entitylivingbase).isCreative())) {
            this.attacker.setAttackTarget((LivingEntity) null);
        }

        this.attacker.getNavigator().clearPath();
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    @Override
    public void tick() {
        LivingEntity entitylivingbase = this.attacker.getAttackTarget();
        this.attacker.getLookController().setLookPositionWithEntity(entitylivingbase, 30.0F, 30.0F);
        double d0 = this.attacker.getDistanceSq(entitylivingbase.posX, entitylivingbase.getBoundingBox().minY,
                entitylivingbase.posZ);
        --this.delayCounter;

        if ((this.longMemory || this.attacker.getEntitySenses().canSee(entitylivingbase)) && this.delayCounter <= 0
                && (this.targetX == 0.0D && this.targetY == 0.0D && this.targetZ == 0.0D
                        || entitylivingbase.getDistanceSq(this.targetX, this.targetY, this.targetZ) >= 1.0D
                        || this.attacker.getRNG().nextFloat() < 0.05F)) {
            this.targetX = entitylivingbase.posX;
            this.targetY = entitylivingbase.getBoundingBox().minY;
            this.targetZ = entitylivingbase.posZ;
            this.delayCounter = 4 + this.attacker.getRNG().nextInt(7);

            if (this.canPenalize) {
                this.delayCounter += this.failedPathFindingPenalty;
                if (this.attacker.getNavigator().getPath() != null) {
                    net.minecraft.pathfinding.PathPoint finalPathPoint = this.attacker.getNavigator().getPath()
                            .getFinalPathPoint();
                    if (finalPathPoint != null && entitylivingbase.getDistanceSq(finalPathPoint.x, finalPathPoint.y,
                            finalPathPoint.z) < 1) {
                        this.failedPathFindingPenalty = 0;
                    } else {
                        this.failedPathFindingPenalty += 10;
                    }
                } else {
                    this.failedPathFindingPenalty += 10;
                }
            }

            if (d0 > 1024.0D) {
                this.delayCounter += 10;
            } else if (d0 > 256.0D) {
                this.delayCounter += 5;
            }

            if (!this.attacker.getNavigator().tryMoveToEntityLiving(entitylivingbase, this.speedTowardsTarget)) {
                this.delayCounter += 15;
            }
        }

        this.attackTick = Math.max(this.attackTick - 1, 0);
        this.checkAndPerformAttack(entitylivingbase, d0);
    }

    protected void checkAndPerformAttack(LivingEntity target, double sqDistance) {
        double d0 = this.getAttackReachSqr(target);

        if (sqDistance <= d0 && this.attackTick <= 0) {
            this.attackTick = 20;
            this.attacker.swingArm(Hand.MAIN_HAND);
            this.attacker.attackEntityAsMob(target);
            target.knockBack(target, 3, this.attacker.posX - target.posX, this.attacker.posZ - target.posZ);
            target.setFire(5);
        }
    }

    protected double getAttackReachSqr(LivingEntity attackTarget) {
        return 12D;
    }

}
