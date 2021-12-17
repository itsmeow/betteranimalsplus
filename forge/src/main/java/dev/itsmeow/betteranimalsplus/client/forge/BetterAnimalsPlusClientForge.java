package dev.itsmeow.betteranimalsplus.client.forge;

import dev.itsmeow.betteranimalsplus.client.ClientLifecycleHandler;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class BetterAnimalsPlusClientForge {

    public void clientSetup(FMLClientSetupEvent event) {
        ClientLifecycleHandler.clientInit();
    }

}
