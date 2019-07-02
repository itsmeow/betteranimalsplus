package its_meow.betteranimalsplus.common.entity;

import java.util.Random;
import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.base.Predicates;

import its_meow.betteranimalsplus.init.ModLootTables;
import its_meow.betteranimalsplus.util.HeadTypes;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
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
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class EntityBear extends EntityMob implements IVariantTypes {

    protected static final DataParameter<Integer> TYPE_NUMBER = EntityDataManager.<Integer>createKey(EntityBear.class, DataSerializers.VARINT);
    private int warningSoundTicks;

    public EntityBear(World worldIn) {
        super(worldIn);
        this.setSize(2F, 1.75F);
    }

    @Override
    protected void initEntityAI() {
        if(this.getTypeNumber() == 1) { // Brown
            this.tasks.addTask(0, new EntityAISwimming(this));
            this.tasks.addTask(1, new EntityBear.AIMeleeAttack());
            this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
            this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
            this.targetTasks.addTask(1, new EntityBear.AIHurtByTarget());
            this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<EntityPlayer>(this, EntityPlayer.class, 90, true, true, Predicates.alwaysTrue()));
            this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<EntityDeer>(this, EntityDeer.class, 90, true, true, Predicates.alwaysTrue()));
            this.targetTasks.addTask(4, new EntityAINearestAttackableTarget<EntityPig>(this, EntityPig.class, 90, true, true, Predicates.alwaysTrue()));
            this.targetTasks.addTask(5, new EntityAINearestAttackableTarget<EntityChicken>(this, EntityChicken.class, 90, true, true, Predicates.alwaysTrue()));
            this.targetTasks.addTask(6, new EntityAINearestAttackableTarget<EntityRabbit>(this, EntityRabbit.class, 90, true, true, Predicates.alwaysTrue()));
            this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<EntityFox>(this, EntityFox.class, 90, true, true, Predicates.alwaysTrue()));
            this.targetTasks.addTask(5, new EntityAINearestAttackableTarget<EntityPheasant>(this, EntityPheasant.class, 90, true, true, Predicates.alwaysTrue()));
        } else { // Black/Kermode
            this.tasks.addTask(0, new EntityAISwimming(this));
            this.tasks.addTask(1, new EntityBear.AIMeleeAttack());
            this.targetTasks.addTask(1, new EntityBear.AIHurtByTarget());
            this.tasks.addTask(5, new EntityAIWander(this, 0.5D));
            this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
            this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<EntityChicken>(this, EntityChicken.class, true));
            this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<EntityRabbit>(this, EntityRabbit.class, true));
            this.targetTasks.addTask(4, new EntityAINearestAttackableTarget<EntityPheasant>(this, EntityPheasant.class, 90, true, true, Predicates.alwaysTrue()));
        }
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_SPEED);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_SPEED).setBaseValue(1D);
    }

    @Override
    @Nullable
    protected ResourceLocation getLootTable() {
        return ModLootTables.bear;
    }
    
    @Override
    public void onDeath(DamageSource cause) {
        super.onDeath(cause);
        if (!world.isRemote && !this.isChild()) {
            if (this.rand.nextInt(12) == 0) {
                ItemStack stack = new ItemStack(HeadTypes.BEARHEAD.getItem(this.getTypeNumber()));
                this.entityDropItem(stack, 0.5F);
            }
        }
    }


    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isEntityInvulnerable(source)) {
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
    public void onUpdate() {
        super.onUpdate();

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

    @Override
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
    public boolean isChildI() {
        return this.isChild();
    }

    @Override
    public Random getRNGI() {
        return this.getRNG();
    }

    @Override
    public EntityDataManager getDataManagerI() {
        return this.getDataManager();
    }

    @Override
    public int getVariantMax() {
        return 3;
    }

    @Override
    public DataParameter<Integer> getDataKey() {
        return TYPE_NUMBER;
    }

    @Override
    @Nullable
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
        int validTypes[] = this.getTypesFor(BiomeDictionary.getTypes(world.getBiome(this.getPosition())));
        return this.initData(super.onInitialSpawn(difficulty, livingdata), getBiasedRandomType(validTypes));
    }

    private int getBiasedRandomType(int[] validTypes) { // Double bias against kermode spawn
        int r = validTypes[this.getRNG().nextInt(validTypes.length)];
        if(validTypes.length > 1) { // No point if only a single possibility
            if(r == 3) {
                r = validTypes[this.getRNG().nextInt(validTypes.length)];
            }
            if(r == 3) {
                r = validTypes[this.getRNG().nextInt(validTypes.length)];
            }
        }
        return r;
    }

    protected int[] getTypesFor(Set<BiomeDictionary.Type> types) {
        if(types.contains(Type.FOREST) && !types.contains(Type.CONIFEROUS)) {
            return new int[] {1};
        } else if(types.contains(Type.CONIFEROUS) && !types.contains(Type.SNOWY)) {
            return new int[] {2, 3};
        } else if(types.contains(Type.CONIFEROUS) && types.contains(Type.SNOWY)) {
            return new int[] {2, 3};
        } else {
            return new int[] {1, 2, 3};
        }
    }

    protected void entityInit() {
        super.entityInit();
        this.registerTypeKey();
    }
    
    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        this.writeType(compound);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        this.readType(compound);
    }

}
