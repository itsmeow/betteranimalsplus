package its_meow.betteranimalsplus.init;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.function.Function;

import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.entity.EntityBear;
import its_meow.betteranimalsplus.common.entity.EntityBearNeutral;
import its_meow.betteranimalsplus.common.entity.EntityBearNeutralKermode;
import its_meow.betteranimalsplus.common.entity.EntityBoar;
import its_meow.betteranimalsplus.common.entity.EntityCoyote;
import its_meow.betteranimalsplus.common.entity.EntityDeer;
import its_meow.betteranimalsplus.common.entity.EntityFeralWolf;
import its_meow.betteranimalsplus.common.entity.EntityFox;
import its_meow.betteranimalsplus.common.entity.EntityGoat;
import its_meow.betteranimalsplus.common.entity.EntityJellyfish;
import its_meow.betteranimalsplus.common.entity.EntityLammergeier;
import its_meow.betteranimalsplus.common.entity.EntityPheasant;
import its_meow.betteranimalsplus.common.entity.EntityReindeer;
import its_meow.betteranimalsplus.common.entity.EntitySquirrel;
import its_meow.betteranimalsplus.common.entity.EntityTarantula;
import its_meow.betteranimalsplus.common.entity.miniboss.hirschgeist.EntityHirschgeist;
import its_meow.betteranimalsplus.config.BetterAnimalsPlusConfig;
import its_meow.betteranimalsplus.util.EntityContainer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.World;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class ModEntities {
	
	public static LinkedHashMap<EntityContainer, EntityType<? extends Entity>> entryMap = new LinkedHashMap<>();
	public static LinkedHashSet<EntityContainer> entityList = new LinkedHashSet<>();
	public static LinkedHashSet<EntityType<? extends Entity>> entrySet = new LinkedHashSet<>();
	
	public static EntityType<? extends Entity> getEntityType(Class<? extends Entity> clazz) {
		for(EntityContainer cont : entityList) {
			if(cont.entityClazz == clazz) {
				return entryMap.get(cont);
			}
		}
		return null;
	}
	
	public static void fillContainers() {
		ModEntities.entityList.add(new EntityContainer(EntityBear.class, EntityBear::new, "brownbear",
				EnumCreatureType.CREATURE, 0x4F2900, 0x8E500E, BetterAnimalsPlusConfig.brownBearWeight, 1, 1,
				BiomeDictionary.getBiomes(Type.FOREST)));
		ModEntities.entityList.add(new EntityContainer(EntityBearNeutral.class, EntityBearNeutral::new, "blackbear",
				EnumCreatureType.CREATURE, 0x000000, 0x333333, BetterAnimalsPlusConfig.blackBearWeight, 1, 1,
				BiomeDictionary.getBiomes(Type.FOREST)));
		ModEntities.entityList.add(new EntityContainer(EntityBearNeutralKermode.class, EntityBearNeutralKermode::new,
				"kermodebear", EnumCreatureType.CREATURE, 0xe8e8e8, 0xf7dabe, BetterAnimalsPlusConfig.kermodeBearWeight,
				1, 1, BiomeDictionary.getBiomes(Type.FOREST)));
		ModEntities.entityList.add(new EntityContainer(EntityDeer.class, EntityDeer::new, "deer",
				EnumCreatureType.CREATURE, 0x8e510b, 0xc6863b, BetterAnimalsPlusConfig.deerWeight, 1, 4,
				BiomeDictionary.getBiomes(Type.FOREST), BiomeDictionary.getBiomes(Type.MAGICAL)));
		ModEntities.entityList.add(new EntityContainer(EntityLammergeier.class, EntityLammergeier::new, "lammergeier",
				EnumCreatureType.CREATURE, 0xd8d8d8, 0xd82b11, BetterAnimalsPlusConfig.lammergeierWeight, 1, 2,
				BiomeDictionary.getBiomes(Type.HILLS), BiomeDictionary.getBiomes(Type.MOUNTAIN)));
		ModEntities.entityList.add(new EntityContainer(EntityFeralWolf.class, EntityFeralWolf::new, "feralwolf",
				EnumCreatureType.CREATURE, 0xbababa, 0x232323, BetterAnimalsPlusConfig.feralWolfWeight, 1, 6,
				BiomeDictionary.getBiomes(Type.FOREST), BiomeDictionary.getBiomes(Type.MAGICAL),
				BiomeDictionary.getBiomes(Type.SPOOKY)));
		ModEntities.entityList.add(new EntityContainer(EntityCoyote.class, EntityCoyote::new, "coyote",
				EnumCreatureType.CREATURE, 0x866a31, 0xb69762, BetterAnimalsPlusConfig.coyoteWeight, 1, 6,
				BiomeDictionary.getBiomes(Type.SANDY), BiomeDictionary.getBiomes(Type.PLAINS)));
		ModEntities.entityList.add(new EntityContainer(EntityFox.class, EntityFox::new, "fox",
				EnumCreatureType.CREATURE, 0xe87422, 0x3f210c, BetterAnimalsPlusConfig.foxWeight, 1, 6,
				BiomeDictionary.getBiomes(Type.FOREST), BiomeDictionary.getBiomes(Type.MAGICAL)));
		ModEntities.entityList.add(new EntityContainer(EntityTarantula.class, EntityTarantula::new, "tarantula",
				EnumCreatureType.MONSTER, 0x1e1e1e, 0x8c0c0c, BetterAnimalsPlusConfig.tarantulaWeight, 1, 3,
				BiomeDictionary.getBiomes(Type.SANDY)));
		ModEntities.entityList.add(new EntityContainer(EntityHirschgeist.class, EntityHirschgeist::new, "hirschgeist",
				EnumCreatureType.CREATURE, 0xfffff, 0x00000, BetterAnimalsPlusConfig.hirschgeistWeight, 1, 1,
				BiomeDictionary.getBiomes(Type.FOREST)));
		ModEntities.entityList
		.add(new EntityContainer(EntityGoat.class, EntityGoat::new, "goat", EnumCreatureType.CREATURE, 0xffffff,
				0xeeeeee, BetterAnimalsPlusConfig.goatWeight, 1, 4, BiomeDictionary.getBiomes(Type.HILLS),
				BiomeDictionary.getBiomes(Type.MOUNTAIN), BiomeDictionary.getBiomes(Type.SAVANNA),
				BiomeDictionary.getBiomes(Type.PLAINS), BiomeDictionary.getBiomes(Type.FOREST)));
		ModEntities.entityList.add(new EntityContainer(EntityJellyfish.class, EntityJellyfish::new, "jellyfish",
				EnumCreatureType.WATER_CREATURE, 0x226fe2, 0xf2b3b3, BetterAnimalsPlusConfig.jellyFishWeight, 1, 1,
				BiomeDictionary.getBiomes(Type.OCEAN)));
		ModEntities.entityList.add(new EntityContainer(EntityPheasant.class, EntityPheasant::new, "pheasant",
				EnumCreatureType.CREATURE, 0x8e6b0b, 0xd8af3c, BetterAnimalsPlusConfig.pheasantWeight, 1, 3,
				BiomeDictionary.getBiomes(Type.FOREST), BiomeDictionary.getBiomes(Type.PLAINS),
				BiomeDictionary.getBiomes(Type.SAVANNA)));
		ModEntities.entityList.add(new EntityContainer(EntityReindeer.class, EntityReindeer::new, "reindeer",
				EnumCreatureType.CREATURE, 0x8e510b, 0x017700, BetterAnimalsPlusConfig.reindeerWeight, 1, 4,
				BiomeDictionary.getBiomes(Type.SNOWY)));
		ModEntities.entityList.add(new EntityContainer(EntityBoar.class, EntityBoar::new, "boar",
				EnumCreatureType.CREATURE, 0x3d3c3b, 0xbca895, BetterAnimalsPlusConfig.boarWeight, 1, 4,
				BiomeDictionary.getBiomes(Type.FOREST), BiomeDictionary.getBiomes(Type.JUNGLE),
				BiomeDictionary.getBiomes(Type.PLAINS), BiomeDictionary.getBiomes(Type.SAVANNA)));
		ModEntities.entityList.add(new EntityContainer(EntitySquirrel.class, EntitySquirrel::new, "squirrel",
				EnumCreatureType.CREATURE, 0x89806f, 0xb2a489, BetterAnimalsPlusConfig.squirrelWeight, 1, 3,
				BiomeDictionary.getBiomes(Type.FOREST)));
		
		for(EntityContainer container : ModEntities.entityList) {
			ModEntities.setupContainer(container);
		}
	}

	/*
	 * Helpers
	 */

	private static void setupContainer(EntityContainer c) {
		EntityType<? extends Entity> entry = ModEntities.createEntityType(c.entityClazz, c.entityFunction, c.entityName, c);
		
		if(c != null) {
			ModEntities.entryMap.put(c, entry);
		}
		ModEntities.entrySet.add(entry);
	}

	private static EntityType<? extends Entity> createEntityType(Class<? extends Entity> EntityClass, Function<? super World, ? extends Entity> func,
			String entityNameIn, EntityContainer container) {
		return EntityType.Builder.create(EntityClass, func).tracker(64, 1, true).build(entityNameIn).setRegistryName(Ref.MOD_ID + ":" + entityNameIn.toLowerCase());
	}
	
}
