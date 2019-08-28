package its_meow.betteranimalsplus.common.entity;

import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.util.EntityContainer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public abstract class EntityTameableBetterAnimalsPlus extends TameableEntity {

    protected EntityTameableBetterAnimalsPlus(EntityType<? extends EntityTameableBetterAnimalsPlus> type, World world) {
        super(type, world);
    }

    public boolean isTamingItem(Item item) {
        EntityContainer<?> container = ModEntities.entityMap.get(this.getContainerName());
        if(container != null) {
            String[] items = container.tameItems;
            String id = item.getRegistryName().toString();
            for(String itemsId : items) {
                if(id.equals(itemsId)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    protected abstract String getContainerName();

    @Override
    public boolean canDespawn(double range) {
        return ModEntities.entityMap.containsKey(this.getContainerName()) ? ModEntities.entityMap.get(this.getContainerName()).despawn : false;
    }

}