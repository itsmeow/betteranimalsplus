package its_meow.betteranimalsplus.common.entity;

import java.util.EnumSet;
import java.util.Random;

import dev.itsmeow.imdlib.entity.util.IVariantTypes;
import its_meow.betteranimalsplus.common.entity.ai.EntityAIFollowOwnerFlying;
import its_meow.betteranimalsplus.common.entity.ai.LammerMoveHelper;
import its_meow.betteranimalsplus.common.entity.util.EntityTypeContainerBAPTameable;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntityTameableBetterAnimalsPlus;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntityTameableFlyingWithTypes;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntityTameableWithTypes;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModLootTables;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.OwnerHurtByTargetGoal;
import net.minecraft.entity.ai.goal.OwnerHurtTargetGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SitGoal;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.GhastEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.Path;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityLammergeier extends EntityTameableFlyingWithTypes implements IVariantTypes<EntityTameableBetterAnimalsPlus> {

    protected static final DataParameter<Float> DATA_HEALTH_ID = EntityDataManager.<Float>createKey(EntityLammergeier.class, DataSerializers.FLOAT);

    protected boolean readyToSit = false;
    public float lastRotX = 0;
    public float rotX = 0;
    private int lastTick = 0;
    public double lastMotionY = 0;
    private final MovementController flightControl;

    public EntityLammergeier(World worldIn) {
        super(ModEntities.LAMMERGEIER.entityType, worldIn);
        this.flightControl = new LammerMoveHelper(this);
        this.moveController = flightControl;
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
    public boolean canBePushed() {
        return super.canBePushed() && this.getPassengers().size() != 0;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new SitGoal(this));
        this.goalSelector.addGoal(2, new EntityLammergeier.AIMeleeAttack(this));
        this.goalSelector.addGoal(3, new EntityAIFollowOwnerFlying(this, 2D, 8.0F, 50.0F) {
            @Override
            public void startExecuting() {
                if(!EntityLammergeier.this.getFlying()) {
                    EntityLammergeier.this.setFlying(true);
                }
                super.startExecuting();
            }

            @Override
            public void tick() {
                if(!EntityLammergeier.this.getFlying()) {
                    EntityLammergeier.this.setFlying(true);
                }
                super.tick();
            }
        });
        this.goalSelector.addGoal(4, new EntityLammergeier.AILanding(this));
        this.goalSelector.addGoal(5, new EntityLammergeier.AIRandomFly(this));
        this.goalSelector.addGoal(5, new RandomWalkingGoal(this, 0.1F) {
            @Override
            public boolean shouldExecute() {
                return !EntityLammergeier.this.isTamed() && !EntityLammergeier.this.getFlying() && super.shouldContinueExecuting();
            }

            @Override
            public boolean shouldContinueExecuting() {
                return !EntityLammergeier.this.isTamed() && !EntityLammergeier.this.getFlying() && super.shouldContinueExecuting();
            }
        });
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this) {
            @Override
            public boolean shouldExecute() {
                return !EntityLammergeier.this.isSitting() && super.shouldExecute();
            }
        });
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this) {
            @Override
            public boolean shouldExecute() {
                return !EntityLammergeier.this.isSitting() && super.shouldExecute();
            }
        });
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<SkeletonEntity>(this, SkeletonEntity.class, false) {
            @Override
            public boolean shouldExecute() {
                return !EntityLammergeier.this.isTamed() && super.shouldExecute();
            }
        });
    }

    @Override
    public void setAttackTarget(LivingEntity entitylivingbaseIn) {
        if(!this.isSitting()) {
            super.setAttackTarget(entitylivingbaseIn);
        }
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(EntityLammergeier.DATA_HEALTH_ID, Float.valueOf(this.getHealth()));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.isTamed() && this.dataManager.get(EntityLammergeier.DATA_HEALTH_ID).floatValue() < 6.0F ? SoundEvents.ENTITY_PARROT_HURT : null;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_PARROT_DEATH;
    }

    @Override
    protected float getSoundPitch() {
        return 0.4F; // Lower pitch
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if(this.isTamed() && !this.isInvulnerableTo(source)) {
            this.setSitting(false);
        }
        if(this.getAttackTarget() != null && this.getAttackTarget() == source.getTrueSource() && this.getAttackTarget().isRidingOrBeingRiddenBy(this)) {
            return super.attackEntityFrom(source, amount / 2F);
        }
        return super.attackEntityFrom(source, amount);
    }

    @Override
    public boolean processInteract(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);

        if(this.isTamed()) {
            if(!itemstack.isEmpty()) {
                if(itemstack.getItem().isFood()) {
                    Food food = itemstack.getItem().getFood();

                    if(this.dataManager.get(EntityLammergeier.DATA_HEALTH_ID) < 20.0F) {
                        if(!player.isCreative()) {
                            itemstack.shrink(1);
                        }
                        for(int i = 0; i < 10; i++) {
                            this.world.addParticle(ParticleTypes.HAPPY_VILLAGER, getPosX() + (this.getRNG().nextFloat() - 0.5F), getPosY() + this.getRNG().nextFloat(), getPosZ() + (this.getRNG().nextFloat() - 0.5F), 0, 0, 0);
                        }
                        this.heal((float) food.getHealing());
                        return true;
                    }
                }
            }
            if(this.isOwner(player) && !this.isBeingRidden() && !this.world.isRemote && this.ticksExisted - this.lastTick > 13 && (itemstack.getItem() == null || !itemstack.isFood())) {
                if(!this.isSitting()) {
                    this.setAttackTarget((LivingEntity) null);
                    this.navigator.clearPath();
                    this.readyToSit = true;
                } else {
                    this.readyToSit = false;
                    this.setSitting(!this.isSitting());
                    this.navigator.clearPath();
                }
                this.lastTick = this.ticksExisted;
            }
        } else if(this.isTamingItem(itemstack.getItem()) && !this.isTamed()) {
            if(!player.isCreative()) {
                itemstack.shrink(1);
            }

            if(!this.world.isRemote) {
                if(!net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
                    this.setTamedBy(player);
                    // this.setOwnerId(player.getUniqueID());
                    this.navigator.clearPath();
                    // ((LammerMoveHelper) this.getMoveHelper()).action = Action.WAIT;
                    this.setAttackTarget((LivingEntity) null);
                    this.setSitting(true);
                    this.setHealth(20.0F);
                    this.world.setEntityState(this, (byte) 7);
                } else {
                    this.world.setEntityState(this, (byte) 6);
                }
            }

            return true;
        }

        return super.processInteract(player, hand);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return this.isTamingItem(stack.getItem());
    }

    @Override
    public boolean shouldAttackEntity(LivingEntity target, LivingEntity owner) {
        if(!(target instanceof CreeperEntity) && !(target instanceof GhastEntity)) {
            if(target instanceof EntityLammergeier) {
                EntityLammergeier entitylam = (EntityLammergeier) target;

                if(entitylam.isTamed() && entitylam.getOwner() == owner) {
                    return false;
                }
            }

            if(target instanceof PlayerEntity && owner instanceof PlayerEntity
            && !((PlayerEntity) owner).canAttackPlayer((PlayerEntity) target)) {
                return false;
            } else {
                return !(target instanceof AbstractHorseEntity) || !((AbstractHorseEntity) target).isTame();
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        return entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float) this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue());
    }

    @Override
    public void tick() {
        if((Math.abs(this.getMotion().getY()) > 0 && (Math.abs(this.getMotion().getX()) > 0.05 || Math.abs(this.getMotion().getZ()) > 0.05)) || Math.abs(this.getMotion().getY()) > 0.25) {
            float x = -((float) Math.atan(this.getMotion().getY() / Math.sqrt(Math.pow(this.getMotion().getX(), 2) + Math.pow(this.getMotion().getZ(), 2))) / 1.5F);
            if(x < 0) {
                x /= 3;
            }
            rotX = x;
        } else {
            rotX = 0;
        }
        super.tick();
        this.lastMotionY = this.getMotion().getY();
        lastRotX = rotX;
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_SPEED);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(this.isTamed() ? 15.0D : 6.0D);
        this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(100.0D);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
        this.getAttribute(SharedMonsterAttributes.ATTACK_SPEED).setBaseValue(1.0D);
        this.getAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(1.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
    }

    @Override
    protected void updateAITasks() {
        super.updateAITasks();
        this.dataManager.set(EntityLammergeier.DATA_HEALTH_ID, this.getHealth());
        this.setNoGravity(this.getFlying());
    }

    @Override
    public void setTamed(boolean tamed) {
        super.setTamed(tamed);
        if(tamed) {
            this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        } else {
            this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0D);
        }
    }

    @Override
    public void updatePassenger(Entity passenger) {
        passenger.setPosition(this.getPosX() + this.getMotion().getX(), this.getPosY() - passenger.getHeight() - 0.05 + this.getMotion().getY(),
        this.getPosZ() + this.getMotion().getZ());
        this.setMotion(this.getMotion().getX(), this.getMotion().getY() + Math.abs(passenger.getMotion().getY()), this.getMotion().getZ());
        if(passenger instanceof LivingEntity && (this.getAttackTarget() == null || this.getAttackTarget() != passenger)) {
            this.setAttackTarget((LivingEntity) passenger);
        }
        if(this.world.isRemote) {
            this.applyOrientationToEntity(passenger);
        }
    }

    static class AIMeleeAttack extends Goal {
        protected World world;
        protected EntityLammergeier attacker;
        protected int attackTick;
        double speedTowardsTarget;
        Path path;
        protected final int attackInterval = 20;
        protected double liftY = 0;

        public AIMeleeAttack(EntityLammergeier lam) {
            this.attacker = lam;
            this.world = lam.getEntityWorld();
            this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.TARGET));
        }

        @Override
        public boolean shouldExecute() {
            LivingEntity entitylivingbase = this.attacker.getAttackTarget();

            if(entitylivingbase == null) {
                return false;
            } else if(!entitylivingbase.isAlive()) {
                return false;
            }

            return !(entitylivingbase instanceof PlayerEntity) || !((PlayerEntity) entitylivingbase).isInvulnerable();
        }

        @Override
        public boolean shouldContinueExecuting() {
            return shouldExecute();
        }

        @Override
        public void startExecuting() {

        }

        @Override
        public void resetTask() {
            LivingEntity entitylivingbase = this.attacker.getAttackTarget();

            if(entitylivingbase instanceof PlayerEntity && (((PlayerEntity) entitylivingbase).isSpectator() || ((PlayerEntity) entitylivingbase).isCreative())) {
                this.attacker.setAttackTarget((LivingEntity) null);
            }
        }

        @Override
        public void tick() {
            if(!attacker.getFlying()) {
                attacker.setFlying(true);
            }
            LivingEntity entitylivingbase = this.attacker.getAttackTarget();

            double targetX = entitylivingbase.getPosX();
            double targetZ = entitylivingbase.getPosZ();

            if(entitylivingbase.getDistanceSq(this.attacker) < 4096.0D) // If the distance is less than 4096 square blocks rotate towards them
            {
                double d1 = entitylivingbase.getPosX() - this.attacker.getPosX();
                double d2 = entitylivingbase.getPosZ() - this.attacker.getPosZ();
                this.attacker.rotationYaw = -((float) MathHelper.atan2(d1, d2)) * (180F / (float) Math.PI);
                this.attacker.renderYawOffset = this.attacker.rotationYaw;
            }

            double distanceToTarget = this.attacker.getDistanceSq(entitylivingbase.getPosX(), entitylivingbase.getPosY(),
            entitylivingbase.getPosZ());

            // Reduce time till attack
            this.attackTick--;

            double reachToTarget = this.getAttackReachSqr(entitylivingbase);

            // If the entity can reach its target and it's time to attack, reset
            // the timer and attack if the entity is not grabbed
            if(distanceToTarget <= reachToTarget && this.attackTick <= 0) {
                this.attackTick = 20;
                if(!attacker.isRidingOrBeingRiddenBy(entitylivingbase)) {
                    this.attacker.attackEntityAsMob(entitylivingbase);
                }
            }

            // If the entity is not grabbing a target, set it to move to its target
            if(attacker.getPassengers().size() == 0) {
                this.attacker.navigator.setPath(this.attacker.navigator.getPathToPos(entitylivingbase.getPosition(), 0), 0.4D);
            } else { // If the entity is grabbing a target, set it to move upwards
                this.attacker.navigator.setPath(this.attacker.navigator.getPathToPos(new BlockPos(targetX, this.liftY + 15, targetZ), 0), 0.4D);
            }

            // If the entity is in range and entity is not grabbing a target and
            // the target's height is less than 3 blocks
            if(distanceToTarget <= reachToTarget && attacker.getPassengers().size() == 0 && entitylivingbase.getHeight() <= 3 && this.attackTick == 15) {
                // Move the entity upwards to avoid being stuck in the ground
                this.attacker.setLocationAndAngles(this.attacker.getPosX(), this.attacker.getPosY() + entitylivingbase.getHeight() + 2,
                this.attacker.getPosZ(), this.attacker.rotationYaw, this.attacker.rotationPitch);
                // Grab the target
                entitylivingbase.startRiding(this.attacker, true);
                // Set liftY so entity can continue moving up from the spot
                this.liftY = entitylivingbase.getPosY();
                // Remove targets of the entity (to avoid something stupid like
                // a skeleton shooting while being eaten by a bird)
                if(entitylivingbase instanceof MobEntity) {
                    MobEntity el = (MobEntity) entitylivingbase;
                    el.setAttackTarget(null);
                    el.setRevengeTarget(null);
                    el.getNavigator().clearPath();
                    el.setNoAI(true);
                }
                // Move upwards
                this.attacker.navigator.setPath(this.attacker.navigator.getPathToPos(new BlockPos(targetX, this.liftY + 15, targetZ), 0), 0.4D);
            }

            // If the entity is grabbing a target and the block above is solid
            // (stuck)
            if(attacker.getPassengers().size() == 0 && this.attacker.getEntityWorld().getBlockState(this.attacker.getPosition().up()).isNormalCube(world, this.attacker.getPosition().up())) {
                // Release target
                entitylivingbase.stopRiding();
                if(entitylivingbase instanceof MobEntity) {
                    MobEntity el = (MobEntity) entitylivingbase;
                    el.setNoAI(false);
                }
                // Remove target
                this.attacker.setAttackTarget(null);
                // Create a random target position
                BlockPos rPos = new BlockPos(this.attacker.getRNG().nextInt(50) - 25, this.attacker.getRNG().nextInt(40) - 20, this.attacker.getRNG().nextInt(50) - 25);
                BlockPos pos = this.attacker.getPosition();
                rPos = rPos.add(pos);
                // Move to random target position
                this.attacker.navigator.setPath(this.attacker.navigator.getPathToPos(rPos, 0), 0.4D);
            }

            // If we've about reached the target lifting point and have a target
            // grabbed, or have completed movement, drop the entity
            if (Math.abs(this.attacker.getPosY() - (this.liftY + 15)) <= 3 && attacker.getPassengers().size() > 0) {
                entitylivingbase.stopRiding();
                if(entitylivingbase instanceof MobEntity) {
                    MobEntity el = (MobEntity) entitylivingbase;
                    el.setNoAI(false);
                }
            }

        }

        protected double getAttackReachSqr(LivingEntity attackTarget) {
            return 4D + attackTarget.getWidth();
        }
    }

    static class AILookAround extends Goal {

        private final EntityLammergeier parentEntity;

        public AILookAround(EntityLammergeier lam) {
            this.parentEntity = lam;
            this.setMutexFlags(EnumSet.of(Goal.Flag.LOOK));
        }

        @Override
        public boolean shouldExecute() {
            return this.parentEntity.getFlying();
        }

        @Override
        public void tick() {
            if(this.parentEntity.getAttackTarget() == null) {
                if(!this.parentEntity.isTamed()) {
                    this.parentEntity.rotationYaw = -((float) MathHelper.atan2(this.parentEntity.getMotion().getX(),
                    this.parentEntity.getMotion().getZ())) * (180F / (float) Math.PI);
                    this.parentEntity.renderYawOffset = this.parentEntity.rotationYaw;
                } else {
                    LivingEntity entitylivingbase = this.parentEntity.getOwner();
                    if(entitylivingbase != null) {

                        if (entitylivingbase.getDistanceSq(this.parentEntity) < 4096.0D) {
                            double d1 = entitylivingbase.getPosX() - this.parentEntity.getPosX();
                            double d2 = entitylivingbase.getPosZ() - this.parentEntity.getPosZ();
                            this.parentEntity.rotationYaw = -((float) MathHelper.atan2(d1, d2))
                            * (180F / (float) Math.PI);
                            this.parentEntity.renderYawOffset = this.parentEntity.rotationYaw;
                        }
                    }
                }
            } else {
                LivingEntity entitylivingbase = this.parentEntity.getAttackTarget();

                if (entitylivingbase.getDistance(this.parentEntity) < 80.0D && entitylivingbase.isAlive()) {
                    double d1 = entitylivingbase.getPosX() - this.parentEntity.getPosX();
                    double d2 = entitylivingbase.getPosZ() - this.parentEntity.getPosZ();
                    this.parentEntity.rotationYaw = -((float) MathHelper.atan2(d1, d2)) * (180F / (float) Math.PI);
                    this.parentEntity.renderYawOffset = this.parentEntity.rotationYaw;
                } else {
                    if(!this.parentEntity.isTamed()) {
                        this.parentEntity.rotationYaw = -((float) MathHelper.atan2(this.parentEntity.getMotion().getX(),
                        this.parentEntity.getMotion().getZ())) * (180F / (float) Math.PI);
                        this.parentEntity.renderYawOffset = this.parentEntity.rotationYaw;
                    } else {
                        if (this.parentEntity.getOwner() != null) {
                            if (this.parentEntity.getOwner().getDistanceSq(this.parentEntity) < 4096.0D) {
                                double d1 = this.parentEntity.getOwner().getPosX() - this.parentEntity.getPosX();
                                double d2 = this.parentEntity.getOwner().getPosZ() - this.parentEntity.getPosZ();
                                this.parentEntity.rotationYaw = -((float) MathHelper.atan2(d1, d2))
                                * (180F / (float) Math.PI);
                                this.parentEntity.renderYawOffset = this.parentEntity.rotationYaw;
                            }
                        }
                    }
                }
            }
        }
    }

    static class AIRandomFly extends Goal {

        private final EntityLammergeier parentEntity;
        private int timeSinceLastMove = 0;
        private double lastDist = 0;

        public AIRandomFly(EntityLammergeier lam) {
            this.parentEntity = lam;
            this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        @Override
        public boolean shouldExecute() {
            if(this.parentEntity.isTamed() || (this.parentEntity.getAttackTarget() != null && this.parentEntity.getAttackTarget().isAlive())) {
                return false;
            }
            if(!parentEntity.getFlying() && parentEntity.getRNG().nextInt(100) != 1) {
                return false;
            }
            MovementController move = this.parentEntity.getMoveHelper();
            double d0 = move.getX() - this.parentEntity.getPosX();
            double d1 = move.getY() - this.parentEntity.getPosY();
            double d2 = move.getZ() - this.parentEntity.getPosZ();
            double distance = d0 * d0 + d1 * d1 + d2 * d2;
            boolean exec = distance < 1.0D || distance > 3600.0D;
            if(!exec) {
                timeSinceLastMove++;
            }
            if(timeSinceLastMove > 60) {
                timeSinceLastMove = 0;
                return true;
            }
            return exec;
        }

        @Override
        public boolean shouldContinueExecuting() {
            return !this.parentEntity.getNavigator().noPath();
        }

        @Override
        public void tick() {
            if(!parentEntity.getFlying()) {
                parentEntity.setFlying(true);
            }
            double dist = parentEntity.getPosition().distanceSq(parentEntity.navigator.getPath().getCurrentPos(), true);
            if(dist - lastDist < 0.05D) {
                timeSinceLastMove++;
                if(timeSinceLastMove > 60) {
                    parentEntity.navigator.clearPath();
                    parentEntity.navigator.updatePath();
                    parentEntity.getMoveHelper().setMoveTo(parentEntity.getPosX() + parentEntity.getRNG().nextInt(3) - 1, parentEntity.getPosY() + parentEntity.getRNG().nextInt(3) - 1, parentEntity.getPosZ() + parentEntity.getRNG().nextInt(3) - 1, 0.5D);
                }
            } else {
                timeSinceLastMove = 0;
            }
            lastDist = dist;
        }

        @Override
        public void startExecuting() {
            if(!parentEntity.getFlying()) {
                parentEntity.setFlying(true);
            }
            BlockPos rPos = new BlockPos(this.parentEntity.getRNG().nextInt(50) - 25, this.parentEntity.getRNG().nextInt(40) - 20, this.parentEntity.getRNG().nextInt(50) - 25);
            BlockPos pos = this.parentEntity.getPosition();
            rPos = rPos.add(pos);
            this.parentEntity.navigator.tryMoveToXYZ(rPos.getX(), rPos.getY(), rPos.getZ(), 1D);
        }

    }

    public static class AILanding extends Goal {

        private final EntityLammergeier parentEntity;
        private BlockPos target;
        private int timeSinceLastMove = 0;
        private double lastDist = 0;

        public AILanding(EntityLammergeier lam) {
            this.parentEntity = lam;
            this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        @Override
        public boolean shouldExecute() {
            if(this.parentEntity.getAttackTarget() != null && this.parentEntity.getAttackTarget().isAlive()) {
                return false;
            }
            if(!this.parentEntity.isTamed() && this.parentEntity.getFlying() && parentEntity.getRNG().nextInt(200) == 1) {
                return true;
            } else {
                return this.parentEntity.isTamed() && this.parentEntity.readyToSit;
            }
        }

        @Override
        public boolean shouldContinueExecuting() {
            return target != null && this.parentEntity.getPosition().distanceSq(target) > 1;
        }

        @Override
        public void startExecuting() {
            BlockPos rPos = parentEntity.findLandingPosition();
            if(rPos != null) {
                this.target = rPos;
                this.parentEntity.navigator.tryMoveToXYZ(rPos.getX(), rPos.getY(), rPos.getZ(), 1.1D);
            } else if(parentEntity.readyToSit) {
                parentEntity.setSitting(true);
                parentEntity.readyToSit = false;
            }
            this.timeSinceLastMove = 0;
        }

        @Override
        public void tick() {
            if(target != null) {
                this.parentEntity.navigator.tryMoveToXYZ(target.getX(), target.getY(), target.getZ(), 1.1D);
                double dist = parentEntity.getPosition().distanceSq(target);
                World world = parentEntity.world;
                BlockPos top = parentEntity.getTopSolidOrLiquidBlock(world, parentEntity.getPosition());
                if(dist < 3D && top != null && Math.abs(parentEntity.getPosition().getY() - top.getY()) <= 3) {
                    parentEntity.setFlying(false);
                    this.target = null;
                    if(parentEntity.readyToSit) {
                        parentEntity.setSitting(true);
                        parentEntity.readyToSit = false;
                    }
                } else if(dist - lastDist < 0.05D) {
                    timeSinceLastMove++;
                    if(timeSinceLastMove > 60) {
                        BlockPos rPos = parentEntity.findLandingPosition();
                        if(rPos != null) {
                            this.target = rPos;
                            this.parentEntity.navigator.tryMoveToXYZ(rPos.getX(), rPos.getY(), rPos.getZ(), 1.1D);
                        }
                    }
                } else {
                    timeSinceLastMove = 0;
                }
                lastDist = dist;
            }
        }
    }

    protected boolean isValidLandingPosition(World world, BlockPos pos) {
        BlockState state = world.getBlockState(pos.down());
        return !state.isAir(world, pos.down()) && world.isAirBlock(pos) && (state.isSolid() || state.isNormalCube(world, pos.down()) || state.getBlock() instanceof LeavesBlock);
    }

    protected BlockPos findLandingPosition() {
        if(this.isValidLandingPosition(world, this.getPosition())) {
            return this.getPosition();
        }
        Random random = this.getRNG();
        BlockPos top = null;
        for(int i = 0; i < 10 && top == null; i++) {
            float x = this.getPosition().getX() + (readyToSit ? random.nextInt(4) - 2 : random.nextInt(16) - 8F) + 0.5F;
            float z = this.getPosition().getZ() + (readyToSit ? random.nextInt(4) - 2 : random.nextInt(16) - 8F) + 0.5F;
            top = getTopSolidOrLiquidBlock(world, new BlockPos(x, 0, z));
            if(top != null) {
                float y = top.getY();
                BlockPos pos = new BlockPos(x, y, z);
                return pos;
            }
        }
        return null;
    }

    protected BlockPos getTopSolidOrLiquidBlock(World world, BlockPos pos) {
        for(int i = world.getHeight(); i > world.getSeaLevel(); i--) {
            BlockPos pos2 = new BlockPos(pos.getX(), i, pos.getZ());
            if(this.isValidLandingPosition(world, pos2)) {
                return pos2;
            }
        }
        return null;
    }

    @Override
    public EntityTypeContainerBAPTameable<EntityLammergeier> getContainer() {
        return ModEntities.LAMMERGEIER;
    }

    @Override
    protected EntityTameableWithTypes getBaseChild() {
        return null;
    }

    @Override
    protected MovementController getFlightMoveController() {
        return this.flightControl;
    }

}
