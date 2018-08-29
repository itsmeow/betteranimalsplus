package its_meow.betteranimalsplus.registry;

import java.util.Collections;
import java.util.Set;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.entity.EntityBear;
import its_meow.betteranimalsplus.entity.EntityBearNeutral;
import its_meow.betteranimalsplus.entity.EntityBearNeutralKermode;
import its_meow.betteranimalsplus.entity.EntityDeer;
import its_meow.betteranimalsplus.entity.EntityLammergeier;
import its_meow.betteranimalsplus.entity.render.RenderBlackBear;
import its_meow.betteranimalsplus.entity.render.RenderBrownBear;
import its_meow.betteranimalsplus.entity.render.RenderDeer;
import its_meow.betteranimalsplus.entity.render.RenderKermodeBear;
import its_meow.betteranimalsplus.entity.render.RenderLammergeier;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeForest;
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
	
	
	
	public static void init(){
		//regCre(Entity.class, "name", 0xFF052E (egg base), 0x14FFFC (egg spot), 25 (percent spawn), 1 (min amt), 3 (max amt), Biomes.PLAINS);
		regMob(EntityBear.class, "Brown Bear", 0x4F2900, 0x8E500E, 3, 1, 1, BiomeDictionary.getBiomes(Type.FOREST));
		regMob(EntityBearNeutral.class, "Black Bear", 0x000000, 0x333333, 2, 1, 1, BiomeDictionary.getBiomes(Type.FOREST));
		regMob(EntityBearNeutralKermode.class, "Kermode Bear", 0xe8e8e8, 0xf7dabe, 1, 1, 1, BiomeDictionary.getBiomes(Type.FOREST));
		regCre(EntityDeer.class, "Deer", 0x8e510b, 0xc6863b, 10, 1, 2,  BiomeDictionary.getBiomes(Type.FOREST), BiomeDictionary.getBiomes(Type.MAGICAL));
		regCre(EntityLammergeier.class, "Lammergeier", 0xd8d8d8, 0xd82b11, 20, 1, 2, BiomeDictionary.getBiomes(Type.HILLS), BiomeDictionary.getBiomes(Type.MOUNTAIN));
	}
	
	@SideOnly(Side.CLIENT)
	public static void initModels() {
		registerRender(EntityBear.class, RenderBrownBear.FACTORY);
		registerRender(EntityBearNeutral.class, RenderBlackBear.FACTORY);
		registerRender(EntityBearNeutralKermode.class, RenderKermodeBear.FACTORY);
		registerRender(EntityDeer.class, RenderDeer.FACTORY);
		registerRender(EntityLammergeier.class, RenderLammergeier.FACTORY);
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
		EntityRegistry.registerModEntity(new ResourceLocation(Ref.MOD_ID + ":" + entityNameIn + "loc"), EntityClass, entityNameIn, ++modEntities, BetterAnimalsPlusMod.mod, 64, 1, true, solidColorIn, spotColorIn);
    }
	
	public static void registerCreatureSpawn(Class EntityClass, int prob, int min, int max, Set<Biome>... biomes) {
		Set<Biome> biomesetAdd = Collections.EMPTY_SET;
		for(Set<Biome> biomeset : biomes) {
			biomeset.addAll(biomesetAdd);
		}
		Biome[] biomesArray = {};
		try {
		biomesArray = biomesetAdd.toArray(biomesArray);
		} catch(NullPointerException e) {
			biomesArray = new Biome[0];
		}
		EntityRegistry.addSpawn(EntityClass, prob, min, max, EnumCreatureType.CREATURE, biomesArray);
	}
	
	public static void registerMobSpawn(Class EntityClass, int prob, int min, int max, Set<Biome>... biomes) {
		Set<Biome> biomesetAdd = Collections.EMPTY_SET;
		for(Set<Biome> biomeset : biomes) {
			biomeset.addAll(biomesetAdd);
		}
		Biome[] biomesArray = {};
		try {
		biomesArray = biomesetAdd.toArray(biomesArray);
		} catch(NullPointerException e) {
			biomesArray = new Biome[0];
		}
		EntityRegistry.addSpawn(EntityClass, prob, min, max, EnumCreatureType.MONSTER, biomesArray);
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerRender(Class EntityClass, IRenderFactory RenderFactory){
		RenderingRegistry.registerEntityRenderingHandler(EntityClass, RenderFactory);
	}
	
	//####################################################################################
	

	
	
}
