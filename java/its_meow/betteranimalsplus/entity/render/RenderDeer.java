package its_meow.betteranimalsplus.entity.render;

import javax.annotation.Nonnull;

import its_meow.betteranimalsplus.entity.EntityDeer;
import its_meow.betteranimalsplus.entity.model.ModelDeer;
import its_meow.betteranimalsplus.registry.TextureRegistry;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderDeer extends RenderLiving<EntityDeer> {


	public RenderDeer(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelDeer(), 1F);
	}



	public static final Factory FACTORY = new Factory();




	@Override
	@Nonnull
	protected ResourceLocation getEntityTexture(@Nonnull EntityDeer entity) {
		return TextureRegistry.deer_01;
	}
	
	public static class Factory implements IRenderFactory<EntityDeer> {
		
		@Override
		public Render<? super EntityDeer> createRenderFor(RenderManager manager) {
			return new RenderDeer(manager);
		}
		
	}

}
