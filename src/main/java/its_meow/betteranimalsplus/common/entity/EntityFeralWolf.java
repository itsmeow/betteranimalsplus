package its_meow.betteranimalsplus.common.entity;

import javax.annotation.Nullable;

import com.google.common.base.Predicates;

import its_meow.betteranimalsplus.init.ModItems;
import its_meow.betteranimalsplus.util.HeadTypes;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISit;
import net.minecraft.entity.ai.EntityAISwimming;
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
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityFeralWolf extends EntityTameableWithTypes implements IMob {

	protected static final DataParameter<Float> DATA_HEALTH_ID = EntityDataManager.<Float>createKey(EntityFeralWolf.class, DataSerializers.FLOAT);

	public EntityFeralWolf(World worldIn) {
		super(worldIn);
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
		this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
		this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true, new Class[0]));
		this.targetTasks.addTask(4, new EntityAITargetNonTamed<EntityPlayer>(this, EntityPlayer.class, false, Predicates.alwaysTrue()));
		this.targetTasks.addTask(4, new EntityAITargetNonTamed<EntityAnimal>(this, EntityAnimal.class, false, (@Nullable Entity e) -> e instanceof EntitySheep || e instanceof EntityRabbit));
		this.targetTasks.addTask(4, new EntityAITargetNonTamed<EntityVillager>(this, EntityVillager.class, false, Predicates.alwaysTrue()));
		this.targetTasks.addTask(4, new EntityAITargetNonTamed<AbstractIllager>(this, AbstractIllager.class, false, Predicates.alwaysTrue()));
		this.targetTasks.addTask(4, new EntityAITargetNonTamed<EntityChicken>(this, EntityChicken.class, false, Predicates.alwaysTrue()));
		this.targetTasks.addTask(4, new EntityAITargetNonTamed<EntityGoat>(this, EntityGoat.class, false, Predicates.alwaysTrue()));
		this.targetTasks.addTask(5, new EntityAINearestAttackableTarget<AbstractSkeleton>(this, AbstractSkeleton.class, false));
	}

	@Override
	public void onDeath(DamageSource cause) {
		super.onDeath(cause);
		if (!world.isRemote && !this.isChild()) {
			if (this.rand.nextInt(12) == 0) {
				ItemStack stack = new ItemStack(HeadTypes.WOLFHEAD.getItem(this.getTypeNumber()));
				this.entityDropItem(stack, 0.5F);
			}
		}
	}

	public boolean isPreventingPlayerRest(EntityPlayer playerIn) {
		return this.world.getDifficulty() != EnumDifficulty.PEACEFUL && !this.isTamed() && this.getAttackTarget() != null && playerIn.getDistanceSq(this) <= 50D;
	}

	protected boolean isValidLightLevel() {
		return true;
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30000001192092896D);

		if (this.isTamed()) {
			this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
		} else {
			this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
		}

		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
	}

	@Override
	protected void updateAITasks() {
		this.dataManager.set(DATA_HEALTH_ID, Float.valueOf(this.getHealth()));
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(DATA_HEALTH_ID, Float.valueOf(this.getHealth()));
	}

	@Override
	protected void playStepSound(BlockPos pos, Block blockIn) {
		this.playSound(SoundEvents.ENTITY_WOLF_STEP, 0.15F, 1.0F);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		if (!this.isTamed() || this.getAttackTarget() != null) {
			return SoundEvents.ENTITY_WOLF_GROWL;
		} else if (this.rand.nextInt(3) == 0) {
			return this.isTamed() && this.dataManager.get(DATA_HEALTH_ID).floatValue() < 10.0F ? SoundEvents.ENTITY_WOLF_WHINE : SoundEvents.ENTITY_WOLF_PANT;
		} else {
			return SoundEvents.ENTITY_WOLF_AMBIENT;
		}
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_WOLF_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_WOLF_DEATH;
	}

	@Override
	protected float getSoundVolume() {
		return 0.4F;
	}

	@Override
	public float getEyeHeight() {
		return this.height * 0.8F;
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (this.isEntityInvulnerable(source)) {
			return false;
		} else {
			Entity entity = source.getTrueSource();

			if (this.aiSit != null) {
				this.aiSit.setSitting(false);
			}

			if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow)) {
				amount = (amount + 1.0F) / 2.0F;
			}

			return super.attackEntityFrom(source, amount);
		}
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), ((int) this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue()));

		if (flag) {
			this.applyEnchantments(this, entityIn);
		}

		return flag;
	}

	@Override
	public void setTamed(boolean tamed) {
		super.setTamed(tamed);

		if (tamed) {
			this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
		} else {
			this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
		}

		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
	}

	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand) {
		ItemStack itemstack = player.getHeldItem(hand);

		if (this.isTamed()) {
			if (!itemstack.isEmpty()) {
				if (itemstack.getItem() instanceof ItemFood) {
					ItemFood itemfood = (ItemFood) itemstack.getItem();

					if (itemfood.isWolfsFavoriteMeat() && this.dataManager.get(DATA_HEALTH_ID).floatValue() < 20.0F) {
						if (!player.capabilities.isCreativeMode) {
							itemstack.shrink(1);
						}

						this.heal(itemfood.getHealAmount(itemstack));
						return true;
					}
				}
			}

			if (this.isOwner(player) && !this.world.isRemote && !this.isBreedingItem(itemstack) && (!(itemstack.getItem() instanceof ItemFood) || !((ItemFood) itemstack.getItem()).isWolfsFavoriteMeat())) {
				this.aiSit.setSitting(!this.isSitting());
				this.isJumping = false;
				this.navigator.clearPath();
				this.setAttackTarget((EntityLivingBase) null);
			}
		} else if (itemstack.getItem() == Items.BONE) {
			boolean wearingPowerHead = false;
			ItemStack stack = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
			if (stack.getItem() == Items.SKULL) {
				if (stack.getMetadata() == 5) { // 5 = "dragon"
						wearingPowerHead = true;
				}
			}
			if (stack.getItem() == ModItems.itemHirschgeistSkullWearable) {
				wearingPowerHead = true;
			}

			if (wearingPowerHead) { // player.isWearing(part))

if (!player.capabilities.isCreativeMode) {
	itemstack.shrink(1);
}

if (!this.world.isRemote) {
	if (this.rand.nextInt(100) <= 14 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
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
			} else {
				if (!this.world.isRemote) {
					player.sendMessage(new TextComponentString("You cannot tame feral wolves without proving your prowess. Discover a mighty enemy, defeat it, and wear its head. Feral Wolves only bow to the protector of the forests."));
				}
			}
		}

		return super.processInteract(player, hand);
	}

	@SideOnly(Side.CLIENT)
	public float getTailRotation() {
		if (!this.isTamed()) {
			return -0.15F;
		} else {
			return this.isTamed() ? (0.25F - (this.getMaxHealth() - this.dataManager.get(DATA_HEALTH_ID).floatValue()) * 0.04F) : -0.85F;
		}
	}

	@Override
	public boolean isBreedingItem(ItemStack stack) {
		return stack.getItem() instanceof ItemFood && ((ItemFood) stack.getItem()).isWolfsFavoriteMeat();
	}

	@Override
	public int getMaxSpawnedInChunk() {
		return 8;
	}

	@Override
	public boolean canMateWith(EntityAnimal otherAnimal) {
		return false;
	}

	@Override
	public boolean shouldAttackEntity(EntityLivingBase target, EntityLivingBase owner) {
		if (!(target instanceof EntityCreeper) && !(target instanceof EntityGhast)) {
			if (target instanceof EntityFeralWolf) {
				EntityFeralWolf entityferalwolf = (EntityFeralWolf) target;

				if (entityferalwolf.isTamed() && entityferalwolf.getOwner() == owner) {
					return false;
				}
			}

			if (target instanceof EntityPlayer && owner instanceof EntityPlayer && !((EntityPlayer) owner).canAttackPlayer((EntityPlayer) target)) {
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
	public int getVariantMax() {
		return 3;
	}

	@Override
	protected IVariantTypes getBaseChild() {
		return null;
	}

}
