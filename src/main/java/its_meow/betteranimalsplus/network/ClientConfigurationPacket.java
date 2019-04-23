package its_meow.betteranimalsplus.network;

import java.util.function.Supplier;

import its_meow.betteranimalsplus.config.BetterAnimalsPlusConfig;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

public class ClientConfigurationPacket {
    
    public ClientConfigurationPacket() {}
    
    public boolean coyoteHostileDaytime = false;
    
    public ClientConfigurationPacket(boolean coyoteHostileDaytime) {
        this.coyoteHostileDaytime = coyoteHostileDaytime;
    }
    
    public static void encode(ClientConfigurationPacket pkt, PacketBuffer buf) {
        buf.writeBoolean(pkt.coyoteHostileDaytime);
    }

    public static ClientConfigurationPacket decode(PacketBuffer buf) {
        return new ClientConfigurationPacket(buf.readBoolean());
    }
    
    public static class Handler {
        public static void handle(ClientConfigurationPacket msg, Supplier<NetworkEvent.Context> ctx) {
            if(ctx.get().getDirection() != NetworkDirection.PLAY_TO_CLIENT) {
                return;
            }
            BetterAnimalsPlusConfig.coyotesHostileDaytime = msg.coyoteHostileDaytime;
        }
    }

}