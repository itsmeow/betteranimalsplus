package its_meow.betteranimalsplus.common.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAIMoveTowardsAttackTarget extends EntityAIBase {
    private final EntityLiving creature;
    private EntityLivingBase targetEntity;
    private double movePosX;
    private double movePosY;
    private double movePosZ;
    private final double speed;
    /**
     * If the distance to the target entity is further than this, this AI task will
     * not run.
     */
    private final float maxTargetDistance;

    public EntityAIMoveTowardsAttackTarget(EntityLiving creature, double speedIn, float targetMaxDistance) {
        this.creature = creature;
        this.speed = speedIn;
        this.maxTargetDistance = targetMaxDistance;
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute() {
        this.targetEntity = this.creature.getAttackTarget();

        if(this.targetEntity == null) {
            return false;
        } else if(this.targetEntity.getDistanceSq(this.creature) > (double) (this.maxTargetDistance * this.maxTargetDistance)) {
            return false;
        } else {
            this.movePosX = this.targetEntity.posX;
            this.movePosY = this.targetEntity.posY;
            this.movePosZ = this.targetEntity.posZ;
            return true;
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean shouldContinueExecuting() {
        return !this.creature.getNavigator().noPath() && this.targetEntity.isEntityAlive() && this.targetEntity.getDistanceSq(this.creature) < (double) (this.maxTargetDistance * this.maxTargetDistance);
    }

    /**
     * Reset the task's internal state. Called when this task is interrupted by
     * another one
     */
    public void resetTask() {
        this.targetEntity = null;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting() {
        this.creature.getNavigator().tryMoveToXYZ(this.movePosX, this.movePosY, this.movePosZ, this.speed);
    }

}