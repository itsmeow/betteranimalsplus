package its_meow.betteranimalsplus.common.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class EntityBadgerDirt extends EntityThrowable {


    protected int stateId = -1;

    public EntityBadgerDirt(World worldIn) {
        super(worldIn);
    }

    public EntityBadgerDirt(World worldIn, EntityLivingBase throwerIn, int stateId) {
        super(worldIn);
        this.thrower = throwerIn;
        this.stateId = stateId;
    }



    @Override
    public void onUpdate() {
        super.onUpdate();
        if(stateId != -1 && !this.world.isRemote) {
            WorldServer worldS = (WorldServer) world;
            for(int i = 0; i < 100; i++) {
                worldS.spawnParticle(EnumParticleTypes.BLOCK_DUST, false, this.posX + Math.random(), this.posY + Math.random(), this.posZ + Math.random(), 1, 0D, 0D, 0D, 0D, stateId);
            }
        }
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if (result.entityHit != null) {
            int i = 2;
            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), i);
            if(Math.random() >= 0.5 && !this.world.isRemote) {
                if (result.entityHit instanceof EntityPlayer) {
                    EntityPlayer player = (EntityPlayer) result.entityHit;
                    int blindnessTicks = 0;
                    if (result.entityHit.getEntityWorld().getDifficulty() == EnumDifficulty.EASY) {
                        blindnessTicks = 10;
                    } else if (result.entityHit.getEntityWorld().getDifficulty() == EnumDifficulty.NORMAL) {
                        blindnessTicks = 20;
                    } else if (result.entityHit.getEntityWorld().getDifficulty() == EnumDifficulty.HARD) {
                        blindnessTicks = 35;
                    }
                    player.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("blindness"), blindnessTicks, 2, false, false));
                }
            }
        }

        if (!this.world.isRemote) {
            this.world.setEntityState(this, (byte) 3);
            this.setDead();
        }
    }

}
