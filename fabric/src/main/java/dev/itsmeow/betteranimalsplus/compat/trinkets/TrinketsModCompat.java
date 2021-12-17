package dev.itsmeow.betteranimalsplus.compat.trinkets;

import dev.emi.trinkets.api.TrinketsApi;
import dev.itsmeow.betteranimalsplus.common.item.ItemCape;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class TrinketsModCompat {

    public static void init() {
        ItemCape.can_equip = (stack, armorType, entity) -> !TrinketsApi.getTrinketComponent((LivingEntity) entity).get().isEquipped(stack.getItem());
    }

}
