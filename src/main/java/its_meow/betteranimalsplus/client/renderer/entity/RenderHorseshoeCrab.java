package its_meow.betteranimalsplus.client.renderer.entity;

import com.mojang.blaze3d.platform.GlStateManager;

import its_meow.betteranimalsplus.client.model.ModelHorseshoeCrab;
import its_meow.betteranimalsplus.common.entity.EntityHorseshoeCrab;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderHorseshoeCrab extends MobRenderer<EntityHorseshoeCrab, ModelHorseshoeCrab<EntityHorseshoeCrab>> {

	public RenderHorseshoeCrab(EntityRendererManager rendermanager) {
		super(rendermanager, new ModelHorseshoeCrab<EntityHorseshoeCrab>(), 0.4F);
	}
	
    @Override
    protected void preRenderCallback(EntityHorseshoeCrab entity, float partialTickTime) {
        if (this.entityModel.isChild) {
            GlStateManager.scaled(0.45D, 0.45D, 0.45D);
        } else {
            GlStateManager.scaled(1.0D, 1.0D, 1.0D);
        }
    }

	@Override
	public ResourceLocation getEntityTexture(EntityHorseshoeCrab entity) {
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
