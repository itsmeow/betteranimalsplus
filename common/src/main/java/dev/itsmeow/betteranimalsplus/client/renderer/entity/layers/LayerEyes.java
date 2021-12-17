package dev.itsmeow.betteranimalsplus.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.itsmeow.betteranimalsplus.client.ClientLifecycleHandler;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;

public class LayerEyes<T extends Mob, A extends EntityModel<T>> extends RenderLayer<T, A> {

    protected RenderType GLOW_STATE;

    public LayerEyes(MobRenderer<T, A> baseRenderer, ResourceLocation texture) {
        super(baseRenderer);
        this.GLOW_STATE = RenderType.eyes(texture);
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, T entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (!entity.isInvisible() && !entity.isBaby()) {
            this.getParentModel().renderToBuffer(matrixStackIn, bufferIn.getBuffer(GLOW_STATE), 15728640, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        }
    }
}