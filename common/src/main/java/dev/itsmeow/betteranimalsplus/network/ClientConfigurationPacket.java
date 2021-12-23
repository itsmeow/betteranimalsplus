package dev.itsmeow.betteranimalsplus.network;

import com.google.common.base.Charsets;
import dev.itsmeow.betteranimalsplus.common.entity.EntityCoyote;
import dev.itsmeow.betteranimalsplus.common.entity.util.EntityTypeContainerBAPTameable;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.architectury.networking.NetworkManager;
import dev.architectury.utils.Env;
import net.minecraft.network.FriendlyByteBuf;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ClientConfigurationPacket {

    public boolean coyotesHostileDaytime;
    public Map<String, String[]> tameItems;

    public ClientConfigurationPacket(boolean coyoteHostile, Map<String, String[]> tameItems) {
        this.coyotesHostileDaytime = coyoteHostile;
        this.tameItems = tameItems;
    }

    public static void encode(ClientConfigurationPacket pkt, FriendlyByteBuf buf) {
        buf.writeBoolean(ModEntities.COYOTE.getCustomConfiguration().getBoolean(EntityCoyote.HOSTILE_DAYTIME_KEY));
        buf.writeInt(pkt.tameItems.size());
        for (String key : pkt.tameItems.keySet()) {
            buf.writeInt(key.length());
            buf.writeCharSequence(key, Charsets.UTF_8);
            String[] items = pkt.tameItems.get(key);
            if (items != null) {
                buf.writeInt(items.length);
                for (String value : items) {
                    buf.writeInt(value.length());
                    buf.writeCharSequence(value, Charsets.UTF_8);
                }
            } else {
                buf.writeInt(0);
            }
        }
    }

    public static ClientConfigurationPacket decode(FriendlyByteBuf buf) {
        boolean coyoteHostile = buf.readBoolean();
        Map<String, String[]> tames = new HashMap<>();
        int mapSize = buf.readInt();
        for (int l = 0; l < mapSize; l++) {
            int keyL = buf.readInt();
            String key = String.valueOf(buf.readCharSequence(keyL, Charsets.UTF_8));
            int tameItemSize = buf.readInt();
            String[] value = new String[tameItemSize];
            for (int i = 0; i < tameItemSize; i++) {
                int valueL = buf.readInt();
                value[i] = String.valueOf(buf.readCharSequence(valueL, Charsets.UTF_8));
            }
            tames.put(key, value);
        }
        return new ClientConfigurationPacket(coyoteHostile, tames);
    }

    public static class Handler {
        public static void handle(ClientConfigurationPacket msg, Supplier<NetworkManager.PacketContext> ctx) {
            if (ctx.get().getEnvironment() == Env.CLIENT) {
                ctx.get().queue(() -> {
                    EntityCoyote.client_hostile_override = msg.coyotesHostileDaytime;
                    for (String key : msg.tameItems.keySet()) {
                        String[] items = msg.tameItems.get(key);
                        EntityTypeContainer<?> container = ModEntities.H.getEntityTypeContainer(key);
                        if (container instanceof EntityTypeContainerBAPTameable) {
                            EntityTypeContainerBAPTameable<?> cont2 = (EntityTypeContainerBAPTameable<?>) container;
                            cont2.setTameItems(items);
                        }
                    }
                });
            }
        }
    }

}