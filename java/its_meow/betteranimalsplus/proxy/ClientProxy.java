package its_meow.betteranimalsplus.proxy;

import its_meow.betteranimalsplus.registry.MobRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event) {
		MobRegistry.initModels();
	}

	
}
