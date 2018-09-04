package its_meow.betteranimalsplus.entity.render;

import javax.annotation.Nonnull;

import its_meow.betteranimalsplus.entity.miniboss.hirschgeist.EntityHirschgeist;
import its_meow.betteranimalsplus.entity.model.ModelHirschgeist;
import its_meow.betteranimalsplus.registry.TextureRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderHirschgeist extends RenderLiving<EntityHirschgeist> {


	public RenderHirschgeist(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelHirschgeist(), 1F);
	}



	public static final Factory FACTORY = new Factory();

	@Override
	public void doRender(EntityHirschgeist entity, double x, double y, double z, float f, float partialTicks) {
		int sF = 2;
		if(!entity.isDaytime()) {
			GlStateManager.pushMatrix();
			
			GlStateManager.scale(sF, sF, sF);
			GlStateManager.translate(0, 1.5F - (1.5F * sF), z);
			
			GlStateManager.enableBlend();
			GlStateManager.enableAlpha();

			GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);


			GlStateManager.depthMask(true);

			int i = 61680;
			int j = i % 65536;
			int k = i / 65536;
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j, (float)k);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 0.5F);
			Minecraft.getMinecraft().entityRenderer.setupFogColor(true);
			super.doRender(entity, x, y, z, f, partialTicks);
			Minecraft.getMinecraft().entityRenderer.setupFogColor(false);
			i = entity.getBrightnessForRender();
			j = i % 65536;
			k = i / 65536;
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j, (float)k);
			this.setLightmap(entity);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1F);
			GlStateManager.disableBlend();
			GlStateManager.disableAlpha();

			GlStateManager.popMatrix();
		} else {
			GlStateManager.pushMatrix();
			
			GlStateManager.scale(sF, sF, sF);
			GlStateManager.translate(0, 1.5F - (1.5F * sF), z);
			
			GlStateManager.enableAlpha();
			
			GlStateManager.color(1.0F, 1.0F, 1.0F, 0.5F);
			
			super.doRender(entity, x, y, z, f, partialTicks);
			
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			
			GlStateManager.disableAlpha();
			
			GlStateManager.popMatrix();
		}
	}



	@Override
	@Nonnull
	protected ResourceLocation getEntityTexture(@Nonnull EntityHirschgeist entity) {
		return TextureRegistry.hirschgeist;
	}

	public static class Factory implements IRenderFactory<EntityHirschgeist> {

		@Override
		public Render<? super EntityHirschgeist> createRenderFor(RenderManager manager) {
			return new RenderHirschgeist(manager);
		}

	}
}
