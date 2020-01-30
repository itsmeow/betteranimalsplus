package its_meow.betteranimalsplus.client.renderer.entity;

import javax.annotation.Nonnull;

import com.mojang.blaze3d.platform.GlStateManager;

import its_meow.betteranimalsplus.client.model.ModelGoose;
import its_meow.betteranimalsplus.common.entity.EntityGoose;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class RenderGoose extends MobRenderer<EntityGoose, ModelGoose<EntityGoose>> {

    public RenderGoose(EntityRendererManager rendermanagerIn) {
        super(rendermanagerIn, new ModelGoose<EntityGoose>(), 0.5F);
        this.addLayer(new GooseItemLayerRenderer());
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
    
    public class GooseItemLayerRenderer extends LayerRenderer<EntityGoose, ModelGoose<EntityGoose>> {

        public GooseItemLayerRenderer(RenderGoose renderer) {
            super(renderer);
        }

        @Override
        public void render(EntityGoose goose, float p_212842_2_, float p_212842_3_, float p_212842_4_, float p_212842_5_, float p_212842_6_, float p_212842_7_, float p_212842_8_) {
            ItemStack itemstack = goose.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
            if (!itemstack.isEmpty()) {
               boolean flag = goose.isSleeping();
               boolean flag1 = goose.isChild();
               GlStateManager.pushMatrix();
               if (flag1) {
                  float f = 0.75F;
                  GlStateManager.scalef(0.75F, 0.75F, 0.75F);
                  GlStateManager.translatef(0.0F, 8.0F * p_212842_8_, 3.35F * p_212842_8_);
               }

               
               GlStateManager.rotatef(f1, 0.0F, 0.0F, 1.0F);
               GlStateManager.rotatef(p_212842_6_, 0.0F, 1.0F, 0.0F);
               GlStateManager.rotatef(p_212842_7_, 1.0F, 0.0F, 0.0F);
               if (goose.isChild()) {
                  if (flag) {
                     GlStateManager.translatef(0.4F, 0.26F, 0.15F);
                  } else {
                     GlStateManager.translatef(0.06F, 0.26F, -0.5F);
                  }
               } else if (flag) {
                  GlStateManager.translatef(0.46F, 0.26F, 0.22F);
               } else {
                  GlStateManager.translatef(0.06F, 0.27F, -0.5F);
               }

               GlStateManager.rotatef(90.0F, 1.0F, 0.0F, 0.0F);
               if (flag) {
                  GlStateManager.rotatef(90.0F, 0.0F, 0.0F, 1.0F);
               }

               Minecraft.getInstance().getItemRenderer().renderItem(itemstack, goose, ItemCameraTransforms.TransformType.GROUND, false);
               GlStateManager.popMatrix();
            }
         }

        @Override
        public boolean shouldCombineTextures() {
            return false;
        }
        
    }

}
