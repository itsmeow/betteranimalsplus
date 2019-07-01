package its_meow.betteranimalsplus.common.entity;

import its_meow.betteranimalsplus.init.ModEntities;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EntityCrab extends EntityAnimalWithTypes {

    public int snipTime = 0;
    public boolean crabRave = false;

    public EntityCrab(World world) {
        super(ModEntities.getEntityType("crab"), world);
        this.setPathPriority(PathNodeType.WATER, 10F);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 0.9D, true) {
            @Override
            public boolean shouldExecute() {
                return super.shouldExecute() && this.field_75441_b.getHealth() > this.field_75441_b.getMaxHealth() / 2F;
            }

            @Override
            public boolean shouldContinueExecuting() {
                return super.shouldContinueExecuting() && this.field_75441_b.getHealth() > this.field_75441_b.getMaxHealth() / 2F;
            }
        });
        this.goalSelector.addGoal(1, new AvoidEntityGoal<PlayerEntity>(this, PlayerEntity.class, 20F, 0.8F, 1.0F));
        this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 0.3D));
        this.targetSelector.addGoal(1, new AIHurtByTarget());
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.5D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3D);
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        if(snipTime == 0) {
            snipTime = 20;
        }
        Vec3d pos = this.getPositionVector();
        Vec3d targetPos = entityIn.getPositionVector();
        if(entityIn instanceof LivingEntity) {
            ((LivingEntity) entityIn).knockBack(entityIn, 0.1F, pos.x - targetPos.x, pos.z - targetPos.z);
        }
        
        // vanilla things
        
        float f = (float)this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue();

        if(entityIn instanceof LivingEntity) {
            f += EnchantmentHelper.getModifierForCreature(this.getHeldItemMainhand(), ((LivingEntity)entityIn).getCreatureAttribute());
        }
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), f);
        if(flag) {
            if(entityIn instanceof PlayerEntity) {
                PlayerEntity entityplayer = (PlayerEntity)entityIn;

                int weakTicks = 0;
                if (this.world.getDifficulty() == Difficulty.EASY) {
                    weakTicks = 200;
                } else if (this.world.getDifficulty() == Difficulty.NORMAL) {
                    weakTicks = 300;
                } else if (this.world.getDifficulty() == Difficulty.HARD) {
                    weakTicks = 600;
                }
                entityplayer.addPotionEffect(new EffectInstance(Effects.WEAKNESS, weakTicks, 1, false, false));
                ItemStack itemstack = this.getHeldItemMainhand();
                ItemStack itemstack1 = entityplayer.isHandActive() ? entityplayer.getActiveItemStack() : ItemStack.EMPTY;
                if(!itemstack.isEmpty() && !itemstack1.isEmpty() && itemstack.getItem().canDisableShield(itemstack, itemstack1, entityplayer, this) && itemstack1.getItem().isShield(itemstack1, entityplayer)) {
                    float f1 = 0.25F + (float)EnchantmentHelper.getEfficiencyModifier(this) * 0.05F;
                    if(this.rand.nextFloat() < f1) {
                        entityplayer.getCooldownTracker().setCooldown(itemstack1.getItem(), 100);
                        this.world.setEntityState(entityplayer, (byte)30);
                    }
                }
            }
            this.applyEnchantments(this, entityIn);
        }
        return flag;
    }

    @Override
    public void tick() {
        super.tick();
        if(snipTime == 0 && Math.random() < 0.005) {
            snipTime = 20;
        } else if(snipTime > 0) {
            snipTime--;
        } else {
            snipTime = 0;
        }
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return true;
    }

    @Override
    public int getTalkInterval() {
        return 120;
    }

    @Override
    public boolean canDespawn(double distance) {
        return !this.hasCustomName() && distance > 30D;
    }

    @Override
    protected int getExperiencePoints(PlayerEntity player) {
        return 1 + this.world.rand.nextInt(3);
    }
    
    @Override
    public boolean isPushedByWater() {
        return false;
    }

    @Override
    public int getVariantMax() {
        return 4;
    }

    @Override
    public boolean processInteract(PlayerEntity player, Hand hand) {
        if(hand == Hand.MAIN_HAND) {
            if(!crabRave) {
                this.crabRave();
            } else {
                crabRave = false;
            }
        }
        return super.processInteract(player, hand);
    }

    public void crabRave() {
        crabRave = true;
        this.setAttackTarget(null);
        this.navigator.clearPath();
    }

    @Override
    public boolean isAIDisabled() {
        return crabRave;
    }

    @Override
    protected IVariantTypes getBaseChild() {
        return new EntityCrab(this.world);
    }

    @Override
    protected float getWaterSlowDown() {
        return 0F;
    }

    class AIHurtByTarget extends HurtByTargetGoal {
        public AIHurtByTarget() {
            super(EntityCrab.this);
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        @Override
        public void startExecuting() {
            super.startExecuting();

            if(EntityCrab.this.isChild()) {
                this.alertOthers();
                this.resetTask();
            }
        }

        @Override
        protected void setAttackTarget(MobEntity mob, LivingEntity living) {
            if (mob instanceof EntityCrab && !mob.isChild()) {
                super.setAttackTarget(mob, living);
            }
        }
    }

}
