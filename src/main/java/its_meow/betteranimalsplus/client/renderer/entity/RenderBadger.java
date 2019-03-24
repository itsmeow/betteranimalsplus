package its_meow.betteranimalsplus.client.renderer.entity;

import its_meow.betteranimalsplus.client.model.ModelBadger;
import its_meow.betteranimalsplus.common.entity.EntityBadger;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderBadger extends RenderLiving<EntityBadger> {

    public RenderBadger(RenderManager mgr) {
        super(mgr, new ModelBadger(), 0.7F);
    }

    @Override
    protected void preRenderCallback(EntityBadger entitylivingbaseIn, float partialTickTime) {
        if (this.getMainModel().isChild) {
            GlStateManager.scaled(0.6D, 0.6D, 0.6D);
        } else {
            GlStateManager.scaled(1.0D, 1.0D, 1.0D);
        }
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityBadger entity) {
        switch(entity.getTypeNumber()) {
        case 1: return ModTextures.badger_1;
        case 2: return ModTextures.badger_2;
        case 3: return ModTextures.badger_3;
        default: return ModTextures.badger_1;
        }
    }

}