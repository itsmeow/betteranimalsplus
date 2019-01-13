package its_meow.betteranimalsplus.client.renderer.entity;

import java.util.Calendar;

import its_meow.betteranimalsplus.client.model.ModelDeer;
import its_meow.betteranimalsplus.common.entity.EntityDeer;
import its_meow.betteranimalsplus.init.TextureRegistry;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderDeer extends RenderLiving<EntityDeer> {

	private boolean isChristmas = false;

	public RenderDeer(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelDeer(), 1F);
		Calendar calendar = Calendar.getInstance();

		if (calendar.get(2) + 1 == 12 && calendar.get(5) >= 24 && calendar.get(5) <= 26)
		{
			this.isChristmas = true;
		}
	}
	
	@Override
	protected void preRenderCallback(EntityDeer entitylivingbaseIn, float partialTickTime) {
		if (getMainModel().isChild) {
			GlStateManager.scale(0.6D, 0.6D, 0.6D);
		} else {
			GlStateManager.scale(1.0D, 1.0D, 1.0D);
		}
	}


	@Override
	protected ResourceLocation getEntityTexture(EntityDeer entity) {
		int type = entity.getTypeNumber();
		if(!this.isChristmas) {
			if(getMainModel().isChild) {
				return TextureRegistry.deer_1;
			}
			if(type == 1) {
				return TextureRegistry.deer_1;
			}
			return TextureRegistry.deer_2;
		} else {
			if(getMainModel().isChild) {
				return TextureRegistry.deer_1_christmas;
			}
			if(type == 1) {
				return TextureRegistry.deer_1_christmas;
			}
			return TextureRegistry.deer_2_christmas;
		}
	}

}
