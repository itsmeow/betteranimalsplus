package dev.itsmeow.betteranimalsplus.common.entity.util.abstracts;

import dev.itsmeow.betteranimalsplus.common.entity.util.EntityTypeContainerBAPTameable;
import dev.itsmeow.imdlib.IMDLib;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.interfaces.IContainerEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public abstract class EntityTameableBetterAnimalsPlus extends TamableAnimal implements IContainerEntity<EntityTameableBetterAnimalsPlus> {

    protected EntityTameableBetterAnimalsPlus(EntityType<? extends EntityTameableBetterAnimalsPlus> type, Level world) {
        super(type, world);
    }

    @Override
    public boolean canAttack(LivingEntity livingEntity) {
        return super.canAttack(livingEntity) && (this.getOwnerUUID() == null || (!(livingEntity instanceof TamableAnimal) || !this.getOwnerUUID().equals(((TamableAnimal) livingEntity).getOwnerUUID())));
    }

    @Override
    public void tick() {
        super.tick();
        if(!level.isClientSide && this.isInSittingPose() != this.isOrderedToSit()) {
            this.setInSittingPose(this.isOrderedToSit());
        }
    }

    public boolean isTamingItem(Item item) {
        EntityTypeContainer<?> container = getContainer();
        if(container instanceof EntityTypeContainerBAPTameable<?>) {
            String[] items = ((EntityTypeContainerBAPTameable<?>) container).getTameItems();
            String id = IMDLib.getRegistry(Registries.ITEM).getKey(item).toString();
            for(String itemsId : items) {
                if(itemsId.startsWith("#")) {
                    if(item.builtInRegistryHolder().is(TagKey.create(Registries.ITEM, new ResourceLocation(itemsId.substring(1))))) {
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
    public boolean removeWhenFarAway(double range) {
        return despawn(range);
    }

    @Override
    public EntityTameableBetterAnimalsPlus getImplementation() {
        return this;
    }

}
