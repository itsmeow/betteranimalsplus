package dev.itsmeow.betteranimalsplus.common.entity.projectile;

import dev.itsmeow.betteranimalsplus.init.ModEntities;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntityTarantulaHair extends ThrowableProjectile {

    public static EntityType<EntityTarantulaHair> HAIR_TYPE = ModEntities.H.createEntityType(EntityTarantulaHair::new, "tarantulahair", MobCategory.MISC, 64, 1, true, 0.5F, 0.5F);

    public LivingEntity thrower;

    public EntityTarantulaHair(Level worldIn) {
        super(EntityTarantulaHair.HAIR_TYPE, worldIn);
    }

    public EntityTarantulaHair(EntityType<? extends EntityTarantulaHair> entityType, Level worldIn) {
        super(entityType, worldIn);
    }

    public EntityTarantulaHair(Level worldIn, LivingEntity throwerIn) {
        super(EntityTarantulaHair.HAIR_TYPE, worldIn);
        this.thrower = throwerIn;
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    @Override
    protected void onHit(HitResult result) {
        if(result instanceof EntityHitResult) {
            EntityHitResult rayR = (EntityHitResult) result;
            int i = 8;
            rayR.getEntity().hurt(DamageSource.thrown(this, this.getOwner()), i);
            if(!this.level.isClientSide) {
                if(rayR.getEntity() instanceof Player) {
                    Player player = (Player) rayR.getEntity();
                    int blindnessTicks = 0;
                    if(player.getCommandSenderWorld().getDifficulty() == Difficulty.EASY) {
                        blindnessTicks = 40;
                    } else if(player.getCommandSenderWorld().getDifficulty() == Difficulty.NORMAL) {
                        blindnessTicks = 60;
                    } else if(player.getCommandSenderWorld().getDifficulty() == Difficulty.HARD) {
                        blindnessTicks = 80;
                    }
                    player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, blindnessTicks, 10, false, false));
                }
            }
        }

        if (!this.level.isClientSide) {
            this.level.broadcastEntityEvent(this, (byte) 3);
            this.remove();
        }
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected void defineSynchedData() {

    }

}
