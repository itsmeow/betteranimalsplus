package dev.itsmeow.betteranimalsplus.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.itsmeow.betteranimalsplus.client.model.entity.ModelGoose;
import dev.itsmeow.imdlib.client.util.RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms.TransformType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class GooseItemLayerRenderer<T extends LivingEntity> extends RenderLayer<T, EntityModel<T>> {

    public GooseItemLayerRenderer(RenderLayerParent<T, EntityModel<T>> renderer) {
        super(renderer);
    }

    @Override
    public void render(PoseStack stack, MultiBufferSource bufferIn, int packedLightIn, T goose, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        ItemStack itemstack = goose.getItemBySlot(EquipmentSlot.MAINHAND);
        if (!itemstack.isEmpty()) {
            stack.pushPose();
            {
                RenderUtil.partTranslateRotate(stack, this.model().body, this.model().neck00, this.model().neck01, this.model().neck02, this.model().neck03, this.model().head, this.model().billUpper);
                stack.translate(0F, 0.15F, 0F);
                stack.scale(0.75F, 0.75F, 0.75F);
                Minecraft.getInstance().getItemRenderer().renderStatic(goose, itemstack, TransformType.GROUND, false, stack, bufferIn, goose.getCommandSenderWorld(), packedLightIn, LivingEntityRenderer.getOverlayCoords(goose, 0.0F), 0);
            }
            stack.popPose();
        }
    }

    private ModelGoose<T> model() {
        return (ModelGoose<T>) this.getParentModel();
    }

}
