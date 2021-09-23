package dev.itsmeow.betteranimalsplus;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.LivingEntityFeatureRendererRegistrationCallback;

public class FabricMod implements ModInitializer {
    @Override
    public void onInitialize() {
        BetterAnimalsPlus.init();
    }
}
