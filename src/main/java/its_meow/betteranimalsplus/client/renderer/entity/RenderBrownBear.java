package its_meow.betteranimalsplus.client.renderer.entity;

import javax.annotation.Nonnull;

import com.mojang.blaze3d.matrix.MatrixStack;

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

    @Override
    protected void preRenderCallback(EntityBear entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.3F, 1.3F, 1.3F);
    }

}
