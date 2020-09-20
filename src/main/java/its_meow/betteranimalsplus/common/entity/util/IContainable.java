package its_meow.betteranimalsplus.common.entity.util;

import javax.annotation.Nonnull;

import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Hand;

public interface IContainable {

    MobEntity getImplementation();

    EntityTypeContainerBAPContainable<?, ?> getContainableContainer();

    default void setContainerData(ItemStack container) {
        if(this.getImplementation().hasCustomName()) {
            container.setDisplayName(this.getImplementation().getCustomName());
        }
    }

    default void writeFromContainerToEntity(CompoundNBT compound) {
        compound.putBoolean("FromBucket", this.isFromContainer());
    }

    default void readFromContainerToEntity(CompoundNBT compound) {
        this.setFromContainer(compound.getBoolean("FromBucket"));
    }

    default ItemStack getContainerItem() {
        return new ItemStack(getContainableContainer().getContainerItem());
    }

    default Item getEmptyContainerItem() {
        return getContainableContainer().getEmptyContainerItem();
    }

    default void setFromContainer(boolean fromContainer) {
        this.getImplementation().getDataManager().set(getContainableContainer().getFromContainerDataKey(), fromContainer);
    }

    default void registerFromContainerKey() {
        this.getImplementation().getDataManager().register(getContainableContainer().getFromContainerDataKey(), false);
    }

    default boolean isFromContainer() {
        return this.getImplementation().getDataManager().get(getContainableContainer().getFromContainerDataKey());
    }

    default void readFromContainer(@Nonnull ItemStack stack) {

    }

    default void readFromContainerTag(@Nonnull CompoundNBT tag) {

    }

    default boolean processContainerInteract(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        if(itemstack.getItem() == getEmptyContainerItem() && this.getImplementation().isAlive()) {
            itemstack.shrink(1);
            ItemStack itemstack1 = this.getContainerItem();
            this.setContainerData(itemstack1);
            this.onPickupSuccess(player, hand, itemstack1);
            if(itemstack.isEmpty()) {
                player.setHeldItem(hand, itemstack1);
            } else if(!player.inventory.addItemStackToInventory(itemstack1)) {
                player.dropItem(itemstack1, false);
            }
            this.getImplementation().remove();
            return true;
        } else {
            return false;
        }
    }

    default void onPickupSuccess(PlayerEntity player, Hand hand, ItemStack stack) {

    }

}
