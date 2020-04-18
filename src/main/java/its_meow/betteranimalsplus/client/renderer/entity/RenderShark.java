package its_meow.betteranimalsplus.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;

import its_meow.betteranimalsplus.client.model.ModelGreenlandShark;
import its_meow.betteranimalsplus.client.model.ModelShark;
import its_meow.betteranimalsplus.common.entity.EntityShark;
import net.minecraft.client.renderer.IRenderTypeBuffer;
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
    protected void preRenderCallback(EntityShark entity, MatrixStack stack, float partialTickTime) {
        switch(entity.getVariantName()) {
        case "blue": stack.scale(0.8F, 0.7F, 0.8F); break;
        case "bull": stack.scale(0.6F, 0.6F, 0.6F); break;
        case "tiger": stack.scale(1.1F, 1.1F, 1.1F); break;
        case "whitetip": stack.scale(0.8F, 0.8F, 0.8F); break;
        case "greenland": stack.scale(1.7F, 1.7F, 1.7F); stack.translate(0F, 0.3F, 0F); break;
        }
    }

    @Override
    public void render(EntityShark entity, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        if (entity.getVariantName().equals("greenland")) {
            this.entityModel = SHARK_GREENLAND;
        } else {
            this.entityModel = SHARK;
        }
        super.render(entity, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityShark entity) {
        return entity.getVariantTexture();
    }

}
