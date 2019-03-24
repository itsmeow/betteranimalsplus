package its_meow.betteranimalsplus.client.renderer.entity;

import its_meow.betteranimalsplus.client.model.ModelFox;
import its_meow.betteranimalsplus.common.entity.EntityFox;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderFox extends RenderLiving<EntityFox> {

    public RenderFox(RenderManager manager) {
        super(manager, new ModelFox(), 0.5F);
    }

    @Override
    protected void preRenderCallback(EntityFox entitylivingbaseIn, float partialTickTime) {
        if (this.getMainModel().isChild) {
            GlStateManager.scale(0.6D, 0.6D, 0.6D);
        } else {
            GlStateManager.scale(1.0D, 1.0D, 1.0D);
        }
    }

    /**
     * Defines what float the third param in setRotationAngles of ModelBase is
     */
    @Override
    protected float handleRotationFloat(EntityFox livingBase, float partialTicks) {
        return livingBase.getTailRotation();
    }

    /**
     * Renders the desired {@code T} type Entity.
     */
    @Override
    public void doRender(EntityFox entity, double x, double y, double z, float entityYaw, float partialTicks) {
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
    protected ResourceLocation getEntityTexture(EntityFox entity) {
        return this.getFoxTexture(entity.getTypeNumber(), entity);
    }

    private ResourceLocation getFoxTexture(int typeNumber, EntityFox entity) {
        ResourceLocation result = null;

        switch (typeNumber) {
        case 1:
            result = ModTextures.fox_1;
            break;
        case 2:
            result = ModTextures.fox_2;
            break;
        case 3:
            result = ModTextures.fox_3;
            break;
        case 4:
            result = ModTextures.fox_4;
            break;
        }
        return result;
    }

}
