package its_meow.betteranimalsplus.common.entity.util.abstracts;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
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
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.EnumSet;

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
        this.rotationVelocity = 1.0F / (this.rand.nextFloat() + 1.0F) * 0.05F;
    }

    @Override
    public void setAttackTarget(LivingEntity entitylivingbaseIn) {
        if(!this.isPeaceful()) {
            super.setAttackTarget(entitylivingbaseIn);
        }
    }

    @Override
    public void livingTick() {
        super.livingTick();
        this.prevSquidPitch = this.squidPitch;
        this.prevSquidYaw = this.squidYaw;
        this.prevSquidRotation = this.squidRotation;
        this.lastTentacleAngle = this.tentacleAngle;
        this.squidRotation += this.rotationVelocity;
        if((double) this.squidRotation > (Math.PI * 2D)) {
            if(this.world.isRemote) {
                this.squidRotation = ((float) Math.PI * 2F);
            } else {
                this.squidRotation = (float) ((double) this.squidRotation - (Math.PI * 2D));
                if(this.rand.nextInt(10) == 0) {
                    this.rotationVelocity = 1.0F / (this.rand.nextFloat() + 1.0F) * 0.2F;
                }
                this.world.setEntityState(this, (byte) 19);
            }
        }
        if(this.isInWaterOrBubbleColumn()) {
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
            if(!this.world.isRemote && this.getNavigator().noPath()) {
                this.setMotion(this.randomMotionVecX * this.randomMotionSpeed, this.randomMotionVecY * this.randomMotionSpeed, this.randomMotionVecZ * this.randomMotionSpeed);
            }
            Vec3d vec3d = this.getMotion();
            float f1 = MathHelper.sqrt(horizontalMag(vec3d));
            this.renderYawOffset += (-((float) MathHelper.atan2(vec3d.x, vec3d.z)) * (180F / (float) Math.PI) - this.renderYawOffset) * 0.1F;
            this.rotationYaw = this.renderYawOffset;
            this.squidYaw = (float) ((double) this.squidYaw + Math.PI * (double) this.rotateSpeed * 1.5D);
            this.squidPitch += (-((float) MathHelper.atan2(f1, vec3d.y)) * (180F / (float) Math.PI) - this.squidPitch) * 0.1F;
        } else {
            this.tentacleAngle = MathHelper.abs(MathHelper.sin(this.squidRotation)) * (float) Math.PI * 0.25F;
            if(!this.world.isRemote) {
                double d0 = this.getMotion().y;
                if(this.isPotionActive(Effects.LEVITATION)) {
                    d0 = 0.05D * (double) (this.getActivePotionEffect(Effects.LEVITATION).getAmplifier() + 1);
                } else if(!this.hasNoGravity()) {
                    d0 -= 0.08D;
                }
                this.setMotion(0.0D, d0 * (double) 0.98F, 0.0D);
            }
            this.squidPitch = (float) ((double) this.squidPitch + (double) (-90.0F - this.squidPitch) * 0.02D);
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if(id == 19) {
            this.squidRotation = 0.0F;
        } else {
            super.handleStatusUpdate(id);
        }
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if(super.attackEntityFrom(source, amount)) {
            this.squirtInk();
            return true;
        }
        return false;
    }

    public boolean isPeaceful() {
        return this.world.getDifficulty() == Difficulty.PEACEFUL;
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        float f = (float) this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue();
        float f1 = (float) this.getAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK).getValue();
        if(entityIn instanceof LivingEntity) {
            f += EnchantmentHelper.getModifierForCreature(this.getHeldItemMainhand(), ((LivingEntity) entityIn).getCreatureAttribute());
            f1 += (float) EnchantmentHelper.getKnockbackModifier(this);
        }
        int i = EnchantmentHelper.getFireAspectModifier(this);
        if(i > 0) {
            entityIn.setFire(i * 4);
        }
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), f);
        if(flag) {
            if(f1 > 0.0F && entityIn instanceof LivingEntity) {
                ((LivingEntity) entityIn).knockBack(this, f1 * 0.5F, MathHelper.sin(this.rotationYaw * ((float) Math.PI / 180F)), -MathHelper.cos(this.rotationYaw * ((float) Math.PI / 180F)));
                this.setMotion(this.getMotion().mul(0.6D, 1.0D, 0.6D));
            }
            if(entityIn instanceof PlayerEntity) {
                PlayerEntity playerentity = (PlayerEntity) entityIn;
                playerentity.addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, 200, 1, false, false));
                ItemStack itemstack = this.getHeldItemMainhand();
                ItemStack itemstack1 = playerentity.isHandActive() ? playerentity.getActiveItemStack() : ItemStack.EMPTY;
                if(!itemstack.isEmpty() && !itemstack1.isEmpty() && itemstack.canDisableShield(itemstack1, playerentity, this) && itemstack1.isShield(playerentity)) {
                    float f2 = 0.25F + (float) EnchantmentHelper.getEfficiencyModifier(this) * 0.05F;
                    if(this.rand.nextFloat() < f2) {
                        playerentity.getCooldownTracker().setCooldown(itemstack.getItem(), 100);
                        this.world.setEntityState(playerentity, (byte) 30);
                    }
                }
            }
            this.applyEnchantments(this, entityIn);
        }
        return flag;
    }

    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return sizeIn.height * 0.5F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SQUID_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_SQUID_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SQUID_DEATH;
    }

    @Override
    protected float getSoundVolume() {
        return 0.4F;
    }

    protected Vec3d getInkAngle(Vec3d vec) {
        Vec3d vec3d = vec.rotatePitch(this.prevSquidPitch * ((float) Math.PI / 180F));
        vec3d = vec3d.rotateYaw(-this.prevRenderYawOffset * ((float) Math.PI / 180F));
        return vec3d;
    }

    protected void squirtInk() {
        this.playSound(SoundEvents.ENTITY_SQUID_SQUIRT, this.getSoundVolume(), this.getSoundPitch());
        Vec3d vec3d = this.getInkAngle(new Vec3d(0.0D, -1.0D, 0.0D)).add(this.getPosX(), this.getPosY(), this.getPosZ());
        for(int i = 0; i < 30; ++i) {
            Vec3d vec3d1 = this.getInkAngle(new Vec3d((double) this.rand.nextFloat() * 0.6D - 0.3D, -1.0D, (double) this.rand.nextFloat() * 0.6D - 0.3D));
            Vec3d vec3d2 = vec3d1.scale(0.3D + (double) (this.rand.nextFloat() * 2.0F));
            ((ServerWorld) this.world).spawnParticle(ParticleTypes.SQUID_INK, vec3d.x, vec3d.y + 0.5D, vec3d.z, 0, vec3d2.x, vec3d2.y, vec3d2.z, 0.1F);
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
            this.setMutexFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        @Override
        public boolean shouldExecute() {
            return cephalopod.getAttackTarget() == null;
        }

        @Override
        public boolean shouldContinueExecuting() {
            return cephalopod.getAttackTarget() == null;
        }

        @Override
        public void tick() {
            int i = this.cephalopod.getIdleTime();
            if(i > 100) {
                this.cephalopod.setMovementVector(0.0F, 0.0F, 0.0F);
            } else if(this.cephalopod.getRNG().nextInt(50) == 0 || !this.cephalopod.inWater || !this.cephalopod.hasMovementVector()) {
                float f = this.cephalopod.getRNG().nextFloat() * ((float) Math.PI * 2F);
                float f1 = MathHelper.cos(f) * 0.2F;
                float f2 = -0.1F + this.cephalopod.getRNG().nextFloat() * 0.2F;
                float f3 = MathHelper.sin(f) * 0.2F;
                this.cephalopod.setMovementVector(f1, f2, f3);
            }

        }
    }

}
