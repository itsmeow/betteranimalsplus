package its_meow.betteranimalsplus.client.renderer.entity;

import its_meow.betteranimalsplus.client.model.ModelFreshwaterEel;
import its_meow.betteranimalsplus.common.entity.EntityFreshwaterEel;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderFreshwaterEel extends RenderLiving<EntityFreshwaterEel> {

    public RenderFreshwaterEel(RenderManager renderManagerIn) {
        super(renderManagerIn, new ModelFreshwaterEel(), 0.4F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityFreshwaterEel entity) {
        int type = entity.getTypeNumber();
        switch(type) {
        case 1: return ModTextures.eel_freshwater_longfin;
        case 2: return ModTextures.eel_freshwater_silver;
        default: return ModTextures.eel_freshwater_longfin;
        }
    }

}
