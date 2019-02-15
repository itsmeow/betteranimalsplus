package its_meow.betteranimalsplus;

import java.io.File;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.graph.ElementOrder.Type;

import its_meow.betteranimalsplus.common.config.BetterAnimalsPlusConfig;
import its_meow.betteranimalsplus.common.world.gen.TrilliumGenerator;
import its_meow.betteranimalsplus.init.BlockRegistry;
import its_meow.betteranimalsplus.init.CraftingRegistry;
import its_meow.betteranimalsplus.init.MobRegistry;
import its_meow.betteranimalsplus.proxy.ClientProxy;
import its_meow.betteranimalsplus.proxy.ISidedProxy;
import its_meow.betteranimalsplus.proxy.ServerProxy;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(value = Ref.MOD_ID)
public class BetterAnimalsPlusMod {
	
	
	public BetterAnimalsPlusMod() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server, registry and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        
        
		if(BetterAnimalsPlusConfig.spawnTrillium) {
			GameRegistry.registerWorldGenerator(new TrilliumGenerator(BlockRegistry.trillium), 1);
		}
		MobRegistry.fillContainers();
        logger.log(Level.INFO, "Injecting super coyotes...");
	}
	
	public static ISidedProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

	public static CreativeTab tab = new CreativeTab("Better Animals+");

    private static final Logger logger = LogManager.getLogger();
	
	
    private void setup(final FMLCommonSetupEvent event) {
    	BiomeDictionary.getBiomes(BiomeDictionary.Type.SWAMP).forEach(biome -> biome.addFeature(generationStage, Biome.createCompositeFeature(new TrilliumGenerator(BlockRegistry.trillium), defaultConfig, defaultPlacement, defaultPlacementConfig)));
		logger.log(Level.INFO, "Overspawning lammergeiers...");
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
		logger.log(Level.INFO, "Rendering squirrel physics...");
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {

    }

    private void processIMC(final InterModProcessEvent event) {

    }
}
