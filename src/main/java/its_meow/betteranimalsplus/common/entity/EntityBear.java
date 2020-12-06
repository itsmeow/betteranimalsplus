package its_meow.betteranimalsplus.common.entity;

import com.google.common.base.Predicates;
import dev.itsmeow.imdlib.entity.util.EntityTypeContainer;
import its_meow.betteranimalsplus.common.entity.ai.EntityAIEatBerries;
import its_meow.betteranimalsplus.common.entity.ai.HungerNearestAttackableTargetGoal;
import its_meow.betteranimalsplus.common.entity.util.IDropHead;
import its_meow.betteranimalsplus.common.entity.util.IHaveHunger;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModLootTables;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.passive.fish.SalmonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class EntityBear extends AnimalEntity implements IDropHead<EntityBear>, IHaveHunger<EntityBear> {
    private static final DataParameter<Boolean> IS_STANDING = EntityDataManager.createKey(EntityBear.class, DataSerializers.BOOLEAN);
    private float clientSideStandAnimation0;
    private float clientSideStandAnimation;
    private int warningSoundTicks;
    private int hunger;

    public EntityBear(World worldIn) {
        super(ModEntities.BROWN_BEAR.entityType, worldIn);
        this.setPathPriority(PathNodeType.DANGER_OTHER, 0.0F);
        this.setPathPriority(PathNodeType.DAMAGE_OTHER, 0.0F);
    }

    public EntityBear(EntityType<? extends EntityBear> type, World worldIn) {
        super(type, worldIn);
        this.setPathPriority(PathNodeType.DANGER_OTHER, 0.0F);
        this.setPathPriority(PathNodeType.DAMAGE_OTHER, 0.0F);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this) {
            public boolean shouldExecute() {
                return EntityBear.this.isInWater() && EntityBear.this.getSubmergedHeight() > 0.6 || EntityBear.this.isInLava();
            }
        });
        this.goalSelector.addGoal(1, new EntityBear.MeleeAttackGoal());
        this.goalSelector.addGoal(1, new EntityBear.PanicGoal());
        this.goalSelector.addGoal(2, new BreedGoal(this, 1D));
        this.goalSelector.addGoal(2, new FollowParentGoal(this, 1.25D));
        this.goalSelector.addGoal(3, new EntityAIEatBerries(this, 1.0D, 12, 2));
        this.goalSelector.addGoal(5, new RandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.targetSelector.addGoal(1, new EntityBear.HurtByTargetGoal());
        this.targetSelector.addGoal(2, new EntityBear.AttackPlayerGoal());
        this.targetSelector.addGoal(2, new HungerNearestAttackableTargetGoal<>(this, SalmonEntity.class, 90, true, true, Predicates.alwaysTrue()));
        this.targetSelector.addGoal(3, new HungerNearestAttackableTargetGoal<>(this, EntityDeer.class, 90, true, true, Predicates.alwaysTrue()));
        this.targetSelector.addGoal(4, new HungerNearestAttackableTargetGoal<>(this, PigEntity.class, 90, true, true, Predicates.alwaysTrue()));
        this.targetSelector.addGoal(5, new HungerNearestAttackableTargetGoal<>(this, ChickenEntity.class, 90, true, true, Predicates.alwaysTrue()));
        this.targetSelector.addGoal(6, new HungerNearestAttackableTargetGoal<>(this, RabbitEntity.class, 90, true, true, Predicates.alwaysTrue()));
        this.targetSelector.addGoal(5, new HungerNearestAttackableTargetGoal<>(this, EntityPheasant.class, 90, true, true, Predicates.alwaysTrue()));
        this.targetSelector.addGoal(3, new HungerNearestAttackableTargetGoal<>(this, FoxEntity.class, 90, true, true, Predicates.alwaysTrue()));
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
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
        this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_SPEED);
        this.getAttribute(SharedMonsterAttributes.ATTACK_SPEED).setBaseValue(1D);
    }

    @Override
    @Nullable
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
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float) ((int) this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue()));
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
            super(EntityBear.this, PlayerEntity.class, 0, true, true, (Predicate<LivingEntity>) null);
        }

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

        protected double getTargetDistance() {
            return super.getTargetDistance() * 0.5D;
        }
    }

    class HurtByTargetGoal extends net.minecraft.entity.ai.goal.HurtByTargetGoal {
        public HurtByTargetGoal() {
            super(EntityBear.this);
        }

        public void startExecuting() {
            super.startExecuting();
            if(EntityBear.this.isChild()) {
                this.alertOthers();
                this.resetTask();
            }

        }

        protected void setAttackTarget(MobEntity mobIn, LivingEntity targetIn) {
            if(mobIn instanceof EntityBear && !mobIn.isChild() && (!(targetIn instanceof PlayerEntity) || !((EntityBear) mobIn).isPeaceful())) {
                super.setAttackTarget(mobIn, targetIn);
            }

        }
    }

    class MeleeAttackGoal extends net.minecraft.entity.ai.goal.MeleeAttackGoal {
        public MeleeAttackGoal() {
            super(EntityBear.this, 1.25D, true);
        }

        protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
            double d0 = this.getAttackReachSqr(enemy);
            if(distToEnemySqr <= d0 && this.attackTick <= 0) {
                this.attackTick = 20;
                this.attacker.attackEntityAsMob(enemy);
                EntityBear.this.setStanding(false);
            } else if(distToEnemySqr <= d0 * 2.0D) {
                if(this.attackTick <= 0) {
                    EntityBear.this.setStanding(false);
                    this.attackTick = 20;
                }

                if(this.attackTick <= 10) {
                    EntityBear.this.setStanding(true);
                    EntityBear.this.playWarningSound();
                }
            } else {
                this.attackTick = 20;
                EntityBear.this.setStanding(false);
            }

        }

        public void resetTask() {
            EntityBear.this.setStanding(false);
            super.resetTask();
        }

        protected double getAttackReachSqr(LivingEntity attackTarget) {
            return (double) (8.0F + attackTarget.getWidth());
        }
    }

    class PanicGoal extends net.minecraft.entity.ai.goal.PanicGoal {
        public PanicGoal() {
            super(EntityBear.this, 2.0D);
        }

        public boolean shouldExecute() {
            return !EntityBear.this.isChild() && !EntityBear.this.isBurning() ? false : super.shouldExecute();
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
    public EntityTypeContainer<?> getContainer() {
        return ModEntities.BROWN_BEAR;
    }

    @Override
    public AgeableEntity createChild(AgeableEntity ageable) {
        return new EntityBear(this.world);
    }

    static class GroupData implements ILivingEntityData {
        private GroupData() {
        }
    }

    @Override
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        this.setInitialHunger();
        if(spawnDataIn instanceof GroupData) {
            this.setGrowingAge(-24000);
        } else {
            spawnDataIn = new GroupData();
        }
        return spawnDataIn;
    }

}
