package dev.itsmeow.betteranimalsplus.common.entity.ai;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class EntityAIEatBerries extends MoveToBlockGoal {
    protected int eatTicks;

    public EntityAIEatBerries(CreatureEntity creature, double speed, int length, int iterations) {
        super(creature, speed, length, iterations);
    }

    @Override
    public double acceptedDistance() {
        return 2.0D;
    }

    @Override
    public boolean shouldRecalculatePath() {
        return this.tryTicks % 100 == 0;
    }

    @Override
    protected boolean isValidTarget(IWorldReader worldIn, BlockPos pos) {
        BlockState blockstate = worldIn.getBlockState(pos);
        return blockstate.getBlock() == Blocks.SWEET_BERRY_BUSH && blockstate.getValue(SweetBerryBushBlock.AGE) >= 2;
    }

    @Override
    public void tick() {
        if(this.isReachedTarget()) {
            if(this.eatTicks >= 40) {
                this.eatBerry();
            } else {
                ++this.eatTicks;
            }
        }

        super.tick();
    }

    protected void eatBerry() {
        if(net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.mob.level, this.mob)) {
            BlockState blockstate = this.mob.level.getBlockState(this.blockPos);
            if(blockstate.getBlock() == Blocks.SWEET_BERRY_BUSH) {
                int i = blockstate.getValue(SweetBerryBushBlock.AGE);
                blockstate.setValue(SweetBerryBushBlock.AGE, 1);
                int j = 1 + this.mob.level.random.nextInt(2) + (i == 3 ? 1 : 0);
                if(j > 0) {
                    Block.popResource(this.mob.level, this.blockPos, new ItemStack(Items.SWEET_BERRIES, j));
                }
                this.mob.playSound(SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, 1.0F, 1.0F);
                this.mob.level.setBlock(this.blockPos, blockstate.setValue(SweetBerryBushBlock.AGE, 1), 2);
            }
        }
    }

    @Override
    public boolean canUse() {
        return !this.mob.isSleeping() && super.canUse();
    }

    @Override
    public void start() {
        this.eatTicks = 0;
        super.start();
    }
}
