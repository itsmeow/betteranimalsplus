package its_meow.betteranimalsplus.common.entity.util;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import dev.itsmeow.imdlib.entity.util.IVariant;
import its_meow.betteranimalsplus.common.item.ItemModFishBucket.IBucketTooltipFunction;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class EntityTypeContainerBAPTameable<T extends MobEntity> extends EntityTypeContainerBAP<T> {

    protected String[] tameItemsStore;
    protected ConfigValue<List<? extends String>> tameItems;
    protected String[] defaultTameItems;

    private EntityTypeContainerBAPTameable(Class<T> EntityClass, Function<World, T> func, String entityNameIn, EntityClassification type, int solidColorIn, int spotColorIn, int prob, int min, int max, float width, float height, boolean despawn, int variantCount, IVariant[] variantFactories, String[] defaultTameItems, @Nullable CustomConfigurationHolder customConfig, @Nullable CustomConfigurationHolder customClientConfig, Supplier<Set<Biome>> biomes, EntitySpawnPlacementRegistry.PlacementType placementType, Heightmap.Type heightMapType, EntitySpawnPlacementRegistry.IPlacementPredicate<T> placementPredicate, boolean hasBucket,
    IBucketTooltipFunction bucketTooltip, Supplier<AttributeModifierMap.MutableAttribute> attributeMap) {
        super(EntityClass, func, entityNameIn, type, solidColorIn, spotColorIn, prob, min, max, width, height, despawn, variantCount, variantFactories, customConfig, customClientConfig, biomes, placementType, heightMapType, placementPredicate, hasBucket, bucketTooltip, attributeMap);
        this.defaultTameItems = defaultTameItems;
    }

    public static class TameableBuilder<T extends MobEntity> extends EntityTypeContainerBAP.Builder<T> {
        protected String[] defaultTameItems;

        private TameableBuilder(Class<T> EntityClass, Function<World, T> func, String entityNameIn, Supplier<AttributeModifierMap.MutableAttribute> attributeMap) {
            super(EntityClass, func, entityNameIn, attributeMap);
        }

        @Override
        public TameableBuilder<T> spawn(EntityClassification type, int weight, int min, int max) {
            super.spawn(type, weight, min, max);
            return this;
        }

        @Override
        public TameableBuilder<T> egg(int solid, int spot) {
            super.egg(solid, spot);
            return this;
        }

        @Override
        public TameableBuilder<T> size(float width, float height) {
            super.size(width, height);
            return this;
        }

        @Override
        public TameableBuilder<T> despawn() {
            super.despawn();
            return this;
        }

        @Override
        public TameableBuilder<T> config(CustomConfigurationHolder config) {
            super.config(config);
            return this;
        }

        @Override
        public TameableBuilder<T> clientConfig(CustomConfigurationHolder config) {
            super.clientConfig(config);
            return this;
        }

        @Override
        public TameableBuilder<T> biomes(BiomeDictionary.Type... biomeTypes) {
            super.biomes(biomeTypes);
            return this;
        }

        @Override
        public TameableBuilder<T> biomes(Supplier<Biome[]> biomes) {
            super.biomes(biomes);
            return this;
        }

        @Override
        public TameableBuilder<T> placement(EntitySpawnPlacementRegistry.PlacementType type, Heightmap.Type heightMap, EntitySpawnPlacementRegistry.IPlacementPredicate<T> predicate) {
            super.placement(type, heightMap, predicate);
            return this;
        }

        @Override
        public TameableBuilder<T> defaultPlacement(EntitySpawnPlacementRegistry.IPlacementPredicate<T> predicate) {
            super.defaultPlacement(predicate);
            return this;
        }

        @Override
        public TameableBuilder<T> waterPlacement() {
            super.waterPlacement();
            return this;
        }

        @Override
        public TameableBuilder<T> waterPlacement(EntitySpawnPlacementRegistry.IPlacementPredicate<T> predicate) {
            super.waterPlacement(predicate);
            return this;
        }

        @Override
        public TameableBuilder<T> variants(IVariant... variants) {
            super.variants(variants);
            return this;
        }

        @Override
        public TameableBuilder<T> variants(String... nameTextures) {
            super.variants(nameTextures);
            return this;
        }

        @Override
        public TameableBuilder<T> variants(int max) {
            super.variants(max);
            return this;
        }

        public TameableBuilder<T> tameItems(String... items) {
            this.defaultTameItems = items;
            return this;
        }

        @Override
        public TameableContainerHeadBuilder<T> head(String headName) {
            return new TameableContainerHeadBuilder<T>(headName, this);
        }

        @Override
        public TameableContainerHeadBuilder<T> head() {
            return head(this.entityName + "head");
        }

        @Override
        public TameableBuilder<T> bucketable() {
            super.bucketable();
            return this;
        }

        @Override
        public TameableBuilder<T> bucketable(IBucketTooltipFunction tooltip) {
            super.bucketable(tooltip);
            return this;
        }

        @Override
        public EntityTypeContainerBAPTameable<T> build() {
            this.preBuild();
            EntityTypeContainerBAPTameable<T> container = new EntityTypeContainerBAPTameable<T>(entityClass, factory, entityName, spawnType, eggColorSolid, eggColorSpot, spawnWeight, spawnMinGroup, spawnMaxGroup, width, height, despawn, variantCount, variants, defaultTameItems, customConfig, customClientConfig, defaultBiomeSupplier, placementType, heightMapType, placementPredicate, hasBucket, bucketTooltipFinal, attributes);
            this.postBuild(container);
            return container;
        }

        public static <T extends MobEntity> TameableBuilder<T> create(Class<T> EntityClass, Function<World, T> func, String entityNameIn, Supplier<AttributeModifierMap.MutableAttribute> attributeMap) {
            return new TameableBuilder<T>(EntityClass, func, entityNameIn, attributeMap);
        }

        public static class TameableContainerHeadBuilder<T extends MobEntity> extends ContainerHeadBuilder<T> {

            private TameableBuilder<T> builder;

            public TameableContainerHeadBuilder(String name, TameableBuilder<T> builder) {
                super(name, builder);
                this.builder = builder;
            }

            @Override
            public TameableContainerHeadBuilder<T> mapToNames() {
                super.mapToNames();
                return this;
            }

            @Override
            public TameableContainerHeadBuilder<T> mapToNumbers() {
                super.mapToNumbers();
                return this;
            }

            @Override
            public TameableContainerHeadBuilder<T> mapToCustom(Function<IVariant, String> customMapper) {
                super.mapToCustom(customMapper);
                return this;
            }

            @Override
            public TameableContainerHeadBuilder<T> singleton(String id, String texture) {
                super.singleton(id, texture);
                return this;
            }

            @Override
            public TameableContainerHeadBuilder<T> allowFloor() {
                super.allowFloor();
                return this;
            }

            @Override
            public TameableContainerHeadBuilder<T> setModel(Supplier<Supplier<EntityModel<?>>> modelSupplier) {
                super.setModel(modelSupplier);
                return this;
            }

            @Override
            public TameableContainerHeadBuilder<T> offset(float yOffset) {
                super.offset(yOffset);
                return this;
            }

            @Override
            public TameableBuilder<T> done() {
                super.done();
                return builder;
            }

        }

    }

    public String[] getTameItems() {
        return tameItemsStore;
    }

    @OnlyIn(Dist.CLIENT)
    public void setTameItems(String[] items) {
        this.tameItemsStore = items;
    }

    @Override
    public void configurationLoad() {
        super.configurationLoad();
        this.tameItemsStore = tameItems.get().toArray(new String[0]);
    }

    @Override
    public void customConfigurationInit(ForgeConfigSpec.Builder builder) {
        super.customConfigurationInit(builder);
        this.tameItems = builder.comment("List of acceptable item IDs to use for taming. Accepts tags by prefixing them with '#'.").worldRestart().defineList("tameItems", Arrays.asList(defaultTameItems), (Predicate<Object>) input -> input instanceof String);
    }

}
