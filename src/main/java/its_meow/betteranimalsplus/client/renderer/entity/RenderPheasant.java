package its_meow.betteranimalsplus.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;

import its_meow.betteranimalsplus.client.model.ModelPheasant;
import its_meow.betteranimalsplus.common.entity.EntityPheasant;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class RenderPheasant extends MobRenderer<EntityPheasant, ModelPheasant<EntityPheasant>> {

    public RenderPheasant(EntityRendererManager rendermanagerIn) {
        super(rendermanagerIn, new ModelPheasant<EntityPheasant>(), 0.5F);
    }

    @Override
    protected void preRenderCallback(EntityPheasant entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        if (this.entityModel.isChild) {
            matrixStackIn.scale(0.5F, 0.5F, 0.5F);
        } else {
            matrixStackIn.scale(1.0F, 1.0F, 1.0F);
        }
    }

    @Override
    protected float handleRotationFloat(EntityPheasant livingBase, float partialTicks) {
        float f = livingBase.oFlap + (livingBase.wingRotation - livingBase.oFlap) * partialTicks;
        float f1 = livingBase.oFlapSpeed + (livingBase.destPos - livingBase.oFlapSpeed) * partialTicks;
        return (MathHelper.sin(f) + 1.0F) * f1;
    }

    @Override
    public ResourceLocation getEntityTexture(EntityPheasant entity) {
        return entity.getVariantTexture();
    }

}
