package dev.itsmeow.betteranimalsplus.common.fabric;

import dev.itsmeow.betteranimalsplus.common.CommonEventHandler;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.FabricLootSupplierBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.function.Function;

import static dev.itsmeow.betteranimalsplus.init.fabric.BetterAnimalsPlusModComponents.SQUIRREL_KILLS_COMPONENT;

public class CommonEventHandlerImpl {

    public static void registerPlatformEvents() {
        LootTableLoadingCallback.EVENT.register((ResourceManager resourceManager, LootTables manager, ResourceLocation id, FabricLootSupplierBuilder table, LootTableLoadingCallback.LootTableSetter setter) -> {
            for (ResourceLocation rl : CommonEventHandler.LOOT_TABLE_INJECTIONS.keys()) {
                if (id.equals(rl)) {
                    for (ResourceLocation ref : CommonEventHandler.LOOT_TABLE_INJECTIONS.get(rl)) {
                        table.pool(FabricLootPoolBuilder.builder().setRolls(ConstantValue.exactly(1)).add(LootTableReference.lootTableReference(ref)));
                    }
                    break;
                }
            }
        });
    }

    public static void setSquirrelKills(Player player, int kills) {
        SQUIRREL_KILLS_COMPONENT.get().get(player).setKills(kills);
    }

    public static void setSquirrelKills(Player player, Function<Integer, Integer> mutator) {
        SQUIRREL_KILLS_COMPONENT.get().get(player).setKills(mutator);
    }

    public static int getSquirrelKills(Player player) {
        return SQUIRREL_KILLS_COMPONENT.get().get(player).getKills();
    }

}
