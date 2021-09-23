package dev.itsmeow.betteranimalsplus.common.entity.projectile;

import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModTriggers;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.network.IPacket;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntityBadgerDirt extends ThrowableEntity {


    public static final EntityType<EntityBadgerDirt> DIRT_TYPE = ModEntities.H.createEntityType(EntityBadgerDirt::new, "badgerdirt", EntityClassification.MISC, 64, 1, true, 1.2F, 1.2F);

    protected int stateId = -1;

    public LivingEntity thrower;

    public EntityBadgerDirt(World worldIn) {
        super(DIRT_TYPE, worldIn);
    }

    public EntityBadgerDirt(EntityType<? extends EntityBadgerDirt> entityType, World worldIn) {
        super(entityType, worldIn);
    }

    public EntityBadgerDirt(World worldIn, LivingEntity throwerIn, int stateId) {
        super(DIRT_TYPE, worldIn);
        this.thrower = throwerIn;
        this.stateId = stateId;
    }

    @Override
    public void baseTick() {
        super.baseTick();
        if(stateId != -1 && !this.level.isClientSide) {
            ServerWorld worldS = (ServerWorld) level;
            for(int i = 0; i < 100; i++) {
                worldS.sendParticles(new BlockParticleData(ParticleTypes.BLOCK, Block.stateById(stateId)), this.getX() + Math.random(), this.getY() + Math.random(), this.getZ() + Math.random(), 1, 0D, 0D, 0D, 0D);
            }
        }
    }

    @Override
    protected void onHit(RayTraceResult result) {
        if(result instanceof EntityRayTraceResult) {
            EntityRayTraceResult rayR = (EntityRayTraceResult) result;
            int i = 2;
            rayR.getEntity().hurt(DamageSource.thrown(this, this.getOwner()), i);
            if(Math.random() >= 0.5 && !this.level.isClientSide) {
                if(rayR.getEntity() instanceof PlayerEntity) {
                    PlayerEntity player = (PlayerEntity) rayR.getEntity();
                    int blindnessTicks = 0;
                    if(player.getCommandSenderWorld().getDifficulty() == Difficulty.EASY) {
                        blindnessTicks = 10;
                    } else if(player.getCommandSenderWorld().getDifficulty() == Difficulty.NORMAL) {
                        blindnessTicks = 20;
                    } else if(player.getCommandSenderWorld().getDifficulty() == Difficulty.HARD) {
                        blindnessTicks = 35;
                    }
                    player.addEffect(new EffectInstance(Effects.BLINDNESS, blindnessTicks, 2, false, false));
                }
            }

            if(rayR.getEntity() instanceof ServerPlayerEntity) {
                ModTriggers.BADGERDIRT_IMPACT.trigger((ServerPlayerEntity) rayR.getEntity());
            }
        }

        if (!this.level.isClientSide) {
            this.level.broadcastEntityEvent(this, (byte) 3);
            this.remove();
        }
    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected void defineSynchedData() {

    }

}
