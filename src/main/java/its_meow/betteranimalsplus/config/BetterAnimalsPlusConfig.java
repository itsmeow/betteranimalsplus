package its_meow.betteranimalsplus.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.tuple.Pair;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.util.EntityTypeContainer;
import its_meow.betteranimalsplus.util.EntityTypeContainerTameable;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Ref.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class BetterAnimalsPlusConfig {

    private static EntityConfig ENTITY_CONFIG = null;

    public static ForgeConfigSpec SERVER_CONFIG = null;

    public static void setupConfig() {
        final Pair<EntityConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(EntityConfig::new);
        SERVER_CONFIG = specPair.getRight();
        ENTITY_CONFIG = specPair.getLeft();
    }

    public static boolean coyotesHostileDaytime = false;
    public static boolean biomeBasedVariants = false;
    public static boolean goatVanillaMilk = false;

    @SubscribeEvent
    public static void onLoad(final ModConfig.Loading configEvent) {
        BetterAnimalsPlusMod.logger.debug("Loading {} {}", Ref.MOD_ID, configEvent.getConfig().getFileName());
        if(configEvent.getConfig().getSpec() == SERVER_CONFIG) {
            ENTITY_CONFIG.onWorldLoad();
        }
    }

    @SubscribeEvent
    public static void onLoad(final ModConfig.ConfigReloading configEvent) {
        BetterAnimalsPlusMod.logger.debug("Reloading {} {}", Ref.MOD_ID, configEvent.getConfig().getFileName());
        if(configEvent.getConfig().getSpec() == SERVER_CONFIG) {
            ENTITY_CONFIG.loadEntityData();
        }
    }

    public static class EntityConfig {
        public ForgeConfigSpec.Builder builder;
        private final ForgeConfigSpec.BooleanValue biomeBasedVariants;

        EntityConfig(ForgeConfigSpec.Builder builder) {
            this.builder = builder;
            for(EntityTypeContainer<?> cont : ModEntities.ENTITIES.values()) {
                cont.initConfiguration(builder);
            }
            builder.push("misc");
            this.biomeBasedVariants = builder.comment("Setting to true enables biome based variant spawning. This will make some entities choose variants based on the biome they spawn in. However, it will also affect eggs, possibly reducing the amount of visible content.").worldRestart().define("biomeBasedVariants", false);
            builder.pop();
            builder.build();
        }

        public void loadEntityData() {
            // Replace entity data

            for(EntityTypeContainer<?> container : ModEntities.ENTITIES.values()) {
                EntityTypeContainer<?>.EntityConfiguration section = container.getConfiguration();
                container.configurationLoad();

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

                container.setBiomes(biomesList.toArray(new Biome[0]));
            }
        }

        @SuppressWarnings("unchecked")
        public void onWorldLoad() {
            // Load misc
            BetterAnimalsPlusConfig.biomeBasedVariants = this.biomeBasedVariants.get();
            
            // Fill containers with proper values from their config sections
            this.loadEntityData();

            // Add spawns based on new container data
            if(!ModEntities.ENTITIES.values().isEmpty()) {
                for(EntityTypeContainer<?> entry : ModEntities.ENTITIES.values()) {
                    EntityType<?> type = entry.entityType;
                    if(entry.doSpawning) {
                        if(entry.spawnType == EntityClassification.WATER_CREATURE && EntitySpawnPlacementRegistry.getPlacementType((EntityType<? extends MobEntity>) type) == EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS) {
                            EntitySpawnPlacementRegistry.<MobEntity>register((EntityType<MobEntity>) type, EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, 
                            (etype, world, reason, pos, rand) -> {
                                return pos.getY() > 45 && pos.getY() < (world.getSeaLevel() - 1) && world.getBlockState(pos).getBlock() == Blocks.WATER;
                            });
                        }
                        for(Biome biome : entry.getBiomes()) {
                            biome.addSpawn(entry.spawnType, new SpawnListEntry((EntityType<? extends MobEntity>) type, entry.spawnWeight, entry.spawnMinGroup, entry.spawnMaxGroup));
                        }
                    }
                }
            }
        }
    }
    
    public static Map<String, String[]> getTameItemsMap() {
        Map<String, String[]> map = new HashMap<String, String[]>();
        for(EntityTypeContainer<?> cont : ModEntities.ENTITIES.values()) {
            if(cont instanceof EntityTypeContainerTameable) {
                EntityTypeContainerTameable<?> cont2 = (EntityTypeContainerTameable<?>) cont;
                map.put(cont2.entityName, cont2.getTameItems());
            }
        }
        return map;
    }

}
