package its_meow.betteranimalsplus.init;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import com.google.common.collect.Lists;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.client.model.ModelBearHead;
import its_meow.betteranimalsplus.client.model.ModelBoarHead;
import its_meow.betteranimalsplus.client.model.ModelCoyoteHead;
import its_meow.betteranimalsplus.client.model.ModelDeerHead;
import its_meow.betteranimalsplus.client.model.ModelFeralWolfHead;
import its_meow.betteranimalsplus.client.model.ModelHirschgeistSkull;
import its_meow.betteranimalsplus.client.model.ModelMooseHead;
import its_meow.betteranimalsplus.client.model.ModelReindeerHead;
import its_meow.betteranimalsplus.common.entity.EntityBadger;
import its_meow.betteranimalsplus.common.entity.EntityBear;
import its_meow.betteranimalsplus.common.entity.EntityBearNeutral;
import its_meow.betteranimalsplus.common.entity.EntityBoar;
import its_meow.betteranimalsplus.common.entity.EntityBobbitWorm;
import its_meow.betteranimalsplus.common.entity.EntityCoyote;
import its_meow.betteranimalsplus.common.entity.EntityCrab;
import its_meow.betteranimalsplus.common.entity.EntityDeer;
import its_meow.betteranimalsplus.common.entity.EntityFeralWolf;
import its_meow.betteranimalsplus.common.entity.EntityFreshwaterEel;
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
import its_meow.betteranimalsplus.common.entity.EntitySaltwaterEel;
import its_meow.betteranimalsplus.common.entity.EntityShark;
import its_meow.betteranimalsplus.common.entity.EntitySongbird;
import its_meow.betteranimalsplus.common.entity.EntitySquirrel;
import its_meow.betteranimalsplus.common.entity.EntityTarantula;
import its_meow.betteranimalsplus.common.entity.EntityTurkey;
import its_meow.betteranimalsplus.common.entity.EntityZotzpyre;
import its_meow.betteranimalsplus.common.entity.miniboss.hirschgeist.EntityHirschgeist;
import its_meow.betteranimalsplus.common.entity.util.EntityTypeContainer;
import its_meow.betteranimalsplus.common.entity.util.EntityTypeContainer.Builder;
import its_meow.betteranimalsplus.common.entity.util.EntityTypeContainer.CustomConfigurationHolder;
import its_meow.betteranimalsplus.common.entity.util.EntityTypeContainerTameable;
import its_meow.betteranimalsplus.common.entity.util.EntityTypeContainerTameable.TameableBuilder;
import its_meow.betteranimalsplus.common.entity.util.EntityVariant;
import its_meow.betteranimalsplus.config.BetterAnimalsPlusConfig;
import its_meow.betteranimalsplus.util.BiomeListBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry.PlacementType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class ModEntities {

    public static final LinkedHashMap<String, EntityTypeContainer<? extends MobEntity>> ENTITIES = new LinkedHashMap<>();
    
    /*
     * ##########################################################
     * 
     * ##########################################################
     */

        public static final EntityTypeContainer<EntityBear> BROWN_BEAR = setup(create(EntityBear.class, EntityBear::new, "brownbear").spawn(EntityClassification.CREATURE, 7, 1, 1).egg(0x4F2900, 0x8E500E).size(2F, 2F).biomes(Type.FOREST).head().singleton("1", "bear_brown").setModel(() -> ModelBearHead::new).done());
        public static final EntityTypeContainer<EntityBearNeutral> BLACK_BEAR = setup(create(EntityBearNeutral.class, EntityBearNeutral::new, "blackbear").spawn(EntityClassification.CREATURE, 6, 1, 1).egg(0x000000, 0x333333).size(2F, 1.5F).biomes(Type.FOREST).variants("black", "kermode").head().mapToNames().setModel(() -> ModelBearHead::new).done());
        public static final EntityTypeContainer<EntityDeer> DEER = setup(create(EntityDeer.class, EntityDeer::new, "deer").spawn(EntityClassification.CREATURE, 16, 1, 4).egg(0x8e510b, 0xc6863b).size(1.2F, 1.6F).biomes(Type.FOREST, Type.MAGICAL).variants(
            new EntityDeer.EntityDeerVariant("1"),
            new EntityDeer.EntityDeerVariant("2"),
            new EntityDeer.EntityDeerVariant("3"),
            new EntityDeer.EntityDeerVariant("4")
        ).head().mapToNames().offset(-1.5F).setModel(() -> ModelDeerHead::new).done());
        public static final EntityTypeContainerTameable<EntityLammergeier> LAMMERGEIER = setup(createTame(EntityLammergeier.class, EntityLammergeier::new, "lammergeier").spawn(EntityClassification.CREATURE, 7, 1, 2).egg(0xd8d8d8, 0xd82b11).size(1F, 1F).tameItems("minecraft:bone").biomes(Type.HILLS, Type.MOUNTAIN).variants("orange", "red", "white", "yellow"));
        public static final EntityTypeContainerTameable<EntityFeralWolf> FERAL_WOLF = setup(createTame(EntityFeralWolf.class, EntityFeralWolf::new, "feralwolf").spawn(EntityClassification.CREATURE, 7, 1, 6).egg(0xbababa, 0x232323).size(1.35F, 1.5F).tameItems("minecraft:bone").biomes(Type.FOREST, Type.MAGICAL, Type.SPOOKY).variants("black", "snowy", "timber", "arctic", "brown", "red").head().mapToNames().allowFloor().setModel(() -> ModelFeralWolfHead::new).done());
        public static final EntityTypeContainerTameable<EntityCoyote> COYOTE = setup(createTame(EntityCoyote.class, EntityCoyote::new, "coyote").spawn(EntityClassification.CREATURE, 5, 1, 6).egg(0x866a31, 0xb69762).size(0.8F, 0.9F).tameItems("minecraft:rabbit", "minecraft:chicken", "betteranimalsplus:pheasantraw", "minecraft:cooked_rabbit", "minecraft:cooked_chicken", "betteranimalsplus:pheasantcooked").biomes(Type.SANDY, Type.PLAINS).config(new CustomConfigurationHolder() {
            private ForgeConfigSpec.BooleanValue coyoteHostileDaytime;
            @Override
            public void customConfigurationInit(ForgeConfigSpec.Builder builder) {
                this.coyoteHostileDaytime = builder.comment("Makes coyote always hostile (removes ability to tame!)").worldRestart().define("coyoteHostileDaytime", false);
            }
            @Override
            public void customConfigurationLoad() {
                BetterAnimalsPlusConfig.coyotesHostileDaytime = this.coyoteHostileDaytime.get();
            }
        }).head().allowFloor().singleton("1", "coyote_hostile").setModel(() -> ModelCoyoteHead::new).done());
        public static final EntityTypeContainer<EntityTarantula> TARANTULA = setup(create(EntityTarantula.class, EntityTarantula::new, "tarantula").spawn(EntityClassification.MONSTER, 40, 1, 3).egg(0x1e1e1e, 0x8c0c0c).size(1.4F, 0.9F).despawn().biomes(Type.SANDY));
        public static final EntityTypeContainer<EntityHirschgeist> HIRSCHGEIST = setup(create(EntityHirschgeist.class, EntityHirschgeist::new, "hirschgeist").spawn(EntityClassification.CREATURE, 2, 1, 1).egg(0xfffff, 0x00000).size(3F, 4F).biomes(Type.FOREST).head("hirschgeistskull").allowFloor().offset(-0.2F).singleton("1", "hirschgeist").setModel(() -> ModelHirschgeistSkull::new).done());
        public static final EntityTypeContainer<EntityGoat> GOAT = setup(create(EntityGoat.class, EntityGoat::new, "goat").spawn(EntityClassification.CREATURE, 9, 1, 4).egg(0xffffff, 0xeeeeee).size(1.2F, 1.2F).biomes(Type.HILLS,Type.MOUNTAIN, Type.SAVANNA, Type.PLAINS, Type.FOREST).config(new CustomConfigurationHolder() {
            private ForgeConfigSpec.BooleanValue goatVanillaMilk;
            @Override
            public void customConfigurationInit(ForgeConfigSpec.Builder builder) {
                this.goatVanillaMilk = builder.comment("Enabling this will cause goats to give out vanilla milk instead of goat milk.").worldRestart().define("goatVanillaMilk", false);
            }
            @Override
            public void customConfigurationLoad() {
                BetterAnimalsPlusConfig.goatVanillaMilk = this.goatVanillaMilk.get();
            }
        }).variants(7));
        public static final EntityTypeContainer<EntityJellyfish> JELLYFISH = setup(create(EntityJellyfish.class, EntityJellyfish::new, "jellyfish").spawn(EntityClassification.WATER_CREATURE, 10, 1, 1).waterPlacement().egg(0x226fe2, 0xf2b3b3).size(0.8F, 0.8F).despawn().biomes(Type.OCEAN).variants(6));
        public static final EntityTypeContainer<EntityPheasant> PHEASANT = setup(create(EntityPheasant.class, EntityPheasant::new, "pheasant").spawn(EntityClassification.CREATURE, 12, 1, 3).egg(0x8e6b0b, 0xd8af3c).size(1F, 1F).biomes(Type.FOREST, Type.PLAINS, Type.SAVANNA).variants(2));
        public static final EntityTypeContainer<EntityReindeer> REINDEER = setup(create(EntityReindeer.class, EntityReindeer::new, "reindeer").spawn(EntityClassification.CREATURE, 10, 1, 4).egg(0x8e510b, 0x017700).size(1.3964844F, 1.8F).biomes(BiomeListBuilder.create().withTypes(Type.SNOWY).withoutTypes(Type.OCEAN)::collect).variants(
            new EntityVariant("1", "reindeer_1"),
            new EntityVariant("2", "reindeer_2"),
            new EntityVariant("3", "reindeer_3"),
            new EntityVariant("4", "reindeer_4"),
            new EntityVariant("1_christmas", "reindeer_1_christmas", false),
            new EntityVariant("2_christmas", "reindeer_2_christmas", false),
            new EntityVariant("3_christmas", "reindeer_3_christmas", false),
            new EntityVariant("4_christmas", "reindeer_4_christmas", false)
        ).head("reindeerhead").mapToNames().setModel(() -> ModelReindeerHead::new).done());
        public static final EntityTypeContainer<EntityBoar> BOAR = setup(create(EntityBoar.class, EntityBoar::new, "boar").spawn(EntityClassification.CREATURE, 9, 1, 4).egg(0x3d3c3b, 0xbca895).size(0.9F, 0.9F).biomes(Type.FOREST, Type.JUNGLE, Type.PLAINS, Type.SAVANNA).variants(4).head().mapToNames().setModel(() -> ModelBoarHead::new).done());
        public static final EntityTypeContainer<EntitySquirrel> SQUIRREL = setup(create(EntitySquirrel.class, EntitySquirrel::new, "squirrel").spawn(EntityClassification.CREATURE, 8, 1, 3).egg(0x89806f, 0xb2a489).size(0.5F, 0.5F).biomes(Type.FOREST).variants("gray", "red", "albino"));
        public static final EntityTypeContainer<EntitySongbird> SONGBIRD = setup(create(EntitySongbird.class, EntitySongbird::new, "songbird").spawn(EntityClassification.CREATURE, 11, 1, 4).egg(0x46f4d2, 0x7df442).size(0.5F, 0.5F).biomes(Type.FOREST, Type.PLAINS).variants("1", "2", "3", "4", "small_1", "small_2", "small_3", "small_4", "small_5", "small_6"));
        public static final EntityTypeContainer<EntityBadger> BADGER = setup(create(EntityBadger.class, EntityBadger::new, "badger").spawn(EntityClassification.CREATURE, 7, 1, 2).egg(0x0c0c0c, 0xd3d3d3).size(0.8F, 0.8F).biomes(Type.FOREST, Type.PLAINS, Type.SAVANNA).variants(3));
        public static final EntityTypeContainer<EntityLamprey> LAMPREY = setup(create(EntityLamprey.class, EntityLamprey::new, "lamprey").spawn(EntityClassification.WATER_CREATURE, 7, 1, 1).waterPlacement().egg(0x0000ad, 0x0a0a0a).size(1.0F, 0.7F).despawn().biomes(Type.RIVER, Type.SWAMP).variants("yellow", "spotted", "brown"));
        public static final EntityTypeContainer<EntityNautilus> NAUTILUS = setup(create(EntityNautilus.class, EntityNautilus::new, "nautilus").spawn(EntityClassification.WATER_CREATURE, 4, 1, 1).waterPlacement().egg(0xFF9659, 0x241682).size(0.75F, 0.75F).despawn().biomes(Type.OCEAN));
        public static final EntityTypeContainer<EntityCrab> CRAB = setup(create(EntityCrab.class, EntityCrab::new, "crab").spawn(EntityClassification.CREATURE, 10, 1, 3).egg(0xe21d16, 0x2d0504).size(1F, 0.65F).biomes(Type.BEACH, Type.SWAMP).variants(4));
        public static final EntityTypeContainer<EntityHorseshoeCrab> HORSESHOE_CRAB = setup(create(EntityHorseshoeCrab.class, EntityHorseshoeCrab::new, "horseshoecrab").spawn(EntityClassification.CREATURE, 8, 1, 3).egg(0xba1111, 0x520807).size(1F, 0.65F).biomes(Type.BEACH).variants(3));
        public static final EntityTypeContainer<EntityShark> SHARK = setup(create(EntityShark.class, EntityShark::new, "shark").spawn(EntityClassification.WATER_CREATURE, 4, 1, 1).waterPlacement().egg(0x787878, 0xbdbdbd).size(2.5F, 1.2F).despawn().biomes(Type.OCEAN).variants("blue", "bull", "tiger", "whitetip", "greenland"));
        public static final EntityTypeContainer<EntityMoose> MOOSE = setup(create(EntityMoose.class, EntityMoose::new, "moose").spawn(EntityClassification.CREATURE, 8, 1, 1).egg(0x46351c, 0x97866e).size(2.25F, 3F).biomes(BiomeListBuilder.create().extra(Type.SWAMP).extra(Biomes.GIANT_SPRUCE_TAIGA, Biomes.GIANT_SPRUCE_TAIGA_HILLS, Biomes.GIANT_TREE_TAIGA, Biomes.GIANT_TREE_TAIGA_HILLS)::collect).variants(4).head().mapToNames().offset(-1.35F).setModel(() -> ModelMooseHead::new).done());
        public static final EntityTypeContainer<EntityTurkey> TURKEY = setup(create(EntityTurkey.class, EntityTurkey::new, "turkey").spawn(EntityClassification.CREATURE, 11, 1, 3).egg(0x857445, 0x5099ba).size(1F, 1F).biomes(BiomeListBuilder.create().withTypes(Type.FOREST).withoutTypes(Type.SNOWY)::collect).variants(4));
        public static final EntityTypeContainer<EntityZotzpyre> ZOTZPYRE = setup(create(EntityZotzpyre.class, EntityZotzpyre::new, "zotzpyre").spawn(EntityClassification.MONSTER, 30, 1, 1).defaultPlacement(EntityZotzpyre::canSpawn).egg(0x321e13, 0x543a28).size(1F, 1F).despawn().biomes(Type.FOREST, Type.JUNGLE, Type.BEACH, Type.CONIFEROUS, Type.LUSH, Type.WASTELAND, Type.SWAMP, Type.HILLS, Type.MOUNTAIN).variants(5));
        public static final EntityTypeContainer<EntityBobbitWorm> BOBBIT_WORM = setup(create(EntityBobbitWorm.class, EntityBobbitWorm::new, "bobbit_worm").spawn(EntityClassification.WATER_CREATURE, 2, 1, 1).waterPlacement().egg(0xffe38f, 0x0f27bf).size(1F, 1F).despawn().biomes(Type.OCEAN).variants(2));
        public static final EntityTypeContainer<EntityGoose> GOOSE = setup(create(EntityGoose.class, EntityGoose::new, "goose").spawn(EntityClassification.CREATURE, 15, 2, 5).placement(PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING, EntityGoose::canSpawn).egg(0xd3cfcf, 0x5e5752).size(1F, 1F).biomes(BiomeListBuilder.create().withTypes(Type.FOREST).withoutTypes(Type.DRY, Type.COLD, Type.HOT, Type.DENSE, Type.DEAD, Type.SPARSE, Type.OCEAN).extra(Type.RIVER)::collect).config(new CustomConfigurationHolder() {
            private ForgeConfigSpec.ConfigValue<List<? extends String>> pickupBlacklist;
            @Override
            public void customConfigurationInit(net.minecraftforge.common.ForgeConfigSpec.Builder builder) {
                this.pickupBlacklist = builder.comment("List of blacklisted item IDs that cannot be picked up. Accepts tags by prefixing them with '#'.").worldRestart().defineList("pickup_blacklist", Lists.asList("betteranimalsplus:goose_egg", new String[] {"betteranimalsplus:golden_goose_egg"}), (Predicate<Object>) input -> input instanceof String);
            }
            @Override
            public void customConfigurationLoad() {
                EntityGoose.pickupBlockList = pickupBlacklist.get().toArray(new String[0]);
            }
        }).variants(3));
        public static final EntityTypeContainer<EntityFreshwaterEel> EEL_FRESHWATER = setup(create(EntityFreshwaterEel.class, EntityFreshwaterEel::new, "eel_freshwater").spawn(EntityClassification.WATER_CREATURE, 7, 1, 2).waterPlacement().egg(0x818077, 0x726c4f).size(1F, 1F).despawn().biomes(Type.RIVER, Type.SWAMP).variants("longfin", "silver"));
        public static final EntityTypeContainer<EntitySaltwaterEel> EEL_SALTWATER = setup(create(EntitySaltwaterEel.class, EntitySaltwaterEel::new, "eel_saltwater").spawn(EntityClassification.WATER_CREATURE, 4, 1, 2).waterPlacement().egg(0xa5a5a5, 0x515168).size(1F, 1F).despawn().biomes(BiomeListBuilder.create().withTypes(Type.OCEAN).withoutTypes(Type.COLD).withoutBiomes(Biomes.DEEP_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN)::collect).variants("conger", "dragon", "morray", "ribbon", "snowflake"));

    /*
     * ##########################################################
     * 
     * ##########################################################
     */
        
    private static <T extends MobEntity> Builder<T> create(Class<T> EntityClass, Function<World, T> func, String entityNameIn) {
        return EntityTypeContainer.Builder.create(EntityClass, func, entityNameIn);
    }
    
    private static <T extends MobEntity> TameableBuilder<T> createTame(Class<T> EntityClass, Function<World, T> func, String entityNameIn) {
        return EntityTypeContainerTameable.TameableBuilder.create(EntityClass, func, entityNameIn);
    }

    @SuppressWarnings("unchecked")
    public static <T extends MobEntity>EntityTypeContainer<T> getEntityTypeContainer(String name) {
        return (EntityTypeContainer<T>) ENTITIES.get(name);
    }

    @SuppressWarnings("unchecked")
    public static <T extends MobEntity>EntityType<T> getEntityType(String name) {
        return (EntityType<T>) ENTITIES.get(name).entityType;
    }

    private static <T extends MobEntity> EntityTypeContainer<T> setup(EntityTypeContainer.Builder<T> builder) {
        EntityTypeContainer<T> c = builder.build();
        c.entityType = ModEntities.<T>createEntityType(c);
        ENTITIES.put(c.entityName, c);
        return c;
    }
    
    private static <T extends MobEntity> EntityTypeContainerTameable<T> setup(EntityTypeContainerTameable.TameableBuilder<T> builder) {
        EntityTypeContainerTameable<T> c = builder.build();
        c.entityType = ModEntities.<T>createEntityType(c);
        ENTITIES.put(c.entityName, c);
        return c;
    }
    
    private static Field type$serializable = null;

    public static <T extends MobEntity> EntityType<T> createEntityType(EntityTypeContainer<T> container) {
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
            BetterAnimalsPlusMod.logger.warn("Unable to set serializable for {}. This could result in possible saving issues with entities!", entityNameIn);
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

    public static void init() {
        
    }

}
