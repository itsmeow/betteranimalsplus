package its_meow.betteranimalsplus.init;

import java.util.LinkedHashSet;

import its_meow.betteranimalsplus.common.entity.EntityBadger;
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
import its_meow.betteranimalsplus.common.entity.EntityLamprey;
import its_meow.betteranimalsplus.common.entity.EntityPheasant;
import its_meow.betteranimalsplus.common.entity.EntityReindeer;
import its_meow.betteranimalsplus.common.entity.EntitySongbird;
import its_meow.betteranimalsplus.common.entity.EntitySquirrel;
import its_meow.betteranimalsplus.common.entity.EntityTarantula;
import its_meow.betteranimalsplus.common.entity.miniboss.hirschgeist.EntityHirschgeist;
import its_meow.betteranimalsplus.config.BetterAnimalsPlusConfig;
import its_meow.betteranimalsplus.util.EntityContainer;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.common.registry.EntityEntry;

public class ModEntities {
    public static int modEntities = 0;

    public static LinkedHashSet<EntityEntry> entrySet = new LinkedHashSet<EntityEntry>();
    public static LinkedHashSet<EntityContainer> entityList = new LinkedHashSet<EntityContainer>();

    public static void fillContainers() {
    	add(EntityBear.class, "BrownBear", EnumCreatureType.CREATURE, 0x4F2900, 0x8E500E, BetterAnimalsPlusConfig.brownBearWeight, 1, 1, Type.FOREST);
		add(EntityBearNeutral.class, "BlackBear", EnumCreatureType.CREATURE, 0x000000, 0x333333, BetterAnimalsPlusConfig.blackBearWeight, 1, 1, Type.FOREST);
		add(EntityBearNeutralKermode.class, "KermodeBear", EnumCreatureType.CREATURE, 0xe8e8e8, 0xf7dabe, BetterAnimalsPlusConfig.kermodeBearWeight, 1, 1, Type.FOREST);
		add(EntityDeer.class, "Deer", EnumCreatureType.CREATURE, 0x8e510b, 0xc6863b, BetterAnimalsPlusConfig.deerWeight, 1, 4,  Type.FOREST, Type.MAGICAL);
		add(EntityLammergeier.class, "Lammergeier", EnumCreatureType.CREATURE, 0xd8d8d8, 0xd82b11, BetterAnimalsPlusConfig.lammergeierWeight, 1, 2, Type.HILLS, Type.MOUNTAIN);
		add(EntityFeralWolf.class, "FeralWolf", EnumCreatureType.CREATURE, 0xbababa, 0x232323, BetterAnimalsPlusConfig.feralWolfWeight, 1, 6, Type.FOREST, Type.MAGICAL, Type.SPOOKY);
		add(EntityCoyote.class, "Coyote", EnumCreatureType.CREATURE, 0x866a31, 0xb69762, BetterAnimalsPlusConfig.coyoteWeight, 1, 6, Type.SANDY, Type.PLAINS);
		add(EntityFox.class, "Fox", EnumCreatureType.CREATURE, 0xe87422, 0x3f210c, BetterAnimalsPlusConfig.foxWeight, 1, 6, Type.FOREST, Type.MAGICAL);
		add(EntityTarantula.class, "Tarantula", EnumCreatureType.MONSTER, 0x1e1e1e, 0x8c0c0c, BetterAnimalsPlusConfig.tarantulaWeight, 1, 3, Type.SANDY);
		add(EntityHirschgeist.class, "Hirschgeist", EnumCreatureType.CREATURE, 0xfffff, 0x00000, BetterAnimalsPlusConfig.hirschgeistWeight, 1, 1, Type.FOREST);
		add(EntityGoat.class, "Goat", EnumCreatureType.CREATURE, 0xffffff, 0xeeeeee, BetterAnimalsPlusConfig.goatWeight, 1, 4, Type.HILLS, Type.MOUNTAIN, Type.SAVANNA, Type.PLAINS, Type.FOREST);
		add(EntityJellyfish.class, "Jellyfish", EnumCreatureType.WATER_CREATURE, 0x226fe2, 0xf2b3b3, BetterAnimalsPlusConfig.jellyFishWeight, 1, 1, Type.OCEAN);
		add(EntityPheasant.class, "Pheasant", EnumCreatureType.CREATURE, 0x8e6b0b, 0xd8af3c, BetterAnimalsPlusConfig.pheasantWeight, 1, 3, Type.FOREST, Type.PLAINS, Type.SAVANNA);
		add(EntityReindeer.class, "Reindeer", EnumCreatureType.CREATURE, 0x8e510b, 0x017700, BetterAnimalsPlusConfig.reindeerWeight, 1, 4, Type.SNOWY);
		add(EntityBoar.class, "Boar", EnumCreatureType.CREATURE, 0x3d3c3b, 0xbca895, BetterAnimalsPlusConfig.boarWeight, 1, 4, Type.FOREST, Type.JUNGLE, Type.PLAINS, Type.SAVANNA);
		add(EntitySquirrel.class, "Squirrel", EnumCreatureType.CREATURE, 0x89806f, 0xb2a489, BetterAnimalsPlusConfig.squirrelWeight, 1, 3, Type.FOREST);
        add(EntitySongbird.class, "songbird", EnumCreatureType.CREATURE, 0x46f4d2, 0x7df442, BetterAnimalsPlusConfig.songbirdWeight, 1, 4, Type.FOREST, Type.PLAINS);
        add(EntityBadger.class, "badger", EnumCreatureType.CREATURE, 0x000000, 0xffffff, BetterAnimalsPlusConfig.badgerWeight, 2, 7, Type.FOREST, Type.PLAINS, Type.SAVANNA);
        add(EntityLamprey.class, "lamprey", EnumCreatureType.WATER_CREATURE, 0x000000, 0xffffff, BetterAnimalsPlusConfig.lampreyWeight, 1, 1, Type.WATER);
    }
    
    public static void add(Class<? extends EntityLiving> EntityClass, String entityNameIn, EnumCreatureType type, int solidColorIn, int spotColorIn, int prob, int min, int max, BiomeDictionary.Type... types) {
    	entityList.add(new EntityContainer(EntityClass, entityNameIn, type, solidColorIn, spotColorIn, prob, min, max, types));
    }

}
