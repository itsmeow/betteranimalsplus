package its_meow.betteranimalsplus.common.entity;

import java.util.UUID;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import its_meow.betteranimalsplus.init.LootTableRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIFindEntityNearest;
import net.minecraft.entity.ai.EntityAIFindEntityNearestPlayer;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPolarBear;
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
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityBear extends EntityMob {

	private int warningSoundTicks;
	private World world = null;

	public EntityBear(World worldIn) {
		super(worldIn);
		this.world = worldIn;
		this.setSize(2F, 2F);
	}
	
	@Override
	protected void initEntityAI()
	{
		//super.initEntityAI();
		this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityBear.AIMeleeAttack());
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityBear.AIHurtByTarget());
        //this.targetTasks.addTask(3, new EntityBear.AIAttackPlayer());
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<EntityPlayer>(this, EntityPlayer.class, 90, true, true, (Predicate) null));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<EntityDeer>(this, EntityDeer.class, 90, true, true, (Predicate)null));
        this.targetTasks.addTask(4, new EntityAINearestAttackableTarget<EntityPig>(this, EntityPig.class, 90, true, true, (Predicate)null));
        this.targetTasks.addTask(5, new EntityAINearestAttackableTarget<EntityChicken>(this, EntityChicken.class, 90, true, true, (Predicate)null));
        this.targetTasks.addTask(6, new EntityAINearestAttackableTarget<EntityRabbit>(this, EntityRabbit.class, 90, true, true, (Predicate)null));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<EntityFox>(this, EntityFox.class, 90, true, true, (Predicate)null));
        //TODO: Once pheasants are added target them
	}

	protected void applyEntityAttributes()
	{
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
	protected ResourceLocation getLootTable()
	{
		return LootTableRegistry.bear;
	}

	
	/**
	 * Checks if the entity's current position is a valid location to spawn this entity.
	 */
	public boolean getCanSpawnHere()
	{
		return this.world.getDifficulty() != EnumDifficulty.PEACEFUL;
	}

	public static void registerFixesBear(DataFixer fixer)
	{
		EntityLiving.registerFixesMob(fixer, EntityBear.class);
	}

	/**
	 * Called when the entity is attacked.
	 */
	public boolean attackEntityFrom(DamageSource source, float amount)
	{
		if (this.isEntityInvulnerable(source))
		{
			return false;
		}
		else
		{
			Entity entity = source.getTrueSource();

			if (entity instanceof EntityPlayer)
			{
				this.setAttackTarget((EntityPlayer) entity);
				this.playWarningSound();
			}

			return super.attackEntityFrom(source, amount);
		}
	}

	public void onUpdate()
	{
		super.onUpdate();


		if (this.warningSoundTicks > 0)
		{
			--this.warningSoundTicks;
		}
	}

	protected void playWarningSound()
	{
		if (this.warningSoundTicks <= 0)
		{
			this.playSound(SoundEvents.ENTITY_POLAR_BEAR_WARNING, 1.0F, 1.0F);
			this.warningSoundTicks = 40;
		}
	}



	protected SoundEvent getAmbientSound()
	{
		return SoundEvents.ENTITY_POLAR_BEAR_AMBIENT;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn)
	{
		return SoundEvents.ENTITY_POLAR_BEAR_HURT;
	}

	protected SoundEvent getDeathSound()
	{
		return SoundEvents.ENTITY_POLAR_BEAR_DEATH;
	}

	protected void playStepSound(BlockPos pos, Block blockIn)
	{
		this.playSound(SoundEvents.ENTITY_POLAR_BEAR_STEP, 0.15F, 1.0F);
	}

	public boolean processInteract(EntityPlayer player, EnumHand hand)
	{
		return false;
	}
	
	public boolean isPreventingPlayerRest(EntityPlayer playerIn)
	{
		return world.getDifficulty() != EnumDifficulty.PEACEFUL && this.getAttackingEntity() == playerIn;
	}


	public class AIHurtByTarget extends EntityAIHurtByTarget
	{
		public AIHurtByTarget()
		{
			super(EntityBear.this, false);
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void startExecuting()
		{
			super.startExecuting();

		}

		protected void setEntityAttackTarget(EntityCreature creatureIn, EntityLivingBase entityLivingBaseIn)
		{
			if (creatureIn instanceof EntityBear)
			{
				super.setEntityAttackTarget(creatureIn, entityLivingBaseIn);
			}
		}
	}
	
	public class AIMeleeAttack extends EntityAIAttackMelee
	{
		public AIMeleeAttack()
		{
			super(EntityBear.this, 1.25D, true);
		}

		protected void checkAndPerformAttack(EntityLivingBase p_190102_1_, double p_190102_2_)
		{
			double d0 = this.getAttackReachSqr(p_190102_1_);

			if (p_190102_2_ <= d0 && this.attackTick <= 0)
			{
				this.attackTick = 20;
				this.attacker.attackEntityAsMob(p_190102_1_);
			}
			else if (p_190102_2_ <= d0 * 2.0D)
			{
				if (this.attackTick <= 0)
				{
					this.attackTick = 20;
				}

				if (this.attackTick <= 10)
				{
					EntityBear.this.playWarningSound();
				}
			}
			else
			{
				this.attackTick = 20;
			}
		}

		/**
		 * Reset the task's internal state. Called when this task is interrupted by another one
		 */
		public void resetTask()
		{
			super.resetTask();
		}

		protected double getAttackReachSqr(EntityLivingBase attackTarget)
		{
			return (double)(10.0F + attackTarget.width);
		}
	}
	
}
