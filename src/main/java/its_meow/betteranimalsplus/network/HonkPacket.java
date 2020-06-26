package its_meow.betteranimalsplus.network;

import java.util.function.Supplier;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.client.dumb.SafeSyncThing;
import its_meow.betteranimalsplus.init.ModSoundEvents;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

public class HonkPacket {

    public static void encode(HonkPacket pkt, PacketBuffer buf) {

    }

    public static HonkPacket decode(PacketBuffer buf) {
        return new HonkPacket();
    }

    public static class Handler {
        public static void handle(HonkPacket msg, Supplier<NetworkEvent.Context> ctx) {
            // from client
            if(ctx.get().getDirection() == NetworkDirection.PLAY_TO_SERVER) {
                ctx.get().enqueueWork(() -> {
                    if(BetterAnimalsPlusMod.isDev(ctx.get().getSender()) && SafeSyncThing.get(ctx.get().getSender().getGameProfile().getId()).on) {
                        ctx.get().getSender().world.playSound(null, ctx.get().getSender().func_233580_cy_(), ModSoundEvents.GOOSE_AMBIENT, SoundCategory.PLAYERS, 2F, 1F);
                    }
                });
            }
            ctx.get().setPacketHandled(true);
        }
    }

}
