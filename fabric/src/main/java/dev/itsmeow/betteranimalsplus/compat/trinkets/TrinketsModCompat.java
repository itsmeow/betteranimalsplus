package dev.itsmeow.betteranimalsplus.compat.trinkets;

import dev.emi.trinkets.api.TrinketsApi;
import dev.itsmeow.betteranimalsplus.common.item.ItemCape;
import dev.itsmeow.betteranimalsplus.init.ModItems;
import me.shedaniel.architectury.registry.RegistrySupplier;
import net.minecraft.world.entity.player.Player;

import java.util.stream.Collectors;

public class TrinketsModCompat {

    public static void init() {
        ItemCape.can_equip = (stack, armorType, entity) -> !TrinketsApi.getTrinketsInventory((Player) entity).hasAnyOf(ModItems.getModeledArmor().values().stream().map(RegistrySupplier::getOrNull).collect(Collectors.toSet()));
    }

}
