package dev.itsmeow.betteranimalsplus.client.model.abstracts;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;

public abstract class ModelBAPHead<T extends Entity> extends ModelBAP<T> {

    private final boolean doXRot;
    private boolean init = false;

    public ModelBAPHead(boolean doXRot) {
        this.doXRot = doXRot;
    }

    public abstract ModelPart basePart();

    public void transform(PoseStack stack) {}

    @Override
    public void setupAnim(T entity, float f, float f1, float f2, float f3, float f4) {
        if(!init) {
            basePart().setPos(0.0F, 23.9F, 0.0F);
            init = true;
        }
        basePart().yRot = rad(f);
        if (doXRot) basePart().xRot = rad(f1);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        matrixStackIn.pushPose();
        transform(matrixStackIn);
        basePart().render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        matrixStackIn.popPose();
    }
}
