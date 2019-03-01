package its_meow.betteranimalsplus.init;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Function;

import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.config.BetterAnimalsPlusConfig;
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
import its_meow.betteranimalsplus.common.entity.projectile.EntityTarantulaHair;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntitySpawnPlacementRegistry.SpawnPlacementType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.ItemSpawnEgg;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.IForgeRegistry;


public class MobRegistry {

	public static int modEntities = 0;

	public static LinkedHashMap<EntityContainer, EntityType<? extends Entity>> entryMap = new LinkedHashMap<>();
	public static LinkedHashSet<EntityContainer> entityList = new LinkedHashSet<>();
	public static LinkedHashSet<EntityType<? extends Entity>> entrySet = new LinkedHashSet<>();

	public static Set<ItemSpawnEgg> eggs = new HashSet<>();

	public static EntityType<? extends Entity> getType(Class<? extends Entity> clazz) {
		for(EntityContainer cont : MobRegistry.entityList) {
			if(cont.entityClazz == clazz) {
				return MobRegistry.entryMap.get(cont);
			}
		}
		return null;
	}

	// private static final String LOCALIZE_PREFIX = Ref.MOD_ID + ".";

	public static void fillContainers() {
		MobRegistry.entityList.add(new EntityContainer(EntityBear.class, EntityBear::new, "BrownBear",
				EnumCreatureType.CREATURE, 0x4F2900, 0x8E500E, BetterAnimalsPlusConfig.brownBearWeight, 1, 1,
				BiomeDictionary.getBiomes(Type.FOREST)));
		MobRegistry.entityList.add(new EntityContainer(EntityBearNeutral.class, EntityBearNeutral::new, "BlackBear",
				EnumCreatureType.CREATURE, 0x000000, 0x333333, BetterAnimalsPlusConfig.blackBearWeight, 1, 1,
				BiomeDictionary.getBiomes(Type.FOREST)));
		MobRegistry.entityList.add(new EntityContainer(EntityBearNeutralKermode.class, EntityBearNeutralKermode::new,
				"KermodeBear", EnumCreatureType.CREATURE, 0xe8e8e8, 0xf7dabe, BetterAnimalsPlusConfig.kermodeBearWeight,
				1, 1, BiomeDictionary.getBiomes(Type.FOREST)));
		MobRegistry.entityList.add(new EntityContainer(EntityDeer.class, EntityDeer::new, "Deer",
				EnumCreatureType.CREATURE, 0x8e510b, 0xc6863b, BetterAnimalsPlusConfig.deerWeight, 1, 4,
				BiomeDictionary.getBiomes(Type.FOREST), BiomeDictionary.getBiomes(Type.MAGICAL)));
		MobRegistry.entityList.add(new EntityContainer(EntityLammergeier.class, EntityLammergeier::new, "Lammergeier",
				EnumCreatureType.CREATURE, 0xd8d8d8, 0xd82b11, BetterAnimalsPlusConfig.lammergeierWeight, 1, 2,
				BiomeDictionary.getBiomes(Type.HILLS), BiomeDictionary.getBiomes(Type.MOUNTAIN)));
		MobRegistry.entityList.add(new EntityContainer(EntityFeralWolf.class, EntityFeralWolf::new, "FeralWolf",
				EnumCreatureType.CREATURE, 0xbababa, 0x232323, BetterAnimalsPlusConfig.feralWolfWeight, 1, 6,
				BiomeDictionary.getBiomes(Type.FOREST), BiomeDictionary.getBiomes(Type.MAGICAL),
				BiomeDictionary.getBiomes(Type.SPOOKY)));
		MobRegistry.entityList.add(new EntityContainer(EntityCoyote.class, EntityCoyote::new, "Coyote",
				EnumCreatureType.CREATURE, 0x866a31, 0xb69762, BetterAnimalsPlusConfig.coyoteWeight, 1, 6,
				BiomeDictionary.getBiomes(Type.SANDY), BiomeDictionary.getBiomes(Type.PLAINS)));
		MobRegistry.entityList.add(new EntityContainer(EntityFox.class, EntityFox::new, "Fox",
				EnumCreatureType.CREATURE, 0xe87422, 0x3f210c, BetterAnimalsPlusConfig.foxWeight, 1, 6,
				BiomeDictionary.getBiomes(Type.FOREST), BiomeDictionary.getBiomes(Type.MAGICAL)));
		MobRegistry.entityList.add(new EntityContainer(EntityTarantula.class, EntityTarantula::new, "Tarantula",
				EnumCreatureType.MONSTER, 0x1e1e1e, 0x8c0c0c, BetterAnimalsPlusConfig.tarantulaWeight, 1, 3,
				BiomeDictionary.getBiomes(Type.SANDY)));
		MobRegistry.entityList.add(new EntityContainer(EntityHirschgeist.class, EntityHirschgeist::new, "Hirschgeist",
				EnumCreatureType.CREATURE, 0xfffff, 0x00000, BetterAnimalsPlusConfig.hirschgeistWeight, 1, 1,
				BiomeDictionary.getBiomes(Type.FOREST)));
		MobRegistry.entityList
		.add(new EntityContainer(EntityGoat.class, EntityGoat::new, "Goat", EnumCreatureType.CREATURE, 0xffffff,
				0xeeeeee, BetterAnimalsPlusConfig.goatWeight, 1, 4, BiomeDictionary.getBiomes(Type.HILLS),
				BiomeDictionary.getBiomes(Type.MOUNTAIN), BiomeDictionary.getBiomes(Type.SAVANNA),
				BiomeDictionary.getBiomes(Type.PLAINS), BiomeDictionary.getBiomes(Type.FOREST)));
		MobRegistry.entityList.add(new EntityContainer(EntityJellyfish.class, EntityJellyfish::new, "Jellyfish",
				EnumCreatureType.WATER_CREATURE, 0x226fe2, 0xf2b3b3, BetterAnimalsPlusConfig.jellyFishWeight, 1, 1,
				BiomeDictionary.getBiomes(Type.OCEAN)));
		MobRegistry.entityList.add(new EntityContainer(EntityPheasant.class, EntityPheasant::new, "Pheasant",
				EnumCreatureType.CREATURE, 0x8e6b0b, 0xd8af3c, BetterAnimalsPlusConfig.pheasantWeight, 1, 3,
				BiomeDictionary.getBiomes(Type.FOREST), BiomeDictionary.getBiomes(Type.PLAINS),
				BiomeDictionary.getBiomes(Type.SAVANNA)));
		MobRegistry.entityList.add(new EntityContainer(EntityReindeer.class, EntityReindeer::new, "Reindeer",
				EnumCreatureType.CREATURE, 0x8e510b, 0x017700, BetterAnimalsPlusConfig.reindeerWeight, 1, 4,
				BiomeDictionary.getBiomes(Type.SNOWY)));
		MobRegistry.entityList.add(new EntityContainer(EntityBoar.class, EntityBoar::new, "Boar",
				EnumCreatureType.CREATURE, 0x3d3c3b, 0xbca895, BetterAnimalsPlusConfig.boarWeight, 1, 4,
				BiomeDictionary.getBiomes(Type.FOREST), BiomeDictionary.getBiomes(Type.JUNGLE),
				BiomeDictionary.getBiomes(Type.PLAINS), BiomeDictionary.getBiomes(Type.SAVANNA)));
		MobRegistry.entityList.add(new EntityContainer(EntitySquirrel.class, EntitySquirrel::new, "Squirrel",
				EnumCreatureType.CREATURE, 0x89806f, 0xb2a489, BetterAnimalsPlusConfig.squirrelWeight, 1, 3,
				BiomeDictionary.getBiomes(Type.FOREST)));
	}

