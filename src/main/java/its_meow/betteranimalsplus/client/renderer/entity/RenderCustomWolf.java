package its_meow.betteranimalsplus.client.renderer.entity;

import com.mojang.blaze3d.platform.GlStateManager;

import its_meow.betteranimalsplus.client.model.ModelFeralWolf;
import its_meow.betteranimalsplus.client.renderer.entity.layers.LayerEyesCondition;
import its_meow.betteranimalsplus.common.entity.EntityFeralWolf;
import its_meow.betteranimalsplus.init.ModTextures;
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
    public void doRender(EntityFeralWolf entity, double x, double y, double z, float entityYaw, float partialTicks) {
        if(entity.isWolfWet()) {
            float f = entity.getBrightness() * entity.getShadingWhileWet(partialTicks);
            GlStateManager.color3f(f, f, f);
        }

        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityFeralWolf entity) {
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
