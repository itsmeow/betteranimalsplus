package its_meow.betteranimalsplus.common.entity.util;

import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import dev.itsmeow.imdlib.entity.util.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.util.IVariant;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.item.ItemModFishBucket;
import its_meow.betteranimalsplus.common.item.ItemModFishBucket.IBucketTooltipFunction;
import its_meow.betteranimalsplus.util.HeadType;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.fluid.Fluids;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.common.BiomeDictionary;

public class EntityTypeContainerBAP<T extends MobEntity> extends EntityTypeContainer<T> {

    protected DataParameter<Boolean> fromBucketDataKey;
    protected ItemModFishBucket<T> bucket;

    protected HeadType headType;

    protected EntityTypeContainerBAP(Class<T> EntityClass, Function<World, T> func, String entityNameIn, EntityClassification type, int solidColorIn, int spotColorIn, int prob, int min, int max, float width, float height, boolean despawn, int variantMax, IVariant[] variants, @Nullable CustomConfigurationHolder customConfig, @Nullable CustomConfigurationHolder customClientConfig, Supplier<Set<Biome>> biomes, EntitySpawnPlacementRegistry.PlacementType placementType, Heightmap.Type heightMapType, EntitySpawnPlacementRegistry.IPlacementPredicate<T> placementPredicate, boolean hasBucket, IBucketTooltipFunction bucketTooltip, Supplier<AttributeModifierMap.MutableAttribute> attributeMap) {
        super(Ref.MOD_ID, EntityClass, func, entityNameIn, type, solidColorIn, spotColorIn, prob, min, max, width, height, despawn, variantMax, variants, customConfig, customClientConfig, biomes, placementType, heightMapType, placementPredicate, attributeMap);
        if(hasBucket) {
            this.bucket = new ItemModFishBucket<T>(this, () -> Fluids.WATER, bucketTooltip);
        }
    }

    public static class Builder<T extends MobEntity> extends EntityTypeContainer.Builder<T> {

        protected HeadType.Builder headTypeBuilder;
        protected boolean hasBucket;
        protected IBucketTooltipFunction bucketTooltip;
        protected IBucketTooltipFunction bucketTooltipFinal;

        protected Builder(Class<T> EntityClass, Function<World, T> func, String entityNameIn, Supplier<AttributeModifierMap.MutableAttribute> attributeMap) {
            super(EntityClass, func, entityNameIn, attributeMap, Ref.MOD_ID);
            this.hasBucket = false;
        }

        @Override
        public Builder<T> spawn(EntityClassification type, int weight, int min, int max) {
            super.spawn(type, weight, min, max);
            return this;
        }

        @Override
        public Builder<T> egg(int solid, int spot) {
            super.egg(solid, spot);
            return this;
        }

        @Override
        public Builder<T> size(float width, float height) {
            super.size(width, height);
            return this;
        }

        @Override
        public Builder<T> despawn() {
            super.despawn();
            return this;
        }

        @Override
        public Builder<T> config(CustomConfigurationHolder config) {
            super.config(config);
            return this;
        }

        @Override
        public Builder<T> clientConfig(CustomConfigurationHolder config) {
            super.clientConfig(config);
            return this;
        }

        @Override
        public Builder<T> placement(EntitySpawnPlacementRegistry.PlacementType type, Heightmap.Type heightMap, EntitySpawnPlacementRegistry.IPlacementPredicate<T> predicate) {
            super.placement(type, heightMap, predicate);
            return this;
        }

        @Override
        public Builder<T> defaultPlacement(EntitySpawnPlacementRegistry.IPlacementPredicate<T> predicate) {
            super.defaultPlacement(predicate);
            return this;
        }

        @Override
        public Builder<T> waterPlacement() {
            super.waterPlacement();
            return this;
        }

        @Override
        public Builder<T> waterPlacement(EntitySpawnPlacementRegistry.IPlacementPredicate<T> predicate) {
            super.waterPlacement(predicate);
            return this;
        }

        @Override
        public Builder<T> biomes(BiomeDictionary.Type... biomeTypes) {
            super.biomes(biomeTypes);
            return this;
        }

        @Override
        public Builder<T> biomes(Supplier<Biome[]> biomes) {
            super.biomes(biomes);
            return this;
        }

        @Override
        public Builder<T> variants(IVariant... variants) {
            super.variants(variants);
            return this;
        }

        @Override
        public Builder<T> variants(String... nameTextures) {
            super.variants(nameTextures);
            return this;
        }

        @Override
        public Builder<T> variants(int max) {
            super.variants(max);
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

        @Override
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
                this.bucketTooltipFinal = (container, stack, world, tooltip) -> {
                };
            }
        }

        @Override
        protected void postBuild(EntityTypeContainer<T> container) {
            EntityTypeContainerBAP<T> c = (EntityTypeContainerBAP<T>) container;
            if(this.headTypeBuilder != null) {
                c.headType = headTypeBuilder.build(c);
            }
        }

        @Override
        public EntityTypeContainerBAP<T> build() {
            preBuild();
            EntityTypeContainerBAP<T> container = new EntityTypeContainerBAP<T>(entityClass, factory, entityName, spawnType, eggColorSolid, eggColorSpot, spawnWeight, spawnMinGroup, spawnMaxGroup, width, height, despawn, variantCount, variants, customConfig, customClientConfig, defaultBiomeSupplier, placementType, heightMapType, placementPredicate, hasBucket, bucketTooltipFinal, attributes);
            postBuild(container);
            return container;
        }

        public static <T extends MobEntity> Builder<T> create(Class<T> EntityClass, Function<World, T> func, String entityNameIn, Supplier<AttributeModifierMap.MutableAttribute> attributeMap) {
            return new Builder<T>(EntityClass, func, entityNameIn, attributeMap);
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

    public HeadType getHeadType() {
        return this.headType;
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