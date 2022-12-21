package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.betteranimalsplus.common.entity.ai.EntityAIFollowOwnerFlying;
import dev.itsmeow.betteranimalsplus.common.entity.ai.LammerMoveHelper;
import dev.itsmeow.betteranimalsplus.common.entity.util.EntityTypeContainerBAPTameable;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityTameableBetterAnimalsPlus;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityTameableFlyingWithTypes;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityTameableWithTypes;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.util.ModPlatformEvents;
import dev.itsmeow.imdlib.entity.interfaces.IVariantTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.EnumSet;
import java.util.Random;

public class EntityLammergeier extends EntityTameableFlyingWithTypes implements IVariantTypes<EntityTameableBetterAnimalsPlus> {

    protected static final EntityDataAccessor<Float> DATA_HEALTH_ID = SynchedEntityData.defineId(EntityLammergeier.class, EntityDataSerializers.FLOAT);

    protected boolean readyToSit = false;
    public float lastRotX = 0;
    public float rotX = 0;
    private int lastTick = 0;
    public double lastMotionY = 0;
    private final MoveControl flightControl;

    public EntityLammergeier(EntityType<? extends EntityLammergeier> entityType, Level worldIn) {
        super(entityType, worldIn);
        this.flightControl = new LammerMoveHelper(this);
        this.moveControl = flightControl;
    }

    @Override
    public int getMaxSpawnClusterSize() {
        return 2;
    }

