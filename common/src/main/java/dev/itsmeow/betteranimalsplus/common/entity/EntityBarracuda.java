package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.util.EntityTypeContainerContainable;
import dev.itsmeow.betteranimalsplus.common.entity.ai.HungerNearestAttackableTargetGoal;
import dev.itsmeow.betteranimalsplus.common.entity.ai.PeacefulNearestAttackableTargetGoal;
import dev.itsmeow.betteranimalsplus.common.entity.util.IHaveHunger;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityWaterMobPathing;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityWaterMobPathingBucketable;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModLootTables;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.*;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.EnumSet;

import net.minecraft.entity.ai.goal.Goal.Flag;

public class EntityBarracuda extends EntityWaterMobPathingBucketable implements IHaveHunger<EntityWaterMobPathing> {

    private int hunger = 0;

    public EntityBarracuda(EntityType<? extends EntityBarracuda> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new RushAttackGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 0.8D, false));
        this.goalSelector.addGoal(2, new LookAtGoal(this, WaterMobEntity.class, 10.0F));
        this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(3, new RandomSwimmingGoal(this, 0.5D, 1));
        this.targetSelector.addGoal(0, new HurtByTargetGoal(this) {
            @Override
            public boolean canUse() {
                return EntityBarracuda.this.level.getDifficulty() != Difficulty.PEACEFUL && super.canUse();
            }
        });
        this.targetSelector.addGoal(1, new HungerNearestAttackableTargetGoal<>(this, WaterMobEntity.class, 100, true, true, e -> !(e instanceof IMob) && !(e instanceof EntityBarracuda)));
        this.targetSelector.addGoal(1, new PeacefulNearestAttackableTargetGoal<>(this, PlayerEntity.class, 100, true, true, EntityBarracuda::isWearingShiny));
    }

    public static boolean isWearingShiny(LivingEntity e) {
        if(e instanceof PlayerEntity) {
            for(ItemStack stack : e.getArmorSlots()) {
                if(stack.getItem() instanceof ArmorItem) {
                    ArmorItem i = (ArmorItem) stack.getItem();
                    IArmorMaterial mat = i.getMaterial();
                    if(mat == ArmorMaterial.CHAIN || mat == ArmorMaterial.DIAMOND || mat == ArmorMaterial.GOLD || mat == ArmorMaterial.IRON) {
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
    public void aiStep() {
        if(!this.isInWater() && this.onGround && this.verticalCollision) {
            this.setDeltaMovement(this.getDeltaMovement().add((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F, 0.4F, (this.random.nextFloat() * 2.0F - 1.0F) * 0.05F));
            this.onGround = false;
            this.hasImpulse = true;
            this.playSound(this.getFlopSound(), this.getSoundVolume(), this.getVoicePitch());
        }
        super.aiStep();
    }

    @Override
    protected ResourceLocation getDefaultLootTable() {
        return ModLootTables.DROPS_COD;
    }

    protected SoundEvent getFlopSound() {
        return SoundEvents.COD_FLOP;
    }

    @Override
    public ActionResultType mobInteract(PlayerEntity player, Hand hand) {
        if(player != this.getTarget()) {
            return super.mobInteract(player, hand);
        } else {
            return ActionResultType.PASS;
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
            if(e.level instanceof ServerWorld) {
                ServerWorld world = (ServerWorld) e.level;
                world.sendParticles(ParticleTypes.BUBBLE, e.getX(), e.getY() + 0.5D, e.getZ(), 5, 0.25D, 0.5D, 0.25D, 0D);
            }
        }

    }
}
