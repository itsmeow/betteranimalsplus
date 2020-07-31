package its_meow.betteranimalsplus.init;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import com.google.common.collect.Lists;

import dev.itsmeow.imdlib.IMDLib;
import dev.itsmeow.imdlib.entity.EntityRegistrarHandler;
import dev.itsmeow.imdlib.entity.util.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.util.EntityTypeContainer.CustomConfigurationHolder;
import dev.itsmeow.imdlib.entity.util.EntityVariant;
import dev.itsmeow.imdlib.entity.util.builder.IEntityBuilder;
import dev.itsmeow.imdlib.util.BiomeListBuilder;
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
import its_meow.betteranimalsplus.common.entity.EntityButterfly;
import its_meow.betteranimalsplus.common.entity.EntityCoyote;
import its_meow.betteranimalsplus.common.entity.EntityCrab;
import its_meow.betteranimalsplus.common.entity.EntityDeer;
import its_meow.betteranimalsplus.common.entity.EntityDragonfly;
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
import its_meow.betteranimalsplus.common.entity.EntityWalrus;
import its_meow.betteranimalsplus.common.entity.EntityWhale;
import its_meow.betteranimalsplus.common.entity.EntityZotzpyre;
import its_meow.betteranimalsplus.common.entity.miniboss.hirschgeist.EntityHirschgeist;
import its_meow.betteranimalsplus.common.entity.util.EntityTypeContainerBAP;
import its_meow.betteranimalsplus.common.entity.util.EntityTypeContainerBAP.Builder;
import its_meow.betteranimalsplus.common.entity.util.EntityTypeContainerBAPContainable;
import its_meow.betteranimalsplus.common.entity.util.EntityTypeContainerBAPTameable;
import its_meow.betteranimalsplus.common.entity.util.IContainable;
import its_meow.betteranimalsplus.common.item.IContainerItem;
import its_meow.betteranimalsplus.common.item.ItemModEntityContainer;
import its_meow.betteranimalsplus.common.item.ItemModFishBucket;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry.PlacementType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.ForgeConfigSpec;

public class ModEntities {

    public static final EntityRegistrarHandler H = IMDLib.entityHandler(Ref.MOD_ID);
    private static String MODID = Ref.MOD_ID;

    /*
     * ##########################################################
     * 
     * ##########################################################
     */

