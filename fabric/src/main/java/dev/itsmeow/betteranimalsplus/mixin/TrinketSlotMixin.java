package dev.itsmeow.betteranimalsplus.mixin;

import dev.emi.trinkets.TrinketSlot;
import dev.emi.trinkets.api.TrinketInventory;
import dev.itsmeow.betteranimalsplus.common.item.ItemCape;
import net.minecraft.world.Container;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TrinketSlot.class)
public abstract class TrinketSlotMixin extends Slot {
    public TrinketSlotMixin(Container container, int i, int j, int k) {
        super(container, i, j, k);
    }

    @Inject(at = @At("HEAD"), method = "mayPlace(Lnet/minecraft/world/item/ItemStack;)Z", cancellable = true)
    private void mayPlace(ItemStack stack, CallbackInfoReturnable<Boolean> callback) {
        if (stack.getItem() instanceof ItemCape && ((SlotAccessor) this).getContainer() instanceof TrinketInventory && ((TrinketInventory) ((SlotAccessor) this).getContainer()).getComponent().getEntity() instanceof Player && (((Player)(((TrinketInventory) ((SlotAccessor) this).getContainer()).getComponent().getEntity())).getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof ItemCape || !ItemCape.can_equip.canEquip(stack, EquipmentSlot.CHEST, ((TrinketInventory) ((SlotAccessor) this).getContainer()).getComponent().getEntity()))) {
            callback.setReturnValue(false);
            callback.cancel();
        }
    }

}
