package its_meow.betteranimalsplus.client.renderer.entity.generic;

import com.mojang.blaze3d.platform.GlStateManager;

import its_meow.betteranimalsplus.common.entity.util.IVariantTypes;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.MobEntity;

public class SimpleScaledRenderer<T extends MobEntity & IVariantTypes<?>, A extends EntityModel<T>> extends SimpleRenderer<T, A> {
    
    private final double adultScale;
    private final double childScale;

    public SimpleScaledRenderer(EntityRendererManager renderManagerIn, A entityModelIn, float shadowSizeIn, double adultScale, double childScale) {
        super(renderManagerIn, entityModelIn, shadowSizeIn);
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
