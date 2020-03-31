package its_meow.betteranimalsplus.client.renderer.entity;

import its_meow.betteranimalsplus.client.model.ModelFeralWolf;
import its_meow.betteranimalsplus.client.renderer.entity.layers.LayerEyesCondition;
import its_meow.betteranimalsplus.common.entity.EntityFeralWolf;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCustomWolf extends RenderLiving<EntityFeralWolf> {

    public RenderCustomWolf(RenderManager manager) {
        super(manager, new ModelFeralWolf(), 0.5F);
        this.addLayer(new LayerEyesCondition<EntityFeralWolf>(this, ModTextures.wolf_eyes, e -> !e.isTamed()));
    }

    @Override
    protected float handleRotationFloat(EntityFeralWolf livingBase, float partialTicks) {
        return livingBase.getTailRotation();
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityFeralWolf entity) {
        int typeNumber = entity.getTypeNumber();
        if (entity.isTamed()) {
            switch (typeNumber) {
            case 1:
                return ModTextures.wolf_black_neutral;
            case 2:
                return ModTextures.wolf_snowy_neutral;
            case 3:
                return ModTextures.wolf_timber_neutral;
            case 4:
                return ModTextures.wolf_arctic_neutral;
            case 5:
                return ModTextures.wolf_brown_neutral;
            case 6:
                return ModTextures.wolf_red_neutral;
            default:
                return ModTextures.wolf_timber_neutral;
            }
        } else {
            switch (typeNumber) {
            case 1:
                return ModTextures.wolf_black;
            case 2:
                return ModTextures.wolf_snowy;
            case 3:
                return ModTextures.wolf_timber;
            case 4:
                return ModTextures.wolf_arctic;
            case 5:
                return ModTextures.wolf_brown;
            case 6:
                return ModTextures.wolf_red;
            default:
                return ModTextures.wolf_timber;
            }
        }
    }

}
