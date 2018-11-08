package its_meow.betteranimalsplus.client.renderer.entity;

import javax.annotation.Nonnull;

import its_meow.betteranimalsplus.client.model.ModelGoat;
import its_meow.betteranimalsplus.common.entity.EntityGoat;
import its_meow.betteranimalsplus.init.TextureRegistry;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderGoat extends RenderLiving<EntityGoat> {

	public RenderGoat(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelGoat(), 0.5F);
	}
	
	@Override
	protected void preRenderCallback(EntityGoat entitylivingbaseIn, float partialTickTime) {
		if (getMainModel().isChild) {
			GlStateManager.scale(0.5D, 0.5D, 0.5D);
		} else {
			GlStateManager.scale(1.0D, 1.0D, 1.0D);
		}
}
	

	public static final Factory FACTORY = new Factory();


	@Override
	@Nonnull
	protected ResourceLocation getEntityTexture(@Nonnull EntityGoat entity) {
		int type = entity.getTypeNumber();
		ResourceLocation res = TextureRegistry.goat_1;
		switch(type) {
		case 1: res = TextureRegistry.goat_1; break;
		case 2: res = TextureRegistry.goat_2; break;
		case 3: res = TextureRegistry.goat_3; break;
		case 4: res = TextureRegistry.goat_4; break;
		case 5: res = TextureRegistry.goat_5; break;
		case 6: res = TextureRegistry.goat_6; break;
		case 7: res = TextureRegistry.goat_7; break;
		default:res = TextureRegistry.goat_1; break;
		}
		return res;
	}

	public static class Factory implements IRenderFactory<EntityGoat> {

		@Override
		public Render<? super EntityGoat> createRenderFor(RenderManager manager) {
			return new RenderGoat(manager);
		}

	}

}
