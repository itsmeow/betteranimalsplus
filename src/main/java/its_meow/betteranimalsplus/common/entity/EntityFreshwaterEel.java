package its_meow.betteranimalsplus.common.entity;

import its_meow.betteranimalsplus.Ref;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Ref.MOD_ID)
public class EntityFreshwaterEel extends EntityEelBase {

    public EntityFreshwaterEel(World worldIn) {
        super(worldIn);
        this.setSize(1F, 1F);
    }

    @Override
    public int getVariantMax() {
        return 2;
    }

    @Override
    protected String getContainerName() {
        return "eel_freshwater";
    }

    @SubscribeEvent
    public static void onSpawn(LivingSpawnEvent event) {
        // patched on crappy fix for overspawning
        if(event.getEntity() instanceof EntityFreshwaterEel) {
            if(event.getWorld().getEntitiesWithinAABB(EntityFreshwaterEel.class, event.getEntity().getEntityBoundingBox().grow(20)).size() > 5) {
                event.setResult(Result.DENY);
            }
        }
    }

}
