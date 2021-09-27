package dev.itsmeow.betteranimalsplus.client;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class BetterAnimalsPlusClientForge {

    public void clientSetup(FMLClientSetupEvent event) {
        ClientLifecycleHandler.clientInit();
    }

}
