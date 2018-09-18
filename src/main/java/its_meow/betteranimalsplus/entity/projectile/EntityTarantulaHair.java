package its_meow.betteranimalsplus.entity.projectile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityTarantulaHair extends EntityThrowable {
	
	public EntityTarantulaHair(World worldIn) {
		super(worldIn);
	}
	
	public EntityTarantulaHair(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn);
		this.thrower = throwerIn;
	}

	/**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(RayTraceResult result)
    {
        if (result.entityHit != null)
        {
            int i = 8;

            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)i);
            if(result.entityHit instanceof EntityPlayer) {
            	EntityPlayer player = (EntityPlayer) result.entityHit;
            	int blindnessTicks = 0;
            	if(result.entityHit.getEntityWorld().getDifficulty() == EnumDifficulty.EASY) {
            		blindnessTicks = 40;
            	} else if(result.entityHit.getEntityWorld().getDifficulty() == EnumDifficulty.NORMAL) {
            		blindnessTicks = 60;
            	} else if(result.entityHit.getEntityWorld().getDifficulty() == EnumDifficulty.HARD) {
            		blindnessTicks = 80;
            	}
            	player.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("blindness"), blindnessTicks, 10, false, false));
            }
        }

        if (!this.world.isRemote)
        {
            this.world.setEntityState(this, (byte)3);
            this.setDead();
        }
    }

}
