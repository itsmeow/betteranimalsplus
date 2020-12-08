package its_meow.betteranimalsplus.common.entity.util.abstracts;

import java.util.EnumSet;
import java.util.List;
import java.util.function.Predicate;

import its_meow.betteranimalsplus.common.entity.ai.PeacefulNearestAttackableTargetGoal;
import its_meow.betteranimalsplus.init.ModLootTables;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public abstract class EntityEelBase extends EntityWaterMobPathingWithTypesBucketable {

    private static final Predicate<ItemEntity> ITEM_SELECTOR = (item) -> {
        return !item.cannotPickup() && item.isAlive() && item.getItem().isFood();
    };
    private int collideWithItemTicks = 0;
    private ItemEntity collidedItem = null;

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
        this.goalSelector.addGoal(2, new EntityEelBase.MoveToFoodItemsGoal());
        //this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(3, new RandomSwimmingGoal(this, 0.25D, 1));
        this.targetSelector.addGoal(1, new PeacefulNearestAttackableTargetGoal<PlayerEntity>(this, PlayerEntity.class, 0, true, true, EntityEelBase::isHoldingFood));
    }

    protected boolean shouldCheckTarget() {
        return true;
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    public void tick() {
        super.tick();
        List<ItemEntity> items = world.getEntitiesWithinAABB(ItemEntity.class, this.getBoundingBox().grow(0.4D), EntityEelBase.ITEM_SELECTOR);
        if(items.size() > 0 && (collidedItem == null || items.contains(collidedItem))) {
            if(collidedItem == null) {
                collidedItem = items.get(this.getRNG().nextInt(items.size()));
            }
            collideWithItemTicks++;
            if(collideWithItemTicks > 35) {
                if(this.getRNG().nextFloat() < 0.1F) {
                    this.playSound(SoundEvents.ENTITY_GENERIC_EAT, 1.0F, 1.0F);
                    this.world.setEntityState(this, (byte) 45); // calls handleStatusUpdate((byte) 45);
                }
                if(collideWithItemTicks > 40 && this.getRNG().nextInt(20) == 0) {
                    collideWithItemTicks = 0;
                    ItemEntity item = collidedItem;
                    ItemStack stack = item.getItem();
                    if(stack.isFood()) {
                        this.heal(stack.getItem().getFood().getSaturation());
                        item.remove();
                        collidedItem = null;
                        collideWithItemTicks = 0;
                    }
                }
            }
        } else {
            collideWithItemTicks = 0;
            collidedItem = null;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if(id == 45) {
            if(collidedItem != null) {
                ItemStack stack = collidedItem.getItem();
                if(!stack.isEmpty()) {
                    for(int i = 0; i < 8; ++i) {
                        Vector3d vec3d = (new Vector3d(((double) this.rand.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, 0.0D)).rotatePitch(-this.rotationPitch * ((float) Math.PI / 180F)).rotateYaw(-this.rotationYaw * ((float) Math.PI / 180F));
                        this.world.addParticle(new ItemParticleData(ParticleTypes.ITEM, stack), this.getPosX() + this.getLookVec().x / 2.0D, this.getPosY(), this.getPosZ() + this.getLookVec().z / 2.0D, vec3d.x, vec3d.y + 0.05D, vec3d.z);
                    }
                }
            }
        } else {
            super.handleStatusUpdate(id);
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        return entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float) this.getAttribute(Attributes.ATTACK_DAMAGE).getValue());
    }

    protected static boolean isHoldingFood(LivingEntity entity) {
        return entity.getHeldItemMainhand().isFood() || entity.getHeldItemOffhand().isFood();
    }

    @Override
    protected ResourceLocation getLootTable() {
        return ModLootTables.EELY;
    }

    public class MoveToFoodItemsGoal extends Goal {
        public MoveToFoodItemsGoal() {
            this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        @Override
        public boolean shouldExecute() {
            if(EntityEelBase.this.getAttackTarget() == null && EntityEelBase.this.getRevengeTarget() == null) {
                if(EntityEelBase.this.getRNG().nextInt(2) != 0) {
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
