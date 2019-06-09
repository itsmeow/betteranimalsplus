package its_meow.betteranimalsplus.common.entity.ai;

import javax.annotation.Nullable;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class EntityAIWanderWaterEntity extends EntityAIBase {
    protected final EntityLiving entity;
    protected double x;
    protected double y;
    protected double z;
    protected final double speed;
    protected int executionChance;
    protected boolean mustUpdate;

    public EntityAIWanderWaterEntity(EntityLiving entityIn, double speedIn) {
        this(entityIn, speedIn, 120);
    }

    public EntityAIWanderWaterEntity(EntityLiving entityIn, double speedIn, int chance) {
        this.entity = entityIn;
        this.speed = speedIn;
        this.executionChance = chance;
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute() {
        if(!this.mustUpdate) {
            if(this.entity.getIdleTime() >= 100) {
                return false;
            }

            if(this.entity.getRNG().nextInt(this.executionChance) != 0) {
                return false;
            }
        }

        Vec3d vec3d = this.getPosition();

        if(vec3d == null) {
            return false;
        } else {
            this.x = vec3d.x;
            this.y = vec3d.y;
            this.z = vec3d.z;
            this.mustUpdate = false;
            return true;
        }
    }

    @Nullable
    protected Vec3d getPosition() {
        int i = 0;
        while(i < 5) {
            Vec3d pos = this.entity.getPositionVector().addVector(Math.random() * 10, Math.random() * 2, Math.random() * 10);
            IBlockState state = this.entity.world.getBlockState(new BlockPos(pos));
            if(state.getBlock() == Blocks.WATER || state.getBlock() == Blocks.FLOWING_WATER) {
                return pos;
            }
            i++;
        }
        
        
        return this.entity.getPositionVector();
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean shouldContinueExecuting() {
        return !this.entity.getNavigator().noPath();
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting() {
        this.entity.getNavigator().tryMoveToXYZ(this.x, this.y, this.z, this.speed);
    }

    /**
     * Makes task to bypass chance
     */
    public void makeUpdate() {
        this.mustUpdate = true;
    }

    /**
     * Changes task random possibility for execution
     */
    public void setExecutionChance(int newchance) {
        this.executionChance = newchance;
    }
}