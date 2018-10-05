package its_meow.betteranimalsplus.client.renderer.entity;

import javax.annotation.Nonnull;

import its_meow.betteranimalsplus.client.model.ModelBear;
import its_meow.betteranimalsplus.common.entity.EntityBear;
import its_meow.betteranimalsplus.init.TextureRegistry;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderBrownBear extends RenderLiving<EntityBear> {


	public RenderBrownBear(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelBear(), 1F);
	}



	public static final Factory FACTORY = new Factory();




	@Override
	@Nonnull
	protected ResourceLocation getEntityTexture(@Nonnull EntityBear entity) {
		return TextureRegistry.bear_brown;
	}
	
	public static class Factory implements IRenderFactory<EntityBear> {
		
		@Override
		public Render<? super EntityBear> createRenderFor(RenderManager manager) {
			return new RenderBrownBear(manager);
		}
		
	}
	
	/**
     * Allows the render to do state modifications necessary before the model is rendered.
     */
    protected void preRenderCallback(EntityBear entitylivingbaseIn, float partialTickTime)
    {
    	float scale = 1.3F;
        GlStateManager.scale(scale, scale, scale);
        super.preRenderCallback(entitylivingbaseIn, partialTickTime);
    }

}
