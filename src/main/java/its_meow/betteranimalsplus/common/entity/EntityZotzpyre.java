package its_meow.betteranimalsplus.common.entity;

import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SPacketSetPassengers;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateClimber;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.BiomeDictionary;

public class EntityZotzpyre extends EntityAnimalWithTypes {

    private static final DataParameter<Byte> CLIMBING = EntityDataManager.<Byte>createKey(EntityZotzpyre.class, DataSerializers.BYTE);
    protected int lastAttack = 0;
    private boolean isFromZotz = false;

    public EntityZotzpyre(World world) {
        super(world);
        this.setSize(1F, 1F);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAILeapAtTarget(this, 0.5F));
        this.tasks.addTask(1, new EntityAIWanderAvoidWater(this, 0.6D));
        this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(2, new EntityAILookIdle(this));
        this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, false, new Class[0]));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget<EntityPlayer>(this, EntityPlayer.class, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<EntityLiving>(this, EntityLiving.class, 0, true, true, (EntityLiving entity) -> !(entity instanceof EntityZotzpyre) && entity.getCreatureAttribute() != EnumCreatureAttribute.UNDEAD));
    }
    
    protected PathNavigate createNavigator(World worldIn) {
        return new PathNavigateClimber(this, worldIn);
    }
    
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(CLIMBING, (byte) 0);
    }

    @Override
    public boolean canBePushed() {
        return false;
    }

    @Override
    protected void collideWithEntity(Entity entityIn) {}

    @Override
    protected void collideWithNearbyEntities() {}

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if(!this.world.isRemote && this.isDead && this.isRiding() || (!this.world.isRemote && this.isRiding() && this.getRidingEntity().isDead)) {
            this.dismountZotz();
        }
        if(!this.world.isRemote) {
            this.setBesideClimbableBlock(this.collidedHorizontally);
        }
    }

    /* prevent slowdown in air */
    public void travel(float strafe, float vertical, float forward) {
        if(this.isServerWorld() || this.canPassengerSteer()) {
            double d0 = this.posY;
            float f1 = this.getWaterSlowDown();
            float f2 = 0.02F;
            float f3 = (float) EnchantmentHelper.getDepthStriderModifier(this);
            if(f3 > 3.0F) {
                f3 = 3.0F;
            }
            // normally vanilla puts slowdown here
            if(f3 > 0.0F) {
                f1 += (0.54600006F - f1) * f3 / 3.0F;
                f2 += (this.getAIMoveSpeed() - f2) * f3 / 3.0F;
            }
            this.moveRelative(strafe, vertical, forward, f2);
            this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
            this.motionX *= (double) f1;
            this.motionY *= 0.800000011920929D;
            this.motionZ *= (double) f1;
            if(!this.hasNoGravity()) {
                this.motionY -= 0.02D;
            }
            if(this.collidedHorizontally && this.isOffsetPositionInLiquid(this.motionX, this.motionY + 0.6000000238418579D - this.posY + d0, this.motionZ)) {
                this.motionY = 0.30000001192092896D;
            }
        }
        this.prevLimbSwingAmount = this.limbSwingAmount;
        double d5 = this.posX - this.prevPosX;
        double d7 = this.posZ - this.prevPosZ;
        double d9 = this instanceof net.minecraft.entity.passive.EntityFlying ? this.posY - this.prevPosY : 0.0D;
        float f10 = MathHelper.sqrt(d5 * d5 + d9 * d9 + d7 * d7) * 4.0F;
        if(f10 > 1.0F) {
            f10 = 1.0F;
        }
        this.limbSwingAmount += (f10 - this.limbSwingAmount) * 0.4F;
        this.limbSwing += this.limbSwingAmount;
    }

    public boolean isOnLadder() {
        return this.isBesideClimbableBlock();
    }
    
    public boolean isBesideClimbableBlock() {
        return (this.dataManager.get(CLIMBING) & 1) != 0;
    }

    public void setBesideClimbableBlock(boolean climbing) {
        byte b0 = ((Byte) this.dataManager.get(CLIMBING)).byteValue();
        this.dataManager.set(CLIMBING, climbing ? (byte) (b0 | 1) : (byte) (b0 & -2));
    }

    @Override
    protected float getSoundVolume() {
        return 0.5F;
    }

    @Override
    protected float getSoundPitch() {
        return super.getSoundPitch() * 0.05F;
    }

    @Override
    public SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_BAT_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_BAT_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_BAT_DEATH;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if(!this.onGround && this.motionY < 0.0D) {
            this.motionY *= 0.8D;
        }
        if(!this.world.isRemote && this.getAttackTarget() != null && !this.getAttackTarget().isDead) {
            if(this.isRiding() && this.getRidingEntity() == this.getAttackTarget()) {
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
    public boolean shouldDismountInWater(Entity rider) {
        return false;
    }

    public void grabTarget(Entity entity) {
        if(!world.isRemote) {
            if(!this.isRiding()) {
                this.startRiding(entity, true);
                if(entity instanceof EntityPlayerMP) {
                    ((EntityPlayerMP) entity).connection.sendPacket(new SPacketSetPassengers(entity));
                }
            }
        }
    }
    
    public void dismountZotz() {
        if(!world.isRemote) {
            Entity mount = this.getRidingEntity();
            this.dismountEntity(mount);
            this.isFromZotz = true;
            this.dismountRidingEntity();
            this.isFromZotz  = false;
            if(mount instanceof EntityPlayerMP) {
                ((EntityPlayerMP) mount).connection.sendPacket(new SPacketSetPassengers(mount));
            }
        }
    }

    @Override
    public void dismountRidingEntity() {
        if(this.world.isChunkGeneratedAt(this.chunkCoordX, this.chunkCoordZ)) {
            if(this.getRidingEntity() != null && !this.getRidingEntity().shouldDismountInWater(this)) {
                super.dismountRidingEntity();
            } else if(this.getAttackTarget() == null || isFromZotz) {
                super.dismountRidingEntity();
            }
        }
    }

    @Override
    public boolean canRiderInteract() {
        return true;
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
    public boolean getCanSpawnHere() {
        BlockPos blockpos = new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ);
        if(blockpos.getY() >= this.world.getSeaLevel() && !BiomeDictionary.getTypes(world.getBiome(blockpos)).contains(BiomeDictionary.Type.JUNGLE)) { // allow spawning on surface in jungles
            return false;
        } else {
            int i = this.world.getLightFromNeighbors(blockpos);
            int j = 4;
            if(this.rand.nextBoolean()) {
                return false;
            }
            if(!(i > this.rand.nextInt(j))) {
                IBlockState iblockstate = this.world.getBlockState((new BlockPos(this)).down());
                return iblockstate.canEntitySpawn(this);
            } else {
                return false;
            }
        }
    }

    public boolean attackEntityFrom(DamageSource source, float amount) {
        if(this.isEntityInvulnerable(source)) {
            return false;
        } else {
            if(amount > 3 && this.isRiding() && !this.world.isRemote) {
                this.dismountZotz();
            }

            return super.attackEntityFrom(source, amount);
        }
    }
    
    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        float f = (float) this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), f);
        if(flag) {
            this.lastAttack = this.ticksExisted;
            if(entityIn instanceof EntityPlayer) {
                EntityPlayer entityplayer = (EntityPlayer) entityIn;
                int slowTicks = 0;
                if(this.world.getDifficulty() == EnumDifficulty.EASY) {
                    slowTicks = 200; // 10s
                } else if(this.world.getDifficulty() == EnumDifficulty.NORMAL) {
                    slowTicks = 300; // 15s
                } else if(this.world.getDifficulty() == EnumDifficulty.HARD) {
                    slowTicks = 600; // 30s
                }
                entityplayer.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("slowness"), slowTicks, 1, false, false));
            }
        }
        return flag;
    }
    
    @Override
    public void fall(float distance, float damageMultiplier) {
    }

    @Override
    public int getVariantMax() {
        return 5;
    }

    @Override
    protected IVariantTypes getBaseChild() {
        return null;
    }

    @Override
    protected String getContainerName() {
        return "zotzpyre";
    }

    @Override
    public boolean canBeLeashedTo(EntityPlayer player) {
        return false;
    }

}
