package its_meow.betteranimalsplus.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;

import its_meow.betteranimalsplus.client.model.ModelFeralWolf;
import its_meow.betteranimalsplus.client.renderer.entity.layers.LayerEyesCondition;
import its_meow.betteranimalsplus.common.entity.EntityFeralWolf;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderCustomWolf extends MobRenderer<EntityFeralWolf, ModelFeralWolf<EntityFeralWolf>> {

    public RenderCustomWolf(EntityRendererManager manager) {
        super(manager, new ModelFeralWolf<EntityFeralWolf>(), 0.5F);
        this.addLayer(new LayerEyesCondition<EntityFeralWolf, ModelFeralWolf<EntityFeralWolf>>(this, ModTextures.wolf_eyes, e -> !e.isTamed()));
    }

    @Override
    protected float handleRotationFloat(EntityFeralWolf livingBase, float partialTicks) {
        return livingBase.getTailRotation();
    }

    @Override
    public void render(EntityFeralWolf entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
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
    public ResourceLocation getEntityTexture(EntityFeralWolf entity) {
        if(entity.isTamed()) {
            switch(entity.getVariantName()) {
            case "black":
                return ModTextures.wolf_black_neutral;
            case "snowy":
                return ModTextures.wolf_snowy_neutral;
            case "timber":
                return ModTextures.wolf_timber_neutral;
            case "arctic":
                return ModTextures.wolf_arctic_neutral;
            case "brown":
                return ModTextures.wolf_brown_neutral;
            case "red":
                return ModTextures.wolf_red_neutral;
            }
        }
        return entity.getVariantTexture();
    }

}
