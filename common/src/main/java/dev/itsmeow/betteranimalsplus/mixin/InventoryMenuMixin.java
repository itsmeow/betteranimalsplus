package dev.itsmeow.betteranimalsplus.mixin;

import dev.itsmeow.betteranimalsplus.common.item.ItemCape;
import net.minecraft.world.Container;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "net.minecraft.world.inventory.InventoryMenu$1")
public class InventoryMenuMixin {

    private static final EquipmentSlot[] SLOTS = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};

    @Shadow
    @Final
    private int slot;

    @Shadow
    @Final
    public Container container;

    @Inject(at = @At("HEAD"), method = "mayPlace(Lnet/minecraft/world/item/ItemStack;)Z", cancellable = true)
    private void mayPlace(ItemStack stack, CallbackInfoReturnable<Boolean> callback) {
        if(stack.getItem() instanceof ItemCape && container instanceof Inventory && !((ItemCape) stack.getItem()).can_equip.canEquip(stack, SLOTS[39 - slot], ((Inventory)container).player)) {
            callback.setReturnValue(false);
            callback.cancel();
        }
    }

}
