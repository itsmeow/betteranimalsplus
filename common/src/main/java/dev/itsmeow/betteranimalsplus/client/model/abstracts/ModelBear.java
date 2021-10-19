package dev.itsmeow.betteranimalsplus.client.model.abstracts;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.common.entity.EntityBear;
import net.minecraft.client.model.geom.ModelPart;

public abstract class ModelBear<T extends EntityBear> extends ModelBAP<T> {

    protected ModelPart chest;
    protected ModelPart neck;
    protected ModelPart head;
    protected ModelPart nose_r1;
    protected ModelPart lowerJaw;
    protected ModelPart snout;
    protected ModelPart upperTeeth;
    protected ModelPart ass;
    protected ModelPart lArm01;
    protected ModelPart lArm02;
    protected ModelPart lPaw;
    protected ModelPart lFClaw04_r1;
    protected ModelPart lFClaw03_r1;
    protected ModelPart lFClaw02_r1;
    protected ModelPart rArm01;
    protected ModelPart rArm02;
    protected ModelPart rPaw;
    protected ModelPart rFClaw04_r1;
    protected ModelPart rFClaw03_r1;
    protected ModelPart rFClaw02_r1;
    protected ModelPart lLeg01;
    protected ModelPart lLeg02;
    protected ModelPart lFoot;
    protected ModelPart lHClaw04_r1;
    protected ModelPart lHClaw03_r1;
    protected ModelPart lHClaw02_r1;
    protected ModelPart rLeg01;
    protected ModelPart rLeg02;
    protected ModelPart rFoot;
    protected ModelPart rHClaw04_r1;
    protected ModelPart rHClaw03_r1;
    protected ModelPart rHClaw02_r1;
    private boolean chestInit = false;
    private float chestYInit = 0F;

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.chest.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.lLeg01.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        this.rLeg01.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        if(!chestInit) {
            chestInit = true;
            chestYInit = chest.y;
        }
        this.quadriped(lLeg01, lArm01, rLeg01, rArm01, limbSwing * 0.666F, limbSwingAmount);
        this.headPitch(neck, headPitch);
        this.headYaw(neck, netHeadYaw);

        if (entityIn.getStandingAnimationScale(ageInTicks - (float) entityIn.tickCount) != 0) {
            standingAnim(ageInTicks);
        } else {
            resetStandingAnim();
        }
    }

    public void standingAnim(float ageInTicks) {
        final float off = pi() * 0.333F;
        this.chest.xRot = -off;
        this.chest.y = chestYInit - 2F;
        this.lLeg01.xRot = 0F;
        this.rLeg01.xRot = 0F;
        this.flap(lArm01, rArm01, ageInTicks * 0.5F, 0.9F, true);
        this.neck.xRot += off;
        this.upperTeeth.visible = true;
        this.lowerJaw.xRot = rad(45F);
    }

    public void resetStandingAnim() {
        this.chest.xRot = 0F;
        this.chest.y = chestYInit;
        this.upperTeeth.visible = false;
        this.lowerJaw.xRot = 0F;
    }
}
