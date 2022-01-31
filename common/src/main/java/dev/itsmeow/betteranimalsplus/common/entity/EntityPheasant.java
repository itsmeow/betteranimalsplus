package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.betteranimalsplus.api.ModEventBus;
import dev.itsmeow.betteranimalsplus.common.entity.util.EntityUtil;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalWithTypes;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModItems;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;

public class EntityPheasant extends EntityAnimalWithTypes {

    protected static final EntityDataAccessor<Integer> PECK_TIME = SynchedEntityData.defineId(EntityPheasant.class, EntityDataSerializers.INT);
    public float wingRotation;
    public float destPos;
    public float oFlapSpeed;
    public float oFlap;
    public float wingRotDelta = 0.3F;
    public int timeUntilNextEgg;

    public EntityPheasant(EntityType<? extends EntityPheasant> entityType, Level worldIn) {
        super(entityType, worldIn);
        this.setPeckTime(this.getNewPeck());
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
        this.timeUntilNextEgg = this.random.nextInt(6000) + 6000;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.4D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.0D, Ingredient.of(Items.PUMPKIN_SEEDS), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
    }

    private int getNewPeck() {
        return this.random.nextInt(600) + 30;
    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.oFlap = this.wingRotation;
        this.oFlapSpeed = this.destPos;
        this.destPos = (float) (this.destPos + (this.onGround ? -1 : 4) * 0.3D);
        this.destPos = Mth.clamp(this.destPos, 0.0F, 1.0F);

        if(!this.onGround && this.wingRotDelta < 1.0F) {
            this.wingRotDelta = 0.3F;
        }

        this.wingRotDelta = (float) (this.wingRotDelta * 0.9D);

        if(!this.onGround && this.getDeltaMovement().y() < 0.0D) {
            this.setDeltaMovement(this.getDeltaMovement().x(), this.getDeltaMovement().y() * 0.6D, this.getDeltaMovement().z());
        }

        this.wingRotation += this.wingRotDelta * 2.0F;

        if(!this.onGround || this.getMoveControl().hasWanted()) {
            if(this.getPeckTime() <= 61) {
                this.setPeckTime(80);
            }
        }

        if(!this.level.isClientSide && this.setPeckTime(this.getPeckTime() - 1) <= 0) {
            this.setPeckTime(this.getNewPeck());
        }

        if(!this.level.isClientSide && !this.isBaby() && ModEventBus.LayEggTickEvent.emit(this) && --this.timeUntilNextEgg <= 0) {
            this.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
            this.spawnAtLocation(ModItems.PHEASANT_EGG.get(), 1);
            this.timeUntilNextEgg = this.random.nextInt(6000) + 6000;
        }
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.getItem() == Items.PUMPKIN_SEEDS;
    }

    @Override
    public boolean causeFallDamage(float distance, float damageMultiplier) {
        return false;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.CHICKEN_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.CHICKEN_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.CHICKEN_STEP, 0.15F, 1.0F);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(EntityPheasant.PECK_TIME, 0);
    }

    public int getPeckTime() {
        return this.entityData.get(EntityPheasant.PECK_TIME);
    }

    public int setPeckTime(int time) {
        this.entityData.set(EntityPheasant.PECK_TIME, time);
        return time;
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, SpawnGroupData livingdata, CompoundTag compound) {
        return EntityUtil.childChance(this, reason, super.finalizeSpawn(world, difficulty, reason, livingdata, compound), 0.25F);
    }

    @Override
    protected EntityPheasant getBaseChild() {
        return getContainer().getEntityType().create(level);
    }

    @Override
    public EntityTypeContainer<EntityPheasant> getContainer() {
        return ModEntities.PHEASANT;
    }

}
