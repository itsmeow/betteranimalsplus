package its_meow.betteranimalsplus.init;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.config.BetterAnimalsPlusConfig;
import its_meow.betteranimalsplus.common.entity.EntityBear;
import its_meow.betteranimalsplus.common.entity.EntityBearNeutral;
import its_meow.betteranimalsplus.common.entity.EntityBearNeutralKermode;
import its_meow.betteranimalsplus.common.entity.EntityCoyote;
import its_meow.betteranimalsplus.common.entity.EntityDeer;
import its_meow.betteranimalsplus.common.entity.EntityFeralWolf;
import its_meow.betteranimalsplus.common.entity.EntityFox;
import its_meow.betteranimalsplus.common.entity.EntityGoat;
import its_meow.betteranimalsplus.common.entity.EntityJellyfish;
import its_meow.betteranimalsplus.common.entity.EntityLammergeier;
import its_meow.betteranimalsplus.common.entity.EntityPheasant;
import its_meow.betteranimalsplus.common.entity.EntityReindeer;
import its_meow.betteranimalsplus.common.entity.EntityTarantula;
import its_meow.betteranimalsplus.common.entity.miniboss.hirschgeist.EntityHirschgeist;
import its_meow.betteranimalsplus.common.entity.projectile.EntityTarantulaHair;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.registries.IForgeRegistry;


public class MobRegistry {
	public static int modEntities;

	public static LinkedHashSet<EntityEntry> entrySet = new LinkedHashSet<EntityEntry>();

	private static final String LOCALIZE_PREFIX = Ref.MOD_ID + ".";

	public static void addEntitiesToSet(){
		if(BetterAnimalsPlusConfig.enableBrownBear)
			regCre(EntityBear.class, "BrownBear", 0x4F2900, 0x8E500E, BetterAnimalsPlusConfig.brownBearWeight, 1, 1, BiomeDictionary.getBiomes(Type.FOREST));
		if(BetterAnimalsPlusConfig.enableBlackBear)
			regCre(EntityBearNeutral.class, "BlackBear", 0x000000, 0x333333, BetterAnimalsPlusConfig.blackBearWeight, 1, 1, BiomeDictionary.getBiomes(Type.FOREST));
		if(BetterAnimalsPlusConfig.enableKermodeBear)
			regCre(EntityBearNeutralKermode.class, "KermodeBear", 0xe8e8e8, 0xf7dabe, BetterAnimalsPlusConfig.kermodeBearWeight, 1, 1, BiomeDictionary.getBiomes(Type.FOREST));
		if(BetterAnimalsPlusConfig.enableDeer)
			regCre(EntityDeer.class, "Deer", 0x8e510b, 0xc6863b, BetterAnimalsPlusConfig.deerWeight, 1, 4,  BiomeDictionary.getBiomes(Type.FOREST), BiomeDictionary.getBiomes(Type.MAGICAL));
		if(BetterAnimalsPlusConfig.enableLammergeier) {
			regCre(EntityLammergeier.class, "Lammergeier", 0xd8d8d8, 0xd82b11, BetterAnimalsPlusConfig.lammergeierWeight, 1, 2, BiomeDictionary.getBiomes(Type.HILLS), BiomeDictionary.getBiomes(Type.MOUNTAIN));
			EntitySpawnPlacementRegistry.setPlacementType(EntityLammergeier.class, SpawnPlacementType.IN_AIR);
		}
		if(BetterAnimalsPlusConfig.enableFeralWolf)
			regCre(EntityFeralWolf.class, "FeralWolf", 0xbababa, 0x232323, BetterAnimalsPlusConfig.feralWolfWeight, 1, 6, BiomeDictionary.getBiomes(Type.FOREST), BiomeDictionary.getBiomes(Type.MAGICAL), BiomeDictionary.getBiomes(Type.SPOOKY));
		if(BetterAnimalsPlusConfig.enableCoyote)
			regCre(EntityCoyote.class, "Coyote", 0x866a31, 0xb69762, BetterAnimalsPlusConfig.coyoteWeight, 1, 6, BiomeDictionary.getBiomes(Type.SANDY), BiomeDictionary.getBiomes(Type.PLAINS));
		if(BetterAnimalsPlusConfig.enableFox)
			regCre(EntityFox.class, "Fox", 0xe87422, 0x3f210c, BetterAnimalsPlusConfig.foxWeight, 1, 6, BiomeDictionary.getBiomes(Type.FOREST), BiomeDictionary.getBiomes(Type.MAGICAL));
		if(BetterAnimalsPlusConfig.enableTarantula)
			register(EntityTarantulaHair.class, "tarantulahair");
		if(BetterAnimalsPlusConfig.enableTarantula)
			regMob(EntityTarantula.class, "Tarantula", 0x1e1e1e, 0x8c0c0c, BetterAnimalsPlusConfig.tarantulaWeight, 1, 3, BiomeDictionary.getBiomes(Type.SANDY));
		if(BetterAnimalsPlusConfig.enableHirschgeist)
			regCre(EntityHirschgeist.class, "Hirschgeist", 0xfffff, 0x00000, BetterAnimalsPlusConfig.hirschgeistWeight, 1, 1, BiomeDictionary.getBiomes(Type.FOREST));
		if(BetterAnimalsPlusConfig.enableGoat)
			regCre(EntityGoat.class, "Goat", 0xffffff, 0xeeeeee, BetterAnimalsPlusConfig.goatWeight, 1, 4, BiomeDictionary.getBiomes(Type.HILLS), BiomeDictionary.getBiomes(Type.MOUNTAIN), BiomeDictionary.getBiomes(Type.SAVANNA), BiomeDictionary.getBiomes(Type.PLAINS), BiomeDictionary.getBiomes(Type.FOREST));
		if(BetterAnimalsPlusConfig.enableJellyfish)
			regWater(EntityJellyfish.class, "Jellyfish", 0x226fe2, 0xf2b3b3, BetterAnimalsPlusConfig.jellyFishWeight, 1, 1, BiomeDictionary.getBiomes(Type.OCEAN));
		if(BetterAnimalsPlusConfig.enablePheasant)
			regCre(EntityPheasant.class, "Pheasant", 0x8e6b0b, 0xd8af3c, BetterAnimalsPlusConfig.pheasantWeight, 1, 3, BiomeDictionary.getBiomes(Type.FOREST), BiomeDictionary.getBiomes(Type.PLAINS), BiomeDictionary.getBiomes(Type.SAVANNA));
		if(BetterAnimalsPlusConfig.enableReindeer)
			regCre(EntityReindeer.class, "Reindeer", 0x8e510b, 0x017700, BetterAnimalsPlusConfig.reindeerWeight, 1, 4, BiomeDictionary.getBiomes(Type.SNOWY));
	}


