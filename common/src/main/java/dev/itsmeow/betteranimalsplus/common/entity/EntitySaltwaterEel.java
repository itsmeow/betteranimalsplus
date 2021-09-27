package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.util.EntityTypeContainerContainable;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityEelBase;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;

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

    public EntitySaltwaterEel(EntityType<? extends EntitySaltwaterEel> entityType, Level worldIn) {
        super(entityType, worldIn);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.targetSelector.addGoal(0, new HurtByTargetGoal(this) {
            @Override
            public boolean canUse() {
                return EntitySaltwaterEel.this.level.getDifficulty() != Difficulty.PEACEFUL && super.canUse();
            }
        });
    }

    @Override
    public void setTarget(LivingEntity entity) {
        if(entity != null && (this.getTarget() == null || this.getTarget() != entity)) {
            isTargetForFood = isHoldingFood(entity);
        }
        super.setTarget(entity);
    }

    @Override
    protected boolean shouldCheckTarget() {
        return isTargetForFood;
    }

    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.TROPICAL_FISH_FLOP;
    }

    @Override
    public EntityTypeContainer<EntitySaltwaterEel> getContainer() {
        return ModEntities.EEL_SALTWATER;
    }

    @Override
    public EntityTypeContainerContainable<?, ?> getContainableContainer() {
        return ModEntities.EEL_SALTWATER;
    }

}
