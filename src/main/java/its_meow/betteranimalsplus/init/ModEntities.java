package its_meow.betteranimalsplus.init;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

import its_meow.betteranimalsplus.common.entity.EntityBadger;
import its_meow.betteranimalsplus.common.entity.EntityBear;
import its_meow.betteranimalsplus.common.entity.EntityBearNeutral;
import its_meow.betteranimalsplus.common.entity.EntityBoar;
import its_meow.betteranimalsplus.common.entity.EntityBobbitWorm;
import its_meow.betteranimalsplus.common.entity.EntityCoyote;
import its_meow.betteranimalsplus.common.entity.EntityCrab;
import its_meow.betteranimalsplus.common.entity.EntityDeer;
import its_meow.betteranimalsplus.common.entity.EntityFeralWolf;
import its_meow.betteranimalsplus.common.entity.EntityFox;
import its_meow.betteranimalsplus.common.entity.EntityGoat;
import its_meow.betteranimalsplus.common.entity.EntityGoose;
import its_meow.betteranimalsplus.common.entity.EntityHorseshoeCrab;
import its_meow.betteranimalsplus.common.entity.EntityJellyfish;
import its_meow.betteranimalsplus.common.entity.EntityLammergeier;
import its_meow.betteranimalsplus.common.entity.EntityLamprey;
import its_meow.betteranimalsplus.common.entity.EntityMoose;
import its_meow.betteranimalsplus.common.entity.EntityNautilus;
import its_meow.betteranimalsplus.common.entity.EntityPheasant;
import its_meow.betteranimalsplus.common.entity.EntityReindeer;
import its_meow.betteranimalsplus.common.entity.EntityShark;
import its_meow.betteranimalsplus.common.entity.EntitySongbird;
import its_meow.betteranimalsplus.common.entity.EntitySquirrel;
import its_meow.betteranimalsplus.common.entity.EntityTarantula;
import its_meow.betteranimalsplus.common.entity.EntityTurkey;
import its_meow.betteranimalsplus.common.entity.EntityZotzpyre;
import its_meow.betteranimalsplus.common.entity.miniboss.hirschgeist.EntityHirschgeist;
import its_meow.betteranimalsplus.config.BetterAnimalsPlusConfig;
import its_meow.betteranimalsplus.util.EntityContainer;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.common.registry.EntityEntry;

public class ModEntities {
    public static int modEntities = 0;

    public static LinkedHashSet<EntityEntry> entrySet = new LinkedHashSet<EntityEntry>();
    public static LinkedHashSet<EntityContainer> entityList = new LinkedHashSet<EntityContainer>();
    public static LinkedHashMap<String, EntityContainer> entityMap = new LinkedHashMap<String, EntityContainer>();