	//#################################################################################

	@SafeVarargs
	public static void regCre(Class<? extends Entity> EntityClass, String entityNameIn, int solidColorIn, int spotColorIn, int prob, int min, int max, Set<Biome>... biomes){
		if(BetterAnimalsPlusConfig.doSpawningFor(entityNameIn)) {
			registerWithSpawnAndEgg(EntityClass, entityNameIn, solidColorIn, spotColorIn, EnumCreatureType.CREATURE, prob, min, max, biomes);
		} else {
			registerWithEgg(EntityClass, entityNameIn, solidColorIn, spotColorIn);
		}
	}

	@SafeVarargs
	public static void regMob(Class<? extends Entity> EntityClass, String entityNameIn, int solidColorIn, int spotColorIn, int prob, int min, int max, Set<Biome>... biomes){
		if(BetterAnimalsPlusConfig.doSpawningFor(entityNameIn)) {
			registerWithSpawnAndEgg(EntityClass, entityNameIn, solidColorIn, spotColorIn, EnumCreatureType.MONSTER, prob, min, max, biomes);
		} else {
			registerWithEgg(EntityClass, entityNameIn, solidColorIn, spotColorIn);
		}
	}

	@SafeVarargs
	public static void regWater(Class<? extends Entity> EntityClass, String entityNameIn, int solidColorIn, int spotColorIn, int prob, int min, int max, Set<Biome>... biomes){
		if(BetterAnimalsPlusConfig.doSpawningFor(entityNameIn)) {
			registerWithSpawnAndEgg(EntityClass, entityNameIn, solidColorIn, spotColorIn, EnumCreatureType.WATER_CREATURE, prob, min, max, biomes);
		} else {
			registerWithEgg(EntityClass, entityNameIn, solidColorIn, spotColorIn);
		}
	}

	@SafeVarargs
	public static void registerWithSpawnAndEgg(Class<? extends Entity> EntityClass, String entityNameIn, int solidColorIn, int spotColorIn, EnumCreatureType typeIn, int prob, int min, int max, Set<Biome>... biomes){
		Set<Biome> biomesetAdd = new HashSet<>();
		for(Set<Biome> biomeset : biomes) {
			biomesetAdd.addAll(biomeset);
		}
		Biome[] biomesArray = {};
		try {
			biomesArray = biomesetAdd.toArray(biomesArray);
		} catch(NullPointerException e) {
			biomesArray = new Biome[0];
		}

		EntityEntry entry = EntityEntryBuilder.create()
				.entity(EntityClass)
				.id(new ResourceLocation(Ref.MOD_ID, entityNameIn), modEntities++)
				.name(LOCALIZE_PREFIX + entityNameIn)
				.tracker(64, 1, true)
				.egg(solidColorIn, spotColorIn)
				.spawn(typeIn, prob, min, max, biomesArray)
				.build();
		if(typeIn == EnumCreatureType.WATER_CREATURE) {
			EntitySpawnPlacementRegistry.setPlacementType(EntityClass, SpawnPlacementType.IN_WATER);
		}
		entrySet.add(entry);
	}

	public static void registerWithEgg(Class<? extends Entity> EntityClass, String entityNameIn, int solidColorIn, int spotColorIn){
		EntityEntry entry = EntityEntryBuilder.create()
				.entity(EntityClass)
				.id(new ResourceLocation(Ref.MOD_ID, entityNameIn), modEntities++)
				.name(LOCALIZE_PREFIX + entityNameIn)
				.tracker(64, 1, true)
				.egg(solidColorIn, spotColorIn)
				.build();
		entrySet.add(entry);
	}

	public static void register(Class<? extends Entity> EntityClass, String entityNameIn){
		EntityEntry entry = EntityEntryBuilder.create()
				.entity(EntityClass)
				.id(new ResourceLocation(Ref.MOD_ID, entityNameIn), modEntities++)
				.name(LOCALIZE_PREFIX + entityNameIn)
				.tracker(64, 1, true)
				.build();

		entrySet.add(entry);
	}



	//####################################################################################

	@EventBusSubscriber(modid = Ref.MOD_ID)
	public static class RegistrationHandler
	{
		/**
		 * Register this mod's {@link EntityEntry}s.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void onEvent(final RegistryEvent.Register<EntityEntry> event)
		{
			final IForgeRegistry<EntityEntry> registry = event.getRegistry();

			MobRegistry.addEntitiesToSet();
			if(!entrySet.isEmpty()) {
				for (final EntityEntry entityEntry : entrySet)
				{
					//System.out.println("Registering entity: " + entityEntry.getName() + "   " + entityEntry.getRegistryName());
					registry.register(entityEntry);
				}
			}
		}
	}


}
