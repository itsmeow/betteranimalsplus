package its_meow.betteranimalsplus.common.entity;

import its_meow.betteranimalsplus.common.entity.ai.HungerNearestAttackableTargetGoal;
import its_meow.betteranimalsplus.common.entity.ai.HungerNonTamedTargetGoal;
import its_meow.betteranimalsplus.common.entity.util.EntityTypeContainerBAPTameable;
import its_meow.betteranimalsplus.init.ModEntities;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
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

    public static boolean HOSTILE_DAYTIME = false;

    public EntityCoyote(World worldIn) {
        super(ModEntities.COYOTE.entityType, worldIn);
        this.setTamed(false);
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
        this.targetSelector.addGoal(4, new NonTamedTargetGoal<>(this, PlayerEntity.class, false, e -> e.world.getDifficulty() != Difficulty.PEACEFUL));
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
        long time = this.world.getDayTime() % 24000L; // Time can go over values of 24000, so divide and take the remainder
        return !(time >= 13000L && time <= 23000L);
    }

    @Override
    public void setAttackTarget(LivingEntity entitylivingbaseIn) {
        if(!this.isDaytime() || HOSTILE_DAYTIME) {
            super.setAttackTarget(entitylivingbaseIn);
        } else if(!this.isTamed()) {
            super.setAttackTarget(null);
        } else {
            super.setAttackTarget(entitylivingbaseIn);
        }
        if(this.world.getDifficulty() == Difficulty.PEACEFUL) {
            super.setAttackTarget(null);
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        if((!this.isDaytime() || HOSTILE_DAYTIME) && !this.isTamed()) {
            return SoundEvents.ENTITY_WOLF_GROWL;
        } else if(this.rand.nextInt(3) == 0) {
            return this.isTamed() && this.dataManager.get(EntityFeralWolf.DATA_HEALTH_ID) < TAMED_HEALTH / 2D ? SoundEvents.ENTITY_WOLF_WHINE : SoundEvents.ENTITY_WOLF_PANT;
        } else if(this.getAttackTarget() != null) {
            return SoundEvents.ENTITY_WOLF_GROWL;
        }
        return null;
    }

    @Override
    public ActionResultType getEntityInteractionResult(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);

        if(this.isTamed()) {
            if(!itemstack.isEmpty()) {
                if(itemstack.getItem().isFood()) {
                    Food food = itemstack.getItem().getFood();

                    if(food.isMeat()
                    && this.dataManager.get(EntityFeralWolf.DATA_HEALTH_ID) < TAMED_HEALTH) {
                        if(!player.isCreative()) {
                            itemstack.shrink(1);
                        }

                        this.heal(food.getHealing());
                        return ActionResultType.SUCCESS;
                    }
                }
            }

            if (this.isOwner(player) && !this.world.isRemote && !this.isBreedingItem(itemstack)
                    && (!(itemstack.getItem().isFood()) || !itemstack.getItem().getFood().isMeat())) {
                this.setSitting(!this.isEntitySleeping());
                this.isJumping = false;
                this.navigator.clearPath();
                this.setAttackTarget(null);
            }
        } else if(this.isTamingItem(itemstack.getItem())) {
            if(HOSTILE_DAYTIME) {
                if(!this.world.isRemote) {
                    player.sendMessage(new TranslationTextComponent("entity.betteranimalsplus.coyote.message.always_hostile"), Util.DUMMY_UUID);
                }
            } else if(this.isDaytime()) {
                if(!player.isCreative()) {
                    itemstack.shrink(1);
                }

                if(!this.world.isRemote) {
                    if(this.rand.nextInt(100) <= 14 && !ForgeEventFactory.onAnimalTame(this, player)) {
                        this.setTamedBy(player);
                        this.navigator.clearPath();
                        this.setAttackTarget(null);
                        this.setSitting(true);
                        this.setHealth((float) TAMED_HEALTH);
                        this.world.setEntityState(this, (byte) 7);
                    } else {
                        this.world.setEntityState(this, (byte) 6);
                    }
                }

                return ActionResultType.SUCCESS;
            } else {
                if(!this.world.isRemote) {
                    player.sendMessage(new TranslationTextComponent("entity.betteranimalsplus.coyote.message.currently_hostile"), Util.DUMMY_UUID);
                }
                return ActionResultType.PASS;
            }
        }
        if(this.isBreedingItem(itemstack)) {
            if(this.getGrowingAge() == 0 && this.canBreed()) {
                this.consumeItemFromStack(player, itemstack);
                this.setInLove(player);
                return ActionResultType.CONSUME;
            }
            if(this.isChild()) {
                this.consumeItemFromStack(player, itemstack);
                this.ageUp((int) ((float) (-this.getGrowingAge() / 20) * 0.1F), true);
                return ActionResultType.CONSUME;
            }
        }

        Item item = itemstack.getItem();
        if(item instanceof SpawnEggItem && ((SpawnEggItem) item).hasType(itemstack.getTag(), this.getType())) {
            if(!this.world.isRemote && world instanceof ServerWorld) {
                AgeableEntity ageableentity = this.createChild((ServerWorld) this.world, this);
                if(ageableentity != null) {
                    ageableentity.setGrowingAge(-24000);
                    ageableentity.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), 0.0F, 0.0F);
                    this.world.addEntity(ageableentity);
                    if(itemstack.hasDisplayName()) {
                        ageableentity.setCustomName(itemstack.getDisplayName());
                    }

                    this.onChildSpawnFromEgg(player, ageableentity);
                    if(!player.abilities.isCreativeMode) {
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
    public EntityTypeContainerBAPTameable<EntityCoyote> getContainer() {
        return ModEntities.COYOTE;
    }

    @Override
    public boolean shouldAttackEntity(LivingEntity target, LivingEntity owner) {
        if(!(target instanceof CreeperEntity) && !(target instanceof GhastEntity) && (this.isTamed() || !this.isDaytime() || HOSTILE_DAYTIME)) {
            if(target instanceof EntityCoyote) {
                EntityCoyote entityferalwolf = (EntityCoyote) target;

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
    protected ResourceLocation getLootTable() {
        return null;
    }

    @Override
    public AgeableEntity createChild(ServerWorld world, AgeableEntity ageable) {
        EntityCoyote coyote = this.getBaseChild();
        if(this.isTamed()) {
            coyote.setTamed(true);
            coyote.setOwnerId(this.getOwnerId());
        }
        return coyote;
    }

    @Override
    protected EntityCoyote getBaseChild() {
        return new EntityCoyote(this.world);
    }
}
