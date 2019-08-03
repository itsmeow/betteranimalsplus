package its_meow.betteranimalsplus.init;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.function.Function;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.entity.EntityBadger;
import its_meow.betteranimalsplus.common.entity.EntityBear;
import its_meow.betteranimalsplus.common.entity.EntityBearNeutral;
import its_meow.betteranimalsplus.common.entity.EntityBoar;
import its_meow.betteranimalsplus.common.entity.EntityCoyote;
import its_meow.betteranimalsplus.common.entity.EntityCrab;
import its_meow.betteranimalsplus.common.entity.EntityDeer;
import its_meow.betteranimalsplus.common.entity.EntityFeralWolf;
import its_meow.betteranimalsplus.common.entity.EntityGoat;
import its_meow.betteranimalsplus.common.entity.EntityHorseshoeCrab;
import its_meow.betteranimalsplus.common.entity.EntityJellyfish;
import its_meow.betteranimalsplus.common.entity.EntityLammergeier;
import its_meow.betteranimalsplus.common.entity.EntityLamprey;
import its_meow.betteranimalsplus.common.entity.EntityNautilus;
import its_meow.betteranimalsplus.common.entity.EntityPheasant;
import its_meow.betteranimalsplus.common.entity.EntityReindeer;
import its_meow.betteranimalsplus.common.entity.EntityShark;
import its_meow.betteranimalsplus.common.entity.EntitySongbird;
import its_meow.betteranimalsplus.common.entity.EntitySquirrel;
import its_meow.betteranimalsplus.common.entity.EntityTarantula;
import its_meow.betteranimalsplus.common.entity.miniboss.hirschgeist.EntityHirschgeist;
import its_meow.betteranimalsplus.config.BetterAnimalsPlusConfig;
import its_meow.betteranimalsplus.util.EntityContainer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

@SuppressWarnings("unchecked")
public class ModEntities {

    public static LinkedHashMap<String, EntityType<? extends LivingEntity>> entryMap = new LinkedHashMap<>();
    public static ArrayList<EntityContainer<?>> entityList = new ArrayList<>();
    public static ArrayList<EntityType<? extends LivingEntity>> entrySet = new ArrayList<EntityType<? extends LivingEntity>>();
    public static LinkedHashMap<EntityContainer<?>, EntityType<? extends LivingEntity>> entryMapContainers = new LinkedHashMap<>();
    public static LinkedHashMap<String, EntityContainer<?>> entityMap = new LinkedHashMap<>();

    public static <T extends LivingEntity> EntityType<T> getEntityType(String name) {
        return (EntityType<T>) entryMap.get(name);
    }

