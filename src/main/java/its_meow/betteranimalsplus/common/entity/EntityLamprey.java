package its_meow.betteranimalsplus.common.entity;

import its_meow.betteranimalsplus.common.entity.ai.EntityAIFindEntityNearestPredicate;
import its_meow.betteranimalsplus.common.entity.ai.EntityAIMoveTowardsAttackTarget;
import its_meow.betteranimalsplus.init.ModEntities;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateSwimmer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EntityLamprey extends EntityWaterMobWithTypes implements IMob {

	private boolean resetPassengerState = true;
	private float passengerX = 0.0F;
	private float passengerZ = 0.0F;

	public EntityLamprey(World worldIn) {
		super(ModEntities.getEntityType(EntityLamprey.class), worldIn);
		this.setSize(1.2F, 0.4F);
	}

	@Override
	protected void initEntityAI() {
		//this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(0, new EntityAIMoveTowardsAttackTarget(this, 0.8D, true));
		this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityWaterMob.class, 10.0F));
		this.targetTasks.addTask(0, new EntityAIFindEntityNearestPredicate(this, EntityLivingBase.class, e -> e instanceof EntityLivingBase && !(e instanceof IMob)));
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(3.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.8D);
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1D);
	}

	@Override
	protected PathNavigate createNavigator(World worldIn) {
		return new PathNavigateSwimmer(this, worldIn);
	}

	public void travel(float strafe, float vertical, float forward) {
		this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn)
	{
		float f = (float)this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue();
		if(entityIn instanceof EntityLivingBase) {
			f += EnchantmentHelper.getModifierForCreature(this.getHeldItemMainhand(), ((EntityLivingBase)entityIn).getCreatureAttribute());
		}
		boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), f);
		if(flag) {
			if(entityIn instanceof EntityPlayer) {
				EntityPlayer entityplayer = (EntityPlayer)entityIn;
				ItemStack itemstack = this.getHeldItemMainhand();
				ItemStack itemstack1 = entityplayer.isHandActive() ? entityplayer.getActiveItemStack() : ItemStack.EMPTY;
				if(!itemstack.isEmpty() && !itemstack1.isEmpty() && itemstack.getItem().canDisableShield(itemstack, itemstack1, entityplayer, this) && itemstack1.getItem().isShield(itemstack1, entityplayer)) {
					float f1 = 0.25F + (float)EnchantmentHelper.getEfficiencyModifier(this) * 0.05F;
					if(this.rand.nextFloat() < f1) {
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
	public void tick() {
		super.tick();
		if(!this.world.isRemote) {
			if(!this.inWater) {
				this.motionX = 0F;
				this.motionZ = 0F;
				if (!this.hasNoGravity()) {
					this.motionY -= 0.08D;
				}

				this.motionY *= 0.9800000190734863D;
			} else {
				this.motionX = (this.getMoveHelper().getX() - this.posX) * 0.05F;
				this.motionZ = (this.getMoveHelper().getZ() - this.posZ) * 0.05F;
				this.motionY = (this.getMoveHelper().getY() - this.posY) * 0.05F;
			}
		}
	}

	@Override
	public void livingTick() {
		super.livingTick();
		if(!this.world.isRemote && this.getAttackTarget() != null) {
			if(this.isRidingOrBeingRiddenBy(this.getAttackTarget())) {
				if(Math.random() >= 0.2F) {
					this.attackEntityAsMob(this.getAttackTarget());
				}
			}
		}
	}

	@Override
	protected void collideWithEntity(Entity entity) {
		if(entity == this.getAttackTarget() && !this.isRidingOrBeingRiddenBy(entity)) {
			entity.startRiding(this);
			this.resetPassengerState = true;
		}
		super.collideWithEntity(entity);
	}

	@Override
	public void updatePassenger(Entity passenger) {
		if(this.isPassenger(passenger)) {
			if(this.resetPassengerState) {
				this.resetPassengerState = false;
				this.setOffsetFor(passenger);
			}
			passenger.setPosition(this.posX + (passengerX), this.posY, this.posZ + (passengerZ));
		}
	}

	private void setOffsetFor(Entity passenger) {
		float modX = Math.random() >= 0.5 ? 1 : -1;
		float modZ = Math.random() >= 0.5 ? 1 : -1;
		this.passengerX = passenger.width * modX;
		this.passengerZ = passenger.width * modZ;
	}

	@Override
	protected boolean canTriggerWalking() {
		return false;
	}

	public boolean canSpawn(IWorld worldIn, boolean p_205020_2_) {
		return this.posY > 45.0D && this.posY < (double)worldIn.getSeaLevel();
	}

	@Override
	public int getVariantMax() {
		return 3;
	}

}