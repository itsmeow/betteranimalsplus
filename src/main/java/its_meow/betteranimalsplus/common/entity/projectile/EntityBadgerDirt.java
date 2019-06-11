package its_meow.betteranimalsplus.common.entity.projectile;

import its_meow.betteranimalsplus.Ref;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Difficulty;
import net.minecraft.world.ServerWorld;
import net.minecraft.world.World;

public class EntityBadgerDirt extends ThrowableEntity {


    public static EntityType<EntityBadgerDirt> DIRT_TYPE = EntityType.Builder.<EntityBadgerDirt>create(EntityClassification.MISC).setTrackingRange(64).setUpdateInterval(1).setShouldReceiveVelocityUpdates(true).build("badgerdirt");
    static { 
        DIRT_TYPE.setRegistryName(Ref.MOD_ID, "badgerdirt"); 
    }
    
	protected int stateId = -1;
	
	public LivingEntity thrower;

    public EntityBadgerDirt(World worldIn) {
        super(DIRT_TYPE, worldIn);
        //this.setSize(1.2F, 1.2F);
    }

    public EntityBadgerDirt(World worldIn, LivingEntity throwerIn, int stateId) {
        super(DIRT_TYPE, worldIn);
        this.thrower = throwerIn;
        this.stateId = stateId;
        //this.setSize(1.2F, 1.2F);
    }

    @Override
    public void baseTick() {
        super.baseTick();
        if(stateId != -1 && !this.world.isRemote) {
            ServerWorld worldS = (ServerWorld) world;
            for(int i = 0; i < 100; i++) {
                worldS.<BlockParticleData>spawnParticle(new BlockParticleData(ParticleTypes.BLOCK, Block.getStateById(stateId)), this.posX + Math.random(), this.posY + Math.random(), this.posZ + Math.random(), 1, 0D, 0D, 0D, 0D);
            }
        }
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if (result.getType() == RayTraceResult.Type.ENTITY && result.hitInfo instanceof Entity) {
            int i = 2;
            ((Entity) result.hitInfo).attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), i);
            if(Math.random() >= 0.5 && !this.world.isRemote) {
                if (result.hitInfo instanceof PlayerEntity) {
                    PlayerEntity player = (PlayerEntity) result.hitInfo;
                    int blindnessTicks = 0;
                    if (player.getEntityWorld().getDifficulty() == Difficulty.EASY) {
                        blindnessTicks = 10;
                    } else if (player.getEntityWorld().getDifficulty() == Difficulty.NORMAL) {
                        blindnessTicks = 20;
                    } else if (player.getEntityWorld().getDifficulty() == Difficulty.HARD) {
                        blindnessTicks = 35;
                    }
                    player.addPotionEffect(new EffectInstance(Effects.BLINDNESS, blindnessTicks, 2, false, false));
                }
            }
        }

        if (!this.world.isRemote) {
            this.world.setEntityState(this, (byte) 3);
            this.remove();
        }
    }

    @Override
    protected void registerData() {
        
    }

}
