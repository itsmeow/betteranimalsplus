package its_meow.betteranimalsplus.util;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.MobEntity;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class EntityTypeContainerTameable<T extends MobEntity> extends EntityTypeContainer<T> {

    protected String[] tameItemsStore;
    protected ConfigValue<List<? extends String>> tameItems;
    protected String[] defaultTameItems;

    private EntityTypeContainerTameable(Class<T> EntityClass, Function<World, T> func, String entityNameIn, EntityClassification type, int solidColorIn, int spotColorIn, int prob, int min, int max, float width, float height, boolean despawn, String[] defaultTameItems, @Nullable CustomConfigurationHolder customConfig, Supplier<Set<Biome>> biomes, EntitySpawnPlacementRegistry.PlacementType placementType, Heightmap.Type heightMapType, EntitySpawnPlacementRegistry.IPlacementPredicate<T> placementPredicate) {
        super(EntityClass, func, entityNameIn, type, solidColorIn, spotColorIn, prob, min, max, width, height, despawn, customConfig, biomes, placementType, heightMapType, placementPredicate);
        this.defaultTameItems = defaultTameItems;
    }

    public static class TameableBuilder<T extends MobEntity> extends EntityTypeContainer.Builder<T> {
        protected String[] defaultTameItems;

        private TameableBuilder(Class<T> EntityClass, Function<World, T> func, String entityNameIn) {
            super(EntityClass, func, entityNameIn);
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
        public TameableBuilder<T> biomes(BiomeDictionary.Type... biomeTypes) {
            super.biomes(biomeTypes);
            return this;
        }
        
        @Override
        public TameableBuilder<T> biomes(Supplier<Biome[]> biomes) {
            super.biomes(biomes);
            return this;
        }
        
        public TameableBuilder<T> placement(EntitySpawnPlacementRegistry.PlacementType type, Heightmap.Type heightMap, EntitySpawnPlacementRegistry.IPlacementPredicate<T> predicate) {
            super.placement(type, heightMap, predicate);
            return this;
        }
        
        public TameableBuilder<T> defaultPlacement(EntitySpawnPlacementRegistry.IPlacementPredicate<T> predicate) {
            super.defaultPlacement(predicate);
            return this;
        }
        
        public TameableBuilder<T> waterPlacement() {
            super.waterPlacement();
            return this;
        }
        
        public TameableBuilder<T> waterPlacement(EntitySpawnPlacementRegistry.IPlacementPredicate<T> predicate) {
            super.waterPlacement(predicate);
            return this;
        }

        public TameableBuilder<T> tameItems(String... items) {
            this.defaultTameItems = items;
            return this;
        }

        @Override
        public EntityTypeContainerTameable<T> build() {
            return new EntityTypeContainerTameable<T>(entityClass, factory, entityName, spawnType, eggColorSolid, eggColorSpot, spawnWeight, spawnMinGroup, spawnMaxGroup, width, height, despawn, defaultTameItems, customConfig, defaultBiomeSupplier, placementType, heightMapType, placementPredicate);
        }

        public static <T extends MobEntity> TameableBuilder<T> create(Class<T> EntityClass, Function<World, T> func, String entityNameIn) {
            return new TameableBuilder<T>(EntityClass, func, entityNameIn);
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
