package its_meow.betteranimalsplus.client.renderer.entity.layers;

import com.mojang.blaze3d.matrix.MatrixStack;

import its_meow.betteranimalsplus.client.model.ModelHirschgeistMain;
import its_meow.betteranimalsplus.common.entity.miniboss.hirschgeist.EntityHirschgeist;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;

public class LayerEctoplasm extends LayerRenderer<EntityHirschgeist, ModelHirschgeistMain<EntityHirschgeist>> {
    
    public static final RenderType GLOW_STATE = RenderType.getEyes(ModTextures.hirschgeist);

    public LayerEctoplasm(IEntityRenderer<EntityHirschgeist, ModelHirschgeistMain<EntityHirschgeist>> renderer) {
        super(renderer);
     }

     public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, EntityHirschgeist entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if(!entity.isDaytime()) {
            this.getEntityModel().renderEctoLayer(matrixStackIn, bufferIn.getBuffer(GLOW_STATE), 0xF00000, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        }
     }

}
