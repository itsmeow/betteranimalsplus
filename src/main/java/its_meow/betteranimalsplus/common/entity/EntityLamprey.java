package its_meow.betteranimalsplus.common.entity;

import its_meow.betteranimalsplus.common.entity.ai.EntityAIMoveTowardsAttackTarget;
import its_meow.betteranimalsplus.init.ModEntities;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFindEntityNearest;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityLamprey extends EntityWaterMob implements IMob {

    private boolean resetPassengerState = true;
    private float passengerX = 0.0F;
    private float passengerZ = 0.0F;

    public EntityLamprey(World worldIn) {
        super(ModEntities.getEntityType(EntityLamprey.class), worldIn);
        this.setSize(0.4F, 0.4F);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAIMoveTowardsAttackTarget(this, 0.4D, true));
        this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityWaterMob.class, 10.0F));
        this.targetTasks.addTask(0, new EntityAIFindEntityNearest(this, EntityWaterMob.class));
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(3.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1D);
    }
    
    @Override
    public boolean attackEntityAsMob(Entity entityIn)
    {
        float f = (float)this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue();
        int i = 0;

        if (entityIn instanceof EntityLivingBase)
        {
            f += EnchantmentHelper.getModifierForCreature(this.getHeldItemMainhand(), ((EntityLivingBase)entityIn).getCreatureAttribute());
            i += EnchantmentHelper.getKnockbackModifier(this);
        }

        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), f);

        if (flag)
        {
            if (i > 0 && entityIn instanceof EntityLivingBase)
            {
                ((EntityLivingBase)entityIn).knockBack(this, (float)i * 0.5F, (double)MathHelper.sin(this.rotationYaw * 0.017453292F), (double)(-MathHelper.cos(this.rotationYaw * 0.017453292F)));
                this.motionX *= 0.6D;
                this.motionZ *= 0.6D;
            }

            int j = EnchantmentHelper.getFireAspectModifier(this);

            if (j > 0)
            {
                entityIn.setFire(j * 4);
            }

            if (entityIn instanceof EntityPlayer)
            {
                EntityPlayer entityplayer = (EntityPlayer)entityIn;
                ItemStack itemstack = this.getHeldItemMainhand();
                ItemStack itemstack1 = entityplayer.isHandActive() ? entityplayer.getActiveItemStack() : ItemStack.EMPTY;

                if (!itemstack.isEmpty() && !itemstack1.isEmpty() && itemstack.getItem().canDisableShield(itemstack, itemstack1, entityplayer, this) && itemstack1.getItem().isShield(itemstack1, entityplayer))
                {
                    float f1 = 0.25F + (float)EnchantmentHelper.getEfficiencyModifier(this) * 0.05F;

                    if (this.rand.nextFloat() < f1)
                    {
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
    public void livingTick() {
        super.livingTick();
        if(!this.world.isRemote && this.getAttackTarget() != null) {
            if(this.isRidingOrBeingRiddenBy(this.getAttackTarget())) {
               if(Math.random() >= 0.2F) {
                   this.attackEntityAsMob(this.getAttackTarget());
               }
            }
        }
    }

    @Override
    protected void collideWithEntity(Entity entity) {
        if(entity == this.getAttackTarget() && !this.isRidingOrBeingRiddenBy(entity)) {
            entity.startRiding(this);
            this.resetPassengerState = true;
        } else {
            super.collideWithEntity(entity);
        }
    }

    @Override
    public void updatePassenger(Entity passenger) {
        if(this.isPassenger(passenger)) {
            if(this.resetPassengerState) {
                this.resetPassengerState = false;
                this.setOffsetFor(passenger);
            }
            passenger.setPosition(passenger.posX + passengerX, passenger.posY, passenger.posZ + passengerZ);
        }
    }

    private void setOffsetFor(Entity passenger) {
        float modX = Math.random() >= 0.5 ? 1 : -1;
        float modZ = Math.random() >= 0.5 ? 1 : -1;
        this.passengerX = passenger.width * modX;
        this.passengerZ = passenger.width * modZ;
    }

}