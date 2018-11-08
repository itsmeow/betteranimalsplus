package its_meow.betteranimalsplus.init;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.client.renderer.entity.RenderBlackBear;
import its_meow.betteranimalsplus.client.renderer.entity.RenderBrownBear;
import its_meow.betteranimalsplus.client.renderer.entity.RenderCoyote;
import its_meow.betteranimalsplus.client.renderer.entity.RenderCustomWolf;
import its_meow.betteranimalsplus.client.renderer.entity.RenderDeer;
import its_meow.betteranimalsplus.client.renderer.entity.RenderFox;
import its_meow.betteranimalsplus.client.renderer.entity.RenderHirschgeist;
import its_meow.betteranimalsplus.client.renderer.entity.RenderKermodeBear;
import its_meow.betteranimalsplus.client.renderer.entity.RenderLammergeier;
import its_meow.betteranimalsplus.client.renderer.entity.RenderTarantula;
import its_meow.betteranimalsplus.client.renderer.entity.RenderTarantulaHair;
import its_meow.betteranimalsplus.common.entity.EntityBear;
import its_meow.betteranimalsplus.common.entity.EntityBearNeutral;
import its_meow.betteranimalsplus.common.entity.EntityBearNeutralKermode;
import its_meow.betteranimalsplus.common.entity.EntityCoyote;
import its_meow.betteranimalsplus.common.entity.EntityDeer;
import its_meow.betteranimalsplus.common.entity.EntityFeralWolf;
import its_meow.betteranimalsplus.common.entity.EntityFox;
import its_meow.betteranimalsplus.common.entity.EntityGoat;
import its_meow.betteranimalsplus.common.entity.EntityLammergeier;
import its_meow.betteranimalsplus.common.entity.EntityTarantula;
import its_meow.betteranimalsplus.common.entity.miniboss.hirschgeist.EntityHirschgeist;
import its_meow.betteranimalsplus.common.entity.projectile.EntityTarantulaHair;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeForest;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import its_meow.betteranimalsplus.common.config.BetterAnimalsPlusConfig;


public class MobRegistry {
	public static int modEntities;

	public static LinkedHashSet<EntityEntry> entrySet = new LinkedHashSet<EntityEntry>();

