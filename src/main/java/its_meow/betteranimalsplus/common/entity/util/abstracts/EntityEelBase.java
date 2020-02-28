package its_meow.betteranimalsplus.common.entity.util.abstracts;

import java.util.EnumSet;
import java.util.List;
import java.util.function.Predicate;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public abstract class EntityEelBase extends EntityWaterMobPathingWithTypesBucketable {
    
    private static final Predicate<ItemEntity> ITEM_SELECTOR = (item) -> {
        return !item.cannotPickup() && item.isAlive() && item.getItem().isFood();
    };
    private int collideWithItemTicks = 0;
    private int lastItemCount = 0;

    public EntityEelBase(EntityType<? extends EntityEelBase> entityType, World worldIn) {
        super(entityType, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 0.8D, false) {
            @Override
            public boolean shouldContinueExecuting() {
                if(shouldCheckTarget() && EntityEelBase.this.getAttackTarget() != null && !isHoldingFood(EntityEelBase.this.getAttackTarget())) {
                    EntityEelBase.this.setAttackTarget(null);
                    return false;
                }
                return super.shouldContinueExecuting();
            }
        });
        this.goalSelector.addGoal(1, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(2, new EntityEelBase.MoveToFoodItemsGoal());
        this.goalSelector.addGoal(3, new RandomSwimmingGoal(this, 0.5D, 1));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<PlayerEntity>(this, PlayerEntity.class, 0, true, true, EntityEelBase::isHoldingFood));
    }

    protected boolean shouldCheckTarget() {
        return true;
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(2D);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.5D);
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    public void tick() {
        super.tick();
        List<ItemEntity> items = world.getEntitiesWithinAABB(ItemEntity.class, this.getBoundingBox(), EntityEelBase.ITEM_SELECTOR);
        if(items.size() > 0 && items.size() == lastItemCount) {
            collideWithItemTicks++;
            if(collideWithItemTicks > 40 && this.getRNG().nextInt(20) == 0) {
                collideWithItemTicks = 0;
                ItemEntity item = items.get(this.getRNG().nextInt(items.size()));
                ItemStack stack = item.getItem();
                if(stack.isFood()) {
                    this.heal(stack.getItem().getFood().getSaturation());
                    item.remove();
                }
            }
        } else {
            collideWithItemTicks = 0;
        }
        lastItemCount = items.size();
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        return entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float) this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue());
    }

    protected static boolean isHoldingFood(LivingEntity entity) {
        return entity.getHeldItemMainhand().isFood() || entity.getHeldItemOffhand().isFood();
    }
    
    public class MoveToFoodItemsGoal extends Goal {
        public MoveToFoodItemsGoal() {
            this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        @Override
        public boolean shouldExecute() {
            if(EntityEelBase.this.getAttackTarget() == null && EntityEelBase.this.getRevengeTarget() == null) {
                if(EntityEelBase.this.getRNG().nextInt(10) != 0) {
                    return false;
                } else {
                    List<ItemEntity> list = EntityEelBase.this.world.getEntitiesWithinAABB(ItemEntity.class, EntityEelBase.this.getBoundingBox().grow(8.0D, 8.0D, 8.0D), EntityEelBase.ITEM_SELECTOR);
                    return !list.isEmpty();
                }
            } else {
                return false;
            }
        }

        @Override
        public void tick() {
            List<ItemEntity> list = EntityEelBase.this.world.getEntitiesWithinAABB(ItemEntity.class, EntityEelBase.this.getBoundingBox().grow(8.0D, 8.0D, 8.0D), EntityEelBase.ITEM_SELECTOR);
            if(!list.isEmpty()) {
                EntityEelBase.this.getNavigator().tryMoveToEntityLiving(list.get(0), (double) 1.2F);
            }

        }

        @Override
        public void startExecuting() {
            List<ItemEntity> list = EntityEelBase.this.world.getEntitiesWithinAABB(ItemEntity.class, EntityEelBase.this.getBoundingBox().grow(8.0D, 8.0D, 8.0D), EntityEelBase.ITEM_SELECTOR);
            if(!list.isEmpty()) {
                EntityEelBase.this.getNavigator().tryMoveToEntityLiving(list.get(0), (double) 1.2F);
            }
        }
    }

}
