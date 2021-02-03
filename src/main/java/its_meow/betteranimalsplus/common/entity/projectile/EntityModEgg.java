package its_meow.betteranimalsplus.common.entity.projectile;

import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

public abstract class EntityModEgg extends ProjectileItemEntity {
    
    public EntityModEgg(EntityType<? extends EntityModEgg> type, World world) {
        super(type, world);
    }

    public EntityModEgg(EntityType<? extends EntityModEgg> type, World worldIn, LivingEntity throwerIn) {
        super(type, throwerIn, worldIn);
    }

    public EntityModEgg(EntityType<? extends EntityModEgg> type, World worldIn, double x, double y, double z) {
        super(type, x, y, z, worldIn);
    }
    
    public EntityModEgg(EntityType<? extends EntityModEgg> type, World worldIn, IPosition pos) {
        this(type, worldIn, pos.getX(), pos.getY(), pos.getZ());
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if(id == 3) {
            for(int i = 0; i < 8; ++i) {
                this.world.addParticle(new ItemParticleData(ParticleTypes.ITEM, this.getItem()), this.getPosX(), this.getPosY(), this.getPosZ(), ((double) this.rand.nextFloat() - 0.5D) * 0.08D, ((double) this.rand.nextFloat() - 0.5D) * 0.08D, ((double) this.rand.nextFloat() - 0.5D) * 0.08D);
            }
        }

    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if(result.getType() == RayTraceResult.Type.ENTITY) {
            ((EntityRayTraceResult) result).getEntity().attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0F);
        }

        if(!this.world.isRemote) {
            if(this.rand.nextInt(8) == 0) {
                int i = 1;
                if(this.rand.nextInt(32) == 0) {
                    i = 4;
                }

                for(int j = 0; j < i; ++j) {
                    this.world.addEntity(createEntity());
                }
            }

            this.world.setEntityState(this, (byte) 3);
            this.remove();
        }

    }
    
    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
    
    protected abstract Entity createEntity();

}
