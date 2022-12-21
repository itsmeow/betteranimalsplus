package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.betteranimalsplus.common.entity.ai.HungerNearestAttackableTargetGoal;
import dev.itsmeow.betteranimalsplus.common.entity.ai.HungerNonTamedTargetGoal;
import dev.itsmeow.betteranimalsplus.common.entity.util.EntityTypeContainerBAPTameable;
import dev.itsmeow.betteranimalsplus.common.entity.util.IDropHead;
import dev.itsmeow.betteranimalsplus.common.entity.util.IHaveHunger;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityTameableBetterAnimalsPlus;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModItems;
import dev.itsmeow.betteranimalsplus.util.ModPlatformEvents;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class EntityCoyote extends EntityTameableBetterAnimalsPlus implements IDropHead<EntityTameableBetterAnimalsPlus>, IHaveHunger<EntityTameableBetterAnimalsPlus> {

    public static final String HOSTILE_DAYTIME_KEY = "hostile_during_daytime";
    public static boolean client_hostile_override = false;
    public static final double TAMED_HEALTH = 30D;
    public static final double UNTAMED_HEALTH = 10D;
    protected static final EntityDataAccessor<Float> DATA_HEALTH_ID = SynchedEntityData.defineId(EntityCoyote.class, EntityDataSerializers.FLOAT);

    private int hunger;

    public EntityCoyote(EntityType<? extends EntityCoyote> entityType, Level worldIn) {
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
        this.targetSelector.addGoal(4, new NonTameRandomTargetGoal<>(this, Player.class, false, e -> e.level.getDifficulty() != Difficulty.PEACEFUL));
        this.targetSelector.addGoal(4, new HungerNonTamedTargetGoal<>(this, Animal.class, false, e -> e instanceof Sheep || e instanceof Rabbit));
        this.targetSelector.addGoal(4, new HungerNonTamedTargetGoal<>(this, Villager.class, false, e -> true));
        this.targetSelector.addGoal(4, new HungerNonTamedTargetGoal<>(this, AbstractIllager.class, false, e -> true));
        this.targetSelector.addGoal(4, new HungerNonTamedTargetGoal<>(this, Chicken.class, false, e -> true));
        this.targetSelector.addGoal(5, new HungerNearestAttackableTargetGoal<>(this, AbstractSkeleton.class, false));
    }

    public boolean isDaytime() {
        long time = this.level.getDayTime() % 24000L; // Time can go over values of 24000, so divide and take the remainder
        return !(time >= 13000L && time <= 23000L);
    }

    @Override
    public void setTarget(LivingEntity entitylivingbaseIn) {
        if(!this.isDaytime() || isHostileDaytime()) {
            super.setTarget(entitylivingbaseIn);
        } else if(!this.isTame()) {
            super.setTarget(null);
        } else {
            super.setTarget(entitylivingbaseIn);
        }
        if(this.level.getDifficulty() == Difficulty.PEACEFUL) {
            super.setTarget(null);
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        if((!this.isDaytime() || isHostileDaytime()) && !this.isTame()) {
            return SoundEvents.WOLF_GROWL;
        } else if(this.random.nextInt(3) == 0) {
            return this.isTame() && this.entityData.get(DATA_HEALTH_ID) < TAMED_HEALTH / 2D ? SoundEvents.WOLF_WHINE : SoundEvents.WOLF_PANT;
        } else if(this.getTarget() != null) {
            return SoundEvents.WOLF_GROWL;
        }
        return null;
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if(this.isTame()) {
            if(!itemstack.isEmpty()) {
                if(itemstack.getItem().isEdible()) {
                    FoodProperties food = itemstack.getItem().getFoodProperties();
                    if(food.isMeat() && this.entityData.get(DATA_HEALTH_ID) < TAMED_HEALTH) {
                        if(!player.isCreative()) {
                            itemstack.shrink(1);
                        }

                        this.heal(food.getNutrition());
                        return InteractionResult.SUCCESS;
                    }
                }
            }

            if (this.isOwnedBy(player) && !this.level.isClientSide && !this.isFood(itemstack) && (!(itemstack.getItem().isEdible()) || !itemstack.getItem().getFoodProperties().isMeat())) {
                this.setOrderedToSit(!this.isInSittingPose());
                this.jumping = false;
                this.navigation.stop();
                this.setTarget(null);
            }
        } else if(this.isTamingItem(itemstack.getItem())) {
            if(isHostileDaytime()) {
                if(!this.level.isClientSide) {
                    player.sendMessage(new TranslatableComponent("entity.betteranimalsplus.coyote.message.always_hostile"), Util.NIL_UUID);
                }
            } else if(this.isDaytime()) {
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
                    player.sendMessage(new TranslatableComponent("entity.betteranimalsplus.coyote.message.currently_hostile"), Util.NIL_UUID);
                }
            }
        }
        return super.mobInteract(player, hand);
    }

    @Override
    public EntityTypeContainerBAPTameable<? extends EntityCoyote> getContainer() {
        return ModEntities.COYOTE;
    }

    @Override
    public boolean wantsToAttack(LivingEntity target, LivingEntity owner) {
        if(!(target instanceof Creeper) && !(target instanceof Ghast) && (this.isTame() || !this.isDaytime() || isHostileDaytime())) {
            if(target instanceof EntityCoyote) {
                EntityCoyote coyote = (EntityCoyote) target;

                if(coyote.isTame() && coyote.getOwner() == owner) {
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

    public boolean isHostileDaytime() {
        return this.level.isClientSide() ? EntityCoyote.client_hostile_override : getContainer().getCustomConfiguration().getBoolean(HOSTILE_DAYTIME_KEY);
    }

    @Override
    public AgableMob getBreedOffspring(ServerLevel world, AgableMob ageable) {
        EntityCoyote coyote = getContainer().getEntityType().create(world);
        if(this.isTame()) {
            coyote.setTame(true);
            coyote.setOwnerUUID(this.getOwnerUUID());
        }
        return coyote;
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
        this.entityData.set(EntityCoyote.DATA_HEALTH_ID, this.getHealth());
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
    public boolean canBreed() {
        return this.isTame() && super.canBreed();
    }

    @Environment(EnvType.CLIENT)
    public float getTailRotation() {
        if(!this.isTame()) {
            return -0.15F;
        } else {
            return this.isTame() ? 0.25F - (this.getMaxHealth() - this.getEntityData().get(EntityCoyote.DATA_HEALTH_ID)) * 0.04F : -0.85F;
        }
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.getItem() == ModItems.ANTLER.get();
    }

    @Override
    public boolean canBeLeashed(Player player) {
        return this.isTame() && super.canBeLeashed(player);
    }

}
