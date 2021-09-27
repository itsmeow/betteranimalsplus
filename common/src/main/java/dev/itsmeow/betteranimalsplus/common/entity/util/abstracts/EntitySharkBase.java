package dev.itsmeow.betteranimalsplus.common.entity.util.abstracts;

import dev.itsmeow.betteranimalsplus.common.entity.util.IHaveHunger;
import dev.itsmeow.betteranimalsplus.init.ModTriggers;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;

public abstract class EntitySharkBase extends EntityWaterMobPathingWithSelectiveTypes implements Enemy, IHaveHunger<EntityWaterMobPathing> {

    private int hunger = 0;

    public EntitySharkBase(EntityType<? extends EntitySharkBase> type, Level world) {
        super(type, world);
    }

    @Override
    public void positionRider(Entity passenger) {
        if(this.hasPassenger(passenger)) {
            BlockPos pos = this.blockPosition().relative(this.getDirection()).subtract(this.blockPosition());
            pos = pos.offset(pos.getX(), 0, pos.getZ());
            passenger.setPos(this.getX() + this.getDeltaMovement().x() + pos.getX(), this.getY() - (this.getBbHeight() / 2) + this.getDeltaMovement().y(), this.getZ() + this.getDeltaMovement().z() + pos.getZ());
            if (passenger instanceof LivingEntity && (this.getTarget() == null || this.getTarget() != passenger)) {
                this.setTarget((LivingEntity) passenger);
            }
            if (this.level.isClientSide) {
                this.onPassengerTurned(passenger);
            }
        }
    }

    public boolean isPeaceful() {
        return this.level.getDifficulty() == Difficulty.PEACEFUL;
    }

    @Override
    public boolean canRiderInteract() {
        return true;
    }

    @Override
    public boolean shouldRiderSit() {
        return false;
    }

    @Override
    public boolean canBeRiddenInWater(Entity rider) {
        return true;
    }

    @Override
    public boolean doHurtTarget(Entity entityIn) {
        float f = (float) this.getAttribute(Attributes.ATTACK_DAMAGE).getValue();
        int i = 0;

        if (entityIn instanceof LivingEntity) {
            f += EnchantmentHelper.getDamageBonus(this.getMainHandItem(), ((LivingEntity) entityIn).getMobType());
            i += EnchantmentHelper.getKnockbackBonus(this);
        }

        boolean flag = entityIn.hurt(DamageSource.mobAttack(this), f);

        if (flag) {
            if (i > 0) {
                ((Player) entityIn).knockback(i * 0.5F, Mth.sin(this.yRot * 0.017453292F), (-Mth.cos(this.yRot * 0.017453292F)));
            }

            int j = EnchantmentHelper.getFireAspect(this);

            if(j > 0) {
                entityIn.setSecondsOnFire(j * 4);
            }

            if (entityIn instanceof Player) {
                Player entityplayer = (Player) entityIn;
                ItemStack itemstack = this.getMainHandItem();
                ItemStack itemstack1 = entityplayer.isUsingItem() ? entityplayer.getUseItem() : ItemStack.EMPTY;

                if(!itemstack.isEmpty() && !itemstack1.isEmpty() && itemstack.getItem().canDisableShield(itemstack, itemstack1, entityplayer, this) && itemstack1.getItem().isShield(itemstack1, entityplayer)) {
                    float f1 = 0.25F + EnchantmentHelper.getBlockEfficiency(this) * 0.05F;

                    if(this.random.nextFloat() < f1) {
                        entityplayer.getCooldowns().addCooldown(itemstack1.getItem(), 100);
                        this.level.broadcastEntityEvent(entityplayer, (byte) 30);
                    }
                }
            }

            this.doEnchantDamageEffects(this, entityIn);
        }

        return flag;
    }

    @Override
    public void setTarget(LivingEntity entitylivingbaseIn) {
        if(!this.isPeaceful()) {
            if(entitylivingbaseIn instanceof ServerPlayer) {
                ModTriggers.SHARK_TARGETED.trigger((ServerPlayer) entitylivingbaseIn);
            }
            super.setTarget(entitylivingbaseIn);
        }
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
        if(this.tickCount % 20 == 0) {
            this.incrementHunger();
        }
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, CompoundTag compound) {
        this.setInitialHunger();
        return super.finalizeSpawn(world, difficulty, reason, livingdata, compound);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        this.writeHunger(compound);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.readHunger(compound);
    }
}
