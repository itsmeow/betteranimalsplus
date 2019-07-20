package its_meow.betteranimalsplus.common.entity;

import javax.annotation.Nullable;

import com.google.common.base.Predicates;

import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModLootTables;
import its_meow.betteranimalsplus.util.HeadTypes;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EntityBear extends MonsterEntity {

    private int warningSoundTicks;

    public EntityBear(World worldIn) {
        super(ModEntities.getEntityType("brownbear"), worldIn);
    }

    public EntityBear(EntityType<? extends EntityBear> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new EntityBear.AIMeleeAttack());
        this.goalSelector.addGoal(5, new RandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, EntityBear.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<PlayerEntity>(this, PlayerEntity.class, 90,
        true, true, Predicates.alwaysTrue()));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<EntityDeer>(this, EntityDeer.class, 90, true,
        true, Predicates.alwaysTrue()));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<PigEntity>(this, PigEntity.class, 90, true,
        true, Predicates.alwaysTrue()));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<ChickenEntity>(this, ChickenEntity.class, 90,
        true, true, Predicates.alwaysTrue()));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<RabbitEntity>(this, RabbitEntity.class, 90,
        true, true, Predicates.alwaysTrue()));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<EntityPheasant>(this, EntityPheasant.class, 90,
        true, true, Predicates.alwaysTrue()));
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
        this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_SPEED);
        this.getAttribute(SharedMonsterAttributes.ATTACK_SPEED).setBaseValue(1D);
    }

    @Override
    @Nullable
    protected ResourceLocation getLootTable() {
        return ModLootTables.bear;
    }

    public boolean canSpawn(IWorld p_213380_1_, SpawnReason p_213380_2_) {
        return p_213380_1_.getDifficulty() != Difficulty.PEACEFUL;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else {
            Entity entity = source.getTrueSource();

            if (entity instanceof PlayerEntity) {
                this.setAttackTarget((PlayerEntity) entity);
                this.playWarningSound();
            }

            return super.attackEntityFrom(source, amount);
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.warningSoundTicks > 0) {
            --this.warningSoundTicks;
        }
    }

    protected void playWarningSound() {
        if (this.warningSoundTicks <= 0) {
            this.playSound(SoundEvents.ENTITY_POLAR_BEAR_WARNING, 1.0F, 1.0F);
            this.warningSoundTicks = 40;
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_POLAR_BEAR_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_POLAR_BEAR_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_POLAR_BEAR_DEATH;
    }

    protected void playStepSound(BlockPos pos, Block blockIn) {
        this.playSound(SoundEvents.ENTITY_POLAR_BEAR_STEP, 0.15F, 1.0F);
    }

    @Override
    public boolean processInteract(PlayerEntity player, Hand hand) {
        return false;
    }

    @Override
    public boolean isPreventingPlayerRest(PlayerEntity playerIn) {
        return this.world.getDifficulty() != Difficulty.PEACEFUL && this.getAttackingEntity() == playerIn;
    }

    public class AIMeleeAttack extends MeleeAttackGoal {

        public AIMeleeAttack() {
            super(EntityBear.this, 1.25D, true);
        }

        @Override
        protected void checkAndPerformAttack(LivingEntity p_190102_1_, double p_190102_2_) {
            double d0 = this.getAttackReachSqr(p_190102_1_);

            if (p_190102_2_ <= d0 && this.attackTick <= 0) {
                this.attackTick = 20;
                this.attacker.attackEntityAsMob(p_190102_1_);
            } else if (p_190102_2_ <= d0 * 2.0D) {
                if (this.attackTick <= 0) {
                    this.attackTick = 20;
                }

                if (this.attackTick <= 10) {
                    EntityBear.this.playWarningSound();
                }
            } else {
                this.attackTick = 20;
            }
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by
         * another one
         */
        @Override
        public void resetTask() {
            super.resetTask();
        }

        @Override
        protected double getAttackReachSqr(LivingEntity attackTarget) {
            return 10.0F + attackTarget.getWidth();
        }
    }

    @Override
    public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, ILivingEntityData entityLivingData,
    CompoundNBT itemNbt) {
        this.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0F);
        return super.onInitialSpawn(world, difficulty, reason, entityLivingData, itemNbt);
    }
    
    @Override
    public void onDeath(DamageSource cause) {
        super.onDeath(cause);
        if (!world.isRemote && !this.isChild()) {
            if (this.rand.nextInt(12) == 0) {
                ItemStack stack = new ItemStack(HeadTypes.BEARHEAD.getItem(1));
                this.entityDropItem(stack, 0.5F);
            }
        }
    }

}
