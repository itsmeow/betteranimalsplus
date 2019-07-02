package its_meow.betteranimalsplus.common.entity;

import its_meow.betteranimalsplus.init.ModLootTables;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityCrab extends EntityAnimalWithTypes {

    public int snipTime = 0;
    protected static final DataParameter<Integer> CRAB_RAVE = EntityDataManager.<Integer>createKey(EntityCrab.class, DataSerializers.VARINT);

    public EntityCrab(World world) {
        super(world);
        this.setSize(1F, 0.65F);
        this.setPathPriority(PathNodeType.WATER, 10F);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAIAttackMelee(this, 0.9D, true) {
            @Override
            public boolean shouldExecute() {
                return super.shouldExecute() && this.attacker.getHealth() > this.attacker.getMaxHealth() / 2F;
            }

            @Override
            public boolean shouldContinueExecuting() {
                return super.shouldContinueExecuting() && this.attacker.getHealth() > this.attacker.getMaxHealth() / 2F;
            }
        });
        this.tasks.addTask(1, new EntityAIAvoidEntity<EntityPlayer>(this, EntityPlayer.class, 20F, 0.8F, 1.0F));
        this.tasks.addTask(2, new EntityAIWander(this, 0.3D));
        this.targetTasks.addTask(1, new AIHurtByTarget());
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.5D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3D);
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(CRAB_RAVE, Integer.valueOf(0));
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        if(snipTime == 0) {
            snipTime = 20;
        }
        Vec3d pos = this.getPositionVector();
        Vec3d targetPos = entityIn.getPositionVector();
        ((EntityLivingBase) entityIn).knockBack(entityIn, 0.1F, pos.x - targetPos.x, pos.z - targetPos.z);

        // Vanilla attack code for mobs

        float f = (float) this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();
        int i = 0;
        if (entityIn instanceof EntityLivingBase) {
            f += EnchantmentHelper.getModifierForCreature(this.getHeldItemMainhand(), ((EntityLivingBase) entityIn).getCreatureAttribute());
            i += EnchantmentHelper.getKnockbackModifier(this);
        }

        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), f);

        if (flag) {
            if (i > 0 && entityIn instanceof EntityLivingBase) {
                ((EntityLivingBase) entityIn).knockBack(this, i * 0.5F, MathHelper.sin(this.rotationYaw * 0.017453292F), (-MathHelper.cos(this.rotationYaw * 0.017453292F)));
                this.motionX *= 0.6D;
                this.motionZ *= 0.6D;
            }

            int j = EnchantmentHelper.getFireAspectModifier(this);

            if (j > 0) {
                entityIn.setFire(j * 4);
            }

            if (entityIn instanceof EntityPlayer) {
                EntityPlayer entityplayer = (EntityPlayer) entityIn;
                ItemStack itemstack = this.getHeldItemMainhand();
                ItemStack itemstack1 = entityplayer.isHandActive() ? entityplayer.getActiveItemStack() : ItemStack.EMPTY;

                if (!itemstack.isEmpty() && !itemstack1.isEmpty() && itemstack.getItem().canDisableShield(itemstack, itemstack1, entityplayer, this) && itemstack1.getItem().isShield(itemstack1, entityplayer)) {
                    float f1 = 0.25F + EnchantmentHelper.getEfficiencyModifier(this) * 0.05F;

                    if (this.rand.nextFloat() < f1) {
                        entityplayer.getCooldownTracker().setCooldown(itemstack1.getItem(), 100);
                        this.world.setEntityState(entityplayer, (byte) 30);
                    }
                }
            }

            this.applyEnchantments(this, entityIn);
        }

        return flag;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if(snipTime == 0 && Math.random() < 0.005) {
            snipTime = 20;
        } else if(snipTime > 0) {
            snipTime--;
        } else {
            snipTime = 0;
        }
    }
    
    public int getIsCrabRave() {
        return this.dataManager.get(CRAB_RAVE).intValue();
    }

    private void setCrabRave(int in) {
        this.dataManager.set(CRAB_RAVE, Integer.valueOf(in));
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    public boolean getCanSpawnHere() {
        return true;
    }

    public boolean isNotColliding() {
        return this.world.checkNoEntityCollision(this.getEntityBoundingBox(), this);
    }

    public int getTalkInterval() {
        return 120;
    }

    protected boolean canDespawn() {
        return this.getIsCrabRave() == 0 && !this.hasCustomName();
    }

    protected int getExperiencePoints(EntityPlayer player) {
        return 1 + this.world.rand.nextInt(3);
    }

    public boolean isPushedByWater() {
        return false;
    }

    @Override
    public int getVariantMax() {
        return 4;
    }

    public void crabRave() {
        this.setCrabRave(this.getRNG().nextInt(3) + 1);
        this.tasks.taskEntries.clear();
        this.targetTasks.taskEntries.clear();
        this.setAttackTarget(null);
        this.navigator.clearPath();
    }
    
    public void unCrabRave() {
        this.setCrabRave(0);
        this.initEntityAI();
    }

    @Override
    protected IVariantTypes getBaseChild() {
        return new EntityCrab(this.world);
    }

    @Override
    protected float getWaterSlowDown() {
        return 0F;
    }

    class AIHurtByTarget extends EntityAIHurtByTarget {
        public AIHurtByTarget() {
            super(EntityCrab.this, false);
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
        protected void setEntityAttackTarget(EntityCreature creatureIn, EntityLivingBase entityLivingBaseIn) {
            if (creatureIn instanceof EntityCrab && !creatureIn.isChild()) {
                super.setEntityAttackTarget(creatureIn, entityLivingBaseIn);
            }
        }
    }

    @Override
    protected ResourceLocation getLootTable() {
        return ModLootTables.CRAB;
    }

}
