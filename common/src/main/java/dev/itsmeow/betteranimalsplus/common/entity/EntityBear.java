package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.betteranimalsplus.common.entity.ai.EntityAIEatBerries;
import dev.itsmeow.betteranimalsplus.common.entity.ai.FollowParentGoalButNotStupid;
import dev.itsmeow.betteranimalsplus.common.entity.ai.HungerNearestAttackableTargetGoal;
import dev.itsmeow.betteranimalsplus.common.entity.util.IDropHead;
import dev.itsmeow.betteranimalsplus.common.entity.util.IHaveHunger;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModLootTables;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;

public class EntityBear extends Animal implements IDropHead<EntityBear>, IHaveHunger<EntityBear> {
    private static final EntityDataAccessor<Boolean> IS_STANDING = SynchedEntityData.defineId(EntityBear.class, EntityDataSerializers.BOOLEAN);
    private float clientSideStandAnimation0;
    private float clientSideStandAnimation;
    private int warningSoundTicks;
    private int hunger;

    public EntityBear(EntityType<? extends EntityBear> entityType, Level worldIn) {
        super(entityType, worldIn);
        this.setPathfindingMalus(BlockPathTypes.DANGER_OTHER, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.DAMAGE_OTHER, 0.0F);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new BearMeleeAttackGoal());
        this.goalSelector.addGoal(1, new BearPanicGoal());
        this.goalSelector.addGoal(2, new BreedGoal(this, 1D));
        this.goalSelector.addGoal(2, new FollowParentGoalButNotStupid(this, 1.25D, e -> !(e instanceof EntityBearNeutral)));
        this.goalSelector.addGoal(3, new EntityAIEatBerries(this, 1.0D, 12, 2));
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.targetSelector.addGoal(1, new BearHurtByTargetGoal());
        this.targetSelector.addGoal(2, new AttackPlayerGoal());
        this.targetSelector.addGoal(2, new HungerNearestAttackableTargetGoal<>(this, Salmon.class, 90, true, true, e -> true));
        this.targetSelector.addGoal(3, new HungerNearestAttackableTargetGoal<>(this, EntityDeer.class, 90, true, true, e -> true));
        this.targetSelector.addGoal(4, new HungerNearestAttackableTargetGoal<>(this, Pig.class, 90, true, true, e -> true));
        this.targetSelector.addGoal(5, new HungerNearestAttackableTargetGoal<>(this, Chicken.class, 90, true, true, e -> true));
        this.targetSelector.addGoal(6, new HungerNearestAttackableTargetGoal<>(this, Rabbit.class, 90, true, true, e -> true));
        this.targetSelector.addGoal(5, new HungerNearestAttackableTargetGoal<>(this, EntityPheasant.class, 90, true, true, e -> true));
        this.targetSelector.addGoal(3, new HungerNearestAttackableTargetGoal<>(this, Fox.class, 90, true, true, e -> true));
    }

    @Override
    protected PathNavigation createNavigation(Level worldIn) {
        return new GroundPathNavigation(this, worldIn) {
            @Override
            protected void followThePath() {
                Vec3 vector3d = this.getTempMobPos();
                this.maxDistanceToWaypoint = this.mob.getBbWidth() > 0.75F ? this.mob.getBbWidth() / 2.0F : 0.75F - this.mob.getBbWidth() / 2.0F;
                Vec3i vector3i = this.path.getNextNodePos();
                double d0 = Math.abs(this.mob.getX() - ((double)vector3i.getX() + (this.mob.getBbWidth() + 1) / 2D)); //Forge: Fix MC-94054
                double d1 = Math.abs(this.mob.getY() - (double)vector3i.getY());
                double d2 = Math.abs(this.mob.getZ() - ((double)vector3i.getZ() + (this.mob.getBbWidth() + 1) / 2D)); //Forge: Fix MC-94054
                boolean flag = d0 <= (double)this.maxDistanceToWaypoint && d2 <= (double)this.maxDistanceToWaypoint && d1 < 1.0D;
                if (flag || this.mob.canCutCorner(this.path.getNextNode().type) && this.shouldTargetNextNodeInDirection(vector3d)) {
                    this.path.advance();
                }

                this.doStuckDetection(vector3d);
            }

            private boolean shouldTargetNextNodeInDirection(Vec3 currentPosition) {
                if (this.path.getNextNodeIndex() + 1 >= this.path.getNodeCount()) {
                    return false;
                } else {
                    Vec3 vector3d = Vec3.atBottomCenterOf(this.path.getNextNodePos());
                    if (!currentPosition.closerThan(vector3d, 2.0D)) {
                        return false;
                    } else {
                        Vec3 vector3d1 = Vec3.atBottomCenterOf(this.path.getNodePos(this.path.getNextNodeIndex() + 1));
                        Vec3 vector3d2 = vector3d1.subtract(vector3d);
                        Vec3 vector3d3 = currentPosition.subtract(vector3d);
                        return vector3d2.dot(vector3d3) > 0.0D;
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
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        this.writeHunger(compound);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.readHunger(compound);
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return ItemTags.FISHES.contains(stack.getItem()) || (stack.getItem().isEdible() && stack.getItem().getFoodProperties().isMeat());
    }

    public boolean isPeaceful() {
        return level.getDifficulty() == Difficulty.PEACEFUL;
    }

    @Override
    public double getFluidJumpThreshold() {
        // max submerged
        return 0.6D;
    }

    @Override
    protected ResourceLocation getDefaultLootTable() {
        return ModLootTables.BEAR_BROWN;
    }

    @Override
    public void tick() {
        super.tick();
        if(this.tickCount % 20 == 0) {
            this.incrementHunger();
        }
        if(this.level.isClientSide) {
            if(this.clientSideStandAnimation != this.clientSideStandAnimation0) {
                this.refreshDimensions();
            }

            this.clientSideStandAnimation0 = this.clientSideStandAnimation;
            if(this.isStanding()) {
                this.clientSideStandAnimation = Mth.clamp(this.clientSideStandAnimation + 1.0F, 0.0F, 6.0F);
            } else {
                this.clientSideStandAnimation = Mth.clamp(this.clientSideStandAnimation - 1.0F, 0.0F, 6.0F);
            }
        }

        if(this.warningSoundTicks > 0) {
            --this.warningSoundTicks;
        }

    }

    public boolean isStanding() {
        return this.entityData.get(IS_STANDING);
    }

    public void setStanding(boolean standing) {
        this.entityData.set(IS_STANDING, standing);
    }

    @Environment(EnvType.CLIENT)
    public float getStandingAnimationScale(float p_189795_1_) {
        return Mth.lerp(p_189795_1_, this.clientSideStandAnimation0, this.clientSideStandAnimation) / 6.0F;
    }

    @Override
    protected float getWaterSlowDown() {
        return 0.97F;
    }

    @Override
    public EntityDimensions getDimensions(Pose poseIn) {
        if(this.clientSideStandAnimation > 0.0F) {
            float f = this.clientSideStandAnimation / 6.0F;
            float f1 = 1.0F + f;
            return super.getDimensions(poseIn).scale(1.0F, f1);
        } else {
            return super.getDimensions(poseIn);
        }
    }

    @Override
    public boolean doHurtTarget(Entity entityIn) {
        boolean flag = entityIn.hurt(DamageSource.mobAttack(this), (float) ((int) this.getAttribute(Attributes.ATTACK_DAMAGE).getValue()));
        if(flag) {
            this.doEnchantDamageEffects(this, entityIn);
        }

        return flag;
    }

    protected void playWarningSound() {
        if(this.warningSoundTicks <= 0) {
            this.playSound(SoundEvents.POLAR_BEAR_WARNING, 1.0F, 1.0F);
            this.warningSoundTicks = 40;
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.isBaby() ? SoundEvents.POLAR_BEAR_AMBIENT_BABY : SoundEvents.POLAR_BEAR_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.POLAR_BEAR_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.POLAR_BEAR_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.POLAR_BEAR_STEP, 0.15F, 1.0F);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(IS_STANDING, false);
    }

    class AttackPlayerGoal extends NearestAttackableTargetGoal<Player> {
        public AttackPlayerGoal() {
            super(EntityBear.this, Player.class, 0, true, true, null);
        }

        @Override
        public boolean canUse() {
            if(EntityBear.this.isPeaceful() || EntityBear.this.isBaby()) {
                return false;
            } else {
                if(super.canUse()) {
                    for(EntityBear bear : EntityBear.this.level.getEntitiesOfClass(EntityBear.class, EntityBear.this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {
                        if(bear.isBaby()) {
                            return true;
                        }
                    }
                }

                return false;
            }
        }

        @Override
        protected double getFollowDistance() {
            return super.getFollowDistance() * 0.5D;
        }
    }

    class BearHurtByTargetGoal extends HurtByTargetGoal {
        public BearHurtByTargetGoal() {
            super(EntityBear.this);
        }

        @Override
        public void start() {
            super.start();
            if(EntityBear.this.isBaby()) {
                this.alertOthers();
                this.stop();
            }

        }

        @Override
        protected void alertOther(Mob mobIn, LivingEntity targetIn) {
            if(mobIn instanceof EntityBear && !mobIn.isBaby() && (!(targetIn instanceof Player) || !((EntityBear) mobIn).isPeaceful())) {
                super.alertOther(mobIn, targetIn);
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
            if (distToEnemySqr <= d0 && this.isTimeToAttack()) {
                this.resetAttackCooldown();
                this.mob.doHurtTarget(enemy);
                EntityBear.this.setStanding(false);
            } else if (distToEnemySqr <= d0 * 2.0D) {
                if (this.isTimeToAttack()) {
                    EntityBear.this.setStanding(false);
                    this.resetAttackCooldown();
                }

                if (this.getTicksUntilNextAttack() <= 10) {
                    EntityBear.this.setStanding(true);
                    EntityBear.this.playWarningSound();
                }
            } else {
                this.resetAttackCooldown();
                EntityBear.this.setStanding(false);
            }

        }

        @Override
        public void stop() {
            EntityBear.this.setStanding(false);
            super.stop();
        }

        @Override
        protected double getAttackReachSqr(LivingEntity attackTarget) {
            return 8.0F + attackTarget.getBbWidth();
        }
    }

    class BearPanicGoal extends PanicGoal {
        public BearPanicGoal() {
            super(EntityBear.this, 2.0D);
        }

        @Override
        public boolean canUse() {
            return (EntityBear.this.isBaby() || EntityBear.this.isOnFire()) && super.canUse();
        }
    }

    @Override
    public boolean isInvulnerableTo(DamageSource source) {
        return super.isInvulnerableTo(source) || source == DamageSource.SWEET_BERRY_BUSH;
    }

    @Override
    public void die(DamageSource cause) {
        super.die(cause);
        this.doHeadDrop();
    }

    @Override
    public boolean removeWhenFarAway(double range) {
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
    public AgableMob getBreedOffspring(ServerLevel world, AgableMob ageable) {
        return getContainer().getEntityType().create(world);
    }

    static class GroupData implements SpawnGroupData {
        private GroupData() {
        }
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, SpawnGroupData spawnDataIn, CompoundTag dataTag) {
        this.setInitialHunger();
        if(spawnDataIn instanceof GroupData) {
            this.setAge(-24000);
        } else {
            spawnDataIn = new GroupData();
        }
        return spawnDataIn;
    }

}
