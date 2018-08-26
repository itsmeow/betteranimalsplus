package its_meow.betteranimalsplus.proxy;

import its_meow.betteranimalsplus.registry.MobRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	

	public void preInit(FMLPreInitializationEvent event) {
		MobRegistry.init();
	}

	public void init(FMLInitializationEvent e) {
		
	}
	
	public void postInit(FMLPostInitializationEvent e) {

	}
	
	
}
