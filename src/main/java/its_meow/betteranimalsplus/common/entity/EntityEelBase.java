package its_meow.betteranimalsplus.common.entity;

import java.util.List;

import com.google.common.base.Predicate;

import its_meow.betteranimalsplus.common.entity.ai.EntityAIWanderWaterEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public abstract class EntityEelBase extends EntityWaterCreatureWithTypes {
    
    private static final Predicate<EntityItem> ITEM_SELECTOR = (item) -> {
        return !item.cannotPickup() && !item.isDead && item.getItem().getItem() instanceof ItemFood;
    };
    private int collideWithItemTicks = 0;
    private int lastItemCount = 0;

    public EntityEelBase(World worldIn) {
        super(worldIn);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAIAttackMelee(this, 0.8D, false) {
            @Override
            public boolean shouldContinueExecuting() {
                if(shouldCheckTarget() && EntityEelBase.this.getAttackTarget() != null && !isHoldingFood(EntityEelBase.this.getAttackTarget())) {
                    EntityEelBase.this.setAttackTarget(null);
                    return false;
                }
                return super.shouldContinueExecuting();
            }
        });
        this.tasks.addTask(1, new EntityAILookIdle(this));
        this.tasks.addTask(2, new EntityEelBase.MoveToFoodItemsGoal());
        this.tasks.addTask(3, new EntityAIWanderWaterEntity(this, 0.5D, 1));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget<EntityPlayer>(this, EntityPlayer.class, 0, true, true, EntityEelBase::isHoldingFood));
    }

    protected boolean shouldCheckTarget() {
        return true;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(2D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.5D);
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        List<EntityItem> items = world.getEntitiesWithinAABB(EntityItem.class, this.getEntityBoundingBox(), EntityEelBase.ITEM_SELECTOR);
        if(items.size() > 0 && items.size() == lastItemCount) {
            collideWithItemTicks++;
            if(collideWithItemTicks > 40 && this.getRNG().nextInt(20) == 0) {
                collideWithItemTicks = 0;
                EntityItem item = items.get(this.getRNG().nextInt(items.size()));
                ItemStack stack = item.getItem();
                if(stack.getItem() instanceof ItemFood) {
                    this.heal(((ItemFood) stack.getItem()).getSaturationModifier(stack));
                    item.setDead();
                }
            }
        } else {
            collideWithItemTicks = 0;
        }
        lastItemCount = items.size();
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        return entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float) this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue());
    }

    protected static boolean isHoldingFood(EntityLivingBase entity) {
        return entity.getHeldItemMainhand().getItem() instanceof ItemFood || entity.getHeldItemOffhand().getItem() instanceof ItemFood;
    }
    
    public class MoveToFoodItemsGoal extends EntityAIBase {
        public MoveToFoodItemsGoal() {
            this.setMutexBits(1);
        }

        @Override
        public boolean shouldExecute() {
            if(EntityEelBase.this.getAttackTarget() == null && EntityEelBase.this.getRevengeTarget() == null) {
                if(EntityEelBase.this.getRNG().nextInt(10) != 0) {
                    return false;
                } else {
                    List<EntityItem> list = EntityEelBase.this.world.getEntitiesWithinAABB(EntityItem.class, EntityEelBase.this.getEntityBoundingBox().grow(8.0D, 8.0D, 8.0D), EntityEelBase.ITEM_SELECTOR);
                    return !list.isEmpty();
                }
            } else {
                return false;
            }
        }

        @Override
        public void updateTask() {
            List<EntityItem> list = EntityEelBase.this.world.getEntitiesWithinAABB(EntityItem.class, EntityEelBase.this.getEntityBoundingBox().grow(8.0D, 8.0D, 8.0D), EntityEelBase.ITEM_SELECTOR);
            if(!list.isEmpty()) {
                EntityEelBase.this.getNavigator().tryMoveToEntityLiving(list.get(0), (double) 1.2F);
            }

        }

        @Override
        public void startExecuting() {
            List<EntityItem> list = EntityEelBase.this.world.getEntitiesWithinAABB(EntityItem.class, EntityEelBase.this.getEntityBoundingBox().grow(8.0D, 8.0D, 8.0D), EntityEelBase.ITEM_SELECTOR);
            if(!list.isEmpty()) {
                EntityEelBase.this.getNavigator().tryMoveToEntityLiving(list.get(0), (double) 1.2F);
            }
        }
    }

}
