package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.betteranimalsplus.common.entity.ai.EntityAIEatBerries;
import dev.itsmeow.betteranimalsplus.common.entity.ai.FollowParentGoalButNotStupid;
import dev.itsmeow.betteranimalsplus.common.entity.ai.HungerNearestAttackableTargetGoal;
import dev.itsmeow.betteranimalsplus.common.entity.util.IDropHead;
import dev.itsmeow.betteranimalsplus.common.entity.util.IHaveHunger;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModLootTables;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.passive.fish.SalmonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class EntityBear extends AnimalEntity implements IDropHead<EntityBear>, IHaveHunger<EntityBear> {
    private static final DataParameter<Boolean> IS_STANDING = EntityDataManager.createKey(EntityBear.class, DataSerializers.BOOLEAN);
    private float clientSideStandAnimation0;
    private float clientSideStandAnimation;
    private int warningSoundTicks;
    private int hunger;

    public EntityBear(EntityType<? extends EntityBear> entityType, World worldIn) {
        super(entityType, worldIn);
        this.setPathPriority(PathNodeType.DANGER_OTHER, 0.0F);
        this.setPathPriority(PathNodeType.DAMAGE_OTHER, 0.0F);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new BearMeleeAttackGoal());
        this.goalSelector.addGoal(1, new BearPanicGoal());
        this.goalSelector.addGoal(2, new BreedGoal(this, 1D));
        this.goalSelector.addGoal(2, new FollowParentGoalButNotStupid(this, 1.25D, e -> !(e instanceof EntityBearNeutral)));
        this.goalSelector.addGoal(3, new EntityAIEatBerries(this, 1.0D, 12, 2));
        this.goalSelector.addGoal(5, new RandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.targetSelector.addGoal(1, new BearHurtByTargetGoal());
        this.targetSelector.addGoal(2, new AttackPlayerGoal());
        this.targetSelector.addGoal(2, new HungerNearestAttackableTargetGoal<>(this, SalmonEntity.class, 90, true, true, e -> true));
        this.targetSelector.addGoal(3, new HungerNearestAttackableTargetGoal<>(this, EntityDeer.class, 90, true, true, e -> true));
        this.targetSelector.addGoal(4, new HungerNearestAttackableTargetGoal<>(this, PigEntity.class, 90, true, true, e -> true));
        this.targetSelector.addGoal(5, new HungerNearestAttackableTargetGoal<>(this, ChickenEntity.class, 90, true, true, e -> true));
        this.targetSelector.addGoal(6, new HungerNearestAttackableTargetGoal<>(this, RabbitEntity.class, 90, true, true, e -> true));
        this.targetSelector.addGoal(5, new HungerNearestAttackableTargetGoal<>(this, EntityPheasant.class, 90, true, true, e -> true));
        this.targetSelector.addGoal(3, new HungerNearestAttackableTargetGoal<>(this, FoxEntity.class, 90, true, true, e -> true));
    }

    @Override
    protected PathNavigator createNavigator(World worldIn) {
        return new GroundPathNavigator(this, worldIn) {
            @Override
            protected void pathFollow() {
                Vector3d vector3d = this.getEntityPosition();
                this.maxDistanceToWaypoint = this.entity.getWidth() > 0.75F ? this.entity.getWidth() / 2.0F : 0.75F - this.entity.getWidth() / 2.0F;
                Vector3i vector3i = this.currentPath.func_242948_g();
                double d0 = Math.abs(this.entity.getPosX() - ((double)vector3i.getX() + (this.entity.getWidth() + 1) / 2D)); //Forge: Fix MC-94054
                double d1 = Math.abs(this.entity.getPosY() - (double)vector3i.getY());
                double d2 = Math.abs(this.entity.getPosZ() - ((double)vector3i.getZ() + (this.entity.getWidth() + 1) / 2D)); //Forge: Fix MC-94054
                boolean flag = d0 <= (double)this.maxDistanceToWaypoint && d2 <= (double)this.maxDistanceToWaypoint && d1 < 1.0D;
                if (flag || this.entity.func_233660_b_(this.currentPath.getCurrentPoint().nodeType) && this.func_234112_b_(vector3d)) {
                    this.currentPath.incrementPathIndex();
                }

                this.checkForStuck(vector3d);
            }

            private boolean func_234112_b_(Vector3d currentPosition) {
                if (this.currentPath.getCurrentPathIndex() + 1 >= this.currentPath.getCurrentPathLength()) {
                    return false;
                } else {
                    Vector3d vector3d = Vector3d.copyCenteredHorizontally(this.currentPath.func_242948_g());
                    if (!currentPosition.isWithinDistanceOf(vector3d, 2.0D)) {
                        return false;
                    } else {
                        Vector3d vector3d1 = Vector3d.copyCenteredHorizontally(this.currentPath.func_242947_d(this.currentPath.getCurrentPathIndex() + 1));
                        Vector3d vector3d2 = vector3d1.subtract(vector3d);
                        Vector3d vector3d3 = currentPosition.subtract(vector3d);
                        return vector3d2.dotProduct(vector3d3) > 0.0D;
                    }
                }
            }
        };
    }

    @Override
    public int getHunger() {
        return hunger;
    }

    @Override
    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        this.writeHunger(compound);
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.readHunger(compound);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return ItemTags.FISHES.contains(stack.getItem()) || (stack.getItem().isFood() && stack.getItem().getFood().isMeat());
    }

    public boolean isPeaceful() {
        return world.getDifficulty() == Difficulty.PEACEFUL;
    }

    @Override
    public double getFluidJumpHeight() {
        // max submerged
        return 0.6D;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return ModLootTables.BEAR_BROWN;
    }

    @Override
    public void tick() {
        super.tick();
        if(this.ticksExisted % 20 == 0) {
            this.incrementHunger();
        }
        if(this.world.isRemote) {
            if(this.clientSideStandAnimation != this.clientSideStandAnimation0) {
                this.recalculateSize();
            }

            this.clientSideStandAnimation0 = this.clientSideStandAnimation;
            if(this.isStanding()) {
                this.clientSideStandAnimation = MathHelper.clamp(this.clientSideStandAnimation + 1.0F, 0.0F, 6.0F);
            } else {
                this.clientSideStandAnimation = MathHelper.clamp(this.clientSideStandAnimation - 1.0F, 0.0F, 6.0F);
            }
        }

        if(this.warningSoundTicks > 0) {
            --this.warningSoundTicks;
        }

    }

    public boolean isStanding() {
        return this.dataManager.get(IS_STANDING);
    }

    public void setStanding(boolean standing) {
        this.dataManager.set(IS_STANDING, standing);
    }

    @OnlyIn(Dist.CLIENT)
    public float getStandingAnimationScale(float p_189795_1_) {
        return MathHelper.lerp(p_189795_1_, this.clientSideStandAnimation0, this.clientSideStandAnimation) / 6.0F;
    }

    @Override
    protected float getWaterSlowDown() {
        return 0.97F;
    }

    @Override
    public EntitySize getSize(Pose poseIn) {
        if(this.clientSideStandAnimation > 0.0F) {
            float f = this.clientSideStandAnimation / 6.0F;
            float f1 = 1.0F + f;
            return super.getSize(poseIn).scale(1.0F, f1);
        } else {
            return super.getSize(poseIn);
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float) ((int) this.getAttribute(Attributes.ATTACK_DAMAGE).getValue()));
        if(flag) {
            this.applyEnchantments(this, entityIn);
        }

        return flag;
    }

    protected void playWarningSound() {
        if(this.warningSoundTicks <= 0) {
            this.playSound(SoundEvents.ENTITY_POLAR_BEAR_WARNING, 1.0F, 1.0F);
            this.warningSoundTicks = 40;
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.isChild() ? SoundEvents.ENTITY_POLAR_BEAR_AMBIENT_BABY : SoundEvents.ENTITY_POLAR_BEAR_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_POLAR_BEAR_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_POLAR_BEAR_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ENTITY_POLAR_BEAR_STEP, 0.15F, 1.0F);
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(IS_STANDING, false);
    }

    class AttackPlayerGoal extends NearestAttackableTargetGoal<PlayerEntity> {
        public AttackPlayerGoal() {
            super(EntityBear.this, PlayerEntity.class, 0, true, true, null);
        }

        @Override
        public boolean shouldExecute() {
            if(EntityBear.this.isPeaceful() || EntityBear.this.isChild()) {
                return false;
            } else {
                if(super.shouldExecute()) {
                    for(EntityBear bear : EntityBear.this.world.getEntitiesWithinAABB(EntityBear.class, EntityBear.this.getBoundingBox().grow(8.0D, 4.0D, 8.0D))) {
                        if(bear.isChild()) {
                            return true;
                        }
                    }
                }

                return false;
            }
        }

        @Override
        protected double getTargetDistance() {
            return super.getTargetDistance() * 0.5D;
        }
    }

    class BearHurtByTargetGoal extends HurtByTargetGoal {
        public BearHurtByTargetGoal() {
            super(EntityBear.this);
        }

        @Override
        public void startExecuting() {
            super.startExecuting();
            if(EntityBear.this.isChild()) {
                this.alertOthers();
                this.resetTask();
            }

        }

        @Override
        protected void setAttackTarget(MobEntity mobIn, LivingEntity targetIn) {
            if(mobIn instanceof EntityBear && !mobIn.isChild() && (!(targetIn instanceof PlayerEntity) || !((EntityBear) mobIn).isPeaceful())) {
                super.setAttackTarget(mobIn, targetIn);
            }

        }
    }

    class BearMeleeAttackGoal extends MeleeAttackGoal {

        public BearMeleeAttackGoal() {
            super(EntityBear.this, 1.25D, true);
        }

        @Override
        protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
            double d0 = this.getAttackReachSqr(enemy);
            if (distToEnemySqr <= d0 && this.isSwingOnCooldown()) {
                this.resetSwingCooldown();
                this.attacker.attackEntityAsMob(enemy);
                EntityBear.this.setStanding(false);
            } else if (distToEnemySqr <= d0 * 2.0D) {
                if (this.isSwingOnCooldown()) {
                    EntityBear.this.setStanding(false);
                    this.resetSwingCooldown();
                }

                if (this.getSwingCooldown() <= 10) {
                    EntityBear.this.setStanding(true);
                    EntityBear.this.playWarningSound();
                }
            } else {
                this.resetSwingCooldown();
                EntityBear.this.setStanding(false);
            }

        }

        @Override
        public void resetTask() {
            EntityBear.this.setStanding(false);
            super.resetTask();
        }

        @Override
        protected double getAttackReachSqr(LivingEntity attackTarget) {
            return 8.0F + attackTarget.getWidth();
        }
    }

    class BearPanicGoal extends PanicGoal {
        public BearPanicGoal() {
            super(EntityBear.this, 2.0D);
        }

        @Override
        public boolean shouldExecute() {
            return (EntityBear.this.isChild() || EntityBear.this.isBurning()) && super.shouldExecute();
        }
    }

    @Override
    public boolean isInvulnerableTo(DamageSource source) {
        return super.isInvulnerableTo(source) || source == DamageSource.SWEET_BERRY_BUSH;
    }

    @Override
    public void onDeath(DamageSource cause) {
        super.onDeath(cause);
        this.doHeadDrop();
    }

    @Override
    public boolean canDespawn(double range) {
        return despawn(range);
    }

    @Override
    public EntityBear getImplementation() {
        return this;
    }

    @Override
    public EntityTypeContainer<? extends EntityBear> getContainer() {
        return ModEntities.BROWN_BEAR;
    }

    @Override
    public AgeableEntity createChild(ServerWorld world, AgeableEntity ageable) {
        return getContainer().getEntityType().create(world);
    }

    static class GroupData implements ILivingEntityData {
        private GroupData() {
        }
    }

    @Override
    public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        this.setInitialHunger();
        if(spawnDataIn instanceof GroupData) {
            this.setGrowingAge(-24000);
        } else {
            spawnDataIn = new GroupData();
        }
        return spawnDataIn;
    }

}
