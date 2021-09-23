package dev.itsmeow.betteranimalsplus;

import com.google.common.collect.ImmutableList;
import dev.itsmeow.betteranimalsplus.client.ClientLifecycleHandler;
import dev.itsmeow.betteranimalsplus.client.dumb.SafeSyncThing;
import dev.itsmeow.betteranimalsplus.client.dumb.SafeSyncThing.DumbOptions;
import dev.itsmeow.betteranimalsplus.compat.curios.CuriosModCompat;
import dev.itsmeow.betteranimalsplus.config.BetterAnimalsPlusConfig;
import dev.itsmeow.betteranimalsplus.init.*;
import dev.itsmeow.betteranimalsplus.network.*;
import dev.itsmeow.imdlib.util.ClassLoadHacks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;

@Mod.EventBusSubscriber(modid = Ref.MOD_ID)
@Mod(value = Ref.MOD_ID)
public class BetterAnimalsPlusMod {
    
    public static final Logger logger = LogManager.getLogger();
    public static final String PROTOCOL_VERSION = "2";
    public static final SimpleChannel HANDLER = NetworkRegistry.ChannelBuilder
            .named(new ResourceLocation(Ref.MOD_ID, "main_channel"))
            .clientAcceptedVersions(PROTOCOL_VERSION::equals)
            .serverAcceptedVersions(PROTOCOL_VERSION::equals)
            .networkProtocolVersion(() -> PROTOCOL_VERSION)
            .simpleChannel();
    public static int packets = 0;
    private static final ImmutableList<UUID> DEVS = ImmutableList.of(
    UUID.fromString("81d9726a-56d4-4419-9a2a-be1d7f7f7ef1"), // its_meow
    UUID.fromString("403f2fd4-f8a2-4608-a0b8-534da4184735"), // cyber
    UUID.fromString("4605663e-fb07-4843-98c5-73adbfb2625e") // batman
    );

    public BetterAnimalsPlusMod() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(this::setup);
        modBus.addListener(this::loadComplete);
        modBus.<FMLClientSetupEvent>addListener(e -> new ClientLifecycleHandler().clientSetup(e));
        ModResources.Tags.Blocks.loadTags();
        ModResources.Tags.Items.loadTags();
        ModEntities.subscribe(modBus);
        ModBlocks.subscribe(modBus);
        ModItems.subscribe(modBus);
        ModSoundEvents.subscribe(modBus);
        ModTileEntities.subscribe(modBus);
        ModWorldGen.subscribe(modBus);
        ModTriggers.register();
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, BetterAnimalsPlusConfig.getClientSpec());
        BetterAnimalsPlusMod.logger.log(Level.INFO, "Injecting super coyotes...");
        ClassLoadHacks.runWhenLoaded("curios", () -> () -> CuriosModCompat.subscribe(modBus));
    }

    public static boolean isDev(UUID uuid) {
        return DEVS.contains(uuid);
    }

    public static boolean isDev(PlayerEntity player) {
        return isDev(player.getGameProfile().getId());
    }

    public static final ItemGroup GROUP = new ItemGroup("Better Animals+") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.ANTLER.get());
        }

        @Override
        public void fillItemList(NonNullList<ItemStack> toDisplay) {
            super.fillItemList(toDisplay);
            ModEntities.getEntities().values().forEach(cont -> toDisplay.add(new ItemStack(cont.getEggItem())));
        }
    };

    private void setup(final FMLCommonSetupEvent event) {
        HANDLER.registerMessage(packets++, ClientConfigurationPacket.class, ClientConfigurationPacket::encode, ClientConfigurationPacket::decode, ClientConfigurationPacket.Handler::handle);
        HANDLER.registerMessage(packets++, ServerNoBAMPacket.class, (pkt, buf) -> {}, buf -> new ServerNoBAMPacket(), (pkt, ctx) -> {
            ctx.get().enqueueWork(() -> ModTriggers.NO_BAM.trigger(ctx.get().getSender()));
            ctx.get().setPacketHandled(true);
        });
        HANDLER.registerMessage(packets++, ClientRequestBAMPacket.class, (pkt, buf) -> {}, buf -> new ClientRequestBAMPacket(), (pkt, ctx) -> {
            ctx.get().enqueueWork(() -> {
                if(!ModList.get().isLoaded("betteranimals")) {
                    HANDLER.sendToServer(new ServerNoBAMPacket());
                }
            });
            ctx.get().setPacketHandled(true);
        });
        HANDLER.registerMessage(packets++, StupidDevPacket.class, StupidDevPacket::encode, StupidDevPacket::decode, StupidDevPacket.Handler::handle);
        HANDLER.registerMessage(packets++, HonkPacket.class, HonkPacket::encode, HonkPacket::decode, HonkPacket.Handler::handle);
        BetterAnimalsPlusMod.logger.log(Level.INFO, "Overspawning lammergeiers...");
    }

    private void loadComplete(final FMLLoadCompleteEvent event) {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, BetterAnimalsPlusConfig.getServerSpec());
        BetterAnimalsPlusMod.logger.log(Level.INFO, "Finished crazy bird creation!");
    }

	@SubscribeEvent
	public static void onPlayerJoin(PlayerLoggedInEvent e) {
	    if(e.getPlayer() instanceof ServerPlayerEntity) {
	        HANDLER.sendTo(new ClientConfigurationPacket(BetterAnimalsPlusConfig.getTameItemsMap()), ((ServerPlayerEntity) e.getPlayer()).connection.connection, NetworkDirection.PLAY_TO_CLIENT);
	        HANDLER.sendTo(new ClientRequestBAMPacket(), ((ServerPlayerEntity) e.getPlayer()).connection.connection, NetworkDirection.PLAY_TO_CLIENT);
            for(UUID devId : DEVS) {
                HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) e.getPlayer()), new StupidDevPacket(SafeSyncThing.get(devId), devId));
            }
	    }
	}

    @SubscribeEvent
    public static void onPlayerLeave(PlayerEvent.PlayerLoggedOutEvent e) {
        if (e.getPlayer() instanceof ServerPlayerEntity) {
            for (UUID devId : DEVS) {
                SafeSyncThing.put(devId, DumbOptions.OFF);
                HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) e.getPlayer()), new StupidDevPacket(DumbOptions.OFF, devId));
            }
        }
    }

}
