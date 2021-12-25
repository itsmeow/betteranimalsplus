package dev.itsmeow.betteranimalsplus.forge;

import dev.architectury.platform.Platform;
import dev.architectury.platform.forge.EventBuses;
import dev.itsmeow.betteranimalsplus.BetterAnimalsPlusMod;
import dev.itsmeow.betteranimalsplus.Ref;
import dev.itsmeow.betteranimalsplus.client.ClientLifecycleHandler;
import dev.itsmeow.betteranimalsplus.client.forge.BetterAnimalsPlusClientForge;
import dev.itsmeow.betteranimalsplus.compat.curios.CuriosModCompat;
import dev.itsmeow.imdlib.util.ClassLoadHacks;
import net.minecraft.nbt.Tag;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Ref.MOD_ID)
@Mod.EventBusSubscriber(modid = Ref.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BetterAnimalsPlusModForge {
    public BetterAnimalsPlusModForge() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        EventBuses.registerModEventBus(Ref.MOD_ID, modBus);
        BetterAnimalsPlusMod.construct();
        modBus.<FMLCommonSetupEvent>addListener(e -> {
            BetterAnimalsPlusMod.init(e::enqueueWork);
        });
        modBus.<FMLClientSetupEvent>addListener(e -> new BetterAnimalsPlusClientForge().clientSetup(e));
        ClassLoadHacks.runIf(Platform.getEnv() == Dist.CLIENT, () -> ClientLifecycleHandler::registerEntityRenders);
        ClassLoadHacks.runWhenLoaded("curios", () -> () -> CuriosModCompat.subscribe(modBus));
    }

    @SubscribeEvent
    public static void onPlayerRespawn(PlayerEvent.Clone event) {
        if(event.getOriginal().getPersistentData().contains("betteranimalsplus", Tag.TAG_COMPOUND)) {
            event.getPlayer().getPersistentData().put("betteranimalsplus", event.getOriginal().getPersistentData().getCompound("betteranimalsplus"));
        }
    }
}