    static {
        ModEntities.entityList.add(new EntityContainer<EntityBear>(EntityBear.class, EntityBear::new, "brownbear",
                EntityClassification.CREATURE, 0x4F2900, 0x8E500E, BetterAnimalsPlusConfig.brownBearWeight, 1, 1, 2F, 2F, null,
                Type.FOREST));
        ModEntities.entityList.add(new EntityContainer<EntityBearNeutral>(EntityBearNeutral.class, EntityBearNeutral::new, "blackbear",
                EntityClassification.CREATURE, 0x000000, 0x333333, BetterAnimalsPlusConfig.blackBearWeight, 1, 1, 2F, 1.5F, null,
                Type.FOREST));
        ModEntities.entityList.add(new EntityContainer<EntityDeer>(EntityDeer.class, EntityDeer::new, "deer",
                EntityClassification.CREATURE, 0x8e510b, 0xc6863b, BetterAnimalsPlusConfig.deerWeight, 1, 4, 1.2F, 1.6F, null,
                Type.FOREST, Type.MAGICAL));
        ModEntities.entityList.add(new EntityContainer<EntityLammergeier>(EntityLammergeier.class, EntityLammergeier::new, "lammergeier",
                EntityClassification.CREATURE, 0xd8d8d8, 0xd82b11, BetterAnimalsPlusConfig.lammergeierWeight, 1, 2, 1F, 1F, new String[] {"minecraft:bone"},
                Type.HILLS, Type.MOUNTAIN));
        ModEntities.entityList.add(new EntityContainer<EntityFeralWolf>(EntityFeralWolf.class, EntityFeralWolf::new, "feralwolf",
                EntityClassification.CREATURE, 0xbababa, 0x232323, BetterAnimalsPlusConfig.feralWolfWeight, 1, 6, 0.8F, 0.9F, new String[] {"minecraft:bone"},
                Type.FOREST, Type.MAGICAL, Type.SPOOKY));
        ModEntities.entityList.add(new EntityContainer<EntityCoyote>(EntityCoyote.class, EntityCoyote::new, "coyote",
                EntityClassification.CREATURE, 0x866a31, 0xb69762, BetterAnimalsPlusConfig.coyoteWeight, 1, 6, 0.8F, 0.9F, new String[] {"minecraft:rabbit", "minecraft:chicken", "betteranimalsplus:pheasantraw", "minecraft:cooked_rabbit", "minecraft:cooked_chicken", "betteranimalsplus:pheasantcooked"},
                Type.SANDY, Type.PLAINS));
        ModEntities.entityList.add(new EntityContainer<EntityTarantula>(EntityTarantula.class, EntityTarantula::new, "tarantula",
                EntityClassification.MONSTER, 0x1e1e1e, 0x8c0c0c, BetterAnimalsPlusConfig.tarantulaWeight, 1, 3, 1.4F, 0.9F, null,
                Type.SANDY));
        ModEntities.entityList.add(new EntityContainer<EntityHirschgeist>(EntityHirschgeist.class, EntityHirschgeist::new, "hirschgeist",
                EntityClassification.CREATURE, 0xfffff, 0x00000, BetterAnimalsPlusConfig.hirschgeistWeight, 1, 1, 3F, 4F, null,
                Type.FOREST));
        ModEntities.entityList.add(new EntityContainer<EntityGoat>(EntityGoat.class, EntityGoat::new, "goat", 
                EntityClassification.CREATURE, 0xffffff,0xeeeeee, BetterAnimalsPlusConfig.goatWeight, 1, 4, 1.2F, 1.2F, null,
                Type.HILLS,Type.MOUNTAIN, Type.SAVANNA, Type.PLAINS, Type.FOREST));
        ModEntities.entityList.add(new EntityContainer<EntityJellyfish>(EntityJellyfish.class, EntityJellyfish::new, "jellyfish",
                EntityClassification.WATER_CREATURE, 0x226fe2, 0xf2b3b3, BetterAnimalsPlusConfig.jellyFishWeight, 1, 1, 0.8F, 0.8F, null,
                Type.OCEAN));
        ModEntities.entityList.add(new EntityContainer<EntityPheasant>(EntityPheasant.class, EntityPheasant::new, "pheasant",
                EntityClassification.CREATURE, 0x8e6b0b, 0xd8af3c, BetterAnimalsPlusConfig.pheasantWeight, 1, 3, 1F, 1F, null,
                Type.FOREST, Type.PLAINS, Type.SAVANNA));
        ModEntities.entityList.add(new EntityContainer<EntityReindeer>(EntityReindeer.class, EntityReindeer::new, "reindeer",
                EntityClassification.CREATURE, 0x8e510b, 0x017700, BetterAnimalsPlusConfig.reindeerWeight, 1, 4, 1.3964844F, 1.8F, null,
                Type.SNOWY));
        ModEntities.entityList.add(new EntityContainer<EntityBoar>(EntityBoar.class, EntityBoar::new, "boar",
                EntityClassification.CREATURE, 0x3d3c3b, 0xbca895, BetterAnimalsPlusConfig.boarWeight, 1, 4, 0.9F, 0.9F, null,
                Type.FOREST, Type.JUNGLE, Type.PLAINS, Type.SAVANNA));
        ModEntities.entityList.add(new EntityContainer<EntitySquirrel>(EntitySquirrel.class, EntitySquirrel::new, "squirrel",
                EntityClassification.CREATURE, 0x89806f, 0xb2a489, BetterAnimalsPlusConfig.squirrelWeight, 1, 3, 0.5F, 0.5F, null,
                Type.FOREST));
        ModEntities.entityList.add(new EntityContainer<EntitySongbird>(EntitySongbird.class, EntitySongbird::new, "songbird",
                EntityClassification.CREATURE, 0x46f4d2, 0x7df442, BetterAnimalsPlusConfig.songbirdWeight, 1, 4, 0.5F, 0.5F, null,
                Type.FOREST, Type.PLAINS));
        ModEntities.entityList.add(new EntityContainer<EntityBadger>(EntityBadger.class, EntityBadger::new, "badger", 
                EntityClassification.CREATURE, 0x0c0c0c, 0xd3d3d3, BetterAnimalsPlusConfig.badgerWeight, 1, 2, 0.8F, 0.8F, null,
                Type.FOREST, Type.PLAINS, Type.SAVANNA));
        ModEntities.entityList.add(new EntityContainer<EntityLamprey>(EntityLamprey.class, EntityLamprey::new, "lamprey", 
                EntityClassification.WATER_CREATURE, 0x0000ad, 0x0a0a0a, BetterAnimalsPlusConfig.lampreyWeight, 1, 1, 1.0F, 0.7F, null,
                Type.RIVER, Type.SWAMP));
        ModEntities.entityList.add(new EntityContainer<EntityNautilus>(EntityNautilus.class, EntityNautilus::new, "nautilus",
                EntityClassification.WATER_CREATURE, 0xFF9659, 0x241682, BetterAnimalsPlusConfig.nautilusWeight, 1, 1, 0.75F, 0.75F, null, 
                Type.OCEAN));
        ModEntities.entityList.add(new EntityContainer<EntityCrab>(EntityCrab.class, EntityCrab::new, "crab",
                EntityClassification.CREATURE, 0xe21d16, 0x2d0504, BetterAnimalsPlusConfig.crabWeight, 1, 3, 1F, 0.65F, null,
                Type.BEACH, Type.SWAMP));
        ModEntities.entityList.add(new EntityContainer<EntityHorseshoeCrab>(EntityHorseshoeCrab.class, EntityHorseshoeCrab::new, "horseshoecrab",
                EntityClassification.CREATURE, 0xba1111, 0x520807, BetterAnimalsPlusConfig.horseshoeCrabWeight, 1, 3, 1F, 0.65F, null,
                Type.BEACH));
        ModEntities.entityList.add(new EntityContainer<EntityShark>(EntityShark.class, EntityShark::new, "shark",
                EntityClassification.WATER_CREATURE, 0x787878, 0xbdbdbd, BetterAnimalsPlusConfig.sharkWeight, 1, 1, 2.5F, 1.2F, null,
                Type.OCEAN));

        for (EntityContainer<?> container : ModEntities.entityList) {
            ModEntities.setupContainer((EntityContainer<LivingEntity>) container);
        }
    }

