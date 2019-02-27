package its_meow.betteranimalsplus.client.renderer.entity;

import its_meow.betteranimalsplus.client.model.ModelReindeer;
import its_meow.betteranimalsplus.common.entity.EntityReindeer;
import its_meow.betteranimalsplus.init.TextureRegistry;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderReindeer extends RenderLiving<EntityReindeer> {

	public RenderReindeer(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelReindeer(), 1F);
	}

	@Override
	protected void preRenderCallback(EntityReindeer entitylivingbaseIn, float partialTickTime) {
		if(this.getMainModel().isChild) {
			GlStateManager.scaled(0.7D, 0.7D, 0.7D);
		} else {
			GlStateManager.scaled(1.3D, 1.3D, 1.3D);
		}
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityReindeer entity) {
		int type = entity.getTypeNumber();
		switch(type) {
		case 1:
			return TextureRegistry.reindeer_1;
		case 2:
			return TextureRegistry.reindeer_2;
		case 3:
			return TextureRegistry.reindeer_3;
		case 4:
			return TextureRegistry.reindeer_4;
		case 5:
			return TextureRegistry.reindeer_1_christmas;
		case 6:
			return TextureRegistry.reindeer_2_christmas;
		case 7:
			return TextureRegistry.reindeer_3_christmas;
		case 8:
			return TextureRegistry.reindeer_4_christmas;
		default:
			return TextureRegistry.reindeer_1;
		}
	}

}
