package its_meow.betteranimalsplus.common.entity.projectile;

import its_meow.betteranimalsplus.Ref;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.network.IPacket;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntityTarantulaHair extends ThrowableEntity {

    public static EntityType<EntityTarantulaHair> HAIR_TYPE = EntityType.Builder.<EntityTarantulaHair>create((type, world) -> new EntityTarantulaHair(world), EntityClassification.MISC).setTrackingRange(64).setUpdateInterval(1).setShouldReceiveVelocityUpdates(true).size(0.5F, 0.5F).setCustomClientFactory((type, world) -> new EntityTarantulaHair(world)).build("tarantulahair");

    static {
        HAIR_TYPE.setRegistryName(Ref.MOD_ID, "tarantulahair");
    }

    public LivingEntity thrower;

    public EntityTarantulaHair(World worldIn) {
        super(EntityTarantulaHair.HAIR_TYPE, worldIn);
    }

    public EntityTarantulaHair(World worldIn, LivingEntity throwerIn) {
        super(EntityTarantulaHair.HAIR_TYPE, worldIn);
        this.thrower = throwerIn;
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    @Override
    protected void onImpact(RayTraceResult result) {
        if(result instanceof EntityRayTraceResult) {
            EntityRayTraceResult rayR = (EntityRayTraceResult) result;
            int i = 8;
            rayR.getEntity().attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), i);
            if(!this.world.isRemote) {
                if(rayR.getEntity() instanceof PlayerEntity) {
                    PlayerEntity player = (PlayerEntity) rayR.getEntity();
                    int blindnessTicks = 0;
                    if(player.getEntityWorld().getDifficulty() == Difficulty.EASY) {
                        blindnessTicks = 40;
                    } else if(player.getEntityWorld().getDifficulty() == Difficulty.NORMAL) {
                        blindnessTicks = 60;
                    } else if(player.getEntityWorld().getDifficulty() == Difficulty.HARD) {
                        blindnessTicks = 80;
                    }
                    player.addPotionEffect(new EffectInstance(Effects.BLINDNESS, blindnessTicks, 10, false, false));
                }
            }
        }

        if (!this.world.isRemote) {
            this.world.setEntityState(this, (byte) 3);
            this.remove();
        }
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected void registerData() {

    }

}
