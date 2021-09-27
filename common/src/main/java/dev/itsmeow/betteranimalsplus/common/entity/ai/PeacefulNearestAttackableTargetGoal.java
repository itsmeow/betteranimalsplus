package dev.itsmeow.betteranimalsplus.common.entity.ai;

import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.Difficulty;

public class PeacefulNearestAttackableTargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {

    public PeacefulNearestAttackableTargetGoal(Mob goalOwnerIn, Class<T> targetClassIn, boolean checkSight) {
        this(goalOwnerIn, targetClassIn, checkSight, false);
    }

    public PeacefulNearestAttackableTargetGoal(Mob goalOwnerIn, Class<T> targetClassIn, boolean checkSight, boolean nearbyOnlyIn) {
        this(goalOwnerIn, targetClassIn, 10, checkSight, nearbyOnlyIn, null);
    }

    public PeacefulNearestAttackableTargetGoal(Mob goalOwnerIn, Class<T> targetClassIn, int targetChanceIn, boolean checkSight, boolean nearbyOnlyIn, @Nullable Predicate<LivingEntity> targetPredicate) {
        super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnlyIn, targetPredicate);
    }

    @Override
    public boolean canUse() {
        return this.mob.level.getDifficulty() != Difficulty.PEACEFUL && super.canUse();
    }

}
