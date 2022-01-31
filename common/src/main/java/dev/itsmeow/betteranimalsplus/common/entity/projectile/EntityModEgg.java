package dev.itsmeow.betteranimalsplus.common.entity.projectile;

import dev.architectury.networking.NetworkManager;
import dev.itsmeow.betteranimalsplus.api.ModEventBus;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.Position;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public abstract class EntityModEgg extends ThrowableItemProjectile {

    public EntityModEgg(EntityType<? extends EntityModEgg> type, Level world) {
        super(type, world);
    }

    public EntityModEgg(EntityType<? extends EntityModEgg> type, Level worldIn, LivingEntity throwerIn) {
        super(type, throwerIn, worldIn);
    }

    public EntityModEgg(EntityType<? extends EntityModEgg> type, Level worldIn, double x, double y, double z) {
        super(type, x, y, z, worldIn);
    }

    public EntityModEgg(EntityType<? extends EntityModEgg> type, Level worldIn, Position pos) {
        this(type, worldIn, pos.x(), pos.y(), pos.z());
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void handleEntityEvent(byte id) {
        if(id == 3) {
            for(int i = 0; i < 8; ++i) {
                this.level.addParticle(new ItemParticleOption(ParticleTypes.ITEM, this.getItem()), this.getX(), this.getY(), this.getZ(), ((double) this.random.nextFloat() - 0.5D) * 0.08D, ((double) this.random.nextFloat() - 0.5D) * 0.08D, ((double) this.random.nextFloat() - 0.5D) * 0.08D);
            }
        }
    }

    @Override
    protected void onHit(HitResult result) {
        if(result.getType() == HitResult.Type.ENTITY) {
            ((EntityHitResult) result).getEntity().hurt(DamageSource.thrown(this, this.getOwner()), 0.0F);
        }

        if(!this.level.isClientSide) {
            if(ModEventBus.ShouldEggSpawnEntitiesEvent.emit(this, this.random.nextInt(8) == 0)) {
                int i = 1;
                if(this.random.nextInt(32) == 0) {
                    i = 4;
                }
                i = ModEventBus.EggThrowSpawnCountEvent.emit(this, i);

                for(int j = 0; j < i; ++j) {
                    this.level.addFreshEntity(createEntity());
                }
            }

            this.level.broadcastEntityEvent(this, (byte) 3);
            this.discard();
        }

    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkManager.createAddEntityPacket(this);
    }

    protected abstract Entity createEntity();

}
