package its_meow.betteranimalsplus.common.entity.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import its_meow.betteranimalsplus.common.item.ItemModFishBucket;
import its_meow.betteranimalsplus.common.item.ItemModFishBucket.IBucketTooltipFunction;
import its_meow.betteranimalsplus.util.HeadType;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.ForgeConfigSpec;

public class EntityTypeContainer<T extends MobEntity> {
    
    public EntityType<T> entityType;
    public SpawnEggItem egg;

    public final Class<T> entityClass;
    public final String entityName;
    public final EntityClassification spawnType;
    public final Function<World, T> factory;
    public final int eggColorSolid;
    public final int eggColorSpot;
    public int spawnWeight;
    public int spawnMinGroup;
    public int spawnMaxGroup;
    public boolean doSpawning = true;
    public final float width;
    public final float height;
    public boolean despawn;
    public final EntitySpawnPlacementRegistry.PlacementType placementType;
    public final Heightmap.Type heightMapType;
    public final EntitySpawnPlacementRegistry.IPlacementPredicate<T> placementPredicate;
    protected boolean placementRegistered = false;

    protected Biome[] spawnBiomes;

    protected EntityConfiguration config;

    protected final CustomConfigurationHolder customConfig;
    protected final CustomConfigurationHolder customClientConfig;

    protected Supplier<Set<Biome>> defaultBiomeSupplier;

    protected EntityVariantList variantList;
    protected int variantMax;
    protected DataParameter<String> variantDataKey;
    protected DataParameter<Boolean> fromBucketDataKey;
    protected ItemModFishBucket<T> bucket;

    protected HeadType headType;

    protected EntityTypeContainer(Class<T> EntityClass, Function<World, T> func, String entityNameIn, EntityClassification type, int solidColorIn, int spotColorIn, int prob, int min, int max, float width, float height, boolean despawn, int variantMax, IVariant[] variants, @Nullable CustomConfigurationHolder customConfig, @Nullable CustomConfigurationHolder customClientConfig, Supplier<Set<Biome>> biomes, EntitySpawnPlacementRegistry.PlacementType placementType, Heightmap.Type heightMapType, EntitySpawnPlacementRegistry.IPlacementPredicate<T> placementPredicate, boolean hasBucket, IBucketTooltipFunction bucketTooltip) {
        this.entityClass = EntityClass;
        this.factory = func;
        this.entityName = entityNameIn;
        this.eggColorSolid = solidColorIn;
        this.eggColorSpot = spotColorIn;
        this.spawnWeight = prob;
        this.spawnMinGroup = min;
        this.spawnMaxGroup = max;
        this.spawnType = type;
        this.width = width;
        this.height = height;
        this.despawn = despawn;
        this.customConfig = customConfig;
        this.customClientConfig = customClientConfig;
        this.defaultBiomeSupplier = biomes;
        this.placementType = placementType;
        this.heightMapType = heightMapType;
        this.placementPredicate = placementPredicate;
        this.variantMax = variantMax;
        if(this.hasVariants()) {
            variantList = new EntityVariantList(variantMax);
            variantList.add(variants);
        }
        if(hasBucket) {
            this.bucket = new ItemModFishBucket<T>(this, () -> Fluids.WATER, bucketTooltip);
        }
    }

    public static class Builder<T extends MobEntity> {
        protected final Class<T> entityClass;
        protected final String entityName;
        protected final Function<World, T> factory;
        protected EntityClassification spawnType;
        protected int eggColorSolid;
        protected int eggColorSpot;
        protected int spawnWeight;
        protected int spawnMinGroup;
        protected int spawnMaxGroup;
        protected float width;
        protected float height;
        protected boolean despawn;
        protected CustomConfigurationHolder customConfig;
        protected CustomConfigurationHolder customClientConfig;
        protected Supplier<Set<Biome>> defaultBiomeSupplier;
        protected EntitySpawnPlacementRegistry.PlacementType placementType;
        protected Heightmap.Type heightMapType;
        protected EntitySpawnPlacementRegistry.IPlacementPredicate<T> placementPredicate;
        protected int variantCount = 0;
        protected IVariant[] variants;
        protected HeadType.Builder headTypeBuilder;
        protected boolean hasBucket;
        protected IBucketTooltipFunction bucketTooltip;
        protected IBucketTooltipFunction bucketTooltipFinal;

