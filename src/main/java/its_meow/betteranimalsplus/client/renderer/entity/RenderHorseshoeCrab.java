package its_meow.betteranimalsplus.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;

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
    protected void preRenderCallback(EntityHorseshoeCrab entity, MatrixStack matrixStackIn, float partialTickTime) {
        if (this.entityModel.isChild) {
            matrixStackIn.scale(0.45F, 0.45F, 0.45F);
        } else {
            matrixStackIn.scale(1.0F, 1.0F, 1.0F);
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
