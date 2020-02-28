package its_meow.betteranimalsplus.client.renderer.entity;

import com.mojang.blaze3d.platform.GlStateManager;

import its_meow.betteranimalsplus.client.model.ModelLamprey;
import its_meow.betteranimalsplus.common.entity.EntityLamprey;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderLamprey extends MobRenderer<EntityLamprey, ModelLamprey<EntityLamprey>> {

    public RenderLamprey(EntityRendererManager rendermanager) {
        super(rendermanager, new ModelLamprey<EntityLamprey>(), 0.4F);
    }

    @Override
    protected void preRenderCallback(EntityLamprey entity, float partialTickTime) {
        GlStateManager.scaled(0.5D, 0.5D, 0.5D);

        if(entity.getRidingEntity() != null) {
            GlStateManager.rotatef(180, 0, 1, 0);
            GlStateManager.translatef(0, 0, 0.5F);
        }
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityLamprey entity) {
        return entity.getVariantTexture();
    }

}
