package its_meow.betteranimalsplus.common.entity;

import java.util.HashSet;

import javax.annotation.Nullable;

import its_meow.betteranimalsplus.init.LootTableRegistry;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
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
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import scala.util.Random;

public class EntityGoat extends EntityAnimal {

	public EntityPlayer friend = null;
	public boolean hasBeenFed = false;
	private HashSet<Item> temptItems = null;

	public EntityGoat(World worldIn) {
		super(worldIn);
		this.world = worldIn;
		this.setSize(1.2F, 1.6F);
		addTemptItems();
	}

	private void addTemptItems() {
		temptItems = new HashSet<Item>();
		temptItems.add(Items.WHEAT);
		temptItems.add(Items.POTATO);
		temptItems.add(Items.CARROT);
		temptItems.add(Items.CARROT_ON_A_STICK);
		temptItems.add(Items.BEETROOT);
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		Vec3d pos = this.getPositionVector();
		Vec3d targetPos = entityIn.getPositionVector();
		((EntityLivingBase) entityIn).knockBack(entityIn, 0.8F, pos.x - targetPos.x, pos.z - targetPos.z);
		
		// Vanilla attack code for mobs
		
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



	@Override
	protected void playStepSound(BlockPos pos, Block blockIn)
	{
		this.playSound(SoundEvents.ENTITY_SHEEP_STEP, 0.15F, 1.0F);
	}

	public boolean isAttacking() {
		return this.getAttackTarget() != null;
	}
	
	public float getHeadPitch() {
		return this.isAttacking() ? -0.398F: -0.698F;
	}

	protected void initEntityAI()
	{
		super.initEntityAI();
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIPanic(this, 0.8D));
		this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(2, new EntityAIAttackMelee(this, 0.6D, true));
		if(temptItems == null) {
			addTemptItems();
		}
		this.tasks.addTask(3, new EntityAITempt(this, 0.6D, false, temptItems));
		this.tasks.addTask(4, new EntityAIFollowParent(this, 0.6D));
		this.tasks.addTask(5, new EntityAIWander(this, 0.6D));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new GoatAIAttackForFriend(this));
		this.targetTasks.addTask(1, new AIHurtByTarget());
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(7.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.8D);
	}



	protected SoundEvent getAmbientSound()
	{
		return SoundEvents.ENTITY_SHEEP_AMBIENT;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn)
	{
		return SoundEvents.ENTITY_SHEEP_HURT;
	}

	protected SoundEvent getDeathSound()
	{
		return SoundEvents.ENTITY_SHEEP_DEATH;
	}

	public boolean processInteract(EntityPlayer player, EnumHand hand)
	{
		ItemStack itemstack = player.getHeldItem(hand);

		if (itemstack.getItem() == Items.BUCKET && !player.capabilities.isCreativeMode && !this.isChild())
		{
			player.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);
			itemstack.shrink(1);

			if (itemstack.isEmpty())
			{
				player.setHeldItem(hand, new ItemStack(Items.MILK_BUCKET));
			}
			else if (!player.inventory.addItemStackToInventory(new ItemStack(Items.MILK_BUCKET)))
			{
				player.dropItem(new ItemStack(Items.MILK_BUCKET), false);
			}

			return true;
		} else if(temptItems.contains(itemstack.getItem()) && !this.isChild()) {
			this.hasBeenFed = true;
			this.friend = player;
			if(itemstack.getItem() == Items.WHEAT) {
				this.setInLove(player);
				if(!player.capabilities.isCreativeMode) {
					itemstack.shrink(1);
				}
			}
			return true;
		} else {
			return super.processInteract(player, hand);
		}
	}

	public float getEyeHeight()
	{
		return this.isChild() ? this.height : 0.5F;
	}

	@Override
	@Nullable
	protected ResourceLocation getLootTable()
	{
		return LootTableRegistry.goat;
	}

	protected void entityInit()
	{
		super.entityInit();
		this.dataManager.register(TYPE_NUMBER, Integer.valueOf(0));
	}

	private static final DataParameter<Integer> TYPE_NUMBER = EntityDataManager.<Integer>createKey(EntityDeer.class, DataSerializers.VARINT);

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
			int i = (new Random()).nextInt(7) + 1; // Values 1 to 7
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

			this.setType(i);

			if (flag)
			{
				this.setGrowingAge(-24000);
			}
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
	public EntityAgeable createChild(EntityAgeable ageable) {
		EntityGoat goat = new EntityGoat(ageable.world);
		goat.setLocationAndAngles(ageable.posX, ageable.posY, ageable.posZ, 0, 0);
		if(ageable.hasCustomName()) {
			goat.setCustomNameTag(ageable.getCustomNameTag());
		}
		goat.setType(this.getTypeNumber());
		return goat;
	}


	public static class GoatAIAttackForFriend extends EntityAIBase {
		EntityGoat goat = null;

		public GoatAIAttackForFriend(EntityGoat entity) {
			goat = entity;
		}

		@Override
		public boolean shouldExecute() {
			return goat.hasBeenFed && goat.friend != null && goat.friend.getAttackingEntity() != null;
		}

		@Override
		public void startExecuting() {
			goat.setAttackTarget(goat.friend.getAttackingEntity());
		}

		@Override
		public boolean shouldContinueExecuting() {
			return false;
		}

	}
	
	class AIHurtByTarget extends EntityAIHurtByTarget
    {
        public AIHurtByTarget()
        {
            super(EntityGoat.this, false);
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting()
        {
            super.startExecuting();

            if (EntityGoat.this.isChild())
            {
                this.alertOthers();
                this.resetTask();
            }
        }

        protected void setEntityAttackTarget(EntityCreature creatureIn, EntityLivingBase entityLivingBaseIn)
        {
            if (creatureIn instanceof EntityGoat && !creatureIn.isChild())
            {
                super.setEntityAttackTarget(creatureIn, entityLivingBaseIn);
            }
        }
    }
}