	public static void addEntitiesToSet(){
		if(BetterAnimalsPlusConfig.spawnBrownBear)
			regCre(EntityBear.class, "BrownBear", 0x4F2900, 0x8E500E, BetterAnimalsPlusConfig.brownBearWeight, 1, 1, BiomeDictionary.getBiomes(Type.FOREST));
		if(BetterAnimalsPlusConfig.spawnBlackBear)
			regCre(EntityBearNeutral.class, "BlackBear", 0x000000, 0x333333, BetterAnimalsPlusConfig.blackBearWeight, 1, 1, BiomeDictionary.getBiomes(Type.FOREST));
		if(BetterAnimalsPlusConfig.spawnKermodeBear)
			regCre(EntityBearNeutralKermode.class, "KermodeBear", 0xe8e8e8, 0xf7dabe, BetterAnimalsPlusConfig.kermodeBearWeight, 1, 1, BiomeDictionary.getBiomes(Type.FOREST));
		if(BetterAnimalsPlusConfig.spawnDeer)
			regCre(EntityDeer.class, "Deer", 0x8e510b, 0xc6863b, BetterAnimalsPlusConfig.deerWeight, 1, 4,  BiomeDictionary.getBiomes(Type.FOREST), BiomeDictionary.getBiomes(Type.MAGICAL));
		if(BetterAnimalsPlusConfig.spawnLammergeier)
			regCre(EntityLammergeier.class, "Lammergeier", 0xd8d8d8, 0xd82b11, BetterAnimalsPlusConfig.lammergeierWeight, 1, 2, BiomeDictionary.getBiomes(Type.HILLS), BiomeDictionary.getBiomes(Type.MOUNTAIN));
		if(BetterAnimalsPlusConfig.spawnFeralWolf)
			regCre(EntityFeralWolf.class, "FeralWolf", 0xbababa, 0x232323, BetterAnimalsPlusConfig.feralWolfWeight, 1, 6, BiomeDictionary.getBiomes(Type.FOREST), BiomeDictionary.getBiomes(Type.MAGICAL), BiomeDictionary.getBiomes(Type.SPOOKY));
		if(BetterAnimalsPlusConfig.spawnCoyote)
			regCre(EntityCoyote.class, "Coyote", 0x866a31, 0xb69762, BetterAnimalsPlusConfig.coyoteWeight, 1, 6, BiomeDictionary.getBiomes(Type.SANDY), BiomeDictionary.getBiomes(Type.PLAINS));
		if(BetterAnimalsPlusConfig.spawnFox)
			regCre(EntityFox.class, "Fox", 0xe87422, 0x3f210c, BetterAnimalsPlusConfig.foxWeight, 1, 6, BiomeDictionary.getBiomes(Type.FOREST), BiomeDictionary.getBiomes(Type.MAGICAL));
		if(BetterAnimalsPlusConfig.spawnTarantula)
			registerNoEggOrSpawn(EntityTarantulaHair.class, "tarantulahair");
		if(BetterAnimalsPlusConfig.spawnTarantula)
			regMob(EntityTarantula.class, "Tarantula", 0x1e1e1e, 0x8c0c0c, BetterAnimalsPlusConfig.tarantulaWeight, 1, 3, BiomeDictionary.getBiomes(Type.SANDY));
		if(BetterAnimalsPlusConfig.spawnHirschgeist)
			regCre(EntityHirschgeist.class, "Hirschgeist", 0xfffff, 0x00000, BetterAnimalsPlusConfig.hirschgeistWeight, 1, 1, BiomeDictionary.getBiomes(Type.FOREST));
		if(BetterAnimalsPlusConfig.spawnGoat)
			regCre(EntityGoat.class, "Goat", 0xffffff, 0xeeeeee, BetterAnimalsPlusConfig.goatWeight, 1, 4, BiomeDictionary.getBiomes(Type.HILLS), BiomeDictionary.getBiomes(Type.MOUNTAIN), BiomeDictionary.getBiomes(Type.SAVANNA), BiomeDictionary.getBiomes(Type.PLAINS), BiomeDictionary.getBiomes(Type.FOREST));
	}


	//#################################################################################

	public static void regCre(Class EntityClass, String entityNameIn, int solidColorIn, int spotColorIn, int prob, int min, int max, Set<Biome>... biomes){
		registerWithSpawnAndEgg(EntityClass, entityNameIn, solidColorIn, spotColorIn, EnumCreatureType.CREATURE, biomes);
	}

	public static void regMob(Class EntityClass, String entityNameIn, int solidColorIn, int spotColorIn, int prob, int min, int max, Set<Biome>... biomes){
		registerWithSpawnAndEgg(EntityClass, entityNameIn, solidColorIn, spotColorIn, EnumCreatureType.MONSTER, biomes);
	}

	public static void registerWithSpawnAndEgg(Class EntityClass, String entityNameIn, int solidColorIn, int spotColorIn, EnumCreatureType typeIn, Set<Biome>... biomes){
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
				.name(entityNameIn)
				.tracker(64, 1, true)
				.egg(solidColorIn, spotColorIn)
				.spawn(typeIn, 4, 1, 1, biomesArray)
				.build();

		entrySet.add(entry);
	}

	public static void registerNoEggOrSpawn(Class EntityClass, String entityNameIn){
		EntityEntry entry = EntityEntryBuilder.create()
				.entity(EntityClass)
				.id(new ResourceLocation(Ref.MOD_ID, entityNameIn), modEntities++)
				.name(entityNameIn)
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
