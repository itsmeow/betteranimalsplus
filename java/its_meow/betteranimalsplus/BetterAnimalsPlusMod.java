package its_meow.betteranimalsplus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import its_meow.betteranimalsplus.proxy.CommonProxy;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Ref.MOD_ID, name = Ref.NAME, version = Ref.VERSION, acceptedMinecraftVersions = Ref.acceptedMCV, updateJSON = Ref.updateJSON)
public class BetterAnimalsPlusMod {

	@Instance(Ref.MOD_ID) 
	public static BetterAnimalsPlusMod mod;
	
	@SidedProxy(clientSide = Ref.CLIENT_PROXY_C, serverSide = Ref.SERVER_PROXY_C)
	public static CommonProxy proxy;

	//public static CreativeTab tab_betteranimalsplus = new CreativeTab("Better Animals+");

	public static Logger logger;
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println("Pre-Init");
		proxy.preInit(event);
		logger = LogManager.getLogger("betteranimalsplus");
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
		System.out.println("Init");
		proxy.init(e);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		System.out.println("Post-Init");
		proxy.postInit(e);
	}
}
