package its_meow.betteranimalsplus.common.entity;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import its_meow.betteranimalsplus.common.entity.ai.EntityAIFollowOwnerFlying;
import its_meow.betteranimalsplus.common.entity.ai.LammerMoveHelper;
import its_meow.betteranimalsplus.common.util.PolarVector3D;
import its_meow.betteranimalsplus.init.LootTableRegistry;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISit;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.ai.EntityMoveHelper.Action;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.Path;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateFlying;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityLammergeier extends EntityTameableFlying {

	private static final DataParameter<Byte> FLYING = EntityDataManager.<Byte>createKey(EntityLammergeier.class, DataSerializers.BYTE);
	private static final DataParameter<Float> DATA_HEALTH_ID = EntityDataManager.<Float>createKey(EntityWolf.class, DataSerializers.FLOAT);

	public boolean landedLast = false;
	
	//Forgive me for this godawful mess.
	
	public EntityLammergeier(World worldIn) {
		super(worldIn);
		this.setSize(1F, 1F);
		//this.moveHelper = new EntityFlyHelper(this);
		this.moveHelper = new LammerMoveHelper(this);
	}

	/**
	 * Returns true if this entity should move as if it were on a ladder (either because it's actually on a ladder, or
	 * for AI reasons)
	 */
	public boolean isOnLadder()
	{
		return false;
	}

	@Override
	protected ResourceLocation getLootTable() {
		return LootTableRegistry.lammergeier;
	}





	@Override
	public int getMaxSpawnedInChunk() {
		return 2;
	}

	@Override
	protected PathNavigate createNavigator(World worldIn) {
		PathNavigateFlying pathnavigateflying = new PathNavigateFlying(this, worldIn);
		pathnavigateflying.setCanOpenDoors(false);
		pathnavigateflying.setCanFloat(true);
		pathnavigateflying.setCanEnterDoors(true);
		return pathnavigateflying;
}

	protected void initEntityAI()
	{
		this.aiSit = new EntityAISit(this);
		this.tasks.addTask(1, this.aiSit);
		this.tasks.addTask(2, new EntityLammergeier.AIMeleeAttack(this, true));
		this.tasks.addTask(3, new EntityAIFollowOwnerFlying(this, 0.5D, 10.0F, 50.0F));
		this.tasks.addTask(5, new EntityLammergeier.AIRandomFly(this));
		this.tasks.addTask(7, new EntityLammergeier.AILookAround(this));
		this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
		this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
		this.targetTasks.addTask(3, new EntityLammergeier.EntityAIFindEntityNearestFlying(this, EntitySkeleton.class));
	}

	protected void entityInit()
	{
		super.entityInit();
		this.dataManager.register(FLYING, Byte.valueOf((byte)0));
		this.dataManager.register(TYPE_NUMBER, Integer.valueOf(0));
		this.dataManager.register(DATA_HEALTH_ID, Float.valueOf(this.getHealth()));
	}

	public boolean canBePushed()
	{
		return false;
	}

	protected SoundEvent getAmbientSound() {
		return this.isTamed() && ((Float)this.dataManager.get(DATA_HEALTH_ID)).floatValue() < 6.0F ? SoundEvents.ENTITY_PARROT_HURT : null;
	}

	protected SoundEvent getDeathSound()
	{
		return SoundEvents.ENTITY_PARROT_DEATH;
	}



	@Override
	protected float getSoundPitch() {
		return 0.4F; //Lower pitch
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

			if (this.aiSit != null)
			{
				this.setSitting(false);
			}

			if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow))
			{
				amount = (amount + 1.0F) / 2.0F;
			}

			return super.attackEntityFrom(source, amount);
		}
	}


	private int lastTick = 0;
	public int ticksForFly = 0;

	public boolean processInteract(EntityPlayer player, EnumHand hand)
	{
		ItemStack itemstack = player.getHeldItem(hand);

		if (this.isTamed())
		{
			if (!itemstack.isEmpty())
			{
				if (itemstack.getItem() instanceof ItemFood)
				{
					ItemFood itemfood = (ItemFood)itemstack.getItem();

					if (((Float)this.dataManager.get(DATA_HEALTH_ID)).floatValue() < 20.0F)
					{
						if (!player.capabilities.isCreativeMode)
						{
							itemstack.shrink(1);
						}

						this.heal((float)itemfood.getHealAmount(itemstack));
						return true;
					}
				}
			}

			if (this.isOwner(player) && !this.isBeingRidden() && !this.world.isRemote && this.ticksExisted - lastTick > 13 && ( itemstack.getItem() == null  || (itemstack.getItem() != Items.MUTTON)))
			{
				if(!this.isSitting() == false) {
					this.getMoveHelper().action = Action.WAIT;
					this.setAttackTarget((EntityLivingBase)null);
				}

				this.setSitting(!this.isSitting());
				//BetterAnimalsPlusMod.logger.log(Level.INFO, this.isSitting());
				this.navigator.clearPath();	
				lastTick = this.ticksExisted;
			}
		}
		else if (itemstack.getItem() == Items.BONE && !this.isTamed())
		{
			if (!player.capabilities.isCreativeMode)
			{
				itemstack.shrink(1);
			}

			if (!this.world.isRemote)
			{
				if (!net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player))
				{
					this.setTamedBy(player);
					//this.setOwnerId(player.getUniqueID());
					this.navigator.clearPath();
					this.getMoveHelper().action = Action.WAIT;
					this.setAttackTarget((EntityLivingBase)null);
					this.setSitting(true);
					this.setHealth(20.0F);
					this.playTameEffect(true);
					this.world.setEntityState(this, (byte)7);
				}
				else
				{
					this.playTameEffect(false);
					this.world.setEntityState(this, (byte)6);
				}
			}

			return true;
		}

		return super.processInteract(player, hand);
	}

	/**
	 * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
	 * the animal type)
	 */
	public boolean isBreedingItem(ItemStack stack)
	{
		return stack.getItem() == Items.BONE;
	}

	public boolean shouldAttackEntity(EntityLivingBase target, EntityLivingBase owner)
	{
		if (!(target instanceof EntityCreeper) && !(target instanceof EntityGhast))
		{
			if (target instanceof EntityLammergeier)
			{
				EntityLammergeier entitylam = (EntityLammergeier)target;

				if (entitylam.isTamed() && entitylam.getOwner() == owner)
				{
					return false;
				}
			}

			if (target instanceof EntityPlayer && owner instanceof EntityPlayer && !((EntityPlayer)owner).canAttackPlayer((EntityPlayer)target))
			{
				return false;
			}
			else
			{
				return !(target instanceof AbstractHorse) || !((AbstractHorse)target).isTame();
			}
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn)
	{
		float f = (float)this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();
		int i = 0;

		if (entityIn instanceof EntityLivingBase)
		{
			f += EnchantmentHelper.getModifierForCreature(this.getHeldItemMainhand(), ((EntityLivingBase)entityIn).getCreatureAttribute());
			i += EnchantmentHelper.getKnockbackModifier(this);
		}

		boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), f);

		if (flag)
		{
			if (i > 0 && entityIn instanceof EntityLivingBase)
			{
				((EntityLivingBase)entityIn).knockBack(this, (float)i * 0.5F, (double)MathHelper.sin(this.rotationYaw * 0.017453292F), (double)(-MathHelper.cos(this.rotationYaw * 0.017453292F)));
				this.motionX *= 0.6D;
				this.motionZ *= 0.6D;
			}

			int j = EnchantmentHelper.getFireAspectModifier(this);

			if (j > 0)
			{
				entityIn.setFire(j * 4);
			}

			if (entityIn instanceof EntityPlayer)
			{
				EntityPlayer entityplayer = (EntityPlayer)entityIn;
				ItemStack itemstack = this.getHeldItemMainhand();
				ItemStack itemstack1 = entityplayer.isHandActive() ? entityplayer.getActiveItemStack() : ItemStack.EMPTY;

				if (!itemstack.isEmpty() && !itemstack1.isEmpty() && itemstack.getItem().canDisableShield(itemstack, itemstack1, entityplayer, this) && itemstack1.getItem().isShield(itemstack1, entityplayer))
				{
					float f1 = 0.25F + (float)EnchantmentHelper.getEfficiencyModifier(this) * 0.05F;

					if (this.rand.nextFloat() < f1)
					{
						entityplayer.getCooldownTracker().setCooldown(itemstack1.getItem(), 100);
						this.world.setEntityState(entityplayer, (byte)30);
					}
				}
			}

			this.applyEnchantments(this, entityIn);
		}

		return flag;
	}

	protected void collideWithEntity(Entity entityIn)
	{
		if(!this.getFlying()) {
			super.collideWithEntity(entityIn);
		}
	}

	protected void collideWithNearbyEntities()
	{
		if(!this.getFlying()) {
			super.collideWithNearbyEntities();
		}
	}

	public void fall(float distance, float damageMultiplier)
	{
		if(!this.getFlying()) {
			super.fall(distance, damageMultiplier);
		}
	}

	protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos)
	{
		if(!this.getFlying()) {
			super.updateFallState(y, onGroundIn, state, pos);
		}
	}

	/**
	 * Return whether this entity should NOT trigger a pressure plate or a tripwire.
	 */
	public boolean doesEntityNotTriggerPressurePlate()
	{
		return !this.getFlying();
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_SPEED);
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(this.isTamed() ? 15.0D : 6.0D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(50.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_SPEED).setBaseValue(1.0D);
		this.getEntityAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(5.0D);
	}

	public boolean getFlying()
	{
		return (((Byte)this.dataManager.get(FLYING)).byteValue() & 1) != 0;
	}

	public void setFlying(boolean isFlying)
	{
		byte b0 = ((Byte)this.dataManager.get(FLYING)).byteValue();

		if (isFlying)
		{
			this.dataManager.set(FLYING, Byte.valueOf((byte)(b0 | 1)));
		}
		else
		{
			this.dataManager.set(FLYING, Byte.valueOf((byte)(b0 & -2)));
		}
		this.setNoGravity(isFlying);
	}

	protected void updateAITasks()
	{
		super.updateAITasks();

		this.dataManager.set(DATA_HEALTH_ID, Float.valueOf(this.getHealth()));

		BlockPos blockpos = new BlockPos(this);
		BlockPos blockpos1 = blockpos.down();

		if (!this.getFlying())
		{
			if (this.world.getBlockState(blockpos1).isNormalCube() && this.getAttackTarget() == null)
			{
				this.setFlying(false);
				if(this.rand.nextInt(100) == 0) {
					this.setFlying(true);
				}
			}
			else
			{
				this.setFlying(true);
				this.world.playEvent((EntityPlayer)null, 1025, blockpos, 0);
			}
		}
		else
		{
			if (this.rand.nextInt(20) == 0 && this.world.getBlockState(blockpos1).isNormalCube())
			{
				this.setFlying(false);
			}
		}
	}

	public BlockPos fromPolarCoordinates(PolarVector3D polar) {
		double r = polar.getR();
		double lat = polar.getThetaY();
		double lon = polar.getThetaX();
		double x = r * Math.sin(lat) * Math.cos(lon);
		double y = r * Math.sin(lat) * Math.sin(lon);
		double z = r * Math.cos(lat);
		return new BlockPos(x, y, z);
	}

	public PolarVector3D toPolarCoordinates(BlockPos pos) {

		BlockPos lPos = this.getPosition();

		double x = lPos.getX() - pos.getX();
		double z = lPos.getZ() - pos.getZ();
		double y = lPos.getY() - pos.getY();
		double rx = Math.sqrt(  Math.pow(x, 2) + Math.pow(z, 2)  );
		double thetax = Math.atan(z / x);
		double thetay = Math.atan(y / rx);
		double ry = Math.sqrt(Math.pow(rx, 2) + Math.pow(y, 2));
		return new PolarVector3D(thetax, thetay, ry);
	}



	public PolarVector3D toPolarCoordinates(int x, int y, int z) {
		return toPolarCoordinates(new BlockPos(x, y, z));
	}


	private static final DataParameter<Integer> TYPE_NUMBER = EntityDataManager.<Integer>createKey(EntityLammergeier.class, DataSerializers.VARINT);

	public int getTypeNumber() {
		return ((Integer)this.dataManager.get(TYPE_NUMBER)).intValue();
	}

	public void setLammerType(int lammerTypeId)
	{
		this.dataManager.set(TYPE_NUMBER, Integer.valueOf(lammerTypeId));
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound compound)
	{
		super.writeEntityToNBT(compound);
		compound.setInteger("TypeNumber", this.getTypeNumber());
		compound.setByte("LammerFlying", ((Byte)this.dataManager.get(FLYING)).byteValue());
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound compound)
	{
		super.readEntityFromNBT(compound);
		this.setLammerType(compound.getInteger("TypeNumber"));
		this.dataManager.set(FLYING, Byte.valueOf(compound.getByte("LammerFlying")));
	}

	public void setTamed(boolean tamed)
	{
		super.setTamed(tamed);
		if (tamed)
		{
			this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0D);
		}
		else
		{
			this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0D);
		}

	}




	/**
	 * Called only once on an entity when first time spawned, via egg, mob spawner, natural spawning etc, but not called
	 * when entity is reloaded from nbt. Mainly used for initializing attributes and inventory
	 */
	@Nullable
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
	{
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		int i = this.rand.nextInt(4) + 1;

		if (livingdata instanceof EntityLammergeier.LammerTypeData)
		{
			i = ((EntityLammergeier.LammerTypeData)livingdata).typeData;
		}
		else
		{
			livingdata = new EntityLammergeier.LammerTypeData(i);
		}

		this.setLammerType(i);

		return livingdata;
	}

	public static class LammerTypeData implements IEntityLivingData
	{
		public int typeData;

		public LammerTypeData(int type)
		{
			this.typeData = type;
		}
	}










	@Override
	public void updatePassenger(Entity passenger)
	{
		if (this.isPassenger(passenger))
		{
			passenger.setPosition(this.posX + this.motionX, this.posY - passenger.height - 0.05 + this.motionY, this.posZ + this.motionZ);
			this.motionY += Math.abs(passenger.motionY);
			if(passenger instanceof EntityLivingBase && (this.getAttackTarget() == null || this.getAttackTarget() != passenger)) {
				this.setAttackTarget((EntityLivingBase) passenger);
			}
			if(this.world.isRemote) {
				this.applyOrientationToEntity(passenger);
			}
		}
	}






	static class AIMeleeAttack extends net.minecraft.entity.ai.EntityAIAttackMelee
	{


		World world;
		protected EntityLammergeier attacker;
		/** An amount of decrementing ticks that allows the entity to attack once the tick reaches 0. */
		protected int attackTick;
		/** The speed with which the mob will approach the target */
		double speedTowardsTarget;
		/** When true, the mob will continue chasing its target, even if it can't find a path to them right now. */
		boolean longMemory;
		/** The PathEntity of our entity. */
		Path path;
		private int delayCounter;
		private double targetX;
		private double targetY;
		private double targetZ;
		protected final int attackInterval = 20;

		private final EntityLammergeier parentEntity;

		public AIMeleeAttack(EntityLammergeier lam, boolean useLongMemory)
		{
			super(lam, 0.5D, false);
			this.parentEntity = lam;
			this.attacker = lam;
			this.world = lam.getEntityWorld();
			this.setMutexBits(2);
		}
		double liftY = 0;

		@Override
		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void updateTask()
		{
			if (this.parentEntity.getAttackTarget() == null)
			{
				this.parentEntity.rotationYaw = -((float)MathHelper.atan2(this.parentEntity.motionX, this.parentEntity.motionZ)) * (180F / (float)Math.PI);
				this.parentEntity.renderYawOffset = this.parentEntity.rotationYaw;
			}
			else
			{
				EntityLivingBase entitylivingbase = this.parentEntity.getAttackTarget();

				if(!entitylivingbase.isEntityAlive()) {
					this.parentEntity.setAttackTarget(null);
					return;
				}


				if (entitylivingbase.getDistanceSq(this.parentEntity) < 4096.0D)
				{
					double d1 = entitylivingbase.posX - this.parentEntity.posX;
					double d2 = entitylivingbase.posZ - this.parentEntity.posZ;
					this.parentEntity.rotationYaw = -((float)MathHelper.atan2(d1, d2)) * (180F / (float)Math.PI);
					this.parentEntity.renderYawOffset = this.parentEntity.rotationYaw;
				}
				//attacker.getMoveHelper().setMoveTo(entitylivingbase.posX, entitylivingbase.posY, entitylivingbase.posZ, 1.0D);

				//this.attacker.getLookHelper().setLookPositionWithEntity(entitylivingbase, 30.0F, 30.0F);
				double d0 = this.attacker.getDistanceSq(entitylivingbase.posX, entitylivingbase.posY, entitylivingbase.posZ);

				--this.delayCounter;

				if ((this.longMemory || this.attacker.getEntitySenses().canSee(entitylivingbase)) && this.delayCounter <= 0 && (this.targetX == 0.0D && this.targetY == 0.0D && this.targetZ == 0.0D || entitylivingbase.getDistanceSq(this.targetX, this.targetY, this.targetZ) >= 1.0D || this.attacker.getRNG().nextFloat() < 0.05F))
				{
					this.targetX = entitylivingbase.posX;
					this.targetY = entitylivingbase.getEntityBoundingBox().minY;
					this.targetZ = entitylivingbase.posZ;
					this.delayCounter = 4 + this.attacker.getRNG().nextInt(7);



					if (d0 > 1024.0D)
					{
						this.delayCounter += 10;
					}
					else if (d0 > 256.0D)
					{
						this.delayCounter += 5;
					}
					if(!attacker.getMoveHelper().isUpdating() && !entitylivingbase.isRiding()) {
						attacker.getMoveHelper().setMoveTo(targetX, targetY, targetZ, 1.0D);
					}
				}

				attackTick--;


				double d2 = this.getAttackReachSqr(entitylivingbase);

				if (d0 <= d2 && this.attackTick <= 0)
				{
					this.attackTick = 20;
					if(!entitylivingbase.isRidingOrBeingRiddenBy(attacker)) {
						this.attacker.attackEntityAsMob(entitylivingbase);
					}



				}
				if(entitylivingbase.isRiding()) {
					this.attacker.getMoveHelper().setMoveTo(targetX, liftY + 15, targetZ, 5.0D);
				}
				if(attackTick == 20 && !entitylivingbase.isRiding() && entitylivingbase.height <= 3) {
					this.attacker.setLocationAndAngles(attacker.posX, attacker.posY + entitylivingbase.height + 2, attacker.posZ, attacker.rotationYaw, attacker.rotationPitch);
					entitylivingbase.startRiding(this.attacker, true);
					liftY = entitylivingbase.posY;
					if(entitylivingbase instanceof EntityLiving) {
						EntityLiving el = (EntityLiving) entitylivingbase;
						el.setAttackTarget(null);
						el.setRevengeTarget(null);
					}
					this.attacker.getMoveHelper().setMoveTo(targetX, liftY + 15, targetZ, 5.0D);
				}
				if(entitylivingbase.isRiding() && attacker.getEntityWorld().getBlockState(attacker.getPosition().up()).isFullCube()) {
					entitylivingbase.dismountRidingEntity();
					this.attacker.setAttackTarget(null);
					Random random = this.attacker.getRNG();
					BlockPos rPos = this.parentEntity.fromPolarCoordinates(new PolarVector3D(this.parentEntity.rotationYaw + (random.nextInt(40) - 20), random.nextInt(40) - 20, random.nextInt(15) + 1 + random.nextFloat()));
					BlockPos pos = this.parentEntity.getPosition();
					rPos = rPos.add(pos);
					this.parentEntity.getMoveHelper().setMoveTo(rPos.getX(), rPos.getY(), rPos.getZ(), 1.0D);
				}
				if(Math.abs(attacker.posY - (liftY + 15)) <= 3 && entitylivingbase.isRiding() || !this.attacker.getMoveHelper().isUpdating()) {
					entitylivingbase.dismountRidingEntity(); //Math.abs(attacker.posY - liftY) <= 1
				}

				//this.checkAndPerformAttack(entitylivingbase, d0);



			}
		}
	}

	static class AILookAround extends EntityAIBase
	{
		private final EntityLammergeier parentEntity;

		public AILookAround(EntityLammergeier lam)
		{
			this.parentEntity = lam;
			this.setMutexBits(2);
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		public boolean shouldExecute()
		{
			return parentEntity.getFlying();
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void updateTask()
		{
			if (this.parentEntity.getAttackTarget() == null)
			{
				if(!this.parentEntity.isTamed()) {
					this.parentEntity.rotationYaw = -((float)MathHelper.atan2(this.parentEntity.motionX, this.parentEntity.motionZ)) * (180F / (float)Math.PI);
					this.parentEntity.renderYawOffset = this.parentEntity.rotationYaw;
				} else {
					EntityLivingBase entitylivingbase = this.parentEntity.getOwner();
					if(entitylivingbase != null) {

						if (entitylivingbase.getDistanceSq(this.parentEntity) < 4096.0D)
						{
							double d1 = entitylivingbase.posX - this.parentEntity.posX;
							double d2 = entitylivingbase.posZ - this.parentEntity.posZ;
							this.parentEntity.rotationYaw = -((float)MathHelper.atan2(d1, d2)) * (180F / (float)Math.PI);
							this.parentEntity.renderYawOffset = this.parentEntity.rotationYaw;
						}
					}
				}
			}
			else
			{
				EntityLivingBase entitylivingbase = this.parentEntity.getAttackTarget();

				if (entitylivingbase.getDistanceSq(this.parentEntity) < 4096.0D)
				{
					double d1 = entitylivingbase.posX - this.parentEntity.posX;
					double d2 = entitylivingbase.posZ - this.parentEntity.posZ;
					this.parentEntity.rotationYaw = -((float)MathHelper.atan2(d1, d2)) * (180F / (float)Math.PI);
					this.parentEntity.renderYawOffset = this.parentEntity.rotationYaw;
				}
			}
		}
	}

	static class AIRandomFly extends EntityAIBase
	{
		private final EntityLammergeier parentEntity;

		public AIRandomFly(EntityLammergeier lam)
		{
			this.parentEntity = lam;
			this.setMutexBits(1);
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		public boolean shouldExecute()
		{
			EntityMoveHelper entitymovehelper = this.parentEntity.getMoveHelper();

			if(parentEntity.isTamed()) {
				return false;
			}
			if (!entitymovehelper.isUpdating())
			{
				return true;
			}
			else
			{
				double d0 = entitymovehelper.getX() - this.parentEntity.posX;
				double d1 = entitymovehelper.getY() - this.parentEntity.posY;
				double d2 = entitymovehelper.getZ() - this.parentEntity.posZ;
				double d3 = d0 * d0 + d1 * d1 + d2 * d2;
				return d3 < 1.0D || d3 > 3600.0D && this.parentEntity.getAttackTarget() == null;
			}
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		public boolean shouldContinueExecuting()
		{
			return false;
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void startExecuting()
		{
			Random random = this.parentEntity.getRNG();
			if(random.nextInt(30) != 1 && !parentEntity.landedLast) {
				this.parentEntity.setFlying(true);
				BlockPos rPos = this.parentEntity.fromPolarCoordinates(new PolarVector3D(this.parentEntity.rotationYaw + (random.nextInt(20) - 10), random.nextInt(20) - 10, random.nextInt(15) + 1 + random.nextFloat()));
				BlockPos pos = this.parentEntity.getPosition();
				rPos = rPos.add(pos);
				/*
			double d0 = this.parentEntity.posX + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
			double d1 = this.parentEntity.posY + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
			double d2 = this.parentEntity.posZ + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
			this.parentEntity.getMoveHelper().setMoveTo(d0, d1, d2, 1.0D);
				 */
				this.parentEntity.getMoveHelper().setMoveTo(rPos.getX(), rPos.getY(), rPos.getZ(), 1.0D);
			} else if(!parentEntity.landedLast && parentEntity.posY > 65 && parentEntity.getFlying()) {
				BlockPos rPos = this.findLandingPosition();
				parentEntity.landedLast = true;
				this.parentEntity.getMoveHelper().setMoveTo(rPos.getX(), rPos.getY(), rPos.getZ(), 1.1D);
			} else {
				parentEntity.ticksForFly++;
				if(parentEntity.ticksForFly == 120) {
					this.parentEntity.setFlying(false);
					parentEntity.landedLast = false;
					parentEntity.ticksForFly = 0;
				}
			}
		}

		private BlockPos findLandingPosition() {
			World world = this.parentEntity.world;
			Random random = this.parentEntity.getRNG();
			float x = ((int) this.parentEntity.posX) + random.nextInt(16) - 8F + 0.5F;
			float z = ((int) this.parentEntity.posZ) + random.nextInt(16) - 8F + 0.5F;

			float y = world.getTopSolidOrLiquidBlock(new BlockPos(x, 0, z)).getY();

			BlockPos pos = new BlockPos(x, y, z);

			return pos;
		}
	}

	static class EntityAIFindEntityNearestFlying extends EntityAIBase {

		private final EntityLammergeier mob;
		private final Predicate<EntityLivingBase> predicate;
		private final EntityAINearestAttackableTarget.Sorter sorter;
		private EntityLivingBase target;
		private final Class <? extends EntityLivingBase > classToCheck;

		public EntityAIFindEntityNearestFlying(EntityLammergeier mobIn, Class<? extends EntityLivingBase> p_i45884_2_) {
			//super(mobIn, p_i45884_2_);
			this.mob = mobIn;
			this.classToCheck = p_i45884_2_;
			this.predicate = new Predicate<EntityLivingBase>()
			{
				public boolean apply(@Nullable EntityLivingBase p_apply_1_)
				{
					double d0 = EntityAIFindEntityNearestFlying.this.getFollowRange();

					if (p_apply_1_.isSneaking())
					{
						d0 *= 0.800000011920929D;
					}

					if (p_apply_1_.isInvisible())
					{
						return false;
					}
					else
					{
						return (double)p_apply_1_.getDistance(EntityAIFindEntityNearestFlying.this.mob) > d0 ? false : EntityAITarget.isSuitableTarget(EntityAIFindEntityNearestFlying.this.mob, p_apply_1_, false, true);
					}
				}
			};

			this.sorter = new EntityAINearestAttackableTarget.Sorter(mobIn);
		}

		@Override
		public boolean shouldExecute()
		{
			if(this.mob.isTamed()) {
				return false;
			}

			double d0 = this.getFollowRange();
			List<EntityLivingBase> list = this.mob.world.<EntityLivingBase>getEntitiesWithinAABB(this.classToCheck, this.mob.getEntityBoundingBox().grow(d0, d0, d0), this.predicate);
			Collections.sort(list, this.sorter);

			if (list.isEmpty())
			{
				return false;
			}
			else
			{
				this.target = list.get(0);
				return true;
			}
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		public boolean shouldContinueExecuting()
		{
			EntityLivingBase entitylivingbase = this.mob.getAttackTarget();

			if (entitylivingbase == null)
			{
				return false;
			}
			else if (!entitylivingbase.isEntityAlive())
			{
				return false;
			} 
			else if(entitylivingbase.isRiding())
			{
				return false;
			}
			else
			{
				double d0 = this.getFollowRange();

				if (this.mob.getDistanceSq(entitylivingbase) > d0 * d0)
				{
					this.mob.setAttackTarget(null);
					return false;
				}
				else
				{
					return !(entitylivingbase instanceof EntityPlayerMP) || !((EntityPlayerMP)entitylivingbase).interactionManager.isCreative();
				}
			}
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void startExecuting()
		{
			this.mob.setAttackTarget(this.target);
			super.startExecuting();
		}

		/**
		 * Reset the task's internal state. Called when this task is interrupted by another one
		 */
		public void resetTask()
		{
			this.mob.setAttackTarget((EntityLivingBase)null);
			super.startExecuting();
		}

		protected double getFollowRange()
		{
			IAttributeInstance iattributeinstance = this.mob.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE);
			return iattributeinstance == null ? 16.0D : iattributeinstance.getAttributeValue();
		}

	}










	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {
		return null;
	}

}