    public static final EntityTypeContainerBAP<EntityBear> BROWN_BEAR = setup(create(EntityBear.class, EntityBear::new, "brownbear").spawn(EntityClassification.CREATURE, 7, 1, 1).egg(0x4F2900, 0x8E500E).size(2F, 2F).biomes(Type.FOREST).head().singleton("1", "bear_brown").setModel(() -> ModelBearHead::new).done());
    public static final EntityTypeContainerBAP<EntityBearNeutral> BLACK_BEAR = setup(create(EntityBearNeutral.class, EntityBearNeutral::new, "blackbear").spawn(EntityClassification.CREATURE, 6, 1, 1).egg(0x000000, 0x333333).size(2F, 1.5F).biomes(Type.FOREST).variants("black", "kermode").head().mapToNames().setModel(() -> ModelBearHead::new).done());
    public static final EntityTypeContainerBAP<EntityDeer> DEER = setup(create(EntityDeer.class, EntityDeer::new, "deer").spawn(EntityClassification.CREATURE, 16, 1, 4).egg(0x8e510b, 0xc6863b).size(1.2F, 1.6F).biomes(Type.FOREST, Type.MAGICAL).variants(
    new EntityDeer.EntityDeerVariant("1"),
    new EntityDeer.EntityDeerVariant("2"),
    new EntityDeer.EntityDeerVariant("3"),
    new EntityDeer.EntityDeerVariant("4")).head().mapToNames().offset(-1.5F).setModel(() -> ModelDeerHead::new).done());
    public static final EntityTypeContainerBAPTameable<EntityLammergeier> LAMMERGEIER = setup(createTame(EntityLammergeier.class, EntityLammergeier::new, "lammergeier").spawn(EntityClassification.CREATURE, 7, 1, 2).egg(0xd8d8d8, 0xd82b11).size(0.75F, 0.5F).tameItems("minecraft:bone").biomes(Type.HILLS, Type.MOUNTAIN).variants("orange", "red", "white", "yellow"));
    public static final EntityTypeContainerBAPTameable<EntityFeralWolf> FERAL_WOLF = setup(createTame(EntityFeralWolf.class, EntityFeralWolf::new, "feralwolf").spawn(EntityClassification.CREATURE, 7, 1, 6).egg(0xbababa, 0x232323).size(1.35F, 1.5F).tameItems("minecraft:bone").biomes(Type.FOREST, Type.MAGICAL, Type.SPOOKY).variants("black", "snowy", "timber", "arctic", "brown", "red").head().mapToNames().allowFloor().setModel(() -> ModelFeralWolfHead::new).done());
    public static final EntityTypeContainerBAPTameable<EntityCoyote> COYOTE = setup(createTame(EntityCoyote.class, EntityCoyote::new, "coyote").spawn(EntityClassification.CREATURE, 5, 1, 6).egg(0x866a31, 0xb69762).size(0.8F, 0.9F).tameItems("minecraft:rabbit", "minecraft:chicken", "betteranimalsplus:pheasantraw", "minecraft:cooked_rabbit", "minecraft:cooked_chicken", "betteranimalsplus:pheasantcooked").biomes(Type.SANDY, Type.PLAINS).config(new CustomConfigurationHolder() {
        private ForgeConfigSpec.BooleanValue coyoteHostileDaytime;

        @Override
        public void customConfigurationInit(ForgeConfigSpec.Builder builder) {
            this.coyoteHostileDaytime = builder.comment("Makes coyote always hostile (removes ability to tame!)").worldRestart().define("coyoteHostileDaytime", false);
        }

        @Override
        public void customConfigurationLoad() {
            EntityCoyote.HOSTILE_DAYTIME = this.coyoteHostileDaytime.get();
        }
    }).head().allowFloor().singleton("1", "coyote_hostile").setModel(() -> ModelCoyoteHead::new).done());
    public static final EntityTypeContainerBAP<EntityTarantula> TARANTULA = setup(create(EntityTarantula.class, EntityTarantula::new, "tarantula").spawn(EntityClassification.MONSTER, 40, 1, 3).egg(0x1e1e1e, 0x8c0c0c).size(1.4F, 0.9F).despawn().biomes(Type.SANDY));
    public static final EntityTypeContainerBAP<EntityHirschgeist> HIRSCHGEIST = setup(create(EntityHirschgeist.class, EntityHirschgeist::new, "hirschgeist").spawn(EntityClassification.CREATURE, 2, 1, 1).egg(0xfffff, 0x00000).size(3F, 4F).biomes(Type.FOREST).head("hirschgeistskull").allowFloor().offset(-0.2F).singleton("1", "hirschgeist").setModel(() -> ModelHirschgeistSkull::new).done());
    public static final EntityTypeContainerBAP<EntityGoat> GOAT = setup(create(EntityGoat.class, EntityGoat::new, "goat").spawn(EntityClassification.CREATURE, 9, 1, 4).egg(0xffffff, 0xeeeeee).size(1.2F, 1.2F).biomes(Type.HILLS, Type.MOUNTAIN, Type.SAVANNA, Type.PLAINS, Type.FOREST).config(new CustomConfigurationHolder() {
        private ForgeConfigSpec.BooleanValue goatVanillaMilk;

        @Override
        public void customConfigurationInit(ForgeConfigSpec.Builder builder) {
            this.goatVanillaMilk = builder.comment("Enabling this will cause goats to give out vanilla milk instead of goat milk.").worldRestart().define("goatVanillaMilk", false);
        }

        @Override
        public void customConfigurationLoad() {
            EntityGoat.VANILLA_MILK = this.goatVanillaMilk.get();
        }
    }).variants(7));
    public static final EntityTypeContainerBAPContainable<EntityJellyfish, ItemModFishBucket<EntityJellyfish>> JELLYFISH = setup(createContainableB(EntityJellyfish.class, EntityJellyfish::new, "jellyfish").spawn(EntityClassification.WATER_CREATURE, 10, 1, 1).waterPlacement().egg(0x226fe2, 0xf2b3b3).size(0.8F, 0.8F).despawn().biomes(Type.OCEAN).variants("little_blue", "big_blue", "pink", "red_stripe", "green", "gray").containers(ItemModFishBucket.waterBucket(), c->Items.BUCKET, EntityJellyfish::bucketTooltip));
    public static final EntityTypeContainerBAP<EntityPheasant> PHEASANT = setup(create(EntityPheasant.class, EntityPheasant::new, "pheasant").spawn(EntityClassification.CREATURE, 12, 1, 3).egg(0x8e6b0b, 0xd8af3c).size(1F, 1F).biomes(Type.FOREST, Type.PLAINS, Type.SAVANNA).variants(2));
    public static final EntityTypeContainerBAP<EntityReindeer> REINDEER = setup(create(EntityReindeer.class, EntityReindeer::new, "reindeer").spawn(EntityClassification.CREATURE, 10, 1, 4).egg(0x8e510b, 0x017700).size(1.3964844F, 1.8F).biomes(BiomeListBuilder.create().withTypes(Type.SNOWY).withoutTypes(Type.OCEAN)::collect).variants(
    new EntityVariant(MODID, "1", "reindeer_1"),
    new EntityVariant(MODID, "2", "reindeer_2"),
    new EntityVariant(MODID, "3", "reindeer_3"),
    new EntityVariant(MODID, "4", "reindeer_4"),
    new EntityVariant(MODID, "1_christmas", "reindeer_1_christmas", false),
    new EntityVariant(MODID, "2_christmas", "reindeer_2_christmas", false),
    new EntityVariant(MODID, "3_christmas", "reindeer_3_christmas", false),
    new EntityVariant(MODID, "4_christmas", "reindeer_4_christmas", false)).head("reindeerhead").mapToNames().setModel(() -> ModelReindeerHead::new).done().clientConfig(new CustomConfigurationHolder() {
        private ForgeConfigSpec.BooleanValue createSnow;

        @Override
        public void customConfigurationInit(net.minecraftforge.common.ForgeConfigSpec.Builder builder) {
            this.createSnow = builder.comment("Set to false to disable snow particles around reindeer.").worldRestart().define("create_snow", true);
        }

        @Override
        public void customConfigurationLoad() {
            EntityReindeer.CREATE_SNOW = this.createSnow.get();
        }
    }));
    public static final EntityTypeContainerBAP<EntityBoar> BOAR = setup(create(EntityBoar.class, EntityBoar::new, "boar").spawn(EntityClassification.CREATURE, 9, 1, 4).egg(0x3d3c3b, 0xbca895).size(0.9F, 0.9F).biomes(Type.FOREST, Type.JUNGLE, Type.PLAINS, Type.SAVANNA).variants(4).head().mapToNames().setModel(() -> ModelBoarHead::new).done());
    public static final EntityTypeContainerBAP<EntitySquirrel> SQUIRREL = setup(create(EntitySquirrel.class, EntitySquirrel::new, "squirrel").spawn(EntityClassification.CREATURE, 8, 1, 3).egg(0x89806f, 0xb2a489).size(0.5F, 0.5F).biomes(Type.FOREST).variants("gray", "red", "albino"));
    public static final EntityTypeContainerBAP<EntitySongbird> SONGBIRD = setup(create(EntitySongbird.class, EntitySongbird::new, "songbird").spawn(EntityClassification.CREATURE, 11, 1, 4).egg(0x46f4d2, 0x7df442).size(0.5F, 0.5F).biomes(Type.FOREST, Type.PLAINS).variants("1", "2", "3", "4", "small_1", "small_2", "small_3", "small_4", "small_5", "small_6"));
    public static final EntityTypeContainerBAP<EntityBadger> BADGER = setup(create(EntityBadger.class, EntityBadger::new, "badger").spawn(EntityClassification.CREATURE, 7, 1, 2).egg(0x0c0c0c, 0xd3d3d3).size(0.8F, 0.8F).biomes(Type.FOREST, Type.PLAINS, Type.SAVANNA).variants("american", "european", "honey"));
    public static final EntityTypeContainerBAPContainable<EntityLamprey, ItemModFishBucket<EntityLamprey>> LAMPREY = setup(createContainableB(EntityLamprey.class, EntityLamprey::new, "lamprey").spawn(EntityClassification.WATER_CREATURE, 7, 1, 1).waterPlacement().egg(0x0000ad, 0x0a0a0a).size(1.0F, 0.7F).despawn().biomes(Type.RIVER, Type.SWAMP).variants("yellow", "spotted", "brown").containers(ItemModFishBucket.waterBucket(), c->Items.BUCKET));
    public static final EntityTypeContainerBAPContainable<EntityNautilus, ItemModFishBucket<EntityNautilus>> NAUTILUS = setup(createContainableB(EntityNautilus.class, EntityNautilus::new, "nautilus").spawn(EntityClassification.WATER_CREATURE, 4, 1, 1).waterPlacement().egg(0xFF9659, 0x241682).size(0.75F, 0.75F).despawn().biomes(Type.OCEAN).containers(ItemModFishBucket.waterBucket(), c->Items.BUCKET));
    public static final EntityTypeContainerBAP<EntityCrab> CRAB = setup(create(EntityCrab.class, EntityCrab::new, "crab").spawn(EntityClassification.CREATURE, 10, 1, 3).egg(0xe21d16, 0x2d0504).size(1F, 0.65F).biomes(Type.BEACH, Type.SWAMP).variants(4));
    public static final EntityTypeContainerBAP<EntityHorseshoeCrab> HORSESHOE_CRAB = setup(create(EntityHorseshoeCrab.class, EntityHorseshoeCrab::new, "horseshoecrab").spawn(EntityClassification.CREATURE, 8, 1, 3).egg(0xba1111, 0x520807).size(1F, 0.65F).biomes(Type.BEACH).variants(3));
    public static final EntityTypeContainerBAP<EntityShark> SHARK = setup(create(EntityShark.class, EntityShark::new, "shark").spawn(EntityClassification.WATER_CREATURE, 4, 1, 1).waterPlacement().egg(0x787878, 0xbdbdbd).size(2.5F, 1.2F).despawn().biomes(Type.OCEAN).variants("blue", "bull", "tiger", "whitetip", "greenland", "hammerhead", "goblin", "mako", "great_white"));
    public static final EntityTypeContainerBAP<EntityMoose> MOOSE = setup(create(EntityMoose.class, EntityMoose::new, "moose").spawn(EntityClassification.CREATURE, 8, 1, 1).egg(0x46351c, 0x97866e).size(2.25F, 3F).biomes(BiomeListBuilder.create().extra(Type.SWAMP).extra(Biomes.GIANT_SPRUCE_TAIGA, Biomes.GIANT_SPRUCE_TAIGA_HILLS, Biomes.GIANT_TREE_TAIGA, Biomes.GIANT_TREE_TAIGA_HILLS)::collect).variants(4).head().mapToNames().offset(-1.35F).setModel(() -> ModelMooseHead::new).done());
    public static final EntityTypeContainerBAP<EntityTurkey> TURKEY = setup(create(EntityTurkey.class, EntityTurkey::new, "turkey").spawn(EntityClassification.CREATURE, 11, 1, 3).egg(0x857445, 0x5099ba).size(1F, 1F).biomes(BiomeListBuilder.create().withTypes(Type.FOREST).withoutTypes(Type.SNOWY)::collect).variants(4));
    public static final EntityTypeContainerBAP<EntityZotzpyre> ZOTZPYRE = setup(create(EntityZotzpyre.class, EntityZotzpyre::new, "zotzpyre").spawn(EntityClassification.MONSTER, 30, 1, 1).defaultPlacement(EntityZotzpyre::canSpawn).egg(0x321e13, 0x543a28).size(1F, 1F).despawn().biomes(Type.FOREST, Type.JUNGLE, Type.BEACH, Type.CONIFEROUS, Type.LUSH, Type.WASTELAND, Type.SWAMP, Type.HILLS, Type.MOUNTAIN).variants(5));
    public static final EntityTypeContainerBAP<EntityBobbitWorm> BOBBIT_WORM = setup(create(EntityBobbitWorm.class, EntityBobbitWorm::new, "bobbit_worm").spawn(EntityClassification.WATER_CREATURE, 2, 1, 1).waterPlacement().egg(0xffe38f, 0x0f27bf).size(1F, 1F).despawn().biomes(Type.OCEAN).variants(2));
    public static final EntityTypeContainerBAP<EntityGoose> GOOSE = setup(create(EntityGoose.class, EntityGoose::new, "goose").spawn(EntityClassification.CREATURE, 15, 2, 5).placement(PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING, EntityGoose::canSpawn).egg(0xd3cfcf, 0x5e5752).size(1F, 1F).biomes(BiomeListBuilder.create().withTypes(Type.FOREST).withoutTypes(Type.DRY, Type.COLD, Type.HOT, Type.DENSE, Type.DEAD, Type.SPARSE, Type.OCEAN).extra(Type.RIVER)::collect).config(new CustomConfigurationHolder() {
        private ForgeConfigSpec.ConfigValue<List<? extends String>> pickupBlacklist;

        @Override
        public void customConfigurationInit(net.minecraftforge.common.ForgeConfigSpec.Builder builder) {
            this.pickupBlacklist = builder.comment("List of blacklisted item IDs that cannot be picked up. Accepts tags by prefixing them with '#'.").worldRestart().defineList("pickup_blacklist", Lists.asList("betteranimalsplus:goose_egg", new String[] { "betteranimalsplus:golden_goose_egg" }), (Predicate<Object>) input -> input instanceof String);
        }

        @Override
        public void customConfigurationLoad() {
            EntityGoose.pickupBlockList = pickupBlacklist.get().toArray(new String[0]);
        }
    }).variants(3));
    public static final EntityTypeContainerBAPContainable<EntityFreshwaterEel, ItemModFishBucket<EntityFreshwaterEel>> EEL_FRESHWATER = setup(createContainableB(EntityFreshwaterEel.class, EntityFreshwaterEel::new, "eel_freshwater").spawn(EntityClassification.WATER_CREATURE, 7, 1, 2).waterPlacement().egg(0x818077, 0x726c4f).size(1F, 1F).despawn().biomes(Type.RIVER, Type.SWAMP).variants("longfin", "silver").containers(ItemModFishBucket.waterBucket(), c->Items.BUCKET));
    public static final EntityTypeContainerBAPContainable<EntitySaltwaterEel, ItemModFishBucket<EntitySaltwaterEel>> EEL_SALTWATER = setup(createContainableB(EntitySaltwaterEel.class, EntitySaltwaterEel::new, "eel_saltwater").spawn(EntityClassification.WATER_CREATURE, 4, 1, 2).waterPlacement().egg(0xa5a5a5, 0x515168).size(1F, 1F).despawn().biomes(BiomeListBuilder.create().withTypes(Type.OCEAN).withoutTypes(Type.COLD).withoutBiomes(Biomes.DEEP_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN)::collect).variants("conger", "dragon", "moray", "ribbon", "snowflake").containers(ItemModFishBucket.waterBucket(), c->Items.BUCKET));
    public static final EntityTypeContainerBAP<EntityWhale> WHALE = setup(create(EntityWhale.class, EntityWhale::new, "whale").spawn(EntityClassification.WATER_CREATURE, 2, 1, 3).waterPlacement().egg(0x328da8, 0x001c4f).size(5F, 3F).despawn().biomes(Type.OCEAN).variants("beluga", "bottlenose", "cuviers", "false_killer", "narwhal", "pilot"));
    public static final EntityTypeContainerBAP<EntityWalrus> WALRUS = setup(create(EntityWalrus.class, EntityWalrus::new, "walrus").spawn(EntityClassification.CREATURE, 4, 1, 5).defaultPlacement(EntityWalrus::canSpawn).egg(0x854c03, 0x42300f).size(3F, 1.25F).biomes(BiomeListBuilder.create().extra(Biomes.FROZEN_OCEAN, Biomes.DEEP_FROZEN_OCEAN, Biomes.SNOWY_BEACH, Biomes.STONE_SHORE)::collect));
    public static final EntityTypeContainerBAPContainable<EntityButterfly, ItemModEntityContainer<EntityButterfly>> BUTTERFLY = setup(ModEntities.<EntityButterfly, ItemModEntityContainer<EntityButterfly>>createContainable(EntityButterfly.class, EntityButterfly::new, "butterfly")
    .spawn(EntityClassification.AMBIENT, 10, 1, 3)
    .egg(0x161d27, 0xb42d10)
    .size(0.35F, 0.35F)
    .despawn()
    .variants(
    "monarch",
    "morpho",
    "purple_emperor",
    "red_admiral",
    "sulphur",
    "swallowtail"
    )
    .biomes(BiomeListBuilder.create().withTypes(Type.FOREST, Type.JUNGLE, Type.MAGICAL).withoutTypes(Type.COLD)::collect)
    .containers(ItemModEntityContainer.get("bottled_%s"), c -> Items.GLASS_BOTTLE, EntityButterfly::bottleTooltip));
    public static final EntityTypeContainerBAPContainable<EntityDragonfly, ItemModEntityContainer<EntityDragonfly>> DRAGONFLY = setup(ModEntities.<EntityDragonfly, ItemModEntityContainer<EntityDragonfly>>createContainable(EntityDragonfly.class, EntityDragonfly::new, "dragonfly")
    .spawn(EntityClassification.AMBIENT, 10, 1, 3)
    .egg(0x40a605, 0x522601)
    .size(0.35F, 0.35F)
    .despawn()
    .variants(
    "blue_dasher",
    "broad_tailed_shadowdragon",
    "green_darner",
    "yellow_winged_darter"
    )
    .biomes(Type.SWAMP, Type.RIVER)
    .containers(ItemModEntityContainer.get("bottled_%s"), c -> Items.GLASS_BOTTLE, EntityDragonfly::bottleTooltip));

