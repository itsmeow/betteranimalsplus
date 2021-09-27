package dev.itsmeow.betteranimalsplus.common.entity.projectile;

import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModTriggers;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class EntityBadgerDirt extends ThrowableProjectile {


    public static final EntityType<EntityBadgerDirt> DIRT_TYPE = ModEntities.H.createEntityType(EntityBadgerDirt::new, "badgerdirt", MobCategory.MISC, 64, 1, true, 1.2F, 1.2F);

    protected int stateId = -1;

    public LivingEntity thrower;

    public EntityBadgerDirt(Level worldIn) {
        super(DIRT_TYPE, worldIn);
    }

    public EntityBadgerDirt(EntityType<? extends EntityBadgerDirt> entityType, Level worldIn) {
        super(entityType, worldIn);
    }

    public EntityBadgerDirt(Level worldIn, LivingEntity throwerIn, int stateId) {
        super(DIRT_TYPE, worldIn);
        this.thrower = throwerIn;
        this.stateId = stateId;
    }

    @Override
    public void baseTick() {
        super.baseTick();
        if(stateId != -1 && !this.level.isClientSide) {
            ServerLevel worldS = (ServerLevel) level;
            for(int i = 0; i < 100; i++) {
                worldS.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, Block.stateById(stateId)), this.getX() + Math.random(), this.getY() + Math.random(), this.getZ() + Math.random(), 1, 0D, 0D, 0D, 0D);
            }
        }
    }

    @Override
    protected void onHit(HitResult result) {
        if(result instanceof EntityHitResult) {
            EntityHitResult rayR = (EntityHitResult) result;
            int i = 2;
            rayR.getEntity().hurt(DamageSource.thrown(this, this.getOwner()), i);
            if(Math.random() >= 0.5 && !this.level.isClientSide) {
                if(rayR.getEntity() instanceof Player) {
                    Player player = (Player) rayR.getEntity();
                    int blindnessTicks = 0;
                    if(player.getCommandSenderWorld().getDifficulty() == Difficulty.EASY) {
                        blindnessTicks = 10;
                    } else if(player.getCommandSenderWorld().getDifficulty() == Difficulty.NORMAL) {
                        blindnessTicks = 20;
                    } else if(player.getCommandSenderWorld().getDifficulty() == Difficulty.HARD) {
                        blindnessTicks = 35;
                    }
                    player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, blindnessTicks, 2, false, false));
                }
            }

            if(rayR.getEntity() instanceof ServerPlayer) {
                ModTriggers.BADGERDIRT_IMPACT.trigger((ServerPlayer) rayR.getEntity());
            }
        }

        if (!this.level.isClientSide) {
            this.level.broadcastEntityEvent(this, (byte) 3);
            this.remove();
        }
    }

    @Override
    protected void defineSynchedData() {

    }

}
