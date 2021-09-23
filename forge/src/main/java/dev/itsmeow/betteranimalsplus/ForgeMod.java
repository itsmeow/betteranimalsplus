package dev.itsmeow.betteranimalsplus;

import me.shedaniel.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Ref.MOD_ID)
public class ForgeMod {
    public ForgeMod() {
        EventBuses.registerModEventBus(Ref.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        BetterAnimalsPlusMod.init();
    }
}
