package its_meow.betteranimalsplus.common.entity;

import dev.itsmeow.imdlib.entity.util.EntityTypeContainer;
import its_meow.betteranimalsplus.common.entity.util.EntityTypeContainerBAPContainable;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntityWaterMobPathingBucketable;
import its_meow.betteranimalsplus.init.ModEntities;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

public class EntityPiranha extends EntityWaterMobPathingBucketable {

    public final DamageSource PIRANHA_DAMAGE = (new EntityDamageSource("betteranimalsplus.piranha", this)).setDamageBypassesArmor();

    public EntityPiranha(World world) {
        super(ModEntities.PIRANHA.entityType, world);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 1D, true));
        this.goalSelector.addGoal(1, new RandomSwimmingGoal(this, 1D, 1));
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<LivingEntity>(this, LivingEntity.class, 1, true, false, e -> e.getHealth() < e.getMaxHealth() && !(e instanceof EntityPiranha) && !(e instanceof SkeletonEntity) && !(e instanceof SkeletonHorseEntity) && (!(e instanceof PlayerEntity) || e.world.getDifficulty() != Difficulty.PEACEFUL)));
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
                    skele.setPositionAndRotation(playerentity.posX, playerentity.posY, playerentity.posZ, playerentity.rotationYaw, playerentity.rotationPitch);
                    playerentity.world.addEntity(skele);
                }
            } else if(entityIn instanceof HorseEntity && !entityIn.isAlive()) {
                SkeletonHorseEntity skele = EntityType.SKELETON_HORSE.create(entityIn.world);
                skele.setPositionAndRotation(entityIn.posX, entityIn.posY, entityIn.posZ, entityIn.rotationYaw, entityIn.rotationPitch);
                skele.onInitialSpawn(entityIn.world, entityIn.world.getDifficultyForLocation(new BlockPos(entityIn)), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
                skele.hurtResistantTime = 60;
                skele.enablePersistence();
                skele.setHorseTamed(true);
                skele.setGrowingAge(0);
                entityIn.world.addEntity(skele);
            }
            this.applyEnchantments(this, entityIn);
        }

        return flag;
    }

    @Override
    public EntityTypeContainer<?> getContainer() {
        return ModEntities.PIRANHA;
    }

    @Override
    public EntityTypeContainerBAPContainable<?, ?> getContainableContainer() {
        return ModEntities.PIRANHA;
    }

}
