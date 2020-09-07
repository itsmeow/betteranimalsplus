package its_meow.betteranimalsplus.common.entity;

import javax.annotation.Nullable;

import its_meow.betteranimalsplus.common.entity.util.EntityTypeContainerBAP;
import its_meow.betteranimalsplus.common.entity.util.EntityUtil;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalWithTypes;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModItems;
import its_meow.betteranimalsplus.init.ModLootTables;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
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
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EntityTurkey extends EntityAnimalWithTypes {

    protected static final DataParameter<Integer> PECK_TIME = EntityDataManager.<Integer>createKey(EntityTurkey.class, DataSerializers.VARINT);
    protected static final DataParameter<Boolean> ATTACKING = EntityDataManager.<Boolean>createKey(EntityTurkey.class, DataSerializers.BOOLEAN);
    public float wingRotation;
    public float destPos;
    public float oFlapSpeed;
    public float oFlap;
    public float wingRotDelta = 0.3F;
    public int timeUntilNextEgg;
    public int attacksLeft = 0;
    public int lastAttackTime = 0;

    public EntityTurkey(World worldIn) {
        super(ModEntities.TURKEY.entityType, worldIn);
        this.setPeckTime(this.getNewPeck());
        this.setPathPriority(PathNodeType.WATER, 0.0F);
        this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.1D, false) {
            @Override
            public void startExecuting() {
                attacksLeft = this.attacker.getRNG().nextInt(2) + 1;
                super.startExecuting();
            }

            @Override
            public boolean shouldExecute() {
                return super.shouldExecute() && this.attacker.ticksExisted - lastAttackTime > 300;
            }

            @Override
            public boolean shouldContinueExecuting() {
                return attacksLeft > 0 && super.shouldContinueExecuting();
            }

            @Override
            protected void checkAndPerformAttack(LivingEntity p_190102_1_, double p_190102_2_) {
                if(attacksLeft > 0) {
                    super.checkAndPerformAttack(p_190102_1_, p_190102_2_);
                } else {
                    this.resetTask();
                }
            }

            @Override
            public void resetTask() {
                super.resetTask();
                if(attacksLeft <= 0) {
                    this.attacker.setAttackTarget(null);
                }
            }
        });
        this.goalSelector.addGoal(2, new PanicGoal(this, 1.4D) {
            @Override
            public boolean shouldExecute() {
                return this.creature.getAttackTarget() == null && super.shouldExecute();
            }
        });
        this.goalSelector.addGoal(3, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.0D, Ingredient.fromItems(Items.PUMPKIN_SEEDS), false));
        this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.targetSelector.addGoal(0, new HurtByTargetGoal(this, new Class[0]));
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.5D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1D);
    }

    @Override
    public void setAttackTarget(LivingEntity entity) {
        this.setTailUp(entity != null);
        super.setAttackTarget(entity);
    }

    public boolean isTailUp() {
        return this.dataManager.get(ATTACKING).booleanValue();
    }

    public void setTailUp(boolean in) {
        this.dataManager.set(ATTACKING, Boolean.valueOf(in));
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        if(attacksLeft > 0) {
            attacksLeft--;
        }
        float f = (float) this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue();
        this.lastAttackTime = this.ticksExisted;
        return entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), f);
    }

    private int getNewPeck() {
        return this.rand.nextInt(600) + 30;
    }

    @Override
    public void livingTick() {
        super.livingTick();
        this.oFlap = this.wingRotation;
        this.oFlapSpeed = this.destPos;
        this.destPos = (float) (this.destPos + (this.onGround ? -1 : 4) * 0.3D);
        this.destPos = MathHelper.clamp(this.destPos, 0.0F, 1.0F);

        if(!this.onGround && this.wingRotDelta < 1.0F) {
            this.wingRotDelta = 0.3F;
        }

        this.wingRotDelta = (float) (this.wingRotDelta * 0.9D);

        if(!this.onGround && this.getMotion().getY() < 0.0D) {
            this.setMotion(this.getMotion().getX(), this.getMotion().getY() * 0.6D, this.getMotion().getZ());
        }

        this.wingRotation += this.wingRotDelta * 2.0F;

        if(!this.onGround || this.getMoveHelper().isUpdating() || this.getAttackTarget() != null) {
            if(this.getPeckTime() <= 61) {
                this.setPeckTime(80);
            }
        }

        if(!this.world.isRemote && this.setPeckTime(this.getPeckTime() - 1) <= 0) {
            this.setPeckTime(this.getNewPeck());
        }

        if(!this.world.isRemote && !this.isChild() && --this.timeUntilNextEgg <= 0) {
            this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            this.entityDropItem(ModItems.TURKEY_EGG, 1);
            this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
        }
        if(!world.isRemote) {
            if(this.isInLove() && !this.isTailUp()) {
                this.setTailUp(true);
            }
            if(!this.isInLove() && this.getAttackTarget() == null && this.isTailUp()) {
                this.setTailUp(false);
            }
        }
    }

    public boolean isBreedingItem(ItemStack stack) {
        return stack.getItem() == Items.PUMPKIN_SEEDS;
    }

    @Override
    public void fall(float distance, float damageMultiplier) {
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_CHICKEN_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_CHICKEN_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_CHICKEN_STEP, 0.15F, 1.0F);
    }

    @Override
    @Nullable
    protected ResourceLocation getLootTable() {
        return ModLootTables.TURKEY;
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(PECK_TIME, Integer.valueOf(0));
        this.dataManager.register(ATTACKING, Boolean.valueOf(false));
    }

    public int getPeckTime() {
        return this.dataManager.get(PECK_TIME).intValue();
    }

    public int setPeckTime(int time) {
        this.dataManager.set(PECK_TIME, Integer.valueOf(time));
        return time;
    }

    @Override
    protected EntityTurkey getBaseChild() {
        return new EntityTurkey(this.world);
    }

    @Override
    public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, ILivingEntityData livingdata, CompoundNBT compound) {
        EntityUtil.childChance(this, reason, livingdata, 0.25F);
        return super.onInitialSpawn(world, difficulty, reason, livingdata, compound);
    }

    @Override
    public EntityTypeContainerBAP<EntityTurkey> getContainer() {
        return ModEntities.TURKEY;
    }

}
