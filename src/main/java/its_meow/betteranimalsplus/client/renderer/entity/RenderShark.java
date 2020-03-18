package its_meow.betteranimalsplus.client.renderer.entity;

import its_meow.betteranimalsplus.client.model.ModelGreenlandShark;
import its_meow.betteranimalsplus.client.model.ModelShark;
import its_meow.betteranimalsplus.common.entity.EntityShark;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderShark extends RenderLiving<EntityShark> {
    
    public static final ModelShark SHARK = new ModelShark();
    public static final ModelGreenlandShark SHARK_GREENLAND = new ModelGreenlandShark();

    public RenderShark(RenderManager rendermanagerIn) {
        super(rendermanagerIn, SHARK, 2F);
    }
    
    @Override
    protected void preRenderCallback(EntityShark entity, float partialTickTime) {
        int type = entity.getTypeNumber();
        switch(type) {
        case 1: GlStateManager.scale(0.8D, 0.7D, 0.8D); break;
        case 2: GlStateManager.scale(0.6D, 0.6D, 0.6D); break;
        case 3: GlStateManager.scale(1.1D, 1.1D, 1.1D); break;
        case 4: GlStateManager.scale(0.8D, 0.8D, 0.8D); break;
        case 5: GlStateManager.scale(1.7D, 1.7D, 1.7D); GlStateManager.translate(0D, 0.3D, 0D); break;
        }
    }
    
    @Override
    public void doRender(EntityShark entity, double x, double y, double z, float entityYaw, float partialTicks) {
        if (entity.getTypeNumber() == 5) {
            this.mainModel = SHARK_GREENLAND;
        } else {
            this.mainModel = SHARK;
        }
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityShark entity) {
        int type = entity.getTypeNumber();
        switch (type) {
        case 1:
            return ModTextures.shark_blue;
        case 2:
            return ModTextures.shark_bull;
        case 3:
            return ModTextures.shark_tiger;
        case 4:
            return ModTextures.shark_whitetip;
        case 5:
            return ModTextures.shark_greenland;
        default:
            return ModTextures.shark_bull;
        }
    }

}
