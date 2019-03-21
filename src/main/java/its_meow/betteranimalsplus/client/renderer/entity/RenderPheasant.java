package its_meow.betteranimalsplus.client.renderer.entity;

import javax.annotation.Nonnull;

import its_meow.betteranimalsplus.client.model.ModelPheasant;
import its_meow.betteranimalsplus.common.entity.EntityPheasant;
import its_meow.betteranimalsplus.init.TextureRegistry;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class RenderPheasant extends RenderLiving<EntityPheasant> {

    public RenderPheasant(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelPheasant(), 0.5F);
    }

    @Override
    protected void preRenderCallback(EntityPheasant entitylivingbaseIn, float partialTickTime) {
        if (this.getMainModel().isChild) {
            GlStateManager.scale(0.5D, 0.5D, 0.5D);
        } else {
            GlStateManager.scale(1.0D, 1.0D, 1.0D);
        }
    }

    @Override
    protected float handleRotationFloat(EntityPheasant livingBase, float partialTicks) {
        float f = livingBase.oFlap + (livingBase.wingRotation - livingBase.oFlap) * partialTicks;
        float f1 = livingBase.oFlapSpeed + (livingBase.destPos - livingBase.oFlapSpeed) * partialTicks;
        return (MathHelper.sin(f) + 1.0F) * f1;
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull EntityPheasant entity) {
        int type = entity.getTypeNumber();
        ResourceLocation res = TextureRegistry.pheasant_1;
        switch (type) {
        case 1:
            res = TextureRegistry.pheasant_1;
            break;
        case 2:
            res = TextureRegistry.pheasant_2;
            break;
        default:
            res = TextureRegistry.pheasant_1;
            break;
        }
        return res;
    }

}
