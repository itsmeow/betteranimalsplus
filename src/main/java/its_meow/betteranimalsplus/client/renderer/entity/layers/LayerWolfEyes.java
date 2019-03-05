package its_meow.betteranimalsplus.client.renderer.entity.layers;

import its_meow.betteranimalsplus.client.renderer.entity.RenderCustomWolf;
import its_meow.betteranimalsplus.common.entity.EntityFeralWolf;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LayerWolfEyes implements LayerRenderer<EntityFeralWolf> {

	private final RenderCustomWolf wolfRenderer;

	public LayerWolfEyes(RenderCustomWolf wolfRendererIn) {
		this.wolfRenderer = wolfRendererIn;
	}

	@Override
	public void render(EntityFeralWolf entity, float limbSwing, float limbSwingAmount, float partialTicks,
			float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		if(!entity.isTamed() && !entity.isInvisible() && !entity.isChild()) {
			this.wolfRenderer.bindTexture(ModTextures.wolf_eyes);

			GlStateManager.enableBlend();
			GlStateManager.disableAlphaTest();
			GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);

			if(entity.isInvisible()) {
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
			GlStateManager.enableAlphaTest();

		}
	}

	@Override
	public boolean shouldCombineTextures() {
		return true;
	}
}