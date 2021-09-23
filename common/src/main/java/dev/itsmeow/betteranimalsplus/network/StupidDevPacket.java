package dev.itsmeow.betteranimalsplus.network;

import java.util.UUID;
import java.util.function.Supplier;

import com.google.common.base.Charsets;

import dev.itsmeow.betteranimalsplus.BetterAnimalsPlusMod;
import dev.itsmeow.betteranimalsplus.client.dumb.SafeSyncThing;
import dev.itsmeow.betteranimalsplus.client.dumb.SafeSyncThing.DumbOptions;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.PacketDistributor;

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

    public StupidDevPacket(DumbOptions opt) {
        this.on = opt.on;
        this.nametag = opt.nametag;
        this.variant = opt.variant;
    }

    public StupidDevPacket(DumbOptions opt, UUID appliesTo) {
        this.on = opt.on;
        this.nametag = opt.nametag;
        this.variant = opt.variant;
        this.appliesTo = appliesTo;
    }

    public static void encode(StupidDevPacket pkt, PacketBuffer buf) {
        buf.writeBoolean(pkt.on);
        buf.writeBoolean(pkt.nametag);
        buf.writeInt(pkt.variant.length());
        buf.writeCharSequence(pkt.variant, Charsets.UTF_8);
        if(pkt.appliesTo != null) {
            buf.writeUUID(pkt.appliesTo);
        }
    }

    public static StupidDevPacket decode(PacketBuffer buf) {
        boolean on = buf.readBoolean();
        boolean nametag = buf.readBoolean();
        int len = buf.readInt();
        String variant = String.valueOf(buf.readCharSequence(len, Charsets.UTF_8));
        if(buf.isReadable()) {
            UUID from = buf.readUUID();
            return new StupidDevPacket(on, nametag, variant, from);
        }
        return new StupidDevPacket(on, nametag, variant);
    }

    public static class Handler {
        public static void handle(StupidDevPacket msg, Supplier<NetworkEvent.Context> ctx) {
            // from server
            if(ctx.get().getDirection() == NetworkDirection.PLAY_TO_CLIENT) {
                ctx.get().enqueueWork(() -> {
                    SafeSyncThing.put(msg.appliesTo, msg);
                });
            }
            // from client
            if(ctx.get().getDirection() == NetworkDirection.PLAY_TO_SERVER) {
                ctx.get().enqueueWork(() -> {
                    if(BetterAnimalsPlusMod.isDev(ctx.get().getSender())) {
                        SafeSyncThing.put(ctx.get().getSender().getGameProfile().getId(), msg);
                        msg.appliesTo = ctx.get().getSender().getGameProfile().getId();
                        for(ServerPlayerEntity player : ctx.get().getSender().getServer().getPlayerList().getPlayers()) {
                            if(player != ctx.get().getSender()) {
                                BetterAnimalsPlusMod.HANDLER.send(PacketDistributor.PLAYER.with(() -> player), msg);
                            }
                        }
                    }
                });
            }
            ctx.get().setPacketHandled(true);
        }
    }
}
