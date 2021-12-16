package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalWithTypes;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;

import java.util.HashSet;
import java.util.Set;

public class EntityBobbitWorm extends EntityAnimalWithTypes {

    protected static final EntityDataAccessor<Integer> ATTACK_STATE = SynchedEntityData.defineId(EntityBobbitWorm.class, EntityDataSerializers.INT);
    private float lastAttack = 0;
    private float lastGrab = 0;
    private Vec3 targetPosition;

    public EntityBobbitWorm(EntityType<? extends EntityBobbitWorm> entityType, Level worldIn) {
        super(entityType, worldIn);
        this.setPathfindingMalus(BlockPathTypes.WATER, 10F);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new LookAtPlayerGoal(this, LivingEntity.class, 10.0F));
        Set<Class<? extends LivingEntity>> blackList = new HashSet<>();
        blackList.add(Skeleton.class);
        blackList.add(EnderMan.class);
        blackList.add(EntityJellyfish.class);
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 0, true, true, e -> e.getBbWidth() < 3 && !(e instanceof Enemy) && !(e instanceof EntityBobbitWorm) && !(e.level.getDifficulty() == Difficulty.PEACEFUL && e instanceof Player) && !blackList.contains(e.getClass())));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACK_STATE, 0);
    }

    public int getAttackState() {
        return this.entityData.get(ATTACK_STATE);
    }

    public void setAttackState(int state) {
        this.entityData.set(ATTACK_STATE, state);
    }

    @Override
    public boolean doHurtTarget(Entity entityIn) {
        return entityIn.hurt(DamageSource.mobAttack(this), (float) this.getAttribute(Attributes.ATTACK_DAMAGE).getValue());
    }

    protected Vec3 getNewTargetPosition() {
        Vec3 pos = DefaultRandomPos.getPos(this, 20, 5);
        if(pos != null) {
            if(isGoodBurrowingPosition(new BlockPos(pos))) {
                return pos;
            }
        }
        if(level.getBlockState(this.blockPosition().below()).getBlock() == Blocks.WATER) {
            return new Vec3(this.getX(), this.getY() - 1, this.getZ());
        }
        return null;
    }

    public boolean isGoodBurrowingPosition(BlockPos pos) {
        Block below = level.getBlockState(pos.below()).getBlock();
        BlockState here = this.level.getBlockState(pos);
        return (below == Blocks.CLAY || below == Blocks.SAND || below == Blocks.GRAVEL || below == Blocks.DIRT) && here.isPathfindable(level, pos, PathComputationType.WATER) && here.getFluidState().is(FluidTags.WATER);
    }

    @Override
    protected PathNavigation createNavigation(Level worldIn) {
        return new WaterBoundPathNavigation(this, worldIn);
    }

    @Override
    public void travel(Vec3 vec) {
        this.move(MoverType.SELF, this.getDeltaMovement());
    }

    @Override
    public void positionRider(Entity passenger) {
        if(this.hasPassenger(passenger)) {
            passenger.setPos(this.getX(), this.getY() - (this.getBbHeight() / 2), this.getZ());
        }
    }

    @Override
    public boolean canBeControlledByRider() {
        return false;
    }

    @Override
    public boolean rideableUnderWater() {
        return true;
    }

    @Override
    public void tick() {
        super.tick();
        if(!this.isInWater()) {
            this.setDeltaMovement(this.getDeltaMovement().x() * 0.2F, this.getDeltaMovement().y(), this.getDeltaMovement().z() * 0.2F);
            if(!this.isNoGravity()) {
                this.setDeltaMovement(this.getDeltaMovement().x(), this.getDeltaMovement().y() - 0.08D, this.getDeltaMovement().z());
            }
            this.setDeltaMovement(this.getDeltaMovement().x(), this.getDeltaMovement().y() * 0.9800000190734863D, this.getDeltaMovement().z());
        } else if(!level.isClientSide) {
            if(this.targetPosition != null) {
                this.setDeltaMovement((this.targetPosition.x - this.getX()) * 0.05F, (this.targetPosition.y - this.getY()) * 0.05F, (this.targetPosition.z - this.getZ()) * 0.05F);
            }
            if(targetPosition != null && Math.sqrt(this.blockPosition().distSqr(this.targetPosition.x, this.targetPosition.y, this.targetPosition.z, false)) < 1) {
                this.setDeltaMovement(this.getDeltaMovement().x() * 0.2F, this.getDeltaMovement().y(), this.getDeltaMovement().z() * 0.2F);
            }
        }
        if(level.isClientSide) { // shut up client stop MOVING you stupid idiot
            this.setDeltaMovement(this.getDeltaMovement().x() * 0.2F, this.getDeltaMovement().y() * 0.2F, this.getDeltaMovement().z() * 0.2F);
        }
        boolean goodPos = this.isGoodBurrowingPosition(this.blockPosition());
        if(this.targetPosition == null && !goodPos) {
            Vec3 pos = this.getNewTargetPosition();
            if(pos != null) {
                this.targetPosition = pos;
            }
        }
        if(targetPosition != null && Math.sqrt(this.blockPosition().distSqr(this.targetPosition.x, this.targetPosition.y, this.targetPosition.z, false)) < 1 && !goodPos) {
            this.targetPosition = null;
        }
        if(this.getAttackState() > 0) {
            this.setAttackState(this.getAttackState() - 1);
        }
        if(!this.level.isClientSide && this.getTarget() != null && this.getTarget().isAlive() && this.isAlive()) {
            if(this.getPassengers().contains(this.getTarget())) {
                float time = 30F;
                if(this.lastAttack + (time - 20) < this.tickCount) {
                    this.setAttackState(20);
                }
                if(this.lastAttack + time < this.tickCount) {
                    this.doHurtTarget(this.getTarget());
                    this.lastAttack = this.tickCount;
                }
            } else if(lastGrab + 60F < this.tickCount && this.distanceToSqr(this.getTarget()) < 5) {
                if(!this.getTarget().isInvulnerable() && this.getTarget().getBbWidth() < 2.5 && this.getTarget().getBbHeight() < 2.5) {
                    this.getTarget().startRiding(this, false);
                } else if(!this.getTarget().isInvulnerable()) {
                    this.doHurtTarget(this.getTarget());
                }
                lastGrab = this.tickCount;
            }
        }
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    protected void pushEntities() {
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public MobType getMobType() {
        return MobType.WATER;
    }

    @Override
    public boolean checkSpawnObstruction(LevelReader worldIn) {
        return worldIn.isUnobstructed(this);
    }

    @Override
    public int getAmbientSoundInterval() {
        return 120;
    }

    @Override
    protected int getExperienceReward(Player player) {
        return 1 + this.level.random.nextInt(3);
    }

    protected void updateAir(int air) {
        if(this.isAlive() && !this.isInWaterOrBubble()) {
            this.setAirSupply(air - 1);
            if(this.getAirSupply() == -20) {
                this.setAirSupply(0);
                this.hurt(DamageSource.DROWN, 2.0F);
            }
        } else {
            this.setAirSupply(300);
        }

    }

    @Override
    public void baseTick() {
        int i = this.getAirSupply();
        super.baseTick();
        this.updateAir(i);
    }

    @Override
    public boolean isPushedByFluid() {
        return false;
    }

    @Override
    public EntityTypeContainer<EntityBobbitWorm> getContainer() {
        return ModEntities.BOBBIT_WORM;
    }

    @Override
    protected EntityBobbitWorm getBaseChild() {
        return null;
    }

}
