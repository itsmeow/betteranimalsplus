package its_meow.betteranimalsplus.common;

import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.entity.EntityBoar;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Ref.MOD_ID)
public class CommonEventHandler {

	@SubscribeEvent
	public static void onDeathOfEntity(LivingDeathEvent e) {
		if(e.getSource().getImmediateSource() instanceof EntityBoar) {
			EntityBoar boar = (EntityBoar) e.getSource().getImmediateSource();
			boar.setInLove(null);
			BlockPos p = boar.getPosition();
			boar.world.spawnParticle(EnumParticleTypes.HEART, p.getX(), p.getY(), p.getZ(), 0.0F, 0.05F, 0.0F);
		}
	}

}