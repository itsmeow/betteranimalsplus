package its_meow.betteranimalsplus.network;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.google.common.base.Charsets;

import its_meow.betteranimalsplus.config.BetterAnimalsPlusConfig;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.util.EntityTypeContainer;
import its_meow.betteranimalsplus.util.EntityTypeContainerTameable;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

public class ClientConfigurationPacket {
    
    public ClientConfigurationPacket() {}
    
    public boolean coyoteHostileDaytime = false;
    public Map<String, String[]> tameItems = new HashMap<String, String[]>();
    
    public ClientConfigurationPacket(boolean coyoteHostileDaytime, Map<String, String[]> tameItems) {
        this.coyoteHostileDaytime = coyoteHostileDaytime;
        this.tameItems = tameItems;
    }
    
    public static void encode(ClientConfigurationPacket pkt, PacketBuffer buf) {
        buf.writeBoolean(pkt.coyoteHostileDaytime);
        buf.writeInt(pkt.tameItems.size());
        for(String key : pkt.tameItems.keySet()) {
            buf.writeInt(key.length());
            buf.writeCharSequence(key, Charsets.UTF_8);
            String[] items = pkt.tameItems.get(key);
            if(items != null) {
                buf.writeInt(items.length);
                for(String value : items) {
                    buf.writeInt(value.length());
                    buf.writeCharSequence(value, Charsets.UTF_8);
                }
            } else {
                buf.writeInt(0);
            }
        }
    }

    public static ClientConfigurationPacket decode(PacketBuffer buf) {
        boolean coyote = buf.readBoolean();
        Map<String, String[]> tames = new HashMap<String, String[]>();
        int mapSize = buf.readInt();
        for(int l = 0; l < mapSize; l++) {
            int keyL = buf.readInt();
            String key = String.valueOf(buf.readCharSequence(keyL, Charsets.UTF_8));
            int tameItemSize = buf.readInt();
            String[] value = new String[tameItemSize];
            for(int i = 0; i < tameItemSize; i++) {
                int valueL = buf.readInt();
                value[i] = String.valueOf(buf.readCharSequence(valueL, Charsets.UTF_8));
            }
            tames.put(key, value);
        }
        return new ClientConfigurationPacket(coyote, tames);
    }
    
    public static class Handler {
        public static boolean handle(ClientConfigurationPacket msg, Supplier<NetworkEvent.Context> ctx) {
            BetterAnimalsPlusConfig.coyotesHostileDaytime = msg.coyoteHostileDaytime;
            for(String key : msg.tameItems.keySet()) {
                String[] items = msg.tameItems.get(key);
                EntityTypeContainer<?> container = ModEntities.ENTITIES.get(key);
                if(container != null && container instanceof EntityTypeContainerTameable) {
                    EntityTypeContainerTameable<?> cont2 = (EntityTypeContainerTameable<?>) container;
                    cont2.setTameItems(items);
                }
            }
            return true;
        }
    }

}