package its_meow.betteranimalsplus.entity;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;
import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBeg;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISit;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.AbstractIllager;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSkull;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityFeralWolf extends EntityTameable implements IMob {
	
	private static final DataParameter<Float> DATA_HEALTH_ID = EntityDataManager.<Float>createKey(EntityWolf.class, DataSerializers.FLOAT);
	private static final DataParameter<Integer> TYPE_NUMBER = EntityDataManager.<Integer>createKey(EntityLammergeier.class, DataSerializers.VARINT);
	/** Float used to smooth the rotation of the wolf head */
    private float headRotationCourse;
    private float headRotationCourseOld;
    /** true is the wolf is wet else false */
    private boolean isWet;
    /** True if the wolf is shaking else False */
    private boolean isShaking;
    /** This time increases while wolf is shaking and emitting water particles. */
    private float timeWolfIsShaking;
    private float prevTimeWolfIsShaking;
	
	public EntityFeralWolf(World worldIn) {
		super(worldIn);
		this.world = worldIn;
		this.setSize(0.6F, 0.85F);
        this.setTamed(false);
	}

	protected void initEntityAI()
	{
		this.aiSit = new EntityAISit(this);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, this.aiSit);
		this.tasks.addTask(4, new EntityAILeapAtTarget(this, 0.4F));
		this.tasks.addTask(5, new EntityAIAttackMelee(this, 1.0D, true));
		this.tasks.addTask(6, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
		this.tasks.addTask(8, new EntityAIWanderAvoidWater(this, 1.0D));
		this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(10, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
		this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true, new Class[0]));
		this.targetTasks.addTask(4, new EntityAITargetNonTamed(this, EntityPlayer.class, false, (Predicate) null));
		this.targetTasks.addTask(4, new EntityAITargetNonTamed(this, EntityAnimal.class, false, new Predicate<Entity>()
		{
			public boolean apply(@Nullable Entity p_apply_1_)
			{
				return p_apply_1_ instanceof EntitySheep || p_apply_1_ instanceof EntityRabbit;
			}
		}));
		this.targetTasks.addTask(4, new EntityAITargetNonTamed(this, EntityVillager.class, false, (Predicate) null));
		this.targetTasks.addTask(4, new EntityAITargetNonTamed(this, AbstractIllager.class, false, (Predicate) null));
		this.targetTasks.addTask(4, new EntityAITargetNonTamed(this, EntityChicken.class, false, (Predicate) null));
		this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, AbstractSkeleton.class, false));
	}
	
	
	
	
	
	
	
	
	
	

	public int getTypeNumber() {
		return ((Integer)this.dataManager.get(TYPE_NUMBER)).intValue();
	}

	public void setType(int typeId)
	{
		this.dataManager.set(TYPE_NUMBER, Integer.valueOf(typeId));
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound compound)
	{
		super.writeEntityToNBT(compound);
		compound.setInteger("TypeNumber", this.getTypeNumber());
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound compound)
	{
		super.readEntityFromNBT(compound);
		this.setType(compound.getInteger("TypeNumber"));
	}
	
	/**
	 * Called only once on an entity when first time spawned, via egg, mob spawner, natural spawning etc, but not called
	 * when entity is reloaded from nbt. Mainly used for initializing attributes and inventory
	 */
	@Nullable
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
	{
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		int i = (new Random()).nextInt(3) + 1;

		if (livingdata instanceof EntityFeralWolf.TypeData)
		{
			i = ((EntityFeralWolf.TypeData)livingdata).typeData;
		}
		else
		{
			livingdata = new EntityFeralWolf.TypeData(i);
		}

		this.setType(i);

		return livingdata;
	}

	public static class TypeData implements IEntityLivingData
	{
		public int typeData;

		public TypeData(int type)
		{
			this.typeData = type;
		}
	}
	
	public boolean isPreventingPlayerRest(EntityPlayer playerIn)
	{
		return !this.isTamed() && this.getAttackTarget() != null && playerIn.getDistanceSq(this) <= 50D;
	}



	/**
	 * Checks if the entity's current position is a valid location to spawn this entity.
	 */
	public boolean getCanSpawnHere()
	{
		return this.world.getDifficulty() != EnumDifficulty.PEACEFUL && this.isValidLightLevel() && super.getCanSpawnHere();
	}

	protected boolean isValidLightLevel()
	{
		BlockPos blockpos = new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ);

		if (this.world.getLightFor(EnumSkyBlock.SKY, blockpos) > this.rand.nextInt(32))
		{
			return false;
		}
		else
		{
			int i = this.world.getLightFromNeighbors(blockpos);

			if (this.world.isThundering())
			{
				int j = this.world.getSkylightSubtracted();
				this.world.setSkylightSubtracted(10);
				i = this.world.getLightFromNeighbors(blockpos);
				this.world.setSkylightSubtracted(j);
			}

			return i <= this.rand.nextInt(8);
		}
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30000001192092896D);

		if (this.isTamed())
		{
			this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
		}
		else
		{
			this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
		}

		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
	}

	protected void updateAITasks()
	{
		this.dataManager.set(DATA_HEALTH_ID, Float.valueOf(this.getHealth()));
	}

	protected void entityInit()
	{
		super.entityInit();
		this.dataManager.register(DATA_HEALTH_ID, Float.valueOf(this.getHealth()));
		this.dataManager.register(TYPE_NUMBER, Integer.valueOf(0));
	}

	protected void playStepSound(BlockPos pos, Block blockIn)
	{
		this.playSound(SoundEvents.ENTITY_WOLF_STEP, 0.15F, 1.0F);
	}

	public static void registerFixesFeralWolf(DataFixer fixer)
	{
		EntityLiving.registerFixesMob(fixer, EntityFeralWolf.class);
	}


	protected SoundEvent getAmbientSound()
	{
		if (!this.isTamed())
		{
			return SoundEvents.ENTITY_WOLF_GROWL;
		}
		else if (this.rand.nextInt(3) == 0)
		{
			return this.isTamed() && ((Float)this.dataManager.get(DATA_HEALTH_ID)).floatValue() < 10.0F ? SoundEvents.ENTITY_WOLF_WHINE : SoundEvents.ENTITY_WOLF_PANT;
		}
		else
		{
			return SoundEvents.ENTITY_WOLF_AMBIENT;
		}
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn)
	{
		return SoundEvents.ENTITY_WOLF_HURT;
	}

	protected SoundEvent getDeathSound()
	{
		return SoundEvents.ENTITY_WOLF_DEATH;
	}

	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	protected float getSoundVolume()
	{
		return 0.4F;
	}

	@Nullable
	protected ResourceLocation getLootTable()
	{
		return LootTableList.ENTITIES_WOLF;
	}

	/**
	 * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
	 * use this to react to sunlight and start to burn.
	 */
	public void onLivingUpdate()
	{
		super.onLivingUpdate();

		if (!this.world.isRemote && this.isWet && !this.isShaking && !this.hasPath() && this.onGround)
		{
			this.isShaking = true;
			this.timeWolfIsShaking = 0.0F;
			this.prevTimeWolfIsShaking = 0.0F;
			this.world.setEntityState(this, (byte)8);
		}
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate()
	{
		super.onUpdate();
		this.headRotationCourseOld = this.headRotationCourse;


		this.headRotationCourse += (0.0F - this.headRotationCourse) * 0.4F;


		if (this.isWet())
		{
			this.isWet = true;
			this.isShaking = false;
			this.timeWolfIsShaking = 0.0F;
			this.prevTimeWolfIsShaking = 0.0F;
		}
		else if ((this.isWet || this.isShaking) && this.isShaking)
		{
			if (this.timeWolfIsShaking == 0.0F)
			{
				this.playSound(SoundEvents.ENTITY_WOLF_SHAKE, this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
			}

			this.prevTimeWolfIsShaking = this.timeWolfIsShaking;
			this.timeWolfIsShaking += 0.05F;

			if (this.prevTimeWolfIsShaking >= 2.0F)
			{
				this.isWet = false;
				this.isShaking = false;
				this.prevTimeWolfIsShaking = 0.0F;
				this.timeWolfIsShaking = 0.0F;
			}

			if (this.timeWolfIsShaking > 0.4F)
			{
				float f = (float)this.getEntityBoundingBox().minY;
				int i = (int)(MathHelper.sin((this.timeWolfIsShaking - 0.4F) * (float)Math.PI) * 7.0F);

				for (int j = 0; j < i; ++j)
				{
					float f1 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;
					float f2 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;
					this.world.spawnParticle(EnumParticleTypes.WATER_SPLASH, this.posX + (double)f1, (double)(f + 0.8F), this.posZ + (double)f2, this.motionX, this.motionY, this.motionZ);
				}
			}
		}
	}

	/**
	 * True if the wolf is wet
	 */
	@SideOnly(Side.CLIENT)
	public boolean isWolfWet()
	{
		return this.isWet;
	}

	/**
	 * Used when calculating the amount of shading to apply while the wolf is wet.
	 */
	@SideOnly(Side.CLIENT)
	public float getShadingWhileWet(float p_70915_1_)
	{
		return 0.75F + (this.prevTimeWolfIsShaking + (this.timeWolfIsShaking - this.prevTimeWolfIsShaking) * p_70915_1_) / 2.0F * 0.25F;
	}

	@SideOnly(Side.CLIENT)
	public float getShakeAngle(float p_70923_1_, float p_70923_2_)
	{
		float f = (this.prevTimeWolfIsShaking + (this.timeWolfIsShaking - this.prevTimeWolfIsShaking) * p_70923_1_ + p_70923_2_) / 1.8F;

		if (f < 0.0F)
		{
			f = 0.0F;
		}
		else if (f > 1.0F)
		{
			f = 1.0F;
		}

		return MathHelper.sin(f * (float)Math.PI) * MathHelper.sin(f * (float)Math.PI * 11.0F) * 0.15F * (float)Math.PI;
	}

	@SideOnly(Side.CLIENT)
	public float getInterestedAngle(float p_70917_1_)
	{
		return (this.headRotationCourseOld + (this.headRotationCourse - this.headRotationCourseOld) * p_70917_1_) * 0.15F * (float)Math.PI;
	}

	public float getEyeHeight()
	{
		return this.height * 0.8F;
	}

	/**
	 * The speed it takes to move the entityliving's rotationPitch through the faceEntity method. This is only currently
	 * use in wolves.
	 */
	public int getVerticalFaceSpeed()
	{
		return this.isSitting() ? 20 : super.getVerticalFaceSpeed();
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
				this.aiSit.setSitting(false);
			}

			if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow))
			{
				amount = (amount + 1.0F) / 2.0F;
			}

			return super.attackEntityFrom(source, amount);
		}
	}

	public boolean attackEntityAsMob(Entity entityIn)
	{
		boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue()));

		if (flag)
		{
			this.applyEnchantments(this, entityIn);
		}

		return flag;
	}

	public void setTamed(boolean tamed)
	{
		super.setTamed(tamed);

		if (tamed)
		{
			this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
		}
		else
		{
			this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
		}

		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
	}

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

					if (itemfood.isWolfsFavoriteMeat() && ((Float)this.dataManager.get(DATA_HEALTH_ID)).floatValue() < 20.0F)
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

			if (this.isOwner(player) && !this.world.isRemote && !this.isBreedingItem(itemstack) && (!(itemstack.getItem() instanceof ItemFood) || !((ItemFood)itemstack.getItem()).isWolfsFavoriteMeat()))
			{
				this.aiSit.setSitting(!this.isSitting());
				this.isJumping = false;
				this.navigator.clearPath();
				this.setAttackTarget((EntityLivingBase)null);
			}
		}
		else if (itemstack.getItem() == Items.BONE )
		{
			boolean wearingPowerHead = false;
			ItemStack stack = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
			if(stack.getItem() == Items.SKULL) {
				if(stack.getMetadata() == 5) { // 5 = "dragon"
					wearingPowerHead = true;
				}
			}


			if(wearingPowerHead) { //player.isWearing(part)) TODO: Once hirschgeist added put check for its head


				if (!player.capabilities.isCreativeMode)
				{
					itemstack.shrink(1);
				}

				if (!this.world.isRemote)
				{
					if (this.rand.nextInt(100) <= 14 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player))
					{
						this.setTamedBy(player);
						this.navigator.clearPath();
						this.setAttackTarget((EntityLivingBase)null);
						this.aiSit.setSitting(true);
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
			} else {
				if(!world.isRemote) {
					player.sendMessage(new TextComponentString("You cannot tame feral wolves without proving your prowess. Discover a mighty enemy, defeat it, and wear its head. Feral Wolves only bow to the protector of the forests."));
				}
			}
		}

		return super.processInteract(player, hand);
	}

	/**
	 * Handler for {@link World#setEntityState}
	 */
	@SideOnly(Side.CLIENT)
	public void handleStatusUpdate(byte id)
	{
		if (id == 8)
		{
			this.isShaking = true;
			this.timeWolfIsShaking = 0.0F;
			this.prevTimeWolfIsShaking = 0.0F;
		}
		else
		{
			super.handleStatusUpdate(id);
		}
	}

	@SideOnly(Side.CLIENT)
	public float getTailRotation()
	{
		if (!this.isTamed())
		{
			return 1.5393804F;
		}
		else
		{
			return this.isTamed() ? (0.55F - (this.getMaxHealth() - ((Float)this.dataManager.get(DATA_HEALTH_ID)).floatValue()) * 0.02F) * (float)Math.PI : ((float)Math.PI / 5F);
		}
	}

	/**
	 * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
	 * the animal type)
	 */
	public boolean isBreedingItem(ItemStack stack)
	{
		return stack.getItem() instanceof ItemFood && ((ItemFood)stack.getItem()).isWolfsFavoriteMeat();
	}

	/**
	 * Will return how many at most can spawn in a chunk at once.
	 */
	public int getMaxSpawnedInChunk()
	{
		return 8;
	}

	/**
	 * Returns true if the mob is currently able to mate with the specified mob.
	 */
	public boolean canMateWith(EntityAnimal otherAnimal)
	{
		return false;
	}


	public boolean shouldAttackEntity(EntityLivingBase target, EntityLivingBase owner)
	{
		if (!(target instanceof EntityCreeper) && !(target instanceof EntityGhast))
		{
			if (target instanceof EntityFeralWolf)
			{
				EntityFeralWolf entityferalwolf = (EntityFeralWolf)target;

				if (entityferalwolf.isTamed() && entityferalwolf.getOwner() == owner)
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

	public boolean canBeLeashedTo(EntityPlayer player)
	{
		return this.isTamed() && super.canBeLeashedTo(player);
	}


	public EntityFeralWolf createChild(EntityAgeable ageable)
	{
		return null;
	}

}
