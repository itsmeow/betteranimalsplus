package its_meow.betteranimalsplus.client.renderer.entity;

import com.mojang.blaze3d.platform.GlStateManager;

import its_meow.betteranimalsplus.client.model.ModelFox;
import its_meow.betteranimalsplus.common.entity.EntityFox;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderFox extends MobRenderer<EntityFox, ModelFox<EntityFox>> {

    public RenderFox(EntityRendererManager manager) {
        super(manager, new ModelFox<EntityFox>(), 0.5F);
    }

    @Override
    protected void preRenderCallback(EntityFox entitylivingbaseIn, float partialTickTime) {
        if (this.field_77045_g.isChild) {
            GlStateManager.scaled(0.6D, 0.6D, 0.6D);
        } else {
            GlStateManager.scaled(1.0D, 1.0D, 1.0D);
        }
    }

    /**
     * Defines what float the third param in setRotationAngles of ModelBase is
     */
    @Override
    protected float handleRotationFloat(EntityFox livingBase, float partialTicks) {
        return livingBase.getTailRotation();
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityFox entity) {
        ResourceLocation result = null;

        switch (entity.getTypeNumber()) {
        case 1:
            result = ModTextures.fox_1;
            break;
        case 2:
            result = ModTextures.fox_2;
            break;
        case 3:
            result = ModTextures.fox_3;
            break;
        case 4:
            result = ModTextures.fox_4;
            break;
        }
        return result;
    }

}
