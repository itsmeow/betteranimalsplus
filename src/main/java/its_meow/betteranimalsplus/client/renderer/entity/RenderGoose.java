package its_meow.betteranimalsplus.client.renderer.entity;

import javax.annotation.Nonnull;

import its_meow.betteranimalsplus.client.model.ModelGoose;
import its_meow.betteranimalsplus.common.entity.EntityGoose;
import its_meow.betteranimalsplus.init.ModTextures;
import its_meow.betteranimalsplus.util.RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class RenderGoose extends RenderLiving<EntityGoose> {

    public RenderGoose(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelGoose(), 0.5F);
        this.addLayer(new GooseItemLayerRenderer(this));
    }
    
    @Override
    protected void preRenderCallback(EntityGoose entitylivingbaseIn, float partialTickTime) {
        if (this.getMainModel().isChild) {
            GlStateManager.scale(0.5D, 0.5D, 0.5D);
        } else {
            GlStateManager.scale(0.8D, 0.8D, 0.8D);
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

    public static class GooseItemLayerRenderer implements LayerRenderer<EntityGoose> {
        
        protected RenderGoose renderer;

        public GooseItemLayerRenderer(RenderGoose renderer) {
            this.renderer = renderer;
        }

        @Override
        public void doRenderLayer(EntityGoose goose, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
            ItemStack itemstack = goose.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND);
            if(!itemstack.isEmpty()) {
                GlStateManager.pushMatrix();
                {
                    RenderUtil.partTranslateRotate(this.getEntityModel().body, this.getEntityModel().neck00, this.getEntityModel().neck01, this.getEntityModel().neck02, this.getEntityModel().neck03, this.getEntityModel().head, this.getEntityModel().billUpper);
                    GlStateManager.translate(0F, 0.15F, 0F);
                    GlStateManager.scale(0.75F, 0.75F, 0.75F);
                    Minecraft.getMinecraft().getItemRenderer().renderItem(goose, itemstack, TransformType.GROUND);
                }
                GlStateManager.popMatrix();
            }
        }
        private ModelGoose getEntityModel() {
            return (ModelGoose) this.renderer.getMainModel();
        }

        @Override
        public boolean shouldCombineTextures() {
            return false;
        }

    }

}
