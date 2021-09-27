package dev.itsmeow.betteranimalsplus.network;

/*import dev.itsmeow.betteranimalsplus.BetterAnimalsPlusMod;
import dev.itsmeow.betteranimalsplus.client.dumb.SafeSyncThing;
import dev.itsmeow.betteranimalsplus.init.ModSoundEvents;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;*/

import net.minecraft.network.FriendlyByteBuf;

public class HonkPacket {

    public static void encode(HonkPacket pkt, FriendlyByteBuf buf) {

    }

    public static HonkPacket decode(FriendlyByteBuf buf) {
        return new HonkPacket();
    }

    public static class Handler {
        /*public static void handle(HonkPacket msg, Supplier<NetworkEvent.Context> ctx) {
            // from client
            if (ctx.get().getDirection() == NetworkDirection.PLAY_TO_SERVER) {
                ctx.get().enqueueWork(() -> {
                    if (BetterAnimalsPlusMod.isDev(ctx.get().getSender()) && SafeSyncThing.get(ctx.get().getSender().getGameProfile().getId()).on) {
                        ctx.get().getSender().world.playSound(null, ctx.get().getSender().getPosition(), ModSoundEvents.GOOSE_AMBIENT.get(), SoundCategory.PLAYERS, 2F, 1F);
                    }
                });
            }
            ctx.get().setPacketHandled(true);
        }*/
    }

}
