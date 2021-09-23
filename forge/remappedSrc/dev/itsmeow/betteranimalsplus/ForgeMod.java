package dev.itsmeow.betteranimalsplus;

import me.shedaniel.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(BetterAnimalsPlus.MOD_ID)
public class ForgeMod {
    public ForgeMod() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(BetterAnimalsPlus.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        BetterAnimalsPlus.init();
    }
}