        protected Builder(Class<T> EntityClass, Function<World, T> func, String entityNameIn) {
            this.entityClass = EntityClass;
            this.factory = func;
            this.entityName = entityNameIn;
            this.eggColorSolid = 0x000000;
            this.eggColorSpot = 0xffffff;
            this.spawnWeight = 1;
            this.spawnMinGroup = 1;
            this.spawnMaxGroup = 1;
            this.spawnType = EntityClassification.CREATURE;
            this.width = 1;
            this.height = 1;
            this.despawn = false;
            this.customConfig = null;
            this.defaultBiomeSupplier = () -> new HashSet<Biome>();
            this.placementType = null;
            this.heightMapType = null;
            this.placementPredicate = null;
            this.hasBucket = false;
        }

        public Builder<T> spawn(EntityClassification type, int weight, int min, int max) {
            this.spawnType = type;
            this.spawnWeight = weight;
            this.spawnMinGroup = min;
            this.spawnMaxGroup = max;
            return this;
        }

        public Builder<T> egg(int solid, int spot) {
            this.eggColorSolid = solid;
            this.eggColorSpot = spot;
            return this;
        }

        public Builder<T> size(float width, float height) {
            this.width = width;
            this.height = height;
            return this;
        }

        public Builder<T> despawn() {
            this.despawn = true;
            return this;
        }

        public Builder<T> config(CustomConfigurationHolder config) {
            this.customConfig = config;
            return this;
        }
        
        public Builder<T> clientConfig(CustomConfigurationHolder config) {
            this.customClientConfig = config;
            return this;
        }

        public Builder<T> placement(EntitySpawnPlacementRegistry.PlacementType type, Heightmap.Type heightMap, EntitySpawnPlacementRegistry.IPlacementPredicate<T> predicate) {
            this.placementType = type;
            this.heightMapType = heightMap;
            this.placementPredicate = predicate;
            return this;
        }

        public Builder<T> defaultPlacement(EntitySpawnPlacementRegistry.IPlacementPredicate<T> predicate) {
            return placement(EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, predicate);
        }

        public Builder<T> waterPlacement() {
            return placement(EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityTypeContainer::waterSpawn);
        }

        public Builder<T> waterPlacement(EntitySpawnPlacementRegistry.IPlacementPredicate<T> predicate) {
            return placement(EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, predicate);
        }

        public Builder<T> biomes(BiomeDictionary.Type... biomeTypes) {
            this.defaultBiomeSupplier = toBiomes(biomeTypes);
            return this;
        }

        public Builder<T> biomes(Supplier<Biome[]> biomes) {
            this.defaultBiomeSupplier = toBiomes(biomes);
            return this;
        }

        public Builder<T> variants(IVariant... variants) {
            this.variantCount = variants.length;
            this.variants = variants;
            return this;
        }

        public Builder<T> variants(String... nameTextures) {
            this.variantCount = nameTextures.length;
            this.variants = new EntityVariant[nameTextures.length];
            for(int i = 0; i < nameTextures.length; i++) {
                String nameTex = nameTextures[i];
                variants[i] = new EntityVariant(nameTex, this.entityName + "_" + nameTex);
            }
            return this;
        }

        public Builder<T> variants(int max) {
            if(max > 0) {
                this.variantCount = max;
                this.variants = new EntityVariant[max];
                for(int i = 0; i < max; i++) {
                    String nameTex = String.valueOf(i + 1);
                    variants[i] = new EntityVariant(nameTex, this.entityName + "_" + nameTex);
                }
            } else {
                throw new RuntimeException("what are you doing kid");
            }
            return this;
        }

        public ContainerHeadBuilder<T> head(String headName) {
            return new ContainerHeadBuilder<T>(headName, this);
        }

        public ContainerHeadBuilder<T> head() {
            return head(this.entityName + "head");
        }

        public Builder<T> bucketable() {
            this.hasBucket = true;
            return this;
        }
        
        public Builder<T> bucketable(IBucketTooltipFunction tooltip) {
            this.hasBucket = true;
            this.bucketTooltip = tooltip;
            return this;
        }

        protected void preBuild() {
            if(this.hasBucket && variantCount > 0) {
                if(this.bucketTooltip == null) {
                    this.bucketTooltipFinal = ItemModFishBucket.defaultVariantFunc;
                } else {
                    this.bucketTooltipFinal = (container, stack, worldIn, tooltip) -> {
                        ItemModFishBucket.defaultVariantFunc.addInformation(container, stack, worldIn, tooltip);
                        this.bucketTooltip.addInformation(container, stack, worldIn, tooltip);
                    };
                }
            } else if(this.hasBucket && this.bucketTooltip != null) {
                this.bucketTooltipFinal = this.bucketTooltip;
            } else if(this.hasBucket && this.bucketTooltip == null) {
                this.bucketTooltipFinal = (container, stack, world, tooltip) -> {};
            }
        }

