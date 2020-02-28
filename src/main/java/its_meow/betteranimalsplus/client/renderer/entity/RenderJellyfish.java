package its_meow.betteranimalsplus.client.renderer.entity;

import javax.annotation.Nonnull;

import com.mojang.blaze3d.platform.GlStateManager;

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
    protected void preRenderCallback(EntityJellyfish entitylivingbaseIn, float partialTickTime) {
        float s = entitylivingbaseIn.getSize(Pose.STANDING).width;
        GlStateManager.scalef(s, s, s);
        GlStateManager.translatef(0, 1F, 0);
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull EntityJellyfish entity) {
        return entity.getVariantTexture();
    }

}
