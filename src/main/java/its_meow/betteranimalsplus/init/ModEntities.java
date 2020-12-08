package its_meow.betteranimalsplus.init;

import com.google.common.collect.Lists;
import dev.itsmeow.imdlib.IMDLib;
import dev.itsmeow.imdlib.entity.EntityRegistrarHandler;
import dev.itsmeow.imdlib.entity.util.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.util.EntityTypeContainer.CustomConfigurationHolder;
import dev.itsmeow.imdlib.entity.util.EntityTypeContainerContainable;
import dev.itsmeow.imdlib.entity.util.EntityVariant;
import dev.itsmeow.imdlib.entity.util.IContainable;
import dev.itsmeow.imdlib.entity.util.builder.IEntityBuilder;
import dev.itsmeow.imdlib.item.IContainerItem;
import dev.itsmeow.imdlib.item.ItemModEntityContainer;
import dev.itsmeow.imdlib.item.ItemModFishBucket;
import dev.itsmeow.imdlib.util.BiomeListBuilder;
import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.client.model.*;
import its_meow.betteranimalsplus.common.entity.*;
import its_meow.betteranimalsplus.common.entity.util.EntityTypeContainerBAPTameable;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntityBAPSquid;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntityCrabLikeBase;
import its_meow.betteranimalsplus.util.OceanBiomeHelper;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry.PlacementType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class ModEntities {

    public static final EntityRegistrarHandler H = IMDLib.entityHandler(Ref.MOD_ID);
    private static final String MODID = Ref.MOD_ID;
    private static final ItemGroup G = BetterAnimalsPlusMod.group;

    /*
     * ##########################################################
     *
     * ##########################################################
     */

    public static final EntityTypeContainer<EntityBear> BROWN_BEAR = setup(create(EntityBear.class, EntityBear::new, "brownbear", () -> MobEntity.func_233666_p_()
    .createMutableAttribute(Attributes.MAX_HEALTH, 30.0D)
    .createMutableAttribute(Attributes.FOLLOW_RANGE, 20.0D)
    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3D)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE, 6.0D)
    .createMutableAttribute(Attributes.ATTACK_SPEED)
    .createMutableAttribute(Attributes.ATTACK_SPEED, 1D))
    .spawn(EntityClassification.CREATURE, 7, 1, 1)
    .defaultPlacement(MobEntity::canSpawnOn)
    .egg(0x4F2900, 0x8E500E)
    .size(2F, 2F)
    .biomes(Type.FOREST)
    .head().singleton("1", "bear_brown").setModel(() -> ModelBearHead::new).done());

    public static final EntityTypeContainer<EntityBearNeutral> BLACK_BEAR = setup(create(EntityBearNeutral.class, EntityBearNeutral::new, "blackbear", () -> MobEntity.func_233666_p_()
    .createMutableAttribute(Attributes.MAX_HEALTH, 30.0D)
    .createMutableAttribute(Attributes.FOLLOW_RANGE, 20.0D)
    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3D)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE, 6.0D)
    .createMutableAttribute(Attributes.ATTACK_SPEED)
    .createMutableAttribute(Attributes.ATTACK_SPEED, 1D))
    .spawn(EntityClassification.CREATURE, 6, 1, 1)
    .defaultPlacement(MobEntity::canSpawnOn)
    .egg(0x000000, 0x333333)
    .size(2F, 1.5F)
    .biomes(Type.FOREST)
    .variants("black", "kermode")
    .head().itemGroup(G).mapToNames().setModel(() -> ModelBearHead::new).done());

    public static final EntityTypeContainer<EntityDeer> DEER = setup(create(EntityDeer.class, EntityDeer::new, "deer", () -> MobEntity.func_233666_p_()
    .createMutableAttribute(Attributes.MAX_HEALTH, 15.0D)
    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.45D))
    .spawn(EntityClassification.CREATURE, 16, 1, 4)
    .defaultPlacement(MobEntity::canSpawnOn)
    .egg(0x8e510b, 0xc6863b)
    .size(1.2F, 1.6F)
    .biomes(Type.FOREST, Type.MAGICAL)
    .variants(EntityDeer.EntityDeerVariant::new, "1", "2", "3", "4")
    .head().itemGroup(G).mapToNames().offset(-1.5F).setModel(() -> ModelDeerHead::new).done());

    public static final EntityTypeContainerBAPTameable<EntityLammergeier> LAMMERGEIER = setup(createTame(EntityLammergeier.class, EntityLammergeier::new, "lammergeier", () -> MobEntity.func_233666_p_()
    .createMutableAttribute(Attributes.ATTACK_SPEED)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE)
    .createMutableAttribute(Attributes.FLYING_SPEED)
    .createMutableAttribute(Attributes.MAX_HEALTH, 6.0D)
    .createMutableAttribute(Attributes.FOLLOW_RANGE, 100.0D)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE, 2.0D)
    .createMutableAttribute(Attributes.ATTACK_SPEED, 1.0D)
    .createMutableAttribute(Attributes.FLYING_SPEED, 1.0D)
    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.4D))
    .spawn(EntityClassification.CREATURE, 7, 1, 2)
    .placement(PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING, null)
    .egg(0xd8d8d8, 0xd82b11)
    .size(0.75F, 0.5F)
    .tameItems("minecraft:bone")
    .biomes(Type.HILLS, Type.MOUNTAIN)
    .variants("orange", "red", "white", "yellow"));

    public static final EntityTypeContainerBAPTameable<EntityFeralWolf> FERAL_WOLF = setup(createTame(EntityFeralWolf.class, EntityFeralWolf::new, "feralwolf", () -> MobEntity.func_233666_p_()
    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3D)
    .createMutableAttribute(Attributes.MAX_HEALTH, 10.0D)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE, 5.0D))
    .spawn(EntityClassification.CREATURE, 7, 1, 6)
    .defaultPlacement(MobEntity::canSpawnOn)
    .egg(0xbababa, 0x232323)
    .size(1.35F, 1.5F)
    .tameItems("minecraft:bone")
    .biomes(Type.FOREST, Type.MAGICAL, Type.SPOOKY)
    .variants(EntityFeralWolf.WolfVariant::new, "black", "snowy", "timber", "arctic", "brown", "red")
    .head().itemGroup(G).mapToNames().allowFloor().setModel(() -> ModelFeralWolfHead::new).done());

    public static final EntityTypeContainerBAPTameable<EntityCoyote> COYOTE = setup(createTame(EntityCoyote.class, EntityCoyote::new, "coyote", () -> MobEntity.func_233666_p_()
    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3D)
    .createMutableAttribute(Attributes.MAX_HEALTH, 10.0D)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE, 5.0D))
    .spawn(EntityClassification.CREATURE, 5, 1, 6)
    .defaultPlacement(MobEntity::canSpawnOn)
    .egg(0x866a31, 0xb69762)
    .size(0.8F, 0.9F)
    .tameItems("minecraft:rabbit", "minecraft:chicken", "betteranimalsplus:pheasantraw", "minecraft:cooked_rabbit", "minecraft:cooked_chicken", "betteranimalsplus:pheasantcooked")
    .biomes(Type.SANDY, Type.PLAINS)
    .config(new CustomConfigurationHolder() {
        private ForgeConfigSpec.BooleanValue coyoteHostileDaytime;

        @Override
        public void customConfigurationInit(ForgeConfigSpec.Builder builder) {
            this.coyoteHostileDaytime = builder.comment("Makes coyote always hostile (removes ability to tame!)").worldRestart().define("coyoteHostileDaytime", false);
        }

        @Override
        public void customConfigurationLoad() {
            EntityCoyote.HOSTILE_DAYTIME = this.coyoteHostileDaytime.get();
        }
    }).head().itemGroup(G).allowFloor().singleton("1", "coyote_hostile").setModel(() -> ModelCoyoteHead::new).done());

    public static final EntityTypeContainer<EntityTarantula> TARANTULA = setup(create(EntityTarantula.class, EntityTarantula::new, "tarantula", SpiderEntity::func_234305_eI_)
    .spawn(EntityClassification.MONSTER, 40, 1, 3)
    .egg(0x1e1e1e, 0x8c0c0c)
    .size(1.4F, 0.9F)
    .defaultPlacement(MonsterEntity::canMonsterSpawnInLight)
    .despawn()
    .biomes(Type.SANDY));

    public static final EntityTypeContainer<EntityGoat> GOAT = setup(create(EntityGoat.class, EntityGoat::new, "goat", () -> MobEntity.func_233666_p_()
    .createMutableAttribute(Attributes.MAX_HEALTH, 14.0D)
    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.5D)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE, 0.8D))
    .spawn(EntityClassification.CREATURE, 9, 1, 4)
    .defaultPlacement(MobEntity::canSpawnOn)
    .egg(0xffffff, 0xeeeeee).size(1.2F, 1.2F)
    .biomes(Type.HILLS, Type.MOUNTAIN, Type.SAVANNA, Type.PLAINS, Type.FOREST)
    .config(new CustomConfigurationHolder() {
        private ForgeConfigSpec.BooleanValue goatVanillaMilk;

        @Override
        public void customConfigurationInit(ForgeConfigSpec.Builder builder) {
            this.goatVanillaMilk = builder.comment("Enabling this will cause goats to give out vanilla milk instead of goat milk.").worldRestart().define("goatVanillaMilk", false);
        }

        @Override
        public void customConfigurationLoad() {
            EntityGoat.VANILLA_MILK = this.goatVanillaMilk.get();
        }
    })
    .variants(7));

    public static final EntityTypeContainerContainable<EntityJellyfish, ItemModFishBucket<EntityJellyfish>> JELLYFISH = setup(createContainableB(EntityJellyfish.class, EntityJellyfish::new, "jellyfish", () -> MobEntity.func_233666_p_()
    .createMutableAttribute(Attributes.MAX_HEALTH, 10.0D))
    .spawn(EntityClassification.WATER_CREATURE, 10, 1, 1)
    .waterPlacement()
    .egg(0x226fe2, 0xf2b3b3)
    .size(0.8F, 0.8F)
    .despawn()
    .biomes(Type.OCEAN)
    .variants("little_blue", "big_blue", "pink", "red_stripe", "green", "gray")
    .containers(ItemModFishBucket.waterBucket(G), c->Items.BUCKET, EntityJellyfish::bucketTooltip));

    public static final EntityTypeContainer<EntityPheasant> PHEASANT = setup(create(EntityPheasant.class, EntityPheasant::new, "pheasant", () -> MobEntity.func_233666_p_()
    .createMutableAttribute(Attributes.MAX_HEALTH, 4.0D)
    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D))
    .spawn(EntityClassification.CREATURE, 12, 1, 3)
    .defaultPlacement(MobEntity::canSpawnOn)
    .egg(0x8e6b0b, 0xd8af3c)
    .size(1F, 1F)
    .biomes(Type.FOREST, Type.PLAINS, Type.SAVANNA)
    .variants(2));

    public static final EntityTypeContainer<EntityReindeer> REINDEER = setup(create(EntityReindeer.class, EntityReindeer::new, "reindeer", () -> MobEntity.func_233666_p_()
    .createMutableAttribute(Attributes.HORSE_JUMP_STRENGTH)
    .createMutableAttribute(Attributes.MAX_HEALTH, 53.0D)
    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.225D))
    .spawn(EntityClassification.CREATURE, 10, 1, 4)
    .defaultPlacement(MobEntity::canSpawnOn)
    .egg(0x8e510b, 0x017700).size(1.3964844F, 1.8F)
    .biomes(BiomeListBuilder.create().withTypes(Type.SNOWY).withoutTypes(Type.OCEAN)::collect)
    .variants(
    new EntityVariant(MODID, "1", "reindeer_1"),
    new EntityVariant(MODID, "2", "reindeer_2"),
    new EntityVariant(MODID, "3", "reindeer_3"),
    new EntityVariant(MODID, "4", "reindeer_4"),
    new EntityVariant(MODID, "1_christmas", "reindeer_1_christmas", false),
    new EntityVariant(MODID, "2_christmas", "reindeer_2_christmas", false),
    new EntityVariant(MODID, "3_christmas", "reindeer_3_christmas", false),
    new EntityVariant(MODID, "4_christmas", "reindeer_4_christmas", false))
    .head("reindeerhead").itemGroup(G).mapToNames().setModel(() -> ModelReindeerHead::new).done()
    .clientConfig(new CustomConfigurationHolder() {
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

    public static final EntityTypeContainer<EntityBoar> BOAR = setup(create(EntityBoar.class, EntityBoar::new, "boar", () -> MobEntity.func_233666_p_()
    .createMutableAttribute(Attributes.MAX_HEALTH, 12.0D)
    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.38D)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE, 3.5D))
    .spawn(EntityClassification.CREATURE, 9, 1, 4)
    .defaultPlacement(MobEntity::canSpawnOn)
    .egg(0x3d3c3b, 0xbca895).size(0.9F, 0.9F)
    .biomes(Type.FOREST, Type.JUNGLE, Type.PLAINS, Type.SAVANNA)
    .variants(4)
    .head().itemGroup(G).mapToNames().setModel(() -> ModelBoarHead::new).done());

    public static final EntityTypeContainer<EntitySquirrel> SQUIRREL = setup(create(EntitySquirrel.class, EntitySquirrel::new, "squirrel", () -> MobEntity.func_233666_p_()
    .createMutableAttribute(Attributes.MAX_HEALTH, 4.5D)
    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.5D))
    .spawn(EntityClassification.CREATURE, 8, 1, 3)
    .placement(PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING, EntitySquirrel::canSquirrelSpawn)
    .egg(0x89806f, 0xb2a489)
    .size(0.5F, 0.5F)
    .biomes(Type.FOREST)
    .variants("gray", "red", "albino"));

    public static final EntityTypeContainer<EntitySongbird> SONGBIRD = setup(create(EntitySongbird.class, EntitySongbird::new, "songbird", () -> MobEntity.func_233666_p_()
    .createMutableAttribute(Attributes.FLYING_SPEED)
    .createMutableAttribute(Attributes.MAX_HEALTH, 6.0D)
    .createMutableAttribute(Attributes.FLYING_SPEED, 0.4D)
    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.2D))
    .spawn(EntityClassification.CREATURE, 11, 1, 4)
    .placement(PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING, EntitySongbird::canSongbirdSpawn)
    .egg(0x46f4d2, 0x7df442)
    .size(0.5F, 0.5F)
    .biomes(Type.FOREST, Type.PLAINS)
    .variants("1", "2", "3", "4", "small_1", "small_2", "small_3", "small_4", "small_5", "small_6"));

    public static final EntityTypeContainer<EntityBadger> BADGER = setup(create(EntityBadger.class, EntityBadger::new, "badger", () -> MobEntity.func_233666_p_()
    .createMutableAttribute(Attributes.MAX_HEALTH, 12.0D)
    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.4D)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE, 2.5D))
    .spawn(EntityClassification.CREATURE, 7, 1, 2)
    .defaultPlacement(MobEntity::canSpawnOn)
    .egg(0x0c0c0c, 0xd3d3d3)
    .size(0.8F, 0.8F)
    .biomes(Type.FOREST, Type.PLAINS, Type.SAVANNA)
    .variants("american", "european", "honey"));

    public static final EntityTypeContainerContainable<EntityLamprey, ItemModFishBucket<EntityLamprey>> LAMPREY = setup(createContainableB(EntityLamprey.class, EntityLamprey::new, "lamprey", () -> MobEntity.func_233666_p_()
    .createMutableAttribute(Attributes.MAX_HEALTH, 3.0D)
    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.8D)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE, 0.5D))
    .spawn(EntityClassification.WATER_CREATURE, 7, 1, 1)
    .waterPlacement()
    .egg(0x0000ad, 0x0a0a0a)
    .size(1.0F, 0.7F)
    .despawn()
    .biomes(Type.RIVER, Type.SWAMP)
    .variants("yellow", "spotted", "brown")
    .containers(ItemModFishBucket.waterBucket(G), c->Items.BUCKET));

    public static final EntityTypeContainerContainable<EntityNautilus, ItemModFishBucket<EntityNautilus>> NAUTILUS = setup(createContainableB(EntityNautilus.class, EntityNautilus::new, "nautilus", () -> MobEntity.func_233666_p_()
    .createMutableAttribute(Attributes.MAX_HEALTH, 5.0D)
    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D))
    .spawn(EntityClassification.WATER_CREATURE, 4, 1, 1)
    .waterPlacement()
    .egg(0xFF9659, 0x241682)
    .size(0.75F, 0.75F)
    .despawn()
    .biomes(Type.OCEAN)
    .containers(ItemModFishBucket.waterBucket(G), c->Items.BUCKET));

    public static final EntityTypeContainer<EntityCrab> CRAB = setup(create(EntityCrab.class, EntityCrab::new, "crab", () -> MobEntity.func_233666_p_()
    .createMutableAttribute(Attributes.MAX_HEALTH, 6.5D)
    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3D)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE, 3D))
    .spawn(EntityClassification.CREATURE, 10, 1, 3)
    .placement(PlacementType.NO_RESTRICTIONS, Heightmap.Type.OCEAN_FLOOR, EntityCrabLikeBase::canCrabSpawn)
    .egg(0xe21d16, 0x2d0504)
    .size(1F, 0.65F)
    .biomes(Type.BEACH, Type.SWAMP)
    .variants(4));

    public static final EntityTypeContainer<EntityHorseshoeCrab> HORSESHOE_CRAB = setup(create(EntityHorseshoeCrab.class, EntityHorseshoeCrab::new, "horseshoecrab", () -> MobEntity.func_233666_p_()
    .createMutableAttribute(Attributes.MAX_HEALTH, 6.5D)
    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3D)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE, 3D))
    .spawn(EntityClassification.CREATURE, 8, 1, 3)
    .placement(PlacementType.NO_RESTRICTIONS, Heightmap.Type.OCEAN_FLOOR, EntityCrabLikeBase::canCrabSpawn)
    .egg(0xba1111, 0x520807)
    .size(1F, 0.65F)
    .biomes(Type.BEACH)
    .variants(3));

    public static final EntityTypeContainer<EntityShark> SHARK = setup(create(EntityShark.class, EntityShark::new, "shark", () -> MobEntity.func_233666_p_()
    .createMutableAttribute(Attributes.MAX_HEALTH, 30D)
    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 1.5D)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE, 6D))
    .spawn(EntityClassification.WATER_CREATURE, 4, 1, 1)
    .waterPlacement()
    .egg(0x787878, 0xbdbdbd)
    .size(2.5F, 1.2F)
    .despawn()
    .biomes(Type.OCEAN)
    .variants("blue", "bull", "tiger", "whitetip", "greenland", "hammerhead", "goblin", "mako", "great_white"));

    public static final EntityTypeContainer<EntityMoose> MOOSE = setup(create(EntityMoose.class, EntityMoose::new, "moose", () -> MobEntity.func_233666_p_()
    .createMutableAttribute(Attributes.MAX_HEALTH, 52.0D)
    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.6D)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE, 4.5D)
    .createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.7D))
    .spawn(EntityClassification.CREATURE, 8, 1, 1)
    .defaultPlacement(MobEntity::canSpawnOn)
    .egg(0x46351c, 0x97866e)
    .size(2.25F, 3F)
    .biomes(BiomeListBuilder.create()
    .extra(Type.SWAMP)
    .extra(Biomes.GIANT_SPRUCE_TAIGA, Biomes.GIANT_SPRUCE_TAIGA_HILLS, Biomes.GIANT_TREE_TAIGA, Biomes.GIANT_TREE_TAIGA_HILLS)::collect)
    .variants(4)
    .head().mapToNames().offset(-1.35F).setModel(() -> ModelMooseHead::new).done());

    public static final EntityTypeContainer<EntityTurkey> TURKEY = setup(create(EntityTurkey.class, EntityTurkey::new, "turkey", () -> MobEntity.func_233666_p_()
    .createMutableAttribute(Attributes.MAX_HEALTH, 6.5D)
    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE, 1D))
    .spawn(EntityClassification.CREATURE, 11, 1, 3)
    .egg(0x857445, 0x5099ba)
    .size(1F, 1F)
    .biomes(BiomeListBuilder.create().withTypes(Type.FOREST).withoutTypes(Type.SNOWY)::collect)
    .variants(4));

    public static final EntityTypeContainer<EntityBobbitWorm> BOBBIT_WORM = setup(create(EntityBobbitWorm.class, EntityBobbitWorm::new, "bobbit_worm", () -> MobEntity.func_233666_p_()
    .createMutableAttribute(Attributes.MAX_HEALTH, 15D)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE, 4D)
    .createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 10D))
    .spawn(EntityClassification.WATER_CREATURE, 2, 1, 1)
    .waterPlacement()
    .egg(0xffe38f, 0x0f27bf)
    .size(1F, 1F)
    .despawn()
    .biomes(Type.OCEAN)
    .variants(2));

    public static final EntityTypeContainer<EntityGoose> GOOSE = setup(create(EntityGoose.class, EntityGoose::new, "goose", () -> MobEntity.func_233666_p_()
    .createMutableAttribute(Attributes.MAX_HEALTH, 8D)
    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3D)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE, 3D))
    .spawn(EntityClassification.CREATURE, 15, 2, 5)
    .placement(PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING, EntityGoose::canGooseSpawn)
    .egg(0xd3cfcf, 0x5e5752)
    .size(1F, 1F)
    .biomes(BiomeListBuilder.create()
    .withTypes(Type.FOREST)
    .withoutTypes(Type.DRY, Type.COLD, Type.HOT, Type.DENSE, Type.DEAD, Type.SPARSE, Type.OCEAN)
    .extra(Type.RIVER)::collect)
    .config(new CustomConfigurationHolder() {
        private ForgeConfigSpec.ConfigValue<List<? extends String>> pickupBlacklist;

        @Override
        public void customConfigurationInit(net.minecraftforge.common.ForgeConfigSpec.Builder builder) {
            this.pickupBlacklist = builder.comment("List of blacklisted item IDs that cannot be picked up. Accepts tags by prefixing them with '#'.").worldRestart().defineList("pickup_blacklist", Lists.asList("betteranimalsplus:goose_egg", new String[] { "betteranimalsplus:golden_goose_egg" }), input -> input instanceof String);
        }

        @Override
        public void customConfigurationLoad() {
            EntityGoose.pickupBlockList = pickupBlacklist.get().toArray(new String[0]);
        }
    }).variants(3));

    public static final EntityTypeContainerContainable<EntityFreshwaterEel, ItemModFishBucket<EntityFreshwaterEel>> EEL_FRESHWATER = setup(createContainableB(EntityFreshwaterEel.class, EntityFreshwaterEel::new, "eel_freshwater", () -> MobEntity.func_233666_p_()
    .createMutableAttribute(Attributes.MAX_HEALTH, 5.0D)
    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 2D)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE, 2.5D))
    .spawn(EntityClassification.WATER_CREATURE, 7, 1, 2)
    .waterPlacement()
    .egg(0x818077, 0x726c4f)
    .size(1F, 1F)
    .despawn()
    .biomes(Type.RIVER, Type.SWAMP)
    .variants("longfin", "silver")
    .containers(ItemModFishBucket.waterBucket(G), c->Items.BUCKET));

    public static final EntityTypeContainerContainable<EntitySaltwaterEel, ItemModFishBucket<EntitySaltwaterEel>> EEL_SALTWATER = setup(createContainableB(EntitySaltwaterEel.class, EntitySaltwaterEel::new, "eel_saltwater", () -> MobEntity.func_233666_p_()
    .createMutableAttribute(Attributes.MAX_HEALTH, 5.0D)
    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 2D)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE, 2.5D))
    .spawn(EntityClassification.WATER_CREATURE, 4, 1, 2)
    .waterPlacement()
    .egg(0xa5a5a5, 0x515168)
    .size(1F, 1F)
    .despawn()
    .biomes(BiomeListBuilder.create()
    .withTypes(Type.OCEAN)
    .withoutTypes(Type.COLD)
    .withoutBiomes(Biomes.DEEP_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN)::collect)
    .variants("conger", "dragon", "moray", "ribbon", "snowflake")
    .containers(ItemModFishBucket.waterBucket(G), c->Items.BUCKET));

    public static final EntityTypeContainer<EntityWhale> WHALE = setup(create(EntityWhale.class, EntityWhale::new, "whale", () -> MobEntity.func_233666_p_()
    .createMutableAttribute(Attributes.MAX_HEALTH, 50D)
    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 2D)
    .createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 1D)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE, 8D))
    .spawn(EntityClassification.WATER_CREATURE, 2, 1, 3)
    .waterPlacement()
    .egg(0x328da8, 0x001c4f)
    .size(5F, 3F)
    .despawn()
    .biomes(Type.OCEAN)
    .variants("beluga", "bottlenose", "cuviers", "false_killer", "narwhal", "pilot"));

    public static final EntityTypeContainer<EntityWalrus> WALRUS = setup(create(EntityWalrus.class, EntityWalrus::new, "walrus", () -> MobEntity.func_233666_p_()
    .createMutableAttribute(Attributes.MAX_HEALTH, 30.0D)
    .createMutableAttribute(Attributes.ARMOR, 5D)
    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE, 4D)
    .createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 1D))
    .spawn(EntityClassification.CREATURE, 4, 1, 5)
    .defaultPlacement(EntityWalrus::canSpawn)
    .egg(0x854c03, 0x42300f)
    .size(3F, 1.25F)
    .biomes(BiomeListBuilder.create().extra(Biomes.FROZEN_OCEAN, Biomes.DEEP_FROZEN_OCEAN, Biomes.SNOWY_BEACH, Biomes.STONE_SHORE)::collect));

    public static final EntityTypeContainerContainable<EntityButterfly, ItemModEntityContainer<EntityButterfly>> BUTTERFLY = setup(ModEntities.<EntityButterfly, ItemModEntityContainer<EntityButterfly>>createContainable(EntityButterfly.class, EntityButterfly::new, "butterfly", () -> MobEntity.func_233666_p_()
    .createMutableAttribute(Attributes.MAX_HEALTH, 2.0D))
    .spawn(EntityClassification.AMBIENT, 10, 1, 3)
    .defaultPlacement((t, w, r, p, rng) -> p.getY() > w.getSeaLevel())
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
    .biomes(EntityButterfly::getSpawnBiomes)
    .containers(ItemModEntityContainer.get("bottled_%s", G), c -> Items.GLASS_BOTTLE, EntityButterfly::bottleTooltip));

    public static final EntityTypeContainerContainable<EntityDragonfly, ItemModEntityContainer<EntityDragonfly>> DRAGONFLY = setup(ModEntities.<EntityDragonfly, ItemModEntityContainer<EntityDragonfly>>createContainable(EntityDragonfly.class, EntityDragonfly::new, "dragonfly", () -> MobEntity.func_233666_p_()
    .createMutableAttribute(Attributes.MAX_HEALTH, 2.0D))
    .spawn(EntityClassification.AMBIENT, 10, 1, 3)
    .defaultPlacement((t, w, r, p, rng) -> p.getY() > w.getSeaLevel())
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
    .containers(ItemModEntityContainer.get("bottled_%s", G), c -> Items.GLASS_BOTTLE, EntityDragonfly::bottleTooltip));

    public static final EntityTypeContainerContainable<EntityBarracuda, ItemModFishBucket<EntityBarracuda>> BARRACUDA = setup(createContainableB(EntityBarracuda.class, EntityBarracuda::new, "barracuda", () -> MobEntity.func_233666_p_()
    .createMutableAttribute(Attributes.MAX_HEALTH, 10D)
    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 2D)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE, 2D))
    .spawn(EntityClassification.WATER_CREATURE, 8, 1, 1)
    .waterPlacement()
    .egg(0x575963, 0xCFCFCF)
    .size(1.5F, 1F)
    .despawn()
    .biomeKeys(OceanBiomeHelper::subtropicalOcean)
    .containers(ItemModFishBucket.waterBucket(G), c -> Items.BUCKET));

    public static final EntityTypeContainerContainable<EntityFlyingFish, ItemModFishBucket<EntityFlyingFish>> FLYING_FISH = setup(createContainableB(EntityFlyingFish.class, EntityFlyingFish::new, "flying_fish", () -> MobEntity.func_233666_p_()
    .createMutableAttribute(Attributes.MAX_HEALTH, 4D)
    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 1D))
    .spawn(EntityClassification.WATER_CREATURE, 10, 1, 5)
    .waterPlacement()
    .egg(0x0D3563, 0xEBC90E)
    .size(1F, 0.8F)
    .despawn()
    .variants("purple", "yellow")
    .biomeKeys(OceanBiomeHelper::subtropicalOcean)
    .containers(ItemModFishBucket.waterBucket(G), c -> Items.BUCKET));

    public static final EntityTypeContainer<EntityColossalSquid> SQUID_COLOSSAL = setup(create(EntityColossalSquid.class, EntityColossalSquid::new, "squid_colossal", () -> MobEntity.func_233666_p_()
    .createMutableAttribute(Attributes.MAX_HEALTH, 30D)
    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 1D)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE, 5D))
    .spawn(EntityClassification.WATER_CREATURE, 2, 1, 1)
    .waterPlacement(EntityBAPSquid::placement)
    .egg(0x8C354A, 0xFAD64A)
    .size(5F, 5F)
    .despawn()
    .biomeKeys(() -> OceanBiomeHelper.removeIf(biome -> !OceanBiomeHelper.isDeepOcean(biome))));

    public static final EntityTypeContainer<EntityGiantSquid> SQUID_GIANT = setup(create(EntityGiantSquid.class, EntityGiantSquid::new, "squid_giant", () -> MobEntity.func_233666_p_()
    .createMutableAttribute(Attributes.MAX_HEALTH, 30D)
    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 1D)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE, 5D))
    .spawn(EntityClassification.WATER_CREATURE, 4, 1, 1)
    .waterPlacement(EntityBAPSquid::placement)
    .egg(0x741921, 0xFAD64A)
    .size(3F, 3F)
    .despawn()
    .biomeKeys(() -> OceanBiomeHelper.removeIf(biome -> !OceanBiomeHelper.isDeepOcean(biome))));

    public static final EntityTypeContainerContainable<EntityPiranha, ItemModFishBucket<EntityPiranha>> PIRANHA = setup(createContainableB(EntityPiranha.class, EntityPiranha::new, "piranha", () -> MobEntity.func_233666_p_()
    .createMutableAttribute(Attributes.MAX_HEALTH, 5.0D)
    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 1D)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE, 4D))
    .spawn(EntityClassification.WATER_CREATURE, 7, 1, 5)
    .waterPlacement()
    .egg(0x545454, 0xB51B15)
    .size(0.5F, 0.5F)
    .despawn()
    .biomes(Type.JUNGLE)
    .containers(ItemModFishBucket.waterBucket(G), c -> Items.BUCKET));

    public static final EntityTypeContainer<EntityOctopus> OCTOPUS = setup(create(EntityOctopus.class, EntityOctopus::new, "octopus", () -> MobEntity.func_233666_p_()
    .createMutableAttribute(Attributes.MAX_HEALTH, 18D)
    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 1D)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE)
    .createMutableAttribute(Attributes.ATTACK_DAMAGE, 3D))
    .spawn(EntityClassification.WATER_CREATURE, 8, 1, 3)
    .waterPlacement()
    .egg(0xE09226, 0xA23420)
    .size(1F, 1F)
    .despawn()
    .variants("east_pacific_red", "common", "giant_pacific", "blue_ringed")
    .biomeKeys(() -> OceanBiomeHelper.returnIf(biome -> OceanBiomeHelper.isWarmOcean(biome) || OceanBiomeHelper.isLukewarmOcean(biome))));

    /*
     * ##########################################################
     * 
     * ##########################################################
     */

    public static LinkedHashMap<String, EntityTypeContainer<? extends MobEntity>> getEntities() {
        return H.ENTITIES;
    }

    private static <T extends MobEntity, C extends EntityTypeContainer<T>> C setup(IEntityBuilder<T, C, ?> builder) {
        return H.add(builder);
    }

    private static <T extends MobEntity> EntityTypeContainer.Builder<T> create(Class<T> EntityClass, Function<World, T> func, String entityNameIn, Supplier<AttributeModifierMap.MutableAttribute> attributeMap) {
        return EntityTypeContainer.Builder.create(EntityClass, func, entityNameIn, attributeMap, MODID);
    }

    private static <T extends TameableEntity> EntityTypeContainerBAPTameable.Builder<T> createTame(Class<T> EntityClass, Function<World, T> func, String entityNameIn, Supplier<AttributeModifierMap.MutableAttribute> attributeMap) {
        return EntityTypeContainerBAPTameable.Builder.create(EntityClass, func, entityNameIn, attributeMap, MODID);
    }

    private static <T extends MobEntity & IContainable, I extends Item & IContainerItem<T>> EntityTypeContainerContainable.Builder<T, I> createContainable(Class<T> EntityClass, Function<World, T> func, String entityNameIn, Supplier<AttributeModifierMap.MutableAttribute> attributeMap) {
        return EntityTypeContainerContainable.Builder.create(EntityClass, func, entityNameIn, attributeMap, MODID);
    }

    private static <T extends MobEntity & IContainable> EntityTypeContainerContainable.Builder<T, ItemModFishBucket<T>> createContainableB(Class<T> EntityClass, Function<World, T> func, String entityNameIn, Supplier<AttributeModifierMap.MutableAttribute> attributeMap) {
        return EntityTypeContainerContainable.Builder.create(EntityClass, func, entityNameIn, attributeMap, MODID);
    }

}
