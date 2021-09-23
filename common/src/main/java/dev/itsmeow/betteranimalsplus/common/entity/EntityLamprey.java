package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.util.EntityTypeContainerContainable;
import dev.itsmeow.betteranimalsplus.common.entity.ai.EfficientMoveTowardsTargetGoal;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityWaterMobPathingWithTypesBucketable;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModLootTables;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.SSetPassengersPacket;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

import java.util.HashSet;
import java.util.Set;

public class EntityLamprey extends EntityWaterMobPathingWithTypesBucketable implements IMob {

    protected int lastAttack = 0;

    public EntityLamprey(EntityType<? extends EntityLamprey> entityType, World worldIn) {
        super(entityType, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new EfficientMoveTowardsTargetGoal(this, 0.8D, false));
        this.goalSelector.addGoal(1, new LookAtGoal(this, WaterMobEntity.class, 10.0F));
        this.goalSelector.addGoal(1, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(2, new RandomSwimmingGoal(this, 0.5D, 1));
        Set<Class<? extends LivingEntity>> blackList = new HashSet<>();
        blackList.add(SkeletonEntity.class);
        blackList.add(EndermanEntity.class);
        blackList.add(EntityJellyfish.class);
        blackList.add(EntityBobbitWorm.class);
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 100, true, true, e -> !(e instanceof IMob) && !(e.level.getDifficulty() == Difficulty.PEACEFUL && e instanceof PlayerEntity) && !blackList.contains(e.getClass())));
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
    public boolean doHurtTarget(Entity entityIn) {
        float f = (float)this.getAttribute(Attributes.ATTACK_DAMAGE).getValue();

        if(entityIn instanceof LivingEntity) {
            f += EnchantmentHelper.getDamageBonus(this.getMainHandItem(), ((LivingEntity)entityIn).getMobType());
        }
        boolean flag = entityIn.hurt(DamageSource.mobAttack(this), f);
        if(flag) {
            this.lastAttack = this.tickCount;
            if(entityIn instanceof PlayerEntity) {
                PlayerEntity entityplayer = (PlayerEntity)entityIn;

                int weakTicks = 0;
                if (this.level.getDifficulty() == Difficulty.EASY) {
                    weakTicks = 200;
                } else if (this.level.getDifficulty() == Difficulty.NORMAL) {
                    weakTicks = 300;
                } else if (this.level.getDifficulty() == Difficulty.HARD) {
                    weakTicks = 600;
                }
                entityplayer.addEffect(new EffectInstance(Effects.WEAKNESS, weakTicks, 1, false, false));
                ItemStack itemstack = this.getMainHandItem();
                ItemStack itemstack1 = entityplayer.isUsingItem() ? entityplayer.getUseItem() : ItemStack.EMPTY;
                if(!itemstack.isEmpty() && !itemstack1.isEmpty() && itemstack.getItem().canDisableShield(itemstack, itemstack1, entityplayer, this) && itemstack1.getItem().isShield(itemstack1, entityplayer)) {
                    float f1 = 0.25F + (float)EnchantmentHelper.getBlockEfficiency(this) * 0.05F;
                    if(this.random.nextFloat() < f1) {
                        entityplayer.getCooldowns().addCooldown(itemstack1.getItem(), 100);
                        this.level.broadcastEntityEvent(entityplayer, (byte)30);
                    }
                }
            }
            this.doEnchantDamageEffects(this, entityIn);
        }
        return flag;
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
            if((entity.canBeRiddenInWater(this) || this.getTarget() == null) && this.level.isAreaLoaded(this.blockPosition(), 10)) {
                super.stopRiding();
            }
        }
    }

    @Override
    public boolean canBeRiddenInWater(Entity rider) {
        return true;
    }

    public void grabTarget(Entity entity) {
        if(entity == this.getTarget() && !entity.hasPassenger(this) && this.wasTouchingWater) {
            this.startRiding(entity);
            if(entity instanceof ServerPlayerEntity) {
               ((ServerPlayerEntity) entity).connection.send(new SSetPassengersPacket(entity));
            }
        }
    }

    @Override
    public boolean shouldRiderSit() {
        return false;
    }

    @Override
    public double getMyRidingOffset() {
        if(getVehicle() != null && getVehicle() instanceof PlayerEntity) {
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
    
    @Override
    public boolean canRiderInteract() {
        return true;
    }

    @Override
    protected ResourceLocation getDefaultLootTable() {
        return ModLootTables.EELY;
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