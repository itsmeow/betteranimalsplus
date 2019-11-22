package its_meow.betteranimalsplus.common.entity;

import its_meow.betteranimalsplus.util.EntityTypeContainerTameable;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public abstract class EntityTameableBetterAnimalsPlus extends TameableEntity {

    protected EntityTameableBetterAnimalsPlus(EntityType<? extends EntityTameableBetterAnimalsPlus> type, World world) {
        super(type, world);
    }

    public boolean isTamingItem(Item item) {
        EntityTypeContainerTameable<?> container = getContainer();
        String[] items = container.getTameItems();
        String id = item.getRegistryName().toString();
        for(String itemsId : items) {
            if (itemsId.startsWith("#")) {
                if (item.getTags().contains(new ResourceLocation(itemsId.substring(1, itemsId.length())))) {
                    return true;
                }
            } else if(id.equals(itemsId)) {
                return true;
            }
        }
        return false;
    }

    protected abstract EntityTypeContainerTameable<? extends EntityTameableBetterAnimalsPlus> getContainer();

    @Override
    public boolean canDespawn(double range) {
        return getContainer().despawn;
    }

}
