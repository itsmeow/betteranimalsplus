package its_meow.betteranimalsplus.client.renderer.entity;

import com.mojang.blaze3d.platform.GlStateManager;

import its_meow.betteranimalsplus.client.model.ModelCoyote;
import its_meow.betteranimalsplus.client.renderer.entity.layers.LayerEyesCondition;
import its_meow.betteranimalsplus.common.entity.EntityCoyote;
import its_meow.betteranimalsplus.config.BetterAnimalsPlusConfig;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderCoyote extends MobRenderer<EntityCoyote, ModelCoyote<EntityCoyote>> {

    public RenderCoyote(EntityRendererManager manager) {
        super(manager, new ModelCoyote<EntityCoyote>(), 0.5F);
        this.addLayer(new LayerEyesCondition<EntityCoyote, ModelCoyote<EntityCoyote>>(this, ModTextures.coyote_eyes, e -> !e.isTamed() && !(e.isDaytime() && !BetterAnimalsPlusConfig.coyotesHostileDaytime)));
    }
    
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
            GlStateManager.color3f(f, f, f);
        }

        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless
     * you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(EntityCoyote entity) {
        if (entity.isTamed()) {
            return ModTextures.coyote_neutral;
        } else if (entity.isDaytime() && !BetterAnimalsPlusConfig.coyotesHostileDaytime) {
            return ModTextures.coyote_neutral;
        } else {
            return ModTextures.coyote_hostile;
        }
    }

}