        protected void postBuild(EntityTypeContainer<T> container) {
            if(this.headTypeBuilder != null) {
                container.headType = headTypeBuilder.build(container);
            }
        }

        public EntityTypeContainer<T> build() {
            preBuild();
            EntityTypeContainer<T> container = new EntityTypeContainer<T>(entityClass, factory, entityName, spawnType, eggColorSolid, eggColorSpot, spawnWeight, spawnMinGroup, spawnMaxGroup, width, height, despawn, variantCount, variants, customConfig, customClientConfig, defaultBiomeSupplier, placementType, heightMapType, placementPredicate, hasBucket, bucketTooltipFinal);
            postBuild(container);
            return container;
        }

        public static <T extends MobEntity> Builder<T> create(Class<T> EntityClass, Function<World, T> func, String entityNameIn) {
            return new Builder<T>(EntityClass, func, entityNameIn);
        }

        public static class ContainerHeadBuilder<T extends MobEntity> extends HeadType.Builder {

            private Builder<T> builder;

            public ContainerHeadBuilder(String name, Builder<T> builder) {
                super(name);
                this.builder = builder;
            }
            
            @Override
            public ContainerHeadBuilder<T> mapToNames() {
                super.mapToNames();
                return this;
            }

            @Override
            public ContainerHeadBuilder<T> mapToNumbers() {
                super.mapToNumbers();
                return this;
            }

            @Override
            public ContainerHeadBuilder<T> mapToCustom(Function<IVariant, String> customMapper) {
                super.mapToCustom(customMapper);
                return this;
            }
            
            @Override
            public ContainerHeadBuilder<T> singleton(String id, String texture) {
                super.singleton(id, texture);
                return this;
            }

            @Override
            public ContainerHeadBuilder<T> allowFloor() {
                super.allowFloor();
                return this;
            }

            @Override
            public ContainerHeadBuilder<T> setModel(Supplier<Supplier<EntityModel<?>>> modelSupplier) {
                super.setModel(modelSupplier);
                return this;
            }
            
            public ContainerHeadBuilder<T> offset(float yOffset) {
                super.offset(yOffset);
                return this;
            }

            public Builder<T> done() {
                builder.headTypeBuilder = this;
                return builder;
            }

        }

    }

    public void initConfiguration(ForgeConfigSpec.Builder builder) {
        this.config = new EntityConfiguration(builder);
    }

    public EntityConfiguration getConfiguration() {
        return this.config;
    }

    public void setBiomes(Biome... biomes) {
        this.spawnBiomes = biomes;
    }

    public Biome[] getBiomes() {
        return spawnBiomes;
    }

    public class EntityConfiguration {
        public ForgeConfigSpec.BooleanValue doSpawning;
        public ForgeConfigSpec.IntValue spawnMinGroup;
        public ForgeConfigSpec.IntValue spawnMaxGroup;
        public ForgeConfigSpec.IntValue spawnWeight;
        public ForgeConfigSpec.ConfigValue<List<? extends String>> biomesList;
        public List<String> biomeStrings;
        public ForgeConfigSpec.BooleanValue doDespawn;

        protected EntityConfiguration(ForgeConfigSpec.Builder builder) {
            EntityTypeContainer<T> container = EntityTypeContainer.this;
            builder.push(container.entityName);
            this.biomeStrings = Arrays.asList(container.getBiomeIDs());
            this.loadSpawning(builder);
            this.loadSpawnValues(builder, container);
            doDespawn = builder.comment("True if this entity can despawn freely when no players are nearby.").worldRestart().define("doDespawn", container.despawn);
            EntityTypeContainer.this.customConfigurationInit(builder);
            builder.pop();
        }

        public void loadSpawning(ForgeConfigSpec.Builder builder) {
            doSpawning = builder.comment("Disables natural spawning").worldRestart().define("doSpawning", true);
        }

        public void loadSpawnValues(ForgeConfigSpec.Builder builder, EntityTypeContainer<T> container) {
            spawnWeight = builder.comment("The spawn chance compared to other entities (typically between 6-20)").worldRestart().defineInRange("weight", container.spawnWeight, 1, 9999);
            spawnMinGroup = builder.comment("Must be greater than 0").worldRestart().defineInRange("minGroup", container.spawnMinGroup, 1, 9999);
            spawnMaxGroup = builder.comment("Must be greater or equal to min value!").worldRestart().defineInRange("maxGroup", container.spawnMaxGroup, 1, 9999);
            biomesList = builder.comment("Enter biome Resource Locations. Supports modded biomes.").worldRestart().defineList("spawnBiomes", biomeStrings, (Predicate<Object>) input -> input instanceof String);
        }
    }

