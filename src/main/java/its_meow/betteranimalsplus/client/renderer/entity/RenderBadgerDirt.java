package its_meow.betteranimalsplus.client.renderer.entity;

import its_meow.betteranimalsplus.common.entity.projectile.EntityBadgerDirt;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class RenderBadgerDirt extends EntityRenderer<EntityBadgerDirt> {

    public RenderBadgerDirt(EntityRendererManager renderManager) {
        super(renderManager);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityBadgerDirt entity) {
        return null;
    }

}