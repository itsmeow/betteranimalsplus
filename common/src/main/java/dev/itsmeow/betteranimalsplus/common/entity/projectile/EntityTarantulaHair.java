package dev.itsmeow.betteranimalsplus.common.entity.projectile;

import dev.architectury.networking.NetworkManager;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class EntityTarantulaHair extends ThrowableProjectile {

    public LivingEntity thrower;

    public EntityTarantulaHair(EntityType<? extends EntityTarantulaHair> entityType, Level worldIn) {
        super(entityType, worldIn);
    }

    public EntityTarantulaHair(EntityType<? extends EntityTarantulaHair> entityType, Level worldIn, LivingEntity throwerIn) {
        super(entityType, worldIn);
        this.thrower = throwerIn;
    }

    @Override
    protected void onHit(HitResult result) {
        if(result instanceof EntityHitResult) {
            EntityHitResult rayR = (EntityHitResult) result;
            rayR.getEntity().hurt(DamageSource.thrown(this, this.getOwner()), 8);
            if(!this.level.isClientSide) {
                if(rayR.getEntity() instanceof Player) {
                    Player player = (Player) rayR.getEntity();
                    int blindnessTicks = 0;
                    switch (player.getCommandSenderWorld().getDifficulty()) {
                        case EASY:
                            blindnessTicks = 40;
                            break;
                        case NORMAL:
                            blindnessTicks = 60;
                            break;
                        case HARD:
                            blindnessTicks = 80;
                            break;
                    }
                    player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, blindnessTicks, 10, false, false));
                }
            }
        }

        if (!this.level.isClientSide) {
            this.level.broadcastEntityEvent(this, (byte) 3);
            this.discard();
        }
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkManager.createAddEntityPacket(this);
    }

    @Override
    protected void defineSynchedData() {

    }

}
