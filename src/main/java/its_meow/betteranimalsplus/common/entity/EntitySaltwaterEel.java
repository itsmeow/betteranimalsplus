package its_meow.betteranimalsplus.common.entity;

import its_meow.betteranimalsplus.common.entity.util.EntityTypeContainer;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntityEelBase;
import its_meow.betteranimalsplus.init.ModEntities;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class EntitySaltwaterEel extends EntityEelBase {

    /* Client Animation Fields */
    public float lastBodyRotation = 0;
    public float body01 = 0;
    public float body02 = 0;
    public float body03 = 0;
    public float body04 = 0;
    public float body05 = 0;
    public float body06 = 0;
    /* Server Logic Fields */
    protected boolean isTargetForFood = false;

    public EntitySaltwaterEel(World worldIn) {
        super(ModEntities.EEL_SALTWATER.entityType, worldIn);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.targetSelector.addGoal(0, new HurtByTargetGoal(this));
    }

    @Override
    public void setAttackTarget(LivingEntity entity) {
        if(entity != null && (this.getAttackTarget() == null || this.getAttackTarget() != entity)) {
            isTargetForFood = isHoldingFood(entity);
        }
        super.setAttackTarget(entity);
    }

    protected boolean shouldCheckTarget() {
        return isTargetForFood;
    }

    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.ENTITY_TROPICAL_FISH_FLOP;
    }

    @Override
    public EntityTypeContainer<EntitySaltwaterEel> getContainer() {
        return ModEntities.EEL_SALTWATER;
    }

}
