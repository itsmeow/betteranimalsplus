package its_meow.betteranimalsplus.client;

import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.init.TextureRegistry;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
@EventBusSubscriber(modid = Ref.MOD_ID)
public class EventHandlerClient {
	
	@SubscribeEvent
	public void textureStitchEventPre(TextureStitchEvent.Pre event)
	{	
		event.getMap().registerSprite(TextureRegistry.sparks);
		event.getMap().registerSprite(TextureRegistry.ember_left);
		event.getMap().registerSprite(TextureRegistry.ember_mid);
		event.getMap().registerSprite(TextureRegistry.ember_right);
	}

	
}
