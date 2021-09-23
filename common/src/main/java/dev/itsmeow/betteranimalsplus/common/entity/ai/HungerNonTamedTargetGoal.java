package dev.itsmeow.betteranimalsplus.common.entity.ai;

import dev.itsmeow.betteranimalsplus.common.entity.util.IHaveHunger;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.NonTamedTargetGoal;
import net.minecraft.entity.passive.TameableEntity;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class HungerNonTamedTargetGoal<T extends LivingEntity, O extends TameableEntity & IHaveHunger> extends NonTamedTargetGoal<T> {

    private final O hunger;

    public HungerNonTamedTargetGoal(O goalOwnerIn, Class<T> targetClassIn, boolean checkSight, @Nullable Predicate<LivingEntity> targetPredicate) {
        super(goalOwnerIn, targetClassIn, checkSight, targetPredicate);
        this.hunger = goalOwnerIn;
    }

    @Override
    public boolean shouldExecute() {
        return super.shouldExecute() && this.hunger.getEffectiveHunger() > 0 && (this.hunger.getEffectiveHunger() >= 100 || this.goalOwner.getRNG().nextInt(100 - this.hunger.getEffectiveHunger()) == 0);
    }

}
