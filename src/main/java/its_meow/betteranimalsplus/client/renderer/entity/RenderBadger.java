package its_meow.betteranimalsplus.client.renderer.entity;

import com.mojang.blaze3d.platform.GlStateManager;

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
    protected void preRenderCallback(EntityBadger entitylivingbaseIn, float partialTickTime) {
        if (this.entityModel.isChild) {
            GlStateManager.scaled(0.35D, 0.35D, 0.35D);
        } else {
            GlStateManager.scaled(0.7D, 0.7D, 0.7D);
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