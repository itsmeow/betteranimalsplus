package dev.itsmeow.betteranimalsplus.client;

import net.fabricmc.api.ClientModInitializer;

public class BetterAnimalsPlusClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientLifecycleHandler.clientInit();
    }
}
