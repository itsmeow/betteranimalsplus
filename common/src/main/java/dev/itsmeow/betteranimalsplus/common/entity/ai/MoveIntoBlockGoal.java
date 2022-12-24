package dev.itsmeow.betteranimalsplus.common.entity.ai;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.LevelReader;

import java.util.EnumSet;

public abstract class MoveIntoBlockGoal extends Goal {
    protected final PathfinderMob creature;
    public final double movementSpeed;
    protected int runDelay;
    protected int timeoutCounter;
    private int maxStayTicks;
    protected BlockPos destinationBlock = BlockPos.ZERO;
    private boolean isAtDestination;
    private final int searchLength;
    private final int verticalSearchRange;
    protected int verticalSearchStart;

    public MoveIntoBlockGoal(PathfinderMob creature, double speedIn, int length) {
       this(creature, speedIn, length, 1);
    }

    public MoveIntoBlockGoal(PathfinderMob creatureIn, double speed, int length, int p_i48796_5_) {
       this.creature = creatureIn;
       this.movementSpeed = speed;
       this.searchLength = length;
       this.verticalSearchStart = 0;
       this.verticalSearchRange = p_i48796_5_;
       this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP));
    }

    @Override
    public boolean canUse() {
       if (this.runDelay > 0) {
          --this.runDelay;
          return false;
       } else {
          this.runDelay = this.getRunDelay(this.creature);
          return this.searchForDestination();
       }
    }

    protected int getRunDelay(PathfinderMob creatureIn) {
       return 200 + creatureIn.getRandom().nextInt(200);
    }

    @Override
    public boolean canContinueToUse() {
       return this.timeoutCounter >= -this.maxStayTicks && this.timeoutCounter <= 1200 && this.shouldMoveTo(this.creature.level, this.destinationBlock);
    }

    @Override
    public void start() {
       this.moveMobToBlock();
       this.timeoutCounter = 0;
       this.maxStayTicks = this.creature.getRandom().nextInt(this.creature.getRandom().nextInt(1200) + 1200) + 1200;
    }

    protected void moveMobToBlock() {
       this.creature.getNavigation().moveTo((double)((float)this.destinationBlock.getX()) + 0.5D, this.destinationBlock.getY(), (double)((float)this.destinationBlock.getZ()) + 0.5D, this.movementSpeed);
    }

    public double getTargetDistanceSq() {
       return 1.0D;
    }

    @Override
    public void tick() {
       if (!this.destinationBlock.closerThan(this.creature.blockPosition(), this.getTargetDistanceSq())) {
          this.isAtDestination = false;
          ++this.timeoutCounter;
          if (this.shouldMove()) {
             this.creature.getNavigation().moveTo((double)((float)this.destinationBlock.getX()) + 0.5D, this.destinationBlock.getY(), (double)((float)this.destinationBlock.getZ()) + 0.5D, this.movementSpeed);
          }
       } else {
          this.isAtDestination = true;
          --this.timeoutCounter;
       }

    }

    public boolean shouldMove() {
       return this.timeoutCounter % 40 == 0;
    }

    protected boolean isAtDestination() {
       return this.isAtDestination;
    }

    protected boolean searchForDestination() {
        BlockPos blockpos = this.creature.blockPosition();
       BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

       for(int k = this.verticalSearchStart; k <= this.verticalSearchRange; k = k > 0 ? -k : 1 - k) {
          for(int l = 0; l < this.searchLength; ++l) {
             for(int i1 = 0; i1 <= l; i1 = i1 > 0 ? -i1 : 1 - i1) {
                for(int j1 = i1 < l && i1 > -l ? l : 0; j1 <= l; j1 = j1 > 0 ? -j1 : 1 - j1) {
                   blockpos$mutableblockpos.set(blockpos).move(i1, k - 1, j1);
                   if (this.creature.isWithinRestriction(blockpos$mutableblockpos) && this.shouldMoveTo(this.creature.level, blockpos$mutableblockpos)) {
                      this.destinationBlock = blockpos$mutableblockpos;
                      return true;
                   }
                }
             }
          }
       }

       return false;
    }

    protected abstract boolean shouldMoveTo(LevelReader worldIn, BlockPos pos);
}