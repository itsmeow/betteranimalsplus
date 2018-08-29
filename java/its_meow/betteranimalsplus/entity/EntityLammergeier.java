package its_meow.betteranimalsplus.entity;

import java.awt.Point;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import its_meow.betteranimalsplus.util.PolarVector3D;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import its_meow.betteranimalsplus.entity.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIFindEntityNearest;
import net.minecraft.entity.ai.EntityAIFindEntityNearestPlayer;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.Path;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import paulscode.sound.Vector3D;

public class EntityLammergeier extends EntityFlying {

	private static final DataParameter<Byte> FLYING = EntityDataManager.<Byte>createKey(EntityLammergeier.class, DataSerializers.BYTE);

	private BlockPos spawnPosition;
	
	public LammerMoveHelper moveHelperL;

	public EntityLammergeier(World worldIn) {
		super(worldIn);
		this.setSize(1F, 1F);
		this.moveHelperL = new EntityLammergeier.LammerMoveHelper(this);
		this.moveHelper = this.moveHelperL;
	}

	protected void initEntityAI()
	{
		this.tasks.addTask(2, new EntityLammergeier.AIMeleeAttack(this, true));
		this.tasks.addTask(2, new EntityLammergeier.AIMoveToTarget(this, 50F));
		this.tasks.addTask(5, new EntityLammergeier.AIRandomFly(this));
		this.tasks.addTask(7, new EntityLammergeier.AILookAround(this));
		this.targetTasks.addTask(1, new EntityLammergeier.EntityAIFindEntityNearestFlying(this, EntitySkeleton.class));
	}

	protected void entityInit()
	{
		super.entityInit();
		this.dataManager.register(FLYING, Byte.valueOf((byte)0));
		this.dataManager.register(TYPE_NUMBER, Integer.valueOf(0));
	}

	public boolean canBePushed()
	{
		return false;
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entityIn)
    {
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

	protected void collideWithEntity(Entity entityIn)
	{
	}

	protected void collideWithNearbyEntities()
	{
	}

	public void fall(float distance, float damageMultiplier)
	{
	}

	protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos)
	{
	}

	/**
	 * Return whether this entity should NOT trigger a pressure plate or a tripwire.
	 */
	public boolean doesEntityNotTriggerPressurePlate()
	{
		return true;
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(50.0D);
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		//this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_SPEED);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
		//this.getEntityAttribute(SharedMonsterAttributes.ATTACK_SPEED).setBaseValue(1.0D);
	}

	public boolean getFlying()
	{
		return (((Byte)this.dataManager.get(FLYING)).byteValue() & 1) != 0;
	}

	public void setFlying(boolean isFlying)
	{
		byte b0 = ((Byte)this.dataManager.get(FLYING)).byteValue();

		if (isFlying)
		{
			this.dataManager.set(FLYING, Byte.valueOf((byte)(b0 | 1)));
		}
		else
		{
			this.dataManager.set(FLYING, Byte.valueOf((byte)(b0 & -2)));
		}
	}

	protected void updateAITasks()
	{
		super.updateAITasks();
		BlockPos blockpos = new BlockPos(this);
		BlockPos blockpos1 = blockpos.down();

		if (!this.getFlying())
		{
			if (this.world.getBlockState(blockpos1).isNormalCube() && this.getAttackTarget() == null)
			{
				this.setFlying(false);
				if(this.rand.nextInt(100) == 0) {
					this.setFlying(true);
				}
			}
			else
			{
				this.setFlying(true);
				this.world.playEvent((EntityPlayer)null, 1025, blockpos, 0);
			}
		}
		else
		{
			if (this.rand.nextInt(20) == 0 && this.world.getBlockState(blockpos1).isNormalCube())
			{
				this.setFlying(false);
			}
		}
	}

