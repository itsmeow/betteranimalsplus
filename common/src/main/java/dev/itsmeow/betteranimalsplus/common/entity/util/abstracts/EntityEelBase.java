package dev.itsmeow.betteranimalsplus.common.entity.util.abstracts;

import dev.itsmeow.betteranimalsplus.common.entity.ai.PeacefulNearestAttackableTargetGoal;
import dev.itsmeow.betteranimalsplus.init.ModLootTables;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;
import java.util.List;
import java.util.function.Predicate;

public abstract class EntityEelBase extends EntityWaterMobPathingWithTypesBucketable {

    private static final Predicate<ItemEntity> ITEM_SELECTOR = (item) -> !item.hasPickUpDelay() && item.isAlive() && item.getItem().isEdible();
    private int collideWithItemTicks = 0;
    private ItemEntity collidedItem = null;

    public EntityEelBase(EntityType<? extends EntityEelBase> entityType, Level worldIn) {
        super(entityType, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 0.8D, false) {
            @Override
            public boolean canContinueToUse() {
                if(shouldCheckTarget() && EntityEelBase.this.getTarget() != null && !isHoldingFood(EntityEelBase.this.getTarget())) {
                    EntityEelBase.this.setTarget(null);
                    return false;
                }
                return super.canContinueToUse();
            }
        });
        this.goalSelector.addGoal(2, new MoveToFoodItemsGoal());
        //this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(3, new RandomSwimmingGoal(this, 0.25D, 1));
        this.targetSelector.addGoal(1, new PeacefulNearestAttackableTargetGoal<>(this, Player.class, 0, true, true, EntityEelBase::isHoldingFood));
    }

    protected boolean shouldCheckTarget() {
        return true;
    }

    @Override
    protected boolean isMovementNoisy() {
        return false;
    }

    @Override
    public void tick() {
        super.tick();
        List<ItemEntity> items = level.getEntitiesOfClass(ItemEntity.class, this.getBoundingBox().inflate(0.4D), EntityEelBase.ITEM_SELECTOR);
        if(items.size() > 0 && (collidedItem == null || items.contains(collidedItem))) {
            if(collidedItem == null) {
                collidedItem = items.get(this.getRandom().nextInt(items.size()));
            }
            collideWithItemTicks++;
            if(collideWithItemTicks > 35) {
                if(this.getRandom().nextFloat() < 0.1F) {
                    this.playSound(SoundEvents.GENERIC_EAT, 1.0F, 1.0F);
                    this.level.broadcastEntityEvent(this, (byte) 45); // calls handleStatusUpdate((byte) 45);
                }
                if(collideWithItemTicks > 40 && this.getRandom().nextInt(20) == 0) {
                    collideWithItemTicks = 0;
                    ItemEntity item = collidedItem;
                    ItemStack stack = item.getItem();
                    if(stack.isEdible()) {
                        this.heal(stack.getItem().getFoodProperties().getSaturationModifier());
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

    @Override
    @Environment(EnvType.CLIENT)
    public void handleEntityEvent(byte id) {
        if(id == 45) {
            if(collidedItem != null) {
                ItemStack stack = collidedItem.getItem();
                if(!stack.isEmpty()) {
                    for(int i = 0; i < 8; ++i) {
                        Vec3 vec3d = (new Vec3(((double) this.random.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, 0.0D)).xRot(-this.xRot * ((float) Math.PI / 180F)).yRot(-this.yRot * ((float) Math.PI / 180F));
                        this.level.addParticle(new ItemParticleOption(ParticleTypes.ITEM, stack), this.getX() + this.getLookAngle().x / 2.0D, this.getY(), this.getZ() + this.getLookAngle().z / 2.0D, vec3d.x, vec3d.y + 0.05D, vec3d.z);
                    }
                }
            }
        } else {
            super.handleEntityEvent(id);
        }
    }

    @Override
    public boolean doHurtTarget(Entity entityIn) {
        return entityIn.hurt(DamageSource.mobAttack(this), (float) this.getAttribute(Attributes.ATTACK_DAMAGE).getValue());
    }

    protected static boolean isHoldingFood(LivingEntity entity) {
        return entity.getMainHandItem().isEdible() || entity.getOffhandItem().isEdible();
    }

    @Override
    protected ResourceLocation getDefaultLootTable() {
        return ModLootTables.EELY;
    }

    public class MoveToFoodItemsGoal extends Goal {
        public MoveToFoodItemsGoal() {
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            if(EntityEelBase.this.getTarget() == null && EntityEelBase.this.getLastHurtByMob() == null) {
                if(EntityEelBase.this.getRandom().nextInt(2) != 0) {
                    return false;
                } else {
                    List<ItemEntity> list = EntityEelBase.this.level.getEntitiesOfClass(ItemEntity.class, EntityEelBase.this.getBoundingBox().inflate(8.0D, 8.0D, 8.0D), EntityEelBase.ITEM_SELECTOR);
                    return !list.isEmpty();
                }
            } else {
                return false;
            }
        }

        @Override
        public void tick() {
            List<ItemEntity> list = EntityEelBase.this.level.getEntitiesOfClass(ItemEntity.class, EntityEelBase.this.getBoundingBox().inflate(8.0D, 8.0D, 8.0D), EntityEelBase.ITEM_SELECTOR);
            if(!list.isEmpty()) {
                EntityEelBase.this.getNavigation().moveTo(list.get(0), 1.2F);
            }

        }

        @Override
        public void start() {
            List<ItemEntity> list = EntityEelBase.this.level.getEntitiesOfClass(ItemEntity.class, EntityEelBase.this.getBoundingBox().inflate(8.0D, 8.0D, 8.0D), EntityEelBase.ITEM_SELECTOR);
            if(!list.isEmpty()) {
                EntityEelBase.this.getNavigation().moveTo(list.get(0), 1.2F);
            }
        }
    }

}
