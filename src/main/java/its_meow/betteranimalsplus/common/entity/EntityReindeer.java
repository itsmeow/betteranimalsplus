package its_meow.betteranimalsplus.common.entity;

import java.util.Calendar;

import javax.annotation.Nullable;

import its_meow.betteranimalsplus.common.entity.util.EntityTypeContainer;
import its_meow.betteranimalsplus.common.entity.util.IDropHead;
import its_meow.betteranimalsplus.common.entity.util.IVariantTypes;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModLootTables;
import its_meow.betteranimalsplus.init.ModTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.IJumpingMount;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class EntityReindeer extends AnimalEntity implements IJumpingMount, IVariantTypes<EntityReindeer>, IDropHead {

    protected static final java.util.function.Predicate<LivingEntity> IS_REINDEER_BREEDING = (entity) -> {
        return entity instanceof EntityReindeer && ((EntityReindeer)entity).isBreeding();
    };
    private static final EntityPredicate PARENT_TARGETING = (new EntityPredicate()).setDistance(16.0D).allowInvulnerable().allowFriendlyFire().setLineOfSiteRequired().setCustomPredicate(IS_REINDEER_BREEDING);
    protected static final IAttribute JUMP_STRENGTH = (new RangedAttribute((IAttribute) null, "reindeer.jumpStrength", 0.7D, 0.0D, 2.0D)).setDescription("Jump Strength").setShouldWatch(true);
    protected static final DataParameter<Byte> STATUS = EntityDataManager.<Byte>createKey(EntityReindeer.class, DataSerializers.BYTE);
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
    public static boolean CREATE_SNOW = true;

    public EntityReindeer(World worldIn) {
        super(ModEntities.REINDEER.entityType, worldIn);
        this.stepHeight = 1.0F;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.2D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D, EntityReindeer.class));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 0.7D));
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.registerTypeKey();
        this.dataManager.register(STATUS, Byte.valueOf((byte) 0));
    }

    // Implementation
    @Override
    public boolean processInteract(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        boolean flag = !itemstack.isEmpty();

        if (flag && itemstack.getItem() instanceof SpawnEggItem) {
            return super.processInteract(player, hand);
        } else {
            if (!this.isChild()) {
                if (player.isCrouching()) {
                    return false;
                }

                if (this.isBeingRidden()) {
                    return super.processInteract(player, hand);
                }
            }

            if (flag) {
                if (this.handleEating(player, itemstack)) {
                    if (!player.isCreative()) {
                        itemstack.shrink(1);
                    }

                    return true;
                }

                if (itemstack.interactWithEntity(player, this, hand)) {
                    return true;
                }

            }

            if (this.isChild()) {
                return super.processInteract(player, hand);
            } else {
                this.mountTo(player);
                return true;
            }
        }
    }

    /**
     * Returns true if the mob is currently able to mate with the specified mob.
     */
    @Override
    public boolean canMateWith(AnimalEntity otherAnimal) {
        if (otherAnimal == this) {
            return false;
        } else if (!(otherAnimal instanceof EntityReindeer)) {
            return false;
        } else {
            return this.canMate() && ((EntityReindeer) otherAnimal).canMate();
        }
    }

    @Override
    public AgeableEntity createChild(AgeableEntity ageable) {
        EntityReindeer reindeer = new EntityReindeer(this.world);
        this.setOffspringAttributes(ageable, reindeer);
        if(ageable instanceof EntityReindeer) {
            EntityReindeer other = (EntityReindeer) ageable;
            if(other.getContainer().getVariantIndex(other.getVariantName()) > 4) { // if one of them is red-nosed make that one take dominance
                reindeer.setType(other.getVariant());
            } else { // none are red-nosed, just use this one's type
                reindeer.setType(this.getVariant());
            }

            if((other.hasCustomName() && other.getCustomName().getString().equalsIgnoreCase("rudolph"))
                    || (this.hasCustomName() && this.getCustomName().getString().equalsIgnoreCase("rudolph"))) {
                reindeer.parentRudolph = true;
            }
        } else { // same as above
            reindeer.setType(this.getVariant());
        }
        return reindeer;
    }

    // Abstract Reindeer

    protected boolean getReindeerWatchableBoolean(int p_110233_1_) {
        return (this.dataManager.get(EntityReindeer.STATUS).byteValue() & p_110233_1_) != 0;
    }

    protected void setReindeerWatchableBoolean(int p_110208_1_, boolean p_110208_2_) {
        byte b0 = this.dataManager.get(EntityReindeer.STATUS).byteValue();

        if (p_110208_2_) {
            this.dataManager.set(EntityReindeer.STATUS, Byte.valueOf((byte) (b0 | p_110208_1_)));
        } else {
            this.dataManager.set(EntityReindeer.STATUS, Byte.valueOf((byte) (b0 & ~p_110208_1_)));
        }
    }

    public float getReindeerSize() {
        return 0.5F;
    }

    public boolean isReindeerJumping() {
        return this.reindeerJumping;
    }

    public void setReindeerJumping(boolean jumping) {
        this.reindeerJumping = jumping;
    }

    @Override
    public boolean canBeLeashedTo(PlayerEntity player) {
        return super.canBeLeashedTo(player);
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
    public boolean attackEntityFrom(DamageSource source, float amount) {
        Entity entity = source.getTrueSource();
        return this.isBeingRidden() && entity != null && this.isRidingOrBeingRiddenBy(entity) ? false
                : super.attackEntityFrom(source, amount);
    }

    /**
     * Returns true if this entity should push and be pushed by other entities when
     * colliding.
     */
    @Override
    public boolean canBePushed() {
        return !this.isBeingRidden();
    }

    private void eatingReindeer() {
        this.openReindeerMouth();

        if (!this.isSilent()) {
            this.world.playSound((PlayerEntity) null, this.getPosX(), this.getPosY(), this.getPosZ(), SoundEvents.ENTITY_HORSE_EAT,
                    this.getSoundCategory(), 1.0F, 1.0F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F);
        }
    }

    @Override
    public boolean onLivingFall(float distance, float damageMultiplier) {
        if (distance > 1.0F) {
            this.playSound(SoundEvents.ENTITY_HORSE_LAND, 0.4F, 1.0F);
        }

        int i = MathHelper.ceil((distance * 0.5F - 3.0F) * damageMultiplier);

        if (i > 0) {
            this.attackEntityFrom(DamageSource.FALL, i);

            if (this.isBeingRidden()) {
                for (Entity entity : this.getRecursivePassengers()) {
                    entity.attackEntityFrom(DamageSource.FALL, i);
                }
            }
            BlockPos pos = new BlockPos(this.getPosX(), this.getPosY() - 0.2D - this.prevRotationYaw, this.getPosZ());
            BlockState iblockstate = this.world.getBlockState(pos);
            Block block = iblockstate.getBlock();

            if (iblockstate.getMaterial() != Material.AIR && !this.isSilent()) {
                SoundType soundtype = block.getSoundType(block.getDefaultState(), this.world, pos, this);
                this.world.playSound((PlayerEntity) null, this.getPosX(), this.getPosY(), this.getPosZ(), soundtype.getStepSound(),
                        this.getSoundCategory(), soundtype.getVolume() * 0.5F, soundtype.getPitch() * 0.75F);
            }
        }
        return true;
    }

    public double getReindeerJumpStrength() {
        return this.getAttribute(EntityReindeer.JUMP_STRENGTH).getValue();
    }

    @Override
    @Nullable
    protected SoundEvent getDeathSound() {
        this.openReindeerMouth();
        return null;
    }

    @Override
    @Nullable
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        this.openReindeerMouth();

        if (this.rand.nextInt(3) == 0) {
            this.makeReindeerRear();
        }

        return null;
    }

    @Override
    @Nullable
    protected SoundEvent getAmbientSound() {
        this.openReindeerMouth();

        if (this.rand.nextInt(10) == 0 && !this.isMovementBlocked()) {
            this.makeReindeerRear();
        }

        return null;
    }

    @Nullable
    protected SoundEvent getAngrySound() {
        this.openReindeerMouth();
        this.makeReindeerRear();
        return null;
    }

    protected void playStepSound(BlockPos pos, Block blockIn) {
        if (!blockIn.getDefaultState().getMaterial().isLiquid()) {
            SoundType soundtype = blockIn.getSoundType(blockIn.getDefaultState(), this.world, pos, this);

            if (this.world.getBlockState(pos.up()).getBlock() == Blocks.SNOW) {
                soundtype = Blocks.SNOW.getSoundType(Blocks.SNOW.getDefaultState(), this.world, pos, this);
            }

            if (this.isBeingRidden() && this.canGallop) {
                ++this.gallopTime;

                if (this.gallopTime > 5 && this.gallopTime % 3 == 0) {
                    this.playGallopSound(soundtype);
                } else if (this.gallopTime <= 5) {
                    this.playSound(SoundEvents.ENTITY_HORSE_STEP_WOOD, soundtype.getVolume() * 0.15F,
                            soundtype.getPitch());
                }
            } else if (soundtype == SoundType.WOOD) {
                this.playSound(SoundEvents.ENTITY_HORSE_STEP_WOOD, soundtype.getVolume() * 0.15F, soundtype.getPitch());
            } else {
                this.playSound(SoundEvents.ENTITY_HORSE_STEP, soundtype.getVolume() * 0.15F, soundtype.getPitch());
            }
        }
    }

    protected void playGallopSound(SoundType p_190680_1_) {
        this.playSound(SoundEvents.ENTITY_HORSE_GALLOP, p_190680_1_.getVolume() * 0.15F, p_190680_1_.getPitch());
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttributes().registerAttribute(EntityReindeer.JUMP_STRENGTH);
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.22499999403953552D);
    }

    /**
     * Will return how many at most can spawn in a chunk at once.
     */
    @Override
    public int getMaxSpawnedInChunk() {
        return 6;
    }

    public int getMaxTemper() {
        return 100;
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    @Override
    protected float getSoundVolume() {
        return 0.8F;
    }

    /**
     * Get number of ticks, at least during which the living entity will be silent.
     */
    @Override
    public int getTalkInterval() {
        return 400;
    }

    protected boolean handleEating(PlayerEntity player, ItemStack stack) {
        boolean flag = false;
        float f = 0.0F;
        int i = 0;
        Item item = stack.getItem();

        if (item == Items.WHEAT || item == Items.CARROT) {
            f = 2.0F;
            i = 20;
            if (!this.isChild() && !this.isInLove()) {
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

            if (this.getGrowingAge() == 0 && !this.isInLove()) {
                flag = true;
                this.setInLove(player);
            }
        } else if (item == Items.GOLDEN_APPLE) {
            f = 10.0F;
            i = 240;

            if (this.getGrowingAge() == 0 && !this.isInLove()) {
                flag = true;
                this.setInLove(player);
            }
        }

        if (this.getHealth() < this.getMaxHealth() && f > 0.0F) {
            this.heal(f);
            flag = true;
        }

        if (this.isChild() && i > 0) {
            this.world.addParticle(ParticleTypes.HAPPY_VILLAGER,
                    this.getPosX() + this.rand.nextFloat() * this.getWidth() * 2.0F - this.getWidth(),
                    this.getPosY() + 0.5D + this.rand.nextFloat() * this.getHeight(),
                    this.getPosZ() + this.rand.nextFloat() * this.getWidth() * 2.0F - this.getWidth(), 0.0D, 0.0D, 0.0D);

            if (!this.world.isRemote) {
                this.addGrowth(i);
            }

            flag = true;
        }
        if (flag) {
            this.eatingReindeer();
        }

        return flag;
    }

    @Override
    public void onDeath(DamageSource cause) {
        super.onDeath(cause);
        this.doHeadDrop();
    }

    @Override
    @Nullable
    protected ResourceLocation getLootTable() {
        return ModLootTables.reindeer;
    }

    protected void mountTo(PlayerEntity player) {
        player.rotationYaw = this.rotationYaw;
        player.rotationPitch = this.rotationPitch;
        this.setEatingHaystack(false);
        this.setRearing(false);
        if(player instanceof ServerPlayerEntity) {
            ModTriggers.RIDE_REINDEER.trigger((ServerPlayerEntity) player);
        }

        if (!this.world.isRemote) {
            player.startRiding(this);
        }
    }

    /**
     * Dead and sleeping entities cannot move
     */
    @Override
    protected boolean isMovementBlocked() {
        return super.isMovementBlocked() && this.isBeingRidden() && true || this.isEatingHaystack() || this.isRearing();
    }

    /**
     * Checks if the parameter is an item which this animal can be fed to breed it
     * (wheat, carrots or seeds depending on the animal type)
     */
    @Override
    public boolean isBreedingItem(ItemStack stack) {
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
    public void livingTick() {
        if(this.rand.nextInt(200) == 0) {
            this.moveTail();
        }

        super.livingTick();
        if(world.isRemote() && CREATE_SNOW  && rand.nextInt(10) == 0) {
            this.world.addParticle(ParticleTypes.POOF, this.getPosX() + this.rand.nextInt(4) - 2F, this.getPosY() + this.rand.nextInt(4), this.getPosZ() + this.rand.nextInt(4) - 2F, 0F, -0.2F, 0F);
        }
        if(!this.world.isRemote) {
            if (this.rand.nextInt(900) == 0 && this.deathTime == 0) {
                this.heal(1.0F);
            }

            if (this.canEatGrass()) {
                if (!this.isEatingHaystack() && !this.isBeingRidden() && this.rand.nextInt(300) == 0
                        && this.world
                                .getBlockState(new BlockPos(MathHelper.floor(this.getPosX()),
                                        MathHelper.floor(this.getPosY()) - 1, MathHelper.floor(this.getPosZ())))
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
        if(this.isBreeding() && this.isChild() && !this.isEatingHaystack()) {
            LivingEntity livingentity = this.world.getClosestEntityWithinAABB(AbstractHorseEntity.class, PARENT_TARGETING, this, this.getPosX(), this.getPosY(), this.getPosZ(), this.getBoundingBox().grow(16.0D));
            if(livingentity != null && this.getDistanceSq(livingentity) > 4.0D) {
                this.navigator.getPathToEntity(livingentity, 0);
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

        if (this.canPassengerSteer() && this.jumpRearingCounter > 0 && ++this.jumpRearingCounter > 20) {
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
        if (!this.world.isRemote) {
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
        if (this.canPassengerSteer()) {
            this.jumpRearingCounter = 1;
            this.setRearing(true);
        }
    }

    @Override
    public void travel(Vec3d vec) {
        if (this.isBeingRidden() && this.canBeSteered()) {
            LivingEntity entitylivingbase = (LivingEntity) this.getControllingPassenger();
            this.rotationYaw = entitylivingbase.rotationYaw;
            this.prevRotationYaw = this.rotationYaw;
            this.rotationPitch = entitylivingbase.rotationPitch * 0.5F;
            this.setRotation(this.rotationYaw, this.rotationPitch);
            this.renderYawOffset = this.rotationYaw;
            this.rotationYawHead = this.renderYawOffset;
            vec = vec.add(entitylivingbase.moveStrafing * 0.5F - vec.x, vec.y, vec.z);
            vec = vec.add(vec.x, vec.y, entitylivingbase.moveForward - vec.z);

            if (vec.z <= 0.0F) {
                vec = vec.mul(1, 1, 0.25F);
                this.gallopTime = 0;
            }

            if (this.onGround && this.jumpPower == 0.0F && this.isRearing() && !this.allowStandSliding) {
                vec = vec.mul(0, 1, 0);
            }

            if (this.jumpPower > 0.0F && !this.isReindeerJumping() && this.onGround) {
                this.setMotion(this.getMotion().add(0, this.getReindeerJumpStrength() * this.jumpPower - this.getMotion().y, 0));

                if (this.isPotionActive(Effects.JUMP_BOOST)) {
                    this.setMotion(this.getMotion().add(0, (this.getActivePotionEffect(Effects.JUMP_BOOST).getAmplifier() + 1) * 0.1F, 0));
                }

                this.setReindeerJumping(true);
                this.isAirBorne = true;

                if (vec.z > 0.0F) {
                    float f = MathHelper.sin(this.rotationYaw * 0.017453292F);
                    float f1 = MathHelper.cos(this.rotationYaw * 0.017453292F);
                    this.setMotion(this.getMotion().add(-0.4F * f * this.jumpPower, 0, 0.4F * f1 * this.jumpPower));
                    this.playSound(SoundEvents.ENTITY_HORSE_JUMP, 0.4F, 1.0F);
                }

                this.jumpPower = 0.0F;
            }

            this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;

            if (this.canPassengerSteer()) {
                this.setAIMoveSpeed((float) this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue());
                super.travel(vec);
            } else if (entitylivingbase instanceof PlayerEntity) {
                this.setMotion(0,0,0);
            }

            if (this.onGround) {
                this.jumpPower = 0.0F;
                this.setReindeerJumping(false);
            }

            this.prevLimbSwingAmount = this.limbSwingAmount;
            double d1 = this.getPosX() - this.prevPosX;
            double d0 = this.getPosZ() - this.prevPosZ;
            float f2 = MathHelper.sqrt(d1 * d1 + d0 * d0) * 4.0F;

            if (f2 > 1.0F) {
                f2 = 1.0F;
            }

            this.limbSwingAmount += (f2 - this.limbSwingAmount) * 0.4F;
            this.limbSwing += this.limbSwingAmount;
        } else {
            this.jumpMovementFactor = 0.02F;
            super.travel(vec);
        }
    }

    @Override
    public void setCustomName(ITextComponent comp) {
        if(comp.getString().toLowerCase().equals("rudolph")) {
            if(this.getVariant() != null && !this.getVariantName().endsWith("_christmas")) {
                this.setType(this.getVariantName() + "_christmas");
            }
        }
        super.setCustomName(comp);
    }

    @Override
    public boolean writeUnlessRemoved(CompoundNBT compound) {
        compound.putBoolean("EatingHaystack", this.isEatingHaystack());
        compound.putBoolean("Bred", this.isBreeding());

        this.writeType(compound);
        compound.putBoolean("IsParentRudolph", this.parentRudolph);
        return super.writeUnlessRemoved(compound);
    }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        this.setEatingHaystack(compound.getBoolean("EatingHaystack"));
        this.setBreeding(compound.getBoolean("Bred"));

        this.parentRudolph = compound.getBoolean("IsParentRudolph");

        IAttributeInstance iattributeinstance = this.getAttributes().getAttributeInstanceByName("Speed");

        if (iattributeinstance != null) {
            this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED)
                    .setBaseValue(iattributeinstance.getBaseValue() * 0.25D);
        }

        this.readType(compound);
        Calendar calendar = Calendar.getInstance();
        if (this.getVariantName().endsWith("_christmas") && !(calendar.get(2) + 1 == 12 && calendar.get(5) >= 22 && calendar.get(5) <= 28)
                && !(this.getCustomName().getString().toLowerCase().equals("rudolph") || this.parentRudolph)) {
            this.setType(this.getVariantName().substring(0, 1)); // Remove red noses after Christmas season after loading entity
        }
    }

    /**
     * Return true if the reindeer entity ready to mate. (no rider, not riding,
     * tame, adult, not sterile...)
     */
    protected boolean canMate() {
        return !this.isBeingRidden() && this.getRidingEntity() == null && !this.isChild()
                && this.getHealth() >= this.getMaxHealth() && this.isInLove();
    }

    protected void setOffspringAttributes(AgeableEntity p_190681_1_, EntityReindeer p_190681_2_) {
        double d0 = this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).getBaseValue()
                + p_190681_1_.getAttribute(SharedMonsterAttributes.MAX_HEALTH).getBaseValue()
                + this.getModifiedMaxHealth();
        p_190681_2_.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(d0 / 3.0D);
        double d1 = this.getAttribute(EntityReindeer.JUMP_STRENGTH).getBaseValue()
                + p_190681_1_.getAttribute(EntityReindeer.JUMP_STRENGTH).getBaseValue()
                + this.getModifiedJumpStrength();
        p_190681_2_.getAttribute(EntityReindeer.JUMP_STRENGTH).setBaseValue(d1 / 3.0D);
        double d2 = this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getBaseValue()
                + p_190681_1_.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getBaseValue()
                + this.getModifiedMovementSpeed();
        p_190681_2_.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(d2 / 3.0D);
    }

    /**
     * returns true if all the conditions for steering the entity are met. For pigs,
     * this is true if it is being ridden by a player and the player is holding a
     * carrot-on-a-stick
     */
    @Override
    public boolean canBeSteered() {
        return this.getControllingPassenger() instanceof LivingEntity;
    }

    @OnlyIn(Dist.CLIENT)
    public float getGrassEatingAmount(float p_110258_1_) {
        return this.prevHeadLean + (this.headLean - this.prevHeadLean) * p_110258_1_;
    }

    @OnlyIn(Dist.CLIENT)
    public float getRearingAmount(float p_110223_1_) {
        return this.prevRearingAmount + (this.rearingAmount - this.prevRearingAmount) * p_110223_1_;
    }

    @OnlyIn(Dist.CLIENT)
    public float getMouthOpennessAngle(float p_110201_1_) {
        return this.prevMouthOpenness + (this.mouthOpenness - this.prevMouthOpenness) * p_110201_1_;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void setJumpPower(int jumpPowerIn) {
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
    @OnlyIn(Dist.CLIENT)
    protected void spawnReindeerParticles(boolean p_110216_1_) {
        BasicParticleType enumparticletypes = p_110216_1_ ? ParticleTypes.HEART : ParticleTypes.SMOKE;

        for (int i = 0; i < 7; ++i) {
            double d0 = this.rand.nextGaussian() * 0.02D;
            double d1 = this.rand.nextGaussian() * 0.02D;
            double d2 = this.rand.nextGaussian() * 0.02D;
            this.world.addParticle(enumparticletypes,
                    this.getPosX() + this.rand.nextFloat() * this.getWidth() * 2.0F - this.getWidth(),
                    this.getPosY() + 0.5D + this.rand.nextFloat() * this.getHeight(),
                    this.getPosZ() + this.rand.nextFloat() * this.getWidth() * 2.0F - this.getWidth(), d0, d1, d2);
        }
    }

    /**
     * Handler for {@link World#setEntityState}
     */
    @Override
    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 7) {
            this.spawnReindeerParticles(true);
        } else if (id == 6) {
            this.spawnReindeerParticles(false);
        } else {
            super.handleStatusUpdate(id);
        }
    }

    @Override
    public void updatePassenger(Entity passenger) {
        super.updatePassenger(passenger);

        if (passenger instanceof MobEntity) {
            MobEntity entityliving = (MobEntity) passenger;
            this.renderYawOffset = entityliving.renderYawOffset;
        }

        if (this.prevRearingAmount > 0.0F) {
            float f3 = MathHelper.sin(this.renderYawOffset * 0.017453292F);
            float f = MathHelper.cos(this.renderYawOffset * 0.017453292F);
            float f1 = 0.7F * this.prevRearingAmount;
            float f2 = 0.15F * this.prevRearingAmount;
            passenger.setPosition(this.getPosX() + f1 * f3,
                    this.getPosY() + this.getMountedYOffset() + passenger.getYOffset() + f2, this.getPosZ() - f1 * f);

            if (passenger instanceof LivingEntity) {
                ((LivingEntity) passenger).renderYawOffset = this.renderYawOffset;
            }
        }
    }

    /**
     * Returns randomized max health
     */
    protected float getModifiedMaxHealth() {
        return 15.0F + this.rand.nextInt(8) + this.rand.nextInt(9);
    }

    /**
     * Returns randomized jump strength
     */
    protected double getModifiedJumpStrength() {
        return 0.4000000059604645D + this.rand.nextDouble() * 0.2D + this.rand.nextDouble() * 0.2D
                + this.rand.nextDouble() * 0.2D;
    }

    /**
     * Returns randomized movement speed
     */
    protected double getModifiedMovementSpeed() {
        return (0.44999998807907104D + this.rand.nextDouble() * 0.3D + this.rand.nextDouble() * 0.3D
                + this.rand.nextDouble() * 0.3D) * 0.25D;
    }

    @Override
    public boolean isOnLadder() {
        return false;
    }

    public boolean wearsArmor() {
        return false;
    }

    public boolean isArmor(ItemStack stack) {
        return false;
    }

    @Override
    @Nullable
    public Entity getControllingPassenger() {
        return this.getPassengers().isEmpty() ? null : (Entity) this.getPassengers().get(0);
    }

    @Override
    @Nullable
    public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData livingdata, CompoundNBT compound) {
        livingdata = super.onInitialSpawn(world, difficulty, reason, livingdata, compound);

        if (!this.isChild()) {
            Calendar calendar = Calendar.getInstance();
            boolean isChristmasSeason = calendar.get(2) + 1 == 12 && calendar.get(5) >= 22 && calendar.get(5) <= 28;
            boolean redNosed = this.rand.nextInt(9) == 0;
            String variant = (this.rand.nextInt(4) + 1) + (isChristmasSeason && redNosed ? "_christmas" : "");
            boolean flag = false;

            if (livingdata instanceof AgeableTypeData) {
                variant = ((AgeableTypeData) livingdata).typeData;
                flag = true;
            } else if(livingdata instanceof AgeableData) {
                livingdata = new AgeableTypeData((AgeableData)livingdata, variant);
                flag = true;
            } else {
                livingdata = new AgeableTypeData(variant);
            }

            this.setType(variant);

            if (flag) {
                this.setGrowingAge(-24000);
            }
        }
        this.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw, 0F);
        return livingdata;
    }
    
    @Override
    public boolean canDespawn(double range) {
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
        this.getHeadType().drop(this, 12, this.getContainer().getVariant(this.getVariantName().substring(0, 1)));
    }

}
