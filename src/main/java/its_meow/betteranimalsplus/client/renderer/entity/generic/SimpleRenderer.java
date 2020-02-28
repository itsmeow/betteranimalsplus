package its_meow.betteranimalsplus.client.renderer.entity.generic;

import its_meow.betteranimalsplus.common.entity.util.IVariantTypes;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.ResourceLocation;

public class SimpleRenderer<T extends MobEntity & IVariantTypes<?>, A extends EntityModel<T>> extends BaseRenderer<T, A> {

    public SimpleRenderer(EntityRendererManager renderManagerIn, A entityModelIn, float shadowSizeIn) {
        super(renderManagerIn, entityModelIn, shadowSizeIn);
    }

    @Override
    protected ResourceLocation getEntityTexture(T entity) {
        return entity.getVariantTexture();
    }

}
