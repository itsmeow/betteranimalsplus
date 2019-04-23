package its_meow.betteranimalsplus.network;

import io.netty.buffer.ByteBuf;
import its_meow.betteranimalsplus.config.BetterAnimalsPlusConfig;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class ClientConfigurationPacket implements IMessage, IMessageHandler<ClientConfigurationPacket, IMessage> {
    
    public ClientConfigurationPacket() {}
    
    public boolean coyoteHostileDaytime = false;
    
    public ClientConfigurationPacket(boolean coyoteHostileDaytime) {
        this.coyoteHostileDaytime = coyoteHostileDaytime;
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeBoolean(this.coyoteHostileDaytime);
    }
    
    @Override
    public void fromBytes(ByteBuf buf) {
        this.coyoteHostileDaytime = buf.readBoolean();
    }

    @Override
    public IMessage onMessage(ClientConfigurationPacket message, MessageContext ctx) {
        if(ctx.side == Side.SERVER) {
            return null;
        }
        BetterAnimalsPlusConfig.coyotesHostileDaytime = message.coyoteHostileDaytime;
        return null;
    }

}