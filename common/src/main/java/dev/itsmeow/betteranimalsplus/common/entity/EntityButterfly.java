package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalWithTypes;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalWithTypesAndSizeContainable;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModResources;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.util.BiomeTypes;
import dev.itsmeow.imdlib.entity.util.EntityTypeContainerContainable;
import dev.architectury.utils.NbtType;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.Vec3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class EntityButterfly extends EntityAnimalWithTypesAndSizeContainable {

    private static final EntityDataAccessor<Boolean> HAS_NECTAR = SynchedEntityData.defineId(EntityButterfly.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> LANDED = SynchedEntityData.defineId(EntityButterfly.class, EntityDataSerializers.INT);
    private static final TargetingConditions playerPredicate = TargetingConditions.forNonCombat().range(4.0D).ignoreLineOfSight();
    private BlockPos targetPosition;
    private int rainTicks = 0;
    private int ticksUntilNextGrow = 0;

    public EntityButterfly(EntityType<? extends EntityButterfly> entityType, Level worldIn) {
        super(entityType, worldIn);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(LANDED, 1);
        this.entityData.define(HAS_NECTAR, false);
    }

    @Override
    public boolean isInvulnerableTo(DamageSource source) {
        return super.isInvulnerableTo(source) || source == DamageSource.SWEET_BERRY_BUSH;
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    protected void doPush(Entity entityIn) {
    }

    @Override
    protected void pushEntities() {
    }

    public boolean isLanded() {
        return this.entityData.get(LANDED) != 1;
    }

    public int getLandedInteger() {
        return this.entityData.get(LANDED);
    }

    public void setLanded(Direction direction) {
        if(direction == Direction.UP) {
            throw new RuntimeException("Invalid landing direction!");
        }
        this.entityData.set(LANDED, direction.ordinal());
    }

    public void setNotLanded() {
        this.entityData.set(LANDED, 1);
        this.teleportTo(this.blockPosition().getX() + 0.5D, this.blockPosition().getY() + 0.5D, this.blockPosition().getZ() + 0.5D);
    }

    public boolean hasNectar() {
        return this.entityData.get(HAS_NECTAR);
    }

    public void setHasNectar(boolean value) {
        this.entityData.set(HAS_NECTAR, value);
    }

    @Override
    public MobType getMobType() {
        return MobType.ARTHROPOD;
    }

    @Override
    public void tick() {
        super.tick();
        if(this.isLanded()) {
            this.setDeltaMovement(Vec3.ZERO);
            if(Direction.from3DDataValue(this.getLandedInteger()) != Direction.DOWN) {
                double x = Math.floor(this.getX()) + 0.5D;
                double z = Math.floor(this.getZ()) + 0.5D;
                BlockPos pos = new BlockPos(x, Math.floor(this.getY()) + 0.5D, z);
                BlockPos offset = pos.relative(Direction.from3DDataValue(this.getLandedInteger()));
                BlockPos diff = pos.subtract(offset);
                this.teleportTo(x - ((double) diff.getX()) / 2.778D, Math.floor(this.getY()) + 0.5D, z - ((double) diff.getZ()) / 2.778D);
                this.setYRot(0);
                this.yHeadRot = 0;
            } else {
                this.teleportTo(this.getX(), Math.floor(this.getY()), this.getZ());
            }
        } else {
            this.setDeltaMovement(this.getDeltaMovement().multiply(1.0D, 0.6D, 1.0D));
        }
        if(this.hasNectar() && this.random.nextFloat() < 0.05F) {
            for(int i = 0; i < this.random.nextInt(2) + 1; ++i) {
                addParticle(this.level, this.getX() - (double) 0.3F, this.getX() + (double) 0.3F, this.getZ() - (double) 0.3F, this.getZ() + (double) 0.3F, this.getY() + 0.5D, new BlockParticleOption(ParticleTypes.FALLING_DUST, Blocks.SAND.defaultBlockState()));
            }
        }
    }

    private static void addParticle(Level worldIn, double xStart, double xEnd, double zStart, double zEnd, double posY, ParticleOptions particleData) {
        worldIn.addParticle(particleData, Mth.lerp(worldIn.random.nextDouble(), xStart, xEnd), posY, Mth.lerp(worldIn.random.nextDouble(), zStart, zEnd), 0.0D, 0.0D, 0.0D);
    }

    public boolean isRainingAt(BlockPos position) {
        if (!level.isRaining()) {
           return false;
        } else if(position == null) {
            return true;
        } else if (!level.isLoaded(position) || !level.canSeeSkyFromBelowWater(position)) {
           return false;
        } else {
           return level.getBiome(position).getPrecipitation() == Biome.Precipitation.RAIN;
        }
     }

    @Override
    protected void customServerAiStep() {
        super.customServerAiStep();
        BlockPos blockpos = this.blockPosition();
        if(this.isLanded()) {
            BlockPos offset = blockpos.relative(Direction.from3DDataValue(this.getLandedInteger()));
            if(this.level.getBlockState(offset).isRedstoneConductor(this.level, offset)) {
                if(this.level.getNearestPlayer(playerPredicate, this) != null || this.getRandom().nextInt(500) == 0) {
                    this.setNotLanded();
                }
            } else {
                this.setNotLanded();
            }
        }
        if(isRainingAt(this.blockPosition())) {
            rainTicks++;
            if(this.isLanded()) {
                this.setNotLanded();
            }
            if(this.targetPosition == null || isRainingAt(this.targetPosition)) {
                this.targetPosition = tryToFindPosition(pos -> {
                    if(pos != null && !isRainingAt(pos) && level.isEmptyBlock(pos)) {
                        boolean found = false;
                        for(Direction direction : Direction.values()) {
                            if(direction != Direction.UP) {
                                BlockPos offset = pos.relative(direction);
                                if(level.getBlockState(offset).isRedstoneConductor(level, offset)) {
                                    found = true;
                                }
                            }
                        }
                        return found;
                    }
                    return false;
                });
            }
            if(this.getRandom().nextFloat() < 0.0025F && rainTicks > 100) {
                this.hurt(DamageSource.DROWN, 1F);
            }
        } else {
            rainTicks = 0;
            if(this.targetPosition == null || this.random.nextInt(30) == 0 || (this.targetPosition.closerThan(this.position(), 1.0D) && !isFlowers(this.targetPosition) && !isGrowable(this.targetPosition))) {
                if(level.isRaining() && level.getBiome(this.blockPosition()).getPrecipitation() == Biome.Precipitation.RAIN) {
                    // attempt to land
                    boolean found = false;
                    for(Direction direction : Direction.values()) {
                        if(direction != Direction.UP) {
                            BlockPos offset = blockpos.relative(direction);
                            if(level.getBlockState(offset).isRedstoneConductor(level, offset) && level.isEmptyBlock(blockpos)) {
                                this.setLanded(direction);
                                this.targetPosition = null;
                                found = true;
                            }
                        }
                    }
                    if(!found) {
                        BlockPos temp = new BlockPos(this.getX() + (double) this.random.nextInt(5) - (double) this.random.nextInt(5), this.getY() + (double) this.random.nextInt(4) - 1.0D, this.getZ() + (double) this.random.nextInt(5) - (double) this.random.nextInt(5));
                        if(!isRainingAt(temp)) {
                            this.targetPosition = temp;
                        }
                    }
                } else {
                    BlockPos destinationBlock = null;
                    boolean ranGrowable = false;
                    if(this.ticksUntilNextGrow <= 0) {
                        if(!this.hasNectar()) {
                            destinationBlock = tryToFindPosition(this::isFlowers);
                        } else {
                            destinationBlock = tryToFindPosition(this::isGrowable);
                            ranGrowable = true;
                        }
                    } else {
                        this.ticksUntilNextGrow--;
                    }
                    if(destinationBlock != null) {
                        this.targetPosition = destinationBlock;
                        this.setNotLanded();
                    } else {
                        boolean found = false;
                        if(this.level.getNearestPlayer(playerPredicate, this) == null && (!this.hasNectar() || ranGrowable)) {
                            for(Direction direction : Direction.values()) {
                                if(direction != Direction.UP) {
                                    BlockPos offset = blockpos.relative(direction);
                                    if(level.getBlockState(offset).isRedstoneConductor(level, offset) && level.isEmptyBlock(blockpos)) {
                                        this.setLanded(direction);
                                        this.targetPosition = null;
                                        found = true;
                                    }
                                }
                            }
                        }
                        if(!found) {
                            int attempts = 0;
                            while(attempts < 5 && (targetPosition == null || !level.isEmptyBlock(targetPosition))) {
                                this.targetPosition = new BlockPos(this.getX() + (double) this.random.nextInt(5) - (double) this.random.nextInt(5), this.getY() + (double) this.random.nextInt(4) - 1.0D, this.getZ() + (double) this.random.nextInt(5) - (double) this.random.nextInt(5));
                                attempts++;
                            }
                        }
                    }
                }
            }
            if(this.targetPosition != null && this.targetPosition.closerThan(this.position(), 1.0D)) {
                if(this.isFlowers(targetPosition) && !this.hasNectar()) {
                    this.setHasNectar(true);
                    this.targetPosition = null;
                } else if(this.isGrowable(targetPosition) && this.hasNectar()) {
                    BlockState blockstate = this.level.getBlockState(targetPosition);
                    Block block = blockstate.getBlock();
                    IntegerProperty age = null;
                    if(block instanceof CropBlock) {
                        age = ((CropBlock) block).getAgeProperty();
                    } else if(block instanceof StemBlock) {
                        age = StemBlock.AGE;
                    } else if(block == Blocks.SWEET_BERRY_BUSH) {
                        age = SweetBerryBushBlock.AGE;
                    }
                    if(age != null) {
                        level.levelEvent(2005, targetPosition, 0);
                        level.setBlockAndUpdate(targetPosition, blockstate.setValue(age, blockstate.getValue(age) + 1));
                        this.setHasNectar(false);
                        this.targetPosition = null;
                        this.ticksUntilNextGrow = this.getRandom().nextInt(150 * 20) + (30 * 20);
                    }
                } else {
                    this.targetPosition = null;
                }
            }
        }
        if(!this.isLanded() && targetPosition != null) {
            if(this.isInWall()) {
                this.targetPosition = null;
                this.setDeltaMovement(0, 0, 0);
            } else {
                double d0 = (double) this.targetPosition.getX() + 0.5D - this.getX();
                double d1 = (double) this.targetPosition.getY() + 0.1D - this.getY();
                double d2 = (double) this.targetPosition.getZ() + 0.5D - this.getZ();
                Vec3 vec3d = this.getDeltaMovement();
                Vec3 vec3d1 = vec3d.add((Math.signum(d0) * 0.5D - vec3d.x) * (double) 0.1F, (Math.signum(d1) * (double) 0.7F - vec3d.y) * (double) 0.1F, (Math.signum(d2) * 0.5D - vec3d.z) * (double) 0.1F);
                this.setDeltaMovement(vec3d1);
                float f = (float) (Mth.atan2(vec3d1.z, vec3d1.x) * (double) (180F / (float) Math.PI)) - 90.0F;
                float f1 = Mth.wrapDegrees(f - this.getYRot());
                this.zza = 0.5F;
                this.setYRot(this.getYRot() + f1);
            }
        }
    }

    private BlockPos tryToFindPosition(Predicate<BlockPos> condition) {
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        int i = 12;
        int j = 2;
        for(int k = 0; k <= j; k = k > 0 ? -k : 1 - k) {
            for(int l = 0; l < i; ++l) {
                for(int i1 = 0; i1 <= l; i1 = i1 > 0 ? -i1 : 1 - i1) {
                    for(int j1 = i1 < l && i1 > -l ? l : 0; j1 <= l; j1 = j1 > 0 ? -j1 : 1 - j1) {
                        pos.set(this.blockPosition()).move(i1, k - 1, j1);
                        if(condition.test(pos.immutable())) {
                            return pos.immutable();
                        }
                    }
                }
            }
        }
        return null;
    }

    private boolean isGrowable(BlockPos blockpos) {
        BlockState blockstate = this.level.getBlockState(blockpos);
        Block block = blockstate.getBlock();
        boolean flag = false;
        if(blockstate.is(ModResources.Tags.Blocks.BUTTERFLY_GROWABLES)) {
            if(block instanceof CropBlock) {
                CropBlock cropsblock = (CropBlock) block;
                if(!cropsblock.isMaxAge(blockstate)) {
                    flag = true;

                }
            } else if(block instanceof StemBlock) {
                int j = blockstate.getValue(StemBlock.AGE);
                if(j < 7) {
                    flag = true;

                }
            } else if(block == Blocks.SWEET_BERRY_BUSH) {
                int k = blockstate.getValue(SweetBerryBushBlock.AGE);
                if(k < 3) {
                    flag = true;

                }
            }
        }
        return flag;
    }

    private boolean isFlowers(BlockPos pos) {
        BlockState state = this.level.getBlockState(pos);
        boolean isFlower = this.level.isLoaded(pos) && state.is(BlockTags.FLOWERS);
        if(isFlower) {
            if(state.is(BlockTags.TALL_FLOWERS)) {
                if(state.getBlock() == Blocks.SUNFLOWER) {
                    return state.getValue(DoublePlantBlock.HALF) == DoubleBlockHalf.UPPER;
                } else {
                    return true;
                }
            } else {
                return state.is(BlockTags.SMALL_FLOWERS);
            }
        }
        return false;
    }

    @Override
    protected MovementEmission getMovementEmission() {
        return MovementEmission.NONE;
    }

    @Override
    public boolean causeFallDamage(float f, float g, DamageSource damageSource) {
        return false;
    }

    @Override
    protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
    }

    @Override
    public boolean isIgnoringBlockTriggers() {
        return true;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if(this.isInvulnerableTo(source)) {
            return false;
        } else {
            if(!this.level.isClientSide && this.isLanded()) {
                this.setNotLanded();
            }
            return super.hurt(source, amount);
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.entityData.set(LANDED, compound.getInt("Landed"));
        this.entityData.set(HAS_NECTAR, compound.getBoolean("HasNectar"));
        this.ticksUntilNextGrow = compound.getInt("TimeUntilNextGrow");
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Landed", this.entityData.get(LANDED));
        compound.putBoolean("HasNectar", this.entityData.get(HAS_NECTAR));
        compound.putInt("TimeUntilNextGrow", this.ticksUntilNextGrow);
    }

    @Override
    protected float getRandomizedSize() {
        return (this.random.nextInt(30) + 1F) / 100F + 0.15F;
    }

    @Override
    public boolean canBeLeashed(Player player) {
        return false;
    }

    @Override
    public EntityTypeContainer<? extends EntityButterfly> getContainer() {
        return ModEntities.BUTTERFLY;
    }

    @Override
    protected EntityAnimalWithTypes getBaseChild() {
        return null;
    }

    @Override
    public EntityTypeContainerContainable<?, ?> getContainableContainer() {
        return ModEntities.BUTTERFLY;
    }

    @Override
    public void setContainerData(ItemStack bucket) {
        super.setContainerData(bucket);
        CompoundTag tag = bucket.getTag();
        tag.putFloat("SizeTag", this.entityData.get(SIZE));
        tag.putBoolean("HasNectar", this.entityData.get(HAS_NECTAR));
        bucket.setTag(tag);
    }

    @Override
    public void readFromContainerTag(CompoundTag tag) {
        super.readFromContainerTag(tag);
        if(tag.contains("SizeTag")) {
            this.setSize(tag.getFloat("SizeTag"));
            this.setHasNectar(tag.getBoolean("HasNectar"));
        }
    }

    public static void bottleTooltip(EntityTypeContainer<? extends Mob> container, ItemStack stack, Level worldIn, List<Component> tooltip) {
        CompoundTag tag = stack.getTag();
        if(tag != null) {
            if(tag.contains("SizeTag", NbtType.FLOAT)) {
                tooltip.add(new TextComponent("Size: " + tag.getFloat("SizeTag")).withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY));
            }
            if(tag.contains("HasNectar") && tag.getBoolean("HasNectar")) {
                tooltip.add(new TranslatableComponent("tooltip.betteranimalsplus.nectar").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.YELLOW));
            }
        }
    }

    public static ResourceKey<Biome>[] getSpawnBiomes() {
        Set<ResourceKey<Biome>> set = new HashSet<>();
        set.addAll(BiomeTypes.getBiomes(BiomeTypes.FOREST));
        set.addAll(BiomeTypes.getBiomes(BiomeTypes.JUNGLE));
        set.addAll(BiomeTypes.getBiomes(BiomeTypes.MAGICAL));
        set.removeIf(b -> BiomeTypes.COLD.hasType(b) || !BiomeTypes.OVERWORLD.hasType(b));
        return set.toArray(new ResourceKey[0]);
    }
}