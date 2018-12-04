package its_meow.betteranimalsplus.client.renderer.entity;

import javax.annotation.Nonnull;

import its_meow.betteranimalsplus.client.model.ModelJellyfish;
import its_meow.betteranimalsplus.common.entity.EntityJellyfish;
import its_meow.betteranimalsplus.init.TextureRegistry;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderJellyfish extends RenderLiving<EntityJellyfish> {

	public RenderJellyfish(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelJellyfish(), 0.5F);
	}
	
	@Override
	protected void preRenderCallback(EntityJellyfish entitylivingbaseIn, float partialTickTime) {
		float s = entitylivingbaseIn.getSize();
		GlStateManager.scale(s,s,s);
	}
	
	@Override
	protected void applyRotations(EntityJellyfish entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        float f = entityLiving.prevSquidPitch + (entityLiving.squidPitch - entityLiving.prevSquidPitch) * partialTicks;
        float f1 = entityLiving.prevSquidYaw + (entityLiving.squidYaw - entityLiving.prevSquidYaw) * partialTicks;
        GlStateManager.translate(0.0F, 0.5F, 0.0F);
        GlStateManager.rotate(180.0F - rotationYaw, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(f, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(f1, 0.0F, 1.0F, 0.0F);
        GlStateManager.translate(0.0F, -1.2F, 0.0F);
    }

	public static final Factory FACTORY = new Factory();


	@Override
	@Nonnull
	protected ResourceLocation getEntityTexture(@Nonnull EntityJellyfish entity) {
		int type = entity.getTypeNumber();
		ResourceLocation res = TextureRegistry.jellyfish_1;
		switch(type) {
		case 1: res = TextureRegistry.jellyfish_1; break;
		case 2: res = TextureRegistry.jellyfish_2; break;
		case 3: res = TextureRegistry.jellyfish_3; break;
		case 4: res = TextureRegistry.jellyfish_4; break;
		case 5: res = TextureRegistry.jellyfish_5; break;
		case 6: res = TextureRegistry.jellyfish_6; break;
		default:res = TextureRegistry.jellyfish_1; break;
		}
		return res;
	}

	public static class Factory implements IRenderFactory<EntityJellyfish> {

		@Override
		public Render<? super EntityJellyfish> createRenderFor(RenderManager manager) {
			return new RenderJellyfish(manager);
		}

	}

}
