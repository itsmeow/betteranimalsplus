package its_meow.betteranimalsplus.client.renderer.entity;

import javax.annotation.Nonnull;

import its_meow.betteranimalsplus.client.model.ModelBear;
import its_meow.betteranimalsplus.common.entity.EntityBearNeutral;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderBlackBear extends MobRenderer<EntityBearNeutral, ModelBear<EntityBearNeutral>> {

    public RenderBlackBear(EntityRendererManager rendermanagerIn) {
        super(rendermanagerIn, new ModelBear<EntityBearNeutral>(), 1F);
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull EntityBearNeutral entity) {
        return ModTextures.bear_black;
    }

}
