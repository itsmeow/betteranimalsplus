package its_meow.betteranimalsplus.common.entity;

import its_meow.betteranimalsplus.config.BetterAnimalsPlusConfig;
import its_meow.betteranimalsplus.init.ModEntities;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public abstract class EntityTameableBetterAnimalsPlus extends EntityTameable {

    public EntityTameableBetterAnimalsPlus(World worldIn) {
        super(worldIn);
    }
    
    public static boolean isTamingItem(Class<? extends EntityTameableBetterAnimalsPlus> type, Item item) {
        String[] items = BetterAnimalsPlusConfig.sections.get(ModEntities.entityMap.get(type)).tameItems;
        String id = item.getRegistryName().toString();
        for(String itemsId : items) {
            if(id.equals(itemsId)) {
                return true;
            }
        }
        return false;
    }

}