	// #################################################################################

	public static void reg(EntityContainer c) {
		if(c.doSpawning) {
			MobRegistry.registerWithSpawn(c.entityClazz, c.entityFunction, c.entityName, c.type, c.weight, c.minGroup,
					c.maxGroup, c.spawnBiomes, c);
		} else {
			MobRegistry.register(c.entityClazz, c.entityFunction, c.entityName, c);
		}
	}

	@SuppressWarnings("unchecked")
	public static void registerWithSpawn(Class<? extends Entity> EntityClass,
			Function<? super World, ? extends Entity> func, String entityNameIn, EnumCreatureType typeIn, int prob,
			int min, int max, Biome[] biomes, EntityContainer container) {
		EntityType<? extends Entity> entry = EntityType.Builder.create(EntityClass, func).tracker(64, 1, true)
				.build(entityNameIn.toLowerCase()).setRegistryName(Ref.MOD_ID, entityNameIn.toLowerCase());
		if(typeIn == EnumCreatureType.WATER_CREATURE) {
			EntitySpawnPlacementRegistry.register(entry, SpawnPlacementType.IN_WATER, Heightmap.Type.OCEAN_FLOOR, null);
		}

		// Now the unchecked operation is checked
		if(EntityClass.isInstance(EntityLiving.class)) {
			for(Biome biome : biomes) {
				biome.getSpawns(typeIn).add(new SpawnListEntry((EntityType<? extends EntityLiving>) entry, prob, min, max));
			}
		}

		if(container != null) {
			MobRegistry.entryMap.put(container, entry);
		}
		MobRegistry.entrySet.add(entry);
	}

	public static void register(Class<? extends Entity> EntityClass, Function<? super World, ? extends Entity> func,
			String entityNameIn, EntityContainer container) {
		EntityType<? extends Entity> entry = EntityType.Builder.create(EntityClass, func).tracker(64, 1, true)
				.build(entityNameIn.toLowerCase()).setRegistryName(Ref.MOD_ID, entityNameIn.toLowerCase());

		if(container != null) {
			MobRegistry.entryMap.put(container, entry);
		}
		MobRegistry.entrySet.add(entry);
	}


	// ####################################################################################

	@EventBusSubscriber(modid = Ref.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
	public static class RegistrationHandler {

		@SubscribeEvent
		public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
			final IForgeRegistry<EntityType<?>> registry = event.getRegistry();

			for(EntityContainer container : MobRegistry.entityList) {
				if(container.doRegister) {
					MobRegistry.reg(container);
				}
			}
			// EntitySpawnPlacementRegistry.setPlacementType(EntityLammergeier.class,
			// SpawnPlacementType.IN_AIR);
			registry.register(EntityTarantulaHair.HAIR_TYPE);

			if(!MobRegistry.entrySet.isEmpty()) {
				for(final EntityType<? extends Entity> entityEntry : MobRegistry.entrySet) {
					// System.out.println("Registering entity: " +
					// entityEntry.getName() + " " +
					// entityEntry.getRegistryName());
					registry.register(entityEntry);
				}
			}
		}
	}


}
