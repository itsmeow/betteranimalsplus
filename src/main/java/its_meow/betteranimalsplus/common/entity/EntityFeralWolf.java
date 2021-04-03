package its_meow.betteranimalsplus.common.entity;

import dev.itsmeow.imdlib.entity.util.EntityVariant;
import dev.itsmeow.imdlib.entity.util.IVariant;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.entity.ai.HungerNearestAttackableTargetGoal;
import its_meow.betteranimalsplus.common.entity.ai.HungerNonTamedTargetGoal;
import its_meow.betteranimalsplus.common.entity.util.EntityTypeContainerBAPTameable;
import its_meow.betteranimalsplus.common.entity.util.EntityUtil;
import its_meow.betteranimalsplus.common.entity.util.IDropHead;
import its_meow.betteranimalsplus.common.entity.util.IHaveHunger;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntityTameableBetterAnimalsPlus;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntityTameableWithSelectiveTypes;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModItems;
import its_meow.betteranimalsplus.init.ModResources;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Food;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.event.ForgeEventFactory;

import java.util.Set;


public class EntityFeralWolf extends EntityTameableWithSelectiveTypes implements IDropHead<EntityTameableBetterAnimalsPlus>, IHaveHunger<EntityTameableBetterAnimalsPlus> {

    public static final double TAMED_HEALTH = 30D;
    public static final double UNTAMED_HEALTH = 10D;
    protected static final DataParameter<Float> DATA_HEALTH_ID = EntityDataManager.createKey(EntityFeralWolf.class, DataSerializers.FLOAT);

    private int hunger;

    public EntityFeralWolf(World worldIn) {
        super(ModEntities.FERAL_WOLF.entityType, worldIn);
        this.setTamed(false);
    }

    public EntityFeralWolf(EntityType<? extends EntityFeralWolf> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.sitGoal = new SitGoal(this);
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(2, this.sitGoal);
        this.goalSelector.addGoal(3, new BreedGoal(this, 1D));
        this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
        this.goalSelector.addGoal(8, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(10, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(4, new NonTamedTargetGoal<>(this, PlayerEntity.class, false,  e -> e.world.getDifficulty() != Difficulty.PEACEFUL));
        this.targetSelector.addGoal(4, new HungerNonTamedTargetGoal<>(this, AnimalEntity.class, false, e -> e instanceof SheepEntity || e instanceof RabbitEntity));
        this.targetSelector.addGoal(4, new HungerNonTamedTargetGoal<>(this, VillagerEntity.class, false, e -> true));
        this.targetSelector.addGoal(4, new HungerNonTamedTargetGoal<>(this, AbstractIllagerEntity.class, false, e -> true));
        this.targetSelector.addGoal(4, new HungerNonTamedTargetGoal<>(this, ChickenEntity.class, false, e -> true));
        this.targetSelector.addGoal(4, new HungerNonTamedTargetGoal<>(this, EntityGoat.class, false, e -> true));
        this.targetSelector.addGoal(5, new HungerNearestAttackableTargetGoal<>(this, AbstractSkeletonEntity.class, false));
    }

    @Override
    public int getHunger() {
        return hunger;
    }

    @Override
    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        this.writeHunger(compound);
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.readHunger(compound);
    }

    @Override
    public void onDeath(DamageSource cause) {
        super.onDeath(cause);
        this.doHeadDrop();
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);

        if(this.isTamed()) {
            this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(TAMED_HEALTH);
        } else {
            this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(UNTAMED_HEALTH);
        }

        this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
    }

