package its_meow.betteranimalsplus.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;

import its_meow.betteranimalsplus.client.model.ModelBoar;
import its_meow.betteranimalsplus.common.entity.EntityBoar;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderBoar extends MobRenderer<EntityBoar, ModelBoar<EntityBoar>> {

    public RenderBoar(EntityRendererManager rendermanagerIn) {
        super(rendermanagerIn, new ModelBoar<EntityBoar>(), 0.6F);
    }

    @Override
    protected void preRenderCallback(EntityBoar entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        if (this.entityModel.isChild) {
            matrixStackIn.scale(0.6F, 0.6F, 0.6F);
        } else {
            matrixStackIn.scale(1.0F, 1.0F, 1.0F);
        }
    }

    @Override
    public ResourceLocation getEntityTexture(EntityBoar entity) {
        int type = entity.getTypeNumber();
        switch (type) {
        case 1:
            return ModTextures.boar_1;
        case 2:
            return ModTextures.boar_2;
        case 3:
            return ModTextures.boar_3;
        case 4:
            return ModTextures.boar_4;
        default:
            return ModTextures.boar_1;
        }
    }

}
