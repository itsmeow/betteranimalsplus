package its_meow.betteranimalsplus.client.renderer.entity;

import its_meow.betteranimalsplus.client.model.ModelTarantula;
import its_meow.betteranimalsplus.client.renderer.entity.layers.LayerTarantulaEyes;
import its_meow.betteranimalsplus.common.entity.EntityTarantula;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class RenderTarantula extends MobRenderer<EntityTarantula, ModelTarantula<EntityTarantula>> {

    public RenderTarantula(EntityRendererManager rendermanagerIn) {
        super(rendermanagerIn, new ModelTarantula<EntityTarantula>(), 1F);
        this.addLayer(new LayerTarantulaEyes(this));
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityTarantula entity) {
        return ModTextures.tarantula;
    }

}
