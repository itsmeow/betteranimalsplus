package its_meow.betteranimalsplus.common.entity.projectile;

import its_meow.betteranimalsplus.common.entity.EntityPheasant;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModItems;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
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

public class EntityPheasantEgg extends ProjectileItemEntity {
    public static EntityType<EntityPheasantEgg> PHEASANT_EGG_TYPE = ModEntities.<EntityPheasantEgg>createEntityType(EntityPheasantEgg.class, EntityPheasantEgg::new, "pheasant_egg", EntityClassification.MISC, 64, 1, true, 0.25F, 0.25F);
    
    public EntityPheasantEgg(World p_i50154_2_) {
        super(PHEASANT_EGG_TYPE, p_i50154_2_);
    }
    
    public EntityPheasantEgg(EntityType<? extends EntityPheasantEgg> p_i50154_1_, World p_i50154_2_) {
        super(p_i50154_1_, p_i50154_2_);
    }

    public EntityPheasantEgg(World worldIn, LivingEntity throwerIn) {
        super(PHEASANT_EGG_TYPE, throwerIn, worldIn);
    }

    public EntityPheasantEgg(World worldIn, double x, double y, double z) {
        super(PHEASANT_EGG_TYPE, x, y, z, worldIn);
    }

    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if(id == 3) {
            for(int i = 0; i < 8; ++i) {
                this.world.addParticle(new ItemParticleData(ParticleTypes.ITEM, this.getItem()), this.posX, this.posY, this.posZ, ((double) this.rand.nextFloat() - 0.5D) * 0.08D, ((double) this.rand.nextFloat() - 0.5D) * 0.08D, ((double) this.rand.nextFloat() - 0.5D) * 0.08D);
            }
        }

    }

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
                    EntityPheasant pheasant = ModEntities.PHEASANT.entityType.create(this.world);
                    pheasant.setGrowingAge(-24000);
                    pheasant.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
                    pheasant.setType(pheasant.getRandomType());
                    this.world.addEntity(pheasant);
                }
            }

            this.world.setEntityState(this, (byte) 3);
            this.remove();
        }

    }

    protected Item func_213885_i() {
        return ModItems.PHEASANT_EGG;
    }
    
    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

}
