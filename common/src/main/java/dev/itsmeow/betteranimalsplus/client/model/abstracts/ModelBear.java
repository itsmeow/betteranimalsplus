package dev.itsmeow.betteranimalsplus.client.model.abstracts;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.common.entity.EntityBear;
import net.minecraft.client.model.geom.ModelPart;

public abstract class ModelBear<T extends EntityBear> extends ModelBAP<T> {

    public ModelPart chest;
    public ModelPart neck;
    public ModelPart head;
    public ModelPart nose_r1;
    public ModelPart lowerJaw;
    public ModelPart snout;
    public ModelPart upperTeeth;
    public ModelPart ass;
    public ModelPart lArm01;
    public ModelPart lArm02;
    public ModelPart lPaw;
    public ModelPart lFClaw04_r1;
    public ModelPart lFClaw03_r1;
    public ModelPart lFClaw02_r1;
    public ModelPart rArm01;
    public ModelPart rArm02;
    public ModelPart rPaw;
    public ModelPart rFClaw04_r1;
    public ModelPart rFClaw03_r1;
    public ModelPart rFClaw02_r1;
    public ModelPart lLeg01;
    public ModelPart lLeg02;
    public ModelPart lFoot;
    public ModelPart lHClaw04_r1;
    public ModelPart lHClaw03_r1;
    public ModelPart lHClaw02_r1;
    public ModelPart rLeg01;
    public ModelPart rLeg02;
    public ModelPart rFoot;
    public ModelPart rHClaw04_r1;
    public ModelPart rHClaw03_r1;
    public ModelPart rHClaw02_r1;
    private boolean chestInit = false;
    private float chestYInit = 0F;

    public ModelBear(ModelPart root) {
        this.chest = root.getChild("chest");
        this.neck = chest.getChild("neck");
        this.head = neck.getChild("head");
        this.nose_r1 = head.getChild("nose_r1");
        this.lowerJaw = head.getChild("lowerJaw");
        this.snout = head.getChild("snout");
        this.upperTeeth = snout.getChild("upperTeeth");
        this.ass = chest.getChild("ass");
        this.lArm01 = chest.getChild("lArm01");
        this.lArm02 = lArm01.getChild("lArm02");
        this.lPaw = lArm02.getChild("lPaw");
        this.lFClaw04_r1 = lPaw.getChild("lFClaw04_r1");
        this.lFClaw03_r1 = lPaw.getChild("lFClaw03_r1");
        this.lFClaw02_r1 = lPaw.getChild("lFClaw02_r1");
        this.rArm01 = chest.getChild("rArm01");
        this.rArm02 = rArm01.getChild("rArm02");
        this.rPaw = rArm02.getChild("rPaw");
        this.rFClaw04_r1 = rPaw.getChild("rFClaw04_r1");
        this.rFClaw03_r1 = rPaw.getChild("rFClaw03_r1");
        this.rFClaw02_r1 = rPaw.getChild("rFClaw02_r1");
        this.lLeg01 = root.getChild("lLeg01");
        this.lLeg02 = lLeg01.getChild("lLeg02");
        this.lFoot = lLeg02.getChild("lFoot");
        this.lHClaw04_r1 = lFoot.getChild("lHClaw04_r1");
        this.lHClaw03_r1 = lFoot.getChild("lHClaw03_r1");
        this.lHClaw02_r1 = lFoot.getChild("lHClaw02_r1");
        this.rLeg01 = root.getChild("rLeg01");
        this.rLeg02 = rLeg01.getChild("rLeg02");
        this.rFoot = rLeg02.getChild("rFoot");
        this.rHClaw04_r1 = rFoot.getChild("rHClaw04_r1");
        this.rHClaw03_r1 = rFoot.getChild("rHClaw03_r1");
        this.rHClaw02_r1 = rFoot.getChild("rHClaw02_r1");
    }

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
