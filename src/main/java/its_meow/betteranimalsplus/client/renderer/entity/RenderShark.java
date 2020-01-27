package its_meow.betteranimalsplus.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;

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
    protected void preRenderCallback(EntityShark entity, MatrixStack matrixStackIn, float partialTickTime) {
        int type = entity.getTypeNumber();
        switch(type) {
        case 1: matrixStackIn.scale(0.8F, 0.7F, 0.8F); break;
        case 2: matrixStackIn.scale(0.6F, 0.6F, 0.6F); break;
        case 3: matrixStackIn.scale(1.1F, 1.1F, 1.1F); break;
        case 4: matrixStackIn.scale(0.8F, 0.8F, 0.8F); break;
        }
    }

    @Override
    public ResourceLocation getEntityTexture(EntityShark entity) {
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
