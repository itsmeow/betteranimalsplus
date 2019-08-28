package its_meow.betteranimalsplus.config;

import java.util.Arrays;
import java.util.List;

import com.google.common.base.Predicate;

import its_meow.betteranimalsplus.util.EntityContainer;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class EntityConfigurationSection {

    public String entityName;
    public ForgeConfigSpec.BooleanValue doSpawning;
    public ForgeConfigSpec.IntValue min;
    public ForgeConfigSpec.IntValue max;
    public ForgeConfigSpec.IntValue weight;
    public ForgeConfigSpec.ConfigValue<List<? extends String>> biomesList;
    public ConfigValue<List<String>> tameItems;
    public List<String> biomeStrings;
    public ForgeConfigSpec.BooleanValue doDespawn;

    public EntityConfigurationSection(EntityContainer<?> container, ForgeConfigSpec.Builder builder) {
        builder.push(container.entityName);

        this.entityName = container.entityName;
        this.biomeStrings = Arrays.asList(container.getBiomeIDs());
        this.loadSpawning(builder);
        this.loadSpawnValues(builder, container);
        if(container.tameItems.length > 0) {
            this.loadTamingItems(builder, container.tameItems);
        }
        doDespawn = builder.comment("True if this entity can despawn freely when no players are nearby.").worldRestart().define("doDespawn", container.despawn);
        
        builder.pop();
    }
    
    public void loadTamingItems(ForgeConfigSpec.Builder builder, String[] tameItems) {
        this.tameItems = builder.comment("List of acceptable item IDs to use for taming").worldRestart().define("tameItems", Arrays.asList(tameItems), (Predicate<Object>) input -> input instanceof String);
    }

    public void loadSpawning(ForgeConfigSpec.Builder builder) {
        doSpawning = builder.comment("Disables natural spawning").worldRestart().define("doSpawning", true);
    }

    public void loadSpawnValues(ForgeConfigSpec.Builder builder, EntityContainer<?> container) {
        weight = builder.comment("The spawn chance compared to other animals (typically between 6-20)").worldRestart()
                .defineInRange("weight", container.weight, 1, 9999);
        min = builder.comment("Must be greater than 0").worldRestart().defineInRange("minGroup", container.minGroup, 1,
                9999);
        max = builder.comment("Must be greater or equal to min value!").worldRestart().defineInRange("maxGroup",
                container.maxGroup, 1, 9999);
        biomesList = builder.comment("Enter biome Resource Locations. Supports modded biomes.").worldRestart()
                .defineList("spawnBiomes", biomeStrings, (Predicate<Object>) input -> input instanceof String);
    }

}
