package its_meow.betteranimalsplus.client.renderer.entity;

import javax.annotation.Nonnull;

import its_meow.betteranimalsplus.client.model.ModelSquirrel;
import its_meow.betteranimalsplus.common.entity.EntitySquirrel;
import its_meow.betteranimalsplus.init.TextureRegistry;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderSquirrel extends RenderLiving<EntitySquirrel> {

	public RenderSquirrel(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelSquirrel(), 0.5F);
	}

	@Override
	protected void preRenderCallback(EntitySquirrel entitylivingbaseIn, float partialTickTime) {
		if (getMainModel().isChild) {
			GlStateManager.scale(0.75D, 0.75D, 0.75D);
		} else {
			GlStateManager.scale(1.0D, 1.0D, 1.0D);
		}
	}


	@Override
	@Nonnull
	protected ResourceLocation getEntityTexture(@Nonnull EntitySquirrel entity) {
		int type = entity.getTypeNumber();
		ResourceLocation res = TextureRegistry.squirrel_1;
		switch(type) {
		case 1: res = TextureRegistry.squirrel_1; break;
		case 2: res = TextureRegistry.squirrel_2; break;
		case 3: res = TextureRegistry.squirrel_3; break;
		default:res = TextureRegistry.squirrel_1; break;
		}
		return res;
	}

}
