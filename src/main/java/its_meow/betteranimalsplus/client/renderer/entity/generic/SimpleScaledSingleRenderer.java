package its_meow.betteranimalsplus.client.renderer.entity.generic;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.ResourceLocation;

public class SimpleScaledSingleRenderer<T extends MobEntity, A extends EntityModel<T>> extends SimpleSingleRenderer<T, A> {
    
    private final double adultScale;
    private final double childScale;

    public SimpleScaledSingleRenderer(EntityRendererManager renderManagerIn, A entityModelIn, float shadowSizeIn, ResourceLocation texture, double adultScale, double childScale) {
        super(renderManagerIn, entityModelIn, shadowSizeIn, texture);
        this.adultScale = adultScale;
        this.childScale = childScale;
    }
    
    @Override
    protected void preRenderCallback(T entity, float partialTickTime) {
        if (this.entityModel.isChild) {
            GlStateManager.scaled(childScale, childScale, childScale);
        } else {
            GlStateManager.scaled(adultScale, adultScale, adultScale);
        }
    }

}
