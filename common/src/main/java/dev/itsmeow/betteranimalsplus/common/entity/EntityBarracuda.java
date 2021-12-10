package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.betteranimalsplus.common.entity.ai.HungerNearestAttackableTargetGoal;
import dev.itsmeow.betteranimalsplus.common.entity.ai.PeacefulNearestAttackableTargetGoal;
import dev.itsmeow.betteranimalsplus.common.entity.util.IHaveHunger;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityWaterMobPathing;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityWaterMobPathingBucketable;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.util.EntityTypeContainerContainable;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import java.util.EnumSet;

public class EntityBarracuda extends EntityWaterMobPathingBucketable implements IHaveHunger<EntityWaterMobPathing> {

    private int hunger = 0;

    public EntityBarracuda(EntityType<? extends EntityBarracuda> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new RushAttackGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 0.8D, false));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, WaterAnimal.class, 10.0F));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(3, new RandomSwimmingGoal(this, 0.5D, 1));
        this.targetSelector.addGoal(0, new HurtByTargetGoal(this) {
            @Override
            public boolean canUse() {
                return EntityBarracuda.this.level.getDifficulty() != Difficulty.PEACEFUL && super.canUse();
            }
        });
        this.targetSelector.addGoal(1, new HungerNearestAttackableTargetGoal<>(this, WaterAnimal.class, 100, true, true, e -> !(e instanceof Enemy) && !(e instanceof EntityBarracuda)));
        this.targetSelector.addGoal(1, new PeacefulNearestAttackableTargetGoal<>(this, Player.class, 100, true, true, EntityBarracuda::isWearingShiny));
    }

    public static boolean isWearingShiny(LivingEntity e) {
        if(e instanceof Player) {
            for(ItemStack stack : e.getArmorSlots()) {
                if(stack.getItem() instanceof ArmorItem) {
                    ArmorItem i = (ArmorItem) stack.getItem();
                    ArmorMaterial mat = i.getMaterial();
                    if(mat == ArmorMaterials.CHAIN || mat == ArmorMaterials.DIAMOND || mat == ArmorMaterials.GOLD || mat == ArmorMaterials.IRON) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            return true;
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
    public void aiStep() {
        if(!this.isInWater() && this.onGround && this.verticalCollision) {
            this.setDeltaMovement(this.getDeltaMovement().add((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F, 0.4F, (this.random.nextFloat() * 2.0F - 1.0F) * 0.05F));
            this.onGround = false;
            this.hasImpulse = true;
            this.playSound(this.getFlopSound(), this.getSoundVolume(), this.getVoicePitch());
        }
        super.aiStep();
    }

    protected SoundEvent getFlopSound() {
        return SoundEvents.COD_FLOP;
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if(player != this.getTarget()) {
            return super.mobInteract(player, hand);
        } else {
            return InteractionResult.PASS;
        }
    }

    @Override
    public EntityTypeContainer<? extends EntityBarracuda> getContainer() {
        return ModEntities.BARRACUDA;
    }

    @Override
    public EntityTypeContainerContainable<?, ?> getContainableContainer() {
        return ModEntities.BARRACUDA;
    }

    public static class RushAttackGoal extends Goal {

        protected EntityBarracuda e;
        protected boolean done = false;

        public RushAttackGoal(EntityBarracuda e) {
            this.e = e;
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            return this.canContinueToUse() && e.position().distanceTo(e.getTarget().position()) >= 8D;
        }

        @Override
        public boolean canContinueToUse() {
            return !done && e.getTarget() != null && e.getTarget().isAlive() && EntityBarracuda.isWearingShiny(e);
        }

        @Override
        public void start() {
            // rush!
            e.getNavigation().moveTo(e.getTarget(), 10D);
        }

        @Override
        public void stop() {
            done = false;
        }

        @Override
        public void tick() {
            e.getNavigation().moveTo(e.getTarget(), 10D);
            e.setDeltaMovement(e.getDeltaMovement().add(0, -0.005D, 0));
            // attack 5HP when close and then move to regular attack
            if(e.position().distanceTo(e.getTarget().position()) < 1.5D) {
                done = true;
                e.getTarget().hurt(DamageSource.mobAttack(e), 5F);
            }
            if(e.level instanceof ServerLevel) {
                ServerLevel world = (ServerLevel) e.level;
                world.sendParticles(ParticleTypes.BUBBLE, e.getX(), e.getY() + 0.5D, e.getZ(), 5, 0.25D, 0.5D, 0.25D, 0D);
            }
        }

    }
}
