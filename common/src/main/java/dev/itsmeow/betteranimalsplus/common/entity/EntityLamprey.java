package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.betteranimalsplus.common.entity.ai.EfficientMoveTowardsTargetGoal;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityWaterMobPathingWithTypesBucketable;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.util.EntityTypeContainerContainable;
import net.minecraft.network.protocol.game.ClientboundSetPassengersPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.HashSet;
import java.util.Set;

public class EntityLamprey extends EntityWaterMobPathingWithTypesBucketable implements Enemy {

    protected int lastAttack = 0;

    public EntityLamprey(EntityType<? extends EntityLamprey> entityType, Level worldIn) {
        super(entityType, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new EfficientMoveTowardsTargetGoal(this, 0.8D, false));
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, WaterAnimal.class, 10.0F));
        this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(2, new RandomSwimmingGoal(this, 0.5D, 1));
        Set<Class<? extends LivingEntity>> blackList = new HashSet<>();
        blackList.add(Skeleton.class);
        blackList.add(EnderMan.class);
        blackList.add(EntityJellyfish.class);
        blackList.add(EntityBobbitWorm.class);
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 100, true, true, e -> !(e instanceof Enemy) && !(e.level.getDifficulty() == Difficulty.PEACEFUL && e instanceof Player) && !blackList.contains(e.getClass())));
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
    public void aiStep() {
        super.aiStep();
        if(!this.isAlive() && this.getVehicle() != null) {
            this.stopRiding();
        }
        if(!this.level.isClientSide && this.getTarget() != null && this.getTarget().isAlive()) {
            if(this.getVehicle() != null && this.getVehicle() == this.getTarget()) {
                float time = 20F; 
                if(!this.wasTouchingWater) {
                    time *= 2F * (Math.random() + 1F);
                } else {
                    time += Math.random() * Math.random() * 2 * ((Math.random() < 0.5) ? -1 : 1);
                }
                if(this.lastAttack + time < this.tickCount) {
                    this.doHurtTarget(this.getTarget());
                }
            } else if(this.distanceToSqr(this.getTarget()) < 3) {
                this.grabTarget(this.getTarget());
            }
        }
    }

    @Override
    public void stopRiding() {
        Entity entity = this.getVehicle();
        if(entity != null) {
            if((entity.rideableUnderWater() || this.getTarget() == null) && this.level.isLoaded(this.blockPosition())) {
                super.stopRiding();
            }
        }
    }

    @Override
    public boolean rideableUnderWater() {
        return true;
    }

    public void grabTarget(Entity entity) {
        if(entity == this.getTarget() && !entity.hasPassenger(this) && this.wasTouchingWater) {
            this.startRiding(entity);
            if(entity instanceof ServerPlayer) {
               ((ServerPlayer) entity).connection.send(new ClientboundSetPassengersPacket(entity));
            }
        }
    }

    @Override
    public double getMyRidingOffset() {
        if(getVehicle() != null && getVehicle() instanceof Player) {
            return getVehicle().getBbHeight() - 2.25F;
        } else if(getVehicle() != null) {
            return getVehicle().getBbHeight() * 0.5D - 1.25D;
        } else {
            return super.getMyRidingOffset();
        }
    }

    @Override
    protected boolean isMovementNoisy() {
        return false;
    }

    //@Override on Forge
    public boolean canRiderInteract() {
        return true;
    }

    @Override
    public EntityTypeContainer<EntityLamprey> getContainer() {
        return ModEntities.LAMPREY;
    }

    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.COD_FLOP;
    }

    @Override
    public EntityTypeContainerContainable<?, ?> getContainableContainer() {
        return ModEntities.LAMPREY;
    }

}