	public BlockPos fromPolarCoordinates(PolarVector3D polar) {
		double r = polar.getR();
		double lat = polar.getThetaY();
		double lon = polar.getThetaX();
		double x = r * Math.sin(lat) * Math.cos(lon);
		double y = r * Math.sin(lat) * Math.sin(lon);
		double z = r * Math.cos(lat);
		return new BlockPos(x, y, z);
	}

	public PolarVector3D toPolarCoordinates(BlockPos pos) {

		BlockPos lPos = this.getPosition();

		double x = lPos.getX() - pos.getX();
		double z = lPos.getZ() - pos.getZ();
		double y = lPos.getY() - pos.getY();
		double rx = Math.sqrt(  Math.pow(x, 2) + Math.pow(z, 2)  );
		double thetax = Math.atan(z / x);
		double thetay = Math.atan(y / rx);
		double ry = Math.sqrt(Math.pow(rx, 2) + Math.pow(y, 2));
		return new PolarVector3D(thetax, thetay, ry);
	}



	public PolarVector3D toPolarCoordinates(int x, int y, int z) {
		return toPolarCoordinates(new BlockPos(x, y, z));
	}

	@Override
	public LammerMoveHelper getMoveHelper() {
		return this.moveHelperL;
	}


	private static final DataParameter<Integer> TYPE_NUMBER = EntityDataManager.<Integer>createKey(EntityLammergeier.class, DataSerializers.VARINT);

	public int getTypeNumber() {
		return ((Integer)this.dataManager.get(TYPE_NUMBER)).intValue();
	}

	public void setLammerType(int lammerTypeId)
	{
		this.dataManager.set(TYPE_NUMBER, Integer.valueOf(lammerTypeId));
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound compound)
	{
		super.writeEntityToNBT(compound);
		compound.setInteger("TypeNumber", this.getTypeNumber());
		compound.setByte("LammerFlying", ((Byte)this.dataManager.get(FLYING)).byteValue());
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound compound)
	{
		super.readEntityFromNBT(compound);
		this.setLammerType(compound.getInteger("TypeNumber"));
		this.dataManager.set(FLYING, Byte.valueOf(compound.getByte("LammerFlying")));
	}

	/**
	 * Called only once on an entity when first time spawned, via egg, mob spawner, natural spawning etc, but not called
	 * when entity is reloaded from nbt. Mainly used for initializing attributes and inventory
	 */
	@Nullable
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
	{
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		int i = (new Random()).nextInt(4) + 1;

		if (livingdata instanceof EntityLammergeier.LammerTypeData)
		{
			i = ((EntityLammergeier.LammerTypeData)livingdata).typeData;
		}
		else
		{
			livingdata = new EntityLammergeier.LammerTypeData(i);
		}

		this.setLammerType(i);

		return livingdata;
	}

	public static class LammerTypeData implements IEntityLivingData
	{
		public int typeData;

		public LammerTypeData(int type)
		{
			this.typeData = type;
		}
	}










	@Override
	public void updatePassenger(Entity passenger)
    {
        if (this.isPassenger(passenger))
        {
            float f1 = (float)((this.isDead ? 0.009999999776482582D : this.getMountedYOffset()) + passenger.getYOffset());
          
            passenger.setPosition(this.posX, this.posY - passenger.height - 0.05, this.posZ);
            this.applyOrientationToEntity(passenger);
        }
    }

















	static class AIMeleeAttack extends EntityAIAttackMelee
	{
		
		
		World world;
	    protected EntityLammergeier attacker;
	    /** An amount of decrementing ticks that allows the entity to attack once the tick reaches 0. */
	    protected int attackTick;
	    /** The speed with which the mob will approach the target */
	    double speedTowardsTarget;
	    /** When true, the mob will continue chasing its target, even if it can't find a path to them right now. */
	    boolean longMemory;
	    /** The PathEntity of our entity. */
	    Path path;
	    private int delayCounter;
	    private double targetX;
	    private double targetY;
	    private double targetZ;
	    protected final int attackInterval = 20;
	    private int failedPathFindingPenalty = 0;
	    private boolean canPenalize = false;
		
