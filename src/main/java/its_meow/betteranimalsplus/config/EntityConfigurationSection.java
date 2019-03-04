package its_meow.betteranimalsplus.config;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Predicate;

import its_meow.betteranimalsplus.init.EntityContainer;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.ForgeConfigSpec;

public class EntityConfigurationSection {

	public String entityName; 
	public ForgeConfigSpec.BooleanValue doSpawning; 
	public ForgeConfigSpec.IntValue min;
	public ForgeConfigSpec.IntValue max; 
	public ForgeConfigSpec.IntValue weight;
	public ForgeConfigSpec.ConfigValue<List<? extends String>> biomesList;
	
	public EntityConfigurationSection(EntityContainer container, ForgeConfigSpec.Builder builder) { 
		builder.push(container.entityName);
		
		this.entityName = container.entityName;
		this.loadSpawning(builder);
		this.loadSpawnValues(builder, container); 
		
		builder.pop();
	}
	
	public void loadSpawning(ForgeConfigSpec.Builder builder) {
		doSpawning = builder.comment("Disables natural spawning").worldRestart().define("doSpawning", true);
		//this.doSpawning = config.getBoolean("doSpawning", this.categoryName, true, "Disables natural spawning"); 
	}

	public void loadSpawnValues(ForgeConfigSpec.Builder builder, EntityContainer container) { 
		weight = builder.comment("The spawn chance compared to other animals (typically between 6-20)").worldRestart().defineInRange("weight", container.weight, 1, 9999);
		min = builder.comment("Must be greater than 0").worldRestart().defineInRange("minGroup", container.minGroup, 1, 9999);
		max = builder.comment("Must be greater or equal to min value!").worldRestart().defineInRange("maxGroup", container.maxGroup, 1, 9999);
		ArrayList<String> biomes = new ArrayList<String>();
		for(Biome biome : container.spawnBiomes) {
			biomes.add(biome.getRegistryName().toString());
		}
		biomesList = builder.comment("Enter biome Resource Locations. Supports modded biomes.").worldRestart().defineList("spawnBiomes", biomes, new Predicate<Object>(){@Override public boolean apply(Object input){return input instanceof String;}});
		//this.weight = config.getInt("weight", this.categoryName, weight, 1, 9999, "The spawn chance compared to other animals (typically between 6-20)");
		//this.min = config.getInt("minGroup", this.categoryName, min, 1, 9999, "Must be greater than 0"); 
		//this.max = config.getInt("maxGroup", this.categoryName, max, 1, 9999, "Must be greater or equal to min value!"); 
		//this.biomesList = config.getStringList("spawnBiomes", this.categoryName, biomesList, "Enter biome Resource Locations. Supports modded biomes."); 
	}

}
