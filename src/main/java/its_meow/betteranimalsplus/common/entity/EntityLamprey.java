package its_meow.betteranimalsplus.common.entity;

import java.util.HashSet;
import java.util.Set;

import its_meow.betteranimalsplus.common.entity.miniboss.hirschgeist.EntityHirschgeist;
import its_meow.betteranimalsplus.init.ModEntities;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.SSetPassengersPacket;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.SwimmerPathNavigator;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

public class EntityLamprey extends EntityWaterMobWithTypes implements IMob {
    
    protected int lastAttack = 0;
    
	public EntityLamprey(World worldIn) {
		super(ModEntities.getEntityType("lamprey"), worldIn);
		//this.setSize(1.0F, 0.7F);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new MoveTowardsTargetGoal(this, 0.8D, 15F));
		this.goalSelector.addGoal(1, new LookAtGoal(this, WaterMobEntity.class, 10.0F));
		Set<Class<? extends LivingEntity>> blackList = new HashSet<Class<? extends LivingEntity>>();
        blackList.add(SkeletonEntity.class);
        blackList.add(EndermanEntity.class);
        blackList.add(EntityHirschgeist.class);
        blackList.add(EntityJellyfish.class);
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<LivingEntity>(this, LivingEntity.class, 100, true, true, e -> e instanceof LivingEntity && !(e instanceof IMob) && !(e instanceof EntityLamprey) && !(blackList.contains(e.getClass()))));
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(3.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.8D);
		this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.5D);
	}

	@Override
	protected PathNavigator createNavigator(World worldIn) {
		return new SwimmerPathNavigator(this, worldIn);
	}
	
	@Override
	public void travel(Vec3d vec) {
		this.move(MoverType.SELF, this.getMotion());
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
	public boolean attackEntityAsMob(Entity entityIn) {
		float f = (float)this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue();

		if(entityIn instanceof LivingEntity) {
			f += EnchantmentHelper.getModifierForCreature(this.getHeldItemMainhand(), ((LivingEntity)entityIn).getCreatureAttribute());
		}
		boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), f);
		if(flag) {
		    this.lastAttack = this.ticksExisted;
			if(entityIn instanceof PlayerEntity) {
				PlayerEntity entityplayer = (PlayerEntity)entityIn;

				int weakTicks = 0;
				if (this.world.getDifficulty() == Difficulty.EASY) {
					weakTicks = 200;
				} else if (this.world.getDifficulty() == Difficulty.NORMAL) {
					weakTicks = 300;
				} else if (this.world.getDifficulty() == Difficulty.HARD) {
					weakTicks = 600;
				}
				entityplayer.addPotionEffect(new EffectInstance(Effects.WEAKNESS, weakTicks, 1, false, false));
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
		    this.setMotion(this.getMotion().getX() * 0.2F, this.getMotion().getY(), this.getMotion().getZ() * 0.2F);
            if (!this.hasNoGravity()) {
                this.setMotion(this.getMotion().getX(), this.getMotion().getY() - 0.08D, this.getMotion().getZ());
            }
            this.setMotion(this.getMotion().getX(), this.getMotion().getY() * 0.9800000190734863D, this.getMotion().getZ());
        } else if(!world.isRemote) {
            if(!this.navigator.noPath()) {
                Vec3d target = this.navigator.getPath().getCurrentPos();
                this.setMotion((target.x - this.posX) * 0.05F, (target.y - this.posY) * 0.05F, (target.z - this.posZ) * 0.05F);
            } else if(this.getMoveHelper().isUpdating()) {
                this.setMotion((this.getMoveHelper().getX() - this.posX) * 0.05F, (this.getMoveHelper().getY() - this.posY) * 0.05F, (this.getMoveHelper().getZ() - this.posZ) * 0.05F);
            } else {
                this.setMotion(this.getMotion().getX() * 0.85F, this.getMotion().getY() * 0.85F, this.getMotion().getZ() * 0.85F);
            }
        }
	}

	@Override
	public void livingTick() {
		super.livingTick();
		if(!this.world.isRemote && this.getAttackTarget() != null && this.getAttackTarget().isAlive()) {
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
			this.getServer().getPlayerList().sendPacketToAllPlayers(new SSetPassengersPacket(entity));
		}
	}
	
	@Override
	public boolean shouldRiderSit() {
		return false;
	}

    @Override
    public double getYOffset() {
        if(getRidingEntity() != null && getRidingEntity() instanceof PlayerEntity) {
            return getRidingEntity().getHeight() - 2.25F;
        } else if(getRidingEntity() != null) {
            return getRidingEntity().getHeight() * 0.5D - 1.25D;
        } else {
            return super.getYOffset();
        }
    }

	@Override
	protected boolean canTriggerWalking() {
		return false;
	}

	@Override
	public int getVariantMax() {
		return 3;
	}

}