package dev.itsmeow.betteranimalsplus.fabric;

import dev.itsmeow.betteranimalsplus.BetterAnimalsPlusMod;
import dev.itsmeow.betteranimalsplus.compat.trinkets.TrinketsModCompat;
import dev.itsmeow.imdlib.util.ClassLoadHacks;
import net.fabricmc.api.ModInitializer;

public class BetterAnimalsPlusModFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        BetterAnimalsPlusMod.construct();
        BetterAnimalsPlusMod.init(Runnable::run);
        ClassLoadHacks.runWhenLoaded("trinkets", () -> () -> TrinketsModCompat.init());
    }

}
