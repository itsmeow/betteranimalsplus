package dev.itsmeow.betteranimalsplus;

import net.fabricmc.api.ModInitializer;

public class BetterAnimalsPlusModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        BetterAnimalsPlusMod.construct();
        BetterAnimalsPlusMod.init(Runnable::run);
    }
}
