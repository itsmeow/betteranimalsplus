package its_meow.betteranimalsplus.client.renderer.entity;

import javax.annotation.Nonnull;

import com.mojang.blaze3d.platform.GlStateManager;

import its_meow.betteranimalsplus.client.model.ModelGoose;
import its_meow.betteranimalsplus.common.entity.EntityGoose;
import its_meow.betteranimalsplus.init.ModTextures;
import its_meow.betteranimalsplus.util.RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRendererManager;
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
    protected void preRenderCallback(EntityGoose entitylivingbaseIn, float partialTickTime) {
        if (this.entityModel.isChild) {
            GlStateManager.scaled(0.5D, 0.5D, 0.5D);
        } else {
            GlStateManager.scaled(0.8D, 0.8D, 0.8D);
        }
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull EntityGoose entity) {
        int type = entity.getTypeNumber();
        switch(type) {
        case 1: return ModTextures.goose_1;
        case 2: return ModTextures.goose_2;
        case 3: return ModTextures.goose_3;
        default: return ModTextures.goose_1;
        }
    }

    public static class GooseItemLayerRenderer extends LayerRenderer<EntityGoose, ModelGoose<EntityGoose>> {

        public GooseItemLayerRenderer(RenderGoose renderer) {
            super(renderer);
        }

        @Override
        public void render(EntityGoose goose, float p_212842_2_, float p_212842_3_, float p_212842_4_, float p_212842_5_, float p_212842_6_, float p_212842_7_, float p_212842_8_) {
            ItemStack itemstack = goose.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
            if(!itemstack.isEmpty()) {
                GlStateManager.pushMatrix();
                {
                    RenderUtil.partTranslateRotate(this.getEntityModel().body, this.getEntityModel().neck00, this.getEntityModel().neck01, this.getEntityModel().neck02, this.getEntityModel().neck03, this.getEntityModel().head, this.getEntityModel().billUpper);
                    GlStateManager.translatef(0F, 0.15F, 0F);
                    GlStateManager.scalef(0.75F, 0.75F, 0.75F);
                    Minecraft.getInstance().getItemRenderer().renderItem(itemstack, goose, TransformType.GROUND, false);
                }
                GlStateManager.popMatrix();
            }
        }

        @Override
        public boolean shouldCombineTextures() {
            return false;
        }

    }

}
