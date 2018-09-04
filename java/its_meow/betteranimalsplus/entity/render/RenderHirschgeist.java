package its_meow.betteranimalsplus.entity.render;

import javax.annotation.Nonnull;

import its_meow.betteranimalsplus.entity.miniboss.hirschgeist.EntityHirschgeist;
import its_meow.betteranimalsplus.entity.model.ModelHirschgeist;
import its_meow.betteranimalsplus.registry.TextureRegistry;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
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
		GlStateManager.pushMatrix();

		GlStateManager.enableAlpha();
		GlStateManager.enableBlend();

		GlStateManager.color(1.0F, 1.0F, 1.0F, 0.5F);

		super.doRender(entity, x, y, z, f, partialTicks);

		GlStateManager.color(1.0F, 1.0F, 1.0F, 1F);

		GlStateManager.disableAlpha();
		GlStateManager.disableBlend();

		GlStateManager.popMatrix();
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
