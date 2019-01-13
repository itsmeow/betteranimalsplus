package its_meow.betteranimalsplus.client.renderer.entity;

import javax.annotation.Nonnull;

import its_meow.betteranimalsplus.client.model.ModelLammergeier;
import its_meow.betteranimalsplus.common.entity.EntityLammergeier;
import its_meow.betteranimalsplus.init.TextureRegistry;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderLammergeier extends RenderLiving<EntityLammergeier> {


	public RenderLammergeier(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelLammergeier(), 0.3F);
	}

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

}
