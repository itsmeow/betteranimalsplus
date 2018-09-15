package its_meow.betteranimalsplus.entity.render;

import javax.annotation.Nonnull;

import its_meow.betteranimalsplus.entity.EntityBear;
import its_meow.betteranimalsplus.entity.EntityBearNeutral;
import its_meow.betteranimalsplus.entity.model.ModelBear;
import its_meow.betteranimalsplus.registry.TextureRegistry;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderBlackBear extends RenderLiving<EntityBearNeutral> {


	public RenderBlackBear(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelBear(), 1F);
	}



	public static final Factory FACTORY = new Factory();




	@Override
	@Nonnull
	protected ResourceLocation getEntityTexture(@Nonnull EntityBearNeutral entity) {
		return TextureRegistry.bear_black;
	}
	
	public static class Factory implements IRenderFactory<EntityBearNeutral> {
		
		@Override
		public Render<? super EntityBearNeutral> createRenderFor(RenderManager manager) {
			return new RenderBlackBear(manager);
		}
		
	}

}
