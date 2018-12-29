package its_meow.betteranimalsplus.common.entity;

import javax.annotation.Nullable;

import its_meow.betteranimalsplus.init.LootTableRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityPheasant extends EntityAnimal {

	public float wingRotation;
	public float destPos;
	public float oFlapSpeed;
	public float oFlap;
	public float wingRotDelta = 0.3F;

	public EntityPheasant(World worldIn) {
		super(worldIn);
		this.setPeckTime(getNewPeck());
		this.setPathPriority(PathNodeType.WATER, 0.0F);
		this.setSize(1F, this.isChild() ? 0.8F : 1F);
	}

	@Override
	protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIPanic(this, 1.4D));
		this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(3, new EntityAITempt(this, 1.0D, Items.PUMPKIN_SEEDS, false));
		this.tasks.addTask(4, new EntityAIFollowParent(this, 1.1D));
		this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(4.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
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
		this.destPos = (float)((double)this.destPos + (double)(this.onGround ? -1 : 4) * 0.3D);
		this.destPos = MathHelper.clamp(this.destPos, 0.0F, 1.0F);

		if (!this.onGround && this.wingRotDelta < 1.0F) {
			this.wingRotDelta = 0.3F;
		}

		this.wingRotDelta = (float)((double)this.wingRotDelta * 0.9D);

		if (!this.onGround && this.motionY < 0.0D) {
			this.motionY *= 0.6D;
		}

		this.wingRotation += this.wingRotDelta * 2.0F;

		if(!this.onGround || this.getMoveHelper().isUpdating()) {
			if(this.getPeckTime() <= 61) {
				this.setPeckTime(80);
			}
		}

		if (!this.world.isRemote && this.setPeckTime(this.getPeckTime() - 1) <= 0) {
			this.setPeckTime(getNewPeck());
		}
	}

	public boolean processInteract(EntityPlayer player, EnumHand hand)
	{
		ItemStack itemstack = player.getHeldItem(hand);

		if(itemstack.getItem() == Items.PUMPKIN_SEEDS && !this.isChild()) {
			this.setInLove(player);
			if(!player.capabilities.isCreativeMode) {
				itemstack.shrink(1);
			}
			return true;
		} else {
			return super.processInteract(player, hand);
		}
	}

	@Override
	public void fall(float distance, float damageMultiplier) {}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn)
	{
		return SoundEvents.ENTITY_CHICKEN_HURT;
	}

	@Override
	protected SoundEvent getDeathSound()
	{
		return SoundEvents.ENTITY_CHICKEN_DEATH;
	}

	@Override
	protected void playStepSound(BlockPos pos, Block blockIn)
	{
		this.playSound(SoundEvents.ENTITY_CHICKEN_STEP, 0.15F, 1.0F);
	}

	@Nullable
	protected ResourceLocation getLootTable()
	{
		return LootTableRegistry.pheasant;
	}

	protected void entityInit()
	{
		super.entityInit();
		this.dataManager.register(TYPE_NUMBER, Integer.valueOf(0));
		this.dataManager.register(PECK_TIME, Integer.valueOf(0));
	}

	private static final DataParameter<Integer> PECK_TIME = EntityDataManager.<Integer>createKey(EntityPheasant.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> TYPE_NUMBER = EntityDataManager.<Integer>createKey(EntityPheasant.class, DataSerializers.VARINT);

	public int getPeckTime() {
		return ((Integer)this.dataManager.get(PECK_TIME)).intValue();
	}

	public int setPeckTime(int time)
	{
		this.dataManager.set(PECK_TIME, Integer.valueOf(time));
		return time;
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
		 if(!this.isChild()) {
			 int i = this.rand.nextInt(2) + 1; // Values 1 to 2
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

	 @Override
	 public EntityAgeable createChild(EntityAgeable ageable) {
		 EntityPheasant child = new EntityPheasant(ageable.world);
		 child.setLocationAndAngles(ageable.posX, ageable.posY, ageable.posZ, 0, 0);
		 if(ageable.hasCustomName()) {
			 child.setCustomNameTag(ageable.getCustomNameTag());
		 }
		 child.setType(this.rand.nextInt(2) + 1);
		 return child;
	 }

}
