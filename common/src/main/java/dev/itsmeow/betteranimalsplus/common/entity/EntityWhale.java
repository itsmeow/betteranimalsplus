package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityWaterMobPathing;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityWaterMobPathingWithTypesAirBreathing;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.interfaces.ISelectiveVariantTypes;
import dev.itsmeow.imdlib.entity.interfaces.IVariantTypes;
import dev.itsmeow.imdlib.entity.util.BiomeTypes;
import dev.itsmeow.imdlib.entity.util.variant.IVariant;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.phys.Vec3;

import java.util.Set;

public class EntityWhale extends EntityWaterMobPathingWithTypesAirBreathing implements ISelectiveVariantTypes<EntityWaterMobPathing> {

    private static final String[] COLD_TYPES = new String[] { "bottlenose", "pilot", "right", "blue" };
    private static final String[] FROZEN_TYPES = new String[] { "narwhal", "beluga" };
    private static final String[] DEEP_TYPES = new String[] { "cuviers", "pilot", "sperm", "sperm_albino", "right", "blue" };
    private static final String[] WARM_OTHER_TYPES = new String[] { "cuviers", "pilot", "false_killer", "sperm", "sperm_albino", "blue" };

    private static final EntityDimensions BLUE_DIMENSIONS = EntityDimensions.scalable(16F, 4F);
    private static final EntityDimensions SPERM_AND_RIGHT_DIMENSIONS = EntityDimensions.scalable(12F, 3.5F);

    public int attacksLeft = 0;

    public EntityWhale(EntityType<? extends EntityWhale> entityType, Level worldIn) {
        super(entityType, worldIn);
        this.fixupDimensions();
        // this 4 is very important for making sure they don't break the laws of fluid by dynamics by doing a 360 noscope in 0.2sec
        this.moveControl = new SmoothSwimmingMoveControl(this, 15, 4, 0.02F, 0.005F, true);
        this.lookControl = new SmoothSwimmingLookControl(this, 10);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new BreathAirGoal(this));
        this.goalSelector.addGoal(0, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(2, new WhaleMeleeAttackGoal(this));
        this.goalSelector.addGoal(3, new RandomSwimmingGoal(this, 1.0D, 10));
        this.targetSelector.addGoal(0, new HurtByTargetGoal(this) {
            @Override
            public boolean canUse() {
                return EntityWhale.this.level.getDifficulty() != Difficulty.PEACEFUL && super.canUse();
            }
        });
    }

    @Override
    public IVariantTypes<EntityWaterMobPathing> setType(String variantKey) {
        IVariantTypes<EntityWaterMobPathing> result = super.setType(variantKey);
        this.refreshDimensions();
        return result;
    }

    @Override
    public IVariantTypes<EntityWaterMobPathing> setType(IVariant variant) {
        IVariantTypes<EntityWaterMobPathing> result = super.setType(variant);
        this.refreshDimensions();
        return result;
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> entityDataAccessor) {
        // Update on variant change for the client
        if (this.getContainer().getVariantDataKey().equals(entityDataAccessor)) {
            this.refreshDimensions();
        }
        super.onSyncedDataUpdated(entityDataAccessor);
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        String variantName = this.getVariantNameOrEmpty();
        switch(variantName) {
            case "sperm":
            case "sperm_albino":
            case "right":
                return SPERM_AND_RIGHT_DIMENSIONS.scale(this.getScale());
            case "blue":
                return BLUE_DIMENSIONS.scale(this.getScale());
            default:
                return this.getType().getDimensions().scale(this.getScale());
        }
    }

    @Override
    protected SoundEvent getSwimSplashSound() {
        return SoundEvents.DOLPHIN_SPLASH;
    }

    @Override
    protected SoundEvent getSwimSound() {
        return SoundEvents.DOLPHIN_SWIM;
    }

    private boolean isNarwhal() {
        return "narwhal".equals(this.getVariantNameOrEmpty());
    }

    @Override
    public int getHeadRotSpeed() {
        return 1;
    }

    @Override
    public int getMaxHeadXRot() {
        return 1;
    }

    @Override
    public int getMaxHeadYRot() {
        return 1;
    }

    @Override
    public boolean doHurtTarget(Entity entityIn) {
        boolean flag = entityIn.hurt(DamageSource.mobAttack(this), (float) (isNarwhal() ? this.getAttribute(Attributes.ATTACK_DAMAGE).getValue() : 1F));
        if(flag) {
            if(!isNarwhal()) {
                if(attacksLeft > 0) {
                    attacksLeft--;
                }
                if(entityIn instanceof Player) {
                    Player player = (Player) entityIn;
                    int ticks = 0;
                    switch (this.level.getDifficulty()) {
                        case EASY:
                            ticks = 50;
                            break;
                        case NORMAL:
                            ticks = 100;
                            break;
                        case HARD:
                            ticks = 140;
                            break;
                    };
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, ticks, 1, false, false));
                    player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, ticks + 40, 1, false, false));
                }
            }
            Vec3 pos = this.position();
            Vec3 targetPos = entityIn.position();
            ((LivingEntity) entityIn).knockback(isNarwhal() ? 0.8F : 2F, pos.x - targetPos.x, pos.z - targetPos.z);
        }
        return flag;
    }

    @Override
    public String[] getTypesFor(ResourceKey<Biome> biomeKey, Biome biome, Set<BiomeTypes.Type> types, MobSpawnType reason) {
        if(biomeKey == Biomes.COLD_OCEAN || biomeKey == Biomes.DEEP_COLD_OCEAN) {
            return COLD_TYPES;
        } else if(biomeKey == Biomes.DEEP_FROZEN_OCEAN || biomeKey == Biomes.FROZEN_OCEAN) {
            return FROZEN_TYPES;
        } else if(biomeKey == Biomes.DEEP_LUKEWARM_OCEAN || biomeKey == Biomes.DEEP_OCEAN) {
            return DEEP_TYPES;
        } else {
            return WARM_OTHER_TYPES;
        }
    }

    @Override
    public EntityTypeContainer<? extends EntityWhale> getContainer() {
        return ModEntities.WHALE;
    }
    
    public static class WhaleMeleeAttackGoal extends MeleeAttackGoal {
        
        private final EntityWhale whale;

        public WhaleMeleeAttackGoal(EntityWhale whale) {
            super(whale, 1.2F, true);
            this.whale = whale;
        }
        
        @Override
        public void start() {
            if(!whale.isNarwhal()) {
                whale.attacksLeft = 1;
            }
            super.start();
        }

        @Override
        public boolean canContinueToUse() {
            return (whale.isNarwhal() || whale.attacksLeft > 0) && super.canContinueToUse();
        }

        @Override
        protected void checkAndPerformAttack(LivingEntity p_190102_1_, double p_190102_2_) {
            if(whale.attacksLeft > 0 || whale.isNarwhal()) {
                super.checkAndPerformAttack(p_190102_1_, p_190102_2_);
            } else {
                this.stop();
            }
        }

        @Override
        public void stop() {
            super.stop();
            if(whale.attacksLeft <= 0 && !whale.isNarwhal()) {
                this.mob.setTarget(null);
            }
        }
        
        @Override
        protected double getAttackReachSqr(LivingEntity attackTarget) {
            return this.mob.getBbWidth() * this.mob.getBbWidth() + attackTarget.getBbWidth();
         }
        
    }

}
