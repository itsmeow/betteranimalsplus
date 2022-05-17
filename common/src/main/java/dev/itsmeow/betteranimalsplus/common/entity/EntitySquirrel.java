package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.betteranimalsplus.common.entity.util.EntityUtil;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalWithSelectiveTypes;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.util.BiomeTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;
import java.util.Set;

public class EntitySquirrel extends EntityAnimalWithSelectiveTypes {

    protected static final EntityDataAccessor<Byte> CLIMBING = SynchedEntityData.defineId(EntitySquirrel.class, EntityDataSerializers.BYTE);
    private static final String[] ALL_TYPES = new String[] { "gray", "red", "albino" };

    private int climbTimeWithoutLog = 0;

    public EntitySquirrel(EntityType<? extends EntitySquirrel> entityType, Level worldIn) {
        super(entityType, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new PanicGoal(this, 0.72D));
        this.goalSelector.addGoal(3, new BreedGoal(this, 0.5D));
        this.goalSelector.addGoal(4, new TemptGoal(this, 0.5D, Ingredient.of(Items.WHEAT_SEEDS), false));
        this.goalSelector.addGoal(5, new AvoidEntityGoal<>(this, Player.class, 10F, 0.5D, 0.7D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 0.5D));
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
    protected PathNavigation createNavigation(Level worldIn) {
        return new WallClimberNavigation(this, worldIn);
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel world, AgeableMob ageable) {
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
    public boolean causeFallDamage(float distance, float damageMultiplier, DamageSource source) {
        return false;
    }

    @Override
    protected EntitySquirrel getBaseChild() {
        return null; // This is not used, createChild is overriden
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, SpawnGroupData livingdata, CompoundTag compound) {
        return EntityUtil.childChance(this, reason, super.finalizeSpawn(world, difficulty, reason, livingdata, compound), 0.25F);
    }

    @Override
    public String[] getTypesFor(ResourceKey<Biome> biomeKey, Biome biome, Set<BiomeTypes.Type> types, MobSpawnType reason) {
        if(types.contains(BiomeTypes.FOREST) && !types.contains(BiomeTypes.CONIFEROUS)) {
            return new String[] { "gray", "albino" };
        } else if(types.contains(BiomeTypes.CONIFEROUS) && !types.contains(BiomeTypes.SNOWY)) {
            return new String[] { "red" };
        } else {
            return ALL_TYPES;
        }
    }

    @Override
    public EntityTypeContainer<EntitySquirrel> getContainer() {
        return ModEntities.SQUIRREL;
    }

    protected boolean isAlbino() {
        return "albino".equals(this.getVariantNameOrEmpty());
    }

    public static boolean canSquirrelSpawn(EntityType<EntitySquirrel> type, ServerLevelAccessor world, MobSpawnType reason, BlockPos pos, Random rand) {
        BlockState below = world.getBlockState(pos.below());
        return Mob.checkMobSpawnRules(type, world, reason, pos, rand) || below.is(BlockTags.LEAVES) || below.is(BlockTags.LOGS);
    }
}
