package its_meow.betteranimalsplus.client.renderer.entity;

import javax.annotation.Nonnull;

import com.mojang.blaze3d.platform.GlStateManager;

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
    protected void preRenderCallback(EntityGoat entitylivingbaseIn, float partialTickTime) {
        if (this.entityModel.isChild) {
            GlStateManager.scaled(0.5D, 0.5D, 0.5D);
        } else {
            GlStateManager.scaled(1.0D, 1.0D, 1.0D);
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
