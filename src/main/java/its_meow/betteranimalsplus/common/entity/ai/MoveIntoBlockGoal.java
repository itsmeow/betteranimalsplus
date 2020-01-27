package its_meow.betteranimalsplus.common.entity.ai;

import java.util.EnumSet;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public abstract class MoveIntoBlockGoal extends Goal {
    protected final CreatureEntity creature;
    public final double movementSpeed;
    protected int runDelay;
    protected int timeoutCounter;
    private int maxStayTicks;
    protected BlockPos destinationBlock = BlockPos.ZERO;
    private boolean isAtDestination;
    private final int searchLength;
    private final int field_203113_j;
    protected int field_203112_e;

    public MoveIntoBlockGoal(CreatureEntity creature, double speedIn, int length) {
       this(creature, speedIn, length, 1);
    }

    public MoveIntoBlockGoal(CreatureEntity creatureIn, double speed, int length, int p_i48796_5_) {
       this.creature = creatureIn;
       this.movementSpeed = speed;
       this.searchLength = length;
       this.field_203112_e = 0;
       this.field_203113_j = p_i48796_5_;
       this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP));
    }

    @Override
    public boolean shouldExecute() {
       if (this.runDelay > 0) {
          --this.runDelay;
          return false;
       } else {
          this.runDelay = this.getRunDelay(this.creature);
          return this.searchForDestination();
       }
    }

    protected int getRunDelay(CreatureEntity creatureIn) {
       return 200 + creatureIn.getRNG().nextInt(200);
    }

    @Override
    public boolean shouldContinueExecuting() {
       return this.timeoutCounter >= -this.maxStayTicks && this.timeoutCounter <= 1200 && this.shouldMoveTo(this.creature.world, this.destinationBlock);
    }

    @Override
    public void startExecuting() {
       this.func_220725_g();
       this.timeoutCounter = 0;
       this.maxStayTicks = this.creature.getRNG().nextInt(this.creature.getRNG().nextInt(1200) + 1200) + 1200;
    }

    protected void func_220725_g() {
       this.creature.getNavigator().tryMoveToXYZ((double)((float)this.destinationBlock.getX()) + 0.5D, (double)(this.destinationBlock.getY()), (double)((float)this.destinationBlock.getZ()) + 0.5D, this.movementSpeed);
    }

    public double getTargetDistanceSq() {
       return 1.0D;
    }

    @Override
    public void tick() {
       if (!this.destinationBlock.withinDistance(this.creature.getPositionVec(), this.getTargetDistanceSq())) {
          this.isAtDestination = false;
          ++this.timeoutCounter;
          if (this.shouldMove()) {
             this.creature.getNavigator().tryMoveToXYZ((double)((float)this.destinationBlock.getX()) + 0.5D, (double)(this.destinationBlock.getY()), (double)((float)this.destinationBlock.getZ()) + 0.5D, this.movementSpeed);
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
       int i = this.searchLength;
       int j = this.field_203113_j;
       BlockPos blockpos = new BlockPos(this.creature);
       BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();

       for(int k = this.field_203112_e; k <= j; k = k > 0 ? -k : 1 - k) {
          for(int l = 0; l < i; ++l) {
             for(int i1 = 0; i1 <= l; i1 = i1 > 0 ? -i1 : 1 - i1) {
                for(int j1 = i1 < l && i1 > -l ? l : 0; j1 <= l; j1 = j1 > 0 ? -j1 : 1 - j1) {
                   blockpos$mutableblockpos.setPos(blockpos).move(i1, k - 1, j1);
                   if (this.creature.isWithinHomeDistanceFromPosition(blockpos$mutableblockpos) && this.shouldMoveTo(this.creature.world, blockpos$mutableblockpos)) {
                      this.destinationBlock = blockpos$mutableblockpos;
                      return true;
                   }
                }
             }
          }
       }

       return false;
    }

    protected abstract boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos);
}