		private final EntityLammergeier parentEntity;

		public AIMeleeAttack(EntityLammergeier lam, boolean useLongMemory)
		{
			super(lam, 0.5D, false);
			this.parentEntity = lam;
			this.attacker = lam;
			this.world = lam.getEntityWorld();
			this.setMutexBits(2);
		}
		double liftY = 0;
		
		@Override
		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void updateTask()
		{
			if (this.parentEntity.getAttackTarget() == null)
			{
				this.parentEntity.rotationYaw = -((float)MathHelper.atan2(this.parentEntity.motionX, this.parentEntity.motionZ)) * (180F / (float)Math.PI);
				this.parentEntity.renderYawOffset = this.parentEntity.rotationYaw;
			}
			else
			{
				EntityLivingBase entitylivingbase = this.parentEntity.getAttackTarget();
				
				if(!entitylivingbase.isEntityAlive()) {
					this.parentEntity.setAttackTarget(null);
					return;
				}
 				
				
				if (entitylivingbase.getDistanceSq(this.parentEntity) < 4096.0D)
				{
					double d1 = entitylivingbase.posX - this.parentEntity.posX;
					double d2 = entitylivingbase.posZ - this.parentEntity.posZ;
					this.parentEntity.rotationYaw = -((float)MathHelper.atan2(d1, d2)) * (180F / (float)Math.PI);
					this.parentEntity.renderYawOffset = this.parentEntity.rotationYaw;
				}


				//this.attacker.getLookHelper().setLookPositionWithEntity(entitylivingbase, 30.0F, 30.0F);
				double d0 = this.attacker.getDistanceSq(entitylivingbase.posX, entitylivingbase.posY, entitylivingbase.posZ);
				
				--this.delayCounter;

				if ((this.longMemory || this.attacker.getEntitySenses().canSee(entitylivingbase)) && this.delayCounter <= 0 && (this.targetX == 0.0D && this.targetY == 0.0D && this.targetZ == 0.0D || entitylivingbase.getDistanceSq(this.targetX, this.targetY, this.targetZ) >= 1.0D || this.attacker.getRNG().nextFloat() < 0.05F))
				{
					this.targetX = entitylivingbase.posX;
					this.targetY = entitylivingbase.getEntityBoundingBox().minY;
					this.targetZ = entitylivingbase.posZ;
					this.delayCounter = 4 + this.attacker.getRNG().nextInt(7);

					if (this.canPenalize)
					{
						this.delayCounter += failedPathFindingPenalty;
						if (this.attacker.getNavigator().getPath() != null)
						{
							net.minecraft.pathfinding.PathPoint finalPathPoint = this.attacker.getNavigator().getPath().getFinalPathPoint();
							if (finalPathPoint != null && entitylivingbase.getDistanceSq(finalPathPoint.x, finalPathPoint.y, finalPathPoint.z) < 1)
								failedPathFindingPenalty = 0;
							else
								failedPathFindingPenalty += 10;
						}
						else
						{
							failedPathFindingPenalty += 10;
						}
					}

					if (d0 > 1024.0D)
					{
						this.delayCounter += 10;
					}
					else if (d0 > 256.0D)
					{
						this.delayCounter += 5;
					}
					attacker.getMoveHelper().setMoveTo(targetX, targetY, targetZ, 0.5D);
					if (!this.attacker.getNavigator().tryMoveToEntityLiving(entitylivingbase, this.speedTowardsTarget))
					{
						this.delayCounter += 15;
					}
				}

				attackTick--;

				
				double d2 = this.getAttackReachSqr(entitylivingbase);

		        if (d0 <= d2 && this.attackTick <= 0)
		        {
		            this.attackTick = 20;
		            if(!entitylivingbase.isRiding()) {
		            	this.attacker.attackEntityAsMob(entitylivingbase);
		            }
		            
		            
		            
		        }
		        if(entitylivingbase.isRiding()) {
		        	this.attacker.getMoveHelper().setMoveTo(targetX, liftY + 15, targetZ, 5.0D);
		        }
		        if(attackTick == 20 && !entitylivingbase.isRiding()) {
		        	this.attacker.setPosition(attacker.posX, attacker.posY + entitylivingbase.height, attacker.posZ);
		        	entitylivingbase.startRiding(this.attacker, true);
		        	liftY = entitylivingbase.posY;
		        	this.attacker.getMoveHelper().setMoveTo(targetX, liftY + 15, targetZ, 5.0D);
	            }
		        if(Math.abs(attacker.posY - (liftY + 15)) <= 3 && entitylivingbase.isRiding() || !this.attacker.getMoveHelper().isUpdating()) {
	            	entitylivingbase.dismountRidingEntity(); //Math.abs(attacker.posY - liftY) <= 1
	            }
		        
				//this.checkAndPerformAttack(entitylivingbase, d0);



			}
		}
	}

