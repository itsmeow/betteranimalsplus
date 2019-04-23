package its_meow.betteranimalsplus.common.entity;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import its_meow.betteranimalsplus.common.entity.ai.EntityAIFollowOwnerFlying;
import its_meow.betteranimalsplus.common.entity.ai.LammerMoveHelper;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModLootTables;
import its_meow.betteranimalsplus.util.PolarVector3D;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISit;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.Path;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateFlying;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityLammergeier extends EntityTameableFlying implements IVariantTypes {
    
    protected static final DataParameter<Integer> TYPE_NUMBER = EntityDataManager.<Integer>createKey(EntityLammergeier.class, DataSerializers.VARINT);
    protected static final DataParameter<Byte> FLYING = EntityDataManager.<Byte>createKey(EntityLammergeier.class, DataSerializers.BYTE);
    protected static final DataParameter<Float> DATA_HEALTH_ID = EntityDataManager.<Float>createKey(EntityLammergeier.class, DataSerializers.FLOAT);

    public boolean landedLast = false;
    protected boolean readyToSit = false;

    // Forgive me for this godawful mess.

    public EntityLammergeier(World worldIn) {
        super(ModEntities.getEntityType(EntityLammergeier.class), worldIn);
        this.setSize(1F, 1F);
        // this.moveHelper = new EntityFlyHelper(this);
        this.moveHelper = new LammerMoveHelper(this);
    }

    /**
     * Returns true if this entity should move as if it were on a ladder (either
     * because it's actually on a ladder, or for AI reasons)
     */
    @Override
    public boolean isOnLadder() {
        return false;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return ModLootTables.lammergeier;
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 2;
    }

    @Override
    protected PathNavigate createNavigator(World worldIn) {
        PathNavigateFlying pathnavigateflying = new PathNavigateFlying(this, worldIn);
        pathnavigateflying.setCanOpenDoors(false);
        pathnavigateflying.setCanSwim(true);
        pathnavigateflying.setCanEnterDoors(true);
        return pathnavigateflying;
    }

    @Override
    public boolean canBePushed() {
        return super.canBePushed() && this.getPassengers().size() != 0;
    }

    @Override
    protected void initEntityAI() {
        this.aiSit = new EntityAISit(this);
        this.tasks.addTask(1, this.aiSit);
        this.tasks.addTask(2, new EntityLammergeier.AIMeleeAttack(this));
        this.tasks.addTask(3, new EntityAIFollowOwnerFlying(this, 0.5D, 10.0F, 50.0F));
        this.tasks.addTask(5, new EntityLammergeier.AIRandomFly(this));
        this.tasks.addTask(7, new EntityLammergeier.AILookAround(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityLammergeier.EntityAIFindEntityNearestFlying(this, EntitySkeleton.class));
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(EntityLammergeier.FLYING, Byte.valueOf((byte) 0));
        this.dataManager.register(EntityLammergeier.TYPE_NUMBER, Integer.valueOf(0));
        this.dataManager.register(EntityLammergeier.DATA_HEALTH_ID, Float.valueOf(this.getHealth()));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.isTamed() && this.dataManager.get(EntityLammergeier.DATA_HEALTH_ID).floatValue() < 6.0F
                ? SoundEvents.ENTITY_PARROT_HURT
                : null;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_PARROT_DEATH;
    }

    @Override
    protected float getSoundPitch() {
        return 0.4F; // Lower pitch
    }

    /**
     * Called when the entity is attacked.
     */
    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else {
            Entity entity = source.getTrueSource();

            if (this.aiSit != null) {
                this.setSitting(false);
            }

            if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow)) {
                amount = (amount + 1.0F) / 2.0F;
            }

            return super.attackEntityFrom(source, amount);
        }
    }

    private int lastTick = 0;
    public int ticksForFly = 0;
    public double lastMotionY = 0;

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        ItemStack itemstack = player.getHeldItem(hand);

        if (this.isTamed()) {
            if (!itemstack.isEmpty()) {
                if (itemstack.getItem() instanceof ItemFood) {
                    ItemFood itemfood = (ItemFood) itemstack.getItem();

                    if (this.dataManager.get(EntityLammergeier.DATA_HEALTH_ID).floatValue() < 20.0F) {
                        if (!player.isCreative()) {
                            itemstack.shrink(1);
                        }

                        this.heal(itemfood.getHealAmount(itemstack));
                        return true;
                    }
                }
            }
            if (this.isOwner(player) && !this.isBeingRidden() && !this.world.isRemote && this.ticksExisted - this.lastTick > 13 && (itemstack.getItem() == null || (itemstack.getItem() != Items.MUTTON))) {
                if (!this.isSitting()) {
                    this.setAttackTarget((EntityLivingBase) null);
                    this.navigator.clearPath();
                    BlockPos landPos = this.getPosition();
                    for(int y = (int) this.posY; y > 0 && y < 255; y--) {
                        BlockPos curPos = new BlockPos(landPos.getX(), y, landPos.getZ());
                        if(world.isAirBlock(curPos) && !world.isAirBlock(curPos.down())) {
                            landPos = curPos;
                            y = -1;
                        }
                    }
                    this.navigator.setPath(this.navigator.getPathToPos(landPos), 1D);
                    this.readyToSit = true;
                } else {
                    this.setSitting(!this.isSitting());
                    this.navigator.clearPath();
                }
                this.lastTick = this.ticksExisted;
            }
        } else if (itemstack.getItem() == Items.BONE && !this.isTamed()) {
            if (!player.isCreative()) {
                itemstack.shrink(1);
            }

            if (!this.world.isRemote) {
                if (!net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
                    this.setTamedBy(player);
                    // this.setOwnerId(player.getUniqueID());
                    this.navigator.clearPath();
                    // ((LammerMoveHelper) this.getMoveHelper()).action = Action.WAIT;
                    this.setAttackTarget((EntityLivingBase) null);
                    this.setSitting(true);
                    this.setHealth(20.0F);
                    this.playTameEffect(true);
                    this.world.setEntityState(this, (byte) 7);
                } else {
                    this.playTameEffect(false);
                    this.world.setEntityState(this, (byte) 6);
                }
            }

            return true;
        }

        return super.processInteract(player, hand);
    }

    /**
     * Checks if the parameter is an item which this animal can be fed to breed it
     * (wheat, carrots or seeds depending on the animal type)
     */
    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.getItem() == Items.BONE;
    }

    @Override
    public boolean shouldAttackEntity(EntityLivingBase target, EntityLivingBase owner) {
        if (!(target instanceof EntityCreeper) && !(target instanceof EntityGhast)) {
            if (target instanceof EntityLammergeier) {
                EntityLammergeier entitylam = (EntityLammergeier) target;

                if (entitylam.isTamed() && entitylam.getOwner() == owner) {
                    return false;
                }
            }

            if (target instanceof EntityPlayer && owner instanceof EntityPlayer
                    && !((EntityPlayer) owner).canAttackPlayer((EntityPlayer) target)) {
                return false;
            } else {
                return !(target instanceof AbstractHorse) || !((AbstractHorse) target).isTame();
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        float f = (float) this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue();
        int i = 0;

        if (entityIn instanceof EntityLivingBase) {
            f += EnchantmentHelper.getModifierForCreature(this.getHeldItemMainhand(),
                    ((EntityLivingBase) entityIn).getCreatureAttribute());
            i += EnchantmentHelper.getKnockbackModifier(this);
        }

        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), f);

        if (flag) {
            if (i > 0 && entityIn instanceof EntityLivingBase) {
                ((EntityLivingBase) entityIn).knockBack(this, i * 0.5F, MathHelper.sin(this.rotationYaw * 0.017453292F),
                        -MathHelper.cos(this.rotationYaw * 0.017453292F));
                this.motionX *= 0.6D;
                this.motionZ *= 0.6D;
            }

            int j = EnchantmentHelper.getFireAspectModifier(this);

            if (j > 0) {
                entityIn.setFire(j * 4);
            }

            if (entityIn instanceof EntityPlayer) {
                EntityPlayer entityplayer = (EntityPlayer) entityIn;
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

    @Override
    protected void collideWithEntity(Entity entityIn) {
        if (!this.getFlying()) {
            super.collideWithEntity(entityIn);
        }
    }

    @Override
    protected void collideWithNearbyEntities() {
        if (!this.getFlying()) {
            super.collideWithNearbyEntities();
        }
    }

    @Override
    public void fall(float distance, float damageMultiplier) {
        if (!this.getFlying()) {
            super.fall(distance, damageMultiplier);
        }
    }

    @Override
    protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {
        if (!this.getFlying()) {
            super.updateFallState(y, onGroundIn, state, pos);
        }
    }

    @Override
    public void tick() {
        super.tick();
        this.lastMotionY = this.motionY;
        if(world.isAreaLoaded(this.getPosition(), this.getPosition().down()) && world.isAirBlock(this.getPosition()) && !world.isAirBlock(this.getPosition().down()) && this.readyToSit) {
            this.readyToSit = false;
            this.setSitting(true);
        }
    }

    /**
     * Return whether this entity should NOT trigger a pressure plate or a tripwire.
     */
    @Override
    public boolean doesEntityNotTriggerPressurePlate() {
        return !this.getFlying();
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_SPEED);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(this.isTamed() ? 15.0D : 6.0D);
        this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(50.0D);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
        this.getAttribute(SharedMonsterAttributes.ATTACK_SPEED).setBaseValue(1.0D);
        this.getAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(5.0D);
    }

    public boolean getFlying() {
        return (this.dataManager.get(EntityLammergeier.FLYING).byteValue() & 1) != 0;
    }

    public void setFlying(boolean isFlying) {
        byte b0 = this.dataManager.get(EntityLammergeier.FLYING).byteValue();

        if (isFlying) {
            this.dataManager.set(EntityLammergeier.FLYING, Byte.valueOf((byte) (b0 | 1)));
        } else {
            this.dataManager.set(EntityLammergeier.FLYING, Byte.valueOf((byte) (b0 & -2)));
        }
        this.setNoGravity(isFlying);
    }

    @Override
    protected void updateAITasks() {
        super.updateAITasks();

        this.dataManager.set(EntityLammergeier.DATA_HEALTH_ID, Float.valueOf(this.getHealth()));

        BlockPos blockpos = new BlockPos(this);
        BlockPos blockpos1 = blockpos.down();

        if (!this.getFlying()) {
            if (this.world.getBlockState(blockpos1).isNormalCube() && this.getAttackTarget() == null) {
                this.setFlying(false);
                if (this.rand.nextInt(100) == 0) {
                    this.setFlying(true);
                }
            } else {
                this.setFlying(true);
                this.world.playEvent((EntityPlayer) null, 1025, blockpos, 0);
            }
        } else {
            if (this.rand.nextInt(20) == 0 && this.world.getBlockState(blockpos1).isNormalCube()) {
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
        double rx = Math.sqrt(Math.pow(x, 2) + Math.pow(z, 2));
        double thetax = Math.atan(z / x);
        double thetay = Math.atan(y / rx);
        double ry = Math.sqrt(Math.pow(rx, 2) + Math.pow(y, 2));
        return new PolarVector3D(thetax, thetay, ry);
    }

    public PolarVector3D toPolarCoordinates(int x, int y, int z) {
        return this.toPolarCoordinates(new BlockPos(x, y, z));
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    @Override
    public boolean writeUnlessRemoved(NBTTagCompound compound) {
        this.writeType(compound);
        compound.setByte("LammerFlying", this.dataManager.get(EntityLammergeier.FLYING).byteValue());
        return super.writeUnlessRemoved(compound);
    }

    @Override
    public void read(NBTTagCompound compound) {
        super.read(compound);
        this.readType(compound);
        this.dataManager.set(EntityLammergeier.FLYING, Byte.valueOf(compound.getByte("LammerFlying")));
    }

    @Override
    public void setTamed(boolean tamed) {
        super.setTamed(tamed);
        if (tamed) {
            this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0D);
        } else {
            this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0D);
        }

    }

    @Override
    @Nullable
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata,
            NBTTagCompound compound) {
        return this.initData(super.onInitialSpawn(difficulty, livingdata, compound));
    }

    @Override
    public void updatePassenger(Entity passenger) {
        if (this.isPassenger(passenger)) {
            passenger.setPosition(this.posX + this.motionX, this.posY - passenger.height - 0.05 + this.motionY,
                    this.posZ + this.motionZ);
            this.motionY += Math.abs(passenger.motionY);
            if (passenger instanceof EntityLivingBase
                    && (this.getAttackTarget() == null || this.getAttackTarget() != passenger)) {
                this.setAttackTarget((EntityLivingBase) passenger);
            }
            if (this.world.isRemote) {
                this.applyOrientationToEntity(passenger);
            }
        }
    }

    static class AIMeleeAttack extends net.minecraft.entity.ai.EntityAIAttackMelee {
        protected World world;
        protected EntityLammergeier attacker;
        /**
         * An amount of decrementing ticks that allows the entity to attack once the
         * tick reaches 0.
         */
        protected int attackTick;
        /** The speed with which the mob will approach the target */
        double speedTowardsTarget;
        /** The PathEntity of our entity. */
        Path path;
        protected final int attackInterval = 20;
        protected double liftY = 0;

        public AIMeleeAttack(EntityLammergeier lam) {
            super(lam, 0.5D, false);
            this.attacker = lam;
            this.world = lam.getEntityWorld();
            this.setMutexBits(2);
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        @Override
        public boolean shouldExecute() {
            EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();

            if (entitylivingbase == null) {
                return false;
            } else if (!entitylivingbase.isAlive()) {
                return false;
            }

            return true;
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        @Override
        public boolean shouldContinueExecuting() {
            EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();

            if (entitylivingbase == null) {
                return false;
            } else if (!entitylivingbase.isAlive()) {
                return false;
            } else {
                return !(entitylivingbase instanceof EntityPlayer) || !((EntityPlayer) entitylivingbase).isSpectator()
                        && !((EntityPlayer) entitylivingbase).isCreative();
            }
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        @Override
        public void startExecuting() {

        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by
         * another one
         */
        @Override
        public void resetTask() {
            EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();

            if (entitylivingbase instanceof EntityPlayer && (((EntityPlayer) entitylivingbase).isSpectator()
                    || ((EntityPlayer) entitylivingbase).isCreative())) {
                this.attacker.setAttackTarget((EntityLivingBase) null);
            }
        }

        @Override
        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();

            double targetX = entitylivingbase.posX;
            double targetY = entitylivingbase.posY;
            double targetZ = entitylivingbase.posZ;

            if (entitylivingbase.getDistanceSq(this.attacker) < 4096.0D) // If the distance is less than 4096 square
                                                                         // blocks rotate towards them
            {
                double d1 = entitylivingbase.posX - this.attacker.posX;
                double d2 = entitylivingbase.posZ - this.attacker.posZ;
                this.attacker.rotationYaw = -((float) MathHelper.atan2(d1, d2)) * (180F / (float) Math.PI);
                this.attacker.renderYawOffset = this.attacker.rotationYaw;
            }

            double distanceToTarget = this.attacker.getDistanceSq(entitylivingbase.posX, entitylivingbase.posY,
                    entitylivingbase.posZ);

            // Reduce time till attack
            this.attackTick--;

            double reachToTarget = this.getAttackReachSqr(entitylivingbase);

            // If the entity can reach its target and it's time to attack, reset
            // the timer and attack if the entity is not grabbed
            if (distanceToTarget <= reachToTarget && this.attackTick <= 0) {
                this.attackTick = 20;
                if (!attacker.isRidingOrBeingRiddenBy(entitylivingbase)) {
                    this.attacker.attackEntityAsMob(entitylivingbase);
                }
            }

            // If the entity is not grabbing a target, set it to move to its target
            if (!attacker.getMoveHelper().isUpdating()) {
                if (attacker.getPassengers().size() == 0) {
                    this.attacker.getMoveHelper().setMoveTo(targetX, targetY, targetZ, 1.0D);
                } else { // If the entity is grabbing a target, set it to move upwards
                    this.attacker.getMoveHelper().setMoveTo(targetX, this.liftY + 15, targetZ, 5.0D);
                }
            }

            // If the entity is in range and entity is not grabbing a target and
            // the target's height is less than 3 blocks
            if (distanceToTarget <= reachToTarget && attacker.getPassengers().size() == 0
                    && entitylivingbase.height <= 3 && this.attackTick == 20) {
                // Move the entity upwards to avoid being stuck in the ground
                this.attacker.setLocationAndAngles(this.attacker.posX, this.attacker.posY + entitylivingbase.height + 2,
                        this.attacker.posZ, this.attacker.rotationYaw, this.attacker.rotationPitch);
                // Grab the target
                entitylivingbase.startRiding(this.attacker, true);
                // Set liftY so entity can continue moving up from the spot
                this.liftY = entitylivingbase.posY;
                // Remove targets of the entity (to avoid something stupid like
                // a skeleton shooting while being eaten by a bird)
                if (entitylivingbase instanceof EntityLiving) {
                    EntityLiving el = (EntityLiving) entitylivingbase;
                    el.setAttackTarget(null);
                    el.setRevengeTarget(null);
                }
                // Move upwards
                this.attacker.getMoveHelper().setMoveTo(targetX, this.liftY + 15, targetZ, 5.0D);
            }

            // If the entity is grabbing a target and the block above is solid
            // (stuck)
            if (attacker.getPassengers().size() == 0
                    && this.attacker.getEntityWorld().getBlockState(this.attacker.getPosition().up()).isFullCube()) {
                // Release target
                entitylivingbase.stopRiding();
                // Remove target
                this.attacker.setAttackTarget(null);
                // Create a random target position
                Random random = this.attacker.getRNG();
                BlockPos rPos = this.attacker
                        .fromPolarCoordinates(new PolarVector3D(this.attacker.rotationYaw + (random.nextInt(40) - 20),
                                random.nextInt(40) - 20, random.nextInt(15) + 1 + random.nextFloat()));
                BlockPos pos = this.attacker.getPosition();
                rPos = rPos.add(pos);
                // Move to random target position
                this.attacker.getMoveHelper().setMoveTo(rPos.getX(), rPos.getY(), rPos.getZ(), 1.0D);
            }

            // If we've about reached the target lifting point and have a target
            // grabbed, or have completed movement, drop the entity
            if (Math.abs(this.attacker.posY - (this.liftY + 15)) <= 3 && attacker.getPassengers().size() > 0) {
                entitylivingbase.stopRiding();
            }

        }
    }

    static class AILookAround extends EntityAIBase {

        private final EntityLammergeier parentEntity;

        public AILookAround(EntityLammergeier lam) {
            this.parentEntity = lam;
            this.setMutexBits(2);
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        @Override
        public boolean shouldExecute() {
            return this.parentEntity.getFlying();
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        @Override
        public void tick() {
            if (this.parentEntity.getAttackTarget() == null) {
                if (!this.parentEntity.isTamed()) {
                    this.parentEntity.rotationYaw = -((float) MathHelper.atan2(this.parentEntity.motionX,
                            this.parentEntity.motionZ)) * (180F / (float) Math.PI);
                    this.parentEntity.renderYawOffset = this.parentEntity.rotationYaw;
                } else {
                    EntityLivingBase entitylivingbase = this.parentEntity.getOwner();
                    if (entitylivingbase != null) {

                        if (entitylivingbase.getDistanceSq(this.parentEntity) < 4096.0D) {
                            double d1 = entitylivingbase.posX - this.parentEntity.posX;
                            double d2 = entitylivingbase.posZ - this.parentEntity.posZ;
                            this.parentEntity.rotationYaw = -((float) MathHelper.atan2(d1, d2))
                                    * (180F / (float) Math.PI);
                            this.parentEntity.renderYawOffset = this.parentEntity.rotationYaw;
                        }
                    }
                }
            } else {
                EntityLivingBase entitylivingbase = this.parentEntity.getAttackTarget();

                if (entitylivingbase.getDistanceSq(this.parentEntity) < 4096.0D) {
                    double d1 = entitylivingbase.posX - this.parentEntity.posX;
                    double d2 = entitylivingbase.posZ - this.parentEntity.posZ;
                    this.parentEntity.rotationYaw = -((float) MathHelper.atan2(d1, d2)) * (180F / (float) Math.PI);
                    this.parentEntity.renderYawOffset = this.parentEntity.rotationYaw;
                }
            }
        }
    }

    static class AIRandomFly extends EntityAIBase {

        private final EntityLammergeier parentEntity;

        public AIRandomFly(EntityLammergeier lam) {
            this.parentEntity = lam;
            this.setMutexBits(1);
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        @Override
        public boolean shouldExecute() {
            EntityMoveHelper entitymovehelper = this.parentEntity.getMoveHelper();

            if (this.parentEntity.isTamed()) {
                return false;
            }
            if (this.parentEntity.getAttackTarget() == null) {
                return true;
            }
            double d0 = entitymovehelper.getX() - this.parentEntity.posX;
            double d1 = entitymovehelper.getY() - this.parentEntity.posY;
            double d2 = entitymovehelper.getZ() - this.parentEntity.posZ;
            double d3 = d0 * d0 + d1 * d1 + d2 * d2;
            return d3 < 1.0D || d3 > 3600.0D;
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        @Override
        public boolean shouldContinueExecuting() {
            return false;
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        @Override
        public void startExecuting() {
            Random random = this.parentEntity.getRNG();
            if (random.nextInt(30) != 1 && !this.parentEntity.landedLast) {
                this.parentEntity.setFlying(true);
                BlockPos rPos = this.parentEntity.fromPolarCoordinates(
                        new PolarVector3D(this.parentEntity.rotationYaw + (random.nextInt(50) - 25),
                                random.nextInt(30) - 10, random.nextInt(50) + 1 + random.nextFloat()));
                BlockPos pos = this.parentEntity.getPosition();
                rPos = rPos.add(pos);
                this.parentEntity.getMoveHelper().setMoveTo(rPos.getX(), rPos.getY(), rPos.getZ(), 1.0D);
            } else if (!this.parentEntity.landedLast && this.parentEntity.posY > 65 && this.parentEntity.getFlying()) {
                BlockPos rPos = this.findLandingPosition();
                this.parentEntity.landedLast = true;
                this.parentEntity.getMoveHelper().setMoveTo(rPos.getX(), rPos.getY(), rPos.getZ(), 1.1D);
            } else {
                this.parentEntity.ticksForFly++;
                if (this.parentEntity.ticksForFly == 120) {
                    this.parentEntity.setFlying(false);
                    this.parentEntity.landedLast = false;
                    this.parentEntity.ticksForFly = 0;
                }
            }
        }

        private BlockPos findLandingPosition() {
            World world = this.parentEntity.world;
            Random random = this.parentEntity.getRNG();
            float x = (int) this.parentEntity.posX + random.nextInt(16) - 8F + 0.5F;
            float z = (int) this.parentEntity.posZ + random.nextInt(16) - 8F + 0.5F;

            float y = AIRandomFly.getTopSolidOrLiquidBlock(world, new BlockPos(x, 0, z)).getY();

            BlockPos pos = new BlockPos(x, y, z);

            return pos;
        }

        private static BlockPos getTopSolidOrLiquidBlock(World world, BlockPos pos) {
            for (int i = world.getHeight(); i > world.getSeaLevel(); i--) {
                BlockPos pos2 = new BlockPos(pos.getX(), i, pos.getZ());
                IBlockState state = world.getBlockState(pos2.down());
                if (world.isAirBlock(pos2) && state.isTopSolid() && world.canSeeSky(pos2)) {
                    return pos2;
                }
            }
            return new BlockPos(pos.getX(), world.getSeaLevel() + 40, pos.getZ());
        }
    }

    static class EntityAIFindEntityNearestFlying extends EntityAIBase {

        private final EntityLammergeier mob;
        private final Predicate<EntityLivingBase> predicate;
        private final EntityAINearestAttackableTarget.Sorter sorter;
        private EntityLivingBase target;
        private final Class<? extends EntityLivingBase> classToCheck;

        public EntityAIFindEntityNearestFlying(EntityLammergeier mobIn, Class<? extends EntityLivingBase> p_i45884_2_) {
            // super(mobIn, p_i45884_2_);
            this.mob = mobIn;
            this.classToCheck = p_i45884_2_;
            this.predicate = (@Nullable EntityLivingBase p_apply_1_) -> {
                double d0 = EntityAIFindEntityNearestFlying.this.getFollowRange();

                if (p_apply_1_.isSneaking()) {
                    d0 *= 0.800000011920929D;
                }

                if (p_apply_1_.isInvisible()) {
                    return false;
                } else {
                    return p_apply_1_.getDistance(EntityAIFindEntityNearestFlying.this.mob) > d0 ? false
                            : EntityAITarget.isSuitableTarget(EntityAIFindEntityNearestFlying.this.mob, p_apply_1_,
                                    false, true);
                }
            };

            this.sorter = new EntityAINearestAttackableTarget.Sorter(mobIn);
        }

        @Override
        public boolean shouldExecute() {
            if (this.mob.isTamed()) {
                return false;
            }

            double d0 = this.getFollowRange();
            List<EntityLivingBase> list = this.mob.world.<EntityLivingBase>getEntitiesWithinAABB(this.classToCheck,
                    this.mob.getBoundingBox().grow(d0, d0, d0), this.predicate);
            Collections.sort(list, this.sorter);

            if (list.isEmpty()) {
                return false;
            } else {
                this.target = list.get(0);
                return true;
            }
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        @Override
        public boolean shouldContinueExecuting() {
            EntityLivingBase entitylivingbase = this.mob.getAttackTarget();

            if (entitylivingbase == null) {
                return false;
            } else if (!entitylivingbase.isAlive()) {
                return false;
            } else if (mob.getPassengers().size() == 0) {
                return false;
            } else {
                double d0 = this.getFollowRange();

                if (this.mob.getDistanceSq(entitylivingbase) > d0 * d0) {
                    this.mob.setAttackTarget(null);
                    return false;
                } else {
                    return !(entitylivingbase instanceof EntityPlayerMP)
                            || !((EntityPlayerMP) entitylivingbase).interactionManager.isCreative();
                }
            }
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        @Override
        public void startExecuting() {
            this.mob.setAttackTarget(this.target);
            super.startExecuting();
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by
         * another one
         */
        @Override
        public void resetTask() {
            this.mob.setAttackTarget((EntityLivingBase) null);
            super.startExecuting();
        }

        protected double getFollowRange() {
            IAttributeInstance iattributeinstance = this.mob.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE);
            return iattributeinstance == null ? 16.0D : iattributeinstance.getValue();
        }

    }

    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return null;
    }

    @Override
    public DataParameter<Integer> getDataKey() {
        return TYPE_NUMBER;
    }

    @Override
    public int getVariantMax() {
        return 4;
    }

    @Override
    public boolean isChildI() {
        return this.isChild();
    }

    @Override
    public Random getRNGI() {
        return this.getRNG();
    }

    @Override
    public EntityDataManager getDataManagerI() {
        return this.getDataManager();
    }

}
