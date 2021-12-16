package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityWaterMobBucketable;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.util.EntityTypeContainerContainable;
import net.minecraft.core.Vec3i;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class EntityNautilus extends EntityWaterMobBucketable {

    public EntityNautilus(EntityType<? extends EntityNautilus> entityType, Level worldIn) {
        super(entityType, worldIn);
    }
    
    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new RandomStrollGoal(this, 0.15D));
    }

    @Override
    protected PathNavigation createNavigation(Level worldIn) {
        return new WaterBoundPathNavigation(this, worldIn);
    }

    @Override
    public void travel(Vec3 vec) {
        this.move(MoverType.SELF, this.getDeltaMovement());
    }

    @Override
    public void tick() {
        super.tick();
        if(!this.wasTouchingWater) {
            this.setDeltaMovement(this.getDeltaMovement().x() * 0.2F, this.getDeltaMovement().y(), this.getDeltaMovement().z() * 0.2F);
            if (!this.isNoGravity()) {
                this.setDeltaMovement(this.getDeltaMovement().x(), this.getDeltaMovement().y() - 0.08D, this.getDeltaMovement().z());
            }
            this.setDeltaMovement(this.getDeltaMovement().x(), this.getDeltaMovement().y() * 0.9800000190734863D, this.getDeltaMovement().z());
        } else if(!level.isClientSide) {
            if(!this.navigation.isDone()) {
                Vec3i target = this.navigation.getPath().getNextNodePos();
                this.setDeltaMovement((target.getX() - this.getX()) * 0.05F, (target.getY() - this.getY()) * 0.05F, (target.getZ() - this.getZ()) * 0.05F);
            } else if(this.getMoveControl().hasWanted()) {
                this.setDeltaMovement((this.getMoveControl().getWantedX() - this.getX()) * 0.05F, (this.getMoveControl().getWantedY() - this.getY()) * 0.05F, (this.getMoveControl().getWantedZ() - this.getZ()) * 0.05F);
            } else {
                this.setDeltaMovement(this.getDeltaMovement().x() * 0.85F, this.getDeltaMovement().y() * 0.85F, this.getDeltaMovement().z() * 0.85F);
            }
        }
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.SQUID_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.SQUID_DEATH;
    }

    @Override
    protected MovementEmission getMovementEmission() {
        return MovementEmission.EVENTS;
    }

    @Override
    public EntityWaterMobBucketable getImplementation() {
        return this;
    }

    @Override
    public EntityTypeContainer<? extends EntityNautilus> getContainer() {
        return ModEntities.NAUTILUS;
    }

    @Override
    public EntityTypeContainerContainable<?, ?> getContainableContainer() {
        return ModEntities.NAUTILUS;
    }

}
