package its_meow.betteranimalsplus.util;

import static its_meow.betteranimalsplus.BetterAnimalsPlusMod.config;

import net.minecraft.entity.Entity;

public class EntityConfigurationSection {

    public Class<? extends Entity> entityClazz;
    public String categoryName;
    public boolean doSpawning;
    public int min;
    public int max;
    public int weight;
    public String[] biomesList;
    public String[] tameItems;
    public boolean allowDespawning;

    public EntityConfigurationSection(Class<? extends Entity> entity, int min, int max, int weight, boolean despawn, String[] tameItems, String[] biomesList) {
        this.categoryName = entity.getName();
        config.addCustomCategoryComment(this.categoryName, "");
        this.entityClazz = entity;
        this.loadSpawning();
        this.loadSpawnValues(weight, min, max, biomesList);
        if(tameItems.length > 0) {
            this.loadTamingItems(tameItems);
        }
        this.allowDespawning = config.getBoolean("allowDespawning", this.categoryName, despawn, "True to despawn this entity when no one is nearby");
    }

    public void loadTamingItems(String[] tameItems) {
        this.tameItems = config.getStringList("tameItems", this.categoryName, tameItems, "List of acceptable item IDs to use for taming");
    }

    public void loadSpawning() {
        this.doSpawning = config.getBoolean("doSpawning", this.categoryName, true, "Disables natural spawning");
    }

    public void loadSpawnValues(int weight, int min, int max, String[] biomesList) {
        this.weight = config.getInt("weight", this.categoryName, weight, 1, 9999, "The spawn chance compared to other animals (typically between 6-20)");
        this.min = config.getInt("minGroup", this.categoryName, min, 1, 9999, "Must be greater than 0");
        this.max = config.getInt("maxGroup", this.categoryName, max, 1, 9999, "Must be greater or equal to min value!");
        this.biomesList = config.getStringList("spawnBiomes", this.categoryName, biomesList, "Enter biome Resource Locations. Supports modded biomes.");
    }

}
