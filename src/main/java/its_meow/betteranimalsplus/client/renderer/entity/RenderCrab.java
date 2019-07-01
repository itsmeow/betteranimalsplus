package its_meow.betteranimalsplus.client.renderer.entity;

import its_meow.betteranimalsplus.client.model.ModelCrab;
import its_meow.betteranimalsplus.common.entity.EntityCrab;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCrab extends RenderLiving<EntityCrab> {

	public RenderCrab(RenderManager rendermanager) {
		super(rendermanager, new ModelCrab(), 0.4F);
	}
	
    @Override
    protected void preRenderCallback(EntityCrab entity, float partialTickTime) {
        if (this.getMainModel().isChild) {
            GlStateManager.scale(0.45D, 0.45D, 0.45D);
        } else {
            GlStateManager.scale(1.0D, 1.0D, 1.0D);
        }
    }

	@Override
	protected ResourceLocation getEntityTexture(EntityCrab entity) {
        int type = entity.getTypeNumber();
        switch (type) {
        case 1:
            return ModTextures.crab_1;
        case 2:
            return ModTextures.crab_2;
        case 3:
            return ModTextures.crab_3;
        case 4:
            return ModTextures.crab_4;
        default:
            return ModTextures.crab_1;
        }
	}

}
