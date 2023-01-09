package dev.itsmeow.betteranimalsplus.init;

import com.google.common.collect.Lists;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.itsmeow.betteranimalsplus.BetterAnimalsPlusMod;
import dev.itsmeow.betteranimalsplus.Ref;
import dev.itsmeow.betteranimalsplus.client.model.block.head.*;
import dev.itsmeow.betteranimalsplus.common.entity.*;
import dev.itsmeow.betteranimalsplus.common.entity.projectile.*;
import dev.itsmeow.betteranimalsplus.common.entity.util.EntityTypeContainerBAPTameable;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityBAPSquid;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityCrabLikeBase;
import dev.itsmeow.betteranimalsplus.util.EntityRegistrarHandlerBAP;
import dev.itsmeow.betteranimalsplus.util.OceanBiomeHelper;
import dev.itsmeow.imdlib.IMDLib;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.util.BiomeTypes;
import dev.itsmeow.imdlib.entity.util.EntityTypeContainerContainable;
import dev.itsmeow.imdlib.entity.util.variant.EntityVariant;
import dev.itsmeow.imdlib.item.ItemModEntityContainer;
import dev.itsmeow.imdlib.item.ItemModFishBucket;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;

import java.util.LinkedHashMap;
import java.util.List;

public class ModEntities {

