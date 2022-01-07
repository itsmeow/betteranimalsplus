package dev.itsmeow.betteranimalsplus.client.dumb;

import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.blaze3d.vertex.PoseStack;
import dev.architectury.event.CompoundEventResult;
import dev.architectury.event.events.client.ClientChatEvent;
import dev.architectury.event.events.client.ClientPlayerEvent;
import dev.architectury.event.events.client.ClientTickEvent;
import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.architectury.platform.Platform;
import dev.architectury.utils.PlatformExpectedError;
import dev.itsmeow.betteranimalsplus.BetterAnimalsPlusMod;
import dev.itsmeow.betteranimalsplus.Ref;
import dev.itsmeow.betteranimalsplus.client.model.entity.ModelGoose;
import dev.itsmeow.betteranimalsplus.client.renderer.entity.layers.GooseItemLayerRenderer;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.mixin.EntityRendererAccessor;
import dev.itsmeow.betteranimalsplus.network.HonkPacket;
import dev.itsmeow.betteranimalsplus.network.StupidDevPacket;
import dev.itsmeow.imdlib.entity.util.variant.IVariant;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

public class DeveloperRenderThing {

    private static StupidRender RENDER_INSTANCE;
    private static int timeSinceLastPacket = 0;

    public static void init() {
        ClientPlayerEvent.CLIENT_PLAYER_QUIT.register(player -> SafeSyncThing.clear());
        ClientTickEvent.CLIENT_PRE.register(DeveloperRenderThing::clientTick);
        if (Platform.isForge())
            ClientChatEvent.PROCESS.register(DeveloperRenderThing::chat);
        initPlatformEvents();
    }

    public static void clientTick(Minecraft minecraft) {
        if (timeSinceLastPacket > 0) {
            timeSinceLastPacket--;
        }
        if (timeSinceLastPacket <= 0) {
            long handle = Minecraft.getInstance().getWindow().getWindow();
            if (InputConstants.isKeyDown(handle, InputConstants.KEY_H) && InputConstants.isKeyDown(handle, InputConstants.KEY_LCONTROL)) {
                timeSinceLastPacket = 10;
                BetterAnimalsPlusMod.HANDLER.sendToServer(new HonkPacket());
            }
        }
    }

    public static boolean shouldRender(Player player) {
        return SafeSyncThing.get(player.getGameProfile().getId()).on;
    }

    public static void playerRender(Player player, PlayerRenderer renderer, float partialTicks, PoseStack stack, MultiBufferSource buffers, int packedLight) {
        if (RENDER_INSTANCE == null) {
            RENDER_INSTANCE = new StupidRender(new EntityRendererProvider.Context(((EntityRendererAccessor) renderer).getEntityRenderDispatcher(), Minecraft.getInstance().getItemRenderer(), Minecraft.getInstance().getResourceManager(), Minecraft.getInstance().getEntityModels(), renderer.getFont()));
        }
        float rot = interpolateRotation(player.yRotO, player.getYRot(), partialTicks);
        RENDER_INSTANCE.render(player, rot, partialTicks, stack, buffers, packedLight);
    }

    public static float interpolateRotation(float prevRotation, float nextRotation, float partialTick) {
        float f3;
        for (f3 = nextRotation - prevRotation; f3 < -180.0F; f3 += 360.0F) {
        }
        while (f3 >= 180.0F) {
            f3 -= 360.0F;
        }
        return prevRotation + partialTick * f3;
    }

    public static CompoundEventResult<String> chat(String m) {
        if (BetterAnimalsPlusMod.isDev(Minecraft.getInstance().player)) {
            if (m.startsWith("/goosedev")) {
                String[] args = m.split(" ");
                if (args.length < 2 || args.length > 4) {
                    msg("[BA+] Invalid length. Args 2 & 3 optional. Default nametag OFF, variant 1. Usage: /goosedev [on/off] [show nametag(on/off)] [variant]");
                    return CompoundEventResult.interruptFalse(m);
                }
                if (!args[1].equals("on") && !args[1].equals("off")) {
                    msg("[BA+] Invalid option for argument 1. Must be \"on\" or \"off\"");
                    return CompoundEventResult.interruptFalse(m);
                }
                boolean on = args[1].equals("on");
                boolean nametag = false;
                String variant = "1";
                if (on) {
                    if (args.length >= 3) {
                        if (!args[2].equals("on") && !args[2].equals("off")) {
                            msg("[BA+] Invalid option for argument 2. Must be \"on\" or \"off\"");
                            return CompoundEventResult.interruptFalse(m);
                        }
                        nametag = args[2].equals("on");
                        if (args.length == 4) {
                            if (!args[3].equals("1") && !args[3].equals("2") && !args[3].equals("3")) {
                                msg("[BA+] Invalid option for argument 3. Must be 1, 2, or 3");
                                return CompoundEventResult.interruptFalse(m);
                            }
                            variant = args[3];
                        }
                    }
                } else if (args.length >= 3) {
                    msg("[BA+] Too many arguments for disabling goose!");
                    return CompoundEventResult.interruptFalse(m);
                }
                msg("Goose " + (on ? "ENABLED" : "DISABLED") + " with nametag " + (nametag ? "ENABLED" : "DISABLED") + " and variant " + variant);
                StupidDevPacket pkt = new StupidDevPacket(on, nametag, variant);
                SafeSyncThing.put(Minecraft.getInstance().player.getGameProfile().getId(), pkt);
                BetterAnimalsPlusMod.HANDLER.sendToServer(pkt);
                return CompoundEventResult.interruptFalse(m);
            } else if (m.startsWith("/help goosedev")) {
                msg("[BA+] Args 2 & 3 optional. Default nametag OFF, variant 1. Usage: /goosedev [on/off] [show nametag(on/off)] [variant]");
                return CompoundEventResult.interruptFalse(m);
            }
        }
        return CompoundEventResult.pass();
    }

    private static void msg(String msg) {
        Minecraft.getInstance().player.sendMessage(new TextComponent(msg), Util.NIL_UUID);
    }

    public static class StupidRender extends LivingEntityRenderer<Player, EntityModel<Player>> {

        public StupidRender(EntityRendererProvider.Context mgr) {
            super(mgr, new ModelGoose<>(mgr.bakeLayer(new ModelLayerLocation(new ResourceLocation(Ref.MOD_ID, "goose"), "main"))), 0.5F);
            this.addLayer(new GooseItemLayerRenderer<>(this));
        }

        @Override
        public void render(Player entity, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
            super.render(entity, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        }

        @Override
        protected boolean shouldShowName(Player entity) {
            return SafeSyncThing.get(entity.getGameProfile().getId()).nametag;
        }

        @Override
        protected void scale(Player player, PoseStack stack, float partialTickTime) {
            stack.scale(0.8F, 0.8F, 0.8F);
        }

        @Override
        public ResourceLocation getTextureLocation(Player player) {
            IVariant v = ModEntities.GOOSE.getVariantForName(SafeSyncThing.get(player.getGameProfile().getId()).variant).orElse(null);
            return v != null ? v.getTexture(null) : null;
        }

    }

    @ExpectPlatform
    public static void initPlatformEvents() {
        throw new PlatformExpectedError("DeveloperRenderThing.initPlatformEvents()");
    }
}
