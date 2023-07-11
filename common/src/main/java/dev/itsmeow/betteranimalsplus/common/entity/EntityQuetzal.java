package dev.itsmeow.betteranimalsplus.common.entity;

import com.google.common.collect.Sets;
import dev.itsmeow.betteranimalsplus.common.entity.util.EntityUtil;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.interfaces.IContainerEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction.Axis;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.Set;
import java.util.function.Predicate;

public class EntityQuetzal extends Animal implements FlyingAnimal, IContainerEntity<EntityQuetzal> {

    protected static final EntityDataAccessor<Boolean> LANDED = SynchedEntityData.defineId(EntityQuetzal.class, EntityDataSerializers.BOOLEAN);
    protected static final Set<Item> SEEDS = Sets.newHashSet(Items.WHEAT_SEEDS, Items.MELON_SEEDS, Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS);
    public float flapSpeed = 1.0F;
    private float nextFlap = 1.0F;

    public EntityQuetzal(EntityType<? extends EntityQuetzal> entityType, Level worldIn) {
        super(entityType, worldIn);
        this.moveControl = new FlyingMoveControl(this, 180, true);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        Predicate<LivingEntity> avoidPredicate = input -> {
            boolean result1 = (input instanceof Player);
            boolean result2 = !SEEDS.contains(input.getItemInHand(InteractionHand.MAIN_HAND).getItem())
                    && !SEEDS.contains(input.getItemInHand(InteractionHand.OFF_HAND).getItem());
            return result1 && result2;
        };
        this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, Player.class, avoidPredicate, 10F, 0.8D,
                1D, e -> true));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomFlyingGoal(this, 1.0D));
    }

    @Override
    public boolean checkSpawnRules(LevelAccessor world, MobSpawnType reason) {
        int i = Mth.floor(this.getX());
        int j = Mth.floor(this.getBoundingBox().minY);
        int k = Mth.floor(this.getZ());
        BlockPos blockpos = new BlockPos(i, j, k);
        if(world instanceof Level && !((Level) world).isLoaded(new BlockPos(blockpos))) {
            BlockState state = this.level.getBlockState(blockpos.below());
            Block block = state.getBlock();
            return block instanceof LeavesBlock || block == Blocks.GRASS || state.is(BlockTags.LOGS)
                    || block == Blocks.AIR && this.level.getMaxLocalRawBrightness(blockpos) > 8 && super.checkSpawnRules(world, reason);
        } else {
            return super.checkSpawnRules(world, reason);
        }
    }

    @Override
    protected PathNavigation createNavigation(Level worldIn) {
        FlyingPathNavigation pathnavigateflying = new FlyingPathNavigation(this, worldIn);
        pathnavigateflying.setCanOpenDoors(false);
        pathnavigateflying.setCanFloat(true);
        pathnavigateflying.setCanPassDoors(true);
        return pathnavigateflying;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(LANDED, true);
    }

    @Override
    public void move(MoverType typeIn, Vec3 pos) {
        super.move(typeIn, pos);
        if(level.isLoaded(this.blockPosition().below())) {
            BlockState state = this.level.getBlockState(this.blockPosition().below());
            this.entityData.set(LANDED, this.onGround || this.getY() == Math.floor(this.getY()) && state.getBlockSupportShape(this.level, this.blockPosition().below()).max(Axis.Y) == 1 && state.isCollisionShapeFullBlock(level, this.blockPosition().below()));
        }
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return SEEDS.contains(stack.getItem());
    }

    @Override
    public boolean causeFallDamage(float distance, float damageMultiplier, DamageSource source) {
        return false;
    }

    @Override
    protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.PARROT_STEP, 0.15F, 1.0F);
    }

    @Override
    protected void onFlap() {
        this.playSound(SoundEvents.PARROT_FLY, 0.15F, 1.0F);
        this.nextFlap = this.flyDist + this.flapSpeed / 2.0F;
    }

    @Override
    protected boolean isFlapping() {
        return this.flyDist > this.nextFlap;
    }

    @Override
    public SoundSource getSoundSource() {
        return SoundSource.NEUTRAL;
    }

    @Override
    public boolean isPushable() {
        return true;
    }

    @Override
    public boolean isFlying() {
        return !this.entityData.get(LANDED);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, SpawnGroupData livingdata, CompoundTag compound) {
        return EntityUtil.childChance(this, reason, super.finalizeSpawn(world, difficulty, reason, livingdata, compound), 0.25F);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }

    @Override
    public EntityQuetzal getImplementation() {
        return this;
    }

    @Override
    public EntityTypeContainer<EntityQuetzal> getContainer() {
        return ModEntities.QUETZAL;
    }

    public static boolean canQuetzalSpawn(EntityType<EntityQuetzal> type, ServerLevelAccessor world, MobSpawnType reason, BlockPos pos, RandomSource rand) {
        return Mob.checkMobSpawnRules(type, world, reason, pos, rand) && pos.getY()>70;
    }
}
