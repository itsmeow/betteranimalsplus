package its_meow.betteranimalsplus.common.entity;

import its_meow.betteranimalsplus.config.BetterAnimalsPlusConfig;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.util.EntityConfigurationSection;
import its_meow.betteranimalsplus.util.EntityContainer;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public abstract class EntityTameableBetterAnimalsPlus extends EntityTameable {

    public EntityTameableBetterAnimalsPlus(World worldIn) {
        super(worldIn);
    }

    public static boolean isTamingItem(String entityName, Item item) {
        EntityContainer container = ModEntities.entityMap.get(entityName);
        EntityConfigurationSection section = BetterAnimalsPlusConfig.sections.get(container);
        if(section != null) {
            String[] items = section.tameItems;
            String id = item.getRegistryName().toString();
            for(String itemsId : items) {
                if(id.equals(itemsId)) {
                    return true;
                }
            }
        }
        return false;
    }

}
