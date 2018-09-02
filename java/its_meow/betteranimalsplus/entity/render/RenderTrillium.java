package its_meow.betteranimalsplus.entity.render;

import java.util.Random;

import javax.annotation.Nonnull;

import its_meow.betteranimalsplus.entity.EntityLammergeier;
import its_meow.betteranimalsplus.entity.EntityTrillium;
import its_meow.betteranimalsplus.entity.model.ModelTrillium;
import its_meow.betteranimalsplus.entity.model.ModelTrilliumMulti;
import its_meow.betteranimalsplus.entity.model.ModelTrilliumMulti2;
import its_meow.betteranimalsplus.registry.TextureRegistry;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderTrillium extends RenderLiving<EntityTrillium> {
	
	
	

	public RenderTrillium(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelTrilliumMulti(), 0.8F);
		
		//super(rendermanagerIn, ((new Random()).nextInt(3)) > 0 ? ((new Random()).nextInt(2) == 0 ? new ModelTrilliumMulti() : new ModelTrilliumMulti2())  : new ModelTrillium() , 1F);
		// Comment comment   //I'm really sorry, but super constructor calls have to be on the first line...
	}



	public static final Factory FACTORY = new Factory();




	@Override
	@Nonnull
	protected ResourceLocation getEntityTexture(@Nonnull EntityTrillium entity) {
		return entity.getTypeNumber() == 1 ? TextureRegistry.trillium2 : TextureRegistry.trillium;
	}
	
	public static class Factory implements IRenderFactory<EntityTrillium> {
		
		@Override
		public Render<? super EntityTrillium> createRenderFor(RenderManager manager) {
			return new RenderTrillium(manager);
		}
		
	}

}
