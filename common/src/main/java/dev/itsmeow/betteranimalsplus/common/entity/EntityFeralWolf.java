package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.betteranimalsplus.Ref;
import dev.itsmeow.betteranimalsplus.common.entity.ai.HungerNearestAttackableTargetGoal;
import dev.itsmeow.betteranimalsplus.common.entity.ai.HungerNonTamedTargetGoal;
import dev.itsmeow.betteranimalsplus.common.entity.util.EntityTypeContainerBAPTameable;
import dev.itsmeow.betteranimalsplus.common.entity.util.EntityUtil;
import dev.itsmeow.betteranimalsplus.common.entity.util.IDropHead;
import dev.itsmeow.betteranimalsplus.common.entity.util.IHaveHunger;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityTameableBetterAnimalsPlus;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityTameableWithSelectiveTypes;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModItems;
import dev.itsmeow.betteranimalsplus.init.ModResources;
import dev.itsmeow.betteranimalsplus.util.ModPlatformEvents;
import dev.itsmeow.imdlib.entity.util.BiomeTypes;
import dev.itsmeow.imdlib.entity.util.variant.EntityVariant;
import dev.itsmeow.imdlib.entity.util.variant.IVariant;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NonTameRandomTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.monster.AbstractIllager;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Set;

public class EntityFeralWolf extends EntityTameableWithSelectiveTypes implements IDropHead<EntityTameableBetterAnimalsPlus>, IHaveHunger<EntityTameableBetterAnimalsPlus> {

    public static final double TAMED_HEALTH = 30D;
    public static final double UNTAMED_HEALTH = 10D;
    protected static final EntityDataAccessor<Float> DATA_HEALTH_ID = SynchedEntityData.defineId(EntityFeralWolf.class, EntityDataSerializers.FLOAT);

    private int hunger;

    public EntityFeralWolf(EntityType<? extends EntityFeralWolf> entityType, Level worldIn) {
        super(entityType, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(3, new BreedGoal(this, 1D));
        this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
        this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(4, new NonTameRandomTargetGoal<>(this, Player.class, false,  e -> e.level.getDifficulty() != Difficulty.PEACEFUL));
        this.targetSelector.addGoal(4, new HungerNonTamedTargetGoal<>(this, Animal.class, false, e -> e instanceof Sheep || e instanceof Rabbit));
        this.targetSelector.addGoal(4, new HungerNonTamedTargetGoal<>(this, Villager.class, false, e -> true));
        this.targetSelector.addGoal(4, new HungerNonTamedTargetGoal<>(this, AbstractIllager.class, false, e -> true));
        this.targetSelector.addGoal(4, new HungerNonTamedTargetGoal<>(this, Chicken.class, false, e -> true));
        this.targetSelector.addGoal(5, new HungerNearestAttackableTargetGoal<>(this, AbstractSkeleton.class, false));
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
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        this.writeHunger(compound);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.readHunger(compound);
    }

    @Override
    public void die(DamageSource cause) {
        super.die(cause);
        this.doHeadDrop();
    }

    @Override
    protected void customServerAiStep() {
        super.customServerAiStep();
        this.entityData.set(EntityFeralWolf.DATA_HEALTH_ID, this.getHealth());
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_HEALTH_ID, this.getHealth());
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockStateIn) {
        this.playSound(SoundEvents.WOLF_STEP, 0.15F, 1.0F);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        if(!this.isTame() || this.getTarget() != null) {
            return SoundEvents.WOLF_GROWL;
        } else if(this.random.nextInt(3) == 0) {
            return this.isTame() && this.entityData.get(EntityFeralWolf.DATA_HEALTH_ID) < TAMED_HEALTH / 2D ? SoundEvents.WOLF_WHINE : SoundEvents.WOLF_PANT;
        } else {
            return SoundEvents.WOLF_AMBIENT;
        }
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.WOLF_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.WOLF_DEATH;
    }

