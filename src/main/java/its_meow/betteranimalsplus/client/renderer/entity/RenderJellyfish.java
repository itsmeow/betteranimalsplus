package its_meow.betteranimalsplus.client.renderer.entity;

import javax.annotation.Nonnull;

import its_meow.betteranimalsplus.client.model.ModelJellyfish;
import its_meow.betteranimalsplus.common.entity.EntityJellyfish;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderJellyfish extends RenderLiving<EntityJellyfish> {

    public RenderJellyfish(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelJellyfish(), 0.5F);
    }

    @Override
    protected void preRenderCallback(EntityJellyfish entitylivingbaseIn, float partialTickTime) {
        float s = entitylivingbaseIn.getSize();
        GlStateManager.scale(s, s, s);
        GlStateManager.translate(0, 1F, 0);
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull EntityJellyfish entity) {
        int type = entity.getTypeNumber();
        ResourceLocation res = ModTextures.jellyfish_1;
        switch (type) {
        case 1:
            res = ModTextures.jellyfish_1;
            break;
        case 2:
            res = ModTextures.jellyfish_2;
            break;
        case 3:
            res = ModTextures.jellyfish_3;
            break;
        case 4:
            res = ModTextures.jellyfish_4;
            break;
        case 5:
            res = ModTextures.jellyfish_5;
            break;
        case 6:
            res = ModTextures.jellyfish_6;
            break;
        default:
            res = ModTextures.jellyfish_1;
            break;
        }
        return res;
    }

}
