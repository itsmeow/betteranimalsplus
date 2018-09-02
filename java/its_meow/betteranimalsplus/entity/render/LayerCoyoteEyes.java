package its_meow.betteranimalsplus.entity.render;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL14;

import its_meow.betteranimalsplus.entity.EntityCoyote;
import its_meow.betteranimalsplus.entity.EntityFeralWolf;
import its_meow.betteranimalsplus.registry.TextureRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderWolf;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerCoyoteEyes implements LayerRenderer<EntityCoyote>
{
	private final RenderCoyote wolfRenderer;

	public LayerCoyoteEyes(RenderCoyote wolfRendererIn)
	{
		this.wolfRenderer = wolfRendererIn;
	}

	public void doRenderLayer(EntityCoyote entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
	{
		if(!entitylivingbaseIn.isDaytime()) {
			if (!entitylivingbaseIn.isTamed() && !entitylivingbaseIn.isInvisible() && !entitylivingbaseIn.isChild())
			{
				this.wolfRenderer.bindTexture(TextureRegistry.coyote_eyes);

				GlStateManager.enableBlend();
				GlStateManager.disableAlpha();
				GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);

				if (entitylivingbaseIn.isInvisible())
				{
					GlStateManager.depthMask(false);
				}
				else
				{
					GlStateManager.depthMask(true);
				}

				int i = 61680;
				int j = i % 65536;
				int k = i / 65536;
				OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j, (float)k);
				GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
				Minecraft.getMinecraft().entityRenderer.setupFogColor(true);
				this.wolfRenderer.getMainModel().render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
				Minecraft.getMinecraft().entityRenderer.setupFogColor(false);
				i = entitylivingbaseIn.getBrightnessForRender();
				j = i % 65536;
				k = i / 65536;
				OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j, (float)k);
				this.wolfRenderer.setLightmap(entitylivingbaseIn);
				GlStateManager.disableBlend();
				GlStateManager.enableAlpha();

			}
		}
	}

	public boolean shouldCombineTextures()
	{
		return true;
	}
}