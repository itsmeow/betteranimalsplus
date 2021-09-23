package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.util.EntityTypeContainerContainable;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalWithTypes;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalWithTypesAndSizeContainable;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModResources;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.util.Constants;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class EntityButterfly extends EntityAnimalWithTypesAndSizeContainable {

    private static final DataParameter<Boolean> HAS_NECTAR = EntityDataManager.defineId(EntityButterfly.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Integer> LANDED = EntityDataManager.defineId(EntityButterfly.class, DataSerializers.INT);
    private static final EntityPredicate playerPredicate = (new EntityPredicate()).range(4.0D).allowSameTeam().allowInvulnerable();
    private BlockPos targetPosition;
    private int rainTicks = 0;
    private int ticksUntilNextGrow = 0;

    public EntityButterfly(EntityType<? extends EntityButterfly> entityType, World worldIn) {
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
    public CreatureAttribute getMobType() {
        return CreatureAttribute.ARTHROPOD;
    }

    @Override
    public void tick() {
        super.tick();
        if(this.isLanded()) {
            this.setDeltaMovement(Vector3d.ZERO);
            if(Direction.from3DDataValue(this.getLandedInteger()) != Direction.DOWN) {
                double x = Math.floor(this.getX()) + 0.5D;
                double z = Math.floor(this.getZ()) + 0.5D;
                BlockPos pos = new BlockPos(x, Math.floor(this.getY()) + 0.5D, z);
                BlockPos offset = pos.relative(Direction.from3DDataValue(this.getLandedInteger()));
                BlockPos diff = pos.subtract(offset);
                this.teleportTo(x - ((double) diff.getX()) / 2.778D, Math.floor(this.getY()) + 0.5D, z - ((double) diff.getZ()) / 2.778D);
                this.yRot = 0;
                this.yHeadRot = 0;
            } else {
                this.teleportTo(this.getX(), Math.floor(this.getY()), this.getZ());
            }
        } else {
            this.setDeltaMovement(this.getDeltaMovement().multiply(1.0D, 0.6D, 1.0D));
        }
        if(this.hasNectar() && this.random.nextFloat() < 0.05F) {
            for(int i = 0; i < this.random.nextInt(2) + 1; ++i) {
                addParticle(this.level, this.getX() - (double) 0.3F, this.getX() + (double) 0.3F, this.getZ() - (double) 0.3F, this.getZ() + (double) 0.3F, this.getY() + 0.5D, new BlockParticleData(ParticleTypes.FALLING_DUST, Blocks.SAND.defaultBlockState()));
            }
        }
    }

    private static void addParticle(World worldIn, double xStart, double xEnd, double zStart, double zEnd, double posY, IParticleData particleData) {
        worldIn.addParticle(particleData, MathHelper.lerp(worldIn.random.nextDouble(), xStart, xEnd), posY, MathHelper.lerp(worldIn.random.nextDouble(), zStart, zEnd), 0.0D, 0.0D, 0.0D);
    }

    public boolean isRainingAt(BlockPos position) {
        if (!level.isRaining()) {
           return false;
        } else if(position == null) {
            return true;
        } else if (!level.isLoaded(position) || !level.canSeeSkyFromBelowWater(position)) {
           return false;
        } else {
           return level.getBiome(position).getPrecipitation() == Biome.RainType.RAIN;
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
                if(level.isRaining() && level.getBiome(this.blockPosition()).getPrecipitation() == Biome.RainType.RAIN) {
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
                    if(block instanceof CropsBlock) {
                        age = ((CropsBlock) block).getAgeProperty();
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
                Vector3d vec3d = this.getDeltaMovement();
                Vector3d vec3d1 = vec3d.add((Math.signum(d0) * 0.5D - vec3d.x) * (double) 0.1F, (Math.signum(d1) * (double) 0.7F - vec3d.y) * (double) 0.1F, (Math.signum(d2) * 0.5D - vec3d.z) * (double) 0.1F);
                this.setDeltaMovement(vec3d1);
                float f = (float) (MathHelper.atan2(vec3d1.z, vec3d1.x) * (double) (180F / (float) Math.PI)) - 90.0F;
                float f1 = MathHelper.wrapDegrees(f - this.yRot);
                this.zza = 0.5F;
                this.yRot += f1;
            }
        }
    }

    private BlockPos tryToFindPosition(Predicate<BlockPos> condition) {
        BlockPos.Mutable pos = new BlockPos.Mutable();
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
        if(block.is(ModResources.Tags.Blocks.BUTTERFLY_GROWABLES)) {
            if(block instanceof CropsBlock) {
                CropsBlock cropsblock = (CropsBlock) block;
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
        boolean isFlower = this.level.isLoaded(pos) && state.getBlock().is(BlockTags.FLOWERS);
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
    protected boolean isMovementNoisy() {
        return false;
    }

    @Override
    public boolean causeFallDamage(float distance, float damageMultiplier) {
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
    public void readAdditionalSaveData(CompoundNBT compound) {
        super.readAdditionalSaveData(compound);
        this.entityData.set(LANDED, compound.getInt("Landed"));
        this.entityData.set(HAS_NECTAR, compound.getBoolean("HasNectar"));
        this.ticksUntilNextGrow = compound.getInt("TimeUntilNextGrow");
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT compound) {
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
    public boolean canBeLeashed(PlayerEntity player) {
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
        CompoundNBT tag = bucket.getTag();
        tag.putFloat("SizeTag", this.entityData.get(SIZE));
        tag.putBoolean("HasNectar", this.entityData.get(HAS_NECTAR));
        bucket.setTag(tag);
    }

    @Override
    public void readFromContainerTag(CompoundNBT tag) {
        super.readFromContainerTag(tag);
        if(tag.contains("SizeTag")) {
            this.setSize(tag.getFloat("SizeTag"));
            this.setHasNectar(tag.getBoolean("HasNectar"));
        }
    }

    public static void bottleTooltip(EntityTypeContainer<? extends MobEntity> container, ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip) {
        CompoundNBT tag = stack.getTag();
        if(tag != null) {
            if(tag.contains("SizeTag", Constants.NBT.TAG_FLOAT)) {
                tooltip.add(new StringTextComponent("Size: " + tag.getFloat("SizeTag")).withStyle(TextFormatting.ITALIC).withStyle(TextFormatting.GRAY));
            }
            if(tag.contains("HasNectar") && tag.getBoolean("HasNectar")) {
                tooltip.add(new TranslationTextComponent("tooltip.betteranimalsplus.nectar").withStyle(TextFormatting.ITALIC).withStyle(TextFormatting.YELLOW));
            }
        }
    }

    public static RegistryKey<Biome>[] getSpawnBiomes() {
        Set<RegistryKey<Biome>> set = new HashSet<>();
        set.addAll(BiomeDictionary.getBiomes(Type.FOREST));
        set.addAll(BiomeDictionary.getBiomes(Type.JUNGLE));
        set.addAll(BiomeDictionary.getBiomes(Type.MAGICAL));
        set.removeIf(b -> BiomeDictionary.hasType(b, Type.COLD) || !BiomeDictionary.hasType(b, Type.OVERWORLD));
        return set.toArray(new RegistryKey[0]);
    }
}