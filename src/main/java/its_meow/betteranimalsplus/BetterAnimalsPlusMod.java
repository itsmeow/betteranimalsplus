package its_meow.betteranimalsplus;

import java.io.File;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import its_meow.betteranimalsplus.common.config.BetterAnimalsPlusConfig;
import its_meow.betteranimalsplus.common.world.gen.TrilliumGenerator;
import its_meow.betteranimalsplus.init.BlockRegistry;
import its_meow.betteranimalsplus.init.CraftingRegistry;
import its_meow.betteranimalsplus.init.MobRegistry;
import its_meow.betteranimalsplus.proxy.ISidedProxy;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Ref.MOD_ID, name = Ref.NAME, version = Ref.VERSION, acceptedMinecraftVersions = Ref.acceptedMCV, updateJSON = Ref.updateJSON)
public class BetterAnimalsPlusMod {

	@Instance(Ref.MOD_ID) 
	public static BetterAnimalsPlusMod mod;
	
	@SidedProxy(clientSide = Ref.CLIENT_PROXY_C, serverSide = Ref.SERVER_PROXY_C)
	public static ISidedProxy proxy;

	public static CreativeTab tab = new CreativeTab("Better Animals+");

	public static Logger logger;
	
	public static Configuration config;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = LogManager.getLogger("betteranimalsplus");
		proxy.preInit(event);
		MobRegistry.fillContainers();
		File directory = event.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "betteranimalsplus.cfg")); 
        BetterAnimalsPlusConfig.readConfig();
        BetterAnimalsPlusConfig.initConfig(config);
        logger.log(Level.INFO, "Injecting super coyotes...");
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.init(e);
		CraftingRegistry.register(); 
		if(BetterAnimalsPlusConfig.spawnTrillium) {
			GameRegistry.registerWorldGenerator(new TrilliumGenerator(BlockRegistry.trillium), 1);
		}
		logger.log(Level.INFO, "Overspawning lammergeiers...");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		proxy.postInit(e);
		if(config.hasChanged()){
			config.save();
		}
		logger.log(Level.INFO, "IT'S A HIRSCHGEIST! RUN!!!!");
	}
}
