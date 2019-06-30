package its_meow.betteranimalsplus.client.renderer.entity;

import its_meow.betteranimalsplus.client.model.ModelNautilus;
import its_meow.betteranimalsplus.common.entity.EntityNautilus;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderNautilus extends RenderLiving<EntityNautilus> {

	public RenderNautilus(RenderManager rendermanager) {
		super(rendermanager, new ModelNautilus(), 0.4F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityNautilus entity) {
		return ModTextures.nautilus;
	}

}
