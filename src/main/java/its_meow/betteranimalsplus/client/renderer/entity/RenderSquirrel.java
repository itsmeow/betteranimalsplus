package its_meow.betteranimalsplus.client.renderer.entity;

import javax.annotation.Nonnull;

import com.mojang.blaze3d.platform.GlStateManager;

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
    protected void preRenderCallback(EntitySquirrel entitylivingbaseIn, float partialTickTime) {
        if (this.entityModel.isChild) {
            GlStateManager.scaled(0.35D, 0.35D, 0.35D);
        } else {
            GlStateManager.scaled(0.5D, 0.5D, 0.5D);
        }
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull EntitySquirrel entity) {
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
