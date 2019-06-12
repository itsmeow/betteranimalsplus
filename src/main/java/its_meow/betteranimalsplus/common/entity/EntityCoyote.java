package its_meow.betteranimalsplus.common.entity;

import javax.annotation.Nullable;

import com.google.common.base.Predicates;

import its_meow.betteranimalsplus.config.BetterAnimalsPlusConfig;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModItems;
import its_meow.betteranimalsplus.util.HeadTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.NonTamedTargetGoal;
import net.minecraft.entity.ai.goal.OwnerHurtByTargetGoal;
import net.minecraft.entity.ai.goal.OwnerHurtTargetGoal;
import net.minecraft.entity.ai.goal.SitGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
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
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

public class EntityCoyote extends EntityFeralWolf {

    public EntityCoyote(World worldIn) {
        super(ModEntities.getEntityType("coyote"), worldIn);
        this.setTamed(false);
    }

    @Override
    protected void registerGoals() {
        this.aiSit = new SitGoal(this);
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(2, this.aiSit);
        this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F));
        this.goalSelector.addGoal(8, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(10, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this, new Class[0]));
        this.targetSelector.addGoal(4,
                new NonTamedTargetGoal<PlayerEntity>(this, PlayerEntity.class, false, Predicates.alwaysTrue()));
        this.targetSelector.addGoal(4,
                new NonTamedTargetGoal<AnimalEntity>(this, AnimalEntity.class, false,
                        (@Nullable LivingEntity p_apply_1_) -> p_apply_1_ instanceof SheepEntity
                                || p_apply_1_ instanceof RabbitEntity));
        this.targetSelector.addGoal(4,
                new NonTamedTargetGoal<VillagerEntity>(this, VillagerEntity.class, false, Predicates.alwaysTrue()));
        this.targetSelector.addGoal(4, new NonTamedTargetGoal<AbstractIllagerEntity>(this, AbstractIllagerEntity.class, false,
                Predicates.alwaysTrue()));
        this.targetSelector.addGoal(4,
                new NonTamedTargetGoal<ChickenEntity>(this, ChickenEntity.class, false, Predicates.alwaysTrue()));
        this.targetSelector.addGoal(5,
                new NearestAttackableTargetGoal<AbstractSkeletonEntity>(this, AbstractSkeletonEntity.class, false));

    }

    public boolean isDaytime() {
        long time = this.world.getDayTime() % 24000L; // Time can go over values of 24000, so divide and take the remainder
        return !(time >= 13000L && time <= 23000L);
    }

    @Override
    public void setAttackTarget(LivingEntity entitylivingbaseIn) {
        if (!this.isDaytime() || BetterAnimalsPlusConfig.coyotesHostileDaytime) {
            super.setAttackTarget(entitylivingbaseIn);
        } else if (!this.isTamed()) {
            super.setAttackTarget(null);
        } else {
            super.setAttackTarget(entitylivingbaseIn);
        }
        if (this.world.getDifficulty() == Difficulty.PEACEFUL) {
            super.setAttackTarget(null);
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        if ((!this.isDaytime() || BetterAnimalsPlusConfig.coyotesHostileDaytime) && !this.isTamed()) {
            return SoundEvents.ENTITY_WOLF_GROWL;
        } else if (this.rand.nextInt(3) == 0) {
            return this.isTamed() && this.dataManager.get(EntityFeralWolf.DATA_HEALTH_ID).floatValue() < 10.0F
                    ? SoundEvents.ENTITY_WOLF_WHINE
                    : SoundEvents.ENTITY_WOLF_PANT;
        } else if (this.getAttackTarget() != null) {
            return SoundEvents.ENTITY_WOLF_GROWL;
        }
        return null;
    }

    @Override
    public void onDeath(DamageSource cause) {
        super.onDeath(cause);
        if (!world.isRemote && !this.isChild()) {
            if (this.rand.nextInt(12) == 0) {
                ItemStack stack = new ItemStack(HeadTypes.WOLFHEAD.getItem(4));
                this.entityDropItem(stack, 0.5F);
            }
        }
    }

    @Override
    public boolean processInteract(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);

        if (this.isTamed()) {
            if (!itemstack.isEmpty()) {
                if (itemstack.getItem().isFood()) {
                    Food food = itemstack.getItem().getFood();

                    if (food.isMeat()
                            && this.dataManager.get(EntityFeralWolf.DATA_HEALTH_ID).floatValue() < 20.0F) {
                        if (!player.isCreative()) {
                            itemstack.shrink(1);
                        }

                        this.heal(food.getHealing());
                        return true;
                    }
                }
            }

            if (this.isOwner(player) && !this.world.isRemote && !this.isBreedingItem(itemstack)
                    && (!(itemstack.getItem().isFood()) || !itemstack.getItem().getFood().isMeat())) {
                this.aiSit.setSitting(!this.isSitting());
                this.isJumping = false;
                this.navigator.clearPath();
                this.setAttackTarget((LivingEntity) null);
            }
        } else if (itemstack.getItem() == Items.RABBIT || itemstack.getItem() == Items.CHICKEN || itemstack.getItem() == Items.COOKED_CHICKEN || itemstack.getItem() == Items.COOKED_RABBIT || itemstack.getItem() == ModItems.PHEASANT_RAW || itemstack.getItem() == ModItems.PHEASANT_COOKED) {
            if(BetterAnimalsPlusConfig.coyotesHostileDaytime) {
                if (!this.world.isRemote) {
                    player.sendMessage(new StringTextComponent("This coyote is always hostile. It cannot be tamed (server configuration)"));
                }
            } else if (this.isDaytime()) {

                if (!player.isCreative()) {
                    itemstack.shrink(1);
                }

                if (!this.world.isRemote) {
                    if (this.rand.nextInt(100) <= 14
                            && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
                        this.setTamedBy(player);
                        this.navigator.clearPath();
                        this.setAttackTarget((LivingEntity) null);
                        this.aiSit.setSitting(true);
                        this.setHealth(20.0F);
                        this.playTameEffect(true);
                        this.world.setEntityState(this, (byte) 7);
                    } else {
                        this.playTameEffect(false);
                        this.world.setEntityState(this, (byte) 6);
                    }
                }

                return true;
            } else {
                if (!this.world.isRemote) {
                    player.sendMessage(new StringTextComponent("This coyote is currently hostile. Perhaps it could be tamed outside of its hunting hours?"));
                }
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean shouldAttackEntity(LivingEntity target, LivingEntity owner) {
        if (!(target instanceof CreeperEntity) && !(target instanceof GhastEntity) && (this.isTamed() || !this.isDaytime() || BetterAnimalsPlusConfig.coyotesHostileDaytime)) {
            if (target instanceof EntityCoyote) {
                EntityCoyote entityferalwolf = (EntityCoyote) target;

                if (entityferalwolf.isTamed() && entityferalwolf.getOwner() == owner) {
                    return false;
                }
            }

            if (target instanceof PlayerEntity && owner instanceof PlayerEntity
                    && !((PlayerEntity) owner).canAttackPlayer((PlayerEntity) target)) {
                return false;
            } else {
                return !(target instanceof AbstractHorseEntity) || !((AbstractHorseEntity) target).isTame();
            }
        } else {
            return false;
        }
    }

}
