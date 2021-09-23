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
    public double getTargetDistanceSq() {
        return 2.0D;
    }

    @Override
    public boolean shouldMove() {
        return this.timeoutCounter % 100 == 0;
    }

    @Override
    protected boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos) {
        BlockState blockstate = worldIn.getBlockState(pos);
        return blockstate.getBlock() == Blocks.SWEET_BERRY_BUSH && blockstate.get(SweetBerryBushBlock.AGE) >= 2;
    }

    @Override
    public void tick() {
        if(this.getIsAboveDestination()) {
            if(this.eatTicks >= 40) {
                this.eatBerry();
            } else {
                ++this.eatTicks;
            }
        }

        super.tick();
    }

    protected void eatBerry() {
        if(net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.creature.world, this.creature)) {
            BlockState blockstate = this.creature.world.getBlockState(this.destinationBlock);
            if(blockstate.getBlock() == Blocks.SWEET_BERRY_BUSH) {
                int i = blockstate.get(SweetBerryBushBlock.AGE);
                blockstate.with(SweetBerryBushBlock.AGE, 1);
                int j = 1 + this.creature.world.rand.nextInt(2) + (i == 3 ? 1 : 0);
                if(j > 0) {
                    Block.spawnAsEntity(this.creature.world, this.destinationBlock, new ItemStack(Items.SWEET_BERRIES, j));
                }
                this.creature.playSound(SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, 1.0F, 1.0F);
                this.creature.world.setBlockState(this.destinationBlock, blockstate.with(SweetBerryBushBlock.AGE, 1), 2);
            }
        }
    }

    @Override
    public boolean shouldExecute() {
        return !this.creature.isSleeping() && super.shouldExecute();
    }

    @Override
    public void startExecuting() {
        this.eatTicks = 0;
        super.startExecuting();
    }
}
