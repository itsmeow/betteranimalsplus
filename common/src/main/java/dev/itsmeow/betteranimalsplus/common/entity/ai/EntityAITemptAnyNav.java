package dev.itsmeow.betteranimalsplus.common.entity.ai;

import java.util.EnumSet;
import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EntityAITemptAnyNav extends Goal {
    private static final EntityPredicate selector = (new EntityPredicate()).range(10.0D).allowSameTeam().allowInvulnerable();
    private final CreatureEntity entity;
    private final double speed;
    private PlayerEntity tempter;
    private int cooldown;
    private final Set<Item> temptItems;

    public EntityAITemptAnyNav(CreatureEntity creature, double speed, Set<Item> temptItems) {
       this.entity = creature;
       this.speed = speed;
       this.temptItems = temptItems;
       this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }
    
    public EntityAITemptAnyNav(CreatureEntity creature, double speed, Item... temptItems) {
        this(creature, speed, Sets.newHashSet(temptItems));
     }

    @Override
    public boolean canUse() {
        if(this.cooldown > 0) {
            --this.cooldown;
            return false;
        } else {
            this.tempter = this.entity.level.getNearestPlayer(selector, this.entity);
            if(this.tempter == null) {
                return false;
            } else {
                return this.isTemptedBy(this.tempter.getMainHandItem()) || this.isTemptedBy(this.tempter.getOffhandItem());
            }
        }
    }

    private boolean isTemptedBy(ItemStack stack) {
        return this.temptItems.contains(stack.getItem());
    }

    @Override
    public boolean canContinueToUse() {
        return this.canUse();
    }

    @Override
    public void stop() {
        this.tempter = null;
        this.entity.getNavigation().stop();
        this.cooldown = 100;
    }

    @Override
    public void tick() {
        this.entity.getLookControl().setLookAt(this.tempter, (float) (this.entity.getMaxHeadYRot() + 20), (float) this.entity.getMaxHeadXRot());
        if(this.entity.distanceToSqr(this.tempter) < 6.25D) {
            this.entity.getNavigation().stop();
        } else {
            this.entity.getNavigation().moveTo(this.tempter, this.speed);
        }

    }

}