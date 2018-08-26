package its_meow.betteranimalsplus.entity;

import java.util.UUID;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityBear extends EntityMob {
	
	private int angerLevel = 0;
	private UUID targetUUID;
	
	private World world = null;
	
	public EntityBear(World worldIn) {
		super(worldIn);
		this.world = worldIn;
	}
	
	public void setTarget(@Nullable EntityLivingBase livingBase)
	{
		super.setRevengeTarget(livingBase);

		if (livingBase != null)
		{
			this.targetUUID = livingBase.getUniqueID();
		}
	}

	protected void applyEntityAI()
	{
		super.initEntityAI();
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.targetTasks.addTask(1, new EntityBearNeutral.AIHurtByAggressor(this));
		this.targetTasks.addTask(2, new EntityBearNeutral.AITargetAggressor(this));
		this.targetTasks.addTask(3, new EntityAIAttackMelee(this, 0.65D, true));
		this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
	}

	protected void updateAITasks()
	{

		if (this.angerLevel > 0 && this.targetUUID != null && this.getRevengeTarget() == null)
		{
			EntityPlayer entityplayer = this.world.getPlayerEntityByUUID(this.targetUUID);
			this.setTarget(entityplayer);
			this.attackingPlayer = entityplayer;
			this.recentlyHit = this.getRevengeTimer();
		}

		super.updateAITasks();
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
	  * (abstract) Protected helper method to write subclass entity data to NBT.
	  */
	 public void writeEntityToNBT(NBTTagCompound compound)
	 {
		 super.writeEntityToNBT(compound);
		 compound.setShort("Anger", (short)this.angerLevel);

		 if (this.targetUUID != null)
		 {
			 compound.setString("HurtBy", this.targetUUID.toString());
		 }
		 else
		 {
			 compound.setString("HurtBy", "");
		 }
	 }

	 /**
	  * (abstract) Protected helper method to read subclass entity data from NBT.
	  */
	 public void readEntityFromNBT(NBTTagCompound compound)
	 {
		 super.readEntityFromNBT(compound);
		 this.angerLevel = compound.getShort("Anger");
		 String s = compound.getString("HurtBy");

		 if (!s.isEmpty())
		 {
			 this.targetUUID = UUID.fromString(s);
			 EntityPlayer entityplayer = this.world.getPlayerEntityByUUID(this.targetUUID);
			 this.setTarget(entityplayer);

			 if (entityplayer != null)
			 {
				 this.attackingPlayer = entityplayer;
				 this.recentlyHit = this.getRevengeTimer();
			 }
		 }
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
				 this.becomeAngryAt(entity);
			 }

			 return super.attackEntityFrom(source, amount);
		 }
	 }

	 protected void playWarningSound()
	 {
		 this.playSound(SoundEvents.ENTITY_POLAR_BEAR_WARNING, 1.0F, 1.0F);
	 }

	 /**
	  * Causes this PigZombie to become angry at the supplied Entity (which will be a player).
	  */
	 private void becomeAngryAt(Entity entity)
	 {
		 this.angerLevel = 400 + this.rand.nextInt(400);
		 this.playWarningSound();

		 if (entity instanceof EntityLivingBase)
		 {
			 this.setRevengeTarget((EntityLivingBase)entity);
		 }
	 }

	 public boolean isAngry()
	 {
		 return this.angerLevel > 0;
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
		 return this.isAngry();
	 }

	 static class AIHurtByAggressor extends EntityAIHurtByTarget
	 {
		 public AIHurtByAggressor(EntityBear p_i45828_1_)
		 {
			 super(p_i45828_1_, true);
		 }

		 protected void setEntityAttackTarget(EntityCreature creatureIn, EntityLivingBase entityLivingBaseIn)
		 {
			 super.setEntityAttackTarget(creatureIn, entityLivingBaseIn);

			 if (creatureIn instanceof EntityBear)
			 {
				 ((EntityBear)creatureIn).becomeAngryAt(entityLivingBaseIn);
			 }
		 }
	 }

	 static class AITargetAggressor extends EntityAINearestAttackableTarget<EntityPlayer>
	 {
		 public AITargetAggressor(EntityBear p_i45829_1_)
		 {
			 super(p_i45829_1_, EntityPlayer.class, true);
		 }

		 /**
		  * Returns whether the EntityAIBase should begin execution.
		  */
		 public boolean shouldExecute()
		 {
			 return ((EntityBear)this.taskOwner).isAngry() && super.shouldExecute();
		 }
	 }

}
