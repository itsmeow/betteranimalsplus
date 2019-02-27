package its_meow.betteranimalsplus.common.entity.projectile;

import its_meow.betteranimalsplus.Ref;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityTarantulaHair extends EntityThrowable {

	public static final EntityType<? extends Entity> HAIR_TYPE = EntityType.Builder
			.create(EntityTarantulaHair.class, EntityTarantulaHair::new).tracker(64, 1, true).build("tarantulahair")
			.setRegistryName(Ref.MOD_ID, "tarantulahair");

	public EntityTarantulaHair(World worldIn) {
		super(EntityTarantulaHair.HAIR_TYPE, worldIn);
	}

	public EntityTarantulaHair(World worldIn, EntityLivingBase throwerIn) {
		super(EntityTarantulaHair.HAIR_TYPE, worldIn);
		this.thrower = throwerIn;
	}

	/**
	 * Called when this EntityThrowable hits a block or entity.
	 */
	@Override
	protected void onImpact(RayTraceResult result) {
		if(result.entity != null) {
			int i = 8;

			result.entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), i);
			if(result.entity instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) result.entity;
				int blindnessTicks = 0;
				if(result.entity.getEntityWorld().getDifficulty() == EnumDifficulty.EASY) {
					blindnessTicks = 40;
				} else if(result.entity.getEntityWorld().getDifficulty() == EnumDifficulty.NORMAL) {
					blindnessTicks = 60;
				} else if(result.entity.getEntityWorld().getDifficulty() == EnumDifficulty.HARD) {
					blindnessTicks = 80;
				}
				player.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, blindnessTicks, 10, false, false));
			}
		}

		if(!this.world.isRemote) {
			this.world.setEntityState(this, (byte) 3);
			this.remove();
		}
	}

}
