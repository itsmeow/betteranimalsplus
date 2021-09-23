package dev.itsmeow.betteranimalsplus.common.entity.ai;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockStateMatcher;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.EnumSet;
import java.util.function.Function;
import java.util.function.Predicate;

public class EntityAIEatGrassCustom extends Goal {

    private static final Predicate<BlockState> IS_GRASS = BlockStateMatcher.forBlock(Blocks.GRASS);
    protected final MobEntity eater;
    protected final World world;
    protected int eatingGrassTimer;
    protected final int childChance;
    protected final int adultChance;
    protected final Function<MobEntity, BlockPos> getPosition;

    public EntityAIEatGrassCustom(MobEntity eater, int childChance, int adultChance) {
        this(eater, childChance, adultChance, e -> new BlockPos(e.getX(), e.getY(), e.getZ()));
    }
    
    public EntityAIEatGrassCustom(MobEntity eater, int childChance, int adultChance, Function<MobEntity, BlockPos> getPosition) {
        this.eater = eater;
        this.world = eater.level;
        this.childChance = childChance;
        this.adultChance = adultChance;
        this.getPosition = getPosition;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
    }

    @Override
    public boolean canUse() {
        if(this.eater.getRandom().nextInt(this.eater.isBaby() ? childChance : adultChance) == 0) {
            BlockPos blockpos = getPosition.apply(eater);
            return IS_GRASS.test(this.world.getBlockState(blockpos)) || this.world.getBlockState(blockpos.below()).getBlock() == Blocks.GRASS_BLOCK;
        }
        return false;
    }

    @Override
    public void start() {
        this.eatingGrassTimer = 40;
        this.world.broadcastEntityEvent(this.eater, (byte) 10);
        this.eater.getNavigation().stop();
    }

    @Override
    public void stop() {
        this.eatingGrassTimer = 0;
    }

    @Override
    public boolean canContinueToUse() {
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
                this.eater.ate();
            } else {
                BlockPos blockpos1 = blockpos.below();
                if(this.world.getBlockState(blockpos1).getBlock() == Blocks.GRASS_BLOCK) {
                    if(net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this.eater)) {
                        this.world.levelEvent(2001, blockpos1, Block.getId(Blocks.GRASS_BLOCK.defaultBlockState()));
                        this.world.setBlock(blockpos1, Blocks.DIRT.defaultBlockState(), 2);
                    }
                    this.eater.ate();
                }
            }
        }
    }
}