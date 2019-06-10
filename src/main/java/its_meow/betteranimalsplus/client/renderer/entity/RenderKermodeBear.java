package its_meow.betteranimalsplus.client.renderer.entity;

import javax.annotation.Nonnull;

import its_meow.betteranimalsplus.client.model.ModelBear;
import its_meow.betteranimalsplus.common.entity.EntityBearNeutralKermode;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class RenderKermodeBear extends MobRenderer<EntityBearNeutralKermode> {

    public RenderKermodeBear(EntityRendererManager rendermanagerIn) {
        super(rendermanagerIn, new ModelBear(), 1F);
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull EntityBearNeutralKermode entity) {
        return ModTextures.bear_kermode;
    }

}
