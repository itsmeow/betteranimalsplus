package dev.itsmeow.betteranimalsplus.common.entity;

import com.google.common.collect.Sets;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.betteranimalsplus.common.entity.util.EntityUtil;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalWithSelectiveTypes;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModLootTables;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.IFlyingAnimal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction.Axis;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary.Type;

import java.util.Random;
import java.util.Set;
import java.util.function.Predicate;

public class EntitySongbird extends EntityAnimalWithSelectiveTypes implements IFlyingAnimal {

    protected static final DataParameter<Boolean> LANDED = EntityDataManager.defineId(EntitySongbird.class, DataSerializers.BOOLEAN);
    protected static final Set<Item> SEEDS = Sets.newHashSet(Items.WHEAT_SEEDS, Items.MELON_SEEDS, Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS);

    public EntitySongbird(EntityType<? extends EntitySongbird> entityType, World worldIn) {
        super(entityType, worldIn);
        this.moveControl = new FlyingMovementController(this, 180, true);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        Predicate<LivingEntity> avoidPredicate = input -> {
            boolean result1 = (input instanceof PlayerEntity);
            boolean result2 = !SEEDS.contains(input.getItemInHand(Hand.MAIN_HAND).getItem())
                    && !SEEDS.contains(input.getItemInHand(Hand.OFF_HAND).getItem());
            return result1 && result2;
        };
        this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, PlayerEntity.class, avoidPredicate, 10F, 0.8D,
                1D, e -> true));
        this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(4, new BreedGoal(this, 0.4F));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomFlyingGoal(this, 1.0D));
    }

    @Override
    public boolean checkSpawnRules(IWorld world, SpawnReason reason) {
        int i = MathHelper.floor(this.getX());
        int j = MathHelper.floor(this.getBoundingBox().minY);
        int k = MathHelper.floor(this.getZ());
        BlockPos blockpos = new BlockPos(i, j, k);
        if(world instanceof World && !((World) world).isLoaded(new BlockPos(blockpos))) {
            Block block = this.level.getBlockState(blockpos.below()).getBlock();
            return block instanceof LeavesBlock || block == Blocks.GRASS || block.is(BlockTags.LOGS)
                    || block == Blocks.AIR && this.level.getMaxLocalRawBrightness(blockpos) > 8 && super.checkSpawnRules(world, reason);
        } else {
            return super.checkSpawnRules(world, reason);
        }
    }

    @Override
    protected PathNavigator createNavigation(World worldIn) {
        FlyingPathNavigator pathnavigateflying = new FlyingPathNavigator(this, worldIn);
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
    public void move(MoverType typeIn, Vector3d pos) {
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
    public boolean causeFallDamage(float distance, float damageMultiplier) {
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
    protected float playFlySound(float p_191954_1_) {
        this.playSound(SoundEvents.PARROT_FLY, 0.15F, 1.0F);
        return p_191954_1_;
    }

    @Override
    protected boolean makeFlySound() {
        return true;
    }

    @Override
    public SoundCategory getSoundSource() {
        return SoundCategory.NEUTRAL;
    }

    @Override
    public boolean isPushable() {
        return true;
    }

    public boolean isFlying() {
        return !this.entityData.get(LANDED);
    }

    @Override
    public boolean canMate(AnimalEntity otherAnimal) {
        if (super.canMate(otherAnimal)) {
            if (!(otherAnimal instanceof EntitySongbird)) {
                return false;
            }
            return !this.getVariantNameOrEmpty().isEmpty() && !((EntitySongbird) otherAnimal).getVariantNameOrEmpty().isEmpty() && ((EntitySongbird) otherAnimal).getVariantNameOrEmpty().equals(this.getVariantNameOrEmpty());
        }
        return false;
    }

    @Override
    protected ResourceLocation getDefaultLootTable() {
        return ModLootTables.songbird;
    }

    @Override
    protected EntitySongbird getBaseChild() {
        return getContainer().getEntityType().create(level);
    }

    @Override
    public String[] getTypesFor(RegistryKey<Biome> biomeKey, Biome biome, Set<Type> types, SpawnReason reason) {
        if(types.contains(Type.FOREST) && !types.contains(Type.CONIFEROUS)) {
            return new String[] { "2", "small_2", "small_3", "small_4" };
        } else if(types.contains(Type.CONIFEROUS) && !types.contains(Type.SNOWY)) {
            return new String[] { "1", "small_5", "small_6" };
        } else if(types.contains(Type.CONIFEROUS) && types.contains(Type.SNOWY)) {
            return new String[] { "3", "4", "small_1" };
        } else {
            return new String[] { "1", "2", "3", "4", "small_1", "small_2", "small_3", "small_4", "small_5", "small_6" };
        }
    }

    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, ILivingEntityData livingdata, CompoundNBT compound) {
        return EntityUtil.childChance(this, reason, super.finalizeSpawn(world, difficulty, reason, livingdata, compound), 0.25F);
    }

    @Override
    public EntityTypeContainer<EntitySongbird> getContainer() {
        return ModEntities.SONGBIRD;
    }

    public static boolean canSongbirdSpawn(EntityType<EntitySongbird> type, IServerWorld world, SpawnReason reason, BlockPos pos, Random rand) {
        Block below = world.getBlockState(pos.below()).getBlock();
        return MobEntity.checkMobSpawnRules(type, world, reason, pos, rand) || below.is(BlockTags.LEAVES) || below.is(BlockTags.LOGS);
    }
}