	static class AILookAround extends EntityAIBase
	{
		private final EntityLammergeier parentEntity;

		public AILookAround(EntityLammergeier lam)
		{
			this.parentEntity = lam;
			this.setMutexBits(2);
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		public boolean shouldExecute()
		{
			return true;
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void updateTask()
		{
			if (this.parentEntity.getAttackTarget() == null)
			{
				this.parentEntity.rotationYaw = -((float)MathHelper.atan2(this.parentEntity.motionX, this.parentEntity.motionZ)) * (180F / (float)Math.PI);
				this.parentEntity.renderYawOffset = this.parentEntity.rotationYaw;
			}
			else
			{
				EntityLivingBase entitylivingbase = this.parentEntity.getAttackTarget();
				double d0 = 64.0D;

				if (entitylivingbase.getDistanceSq(this.parentEntity) < 4096.0D)
				{
					double d1 = entitylivingbase.posX - this.parentEntity.posX;
					double d2 = entitylivingbase.posZ - this.parentEntity.posZ;
					this.parentEntity.rotationYaw = -((float)MathHelper.atan2(d1, d2)) * (180F / (float)Math.PI);
					this.parentEntity.renderYawOffset = this.parentEntity.rotationYaw;
				}
			}
		}
	}

	static class AIRandomFly extends EntityAIBase
	{
		private final EntityLammergeier parentEntity;

		public AIRandomFly(EntityLammergeier lam)
		{
			this.parentEntity = lam;
			this.setMutexBits(1);
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		public boolean shouldExecute()
		{
			LammerMoveHelper entitymovehelper = this.parentEntity.getMoveHelper();

			if (!entitymovehelper.isUpdating())
			{
				return true;
			}
			else
			{
				double d0 = entitymovehelper.getX() - this.parentEntity.posX;
				double d1 = entitymovehelper.getY() - this.parentEntity.posY;
				double d2 = entitymovehelper.getZ() - this.parentEntity.posZ;
				double d3 = d0 * d0 + d1 * d1 + d2 * d2;
				return d3 < 1.0D || d3 > 3600.0D && this.parentEntity.getAttackTarget() == null;
			}
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		public boolean shouldContinueExecuting()
		{
			return false;
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void startExecuting()
		{
			Random random = this.parentEntity.getRNG();
			
			BlockPos rPos = this.parentEntity.fromPolarCoordinates(new PolarVector3D(this.parentEntity.rotationYaw + (random.nextInt(40) - 20), random.nextInt(40) - 20, random.nextInt(15) + 1 + random.nextFloat()));
			BlockPos pos = this.parentEntity.getPosition();
			rPos = rPos.add(pos);
			/*
			double d0 = this.parentEntity.posX + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
			double d1 = this.parentEntity.posY + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
			double d2 = this.parentEntity.posZ + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
			this.parentEntity.getMoveHelper().setMoveTo(d0, d1, d2, 1.0D);
			*/
			this.parentEntity.getMoveHelper().setMoveTo(rPos.getX(), rPos.getY(), rPos.getZ(), 1.0D);
		}
	}
	
	
	static class AIMoveToTarget extends EntityAIBase
	{
		private final EntityLammergeier parentEntity;
		private final float maxTargetDistance;
		
		public AIMoveToTarget(EntityLammergeier lam, float maxTargetDistance)
		{
			this.parentEntity = lam;
			this.maxTargetDistance = maxTargetDistance;
			this.setMutexBits(1);
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		public boolean shouldExecute()
		{
			EntityLivingBase targetEntity = parentEntity.getAttackTarget();
			LammerMoveHelper entitymovehelper = this.parentEntity.getMoveHelper();
			double d0 = entitymovehelper.getX() - this.parentEntity.posX;
			double d1 = entitymovehelper.getY() - this.parentEntity.posY;
			double d2 = entitymovehelper.getZ() - this.parentEntity.posZ;
			double d3 = d0 * d0 + d1 * d1 + d2 * d2;
			return targetEntity != null && (!this.parentEntity.getMoveHelper().isUpdating() || (d3 < 1.0D || d3 > 3600.0D)); //&& targetEntity.getDistanceSq(this.parentEntity) > (double)(this.maxTargetDistance * this.maxTargetDistance);
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		public boolean shouldContinueExecuting()
		{
			return false;
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void startExecuting()
		{
			EntityLivingBase target = this.parentEntity.getAttackTarget();
			this.parentEntity.getMoveHelper().setMoveTo(target.getPosition().getX(), target.getPosition().getY(), target.getPosition().getZ(), 1.0D);
		}
	}
	
	static class EntityAIFindEntityNearestFlying extends EntityAIBase {
		
		private final EntityLiving mob;
		private final Predicate<EntityLivingBase> predicate;
	    private final EntityAINearestAttackableTarget.Sorter sorter;
	    private EntityLivingBase target;
	    private final Class <? extends EntityLivingBase > classToCheck;
		
		public EntityAIFindEntityNearestFlying(EntityLiving mobIn, Class<? extends EntityLivingBase> p_i45884_2_) {
			//super(mobIn, p_i45884_2_);
			this.mob = mobIn;
	        this.classToCheck = p_i45884_2_;
	        this.predicate = new Predicate<EntityLivingBase>()
	        {
	            public boolean apply(@Nullable EntityLivingBase p_apply_1_)
	            {
	                double d0 = EntityAIFindEntityNearestFlying.this.getFollowRange();

	                if (p_apply_1_.isSneaking())
	                {
	                    d0 *= 0.800000011920929D;
	                }

	                if (p_apply_1_.isInvisible())
	                {
	                    return false;
	                }
	                else
	                {
	                    return (double)p_apply_1_.getDistance(EntityAIFindEntityNearestFlying.this.mob) > d0 ? false : EntityAITarget.isSuitableTarget(EntityAIFindEntityNearestFlying.this.mob, p_apply_1_, false, true);
	                }
	            }
	        };
	        
	        this.sorter = new EntityAINearestAttackableTarget.Sorter(mobIn);
		}
		
		@Override
		public boolean shouldExecute()
	    {
	        double d0 = this.getFollowRange();
	        List<EntityLivingBase> list = this.mob.world.<EntityLivingBase>getEntitiesWithinAABB(this.classToCheck, this.mob.getEntityBoundingBox().grow(d0, d0, d0), this.predicate);
	        Collections.sort(list, this.sorter);

	        if (list.isEmpty())
	        {
	            return false;
	        }
	        else
	        {
	            this.target = list.get(0);
	            return true;
	        }
	    }
		
		/**
	     * Returns whether an in-progress EntityAIBase should continue executing
	     */
	    public boolean shouldContinueExecuting()
	    {
	        EntityLivingBase entitylivingbase = this.mob.getAttackTarget();

	        if (entitylivingbase == null)
	        {
	            return false;
	        }
	        else if (!entitylivingbase.isEntityAlive())
	        {
	            return false;
	        }
	        else
	        {
	            double d0 = this.getFollowRange();

	            if (this.mob.getDistanceSq(entitylivingbase) > d0 * d0)
	            {
	                return false;
	            }
	            else
	            {
	                return !(entitylivingbase instanceof EntityPlayerMP) || !((EntityPlayerMP)entitylivingbase).interactionManager.isCreative();
	            }
	        }
	    }

	    /**
	     * Execute a one shot task or start executing a continuous task
	     */
	    public void startExecuting()
	    {
	        this.mob.setAttackTarget(this.target);
	        super.startExecuting();
	    }

	    /**
	     * Reset the task's internal state. Called when this task is interrupted by another one
	     */
	    public void resetTask()
	    {
	        this.mob.setAttackTarget((EntityLivingBase)null);
	        super.startExecuting();
	    }

	    protected double getFollowRange()
	    {
	        IAttributeInstance iattributeinstance = this.mob.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE);
	        return iattributeinstance == null ? 16.0D : iattributeinstance.getAttributeValue();
	    }
		
	}

	static class LammerMoveHelper extends EntityMoveHelper
	{
		private final EntityLammergeier parentEntity;
		private int courseChangeCooldown;

		public LammerMoveHelper(EntityLammergeier lam)
		{
			super(lam);
			this.parentEntity = lam;
		}
		
		public boolean isUpdating()
	    {
	        return this.action == EntityMoveHelper.Action.MOVE_TO;
	    }
		
		@Override
		public void onUpdateMoveHelper()
		{
			if (this.action == EntityMoveHelper.Action.MOVE_TO)
			{
				double d0 = this.posX - this.parentEntity.posX;
				double d1 = this.posY - this.parentEntity.posY;
				double d2 = this.posZ - this.parentEntity.posZ;
				double d3 = d0 * d0 + d1 * d1 + d2 * d2;

				//if (this.courseChangeCooldown-- <= 0)
				{
					this.courseChangeCooldown += this.parentEntity.getRNG().nextInt(5) + 2;
					d3 = (double)MathHelper.sqrt(d3);

					if (this.isNotColliding(this.posX, this.posY, this.posZ, d3))
					{
						if(Math.abs(d0) >= 1 && Math.abs(d1) >= 1 && Math.abs(d2) >= 1) {
							this.action = EntityMoveHelper.Action.WAIT;
							return;
						}
						this.parentEntity.motionX += d0 / d3 * 0.1D;
						this.parentEntity.motionY += d1 / d3 * 0.1D;
						this.parentEntity.motionZ += d2 / d3 * 0.1D;
					}
					else
					{
						this.action = EntityMoveHelper.Action.WAIT;
					}
				}
			}
		}

		/**
		 * Checks if entity bounding box is not colliding with terrain
		 */
		private boolean isNotColliding(double x, double y, double z, double p_179926_7_)
		{
			double d0 = (x - this.parentEntity.posX) / p_179926_7_;
			double d1 = (y - this.parentEntity.posY) / p_179926_7_;
			double d2 = (z - this.parentEntity.posZ) / p_179926_7_;
			AxisAlignedBB axisalignedbb = this.parentEntity.getEntityBoundingBox();

			for (int i = 1; (double)i < p_179926_7_; ++i)
			{
				axisalignedbb = axisalignedbb.offset(d0, d1, d2);

				if (!this.parentEntity.world.getCollisionBoxes(this.parentEntity, axisalignedbb).isEmpty())
				{
					return false;
				}
			}

			return true;
		}
	}

}