    @Override
    protected void updateAITasks() {
        super.updateAITasks();
        this.dataManager.set(EntityFeralWolf.DATA_HEALTH_ID, this.getHealth());
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(DATA_HEALTH_ID, this.getHealth());
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockStateIn) {
        this.playSound(SoundEvents.ENTITY_WOLF_STEP, 0.15F, 1.0F);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        if(!this.isTamed() || this.getAttackTarget() != null) {
            return SoundEvents.ENTITY_WOLF_GROWL;
        } else if(this.rand.nextInt(3) == 0) {
            return this.isTamed() && this.dataManager.get(EntityFeralWolf.DATA_HEALTH_ID) < TAMED_HEALTH / 2D ? SoundEvents.ENTITY_WOLF_WHINE : SoundEvents.ENTITY_WOLF_PANT;
        } else {
            return SoundEvents.ENTITY_WOLF_AMBIENT;
        }
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_WOLF_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_WOLF_DEATH;
    }

    @Override
    protected float getSoundVolume() {
        return 0.4F;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.ticksExisted % 20 == 0) {
            this.incrementHunger();
        }
    }

    @Override
    public int getVerticalFaceSpeed() {
        return this.isSitting() ? 20 : super.getVerticalFaceSpeed();
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if(this.isInvulnerableTo(source)) {
            return false;
        } else {
            Entity entity = source.getTrueSource();

            if(this.sitGoal != null) {
                this.sitGoal.setSitting(false);
            }

            if(entity != null && !(entity instanceof PlayerEntity) && !(entity instanceof AbstractArrowEntity)) {
                amount = (amount + 1.0F) / 2.0F;
            }

            return super.attackEntityFrom(source, amount);
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this),
        (int) this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue());

        if(flag) {
            this.applyEnchantments(this, entityIn);
        }

        return flag;
    }

    @Override
    public void setTamed(boolean tamed) {
        super.setTamed(tamed);

        if(tamed) {
            this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(TAMED_HEALTH);
        } else {
            this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(UNTAMED_HEALTH);
        }

        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
    }

    @Override
    public boolean processInteract(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        if(this.isTamed()) {
            if(!itemstack.isEmpty()) {
                if(itemstack.getItem().isFood()) {
                    Food food = itemstack.getItem().getFood();
                    if(food.isMeat() && this.dataManager.get(EntityFeralWolf.DATA_HEALTH_ID) < TAMED_HEALTH) {
                        if(!player.isCreative()) {
                            itemstack.shrink(1);
                        }
                        this.heal(food.getHealing());
                        return true;
                    }
                }
            }
            if(this.isOwner(player) && !this.world.isRemote && !this.isBreedingItem(itemstack) && (!(itemstack.getItem().isFood()) || !(itemstack.getItem().getFood().isMeat()))) {
                this.sitGoal.setSitting(!this.isSitting());
                this.isJumping = false;
                this.navigator.clearPath();
                this.setAttackTarget(null);
            }
        } else if(this.isTamingItem(itemstack.getItem())) {
            ItemStack stack = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
            if(stack.getItem().isIn(ModResources.Tags.Items.FERAL_WOLF_TAME_ARMOR)) {
                if(!player.isCreative()) {
                    itemstack.shrink(1);
                }
                if(!this.world.isRemote) {
                    if(this.rand.nextInt(100) <= 14 && !ForgeEventFactory.onAnimalTame(this, player)) {
                        this.setTamedBy(player);
                        this.navigator.clearPath();
                        this.setAttackTarget(null);
                        this.sitGoal.setSitting(true);
                        this.setHealth((float) TAMED_HEALTH);
                        this.world.setEntityState(this, (byte) 7);
                    } else {
                        this.world.setEntityState(this, (byte) 6);
                    }
                }

                return true;
            } else {
                if(!this.world.isRemote) {
                    player.sendMessage(new TranslationTextComponent("entity.betteranimalsplus.feralwolf.message.wear_head"));
                }
            }
        }
        return super.processInteract(player, hand);
    }

    @Override
    public boolean canBreed() {
        return this.isTamed() && super.canBreed();
    }

    @OnlyIn(Dist.CLIENT)
    public float getTailRotation() {
        if(!this.isTamed()) {
            return -0.15F;
        } else {
            return this.isTamed()
            ? 0.25F - (this.getMaxHealth() - this.dataManager.get(EntityFeralWolf.DATA_HEALTH_ID))
            * 0.04F
            : -0.85F;
        }
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.getItem() == ModItems.ANTLER.get();
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 8;
    }

    @Override
    public boolean shouldAttackEntity(LivingEntity target, LivingEntity owner) {
        if(!(target instanceof CreeperEntity) && !(target instanceof GhastEntity)) {
            if(target instanceof EntityFeralWolf) {
                EntityFeralWolf entityferalwolf = (EntityFeralWolf) target;

                if(entityferalwolf.isTamed() && entityferalwolf.getOwner() == owner) {
                    return false;
                }
            }

            if(target instanceof PlayerEntity && owner instanceof PlayerEntity && !((PlayerEntity) owner).canAttackPlayer((PlayerEntity) target)) {
                return false;
            } else {
                return !(target instanceof AbstractHorseEntity) || !((AbstractHorseEntity) target).isTame();
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean canBeLeashedTo(PlayerEntity player) {
        return this.isTamed() && super.canBeLeashedTo(player);
    }

    @Override
    protected EntityFeralWolf getBaseChild() {
        EntityFeralWolf wolf = new EntityFeralWolf(this.world);
        if(this.isTamed()) {
            wolf.setTamed(true);
            wolf.setOwnerId(this.getOwnerId());
        }
        return wolf;
    }

    @Override
    public String[] getTypesFor(Biome biome, Set<BiomeDictionary.Type> types) {
        if(types.contains(Type.FOREST) && !types.contains(Type.CONIFEROUS)) {
            return new String[] {"timber", "red"};
        } else if(types.contains(Type.CONIFEROUS) && !types.contains(Type.SNOWY)) {
            return new String[] {"black", "timber", "red"};
        } else if(types.contains(Type.CONIFEROUS) && types.contains(Type.SNOWY)) {
            return new String[] {"snowy", "timber"};
        } else if(types.contains(Type.SNOWY) && !types.contains(Type.FOREST)) { 
            return new String[] {"snowy", "arctic"};
        } else if(types.contains(Type.FOREST) && types.contains(Type.CONIFEROUS) && !types.contains(Type.SNOWY)) { 
            return new String[] {"brown", "red", "timber", "black"};
        } else {
            return new String[] {"black", "snowy", "timber", "arctic", "brown", "red"};
        }
    }

    @Override
    public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, ILivingEntityData livingdata, CompoundNBT compound) {
        this.setInitialHunger();
        return EntityUtil.childChance(this, reason, super.onInitialSpawn(world, difficulty, reason, livingdata, compound), 0.25F);
    }

    @Override
    protected ResourceLocation getLootTable() {
        if(this.getVariant().isPresent()) {
            IVariant variant = this.getVariant().get();
            if(variant instanceof WolfVariant) {
                return ((WolfVariant)variant).getLootTable();
            }
        }
        return null;
    }

    public static class WolfVariant extends EntityVariant {
        private final ResourceLocation neutralTexture;
        private final ResourceLocation lootTable;

        public WolfVariant(String nameTexture) {
            super(Ref.MOD_ID, nameTexture, "feralwolf_" + nameTexture);
            this.neutralTexture = new ResourceLocation(Ref.MOD_ID, "textures/entity/feralwolf_" + nameTexture + "_neutral.png");
            this.lootTable = new ResourceLocation(Ref.MOD_ID, "feralwolf_" + nameTexture);
        }

        @Override
        public ResourceLocation getTexture(Entity entity) {
            if(entity instanceof EntityFeralWolf && ((EntityFeralWolf) entity).isTamed()) {
                return neutralTexture;
            }
            return super.getTexture(entity);
        }

        public ResourceLocation getLootTable() {
            return lootTable;
        }
    }

    @Override
    public EntityTypeContainerBAPTameable<? extends EntityTameableWithSelectiveTypes> getContainer() {
        return ModEntities.FERAL_WOLF;
    }

}
