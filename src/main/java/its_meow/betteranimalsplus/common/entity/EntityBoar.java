package its_meow.betteranimalsplus.common.entity;

import javax.annotation.Nullable;

import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.util.HeadTypes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.monster.ZombiePigmanEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

public class EntityBoar extends EntityAnimalWithTypes implements IMob {

	public EntityBoar(World worldIn) {
		super(ModEntities.getEntityType("boar"), worldIn);
		//this.setSize(0.9F, 0.9F);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new SwimGoal(this));
		if (!this.isChild() && this.getEntityWorld().getDifficulty() != Difficulty.PEACEFUL) {
			this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2D, false));
		}
		this.goalSelector.addGoal(3, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.1D));
		// Eats grass at priority 6
		this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		if (!this.isChild() && this.getEntityWorld().getDifficulty() != Difficulty.PEACEFUL) {
			this.targetSelector.addGoal(1,
					new NearestAttackableTargetGoal<AnimalEntity>(this, AnimalEntity.class, 90, true, true,
							(@Nullable LivingEntity in) -> in instanceof ChickenEntity || in instanceof EntityPheasant
							|| in instanceof AnimalEntity && ((AnimalEntity) in).isChild()
							&& !(in instanceof EntityBoar || in instanceof PigEntity)));
			this.targetSelector.addGoal(2,
					new NearestAttackableTargetGoal<LivingEntity>(this, LivingEntity.class, 50, true, true,
							(@Nullable LivingEntity in) -> in instanceof AnimalEntity
							&& !(in instanceof EntityBoar || in instanceof PigEntity)
							|| in instanceof PlayerEntity));
		}
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(12.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.38D);
		this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.5D);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_PIG_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_PIG_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_PIG_DEATH;
	}

	protected void playStepSound(BlockPos pos, Block blockIn) {
		this.playSound(SoundEvents.ENTITY_PIG_STEP, 0.15F, 1.0F);
	}

	/**
	 * Called when the mob's health reaches 0.
	 */
	 @Override
	 public void onDeath(DamageSource cause) {
		super.onDeath(cause);
		if (!world.isRemote && !this.isChild()) {
			if (this.rand.nextInt(12) == 0) {
				ItemStack stack = new ItemStack(HeadTypes.BOARHEAD.getItem(this.getTypeNumber()));
				this.entityDropItem(stack, 0.5F);
			}
		}
	}

	@Override
	@Nullable
	protected ResourceLocation getLootTable() {
		return null; //TODO: Find pig
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		Vec3d pos = this.getPositionVector();
		Vec3d targetPos = entityIn.getPositionVector();
		((LivingEntity) entityIn).knockBack(entityIn, 0.8F, pos.x - targetPos.x, pos.z - targetPos.z);

		// Vanilla attack code for mobs

		float f = (float) this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue();
		int i = 0;

		if (entityIn instanceof LivingEntity) {
			f += EnchantmentHelper.getModifierForCreature(this.getHeldItemMainhand(),
					((LivingEntity) entityIn).getCreatureAttribute());
			i += EnchantmentHelper.getKnockbackModifier(this);
		}

		boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), f);

		if (flag) {
			if (i > 0 && entityIn instanceof LivingEntity) {
				((LivingEntity) entityIn).knockBack(this, i * 0.5F, MathHelper.sin(this.rotationYaw * 0.017453292F),
						-MathHelper.cos(this.rotationYaw * 0.017453292F));
				this.setMotion(this.getMotion().getX() * 0.6D, this.getMotion().getY(), this.getMotion().getZ() * 0.6D);
			}

			int j = EnchantmentHelper.getFireAspectModifier(this);

			if (j > 0) {
				entityIn.setFire(j * 4);
			}

			if (entityIn instanceof PlayerEntity) {
				PlayerEntity entityplayer = (PlayerEntity) entityIn;
				ItemStack itemstack = this.getHeldItemMainhand();
				ItemStack itemstack1 = entityplayer.isHandActive() ? entityplayer.getActiveItemStack()
						: ItemStack.EMPTY;

				if (!itemstack.isEmpty() && !itemstack1.isEmpty()
						&& itemstack.getItem().canDisableShield(itemstack, itemstack1, entityplayer, this)
						&& itemstack1.getItem().isShield(itemstack1, entityplayer)) {
					float f1 = 0.25F + EnchantmentHelper.getEfficiencyModifier(this) * 0.05F;

					if (this.rand.nextFloat() < f1) {
						entityplayer.getCooldownTracker().setCooldown(itemstack1.getItem(), 100);
						this.world.setEntityState(entityplayer, (byte) 30);
					}
				}
			}

			this.applyEnchantments(this, entityIn);
		}

		return flag;
	}

	/**
	 * Called when a lightning bolt hits the entity.
	 */
	@Override
	public void onStruckByLightning(LightningBoltEntity lightningBolt) {
		if (!this.world.isRemote && !this.dead) {
			ZombiePigmanEntity entitypigzombie = new ZombiePigmanEntity(EntityType.ZOMBIE_PIGMAN, this.world);
			entitypigzombie.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.GOLDEN_SWORD));
			entitypigzombie.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
			entitypigzombie.setNoAI(this.isAIDisabled());

			if (this.hasCustomName()) {
				entitypigzombie.setCustomName(this.getCustomName());
				entitypigzombie.setCustomNameVisible(true);
			}

			this.world.addEntity(entitypigzombie);
			this.remove();
		}
	}

	@Override
	public void tick() {
		super.tick();
		if(net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this)) {
			if (this.rand.nextInt(200) == 0) {
				Block block = this.world.getBlockState(this.getPosition()).getBlock();
				if (block == Blocks.WHEAT || block == Blocks.CARROTS || block == Blocks.POTATOES
						|| block == Blocks.BEETROOTS) {
					this.world.setBlockState(this.getPosition(), Blocks.AIR.getDefaultState());
					this.setInLove(null);
				}
			}
		}
	}

	@Override
	public AgeableEntity createChild(AgeableEntity ageable) {
		if (ageable instanceof EntityBoar) {
			EntityBoar boar = new EntityBoar(this.world);
			boar.setType(this.getTypeNumber());
			return boar;
		} else if (ageable instanceof PigEntity) {
			PigEntity pig = new PigEntity(EntityType.PIG, this.world);
			EntityBoar boar = new EntityBoar(this.world);
			boar.setType(this.getTypeNumber());
			return this.rand.nextBoolean() ? pig : boar;
		} else {
			return null;
		}
	}

	@Override
	public boolean canMateWith(AnimalEntity otherAnimal) {
		if (otherAnimal != this) {
			if (otherAnimal instanceof EntityBoar || otherAnimal instanceof PigEntity) {
				if (otherAnimal.isInLove() && this.isInLove()) {
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public boolean isBreedingItem(ItemStack stack) {
		return stack.getItem() == Items.CARROT || stack.getItem() == Items.GOLDEN_CARROT;
	}
	
	@Override
	public int getVariantMax() {
		return 4;
	}

	@Override
	protected IVariantTypes getBaseChild() {
		return null;
	}
}
