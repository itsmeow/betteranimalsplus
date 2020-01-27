package its_meow.betteranimalsplus.client.renderer.entity;

import javax.annotation.Nonnull;

import com.mojang.blaze3d.matrix.MatrixStack;

import its_meow.betteranimalsplus.client.model.ModelGoat;
import its_meow.betteranimalsplus.common.entity.EntityGoat;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderGoat extends MobRenderer<EntityGoat, ModelGoat<EntityGoat>> {

    public RenderGoat(EntityRendererManager rendermanagerIn) {
        super(rendermanagerIn, new ModelGoat<EntityGoat>(), 0.5F);
    }

    @Override
    protected void preRenderCallback(EntityGoat entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        if (this.entityModel.isChild) {
            matrixStackIn.scale(0.5F, 0.5F, 0.5F);
        } else {
            matrixStackIn.scale(1.0F, 1.0F, 1.0F);
        }
    }

    @Override
    @Nonnull
    public ResourceLocation getEntityTexture(@Nonnull EntityGoat entity) {
        int type = entity.getTypeNumber();
        ResourceLocation res = ModTextures.goat_1;
        switch (type) {
        case 1:
            res = ModTextures.goat_1;
            break;
        case 2:
            res = ModTextures.goat_2;
            break;
        case 3:
            res = ModTextures.goat_3;
            break;
        case 4:
            res = ModTextures.goat_4;
            break;
        case 5:
            res = ModTextures.goat_5;
            break;
        case 6:
            res = ModTextures.goat_6;
            break;
        case 7:
            res = ModTextures.goat_7;
            break;
        default:
            res = ModTextures.goat_1;
            break;
        }
        return res;
    }

}
