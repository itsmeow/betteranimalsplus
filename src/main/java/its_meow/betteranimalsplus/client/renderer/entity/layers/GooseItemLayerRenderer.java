package its_meow.betteranimalsplus.client.renderer.entity.layers;

import com.mojang.blaze3d.matrix.MatrixStack;

import dev.itsmeow.imdlib.client.util.RenderUtil;
import its_meow.betteranimalsplus.client.model.ModelGoose;
import its_meow.betteranimalsplus.common.entity.EntityGoose;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms.TransformType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;

@SuppressWarnings("deprecation")
public class GooseItemLayerRenderer extends LayerRenderer<EntityGoose, EntityModel<EntityGoose>> {

    public GooseItemLayerRenderer(IEntityRenderer<EntityGoose, EntityModel<EntityGoose>> renderer) {
        super(renderer);
    }

    @Override
    public void render(MatrixStack stack, IRenderTypeBuffer bufferIn, int packedLightIn, EntityGoose goose, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
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

    private ModelGoose<EntityGoose> model() {
        return (ModelGoose<EntityGoose>) this.getEntityModel();
    }

}
