package its_meow.betteranimalsplus.common.entity;

import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWaterFlying;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityFlyHelper;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityFlying;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateFlying;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntitySongbird extends EntityAnimal implements EntityFlying {

	private static final Set<Item> ITEMS = Sets.newHashSet(Items.WHEAT_SEEDS, Items.MELON_SEEDS, Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS);
	
	public EntitySongbird(World worldIn) {
		super(worldIn);
		this.setSize(0.5F, 0.9F);
        this.moveHelper = new EntityFlyHelper(this);
	}
	
	protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.25D));
        this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAIMate(this, 0.4F));
		this.tasks.addTask(4, new EntityAIAvoidEntity<EntityPlayer>(this, EntityPlayer.class, 20, 0.55D, 0.7D));
        this.tasks.addTask(5, new EntityAIWanderAvoidWaterFlying(this, 1.0D));
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0D);
        this.getEntityAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0.4D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
    }
    
    public boolean getCanSpawnHere()
    {
        int i = MathHelper.floor(this.posX);
        int j = MathHelper.floor(this.getEntityBoundingBox().minY);
        int k = MathHelper.floor(this.posZ);
        BlockPos blockpos = new BlockPos(i, j, k);
        Block block = this.world.getBlockState(blockpos.down()).getBlock();
        return block instanceof BlockLeaves || block == Blocks.GRASS || block instanceof BlockLog || block == Blocks.AIR && this.world.getLight(blockpos) > 8 && super.getCanSpawnHere();
    }

    /**
     * Returns new PathNavigateGround instance
     */
    protected PathNavigate createNavigator(World worldIn)
    {
        PathNavigateFlying pathnavigateflying = new PathNavigateFlying(this, worldIn);
        pathnavigateflying.setCanOpenDoors(false);
        pathnavigateflying.setCanFloat(true);
        pathnavigateflying.setCanEnterDoors(true);
        return pathnavigateflying;
    }

	@Override
	public boolean isBreedingItem(ItemStack stack) {
		return ITEMS.contains(stack.getItem());
	}
	
	public void fall(float distance, float damageMultiplier)
    {
    }

    protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos)
    {
    }
    
    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound(SoundEvents.ENTITY_PARROT_STEP, 0.15F, 1.0F);
    }

    protected float playFlySound(float p_191954_1_)
    {
        this.playSound(SoundEvents.ENTITY_PARROT_FLY, 0.15F, 1.0F);
        return p_191954_1_;
    }

    protected boolean makeFlySound()
    {
        return true;
    }
    
    public SoundCategory getSoundCategory()
    {
        return SoundCategory.NEUTRAL;
    }
    
    public boolean canBePushed()
    {
        return true;
    }

    public boolean isFlying()
    {
        return !this.onGround;
    }
    
    protected static final DataParameter<Integer> TYPE_NUMBER = EntityDataManager.<Integer>createKey(EntitySongbird.class, DataSerializers.VARINT);
    
    protected void entityInit()
	{
		super.entityInit();
		this.dataManager.register(TYPE_NUMBER, Integer.valueOf(0));
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
		int i = this.rand.nextInt(9) + 1;

		if (livingdata instanceof EntitySongbird.TypeData)
		{
			i = ((EntitySongbird.TypeData)livingdata).typeData;
		}
		else
		{
			livingdata = new EntitySongbird.TypeData(i);
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
	
	

	@Override
	public boolean canMateWith(EntityAnimal otherAnimal) {
		if(super.canMateWith(otherAnimal)) {
			if(!(otherAnimal instanceof EntitySongbird)) {
				return false;
			}
			return ((EntitySongbird) otherAnimal).getTypeNumber() == this.getTypeNumber();
		}
		return false;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {
		EntitySongbird bird = new EntitySongbird(world);
		bird.setType(this.getTypeNumber());
		return bird;
	}
}
