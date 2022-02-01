package dev.itsmeow.betteranimalsplus.compat.trinkets;

import dev.emi.trinkets.api.TrinketsApi;
import dev.itsmeow.betteranimalsplus.Ref;
import dev.itsmeow.betteranimalsplus.common.item.ItemCape;
import net.fabricmc.fabric.api.util.TriState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;

public class TrinketsModCompat {

    public static void init() {
        ItemCape.can_equip = (stack, armorType, entity) -> !TrinketsApi.getTrinketComponent((LivingEntity) entity).get().isEquipped(s -> s.getItem() instanceof ItemCape);
        TrinketsApi.registerTrinketPredicate(new ResourceLocation(Ref.MOD_ID, "cape_allowed"), (stack, slot, entity) -> {
            if (stack.getItem() instanceof ItemCape && entity.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof ItemCape) {
                return TriState.FALSE;
            }
            return TriState.TRUE;
        });
    }

}
