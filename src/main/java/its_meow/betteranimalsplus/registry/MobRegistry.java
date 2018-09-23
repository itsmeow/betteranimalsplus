package its_meow.betteranimalsplus.registry;

import java.sql.Types;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.entity.EntityBear;
import its_meow.betteranimalsplus.entity.EntityBearNeutral;
import its_meow.betteranimalsplus.entity.EntityBearNeutralKermode;
import its_meow.betteranimalsplus.entity.EntityCoyote;
import its_meow.betteranimalsplus.entity.EntityDeer;
import its_meow.betteranimalsplus.entity.EntityFeralWolf;
import its_meow.betteranimalsplus.entity.EntityFox;
import its_meow.betteranimalsplus.entity.EntityLammergeier;
import its_meow.betteranimalsplus.entity.EntityTarantula;
import its_meow.betteranimalsplus.entity.miniboss.hirschgeist.EntityHirschgeist;
import its_meow.betteranimalsplus.entity.projectile.EntityTarantulaHair;
import its_meow.betteranimalsplus.entity.render.RenderBlackBear;
import its_meow.betteranimalsplus.entity.render.RenderBrownBear;
import its_meow.betteranimalsplus.entity.render.RenderCoyote;
import its_meow.betteranimalsplus.entity.render.RenderCustomWolf;
import its_meow.betteranimalsplus.entity.render.RenderDeer;
import its_meow.betteranimalsplus.entity.render.RenderFox;
import its_meow.betteranimalsplus.entity.render.RenderHirschgeist;
import its_meow.betteranimalsplus.entity.render.RenderKermodeBear;
import its_meow.betteranimalsplus.entity.render.RenderLammergeier;
import its_meow.betteranimalsplus.entity.render.RenderTarantula;
import its_meow.betteranimalsplus.entity.render.RenderTarantulaHair;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeForest;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class MobRegistry {
	public static int modEntities;
	
	
	//Need to be using registry events. This will break in the near future.
	public static void init(){
		//regCre(Entity.class, "name", 0xFF052E (egg base), 0x14FFFC (egg spot), 25 (percent spawn), 1 (min amt), 3 (max amt), Biomes.PLAINS);
		regMob(EntityBear.class, "BrownBear", 0x4F2900, 0x8E500E, 4, 1, 1, BiomeDictionary.getBiomes(Type.FOREST));
		regMob(EntityBearNeutral.class, "BlackBear", 0x000000, 0x333333, 4, 1, 1, BiomeDictionary.getBiomes(Type.FOREST));
		regMob(EntityBearNeutralKermode.class, "KermodeBear", 0xe8e8e8, 0xf7dabe, 2, 1, 1, BiomeDictionary.getBiomes(Type.FOREST));
		regMob(EntityDeer.class, "Deer", 0x8e510b, 0xc6863b, 10, 1, 2,  BiomeDictionary.getBiomes(Type.FOREST), BiomeDictionary.getBiomes(Type.MAGICAL));
		regMob(EntityLammergeier.class, "Lammergeier", 0xd8d8d8, 0xd82b11, 7, 1, 2, BiomeDictionary.getBiomes(Type.HILLS), BiomeDictionary.getBiomes(Type.MOUNTAIN));
		regMob(EntityFeralWolf.class, "FeralWolf", 0xbababa, 0x232323, 6, 1, 6, BiomeDictionary.getBiomes(Type.FOREST), BiomeDictionary.getBiomes(Type.MAGICAL), BiomeDictionary.getBiomes(Type.SPOOKY));
		regMob(EntityCoyote.class, "Coyote", 0x866a31, 0xb69762, 6, 1, 6, BiomeDictionary.getBiomes(Type.SANDY), BiomeDictionary.getBiomes(Type.PLAINS));
		regMob(EntityFox.class, "Fox", 0xe87422, 0x3f210c, 8, 1, 6, BiomeDictionary.getBiomes(Type.FOREST), BiomeDictionary.getBiomes(Type.MAGICAL));
		registerNoEgg(EntityTarantulaHair.class, "tarantulahair");
		regMob(EntityTarantula.class, "Tarantula", 0x1e1e1e, 0x8c0c0c, 6, 1, 3, BiomeDictionary.getBiomes(Type.SANDY));
		regMob(EntityHirschgeist.class, "Hirschgeist", 0xfffff, 0x00000, 1, 1, 1, BiomeDictionary.getBiomes(Type.FOREST));
	}
	
	@SideOnly(Side.CLIENT)
	public static void initModels() {
		registerRender(EntityBear.class, RenderBrownBear.FACTORY);
		registerRender(EntityBearNeutral.class, RenderBlackBear.FACTORY);
		registerRender(EntityBearNeutralKermode.class, RenderKermodeBear.FACTORY);
		registerRender(EntityDeer.class, RenderDeer.FACTORY);
		registerRender(EntityLammergeier.class, RenderLammergeier.FACTORY);
		registerRender(EntityFeralWolf.class, RenderCustomWolf.FACTORY);
		registerRender(EntityFox.class, RenderFox.FACTORY);
		registerRender(EntityTarantulaHair.class, RenderTarantulaHair.FACTORY);
		registerRender(EntityTarantula.class, RenderTarantula.FACTORY);
		registerRender(EntityHirschgeist.class, RenderHirschgeist.FACTORY);
	}
	
	@SideOnly(Side.CLIENT)
	public static void initModel(Class EntityClass, IRenderFactory FACTORY){
		registerRender(EntityClass, FACTORY);
	}
	
	
	//#################################################################################
	
	public static void regCre(Class EntityClass, String entityNameIn, int solidColorIn, int spotColorIn, int prob, int min, int max, Set<Biome>... biomes){
		register(EntityClass, entityNameIn, solidColorIn, spotColorIn);
		registerCreatureSpawn(EntityClass, prob, min, max, biomes);
		//initModel(EntityClass, FACTORY);
	}
	
	public static void regMob(Class EntityClass, String entityNameIn, int solidColorIn, int spotColorIn, int prob, int min, int max, Set<Biome>... biomes){
		register(EntityClass, entityNameIn, solidColorIn, spotColorIn);
		registerMobSpawn(EntityClass, prob, min, max, biomes);
		//initModel(EntityClass, FACTORY);
	}
	
	public static void register(Class EntityClass, String entityNameIn, int solidColorIn, int spotColorIn){
		EntityRegistry.registerModEntity(new ResourceLocation(Ref.MOD_ID + ":" + entityNameIn), EntityClass, entityNameIn, ++modEntities, BetterAnimalsPlusMod.mod, 64, 1, true, solidColorIn, spotColorIn);
    }
	
	public static void registerNoEgg(Class EntityClass, String entityNameIn){
		EntityRegistry.registerModEntity(new ResourceLocation(Ref.MOD_ID + ":" + entityNameIn), EntityClass, entityNameIn, ++modEntities, BetterAnimalsPlusMod.mod, 64, 1, true);
    }
	
	public static void registerCreatureSpawn(Class EntityClass, int prob, int min, int max, Set<Biome>... biomes) {
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
		
		/*for(Biome biome : biomesArray) {
			List<SpawnListEntry> list = biome.getSpawnableList(EnumCreatureType.CREATURE);
			
			int totalValue = 0;
			int totalAmount = 0;

			
			for(SpawnListEntry entry : list) {
				totalValue += entry.itemWeight;
				totalAmount++;
			}
			int prob2 = 0;
			if(totalAmount != 0) {
				prob2 = prob * ((totalValue) / totalAmount);
			} else {
				prob2 = prob;
			}
			
            boolean found = false;
			for(SpawnListEntry entry : list) {
				if (entry.entityClass == EntityClass)
                {
                    entry.itemWeight = prob2;
                    entry.minGroupCount = min;
                    entry.maxGroupCount = max;
                    found = true;
                    break;
                }
			}
			
			
            if (!found) {
                list.add(new SpawnListEntry(EntityClass, prob2, min, max));
            }
			
		}*/
		EntityRegistry.addSpawn(EntityClass, prob, min, max, EnumCreatureType.CREATURE, biomesArray);
	}
	
	public static void registerMobSpawn(Class EntityClass, int prob, int min, int max, Set<Biome>... biomes) {
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
		
		
		/*for(Biome biome : biomesArray) {
			List<SpawnListEntry> list = biome.getSpawnableList(EnumCreatureType.MONSTER);
			
			int totalValue = 0;
			int totalAmount = 0;

			
			for(SpawnListEntry entry : list) {
				totalValue += entry.itemWeight;
				totalAmount++;
			}
			
			int prob2 = 0;
			if(totalAmount != 0) {
				prob2 = prob * ((totalValue) / totalAmount);
			} else {
				prob2 = prob;
			}
			
			
            boolean found = false;
			for(SpawnListEntry entry : list) {
				if (entry.entityClass == EntityClass)
                {
                    entry.itemWeight = prob2;
                    entry.minGroupCount = min;
                    entry.maxGroupCount = max;
                    found = true;
                    break;
                }
			}
			
			
            if (!found) {
                list.add(new SpawnListEntry(EntityClass, prob2, min, max));
            }
			
		}*/
		EntityRegistry.addSpawn(EntityClass, prob, min, max, EnumCreatureType.MONSTER, biomesArray);
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerRender(Class EntityClass, IRenderFactory RenderFactory){
		RenderingRegistry.registerEntityRenderingHandler(EntityClass, RenderFactory);
	}
	
	//####################################################################################
	

	
	
}
