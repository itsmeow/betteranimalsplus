package its_meow.betteranimalsplus.client.renderer.entity.generic;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.ResourceLocation;

public class SimpleSingleRenderer<T extends MobEntity, A extends EntityModel<T>> extends BaseRenderer<T, A> {
    
    private ResourceLocation texture;

    public SimpleSingleRenderer(EntityRendererManager renderManagerIn, A entityModelIn, float shadowSizeIn, ResourceLocation texture) {
        super(renderManagerIn, entityModelIn, shadowSizeIn);
        this.texture = texture;
    }

    @Override
    protected ResourceLocation getEntityTexture(T entity) {
        return texture;
    }

}
