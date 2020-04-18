package its_meow.betteranimalsplus.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;

import its_meow.betteranimalsplus.client.model.ModelJellyfish;
import its_meow.betteranimalsplus.common.entity.EntityJellyfish;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.entity.Pose;
import net.minecraft.util.ResourceLocation;

public class RenderJellyfish extends MobRenderer<EntityJellyfish, ModelJellyfish<EntityJellyfish>> {

    public RenderJellyfish(EntityRendererManager rendermanagerIn) {
        super(rendermanagerIn, new ModelJellyfish<EntityJellyfish>(), 0.5F);
    }

    @Override
    protected void preRenderCallback(EntityJellyfish entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        float s = entitylivingbaseIn.getSize(Pose.STANDING).width;
        matrixStackIn.scale(s, s, s);
        matrixStackIn.translate(0, 1F, 0);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityJellyfish entity) {
        return entity.getVariantTexture();
    }

}
