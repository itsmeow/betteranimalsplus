package dev.itsmeow.betteranimalsplus.common.entity.ai;

import net.minecraft.block.Blocks;
import net.minecraft.entity.MobEntity;
import net.minecraft.pathfinding.PathFinder;
import net.minecraft.pathfinding.SwimmerPathNavigator;
import net.minecraft.pathfinding.WalkAndSwimNodeProcessor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.function.Predicate;

public class HybridPathNavigator<T extends MobEntity> extends SwimmerPathNavigator {

    private final Predicate<T> shouldPathAsWater;
    private final T entity;

    public HybridPathNavigator(T entity, World world, Predicate<T> shouldPathAsWater) {
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
        this.nodeEvaluator = new WalkAndSwimNodeProcessor();
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
