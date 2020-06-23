package its_meow.betteranimalsplus.common.entity.util.abstracts;

import dev.itsmeow.imdlib.entity.util.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.util.IContainerEntity;
import its_meow.betteranimalsplus.common.entity.util.EntityTypeContainerBAPTameable;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public abstract class EntityTameableBetterAnimalsPlus extends TameableEntity implements IContainerEntity<EntityTameableBetterAnimalsPlus> {

    protected EntityTameableBetterAnimalsPlus(EntityType<? extends EntityTameableBetterAnimalsPlus> type, World world) {
        super(type, world);
    }

    public boolean isTamingItem(Item item) {
        EntityTypeContainer<?> container = getContainer();
        if(container instanceof EntityTypeContainerBAPTameable<?>) {
            String[] items = ((EntityTypeContainerBAPTameable<?>) container).getTameItems();
            String id = item.getRegistryName().toString();
            for(String itemsId : items) {
                if(itemsId.startsWith("#")) {
                    if(item.getTags().contains(new ResourceLocation(itemsId.substring(1)))) {
                        return true;
                    }
                } else if(id.equals(itemsId)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean canDespawn(double range) {
        return despawn(range);
    }

    @Override
    public EntityTameableBetterAnimalsPlus getImplementation() {
        return this;
    }

}
