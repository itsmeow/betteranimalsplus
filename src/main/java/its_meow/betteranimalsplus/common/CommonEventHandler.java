package its_meow.betteranimalsplus.common;

import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.entity.EntityBoar;
import net.minecraft.init.Particles;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Ref.MOD_ID)
public class CommonEventHandler {

    @SubscribeEvent
    public static void onDeathOfEntity(LivingDeathEvent e) {
        if (e.getSource().getImmediateSource() instanceof EntityBoar) {
            EntityBoar boar = (EntityBoar) e.getSource().getImmediateSource();
            boar.setInLove(null);
            BlockPos p = boar.getPosition();
            boar.world.addParticle(Particles.HEART, p.getX(), p.getY(), p.getZ(), 0.0F, 0.05F, 0.0F);
        }
    }

}