package its_meow.betteranimalsplus.client.renderer.entity.layers;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.ResourceLocation;

public class LayerEyes<T extends MobEntity, A extends EntityModel<T>> extends LayerRenderer<T, A> {

    protected final RenderType GLOW_STATE;

    public LayerEyes(MobRenderer<T, A> baseRenderer, ResourceLocation texture) {
        super(baseRenderer);
        this.GLOW_STATE = RenderType.getEyes(texture);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (!entity.isInvisible() && !entity.isChild()) {
            this.getEntityModel().render(matrixStackIn, bufferIn.getBuffer(GLOW_STATE), 15728640, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        }
    }
}