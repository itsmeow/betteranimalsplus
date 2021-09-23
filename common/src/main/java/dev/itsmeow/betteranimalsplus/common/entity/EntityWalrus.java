package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.interfaces.IContainerEntity;
import dev.itsmeow.betteranimalsplus.common.entity.ai.HybridPathNavigator;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModItems;
import dev.itsmeow.betteranimalsplus.init.ModLootTables;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.*;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Random;

public class EntityWalrus extends AnimalEntity implements IContainerEntity<EntityWalrus> {

    private static final DataParameter<BlockPos> HOME_POS = EntityDataManager.defineId(EntityWalrus.class, DataSerializers.BLOCK_POS);
    private static final DataParameter<BlockPos> TRAVEL_POS = EntityDataManager.defineId(EntityWalrus.class, DataSerializers.BLOCK_POS);
    private static final DataParameter<Boolean> GOING_HOME = EntityDataManager.defineId(EntityWalrus.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> TRAVELLING = EntityDataManager.defineId(EntityWalrus.class, DataSerializers.BOOLEAN);
    public boolean hasGivenDisc = false;

    public EntityWalrus(EntityType<? extends EntityWalrus> entityType, World worldIn) {
        super(entityType, worldIn);
        this.setPathfindingMalus(PathNodeType.WATER, 0.0F);
        this.moveControl = new EntityWalrus.MoveHelperController(this);
        this.maxUpStep = 1.0F;
    }

    @Override
    public ActionResultType mobInteract(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if(!hasGivenDisc && stack.getItem() == ModItems.FRIED_EGG.get()) {
            this.usePlayerItem(player, stack);
            this.level.broadcastEntityEvent(this, (byte) 90);
            this.hasGivenDisc = true;
            this.spawnAtLocation(new ItemStack(ModItems.RECORD_WALRUS.get()));
            return ActionResultType.SUCCESS;
        }
        return super.mobInteract(player, hand);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void handleEntityEvent(byte id) {
        if(id == 90) {
            for(int i = 0; i < 7; ++i) {
                double x = this.random.nextGaussian() * 0.02D;
                double y = this.random.nextGaussian() * 0.02D;
                double z = this.random.nextGaussian() * 0.02D;
                this.level.addParticle(ParticleTypes.NOTE, this.getX() + (double) (this.random.nextFloat() * this.getBbWidth() * 2.0F) - (double) this.getBbWidth(), this.getY() + 0.5D + (double) (this.random.nextFloat() * this.getBbHeight()), this.getZ() + (double) (this.random.nextFloat() * this.getBbWidth() * 2.0F) - (double) this.getBbWidth(), x, y, z);
            }
        } else {
            super.handleEntityEvent(id);
        }
    }

    @Override
    public boolean doHurtTarget(Entity entityIn) {
        // 1/3 chance to pierce armor
        boolean flag = entityIn.hurt(this.getRandom().nextInt(3) == 0 ? DamageSource.mobAttack(this).bypassArmor() : DamageSource.mobAttack(this), (float) this.getAttribute(Attributes.ATTACK_DAMAGE).getValue());
        if(flag) {
            Vector3d pos = this.position();
            Vector3d targetPos = entityIn.position();
            ((LivingEntity) entityIn).knockback(0.5F, pos.x - targetPos.x, pos.z - targetPos.z);
        }
        return flag;
    }

    public void setHome(BlockPos position) {
        this.entityData.set(HOME_POS, position);
    }

    private BlockPos getHome() {
        return this.entityData.get(HOME_POS);
    }

    private void setTravelPos(BlockPos position) {
        this.entityData.set(TRAVEL_POS, position);
    }

    private BlockPos getTravelPos() {
        return this.entityData.get(TRAVEL_POS);
    }

    private boolean isGoingHome() {
        return this.entityData.get(GOING_HOME);
    }

    private void setGoingHome(boolean isGoingHome) {
        this.entityData.set(GOING_HOME, isGoingHome);
    }

    private boolean isTravelling() {
        return this.entityData.get(TRAVELLING);
    }

    private void setTravelling(boolean isTravelling) {
        this.entityData.set(TRAVELLING, isTravelling);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(HOME_POS, BlockPos.ZERO);
        this.entityData.define(TRAVEL_POS, BlockPos.ZERO);
        this.entityData.define(GOING_HOME, false);
        this.entityData.define(TRAVELLING, false);
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("HomePosX", this.getHome().getX());
        compound.putInt("HomePosY", this.getHome().getY());
        compound.putInt("HomePosZ", this.getHome().getZ());
        compound.putInt("TravelPosX", this.getTravelPos().getX());
        compound.putInt("TravelPosY", this.getTravelPos().getY());
        compound.putInt("TravelPosZ", this.getTravelPos().getZ());
        compound.putBoolean("DiscGiven", hasGivenDisc);
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT compound) {
        int i = compound.getInt("HomePosX");
        int j = compound.getInt("HomePosY");
        int k = compound.getInt("HomePosZ");
        this.setHome(new BlockPos(i, j, k));
        super.readAdditionalSaveData(compound);
        int l = compound.getInt("TravelPosX");
        int i1 = compound.getInt("TravelPosY");
        int j1 = compound.getInt("TravelPosZ");
        this.setTravelPos(new BlockPos(l, i1, j1));
        this.hasGivenDisc = compound.getBoolean("DiscGiven");
    }

    @Override
    @Nullable
    public ILivingEntityData finalizeSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        this.setHome(this.blockPosition());
        this.setTravelPos(BlockPos.ZERO);
        return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }

    @SuppressWarnings("deprecation")
    public static boolean canSpawn(EntityType<EntityWalrus> walrus, IWorld world, SpawnReason reason, BlockPos pos, Random rand) {
        return pos.getY() < world.getSeaLevel() + 4 && world.getRawBrightness(pos, 0) > 8;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new BreatheAirGoal(this));
        this.goalSelector.addGoal(1, new EntityWalrus.GoToWaterGoal(this, 1.0D));
        this.goalSelector.addGoal(2, new EntityWalrus.GoHomeGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new EntityWalrus.TravelGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity attackTarget) {
                return this.mob.getBbWidth() * this.mob.getBbWidth() + attackTarget.getBbWidth();
            }
        });
        this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(5, new EntityWalrus.WanderGoal(this, 1.0D, 100));
        this.targetSelector.addGoal(0, new HurtByTargetGoal(this) {
            @Override
            public boolean canUse() {
                return EntityWalrus.this.level.getDifficulty() != Difficulty.PEACEFUL && super.canUse();
            }
        });
    }

    @Override
    public boolean isPushedByFluid() {
        return false;
    }

    @Override
    public boolean canBreatheUnderwater() {
        return false;
    }

    @Override
    public int getMaxAirSupply() {
        return 6000; // 5m
    }

    @Override
    protected int increaseAirSupply(int currentAir) {
        return this.getMaxAirSupply();
    }

    @Override
    public CreatureAttribute getMobType() {
        return CreatureAttribute.WATER;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.COW_STEP, 0.15F, 0.6F);
    }

    @Override
    protected float nextStep() {
        return this.moveDist + 0.15F;
    }

    @Override
    protected PathNavigator createNavigation(World worldIn) {
        return new HybridPathNavigator<>(this, worldIn, EntityWalrus::isTravelling);
    }

    @Override
    @SuppressWarnings("deprecation")
    public float getWalkTargetValue(BlockPos pos, IWorldReader worldIn) {
        if(!this.isGoingHome() && worldIn.getFluidState(pos).is(FluidTags.WATER)) {
            return 10.0F;
        } else {
            return worldIn.getBlockState(pos.below()).getBlock().is(BlockTags.ICE) ? 10.0F : worldIn.getBrightness(pos) - 0.5F;
        }
    }

    @Override
    public void travel(Vector3d p_213352_1_) {
        if(this.isEffectiveAi() && this.isInWater()) {
            this.moveRelative(0.1F, p_213352_1_);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
            if(this.getTarget() == null && (!this.isGoingHome() || !this.getHome().closerThan(this.position(), 20.0D))) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
            }
        } else {
            super.travel(p_213352_1_);
        }

    }

    @Override
    public boolean canBeLeashed(PlayerEntity player) {
        return false;
    }

    @Override
    protected ResourceLocation getDefaultLootTable() {
        return ModLootTables.WALRUS;
    }

    public static class GoHomeGoal extends Goal {
        private final EntityWalrus walrus;
        private final double speed;
        private boolean noPosition;
        private int ticksRan;

        public GoHomeGoal(EntityWalrus walrus, double speedIn) {
            this.walrus = walrus;
            this.speed = speedIn;
        }

        @Override
        public boolean canUse() {
            if(this.walrus.isBaby()) {
                return false;
            } else if(this.walrus.getRandom().nextInt(700) != 0) {
                return false;
            } else {
                return !this.walrus.getHome().closerThan(this.walrus.position(), 64.0D);
            }
        }

        @Override
        public void start() {
            this.walrus.setGoingHome(true);
            this.noPosition = false;
            this.ticksRan = 0;
        }

        @Override
        public void stop() {
            this.walrus.setGoingHome(false);
        }

        @Override
        public boolean canContinueToUse() {
            return !this.walrus.getHome().closerThan(this.walrus.position(), 7.0D) && !this.noPosition && this.ticksRan <= 600;
        }

        @Override
        public void tick() {
            BlockPos blockpos = this.walrus.getHome();
            boolean nearHome = blockpos.closerThan(this.walrus.position(), 16.0D);
            if(nearHome) {
                ++this.ticksRan;
            }

            if(this.walrus.getNavigation().isDone()) {
                Vector3d vec3d = RandomPositionGenerator.getPosTowards(this.walrus, 16, 3, new Vector3d(blockpos.getX(), blockpos.getY(), blockpos.getZ()), (float) Math.PI / 10F);
                if(vec3d == null) {
                    vec3d = RandomPositionGenerator.getPosTowards(this.walrus, 8, 7, new Vector3d(blockpos.getX(), blockpos.getY(), blockpos.getZ()));
                }

                if(vec3d != null && !nearHome && this.walrus.level.getBlockState(new BlockPos(vec3d)).getBlock() != Blocks.WATER) {
                    vec3d = RandomPositionGenerator.getPosTowards(this.walrus, 16, 5, new Vector3d(blockpos.getX(), blockpos.getY(), blockpos.getZ()));
                }

                if(vec3d == null) {
                    this.noPosition = true;
                    return;
                }

                this.walrus.getNavigation().moveTo(vec3d.x, vec3d.y, vec3d.z, this.speed);
            }

        }
    }

    public static class GoToWaterGoal extends MoveToBlockGoal {
        private final EntityWalrus walrus;

        public GoToWaterGoal(EntityWalrus walrus, double speed) {
            super(walrus, speed, 24);
            this.walrus = walrus;
            this.verticalSearchStart = -1;
        }

        @Override
        public boolean canContinueToUse() {
            return !this.walrus.isInWater() && this.tryTicks <= 1200 && this.isValidTarget(this.walrus.level, this.blockPos);
        }

        @Override
        public boolean canUse() {
            if(this.walrus.isBaby() && !this.walrus.isInWater()) {
                return super.canUse();
            } else {
                return !this.walrus.isGoingHome() && !this.walrus.isInWater() && super.canUse();
            }
        }

        @Override
        public boolean shouldRecalculatePath() {
            return this.tryTicks % 160 == 0;
        }

        @Override
        protected boolean isValidTarget(IWorldReader worldIn, BlockPos pos) {
            Block block = worldIn.getBlockState(pos).getBlock();
            return block == Blocks.WATER;
        }
    }

    static class MoveHelperController extends MovementController {
        private final EntityWalrus walrus;

        MoveHelperController(EntityWalrus walrus) {
            super(walrus);
            this.walrus = walrus;
        }

        private void updateSpeed() {
            if(this.walrus.isInWater()) {
                this.walrus.setDeltaMovement(this.walrus.getDeltaMovement().add(0.0D, 0.005D, 0.0D));
                if(!this.walrus.getHome().closerThan(this.walrus.position(), 16.0D)) {
                    this.walrus.setSpeed(Math.max(this.walrus.getSpeed() / 2.0F, 0.2F));
                }
            } else if(this.walrus.onGround) {
                this.walrus.setSpeed(Math.max(this.walrus.getSpeed() / 2.0F, 0.06F));
            }

        }

        @Override
        public void tick() {
            this.updateSpeed();
            if(this.operation == MovementController.Action.MOVE_TO && !this.walrus.getNavigation().isDone()) {
                double d0 = this.wantedX - this.walrus.getX();
                double d1 = this.wantedY - this.walrus.getY();
                double d2 = this.wantedZ - this.walrus.getZ();
                double d3 = MathHelper.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
                d1 = d1 / d3;
                float f = (float) (MathHelper.atan2(d2, d0) * (double) (180F / (float) Math.PI)) - 90.0F;
                this.walrus.yRot = this.rotlerp(this.walrus.yRot, f, 90.0F);
                this.walrus.yBodyRot = this.walrus.yRot;
                float f1 = (float) (this.speedModifier * this.walrus.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
                this.walrus.setSpeed(MathHelper.lerp(0.125F, this.walrus.getSpeed(), f1));
                this.walrus.setDeltaMovement(this.walrus.getDeltaMovement().add(0.0D, (double) this.walrus.getSpeed() * d1 * 0.1D, 0.0D));
            } else {
                this.walrus.setSpeed(0.0F);
            }
        }
    }

    public static class TravelGoal extends Goal {
        private final EntityWalrus walrus;
        private final double speed;
        private boolean noPosition;

        public TravelGoal(EntityWalrus walrus, double speed) {
            this.walrus = walrus;
            this.speed = speed;
        }

        @Override
        public boolean canUse() {
            return !this.walrus.isGoingHome() && this.walrus.isInWater();
        }

        @Override
        public void start() {
            int xzRange = 512;
            int yRange = 4;
            Random random = this.walrus.random;
            int xOff = random.nextInt(xzRange * 2 + 1) - xzRange;
            int yOff = random.nextInt(yRange * 2 + 1) - yRange;
            int zOff = random.nextInt(xzRange * 2 + 1) - xzRange;
            if(yOff + this.walrus.getY() > this.walrus.level.getSeaLevel() - 1) {
                yOff = 0;
            }

            BlockPos blockpos = new BlockPos((double) xOff + this.walrus.getX(), (double) yOff + this.walrus.getY(), (double) zOff + this.walrus.getZ());
            this.walrus.setTravelPos(blockpos);
            this.walrus.setTravelling(true);
            this.noPosition = false;
        }

        @Override
        @SuppressWarnings("deprecation")
        public void tick() {
            if(this.walrus.getNavigation().isDone()) {
                BlockPos blockpos = this.walrus.getTravelPos();
                Vector3d dest = RandomPositionGenerator.getPosTowards(this.walrus, 16, 3, new Vector3d(blockpos.getX(), blockpos.getY(), blockpos.getZ()), Math.PI / 10D);
                if(dest == null) {
                    dest = RandomPositionGenerator.getPosTowards(this.walrus, 8, 7, new Vector3d(blockpos.getX(), blockpos.getY(), blockpos.getZ()));
                }

                if(dest != null) {
                    int x = MathHelper.floor(dest.x);
                    int z = MathHelper.floor(dest.z);
                    int range = 34;
                    if(!this.walrus.level.hasChunksAt(x - range, 0, z - range, x + range, 0, z + range)) {
                        dest = null;
                    }
                }

                if(dest == null) {
                    this.noPosition = true;
                    return;
                }

                this.walrus.getNavigation().moveTo(dest.x, dest.y, dest.z, this.speed);
            }

        }

        @Override
        public boolean canContinueToUse() {
            return !this.walrus.getNavigation().isDone() && !this.noPosition && !this.walrus.isGoingHome();
        }

        @Override
        public void stop() {
            this.walrus.setTravelling(false);
            super.stop();
        }
    }

    public static class WanderGoal extends RandomWalkingGoal {
        private final EntityWalrus walrus;

        public WanderGoal(EntityWalrus walrus, double speed, int chance) {
            super(walrus, speed, chance);
            this.walrus = walrus;
        }

        @Override
        public boolean canUse() {
            return !this.mob.isInWater() && !this.walrus.isGoingHome() && super.canUse();
        }
    }

    @Override
    public AgeableEntity getBreedOffspring(ServerWorld world, AgeableEntity ageable) {
        return null;
    }

    @Override
    public boolean removeWhenFarAway(double range) {
        return despawn(range);
    }

    @Override
    public EntityWalrus getImplementation() {
        return this;
    }

    @Override
    public EntityTypeContainer<? extends EntityWalrus> getContainer() {
        return ModEntities.WALRUS;
    }

}
