package its_meow.betteranimalsplus.common.entity.projectile;

import its_meow.betteranimalsplus.Ref;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

public class EntityTarantulaHair extends ThrowableEntity {

    public static final EntityType<? extends Entity> HAIR_TYPE = EntityType.Builder
            .create(EntityTarantulaHair.class, EntityTarantulaHair::new).tracker(64, 1, true).build("tarantulahair")
            .setRegistryName(Ref.MOD_ID, "tarantulahair");

    public EntityTarantulaHair(World worldIn) {
        super(EntityTarantulaHair.HAIR_TYPE, worldIn);
    }

    public EntityTarantulaHair(World worldIn, LivingEntity throwerIn) {
        super(EntityTarantulaHair.HAIR_TYPE, worldIn);
        this.thrower = throwerIn;
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    @Override
    protected void onImpact(RayTraceResult result) {
        if (result.entity != null) {
            int i = 8;

            result.entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), i);
            if (result.entity instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) result.entity;
                int blindnessTicks = 0;
                if (result.entity.getEntityWorld().getDifficulty() == Difficulty.EASY) {
                    blindnessTicks = 40;
                } else if (result.entity.getEntityWorld().getDifficulty() == Difficulty.NORMAL) {
                    blindnessTicks = 60;
                } else if (result.entity.getEntityWorld().getDifficulty() == Difficulty.HARD) {
                    blindnessTicks = 80;
                }
                player.addPotionEffect(new EffectInstance(Effects.BLINDNESS, blindnessTicks, 10, false, false));
            }
        }

        if (!this.world.isRemote) {
            this.world.setEntityState(this, (byte) 3);
            this.remove();
        }
    }

}
