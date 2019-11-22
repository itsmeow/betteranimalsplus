package its_meow.betteranimalsplus.util;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class EntityTypeContainerTameable<T extends LivingEntity> extends EntityTypeContainer<T> {

    protected String[] tameItemsStore;
    protected ConfigValue<List<String>> tameItems;
    protected String[] defaultTameItems;

    public EntityTypeContainerTameable(Class<T> EntityClass, Function<World, T> func,
    String entityNameIn, EntityClassification type, int solidColorIn, int spotColorIn, int prob, int min, int max, float width, float height, boolean despawn, String[] defaultTameItems, @Nullable CustomConfigurationHolder customConfig, BiomeDictionary.Type... biomeTypes) {
        this(EntityClass, func, entityNameIn, type, solidColorIn, spotColorIn, prob, min, max, width, height, despawn, defaultTameItems, customConfig, toBiomes(biomeTypes));
    }

    @SafeVarargs
    public EntityTypeContainerTameable(Class<T> EntityClass, Function<World, T> func, String entityNameIn, EntityClassification type, int solidColorIn, int spotColorIn, int prob, int min, int max, float width, float height, boolean despawn, String[] defaultTameItems, @Nullable CustomConfigurationHolder customConfig, Supplier<Biome[]>... biomes) {
        this(EntityClass, func, entityNameIn, type, solidColorIn, spotColorIn, prob, min, max, width, height, despawn, defaultTameItems, customConfig, toBiomes(biomes[0]));
        if(biomes.length != 1) {
            throw new RuntimeException("STOP IT MEOW, FIX THIS.");
        }
    }

    public EntityTypeContainerTameable(Class<T> EntityClass, Function<World, T> func, String entityNameIn, EntityClassification type, int solidColorIn, int spotColorIn, int prob, int min, int max, float width, float height, boolean despawn, String[] defaultTameItems, @Nullable CustomConfigurationHolder customConfig, Supplier<Set<Biome>> biomes) {
        super(EntityClass, func, entityNameIn, type, solidColorIn, spotColorIn, prob, min, max, width, height, despawn, customConfig, biomes);
        this.defaultTameItems = defaultTameItems;
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
    public void customConfigurationInit(Builder builder) {
        super.customConfigurationInit(builder);
        this.tameItems = builder.comment("List of acceptable item IDs to use for taming").worldRestart().define("tameItems", Arrays.asList(defaultTameItems), (Predicate<Object>) input -> input instanceof String);
    }

}
