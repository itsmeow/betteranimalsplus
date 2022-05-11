package dev.itsmeow.betteranimalsplus.common.entity.ai;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.entity.EntitySelector;

import java.util.EnumSet;

public class EfficientMoveTowardsTargetGoal extends Goal {
    protected final PathfinderMob attacker;
    private final double speedTowardsTarget;
    private final boolean longMemory;
    private Path path;
    private int delayCounter;
    private double targetX;
    private double targetY;
    private double targetZ;
    private long lastCheckTime;

    public EfficientMoveTowardsTargetGoal(PathfinderMob creature, double speedIn, boolean useLongMemory) {
        this.attacker = creature;
        this.speedTowardsTarget = speedIn;
        this.longMemory = useLongMemory;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        long i = this.attacker.level.getGameTime();
        if (i - this.lastCheckTime < 20L) {
            return false;
        } else {
            this.lastCheckTime = i;
            LivingEntity livingentity = this.attacker.getTarget();
            if (livingentity == null) {
                return false;
            } else if (!livingentity.isAlive()) {
                return false;
            } else {
                this.path = this.attacker.getNavigation().createPath(livingentity, 0);
                if (this.path != null) {
                    return true;
                } else {
                    return this.getAttackReachSqr(livingentity) >= this.attacker.distanceToSqr(livingentity.getX(), livingentity.getY(), livingentity.getZ());
                }
            }
        }
    }

    @Override
    public boolean canContinueToUse() {
        LivingEntity livingentity = this.attacker.getTarget();
        if (livingentity == null) {
            return false;
        } else if (!livingentity.isAlive()) {
            return false;
        } else if (!this.longMemory) {
            return !this.attacker.getNavigation().isDone();
        } else if (!this.attacker.isWithinRestriction(livingentity.blockPosition())) {
            return false;
        } else {
            return !(livingentity instanceof Player) || !livingentity.isSpectator() && !((Player) livingentity).isCreative();
        }
    }

    @Override
    public void start() {
        this.attacker.getNavigation().moveTo(this.path, this.speedTowardsTarget);
        this.attacker.setAggressive(true);
        this.delayCounter = 0;
    }

    @Override
    public void stop() {
        LivingEntity livingentity = this.attacker.getTarget();
        if (!EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(livingentity)) {
            this.attacker.setTarget(null);
        }
        this.attacker.setAggressive(false);
        this.attacker.getNavigation().stop();
    }

    @Override
    public void tick() {
        LivingEntity livingentity = this.attacker.getTarget();
        this.attacker.getLookControl().setLookAt(livingentity, 30.0F, 30.0F);
        --this.delayCounter;
        if ((this.longMemory || this.attacker.getSensing().hasLineOfSight(livingentity)) && this.delayCounter <= 0 && (this.targetX == 0.0D && this.targetY == 0.0D && this.targetZ == 0.0D || livingentity.distanceToSqr(this.targetX, this.targetY, this.targetZ) >= 1.0D || this.attacker.getRandom().nextFloat() < 0.05F)) {
            double d0 = this.attacker.distanceToSqr(livingentity.getX(), livingentity.getY(), livingentity.getZ());
            this.targetX = livingentity.getX();
            this.targetY = livingentity.getY();
            this.targetZ = livingentity.getZ();
            this.delayCounter = 4 + this.attacker.getRandom().nextInt(7);
            if (d0 > 1024.0D) {
                this.delayCounter += 10;
            } else if (d0 > 256.0D) {
                this.delayCounter += 5;
            }

            if (!this.attacker.getNavigation().moveTo(livingentity, this.speedTowardsTarget)) {
                this.delayCounter += 15;
            }
        }
    }

    protected double getAttackReachSqr(LivingEntity attackTarget) {
        return this.attacker.getBbWidth() * 2.0D * this.attacker.getBbWidth() * 2.0D + attackTarget.getBbWidth();
    }
}