    @Override
    public boolean isPushable() {
        return super.isPushable() && this.getPassengers().size() != 0;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(2, new AIMeleeAttack(this));
        this.goalSelector.addGoal(3, new EntityAIFollowOwnerFlying(this, 2D, 8.0F, 50.0F) {
            @Override
            public void start() {
                if(!EntityLammergeier.this.getFlying()) {
                    EntityLammergeier.this.setFlying(true);
                }
                super.start();
            }

            @Override
            public void tick() {
                if(!EntityLammergeier.this.getFlying()) {
                    EntityLammergeier.this.setFlying(true);
                }
                super.tick();
            }
        });
        this.goalSelector.addGoal(4, new AILanding(this));
        this.goalSelector.addGoal(5, new AIRandomFly(this));
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 0.1F) {
            @Override
            public boolean canUse() {
                return !EntityLammergeier.this.isTame() && !EntityLammergeier.this.getFlying() && super.canContinueToUse();
            }

            @Override
            public boolean canContinueToUse() {
                return !EntityLammergeier.this.isTame() && !EntityLammergeier.this.getFlying() && super.canContinueToUse();
            }
        });
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this) {
            @Override
            public boolean canUse() {
                return !EntityLammergeier.this.isInSittingPose() && !EntityLammergeier.this.isOrderedToSit() && super.canUse();
            }
        });
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this) {
            @Override
            public boolean canUse() {
                return !EntityLammergeier.this.isInSittingPose() && !EntityLammergeier.this.isOrderedToSit() && super.canUse();
            }
        });
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<AbstractSkeleton>(this, AbstractSkeleton.class, false) {
            @Override
            public boolean canUse() {
                return !EntityLammergeier.this.isTame() && super.canUse();
            }
        });
    }

    @Override
    public void setTarget(LivingEntity entitylivingbaseIn) {
        if(!this.isInSittingPose() && !this.isOrderedToSit()) {
            super.setTarget(entitylivingbaseIn);
        }
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(EntityLammergeier.DATA_HEALTH_ID, this.getHealth());
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.isTame() && this.entityData.get(EntityLammergeier.DATA_HEALTH_ID) < 6.0F ? SoundEvents.PARROT_HURT : null;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.PARROT_DEATH;
    }

    @Override
    public float getVoicePitch() {
        return 0.4F; // Lower pitch
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if(this.isTame() && !this.isInvulnerableTo(source)) {
            this.setInSittingPose(false);
            this.setOrderedToSit(false);
        }
        if(this.getTarget() != null && this.getTarget() == source.getEntity() && this.hasPassenger(this.getTarget())) {
            return super.hurt(source, amount / 2F);
        }
        return super.hurt(source, amount);
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        if(this.isTame()) {
            if(!itemstack.isEmpty()) {
                if(itemstack.getItem().isEdible()) {
                    FoodProperties food = itemstack.getItem().getFoodProperties();

                    if(this.entityData.get(EntityLammergeier.DATA_HEALTH_ID) < 20.0F) {
                        if(!player.isCreative()) {
                            itemstack.shrink(1);
                        }
                        for(int i = 0; i < 10; i++) {
                            this.level.addParticle(ParticleTypes.HAPPY_VILLAGER, getX() + (this.getRandom().nextFloat() - 0.5F), getY() + this.getRandom().nextFloat(), getZ() + (this.getRandom().nextFloat() - 0.5F), 0, 0, 0);
                        }
                        this.heal((float) food.getNutrition());
                        return InteractionResult.SUCCESS;
                    }
                }
            }
            if(this.isOwnedBy(player) && !this.isVehicle() && !this.level.isClientSide && this.tickCount - this.lastTick > 13 && !itemstack.isEdible()) {
                if(!this.isInSittingPose() && !this.isOrderedToSit()) {
                    this.setTarget(null);
                    this.navigation.stop();
                    this.readyToSit = true;
                } else {
                    this.readyToSit = false;
                    this.setInSittingPose(false);
                    this.setOrderedToSit(false);
                    this.navigation.stop();
                }
                this.lastTick = this.tickCount;
            }
        } else if(this.isTamingItem(itemstack.getItem()) && !this.isTame()) {
            if(!player.isCreative()) {
                itemstack.shrink(1);
            }

            if(!this.level.isClientSide) {
                if(!ModPlatformEvents.tame(this, player)) {
                    this.tame(player);
                    // this.setOwnerId(player.getUniqueID());
                    this.navigation.stop();
                    // ((LammerMoveHelper) this.getMoveHelper()).action = Action.WAIT;
                    this.setTarget(null);
                    this.setInSittingPose(true);
                    this.setOrderedToSit(true);
                    this.setHealth(20.0F);
                    this.level.broadcastEntityEvent(this, (byte) 7);
                } else {
                    this.level.broadcastEntityEvent(this, (byte) 6);
                }
            }

            return InteractionResult.SUCCESS;
        }

        return super.mobInteract(player, hand);
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return this.isTamingItem(stack.getItem());
    }

    @Override
    public boolean wantsToAttack(LivingEntity target, LivingEntity owner) {
        if(!(target instanceof Creeper) && !(target instanceof Ghast)) {
            if(target instanceof EntityLammergeier) {
                EntityLammergeier entitylam = (EntityLammergeier) target;

                if(entitylam.isTame() && entitylam.getOwner() == owner) {
                    return false;
                }
            }

            if(target instanceof Player && owner instanceof Player
            && !((Player) owner).canHarmPlayer((Player) target)) {
                return false;
            } else {
                return !(target instanceof AbstractHorse) || !((AbstractHorse) target).isTamed();
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean doHurtTarget(Entity entityIn) {
        return entityIn.hurt(DamageSource.mobAttack(this), (float) this.getAttribute(Attributes.ATTACK_DAMAGE).getValue());
    }

    @Override
    public void tick() {
        if((Math.abs(this.getDeltaMovement().y()) > 0 && (Math.abs(this.getDeltaMovement().x()) > 0.05 || Math.abs(this.getDeltaMovement().z()) > 0.05)) || Math.abs(this.getDeltaMovement().y()) > 0.25) {
            float x = -((float) Math.atan2(this.getDeltaMovement().y(), Math.sqrt(Math.pow(this.getDeltaMovement().x(), 2) + Math.pow(this.getDeltaMovement().z(), 2))) / 1.5F);
            if(x < 0) {
                x /= 3;
            }
            rotX = x;
        } else {
            rotX = 0;
        }
        super.tick();
        this.lastMotionY = this.getDeltaMovement().y();
        lastRotX = rotX;
    }

    @Override
    protected void customServerAiStep() {
        super.customServerAiStep();
        this.entityData.set(EntityLammergeier.DATA_HEALTH_ID, this.getHealth());
        this.setNoGravity(this.getFlying());
    }

    @Override
    public void setTame(boolean tamed) {
        super.setTame(tamed);
        if(tamed) {
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20.0D);
        } else {
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(6.0D);
        }
    }

    @Override
    public void positionRider(Entity passenger) {
        passenger.setPos(this.getX() + this.getDeltaMovement().x(), this.getY() - passenger.getBbHeight() - 0.05 + this.getDeltaMovement().y(),
        this.getZ() + this.getDeltaMovement().z());
        this.setDeltaMovement(this.getDeltaMovement().x(), this.getDeltaMovement().y() + Math.abs(passenger.getDeltaMovement().y()), this.getDeltaMovement().z());
        if(passenger instanceof LivingEntity && (this.getTarget() == null || this.getTarget() != passenger)) {
            this.setTarget((LivingEntity) passenger);
        }
        if(this.level.isClientSide) {
            this.onPassengerTurned(passenger);
        }
    }

    static class AIMeleeAttack extends Goal {
        protected Level world;
        protected EntityLammergeier attacker;
        protected int attackTick;
        protected double liftY = 0;

        public AIMeleeAttack(EntityLammergeier lam) {
            this.attacker = lam;
            this.world = lam.getCommandSenderWorld();
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.TARGET));
        }

        @Override
        public boolean canUse() {
            LivingEntity entitylivingbase = this.attacker.getTarget();

            if(entitylivingbase == null) {
                return false;
            } else if(!entitylivingbase.isAlive()) {
                return false;
            }

            return !(entitylivingbase instanceof Player) || !entitylivingbase.isInvulnerable();
        }

        @Override
        public boolean canContinueToUse() {
            return canUse();
        }

        @Override
        public void start() {

        }

        @Override
        public void stop() {
            LivingEntity entitylivingbase = this.attacker.getTarget();

            if(entitylivingbase instanceof Player && (entitylivingbase.isSpectator() || ((Player) entitylivingbase).isCreative())) {
                this.attacker.setTarget(null);
            }
        }

        @Override
        public void tick() {
            if(!attacker.getFlying()) {
                attacker.setFlying(true);
            }
            LivingEntity entitylivingbase = this.attacker.getTarget();
            if(entitylivingbase == null) {
                return;
            }

            double targetX = entitylivingbase.getX();
            double targetZ = entitylivingbase.getZ();

            if(entitylivingbase.distanceToSqr(this.attacker) < 4096.0D) // If the distance is less than 4096 square blocks rotate towards them
            {
                double d1 = targetX - this.attacker.getX();
                double d2 = targetZ - this.attacker.getZ();
                this.attacker.setYRot(-((float) Mth.atan2(d1, d2)) * (180F / (float) Math.PI));
                this.attacker.yBodyRot = this.attacker.getYRot();
            }

            double distanceToTarget = this.attacker.distanceToSqr(entitylivingbase.getX(), entitylivingbase.getY(),
            entitylivingbase.getZ());

            // Reduce time till attack
            this.attackTick--;

            double reachToTarget = this.getAttackReachSqr(entitylivingbase);

            // If the entity can reach its target and it's time to attack, reset
            // the timer and attack if the entity is not grabbed
            if(distanceToTarget <= reachToTarget && this.attackTick <= 0) {
                this.attackTick = 20;
                if(!entitylivingbase.hasPassenger(attacker)) {
                    this.attacker.doHurtTarget(entitylivingbase);
                }
            }

            // If the entity is not grabbing a target, set it to move to its target
            if(attacker.getPassengers().size() == 0) {
                this.attacker.navigation.moveTo(this.attacker.navigation.createPath(entitylivingbase.blockPosition(), 0), 0.4D);
            } else { // If the entity is grabbing a target, set it to move upwards
                this.attacker.navigation.moveTo(this.attacker.navigation.createPath(new BlockPos(targetX, this.liftY + 15, targetZ), 0), 0.4D);
            }

            // If the entity is in range and entity is not grabbing a target and
            // the target's height is less than 3 blocks
            if(distanceToTarget <= reachToTarget && attacker.getPassengers().size() == 0 && entitylivingbase.getBbHeight() <= 3 && this.attackTick == 15) {
                // Move the entity upwards to avoid being stuck in the ground
                this.attacker.moveTo(this.attacker.getX(), this.attacker.getY() + entitylivingbase.getBbHeight() + 2,
                this.attacker.getZ(), this.attacker.getYRot(), this.attacker.getXRot());
                // Grab the target
                entitylivingbase.startRiding(this.attacker, true);
                // Set liftY so entity can continue moving up from the spot
                this.liftY = entitylivingbase.getY();
                // Remove targets of the entity (to avoid something stupid like
                // a skeleton shooting while being eaten by a bird)
                if(entitylivingbase instanceof Mob) {
                    Mob el = (Mob) entitylivingbase;
                    el.setTarget(null);
                    el.setLastHurtByMob(null);
                    el.getNavigation().stop();
                    el.setNoAi(true);
                }
                // Move upwards
                this.attacker.navigation.moveTo(this.attacker.navigation.createPath(new BlockPos(targetX, this.liftY + 15, targetZ), 0), 0.4D);
            }

            // If the entity is grabbing a target and the block above is solid
            // (stuck)
            if(attacker.getPassengers().size() == 0 && this.attacker.getCommandSenderWorld().getBlockState(this.attacker.blockPosition().above()).isRedstoneConductor(world, this.attacker.blockPosition().above())) {
                // Release target
                entitylivingbase.stopRiding();
                if(entitylivingbase instanceof Mob) {
                    Mob el = (Mob) entitylivingbase;
                    el.setNoAi(false);
                }
                // Remove target
                this.attacker.setTarget(null);
                // Create a random target position
                BlockPos rPos = new BlockPos(this.attacker.getRandom().nextInt(50) - 25, this.attacker.getRandom().nextInt(40) - 20, this.attacker.getRandom().nextInt(50) - 25);
                BlockPos pos = this.attacker.blockPosition();
                rPos = rPos.offset(pos);
                // Move to random target position
                this.attacker.navigation.moveTo(this.attacker.navigation.createPath(rPos, 0), 0.4D);
            }

            // If we've about reached the target lifting point and have a target
            // grabbed, or have completed movement, drop the entity
            if (Math.abs(this.attacker.getY() - (this.liftY + 15)) <= 3 && attacker.getPassengers().size() > 0) {
                entitylivingbase.stopRiding();
                if(entitylivingbase instanceof Mob) {
                    Mob el = (Mob) entitylivingbase;
                    el.setNoAi(false);
                }
            }

        }

        protected double getAttackReachSqr(LivingEntity attackTarget) {
            return 4D + attackTarget.getBbWidth();
        }
    }

    static class AIRandomFly extends Goal {

        private final EntityLammergeier parentEntity;
        private int timeSinceLastMove = 0;
        private double lastDist = 0;

        public AIRandomFly(EntityLammergeier lam) {
            this.parentEntity = lam;
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            if(this.parentEntity.isTame() || (this.parentEntity.getTarget() != null && this.parentEntity.getTarget().isAlive())) {
                return false;
            }
            if(!parentEntity.getFlying() && parentEntity.getRandom().nextInt(100) != 1) {
                return false;
            }
            MoveControl move = this.parentEntity.getMoveControl();
            double d0 = move.getWantedX() - this.parentEntity.getX();
            double d1 = move.getWantedY() - this.parentEntity.getY();
            double d2 = move.getWantedZ() - this.parentEntity.getZ();
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
        public boolean canContinueToUse() {
            return !this.parentEntity.getNavigation().isDone();
        }

        @Override
        public void tick() {
            if(!parentEntity.getFlying()) {
                parentEntity.setFlying(true);
            }
            boolean idle = true;
            if(parentEntity.navigation.getPath() != null && parentEntity.navigation.getPath().getNextNodeIndex() < parentEntity.navigation.getPath().getNodeCount()) {
                double dist = parentEntity.blockPosition().distSqr(parentEntity.navigation.getPath().getNextNodePos());
                idle = dist - lastDist < 0.05D;
                lastDist = dist;
            }
            if(idle) {
                timeSinceLastMove++;
                if(timeSinceLastMove > 60) {
                    parentEntity.navigation.stop();
                    parentEntity.navigation.recomputePath();
                    parentEntity.getMoveControl().setWantedPosition(parentEntity.getX() + parentEntity.getRandom().nextInt(3) - 1, parentEntity.getY() + parentEntity.getRandom().nextInt(3) - 1, parentEntity.getZ() + parentEntity.getRandom().nextInt(3) - 1, 0.5D);
                }
            } else {
                timeSinceLastMove = 0;
            }
        }

        @Override
        public void start() {
            if(!parentEntity.getFlying()) {
                parentEntity.setFlying(true);
            }
            BlockPos rPos = new BlockPos(this.parentEntity.getRandom().nextInt(50) - 25, this.parentEntity.getRandom().nextInt(40) - 20, this.parentEntity.getRandom().nextInt(50) - 25);
            BlockPos pos = this.parentEntity.blockPosition();
            rPos = rPos.offset(pos);
            this.parentEntity.navigation.moveTo(rPos.getX(), rPos.getY(), rPos.getZ(), 1D);
        }

    }

    public static class AILanding extends Goal {

        private final EntityLammergeier parentEntity;
        private BlockPos target;
        private int timeSinceLastMove = 0;
        private double lastDist = 0;

        public AILanding(EntityLammergeier lam) {
            this.parentEntity = lam;
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            if(this.parentEntity.getTarget() != null && this.parentEntity.getTarget().isAlive()) {
                return false;
            }
            if(!this.parentEntity.isTame() && this.parentEntity.getFlying() && parentEntity.getRandom().nextInt(200) == 1) {
                return true;
            } else {
                return this.parentEntity.isTame() && this.parentEntity.readyToSit;
            }
        }

        @Override
        public boolean canContinueToUse() {
            return target != null && this.parentEntity.blockPosition().distSqr(target) > 1;
        }

        @Override
        public void start() {
            BlockPos rPos = parentEntity.findLandingPosition();
            if(rPos != null) {
                this.target = rPos;
                this.parentEntity.navigation.moveTo(rPos.getX(), rPos.getY(), rPos.getZ(), 1.1D);
            } else if(parentEntity.readyToSit) {
                parentEntity.setInSittingPose(true);
                parentEntity.setOrderedToSit(true);
                parentEntity.readyToSit = false;
            }
            this.timeSinceLastMove = 0;
        }

        @Override
        public void tick() {
            if(target != null) {
                this.parentEntity.navigation.moveTo(target.getX(), target.getY(), target.getZ(), 1.1D);
                double dist = parentEntity.blockPosition().distSqr(target);
                Level world = parentEntity.level;
                BlockPos top = parentEntity.getTopSolidOrLiquidBlock(world, parentEntity.blockPosition());
                if(dist < 3D && top != null && Math.abs(parentEntity.blockPosition().getY() - top.getY()) <= 3) {
                    parentEntity.setFlying(false);
                    this.target = null;
                    if(parentEntity.readyToSit) {
                        parentEntity.setInSittingPose(true);
                        parentEntity.setOrderedToSit(true);
                        parentEntity.readyToSit = false;
                        parentEntity.getNavigation().stop();
                        parentEntity.setDeltaMovement(0, 0, 0);
                    }
                } else if(dist - lastDist < 0.05D) {
                    timeSinceLastMove++;
                    if(timeSinceLastMove > 60) {
                        BlockPos rPos = parentEntity.findLandingPosition();
                        if(rPos != null) {
                            this.target = rPos;
                            this.parentEntity.navigation.moveTo(rPos.getX(), rPos.getY(), rPos.getZ(), 1.1D);
                        }
                    }
                } else {
                    timeSinceLastMove = 0;
                }
                lastDist = dist;
            }
        }
    }

    protected boolean isValidLandingPosition(Level world, BlockPos pos) {
        BlockState state = world.getBlockState(pos.below());
        return !world.isEmptyBlock(pos.below()) && world.isEmptyBlock(pos) && (state.canOcclude() || state.isRedstoneConductor(world, pos.below()) || state.getBlock() instanceof LeavesBlock);
    }

    protected BlockPos findLandingPosition() {
        if(this.isValidLandingPosition(level, this.blockPosition())) {
            return this.blockPosition();
        }
        Random random = this.getRandom();
        BlockPos top;
        for(int i = 0; i < 10; i++) {
            float x = this.blockPosition().getX() + (readyToSit ? random.nextInt(4) - 2 : random.nextInt(16) - 8F) + 0.5F;
            float z = this.blockPosition().getZ() + (readyToSit ? random.nextInt(4) - 2 : random.nextInt(16) - 8F) + 0.5F;
            top = getTopSolidOrLiquidBlock(level, new BlockPos(x, 0, z));
            if(top != null) {
                float y = top.getY();
                return new BlockPos(x, y, z);
            }
        }
        return null;
    }

    protected BlockPos getTopSolidOrLiquidBlock(Level world, BlockPos pos) {
        for(int i = world.getMaxBuildHeight(); i > world.getSeaLevel(); i--) {
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
    protected MoveControl getFlightMoveController() {
        return this.flightControl;
    }

}
