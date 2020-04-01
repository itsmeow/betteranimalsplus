package its_meow.betteranimalsplus.common.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockPos.MutableBlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class BreatheAirGoal extends EntityAIBase {
    private final EntityCreature entity;

    public BreatheAirGoal(EntityCreature creature) {
        this.entity = creature;
        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute() {
        return this.entity.getAir() < 140;
    }

    @Override
    public boolean shouldContinueExecuting() {
        return this.shouldExecute();
    }

    @Override
    public boolean isInterruptible() {
        return false;
    }

    @Override
    public void startExecuting() {
        this.navigate();
    }

    private void navigate() {
        Iterable<MutableBlockPos> iterable = BlockPos.getAllInBoxMutable(MathHelper.floor(this.entity.posX - 1.0D), MathHelper.floor(this.entity.posY), MathHelper.floor(this.entity.posZ - 1.0D), MathHelper.floor(this.entity.posX + 1.0D), MathHelper.floor(this.entity.posY + 8.0D), MathHelper.floor(this.entity.posZ + 1.0D));
        BlockPos blockpos = null;

        for(BlockPos blockpos1 : iterable) {
            if(canBreatheAt(this.entity.world, blockpos1)) {
                blockpos = blockpos1;
                break;
            }
        }

        if(blockpos == null) {
            blockpos = new BlockPos(this.entity.posX, this.entity.posY + 8.0D, this.entity.posZ);
        }

        this.entity.getMoveHelper().setMoveTo((double) blockpos.getX(), (double) (blockpos.getY() + 1), (double) blockpos.getZ(), 0.2D);
    }

    @Override
    public void updateTask() {
        this.navigate();
        this.entity.moveRelative(0.02F, this.entity.moveStrafing, this.entity.moveVertical, this.entity.moveForward);
        this.entity.move(MoverType.SELF, entity.motionX, entity.motionY, entity.motionZ);
    }

    private static boolean canBreatheAt(World worldIn, BlockPos pos) {
        return worldIn.isAirBlock(pos);
    }
}
