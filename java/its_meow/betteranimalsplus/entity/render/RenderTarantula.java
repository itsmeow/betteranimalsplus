package its_meow.betteranimalsplus.entity.render;

import javax.annotation.Nonnull;

import its_meow.betteranimalsplus.entity.EntityTarantula;
import its_meow.betteranimalsplus.entity.model.ModelTarantula;
import its_meow.betteranimalsplus.registry.TextureRegistry;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import scala.util.Random;

public class RenderTarantula extends RenderLiving<EntityTarantula> {


	public RenderTarantula(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelTarantula(), 1F);
		this.addLayer(new LayerTarantulaEyes(this));
	}
	
	
	
	
	public static final Factory FACTORY = new Factory();

	
	
	@Override
	protected ResourceLocation getEntityTexture(EntityTarantula entity) {
		return TextureRegistry.tarantula;
	}
	
	public static class Factory implements IRenderFactory<EntityTarantula> {
		
		@Override
		public Render<? super EntityTarantula> createRenderFor(RenderManager manager) {
			return new RenderTarantula(manager);
		}
		
	}

}
