package its_meow.betteranimalsplus.common.entity;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateClimber;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntitySquirrel extends EntityAnimal implements IVariantTypes {

	private static final DataParameter<Byte> CLIMBING = EntityDataManager.<Byte>createKey(EntitySquirrel.class, DataSerializers.BYTE);
	private static final DataParameter<Integer> TYPE_NUMBER = EntityDataManager.<Integer>createKey(EntitySquirrel.class, DataSerializers.VARINT);

	private int climbTimeWithoutLog = 0;

	public EntitySquirrel(World worldIn) {
		super(worldIn);
		this.setSize(0.5F, 0.5F);

	}

	@Override
	protected void initEntityAI() {
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIPanic(this, 0.72D));
		this.tasks.addTask(3, new EntityAIMate(this, 0.5D));
		this.tasks.addTask(4, new EntityAITempt(this, 0.5D, Items.WHEAT_SEEDS, false));
		this.tasks.addTask(5, new EntityAIAvoidEntity<EntityPlayer>(this, EntityPlayer.class, 10F, 0.5D, 0.7D));
		this.tasks.addTask(6, new EntityAIWanderAvoidWater(this, 0.5D));
		this.tasks.addTask(7, new EntityAILookIdle(this));
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(4.5D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
	}

	protected void entityInit()
	{
		super.entityInit();
		this.dataManager.register(CLIMBING, Byte.valueOf((byte)0));
		this.registerTypeKey();
	}

	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		this.writeType(compound);
	}

	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.readType(compound);
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
			int i = this.rand.nextInt(3) + 1; // Values 1 to 3
			if(i == 3 && this.rand.nextInt(4) != 0) { // 1/4 chance it remains white (overall 1/12 chance of white)
				i = this.rand.nextInt(2) + 1; // 1 - 2
			}
			if (livingdata instanceof TypeData)
			{
				i = ((TypeData)livingdata).typeData;
			}
			else
			{
				livingdata = new TypeData(i);
			}

			this.setType(i);
		}
		return livingdata;
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate()
	{
		super.onUpdate();

		if (!this.world.isRemote)
		{
			boolean nearLog = false;
			for(EnumFacing facing : EnumFacing.values()) {
				BlockPos pos = this.getPosition().offset(facing);
				Block block = this.world.getBlockState(pos).getBlock();
				if(block == Blocks.LOG || block == Blocks.LOG2) {
					nearLog = true;
				}
			}
			this.setBesideClimbableBlock((this.collidedHorizontally && nearLog) || (this.collidedHorizontally && this.climbTimeWithoutLog < 15));
			if(this.collidedHorizontally && !nearLog) {
				this.climbTimeWithoutLog++;
			} else if(this.climbTimeWithoutLog > 0 || (this.collidedHorizontally && nearLog)) {
				this.climbTimeWithoutLog = 0;
			}
		}
	}


	public boolean isOnLadder()
	{
		return this.isBesideClimbableBlock();
	}

	/**
	 * Returns true if the WatchableObject (Byte) is 0x01 otherwise returns false. The WatchableObject is updated using
	 * setBesideClimableBlock.
	 */
	public boolean isBesideClimbableBlock()
	{
		return (((Byte)this.dataManager.get(CLIMBING)).byteValue() & 1) != 0;
	}

	/**
	 * Updates the WatchableObject (Byte) created in entityInit(), setting it to 0x01 if par1 is true or 0x00 if it is
	 * false.
	 */
	public void setBesideClimbableBlock(boolean climbing)
	{
		byte b0 = ((Byte)this.dataManager.get(CLIMBING)).byteValue();

		if (climbing)
		{
			b0 = (byte)(b0 | 1);
		}
		else
		{
			b0 = (byte)(b0 & -2);
		}

		this.dataManager.set(CLIMBING, Byte.valueOf(b0));
	}

	protected PathNavigate createNavigator(World worldIn) {
		return new PathNavigateClimber(this, worldIn);
	}

	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {
		EntitySquirrel squirrel = new EntitySquirrel(this.world);
		if(ageable instanceof EntitySquirrel) {
			EntitySquirrel other = (EntitySquirrel) ageable;
			if((this.getTypeNumber() == 3 || other.getTypeNumber() == 3) && this.getTypeNumber() != other.getTypeNumber()) {
				squirrel.setType(this.getTypeNumber() == 3 ? other.getTypeNumber() : this.getTypeNumber());
			} else {
				squirrel.setType(this.rand.nextBoolean() ? this.getTypeNumber() : other.getTypeNumber());
			}
		}
		return squirrel;
	}

	@Override
	public boolean isBreedingItem(ItemStack stack) {
		return stack.getItem() == Items.WHEAT_SEEDS || stack.getItem() == Items.BEETROOT_SEEDS || stack.getItem() == Items.MELON_SEEDS || stack.getItem() == Items.PUMPKIN_SEEDS;
	}

	@Override
	public int getVariantMax() {
		return 0; // This is not used in this class
	}

	@Override
	public DataParameter<Integer> getDataKey() {
		return TYPE_NUMBER;
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

}
