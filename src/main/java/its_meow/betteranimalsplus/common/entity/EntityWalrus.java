package its_meow.betteranimalsplus.common.entity;

import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.interfaces.IContainerEntity;
import its_meow.betteranimalsplus.common.entity.ai.HybridPathNavigator;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModItems;
import its_meow.betteranimalsplus.init.ModLootTables;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.RandomPositionGenerator;
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
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Random;

public class EntityWalrus extends AnimalEntity implements IContainerEntity<EntityWalrus> {

    private static final DataParameter<BlockPos> HOME_POS = EntityDataManager.createKey(EntityWalrus.class, DataSerializers.BLOCK_POS);
    private static final DataParameter<BlockPos> TRAVEL_POS = EntityDataManager.createKey(EntityWalrus.class, DataSerializers.BLOCK_POS);
    private static final DataParameter<Boolean> GOING_HOME = EntityDataManager.createKey(EntityWalrus.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> TRAVELLING = EntityDataManager.createKey(EntityWalrus.class, DataSerializers.BOOLEAN);
    public boolean hasGivenDisc = false;

    public EntityWalrus(EntityType<? extends EntityWalrus> entityType, World worldIn) {
        super(entityType, worldIn);
        this.setPathPriority(PathNodeType.WATER, 0.0F);
        this.moveController = new EntityWalrus.MoveHelperController(this);
        this.stepHeight = 1.0F;
    }

    @Override
    public boolean processInteract(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getHeldItem(hand);
        if(!hasGivenDisc && stack.getItem() == ModItems.FRIED_EGG.get()) {
            this.consumeItemFromStack(player, stack);
            this.world.setEntityState(this, (byte) 90);
            this.hasGivenDisc = true;
            this.entityDropItem(new ItemStack(ModItems.RECORD_WALRUS.get()));
            return true;
        }
        return super.processInteract(player, hand);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if(id == 90) {
            for(int i = 0; i < 7; ++i) {
                double x = this.rand.nextGaussian() * 0.02D;
                double y = this.rand.nextGaussian() * 0.02D;
                double z = this.rand.nextGaussian() * 0.02D;
                this.world.addParticle(ParticleTypes.NOTE, this.getPosX() + (double) (this.rand.nextFloat() * this.getWidth() * 2.0F) - (double) this.getWidth(), this.getPosY() + 0.5D + (double) (this.rand.nextFloat() * this.getHeight()), this.getPosZ() + (double) (this.rand.nextFloat() * this.getWidth() * 2.0F) - (double) this.getWidth(), x, y, z);
            }
        } else {
            super.handleStatusUpdate(id);
        }
    }

    public boolean attackEntityAsMob(Entity entityIn) {
        // 1/3 chance to pierce armor
        boolean flag = entityIn.attackEntityFrom(this.getRNG().nextInt(3) == 0 ? DamageSource.causeMobDamage(this).setDamageBypassesArmor() : DamageSource.causeMobDamage(this), (float) this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue());
        if(flag) {
            Vec3d pos = this.getPositionVector();
            Vec3d targetPos = entityIn.getPositionVector();
            ((LivingEntity) entityIn).knockBack(this, 0.5F, pos.x - targetPos.x, pos.z - targetPos.z);
        }
        return flag;
    }

    public void setHome(BlockPos position) {
        this.dataManager.set(HOME_POS, position);
    }

    private BlockPos getHome() {
        return this.dataManager.get(HOME_POS);
    }

    private void setTravelPos(BlockPos position) {
        this.dataManager.set(TRAVEL_POS, position);
    }

    private BlockPos getTravelPos() {
        return this.dataManager.get(TRAVEL_POS);
    }

    private boolean isGoingHome() {
        return this.dataManager.get(GOING_HOME);
    }

    private void setGoingHome(boolean isGoingHome) {
        this.dataManager.set(GOING_HOME, isGoingHome);
    }

    private boolean isTravelling() {
        return this.dataManager.get(TRAVELLING);
    }

    private void setTravelling(boolean isTravelling) {
        this.dataManager.set(TRAVELLING, isTravelling);
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(HOME_POS, BlockPos.ZERO);
        this.dataManager.register(TRAVEL_POS, BlockPos.ZERO);
        this.dataManager.register(GOING_HOME, false);
        this.dataManager.register(TRAVELLING, false);
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putInt("HomePosX", this.getHome().getX());
        compound.putInt("HomePosY", this.getHome().getY());
        compound.putInt("HomePosZ", this.getHome().getZ());
        compound.putInt("TravelPosX", this.getTravelPos().getX());
        compound.putInt("TravelPosY", this.getTravelPos().getY());
        compound.putInt("TravelPosZ", this.getTravelPos().getZ());
        compound.putBoolean("DiscGiven", hasGivenDisc);
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        int i = compound.getInt("HomePosX");
        int j = compound.getInt("HomePosY");
        int k = compound.getInt("HomePosZ");
        this.setHome(new BlockPos(i, j, k));
        super.readAdditional(compound);
        int l = compound.getInt("TravelPosX");
        int i1 = compound.getInt("TravelPosY");
        int j1 = compound.getInt("TravelPosZ");
        this.setTravelPos(new BlockPos(l, i1, j1));
        this.hasGivenDisc = compound.getBoolean("DiscGiven");
    }

    @Override
    @Nullable
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        this.setHome(new BlockPos(this));
        this.setTravelPos(BlockPos.ZERO);
        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }

