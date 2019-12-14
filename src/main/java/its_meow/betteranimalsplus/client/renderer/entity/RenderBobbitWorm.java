package its_meow.betteranimalsplus.client.renderer.entity;

import its_meow.betteranimalsplus.client.model.ModelBobbitWorm;
import its_meow.betteranimalsplus.common.entity.EntityBobbitWorm;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderBobbitWorm extends RenderLiving<EntityBobbitWorm> {

    public RenderBobbitWorm(RenderManager mgr) {
        super(mgr, new ModelBobbitWorm(), 0.4F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityBobbitWorm entity) {
        if(entity.getTypeNumber() == 2) {
            return ModTextures.bobbit_worm_2;
        } else {
            return ModTextures.bobbit_worm_1;
        }
    }

}
