package its_meow.betteranimalsplus.client.renderer.entity.layers;

import com.mojang.blaze3d.platform.GlStateManager;

import dev.itsmeow.imdlib.client.util.RenderUtil;
import its_meow.betteranimalsplus.client.model.ModelGoose;
import its_meow.betteranimalsplus.common.entity.EntityGoose;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;

@SuppressWarnings("deprecation")
public class GooseItemLayerRenderer<T extends LivingEntity> extends LayerRenderer<T, EntityModel<T>> {

    public GooseItemLayerRenderer(IEntityRenderer<T, EntityModel<T>> renderer) {
        super(renderer);
    }

    @Override
    public void render(T goose, float p_212842_2_, float p_212842_3_, float p_212842_4_, float p_212842_5_, float p_212842_6_, float p_212842_7_, float p_212842_8_) {
        ItemStack itemstack = goose.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
        if(!itemstack.isEmpty()) {
            GlStateManager.pushMatrix();
            {
                RenderUtil.partTranslateRotate(this.model().body, this.model().neck00, this.model().neck01, this.model().neck02, this.model().neck03, this.model().head, this.model().billUpper);
                GlStateManager.translatef(0F, 0.15F, 0F);
                GlStateManager.scalef(0.75F, 0.75F, 0.75F);
                Minecraft.getInstance().getItemRenderer().renderItem(itemstack, goose, TransformType.GROUND, false);
            }
            GlStateManager.popMatrix();
        }
    }

    @SuppressWarnings("unchecked")
    private ModelGoose<EntityGoose> model() {
        return (ModelGoose<EntityGoose>) this.getEntityModel();
    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }

}
