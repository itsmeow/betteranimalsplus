package its_meow.betteranimalsplus.common.entity;

import java.util.Random;

import its_meow.betteranimalsplus.common.entity.ai.BreatheAirGoal;
import its_meow.betteranimalsplus.common.entity.ai.WalkAndSwimNodeProcessor;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModItems;
import its_meow.betteranimalsplus.init.ModLootTables;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIMoveToBlock;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathFinder;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateSwimmer;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityWalrus extends EntityAnimal {
    private static final DataParameter<BlockPos> HOME_POS = EntityDataManager.createKey(EntityWalrus.class, DataSerializers.BLOCK_POS);
    private static final DataParameter<BlockPos> TRAVEL_POS = EntityDataManager.createKey(EntityWalrus.class, DataSerializers.BLOCK_POS);
    private static final DataParameter<Boolean> GOING_HOME = EntityDataManager.createKey(EntityWalrus.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> TRAVELLING = EntityDataManager.createKey(EntityWalrus.class, DataSerializers.BOOLEAN);
    public boolean hasGivenDisc = false;

    public EntityWalrus(World worldIn) {
        super(worldIn);
        this.setSize(3, 1.25F);
        this.moveHelper = new EntityWalrus.MoveHelperController(this);
        this.stepHeight = 1.0F;
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.getHeldItem(hand);
        if(!hasGivenDisc && stack.getItem() == ModItems.FRIED_EGG) {
            this.consumeItemFromStack(player, stack);
            this.world.setEntityState(this, (byte) 90);
            this.hasGivenDisc = true;
            this.entityDropItem(new ItemStack(ModItems.RECORD_WALRUS), 0.5F);
            return true;
        }
        return super.processInteract(player, hand);
    }

    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id) {
        if(id == 90) {
            for(int i = 0; i < 7; ++i) {
                double x = this.rand.nextGaussian() * 0.02D;
                double y = this.rand.nextGaussian() * 0.02D;
                double z = this.rand.nextGaussian() * 0.02D;
                this.world.spawnParticle(EnumParticleTypes.NOTE, this.posX + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, this.posY + 0.5D + (double) (this.rand.nextFloat() * this.height), this.posZ + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, x, y, z);
            }
        } else {
            super.handleStatusUpdate(id);
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        // 1/3 chance to pierce armor
        boolean flag = entityIn.attackEntityFrom(this.getRNG().nextInt(3) == 0 ? DamageSource.causeMobDamage(this).setDamageBypassesArmor() : DamageSource.causeMobDamage(this), (float) this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getBaseValue());
        if(flag) {
            Vec3d pos = this.getPositionVector();
            Vec3d targetPos = entityIn.getPositionVector();
            ((EntityLivingBase) entityIn).knockBack(this, 0.5F, pos.x - targetPos.x, pos.z - targetPos.z);
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
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(HOME_POS, BlockPos.ORIGIN);
        this.dataManager.register(TRAVEL_POS, BlockPos.ORIGIN);
        this.dataManager.register(GOING_HOME, false);
        this.dataManager.register(TRAVELLING, false);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setInteger("HomePosX", this.getHome().getX());
        compound.setInteger("HomePosY", this.getHome().getY());
        compound.setInteger("HomePosZ", this.getHome().getZ());
        compound.setInteger("TravelPosX", this.getTravelPos().getX());
        compound.setInteger("TravelPosY", this.getTravelPos().getY());
        compound.setInteger("TravelPosZ", this.getTravelPos().getZ());
        compound.setBoolean("DiscGiven", hasGivenDisc);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        int i = compound.getInteger("HomePosX");
        int j = compound.getInteger("HomePosY");
        int k = compound.getInteger("HomePosZ");
        this.setHome(new BlockPos(i, j, k));
        super.readEntityFromNBT(compound);
        int l = compound.getInteger("TravelPosX");
        int i1 = compound.getInteger("TravelPosY");
        int j1 = compound.getInteger("TravelPosZ");
        this.setTravelPos(new BlockPos(l, i1, j1));
        this.hasGivenDisc = compound.getBoolean("DiscGiven");
    }

    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
        this.setHome(new BlockPos(this));
        this.setTravelPos(BlockPos.ORIGIN);
        return super.onInitialSpawn(difficulty, livingdata);
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.getPosition().getY() < world.getSeaLevel() + 4 && world.getLight(this.getPosition(), true) > 8;
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new BreatheAirGoal(this));
        this.tasks.addTask(1, new EntityWalrus.GoToWaterGoal(this, 1.0D));
        this.tasks.addTask(2, new EntityWalrus.GoHomeGoal(this, 1.0D));
        this.tasks.addTask(3, new EntityWalrus.TravelGoal(this, 1.0D));
        this.tasks.addTask(4, new EntityAIAttackMelee(this, 1.0D, false) {
            @Override
            protected double getAttackReachSqr(EntityLivingBase attackTarget) {
                return (double) (this.attacker.width * this.attacker.width + attackTarget.width);
            }
        });
        this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(5, new EntityWalrus.WanderGoal(this, 1.0D, 100));
        this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, false, new Class[0]));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(5D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1D);
    }

    public boolean isPushedByWater() {
        return false;
    }

    public boolean canBreatheUnderwater() {
        return false;
    }

    @Override
    public void setAir(int air) {
        if(air == 300 && this.world != null && this.isAddedToWorld() && this.world.loadedEntityList.contains(this) && !this.isInsideOfMaterial(Material.WATER)) {
            super.setAir(6000); // 5m
        } else {
            super.setAir(air);
        }
    }

    @Override
    protected void playStepSound(BlockPos pos, Block blockIn) {
        this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 0.6F);
    }

    @Override
    protected PathNavigate createNavigator(World worldIn) {
        return new EntityWalrus.Navigator(this, worldIn);
    }

    @Override
    public float getPathPriority(PathNodeType nodeType) {
        if(!this.isGoingHome() && nodeType == PathNodeType.WATER) {
            return 10.0F;
        } else {
            return super.getPathPriority(nodeType);
        }
    }

    @Override
    public void travel(float strafe, float vertical, float forward) {
        if(this.isServerWorld() && this.isInWater()) {
            this.moveRelative(strafe, vertical, forward, 0.1F);
            this.move(MoverType.SELF, motionX, motionY, motionZ);
            this.motionX *= 0.9D;
            this.motionY *= 0.9D;
            this.motionZ *= 0.9D;
            if(this.getAttackTarget() == null && (!this.isGoingHome() || !this.withinDistanceFromHome(20D))) {
                this.motionY -= 0.05D;
            }
        } else {
            super.travel(strafe, vertical, forward);
        }
    }

    @Override
    public boolean canBeLeashedTo(EntityPlayer player) {
        return false;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return ModLootTables.WALRUS;
    }

    public boolean withinDistanceFromHome(double distance) {
        return Math.sqrt(this.getHome().distanceSq(this.getPosition())) <= distance;
    }

    public static class GoHomeGoal extends EntityAIBase {
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
                return !walrus.withinDistanceFromHome(64.0D);
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
            return !this.walrus.withinDistanceFromHome(7.0D) && !this.noPosition && this.ticksRan <= 600;
        }

        @Override
        public void updateTask() {
            BlockPos blockpos = this.walrus.getHome();
            boolean nearHome = walrus.withinDistanceFromHome(16.0D);
            if(nearHome) {
                ++this.ticksRan;
            }

            if(this.walrus.getNavigator().noPath()) {
                Vec3d vec3d = RandomPositionGenerator.findRandomTargetBlockTowards(this.walrus, 16, 3, new Vec3d((double) blockpos.getX(), (double) blockpos.getY(), (double) blockpos.getZ()));
                if(vec3d == null) {
                    vec3d = RandomPositionGenerator.findRandomTargetBlockTowards(this.walrus, 8, 7, new Vec3d((double) blockpos.getX(), (double) blockpos.getY(), (double) blockpos.getZ()));
                }

                if(vec3d != null && !nearHome && this.walrus.world.getBlockState(new BlockPos(vec3d)).getBlock() != Blocks.WATER) {
                    vec3d = RandomPositionGenerator.findRandomTargetBlockTowards(this.walrus, 16, 5, new Vec3d((double) blockpos.getX(), (double) blockpos.getY(), (double) blockpos.getZ()));
                }

                if(vec3d == null) {
                    this.noPosition = true;
                    return;
                }

                this.walrus.getNavigator().tryMoveToXYZ(vec3d.x, vec3d.y, vec3d.z, this.speed);
            }

        }
    }

    public static class GoToWaterGoal extends EntityAIMoveToBlock {
        private final EntityWalrus walrus;
        private boolean isAboveDestination2;
        private int timeoutCounter2;
        private double speed;

        public GoToWaterGoal(EntityWalrus walrus, double speed) {
            super(walrus, speed, 24);
            this.walrus = walrus;
            this.speed = speed;
        }

        @Override
        public boolean shouldContinueExecuting() {
            return !this.walrus.isInWater() && this.timeoutCounter2 <= 1200 && this.shouldMoveTo(this.walrus.world, this.destinationBlock);
        }

        @Override
        public boolean shouldExecute() {
            if(this.walrus.isChild() && !this.walrus.isInWater()) {
                return shouldExecute2();
            } else {
                return !this.walrus.isGoingHome() && !this.walrus.isInWater() && shouldExecute2();
            }
        }

        public boolean shouldExecute2() {
            if(this.runDelay > 0) {
                --this.runDelay;
                return false;
            } else {
                this.runDelay = 200 + walrus.getRNG().nextInt(200);
                return this.searchForDestination2();
            }
        }

        @Override
        public void startExecuting() {
            super.startExecuting();
            this.timeoutCounter2 = 0;
        }

        private boolean searchForDestination2() {
            int i = 24;
            BlockPos blockpos = new BlockPos(this.walrus);

            for(int k = -1; k <= 1; k = k > 0 ? -k : 1 - k) {
                for(int l = 0; l < i; ++l) {
                    for(int i1 = 0; i1 <= l; i1 = i1 > 0 ? -i1 : 1 - i1) {
                        for(int j1 = i1 < l && i1 > -l ? l : 0; j1 <= l; j1 = j1 > 0 ? -j1 : 1 - j1) {
                            BlockPos blockpos1 = blockpos.add(i1, k - 1, j1);

                            if(this.walrus.isWithinHomeDistanceFromPosition(blockpos1) && this.shouldMoveTo(this.walrus.world, blockpos1)) {
                                this.destinationBlock = blockpos1;
                                return true;
                            }
                        }
                    }
                }
            }

            return false;
        }

        @Override
        public void updateTask() {
            if(this.walrus.getDistanceSqToCenter(this.destinationBlock.up()) > 1.0D) {
                this.isAboveDestination2 = false;
                ++this.timeoutCounter2;

                if(this.timeoutCounter2 % 160 == 0) {
                    this.walrus.getNavigator().tryMoveToXYZ((double) ((float) this.destinationBlock.getX()) + 0.5D, (double) (this.destinationBlock.getY() + 1), (double) ((float) this.destinationBlock.getZ()) + 0.5D, this.speed);
                }
            } else {
                this.isAboveDestination2 = true;
                --this.timeoutCounter2;
            }
        }

        @Override
        protected boolean getIsAboveDestination() {
            return this.isAboveDestination2;
        }

        @Override
        protected boolean shouldMoveTo(World worldIn, BlockPos pos) {
            Block block = worldIn.getBlockState(pos).getBlock();
            return block == Blocks.WATER;
        }
    }

    static class MoveHelperController extends EntityMoveHelper {
        private final EntityWalrus walrus;

        MoveHelperController(EntityWalrus walrus) {
            super(walrus);
            this.walrus = walrus;
        }

        private void updateSpeed() {
            if(this.walrus.isInWater()) {
                this.walrus.motionY += 0.05D;
                if(!this.walrus.withinDistanceFromHome(16.0D)) {
                    this.walrus.setAIMoveSpeed(Math.max(this.walrus.getAIMoveSpeed() / 2.0F, 0.2F));
                }
            } else if(this.walrus.onGround) {
                this.walrus.setAIMoveSpeed(Math.max(this.walrus.getAIMoveSpeed() / 2.0F, 0.06F));
            }

        }

        @Override
        public void onUpdateMoveHelper() {
            this.updateSpeed();
            if(this.action == EntityMoveHelper.Action.MOVE_TO && !this.walrus.getNavigator().noPath()) {
                double d0 = this.posX - this.walrus.posX;
                double d1 = this.posY - this.walrus.posY;
                double d2 = this.posZ - this.walrus.posZ;
                double d3 = (double) MathHelper.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
                d1 = d1 / d3;
                float f = (float) (MathHelper.atan2(d2, d0) * (double) (180F / (float) Math.PI)) - 90.0F;
                this.walrus.rotationYaw = this.limitAngle(this.walrus.rotationYaw, f, 90.0F);
                this.walrus.renderYawOffset = this.walrus.rotationYaw;
                float f1 = (float) (this.speed * this.walrus.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());
                this.walrus.setAIMoveSpeed(lerp(0.125F, this.walrus.getAIMoveSpeed(), f1));
                this.walrus.motionY += (double) this.walrus.getAIMoveSpeed() * d1 * 0.1D;
            } else {
                this.walrus.setAIMoveSpeed(0.0F);
            }
        }

        public static float lerp(float pct, float start, float end) {
            return start + pct * (end - start);
        }
    }

    public static class Navigator extends PathNavigateSwimmer {
        public Navigator(EntityWalrus walrus, World world) {
            super(walrus, world);
        }

        @Override
        protected boolean canNavigate() {
            return true;
        }

        @Override
        protected PathFinder getPathFinder() {
            return new PathFinder(new WalkAndSwimNodeProcessor());
        }

        @Override
        public boolean canEntityStandOnPos(BlockPos pos) {
            if(this.entity instanceof EntityWalrus) {
                EntityWalrus walrus = (EntityWalrus) this.entity;
                if(walrus.isTravelling()) {
                    return this.world.getBlockState(pos).getBlock() == Blocks.WATER;
                }
            }

            return !this.world.isAirBlock(pos.down());
        }
    }

    public static class TravelGoal extends EntityAIBase {
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
            if(yOff + this.walrus.posY > this.walrus.world.getSeaLevel() - 1) {
                yOff = 0;
            }

            BlockPos blockpos = new BlockPos((double) xOff + this.walrus.posX, (double) yOff + this.walrus.posY, (double) zOff + this.walrus.posZ);
            this.walrus.setTravelPos(blockpos);
            this.walrus.setTravelling(true);
            this.noPosition = false;
        }

        @Override
        public void updateTask() {
            if(this.walrus.getNavigator().noPath()) {
                BlockPos blockpos = this.walrus.getTravelPos();
                Vec3d vec3d = RandomPositionGenerator.findRandomTargetBlockTowards(this.walrus, 16, 3, new Vec3d(blockpos.getX(), blockpos.getY(), blockpos.getZ()));
                if(vec3d == null) {
                    vec3d = RandomPositionGenerator.findRandomTargetBlockTowards(this.walrus, 8, 7, new Vec3d(blockpos.getX(), blockpos.getY(), blockpos.getZ()));
                }

                if(vec3d != null) {
                    int x = MathHelper.floor(vec3d.x);
                    int z = MathHelper.floor(vec3d.z);
                    int range = 34;
                    if(!this.walrus.world.isAreaLoaded(new BlockPos(x - range, 0, z - range), new BlockPos(x + range, 0, z + range), true)) {
                        vec3d = null;
                    }
                }

                if(vec3d == null) {
                    this.noPosition = true;
                    return;
                }

                this.walrus.getNavigator().tryMoveToXYZ(vec3d.x, vec3d.y, vec3d.z, this.speed);
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

    public static class WanderGoal extends EntityAIWander {
        private final EntityWalrus walrus;

        public WanderGoal(EntityWalrus walrus, double speed, int chance) {
            super(walrus, speed, chance);
            this.walrus = walrus;
        }

        public boolean shouldExecute() {
            return !this.walrus.isInWater() && !this.walrus.isGoingHome() && super.shouldExecute();
        }
    }

    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return null;
    }

    @Override
    protected boolean canDespawn() {
        return ModEntities.entityMap.containsKey("walrus") ? ModEntities.entityMap.get("walrus").despawn && !this.hasCustomName() : false;
    }
}