    public static final EntityRegistrarHandlerBAP H = new EntityRegistrarHandlerBAP();
    private static final String MODID = Ref.MOD_ID;
    private static final CreativeModeTab G = BetterAnimalsPlusMod.TAB;
    public static final EntityTypeContainerBAPTameable<EntityLammergeier> LAMMERGEIER = H.addTame(EntityLammergeier.class, EntityLammergeier::new, "lammergeier", () -> Mob.createMobAttributes()
            .add(Attributes.ATTACK_SPEED)
            .add(Attributes.ATTACK_DAMAGE)
            .add(Attributes.FLYING_SPEED)
            .add(Attributes.MAX_HEALTH, 6.0D)
            .add(Attributes.FOLLOW_RANGE, 100.0D)
            .add(Attributes.ATTACK_DAMAGE, 2.0D)
            .add(Attributes.ATTACK_SPEED, 1.0D)
            .add(Attributes.FLYING_SPEED, 1.0D)
            .add(Attributes.MOVEMENT_SPEED, 0.4D), b -> b
            .spawn(MobCategory.CREATURE, 7, 1, 2)
            .placement(SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING, null)
            .egg(0xd8d8d8, 0xd82b11)
            .size(0.75F, 0.5F)
            .tameItems("minecraft:bone")
            .biomesOverworld(BiomeTypes.HILL, BiomeTypes.MOUNTAIN)
            .variants("orange", "red", "white", "yellow"));
    public static final EntityTypeContainer<EntityTarantula> TARANTULA = H.add(EntityTarantula.class, EntityTarantula::new, "tarantula", Spider::createAttributes, b -> b
            .spawn(MobCategory.MONSTER, 40, 1, 3)
            .egg(0x1e1e1e, 0x8c0c0c)
            .size(1.4F, 0.9F)
            .defaultPlacement(Monster::checkMonsterSpawnRules)
            .despawn()
            .biomesOverworld(BiomeTypes.SANDY, BiomeTypes.JUNGLE)
            .variants("desert_1", "desert_2", "desert_3", "jungle_1", "jungle_2", "jungle_3"));
    public static final EntityTypeContainer<EntityPheasant> PHEASANT = H.add(EntityPheasant.class, EntityPheasant::new, "pheasant", () -> Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 4.0D)
            .add(Attributes.MOVEMENT_SPEED, 0.25D), b -> b
            .spawn(MobCategory.CREATURE, 12, 1, 3)
            .defaultPlacement(Mob::checkMobSpawnRules)
            .egg(0x8e6b0b, 0xd8af3c)
            .size(1F, 1F)
            .biomesOverworld(BiomeTypes.FOREST, BiomeTypes.PLAINS, BiomeTypes.SAVANNA)
            .variants(2));
    public static final EntityTypeContainer<EntitySquirrel> SQUIRREL = H.add(EntitySquirrel.class, EntitySquirrel::new, "squirrel", () -> Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 4.5D)
            .add(Attributes.MOVEMENT_SPEED, 0.5D), b -> b
            .spawn(MobCategory.CREATURE, 8, 1, 3)
            .placement(SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, EntitySquirrel::canSquirrelSpawn)
            .egg(0x89806f, 0xb2a489)
            .size(0.5F, 0.5F)
            .biomesOverworld(BiomeTypes.FOREST)
            .variants("gray", "red", "albino"));
    public static final EntityTypeContainer<EntitySongbird> SONGBIRD = H.add(EntitySongbird.class, EntitySongbird::new, "songbird", () -> Mob.createMobAttributes()
            .add(Attributes.FLYING_SPEED)
            .add(Attributes.MAX_HEALTH, 6.0D)
            .add(Attributes.FLYING_SPEED, 0.4D)
            .add(Attributes.MOVEMENT_SPEED, 0.2D), b -> b
            .spawn(MobCategory.CREATURE, 11, 1, 4)
            .placement(SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, EntitySongbird::canSongbirdSpawn)
            .egg(0x46f4d2, 0x7df442)
            .size(0.5F, 0.5F)
            .biomesOverworld(BiomeTypes.FOREST, BiomeTypes.PLAINS)
            .variants("1", "2", "3", "4", "small_1", "small_2", "small_3", "small_4", "small_5", "small_6"));
    public static final EntityTypeContainer<EntityBadger> BADGER = H.add(EntityBadger.class, EntityBadger::new, "badger", () -> Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 12.0D)
            .add(Attributes.MOVEMENT_SPEED, 0.4D)
            .add(Attributes.ATTACK_DAMAGE)
            .add(Attributes.ATTACK_DAMAGE, 2.5D), b -> b
            .spawn(MobCategory.CREATURE, 7, 1, 2)
            .defaultPlacement(Mob::checkMobSpawnRules)
            .egg(0x0c0c0c, 0xd3d3d3)
            .size(0.8F, 0.8F)
            .biomesOverworld(BiomeTypes.FOREST, BiomeTypes.PLAINS, BiomeTypes.SAVANNA)
            .variants("american", "european", "honey"));
    public static final EntityTypeContainerContainable<EntityCrab, ItemModFishBucket<EntityCrab>> CRAB = H.addContainableB(EntityCrab.class, EntityCrab::new, "crab", () -> Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 6.5D)
            .add(Attributes.MOVEMENT_SPEED, 0.3D)
            .add(Attributes.ATTACK_DAMAGE)
            .add(Attributes.ATTACK_DAMAGE, 3D), b -> b
            .spawn(MobCategory.CREATURE, 10, 1, 3)
            .placement(SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.OCEAN_FLOOR, EntityCrabLikeBase::canCrabSpawn)
            .egg(0xe21d16, 0x2d0504)
            .size(1F, 0.65F)
            .biomesOverworld(BiomeTypes.BEACH, BiomeTypes.SWAMP)
            .variants("red", "pink", "brown", "blue")
            .containers("%s_bucket", ItemModFishBucket.waterBucket(G), "", c -> Items.WATER_BUCKET));
    public static final EntityTypeContainerContainable<EntityHorseshoeCrab, ItemModFishBucket<EntityHorseshoeCrab>> HORSESHOE_CRAB = H.addContainableB(EntityHorseshoeCrab.class, EntityHorseshoeCrab::new, "horseshoecrab", () -> Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 6.5D)
            .add(Attributes.MOVEMENT_SPEED, 0.3D)
            .add(Attributes.ATTACK_DAMAGE)
            .add(Attributes.ATTACK_DAMAGE, 3D), b -> b
            .spawn(MobCategory.CREATURE, 8, 1, 3)
            .placement(SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.OCEAN_FLOOR, EntityCrabLikeBase::canCrabSpawn)
            .egg(0xba1111, 0x520807)
            .size(1F, 0.65F)
            .biomesOverworld(BiomeTypes.BEACH)
            .variants("brown", "dark_brown", "green", "orange")
            .containers("%s_bucket", ItemModFishBucket.waterBucket(G), "", c -> Items.WATER_BUCKET));
    public static final EntityTypeContainer<EntityShark> SHARK = H.add(EntityShark.class, EntityShark::new, "shark", () -> Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 30D)
            .add(Attributes.MOVEMENT_SPEED, 1.5D)
            .add(Attributes.ATTACK_DAMAGE)
            .add(Attributes.ATTACK_DAMAGE, 6D), b -> b
            .spawn(MobCategory.WATER_CREATURE, 4, 1, 3)
            .waterPlacement()
            .egg(0x787878, 0xbdbdbd)
            .size(2.5F, 1.2F)
            .despawn()
            .biomesOverworld(BiomeTypes.OCEAN)
            .variants("blue", "bull", "tiger", "whitetip", "greenland", "hammerhead", "goblin", "mako", "great_white"));
    public static final EntityTypeContainer<EntityTurkey> TURKEY = H.add(EntityTurkey.class, EntityTurkey::new, "turkey", () -> Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 6.5D)
            .add(Attributes.MOVEMENT_SPEED, 0.25D)
            .add(Attributes.ATTACK_DAMAGE)
            .add(Attributes.ATTACK_DAMAGE, 1D), b -> b
            .spawn(MobCategory.CREATURE, 11, 1, 3)
            .egg(0x857445, 0x5099ba)
            .size(1F, 1F)
            .biomes(c -> c.withTypes(BiomeTypes.FOREST).withoutTypes(BiomeTypes.SNOWY).onlyOverworld())
            .variants(4));
    public static final EntityTypeContainer<EntityBobbitWorm> BOBBIT_WORM = H.add(EntityBobbitWorm.class, EntityBobbitWorm::new, "bobbit_worm", () -> Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 15D)
            .add(Attributes.ATTACK_DAMAGE)
            .add(Attributes.ATTACK_DAMAGE, 4D)
            .add(Attributes.KNOCKBACK_RESISTANCE, 10D), b -> b
            .spawn(MobCategory.WATER_AMBIENT, 2, 1, 1)
            .waterPlacement()
            .egg(0xffe38f, 0x0f27bf)
            .size(1F, 1F)
            .despawn()
            .biomesOverworld(BiomeTypes.OCEAN)
            .variants(2));
    public static final EntityTypeContainer<EntityGoose> GOOSE = H.add(EntityGoose.class, EntityGoose::new, "goose", () -> Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 8D)
            .add(Attributes.MOVEMENT_SPEED, 0.3D)
            .add(Attributes.ATTACK_DAMAGE)
            .add(Attributes.ATTACK_DAMAGE, 3D), b -> b
            .spawn(MobCategory.CREATURE, 15, 2, 5)
            .placement(SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING, EntityGoose::canGooseSpawn)
            .egg(0xd3cfcf, 0x5e5752)
            .size(1F, 1F)
            .biomes(c -> c
                    .withTypes(BiomeTypes.FOREST)
                    .withoutTypes(BiomeTypes.DRY, BiomeTypes.COLD, BiomeTypes.HOT, BiomeTypes.DENSE, BiomeTypes.DEAD, BiomeTypes.SPARSE, BiomeTypes.OCEAN)
                    .extra(BiomeTypes.RIVER).onlyOverworld())
            .config((holder, builder) -> holder.put("pickup_blacklist", List.class, builder.defineList("pickup_blacklist", "List of blacklisted item IDs that cannot be picked up. Accepts tags by prefixing them with '#'.", Lists.newArrayList("betteranimalsplus:goose_egg", "betteranimalsplus:golden_goose_egg"), "", input -> input instanceof String)))
            .variants(3));
    public static final EntityTypeContainer<EntityWhale> WHALE = H.add(EntityWhale.class, EntityWhale::new, "whale", () -> Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 50D)
            .add(Attributes.MOVEMENT_SPEED, 2D)
            .add(Attributes.KNOCKBACK_RESISTANCE, 1D)
            .add(Attributes.ATTACK_DAMAGE)
            .add(Attributes.ATTACK_DAMAGE, 8D), b -> b
            .spawn(MobCategory.WATER_CREATURE, 2, 1, 3)
            .waterPlacement()
            .egg(0x328da8, 0x001c4f)
            .size(5F, 2.7F)
            .despawn()
            .biomesOverworld(BiomeTypes.OCEAN)
            .variants("beluga", "bottlenose", "cuviers", "false_killer", "narwhal", "pilot", "sperm", "sperm_albino", "right", "blue"));
    public static final EntityTypeContainer<EntityWalrus> WALRUS = H.add(EntityWalrus.class, EntityWalrus::new, "walrus", () -> Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 30.0D)
            .add(Attributes.ARMOR, 5D)
            .add(Attributes.MOVEMENT_SPEED, 0.25D)
            .add(Attributes.ATTACK_DAMAGE)
            .add(Attributes.ATTACK_DAMAGE, 4D)
            .add(Attributes.KNOCKBACK_RESISTANCE, 1D), b -> b
            .spawn(MobCategory.CREATURE, 4, 1, 5)
            .defaultPlacement(EntityWalrus::canSpawn)
            .egg(0x854c03, 0x42300f)
            .size(3F, 1.25F)
            .biomes(c -> c.extra(Biomes.FROZEN_OCEAN, Biomes.DEEP_FROZEN_OCEAN, Biomes.SNOWY_BEACH, Biomes.STONY_SHORE)));
    public static final EntityTypeContainer<EntityColossalSquid> SQUID_COLOSSAL = H.add(EntityColossalSquid.class, EntityColossalSquid::new, "squid_colossal", () -> Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 30D)
            .add(Attributes.MOVEMENT_SPEED, 1D)
            .add(Attributes.ATTACK_DAMAGE)
            .add(Attributes.ATTACK_DAMAGE, 5D), b -> b
            .spawn(MobCategory.WATER_CREATURE, 1, 1, 1)
            .waterPlacement(EntityBAPSquid::placement)
            .egg(0x8C354A, 0xFAD64A)
            .size(5F, 5F)
            .despawn()
            .biomes(() -> OceanBiomeHelper.removeIf(biome -> !OceanBiomeHelper.isDeepOcean(biome))));
    public static final EntityTypeContainer<EntityGiantSquid> SQUID_GIANT = H.add(EntityGiantSquid.class, EntityGiantSquid::new, "squid_giant", () -> Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 30D)
            .add(Attributes.MOVEMENT_SPEED, 1D)
            .add(Attributes.ATTACK_DAMAGE)
            .add(Attributes.ATTACK_DAMAGE, 5D), b -> b
            .spawn(MobCategory.WATER_CREATURE, 1, 1, 1)
            .waterPlacement(EntityBAPSquid::placement)
            .egg(0x741921, 0xFAD64A)
            .size(3F, 3F)
            .despawn()
            .biomes(() -> OceanBiomeHelper.removeIf(biome -> !OceanBiomeHelper.isDeepOcean(biome))));
    public static final EntityTypeContainer<EntityOctopus> OCTOPUS = H.add(EntityOctopus.class, EntityOctopus::new, "octopus", () -> Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 18D)
            .add(Attributes.MOVEMENT_SPEED, 1D)
            .add(Attributes.ATTACK_DAMAGE)
            .add(Attributes.ATTACK_DAMAGE, 3D), b -> b
            .spawn(MobCategory.WATER_CREATURE, 5, 1, 3)
            .waterPlacement()
            .egg(0xE09226, 0xA23420)
            .size(1F, 1F)
            .despawn()
            .variants("east_pacific_red", "common", "giant_pacific", "blue_ringed")
            .biomes(() -> OceanBiomeHelper.returnIf(biome -> OceanBiomeHelper.isWarmOcean(biome) || OceanBiomeHelper.isLukewarmOcean(biome))));
    public static final EntityTypeContainer<EntityBear> BROWN_BEAR = H.add(EntityBear.class, EntityBear::new, "brownbear", () -> Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 30.0D)
            .add(Attributes.FOLLOW_RANGE, 20.0D)
            .add(Attributes.MOVEMENT_SPEED, 0.3D)
            .add(Attributes.ATTACK_DAMAGE)
            .add(Attributes.ATTACK_DAMAGE, 6.0D)
            .add(Attributes.ATTACK_SPEED)
            .add(Attributes.ATTACK_SPEED, 1D), b -> b
            .spawn(MobCategory.CREATURE, 7, 1, 1)
            .defaultPlacement(Mob::checkMobSpawnRules)
            .egg(0x4F2900, 0x8E500E)
            .size(2F, 2F)
            .biomesOverworld(BiomeTypes.FOREST)
            .head().itemGroup(G).singleton("1", "brownbear").setModel(() -> ModelBrownBearHead::new, "brown_bear_head").done());
    public static final EntityTypeContainer<EntityBearNeutral> BLACK_BEAR = H.add(EntityBearNeutral.class, EntityBearNeutral::new, "blackbear", () -> Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 30.0D)
            .add(Attributes.FOLLOW_RANGE, 20.0D)
            .add(Attributes.MOVEMENT_SPEED, 0.3D)
            .add(Attributes.ATTACK_DAMAGE)
            .add(Attributes.ATTACK_DAMAGE, 6.0D)
            .add(Attributes.ATTACK_SPEED)
            .add(Attributes.ATTACK_SPEED, 1D), b -> b
            .spawn(MobCategory.CREATURE, 6, 1, 1)
            .defaultPlacement(Mob::checkMobSpawnRules)
            .egg(0x000000, 0x333333)
            .size(2F, 1.5F)
            .biomesOverworld(BiomeTypes.FOREST)
            .variants(EntityBearNeutral.BlackBearVariant::new, "black", "kermode")
            .head().itemGroup(G).mapToNames().setModel(() -> ModelBlackBearHead::new, "black_bear_head").done());
    public static final EntityTypeContainer<EntityDeer> DEER = H.add(EntityDeer.class, EntityDeer::new, "deer", () -> Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 15.0D)
            .add(Attributes.MOVEMENT_SPEED, 0.45D), b -> b
            .spawn(MobCategory.CREATURE, 16, 1, 4)
            .defaultPlacement(Mob::checkMobSpawnRules)
            .egg(0x8e510b, 0xc6863b)
            .size(1.2F, 1.6F)
            .biomesOverworld(BiomeTypes.FOREST, BiomeTypes.MAGICAL)
            .variants(EntityDeer.EntityDeerVariant::new, "1", "2", "3", "4")
            .head().itemGroup(G).mapToNames().setModel(() -> ModelDeerHead::new, "deer_head").done());
    public static final EntityTypeContainerBAPTameable<EntityFeralWolf> FERAL_WOLF = H.addTame(EntityFeralWolf.class, EntityFeralWolf::new, "feralwolf", () -> Mob.createMobAttributes()
            .add(Attributes.MOVEMENT_SPEED, 0.3D)
            .add(Attributes.MAX_HEALTH, 10.0D)
            .add(Attributes.ATTACK_DAMAGE)
            .add(Attributes.ATTACK_DAMAGE, 5.0D), b -> b
            .spawn(MobCategory.CREATURE, 7, 1, 6)
            .defaultPlacement(Mob::checkMobSpawnRules)
            .egg(0xbababa, 0x232323)
            .size(1.35F, 1.5F)
            .tameItems("minecraft:bone")
            .biomesOverworld(BiomeTypes.FOREST, BiomeTypes.MAGICAL, BiomeTypes.SPOOKY)
            .variants(EntityFeralWolf.WolfVariant::new, "black", "snowy", "timber", "arctic", "brown", "red")
            .head().itemGroup(G).mapToNames().allowFloor().setModel(() -> ModelFeralWolfHead::new, "feral_wolf_head").done());
    public static final EntityTypeContainerBAPTameable<EntityCoyote> COYOTE = H.addTame(EntityCoyote.class, EntityCoyote::new, "coyote", () -> Mob.createMobAttributes()
            .add(Attributes.MOVEMENT_SPEED, 0.3D)
            .add(Attributes.MAX_HEALTH, 10.0D)
            .add(Attributes.ATTACK_DAMAGE)
            .add(Attributes.ATTACK_DAMAGE, 5.0D), b -> b
            .spawn(MobCategory.CREATURE, 5, 1, 6)
            .defaultPlacement(Mob::checkMobSpawnRules)
            .egg(0x866a31, 0xb69762)
            .size(0.8F, 0.9F)
            .tameItems("minecraft:rabbit", "minecraft:chicken", "betteranimalsplus:pheasantraw", "minecraft:cooked_rabbit", "minecraft:cooked_chicken", "betteranimalsplus:pheasantcooked")
            .biomesOverworld(BiomeTypes.SANDY, BiomeTypes.PLAINS)
            .config((holder, builder) -> holder.put(EntityCoyote.HOSTILE_DAYTIME_KEY, Boolean.class, builder.define(EntityCoyote.HOSTILE_DAYTIME_KEY, "Makes coyote always hostile (removes ability to tame!)", false))).head().itemGroup(G).allowFloor().singleton("1", "coyote_hostile").setModel(() -> ModelCoyoteHead::new, "coyote_head").done());
    public static final EntityTypeContainerContainable<EntityJellyfish, ItemModFishBucket<EntityJellyfish>> JELLYFISH = H.addContainableB(EntityJellyfish.class, EntityJellyfish::new, "jellyfish", () -> Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 10.0D), b -> b
            .spawn(MobCategory.WATER_AMBIENT, 10, 1, 5)
            .waterPlacement()
            .egg(0x226fe2, 0xf2b3b3)
            .size(0.8F, 0.8F)
            .despawn()
            .biomesOverworld(BiomeTypes.OCEAN)
            .variants("japanese_sea_nettle", "moon", "barrel", "white_spotted", "crown", "purple_striped")
            .containers("%s_bucket", ItemModFishBucket.waterBucket(G), "", c -> Items.WATER_BUCKET, EntityJellyfish::bucketTooltip));
    public static final EntityTypeContainer<EntityReindeer> REINDEER = H.add(EntityReindeer.class, EntityReindeer::new, "reindeer", () -> Mob.createMobAttributes()
            .add(Attributes.JUMP_STRENGTH)
            .add(Attributes.MAX_HEALTH, 53.0D)
            .add(Attributes.MOVEMENT_SPEED, 0.225D), b -> b
            .spawn(MobCategory.CREATURE, 10, 1, 4)
            .defaultPlacement(Mob::checkMobSpawnRules)
            .egg(0x8e510b, 0x017700).size(1.3964844F, 1.8F)
            .biomes(d -> d.withTypes(BiomeTypes.SNOWY).withoutTypes(BiomeTypes.OCEAN).onlyOverworld())
            .variants(
                    new EntityVariant(MODID, "1", "reindeer_1"),
                    new EntityVariant(MODID, "2", "reindeer_2"),
                    new EntityVariant(MODID, "3", "reindeer_3"),
                    new EntityVariant(MODID, "4", "reindeer_4"),
                    new EntityVariant(MODID, "1_christmas", "reindeer_1_christmas", false),
                    new EntityVariant(MODID, "2_christmas", "reindeer_2_christmas", false),
                    new EntityVariant(MODID, "3_christmas", "reindeer_3_christmas", false),
                    new EntityVariant(MODID, "4_christmas", "reindeer_4_christmas", false))
            .head("reindeerhead").itemGroup(G).mapToNames().setModel(() -> ModelReindeerHead::new, "reindeer_head").done()
            .clientConfig((holder, builder) -> holder.put("create_snow", Boolean.class, builder.define("create_snow", "Generates snow particles around reindeer.", true))));
    public static final EntityTypeContainer<EntityBoar> BOAR = H.add(EntityBoar.class, EntityBoar::new, "boar", () -> Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 12.0D)
            .add(Attributes.MOVEMENT_SPEED, 0.38D)
            .add(Attributes.ATTACK_DAMAGE)
            .add(Attributes.ATTACK_DAMAGE, 3.5D), b -> b
            .spawn(MobCategory.CREATURE, 9, 1, 4)
            .defaultPlacement(Mob::checkMobSpawnRules)
            .egg(0x3d3c3b, 0xbca895).size(0.9F, 0.9F)
            .biomesOverworld(BiomeTypes.FOREST, BiomeTypes.JUNGLE, BiomeTypes.PLAINS, BiomeTypes.SAVANNA)
            .variants("gray", "light_brown", "dark_brown")
            .config((holder, builder) -> {
                builder.push("nerf_options");
                holder.put("nerf_options/breed_from_kill", Boolean.class, builder.define("breed_from_kill", "Sets boars in breeding mode if they kill something", true));
                holder.put("nerf_options/breed_from_crops", Boolean.class, builder.define("breed_from_crops", "Sets boars in breeding mode if they eat crops or berries", true));
                holder.put("nerf_options/eat_crops", Boolean.class, builder.define("eat_crops", "Makes boars eat crops", true));
                holder.put("nerf_options/target_chance", Integer.class, builder.defineInRange("target_chance", "Chance out of 100 the boar will execute targeting AI: lower number = less common attacks", 100, 0, 100));
                builder.pop();
            })
            .head().itemGroup(G).mapToNames().setModel(() -> ModelBoarHead::new, "boar_head").done());
    public static final EntityTypeContainerContainable<EntityLamprey, ItemModFishBucket<EntityLamprey>> LAMPREY = H.addContainableB(EntityLamprey.class, EntityLamprey::new, "lamprey", () -> Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 3.0D)
            .add(Attributes.MOVEMENT_SPEED, 0.8D)
            .add(Attributes.ATTACK_DAMAGE)
            .add(Attributes.ATTACK_DAMAGE, 0.5D), b -> b
            .spawn(MobCategory.WATER_AMBIENT, 7, 1, 3)
            .waterPlacement()
            .egg(0x0000ad, 0x0a0a0a)
            .size(1.0F, 0.7F)
            .despawn()
            .biomesOverworld(BiomeTypes.RIVER, BiomeTypes.SWAMP)
            .variants("yellow", "spotted", "brown")
            .containers("%s_bucket", ItemModFishBucket.waterBucket(G), "", c -> Items.WATER_BUCKET));
    public static final EntityTypeContainerContainable<EntityNautilus, ItemModFishBucket<EntityNautilus>> NAUTILUS = H.addContainableB(EntityNautilus.class, EntityNautilus::new, "nautilus", () -> Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 5.0D)
            .add(Attributes.MOVEMENT_SPEED, 0.25D), b -> b
            .spawn(MobCategory.WATER_AMBIENT, 2, 1, 1)
            .waterPlacement()
            .egg(0xFF9659, 0x241682)
            .size(0.75F, 0.75F)
            .despawn()
            .biomesOverworld(BiomeTypes.OCEAN)
            .containers("%s_bucket", ItemModFishBucket.waterBucket(G), "", c -> Items.WATER_BUCKET));
    public static final EntityTypeContainer<EntityMoose> MOOSE = H.add(EntityMoose.class, EntityMoose::new, "moose", () -> Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 52.0D)
            .add(Attributes.MOVEMENT_SPEED, 0.6D)
            .add(Attributes.ATTACK_DAMAGE)
            .add(Attributes.ATTACK_DAMAGE, 4.5D)
            .add(Attributes.KNOCKBACK_RESISTANCE, 0.7D), b -> b
            .spawn(MobCategory.CREATURE, 8, 1, 1)
            .defaultPlacement(Mob::checkMobSpawnRules)
            .egg(0x46351c, 0x97866e)
            .size(2.25F, 3F)
            .biomes(c -> c
                    .extra(BiomeTypes.SWAMP)
                    .extra(Biomes.OLD_GROWTH_SPRUCE_TAIGA, Biomes.OLD_GROWTH_PINE_TAIGA))
            .variants(4)
            .head().itemGroup(G).mapToNames().setModel(() -> ModelMooseHead::new, "moose_head").done());
    public static final EntityTypeContainerContainable<EntityFreshwaterEel, ItemModFishBucket<EntityFreshwaterEel>> EEL_FRESHWATER = H.addContainableB(EntityFreshwaterEel.class, EntityFreshwaterEel::new, "eel_freshwater", () -> Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 5.0D)
            .add(Attributes.MOVEMENT_SPEED, 2D)
            .add(Attributes.ATTACK_DAMAGE)
            .add(Attributes.ATTACK_DAMAGE, 2.5D), b -> b
            .spawn(MobCategory.WATER_AMBIENT, 7, 1, 3)
            .waterPlacement()
            .egg(0x818077, 0x726c4f)
            .size(1F, 1F)
            .despawn()
            .biomesOverworld(BiomeTypes.RIVER, BiomeTypes.SWAMP)
            .variants("longfin", "silver")
            .containers("%s_bucket", ItemModFishBucket.waterBucket(G), "", c -> Items.WATER_BUCKET));
    public static final EntityTypeContainerContainable<EntitySaltwaterEel, ItemModFishBucket<EntitySaltwaterEel>> EEL_SALTWATER = H.addContainableB(EntitySaltwaterEel.class, EntitySaltwaterEel::new, "eel_saltwater", () -> Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 5.0D)
            .add(Attributes.MOVEMENT_SPEED, 2D)
            .add(Attributes.ATTACK_DAMAGE)
            .add(Attributes.ATTACK_DAMAGE, 2.5D), b -> b
            .spawn(MobCategory.WATER_AMBIENT, 4, 1, 3)
            .waterPlacement()
            .egg(0xa5a5a5, 0x515168)
            .size(1F, 1F)
            .despawn()
            .biomes(c -> c
                    .withTypes(BiomeTypes.OCEAN)
                    .withoutTypes(BiomeTypes.COLD)
                    .withoutBiomes(Biomes.DEEP_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN)
                    .onlyOverworld())
            .variants("conger", "dragon", "moray", "ribbon", "snowflake")
            .containers("%s_bucket", ItemModFishBucket.waterBucket(G), "", c -> Items.WATER_BUCKET));
    public static final EntityTypeContainerContainable<EntityButterfly, ItemModEntityContainer<EntityButterfly>> BUTTERFLY = H.addContainable(EntityButterfly.class, EntityButterfly::new, "butterfly", () -> Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 2.0D), b -> b
            .spawn(MobCategory.AMBIENT, 10, 1, 3)
            .placement(SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING, (t, w, r, p, rng) -> p.getY() > w.getSeaLevel() && w.getBlockState(p).isAir() && (w.getBlockState(p.below()).is(BlockTags.LEAVES) || w.getBlockState(p.below()).getBlock() == Blocks.GRASS_BLOCK))
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
            .containers("bottled_%s", ItemModEntityContainer.get(G), "", c -> Items.GLASS_BOTTLE, EntityButterfly::bottleTooltip));
    public static final EntityTypeContainerContainable<EntityDragonfly, ItemModEntityContainer<EntityDragonfly>> DRAGONFLY = H.addContainable(EntityDragonfly.class, EntityDragonfly::new, "dragonfly", () -> Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 2.0D), b -> b
            .spawn(MobCategory.AMBIENT, 10, 1, 3)
            .placement(SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING, (t, w, r, p, rng) -> p.getY() > w.getSeaLevel() && w.getBlockState(p).isAir() && (w.getBlockState(p.below()).is(BlockTags.LEAVES) || w.getBlockState(p.below()).getBlock() == Blocks.GRASS_BLOCK))
            .egg(0x40a605, 0x522601)
            .size(0.35F, 0.35F)
            .despawn()
            .variants(
                    "blue_dasher",
                    "broad_tailed_shadowdragon",
                    "green_darner",
                    "yellow_winged_darter"
            )
            .biomesOverworld(BiomeTypes.SWAMP, BiomeTypes.RIVER)
            .containers("bottled_%s", ItemModEntityContainer.get(G), "", c -> Items.GLASS_BOTTLE, EntityDragonfly::bottleTooltip));
    public static final EntityTypeContainerContainable<EntityBarracuda, ItemModFishBucket<EntityBarracuda>> BARRACUDA = H.addContainableB(EntityBarracuda.class, EntityBarracuda::new, "barracuda", () -> Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 10D)
            .add(Attributes.MOVEMENT_SPEED, 2D)
            .add(Attributes.ATTACK_DAMAGE)
            .add(Attributes.ATTACK_DAMAGE, 2D), b -> b
            .spawn(MobCategory.WATER_AMBIENT, 3, 1, 1)
            .waterPlacement()
            .egg(0x575963, 0xCFCFCF)
            .size(1.5F, 1F)
            .despawn()
            .biomes(OceanBiomeHelper::subtropicalOcean)
            .containers("%s_bucket", ItemModFishBucket.waterBucket(G), "", c -> Items.WATER_BUCKET));
    public static final EntityTypeContainerContainable<EntityFlyingFish, ItemModFishBucket<EntityFlyingFish>> FLYING_FISH = H.addContainableB(EntityFlyingFish.class, EntityFlyingFish::new, "flying_fish", () -> Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 4D)
            .add(Attributes.MOVEMENT_SPEED, 1D), b -> b
            .spawn(MobCategory.WATER_AMBIENT, 10, 1, 5)
            .waterPlacement()
            .egg(0x0D3563, 0xEBC90E)
            .size(1F, 0.8F)
            .despawn()
            .variants("purple", "yellow")
            .biomes(OceanBiomeHelper::subtropicalOcean)
            .containers("%s_bucket", ItemModFishBucket.waterBucket(G), "", c -> Items.WATER_BUCKET));
    public static final EntityTypeContainerContainable<EntityPiranha, ItemModFishBucket<EntityPiranha>> PIRANHA = H.addContainableB(EntityPiranha.class, EntityPiranha::new, "piranha", () -> Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 5.0D)
            .add(Attributes.MOVEMENT_SPEED, 1D)
            .add(Attributes.ATTACK_DAMAGE)
            .add(Attributes.ATTACK_DAMAGE, 4D), b -> b
            .spawn(MobCategory.WATER_AMBIENT, 7, 1, 5)
            .waterPlacement()
            .egg(0x545454, 0xB51B15)
            .size(0.5F, 0.5F)
            .despawn()
            .biomesOverworld(BiomeTypes.JUNGLE)
            .containers("%s_bucket", ItemModFishBucket.waterBucket(G), "", c -> Items.WATER_BUCKET));

    public static LinkedHashMap<String, EntityTypeContainer<? extends Mob>> getEntities() {
        return H.ENTITIES;
    }

    public static final RegistrySupplier<EntityType<EntityBadgerDirt>> PROJECTILE_BADGER_DIRT = projectile(EntityBadgerDirt::new, "badgerdirt", 1.2F, 1.2F);
    public static final RegistrySupplier<EntityType<EntityGoldenGooseEgg>> PROJECTILE_GOLDEN_GOOSE_EGG = projectile(EntityGoldenGooseEgg::new, "golden_goose_egg", 0.25F, 0.25F);
    public static final RegistrySupplier<EntityType<EntityGooseEgg>> PROJECTILE_GOOSE_EGG = projectile(EntityGooseEgg::new, "goose_egg", 0.25F, 0.25F);
    public static final RegistrySupplier<EntityType<EntityPheasantEgg>> PROJECTILE_PHEASANT_EGG = projectile(EntityPheasantEgg::new, "pheasant_egg", 0.25F, 0.25F);
    public static final RegistrySupplier<EntityType<EntityTurkeyEgg>> PROJECTILE_TURKEY_EGG = projectile(EntityTurkeyEgg::new, "turkey_egg", 0.25F, 0.25F);
    public static final RegistrySupplier<EntityType<EntityTarantulaHair>> PROJECTILE_TARANTULA_HAIR = projectile(EntityTarantulaHair::new, "tarantulahair", 0.5F, 0.5F);

    public static void init() {
        H.init();
    }

    private static <T extends Projectile> RegistrySupplier<EntityType<T>> projectile(EntityType.EntityFactory<T> factory, String name, float width, float height) {
        return IMDLib.getRegistry(Registry.ENTITY_TYPE_REGISTRY).register(new ResourceLocation(MODID, name), () -> H.createEntityType(factory, name, MobCategory.MISC, 64, 1, true, width, height));
    }
}