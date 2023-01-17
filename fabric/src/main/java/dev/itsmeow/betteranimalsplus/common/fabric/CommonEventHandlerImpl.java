package dev.itsmeow.betteranimalsplus.common.fabric;

import dev.itsmeow.betteranimalsplus.common.CommonEventHandler;
import dev.itsmeow.betteranimalsplus.util.ISquirrelData;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.loot.v2.LootTableSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.function.Function;

public class CommonEventHandlerImpl {

    public static void registerPlatformEvents() {
    }

    public static void setSquirrelKills(Player player, int kills) {
        if(player instanceof ISquirrelData)
            ((ISquirrelData) player).setSquirrelKills(kills);
    }

    public static void setSquirrelKills(Player player, Function<Integer, Integer> mutator) {
        if(player instanceof ISquirrelData)
            ((ISquirrelData) player).setSquirrelKills(mutator);
    }

    public static int getSquirrelKills(Player player) {
        if(player instanceof ISquirrelData)
            return ((ISquirrelData) player).getSquirrelKills();
        return 0;
    }

}
