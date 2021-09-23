package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.util.EntityTypeContainerContainable;
import dev.itsmeow.betteranimalsplus.common.entity.ai.HungerNearestAttackableTargetGoal;
import dev.itsmeow.betteranimalsplus.common.entity.ai.PeacefulNearestAttackableTargetGoal;
import dev.itsmeow.betteranimalsplus.common.entity.util.IHaveHunger;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityWaterMobPathing;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityWaterMobPathingBucketable;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.passive.horse.SkeletonHorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class EntityPiranha extends EntityWaterMobPathingBucketable implements IHaveHunger<EntityWaterMobPathing> {

    public final DamageSource PIRANHA_DAMAGE = (new EntityDamageSource("betteranimalsplus.piranha", this)).bypassArmor();
    private int hunger;

    public EntityPiranha(EntityType<? extends EntityPiranha> entityType, World worldIn) {
        super(entityType, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 1D, true));
        this.goalSelector.addGoal(1, new RandomSwimmingGoal(this, 1D, 1));
        Predicate<LivingEntity> eP = e -> e.getHealth() < e.getMaxHealth();
        this.targetSelector.addGoal(0, new HungerNearestAttackableTargetGoal<>(this, LivingEntity.class, 0, true, false, e -> eP.test(e) && !(e instanceof EntityPiranha) && !(e instanceof SkeletonEntity) && !(e instanceof SkeletonHorseEntity) && !(e instanceof PlayerEntity)));
        this.targetSelector.addGoal(1, new PeacefulNearestAttackableTargetGoal<>(this, PlayerEntity.class, true, false));
    }

    @Override
    public int getHunger() {
        return hunger;
    }

    @Override
    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.tickCount % 20 == 0) {
            this.incrementHunger();
        }
    }

    @Nullable
    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData livingdata, CompoundNBT compound) {
        this.setInitialHunger();
        return super.finalizeSpawn(world, difficulty, reason, livingdata, compound);
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT compound) {
        super.addAdditionalSaveData(compound);
        this.writeHunger(compound);
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT compound) {
        super.readAdditionalSaveData(compound);
        this.readHunger(compound);
    }

    @Override
    public boolean doHurtTarget(Entity entityIn) {
        float f = (float) this.getAttribute(Attributes.ATTACK_DAMAGE).getValue();
        float f1 = (float) this.getAttribute(Attributes.ATTACK_KNOCKBACK).getValue();
        if(entityIn instanceof LivingEntity) {
            f += EnchantmentHelper.getDamageBonus(this.getMainHandItem(), ((LivingEntity) entityIn).getMobType());
            f1 += (float) EnchantmentHelper.getKnockbackBonus(this);
        }
        int i = EnchantmentHelper.getFireAspect(this);
        if(i > 0) {
            entityIn.setSecondsOnFire(i * 4);
        }
        boolean flag = entityIn.hurt(PIRANHA_DAMAGE, f);
        if(flag) {
            if(f1 > 0.0F && entityIn instanceof LivingEntity) {
                ((LivingEntity) entityIn).knockback(f1 * 0.5F, MathHelper.sin(this.yRot * ((float) Math.PI / 180F)), -MathHelper.cos(this.yRot * ((float) Math.PI / 180F)));
                this.setDeltaMovement(this.getDeltaMovement().multiply(0.6D, 1.0D, 0.6D));
            }
            if(entityIn instanceof PlayerEntity) {
                PlayerEntity playerentity = (PlayerEntity) entityIn;
                ItemStack itemstack = this.getMainHandItem();
                ItemStack itemstack1 = playerentity.isUsingItem() ? playerentity.getUseItem() : ItemStack.EMPTY;
                if(!itemstack.isEmpty() && !itemstack1.isEmpty() && itemstack.canDisableShield(itemstack1, playerentity, this) && itemstack1.isShield(playerentity)) {
                    float f2 = 0.25F + (float) EnchantmentHelper.getBlockEfficiency(this) * 0.05F;
                    if(this.random.nextFloat() < f2) {
                        playerentity.getCooldowns().addCooldown(itemstack.getItem(), 100);
                        this.level.broadcastEntityEvent(playerentity, (byte) 30);
                    }
                }
                if(!playerentity.isAlive()) {
                    SkeletonEntity skele = EntityType.SKELETON.create(playerentity.level);
                    skele.setCustomName(playerentity.getName());
                    skele.setCustomNameVisible(true);
                    skele.absMoveTo(playerentity.getX(), playerentity.getY(), playerentity.getZ(), playerentity.yRot, playerentity.xRot);
                    playerentity.level.addFreshEntity(skele);
                }
            } else if(entityIn instanceof HorseEntity && !entityIn.isAlive() && entityIn.level instanceof IServerWorld) {
                SkeletonHorseEntity skele = EntityType.SKELETON_HORSE.create(entityIn.level);
                skele.absMoveTo(entityIn.getX(), entityIn.getY(), entityIn.getZ(), entityIn.yRot, entityIn.xRot);
                skele.finalizeSpawn((IServerWorld) entityIn.level, entityIn.level.getCurrentDifficultyAt(entityIn.blockPosition()), SpawnReason.MOB_SUMMONED, null, null);
                skele.invulnerableTime = 60;
                skele.setPersistenceRequired();
                skele.setTamed(true);
                skele.setAge(0);
                if(entityIn.hasCustomName()) {
                    skele.setCustomName(entityIn.getCustomName());
                }
                skele.setAge(((HorseEntity) entityIn).getAge());
                skele.setCustomNameVisible(entityIn.isCustomNameVisible());
                entityIn.level.addFreshEntity(skele);
            }
            this.doEnchantDamageEffects(this, entityIn);
        }

        return flag;
    }

    @Override
    protected SoundEvent getSwimSound() {
        return SoundEvents.FISH_SWIM;
    }

    @Override
    public void aiStep() {
        if(!this.isInWater() && this.onGround && this.verticalCollision) {
            this.setDeltaMovement(this.getDeltaMovement().add((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F, 0.4F, (this.random.nextFloat() * 2.0F - 1.0F) * 0.05F));
            this.onGround = false;
            this.hasImpulse = true;
            this.playSound(SoundEvents.COD_FLOP, this.getSoundVolume(), this.getVoicePitch());
        }

        super.aiStep();
    }

    @Override
    public EntityTypeContainer<? extends EntityPiranha> getContainer() {
        return ModEntities.PIRANHA;
    }

    @Override
    public EntityTypeContainerContainable<?, ?> getContainableContainer() {
        return ModEntities.PIRANHA;
    }

}
