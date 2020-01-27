package its_meow.betteranimalsplus.common.entity.ai;

import java.util.EnumSet;
import java.util.function.Function;
import java.util.function.Predicate;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockStateMatcher;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityAIEatGrassCustom extends Goal {

    private static final Predicate<BlockState> IS_GRASS = (Predicate<BlockState>) BlockStateMatcher.forBlock(Blocks.GRASS);
    protected final MobEntity eater;
    protected final World world;
    protected int eatingGrassTimer;
    protected final int childChance;
    protected final int adultChance;
    protected final Function<MobEntity, BlockPos> getPosition;

    public EntityAIEatGrassCustom(MobEntity eater, int childChance, int adultChance) {
        this(eater, childChance, adultChance, e -> new BlockPos(e.getPosX(), e.getPosY(), e.getPosZ()));
    }
    
    public EntityAIEatGrassCustom(MobEntity eater, int childChance, int adultChance, Function<MobEntity, BlockPos> getPosition) {
        this.eater = eater;
        this.world = eater.world;
        this.childChance = childChance;
        this.adultChance = adultChance;
        this.getPosition = getPosition;
        this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
    }

    @Override
    public boolean shouldExecute() {
        if(this.eater.getRNG().nextInt(this.eater.isChild() ? childChance : adultChance) == 0) {
            BlockPos blockpos = getPosition.apply(eater);
            return IS_GRASS.test(this.world.getBlockState(blockpos)) || this.world.getBlockState(blockpos.down()).getBlock() == Blocks.GRASS_BLOCK;
        }
        return false;
    }

    @Override
    public void startExecuting() {
        this.eatingGrassTimer = 40;
        this.world.setEntityState(this.eater, (byte) 10);
        this.eater.getNavigator().clearPath();
    }

    @Override
    public void resetTask() {
        this.eatingGrassTimer = 0;
    }

    @Override
    public boolean shouldContinueExecuting() {
        return this.eatingGrassTimer > 0;
    }

    public int getEatingGrassTimer() {
        return this.eatingGrassTimer;
    }

    @Override
    public void tick() {
        this.eatingGrassTimer = Math.max(0, this.eatingGrassTimer - 1);
        if(this.eatingGrassTimer == 4) {
            BlockPos blockpos = this.getPosition.apply(eater);
            if(IS_GRASS.test(this.world.getBlockState(blockpos))) {
                if(net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this.eater)) {
                    this.world.destroyBlock(blockpos, false);
                }
                this.eater.eatGrassBonus();
            } else {
                BlockPos blockpos1 = blockpos.down();
                if(this.world.getBlockState(blockpos1).getBlock() == Blocks.GRASS_BLOCK) {
                    if(net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this.eater)) {
                        this.world.playEvent(2001, blockpos1, Block.getStateId(Blocks.GRASS_BLOCK.getDefaultState()));
                        this.world.setBlockState(blockpos1, Blocks.DIRT.getDefaultState(), 2);
                    }
                    this.eater.eatGrassBonus();
                }
            }
        }
    }
}