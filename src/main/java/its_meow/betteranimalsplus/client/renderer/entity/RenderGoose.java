package its_meow.betteranimalsplus.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;

import its_meow.betteranimalsplus.client.model.ModelGoose;
import its_meow.betteranimalsplus.common.entity.EntityGoose;
import its_meow.betteranimalsplus.util.RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.model.ItemCameraTransforms.TransformType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

@SuppressWarnings("deprecation")
public class RenderGoose extends MobRenderer<EntityGoose, ModelGoose<EntityGoose>> {

    public RenderGoose(EntityRendererManager rendermanagerIn) {
        super(rendermanagerIn, new ModelGoose<EntityGoose>(), 0.5F);
        this.addLayer(new GooseItemLayerRenderer(this));
    }

    @Override
    protected void preRenderCallback(EntityGoose entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        if(this.entityModel.isChild) {
            matrixStackIn.scale(0.5F, 0.5F, 0.5F);
        } else {
            matrixStackIn.scale(0.8F, 0.8F, 0.8F);
        }
    }

    @Override
    public ResourceLocation getEntityTexture(EntityGoose entity) {
        return entity.getVariantTexture();
    }

    public static class GooseItemLayerRenderer extends LayerRenderer<EntityGoose, ModelGoose<EntityGoose>> {

        public GooseItemLayerRenderer(RenderGoose renderer) {
            super(renderer);
        }

        @Override
        public void render(MatrixStack stack, IRenderTypeBuffer bufferIn, int packedLightIn, EntityGoose goose, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            ItemStack itemstack = goose.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
            if(!itemstack.isEmpty()) {
                stack.push();
                {
                    RenderUtil.partTranslateRotate(stack, this.getEntityModel().body, this.getEntityModel().neck00, this.getEntityModel().neck01, this.getEntityModel().neck02, this.getEntityModel().neck03, this.getEntityModel().head, this.getEntityModel().billUpper);
                    stack.translate(0F, 0.15F, 0F);
                    stack.scale(0.75F, 0.75F, 0.75F);
                    Minecraft.getInstance().getItemRenderer().renderItem(goose, itemstack, TransformType.GROUND, false, stack, bufferIn, goose.getEntityWorld(), packedLightIn, LivingRenderer.getPackedOverlay(goose, 0.0F));
                }
                stack.pop();
            }
        }
    }

}
