package dev.itsmeow.betteranimalsplus.client.renderer.entity.layers;

import com.mojang.blaze3d.matrix.MatrixStack;

import dev.itsmeow.imdlib.client.util.RenderUtil;
import dev.itsmeow.betteranimalsplus.client.model.ModelGoose;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;

public class GooseItemLayerRenderer<T extends LivingEntity> extends LayerRenderer<T, EntityModel<T>> {

    public GooseItemLayerRenderer(IEntityRenderer<T, EntityModel<T>> renderer) {
        super(renderer);
    }

    @Override
    public void render(MatrixStack stack, IRenderTypeBuffer bufferIn, int packedLightIn, T goose, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        ItemStack itemstack = goose.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
        if(!itemstack.isEmpty()) {
            stack.push();
            {
                RenderUtil.partTranslateRotate(stack, this.model().body, this.model().neck00, this.model().neck01, this.model().neck02, this.model().neck03, this.model().head, this.model().billUpper);
                stack.translate(0F, 0.15F, 0F);
                stack.scale(0.75F, 0.75F, 0.75F);
                Minecraft.getInstance().getItemRenderer().renderItem(goose, itemstack, TransformType.GROUND, false, stack, bufferIn, goose.getEntityWorld(), packedLightIn, LivingRenderer.getPackedOverlay(goose, 0.0F));
            }
            stack.pop();
        }
    }

    private ModelGoose<T> model() {
        return (ModelGoose<T>) this.getEntityModel();
    }

}
