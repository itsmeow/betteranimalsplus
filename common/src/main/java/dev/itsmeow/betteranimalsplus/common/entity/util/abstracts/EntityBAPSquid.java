package dev.itsmeow.betteranimalsplus.common.entity.util.abstracts;

import dev.itsmeow.betteranimalsplus.common.entity.ai.EfficientMoveTowardsTargetGoal;
import dev.itsmeow.betteranimalsplus.init.ModTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;

import java.util.Random;

public abstract class EntityBAPSquid extends EntityBAPCephalopod {

    private float lastAttack = 0;
    private float lastTickHealth = 0;
    private float lastGrab = 0;

    public EntityBAPSquid(EntityType<? extends WaterAnimal> type, Level world) {
        super(type, world);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new EfficientMoveTowardsTargetGoal(this, 1D, true));
        this.goalSelector.addGoal(1, new MoveRandomGoal(this));
        this.targetSelector.addGoal(0, new HurtByTargetGoal(this) {
            @Override
            public boolean canUse() {
                return EntityBAPSquid.this.level.getDifficulty() != Difficulty.PEACEFUL && super.canUse();
            }
        });
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, WaterAnimal.class, 20, true, true, e -> true));
    }

    @Override
    public void setTarget(LivingEntity entitylivingbaseIn) {
        if(!this.isPeaceful()) {
            if(entitylivingbaseIn instanceof ServerPlayer) {
                ModTriggers.SQUID_TARGETED.trigger((ServerPlayer) entitylivingbaseIn);
            }
            super.setTarget(entitylivingbaseIn);
        }
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if(this.isInWater() && this.getY() > level.getSeaLevel() - 8) {
            this.setDeltaMovement(this.getDeltaMovement().add(0D, -0.05D, 0D));
        }
        if(this.getTarget() != null && !this.getTarget().isAlive()) {
            this.setTarget(null);
        }
        if(!this.level.isClientSide && this.getTarget() != null && this.getTarget().isAlive() && this.isAlive() && !this.isPeaceful()) {
            boolean isBoat = this.getTarget() instanceof Player && this.getTarget().getVehicle() != null && this.getTarget().getVehicle() instanceof Boat;
            float grabDelay = isBoat ? 20F : 60F;
            if(this.getPassengers().contains(this.getTarget())) {
                float time = 30F * ((float) Math.random() + 1F);
                if(this.lastAttack + time < this.tickCount) {
                    this.doHurtTarget(this.getTarget());
                }
            } else if(lastGrab + grabDelay < this.tickCount && this.distanceToSqr(this.getTarget()) < 5) {
                if(isBoat) {
                    Boat boat = (Boat) this.getTarget().getVehicle();
                    boat.hurt(DamageSource.mobAttack(this), 5F);
                } else if(!this.getTarget().isInvulnerable() && this.getTarget().getBbWidth() < 2.5 && this.getTarget().getBbHeight() < 2.5) {
                    if(this.getTarget() instanceof Mob) {
                        Mob el = (Mob) this.getTarget();
                        el.setTarget(null);
                        el.setLastHurtByMob(null);
                        el.getNavigation().stop();
                        el.setNoAi(true);
                    }
                    this.getTarget().startRiding(this, false);
                } else if(!this.getTarget().isInvulnerable()) {
                    this.doHurtTarget(this.getTarget());
                }
                lastGrab = this.tickCount;
            }
            if(lastTickHealth - 4F > this.getHealth()) {
                this.getTarget().stopRiding();
                if(this.getTarget() instanceof Mob) {
                    Mob el = (Mob) this.getTarget();
                    el.setNoAi(false);
                }
            }
        }
        this.lastTickHealth = this.getHealth();
    }

    @Override
    public boolean doHurtTarget(Entity entityIn) {
        if(super.doHurtTarget(entityIn)) {
            this.lastAttack = this.tickCount;
            return true;
        }
        return false;
    }

    public static <T extends EntityBAPSquid> boolean placement(EntityType<T> type, LevelAccessor world, MobSpawnType reason, BlockPos pos, Random rng) {
        return pos.getY() < (world.getSeaLevel() - 31) && world.getBlockState(pos).getBlock() == Blocks.WATER && world.getEntitiesOfClass(EntityBAPSquid.class, new AABB(pos).inflate(100D)).size() == 0;
    }
}
