package its_meow.betteranimalsplus.client.renderer.entity;

import com.mojang.blaze3d.platform.GlStateManager;

import its_meow.betteranimalsplus.client.model.ModelMoose;
import its_meow.betteranimalsplus.common.entity.EntityMoose;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderMoose extends MobRenderer<EntityMoose, ModelMoose<EntityMoose>> {

    public RenderMoose(EntityRendererManager rendermanager) {
        super(rendermanager, new ModelMoose<EntityMoose>(), 0.8F);
    }
    
    @Override
    protected void preRenderCallback(EntityMoose bear, float partialTickTime) {
        float scale = 1.5F;
        GlStateManager.scalef(scale, scale, scale);
        super.preRenderCallback(bear, partialTickTime);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityMoose entity) {
        int type = entity.getTypeNumber();
        switch (type) {
        case 1:
            return ModTextures.moose_1;
        case 2:
            return ModTextures.moose_2;
        case 3:
            return ModTextures.moose_3;
        case 4:
            return ModTextures.moose_4;
        default:
            return ModTextures.moose_1;
        }
    }

}
