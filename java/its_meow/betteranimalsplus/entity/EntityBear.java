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
	
	private World world = null;
	
	public EntityBear(World worldIn) {
		super(worldIn);
		this.world = worldIn;
	}

	protected void applyEntityAI()
	{
		super.initEntityAI();
		this.tasks.addTask(0, new EntityAISwimming(this));
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
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
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
				 this.attackEntityAsMob(entity);
				 this.playWarningSound();
			 }

			 return super.attackEntityFrom(source, amount);
		 }
	 }

	 protected void playWarningSound()
	 {
		 this.playSound(SoundEvents.ENTITY_POLAR_BEAR_WARNING, 1.0F, 1.0F);
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
		 return this.getAttackingEntity() == playerIn;
	 }

}
