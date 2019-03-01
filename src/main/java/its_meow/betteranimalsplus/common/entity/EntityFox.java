package its_meow.betteranimalsplus.common.entity;

import javax.annotation.Nullable;

import its_meow.betteranimalsplus.init.MobRegistry;
import its_meow.betteranimalsplus.util.HeadTypes;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISit;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.init.Particles;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemFood;
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
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class EntityFox extends EntityTameable {

	protected static final DataParameter<Float> DATA_HEALTH_ID = EntityDataManager.<Float>createKey(EntityFox.class,
			DataSerializers.FLOAT);
	protected static final DataParameter<Integer> TYPE_NUMBER = EntityDataManager.<Integer>createKey(EntityFox.class,
			DataSerializers.VARINT);
	/** Float used to smooth the rotation of the wolf head */
	protected float headRotationCourse;
	protected float headRotationCourseOld;
	/** true is the wolf is wet else false */
	protected boolean isWet;
	/** True if the wolf is shaking else False */
	protected boolean isShaking;
	/**
	 * This time increases while wolf is shaking and emitting water particles.
	 */
	protected float timeWolfIsShaking;
	protected float prevTimeWolfIsShaking;

	public EntityFox(World worldIn) {
		super(MobRegistry.getType(EntityFox.class), worldIn);
		this.world = worldIn;
		this.setSize(0.8F, 0.9F);
		this.setTamed(false);
	}

	@Override
	protected void initEntityAI() {
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
		this.targetTasks.addTask(4,
				new EntityAITargetNonTamed<>(this, EntityRabbit.class, false, new NullPredicate()));
		this.targetTasks.addTask(4,
				new EntityAITargetNonTamed<>(this, EntityChicken.class, false, new NullPredicate()));
	}

	public int getTypeNumber() {
		return this.dataManager.get(EntityFox.TYPE_NUMBER).intValue();
	}

	public void setType(int typeId) {
		this.dataManager.set(EntityFox.TYPE_NUMBER, Integer.valueOf(typeId));
	}

	@Override
	public boolean writeUnlessRemoved(NBTTagCompound compound) {
		compound.setInt("TypeNumber", this.getTypeNumber());
		return super.writeUnlessRemoved(compound);
	}

	@Override
	public void read(NBTTagCompound compound) {
		super.read(compound);
		this.setType(compound.getInt("TypeNumber"));
	}

	/**
	 * Called only once on an entity when first time spawned, via egg, mob
	 * spawner, natural spawning etc, but not called when entity is reloaded
	 * from nbt. Mainly used for initializing attributes and inventory
	 */
	@Override
	@Nullable
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata,
			NBTTagCompound compound) {
		livingdata = super.onInitialSpawn(difficulty, livingdata, compound);
		int i = this.rand.nextInt(4) + 1;

		if(livingdata instanceof EntityFox.TypeData) {
			i = ((EntityFox.TypeData) livingdata).typeData;
		} else {
			livingdata = new EntityFox.TypeData(i);
		}

		this.setType(i);

		return livingdata;
	}

	public static class TypeData implements IEntityLivingData {

		public int typeData;

		public TypeData(int type) {
			this.typeData = type;
		}
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30000001192092896D);

		if(this.isTamed()) {
			this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
		} else {
			this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
		}

		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
	}

	@Override
	protected void updateAITasks() {
		this.dataManager.set(EntityFox.DATA_HEALTH_ID, Float.valueOf(this.getHealth()));
	}

	@Override
	protected void registerData() {
		super.registerData();
		this.dataManager.register(EntityFox.DATA_HEALTH_ID, Float.valueOf(this.getHealth()));
		this.dataManager.register(EntityFox.TYPE_NUMBER, Integer.valueOf(0));
	}

	@Override
	public void setAttackTarget(EntityLivingBase entitylivingbaseIn) {
		if(this.world.getDifficulty() == EnumDifficulty.PEACEFUL) {
			super.setAttackTarget(null);
		} else {
			super.setAttackTarget(entitylivingbaseIn);
		}
	}

	protected void playStepSound(BlockPos pos, Block blockIn) {
		this.playSound(SoundEvents.ENTITY_WOLF_STEP, 0.15F, 1.0F);
	}
	
	@Override
	public void onDeath(DamageSource cause) {
		super.onDeath(cause);
		if(!world.isRemote && !this.isChild()) {
			if(this.rand.nextInt(12) == 0) {
				ItemStack stack = new ItemStack(HeadTypes.WOLFHEAD.getItem(this.getTypeNumber()));
				this.entityDropItem(stack, 0.5F);
			}
		}
	}

	@Override
	protected SoundEvent getAmbientSound() {
		if(this.rand.nextInt(3) == 0) {
			return this.isTamed() && this.dataManager.get(EntityFox.DATA_HEALTH_ID).floatValue() < 10.0F
					? SoundEvents.ENTITY_WOLF_WHINE
					: SoundEvents.ENTITY_WOLF_PANT;
		}
		return null;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_WOLF_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_WOLF_DEATH;
	}

	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	@Override
	protected float getSoundVolume() {
		return 0.4F;
	}

	@Override
	@Nullable
	protected ResourceLocation getLootTable() {
		return LootTableList.ENTITIES_WOLF;
	}

	/**
	 * Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn.
	 */
	@Override
	public void livingTick() {
		super.livingTick();

		if(!this.world.isRemote && this.isWet && !this.isShaking && !this.hasPath() && this.onGround) {
			this.isShaking = true;
			this.timeWolfIsShaking = 0.0F;
			this.prevTimeWolfIsShaking = 0.0F;
			this.world.setEntityState(this, (byte) 8);
		}
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	@Override
	public void tick() {
		super.tick();
		this.headRotationCourseOld = this.headRotationCourse;


		this.headRotationCourse += (0.0F - this.headRotationCourse) * 0.4F;


		if(this.isWet()) {
			this.isWet = true;
			this.isShaking = false;
			this.timeWolfIsShaking = 0.0F;
			this.prevTimeWolfIsShaking = 0.0F;
		} else if((this.isWet || this.isShaking) && this.isShaking) {
			if(this.timeWolfIsShaking == 0.0F) {
				this.playSound(SoundEvents.ENTITY_WOLF_SHAKE, this.getSoundVolume(),
						(this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
			}

			this.prevTimeWolfIsShaking = this.timeWolfIsShaking;
			this.timeWolfIsShaking += 0.05F;

			if(this.prevTimeWolfIsShaking >= 2.0F) {
				this.isWet = false;
				this.isShaking = false;
				this.prevTimeWolfIsShaking = 0.0F;
				this.timeWolfIsShaking = 0.0F;
			}

			if(this.timeWolfIsShaking > 0.4F) {
				float f = (float) this.getBoundingBox().minY;
				int i = (int) (MathHelper.sin((this.timeWolfIsShaking - 0.4F) * (float) Math.PI) * 7.0F);

				for(int j = 0; j < i; ++j) {
					float f1 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;
					float f2 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;
					this.world.spawnParticle(Particles.SPLASH, this.posX + f1, f + 0.8F, this.posZ + f2, this.motionX,
							this.motionY, this.motionZ);
				}
			}
		}
	}

	/**
	 * True if the wolf is wet
	 */
	@OnlyIn(Dist.CLIENT)
	public boolean isWolfWet() {
		return this.isWet;
	}

	/**
	 * Used when calculating the amount of shading to apply while the wolf is
	 * wet.
	 */
	@OnlyIn(Dist.CLIENT)
	public float getShadingWhileWet(float p_70915_1_) {
		return 0.75F + (this.prevTimeWolfIsShaking + (this.timeWolfIsShaking - this.prevTimeWolfIsShaking) * p_70915_1_)
				/ 2.0F * 0.25F;
	}

	@OnlyIn(Dist.CLIENT)
	public float getShakeAngle(float p_70923_1_, float p_70923_2_) {
		float f = (this.prevTimeWolfIsShaking + (this.timeWolfIsShaking - this.prevTimeWolfIsShaking) * p_70923_1_
				+ p_70923_2_) / 1.8F;

		if(f < 0.0F) {
			f = 0.0F;
		} else if(f > 1.0F) {
			f = 1.0F;
		}

		return MathHelper.sin(f * (float) Math.PI) * MathHelper.sin(f * (float) Math.PI * 11.0F) * 0.15F
				* (float) Math.PI;
	}

	@OnlyIn(Dist.CLIENT)
	public float getInterestedAngle(float p_70917_1_) {
		return (this.headRotationCourseOld + (this.headRotationCourse - this.headRotationCourseOld) * p_70917_1_)
				* 0.15F * (float) Math.PI;
	}

	@Override
	public float getEyeHeight() {
		return this.height * 0.8F;
	}

	/**
	 * The speed it takes to move the entityliving's rotationPitch through the
	 * faceEntity method. This is only currently use in wolves.
	 */
	@Override
	public int getVerticalFaceSpeed() {
		return this.isSitting() ? 20 : super.getVerticalFaceSpeed();
	}

	/**
	 * Called when the entity is attacked.
	 */
	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if(this.isInvulnerableTo(source)) {
			return false;
		} else {
			Entity entity = source.getTrueSource();

			if(this.aiSit != null) {
				this.aiSit.setSitting(false);
			}

			if(entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow)) {
				amount = (amount + 1.0F) / 2.0F;
			}

			return super.attackEntityFrom(source, amount);
		}
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this),
				(int) this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue());

		if(flag) {
			this.applyEnchantments(this, entityIn);
		}

		return flag;
	}

	@Override
	public void setTamed(boolean tamed) {
		super.setTamed(tamed);

		if(tamed) {
			this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
		} else {
			this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
		}

		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
	}

	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand) {
		ItemStack itemstack = player.getHeldItem(hand);

		if(this.isTamed()) {
			if(!itemstack.isEmpty()) {
				if(itemstack.getItem() instanceof ItemFood) {
					ItemFood itemfood = (ItemFood) itemstack.getItem();

					if(itemfood.isMeat() && this.dataManager.get(EntityFox.DATA_HEALTH_ID).floatValue() < 20.0F) {
						if(!player.isCreative()) {
							itemstack.shrink(1);
						}

						this.heal(itemfood.getHealAmount(itemstack));
						return true;
					}
				}
			}

			if(this.isOwner(player) && !this.world.isRemote && !this.isBreedingItem(itemstack)
					&& (!(itemstack.getItem() instanceof ItemFood) || !((ItemFood) itemstack.getItem()).isMeat())) {
				this.aiSit.setSitting(!this.isSitting());
				this.isJumping = false;
				this.navigator.clearPath();
				this.setAttackTarget((EntityLivingBase) null);
			}
		} else if(itemstack.getItem() == Items.RABBIT || itemstack.getItem() == Items.CHICKEN) {
			if(!player.isCreative()) {
				itemstack.shrink(1);
			}

			if(!this.world.isRemote) {
				if(this.rand.nextInt(3) == 0
						&& !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
					this.setTamedBy(player);
					this.navigator.clearPath();
					this.setAttackTarget((EntityLivingBase) null);
					this.aiSit.setSitting(true);
					this.setHealth(20.0F);
					this.playTameEffect(true);
					this.world.setEntityState(this, (byte) 7);
				} else {
					this.playTameEffect(false);
					this.world.setEntityState(this, (byte) 6);
				}
			}

			return true;
		}

		return super.processInteract(player, hand);
	}

	/**
	 * Handler for {@link World#setEntityState}
	 */
	@Override
	@OnlyIn(Dist.CLIENT)
	public void handleStatusUpdate(byte id) {
		if(id == 8) {
			this.isShaking = true;
			this.timeWolfIsShaking = 0.0F;
			this.prevTimeWolfIsShaking = 0.0F;
		} else {
			super.handleStatusUpdate(id);
		}
	}

	@OnlyIn(Dist.CLIENT)
	public float getTailRotation() {
		if(!this.isTamed()) {
			return -0.15F;
		} else {
			return this.isTamed()
					? 0.25F - (this.getMaxHealth() - this.dataManager.get(EntityFox.DATA_HEALTH_ID).floatValue())
							* 0.04F
					: -0.85F;
		}
	}

	/**
	 * Checks if the parameter is an item which this animal can be fed to breed
	 * it (wheat, carrots or seeds depending on the animal type)
	 */
	@Override
	public boolean isBreedingItem(ItemStack stack) {
		return stack.getItem() instanceof ItemFood && ((ItemFood) stack.getItem()).isMeat();
	}

	/**
	 * Will return how many at most can spawn in a chunk at once.
	 */
	@Override
	public int getMaxSpawnedInChunk() {
		return 8;
	}

	/**
	 * Returns true if the mob is currently able to mate with the specified mob.
	 */
	@Override
	public boolean canMateWith(EntityAnimal otherAnimal) {
		return false;
	}


	@Override
	public boolean shouldAttackEntity(EntityLivingBase target, EntityLivingBase owner) {
		if(!(target instanceof EntityCreeper) && !(target instanceof EntityGhast)) {
			if(target instanceof EntityFox) {
				EntityFox entityfox = (EntityFox) target;

				if(entityfox.isTamed() && entityfox.getOwner() == owner) {
					return false;
				}
			}

			if(target instanceof EntityPlayer && owner instanceof EntityPlayer
					&& !((EntityPlayer) owner).canAttackPlayer((EntityPlayer) target)) {
				return false;
			} else {
				return !(target instanceof AbstractHorse) || !((AbstractHorse) target).isTame();
			}
		} else {
			return false;
		}
	}

	@Override
	public boolean canBeLeashedTo(EntityPlayer player) {
		return this.isTamed() && super.canBeLeashedTo(player);
	}


	@Override
	public EntityFox createChild(EntityAgeable ageable) {
		return null;
	}

}
