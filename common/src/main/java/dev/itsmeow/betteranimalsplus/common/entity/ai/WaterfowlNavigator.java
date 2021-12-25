package dev.itsmeow.betteranimalsplus.common.entity.ai;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.PathFinder;
import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;

public class WaterfowlNavigator extends GroundPathNavigation {

    public WaterfowlNavigator(Mob entitylivingIn, Level worldIn) {
        super(entitylivingIn, worldIn);
        this.nodeEvaluator.setCanOpenDoors(false);
        this.nodeEvaluator.setCanFloat(true);
        this.nodeEvaluator.setCanFloat(true);
    }

    @Override
    protected PathFinder createPathFinder(int p_179679_1_) {
        this.nodeEvaluator = new WalkNodeEvaluator();
        this.nodeEvaluator.setCanPassDoors(true);
        this.nodeEvaluator.setCanFloat(true);
        return new PathFinder(this.nodeEvaluator, p_179679_1_);
    }

    @Override
    protected boolean hasValidPathType(BlockPathTypes blockPathTypes) {
        return blockPathTypes == BlockPathTypes.LAVA ? false : blockPathTypes != BlockPathTypes.OPEN;
    }

}
