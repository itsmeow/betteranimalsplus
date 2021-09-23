package dev.itsmeow.betteranimalsplus;

import com.google.common.collect.ImmutableList;
import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.itsmeow.betteranimalsplus.compat.curios.CuriosModCompat;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModItems;
import dev.itsmeow.imdlib.util.ClassLoadHacks;
import me.shedaniel.architectury.utils.PlatformExpectedError;
import net.minecraft.core.NonNullList;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;

//@Mod.EventBusSubscriber(modid = Ref.MOD_ID)
//@Mod(value = Ref.MOD_ID)
public class BetterAnimalsPlusMod {

    public static final Logger logger = LogManager.getLogger();
    /*public static final String PROTOCOL_VERSION = "2";
    public static final SimpleChannel HANDLER = NetworkRegistry.ChannelBuilder
            .named(new ResourceLocation(Ref.MOD_ID, "main_channel"))
            .clientAcceptedVersions(PROTOCOL_VERSION::equals)
            .serverAcceptedVersions(PROTOCOL_VERSION::equals)
            .networkProtocolVersion(() -> PROTOCOL_VERSION)
            .simpleChannel();
    public static int packets = 0;*/
    private static final ImmutableList<UUID> DEVS = ImmutableList.of(
    UUID.fromString("81d9726a-56d4-4419-9a2a-be1d7f7f7ef1"), // its_meow
    UUID.fromString("403f2fd4-f8a2-4608-a0b8-534da4184735"), // cyber
    UUID.fromString("4605663e-fb07-4843-98c5-73adbfb2625e") // batman
    );

    public BetterAnimalsPlusMod() {
       /* IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
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
        */
        ModItems.init();
        BetterAnimalsPlusMod.logger.log(Level.INFO, "Injecting super coyotes...");
        //ClassLoadHacks.runWhenLoaded("curios", () -> () -> CuriosModCompat.subscribe(modBus));


    }

    public static boolean isDev(UUID uuid) {
        return DEVS.contains(uuid);
    }

    public static boolean isDev(Player player) {
        return isDev(player.getGameProfile().getId());
    }

    public static final CreativeModeTab TAB = getPlatformTab();

    @ExpectPlatform
    private static CreativeModeTab getPlatformTab() {
        throw new PlatformExpectedError("getPlatformTab(): Expected Platform");
    }

    /*
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
    */
}
