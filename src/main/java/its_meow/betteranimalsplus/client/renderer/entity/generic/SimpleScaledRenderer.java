package its_meow.betteranimalsplus.client.renderer.entity.generic;

import com.mojang.blaze3d.matrix.MatrixStack;

import its_meow.betteranimalsplus.common.entity.util.IVariantTypes;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.MobEntity;

public class SimpleScaledRenderer<T extends MobEntity & IVariantTypes<?>, A extends EntityModel<T>> extends SimpleRenderer<T, A> {

    private final float adultScale;
    private final float childScale;

    public SimpleScaledRenderer(EntityRendererManager renderManagerIn, A entityModelIn, float shadowSizeIn, double adultScale, double childScale) {
        super(renderManagerIn, entityModelIn, shadowSizeIn);
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
