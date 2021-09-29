package dev.itsmeow.betteranimalsplus.network;

import dev.itsmeow.betteranimalsplus.BetterAnimalsPlusMod;
import dev.itsmeow.betteranimalsplus.client.dumb.SafeSyncThing;
import dev.itsmeow.betteranimalsplus.init.ModSoundEvents;
import me.shedaniel.architectury.networking.NetworkManager;
import me.shedaniel.architectury.utils.Env;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.sounds.SoundSource;

import java.util.function.Supplier;

public class HonkPacket {

    public static void encode(HonkPacket pkt, FriendlyByteBuf buf) {

    }

    public static HonkPacket decode(FriendlyByteBuf buf) {
        return new HonkPacket();
    }

    public static class Handler {
        public static void handle(HonkPacket msg, Supplier<NetworkManager.PacketContext> ctx) {
            // from client
            if (ctx.get().getEnvironment() == Env.SERVER) {
                ctx.get().queue(() -> {
                    if (BetterAnimalsPlusMod.isDev(ctx.get().getPlayer()) && SafeSyncThing.get(ctx.get().getPlayer().getGameProfile().getId()).on) {
                        ctx.get().getPlayer().level.playSound(null, ctx.get().getPlayer().blockPosition(), ModSoundEvents.GOOSE_AMBIENT.get(), SoundSource.PLAYERS, 2F, 1F);
                    }
                });
            }
        }
    }

}
