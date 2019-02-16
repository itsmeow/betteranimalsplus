package its_meow.betteranimalsplus.common.entity;

import java.util.Calendar;
import java.util.UUID;

import javax.annotation.Nullable;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;

import its_meow.betteranimalsplus.init.BlockRegistry;
import its_meow.betteranimalsplus.init.LootTableRegistry;
import its_meow.betteranimalsplus.init.MobRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IJumpingMount;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpawnEgg;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityReindeer extends EntityAnimal implements IJumpingMount {

	private static final Predicate<Entity> IS_REINDEER_BREEDING = new Predicate<Entity>()
	{
		public boolean apply(@Nullable Entity p_apply_1_)
		{
			return p_apply_1_ instanceof EntityReindeer && ((EntityReindeer)p_apply_1_).isBreeding();
		}
	};
	protected static final IAttribute JUMP_STRENGTH = (new RangedAttribute((IAttribute)null, "reindeer.jumpStrength", 0.7D, 0.0D, 2.0D)).setDescription("Jump Strength").setShouldWatch(true);
	private static final DataParameter<Byte> STATUS = EntityDataManager.<Byte>createKey(EntityReindeer.class, DataSerializers.BYTE);
	private int eatingCounter;
	private int openMouthCounter;
	private int jumpRearingCounter;
	public int tailCounter;
	public int sprintCounter;
	protected boolean reindeerJumping;
	/** "The higher this value, the more likely the reindeer is to be tamed next time a player rides it." */
	protected int temper;
	protected float jumpPower;
	private boolean allowStandSliding;
	private float headLean;
	private float prevHeadLean;
	private float rearingAmount;
	private float prevRearingAmount;
	private float mouthOpenness;
	private float prevMouthOpenness;
	protected boolean canGallop = true;
	/** Used to determine the sound that the reindeer should make when it steps */
	protected int gallopTime;
	public boolean parentRudolph = false;

	public EntityReindeer(World worldIn) {
		super(MobRegistry.getType(EntityReindeer.class), worldIn);
		this.setSize(1.3964844F, 1.8F);
		this.stepHeight = 1.0F;
	}

	protected void initEntityAI()
	{
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIPanic(this, 1.2D));
		this.tasks.addTask(2, new EntityAIMate(this, 1.0D, EntityReindeer.class));
		this.tasks.addTask(4, new EntityAIFollowParent(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWanderAvoidWater(this, 0.7D));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
	}

	protected void registerData()
	{
		super.registerData();
		this.dataManager.register(STATUS, Byte.valueOf((byte)0));
		this.dataManager.register(TYPE_NUMBER, Integer.valueOf(0));
	}


	// Implementation
	public boolean processInteract(EntityPlayer player, EnumHand hand)
	{
		ItemStack itemstack = player.getHeldItem(hand);
		boolean flag = !itemstack.isEmpty();

		if (flag && itemstack.getItem() instanceof ItemSpawnEgg)
		{
			return super.processInteract(player, hand);
		}
		else
		{
			if (!this.isChild())
			{
				if (player.isSneaking())
				{
					return false;
				}

				if (this.isBeingRidden())
				{
					return super.processInteract(player, hand);
				}
			}

			if (flag)
			{
				if (this.handleEating(player, itemstack))
				{
					if (!player.isCreative())
					{
						itemstack.shrink(1);
					}

					return true;
				}

				if (itemstack.interactWithEntity(player, this, hand))
				{
					return true;
				}

			}

			if (this.isChild())
			{
				return super.processInteract(player, hand);
			}
			else
			{
				this.mountTo(player);
				return true;
			}
		}
	}

	/**
	 * Returns true if the mob is currently able to mate with the specified mob.
	 */
	public boolean canMateWith(EntityAnimal otherAnimal)
	{
		if (otherAnimal == this)
		{
			return false;
		}
		else if (!(otherAnimal instanceof EntityReindeer))
		{
			return false;
		}
		else
		{
			return this.canMate() && ((EntityReindeer)otherAnimal).canMate();
		}
	}

	public EntityAgeable createChild(EntityAgeable ageable)
	{
		EntityReindeer reindeer = new EntityReindeer(this.world);
		this.setOffspringAttributes(ageable, reindeer);
		if(ageable instanceof EntityReindeer) {
			EntityReindeer other = (EntityReindeer) ageable;
			if(other.getTypeNumber() > 4) { // if one of them is red-nosed make that one take dominance
				reindeer.setType(other.getTypeNumber());
			} else { // none are red-nosed, just use this one's type
				reindeer.setType(this.getTypeNumber());
			}
			
			if(other.getCustomNameTag().equalsIgnoreCase("rudolph") || this.getCustomNameTag().equalsIgnoreCase("rudolph")) {
				reindeer.parentRudolph = true;
			}
		} else { // same as above
			reindeer.setType(this.getTypeNumber());
		}
		return reindeer;
	}



	// Abstract Reindeer

	protected boolean getReindeerWatchableBoolean(int p_110233_1_)
	{
		return (((Byte)this.dataManager.get(STATUS)).byteValue() & p_110233_1_) != 0;
	}

	protected void setReindeerWatchableBoolean(int p_110208_1_, boolean p_110208_2_)
	{
		byte b0 = ((Byte)this.dataManager.get(STATUS)).byteValue();

		if (p_110208_2_)
		{
			this.dataManager.set(STATUS, Byte.valueOf((byte)(b0 | p_110208_1_)));
		}
		else
		{
			this.dataManager.set(STATUS, Byte.valueOf((byte)(b0 & ~p_110208_1_)));
		}
	}

	public float getReindeerSize()
	{
		return 0.5F;
	}

	/**
	 * "Sets the scale for an ageable entity according to the boolean parameter, which says if it's a child."
	 */
	public void setScaleForAge(boolean child)
	{
		this.setScale(child ? this.getReindeerSize() : 1.0F);
	}

	public boolean isReindeerJumping()
	{
		return this.reindeerJumping;
	}


	public void setReindeerJumping(boolean jumping)
	{
		this.reindeerJumping = jumping;
	}

	public boolean canBeLeashedTo(EntityPlayer player)
	{
		return super.canBeLeashedTo(player) && this.getCreatureAttribute() != EnumCreatureAttribute.UNDEAD;
	}

	protected void onLeashDistance(float p_142017_1_)
	{
		if (p_142017_1_ > 6.0F && this.isEatingHaystack())
		{
			this.setEatingHaystack(false);
		}
	}

	public boolean isEatingHaystack()
	{
		return this.getReindeerWatchableBoolean(16);
	}

	public boolean isRearing()
	{
		return this.getReindeerWatchableBoolean(32);
	}

	public boolean isBreeding()
	{
		return this.getReindeerWatchableBoolean(8);
	}

	public void setBreeding(boolean breeding)
	{
		this.setReindeerWatchableBoolean(8, breeding);
	}

	public int getTemper()
	{
		return this.temper;
	}

	public void setTemper(int temperIn)
	{
		this.temper = temperIn;
	}

	public int increaseTemper(int p_110198_1_)
	{
		int i = MathHelper.clamp(this.getTemper() + p_110198_1_, 0, this.getMaxTemper());
		this.setTemper(i);
		return i;
	}

	/**
	 * Called when the entity is attacked.
	 */
	public boolean attackEntityFrom(DamageSource source, float amount)
	{
		Entity entity = source.getTrueSource();
		return this.isBeingRidden() && entity != null && this.isRidingOrBeingRiddenBy(entity) ? false : super.attackEntityFrom(source, amount);
	}

	/**
	 * Returns true if this entity should push and be pushed by other entities when colliding.
	 */
	public boolean canBePushed()
	{
		return !this.isBeingRidden();
	}

	private void eatingReindeer()
	{
		this.openReindeerMouth();

		if (!this.isSilent())
		{
			this.world.playSound((EntityPlayer)null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_HORSE_EAT, this.getSoundCategory(), 1.0F, 1.0F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F);
		}
	}

	public void fall(float distance, float damageMultiplier)
	{
		if (distance > 1.0F)
		{
			this.playSound(SoundEvents.ENTITY_HORSE_LAND, 0.4F, 1.0F);
		}

		int i = MathHelper.ceil((distance * 0.5F - 3.0F) * damageMultiplier);

		if (i > 0)
		{
			this.attackEntityFrom(DamageSource.FALL, (float)i);

			if (this.isBeingRidden())
			{
				for (Entity entity : this.getRecursivePassengers())
				{
					entity.attackEntityFrom(DamageSource.FALL, (float)i);
				}
			}
			BlockPos pos = new BlockPos(this.posX, this.posY - 0.2D - (double)this.prevRotationYaw, this.posZ);
			IBlockState iblockstate = this.world.getBlockState(pos);
			Block block = iblockstate.getBlock();

			if (iblockstate.getMaterial() != Material.AIR && !this.isSilent())
			{
				SoundType soundtype = block.getSoundType(block.getDefaultState(), this.world, pos, this);
				this.world.playSound((EntityPlayer)null, this.posX, this.posY, this.posZ, soundtype.getStepSound(), this.getSoundCategory(), soundtype.getVolume() * 0.5F, soundtype.getPitch() * 0.75F);
			}
		}
	}


	@Nullable
	protected EntityReindeer getClosestReindeer(Entity entityIn, double distance)
	{
		double d0 = Double.MAX_VALUE;
		Entity entity = null;

		for (Entity entity1 : this.world.getEntitiesInAABBexcluding(entityIn, entityIn.getBoundingBox().expand(distance, distance, distance), IS_REINDEER_BREEDING))
		{
			double d1 = entity1.getDistanceSq(entityIn.posX, entityIn.posY, entityIn.posZ);

			if (d1 < d0)
			{
				entity = entity1;
				d0 = d1;
			}
		}

		return (EntityReindeer)entity;
	}

	public double getReindeerJumpStrength()
	{
		return this.getAttribute(JUMP_STRENGTH).getValue();
	}

	@Nullable
	protected SoundEvent getDeathSound()
	{
		this.openReindeerMouth();
		return null;
	}

	@Nullable
	protected SoundEvent getHurtSound(DamageSource damageSourceIn)
	{
		this.openReindeerMouth();

		if (this.rand.nextInt(3) == 0)
		{
			this.makeReindeerRear();
		}

		return null;
	}

	@Nullable
	protected SoundEvent getAmbientSound()
	{
		this.openReindeerMouth();

		if (this.rand.nextInt(10) == 0 && !this.isMovementBlocked())
		{
			this.makeReindeerRear();
		}

		return null;
	}

	@Nullable
	protected SoundEvent getAngrySound()
	{
		this.openReindeerMouth();
		this.makeReindeerRear();
		return null;
	}

	protected void playStepSound(BlockPos pos, Block blockIn)
	{
		if (!blockIn.getDefaultState().getMaterial().isLiquid())
		{
			SoundType soundtype = blockIn.getSoundType(blockIn.getDefaultState(), this.world, pos, this);

			if (this.world.getBlockState(pos.up()).getBlock() == Blocks.SNOW_LAYER)
			{
				soundtype = Blocks.SNOW_LAYER.getSoundType(Blocks.SNOW_LAYER.getDefaultState(), this.world, pos, this);
			}

			if (this.isBeingRidden() && this.canGallop)
			{
				++this.gallopTime;

				if (this.gallopTime > 5 && this.gallopTime % 3 == 0)
				{
					this.playGallopSound(soundtype);
				}
				else if (this.gallopTime <= 5)
				{
					this.playSound(SoundEvents.ENTITY_HORSE_STEP_WOOD, soundtype.getVolume() * 0.15F, soundtype.getPitch());
				}
			}
			else if (soundtype == SoundType.WOOD)
			{
				this.playSound(SoundEvents.ENTITY_HORSE_STEP_WOOD, soundtype.getVolume() * 0.15F, soundtype.getPitch());
			}
			else
			{
				this.playSound(SoundEvents.ENTITY_HORSE_STEP, soundtype.getVolume() * 0.15F, soundtype.getPitch());
			}
		}
	}

	protected void playGallopSound(SoundType p_190680_1_)
	{
		this.playSound(SoundEvents.ENTITY_HORSE_GALLOP, p_190680_1_.getVolume() * 0.15F, p_190680_1_.getPitch());
	}

	protected void registerAttributes()
	{
		super.registerAttributes();
		this.getAttributeMap().registerAttribute(JUMP_STRENGTH);
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(53.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.22499999403953552D);
	}

	/**
	 * Will return how many at most can spawn in a chunk at once.
	 */
	public int getMaxSpawnedInChunk()
	{
		return 6;
	}

	public int getMaxTemper()
	{
		return 100;
	}

	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	protected float getSoundVolume()
	{
		return 0.8F;
	}

	/**
	 * Get number of ticks, at least during which the living entity will be silent.
	 */
	public int getTalkInterval()
	{
		return 400;
	}

	protected boolean handleEating(EntityPlayer player, ItemStack stack)
	{
		boolean flag = false;
		float f = 0.0F;
		int i = 0;
		int j = 0;
		Item item = stack.getItem();

		if (item == Items.WHEAT || item == Items.CARROT)
		{
			f = 2.0F;
			i = 20;
			j = 3;
			if(!this.isChild() && !this.isInLove()) {
				flag = true;
				this.setInLove(player);
			}
		}
		else if (item == Items.SUGAR)
		{
			f = 1.0F;
			i = 30;
			j = 3;
		}
		else if (item == Item.getItemFromBlock(Blocks.HAY_BLOCK))
		{
			f = 20.0F;
			i = 180;
		}
		else if (item == Items.APPLE)
		{
			f = 3.0F;
			i = 60;
			j = 3;
		}
		else if (item == Items.GOLDEN_CARROT)
		{
			f = 4.0F;
			i = 60;
			j = 5;

			if (this.getGrowingAge() == 0 && !this.isInLove())
			{
				flag = true;
				this.setInLove(player);
			}
		}
		else if (item == Items.GOLDEN_APPLE)
		{
			f = 10.0F;
			i = 240;
			j = 10;

			if (this.getGrowingAge() == 0 && !this.isInLove())
			{
				flag = true;
				this.setInLove(player);
			}
		}

		if (this.getHealth() < this.getMaxHealth() && f > 0.0F)
		{
			this.heal(f);
			flag = true;
		}

		if (this.isChild() && i > 0)
		{
			this.world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + 0.5D + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, 0.0D, 0.0D, 0.0D);

			if (!this.world.isRemote)
			{
				this.addGrowth(i);
			}

			flag = true;
		}

		if (j > 0 && (flag) && this.getTemper() < this.getMaxTemper())
		{
			flag = true;

			if (!this.world.isRemote)
			{
				this.increaseTemper(j);
			}
		}

		if (flag)
		{
			this.eatingReindeer();
		}

		return flag;
	}
	
	@Override
	public void onDeath(DamageSource cause) {
		if(!this.isChild()) {
			if(this.rand.nextInt(12) == 0) {
				ItemStack stack = new ItemStack(BlockRegistry.reindeerhead.getItemBlock());
				stack.setTagCompound(new NBTTagCompound());
				stack.getTagCompound().setInteger("TYPENUM", this.getTypeNumber());
				this.entityDropItem(stack, 0.5F);
			}
		}
	}
	
	@Override
	@Nullable
	protected ResourceLocation getLootTable()
	{
		return LootTableRegistry.reindeer;
	}

	protected void mountTo(EntityPlayer player)
	{
		player.rotationYaw = this.rotationYaw;
		player.rotationPitch = this.rotationPitch;
		this.setEatingHaystack(false);
		this.setRearing(false);

		if (!this.world.isRemote)
		{
			player.startRiding(this);
		}
	}

	/**
	 * Dead and sleeping entities cannot move
	 */
	protected boolean isMovementBlocked()
	{
		return super.isMovementBlocked() && this.isBeingRidden() && true || this.isEatingHaystack() || this.isRearing();
	}

	/**
	 * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
	 * the animal type)
	 */
	public boolean isBreedingItem(ItemStack stack)
	{
		return false;
	}

	private void moveTail()
	{
		this.tailCounter = 1;
	}

	/**
	 * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
	 * use this to react to sunlight and start to burn.
	 */
	public void livingTick()
	{
		if (this.rand.nextInt(200) == 0)
		{
			this.moveTail();
		}

		super.livingTick();
		if(this.rand.nextInt(10) == 0) {
			this.world.spawnParticle(EnumParticleTypes.SNOW_SHOVEL, this.posX + this.rand.nextInt(4) - 2F, this.posY + this.rand.nextInt(4), this.posZ + this.rand.nextInt(4) - 2F, 0F, -0.005F, 0F);
		}
		if (!this.world.isRemote)
		{
			if (this.rand.nextInt(900) == 0 && this.deathTime == 0)
			{
				this.heal(1.0F);
			}

			if (this.canEatGrass())
			{
				if (!this.isEatingHaystack() && !this.isBeingRidden() && this.rand.nextInt(300) == 0 && this.world.getBlockState(new BlockPos(MathHelper.floor(this.posX), MathHelper.floor(this.posY) - 1, MathHelper.floor(this.posZ))).getBlock() == Blocks.GRASS)
				{
					this.setEatingHaystack(true);
				}

				if (this.isEatingHaystack() && ++this.eatingCounter > 50)
				{
					this.eatingCounter = 0;
					this.setEatingHaystack(false);
				}
			}


			this.followMother();
		}
	}

	protected void followMother()
	{
		if (this.isBreeding() && this.isChild() && !this.isEatingHaystack())
		{
			EntityReindeer reindeer = this.getClosestReindeer(this, 16.0D);

			if (reindeer != null && this.getDistanceSq(reindeer) > 4.0D)
			{
				this.navigator.getPathToEntityLiving(reindeer);
			}
		}
	}

	public boolean canEatGrass()
	{
		return true;
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void tick()
	{
		super.tick();

		if (this.openMouthCounter > 0 && ++this.openMouthCounter > 30)
		{
			this.openMouthCounter = 0;
			this.setReindeerWatchableBoolean(64, false);
		}

		if (this.canPassengerSteer() && this.jumpRearingCounter > 0 && ++this.jumpRearingCounter > 20)
		{
			this.jumpRearingCounter = 0;
			this.setRearing(false);
		}

		if (this.tailCounter > 0 && ++this.tailCounter > 8)
		{
			this.tailCounter = 0;
		}

		if (this.sprintCounter > 0)
		{
			++this.sprintCounter;

			if (this.sprintCounter > 300)
			{
				this.sprintCounter = 0;
			}
		}

		this.prevHeadLean = this.headLean;

		if (this.isEatingHaystack())
		{
			this.headLean += (1.0F - this.headLean) * 0.4F + 0.05F;

			if (this.headLean > 1.0F)
			{
				this.headLean = 1.0F;
			}
		}
		else
		{
			this.headLean += (0.0F - this.headLean) * 0.4F - 0.05F;

			if (this.headLean < 0.0F)
			{
				this.headLean = 0.0F;
			}
		}

		this.prevRearingAmount = this.rearingAmount;

		if (this.isRearing())
		{
			this.headLean = 0.0F;
			this.prevHeadLean = this.headLean;
			this.rearingAmount += (1.0F - this.rearingAmount) * 0.4F + 0.05F;

			if (this.rearingAmount > 1.0F)
			{
				this.rearingAmount = 1.0F;
			}
		}
		else
		{
			this.allowStandSliding = false;
			this.rearingAmount += (0.8F * this.rearingAmount * this.rearingAmount * this.rearingAmount - this.rearingAmount) * 0.6F - 0.05F;

			if (this.rearingAmount < 0.0F)
			{
				this.rearingAmount = 0.0F;
			}
		}

		this.prevMouthOpenness = this.mouthOpenness;

		if (this.getReindeerWatchableBoolean(64))
		{
			this.mouthOpenness += (1.0F - this.mouthOpenness) * 0.7F + 0.05F;

			if (this.mouthOpenness > 1.0F)
			{
				this.mouthOpenness = 1.0F;
			}
		}
		else
		{
			this.mouthOpenness += (0.0F - this.mouthOpenness) * 0.7F - 0.05F;

			if (this.mouthOpenness < 0.0F)
			{
				this.mouthOpenness = 0.0F;
			}
		}
	}

	private void openReindeerMouth()
	{
		if (!this.world.isRemote)
		{
			this.openMouthCounter = 1;
			this.setReindeerWatchableBoolean(64, true);
		}
	}

	public void setEatingHaystack(boolean p_110227_1_)
	{
		this.setReindeerWatchableBoolean(16, p_110227_1_);
	}

	public void setRearing(boolean rearing)
	{
		if (rearing)
		{
			this.setEatingHaystack(false);
		}

		this.setReindeerWatchableBoolean(32, rearing);
	}

	private void makeReindeerRear()
	{
		if (this.canPassengerSteer())
		{
			this.jumpRearingCounter = 1;
			this.setRearing(true);
		}
	}

	public void travel(float strafe, float vertical, float forward)
	{
		if (this.isBeingRidden() && this.canBeSteered())
		{
			EntityLivingBase entitylivingbase = (EntityLivingBase)this.getControllingPassenger();
			this.rotationYaw = entitylivingbase.rotationYaw;
			this.prevRotationYaw = this.rotationYaw;
			this.rotationPitch = entitylivingbase.rotationPitch * 0.5F;
			this.setRotation(this.rotationYaw, this.rotationPitch);
			this.renderYawOffset = this.rotationYaw;
			this.rotationYawHead = this.renderYawOffset;
			strafe = entitylivingbase.moveStrafing * 0.5F;
			forward = entitylivingbase.moveForward;

			if (forward <= 0.0F)
			{
				forward *= 0.25F;
				this.gallopTime = 0;
			}

			if (this.onGround && this.jumpPower == 0.0F && this.isRearing() && !this.allowStandSliding)
			{
				strafe = 0.0F;
				forward = 0.0F;
			}

			if (this.jumpPower > 0.0F && !this.isReindeerJumping() && this.onGround)
			{
				this.motionY = this.getReindeerJumpStrength() * (double)this.jumpPower;

				if (this.isPotionActive(MobEffects.JUMP_BOOST))
				{
					this.motionY += (double)((float)(this.getActivePotionEffect(MobEffects.JUMP_BOOST).getAmplifier() + 1) * 0.1F);
				}

				this.setReindeerJumping(true);
				this.isAirBorne = true;

				if (forward > 0.0F)
				{
					float f = MathHelper.sin(this.rotationYaw * 0.017453292F);
					float f1 = MathHelper.cos(this.rotationYaw * 0.017453292F);
					this.motionX += (double)(-0.4F * f * this.jumpPower);
					this.motionZ += (double)(0.4F * f1 * this.jumpPower);
					this.playSound(SoundEvents.ENTITY_HORSE_JUMP, 0.4F, 1.0F);
				}

				this.jumpPower = 0.0F;
			}

			this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;

			if (this.canPassengerSteer())
			{
				this.setAIMoveSpeed((float)this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue());
				super.travel(strafe, vertical, forward);
			}
			else if (entitylivingbase instanceof EntityPlayer)
			{
				this.motionX = 0.0D;
				this.motionY = 0.0D;
				this.motionZ = 0.0D;
			}

			if (this.onGround)
			{
				this.jumpPower = 0.0F;
				this.setReindeerJumping(false);
			}

			this.prevLimbSwingAmount = this.limbSwingAmount;
			double d1 = this.posX - this.prevPosX;
			double d0 = this.posZ - this.prevPosZ;
			float f2 = MathHelper.sqrt(d1 * d1 + d0 * d0) * 4.0F;

			if (f2 > 1.0F)
			{
				f2 = 1.0F;
			}

			this.limbSwingAmount += (f2 - this.limbSwingAmount) * 0.4F;
			this.limbSwing += this.limbSwingAmount;
		}
		else
		{
			this.jumpMovementFactor = 0.02F;
			super.travel(strafe, vertical, forward);
		}
	}
	
	

	@Override
	public void setCustomNameTag(String name) {
		if(name.toLowerCase().equals("rudolph")) {
			if(this.getTypeNumber() <= 4) {
				this.setType(this.getTypeNumber() + 4);
			}
		}
		super.setCustomNameTag(name);
	}



	private static final DataParameter<Integer> TYPE_NUMBER = EntityDataManager.<Integer>createKey(EntityReindeer.class, DataSerializers.VARINT);

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
	public boolean writeUnlessRemoved(NBTTagCompound compound)
	{
		super.writeUnlessRemoved(compound);
		compound.setBoolean("EatingHaystack", this.isEatingHaystack());
		compound.setBoolean("Bred", this.isBreeding());
		compound.setInt("Temper", this.getTemper());

		compound.setInt("TypeNumber", this.getTypeNumber());
		compound.setBoolean("IsParentRudolph", this.parentRudolph );
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void read(NBTTagCompound compound)
	{
		super.read(compound);
		this.setEatingHaystack(compound.getBoolean("EatingHaystack"));
		this.setBreeding(compound.getBoolean("Bred"));
		this.setTemper(compound.getInt("Temper"));
		this.parentRudolph = compound.getBoolean("IsParentRudolph");

		IAttributeInstance iattributeinstance = this.getAttributeMap().getAttributeInstanceByName("Speed");

		if (iattributeinstance != null)
		{
			this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(iattributeinstance.getBaseValue() * 0.25D);
		}


		this.setType(compound.getInt("TypeNumber"));
		Calendar calendar = Calendar.getInstance();
		if(this.getTypeNumber() > 4 && !(calendar.get(2) + 1 == 12 && calendar.get(5) >= 22 && calendar.get(5) <= 28) && !(this.getCustomNameTag().toLowerCase().equals("rudolph") || this.parentRudolph)) {
			this.setType(this.getTypeNumber() - 4); // Remove red noses after Christmas season after loading entity
		}
	}


	/**
	 * Return true if the reindeer entity ready to mate. (no rider, not riding, tame, adult, not sterile...)
	 */
	protected boolean canMate()
	{
		return !this.isBeingRidden() && !this.isRiding() && !this.isChild() && this.getHealth() >= this.getMaxHealth() && this.isInLove();
	}


	protected void setOffspringAttributes(EntityAgeable p_190681_1_, EntityReindeer p_190681_2_)
	{
		double d0 = this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).getBaseValue() + p_190681_1_.getAttribute(SharedMonsterAttributes.MAX_HEALTH).getBaseValue() + (double)this.getModifiedMaxHealth();
		p_190681_2_.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(d0 / 3.0D);
		double d1 = this.getAttribute(JUMP_STRENGTH).getBaseValue() + p_190681_1_.getAttribute(JUMP_STRENGTH).getBaseValue() + this.getModifiedJumpStrength();
		p_190681_2_.getAttribute(JUMP_STRENGTH).setBaseValue(d1 / 3.0D);
		double d2 = this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getBaseValue() + p_190681_1_.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getBaseValue() + this.getModifiedMovementSpeed();
		p_190681_2_.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(d2 / 3.0D);
	}

	/**
	 * returns true if all the conditions for steering the entity are met. For pigs, this is true if it is being ridden
	 * by a player and the player is holding a carrot-on-a-stick
	 */
	public boolean canBeSteered()
	{
		return this.getControllingPassenger() instanceof EntityLivingBase;
	}

	@OnlyIn(Dist.CLIENT)
	public float getGrassEatingAmount(float p_110258_1_)
	{
		return this.prevHeadLean + (this.headLean - this.prevHeadLean) * p_110258_1_;
	}

	@OnlyIn(Dist.CLIENT)
	public float getRearingAmount(float p_110223_1_)
	{
		return this.prevRearingAmount + (this.rearingAmount - this.prevRearingAmount) * p_110223_1_;
	}

	@OnlyIn(Dist.CLIENT)
	public float getMouthOpennessAngle(float p_110201_1_)
	{
		return this.prevMouthOpenness + (this.mouthOpenness - this.prevMouthOpenness) * p_110201_1_;
	}

	@OnlyIn(Dist.CLIENT)
	public void setJumpPower(int jumpPowerIn)
	{
		if (jumpPowerIn < 0)
		{
			jumpPowerIn = 0;
		}
		else
		{
			this.allowStandSliding = true;
			this.makeReindeerRear();
		}

		if (jumpPowerIn >= 90)
		{
			this.jumpPower = 1.0F;
		}
		else
		{
			this.jumpPower = 0.4F + 0.4F * (float)jumpPowerIn / 90.0F;
		}
	}

	public boolean canJump()
	{
		return true;
	}

	public void handleStartJump(int p_184775_1_)
	{
		this.allowStandSliding = true;
		this.makeReindeerRear();
	}

	public void handleStopJump()
	{
	}

	/**
	 * "Spawns particles for the reindeer entity. par1 tells whether to spawn hearts. If it is false, it spawns smoke."
	 */
	@OnlyIn(Dist.CLIENT)
	protected void spawnReindeerParticles(boolean p_110216_1_)
	{
		EnumParticleTypes enumparticletypes = p_110216_1_ ? EnumParticleTypes.HEART : EnumParticleTypes.SMOKE_NORMAL;

		for (int i = 0; i < 7; ++i)
		{
			double d0 = this.rand.nextGaussian() * 0.02D;
			double d1 = this.rand.nextGaussian() * 0.02D;
			double d2 = this.rand.nextGaussian() * 0.02D;
			this.world.spawnParticle(enumparticletypes, this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + 0.5D + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, d0, d1, d2);
		}
	}

	/**
	 * Handler for {@link World#setEntityState}
	 */
	@OnlyIn(Dist.CLIENT)
	public void handleStatusUpdate(byte id)
	{
		if (id == 7)
		{
			this.spawnReindeerParticles(true);
		}
		else if (id == 6)
		{
			this.spawnReindeerParticles(false);
		}
		else
		{
			super.handleStatusUpdate(id);
		}
	}

	public void updatePassenger(Entity passenger)
	{
		super.updatePassenger(passenger);

		if (passenger instanceof EntityLiving)
		{
			EntityLiving entityliving = (EntityLiving)passenger;
			this.renderYawOffset = entityliving.renderYawOffset;
		}

		if (this.prevRearingAmount > 0.0F)
		{
			float f3 = MathHelper.sin(this.renderYawOffset * 0.017453292F);
			float f = MathHelper.cos(this.renderYawOffset * 0.017453292F);
			float f1 = 0.7F * this.prevRearingAmount;
			float f2 = 0.15F * this.prevRearingAmount;
			passenger.setPosition(this.posX + (double)(f1 * f3), this.posY + this.getMountedYOffset() + passenger.getYOffset() + (double)f2, this.posZ - (double)(f1 * f));

			if (passenger instanceof EntityLivingBase)
			{
				((EntityLivingBase)passenger).renderYawOffset = this.renderYawOffset;
			}
		}
	}

	/**
	 * Returns randomized max health
	 */
	protected float getModifiedMaxHealth()
	{
		return 15.0F + (float)this.rand.nextInt(8) + (float)this.rand.nextInt(9);
	}

	/**
	 * Returns randomized jump strength
	 */
	protected double getModifiedJumpStrength()
	{
		return 0.4000000059604645D + this.rand.nextDouble() * 0.2D + this.rand.nextDouble() * 0.2D + this.rand.nextDouble() * 0.2D;
	}

	/**
	 * Returns randomized movement speed
	 */
	protected double getModifiedMovementSpeed()
	{
		return (0.44999998807907104D + this.rand.nextDouble() * 0.3D + this.rand.nextDouble() * 0.3D + this.rand.nextDouble() * 0.3D) * 0.25D;
	}

	/**
	 * Returns true if this entity should move as if it were on a ladder (either because it's actually on a ladder, or
	 * for AI reasons)
	 */
	public boolean isOnLadder()
	{
		return false;
	}

	public float getEyeHeight()
	{
		return this.height;
	}

	public boolean wearsArmor()
	{
		return false;
	}

	public boolean isArmor(ItemStack stack)
	{
		return false;
	}

	/**
	 * For vehicles, the first passenger is generally considered the controller and "drives" the vehicle. For example,
	 * Pigs, Horses, and Boats are generally "steered" by the controlling passenger.
	 */
	@Nullable
	public Entity getControllingPassenger()
	{
		return this.getPassengers().isEmpty() ? null : (Entity)this.getPassengers().get(0);
	}

	/**
	 * Called only once on an entity when first time spawned, via egg, mob spawner, natural spawning etc, but not called
	 * when entity is reloaded from nbt. Mainly used for initializing attributes and inventory
	 */
	@Nullable
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata, NBTTagCompound compound)
	{
		livingdata = super.onInitialSpawn(difficulty, livingdata, compound);

		if(!this.isChild()) {
			Calendar calendar = Calendar.getInstance();
			boolean isChristmasSeason = calendar.get(2) + 1 == 12 && calendar.get(5) >= 22 && calendar.get(5) <= 28;
			boolean redNosed = this.rand.nextInt(9) == 0;
			int i = this.rand.nextInt(4) + (isChristmasSeason && redNosed ? 5 : 1); // Values 1 to 4 or 1 to 8 (with 1/9 chance and only during christmas)
			boolean flag = false;

			if (livingdata instanceof TypeData)
			{
				i = ((TypeData)livingdata).typeData;
				flag = true;
			}
			else
			{
				livingdata = new TypeData(i);
			}

			this.setType(i);

			if (flag)
			{
				this.setGrowingAge(-24000);
			}
		}
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


}
