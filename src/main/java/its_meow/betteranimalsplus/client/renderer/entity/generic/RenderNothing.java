package its_meow.betteranimalsplus.client.renderer.entity.generic;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderNothing<T extends Entity> extends EntityRenderer<T> {

    public RenderNothing(EntityRendererManager renderManager) {
        super(renderManager);
    }

    @Override
    public ResourceLocation getEntityTexture(T entity) {
        return null;
    }

}