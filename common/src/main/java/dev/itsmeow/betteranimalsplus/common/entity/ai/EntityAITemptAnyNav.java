package dev.itsmeow.betteranimalsplus.common.entity.ai;

import java.util.EnumSet;
import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class EntityAITemptAnyNav extends Goal {
    private static final TargetingConditions selector = (new TargetingConditions()).range(10.0D).allowSameTeam().allowInvulnerable();
    private final PathfinderMob entity;
    private final double speed;
    private Player tempter;
    private int cooldown;
    private final Set<Item> temptItems;

    public EntityAITemptAnyNav(PathfinderMob creature, double speed, Set<Item> temptItems) {
       this.entity = creature;
       this.speed = speed;
       this.temptItems = temptItems;
       this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }
    
    public EntityAITemptAnyNav(PathfinderMob creature, double speed, Item... temptItems) {
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
