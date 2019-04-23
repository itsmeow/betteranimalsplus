package its_meow.betteranimalsplus.config;

import org.apache.commons.lang3.tuple.Pair;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.Ref;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;

@Mod.EventBusSubscriber(modid = Ref.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class BetterAnimalsPlusConfig {

    private static EntityConfig ENTITY_CONFIG = null;

    public static ForgeConfigSpec SERVER_CONFIG = null;

    public static void setupConfig() {
        final Pair<EntityConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(EntityConfig::new);
        SERVER_CONFIG = specPair.getRight();
        ENTITY_CONFIG = specPair.getLeft();
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
    public static int songbirdWeight = 11;
    public static int badgerWeight = 7;
    public static int lampreyWeight = 7;

    public static boolean spawnTrillium = true;
    public static boolean coyotesHostileDaytime = false;

    @SubscribeEvent
    public static void onLoad(final ModConfig.Loading configEvent) {
        BetterAnimalsPlusMod.logger.debug("Loading {} {}", Ref.MOD_ID, configEvent.getConfig().getFileName());
        if (configEvent.getConfig().getSpec() == SERVER_CONFIG) {
            ENTITY_CONFIG.onWorldLoad();
        }
    }

}
