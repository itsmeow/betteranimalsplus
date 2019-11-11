package its_meow.betteranimalsplus.common.entity.projectile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class EntityModEgg extends EntityThrowable {
    
    public EntityModEgg(World worldIn) {
        super(worldIn);
    }

    public EntityModEgg(World worldIn, EntityLivingBase throwerIn) {
        super(worldIn, throwerIn);
    }

    public EntityModEgg(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }
    
    public abstract Item getEggItem();

    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id) {
        if(id == 3) {
            for(int i = 0; i < 8; ++i) {
                this.world.spawnParticle(EnumParticleTypes.ITEM_CRACK, this.posX, this.posY, this.posZ, ((double) this.rand.nextFloat() - 0.5D) * 0.08D, ((double) this.rand.nextFloat() - 0.5D) * 0.08D, ((double) this.rand.nextFloat() - 0.5D) * 0.08D, Item.getIdFromItem(getEggItem()));
            }
        }
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(RayTraceResult result) {
        if(result.entityHit != null) {
            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0F);
        }
        if(!this.world.isRemote) {
            if(this.rand.nextInt(8) == 0) {
                int i = 1;
                if(this.rand.nextInt(32) == 0) {
                    i = 4;
                }
                for(int j = 0; j < i; ++j) {
                    this.world.spawnEntity(createEntity());
                }
            }
            this.world.setEntityState(this, (byte) 3);
            this.setDead();
        }
    }
    
    protected abstract Entity createEntity();
    
}
