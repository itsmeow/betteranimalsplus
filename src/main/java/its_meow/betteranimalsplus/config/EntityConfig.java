package its_meow.betteranimalsplus.config;

import java.util.HashMap;

import its_meow.betteranimalsplus.init.EntityContainer;
import its_meow.betteranimalsplus.init.MobRegistry;
import net.minecraftforge.common.ForgeConfigSpec;

public class EntityConfig {
	
	public HashMap<EntityContainer, EntityConfigurationSection> sections = new HashMap<EntityContainer, EntityConfigurationSection>();
	
	EntityConfig(ForgeConfigSpec.Builder builder) {
		for(EntityContainer cont : MobRegistry.entityList) {
			sections.put(cont, new EntityConfigurationSection(cont, builder));
		}
	}
}
