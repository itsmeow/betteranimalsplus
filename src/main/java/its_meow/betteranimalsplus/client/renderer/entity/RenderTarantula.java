package its_meow.betteranimalsplus.client.renderer.entity;

import its_meow.betteranimalsplus.client.model.ModelTarantula;
import its_meow.betteranimalsplus.client.renderer.entity.layers.LayerEyes;
import its_meow.betteranimalsplus.common.entity.EntityTarantula;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderTarantula extends RenderLiving<EntityTarantula> {

    public RenderTarantula(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelTarantula(), 1F);
        this.addLayer(new LayerEyes<EntityTarantula>(this, ModTextures.tarantula_eyes));
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityTarantula entity) {
        return ModTextures.tarantula;
    }

}
