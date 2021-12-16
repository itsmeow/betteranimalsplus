package dev.itsmeow.betteranimalsplus.network;

import com.google.common.base.Charsets;
import dev.itsmeow.betteranimalsplus.BetterAnimalsPlusMod;
import dev.itsmeow.betteranimalsplus.client.dumb.SafeSyncThing;
import dev.architectury.networking.NetworkManager;
import dev.architectury.utils.Env;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;

import java.util.UUID;
import java.util.function.Supplier;

public class StupidDevPacket {

    public final boolean on;
    public final boolean nametag;
    public final String variant;
    public UUID appliesTo;

    public StupidDevPacket(boolean on, boolean nametag, String variant) {
        this.on = on;
        this.nametag = nametag;
        this.variant = variant;
    }

    public StupidDevPacket(boolean on, boolean nametag, String variant, UUID appliesTo) {
        this.on = on;
        this.nametag = nametag;
        this.variant = variant;
        this.appliesTo = appliesTo;
    }

    public StupidDevPacket(SafeSyncThing.DumbOptions opt) {
        this.on = opt.on;
        this.nametag = opt.nametag;
        this.variant = opt.variant;
    }

    public StupidDevPacket(SafeSyncThing.DumbOptions opt, UUID appliesTo) {
        this.on = opt.on;
        this.nametag = opt.nametag;
        this.variant = opt.variant;
        this.appliesTo = appliesTo;
    }

    public static void encode(StupidDevPacket pkt, FriendlyByteBuf buf) {
        buf.writeBoolean(pkt.on);
        buf.writeBoolean(pkt.nametag);
        buf.writeInt(pkt.variant.length());
        buf.writeCharSequence(pkt.variant, Charsets.UTF_8);
        if (pkt.appliesTo != null) {
            buf.writeUUID(pkt.appliesTo);
        }
    }

    public static StupidDevPacket decode(FriendlyByteBuf buf) {
        boolean on = buf.readBoolean();
        boolean nametag = buf.readBoolean();
        int len = buf.readInt();
        String variant = String.valueOf(buf.readCharSequence(len, Charsets.UTF_8));
        if (buf.isReadable()) {
            UUID from = buf.readUUID();
            return new StupidDevPacket(on, nametag, variant, from);
        }
        return new StupidDevPacket(on, nametag, variant);
    }

    public static class Handler {
        public static void handle(StupidDevPacket msg, Supplier<NetworkManager.PacketContext> ctx) {
            // from server
            if (ctx.get().getEnvironment() == Env.CLIENT) {
                ctx.get().queue(() -> {
                    SafeSyncThing.put(msg.appliesTo, msg);
                });
            }
            // from client
            if (ctx.get().getEnvironment() == Env.SERVER) {
                ctx.get().queue(() -> {
                    if (BetterAnimalsPlusMod.isDev(ctx.get().getPlayer())) {
                        SafeSyncThing.put(ctx.get().getPlayer().getGameProfile().getId(), msg);
                        msg.appliesTo = ctx.get().getPlayer().getGameProfile().getId();
                        for (ServerPlayer player : ctx.get().getPlayer().getServer().getPlayerList().getPlayers()) {
                            if (player != ctx.get().getPlayer()) {
                                BetterAnimalsPlusMod.HANDLER.sendToPlayer(player, msg);
                            }
                        }
                    }
                });
            }
        }
    }
}
