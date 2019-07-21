package its_meow.betteranimalsplus.client.renderer.entity;

import com.mojang.blaze3d.platform.GlStateManager;

import its_meow.betteranimalsplus.client.model.ModelShark;
import its_meow.betteranimalsplus.common.entity.EntityShark;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderShark extends MobRenderer<EntityShark, ModelShark<EntityShark>> {

    public RenderShark(EntityRendererManager rendermanagerIn) {
        super(rendermanagerIn, new ModelShark<EntityShark>(), 2F);
    }
    
    @Override
    protected void preRenderCallback(EntityShark entity, float partialTickTime) {
        int type = entity.getTypeNumber();
        switch(type) {
        case 1: GlStateManager.scaled(0.8D, 0.7D, 0.8D); break;
        case 2: GlStateManager.scaled(0.6D, 0.6D, 0.6D); break;
        case 3: GlStateManager.scaled(1.1D, 1.1D, 1.1D); break;
        case 4: GlStateManager.scaled(0.8D, 0.8D, 0.8D); break;
        }
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityShark entity) {
        int type = entity.getTypeNumber();
        switch (type) {
        case 1:
            return ModTextures.shark_blue;
        case 2:
            return ModTextures.shark_bull;
        case 3:
            return ModTextures.shark_tiger;
        case 4:
            return ModTextures.shark_whitetip;
        default:
            return ModTextures.shark_bull;
        }
    }

}
