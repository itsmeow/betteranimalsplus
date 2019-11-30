package its_meow.betteranimalsplus.init;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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
import its_meow.betteranimalsplus.util.EntityTypeContainer;
import its_meow.betteranimalsplus.util.EntityTypeContainer.CustomConfigurationHolder;
import its_meow.betteranimalsplus.util.EntityTypeContainerTameable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class ModEntities {

    public static final LinkedHashMap<String, EntityTypeContainer<? extends LivingEntity>> ENTITIES = new LinkedHashMap<>();
    
    /*
     * ##########################################################
     * 
     * ##########################################################
     */

        public static final EntityTypeContainer<EntityBear> BROWN_BEAR = setupContainer(new EntityTypeContainer<EntityBear>(EntityBear.class, EntityBear::new, "brownbear",
                EntityClassification.CREATURE, 0x4F2900, 0x8E500E, 7, 1, 1, 2F, 2F, false, null,
                Type.FOREST));
        public static final EntityTypeContainer<EntityBearNeutral> BLACK_BEAR = setupContainer(new EntityTypeContainer<EntityBearNeutral>(EntityBearNeutral.class, EntityBearNeutral::new, "blackbear",
                EntityClassification.CREATURE, 0x000000, 0x333333, 6, 1, 1, 2F, 1.5F, false, null,
                Type.FOREST));
        public static final EntityTypeContainer<EntityDeer> DEER = setupContainer(new EntityTypeContainer<EntityDeer>(EntityDeer.class, EntityDeer::new, "deer",
                EntityClassification.CREATURE, 0x8e510b, 0xc6863b, 16, 1, 4, 1.2F, 1.6F, false, null,
                Type.FOREST, Type.MAGICAL));
        public static final EntityTypeContainerTameable<EntityLammergeier> LAMMERGEIER = setupContainer(new EntityTypeContainerTameable<EntityLammergeier>(EntityLammergeier.class, EntityLammergeier::new, "lammergeier",
                EntityClassification.CREATURE, 0xd8d8d8, 0xd82b11, 7, 1, 2, 1F, 1F, false, new String[] {"minecraft:bone"}, null,
                Type.HILLS, Type.MOUNTAIN));
        public static final EntityTypeContainerTameable<EntityFeralWolf> FERAL_WOLF = setupContainer(new EntityTypeContainerTameable<EntityFeralWolf>(EntityFeralWolf.class, EntityFeralWolf::new, "feralwolf",
                EntityClassification.CREATURE, 0xbababa, 0x232323, 7, 1, 6, 1.35F, 1.5F, false, new String[] {"minecraft:bone"}, null,
                Type.FOREST, Type.MAGICAL, Type.SPOOKY));
        public static final EntityTypeContainerTameable<EntityCoyote> COYOTE = setupContainer(new EntityTypeContainerTameable<EntityCoyote>(EntityCoyote.class, EntityCoyote::new, "coyote",
                EntityClassification.CREATURE, 0x866a31, 0xb69762, 5, 1, 6, 0.8F, 0.9F, false, new String[] {"minecraft:rabbit", "minecraft:chicken", "betteranimalsplus:pheasantraw", "minecraft:cooked_rabbit", "minecraft:cooked_chicken", "betteranimalsplus:pheasantcooked"}, new CustomConfigurationHolder() {
                    private ForgeConfigSpec.BooleanValue coyoteHostileDaytime;
                    @Override
                    public void customConfigurationInit(Builder builder) {
                        this.coyoteHostileDaytime = builder.comment("Makes coyote always hostile (removes ability to tame!)").worldRestart().define("coyoteHostileDaytime", false);
                    }
                    @Override
                    public void customConfigurationLoad() {
                        BetterAnimalsPlusConfig.coyotesHostileDaytime = this.coyoteHostileDaytime.get();
                    }
                },
                Type.SANDY, Type.PLAINS));
        public static final EntityTypeContainer<EntityTarantula> TARANTULA = setupContainer(new EntityTypeContainer<EntityTarantula>(EntityTarantula.class, EntityTarantula::new, "tarantula",
                EntityClassification.MONSTER, 0x1e1e1e, 0x8c0c0c, 13, 1, 3, 1.4F, 0.9F, true, null,
                Type.SANDY));
        public static final EntityTypeContainer<EntityHirschgeist> HIRSCHGEIST = setupContainer(new EntityTypeContainer<EntityHirschgeist>(EntityHirschgeist.class, EntityHirschgeist::new, "hirschgeist",
                EntityClassification.CREATURE, 0xfffff, 0x00000, 2, 1, 1, 3F, 4F, false, null,
                Type.FOREST));
        public static final EntityTypeContainer<EntityGoat> GOAT = setupContainer(new EntityTypeContainer<EntityGoat>(EntityGoat.class, EntityGoat::new, "goat", 
                EntityClassification.CREATURE, 0xffffff,0xeeeeee, 9, 1, 4, 1.2F, 1.2F, false, new CustomConfigurationHolder() {
                    private ForgeConfigSpec.BooleanValue goatVanillaMilk;
                    @Override
                    public void customConfigurationInit(Builder builder) {
                        this.goatVanillaMilk = builder.comment("Enabling this will cause goats to give out vanilla milk instead of goat milk.").worldRestart().define("goatVanillaMilk", false);
                    }
                    @Override
                    public void customConfigurationLoad() {
                        BetterAnimalsPlusConfig.goatVanillaMilk = this.goatVanillaMilk.get();
                    }
                },
                Type.HILLS,Type.MOUNTAIN, Type.SAVANNA, Type.PLAINS, Type.FOREST));
        public static final EntityTypeContainer<EntityJellyfish> JELLYFISH = setupContainer(new EntityTypeContainer<EntityJellyfish>(EntityJellyfish.class, EntityJellyfish::new, "jellyfish",
                EntityClassification.WATER_CREATURE, 0x226fe2, 0xf2b3b3, 10, 1, 1, 0.8F, 0.8F, true, null,
                Type.OCEAN));
        public static final EntityTypeContainer<EntityPheasant> PHEASANT = setupContainer(new EntityTypeContainer<EntityPheasant>(EntityPheasant.class, EntityPheasant::new, "pheasant",
                EntityClassification.CREATURE, 0x8e6b0b, 0xd8af3c, 12, 1, 3, 1F, 1F, false, null,
                Type.FOREST, Type.PLAINS, Type.SAVANNA));
        public static final EntityTypeContainer<EntityReindeer> REINDEER = setupContainer(new EntityTypeContainer<EntityReindeer>(EntityReindeer.class, EntityReindeer::new, "reindeer",
                EntityClassification.CREATURE, 0x8e510b, 0x017700, 10, 1, 4, 1.3964844F, 1.8F, false, null,
                Type.SNOWY));
        public static final EntityTypeContainer<EntityBoar> BOAR = setupContainer(new EntityTypeContainer<EntityBoar>(EntityBoar.class, EntityBoar::new, "boar",
                EntityClassification.CREATURE, 0x3d3c3b, 0xbca895, 9, 1, 4, 0.9F, 0.9F, false, null,
                Type.FOREST, Type.JUNGLE, Type.PLAINS, Type.SAVANNA));
        public static final EntityTypeContainer<EntitySquirrel> SQUIRREL = setupContainer(new EntityTypeContainer<EntitySquirrel>(EntitySquirrel.class, EntitySquirrel::new, "squirrel",
                EntityClassification.CREATURE, 0x89806f, 0xb2a489, 8, 1, 3, 0.5F, 0.5F, false, null,
                Type.FOREST));
        public static final EntityTypeContainer<EntitySongbird> SONGBIRD = setupContainer(new EntityTypeContainer<EntitySongbird>(EntitySongbird.class, EntitySongbird::new, "songbird",
                EntityClassification.CREATURE, 0x46f4d2, 0x7df442, 11, 1, 4, 0.5F, 0.5F, false, null,
                Type.FOREST, Type.PLAINS));
        public static final EntityTypeContainer<EntityBadger> BADGER = setupContainer(new EntityTypeContainer<EntityBadger>(EntityBadger.class, EntityBadger::new, "badger", 
                EntityClassification.CREATURE, 0x0c0c0c, 0xd3d3d3, 7, 1, 2, 0.8F, 0.8F, false, null,
                Type.FOREST, Type.PLAINS, Type.SAVANNA));
        public static final EntityTypeContainer<EntityLamprey> LAMPREY = setupContainer(new EntityTypeContainer<EntityLamprey>(EntityLamprey.class, EntityLamprey::new, "lamprey", 
                EntityClassification.WATER_CREATURE, 0x0000ad, 0x0a0a0a, 7, 1, 1, 1.0F, 0.7F, true, null,
                Type.RIVER, Type.SWAMP));
        public static final EntityTypeContainer<EntityNautilus> NAUTILUS = setupContainer(new EntityTypeContainer<EntityNautilus>(EntityNautilus.class, EntityNautilus::new, "nautilus",
                EntityClassification.WATER_CREATURE, 0xFF9659, 0x241682, 4, 1, 1, 0.75F, 0.75F, true, null, 
                Type.OCEAN));
        public static final EntityTypeContainer<EntityCrab> CRAB = setupContainer(new EntityTypeContainer<EntityCrab>(EntityCrab.class, EntityCrab::new, "crab",
                EntityClassification.CREATURE, 0xe21d16, 0x2d0504, 10, 1, 3, 1F, 0.65F, true, null,
                Type.BEACH, Type.SWAMP));
        public static final EntityTypeContainer<EntityHorseshoeCrab> HORSESHOE_CRAB = setupContainer(new EntityTypeContainer<EntityHorseshoeCrab>(EntityHorseshoeCrab.class, EntityHorseshoeCrab::new, "horseshoecrab",
                EntityClassification.CREATURE, 0xba1111, 0x520807, 8, 1, 3, 1F, 0.65F, true, null,
                Type.BEACH));
        public static final EntityTypeContainer<EntityShark> SHARK = setupContainer(new EntityTypeContainer<EntityShark>(EntityShark.class, EntityShark::new, "shark",
                EntityClassification.WATER_CREATURE, 0x787878, 0xbdbdbd, 4, 1, 1, 2.5F, 1.2F, true, null,
                Type.OCEAN));
        public static final EntityTypeContainer<EntityMoose> MOOSE = setupContainer(new EntityTypeContainer<EntityMoose>(EntityMoose.class, EntityMoose::new, "moose",
                EntityClassification.CREATURE, 0x46351c, 0x97866e, 8, 1, 1, 2.25F, 3F, false, null,
                () -> {List<Biome> list = BiomeDictionary.getBiomes(Type.SWAMP).stream().collect(Collectors.toList());list.add(Biomes.GIANT_SPRUCE_TAIGA); list.add(Biomes.GIANT_SPRUCE_TAIGA_HILLS);list.add(Biomes.GIANT_TREE_TAIGA);list.add(Biomes.GIANT_TREE_TAIGA_HILLS);return list.toArray(new Biome[0]);}));
        public static final EntityTypeContainer<EntityTurkey> TURKEY = setupContainer(new EntityTypeContainer<EntityTurkey>(EntityTurkey.class, EntityTurkey::new, "turkey",
                EntityClassification.CREATURE, 0x857445, 0x5099ba, 11, 1, 3, 1F, 1F, false, null,
                () -> BiomeDictionary.getBiomes(Type.FOREST).stream().filter(biome -> !BiomeDictionary.getTypes(biome).contains(Type.SNOWY)).collect(Collectors.toList()).toArray(new Biome[0])));
        public static final EntityTypeContainer<EntityZotzpyre> ZOTZPYRE = setupContainer(new EntityTypeContainer<EntityZotzpyre>(EntityZotzpyre.class, EntityZotzpyre::new, "zotzpyre",
                EntityClassification.AMBIENT, 0x321e13, 0x543a28, 10, 1, 1, 1F, 1F, true, null,
                Type.FOREST, Type.JUNGLE, Type.BEACH, Type.CONIFEROUS, Type.LUSH, Type.WASTELAND, Type.SWAMP, Type.HILLS, Type.MOUNTAIN));

    /*
     * ##########################################################
     * 
     * ##########################################################
     */

    @SuppressWarnings("unchecked")
    public static <T extends LivingEntity>EntityTypeContainer<T> getEntityTypeContainer(String name) {
        return (EntityTypeContainer<T>) ENTITIES.get(name);
    }

    @SuppressWarnings("unchecked")
    public static <T extends LivingEntity>EntityType<T> getEntityType(String name) {
        return (EntityType<T>) ENTITIES.get(name).entityType;
    }

    private static <T extends LivingEntity, C extends EntityTypeContainer<T>> C setupContainer(C c) {
        c.entityType = ModEntities.<T>createEntityType(c);
        ENTITIES.put(c.entityName, c);
        return c;
    }
    
    private static Field type$serializable = null;

    public static <T extends LivingEntity> EntityType<T> createEntityType(EntityTypeContainer<T> container) {
        return createEntityType(container.entityClass, container.factory, container.entityName, container.spawnType, 64, 1, true, container.width, container.height);
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
