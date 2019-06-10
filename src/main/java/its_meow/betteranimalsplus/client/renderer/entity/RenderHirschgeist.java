package its_meow.betteranimalsplus.client.renderer.entity;

import javax.annotation.Nonnull;

import com.mojang.blaze3d.platform.GlStateManager;

import its_meow.betteranimalsplus.client.model.ModelHirschgeistMain;
import its_meow.betteranimalsplus.common.entity.miniboss.hirschgeist.EntityHirschgeist;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderHirschgeist extends MobRenderer<EntityHirschgeist, ModelHirschgeistMain<EntityHirschgeist>> {

    public RenderHirschgeist(EntityRendererManager rendermanagerIn) {
        super(rendermanagerIn, new ModelHirschgeistMain<EntityHirschgeist>(), 1F);
    }

    /**
     * Allows the render to do state modifications necessary before the model is
     * rendered.
     */
    @Override
    protected void preRenderCallback(EntityHirschgeist entitylivingbaseIn, float partialTickTime) {
        if (!entitylivingbaseIn.isDaytime()) {
            float scale = 2F;
            GlStateManager.scalef(scale, scale, scale);
        }
        super.preRenderCallback(entitylivingbaseIn, partialTickTime);
    }

    @Override
    public void doRender(EntityHirschgeist entity, double x, double y, double z, float f, float partialTicks) {
        super.doRender(entity, x, y, z, f, partialTicks);
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull EntityHirschgeist entity) {
        return ModTextures.hirschgeist;
    }

}