    @Override
    protected float getSoundVolume() {
        return 0.4F;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.tickCount % 20 == 0) {
            this.incrementHunger();
        }
    }

    @Override
    public int getMaxHeadXRot() {
        return this.isInSittingPose() ? 20 : super.getMaxHeadXRot();
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if(this.isInvulnerableTo(source)) {
            return false;
        } else {
            Entity entity = source.getEntity();

            if(this.isInSittingPose()) { // sitting
                this.setOrderedToSit(false);
            }

            if(entity != null && !(entity instanceof Player) && !(entity instanceof AbstractArrow)) {
                amount = (amount + 1.0F) / 2.0F;
            }

            return super.hurt(source, amount);
        }
    }

    @Override
    public void setTame(boolean tamed) {
        super.setTame(tamed);

        if(tamed) {
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(TAMED_HEALTH);
        } else {
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(UNTAMED_HEALTH);
        }
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if(this.isTame()) {
            if(!itemstack.isEmpty()) {
                if(itemstack.getItem().isEdible()) {
                    FoodProperties food = itemstack.getItem().getFoodProperties();
                    if(food.isMeat() && this.entityData.get(EntityFeralWolf.DATA_HEALTH_ID) < TAMED_HEALTH) {
                        if(!player.isCreative()) {
                            itemstack.shrink(1);
                        }
                        this.heal(food.getNutrition());
                        return InteractionResult.SUCCESS;
                    }
                }
            }

            if(this.isOwnedBy(player) && !this.level.isClientSide && !this.isFood(itemstack) && (!(itemstack.getItem().isEdible()) || !(itemstack.getItem().getFoodProperties().isMeat()))) {
                this.setOrderedToSit(!this.isInSittingPose());
                this.jumping = false;
                this.navigation.stop();
                this.setTarget(null);
            }
        } else if(this.isTamingItem(itemstack.getItem())) {
            ItemStack stack = player.getItemBySlot(EquipmentSlot.HEAD);
            if(stack.is(ModResources.Tags.Items.FERAL_WOLF_TAME_ARMOR)) {
                if(!player.isCreative()) {
                    itemstack.shrink(1);
                }
                if(!this.level.isClientSide) {
                    if(this.random.nextInt(100) <= 14 && !ModPlatformEvents.tame(this, player)) {
                        this.tame(player);
                        this.navigation.stop();
                        this.setTarget(null);
                        this.setOrderedToSit(true);
                        this.setHealth((float) TAMED_HEALTH);
                        this.level.broadcastEntityEvent(this, (byte) 7);
                    } else {
                        this.level.broadcastEntityEvent(this, (byte) 6);
                    }
                }

                return InteractionResult.SUCCESS;
            } else {
                if(!this.level.isClientSide) {
                    player.sendMessage(new TranslatableComponent("entity.betteranimalsplus.feralwolf.message.wear_head"), Util.NIL_UUID);
                }
            }
        }

        return super.mobInteract(player, hand);
    }

    @Override
    public boolean canBreed() {
        return this.isTame() && super.canBreed();
    }

    @Environment(EnvType.CLIENT)
    public float getTailRotation() {
        if(!this.isTame()) {
            return -0.15F;
        } else {
            return this.isTame()
            ? 0.25F - (this.getMaxHealth() - this.entityData.get(EntityFeralWolf.DATA_HEALTH_ID))
            * 0.04F
            : -0.85F;
        }
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.getItem() == ModItems.ANTLER.get();
    }

    @Override
    public int getMaxSpawnClusterSize() {
        return 8;
    }

    @Override
    public boolean wantsToAttack(LivingEntity target, LivingEntity owner) {
        if(!(target instanceof Creeper) && !(target instanceof Ghast)) {
            if(target instanceof EntityFeralWolf) {
                EntityFeralWolf entityferalwolf = (EntityFeralWolf) target;

                if(entityferalwolf.isTame() && entityferalwolf.getOwner() == owner) {
                    return false;
                }
            }

            if(target instanceof Player && owner instanceof Player && !((Player) owner).canHarmPlayer((Player) target)) {
                return false;
            } else {
                return !(target instanceof AbstractHorse) || !((AbstractHorse) target).isTamed();
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean canBeLeashed(Player player) {
        return this.isTame() && super.canBeLeashed(player);
    }

    @Override
    protected EntityFeralWolf getBaseChild() {
        EntityFeralWolf wolf = getContainer().getEntityType().create(level);
        if(this.isTame()) {
            wolf.setTame(true);
            wolf.setOwnerUUID(this.getOwnerUUID());
        }
        return wolf;
    }

    @Override
    public String[] getTypesFor(ResourceKey<Biome> biomeKey, Biome biome, Set<BiomeTypes.Type> types, MobSpawnType reason) {
        if(types.contains(BiomeTypes.FOREST) && !types.contains(BiomeTypes.CONIFEROUS)) {
            return new String[] {"timber", "red"};
        } else if(types.contains(BiomeTypes.CONIFEROUS) && !types.contains(BiomeTypes.SNOWY)) {
            return new String[] {"black", "timber", "red"};
        } else if(types.contains(BiomeTypes.CONIFEROUS) && types.contains(BiomeTypes.SNOWY)) {
            return new String[] {"snowy", "timber"};
        } else if(types.contains(BiomeTypes.SNOWY) && !types.contains(BiomeTypes.FOREST)) {
            return new String[] {"snowy", "arctic"};
        } else if(types.contains(BiomeTypes.FOREST) && types.contains(BiomeTypes.CONIFEROUS) && !types.contains(BiomeTypes.SNOWY)) {
            return new String[] {"brown", "red", "timber", "black"};
        } else {
            return new String[] {"black", "snowy", "timber", "arctic", "brown", "red"};
        }
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, SpawnGroupData livingdata, CompoundTag compound) {
        this.setInitialHunger();
        return EntityUtil.childChance(this, reason, super.finalizeSpawn(world, difficulty, reason, livingdata, compound), 0.25F);
    }

    @Override
    protected ResourceLocation getDefaultLootTable() {
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
            this.lootTable = new ResourceLocation(Ref.MOD_ID, "entities/feralwolf_" + nameTexture);
        }

        @Override
        public ResourceLocation getTexture(Entity entity) {
            if(entity instanceof EntityFeralWolf && ((EntityFeralWolf) entity).isTame()) {
                return neutralTexture;
            }
            return super.getTexture(entity);
        }

        public ResourceLocation getLootTable() {
            return lootTable;
        }
    }

    @Override
    public EntityTypeContainerBAPTameable<? extends EntityFeralWolf> getContainer() {
        return ModEntities.FERAL_WOLF;
    }

}
