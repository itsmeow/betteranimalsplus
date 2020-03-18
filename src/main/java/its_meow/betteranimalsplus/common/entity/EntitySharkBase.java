package its_meow.betteranimalsplus.common.entity;

import its_meow.betteranimalsplus.init.ModTriggers;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public abstract class EntitySharkBase extends EntityWaterMobPathingWithSelectiveTypes implements IMob {

    public EntitySharkBase(World world) {
        super(world);
    }

    @Override
    public void updatePassenger(Entity passenger) {
        if(this.isPassenger(passenger)) {
            BlockPos pos = this.getPosition().offset(this.getHorizontalFacing()).subtract(this.getPosition());
            pos = pos.add(pos.getX(), 0, pos.getZ());
            passenger.setPosition(this.posX + this.motionX + pos.getX(), this.posY - (this.height / 2) + this.motionY, this.posZ + this.motionZ + pos.getZ());
            //this.motionY += Math.abs(passenger.motionY);
            if(passenger instanceof EntityLivingBase && (this.getAttackTarget() == null || this.getAttackTarget() != passenger)) {
                this.setAttackTarget((EntityLivingBase) passenger);
            }
            if(this.world.isRemote) {
                this.applyOrientationToEntity(passenger);
            }
        }
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if(this.world.getDifficulty() == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }
    }

    public boolean getCanSpawnHere() {
        return this.world.getDifficulty() != EnumDifficulty.PEACEFUL && super.getCanSpawnHere();
    }

    @Override
    public boolean canRiderInteract() {
        return true;
    }

    @Override
    public boolean shouldRiderSit() {
        return false;
    }

    @Override
    public boolean shouldDismountInWater(Entity entity) {
        return false;
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        float f = (float) this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();
        int i = 0;

        if(entityIn instanceof EntityLivingBase) {
            f += EnchantmentHelper.getModifierForCreature(this.getHeldItemMainhand(), ((EntityLivingBase) entityIn).getCreatureAttribute());
            i += EnchantmentHelper.getKnockbackModifier(this);
        }

        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), f);

        if(flag) {
            if(i > 0 && entityIn instanceof EntityLivingBase) {
                ((EntityLivingBase) entityIn).knockBack(this, i * 0.5F, MathHelper.sin(this.rotationYaw * 0.017453292F), (-MathHelper.cos(this.rotationYaw * 0.017453292F)));
                this.motionX *= 0.6D;
                this.motionZ *= 0.6D;
            }

            int j = EnchantmentHelper.getFireAspectModifier(this);

            if(j > 0) {
                entityIn.setFire(j * 4);
            }

            if(entityIn instanceof EntityPlayer) {
                EntityPlayer entityplayer = (EntityPlayer) entityIn;
                ItemStack itemstack = this.getHeldItemMainhand();
                ItemStack itemstack1 = entityplayer.isHandActive() ? entityplayer.getActiveItemStack() : ItemStack.EMPTY;

                if(!itemstack.isEmpty() && !itemstack1.isEmpty() && itemstack.getItem().canDisableShield(itemstack, itemstack1, entityplayer, this) && itemstack1.getItem().isShield(itemstack1, entityplayer)) {
                    float f1 = 0.25F + EnchantmentHelper.getEfficiencyModifier(this) * 0.05F;

                    if(this.rand.nextFloat() < f1) {
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
    public void setAttackTarget(EntityLivingBase entitylivingbaseIn) {
        if(entitylivingbaseIn instanceof EntityPlayerMP) {
            ModTriggers.SHARK_TARGETED.trigger((EntityPlayerMP) entitylivingbaseIn);
        }
        super.setAttackTarget(entitylivingbaseIn);
    }

}
