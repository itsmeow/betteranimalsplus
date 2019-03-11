package its_meow.betteranimalsplus.common.entity;

import javax.annotation.Nullable;

import its_meow.betteranimalsplus.init.ModLootTables;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.util.HeadTypes;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityDeer extends EntityAnimal implements IVariantTypes {
	
	private static final DataParameter<Integer> TYPE_NUMBER = EntityDataManager.<Integer>createKey(EntityDeer.class, DataSerializers.VARINT);
	
	public EntityDeer(World worldIn) {
		super(ModEntities.getEntityType(EntityDeer.class), worldIn);
		this.setSize(1.2F, 1.6F);
	}
	
	
	@Override
	protected void registerData() {
		super.registerData();
		this.dataManager.register(EntityDeer.TYPE_NUMBER, Integer.valueOf(0));
	}
	
	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand) {
		ItemStack stack = player.getHeldItem(hand);
		boolean isEmpty = stack.isEmpty();
		if(!isEmpty) {
			if(stack.getItem() == Items.WHEAT || stack.getItem() == Items.CARROT) {
				this.setInLove(player);
			}
		}

		return super.processInteract(player, hand);
	}

	@Override
	public int getMaxSpawnedInChunk() {
		return 4;
	}

	@Override
	public boolean writeUnlessRemoved(NBTTagCompound compound) {
		this.writeType(compound);
		return super.writeUnlessRemoved(compound);
	}

	@Override
	public void read(NBTTagCompound compound) {
		super.read(compound);
		this.readType(compound);
	}

	@Override
	@Nullable
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata, NBTTagCompound compound) {
		return this.initData(super.onInitialSpawn(difficulty, livingdata, compound));
	}

	@Override
	protected void playStepSound(BlockPos pos, IBlockState state) {
		this.playSound(SoundEvents.ENTITY_SHEEP_STEP, 0.15F, 1.0F);
	}


	@Override
	protected void initEntityAI() {
		super.initEntityAI();
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIPanic(this, 0.65D));
		IItemProvider[] temptItems = new IItemProvider[5];
		temptItems[0] = Items.APPLE;
		temptItems[1] = Items.GOLDEN_APPLE;
		temptItems[2] = Items.CARROT;
		temptItems[3] = Items.CARROT_ON_A_STICK;
		temptItems[4] = Items.GOLDEN_CARROT;
		this.tasks.addTask(3, new EntityAITempt(this, 0.45D, false, Ingredient.fromItems(temptItems)));
		this.tasks.addTask(4, new EntityAIAvoidEntity<>(this, EntityPlayer.class, 20, 0.55D, 0.7D));
		this.tasks.addTask(5, new EntityAIWander(this, 0.45D));
		this.tasks.addTask(6, new EntityAILookIdle(this));
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.45D);
	}

	@Override
	public void onDeath(DamageSource cause) {
		super.onDeath(cause);
		if(!world.isRemote && !this.isChild()) {
			if(this.rand.nextInt(12) == 0) {
				ItemStack stack = new ItemStack(HeadTypes.DEERHEAD.getItem(this.getTypeNumber()));
				this.entityDropItem(stack, 0.5F);
			}
		}
	}

	@Override
	@Nullable
	protected ResourceLocation getLootTable() {
		return ModLootTables.deer;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {
		EntityDeer child = new EntityDeer(this.world);
		child.setType(this.getTypeNumber());
		return child;
	}

	@Override
	public DataParameter<Integer> getDataKey() {
		return TYPE_NUMBER;
	}

	@Override
	public int getVariantMax() {
		return 2;
	}


}
