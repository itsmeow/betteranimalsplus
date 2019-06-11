package its_meow.betteranimalsplus.config;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.util.EntityContainer;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityConfig {

    private HashMap<EntityContainer<?>, EntityConfigurationSection> sections = new HashMap<EntityContainer<?>, EntityConfigurationSection>();
    private BooleanValue coyoteHostileDaytime;
    
    EntityConfig(ForgeConfigSpec.Builder builder) {
        for(EntityContainer<?> cont : ModEntities.entityList) {
            sections.put(cont, new EntityConfigurationSection(cont, builder));
        }
        builder.push("coyote");
        this.coyoteHostileDaytime = builder.comment("Makes coyote always hostile (removes ability to tame!)").worldRestart().define("coyoteHostileDaytime", false);
    }

    public void loadEntityData() {
        BetterAnimalsPlusConfig.coyotesHostileDaytime = this.coyoteHostileDaytime.get();
        // Replace entity data
        for (EntityContainer<?> container : this.sections.keySet()) {
            EntityConfigurationSection section = this.sections.get(container);
            container.maxGroup = section.max.get();
            container.minGroup = section.min.get();
            container.weight = section.weight.get();
            container.doSpawning = section.doSpawning.get();

            // Parse biomes
            List<Biome> biomesList = new ArrayList<Biome>();
            for (String biomeID : section.biomesList.get()) {
                Biome biome = ForgeRegistries.BIOMES.getValue(new ResourceLocation(biomeID));
                if (biome == null) { // Could not get biome with ID
                    BetterAnimalsPlusMod.logger.error("Invalid biome configuration entered for entity \""
                            + container.entityName + "\" (biome was mistyped or a biome mod was removed?): " + biomeID);
                } else { // Valid biome
                    biomesList.add(biome);
                }
            }
            // Get as array
            Biome[] biomes = new Biome[biomesList.size()];
            for (int i = 0; i < biomesList.size(); i++) {
                biomes[i] = biomesList.get(i);
            }

            container.spawnBiomes = biomes;
        }
    }

    @SuppressWarnings("unchecked")
    public void onWorldLoad() {

        // Fill containers with proper values from their config sections
        this.loadEntityData();

        // Add spawns based on new container data
        if (!ModEntities.entryMap.isEmpty()) {
            for(EntityContainer<?> entry : ModEntities.entryMapContainers.keySet()) {
                EntityType<?> type = ModEntities.entryMapContainers.get(entry);
                if (entry.doSpawning) {
                    if (entry.type == EntityClassification.WATER_CREATURE && EntitySpawnPlacementRegistry.getPlacementType((EntityType<? extends MobEntity>) type) == null) {
                        //TODO: reimplement once AT is back
                        //EntitySpawnPlacementRegistry.register(type, EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.OCEAN_FLOOR, null);
                    }
                    for (Biome biome : entry.spawnBiomes) {
                        Method addSpawn = ObfuscationReflectionHelper.findMethod(Biome.class, "func_201866_a",
                                EntityClassification.class, SpawnListEntry.class);
                        try {
                            addSpawn.invoke(biome, entry.type, new SpawnListEntry((EntityType<? extends MobEntity>) type, entry.weight, entry.minGroup, entry.maxGroup));
                        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
