package its_meow.betteranimalsplus.client.renderer.entity;

import its_meow.betteranimalsplus.client.model.ModelHorseshoeCrab;
import its_meow.betteranimalsplus.common.entity.EntityHorseshoeCrab;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderHorseshoeCrab extends RenderLiving<EntityHorseshoeCrab> {

	public RenderHorseshoeCrab(RenderManager rendermanager) {
		super(rendermanager, new ModelHorseshoeCrab(), 0.4F);
	}
	
    @Override
    protected void preRenderCallback(EntityHorseshoeCrab entity, float partialTickTime) {
        if (this.getMainModel().isChild) {
            GlStateManager.scale(0.45D, 0.45D, 0.45D);
        } else {
            GlStateManager.scale(1.0D, 1.0D, 1.0D);
        }
    }

	@Override
	protected ResourceLocation getEntityTexture(EntityHorseshoeCrab entity) {
        int type = entity.getTypeNumber();
        switch (type) {
        case 1:
            return ModTextures.horseshoe_crab_1;
        case 2:
            return ModTextures.horseshoe_crab_2;
        case 3:
            return ModTextures.horseshoe_crab_3;
        default:
            return ModTextures.horseshoe_crab_1;
        }
	}

}
