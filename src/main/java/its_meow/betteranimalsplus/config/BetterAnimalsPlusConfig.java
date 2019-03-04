package its_meow.betteranimalsplus.config;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.init.EntityContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.Logging;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber
public class BetterAnimalsPlusConfig {

	private static final EntityConfig ENTITYCONFIG;
	//private static final ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();

	public static final ForgeConfigSpec SERVER_CONFIG;
	//public static final ForgeConfigSpec CLIENT_CONFIG;

	static { 
		final Pair<EntityConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(EntityConfig::new);
        SERVER_CONFIG = specPair.getRight();
        ENTITYCONFIG = specPair.getLeft();
	}
	
	public static void loadEntityData() {
		// Replace entity data
		for(EntityContainer container : BetterAnimalsPlusConfig.ENTITYCONFIG.sections.keySet()) {
			EntityConfigurationSection section = BetterAnimalsPlusConfig.ENTITYCONFIG.sections.get(container);
			container.maxGroup = section.max.get();
			container.minGroup = section.min.get();
			container.weight = section.weight.get();
			container.doRegister = section.doRegister.get();
			container.doSpawning = section.doSpawning.get();

			// Parse biomes
			List<Biome> biomesList = new ArrayList<Biome>();
			for(String biomeID : section.biomesList.get()) {
				Biome biome = ForgeRegistries.BIOMES.getValue(new ResourceLocation(biomeID));
				if(biome == null) { // Could not get biome with ID
					BetterAnimalsPlusMod.logger.error("Invalid biome configuration entered for entity \"" + container.entityName + "\" (biome was mistyped or a biome mod was removed?): " + biomeID);
				} else { // Valid biome
					biomesList.add(biome);
				}
			}
			// Get as array
			Biome[] biomes = new Biome[biomesList.size()];
			for (int i = 0; i < biomesList.size(); i++)
			{
				biomes[i] = biomesList.get(i);
			}

			container.spawnBiomes = biomes;
		}
	}

	public static int brownBearWeight = 7;
	public static int blackBearWeight = 5;
	public static int kermodeBearWeight = 4;
	public static int deerWeight = 16;
	public static int lammergeierWeight = 7;
	public static int feralWolfWeight = 7;
	public static int coyoteWeight = 5;
	public static int foxWeight = 10;
	public static int tarantulaWeight = 13;
	public static int hirschgeistWeight = 2;
	public static int goatWeight = 9;
	public static int jellyFishWeight = 10;
	public static int pheasantWeight = 12;
	public static int reindeerWeight = 10;
	public static int boarWeight = 9;
	public static int squirrelWeight = 8;

	public static boolean spawnTrillium = true;

	@SubscribeEvent
	public static void onLoad(final ModConfig.Loading configEvent) {
		BetterAnimalsPlusMod.logger.debug("Loading {} {}", Ref.MOD_ID, configEvent.getConfig().getFileName());
	}

	@SubscribeEvent
	public static void onFileChange(final ModConfig.ConfigReloading configEvent) {
		BetterAnimalsPlusMod.logger.fatal(Logging.CORE, "{} changed while running!", Ref.MOD_ID);
	}

}
