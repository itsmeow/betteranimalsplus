package dev.itsmeow.betteranimalsplus.client.dumb;

//@Mod.EventBusSubscriber(modid = Ref.MOD_ID, value = Dist.CLIENT)
public class DeveloperRenderThing {
    // TODO render goose
/*
    private static StupidRender RENDER_INSTANCE;
    private static int timeSinceLastPacket = 0;

    @SubscribeEvent
    public static void onLogout(ClientPlayerNetworkEvent.LoggedOutEvent event) {
        SafeSyncThing.clear();
    }

    @SubscribeEvent
    public static void onKey(ClientTickEvent event) {
        if (timeSinceLastPacket > 0) {
            timeSinceLastPacket--;
        }
        if (timeSinceLastPacket <= 0) {
            long handle = Minecraft.getInstance().getWindow().getWindow();
            if (InputConstants.isKeyDown(handle, 72) && InputConstants.isKeyDown(handle, 341)) { // ctrl + h
                timeSinceLastPacket = 10;
                BetterAnimalsPlusMod.HANDLER.sendToServer(new HonkPacket());
            }
        }
    }

    @SubscribeEvent
    public static void onRenderPlayerPre(RenderPlayerEvent.Pre event) {
        if (SafeSyncThing.get(event.getPlayer().getGameProfile().getId()).on) {
            event.setCanceled(true);
            if (RENDER_INSTANCE == null) {
                RENDER_INSTANCE = new StupidRender(event.getRenderer().getRenderManager());
            }
            float rot = interpolateRotation(event.getPlayer().prevRotationYaw, event.getPlayer().rotationYaw, event.getPartialRenderTick());
            RENDER_INSTANCE.render(event.getPlayer(), rot, event.getPartialRenderTick(), event.getMatrixStack(), event.getBuffers(), event.getLight());
        }
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

    @SubscribeEvent
    public static void chat(ClientChatEvent event) {
        String m = event.getOriginalMessage();
        if (BetterAnimalsPlusMod.isDev(Minecraft.getInstance().player)) {
            if (m.startsWith("/goosedev")) {
                String[] args = m.split(" ");
                if (args.length < 2 || args.length > 4) {
                    msg("[BA+] Invalid length. Args 2 & 3 optional. Default nametag OFF, variant 1. Usage: /goosedev [on/off] [show nametag(on/off)] [variant]");
                    event.setCanceled(true);
                    return;
                }
                if (!args[1].equals("on") && !args[1].equals("off")) {
                    msg("[BA+] Invalid option for argument 1. Must be \"on\" or \"off\"");
                    event.setCanceled(true);
                    return;
                }
                boolean on = args[1].equals("on");
                boolean nametag = false;
                String variant = "1";
                if (on) {
                    if (args.length >= 3) {
                        if (!args[2].equals("on") && !args[2].equals("off")) {
                            msg("[BA+] Invalid option for argument 2. Must be \"on\" or \"off\"");
                            event.setCanceled(true);
                            return;
                        }
                        nametag = args[2].equals("on");
                        if (args.length == 4) {
                            if (!args[3].equals("1") && !args[3].equals("2") && !args[3].equals("3")) {
                                msg("[BA+] Invalid option for argument 3. Must be 1, 2, or 3");
                                event.setCanceled(true);
                                return;
                            }
                            variant = args[3];
                        }
                    }
                } else if (args.length >= 3) {
                    msg("[BA+] Too many arguments for disabling goose!");
                    event.setCanceled(true);
                    return;
                }
                event.setCanceled(true);
                msg("Goose " + (on ? "ENABLED" : "DISABLED") + " with nametag " + (nametag ? "ENABLED" : "DISABLED") + " and variant " + variant);
                StupidDevPacket pkt = new StupidDevPacket(on, nametag, variant);
                SafeSyncThing.put(Minecraft.getInstance().player.getGameProfile().getId(), pkt);
                BetterAnimalsPlusMod.HANDLER.sendToServer(pkt);
            } else if (m.startsWith("/help goosedev")) {
                msg("[BA+] Args 2 & 3 optional. Default nametag OFF, variant 1. Usage: /goosedev [on/off] [show nametag(on/off)] [variant]");
                event.setCanceled(true);
            }
        }
    }

    private static void msg(String msg) {
        Minecraft.getInstance().player.sendMessage(new TextComponent(msg), Util.NIL_UUID);
    }

    public static class StupidRender extends LivingEntityRenderer<Player, EntityModel<Player>> {

        public StupidRender(EntityRenderDispatcher mgr) {
            super(mgr, new ModelGoose<>(), 0.5F);
            this.addLayer(new GooseItemLayerRenderer<>(this));
        }

        @Override
        public void render(Player entity, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
            super.render(entity, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        }

        @Override
        protected boolean canRenderName(Player entity) {
            return SafeSyncThing.get(entity.getGameProfile().getId()).nametag;
        }

        @Override
        protected void preRenderCallback(Player entitylivingbaseIn, PoseStack stack, float partialTickTime) {
            stack.scale(0.8F, 0.8F, 0.8F);
        }

        @Override
        public ResourceLocation getEntityTexture(Player entity) {
            return ModEntities.GOOSE.getVariantForName(SafeSyncThing.get(entity.getGameProfile().getId()).variant).getTexture(null);
        }

    }
*/
}
