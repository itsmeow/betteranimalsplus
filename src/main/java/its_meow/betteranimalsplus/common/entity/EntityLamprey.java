package its_meow.betteranimalsplus.common.entity;

import dev.itsmeow.imdlib.entity.util.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.util.EntityTypeContainerContainable;
import its_meow.betteranimalsplus.common.entity.ai.EfficientMoveTowardsTargetGoal;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntityWaterMobPathingWithTypesBucketable;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModLootTables;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.SSetPassengersPacket;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

import java.util.HashSet;
import java.util.Set;

public class EntityLamprey extends EntityWaterMobPathingWithTypesBucketable implements IMob {

    protected int lastAttack = 0;

    public EntityLamprey(World worldIn) {
        super(ModEntities.LAMPREY.entityType, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new EfficientMoveTowardsTargetGoal(this, 0.8D, false));
        this.goalSelector.addGoal(1, new LookAtGoal(this, WaterMobEntity.class, 10.0F));
        this.goalSelector.addGoal(1, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(2, new RandomSwimmingGoal(this, 0.5D, 1));
        Set<Class<? extends LivingEntity>> blackList = new HashSet<>();
        blackList.add(SkeletonEntity.class);
        blackList.add(EndermanEntity.class);
        blackList.add(EntityJellyfish.class);
        blackList.add(EntityBobbitWorm.class);
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 100, true, true, e -> !(e instanceof IMob) && !(e.world.getDifficulty() == Difficulty.PEACEFUL && e instanceof PlayerEntity) && !blackList.contains(e.getClass())));
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(3.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.8D);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.5D);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_SQUID_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SQUID_DEATH;
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        float f = (float)this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue();

        if(entityIn instanceof LivingEntity) {
            f += EnchantmentHelper.getModifierForCreature(this.getHeldItemMainhand(), ((LivingEntity)entityIn).getCreatureAttribute());
        }
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), f);
        if(flag) {
            this.lastAttack = this.ticksExisted;
            if(entityIn instanceof PlayerEntity) {
                PlayerEntity entityplayer = (PlayerEntity)entityIn;

                int weakTicks = 0;
                if (this.world.getDifficulty() == Difficulty.EASY) {
                    weakTicks = 200;
                } else if (this.world.getDifficulty() == Difficulty.NORMAL) {
                    weakTicks = 300;
                } else if (this.world.getDifficulty() == Difficulty.HARD) {
                    weakTicks = 600;
                }
                entityplayer.addPotionEffect(new EffectInstance(Effects.WEAKNESS, weakTicks, 1, false, false));
                ItemStack itemstack = this.getHeldItemMainhand();
                ItemStack itemstack1 = entityplayer.isHandActive() ? entityplayer.getActiveItemStack() : ItemStack.EMPTY;
                if(!itemstack.isEmpty() && !itemstack1.isEmpty() && itemstack.getItem().canDisableShield(itemstack, itemstack1, entityplayer, this) && itemstack1.getItem().isShield(itemstack1, entityplayer)) {
                    float f1 = 0.25F + (float)EnchantmentHelper.getEfficiencyModifier(this) * 0.05F;
                    if(this.rand.nextFloat() < f1) {
                        entityplayer.getCooldownTracker().setCooldown(itemstack1.getItem(), 100);
                        this.world.setEntityState(entityplayer, (byte)30);
                    }
                }
            }
            this.applyEnchantments(this, entityIn);
        }
        return flag;
    }

    @Override
    public void livingTick() {
        super.livingTick();
        if(!this.isAlive() && this.getRidingEntity() != null) {
            this.stopRiding();
        }
        if(!this.world.isRemote && this.getAttackTarget() != null && this.getAttackTarget().isAlive()) {
            if(this.getRidingEntity() != null && this.getRidingEntity() == this.getAttackTarget()) {
                float time = 20F; 
                if(!this.inWater) {
                    time *= 2F * (Math.random() + 1F);
                } else {
                    time += Math.random() * Math.random() * 2 * ((Math.random() < 0.5) ? -1 : 1);
                }
                if(this.lastAttack + time < this.ticksExisted) {
                    this.attackEntityAsMob(this.getAttackTarget());
                }
            } else if(this.getDistanceSq(this.getAttackTarget()) < 3) {
                this.grabTarget(this.getAttackTarget());
            }
        }
    }

    @Override
    public void stopRiding() {
        Entity entity = this.getRidingEntity();
        if(entity != null) {
            if((entity.canBeRiddenInWater(this) || this.getAttackTarget() == null) && this.world.isAreaLoaded(this.getPosition(), 10)) {
                super.stopRiding();
            }
        }
    }

    @Override
    public boolean canBeRiddenInWater(Entity rider) {
        return true;
    }

    public void grabTarget(Entity entity) {
        if(entity == this.getAttackTarget() && !this.isRidingOrBeingRiddenBy(entity) && this.inWater) {
            this.startRiding(entity);
            if(entity instanceof ServerPlayerEntity) {
               ((ServerPlayerEntity) entity).connection.sendPacket(new SSetPassengersPacket(entity));
            }
        }
    }

    @Override
    public boolean shouldRiderSit() {
        return false;
    }

    @Override
    public double getYOffset() {
        if(getRidingEntity() != null && getRidingEntity() instanceof PlayerEntity) {
            return getRidingEntity().getHeight() - 2.25F;
        } else if(getRidingEntity() != null) {
            return getRidingEntity().getHeight() * 0.5D - 1.25D;
        } else {
            return super.getYOffset();
        }
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }
    
    @Override
    public boolean canRiderInteract() {
        return true;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return ModLootTables.EELY;
    }

    @Override
    public EntityTypeContainer<EntityLamprey> getContainer() {
        return ModEntities.LAMPREY;
    }

    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.ENTITY_COD_FLOP;
    }

    @Override
    public EntityTypeContainerContainable<?, ?> getContainableContainer() {
        return ModEntities.LAMPREY;
    }

}