package dev.itsmeow.betteranimalsplus.common.entity.ai;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.pathfinder.AmphibiousNodeEvaluator;
import net.minecraft.world.level.pathfinder.PathFinder;

import java.util.function.Predicate;

public class HybridPathNavigator<T extends Mob> extends WaterBoundPathNavigation {

    private final Predicate<T> shouldPathAsWater;
    private final T entity;

    public HybridPathNavigator(T entity, Level world, Predicate<T> shouldPathAsWater) {
        super(entity, world);
        this.shouldPathAsWater = shouldPathAsWater;
        this.entity = entity;
    }

    @Override
    protected boolean canUpdatePath() {
        return true;
    }

    @Override
    protected PathFinder createPathFinder(int p_179679_1_) {
        this.nodeEvaluator = new AmphibiousNodeEvaluator(true);
        return new PathFinder(this.nodeEvaluator, p_179679_1_);
    }

    @Override
    public boolean isStableDestination(BlockPos pos) {
        if (shouldPathAsWater.test(entity)) {
            return this.level.getBlockState(pos).getBlock() == Blocks.WATER;
        }
        return !this.level.isEmptyBlock(pos.below());
    }
}
