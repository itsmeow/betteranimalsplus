package its_meow.betteranimalsplus.client.renderer.entity;

import its_meow.betteranimalsplus.client.model.ModelWalrus;
import its_meow.betteranimalsplus.common.entity.EntityWalrus;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderWalrus extends RenderLiving<EntityWalrus> {

    public RenderWalrus(RenderManager rendermanager) {
        super(rendermanager, new ModelWalrus(), 1.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityWalrus entity) {
        return ModTextures.walrus;
    }

}
