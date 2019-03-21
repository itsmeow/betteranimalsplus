package its_meow.betteranimalsplus.common.entity;

import javax.annotation.Nullable;

import com.google.common.base.Predicates;

import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModLootTables;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EntityBear extends EntityMob {

    private int warningSoundTicks;

    public EntityBear(World worldIn) {
        super(ModEntities.getEntityType(EntityBear.class), worldIn);
        this.setSize(2F, 2F);
    }

    public EntityBear(EntityType<?> type, World worldIn) {
        super(type, worldIn);
        this.setSize(2F, 2F);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityBear.AIMeleeAttack());
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityBear.AIHurtByTarget());
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<EntityPlayer>(this, EntityPlayer.class, 90,
                true, true, Predicates.alwaysTrue()));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<EntityDeer>(this, EntityDeer.class, 90, true,
                true, Predicates.alwaysTrue()));
        this.targetTasks.addTask(4, new EntityAINearestAttackableTarget<EntityPig>(this, EntityPig.class, 90, true,
                true, Predicates.alwaysTrue()));
        this.targetTasks.addTask(5, new EntityAINearestAttackableTarget<EntityChicken>(this, EntityChicken.class, 90,
                true, true, Predicates.alwaysTrue()));
        this.targetTasks.addTask(6, new EntityAINearestAttackableTarget<EntityRabbit>(this, EntityRabbit.class, 90,
                true, true, Predicates.alwaysTrue()));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<EntityFox>(this, EntityFox.class, 90, true,
                true, Predicates.alwaysTrue()));
        this.targetTasks.addTask(5, new EntityAINearestAttackableTarget<EntityPheasant>(this, EntityPheasant.class, 90,
                true, true, Predicates.alwaysTrue()));
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
        this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_SPEED);
        this.getAttribute(SharedMonsterAttributes.ATTACK_SPEED).setBaseValue(1D);
    }

    @Override
    @Nullable
    protected ResourceLocation getLootTable() {
        return ModLootTables.bear;
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this
     * entity.
     */
    @Override
    public boolean canSpawn(IWorld world, boolean b) {
        return this.world.getDifficulty() != EnumDifficulty.PEACEFUL;
    }

    /**
     * Called when the entity is attacked.
     */
    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else {
            Entity entity = source.getTrueSource();

            if (entity instanceof EntityPlayer) {
                this.setAttackTarget((EntityPlayer) entity);
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
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        return false;
    }

    @Override
    public boolean isPreventingPlayerRest(EntityPlayer playerIn) {
        return this.world.getDifficulty() != EnumDifficulty.PEACEFUL && this.getAttackingEntity() == playerIn;
    }

    public class AIHurtByTarget extends EntityAIHurtByTarget {

        public AIHurtByTarget() {
            super(EntityBear.this, false);
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        @Override
        public void startExecuting() {
            super.startExecuting();

        }

        @Override
        protected void setEntityAttackTarget(EntityCreature creatureIn, EntityLivingBase entityLivingBaseIn) {
            if (creatureIn instanceof EntityBear) {
                super.setEntityAttackTarget(creatureIn, entityLivingBaseIn);
            }
        }
    }

    public class AIMeleeAttack extends EntityAIAttackMelee {

        public AIMeleeAttack() {
            super(EntityBear.this, 1.25D, true);
        }

        @Override
        protected void checkAndPerformAttack(EntityLivingBase p_190102_1_, double p_190102_2_) {
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
        protected double getAttackReachSqr(EntityLivingBase attackTarget) {
            return 10.0F + attackTarget.width;
        }
    }

    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData entityLivingData,
            NBTTagCompound itemNbt) {
        this.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0F);
        return super.onInitialSpawn(difficulty, entityLivingData, itemNbt);
    }

}
