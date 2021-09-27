package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.betteranimalsplus.common.entity.util.IDropHead;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModLootTables;
import dev.itsmeow.betteranimalsplus.init.ModTriggers;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.interfaces.IVariantTypes;
import dev.itsmeow.imdlib.entity.util.variant.IVariant;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.Vec3;

import java.util.Calendar;

public class EntityReindeer extends Animal implements PlayerRideableJumping, IVariantTypes<EntityReindeer>, IDropHead<EntityReindeer> {

    protected static final java.util.function.Predicate<LivingEntity> IS_REINDEER_BREEDING = (entity) -> entity instanceof EntityReindeer && ((EntityReindeer)entity).isBreeding();
    private static final TargetingConditions PARENT_TARGETING = (new TargetingConditions()).range(16.0D).allowInvulnerable().allowSameTeam().allowUnseeable().selector(IS_REINDEER_BREEDING);
    protected static final EntityDataAccessor<Byte> STATUS = SynchedEntityData.defineId(EntityReindeer.class, EntityDataSerializers.BYTE);
    private int eatingCounter;
    private int openMouthCounter;
    private int jumpRearingCounter;
    public int tailCounter;
    public int sprintCounter;
    protected boolean reindeerJumping;
    protected float jumpPower;
    private boolean allowStandSliding;
    private float headLean;
    private float prevHeadLean;
    private float rearingAmount;
    private float prevRearingAmount;
    private float mouthOpenness;
    private float prevMouthOpenness;
    protected boolean canGallop = true;
    /**
     * Used to determine the sound that the reindeer should make when it steps
     */
    protected int gallopTime;
    public boolean parentRudolph = false;
    public static final String CREATE_SNOW_KEY = "create_snow";

