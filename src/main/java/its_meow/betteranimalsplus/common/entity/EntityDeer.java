package its_meow.betteranimalsplus.common.entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import its_meow.betteranimalsplus.init.LootTableRegistry;
import its_meow.betteranimalsplus.init.TextureRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockStateMatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import scala.util.Random;

public class EntityDeer extends EntityAnimal {
	
	

	private World world = null;
	
	public EntityDeer(World worldIn) {
		super(worldIn);
		this.world = worldIn;
		this.setSize(1F, 2.5F);
	}
	
	protected void entityInit()
    {
        super.entityInit();
        this.dataManager.register(TYPE_NUMBER, Integer.valueOf(0));
    }
	
	@Override
	public int getMaxSpawnedInChunk() {
		return 4;
	}
	
	private static final DataParameter<Integer> TYPE_NUMBER = EntityDataManager.<Integer>createKey(EntityDeer.class, DataSerializers.VARINT);
	
	public int getTypeNumber() {
		return ((Integer)this.dataManager.get(TYPE_NUMBER)).intValue();
	}
	
	public void setDeerType(int deerTypeId)
    {
        this.dataManager.set(TYPE_NUMBER, Integer.valueOf(deerTypeId));
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
        this.setDeerType(compound.getInteger("TypeNumber"));
    }
	
	/**
     * Called only once on an entity when first time spawned, via egg, mob spawner, natural spawning etc, but not called
     * when entity is reloaded from nbt. Mainly used for initializing attributes and inventory
     */
    @Nullable
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
    {
        livingdata = super.onInitialSpawn(difficulty, livingdata);
        int i = (new Random()).nextInt(2) + 1;
        boolean flag = false;

        if (livingdata instanceof EntityDeer.DeerTypeData)
        {
            i = ((EntityDeer.DeerTypeData)livingdata).typeData;
            flag = true;
        }
        else
        {
            livingdata = new EntityDeer.DeerTypeData(i);
        }

        this.setDeerType(i);

        if (flag)
        {
            this.setGrowingAge(-24000);
        }

        return livingdata;
    }
    
    public static class DeerTypeData implements IEntityLivingData
    {
        public int typeData;

        public DeerTypeData(int type)
        {
            this.typeData = type;
        }
    }
    
    @Override
    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound(SoundEvents.ENTITY_SHEEP_STEP, 0.15F, 1.0F);
    }
    

	protected void initEntityAI()
	{
		super.initEntityAI();
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIPanic(this, 0.65D));
		Set<Item> temptItems = new HashSet<Item>();
		temptItems.add(Items.APPLE);
		temptItems.add(Items.GOLDEN_APPLE);
		temptItems.add(Items.CARROT);
		temptItems.add(Items.CARROT_ON_A_STICK);
		temptItems.add(Items.GOLDEN_CARROT);
		this.tasks.addTask(3, new EntityAITempt(this, 0.45D, false, temptItems));
		this.tasks.addTask(4, new EntityAIAvoidEntity<EntityPlayer>(this, EntityPlayer.class, 20, 0.55D, 0.7D));
		this.tasks.addTask(5, new EntityAIWander(this, 0.45D));
		this.tasks.addTask(6, new EntityAILookIdle(this));
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.45D);
	}
	
	

	


	@Override
	@Nullable
	protected ResourceLocation getLootTable()
	{
		return LootTableRegistry.deer;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {
		return null;
	}
	
	 
	
}
