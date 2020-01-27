package its_meow.betteranimalsplus.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;

import its_meow.betteranimalsplus.client.model.ModelBadger;
import its_meow.betteranimalsplus.common.entity.EntityBadger;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderBadger extends MobRenderer<EntityBadger, ModelBadger<EntityBadger>> {

    public RenderBadger(EntityRendererManager mgr) {
        super(mgr, new ModelBadger<EntityBadger>(), 0.4F);
    }

    @Override
    protected void preRenderCallback(EntityBadger entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        if (this.entityModel.isChild) {
            matrixStackIn.scale(0.35F, 0.35F, 0.35F);
        } else {
            matrixStackIn.scale(0.7F, 0.7F, 0.7F);
        }
    }

    @Override
    public ResourceLocation getEntityTexture(EntityBadger entity) {
        switch(entity.getTypeNumber()) {
        case 1: return ModTextures.badger_1;
        case 2: return ModTextures.badger_2;
        case 3: return ModTextures.badger_3;
        default: return ModTextures.badger_1;
        }
    }

}