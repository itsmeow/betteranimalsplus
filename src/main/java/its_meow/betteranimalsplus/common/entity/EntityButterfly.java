package its_meow.betteranimalsplus.common.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import dev.itsmeow.imdlib.entity.util.EntityTypeContainer;
import its_meow.betteranimalsplus.common.entity.util.EntityTypeContainerBAP;
import its_meow.betteranimalsplus.common.entity.util.EntityTypeContainerBAPContainable;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalWithTypes;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalWithTypesAndSizeContainable;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModResources;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.block.StemBlock;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SharedMonsterAttributes;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.util.Constants;

public class EntityButterfly extends EntityAnimalWithTypesAndSizeContainable {

    private static final DataParameter<Boolean> HAS_NECTAR = EntityDataManager.createKey(EntityButterfly.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Integer> LANDED = EntityDataManager.createKey(EntityButterfly.class, DataSerializers.VARINT);
    private static final EntityPredicate playerPredicate = (new EntityPredicate()).setDistance(4.0D).allowFriendlyFire().allowInvulnerable();
    private BlockPos targetPosition;
    private int rainTicks = 0;
    private int ticksUntilNextGrow = 0;

    public EntityButterfly(World worldIn) {
        super(ModEntities.BUTTERFLY.entityType, worldIn);
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(LANDED, 1);
        this.dataManager.register(HAS_NECTAR, false);
    }

    @Override
    public boolean isInvulnerableTo(DamageSource source) {
        return super.isInvulnerableTo(source) || source == DamageSource.SWEET_BERRY_BUSH;
    }

    @Override
    public boolean canBePushed() {
        return false;
    }

    @Override
    protected void collideWithEntity(Entity entityIn) {
    }

    @Override
    protected void collideWithNearbyEntities() {
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(2.0D);
    }

    public boolean isLanded() {
        return this.dataManager.get(LANDED) != 1;
    }

    public int getLandedInteger() {
        return this.dataManager.get(LANDED);
    }

    public void setLanded(Direction direction) {
        if(direction == Direction.UP) {
            throw new RuntimeException("Invalid landing direction!");
        }
        this.dataManager.set(LANDED, direction.ordinal());
    }

    public void setNotLanded() {
        this.dataManager.set(LANDED, 1);
    }

    public boolean hasNectar() {
        return this.dataManager.get(HAS_NECTAR);
    }

    public void setHasNectar(boolean value) {
        this.dataManager.set(HAS_NECTAR, value);
    }

    @Override
    public CreatureAttribute getCreatureAttribute() {
        return CreatureAttribute.ARTHROPOD;
    }

    @Override
    public void tick() {
        super.tick();
        if(this.isLanded()) {
            this.setMotion(Vec3d.ZERO);
            if(Direction.byIndex(this.getLandedInteger()) != Direction.DOWN) {
                double x = Math.floor(this.getPosX()) + 0.5D;
                double z = Math.floor(this.getPosZ()) + 0.5D;
                BlockPos pos = new BlockPos(x, this.getPosY(), z);
                BlockPos offset = pos.offset(Direction.byIndex(this.getLandedInteger()));
                BlockPos diff = pos.subtract(offset);
                this.setPositionAndUpdate(x - ((double) diff.getX()) / 2.778D, Math.floor(this.getPosY()) + 0.5D, ((double) diff.getZ()) / 2.778D);
                this.rotationYaw = 0;
                this.rotationYawHead = 0;
            } else {
                this.setPositionAndUpdate(this.getPosX(), Math.floor(this.getPosY()), this.getPosZ());
            }
        } else {
            this.setMotion(this.getMotion().mul(1.0D, 0.6D, 1.0D));
        }
        if(this.hasNectar() && this.rand.nextFloat() < 0.05F) {
            for(int i = 0; i < this.rand.nextInt(2) + 1; ++i) {
                addParticle(this.world, this.getPosX() - (double) 0.3F, this.getPosX() + (double) 0.3F, this.getPosZ() - (double) 0.3F, this.getPosZ() + (double) 0.3F, this.getPosY() + 0.5D, new BlockParticleData(ParticleTypes.FALLING_DUST, Blocks.SAND.getDefaultState()));
            }
        }
    }

    private static void addParticle(World worldIn, double xStart, double xEnd, double zStart, double zEnd, double posY, IParticleData particleData) {
        worldIn.addParticle(particleData, MathHelper.lerp(worldIn.rand.nextDouble(), xStart, xEnd), posY, MathHelper.lerp(worldIn.rand.nextDouble(), zStart, zEnd), 0.0D, 0.0D, 0.0D);
    }

    public boolean isRainingAt(BlockPos position) {
        if (!world.isRaining()) {
           return false;
        } else if(position == null) {
            return true;
        } else if (!world.isBlockPresent(position) || !world.canBlockSeeSky(position)) {
           return false;
        } else {
           return world.getBiome(position).getPrecipitation() == Biome.RainType.RAIN;
        }
     }

    @Override
    protected void updateAITasks() {
        super.updateAITasks();
        BlockPos blockpos = new BlockPos(this);
        if(this.isLanded()) {
            BlockPos offset = blockpos.offset(Direction.byIndex(this.getLandedInteger()));
            if(this.world.getBlockState(offset).isNormalCube(this.world, offset)) {
                if(this.world.getClosestPlayer(playerPredicate, this) != null || this.getRNG().nextInt(500) == 0) {
                    this.setNotLanded();
                }
            } else {
                this.setNotLanded();
            }
        }
        if(isRainingAt(this.getPosition())) {
            rainTicks++;
            if(this.isLanded()) {
                this.setNotLanded();
            }
            if(this.targetPosition == null || isRainingAt(this.targetPosition)) {
                this.targetPosition = tryToFindPosition(pos -> {
                    if(pos != null && !isRainingAt(pos) && world.isAirBlock(pos)) {
                        boolean found = false;
                        for(Direction direction : Direction.values()) {
                            if(direction != Direction.UP) {
                                BlockPos offset = pos.offset(direction);
                                if(world.getBlockState(offset).isNormalCube(world, offset)) {
                                    found = true;
                                }
                            }
                        }
                        return found;
                    }
                    return false;
                });
            }
            if(this.getRNG().nextFloat() < 0.0025F && rainTicks > 100) {
                this.attackEntityFrom(DamageSource.DROWN, 1F);
            }
        } else {
            rainTicks = 0;
            if(this.targetPosition == null || this.rand.nextInt(30) == 0 || (this.targetPosition.withinDistance(this.getPositionVec(), 1.0D) && !isFlowers(this.targetPosition) && !isGrowable(this.targetPosition))) {
                if(world.isRaining() && world.getBiome(this.getPosition()).getPrecipitation() == Biome.RainType.RAIN) {
                    // attempt to land
                    boolean found = false;
                    for(Direction direction : Direction.values()) {
                        if(direction != Direction.UP) {
                            BlockPos offset = blockpos.offset(direction);
                            if(world.getBlockState(offset).isNormalCube(world, offset) && world.isAirBlock(blockpos)) {
                                this.setLanded(direction);
                                this.targetPosition = null;
                                found = true;
                            }
                        }
                    }
                    if(!found) {
                        BlockPos temp = new BlockPos(this.getPosX() + (double) this.rand.nextInt(5) - (double) this.rand.nextInt(5), this.getPosY() + (double) this.rand.nextInt(4) - 1.0D, this.getPosZ() + (double) this.rand.nextInt(5) - (double) this.rand.nextInt(5));
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
                        if(this.world.getClosestPlayer(playerPredicate, this) == null && (!this.hasNectar() || ranGrowable)) {
                            for(Direction direction : Direction.values()) {
                                if(direction != Direction.UP) {
                                    BlockPos offset = blockpos.offset(direction);
                                    if(world.getBlockState(offset).isNormalCube(world, offset) && world.isAirBlock(blockpos)) {
                                        this.setLanded(direction);
                                        this.targetPosition = null;
                                        found = true;
                                    }
                                }
                            }
                        }
                        if(!found) {
                            this.targetPosition = new BlockPos(this.getPosX() + (double) this.rand.nextInt(5) - (double) this.rand.nextInt(5), this.getPosY() + (double) this.rand.nextInt(4) - 1.0D, this.getPosZ() + (double) this.rand.nextInt(5) - (double) this.rand.nextInt(5));
                        }
                    }
                }
            }
            if(this.targetPosition != null && this.targetPosition.withinDistance(this.getPositionVec(), 1.0D)) {
                if(this.isFlowers(targetPosition) && !this.hasNectar()) {
                    this.setHasNectar(true);
                    this.targetPosition = null;
                } else if(this.isGrowable(targetPosition) && this.hasNectar()) {
                    BlockState blockstate = this.world.getBlockState(targetPosition);
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
                        world.playEvent(2005, targetPosition, 0);
                        world.setBlockState(targetPosition, blockstate.with(age, Integer.valueOf(blockstate.get(age) + 1)));
                        this.setHasNectar(false);
                        this.targetPosition = null;
                        this.ticksUntilNextGrow = this.getRNG().nextInt(150 * 20) + (30 * 20);
                    }
                }
            }
        }
        if(!this.isLanded() && targetPosition != null) {
            double d0 = (double) this.targetPosition.getX() + 0.5D - this.getPosX();
            double d1 = (double) this.targetPosition.getY() + 0.1D - this.getPosY();
            double d2 = (double) this.targetPosition.getZ() + 0.5D - this.getPosZ();
            Vec3d vec3d = this.getMotion();
            Vec3d vec3d1 = vec3d.add((Math.signum(d0) * 0.5D - vec3d.x) * (double) 0.1F, (Math.signum(d1) * (double) 0.7F - vec3d.y) * (double) 0.1F, (Math.signum(d2) * 0.5D - vec3d.z) * (double) 0.1F);
            this.setMotion(vec3d1);
            float f = (float) (MathHelper.atan2(vec3d1.z, vec3d1.x) * (double) (180F / (float) Math.PI)) - 90.0F;
            float f1 = MathHelper.wrapDegrees(f - this.rotationYaw);
            this.moveForward = 0.5F;
            this.rotationYaw += f1;
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
                        pos.setPos(this.getPosition()).move(i1, k - 1, j1);
                        if(condition.test(pos.toImmutable())) {
                            return pos.toImmutable();
                        }
                    }
                }
            }
        }
        return null;
    }

    private boolean isGrowable(BlockPos blockpos) {
        BlockState blockstate = this.world.getBlockState(blockpos);
        Block block = blockstate.getBlock();
        boolean flag = false;
        if(block.isIn(ModResources.Tags.Blocks.BUTTERFLY_GROWABLES)) {
            if(block instanceof CropsBlock) {
                CropsBlock cropsblock = (CropsBlock) block;
                if(!cropsblock.isMaxAge(blockstate)) {
                    flag = true;

                }
            } else if(block instanceof StemBlock) {
                int j = blockstate.get(StemBlock.AGE);
                if(j < 7) {
                    flag = true;

                }
            } else if(block == Blocks.SWEET_BERRY_BUSH) {
                int k = blockstate.get(SweetBerryBushBlock.AGE);
                if(k < 3) {
                    flag = true;

                }
            }
        }
        return flag;
    }

    private boolean isFlowers(BlockPos pos) {
        BlockState state = this.world.getBlockState(pos);
        boolean isFlower = this.world.isBlockPresent(pos) && state.getBlock().isIn(ModResources.Tags.Blocks.FLOWERS);
        if(isFlower) {
            if(state.isIn(ModResources.Tags.Blocks.TALL_FLOWERS)) {
                if(state.getBlock() == Blocks.SUNFLOWER) {
                    return state.get(DoublePlantBlock.HALF) == DoubleBlockHalf.UPPER;
                } else {
                    return true;
                }
            } else {
                return state.isIn(BlockTags.SMALL_FLOWERS);
            }
        }
        return false;
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    public boolean onLivingFall(float distance, float damageMultiplier) {
        return false;
    }

    @Override
    protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
    }

    @Override
    public boolean doesEntityNotTriggerPressurePlate() {
        return true;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if(this.isInvulnerableTo(source)) {
            return false;
        } else {
            if(!this.world.isRemote && this.isLanded()) {
                this.setNotLanded();
            }
            return super.attackEntityFrom(source, amount);
        }
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.dataManager.set(LANDED, compound.getInt("Landed"));
        this.dataManager.set(HAS_NECTAR, compound.getBoolean("HasNectar"));
        this.ticksUntilNextGrow = compound.getInt("TimeUntilNextGrow");
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putInt("Landed", this.dataManager.get(LANDED));
        compound.putBoolean("HasNectar", this.dataManager.get(HAS_NECTAR));
        compound.putInt("TimeUntilNextGrow", this.ticksUntilNextGrow);
    }

    @Override
    protected float getRandomizedSize() {
        return (this.rand.nextInt(30) + 1F) / 100F + 0.15F;
    }

    @Override
    public boolean canBeLeashedTo(PlayerEntity player) {
        return false;
    }

    @Override
    public EntityTypeContainer<?> getContainer() {
        return ModEntities.BUTTERFLY;
    }

    @Override
    protected EntityAnimalWithTypes getBaseChild() {
        return null;
    }

    @Override
    public EntityTypeContainerBAPContainable<?, ?> getContainableContainer() {
        return ModEntities.BUTTERFLY;
    }

    @Override
    public void setContainerData(ItemStack bucket) {
        super.setContainerData(bucket);
        CompoundNBT tag = bucket.getTag();
        tag.putFloat("SizeTag", this.dataManager.get(SIZE));
        tag.putBoolean("HasNectar", this.dataManager.get(HAS_NECTAR));
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

    public static void bottleTooltip(EntityTypeContainerBAP<? extends MobEntity> container, ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip) {
        CompoundNBT tag = stack.getTag();
        if(tag != null) {
            if(tag.contains("SizeTag", Constants.NBT.TAG_FLOAT)) {
                tooltip.add(new StringTextComponent("Size: " + tag.getFloat("SizeTag")).applyTextStyles(new TextFormatting[] { TextFormatting.ITALIC, TextFormatting.GRAY }));
            }
            if(tag.contains("HasNectar") && tag.getBoolean("HasNectar")) {
                tooltip.add(new TranslationTextComponent("tooltip.betteranimalsplus.nectar").applyTextStyles(new TextFormatting[] { TextFormatting.ITALIC, TextFormatting.YELLOW }));
            }
        }
    }

    public static Biome[] getSpawnBiomes() {
        // java ****ing sucks at type inference, which is why this is here. because it won't compile as a lambda inside ModEntities. thanks java.
        Set<Biome> set = new HashSet<Biome>();
        set.addAll(BiomeDictionary.getBiomes(Type.FOREST));
        set.addAll(BiomeDictionary.getBiomes(Type.JUNGLE));
        set.addAll(BiomeDictionary.getBiomes(Type.MAGICAL));
        set.removeIf(b -> BiomeDictionary.getTypes(b).contains(Type.COLD));
        return set.toArray(new Biome[0]);
    }
}