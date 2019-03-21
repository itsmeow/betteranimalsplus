package its_meow.betteranimalsplus.client.renderer.entity;

import javax.annotation.Nonnull;

import its_meow.betteranimalsplus.client.model.ModelBear;
import its_meow.betteranimalsplus.common.entity.EntityBearNeutralKermode;
import its_meow.betteranimalsplus.init.TextureRegistry;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderKermodeBear extends RenderLiving<EntityBearNeutralKermode> {

    public RenderKermodeBear(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelBear(), 1F);
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull EntityBearNeutralKermode entity) {
        return TextureRegistry.bear_kermode;
    }

}