    public EntityReindeer(EntityType<? extends EntityReindeer> entityType, Level worldIn) {
        super(entityType, worldIn);
        this.maxUpStep = 1.0F;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.2D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D, EntityReindeer.class));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 0.7D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.registerTypeKey();
        this.entityData.define(STATUS, (byte) 0);
    }

    // Implementation
    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        boolean flag = !itemstack.isEmpty();

        if(flag && itemstack.getItem() instanceof SpawnEggItem) {
            return super.mobInteract(player, hand);
        } else {
            if(!this.isBaby()) {
                if(player.isCrouching()) {
                    return InteractionResult.PASS;
                }

                if(this.isVehicle()) {
                    return super.mobInteract(player, hand);
                }
            }

            if(flag) {
                if(this.handleEating(player, itemstack)) {
                    if(!player.isCreative()) {
                        itemstack.shrink(1);
                    }

                    return InteractionResult.SUCCESS;
                }

                if(itemstack.interactLivingEntity(player, this, hand) == InteractionResult.SUCCESS) {
                    return InteractionResult.SUCCESS;
                }

            }

            if(this.isBaby()) {
                return super.mobInteract(player, hand);
            } else {
                this.mountTo(player);
                return InteractionResult.SUCCESS;
            }
        }
    }

    /**
     * Returns true if the mob is currently able to mate with the specified mob.
     */
    @Override
    public boolean canMate(Animal otherAnimal) {
        if (otherAnimal == this) {
            return false;
        } else if (!(otherAnimal instanceof EntityReindeer)) {
            return false;
        } else {
            return this.canMate() && ((EntityReindeer) otherAnimal).canMate();
        }
    }

    @Override
    public AgableMob getBreedOffspring(ServerLevel world, AgableMob ageable) {
        EntityReindeer reindeer = getContainer().getEntityType().create(world);
        this.setOffspringAttributes(ageable, reindeer);
        if(ageable instanceof EntityReindeer) {
            EntityReindeer other = (EntityReindeer) ageable;
            if(other.getVariantNameOrEmpty().endsWith("christmas")) { // if one of them is red-nosed make that one take dominance
                reindeer.setType(other.getVariant().get());
            } else { // none are red-nosed, just use this one's type
                reindeer.setType(this.getVariant().get());
            }

            if((other.hasCustomName() && other.getCustomName().getString().equalsIgnoreCase("rudolph"))
                    || (this.hasCustomName() && this.getCustomName().getString().equalsIgnoreCase("rudolph"))) {
                reindeer.parentRudolph = true;
            }
        } else { // same as above
            reindeer.setType(this.getVariant().get());
        }
        return reindeer;
    }

    // Abstract Reindeer

    protected boolean getReindeerWatchableBoolean(int p_110233_1_) {
        return (this.entityData.get(EntityReindeer.STATUS) & p_110233_1_) != 0;
    }

    protected void setReindeerWatchableBoolean(int p_110208_1_, boolean p_110208_2_) {
        byte b0 = this.entityData.get(EntityReindeer.STATUS);

        if (p_110208_2_) {
            this.entityData.set(EntityReindeer.STATUS, (byte) (b0 | p_110208_1_));
        } else {
            this.entityData.set(EntityReindeer.STATUS, (byte) (b0 & ~p_110208_1_));
        }
    }

    public boolean isReindeerJumping() {
        return this.reindeerJumping;
    }

    public void setReindeerJumping(boolean jumping) {
        this.reindeerJumping = jumping;
    }

    @Override
    public boolean canBeLeashed(Player player) {
        return super.canBeLeashed(player);
    }

    @Override
    protected void onLeashDistance(float p_142017_1_) {
        if (p_142017_1_ > 6.0F && this.isEatingHaystack()) {
            this.setEatingHaystack(false);
        }
    }

    public boolean isEatingHaystack() {
        return this.getReindeerWatchableBoolean(16);
    }

    public boolean isRearing() {
        return this.getReindeerWatchableBoolean(32);
    }

    public boolean isBreeding() {
        return this.getReindeerWatchableBoolean(8);
    }

    public void setBreeding(boolean breeding) {
        this.setReindeerWatchableBoolean(8, breeding);
    }

    /**
     * Called when the entity is attacked.
     */
    @Override
    public boolean hurt(DamageSource source, float amount) {
        Entity entity = source.getEntity();
        return (!this.isVehicle() || entity == null || !this.hasPassenger(entity)) && super.hurt(source, amount);
    }

    /**
     * Returns true if this entity should push and be pushed by other entities when
     * colliding.
     */
    @Override
    public boolean isPushable() {
        return !this.isVehicle();
    }

    private void eatingReindeer() {
        this.openReindeerMouth();

        if (!this.isSilent()) {
            this.level.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.HORSE_EAT,
                    this.getSoundSource(), 1.0F, 1.0F + (this.random.nextFloat() - this.random.nextFloat()) * 0.2F);
        }
    }

    @Override
    public boolean causeFallDamage(float distance, float damageMultiplier) {
        if (distance > 1.0F) {
            this.playSound(SoundEvents.HORSE_LAND, 0.4F, 1.0F);
        }

        int i = Mth.ceil((distance * 0.5F - 3.0F) * damageMultiplier);

        if (i > 0) {
            this.hurt(DamageSource.FALL, i);

            if (this.isVehicle()) {
                for (Entity entity : this.getIndirectPassengers()) {
                    entity.hurt(DamageSource.FALL, i);
                }
            }
            BlockPos pos = new BlockPos(this.getX(), this.getY() - 0.2D - this.yRotO, this.getZ());
            BlockState iblockstate = this.level.getBlockState(pos);
            Block block = iblockstate.getBlock();

            if (iblockstate.getMaterial() != Material.AIR && !this.isSilent()) {
                SoundType soundtype = block.getSoundType(block.defaultBlockState());
                this.level.playSound(null, this.getX(), this.getY(), this.getZ(), soundtype.getStepSound(),
                        this.getSoundSource(), soundtype.getVolume() * 0.5F, soundtype.getPitch() * 0.75F);
            }
        }
        return true;
    }

    public double getReindeerJumpStrength() {
        return this.getAttribute(Attributes.JUMP_STRENGTH).getValue();
    }

    @Override
    protected SoundEvent getDeathSound() {
        this.openReindeerMouth();
        return null;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        this.openReindeerMouth();

        if (this.random.nextInt(3) == 0) {
            this.makeReindeerRear();
        }

        return null;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        this.openReindeerMouth();

        if (this.random.nextInt(10) == 0 && !this.isImmobile()) {
            this.makeReindeerRear();
        }

        return null;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockStateIn) {
        if (!blockStateIn.getMaterial().isLiquid()) {
            SoundType soundtype = blockStateIn.getSoundType();

            if (this.level.getBlockState(pos.above()).getBlock() == Blocks.SNOW) {
                soundtype = Blocks.SNOW.getSoundType(Blocks.SNOW.defaultBlockState());
            }

            if (this.isVehicle() && this.canGallop) {
                ++this.gallopTime;

                if (this.gallopTime > 5 && this.gallopTime % 3 == 0) {
                    this.playGallopSound(soundtype);
                } else if (this.gallopTime <= 5) {
                    this.playSound(SoundEvents.HORSE_STEP_WOOD, soundtype.getVolume() * 0.15F,
                            soundtype.getPitch());
                }
            } else if (soundtype == SoundType.WOOD) {
                this.playSound(SoundEvents.HORSE_STEP_WOOD, soundtype.getVolume() * 0.15F, soundtype.getPitch());
            } else {
                this.playSound(SoundEvents.HORSE_STEP, soundtype.getVolume() * 0.15F, soundtype.getPitch());
            }
        }
    }

    protected void playGallopSound(SoundType p_190680_1_) {
        this.playSound(SoundEvents.HORSE_GALLOP, p_190680_1_.getVolume() * 0.15F, p_190680_1_.getPitch());
    }

    @Override
    public int getMaxSpawnClusterSize() {
        return 6;
    }

    @Override
    protected float getSoundVolume() {
        return 0.8F;
    }

    @Override
    public int getAmbientSoundInterval() {
        return 400;
    }

    protected boolean handleEating(Player player, ItemStack stack) {
        boolean flag = false;
        float f = 0.0F;
        int i = 0;
        Item item = stack.getItem();

        if (item == Items.WHEAT || item == Items.CARROT) {
            f = 2.0F;
            i = 20;
            if (!this.isBaby() && !this.isInLove()) {
                flag = true;
                this.setInLove(player);
            }
        } else if (item == Items.SUGAR) {
            f = 1.0F;
            i = 30;
        } else if (item == Blocks.HAY_BLOCK.asItem()) {
            f = 20.0F;
            i = 180;
        } else if (item == Items.APPLE) {
            f = 3.0F;
            i = 60;
        } else if (item == Items.GOLDEN_CARROT) {
            f = 4.0F;
            i = 60;

            if (this.getAge() == 0 && !this.isInLove()) {
                flag = true;
                this.setInLove(player);
            }
        } else if (item == Items.GOLDEN_APPLE) {
            f = 10.0F;
            i = 240;

            if (this.getAge() == 0 && !this.isInLove()) {
                flag = true;
                this.setInLove(player);
            }
        }

        if (this.getHealth() < this.getMaxHealth() && f > 0.0F) {
            this.heal(f);
            flag = true;
        }

        if (this.isBaby() && i > 0) {
            this.level.addParticle(ParticleTypes.HAPPY_VILLAGER,
                    this.getX() + this.random.nextFloat() * this.getBbWidth() * 2.0F - this.getBbWidth(),
                    this.getY() + 0.5D + this.random.nextFloat() * this.getBbHeight(),
                    this.getZ() + this.random.nextFloat() * this.getBbWidth() * 2.0F - this.getBbWidth(), 0.0D, 0.0D, 0.0D);

            if (!this.level.isClientSide) {
                this.ageUp(i);
            }

            flag = true;
        }
        if (flag) {
            this.eatingReindeer();
        }

        return flag;
    }

    @Override
    public void die(DamageSource cause) {
        super.die(cause);
        this.doHeadDrop();
    }

    @Override
    protected ResourceLocation getDefaultLootTable() {
        return ModLootTables.reindeer;
    }

    protected void mountTo(Player player) {
        player.yRot = this.yRot;
        player.xRot = this.xRot;
        this.setEatingHaystack(false);
        this.setRearing(false);
        if(player instanceof ServerPlayer) {
            ModTriggers.RIDE_REINDEER.trigger((ServerPlayer) player);
        }

        if (!this.level.isClientSide) {
            player.startRiding(this);
        }
    }

    /**
     * Dead and sleeping entities cannot move
     */
    @Override
    protected boolean isImmobile() {
        return super.isImmobile() && this.isVehicle() || this.isEatingHaystack() || this.isRearing();
    }

    /**
     * Checks if the parameter is an item which this animal can be fed to breed it
     * (wheat, carrots or seeds depending on the animal type)
     */
    @Override
    public boolean isFood(ItemStack stack) {
        return false;
    }

    private void moveTail() {
        this.tailCounter = 1;
    }

    /**
     * Called frequently so the entity can update its state every tick as required.
     * For example, zombies and skeletons use this to react to sunlight and start to
     * burn.
     */
    @Override
    public void aiStep() {
        if(this.random.nextInt(200) == 0) {
            this.moveTail();
        }

        super.aiStep();
        if(level.isClientSide() && getContainer().getCustomConfigurationClient().getBoolean(CREATE_SNOW_KEY) && random.nextInt(10) == 0) {
            this.level.addParticle(ParticleTypes.POOF, this.getX() + this.random.nextInt(4) - 2F, this.getY() + this.random.nextInt(4), this.getZ() + this.random.nextInt(4) - 2F, 0F, -0.2F, 0F);
        }
        if(!this.level.isClientSide) {
            if (this.random.nextInt(900) == 0 && this.deathTime == 0) {
                this.heal(1.0F);
            }

            if (this.canEatGrass()) {
                if (!this.isEatingHaystack() && !this.isVehicle() && this.random.nextInt(300) == 0
                        && this.level
                                .getBlockState(new BlockPos(Mth.floor(this.getX()),
                                        Mth.floor(this.getY()) - 1, Mth.floor(this.getZ())))
                                .getBlock() == Blocks.GRASS) {
                    this.setEatingHaystack(true);
                }

                if (this.isEatingHaystack() && ++this.eatingCounter > 50) {
                    this.eatingCounter = 0;
                    this.setEatingHaystack(false);
                }
            }

            this.followMother();
        }
    }

    protected void followMother() {
        if(this.isBreeding() && this.isBaby() && !this.isEatingHaystack()) {
            LivingEntity livingentity = this.level.getNearestEntity(AbstractHorse.class, PARENT_TARGETING, this, this.getX(), this.getY(), this.getZ(), this.getBoundingBox().inflate(16.0D));
            if(livingentity != null && this.distanceToSqr(livingentity) > 4.0D) {
                this.navigation.createPath(livingentity, 0);
            }
        }
    }

    public boolean canEatGrass() {
        return true;
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void tick() {
        super.tick();

        if (this.openMouthCounter > 0 && ++this.openMouthCounter > 30) {
            this.openMouthCounter = 0;
            this.setReindeerWatchableBoolean(64, false);
        }

        if (this.isControlledByLocalInstance() && this.jumpRearingCounter > 0 && ++this.jumpRearingCounter > 20) {
            this.jumpRearingCounter = 0;
            this.setRearing(false);
        }

        if (this.tailCounter > 0 && ++this.tailCounter > 8) {
            this.tailCounter = 0;
        }

        if (this.sprintCounter > 0) {
            ++this.sprintCounter;

            if (this.sprintCounter > 300) {
                this.sprintCounter = 0;
            }
        }

        this.prevHeadLean = this.headLean;

        if (this.isEatingHaystack()) {
            this.headLean += (1.0F - this.headLean) * 0.4F + 0.05F;

            if (this.headLean > 1.0F) {
                this.headLean = 1.0F;
            }
        } else {
            this.headLean += (0.0F - this.headLean) * 0.4F - 0.05F;

            if (this.headLean < 0.0F) {
                this.headLean = 0.0F;
            }
        }

        this.prevRearingAmount = this.rearingAmount;

        if (this.isRearing()) {
            this.headLean = 0.0F;
            this.prevHeadLean = this.headLean;
            this.rearingAmount += (1.0F - this.rearingAmount) * 0.4F + 0.05F;

            if (this.rearingAmount > 1.0F) {
                this.rearingAmount = 1.0F;
            }
        } else {
            this.allowStandSliding = false;
            this.rearingAmount += (0.8F * this.rearingAmount * this.rearingAmount * this.rearingAmount
                    - this.rearingAmount) * 0.6F - 0.05F;

            if (this.rearingAmount < 0.0F) {
                this.rearingAmount = 0.0F;
            }
        }

        this.prevMouthOpenness = this.mouthOpenness;

        if (this.getReindeerWatchableBoolean(64)) {
            this.mouthOpenness += (1.0F - this.mouthOpenness) * 0.7F + 0.05F;

            if (this.mouthOpenness > 1.0F) {
                this.mouthOpenness = 1.0F;
            }
        } else {
            this.mouthOpenness += (0.0F - this.mouthOpenness) * 0.7F - 0.05F;

            if (this.mouthOpenness < 0.0F) {
                this.mouthOpenness = 0.0F;
            }
        }
    }

    private void openReindeerMouth() {
        if (!this.level.isClientSide) {
            this.openMouthCounter = 1;
            this.setReindeerWatchableBoolean(64, true);
        }
    }

    public void setEatingHaystack(boolean p_110227_1_) {
        this.setReindeerWatchableBoolean(16, p_110227_1_);
    }

    public void setRearing(boolean rearing) {
        if (rearing) {
            this.setEatingHaystack(false);
        }

        this.setReindeerWatchableBoolean(32, rearing);
    }

    private void makeReindeerRear() {
        if (this.isControlledByLocalInstance()) {
            this.jumpRearingCounter = 1;
            this.setRearing(true);
        }
    }

    @Override
    public void travel(Vec3 vec) {
        if (this.isVehicle() && this.canBeControlledByRider()) {
            LivingEntity entitylivingbase = (LivingEntity) this.getControllingPassenger();
            this.yRot = entitylivingbase.yRot;
            this.yRotO = this.yRot;
            this.xRot = entitylivingbase.xRot * 0.5F;
            this.setRot(this.yRot, this.xRot);
            this.yBodyRot = this.yRot;
            this.yHeadRot = this.yBodyRot;
            vec = vec.add(entitylivingbase.xxa * 0.5F - vec.x, vec.y, vec.z);
            vec = vec.add(vec.x, vec.y, entitylivingbase.zza - vec.z);

            if (vec.z <= 0.0F) {
                vec = vec.multiply(1, 1, 0.25F);
                this.gallopTime = 0;
            }

            if (this.onGround && this.jumpPower == 0.0F && this.isRearing() && !this.allowStandSliding) {
                vec = vec.multiply(0, 1, 0);
            }

            if (this.jumpPower > 0.0F && !this.isReindeerJumping() && this.onGround) {
                this.setDeltaMovement(this.getDeltaMovement().add(0, this.getReindeerJumpStrength() * this.jumpPower - this.getDeltaMovement().y, 0));

                if (this.hasEffect(MobEffects.JUMP)) {
                    this.setDeltaMovement(this.getDeltaMovement().add(0, (this.getEffect(MobEffects.JUMP).getAmplifier() + 1) * 0.1F, 0));
                }

                this.setReindeerJumping(true);
                this.hasImpulse = true;

                if (vec.z > 0.0F) {
                    float f = Mth.sin(this.yRot * 0.017453292F);
                    float f1 = Mth.cos(this.yRot * 0.017453292F);
                    this.setDeltaMovement(this.getDeltaMovement().add(-0.4F * f * this.jumpPower, 0, 0.4F * f1 * this.jumpPower));
                    this.playSound(SoundEvents.HORSE_JUMP, 0.4F, 1.0F);
                }

                this.jumpPower = 0.0F;
            }

            this.flyingSpeed = this.getSpeed() * 0.1F;

            if (this.isControlledByLocalInstance()) {
                this.setSpeed((float) this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
                super.travel(vec);
            } else if (entitylivingbase instanceof Player) {
                this.setDeltaMovement(0,0,0);
            }

            if (this.onGround) {
                this.jumpPower = 0.0F;
                this.setReindeerJumping(false);
            }

            this.animationSpeedOld = this.animationSpeed;
            double d1 = this.getX() - this.xo;
            double d0 = this.getZ() - this.zo;
            float f2 = Mth.sqrt(d1 * d1 + d0 * d0) * 4.0F;

            if (f2 > 1.0F) {
                f2 = 1.0F;
            }

            this.animationSpeed += (f2 - this.animationSpeed) * 0.4F;
            this.animationPosition += this.animationSpeed;
        } else {
            this.flyingSpeed = 0.02F;
            super.travel(vec);
        }
    }

    @Override
    public void setCustomName(Component comp) {
        if(comp.getString().equalsIgnoreCase("rudolph")) {
            if(this.getVariant().isPresent() && !this.getVariantNameOrEmpty().endsWith("_christmas")) {
                this.setType(this.getVariantNameOrEmpty() + "_christmas");
            }
        }
        super.setCustomName(comp);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("EatingHaystack", this.isEatingHaystack());
        compound.putBoolean("Bred", this.isBreeding());

        this.writeType(compound);
        compound.putBoolean("IsParentRudolph", this.parentRudolph);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setEatingHaystack(compound.getBoolean("EatingHaystack"));
        this.setBreeding(compound.getBoolean("Bred"));

        this.parentRudolph = compound.getBoolean("IsParentRudolph");

        this.readType(compound);
        Calendar calendar = Calendar.getInstance();
        if (this.getVariantNameOrEmpty().endsWith("_christmas") && !(calendar.get(Calendar.MONTH) + 1 == 12 && calendar.get(Calendar.DATE) >= 22 && calendar.get(Calendar.DATE) <= 28)
                && !(this.getCustomName().getString().equalsIgnoreCase("rudolph") || this.parentRudolph)) {
            this.setType(this.getVariantNameOrEmpty().substring(0, 1)); // Remove red noses after Christmas season after loading entity
        }
    }

    /**
     * Return true if the reindeer entity ready to mate. (no rider, not riding,
     * tame, adult, not sterile...)
     */
    protected boolean canMate() {
        return !this.isVehicle() && this.getVehicle() == null && !this.isBaby()
                && this.getHealth() >= this.getMaxHealth() && this.isInLove();
    }

    protected void setOffspringAttributes(AgableMob p_190681_1_, EntityReindeer p_190681_2_) {
        double d0 = this.getAttributeBaseValue(Attributes.MAX_HEALTH) + p_190681_1_.getAttributeBaseValue(Attributes.MAX_HEALTH) + (double) this.getModifiedMaxHealth();
        p_190681_2_.getAttribute(Attributes.MAX_HEALTH).setBaseValue(d0 / 3.0D);
        double d1 = this.getAttributeBaseValue(Attributes.JUMP_STRENGTH) + p_190681_1_.getAttributeBaseValue(Attributes.JUMP_STRENGTH) + this.getModifiedJumpStrength();
        p_190681_2_.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(d1 / 3.0D);
        double d2 = this.getAttributeBaseValue(Attributes.MOVEMENT_SPEED) + p_190681_1_.getAttributeBaseValue(Attributes.MOVEMENT_SPEED) + this.getModifiedMovementSpeed();
        p_190681_2_.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(d2 / 3.0D);
    }

    /**
     * returns true if all the conditions for steering the entity are met. For pigs,
     * this is true if it is being ridden by a player and the player is holding a
     * carrot-on-a-stick
     */
    @Override
    public boolean canBeControlledByRider() {
        return this.getControllingPassenger() instanceof LivingEntity;
    }

    @Environment(EnvType.CLIENT)
    public float getGrassEatingAmount(float p_110258_1_) {
        return this.prevHeadLean + (this.headLean - this.prevHeadLean) * p_110258_1_;
    }

    @Environment(EnvType.CLIENT)
    public float getRearingAmount(float p_110223_1_) {
        return this.prevRearingAmount + (this.rearingAmount - this.prevRearingAmount) * p_110223_1_;
    }

    @Environment(EnvType.CLIENT)
    public float getMouthOpennessAngle(float p_110201_1_) {
        return this.prevMouthOpenness + (this.mouthOpenness - this.prevMouthOpenness) * p_110201_1_;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void onPlayerJump(int jumpPowerIn) {
        if (jumpPowerIn < 0) {
            jumpPowerIn = 0;
        } else {
            this.allowStandSliding = true;
            this.makeReindeerRear();
        }

        if (jumpPowerIn >= 90) {
            this.jumpPower = 1.0F;
        } else {
            this.jumpPower = 0.4F + 0.4F * jumpPowerIn / 90.0F;
        }
    }

    @Override
    public boolean canJump() {
        return true;
    }

    @Override
    public void handleStartJump(int p_184775_1_) {
        this.allowStandSliding = true;
        this.makeReindeerRear();
    }

    @Override
    public void handleStopJump() {
    }

    /**
     * "Spawns particles for the reindeer entity. par1 tells whether to spawn
     * hearts. If it is false, it spawns smoke."
     */
    @Environment(EnvType.CLIENT)
    protected void spawnReindeerParticles(boolean p_110216_1_) {
        SimpleParticleType enumparticletypes = p_110216_1_ ? ParticleTypes.HEART : ParticleTypes.SMOKE;

        for (int i = 0; i < 7; ++i) {
            double d0 = this.random.nextGaussian() * 0.02D;
            double d1 = this.random.nextGaussian() * 0.02D;
            double d2 = this.random.nextGaussian() * 0.02D;
            this.level.addParticle(enumparticletypes,
                    this.getX() + this.random.nextFloat() * this.getBbWidth() * 2.0F - this.getBbWidth(),
                    this.getY() + 0.5D + this.random.nextFloat() * this.getBbHeight(),
                    this.getZ() + this.random.nextFloat() * this.getBbWidth() * 2.0F - this.getBbWidth(), d0, d1, d2);
        }
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void handleEntityEvent(byte id) {
        if (id == 7) {
            this.spawnReindeerParticles(true);
        } else if (id == 6) {
            this.spawnReindeerParticles(false);
        } else {
            super.handleEntityEvent(id);
        }
    }

    @Override
    public void positionRider(Entity passenger) {
        super.positionRider(passenger);

        if (passenger instanceof Mob) {
            Mob entityliving = (Mob) passenger;
            this.yBodyRot = entityliving.yBodyRot;
        }

        if (this.prevRearingAmount > 0.0F) {
            float f3 = Mth.sin(this.yBodyRot * 0.017453292F);
            float f = Mth.cos(this.yBodyRot * 0.017453292F);
            float f1 = 0.7F * this.prevRearingAmount;
            float f2 = 0.15F * this.prevRearingAmount;
            passenger.setPos(this.getX() + f1 * f3,
                    this.getY() + this.getPassengersRidingOffset() + passenger.getMyRidingOffset() + f2, this.getZ() - f1 * f);

            if (passenger instanceof LivingEntity) {
                ((LivingEntity) passenger).yBodyRot = this.yBodyRot;
            }
        }
    }

    protected float getModifiedMaxHealth() {
        return 15.0F + (float) this.random.nextInt(8) + (float) this.random.nextInt(9);
    }

    protected double getModifiedJumpStrength() {
        return (double) 0.4F + this.random.nextDouble() * 0.2D + this.random.nextDouble() * 0.2D + this.random.nextDouble() * 0.2D;
    }

    protected double getModifiedMovementSpeed() {
        return ((double) 0.45F + this.random.nextDouble() * 0.3D + this.random.nextDouble() * 0.3D + this.random.nextDouble() * 0.3D) * 0.25D;
    }

    @Override
    public boolean onClimbable() {
        return false;
    }

    @Override
    public Entity getControllingPassenger() {
        return this.getPassengers().isEmpty() ? null : this.getPassengers().get(0);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, SpawnGroupData livingdata, CompoundTag compound) {
        this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(this.getModifiedMaxHealth());
        this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(this.getModifiedMovementSpeed());
        this.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(this.getModifiedJumpStrength());
        return this.initAgeableData(world, reason, super.finalizeSpawn(world, difficulty, reason, livingdata, compound));
    }

    @Override
    public IVariant getRandomType() {
        Calendar calendar = Calendar.getInstance();
        boolean isChristmasSeason = calendar.get(Calendar.MONTH) + 1 == 12 && calendar.get(Calendar.DATE) >= 22 && calendar.get(Calendar.DATE) <= 28;
        boolean redNosed = this.random.nextInt(9) == 0;
        return this.getContainer().getVariantForName((this.random.nextInt(4) + 1) + (isChristmasSeason && redNosed ? "_christmas" : ""));
    }

    @Override
    public boolean removeWhenFarAway(double range) {
        return despawn(range);
    }

    @Override
    public EntityReindeer getImplementation() {
        return this;
    }

    @Override
    public EntityTypeContainer<EntityReindeer> getContainer() {
        return ModEntities.REINDEER;
    }

    @Override
    public void doHeadDrop() {
        this.getHeadType().drop(this, 12, this.getContainer().getVariantForName(this.getVariantNameOrEmpty().substring(0, 1)));
    }

}
