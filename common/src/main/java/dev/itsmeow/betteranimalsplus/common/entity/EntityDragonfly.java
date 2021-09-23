package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.util.EntityTypeContainerContainable;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalWithTypes;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalWithTypesAndSizeContainable;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.util.Constants;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Predicate;

public class EntityDragonfly extends EntityAnimalWithTypesAndSizeContainable {

    private static final DataParameter<Integer> LANDED = EntityDataManager.defineId(EntityDragonfly.class, DataSerializers.INT);
    private static final EntityPredicate playerPredicate = (new EntityPredicate()).range(4.0D).allowSameTeam().allowInvulnerable();
    private BlockPos targetPosition;
    private int rainTicks = 0;

    public EntityDragonfly(EntityType<? extends EntityDragonfly> entityType, World worldIn) {
        super(entityType, worldIn);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(LANDED, 1);
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
    }

    public boolean isRainingAt(BlockPos position) {
        if(!level.isRaining()) {
            return false;
        } else if(position == null) {
            return true;
        } else if(!level.isLoaded(position) || !level.canSeeSkyFromBelowWater(position)) {
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
            if(this.targetPosition == null || this.random.nextInt(30) == 0 || (this.targetPosition.closerThan(this.position(), 1.0D))) {
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
                    boolean found = false;
                    if(this.level.getNearestPlayer(playerPredicate, this) == null) {
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
            if(this.targetPosition != null && this.targetPosition.closerThan(this.position(), 1.0D)) {
                this.targetPosition = null;
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
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Landed", this.entityData.get(LANDED));
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
    public EntityTypeContainer<? extends EntityDragonfly> getContainer() {
        return ModEntities.DRAGONFLY;
    }

    @Override
    protected EntityAnimalWithTypes getBaseChild() {
        return null;
    }

    @Override
    public EntityTypeContainerContainable<? extends EntityDragonfly, ?> getContainableContainer() {
        return ModEntities.DRAGONFLY;
    }

    @Override
    public void setContainerData(ItemStack bucket) {
        super.setContainerData(bucket);
        CompoundNBT tag = bucket.getTag();
        tag.putFloat("SizeTag", this.entityData.get(SIZE));
        bucket.setTag(tag);
    }

    @Override
    public void readFromContainerTag(CompoundNBT tag) {
        super.readFromContainerTag(tag);
        if(tag.contains("SizeTag")) {
            this.setSize(tag.getFloat("SizeTag"));
        }
    }

    public static void bottleTooltip(EntityTypeContainer<? extends MobEntity> container, ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip) {
        CompoundNBT tag = stack.getTag();
        if(tag != null) {
            if(tag.contains("SizeTag", Constants.NBT.TAG_FLOAT)) {
                tooltip.add(new StringTextComponent("Size: " + tag.getFloat("SizeTag")).withStyle(TextFormatting.ITALIC).withStyle(TextFormatting.GRAY));
            }
        }
    }
}