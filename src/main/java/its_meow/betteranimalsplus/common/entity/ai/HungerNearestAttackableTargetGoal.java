package its_meow.betteranimalsplus.common.entity.ai;

import its_meow.betteranimalsplus.common.entity.util.IHaveHunger;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class HungerNearestAttackableTargetGoal<T extends LivingEntity, O extends MobEntity & IHaveHunger> extends NearestAttackableTargetGoal<T> {

    private final O hunger;

    public HungerNearestAttackableTargetGoal(O goalOwnerIn, Class<T> targetClassIn, boolean checkSight) {
        this(goalOwnerIn, targetClassIn, checkSight, false);
    }

    public HungerNearestAttackableTargetGoal(O goalOwnerIn, Class<T> targetClassIn, boolean checkSight, boolean nearbyOnlyIn) {
        this(goalOwnerIn, targetClassIn, 10, checkSight, nearbyOnlyIn, null);
    }

    public HungerNearestAttackableTargetGoal(O goalOwnerIn, Class<T> targetClassIn, int targetChanceIn, boolean checkSight, boolean nearbyOnlyIn, @Nullable Predicate<LivingEntity> targetPredicate) {
        super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnlyIn, targetPredicate);
        this.hunger = goalOwnerIn;
    }

    @Override
    public boolean shouldExecute() {
        return super.shouldExecute() && this.hunger.getEffectiveHunger() > 0 && (this.hunger.getEffectiveHunger() >= 100 || this.goalOwner.getRNG().nextInt(100 - this.hunger.getEffectiveHunger()) == 0);
    }

}