    public static boolean canSpawn(EntityType<EntityWalrus> walrus, IWorld world, SpawnReason reason, BlockPos pos, Random rand) {
        return pos.getY() < world.getSeaLevel() + 4 && world.getLightSubtracted(pos, 0) > 8;
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
                return this.attacker.getWidth() * this.attacker.getWidth() + attackTarget.getWidth();
            }
        });
        this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(5, new EntityWalrus.WanderGoal(this, 1.0D, 100));
        this.targetSelector.addGoal(0, new HurtByTargetGoal(this, new Class[0]) {
            @Override
            public boolean shouldExecute() {
                return EntityWalrus.this.world.getDifficulty() != Difficulty.PEACEFUL && super.shouldExecute();
            }
        });
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
        this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(5D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4D);
        this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1D);
    }

    @Override
    public boolean isPushedByWater() {
        return false;
    }

    @Override
    public boolean canBreatheUnderwater() {
        return false;
    }

    @Override
    public int getMaxAir() {
        return 6000; // 5m
    }

    @Override
    protected int determineNextAir(int currentAir) {
        return this.getMaxAir();
    }

    @Override
    public CreatureAttribute getCreatureAttribute() {
        return CreatureAttribute.WATER;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 0.6F);
    }

    @Override
    protected float determineNextStepDistance() {
        return this.distanceWalkedOnStepModified + 0.15F;
    }

    @Override
    protected PathNavigator createNavigator(World worldIn) {
        return new HybridPathNavigator<>(this, worldIn, EntityWalrus::isTravelling);
    }

    @Override
    @SuppressWarnings("deprecation")
    public float getBlockPathWeight(BlockPos pos, IWorldReader worldIn) {
        if(!this.isGoingHome() && worldIn.getFluidState(pos).isTagged(FluidTags.WATER)) {
            return 10.0F;
        } else {
            return BlockTags.ICE.contains(worldIn.getBlockState(pos.down()).getBlock()) ? 10.0F : worldIn.getBrightness(pos) - 0.5F;
        }
    }

    @Override
    public void travel(Vec3d p_213352_1_) {
        if(this.isServerWorld() && this.isInWater()) {
            this.moveRelative(0.1F, p_213352_1_);
            this.move(MoverType.SELF, this.getMotion());
            this.setMotion(this.getMotion().scale(0.9D));
            if(this.getAttackTarget() == null && (!this.isGoingHome() || !this.getHome().withinDistance(this.getPositionVec(), 20.0D))) {
                this.setMotion(this.getMotion().add(0.0D, -0.005D, 0.0D));
            }
        } else {
            super.travel(p_213352_1_);
        }

    }

    @Override
    public boolean canBeLeashedTo(PlayerEntity player) {
        return false;
    }

    @Override
    protected ResourceLocation getLootTable() {
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
        public boolean shouldExecute() {
            if(this.walrus.isChild()) {
                return false;
            } else if(this.walrus.getRNG().nextInt(700) != 0) {
                return false;
            } else {
                return !this.walrus.getHome().withinDistance(this.walrus.getPositionVec(), 64.0D);
            }
        }

        @Override
        public void startExecuting() {
            this.walrus.setGoingHome(true);
            this.noPosition = false;
            this.ticksRan = 0;
        }

        @Override
        public void resetTask() {
            this.walrus.setGoingHome(false);
        }

        @Override
        public boolean shouldContinueExecuting() {
            return !this.walrus.getHome().withinDistance(this.walrus.getPositionVec(), 7.0D) && !this.noPosition && this.ticksRan <= 600;
        }

        @Override
        public void tick() {
            BlockPos blockpos = this.walrus.getHome();
            boolean nearHome = blockpos.withinDistance(this.walrus.getPositionVec(), 16.0D);
            if(nearHome) {
                ++this.ticksRan;
            }

            if(this.walrus.getNavigator().noPath()) {
                Vec3d vec3d = RandomPositionGenerator.findRandomTargetTowardsScaled(this.walrus, 16, 3, new Vec3d(blockpos.getX(), blockpos.getY(), blockpos.getZ()), (float) Math.PI / 10F);
                if(vec3d == null) {
                    vec3d = RandomPositionGenerator.findRandomTargetBlockTowards(this.walrus, 8, 7, new Vec3d(blockpos.getX(), blockpos.getY(), blockpos.getZ()));
                }

                if(vec3d != null && !nearHome && this.walrus.world.getBlockState(new BlockPos(vec3d)).getBlock() != Blocks.WATER) {
                    vec3d = RandomPositionGenerator.findRandomTargetBlockTowards(this.walrus, 16, 5, new Vec3d(blockpos.getX(), blockpos.getY(), blockpos.getZ()));
                }

                if(vec3d == null) {
                    this.noPosition = true;
                    return;
                }

                this.walrus.getNavigator().tryMoveToXYZ(vec3d.x, vec3d.y, vec3d.z, this.speed);
            }

        }
    }

    public static class GoToWaterGoal extends MoveToBlockGoal {
        private final EntityWalrus walrus;

        public GoToWaterGoal(EntityWalrus walrus, double speed) {
            super(walrus, speed, 24);
            this.walrus = walrus;
            this.field_203112_e = -1;
        }

        @Override
        public boolean shouldContinueExecuting() {
            return !this.walrus.isInWater() && this.timeoutCounter <= 1200 && this.shouldMoveTo(this.walrus.world, this.destinationBlock);
        }

        @Override
        public boolean shouldExecute() {
            if(this.walrus.isChild() && !this.walrus.isInWater()) {
                return super.shouldExecute();
            } else {
                return !this.walrus.isGoingHome() && !this.walrus.isInWater() && super.shouldExecute();
            }
        }

        @Override
        public boolean shouldMove() {
            return this.timeoutCounter % 160 == 0;
        }

        @Override
        protected boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos) {
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
                this.walrus.setMotion(this.walrus.getMotion().add(0.0D, 0.005D, 0.0D));
                if(!this.walrus.getHome().withinDistance(this.walrus.getPositionVec(), 16.0D)) {
                    this.walrus.setAIMoveSpeed(Math.max(this.walrus.getAIMoveSpeed() / 2.0F, 0.2F));
                }
            } else if(this.walrus.onGround) {
                this.walrus.setAIMoveSpeed(Math.max(this.walrus.getAIMoveSpeed() / 2.0F, 0.06F));
            }

        }

        @Override
        public void tick() {
            this.updateSpeed();
            if(this.action == MovementController.Action.MOVE_TO && !this.walrus.getNavigator().noPath()) {
                double d0 = this.posX - this.walrus.getPosX();
                double d1 = this.posY - this.walrus.getPosY();
                double d2 = this.posZ - this.walrus.getPosZ();
                double d3 = MathHelper.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
                d1 = d1 / d3;
                float f = (float) (MathHelper.atan2(d2, d0) * (double) (180F / (float) Math.PI)) - 90.0F;
                this.walrus.rotationYaw = this.limitAngle(this.walrus.rotationYaw, f, 90.0F);
                this.walrus.renderYawOffset = this.walrus.rotationYaw;
                float f1 = (float) (this.speed * this.walrus.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue());
                this.walrus.setAIMoveSpeed(MathHelper.lerp(0.125F, this.walrus.getAIMoveSpeed(), f1));
                this.walrus.setMotion(this.walrus.getMotion().add(0.0D, (double) this.walrus.getAIMoveSpeed() * d1 * 0.1D, 0.0D));
            } else {
                this.walrus.setAIMoveSpeed(0.0F);
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
        public boolean shouldExecute() {
            return !this.walrus.isGoingHome() && this.walrus.isInWater();
        }

        @Override
        public void startExecuting() {
            int xzRange = 512;
            int yRange = 4;
            Random random = this.walrus.rand;
            int xOff = random.nextInt(xzRange * 2 + 1) - xzRange;
            int yOff = random.nextInt(yRange * 2 + 1) - yRange;
            int zOff = random.nextInt(xzRange * 2 + 1) - xzRange;
            if(yOff + this.walrus.getPosY() > this.walrus.world.getSeaLevel() - 1) {
                yOff = 0;
            }

            BlockPos blockpos = new BlockPos((double) xOff + this.walrus.getPosX(), (double) yOff + this.walrus.getPosY(), (double) zOff + this.walrus.getPosZ());
            this.walrus.setTravelPos(blockpos);
            this.walrus.setTravelling(true);
            this.noPosition = false;
        }

        @Override
        @SuppressWarnings("deprecation")
        public void tick() {
            if(this.walrus.getNavigator().noPath()) {
                Vec3d travelDest = new Vec3d(this.walrus.getTravelPos());
                Vec3d dest = RandomPositionGenerator.findRandomTargetTowardsScaled(this.walrus, 16, 3, travelDest, (float) Math.PI / 10F);
                if(dest == null) {
                    dest = RandomPositionGenerator.findRandomTargetBlockTowards(this.walrus, 8, 7, travelDest);
                }

                if(dest != null) {
                    int x = MathHelper.floor(dest.x);
                    int z = MathHelper.floor(dest.z);
                    int range = 34;
                    if(!this.walrus.world.isAreaLoaded(x - range, 0, z - range, x + range, 0, z + range)) {
                        dest = null;
                    }
                }

                if(dest == null) {
                    this.noPosition = true;
                    return;
                }

                this.walrus.getNavigator().tryMoveToXYZ(dest.x, dest.y, dest.z, this.speed);
            }

        }

        @Override
        public boolean shouldContinueExecuting() {
            return !this.walrus.getNavigator().noPath() && !this.noPosition && !this.walrus.isGoingHome();
        }

        @Override
        public void resetTask() {
            this.walrus.setTravelling(false);
            super.resetTask();
        }
    }

    public static class WanderGoal extends RandomWalkingGoal {
        private final EntityWalrus walrus;

        public WanderGoal(EntityWalrus walrus, double speed, int chance) {
            super(walrus, speed, chance);
            this.walrus = walrus;
        }

        @Override
        public boolean shouldExecute() {
            return !this.creature.isInWater() && !this.walrus.isGoingHome() && super.shouldExecute();
        }
    }

    @Override
    public AgeableEntity createChild(AgeableEntity ageable) {
        return null;
    }

    @Override
    public boolean canDespawn(double range) {
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
