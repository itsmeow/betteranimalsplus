package its_meow.betteranimalsplus.client.renderer.entity.generic;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.ResourceLocation;

public class SimpleScaledSingleRenderer<T extends MobEntity, A extends EntityModel<T>> extends SimpleSingleRenderer<T, A> {

    private final float adultScale;
    private final float childScale;

    public SimpleScaledSingleRenderer(EntityRendererManager renderManagerIn, A entityModelIn, float shadowSizeIn, ResourceLocation texture, double adultScale, double childScale) {
        super(renderManagerIn, entityModelIn, shadowSizeIn, texture);
        this.adultScale = (float) adultScale;
        this.childScale = (float) childScale;
    }

    @Override
    protected void preRenderCallback(T entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        if(this.entityModel.isChild) {
            matrixStackIn.scale(childScale, childScale, childScale);
        } else {
            matrixStackIn.scale(adultScale, adultScale, adultScale);
        }
    }

}
