package its_meow.betteranimalsplus.network;

import java.util.HashMap;
import java.util.Map;

import io.netty.buffer.ByteBuf;
import its_meow.betteranimalsplus.config.BetterAnimalsPlusConfig;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.util.EntityConfigurationSection;
import its_meow.betteranimalsplus.util.EntityContainer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class ClientConfigurationPacket implements IMessage, IMessageHandler<ClientConfigurationPacket, IMessage> {

    public ClientConfigurationPacket() {}

    public boolean coyoteHostileDaytime = false;
    public Map<String, String[]> tameItems = new HashMap<String, String[]>();

    public ClientConfigurationPacket(boolean coyoteHostileDaytime, Map<String, String[]> tameItems) {
        this.coyoteHostileDaytime = coyoteHostileDaytime;
        this.tameItems = tameItems;
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeBoolean(this.coyoteHostileDaytime);
        buf.writeInt(tameItems.size());
        for(String key : tameItems.keySet()) {
            ByteBufUtils.writeUTF8String(buf, key);
            String[] items = tameItems.get(key);
            if(items != null) {
                buf.writeInt(items.length);
                for(String value : items) {
                    ByteBufUtils.writeUTF8String(buf, value);
                }
            } else {
                buf.writeInt(0);
            }
        }
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.coyoteHostileDaytime = buf.readBoolean();
        tameItems = new HashMap<String, String[]>();
        int mapSize = buf.readInt();
        for(int l = 0; l < mapSize; l++) {
            String key = ByteBufUtils.readUTF8String(buf);
            int tameItemSize = buf.readInt();
            String[] value = new String[tameItemSize];
            for(int i = 0; i < tameItemSize; i++) {
                value[i] = ByteBufUtils.readUTF8String(buf);
            }
            tameItems.put(key, value);
        }
    }

    @Override
    public IMessage onMessage(ClientConfigurationPacket message, MessageContext ctx) {
        if(ctx.side == Side.SERVER) {
            return null;
        }
        BetterAnimalsPlusConfig.coyotesHostileDaytime = message.coyoteHostileDaytime;
        for(String key : message.tameItems.keySet()) {
            String[] items = message.tameItems.get(key);
            EntityContainer container = ModEntities.entityMap.get(key);
            EntityConfigurationSection section = BetterAnimalsPlusConfig.sections.get(container);
            if(section != null) {
                section.tameItems = items;
            }
        }
        return null;
    }

}