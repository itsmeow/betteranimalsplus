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
    protected boolean canNavigate() {
        return true;
    }

    @Override
    protected PathFinder getPathFinder(int p_179679_1_) {
        this.nodeProcessor = new WalkAndSwimNodeProcessor();
        return new PathFinder(this.nodeProcessor, p_179679_1_);
    }

    @Override
    public boolean canEntityStandOnPos(BlockPos pos) {
        if (shouldPathAsWater.test(entity)) {
            return this.world.getBlockState(pos).getBlock() == Blocks.WATER;
        }
        return !this.world.isAirBlock(pos.down());
    }
}
