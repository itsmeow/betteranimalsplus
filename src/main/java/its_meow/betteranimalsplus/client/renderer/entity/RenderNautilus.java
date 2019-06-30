package its_meow.betteranimalsplus.client.renderer.entity;

import its_meow.betteranimalsplus.client.model.ModelNautilus;
import its_meow.betteranimalsplus.common.entity.EntityNautilus;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

public class RenderNautilus extends MobRenderer<EntityNautilus, EntityModel<EntityNautilus>> {

	public RenderNautilus(EntityRendererManager rendermanager) {
		super(rendermanager, new ModelNautilus<EntityNautilus>(), 0.4F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityNautilus entity) {
		return ModTextures.nautilus;
	}

}
