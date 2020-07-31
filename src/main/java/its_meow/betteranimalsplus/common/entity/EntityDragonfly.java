package its_meow.betteranimalsplus.common.entity;

import java.util.List;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import dev.itsmeow.imdlib.entity.util.EntityTypeContainer;
import its_meow.betteranimalsplus.common.entity.util.EntityTypeContainerBAP;
import its_meow.betteranimalsplus.common.entity.util.EntityTypeContainerBAPContainable;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalWithTypes;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalWithTypesAndSizeContainable;
import its_meow.betteranimalsplus.init.ModEntities;
import net.minecraft.block.BlockState;
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
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.util.Constants;

public class EntityDragonfly extends EntityAnimalWithTypesAndSizeContainable {

    private static final DataParameter<Integer> LANDED = EntityDataManager.createKey(EntityDragonfly.class, DataSerializers.VARINT);
    private static final EntityPredicate playerPredicate = (new EntityPredicate()).setDistance(4.0D).allowFriendlyFire().allowInvulnerable();
    private BlockPos targetPosition;
    private int rainTicks = 0;

    public EntityDragonfly(World worldIn) {
        super(ModEntities.DRAGONFLY.entityType, worldIn);
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(LANDED, 1);
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
                double x = Math.floor(this.posX) + 0.5D;
                double z = Math.floor(this.posZ) + 0.5D;
                this.posY = Math.floor(this.posY) + 0.5D;
                BlockPos pos = new BlockPos(x, posY, z);
                BlockPos offset = pos.offset(Direction.byIndex(this.getLandedInteger()));
                BlockPos diff = pos.subtract(offset);
                this.posX = x - ((double) diff.getX()) / 2.778D;
                this.posZ = z - ((double) diff.getZ()) / 2.778D;
                this.rotationYaw = 0;
                this.rotationYawHead = 0;
            } else {
                this.posY = Math.floor(this.posY);
            }
        } else {
            this.setMotion(this.getMotion().mul(1.0D, 0.6D, 1.0D));
        }
    }

    public boolean isRainingAt(BlockPos position) {
        if(!world.isRaining()) {
            return false;
        } else if(position == null) {
            return true;
        } else if(!world.isBlockPresent(position) || !world.canBlockSeeSky(position)) {
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
            if(this.targetPosition == null || this.rand.nextInt(30) == 0 || (this.targetPosition.withinDistance(this.getPositionVec(), 1.0D))) {
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
                        BlockPos temp = new BlockPos(this.posX + (double) this.rand.nextInt(5) - (double) this.rand.nextInt(5), this.posY + (double) this.rand.nextInt(4) - 1.0D, this.posZ + (double) this.rand.nextInt(5) - (double) this.rand.nextInt(5));
                        if(!isRainingAt(temp)) {
                            this.targetPosition = temp;
                        }
                    }
                } else {
                    boolean found = false;
                    if(this.world.getClosestPlayer(playerPredicate, this) == null) {
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
                        this.targetPosition = new BlockPos(this.posX + (double) this.rand.nextInt(5) - (double) this.rand.nextInt(5), this.posY + (double) this.rand.nextInt(4) - 1.0D, this.posZ + (double) this.rand.nextInt(5) - (double) this.rand.nextInt(5));
                    }
                }
            }
            if(this.targetPosition != null && this.targetPosition.withinDistance(this.getPositionVec(), 1.0D)) {
                this.targetPosition = null;
            }
        }
        if(!this.isLanded() && targetPosition != null) {
            double d0 = (double) this.targetPosition.getX() + 0.5D - this.posX;
            double d1 = (double) this.targetPosition.getY() + 0.1D - this.posY;
            double d2 = (double) this.targetPosition.getZ() + 0.5D - this.posZ;
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
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
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

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    public void fall(float distance, float damageMultiplier) {
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
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putInt("Landed", this.dataManager.get(LANDED));
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
        return ModEntities.DRAGONFLY;
    }

    @Override
    protected EntityAnimalWithTypes getBaseChild() {
        return null;
    }

    @Override
    public EntityTypeContainerBAPContainable<?, ?> getContainableContainer() {
        return ModEntities.DRAGONFLY;
    }

    @Override
    public void setContainerData(ItemStack bucket) {
        super.setContainerData(bucket);
        CompoundNBT tag = bucket.getTag();
        tag.putFloat("SizeTag", this.dataManager.get(SIZE));
        bucket.setTag(tag);
    }

    @Override
    public void readFromContainerTag(CompoundNBT tag) {
        super.readFromContainerTag(tag);
        if(tag.contains("SizeTag")) {
            this.setSize(tag.getFloat("SizeTag"));
        }
    }

    public static void bottleTooltip(EntityTypeContainerBAP<? extends MobEntity> container, ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip) {
        CompoundNBT tag = stack.getTag();
        if(tag != null) {
            if(tag.contains("SizeTag", Constants.NBT.TAG_FLOAT)) {
                tooltip.add(new StringTextComponent("Size: " + tag.getFloat("SizeTag")).applyTextStyles(new TextFormatting[] { TextFormatting.ITALIC, TextFormatting.GRAY }));
            }
        }
    }
}