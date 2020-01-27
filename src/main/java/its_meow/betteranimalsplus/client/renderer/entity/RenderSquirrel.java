package its_meow.betteranimalsplus.client.renderer.entity;

import javax.annotation.Nonnull;

import com.mojang.blaze3d.matrix.MatrixStack;

import its_meow.betteranimalsplus.client.model.ModelSquirrel;
import its_meow.betteranimalsplus.common.entity.EntitySquirrel;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderSquirrel extends MobRenderer<EntitySquirrel, ModelSquirrel<EntitySquirrel>> {

    public RenderSquirrel(EntityRendererManager rendermanagerIn) {
        super(rendermanagerIn, new ModelSquirrel<EntitySquirrel>(), 0.3F);
    }

    @Override
    protected void preRenderCallback(EntitySquirrel entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        if (this.entityModel.isChild) {
            matrixStackIn.scale(0.35F, 0.35F, 0.35F);
        } else {
            matrixStackIn.scale(0.5F, 0.5F, 0.5F);
        }
    }

    @Override
    @Nonnull
    public ResourceLocation getEntityTexture(@Nonnull EntitySquirrel entity) {
        int type = entity.getTypeNumber();
        ResourceLocation res = ModTextures.squirrel_1;
        switch (type) {
        case 1:
            res = ModTextures.squirrel_1;
            break;
        case 2:
            res = ModTextures.squirrel_2;
            break;
        case 3:
            res = ModTextures.squirrel_3;
            break;
        default:
            res = ModTextures.squirrel_1;
            break;
        }
        return res;
    }

}
