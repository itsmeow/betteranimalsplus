package its_meow.betteranimalsplus.common.entity.util;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;

public interface IBucketable extends IContainable {

    @Override
    default void onPickupSuccess(PlayerEntity player, Hand hand, ItemStack stack) {
        this.getImplementation().playSound(SoundEvents.ITEM_BUCKET_FILL_FISH, 1.0F, 1.0F);
        if(!this.getImplementation().world.isRemote) {
            CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayerEntity) player, stack);
        }
    }

}
