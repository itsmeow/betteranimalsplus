package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.betteranimalsplus.common.entity.ai.HungerNearestAttackableTargetGoal;
import dev.itsmeow.betteranimalsplus.common.entity.ai.HungerNonTamedTargetGoal;
import dev.itsmeow.betteranimalsplus.common.entity.util.EntityTypeContainerBAPTameable;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.util.ModPlatformEvents;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
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
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class EntityCoyote extends EntityFeralWolf {

    public static final String HOSTILE_DAYTIME_KEY = "hostile_during_daytime";
    public static boolean client_hostile_override = false;

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

    @Override
    public SpawnGroupData initAgeableData(LevelAccessor world, MobSpawnType reason, SpawnGroupData livingdata) {
        return livingdata;
    }

    @Override
    public void writeType(CompoundTag nbt) {
    }

    @Override
    public void readType(CompoundTag nbt) {
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

                    if(food.isMeat()
                    && this.entityData.get(DATA_HEALTH_ID) < TAMED_HEALTH) {
                        if(!player.isCreative()) {
                            itemstack.shrink(1);
                        }

                        this.heal(food.getNutrition());
                        return InteractionResult.SUCCESS;
                    }
                }
            }

            if (this.isOwnedBy(player) && !this.level.isClientSide && !this.isFood(itemstack)
                    && (!(itemstack.getItem().isEdible()) || !itemstack.getItem().getFoodProperties().isMeat())) {
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
                return InteractionResult.PASS;
            }
        }
        if(this.isFood(itemstack)) {
            if(this.getAge() == 0 && this.canBreed()) {
                this.usePlayerItem(player, hand, itemstack);
                this.setInLove(player);
                return InteractionResult.CONSUME;
            }
            if(this.isBaby()) {
                this.usePlayerItem(player, hand, itemstack);
                this.ageUp((int) ((float) (-this.getAge() / 20) * 0.1F), true);
                return InteractionResult.CONSUME;
            }
        }

        Item item = itemstack.getItem();
        if(item instanceof SpawnEggItem && ((SpawnEggItem) item).spawnsEntity(itemstack.getTag(), this.getType())) {
            if(!this.level.isClientSide && level instanceof ServerLevel) {
                AgeableMob ageableentity = this.getBreedOffspring((ServerLevel) this.level, this);
                if(ageableentity != null) {
                    ageableentity.setAge(-24000);
                    ageableentity.moveTo(this.getX(), this.getY(), this.getZ(), 0.0F, 0.0F);
                    this.level.addFreshEntity(ageableentity);
                    if(itemstack.hasCustomHoverName()) {
                        ageableentity.setCustomName(itemstack.getHoverName());
                    }

                    this.onOffspringSpawnedFromEgg(player, ageableentity);
                    if(!player.getAbilities().instabuild) {
                        itemstack.shrink(1);
                    }
                }
            }

            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.PASS;
        }
    }

    @Override
    public EntityTypeContainerBAPTameable<? extends EntityCoyote> getContainer() {
        return ModEntities.COYOTE;
    }

    @Override
    public boolean wantsToAttack(LivingEntity target, LivingEntity owner) {
        if(!(target instanceof Creeper) && !(target instanceof Ghast) && (this.isTame() || !this.isDaytime() || isHostileDaytime())) {
            if(target instanceof EntityCoyote) {
                EntityCoyote entityferalwolf = (EntityCoyote) target;

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

    public boolean isHostileDaytime() {
        return this.level.isClientSide() ? EntityCoyote.client_hostile_override : getContainer().getCustomConfiguration().getBoolean(HOSTILE_DAYTIME_KEY);
    }

    @Override
    protected ResourceLocation getDefaultLootTable() {
        return null;
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel world, AgeableMob ageable) {
        EntityCoyote coyote = this.getBaseChild();
        if(this.isTame()) {
            coyote.setTame(true);
            coyote.setOwnerUUID(this.getOwnerUUID());
        }
        return coyote;
    }

    @Override
    protected EntityCoyote getBaseChild() {
        return getContainer().getEntityType().create(level);
    }
}
