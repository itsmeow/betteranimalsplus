package its_meow.betteranimalsplus.client.renderer.entity;

import its_meow.betteranimalsplus.client.model.ModelSaltwaterEel;
import its_meow.betteranimalsplus.common.entity.EntitySaltwaterEel;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderSaltwaterEel extends MobRenderer<EntitySaltwaterEel, ModelSaltwaterEel<EntitySaltwaterEel>>{

    public RenderSaltwaterEel(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelSaltwaterEel<EntitySaltwaterEel>(), 0.4F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntitySaltwaterEel entity) {
        int type = entity.getTypeNumber();
        switch(type) {
        case 1: return ModTextures.eel_saltwater_conger;
        case 2: return ModTextures.eel_saltwater_dragon;
        case 3: return ModTextures.eel_saltwater_morray;
        case 4: return ModTextures.eel_saltwater_ribbon;
        case 5: return ModTextures.eel_saltwater_snowflake;
        default: return ModTextures.eel_saltwater_conger;
        }
    }

}
