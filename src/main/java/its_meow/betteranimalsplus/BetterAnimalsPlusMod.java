package its_meow.betteranimalsplus;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import its_meow.betteranimalsplus.client.ClientLifecycleHandler;
import its_meow.betteranimalsplus.common.world.gen.TrilliumGenerator;
import its_meow.betteranimalsplus.init.ItemRegistry;
import its_meow.betteranimalsplus.init.LootTableRegistry;
import its_meow.betteranimalsplus.init.MobRegistry;
import its_meow.betteranimalsplus.proxy.ClientProxy;
import its_meow.betteranimalsplus.proxy.ISidedProxy;
import its_meow.betteranimalsplus.proxy.ServerProxy;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemSpawnEgg;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(value = Ref.MOD_ID)
public class BetterAnimalsPlusMod {

	public BetterAnimalsPlusMod() {

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().<FMLClientSetupEvent>addListener(e -> new ClientLifecycleHandler().clientSetup(e));

		MobRegistry.fillContainers();
		BetterAnimalsPlusMod.logger.log(Level.INFO, "Injecting super coyotes...");
	}

	public static ISidedProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(),
			() -> () -> new ServerProxy());

	public static ItemGroup group = new ItemGroup("Better Animals+") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ItemRegistry.antler);
		}

		@Override
		public void fill(NonNullList<ItemStack> toDisplay) {
			super.fill(toDisplay);
			for(ItemSpawnEgg egg : MobRegistry.eggs) {
				ItemStack stack = new ItemStack(egg);
				toDisplay.add(stack);
			}
		}
	};

	public static final Logger logger = LogManager.getLogger();


	private void setup(final FMLCommonSetupEvent event) {
		proxy.setup();
		BiomeDictionary.getBiomes(BiomeDictionary.Type.SWAMP).forEach(
				biome -> biome.addFeature(net.minecraft.world.gen.GenerationStage.Decoration.VEGETAL_DECORATION,
						Biome.createCompositeFeature(new TrilliumGenerator(), new NoFeatureConfig(), Biome.TOP_SOLID,
								new FrequencyConfig(3))));
		LootTableRegistry.register();
		BetterAnimalsPlusMod.logger.log(Level.INFO, "Overspawning lammergeiers...");
	}
}
