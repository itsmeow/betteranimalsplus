package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.betteranimalsplus.common.entity.ai.HungerNearestAttackableTargetGoal;
import dev.itsmeow.betteranimalsplus.common.entity.ai.HungerNonTamedTargetGoal;
import dev.itsmeow.betteranimalsplus.common.entity.util.EntityTypeContainerBAPTameable;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.AbstractIllagerEntity;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.GhastEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.*;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.ForgeEventFactory;

public class EntityCoyote extends EntityFeralWolf {

    public static final String HOSTILE_DAYTIME_KEY = "hostile_during_daytime";

    public EntityCoyote(EntityType<? extends EntityCoyote> entityType, World worldIn) {
        super(entityType, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(2, new SitGoal(this));
        this.goalSelector.addGoal(3, new BreedGoal(this, 1D));
        this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
        this.goalSelector.addGoal(8, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(10, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(4, new NonTamedTargetGoal<>(this, PlayerEntity.class, false, e -> e.level.getDifficulty() != Difficulty.PEACEFUL));
        this.targetSelector.addGoal(4, new HungerNonTamedTargetGoal<>(this, AnimalEntity.class, false, e -> e instanceof SheepEntity || e instanceof RabbitEntity));
        this.targetSelector.addGoal(4, new HungerNonTamedTargetGoal<>(this, VillagerEntity.class, false, e -> true));
        this.targetSelector.addGoal(4, new HungerNonTamedTargetGoal<>(this, AbstractIllagerEntity.class, false, e -> true));
        this.targetSelector.addGoal(4, new HungerNonTamedTargetGoal<>(this, ChickenEntity.class, false, e -> true));
        this.targetSelector.addGoal(5, new HungerNearestAttackableTargetGoal<>(this, AbstractSkeletonEntity.class, false));
    }

    @Override
    public ILivingEntityData initAgeableData(IWorld world, SpawnReason reason, ILivingEntityData livingdata) {
        return livingdata;
    }

    @Override
    public void writeType(CompoundNBT nbt) {
    }

    @Override
    public void readType(CompoundNBT nbt) {
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
    public ActionResultType mobInteract(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        if(this.isTame()) {
            if(!itemstack.isEmpty()) {
                if(itemstack.getItem().isEdible()) {
                    Food food = itemstack.getItem().getFoodProperties();

                    if(food.isMeat()
                    && this.entityData.get(DATA_HEALTH_ID) < TAMED_HEALTH) {
                        if(!player.isCreative()) {
                            itemstack.shrink(1);
                        }

                        this.heal(food.getNutrition());
                        return ActionResultType.SUCCESS;
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
                    player.sendMessage(new TranslationTextComponent("entity.betteranimalsplus.coyote.message.always_hostile"), Util.NIL_UUID);
                }
            } else if(this.isDaytime()) {
                if(!player.isCreative()) {
                    itemstack.shrink(1);
                }

                if(!this.level.isClientSide) {
                    if(this.random.nextInt(100) <= 14 && !ForgeEventFactory.onAnimalTame(this, player)) {
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

                return ActionResultType.SUCCESS;
            } else {
                if(!this.level.isClientSide) {
                    player.sendMessage(new TranslationTextComponent("entity.betteranimalsplus.coyote.message.currently_hostile"), Util.NIL_UUID);
                }
                return ActionResultType.PASS;
            }
        }
        if(this.isFood(itemstack)) {
            if(this.getAge() == 0 && this.canBreed()) {
                this.usePlayerItem(player, itemstack);
                this.setInLove(player);
                return ActionResultType.CONSUME;
            }
            if(this.isBaby()) {
                this.usePlayerItem(player, itemstack);
                this.ageUp((int) ((float) (-this.getAge() / 20) * 0.1F), true);
                return ActionResultType.CONSUME;
            }
        }

        Item item = itemstack.getItem();
        if(item instanceof SpawnEggItem && ((SpawnEggItem) item).spawnsEntity(itemstack.getTag(), this.getType())) {
            if(!this.level.isClientSide && level instanceof ServerWorld) {
                AgeableEntity ageableentity = this.getBreedOffspring((ServerWorld) this.level, this);
                if(ageableentity != null) {
                    ageableentity.setAge(-24000);
                    ageableentity.moveTo(this.getX(), this.getY(), this.getZ(), 0.0F, 0.0F);
                    this.level.addFreshEntity(ageableentity);
                    if(itemstack.hasCustomHoverName()) {
                        ageableentity.setCustomName(itemstack.getHoverName());
                    }

                    this.onOffspringSpawnedFromEgg(player, ageableentity);
                    if(!player.abilities.instabuild) {
                        itemstack.shrink(1);
                    }
                }
            }

            return ActionResultType.SUCCESS;
        } else {
            return ActionResultType.PASS;
        }
    }

    @Override
    public EntityTypeContainerBAPTameable<? extends EntityCoyote> getContainer() {
        return ModEntities.COYOTE;
    }

    @Override
    public boolean wantsToAttack(LivingEntity target, LivingEntity owner) {
        if(!(target instanceof CreeperEntity) && !(target instanceof GhastEntity) && (this.isTame() || !this.isDaytime() || isHostileDaytime())) {
            if(target instanceof EntityCoyote) {
                EntityCoyote entityferalwolf = (EntityCoyote) target;

                if(entityferalwolf.isTame() && entityferalwolf.getOwner() == owner) {
                    return false;
                }
            }

            if(target instanceof PlayerEntity && owner instanceof PlayerEntity && !((PlayerEntity) owner).canHarmPlayer((PlayerEntity) target)) {
                return false;
            } else {
                return !(target instanceof AbstractHorseEntity) || !((AbstractHorseEntity) target).isTamed();
            }
        } else {
            return false;
        }
    }

    public boolean isHostileDaytime() {
        return getContainer().getCustomConfiguration().getBoolean(HOSTILE_DAYTIME_KEY);
    }

    @Override
    protected ResourceLocation getDefaultLootTable() {
        return null;
    }

    @Override
    public AgeableEntity getBreedOffspring(ServerWorld world, AgeableEntity ageable) {
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
