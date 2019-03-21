package its_meow.betteranimalsplus.client.renderer.entity.layers;

import its_meow.betteranimalsplus.client.renderer.entity.RenderCoyote;
import its_meow.betteranimalsplus.common.entity.EntityCoyote;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LayerCoyoteEyes implements LayerRenderer<EntityCoyote> {

    private final RenderCoyote wolfRenderer;

    public LayerCoyoteEyes(RenderCoyote wolfRendererIn) {
        this.wolfRenderer = wolfRendererIn;
    }

    @Override
    public void render(EntityCoyote entity, float limbSwing, float limbSwingAmount, float partialTicks,
            float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        if (!entity.isDaytime()) {
            if (!entity.isTamed() && !entity.isInvisible() && !entity.isChild()) {
                this.wolfRenderer.bindTexture(ModTextures.coyote_eyes);

                GlStateManager.enableBlend();
                GlStateManager.enableAlphaTest();
                GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);

                if (entity.isInvisible()) {
                    GlStateManager.depthMask(false);
                } else {
                    GlStateManager.depthMask(true);
                }

                int i = 61680;
                int j = i % 65536;
                int k = i / 65536;
                OpenGlHelper.glMultiTexCoord2f(OpenGlHelper.GL_TEXTURE1, j, k);
                Minecraft.getInstance().entityRenderer.setupFogColor(true);
                this.wolfRenderer.getMainModel().render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw,
                        headPitch, scale);
                Minecraft.getInstance().entityRenderer.setupFogColor(false);
                i = entity.getBrightnessForRender();
                j = i % 65536;
                k = i / 65536;
                OpenGlHelper.glMultiTexCoord2f(OpenGlHelper.GL_TEXTURE1, j, k);
                this.wolfRenderer.setLightmap(entity);
                GlStateManager.disableBlend();
                GlStateManager.disableAlphaTest();

            }
        }
    }

    @Override
    public boolean shouldCombineTextures() {
        return true;
    }
}