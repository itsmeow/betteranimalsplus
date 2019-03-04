package its_meow.betteranimalsplus.config;

import java.util.HashMap;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.init.EntityContainer;
import its_meow.betteranimalsplus.init.MobRegistry;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.Logging;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod.EventBusSubscriber
public class BetterAnimalsPlusConfig {

	private static final ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
	//private static final ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();

	public static final ForgeConfigSpec SERVER_CONFIG;
	//public static final ForgeConfigSpec CLIENT_CONFIG;

	public static HashMap<EntityContainer, EntityConfiguration> sections = new HashMap<EntityContainer, EntityConfiguration>();

	static { 
		for(EntityContainer cont : MobRegistry.entityList) {
			sections.put(cont, new EntityConfiguration(cont, SERVER_BUILDER));
		}

		SERVER_CONFIG = SERVER_BUILDER.build();
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
