package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.util.EntityTypeContainerContainable;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityWaterMobBucketable;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModLootTables;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.SwimmerPathNavigator;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.World;

public class EntityNautilus extends EntityWaterMobBucketable {

    public EntityNautilus(EntityType<? extends EntityNautilus> entityType, World worldIn) {
        super(entityType, worldIn);
    }
    
    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new RandomWalkingGoal(this, 0.15D));
    }

    @Override
    protected PathNavigator createNavigation(World worldIn) {
        return new SwimmerPathNavigator(this, worldIn);
    }

    @Override
    public void travel(Vector3d vec) {
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
                Vector3i target = this.navigation.getPath().getNextNodePos();
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
    protected boolean isMovementNoisy() {
        return false;
    }

    @Override
    protected ResourceLocation getDefaultLootTable() {
        return ModLootTables.NAUTILUS;
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
