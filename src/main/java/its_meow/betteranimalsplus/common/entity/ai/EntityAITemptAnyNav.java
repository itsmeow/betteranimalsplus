package its_meow.betteranimalsplus.common.entity.ai;

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
    private static final EntityPredicate selector = (new EntityPredicate()).setDistance(10.0D).allowFriendlyFire().allowInvulnerable();
    private final CreatureEntity entity;
    private final double speed;
    private PlayerEntity tempter;
    private int cooldown;
    private final Set<Item> temptItems;

    public EntityAITemptAnyNav(CreatureEntity creature, double speed, Set<Item> temptItems) {
       this.entity = creature;
       this.speed = speed;
       this.temptItems = temptItems;
       this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }
    
    public EntityAITemptAnyNav(CreatureEntity creature, double speed, Item... temptItems) {
        this(creature, speed, Sets.newHashSet(temptItems));
     }

    @Override
    public boolean shouldExecute() {
        if(this.cooldown > 0) {
            --this.cooldown;
            return false;
        } else {
            this.tempter = this.entity.world.getClosestPlayer(selector, this.entity);
            if(this.tempter == null) {
                return false;
            } else {
                return this.isTemptedBy(this.tempter.getHeldItemMainhand()) || this.isTemptedBy(this.tempter.getHeldItemOffhand());
            }
        }
    }

    private boolean isTemptedBy(ItemStack stack) {
        return this.temptItems.contains(stack.getItem());
    }

    @Override
    public boolean shouldContinueExecuting() {
        return this.shouldExecute();
    }

    @Override
    public void resetTask() {
        this.tempter = null;
        this.entity.getNavigator().clearPath();
        this.cooldown = 100;
    }

    @Override
    public void tick() {
        this.entity.getLookController().setLookPositionWithEntity(this.tempter, (float) (this.entity.getHorizontalFaceSpeed() + 20), (float) this.entity.getVerticalFaceSpeed());
        if(this.entity.getDistanceSq(this.tempter) < 6.25D) {
            this.entity.getNavigator().clearPath();
        } else {
            this.entity.getNavigator().tryMoveToEntityLiving(this.tempter, this.speed);
        }

    }

}
