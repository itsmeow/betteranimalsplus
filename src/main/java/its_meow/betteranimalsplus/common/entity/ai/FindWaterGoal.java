package its_meow.betteranimalsplus.common.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

public class FindWaterGoal extends EntityAIBase {
    private final EntityCreature entity;

    public FindWaterGoal(EntityCreature creature) {
        this.entity = creature;
    }

    @Override
    public boolean shouldExecute() {
        return this.entity.onGround && this.entity.world.getBlockState(new BlockPos(this.entity)) != Blocks.WATER;
    }

    @Override
    public void startExecuting() {
        BlockPos blockpos = null;
        for(BlockPos blockpos1 : BlockPos.getAllInBoxMutable(MathHelper.floor(this.entity.posX - 2.0D), MathHelper.floor(this.entity.posY - 2.0D), MathHelper.floor(this.entity.posZ - 2.0D), MathHelper.floor(this.entity.posX + 2.0D), MathHelper.floor(this.entity.posY), MathHelper.floor(this.entity.posZ + 2.0D))) {
            if(this.entity.world.getBlockState(blockpos1) == Blocks.WATER) {
                blockpos = blockpos1;
                break;
            }
        }
        if(blockpos != null) {
            this.entity.getMoveHelper().setMoveTo((double) blockpos.getX(), (double) blockpos.getY(), (double) blockpos.getZ(), 1.0D);
        }
    }
}
