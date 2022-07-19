package dev.itsmeow.betteranimalsplus.client.dumb.forge;

import dev.itsmeow.betteranimalsplus.client.dumb.DeveloperRenderThing;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.MinecraftForge;

public class DeveloperRenderThingImpl {

    public static void initPlatformEvents() {
        MinecraftForge.EVENT_BUS.addListener(DeveloperRenderThingImpl::renderPlayer);
    }

    public static void renderPlayer(RenderPlayerEvent.Pre event) {
        if (DeveloperRenderThing.shouldRender(event.getEntity())) {
            DeveloperRenderThing.playerRender(event.getEntity(), event.getRenderer(), event.getPartialTick(), event.getPoseStack(), event.getMultiBufferSource(), event.getPackedLight());
            event.setCanceled(true);
        }
    }

}
