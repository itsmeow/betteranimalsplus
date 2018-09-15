package its_meow.betteranimalsplus.entity.render;

import java.util.Random;

import javax.annotation.Nonnull;

import its_meow.betteranimalsplus.entity.EntityLammergeier;
import its_meow.betteranimalsplus.entity.model.ModelLammergeier;
import its_meow.betteranimalsplus.registry.TextureRegistry;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderLammergeier extends RenderLiving<EntityLammergeier> {


	public RenderLammergeier(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelLammergeier(), 0.3F);
	}



	public static final Factory FACTORY = new Factory();




	@Override
	@Nonnull
	protected ResourceLocation getEntityTexture(@Nonnull EntityLammergeier entity) {
		int typeNumber = entity.getTypeNumber();
		ResourceLocation result = null;
		switch(typeNumber) {
			case 1:
				result = TextureRegistry.lam_orange;
				break;
			case 2:
				result = TextureRegistry.lam_red;
				break;
			case 3:
				result = TextureRegistry.lam_white;
				break;
			case 4:
				result = TextureRegistry.lam_yellow;
				break;
		}
		return result;
		
	}
	
	public static class Factory implements IRenderFactory<EntityLammergeier> {
		
		@Override
		public Render<? super EntityLammergeier> createRenderFor(RenderManager manager) {
			return new RenderLammergeier(manager);
		}
		
	}

}
