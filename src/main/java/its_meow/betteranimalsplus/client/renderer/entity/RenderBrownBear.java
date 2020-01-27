package its_meow.betteranimalsplus.client.renderer.entity;

import javax.annotation.Nonnull;

import com.mojang.blaze3d.platform.GlStateManager;

import its_meow.betteranimalsplus.client.model.ModelBear;
import its_meow.betteranimalsplus.common.entity.EntityBear;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderBrownBear extends MobRenderer<EntityBear, ModelBear<EntityBear>> {

    public RenderBrownBear(EntityRendererManager rendermanagerIn) {
        super(rendermanagerIn, new ModelBear<EntityBear>(), 1F);
    }

    @Override
    @Nonnull
    public ResourceLocation getEntityTexture(@Nonnull EntityBear entity) {
        return ModTextures.bear_brown;
    }

    /**
     * Allows the render to do state modifications necessary before the model is
     * rendered.
     */
    @Override
    protected void preRenderCallback(EntityBear entitylivingbaseIn, float partialTickTime) {
        float scale = 1.3F;
        GlStateManager.scalef(scale, scale, scale);
        super.preRenderCallback(entitylivingbaseIn, partialTickTime);
    }

}
