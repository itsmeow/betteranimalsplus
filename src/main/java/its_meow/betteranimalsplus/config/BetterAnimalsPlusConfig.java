package its_meow.betteranimalsplus.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.util.EntityConfigurationSection;
import its_meow.betteranimalsplus.util.EntityContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.config.Configuration;

public class BetterAnimalsPlusConfig {

    public static int bearWeight = 6;
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
    public static int nautilusWeight = 4;
    public static int crabWeight = 10;

    public static boolean spawnTrillium = true;
    public static boolean coyotesHostileDaytime = false;

    public static HashMap<EntityContainer, EntityConfigurationSection> sections = new HashMap<EntityContainer, EntityConfigurationSection>();

    public static void readConfig(boolean init){
        Configuration cfg = BetterAnimalsPlusMod.config;
        try {
            cfg.load();
            if(init) initLoadConfig(cfg); else worldLoadConfig(cfg);
        } catch (Exception e1) {
            BetterAnimalsPlusMod.logger.log(org.apache.logging.log4j.Level.ERROR, "Mod " + Ref.MOD_ID + " failed to load configuration. Report this here: http://github.com/itsmeow/betteranimalsplus/issues/new/choose", e1);
        } finally {
            if(cfg.hasChanged()){
                cfg.save();
            }
        }
    }

    public static void initLoadConfig(Configuration cfg) {
        spawnTrillium = cfg.getBoolean("generatetrillium", "generation", true, "Does not remove item, prevents world gen");
    }

    public static void worldLoadConfig(Configuration cfg) {
        coyotesHostileDaytime = cfg.getBoolean("coyotesHostileInDaytime", "its_meow.betteranimalsplus.common.entity.entitycoyote", false, "Enable to make coyotes always hostile (this also makes them untameable!");
        for(EntityContainer container : ModEntities.entityList) {
            container.populateBiomes();
            String[] biomeStrings = new String[container.spawnBiomes.length];
            for(int i = 0; i < container.spawnBiomes.length; i++) {
                biomeStrings[i] = container.spawnBiomes[i].getRegistryName().toString();
            }
            EntityConfigurationSection configSection = new EntityConfigurationSection(container.entityClazz, container.minGroup, container.maxGroup, container.weight, container.tameItems, biomeStrings);
            sections.put(container, configSection);
        }
        for(EntityContainer container : sections.keySet()) {
            EntityConfigurationSection section = sections.get(container);
            container.maxGroup = section.max;
            container.minGroup = section.min;
            container.weight = section.weight;
            container.doSpawning = section.doSpawning;

            // Parse biomes
            List<Biome> biomesList = new ArrayList<Biome>();
            for(String biomeID : section.biomesList) {
                Biome biome = Biome.REGISTRY.getObject(new ResourceLocation(biomeID));
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
        for(EntityContainer container : ModEntities.entityList) {
            if(container.doSpawning) {
                for(Biome biome : container.spawnBiomes) {
                    Biome.SpawnListEntry entry = new Biome.SpawnListEntry(container.entityClazz, container.weight, container.minGroup, container.maxGroup);
                    biome.getSpawnableList(container.type).add(entry);
                }
            }
        }
    }

    public static Map<String, String[]> getTameItemsMap() {
        Map<String, String[]> map = new HashMap<String, String[]>();
        for(EntityContainer cont : sections.keySet()) {
            EntityConfigurationSection section = sections.get(cont);
            map.put(cont.entityName, section.tameItems);
        }
        return map;
    }

}
