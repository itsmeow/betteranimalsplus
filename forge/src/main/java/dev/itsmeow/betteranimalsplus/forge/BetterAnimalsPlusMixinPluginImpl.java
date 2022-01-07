package dev.itsmeow.betteranimalsplus.forge;

import cpw.mods.modlauncher.Launcher;
import cpw.mods.modlauncher.api.IModuleLayerManager;

import java.util.Optional;

public class BetterAnimalsPlusMixinPluginImpl {
    public static boolean shouldApplyMixinPlatform() {
        Optional<IModuleLayerManager> mgr = Launcher.INSTANCE.findLayerManager();
        if(mgr.isPresent()) {
            Optional<ModuleLayer> layer = mgr.get().getLayer(IModuleLayerManager.Layer.GAME);
            if(layer.isPresent()) {
                return layer.get().configuration().findModule("architectury").isPresent();
            }
        }
        return true;
    }
}
