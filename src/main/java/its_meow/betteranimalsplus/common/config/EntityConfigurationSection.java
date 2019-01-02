package its_meow.betteranimalsplus.common.config;

import its_meow.betteranimalsplus.proxy.CommonProxy;
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
		CommonProxy.config.addCustomCategoryComment(categoryName, "");
		this.entityClazz = entity;
		this.loadRegister();
		this.loadSpawning();
		this.loadSpawnValues(weight, min, max);
	}
	
	public void loadRegister() {
		this.doRegister = CommonProxy.config.getBoolean("doRegistration", categoryName, true, "If set to false, the entity is removed (will remove from existing worlds!)");
	}
	
	public void loadSpawning() {
		this.doSpawning = CommonProxy.config.getBoolean("doSpawning", categoryName, true, "Disables natural spawning");
	}
	
	public void loadSpawnValues(int weight, int min, int max) {
		this.weight = CommonProxy.config.getInt("weight", categoryName, weight, 1, 9999, "The spawn chance compared to other animals (typically between 6-20)");
		this.min = CommonProxy.config.getInt("minGroup", categoryName, min, 1, 9999, "Must be greater than 0");
		this.max = CommonProxy.config.getInt("maxGroup", categoryName, max, 1, 9999, "Must be greater or equal to min value!");
	}
	
}