    static {
    	add(EntityBear.class, "brownbear", EnumCreatureType.CREATURE, 0x4F2900, 0x8E500E, BetterAnimalsPlusConfig.bearWeight, 1, 1, false, null, Type.FOREST);
    	add(EntityBearNeutral.class, "blackbear", EnumCreatureType.CREATURE, 0x000000, 0x333333, BetterAnimalsPlusConfig.blackBearWeight, 1, 1, false, null, Type.FOREST);
    	add(EntityDeer.class, "deer", EnumCreatureType.CREATURE, 0x8e510b, 0xc6863b, BetterAnimalsPlusConfig.deerWeight, 1, 4, false, null, Type.FOREST, Type.MAGICAL);
		add(EntityLammergeier.class, "lammergeier", EnumCreatureType.CREATURE, 0xd8d8d8, 0xd82b11, BetterAnimalsPlusConfig.lammergeierWeight, 1, 2, false, new String[] {"minecraft:bone"}, Type.HILLS, Type.MOUNTAIN);
		add(EntityFeralWolf.class, "feralwolf", EnumCreatureType.CREATURE, 0xbababa, 0x232323, BetterAnimalsPlusConfig.feralWolfWeight, 1, 6, false, new String[] {"minecraft:bone"}, Type.FOREST, Type.MAGICAL, Type.SPOOKY);
		add(EntityCoyote.class, "coyote", EnumCreatureType.CREATURE, 0x866a31, 0xb69762, BetterAnimalsPlusConfig.coyoteWeight, 1, 6, false, new String[] {"minecraft:rabbit", "minecraft:chicken", "betteranimalsplus:pheasantraw", "minecraft:cooked_rabbit", "minecraft:cooked_chicken", "betteranimalsplus:pheasantcooked"}, Type.SANDY, Type.PLAINS);
		add(EntityFox.class, "fox", EnumCreatureType.CREATURE, 0xe87422, 0x3f210c, BetterAnimalsPlusConfig.foxWeight, 1, 6, false, new String[] {"minecraft:rabbit", "minecraft:chicken", "betteranimalsplus:pheasantraw", "minecraft:cooked_rabbit", "minecraft:cooked_chicken", "betteranimalsplus:pheasantcooked"}, Type.FOREST, Type.MAGICAL);
		add(EntityTarantula.class, "tarantula", EnumCreatureType.MONSTER, 0x1e1e1e, 0x8c0c0c, BetterAnimalsPlusConfig.tarantulaWeight, 1, 3, true, null, Type.SANDY);
		add(EntityHirschgeist.class, "hirschgeist", EnumCreatureType.CREATURE, 0xfffff, 0x00000, BetterAnimalsPlusConfig.hirschgeistWeight, 1, 1, false, null, Type.FOREST);
		add(EntityGoat.class, "goat", EnumCreatureType.CREATURE, 0xffffff, 0xeeeeee, BetterAnimalsPlusConfig.goatWeight, 1, 4, false, null, Type.HILLS, Type.MOUNTAIN, Type.SAVANNA, Type.PLAINS, Type.FOREST);
		add(EntityJellyfish.class, "jellyfish", EnumCreatureType.WATER_CREATURE, 0x226fe2, 0xf2b3b3, BetterAnimalsPlusConfig.jellyFishWeight, 1, 1, true, null, Type.OCEAN);
		add(EntityPheasant.class, "pheasant", EnumCreatureType.CREATURE, 0x8e6b0b, 0xd8af3c, BetterAnimalsPlusConfig.pheasantWeight, 1, 3, false, null, Type.FOREST, Type.PLAINS, Type.SAVANNA);
		add(EntityReindeer.class, "reindeer", EnumCreatureType.CREATURE, 0x8e510b, 0x017700, BetterAnimalsPlusConfig.reindeerWeight, 1, 4, false, null, () -> BiomeDictionary.getBiomes(Type.SNOWY).stream().filter(biome -> !BiomeDictionary.getTypes(biome).contains(Type.OCEAN)).collect(Collectors.toList()).toArray(new Biome[0]));
		add(EntityBoar.class, "boar", EnumCreatureType.CREATURE, 0x3d3c3b, 0xbca895, BetterAnimalsPlusConfig.boarWeight, 1, 4, false, null, Type.FOREST, Type.JUNGLE, Type.PLAINS, Type.SAVANNA);
		add(EntitySquirrel.class, "squirrel", EnumCreatureType.CREATURE, 0x89806f, 0xb2a489, BetterAnimalsPlusConfig.squirrelWeight, 1, 3, false, null, Type.FOREST);
        add(EntitySongbird.class, "songbird", EnumCreatureType.CREATURE, 0x46f4d2, 0x7df442, BetterAnimalsPlusConfig.songbirdWeight, 1, 4, false, null, Type.FOREST, Type.PLAINS);
        add(EntityBadger.class, "badger", EnumCreatureType.CREATURE, 0x0c0c0c, 0xd3d3d3, BetterAnimalsPlusConfig.badgerWeight, 1, 2, false, null, Type.FOREST, Type.PLAINS, Type.SAVANNA);
        add(EntityLamprey.class, "lamprey", EnumCreatureType.WATER_CREATURE, 0x0000ad, 0x0a0a0a, BetterAnimalsPlusConfig.lampreyWeight, 1, 1, true, null, Type.RIVER, Type.SWAMP);
        add(EntityNautilus.class, "nautilus", EnumCreatureType.WATER_CREATURE, 0xff9659, 0x241682, BetterAnimalsPlusConfig.nautilusWeight, 1, 1, true, null, Type.OCEAN);
        add(EntityCrab.class, "crab", EnumCreatureType.CREATURE, 0xe21d16, 0x2d0504, BetterAnimalsPlusConfig.crabWeight, 1, 3, false, null, Type.BEACH, Type.SWAMP);
        add(EntityHorseshoeCrab.class, "horseshoecrab", EnumCreatureType.CREATURE, 0xba1111, 0x520807, BetterAnimalsPlusConfig.horseshoeCrabWeight, 1, 3, false, null, Type.BEACH);
        add(EntityShark.class, "shark", EnumCreatureType.WATER_CREATURE, 0x787878, 0xbdbdbd, BetterAnimalsPlusConfig.sharkWeight, 1, 1, true, null, Type.OCEAN);
        add(EntityMoose.class, "moose", EnumCreatureType.CREATURE, 0x46351c, 0x97866e, BetterAnimalsPlusConfig.mooseWeight, 1, 1, false, null, () -> {List<Biome> list = BiomeDictionary.getBiomes(Type.SWAMP).stream().collect(Collectors.toList());list.add(Biomes.REDWOOD_TAIGA); list.add(Biomes.REDWOOD_TAIGA_HILLS);list.add(Biomes.MUTATED_REDWOOD_TAIGA);list.add(Biomes.MUTATED_REDWOOD_TAIGA_HILLS);return list.toArray(new Biome[0]);});
        add(EntityTurkey.class, "turkey", EnumCreatureType.CREATURE, 0x857445, 0x5099ba, BetterAnimalsPlusConfig.turkeyWeight, 2, 5, false, null, () -> BiomeDictionary.getBiomes(Type.FOREST).stream().filter(biome -> !BiomeDictionary.getTypes(biome).contains(Type.SNOWY)).collect(Collectors.toList()).toArray(new Biome[0]));
        add(EntityZotzpyre.class, "zotzpyre", EnumCreatureType.MONSTER, 0x321e13, 0x543a28, 30, 1, 1, true, null, Type.FOREST, Type.JUNGLE, Type.BEACH, Type.CONIFEROUS, Type.LUSH, Type.WASTELAND, Type.SWAMP, Type.HILLS, Type.MOUNTAIN);
        add(EntityBobbitWorm.class, "bobbit_worm", EnumCreatureType.WATER_CREATURE, 0xffe38f, 0x0f27bf, 2, 1, 1, true, null, Type.OCEAN);
        add(EntityGoose.class, "goose", EnumCreatureType.CREATURE, 0xd3cfcf, 0x5e5752, 15, 2, 5, false, null, () -> {
            List<Type> blockedTypes = Lists.newArrayList(Type.DRY, Type.COLD, Type.HOT, Type.DENSE, Type.DEAD, Type.SPARSE, Type.OCEAN);
            List<Biome> biomes = BiomeDictionary.getBiomes(Type.FOREST).stream().filter(biome -> {
                for(Type type : BiomeDictionary.getTypes(biome)) {
                    if(blockedTypes.contains(type)) {
                        return false;
                    }
                }
                return true;
            }).collect(Collectors.toList());
            BiomeDictionary.getBiomes(Type.RIVER).forEach(biome -> biomes.add(biome));
            return biomes.toArray(new Biome[0]);
        });
    }
    
