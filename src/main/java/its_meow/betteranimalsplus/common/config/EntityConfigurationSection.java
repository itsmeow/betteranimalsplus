package its_meow.betteranimalsplus.common.config;

import static its_meow.betteranimalsplus.BetterAnimalsPlusMod.config;

import net.minecraft.entity.Entity;

public class EntityConfigurationSection {
	
	public Class<? extends Entity> entityClazz;
	public String categoryName;
	public boolean doRegister;
	public boolean doSpawning;
	public int min;
	public int max;
	public int weight;
	
	public EntityConfigurationSection(Class<? extends Entity> entity, int min, int max, int weight) {
		this.categoryName = entity.getName();
		config.addCustomCategoryComment(this.categoryName, "");
		this.entityClazz = entity;
		this.loadRegister();
		this.loadSpawning();
		this.loadSpawnValues(weight, min, max);
	}
	
	public void loadRegister() {
		this.doRegister = config.getBoolean("doRegistration", this.categoryName, true, "If set to false, the entity is removed (will remove from existing worlds!)");
	}
	
	public void loadSpawning() {
		this.doSpawning = config.getBoolean("doSpawning", this.categoryName, true, "Disables natural spawning");
	}
	
	public void loadSpawnValues(int weight, int min, int max) {
		this.weight = config.getInt("weight", this.categoryName, weight, 1, 9999, "The spawn chance compared to other animals (typically between 6-20)");
		this.min = config.getInt("minGroup", this.categoryName, min, 1, 9999, "Must be greater than 0");
		this.max = config.getInt("maxGroup", this.categoryName, max, 1, 9999, "Must be greater or equal to min value!");
	}
	
}
