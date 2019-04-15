package its_meow.betteranimalsplus.common.entity.projectile;

import its_meow.betteranimalsplus.Ref;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.MobEffects;
import net.minecraft.init.Particles;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class EntityBadgerDirt extends EntityThrowable {


    public static final EntityType<?> DIRT_TYPE = EntityType.Builder.create(EntityBadgerDirt.class, EntityBadgerDirt::new).tracker(64, 1, true).build("badgerdirt").setRegistryName(Ref.MOD_ID, "badgerdirt");
    
	protected int stateId = -1;

    public EntityBadgerDirt(World worldIn) {
        super(DIRT_TYPE, worldIn);
        this.setSize(1.2F, 1.2F);
    }

    public EntityBadgerDirt(World worldIn, EntityLivingBase throwerIn, int stateId) {
        super(DIRT_TYPE, worldIn);
        this.thrower = throwerIn;
        this.stateId = stateId;
        this.setSize(1.2F, 1.2F);
    }

    @Override
    public void baseTick() {
        super.baseTick();
        if(stateId != -1 && !this.world.isRemote) {
            WorldServer worldS = (WorldServer) world;
            for(int i = 0; i < 100; i++) {
                worldS.<BlockParticleData>spawnParticle(new BlockParticleData(Particles.BLOCK, Block.getStateById(stateId)), this.posX + Math.random(), this.posY + Math.random(), this.posZ + Math.random(), 1, 0D, 0D, 0D, 0D);
            }
        }
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if (result.entity != null) {
            int i = 2;
            result.entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), i);
            if(Math.random() >= 0.5 && !this.world.isRemote) {
                if (result.entity instanceof EntityPlayer) {
                    EntityPlayer player = (EntityPlayer) result.entity;
                    int blindnessTicks = 0;
                    if (result.entity.getEntityWorld().getDifficulty() == EnumDifficulty.EASY) {
                        blindnessTicks = 10;
                    } else if (result.entity.getEntityWorld().getDifficulty() == EnumDifficulty.NORMAL) {
                        blindnessTicks = 20;
                    } else if (result.entity.getEntityWorld().getDifficulty() == EnumDifficulty.HARD) {
                        blindnessTicks = 35;
                    }
                    player.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, blindnessTicks, 2, false, false));
                }
            }
        }

        if (!this.world.isRemote) {
            this.world.setEntityState(this, (byte) 3);
            this.remove();
        }
    }

}
