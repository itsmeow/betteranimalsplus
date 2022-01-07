package dev.itsmeow.betteranimalsplus.util.forge;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fml.ModList;

public class ModPlatformEventsImpl {

    public static boolean tame(TamableAnimal entity, Player player) {
        return ForgeEventFactory.onAnimalTame(entity, player);
    }

    public static boolean mobGrief(Level level, Mob entity) {
        return ForgeEventFactory.getMobGriefingEvent(level, entity);
    }

    public static boolean isLoaded(String modid) {
        return ModList.get().isLoaded(modid);
    }

}
