package its_meow.betteranimalsplus.client.renderer.entity;

import javax.annotation.Nonnull;

import com.mojang.blaze3d.platform.GlStateManager;

import its_meow.betteranimalsplus.client.model.ModelTurkey;
import its_meow.betteranimalsplus.common.entity.EntityTurkey;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class RenderTurkey extends MobRenderer<EntityTurkey, ModelTurkey<EntityTurkey>> {

    public RenderTurkey(EntityRendererManager rendermanagerIn) {
        super(rendermanagerIn, new ModelTurkey<EntityTurkey>(), 0.5F);
    }

    @Override
    protected void preRenderCallback(EntityTurkey entitylivingbaseIn, float partialTickTime) {
        if (this.entityModel.isChild) {
            GlStateManager.scaled(0.5D, 0.5D, 0.5D);
        } else {
            GlStateManager.scaled(0.8D, 0.8D, 0.8D);
        }
    }

    @Override
    protected float handleRotationFloat(EntityTurkey livingBase, float partialTicks) {
        float f = livingBase.oFlap + (livingBase.wingRotation - livingBase.oFlap) * partialTicks;
        float f1 = livingBase.oFlapSpeed + (livingBase.destPos - livingBase.oFlapSpeed) * partialTicks;
        return (MathHelper.sin(f) + 1.0F) * f1;
    }

    @Override
    @Nonnull
    public ResourceLocation getEntityTexture(@Nonnull EntityTurkey entity) {
        int type = entity.getTypeNumber();
        switch(type) {
        case 1: return ModTextures.turkey_1;
        case 2: return ModTextures.turkey_2;
        case 3: return ModTextures.turkey_3;
        case 4: return ModTextures.turkey_4;
        default: return ModTextures.turkey_1;
        }
    }

}