    protected static Supplier<Set<Biome>> toBiomes(BiomeDictionary.Type[] biomeTypes) {
        return () -> {
            Set<Biome> biomes = new HashSet<Biome>();
            for(BiomeDictionary.Type type : biomeTypes) {
                biomes.addAll(BiomeDictionary.getBiomes(type));
            }
            return biomes;
        };
    }

    protected static Supplier<Set<Biome>> toBiomes(Supplier<Biome[]> biomes2) {
        return () -> {
            Set<Biome> biomes = new HashSet<Biome>();
            biomes.addAll(Lists.newArrayList(biomes2.get()));
            return biomes;
        };
    }

    public String[] getBiomeIDs() {
        try {
            spawnBiomes = defaultBiomeSupplier.get().toArray(new Biome[0]);
        } catch(NullPointerException e) {
            spawnBiomes = new Biome[0];
        }
        String[] biomeStrings = new String[spawnBiomes.length];
        for(int i = 0; i < spawnBiomes.length; i++) {
            biomeStrings[i] = spawnBiomes[i].getRegistryName().toString();
        }
        return biomeStrings;
    }

    public void configurationLoad() {
        EntityTypeContainer<T>.EntityConfiguration section = this.getConfiguration();
        spawnMaxGroup = section.spawnMaxGroup.get();
        spawnMinGroup = section.spawnMinGroup.get();
        spawnWeight = section.spawnWeight.get();
        doSpawning = section.doSpawning.get();
        despawn = section.doDespawn.get();
        if(this.customConfig != null) {
            this.customConfig.customConfigurationLoad();
        }
    }

    public void clientConfigurationLoad() {
        if(this.customClientConfig != null) {
            this.customClientConfig.customConfigurationLoad();
        }
    }

    public void customConfigurationInit(ForgeConfigSpec.Builder builder) {
        if(this.customConfig != null) {
            this.customConfig.customConfigurationInit(builder);
        }
    }
    
    public void clientCustomConfigurationInit(ForgeConfigSpec.Builder builder) {
        if(this.customClientConfig != null) {
            builder.push(this.entityName);
            this.customClientConfig.customConfigurationInit(builder);
            builder.pop();
        }
    }

    public static interface CustomConfigurationHolder {
        void customConfigurationInit(ForgeConfigSpec.Builder builder);

        void customConfigurationLoad();
    }

    protected static <T extends MobEntity> boolean waterSpawn(EntityType<T> type, IWorld world, SpawnReason reason, BlockPos pos, Random rand) {
        return pos.getY() > 45 && pos.getY() < (world.getSeaLevel() - 1) && world.getBlockState(pos).getBlock() == Blocks.WATER;
    }

    public void registerPlacement() {
        if(this.placementType != null && this.placementPredicate != null && this.heightMapType != null) {
            if(!placementRegistered) {
                EntitySpawnPlacementRegistry.<T>register(this.entityType, placementType, heightMapType, placementPredicate);
                placementRegistered = true;
            }
        }
    }

    public HeadType getHeadType() {
        return this.headType;
    }

    public boolean hasVariants() {
        return this.variantMax > 0;
    }

    public int getVariantMax() {
        return this.variantMax;
    }

    public IVariant getVariant(String name) {
        return this.variantList.getVariant(name);
    }

    public IVariant getVariant(int index) {
        return this.variantList.getVariant(index);
    }

    public ImmutableList<IVariant> getVariants() {
        return this.variantList.getVariantList();
    }

    public int getVariantIndex(String variant) {
        return this.variantList.getVariantIndex(variant);
    }

    public int getVariantIndex(IVariant variant) {
        return this.variantList.getVariantIndex(variant);
    }

    public DataParameter<String> getVariantDataKey() {
        if(this.variantDataKey == null) {
            this.variantDataKey = EntityDataManager.<String>createKey(this.entityClass, DataSerializers.STRING);
        }
        return this.variantDataKey;
    }

    public DataParameter<Boolean> getFromBucketDataKey() {
        if(this.fromBucketDataKey == null) {
            this.fromBucketDataKey = EntityDataManager.<Boolean>createKey(this.entityClass, DataSerializers.BOOLEAN);
        }
        return this.fromBucketDataKey;
    }

    public ItemModFishBucket<T> getBucketItem() {
        return this.bucket;
    }

    public boolean hasBucket() {
        return this.bucket != null;
    }

}