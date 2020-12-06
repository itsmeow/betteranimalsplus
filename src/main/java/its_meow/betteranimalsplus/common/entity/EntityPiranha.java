package its_meow.betteranimalsplus.common.entity;

import dev.itsmeow.imdlib.entity.util.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.util.EntityTypeContainerContainable;
import its_meow.betteranimalsplus.common.entity.ai.HungerNearestAttackableTargetGoal;
import its_meow.betteranimalsplus.common.entity.ai.PeacefulNearestAttackableTargetGoal;
import its_meow.betteranimalsplus.common.entity.util.IHaveHunger;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntityWaterMobPathing;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntityWaterMobPathingBucketable;
import its_meow.betteranimalsplus.init.ModEntities;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.passive.horse.SkeletonHorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class EntityPiranha extends EntityWaterMobPathingBucketable implements IHaveHunger<EntityWaterMobPathing> {

    public final DamageSource PIRANHA_DAMAGE = (new EntityDamageSource("betteranimalsplus.piranha", this)).setDamageBypassesArmor();
    private int hunger;

    public EntityPiranha(World world) {
        super(ModEntities.PIRANHA.entityType, world);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 1D, true));
        this.goalSelector.addGoal(1, new RandomSwimmingGoal(this, 1D, 1));
        Predicate<LivingEntity> eP = e -> e.getHealth() < e.getMaxHealth();
        this.targetSelector.addGoal(0, new HungerNearestAttackableTargetGoal<>(this, LivingEntity.class, 0, true, false, e -> eP.test(e) && !(e instanceof EntityPiranha) && !(e instanceof SkeletonEntity) && !(e instanceof SkeletonHorseEntity) && !(e instanceof PlayerEntity)));
        this.targetSelector.addGoal(1, new PeacefulNearestAttackableTargetGoal<>(this, PlayerEntity.class, true, false));
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(1D);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4D);
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
    public void tick() {
        super.tick();
        if (this.ticksExisted % 20 == 0) {
            this.incrementHunger();
        }
    }

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData livingdata, CompoundNBT compound) {
        this.setInitialHunger();
        return super.onInitialSpawn(world, difficulty, reason, livingdata, compound);
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
    public boolean attackEntityAsMob(Entity entityIn) {
        float f = (float) this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue();
        float f1 = (float) this.getAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK).getValue();
        if(entityIn instanceof LivingEntity) {
            f += EnchantmentHelper.getModifierForCreature(this.getHeldItemMainhand(), ((LivingEntity) entityIn).getCreatureAttribute());
            f1 += (float) EnchantmentHelper.getKnockbackModifier(this);
        }
        int i = EnchantmentHelper.getFireAspectModifier(this);
        if(i > 0) {
            entityIn.setFire(i * 4);
        }
        boolean flag = entityIn.attackEntityFrom(PIRANHA_DAMAGE, f);
        if(flag) {
            if(f1 > 0.0F && entityIn instanceof LivingEntity) {
                ((LivingEntity) entityIn).knockBack(this, f1 * 0.5F, (double) MathHelper.sin(this.rotationYaw * ((float) Math.PI / 180F)), (double) (-MathHelper.cos(this.rotationYaw * ((float) Math.PI / 180F))));
                this.setMotion(this.getMotion().mul(0.6D, 1.0D, 0.6D));
            }
            if(entityIn instanceof PlayerEntity) {
                PlayerEntity playerentity = (PlayerEntity) entityIn;
                ItemStack itemstack = this.getHeldItemMainhand();
                ItemStack itemstack1 = playerentity.isHandActive() ? playerentity.getActiveItemStack() : ItemStack.EMPTY;
                if(!itemstack.isEmpty() && !itemstack1.isEmpty() && itemstack.canDisableShield(itemstack1, playerentity, this) && itemstack1.isShield(playerentity)) {
                    float f2 = 0.25F + (float) EnchantmentHelper.getEfficiencyModifier(this) * 0.05F;
                    if(this.rand.nextFloat() < f2) {
                        playerentity.getCooldownTracker().setCooldown(itemstack.getItem(), 100);
                        this.world.setEntityState(playerentity, (byte) 30);
                    }
                }
                if(!playerentity.isAlive()) {
                    SkeletonEntity skele = EntityType.SKELETON.create(playerentity.world);
                    skele.setCustomName(playerentity.getName());
                    skele.setCustomNameVisible(true);
                    skele.setPositionAndRotation(playerentity.getPosX(), playerentity.getPosY(), playerentity.getPosZ(), playerentity.rotationYaw, playerentity.rotationPitch);
                    playerentity.world.addEntity(skele);
                }
            } else if(entityIn instanceof HorseEntity && !entityIn.isAlive()) {
                SkeletonHorseEntity skele = EntityType.SKELETON_HORSE.create(entityIn.world);
                skele.setPositionAndRotation(entityIn.getPosX(), entityIn.getPosY(), entityIn.getPosZ(), entityIn.rotationYaw, entityIn.rotationPitch);
                skele.onInitialSpawn(entityIn.world, entityIn.world.getDifficultyForLocation(new BlockPos(entityIn)), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
                skele.hurtResistantTime = 60;
                skele.enablePersistence();
                skele.setHorseTamed(true);
                skele.setGrowingAge(0);
                if(entityIn.hasCustomName()) {
                    skele.setCustomName(entityIn.getCustomName());
                }
                skele.setGrowingAge(((HorseEntity) entityIn).getGrowingAge());
                skele.setCustomNameVisible(entityIn.isCustomNameVisible());
                entityIn.world.addEntity(skele);
            }
            this.applyEnchantments(this, entityIn);
        }

        return flag;
    }

    @Override
    protected SoundEvent getSwimSound() {
        return SoundEvents.ENTITY_FISH_SWIM;
    }

    @Override
    public void livingTick() {
        if(!this.isInWater() && this.onGround && this.collidedVertically) {
            this.setMotion(this.getMotion().add((double) ((this.rand.nextFloat() * 2.0F - 1.0F) * 0.05F), (double) 0.4F, (double) ((this.rand.nextFloat() * 2.0F - 1.0F) * 0.05F)));
            this.onGround = false;
            this.isAirBorne = true;
            this.playSound(SoundEvents.ENTITY_COD_FLOP, this.getSoundVolume(), this.getSoundPitch());
        }

        super.livingTick();
    }

    @Override
    public EntityTypeContainer<?> getContainer() {
        return ModEntities.PIRANHA;
    }

    @Override
    public EntityTypeContainerContainable<?, ?> getContainableContainer() {
        return ModEntities.PIRANHA;
    }

}
