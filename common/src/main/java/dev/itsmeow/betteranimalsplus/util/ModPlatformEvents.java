package dev.itsmeow.betteranimalsplus.util;

import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.architectury.utils.PlatformExpectedError;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class ModPlatformEvents {

    /**
     * @return true if cancelled, false if not
     */
    @ExpectPlatform
    public static boolean tame(TamableAnimal entity, Player player) {
        throw new PlatformExpectedError("ExpectPlatform failed: ModPlatformEvents.tame()");
    }

    /**
     * Internally checks mob grief game rule on both platforms
     * @return true if mob grief allowed, false if not
     */
    @ExpectPlatform
    public static boolean mobGrief(Level level, Mob entity) {
        throw new PlatformExpectedError("ExpectPlatform failed: ModPlatformEvents.mobGrief()");
    }

}
