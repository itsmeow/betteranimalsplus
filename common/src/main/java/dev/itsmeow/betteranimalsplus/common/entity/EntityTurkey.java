package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.betteranimalsplus.common.entity.util.EntityUtil;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalWithTypes;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModItems;
import dev.itsmeow.betteranimalsplus.init.ModLootTables;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

public class EntityTurkey extends EntityAnimalWithTypes {

    protected static final DataParameter<Integer> PECK_TIME = EntityDataManager.defineId(EntityTurkey.class, DataSerializers.INT);
    protected static final DataParameter<Boolean> ATTACKING = EntityDataManager.defineId(EntityTurkey.class, DataSerializers.BOOLEAN);
    public float wingRotation;
    public float destPos;
    public float oFlapSpeed;
    public float oFlap;
    public float wingRotDelta = 0.3F;
    public int timeUntilNextEgg;
    public int attacksLeft = 0;
    public int lastAttackTime = 0;

    public EntityTurkey(EntityType<? extends EntityTurkey> entityType, World worldIn) {
        super(entityType, worldIn);
        this.setPeckTime(this.getNewPeck());
        this.setPathfindingMalus(PathNodeType.WATER, 0.0F);
        this.timeUntilNextEgg = this.random.nextInt(6000) + 6000;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.1D, false) {
            @Override
            public void start() {
                attacksLeft = this.mob.getRandom().nextInt(2) + 1;
                super.start();
            }

            @Override
            public boolean canUse() {
                return super.canUse() && this.mob.tickCount - lastAttackTime > 300;
            }

            @Override
            public boolean canContinueToUse() {
                return attacksLeft > 0 && super.canContinueToUse();
            }

            @Override
            protected void checkAndPerformAttack(LivingEntity p_190102_1_, double p_190102_2_) {
                if(attacksLeft > 0) {
                    super.checkAndPerformAttack(p_190102_1_, p_190102_2_);
                } else {
                    this.stop();
                }
            }

            @Override
            public void stop() {
                super.stop();
                if(attacksLeft <= 0) {
                    this.mob.setTarget(null);
                }
            }
        });
        this.goalSelector.addGoal(2, new PanicGoal(this, 1.4D) {
            @Override
            public boolean canUse() {
                return this.mob.getTarget() == null && super.canUse();
            }
        });
        this.goalSelector.addGoal(3, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.0D, Ingredient.of(Items.PUMPKIN_SEEDS), false));
        this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.targetSelector.addGoal(0, new HurtByTargetGoal(this));
    }

    @Override
    public void setTarget(LivingEntity entity) {
        this.setTailUp(entity != null);
        super.setTarget(entity);
    }

    public boolean isTailUp() {
        return this.entityData.get(ATTACKING);
    }

    public void setTailUp(boolean in) {
        this.entityData.set(ATTACKING, in);
    }

    @Override
    public boolean doHurtTarget(Entity entityIn) {
        if(attacksLeft > 0) {
            attacksLeft--;
        }
        float f = (float) this.getAttribute(Attributes.ATTACK_DAMAGE).getValue();
        this.lastAttackTime = this.tickCount;
        return entityIn.hurt(DamageSource.mobAttack(this), f);
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
        this.destPos = MathHelper.clamp(this.destPos, 0.0F, 1.0F);

        if(!this.onGround && this.wingRotDelta < 1.0F) {
            this.wingRotDelta = 0.3F;
        }

        this.wingRotDelta = (float) (this.wingRotDelta * 0.9D);

        if(!this.onGround && this.getDeltaMovement().y() < 0.0D) {
            this.setDeltaMovement(this.getDeltaMovement().x(), this.getDeltaMovement().y() * 0.6D, this.getDeltaMovement().z());
        }

        this.wingRotation += this.wingRotDelta * 2.0F;

        if(!this.onGround || this.getMoveControl().hasWanted() || this.getTarget() != null) {
            if(this.getPeckTime() <= 61) {
                this.setPeckTime(80);
            }
        }

        if(!this.level.isClientSide && this.setPeckTime(this.getPeckTime() - 1) <= 0) {
            this.setPeckTime(this.getNewPeck());
        }

        if(!this.level.isClientSide && !this.isBaby() && --this.timeUntilNextEgg <= 0) {
            this.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
            this.spawnAtLocation(ModItems.TURKEY_EGG.get(), 1);
            this.timeUntilNextEgg = this.random.nextInt(6000) + 6000;
        }
        if(!level.isClientSide) {
            if(this.isInLove() && !this.isTailUp()) {
                this.setTailUp(true);
            }
            if(!this.isInLove() && this.getTarget() == null && this.isTailUp()) {
                this.setTailUp(false);
            }
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
    protected ResourceLocation getDefaultLootTable() {
        return ModLootTables.TURKEY;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(PECK_TIME, 0);
        this.entityData.define(ATTACKING, Boolean.FALSE);
    }

    public int getPeckTime() {
        return this.entityData.get(PECK_TIME);
    }

    public int setPeckTime(int time) {
        this.entityData.set(PECK_TIME, time);
        return time;
    }

    @Override
    protected EntityTurkey getBaseChild() {
        return getContainer().getEntityType().create(level);
    }

    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, ILivingEntityData livingdata, CompoundNBT compound) {
        return EntityUtil.childChance(this, reason, super.finalizeSpawn(world, difficulty, reason, livingdata, compound), 0.25F);
    }

    @Override
    public EntityTypeContainer<EntityTurkey> getContainer() {
        return ModEntities.TURKEY;
    }

}
