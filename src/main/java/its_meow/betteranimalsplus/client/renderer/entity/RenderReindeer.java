package its_meow.betteranimalsplus.client.renderer.entity;

import com.mojang.blaze3d.platform.GlStateManager;

import its_meow.betteranimalsplus.client.model.ModelReindeer;
import its_meow.betteranimalsplus.common.entity.EntityReindeer;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderReindeer extends MobRenderer<EntityReindeer, ModelReindeer<EntityReindeer>> {

    public RenderReindeer(EntityRendererManager rendermanagerIn) {
        super(rendermanagerIn, new ModelReindeer<EntityReindeer>(), 1F);
    }

    @Override
    protected void preRenderCallback(EntityReindeer entitylivingbaseIn, float partialTickTime) {
        if (this.entityModel.isChild) {
            GlStateManager.scaled(0.7D, 0.7D, 0.7D);
        } else {
            GlStateManager.scaled(1.3D, 1.3D, 1.3D);
        }
    }

    @Override
    public ResourceLocation getEntityTexture(EntityReindeer entity) {
        int type = entity.getTypeNumber();
        switch (type) {
        case 1:
            return ModTextures.reindeer_1;
        case 2:
            return ModTextures.reindeer_2;
        case 3:
            return ModTextures.reindeer_3;
        case 4:
            return ModTextures.reindeer_4;
        case 5:
            return ModTextures.reindeer_1_christmas;
        case 6:
            return ModTextures.reindeer_2_christmas;
        case 7:
            return ModTextures.reindeer_3_christmas;
        case 8:
            return ModTextures.reindeer_4_christmas;
        default:
            return ModTextures.reindeer_1;
        }
    }

}
