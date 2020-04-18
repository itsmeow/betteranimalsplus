package its_meow.betteranimalsplus.common.entity.util;

import javax.annotation.Nonnull;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;

public interface IBucketable {

    MobEntity getImplementation();

    EntityTypeContainer<?> getContainer();

    default void setBucketData(ItemStack bucket) {
        if(this.getImplementation().hasCustomName()) {
            bucket.setDisplayName(this.getImplementation().getCustomName());
        }
    }
    
    default void writeFromBucketToEntity(CompoundNBT compound) {
        compound.putBoolean("FromBucket", this.isFromBucket());
    }

    default void readFromBucketToEntity(CompoundNBT compound) {
        this.setFromBucket(compound.getBoolean("FromBucket"));
    }

    default ItemStack getBucket() {
        return new ItemStack(getContainer().getBucketItem());
    }

    default void setFromBucket(boolean fromBucket) {
        this.getImplementation().getDataManager().set(getContainer().getFromBucketDataKey(), fromBucket);
    }
    
    default void registerFromBucketKey() {
        this.getImplementation().getDataManager().register(getContainer().getFromBucketDataKey(), false);
    }

    default boolean isFromBucket() {
        return this.getImplementation().getDataManager().get(getContainer().getFromBucketDataKey());
    }

    default void readFromBucket(@Nonnull ItemStack stack) {

    }

    default void readFromBucketTag(@Nonnull CompoundNBT tag) {

    }
    
    default boolean processBucketInteract(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        if(itemstack.getItem() == Items.WATER_BUCKET && this.getImplementation().isAlive()) {
            this.getImplementation().playSound(SoundEvents.ITEM_BUCKET_FILL_FISH, 1.0F, 1.0F);
            itemstack.shrink(1);
            ItemStack itemstack1 = this.getBucket();
            this.setBucketData(itemstack1);
            if(!this.getImplementation().world.isRemote) {
                CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayerEntity) player, itemstack1);
            }
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

}
