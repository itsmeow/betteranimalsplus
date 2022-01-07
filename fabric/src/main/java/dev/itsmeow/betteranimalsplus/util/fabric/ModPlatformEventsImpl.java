package dev.itsmeow.betteranimalsplus.util.fabric;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;

public class ModPlatformEventsImpl {

    public static boolean tame(TamableAnimal entity, Player player) {
        return false;
    }

    public static boolean mobGrief(Level level, Mob entity) {
        return level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING);
    }

    public static boolean isLoaded(String modid) {
        return FabricLoader.getInstance().isModLoaded(modid);
    }

}
