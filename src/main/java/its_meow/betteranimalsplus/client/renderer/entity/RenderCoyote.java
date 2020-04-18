package its_meow.betteranimalsplus.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;

import its_meow.betteranimalsplus.client.model.ModelCoyote;
import its_meow.betteranimalsplus.client.renderer.entity.layers.LayerEyesCondition;
import its_meow.betteranimalsplus.common.entity.EntityCoyote;
import its_meow.betteranimalsplus.config.BetterAnimalsPlusConfig;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderCoyote extends MobRenderer<EntityCoyote, ModelCoyote<EntityCoyote>> {

    public RenderCoyote(EntityRendererManager manager) {
        super(manager, new ModelCoyote<EntityCoyote>(), 0.5F);
        this.addLayer(new LayerEyesCondition<EntityCoyote, ModelCoyote<EntityCoyote>>(this, ModTextures.coyote_eyes, e -> !e.isTamed() && !(e.isDaytime() && !BetterAnimalsPlusConfig.coyotesHostileDaytime)));
    }

    @Override
    protected float handleRotationFloat(EntityCoyote livingBase, float partialTicks) {
        return livingBase.getTailRotation();
    }

    @Override
    public void render(EntityCoyote entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        if(entityIn.isWolfWet()) {
            float f = entityIn.getBrightness() * entityIn.getShadingWhileWet(partialTicks);
            this.entityModel.setColors(f, f, f);
        }
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        if(entityIn.isWolfWet()) {
            this.entityModel.setColors(1.0F, 1.0F, 1.0F);
        }
    }

    @Override
    public ResourceLocation getEntityTexture(EntityCoyote entity) {
        if (entity.isTamed()) {
            return ModTextures.coyote_neutral;
        } else if(entity.isDaytime() && !BetterAnimalsPlusConfig.coyotesHostileDaytime) {
            return ModTextures.coyote_neutral;
        } else {
            return ModTextures.coyote_hostile;
        }
    }

}
