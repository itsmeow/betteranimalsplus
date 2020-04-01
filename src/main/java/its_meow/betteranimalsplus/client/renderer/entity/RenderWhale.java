package its_meow.betteranimalsplus.client.renderer.entity;

import its_meow.betteranimalsplus.client.model.ModelBeakedWhale;
import its_meow.betteranimalsplus.client.model.ModelSmallWhale;
import its_meow.betteranimalsplus.common.entity.EntityWhale;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderWhale extends RenderLiving<EntityWhale> {

    public static final ModelSmallWhale SMALL_WHALE = new ModelSmallWhale();
    public static final ModelBeakedWhale BEAKED_WHALE = new ModelBeakedWhale();

    public RenderWhale(RenderManager mgr) {
        super(mgr, SMALL_WHALE, 3F);
    }

    @Override
    protected void preRenderCallback(EntityWhale entity, float partialTickTime) {
        switch(entity.getTypeNumber()) {
        case 1: GlStateManager.scale(1.8D, 1.8D, 1.8D); break; //false killer
        case 2: GlStateManager.scale(1.5D, 1.5D, 1.5D); break; //beluga
        case 3: GlStateManager.scale(1.6D, 1.6D, 1.6D); break; //narwhal
        case 4: GlStateManager.scale(2.0D, 2.0D, 2.0D); break; //pilot
        case 5: GlStateManager.scale(2.5D, 2.5D, 2.5D); break; //bottlenose
        case 6: GlStateManager.scale(1.7D, 1.7D, 1.7D); break; //cuivers
        }
    }

    @Override
    public void doRender(EntityWhale entity, double x, double y, double z, float entityYaw, float partialTicks) {
        if(entity.getTypeNumber() > 4) {
            this.mainModel = BEAKED_WHALE;
        } else {
            this.mainModel = SMALL_WHALE;
        }
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityWhale entity) {
        switch (entity.getTypeNumber()) {
        case 1:
            return ModTextures.whale_1;
        case 2:
            return ModTextures.whale_2;
        case 3:
            return ModTextures.whale_3;
        case 4:
            return ModTextures.whale_4;
        case 5:
            return ModTextures.whale_5;
        case 6:
            return ModTextures.whale_6;
        default:
            return ModTextures.whale_1;
        }
    }

}
