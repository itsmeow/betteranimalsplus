package its_meow.betteranimalsplus.client.renderer.entity;

import its_meow.betteranimalsplus.client.model.ModelCustomWolf;
import its_meow.betteranimalsplus.client.renderer.entity.layers.LayerCoyoteEyes;
import its_meow.betteranimalsplus.common.entity.EntityCoyote;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCoyote extends RenderLiving<EntityCoyote> {

    public RenderCoyote(RenderManager manager) {
        super(manager, new ModelCustomWolf(), 0.5F);
        this.addLayer(new LayerCoyoteEyes(this));
    }
    
    @Override
    protected float handleRotationFloat(EntityCoyote livingBase, float partialTicks) {
        return livingBase.getTailRotation();
    }
    
    @Override
    protected ResourceLocation getEntityTexture(EntityCoyote entity) {
        if (entity.isTamed()) {
            return ModTextures.coyote_neutral;
        } else if (entity.isDaytime()) {
            return ModTextures.coyote_neutral;
        } else {
            return ModTextures.coyote_hostile;
        }
    }

}
