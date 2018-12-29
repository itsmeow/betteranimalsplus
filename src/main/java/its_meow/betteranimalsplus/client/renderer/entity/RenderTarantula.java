package its_meow.betteranimalsplus.client.renderer.entity;

import its_meow.betteranimalsplus.client.model.ModelTarantula;
import its_meow.betteranimalsplus.client.renderer.entity.layers.LayerTarantulaEyes;
import its_meow.betteranimalsplus.common.entity.EntityTarantula;
import its_meow.betteranimalsplus.init.TextureRegistry;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

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
