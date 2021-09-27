package dev.itsmeow.betteranimalsplus;

import dev.itsmeow.betteranimalsplus.client.BetterAnimalsPlusClientForge;
import me.shedaniel.architectury.platform.forge.EventBuses;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Ref.MOD_ID)
public class BetterAnimalsPlusModForge {
    public BetterAnimalsPlusModForge() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        EventBuses.registerModEventBus(Ref.MOD_ID, modBus);
        BetterAnimalsPlusMod.init();
        modBus.<FMLClientSetupEvent>addListener(e -> new BetterAnimalsPlusClientForge().clientSetup(e));
    }
}
