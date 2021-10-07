package dev.itsmeow.betteranimalsplus.common.fabric;

import static dev.itsmeow.betteranimalsplus.BetterAnimalsPlusModFabric.BetterAnimalsPlusModComponents.SQUIRREL_KILLS_COMPONENT;
import net.minecraft.world.entity.player.Player;

import java.util.function.Function;

public class CommonEventHandlerImpl {

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