    /**
     * Use this to add new entities to be registered
     * @param EntityClass - The class of the entity
     * @param entityNameIn - The name of the entity. Should be lower case.
     * @param type - The type of the entity (EnumCreatureType). This is only used for spawning types. Typically use CREATURE.
     * @param solidColorIn - The solid color if the egg (back color) in integer format. You can specify in decimal or hexadecimal form. (0 or 0x000000)
     * @param spotColorIn - The spot color of the egg in integer format. See solid color for more.
     * @param prob - The random selection spawning weight used at spawn time. E.g. a spawn weight of 20 is 20x more likely to spawn than a weight of 1, and 2x more than 10.
     * @param min - The minimum amount of these that can spawn at once (in a group). Must be at least 1 and less than or equal to the maximum.
     * @param max - The maximum amount of these that can spawn at once (in a group). Must be at least 1 and greater to or equal to the minimum.
     * @param despawn - If the entity despawns by default
     * @param tameItems - List of items to tame this animal or null/empty array
     * @param types - A list of BiomeTypes this entity can spawn in.
     */
    public static void add(Class<? extends EntityLiving> EntityClass, String entityNameIn, EnumCreatureType type, int solidColorIn, int spotColorIn, int prob, int min, int max, boolean despawn, String[] tameItems, BiomeDictionary.Type... types) {
    	EntityContainer cont = new EntityContainer(EntityClass, entityNameIn, type, solidColorIn, spotColorIn, prob, min, max, despawn, tameItems, types);
        entityList.add(cont);
        entityMap.put(entityNameIn, cont);
    }
    
    /**
     * Use this to add new entities to be registered
     * @param EntityClass - The class of the entity
     * @param entityNameIn - The name of the entity. Should be lower case.
     * @param type - The type of the entity (EnumCreatureType). This is only used for spawning types. Typically use CREATURE.
     * @param solidColorIn - The solid color if the egg (back color) in integer format. You can specify in decimal or hexadecimal form. (0 or 0x000000)
     * @param spotColorIn - The spot color of the egg in integer format. See solid color for more.
     * @param prob - The random selection spawning weight used at spawn time. E.g. a spawn weight of 20 is 20x more likely to spawn than a weight of 1, and 2x more than 10.
     * @param min - The minimum amount of these that can spawn at once (in a group). Must be at least 1 and less than or equal to the maximum.
     * @param max - The maximum amount of these that can spawn at once (in a group). Must be at least 1 and greater to or equal to the minimum.
     * @param despawn - If the entity despawns by default
     * @param tameItems - List of items to tame this animal or null/empty array
     * @param biomeSupplier - A function providing a list of default spawn biomes.
     */
    public static void add(Class<? extends EntityLiving> EntityClass, String entityNameIn, EnumCreatureType type, int solidColorIn, int spotColorIn, int prob, int min, int max, boolean despawn, String[] tameItems, Supplier<Biome[]> biomeSupplier) {
        EntityContainer cont = new EntityContainer(EntityClass, entityNameIn, type, solidColorIn, spotColorIn, prob, min, max, despawn, tameItems, biomeSupplier);
        entityList.add(cont);
        entityMap.put(entityNameIn, cont);
    }

}
