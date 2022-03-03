package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityWaterMobWithTypesBucketable;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.util.EntityTypeContainerContainable;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class EntityJellyfish extends EntityWaterMobWithTypesBucketable {

    protected static final EntityDataAccessor<Float> SIZE = SynchedEntityData.defineId(EntityJellyfish.class, EntityDataSerializers.FLOAT);
    protected int attackCooldown = 0;

    public float jellyYaw;
    public float prevJellyYaw;
    public float jellyRotation;
    public float prevJellyRotation;
    private float randomMotionSpeed;
    private float rotationVelocity;
    private float rotateSpeed;
    private float randomMotionVecX;
    private float randomMotionVecY;
    private float randomMotionVecZ;

    public EntityJellyfish(EntityType<? extends EntityJellyfish> entityType, Level worldIn) {
        super(entityType, worldIn);
        this.setSize(0.8F);
        rotationVelocity = (1.0F / (random.nextFloat() + 1.0F) * 0.2F);
    }

    @Override
    protected MovementEmission getMovementEmission() {
        return MovementEmission.EVENTS;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new AIMoveRandom(this));
    }

    @Override
    public void tick() {
        super.tick();
        if(this.attackCooldown > 0) {
            this.attackCooldown--;
        }
    }

    @Override
    public void aiStep() {
        super.aiStep();

        prevJellyYaw = jellyYaw;
        prevJellyRotation = jellyRotation;

        jellyRotation += rotationVelocity;
        if(jellyRotation > 6.283185307179586D) {
            if(level.isClientSide) {
                jellyRotation = 6.2831855F;
            } else {
                jellyRotation = ((float) (jellyRotation - 6.283185307179586D));
                if(random.nextInt(10) == 0) {
                    rotationVelocity = (1.0F / (random.nextFloat() + 1.0F) * 0.2F);
                }
                level.broadcastEntityEvent(this, (byte) 19);
            }
        }
        if(isInWaterOrBubble()) {
            if(jellyRotation < 3.1415927F) {
                float lvt_1_1_ = jellyRotation / 3.1415927F;
                if(lvt_1_1_ > 0.75D) {
                    randomMotionSpeed = 1.0F;
                    rotateSpeed = 1.0F;
                } else {
                    rotateSpeed *= 0.8F;
                }
            } else {
                randomMotionSpeed *= 0.9F;
                rotateSpeed *= 0.99F;
            }
            if(!level.isClientSide) {
                this.setDeltaMovement((randomMotionVecX * randomMotionSpeed), (randomMotionVecY * randomMotionSpeed), (randomMotionVecZ * randomMotionSpeed));
            }
            yBodyRot += (-(float) Mth.atan2(this.getDeltaMovement().x(), this.getDeltaMovement().z()) * 57.295776F - yBodyRot) * 0.1F;
            this.setYRot(yBodyRot);
            jellyYaw = ((float) (jellyYaw + 3.141592653589793D * rotateSpeed * 1.5D));
        } else {
            if(!level.isClientSide) {
                this.setDeltaMovement(0, this.getDeltaMovement().y(), 0);
                if(hasEffect(MobEffects.LEVITATION)) {
                    this.setDeltaMovement(this.getDeltaMovement().x(), this.getDeltaMovement().y() + 0.05D * (getEffect(MobEffects.LEVITATION).getAmplifier() + 1) - this.getDeltaMovement().y(), this.getDeltaMovement().z());
                } else if(!isNoGravity()) {
                    this.setDeltaMovement(this.getDeltaMovement().x(), this.getDeltaMovement().y() - 0.08D, this.getDeltaMovement().z());
                }
                this.setDeltaMovement(this.getDeltaMovement().x(), this.getDeltaMovement().y() * 0.9800000190734863D, this.getDeltaMovement().z());
            }
        }
    }

    @Override
    public void playerTouch(Player entity) {
        super.playerTouch(entity);
        if(!entity.isCreative() && this.attackCooldown == 0 && entity.level.getDifficulty() != Difficulty.PEACEFUL) {
            entity.hurt(DamageSource.mobAttack(this), 2.0F);
            entity.addEffect(new MobEffectInstance(MobEffects.POISON, 200, 0, false, false));
            entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 90, 2, false, false));
            this.attackCooldown = 80;
        }
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.SLIME_SQUISH;
    }

    @Override
    public void travel(Vec3 vec) {
        move(MoverType.SELF, this.getDeltaMovement());
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void handleEntityEvent(byte p_70103_1_) {
        if(p_70103_1_ == 19) {
            jellyRotation = 0.0F;
        } else {
            super.handleEntityEvent(p_70103_1_);
        }
    }

    public void setMovementVector(float p_175568_1_, float p_175568_2_, float p_175568_3_) {
        randomMotionVecX = p_175568_1_;
        randomMotionVecY = p_175568_2_;
        randomMotionVecZ = p_175568_3_;
    }

    public boolean hasMovementVector() {
        return (randomMotionVecX != 0.0F) || (randomMotionVecY != 0.0F) || (randomMotionVecZ != 0.0F);
    }

    /* NBT AND TYPE CODE: */

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(EntityJellyfish.SIZE, 1F);
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        float size = this.entityData.get(EntityJellyfish.SIZE);
        return EntityDimensions.scalable(size, size).scale(this.getScale());
    }

    public void setSize(float size) {
        this.entityData.set(EntityJellyfish.SIZE, size);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putFloat("Size", this.getDimensions(Pose.STANDING).width);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        float size = compound.getFloat("Size");
        this.setSize(size);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, SpawnGroupData livingdata, CompoundTag compound) {
        livingdata = super.finalizeSpawn(world, difficulty, reason, livingdata, compound);
        if(!this.isBaby()) {
            String i = this.getRandomType().getName();
            float rand = (this.random.nextInt(30) + 1F) / 50F + 0.05F;

            if(livingdata instanceof JellyfishData) {
                i = ((JellyfishData) livingdata).typeData;
                rand = ((JellyfishData) livingdata).size;
            } else {
                livingdata = new JellyfishData(i, rand);
            }

            this.setType(i);
            this.setSize(rand);
        }
        return livingdata;
    }

    public static class JellyfishData implements SpawnGroupData {

        public String typeData;
        public float size;

        public JellyfishData(String type, float size) {
            this.typeData = type;
            this.size = size;
        }
    }

    static class AIMoveRandom extends Goal {

        private final EntityJellyfish entity;

        public AIMoveRandom(EntityJellyfish entityIn) {
            this.entity = entityIn;
        }

        @Override
        public boolean canUse() {
            return true;
        }

        @Override
        public void tick() {
            int i = this.entity.getNoActionTime();

            if(i > 100) {
                this.entity.setMovementVector(0.0F, 0.0F, 0.0F);
            } else if(this.entity.getRandom().nextInt(50) == 0 || !this.entity.wasTouchingWater
            || !this.entity.hasMovementVector()) {
                float f = this.entity.getRandom().nextFloat() * ((float) Math.PI * 2F);
                float f1 = Mth.cos(f) * 0.2F;
                float f2 = -0.1F + this.entity.getRandom().nextFloat() * 0.2F;
                float f3 = Mth.sin(f) * 0.2F;
                this.entity.setMovementVector(f1 / 3, f2 / 3, f3 / 3);
            }
        }
    }

    @Override
    public EntityJellyfish getImplementation() {
        return this;
    }

    @Override
    public EntityTypeContainer<EntityJellyfish> getContainer() {
        return ModEntities.JELLYFISH;
    }

    @Override
    public void setContainerData(ItemStack bucket) {
        super.setContainerData(bucket);
        CompoundTag tag = bucket.getTag();
        tag.putFloat("JellyfishSizeTag", this.entityData.get(EntityJellyfish.SIZE));
        bucket.setTag(tag);
    }

    @Override
    public void readFromContainerTag(CompoundTag tag) {
        super.readFromContainerTag(tag);
        if(tag.contains("JellyfishSizeTag")) {
            this.setSize(tag.getFloat("JellyfishSizeTag"));
        }
    }

    public static void bucketTooltip(EntityTypeContainer<? extends Mob> container, ItemStack stack, Level worldIn, List<Component> tooltip) {
        CompoundTag tag = stack.getTag();
        if(tag != null && tag.contains("JellyfishSizeTag", Tag.TAG_FLOAT)) {
            tooltip.add(new TextComponent("Size: " + tag.getFloat("JellyfishSizeTag")).withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY));
        }
    }

    @Override
    public EntityTypeContainerContainable<?, ?> getContainableContainer() {
        return ModEntities.JELLYFISH;
    }

}
