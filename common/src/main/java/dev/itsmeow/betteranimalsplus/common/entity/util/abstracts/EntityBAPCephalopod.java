package dev.itsmeow.betteranimalsplus.common.entity.util.abstracts;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.EnumSet;

import net.minecraft.entity.ai.goal.Goal.Flag;

public abstract class EntityBAPCephalopod extends EntityWaterMobPathing {

    public float squidPitch;
    public float prevSquidPitch;
    public float squidYaw;
    public float prevSquidYaw;
    public float squidRotation;
    public float prevSquidRotation;
    public float tentacleAngle;
    public float lastTentacleAngle;
    protected float rotationVelocity;
    protected float rotateSpeed;
    protected float randomMotionSpeed;
    protected float randomMotionVecX;
    protected float randomMotionVecY;
    protected float randomMotionVecZ;

    public EntityBAPCephalopod(EntityType<? extends WaterMobEntity> type, World world) {
        super(type, world);
        this.rotationVelocity = 1.0F / (this.random.nextFloat() + 1.0F) * 0.05F;
    }

    @Override
    public void setTarget(LivingEntity entitylivingbaseIn) {
        if(!this.isPeaceful()) {
            super.setTarget(entitylivingbaseIn);
        }
    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.prevSquidPitch = this.squidPitch;
        this.prevSquidYaw = this.squidYaw;
        this.prevSquidRotation = this.squidRotation;
        this.lastTentacleAngle = this.tentacleAngle;
        this.squidRotation += this.rotationVelocity;
        if((double) this.squidRotation > (Math.PI * 2D)) {
            if(this.level.isClientSide) {
                this.squidRotation = ((float) Math.PI * 2F);
            } else {
                this.squidRotation = (float) ((double) this.squidRotation - (Math.PI * 2D));
                if(this.random.nextInt(10) == 0) {
                    this.rotationVelocity = 1.0F / (this.random.nextFloat() + 1.0F) * 0.2F;
                }
                this.level.broadcastEntityEvent(this, (byte) 19);
            }
        }
        if(this.isInWaterOrBubble()) {
            if(this.squidRotation < (float) Math.PI) {
                float f = this.squidRotation / (float) Math.PI;
                this.tentacleAngle = MathHelper.sin(f * f * (float) Math.PI) * (float) Math.PI * 0.25F;
                if((double) f > 0.75D) {
                    this.randomMotionSpeed = 1.0F;
                    this.rotateSpeed = 1.0F;
                } else {
                    this.rotateSpeed *= 0.8F;
                }
            } else {
                this.tentacleAngle = 0.0F;
                this.randomMotionSpeed *= 0.9F;
                this.rotateSpeed *= 0.99F;
            }
            if(!this.level.isClientSide && this.getNavigation().isDone()) {
                this.setDeltaMovement(this.randomMotionVecX * this.randomMotionSpeed, this.randomMotionVecY * this.randomMotionSpeed, this.randomMotionVecZ * this.randomMotionSpeed);
            }
            Vector3d vec3d = this.getDeltaMovement();
            float f1 = MathHelper.sqrt(getHorizontalDistanceSqr(vec3d));
            this.yBodyRot += (-((float) MathHelper.atan2(vec3d.x, vec3d.z)) * (180F / (float) Math.PI) - this.yBodyRot) * 0.1F;
            this.yRot = this.yBodyRot;
            this.squidYaw = (float) ((double) this.squidYaw + Math.PI * (double) this.rotateSpeed * 1.5D);
            this.squidPitch += (-((float) MathHelper.atan2(f1, vec3d.y)) * (180F / (float) Math.PI) - this.squidPitch) * 0.1F;
        } else {
            this.tentacleAngle = MathHelper.abs(MathHelper.sin(this.squidRotation)) * (float) Math.PI * 0.25F;
            if(!this.level.isClientSide) {
                double d0 = this.getDeltaMovement().y;
                if(this.hasEffect(Effects.LEVITATION)) {
                    d0 = 0.05D * (double) (this.getEffect(Effects.LEVITATION).getAmplifier() + 1);
                } else if(!this.isNoGravity()) {
                    d0 -= 0.08D;
                }
                this.setDeltaMovement(0.0D, d0 * (double) 0.98F, 0.0D);
            }
            this.squidPitch = (float) ((double) this.squidPitch + (double) (-90.0F - this.squidPitch) * 0.02D);
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void handleEntityEvent(byte id) {
        if(id == 19) {
            this.squidRotation = 0.0F;
        } else {
            super.handleEntityEvent(id);
        }
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if(super.hurt(source, amount)) {
            this.squirtInk();
            return true;
        }
        return false;
    }

    public boolean isPeaceful() {
        return this.level.getDifficulty() == Difficulty.PEACEFUL;
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
        boolean flag = entityIn.hurt(DamageSource.mobAttack(this), f);
        if(flag) {
            if(f1 > 0.0F && entityIn instanceof LivingEntity) {
                ((LivingEntity) entityIn).knockback(f1 * 0.5F, MathHelper.sin(this.yRot * ((float) Math.PI / 180F)), -MathHelper.cos(this.yRot * ((float) Math.PI / 180F)));
                this.setDeltaMovement(this.getDeltaMovement().multiply(0.6D, 1.0D, 0.6D));
            }
            if(entityIn instanceof PlayerEntity) {
                PlayerEntity playerentity = (PlayerEntity) entityIn;
                playerentity.addEffect(new EffectInstance(Effects.DIG_SLOWDOWN, 200, 1, false, false));
                ItemStack itemstack = this.getMainHandItem();
                ItemStack itemstack1 = playerentity.isUsingItem() ? playerentity.getUseItem() : ItemStack.EMPTY;
                if(!itemstack.isEmpty() && !itemstack1.isEmpty() && itemstack.canDisableShield(itemstack1, playerentity, this) && itemstack1.isShield(playerentity)) {
                    float f2 = 0.25F + (float) EnchantmentHelper.getBlockEfficiency(this) * 0.05F;
                    if(this.random.nextFloat() < f2) {
                        playerentity.getCooldowns().addCooldown(itemstack.getItem(), 100);
                        this.level.broadcastEntityEvent(playerentity, (byte) 30);
                    }
                }
            }
            this.doEnchantDamageEffects(this, entityIn);
        }
        return flag;
    }

    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return sizeIn.height * 0.5F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.SQUID_AMBIENT;
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
    protected float getSoundVolume() {
        return 0.4F;
    }

    protected Vector3d getInkAngle(Vector3d vec) {
        Vector3d vec3d = vec.xRot(this.prevSquidPitch * ((float) Math.PI / 180F));
        vec3d = vec3d.yRot(-this.yBodyRotO * ((float) Math.PI / 180F));
        return vec3d;
    }

    protected void squirtInk() {
        this.playSound(SoundEvents.SQUID_SQUIRT, this.getSoundVolume(), this.getVoicePitch());
        Vector3d vec3d = this.getInkAngle(new Vector3d(0.0D, -1.0D, 0.0D)).add(this.getX(), this.getY(), this.getZ());
        for(int i = 0; i < 30; ++i) {
            Vector3d vec3d1 = this.getInkAngle(new Vector3d((double) this.random.nextFloat() * 0.6D - 0.3D, -1.0D, (double) this.random.nextFloat() * 0.6D - 0.3D));
            Vector3d vec3d2 = vec3d1.scale(0.3D + (double) (this.random.nextFloat() * 2.0F));
            ((ServerWorld) this.level).sendParticles(ParticleTypes.SQUID_INK, vec3d.x, vec3d.y + 0.5D, vec3d.z, 0, vec3d2.x, vec3d2.y, vec3d2.z, 0.1F);
        }
    }

    public void setMovementVector(float x, float y, float z) {
        this.randomMotionVecX = x;
        this.randomMotionVecY = y;
        this.randomMotionVecZ = z;
    }

    public boolean hasMovementVector() {
        return this.randomMotionVecX != 0.0F || this.randomMotionVecY != 0.0F || this.randomMotionVecZ != 0.0F;
    }

    public static class MoveRandomGoal extends Goal {
        private final EntityBAPCephalopod cephalopod;

        public MoveRandomGoal(EntityBAPCephalopod squid) {
            this.cephalopod = squid;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            return cephalopod.getTarget() == null;
        }

        @Override
        public boolean canContinueToUse() {
            return cephalopod.getTarget() == null;
        }

        @Override
        public void tick() {
            int i = this.cephalopod.getNoActionTime();
            if(i > 100) {
                this.cephalopod.setMovementVector(0.0F, 0.0F, 0.0F);
            } else if(this.cephalopod.getRandom().nextInt(50) == 0 || !this.cephalopod.wasTouchingWater || !this.cephalopod.hasMovementVector()) {
                float f = this.cephalopod.getRandom().nextFloat() * ((float) Math.PI * 2F);
                float f1 = MathHelper.cos(f) * 0.2F;
                float f2 = -0.1F + this.cephalopod.getRandom().nextFloat() * 0.2F;
                float f3 = MathHelper.sin(f) * 0.2F;
                this.cephalopod.setMovementVector(f1, f2, f3);
            }

        }
    }

}
