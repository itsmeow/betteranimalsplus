package its_meow.betteranimalsplus.client.renderer.entity;

import its_meow.betteranimalsplus.client.model.ModelCustomWolf;
import its_meow.betteranimalsplus.client.renderer.entity.layers.LayerCoyoteEyes;
import its_meow.betteranimalsplus.common.entity.EntityCoyote;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCoyote extends RenderLiving<EntityCoyote> {

    public RenderCoyote(RenderManager manager) {
        super(manager, new ModelCustomWolf(), 0.5F);
        this.addLayer(new LayerCoyoteEyes(this));
    }

    /**
     * Defines what float the third param in setRotationAngles of ModelBase is
     */
    @Override
    protected float handleRotationFloat(EntityCoyote livingBase, float partialTicks) {
        return livingBase.getTailRotation();
    }

    /**
     * Renders the desired {@code T} type Entity.
     */
    @Override
    public void doRender(EntityCoyote entity, double x, double y, double z, float entityYaw, float partialTicks) {
        if (entity.isWolfWet()) {
            float f = entity.getBrightness() * entity.getShadingWhileWet(partialTicks);
            GlStateManager.color(f, f, f);
        }

        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless
     * you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(EntityCoyote entity) {
        return this.getCoyoteTexture(entity);
    }

    private ResourceLocation getCoyoteTexture(EntityCoyote entity) {
        if (entity.isTamed()) {
            return ModTextures.coyote_neutral;
        } else if (entity.isDaytime()) {
            return ModTextures.coyote_neutral;
        } else {
            return ModTextures.coyote_hostile;
        }
    }

}
