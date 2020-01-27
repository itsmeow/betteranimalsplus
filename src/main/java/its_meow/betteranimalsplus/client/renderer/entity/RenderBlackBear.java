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
    public ResourceLocation getEntityTexture(@Nonnull EntityBearNeutral entity) {
        int type = entity.getTypeNumber();
        switch(type) {
        case 1: return ModTextures.bear_black;
        case 2: return ModTextures.bear_kermode;
        default: return ModTextures.bear_black;
        }
    }

}
