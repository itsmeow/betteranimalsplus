package its_meow.betteranimalsplus;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import its_meow.betteranimalsplus.common.world.gen.TrilliumGenerator;
import its_meow.betteranimalsplus.init.MobRegistry;
import its_meow.betteranimalsplus.proxy.ClientProxy;
import its_meow.betteranimalsplus.proxy.ISidedProxy;
import its_meow.betteranimalsplus.proxy.ServerProxy;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(value = Ref.MOD_ID)
public class BetterAnimalsPlusMod {
	
	
	public BetterAnimalsPlusMod() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        //FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        //FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server, registry and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        
		MobRegistry.fillContainers();
        logger.log(Level.INFO, "Injecting super coyotes...");
	}
	
	public static ISidedProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

	public static BetterAnimalsItemGroup group = new BetterAnimalsItemGroup("Better Animals+");

    private static final Logger logger = LogManager.getLogger();
	
	
    private void setup(final FMLCommonSetupEvent event) {
    	BiomeDictionary.getBiomes(BiomeDictionary.Type.SWAMP).forEach(biome -> biome.addFeature(net.minecraft.world.gen.GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createCompositeFeature(new TrilliumGenerator(), new NoFeatureConfig(), Biome.TOP_SOLID, new FrequencyConfig(3))));
		logger.log(Level.INFO, "Overspawning lammergeiers...");
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
		logger.log(Level.INFO, "Rendering squirrel physics...");
    }
}
