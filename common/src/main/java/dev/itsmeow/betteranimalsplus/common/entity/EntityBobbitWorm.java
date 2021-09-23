package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalWithTypes;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.pathfinding.PathType;
import net.minecraft.pathfinding.SwimmerPathNavigator;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.Set;

public class EntityBobbitWorm extends EntityAnimalWithTypes {

    protected static final DataParameter<Integer> ATTACK_STATE = EntityDataManager.defineId(EntityBobbitWorm.class, DataSerializers.INT);
    private float lastAttack = 0;
    private float lastGrab = 0;
    private Vector3d targetPosition;

    public EntityBobbitWorm(EntityType<? extends EntityBobbitWorm> entityType, World worldIn) {
        super(entityType, worldIn);
        this.setPathfindingMalus(PathNodeType.WATER, 10F);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new LookAtGoal(this, LivingEntity.class, 10.0F));
        Set<Class<? extends LivingEntity>> blackList = new HashSet<>();
        blackList.add(SkeletonEntity.class);
        blackList.add(EndermanEntity.class);
        blackList.add(EntityJellyfish.class);
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 0, true, true, e -> e.getBbWidth() < 3 && !(e instanceof IMob) && !(e instanceof EntityBobbitWorm) && !(e.level.getDifficulty() == Difficulty.PEACEFUL && e instanceof PlayerEntity) && !blackList.contains(e.getClass())));
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

    @Nullable
    protected Vector3d getNewTargetPosition() {
        Vector3d pos = RandomPositionGenerator.getPos(this, 20, 5);
        if(pos != null) {
            if(isGoodBurrowingPosition(new BlockPos(pos))) {
                return pos;
            }
        }
        if(level.getBlockState(this.blockPosition().below()).getBlock() == Blocks.WATER) {
            return new Vector3d(this.getX(), this.getY() - 1D, this.getZ());
        }
        return null;
    }

    public boolean isGoodBurrowingPosition(BlockPos pos) {
        Block below = level.getBlockState(pos.below()).getBlock();
        BlockState here = this.level.getBlockState(pos);
        return (below == Blocks.CLAY || below == Blocks.SAND || below == Blocks.GRAVEL || below == Blocks.DIRT) && here.isPathfindable(level, pos, PathType.WATER) && here.getFluidState().is(FluidTags.WATER);
    }

    @Override
    protected PathNavigator createNavigation(World worldIn) {
        return new SwimmerPathNavigator(this, worldIn);
    }

    @Override
    public void travel(Vector3d vec) {
        this.move(MoverType.SELF, this.getDeltaMovement());
    }

    @Override
    public void positionRider(Entity passenger) {
        if(this.hasPassenger(passenger)) {
            passenger.setPos(this.getX(), this.getY() - (this.getBbHeight() / 2), this.getZ());
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
    public boolean canBeRiddenInWater(Entity rider) {
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
            Vector3d pos = this.getNewTargetPosition();
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
    public CreatureAttribute getMobType() {
        return CreatureAttribute.WATER;
    }

    @Override
    public boolean checkSpawnObstruction(IWorldReader worldIn) {
        return worldIn.isUnobstructed(this);
    }

    @Override
    public int getAmbientSoundInterval() {
        return 120;
    }

    @Override
    protected int getExperienceReward(PlayerEntity player) {
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
