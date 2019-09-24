package its_meow.betteranimalsplus.client.renderer.entity;

import its_meow.betteranimalsplus.client.model.ModelMoose;
import its_meow.betteranimalsplus.common.entity.EntityMoose;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderMoose extends RenderLiving<EntityMoose> {

    public RenderMoose(RenderManager rendermanager) {
        super(rendermanager, new ModelMoose(), 0.8F);
    }
    
    @Override
    protected void preRenderCallback(EntityMoose bear, float partialTickTime) {
        float scale = 1.5F;
        GlStateManager.scale(scale, scale, scale);
        super.preRenderCallback(bear, partialTickTime);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityMoose entity) {
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
