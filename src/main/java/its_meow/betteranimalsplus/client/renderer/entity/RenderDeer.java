package its_meow.betteranimalsplus.client.renderer.entity;

import javax.annotation.Nonnull;

import its_meow.betteranimalsplus.client.model.ModelDeer;
import its_meow.betteranimalsplus.common.entity.EntityDeer;
import its_meow.betteranimalsplus.init.TextureRegistry;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import scala.util.Random;

public class RenderDeer extends RenderLiving<EntityDeer> {


	public RenderDeer(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelDeer(), 1F);
	}



	public static final Factory FACTORY = new Factory();




	@Override
	protected ResourceLocation getEntityTexture(EntityDeer entity) {
		int type = entity.getTypeNumber();
		if(type == 1) {
			return TextureRegistry.deer_1;
		}
		return TextureRegistry.deer_2;
	}
	
	public static class Factory implements IRenderFactory<EntityDeer> {
		
		@Override
		public Render<? super EntityDeer> createRenderFor(RenderManager manager) {
			return new RenderDeer(manager);
		}
		
	}

}
