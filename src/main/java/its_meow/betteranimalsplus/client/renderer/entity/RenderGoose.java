package its_meow.betteranimalsplus.client.renderer.entity;

import javax.annotation.Nonnull;

import com.mojang.blaze3d.platform.GlStateManager;

import its_meow.betteranimalsplus.client.model.ModelGoose;
import its_meow.betteranimalsplus.common.entity.EntityGoose;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderGoose extends MobRenderer<EntityGoose, ModelGoose<EntityGoose>> {

    public RenderGoose(EntityRendererManager rendermanagerIn) {
        super(rendermanagerIn, new ModelGoose<EntityGoose>(), 0.5F);
    }

    @Override
    protected void preRenderCallback(EntityGoose entitylivingbaseIn, float partialTickTime) {
        if (this.entityModel.isChild) {
            GlStateManager.scaled(0.5D, 0.5D, 0.5D);
        } else {
            GlStateManager.scaled(0.8D, 0.8D, 0.8D);
        }
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull EntityGoose entity) {
        int type = entity.getTypeNumber();
        switch(type) {
        case 1: return ModTextures.goose_1;
        case 2: return ModTextures.goose_2;
        case 3: return ModTextures.goose_3;
        default: return ModTextures.goose_1;
        }
    }

}
