package its_meow.betteranimalsplus.common.config;

import java.nio.file.Path;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.Ref;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.Logging;
import net.minecraftforge.fml.config.ModConfig;

@Mod.EventBusSubscriber
public class BetterAnimalsPlusConfig {

	private static final ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
	//private static final ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();

	public static final ForgeConfigSpec SERVER_CONFIG;
	//public static final ForgeConfigSpec CLIENT_CONFIG;
	
	static {
        SERVER_CONFIG = SERVER_BUILDER.build();
        //CLIENT_CONFIG = CLIENT_BUILDER.build();
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
	
	
	public static void loadConfig(ForgeConfigSpec spec, Path path) {
        final CommentedFileConfig configData = CommentedFileConfig.builder(path)
                .sync()
                .autosave()
                .writingMode(WritingMode.REPLACE)
                .build();

        configData.load();
        spec.setConfig(configData);
    }

    @SubscribeEvent
    public static void onLoad(final ModConfig.Loading configEvent) {
        BetterAnimalsPlusMod.logger.debug("Loading {} {}", Ref.MOD_ID, configEvent.getConfig().getFileName());

    }

    @SubscribeEvent
    public static void onFileChange(final ModConfig.ConfigReloading configEvent) {
        BetterAnimalsPlusMod.logger.fatal(Logging.CORE, "{} changed incorrectly!", Ref.MOD_ID);
    }

	/*
	 * public static HashMap<EntityContainer, EntityConfigurationSection>
	 * sections = new HashMap<EntityContainer, EntityConfigurationSection>();
	 * public static void readConfig(){ Configuration cfg =
	 * BetterAnimalsPlusMod.config; try { cfg.load(); initConfig(cfg); } catch
	 * (Exception e1) {
	 * BetterAnimalsPlusMod.logger.log(org.apache.logging.log4j.Level.ERROR,
	 * "Mod " + Ref.MOD_ID +
	 * " failed to load configuration. Report this here: http://github.com/itsmeow/betteranimalsplus/issues/new/choose"
	 * , e1); } finally { if(cfg.hasChanged()){ cfg.save(); } } } public static
	 * void initConfig(Configuration cfg) { spawnTrillium =
	 * cfg.getBoolean("generatetrillium", "generation", true,
	 * "Does not remove item, prevents world gen"); for(EntityContainer
	 * container : MobRegistry.entityList) { String[] biomeStrings = new
	 * String[container.spawnBiomes.length]; for(int i = 0; i <
	 * container.spawnBiomes.length; i++) { biomeStrings[i] =
	 * container.spawnBiomes[i].getRegistryName().toString(); }
	 * EntityConfigurationSection configSection = new
	 * EntityConfigurationSection(container.entityClazz, container.minGroup,
	 * container.maxGroup, container.weight, biomeStrings);
	 * sections.put(container, configSection); } for(EntityContainer container :
	 * sections.keySet()) { EntityConfigurationSection section =
	 * sections.get(container); container.maxGroup = section.max;
	 * container.minGroup = section.min; container.weight = section.weight;
	 * container.doRegister = section.doRegister; container.doSpawning =
	 * section.doSpawning; // Parse biomes List<Biome> biomesList = new
	 * ArrayList<Biome>(); for(String biomeID : section.biomesList) { Biome
	 * biome = Biome.REGISTRY.getObject(new ResourceLocation(biomeID)); if(biome
	 * == null) { // Could not get biome with ID BetterAnimalsPlusMod.logger.
	 * error("Invalid biome configuration entered for entity \"" +
	 * container.entityName +
	 * "\" (biome was mistyped or a biome mod was removed?): " + biomeID); }
	 * else { // Valid biome biomesList.add(biome); } } // Get as array Biome[]
	 * biomes = new Biome[biomesList.size()]; for (int i = 0; i <
	 * biomesList.size(); i++) { biomes[i] = biomesList.get(i); }
	 * container.spawnBiomes = biomes; } }
	 */

}
