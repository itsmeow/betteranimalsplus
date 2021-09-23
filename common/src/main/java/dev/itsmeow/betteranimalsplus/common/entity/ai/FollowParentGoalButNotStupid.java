package dev.itsmeow.betteranimalsplus.common.entity.ai;

import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.passive.AnimalEntity;

import java.util.List;
import java.util.function.Predicate;

public class FollowParentGoalButNotStupid extends Goal {
    protected final AnimalEntity childAnimal;
    protected AnimalEntity parentAnimal;
    protected final double moveSpeed;
    protected int delayCounter;
    protected Predicate<MobEntity> filter;

    public FollowParentGoalButNotStupid(AnimalEntity animal, double speed, Predicate<MobEntity> filter) {
        this.childAnimal = animal;
        this.moveSpeed = speed;
        this.filter = filter;
    }

    @Override
    public boolean canUse() {
        if (this.childAnimal.getAge() >= 0) {
            return false;
        } else {
            List<AnimalEntity> list = this.childAnimal.level.getEntitiesOfClass(this.childAnimal.getClass(), this.childAnimal.getBoundingBox().inflate(8.0D, 4.0D, 8.0D), filter);
            AnimalEntity animalentity = null;
            double d0 = Double.MAX_VALUE;

            for (AnimalEntity animalentity1 : list) {
                if (animalentity1.getAge() >= 0) {
                    double d1 = this.childAnimal.distanceToSqr(animalentity1);
                    if (!(d1 > d0)) {
                        d0 = d1;
                        animalentity = animalentity1;
                    }
                }
            }

            if (animalentity == null) {
                return false;
            } else if (d0 < 9.0D) {
                return false;
            } else {
                this.parentAnimal = animalentity;
                return true;
            }
        }
    }

    @Override
    public boolean canContinueToUse() {
        if (this.childAnimal.getAge() >= 0) {
            return false;
        } else if (!this.parentAnimal.isAlive()) {
            return false;
        } else {
            double d0 = this.childAnimal.distanceToSqr(this.parentAnimal);
            return !(d0 < 9.0D) && !(d0 > 256.0D);
        }
    }

    @Override
    public void start() {
        this.delayCounter = 0;
    }

    @Override
    public void stop() {
        this.parentAnimal = null;
    }

    @Override
    public void tick() {
        if (--this.delayCounter <= 0) {
            this.delayCounter = 10;
            this.childAnimal.getNavigation().moveTo(this.parentAnimal, this.moveSpeed);
        }
    }
}
