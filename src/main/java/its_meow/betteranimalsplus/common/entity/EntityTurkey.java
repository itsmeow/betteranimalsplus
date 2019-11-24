package its_meow.betteranimalsplus.common.entity;

import javax.annotation.Nullable;

import its_meow.betteranimalsplus.init.ModItems;
import its_meow.betteranimalsplus.init.ModLootTables;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
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
        super(worldIn);
        this.setPeckTime(this.getNewPeck());
        this.setPathPriority(PathNodeType.WATER, 0.0F);
        this.setSize(1F, this.isChild() ? 0.8F : 1F);
        this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.1D, false) {
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

            protected void checkAndPerformAttack(EntityLivingBase p_190102_1_, double p_190102_2_) {
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
        this.tasks.addTask(2, new EntityAIPanic(this, 1.4D) {
            @Override
            public boolean shouldExecute() {
                return this.creature.getAttackTarget() == null && super.shouldExecute();
            }
        });
        this.tasks.addTask(3, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(4, new EntityAITempt(this, 1.0D, Items.PUMPKIN_SEEDS, false));
        this.tasks.addTask(5, new EntityAIFollowParent(this, 1.1D));
        this.tasks.addTask(6, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, false, new Class[0]));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.5D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1D);
    }

    @Override
    public void setAttackTarget(EntityLivingBase entitylivingbaseIn) {
        this.setTailUp(entitylivingbaseIn != null);
        super.setAttackTarget(entitylivingbaseIn);
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
        float f = (float) this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();
        this.lastAttackTime = this.ticksExisted;
        return entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), f);
    }

    private int getNewPeck() {
        return this.rand.nextInt(600) + 30;
    }

    @Override
    public float getEyeHeight() {
        return this.height;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        this.oFlap = this.wingRotation;
        this.oFlapSpeed = this.destPos;
        this.destPos = (float) (this.destPos + (this.onGround ? -1 : 4) * 0.3D);
        this.destPos = MathHelper.clamp(this.destPos, 0.0F, 1.0F);

        if(!this.onGround && this.wingRotDelta < 1.0F) {
            this.wingRotDelta = 0.3F;
        }

        this.wingRotDelta = (float) (this.wingRotDelta * 0.9D);

        if(!this.onGround && this.motionY < 0.0D) {
            this.motionY *= 0.6D;
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
            this.dropItem(ModItems.TURKEY_EGG, 1);
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
    protected void playStepSound(BlockPos pos, Block blockIn) {
        this.playSound(SoundEvents.ENTITY_CHICKEN_STEP, 0.15F, 1.0F);
    }

    @Override
    @Nullable
    protected ResourceLocation getLootTable() {
        return ModLootTables.TURKEY;
    }

    @Override
    protected void entityInit() {
        super.entityInit();
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
    public int getVariantMax() {
        return 4;
    }

    @Override
    protected IVariantTypes getBaseChild() {
        return new EntityTurkey(this.world);
    }

    @Override
    protected String getContainerName() {
        return "turkey";
    }

}
