package its_meow.betteranimalsplus.client.renderer.entity;

import javax.annotation.Nonnull;

import com.mojang.blaze3d.matrix.MatrixStack;

import its_meow.betteranimalsplus.client.model.ModelHirschgeistMain;
import its_meow.betteranimalsplus.client.renderer.entity.layers.LayerEctoplasm;
import its_meow.betteranimalsplus.common.entity.miniboss.hirschgeist.EntityHirschgeist;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderHirschgeist extends MobRenderer<EntityHirschgeist, ModelHirschgeistMain<EntityHirschgeist>> {

    public RenderHirschgeist(EntityRendererManager rendermanagerIn) {
        super(rendermanagerIn, new ModelHirschgeistMain<EntityHirschgeist>(), 1F);
        this.addLayer(new LayerEctoplasm(this));
    }

    @Override
    protected void preRenderCallback(EntityHirschgeist entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        if (!entitylivingbaseIn.isDaytime()) {
            matrixStackIn.scale(2F, 2F, 2F);
        }
    }

    @Override
    @Nonnull
    public ResourceLocation getEntityTexture(@Nonnull EntityHirschgeist entity) {
        return ModTextures.hirschgeist;
    }

}
