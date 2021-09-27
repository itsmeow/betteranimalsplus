package dev.itsmeow.betteranimalsplus.common.entity.ai;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;

public class EntityAIEatBerries extends MoveToBlockGoal {
    protected int eatTicks;

    public EntityAIEatBerries(PathfinderMob creature, double speed, int length, int iterations) {
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
    protected boolean isValidTarget(LevelReader worldIn, BlockPos pos) {
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