    /*
     * ##########################################################
     * 
     * ##########################################################
     */

    public static final LinkedHashMap<String, EntityTypeContainer<? extends MobEntity>> getEntities() {
        return H.ENTITIES;
    }

    private static <T extends MobEntity, C extends EntityTypeContainer<T>> C setup(IEntityBuilder<T, C, ?> builder) {
        return H.add(builder);
    }

    private static <T extends MobEntity> Builder<T> create(Class<T> EntityClass, Function<World, T> func, String entityNameIn) {
        return EntityTypeContainerBAP.Builder.create(EntityClass, func, entityNameIn);
    }

    private static <T extends TameableEntity> EntityTypeContainerBAPTameable.Builder<T> createTame(Class<T> EntityClass, Function<World, T> func, String entityNameIn) {
        return EntityTypeContainerBAPTameable.Builder.create(EntityClass, func, entityNameIn);
    }

    private static <T extends MobEntity & IContainable, I extends Item & IContainerItem<T>> EntityTypeContainerBAPContainable.Builder<T, I> createContainable(Class<T> EntityClass, Function<World, T> func, String entityNameIn) {
        return EntityTypeContainerBAPContainable.Builder.create(EntityClass, func, entityNameIn);
    }

    private static <T extends MobEntity & IContainable> EntityTypeContainerBAPContainable.Builder<T, ItemModFishBucket<T>> createContainableB(Class<T> EntityClass, Function<World, T> func, String entityNameIn) {
        return EntityTypeContainerBAPContainable.Builder.<T, ItemModFishBucket<T>>create(EntityClass, func, entityNameIn);
    }
}
