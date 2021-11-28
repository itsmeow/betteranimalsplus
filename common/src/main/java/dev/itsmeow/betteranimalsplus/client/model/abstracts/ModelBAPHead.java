package dev.itsmeow.betteranimalsplus.client.model.abstracts;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.imdlib.client.render.HeadModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;

public abstract class ModelBAPHead<T extends Entity> extends ModelBAP<T> implements HeadModel {

    private final boolean doXRot;
    private boolean init = false;

    public ModelBAPHead(boolean doXRot) {
        this.doXRot = doXRot;
    }

    public abstract ModelPart basePart();

    @Override
    public void setupAnim(T entity, float f, float f1, float f2, float f3, float f4) {
        if(!init) {
            basePart().setPos(0F,0F,0F);
        }
        basePart().yRot = rad(f);
        if (doXRot) basePart().xRot = rad(f1);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        matrixStackIn.pushPose();
        basePart().render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        matrixStackIn.popPose();
    }
}
