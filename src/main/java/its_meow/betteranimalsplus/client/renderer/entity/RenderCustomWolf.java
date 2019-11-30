package its_meow.betteranimalsplus.client.renderer.entity;

import its_meow.betteranimalsplus.client.model.ModelFeralWolf;
import its_meow.betteranimalsplus.client.renderer.entity.layers.LayerEyesTamed;
import its_meow.betteranimalsplus.common.entity.EntityFeralWolf;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCustomWolf extends RenderLiving<EntityFeralWolf> {

    public RenderCustomWolf(RenderManager manager) {
        super(manager, new ModelFeralWolf(), 0.5F);
        this.addLayer(new LayerEyesTamed<EntityFeralWolf>(this, ModTextures.wolf_eyes));
    }

    @Override
    protected float handleRotationFloat(EntityFeralWolf livingBase, float partialTicks) {
        return livingBase.getTailRotation();
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityFeralWolf entity) {
        ResourceLocation result = null;
        int typeNumber = entity.getTypeNumber();
        if (entity.isTamed()) {
            switch (typeNumber) {
            case 1:
                result = ModTextures.wolf_black_neutral;
                break;
            case 2:
                result = ModTextures.wolf_snowy_neutral;
                break;
            case 3:
                result = ModTextures.wolf_timber_neutral;
                break;
            }
        } else {
            switch (typeNumber) {
            case 1:
                result = ModTextures.wolf_black;
                break;
            case 2:
                result = ModTextures.wolf_snowy;
                break;
            case 3:
                result = ModTextures.wolf_timber;
                break;
            }
        }
        return result;
    }

}
