package dev.itsmeow.betteranimalsplus.common.entity.ai;

import dev.itsmeow.betteranimalsplus.common.entity.util.IHaveHunger;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.NonTameRandomTargetGoal;
import net.minecraft.world.entity.TamableAnimal;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class HungerNonTamedTargetGoal<T extends LivingEntity, O extends TamableAnimal & IHaveHunger> extends NonTameRandomTargetGoal<T> {

    private final O hunger;

    public HungerNonTamedTargetGoal(O goalOwnerIn, Class<T> targetClassIn, boolean checkSight, @Nullable Predicate<LivingEntity> targetPredicate) {
        super(goalOwnerIn, targetClassIn, checkSight, targetPredicate);
        this.hunger = goalOwnerIn;
    }

    @Override
    public boolean canUse() {
        return super.canUse() && this.hunger.getEffectiveHunger() > 0 && (this.hunger.getEffectiveHunger() >= 100 || this.mob.getRandom().nextInt(100 - this.hunger.getEffectiveHunger()) == 0);
    }

}
