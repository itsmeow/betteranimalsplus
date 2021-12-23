package dev.itsmeow.betteranimalsplus;

import com.google.common.collect.ImmutableList;
import dev.architectury.event.events.common.PlayerEvent;
import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.architectury.networking.NetworkChannel;
import dev.architectury.platform.Platform;
import dev.architectury.utils.Env;
import dev.architectury.utils.PlatformExpectedError;
import dev.itsmeow.betteranimalsplus.client.dumb.SafeSyncThing;
import dev.itsmeow.betteranimalsplus.common.CommonEventHandler;
import dev.itsmeow.betteranimalsplus.common.entity.EntityCoyote;
import dev.itsmeow.betteranimalsplus.common.entity.util.EntityTypeContainerBAPTameable;
import dev.itsmeow.betteranimalsplus.init.*;
import dev.itsmeow.betteranimalsplus.network.*;
import dev.itsmeow.imdlib.IMDLib;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class BetterAnimalsPlusMod {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final NetworkChannel HANDLER = NetworkChannel.create(new ResourceLocation(Ref.MOD_ID, "main_channel"));
    private static final ImmutableList<UUID> DEVS = ImmutableList.of(
            UUID.fromString("81d9726a-56d4-4419-9a2a-be1d7f7f7ef1"),
            UUID.fromString("403f2fd4-f8a2-4608-a0b8-534da4184735"),
            UUID.fromString("4605663e-fb07-4843-98c5-73adbfb2625e")
    );

    public static void construct() {
        IMDLib.setRegistry(Ref.MOD_ID);
        ModResources.Tags.Blocks.loadTags();
        ModResources.Tags.Items.loadTags();
        ModSoundEvents.init();
        ModEntities.init();
        ModBlocks.init();
        ModItems.init();
        ModBlockEntities.init();
        ModTriggers.register();
        LOGGER.info("Injecting super coyotes...");
        HANDLER.register(ClientConfigurationPacket.class, ClientConfigurationPacket::encode, ClientConfigurationPacket::decode, ClientConfigurationPacket.Handler::handle);
        HANDLER.register(ServerNoBAMPacket.class, (pkt, buf) -> {}, buf -> new ServerNoBAMPacket(), (pkt, ctx) -> {
            if(ctx.get().getEnvironment() == Env.SERVER) {
                ctx.get().queue(() -> ModTriggers.NO_BAM.trigger((ServerPlayer) ctx.get().getPlayer()));
            }
        });
        HANDLER.register(ClientRequestBAMPacket.class, (pkt, buf) -> {}, buf -> new ClientRequestBAMPacket(), (pkt, ctx) -> {
            if(ctx.get().getEnvironment() == Env.CLIENT) {
                ctx.get().queue(() -> {
                    if (!Platform.isModLoaded("betteranimals")) {
                        HANDLER.sendToServer(new ServerNoBAMPacket());
                    }
                });
            }
        });
        HANDLER.register(StupidDevPacket.class, StupidDevPacket::encode, StupidDevPacket::decode, StupidDevPacket.Handler::handle);
        HANDLER.register(HonkPacket.class, HonkPacket::encode, HonkPacket::decode, HonkPacket.Handler::handle);
        PlayerEvent.PLAYER_JOIN.register(BetterAnimalsPlusMod::onPlayerJoin);
        PlayerEvent.PLAYER_QUIT.register(BetterAnimalsPlusMod::onPlayerLeave);
        CommonEventHandler.init();
    }

    public static void init(Consumer<Runnable> enqueue) {
        ModWorldGen.init(enqueue);
        LOGGER.info("Overspawning lammergeiers...");
    }

    public static boolean isDev(UUID uuid) {
        return DEVS.contains(uuid);
    }

    public static boolean isDev(Player player) {
        return isDev(player.getGameProfile().getId());
    }

    public static final CreativeModeTab TAB = getPlatformTab();

    @ExpectPlatform
    public static CreativeModeTab getPlatformTab() {
        throw new PlatformExpectedError("getPlatformTab(): Expected Platform");
    }

    public static void onPlayerJoin(ServerPlayer player) {
        HANDLER.sendToPlayer(player, new ClientConfigurationPacket(ModEntities.COYOTE.getCustomConfiguration().getBoolean(EntityCoyote.HOSTILE_DAYTIME_KEY), ModEntities.getEntities().values().stream()
                .filter(c -> c instanceof EntityTypeContainerBAPTameable).map(c -> (EntityTypeContainerBAPTameable) c)
                .collect(Collectors.toMap(EntityTypeContainer::getEntityName, EntityTypeContainerBAPTameable::getTameItems))));
        HANDLER.sendToPlayer(player, new ClientRequestBAMPacket());
        for (UUID devId : DEVS) {
            HANDLER.sendToPlayer(player, new StupidDevPacket(SafeSyncThing.get(devId), devId));
        }
    }

    public static void onPlayerLeave(ServerPlayer player) {
        for (UUID devId : DEVS) {
            SafeSyncThing.put(devId, SafeSyncThing.DumbOptions.OFF);
            HANDLER.sendToPlayer(player, new StupidDevPacket(SafeSyncThing.DumbOptions.OFF, devId));
        }
    }

}
