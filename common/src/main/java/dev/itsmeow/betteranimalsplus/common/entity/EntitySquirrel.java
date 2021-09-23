package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.betteranimalsplus.common.entity.util.EntityUtil;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalWithSelectiveTypes;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.ClimberPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

import java.util.Random;
import java.util.Set;

public class EntitySquirrel extends EntityAnimalWithSelectiveTypes {

    protected static final DataParameter<Byte> CLIMBING = EntityDataManager.defineId(EntitySquirrel.class, DataSerializers.BYTE);

    private int climbTimeWithoutLog = 0;

    public EntitySquirrel(EntityType<? extends EntitySquirrel> entityType, World worldIn) {
        super(entityType, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(2, new PanicGoal(this, 0.72D));
        this.goalSelector.addGoal(3, new BreedGoal(this, 0.5D));
        this.goalSelector.addGoal(4, new TemptGoal(this, 0.5D, Ingredient.of(Items.WHEAT_SEEDS), false));
        this.goalSelector.addGoal(5, new AvoidEntityGoal<>(this, PlayerEntity.class, 10F, 0.5D, 0.7D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 0.5D));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(EntitySquirrel.CLIMBING, (byte) 0);
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void tick() {
        super.tick();

        if (!this.level.isClientSide) {
            boolean nearLog = false;
            for (Direction facing : Direction.values()) {
                BlockPos pos = this.blockPosition().relative(facing);
                Block block = this.level.getBlockState(pos).getBlock();
                if (block == Blocks.ACACIA_LOG || block == Blocks.BIRCH_LOG || block == Blocks.DARK_OAK_LOG
                        || block == Blocks.JUNGLE_LOG || block == Blocks.OAK_LOG || block == Blocks.SPRUCE_LOG) {
                    nearLog = true;
                }
            }
            this.setBesideClimbableBlock(
                    this.horizontalCollision && nearLog || this.horizontalCollision && this.climbTimeWithoutLog < 15);
            if (this.horizontalCollision && !nearLog) {
                this.climbTimeWithoutLog++;
            } else if (this.climbTimeWithoutLog > 0 || this.horizontalCollision) {
                this.climbTimeWithoutLog = 0;
            }
        }
    }

    @Override
    public boolean onClimbable() {
        return this.isBesideClimbableBlock();
    }

    /**
     * Returns true if the WatchableObject (Byte) is 0x01 otherwise returns false.
     * The WatchableObject is updated using setBesideClimableBlock.
     */
    public boolean isBesideClimbableBlock() {
        return (this.entityData.get(EntitySquirrel.CLIMBING) & 1) != 0;
    }

    /**
     * Updates the WatchableObject (Byte) created in registerData(), setting it to
     * 0x01 if par1 is true or 0x00 if it is false.
     */
    public void setBesideClimbableBlock(boolean climbing) {
        byte b0 = this.entityData.get(EntitySquirrel.CLIMBING);

        if (climbing) {
            b0 = (byte) (b0 | 1);
        } else {
            b0 = (byte) (b0 & -2);
        }

        this.entityData.set(EntitySquirrel.CLIMBING, b0);
    }

    @Override
    protected PathNavigator createNavigation(World worldIn) {
        return new ClimberPathNavigator(this, worldIn);
    }

    @Override
    public AgeableEntity getBreedOffspring(ServerWorld world, AgeableEntity ageable) {
        EntitySquirrel squirrel = getContainer().getEntityType().create(world);
        if (ageable instanceof EntitySquirrel) {
            EntitySquirrel other = (EntitySquirrel) ageable;
            if ((this.isAlbino() || other.isAlbino()) && !this.getVariantNameOrEmpty().equals(other.getVariantNameOrEmpty())) {
                squirrel.setType(this.isAlbino() ? other.getVariant().get() : this.getVariant().get());
            } else {
                squirrel.setType(this.random.nextBoolean() ? this.getVariant().get() : other.getVariant().get());
            }
        }
        return squirrel;
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.getItem() == Items.WHEAT_SEEDS || stack.getItem() == Items.BEETROOT_SEEDS
                || stack.getItem() == Items.MELON_SEEDS || stack.getItem() == Items.PUMPKIN_SEEDS;
    }
    
    @Override
    public boolean causeFallDamage(float distance, float damageMultiplier) {
        return false;
    }

    @Override
    protected EntitySquirrel getBaseChild() {
        return null; // This is not used, createChild is overriden
    }

    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, ILivingEntityData livingdata, CompoundNBT compound) {
        return EntityUtil.childChance(this, reason, super.finalizeSpawn(world, difficulty, reason, livingdata, compound), 0.25F);
    }

    @Override
    public String[] getTypesFor(RegistryKey<Biome> biomeKey, Biome biome, Set<BiomeDictionary.Type> types, SpawnReason reason) {
        if(types.contains(Type.FOREST) && !types.contains(Type.CONIFEROUS)) {
            return new String[] { "gray", "albino" };
        } else if(types.contains(Type.CONIFEROUS) && !types.contains(Type.SNOWY)) {
            return new String[] { "red" };
        } else {
            return new String[] { "gray", "red", "albino" };
        }
    }

    @Override
    public EntityTypeContainer<EntitySquirrel> getContainer() {
        return ModEntities.SQUIRREL;
    }

    protected boolean isAlbino() {
        return "albino".equals(this.getVariantNameOrEmpty());
    }

    public static boolean canSquirrelSpawn(EntityType<EntitySquirrel> type, IServerWorld world, SpawnReason reason, BlockPos pos, Random rand) {
        Block below = world.getBlockState(pos.below()).getBlock();
        return MobEntity.checkMobSpawnRules(type, world, reason, pos, rand) || below.is(BlockTags.LEAVES) || below.is(BlockTags.LOGS);
    }
}
