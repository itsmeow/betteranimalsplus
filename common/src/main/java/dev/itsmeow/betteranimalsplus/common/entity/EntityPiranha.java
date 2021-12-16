package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.betteranimalsplus.common.entity.ai.HungerNearestAttackableTargetGoal;
import dev.itsmeow.betteranimalsplus.common.entity.ai.PeacefulNearestAttackableTargetGoal;
import dev.itsmeow.betteranimalsplus.common.entity.util.IHaveHunger;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityWaterMobPathing;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityWaterMobPathingBucketable;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.mixin.DamageSourceInvoker;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.util.EntityTypeContainerContainable;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.animal.horse.SkeletonHorse;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import java.util.function.Predicate;

public class EntityPiranha extends EntityWaterMobPathingBucketable implements IHaveHunger<EntityWaterMobPathing> {

    public final DamageSource PIRANHA_DAMAGE = ((DamageSourceInvoker) new EntityDamageSource("betteranimalsplus.piranha", this)).invokeBypassArmor();
    private int hunger;

    public EntityPiranha(EntityType<? extends EntityPiranha> entityType, Level worldIn) {
        super(entityType, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 1D, true));
        this.goalSelector.addGoal(1, new RandomSwimmingGoal(this, 1D, 1));
        Predicate<LivingEntity> eP = e -> e.getHealth() < e.getMaxHealth();
        this.targetSelector.addGoal(0, new HungerNearestAttackableTargetGoal<>(this, LivingEntity.class, 0, true, false, e -> eP.test(e) && !(e instanceof EntityPiranha) && !(e instanceof Skeleton) && !(e instanceof SkeletonHorse) && !(e instanceof Player)));
        this.targetSelector.addGoal(1, new PeacefulNearestAttackableTargetGoal<>(this, Player.class, true, false));
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

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, SpawnGroupData livingdata, CompoundTag compound) {
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

    @Override
    public boolean doHurtTarget(Entity entityIn) {
        if(super.doHurtTarget(entityIn)) {
            if(entityIn instanceof Player) {
                Player player = (Player) entityIn;
                if(!player.isAlive()) {
                    Skeleton skele = EntityType.SKELETON.create(player.level);
                    skele.setCustomName(player.getName());
                    skele.setCustomNameVisible(true);
                    skele.absMoveTo(player.getX(), player.getY(), player.getZ(), player.getYRot(), player.getXRot());
                    player.level.addFreshEntity(skele);
                }
            } else if(entityIn instanceof Horse && !entityIn.isAlive() && entityIn.level instanceof ServerLevelAccessor) {
                SkeletonHorse skele = EntityType.SKELETON_HORSE.create(entityIn.level);
                skele.absMoveTo(entityIn.getX(), entityIn.getY(), entityIn.getZ(), entityIn.getYRot(), entityIn.getXRot());
                skele.finalizeSpawn((ServerLevelAccessor) entityIn.level, entityIn.level.getCurrentDifficultyAt(entityIn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
                skele.invulnerableTime = 60;
                skele.setPersistenceRequired();
                skele.setTamed(true);
                skele.setAge(0);
                if(entityIn.hasCustomName()) {
                    skele.setCustomName(entityIn.getCustomName());
                }
                skele.setAge(((Horse) entityIn).getAge());
                skele.setCustomNameVisible(entityIn.isCustomNameVisible());
                entityIn.level.addFreshEntity(skele);
            }
            return true;
        }
        return false;
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
