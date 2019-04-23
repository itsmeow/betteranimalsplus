package its_meow.betteranimalsplus.common.entity;

import its_meow.betteranimalsplus.init.ModEntities;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.SPacketSetPassengers;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateSwimmer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EntityLamprey extends EntityWaterMobWithTypes implements IMob {
    
    protected int lastAttack = 0;
    
	public EntityLamprey(World worldIn) {
		super(ModEntities.getEntityType(EntityLamprey.class), worldIn);
		this.setSize(1.0F, 0.7F);
	}

	@Override
	protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAIMoveTowardsTarget(this, 0.8D, 15F));
		this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityWaterMob.class, 10.0F));
		this.targetTasks.addTask(0, new EntityAINearestAttackableTarget<EntityLivingBase>(this, EntityLivingBase.class, 100, true, true, e -> e instanceof EntityLivingBase && !(e instanceof IMob) && !(e instanceof EntityLamprey)));
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(3.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.8D);
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.5D);
	}

	@Override
	protected PathNavigate createNavigator(World worldIn) {
		return new PathNavigateSwimmer(this, worldIn);
	}
	
	@Override
	public void travel(float strafe, float vertical, float forward) {
		this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
	}

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_SQUID_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SQUID_DEATH;
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
		    this.lastAttack = this.ticksExisted;
			if(entityIn instanceof EntityPlayer) {
				EntityPlayer entityplayer = (EntityPlayer)entityIn;

				int weakTicks = 0;
				if (this.world.getDifficulty() == EnumDifficulty.EASY) {
					weakTicks = 200;
				} else if (this.world.getDifficulty() == EnumDifficulty.NORMAL) {
					weakTicks = 300;
				} else if (this.world.getDifficulty() == EnumDifficulty.HARD) {
					weakTicks = 600;
				}
				entityplayer.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, weakTicks, 1, false, false));
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
		if(!this.inWater) {
            this.motionX *= 0.2F;
            this.motionZ *= 0.2F;
            if (!this.hasNoGravity()) {
                this.motionY -= 0.08D;
            }

            this.motionY *= 0.9800000190734863D;
        } else if(!world.isRemote) {
            if(!this.navigator.noPath()) {
                Vec3d target = this.navigator.getPath().getCurrentPos();
                this.motionX = (target.x - this.posX) * 0.05F;
                this.motionY = (target.y - this.posY) * 0.05F;
                this.motionZ = (target.z - this.posZ) * 0.05F;
            } else if(this.getMoveHelper().isUpdating()) {
                this.motionX = (this.getMoveHelper().getX() - this.posX) * 0.05F;
                this.motionZ = (this.getMoveHelper().getZ() - this.posZ) * 0.05F;
                this.motionY = (this.getMoveHelper().getY() - this.posY) * 0.05F;
            }
        }
	}

	@Override
	public void livingTick() {
		super.livingTick();
		if(!this.world.isRemote && this.getAttackTarget() != null && !this.getAttackTarget().removed) {
			if(this.getRidingEntity() != null && this.getRidingEntity() == this.getAttackTarget()) {
			    float time = 20F; 
			    if(!this.inWater) {
			        time *= 2F * (Math.random() + 1F);
			    } else {
			        time += Math.random() * Math.random() * 2 * ((Math.random() < 0.5) ? -1 : 1);
			    }
				if(this.lastAttack + time < this.ticksExisted) {
					this.attackEntityAsMob(this.getAttackTarget());
				}
			} else if(this.getDistanceSq(this.getAttackTarget()) < 3) {
				this.grabTarget(this.getAttackTarget());
			}
		}
	}

    @Override
    public void dismountEntity(Entity entity) {
        if(entity.canBeRiddenInWater(this) || this.getAttackTarget() == null) {
            super.dismountEntity(entity);
        }
    }
    
    @Override
    public boolean canBeRiddenInWater(Entity rider) {
        return true;
    }

    public void grabTarget(Entity entity) {
		if(entity == this.getAttackTarget() && !this.isRidingOrBeingRiddenBy(entity) && this.inWater) {
			this.startRiding(entity);
			this.getServer().getPlayerList().sendPacketToAllPlayers(new SPacketSetPassengers(entity));
		}
	}
	
	@Override
	public boolean shouldRiderSit() {
		return false;
	}

    @Override
    public double getYOffset() {
        if(getRidingEntity() != null && getRidingEntity() instanceof EntityPlayer) {
            return getRidingEntity().height - 2.25F;
        } else if(getRidingEntity() != null) {
            return getRidingEntity().height * 0.5D - 1.25D;
        } else {
            return super.getYOffset();
        }
    }

	@Override
	protected boolean canTriggerWalking() {
		return false;
	}

	@Override
	public boolean canSpawn(IWorld worldIn, boolean p_205020_2_) {
		return this.posY > 45.0D && this.posY < (double)worldIn.getSeaLevel();
	}

	@Override
	public int getVariantMax() {
		return 3;
	}

}