package its_meow.betteranimalsplus.client.renderer.entity;

import com.mojang.blaze3d.platform.GlStateManager;

import its_meow.betteranimalsplus.client.model.ModelGreenlandShark;
import its_meow.betteranimalsplus.client.model.ModelShark;
import its_meow.betteranimalsplus.common.entity.EntityShark;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

public class RenderShark extends MobRenderer<EntityShark, EntityModel<EntityShark>> {
    
    public static final EntityModel<EntityShark> SHARK = new ModelShark<EntityShark>();
    public static final EntityModel<EntityShark> SHARK_GREENLAND = new ModelGreenlandShark<EntityShark>();

    public RenderShark(EntityRendererManager rendermanagerIn) {
        super(rendermanagerIn, SHARK, 2F);
    }
    
    @Override
    protected void preRenderCallback(EntityShark entity, float partialTickTime) {
        switch(entity.getVariantName()) {
        case "blue": GlStateManager.scaled(0.8D, 0.7D, 0.8D); break;
        case "bull": GlStateManager.scaled(0.6D, 0.6D, 0.6D); break;
        case "tiger": GlStateManager.scaled(1.1D, 1.1D, 1.1D); break;
        case "whitetip": GlStateManager.scaled(0.8D, 0.8D, 0.8D); break;
        case "greenland": GlStateManager.scaled(1.7D, 1.7D, 1.7D); GlStateManager.translated(0D, 0.3D, 0D); break;
        }
    }
    
    @Override
    public void doRender(EntityShark entity, double x, double y, double z, float entityYaw, float partialTicks) {
        if (entity.getVariantName().equals("greenland")) {
            this.entityModel = SHARK_GREENLAND;
        } else {
            this.entityModel = SHARK;
        }
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityShark entity) {
        return entity.getVariantTexture();
    }

}