    /*
     * Helpers
     */

    private static void setupContainer(EntityContainer<LivingEntity> c) {
        EntityType<LivingEntity> entry = ModEntities.createEntityType(c.entityClazz, c.entityFunction, c.entityName,
                c);

        if (c != null) {
            ModEntities.entryMap.put(c.entityName, entry);
            ModEntities.entryMapContainers.put(c, entry);
            ModEntities.entityMap.put(c.entityName, c);
        }
        ModEntities.entrySet.add(entry);
    }
    
    private static Field type$serializable = null;

    public static <T extends LivingEntity> EntityType<T> createEntityType(Class<T> EntityClass, Function<World, T> func, String entityNameIn, EntityContainer<T> container) {
        return createEntityType(EntityClass, func, entityNameIn, container.type, 64, 1, true, container.width, container.height);
    }
    
    public static <T extends Entity> EntityType<T> createEntityType(Class<T> EntityClass, Function<World, T> func, String entityNameIn, EntityClassification classification, int trackingRange, int updateInterval, boolean velUpdates, float width, float height) {
        EntityType<T> type =  EntityType.Builder.<T>create((etype, world) -> func.apply(world), classification).setTrackingRange(trackingRange).setUpdateInterval(updateInterval).setShouldReceiveVelocityUpdates(velUpdates).size(width, height).setCustomClientFactory((e, world) -> func.apply(world)).disableSerialization().build(Ref.MOD_ID + ":" + entityNameIn.toLowerCase());
        type.setRegistryName(Ref.MOD_ID + ":" + entityNameIn.toLowerCase());
        
        // It's okay, I hate it too
        try {
            if(type$serializable == null) {
                type$serializable = ObfuscationReflectionHelper.findField(EntityType.class, "field_200733_aL");
            }
            setFinalField(type$serializable, type, true);
        } catch(Exception e) {
            BetterAnimalsPlusMod.logger.warn("Unable to set serializable for " + entityNameIn + ". This could result in possible saving issues with entities!");
        }
        return type;
    }
    
    private static void setFinalField(Field field, Object object, Object newValue) throws Exception {
        field.setAccessible(true);

        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

        field.set(object, newValue);
     }

}
