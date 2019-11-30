package its_meow.betteranimalsplus.client.renderer.entity;

import its_meow.betteranimalsplus.client.model.ModelZotzpyre;
import its_meow.betteranimalsplus.client.renderer.entity.layers.LayerEyes;
import its_meow.betteranimalsplus.common.entity.EntityZotzpyre;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderZotzpyre extends MobRenderer<EntityZotzpyre, ModelZotzpyre<EntityZotzpyre>> {

	public RenderZotzpyre(EntityRendererManager rendermanager) {
		super(rendermanager, new ModelZotzpyre<EntityZotzpyre>(), 0.4F);
		this.addLayer(new LayerEyes<EntityZotzpyre, ModelZotzpyre<EntityZotzpyre>>(this, ModTextures.zotzpyre_eyes));
	}

    @Override
    protected ResourceLocation getEntityTexture(EntityZotzpyre entity) {
        switch(entity.getTypeNumber()) {
        case 1:
            return ModTextures.zotzpyre_1;
        case 2:
            return ModTextures.zotzpyre_2;
        case 3:
            return ModTextures.zotzpyre_3;
        case 4:
            return ModTextures.zotzpyre_4;
        case 5:
            return ModTextures.zotzpyre_5;
        default:
            return ModTextures.zotzpyre_1;
        }
    }

}
