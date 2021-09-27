package dev.itsmeow.betteranimalsplus.common.entity.ai;

import dev.itsmeow.betteranimalsplus.common.entity.util.IHaveHunger;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;

import java.util.function.Predicate;

public class HungerNearestAttackableTargetGoal<T extends LivingEntity, O extends Mob & IHaveHunger> extends NearestAttackableTargetGoal<T> {

    private final O hunger;

    public HungerNearestAttackableTargetGoal(O goalOwnerIn, Class<T> targetClassIn, boolean checkSight) {
        this(goalOwnerIn, targetClassIn, checkSight, false);
    }

    public HungerNearestAttackableTargetGoal(O goalOwnerIn, Class<T> targetClassIn, boolean checkSight, boolean nearbyOnlyIn) {
        this(goalOwnerIn, targetClassIn, 10, checkSight, nearbyOnlyIn, null);
    }

    public HungerNearestAttackableTargetGoal(O goalOwnerIn, Class<T> targetClassIn, int targetChanceIn, boolean checkSight, boolean nearbyOnlyIn, Predicate<LivingEntity> targetPredicate) {
        super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnlyIn, targetPredicate);
        this.hunger = goalOwnerIn;
    }

    @Override
    public boolean canUse() {
        return super.canUse() && this.hunger.getEffectiveHunger() > 0 && (this.hunger.getEffectiveHunger() >= 100 || this.mob.getRandom().nextInt(100 - this.hunger.getEffectiveHunger()) == 0);
    }

}
