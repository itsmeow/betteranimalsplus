package its_meow.betteranimalsplus.common.entity;

import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.interfaces.ISelectiveVariantTypes;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntityWaterMobPathing;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntityWaterMobPathingWithTypesAirBreathing;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModLootTables;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.DolphinLookController;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.*;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.common.BiomeDictionary.Type;

import java.util.Set;

public class EntityWhale extends EntityWaterMobPathingWithTypesAirBreathing implements ISelectiveVariantTypes<EntityWaterMobPathing> {

    public int attacksLeft = 0;

    public EntityWhale(EntityType<? extends EntityWhale> entityType, World worldIn) {
        super(entityType, worldIn);
        this.lookController = new DolphinLookController(this, 10);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new BreatheAirGoal(this));
        this.goalSelector.addGoal(0, new FindWaterGoal(this));
        this.goalSelector.addGoal(2, new WhaleMeleeAttackGoal(this));
        this.goalSelector.addGoal(3, new RandomSwimmingGoal(this, 1.0D, 10));
        this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(0, new HurtByTargetGoal(this) {
            @Override
            public boolean shouldExecute() {
                return EntityWhale.this.world.getDifficulty() != Difficulty.PEACEFUL && super.shouldExecute();
            }
        });
    }

    @Override
    protected SoundEvent getSplashSound() {
        return SoundEvents.ENTITY_DOLPHIN_SPLASH;
    }

    @Override
    protected SoundEvent getSwimSound() {
        return SoundEvents.ENTITY_DOLPHIN_SWIM;
    }

    private boolean isNarwhal() {
        return "narwhal".equals(this.getVariantNameOrEmpty());
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float) (isNarwhal() ? this.getAttribute(Attributes.ATTACK_DAMAGE).getValue() : 1F));
        if(flag) {
            if(!isNarwhal()) {
                if(attacksLeft > 0) {
                    attacksLeft--;
                }
                if(entityIn instanceof PlayerEntity) {
                    PlayerEntity player = (PlayerEntity) entityIn;
                    int ticks = 0;
                    if (this.world.getDifficulty() == Difficulty.EASY) {
                        ticks = 50;
                    } else if (this.world.getDifficulty() == Difficulty.NORMAL) {
                        ticks = 100;
                    } else if (this.world.getDifficulty() == Difficulty.HARD) {
                        ticks = 140;
                    }
                    player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, ticks, 1, false, false));
                    player.addPotionEffect(new EffectInstance(Effects.NAUSEA, ticks + 40, 1, false, false));
                }
            }
            Vector3d pos = this.getPositionVec();
            Vector3d targetPos = entityIn.getPositionVec();
            ((LivingEntity) entityIn).applyKnockback(isNarwhal() ? 0.8F : 2F, pos.x - targetPos.x, pos.z - targetPos.z);
        }
        return flag;
    }

    @Override
    public String[] getTypesFor(RegistryKey<Biome> biomeKey, Biome biome, Set<Type> types, SpawnReason reason) {
        if(biomeKey == Biomes.COLD_OCEAN || biomeKey == Biomes.DEEP_COLD_OCEAN) {
            return new String[] { "bottlenose", "pilot" };
        } else if(biomeKey == Biomes.DEEP_FROZEN_OCEAN || biomeKey == Biomes.FROZEN_OCEAN) {
            return new String[] { "narwhal", "beluga" };
        } else if(biomeKey == Biomes.DEEP_LUKEWARM_OCEAN || biomeKey == Biomes.DEEP_OCEAN || biomeKey == Biomes.DEEP_WARM_OCEAN) {
            return new String[] { "cuviers", "pilot" };
        } else {
            return new String[] { "cuviers", "pilot", "false_killer" };
        }
    }

    @Override
    protected ResourceLocation getLootTable() {
        return ModLootTables.WHALE;
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
        public void startExecuting() {
            if(!whale.isNarwhal()) {
                whale.attacksLeft = 1;
            }
            super.startExecuting();
        }

        @Override
        public boolean shouldContinueExecuting() {
            return (whale.isNarwhal() || whale.attacksLeft > 0) && super.shouldContinueExecuting();
        }

        @Override
        protected void checkAndPerformAttack(LivingEntity p_190102_1_, double p_190102_2_) {
            if(whale.attacksLeft > 0 || whale.isNarwhal()) {
                super.checkAndPerformAttack(p_190102_1_, p_190102_2_);
            } else {
                this.resetTask();
            }
        }

        @Override
        public void resetTask() {
            super.resetTask();
            if(whale.attacksLeft <= 0 && !whale.isNarwhal()) {
                this.attacker.setAttackTarget(null);
            }
        }
        
        @Override
        protected double getAttackReachSqr(LivingEntity attackTarget) {
            return this.attacker.getWidth() * this.attacker.getWidth() + attackTarget.getWidth();
         }
        
    }

}
