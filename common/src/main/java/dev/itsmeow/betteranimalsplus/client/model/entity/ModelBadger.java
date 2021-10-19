package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;

public class ModelBadger<T extends LivingEntity> extends ModelBAP<T> {

    private final ModelPart lowerBack;
    private final ModelPart front;
    private final ModelPart neck;
    private final ModelPart head;
    private final ModelPart topjaw;
    private final ModelPart snout;
    private final ModelPart lowerjaw;
    private final ModelPart lEar;
    private final ModelPart rEar;
    private final ModelPart lArm01;
    private final ModelPart lArm02;
    private final ModelPart lForepaw;
    private final ModelPart lClaw01;
    private final ModelPart lClaw02;
    private final ModelPart lClaw03;
    private final ModelPart lClaw04;
    private final ModelPart rArm01;
    private final ModelPart rArm02;
    private final ModelPart rForepaw;
    private final ModelPart rClaw01;
    private final ModelPart rClaw02;
    private final ModelPart rClaw03;
    private final ModelPart rClaw04;
    private final ModelPart lLeg01;
    private final ModelPart lLeg02;
    private final ModelPart lLeg03;
    private final ModelPart lFoot;
    private final ModelPart lHindClaw01;
    private final ModelPart lHindClaw02;
    private final ModelPart lHindClaw03;
    private final ModelPart lHindClaw04;
    private final ModelPart rLeg01;
    private final ModelPart rLeg02;
    private final ModelPart rLeg03;
    private final ModelPart rFoot;
    private final ModelPart rHindClaw01;
    private final ModelPart rHindClaw02;
    private final ModelPart rHindClaw03;
    private final ModelPart rHindClaw04;
    private final ModelPart tail;
    private final ModelPart tail2;
    private final ModelPart tailfloof;

    public ModelBadger() {
        texWidth = 64;
        texHeight = 64;

        lowerBack = new ModelPart(this);
        lowerBack.setPos(0.0F, 15.5F, -1.0F);
        this.setRotateAngle(lowerBack, -0.0456F, 0.0F, 0.0F);
        lowerBack.texOffs(0, 15).addBox(-4.5F, -4.7F, 0.0F, 9.0F, 8.0F, 10.0F, 0.0F, false);

        front = new ModelPart(this);
        front.setPos(0.0F, -0.5F, 3.4F);
        lowerBack.addChild(front);
        this.setRotateAngle(front, 0.0911F, 0.0F, 0.0F);
        front.texOffs(0, 0).addBox(-4.0F, -4.0F, -10.0F, 8.0F, 7.0F, 7.0F, 0.0F, false);

        neck = new ModelPart(this);
        neck.setPos(0.0F, -0.7F, -9.0F);
        front.addChild(neck);
        this.setRotateAngle(neck, -0.182F, 0.0F, 0.0F);
        neck.texOffs(0, 34).addBox(-3.0F, -3.0F, -4.0F, 6.0F, 6.0F, 4.0F, 0.1F, false);

        head = new ModelPart(this);
        head.setPos(0.0F, -0.2F, -3.15F);
        neck.addChild(head);
        this.setRotateAngle(head, 0.3187F, 0.0F, 0.0F);
        head.texOffs(0, 45).addBox(-3.0F, -3.0F, -5.5F, 6.0F, 5.0F, 6.0F, 0.0F, false);

        topjaw = new ModelPart(this);
        topjaw.setPos(0.0F, -1.1F, -4.45F);
        head.addChild(topjaw);
        topjaw.texOffs(24, 49).addBox(-2.0F, 0.0F, -4.5F, 4.0F, 2.0F, 4.0F, 0.0F, false);

        snout = new ModelPart(this);
        snout.setPos(0.0F, 0.0F, -4.6F);
        topjaw.addChild(snout);
        this.setRotateAngle(snout, 0.2276F, 0.0F, 0.0F);
        snout.texOffs(23, 41).addBox(-1.5F, 0.0F, -0.5F, 3.0F, 2.0F, 6.0F, 0.0F, false);

        lowerjaw = new ModelPart(this);
        lowerjaw.setPos(0.0F, 1.4F, -5.3F);
        head.addChild(lowerjaw);
        this.setRotateAngle(lowerjaw, -0.1367F, 0.0F, 0.0F);
        lowerjaw.texOffs(26, 56).addBox(-1.5F, -0.5F, -3.5F, 3.0F, 1.0F, 4.0F, 0.1F, false);

        lEar = new ModelPart(this);
        lEar.setPos(2.3F, -1.65F, -1.25F);
        head.addChild(lEar);
        this.setRotateAngle(lEar, -0.7854F, 0.7418F, 0.2793F);
        lEar.texOffs(0, 59).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

        rEar = new ModelPart(this);
        rEar.setPos(-2.3F, -1.65F, -1.25F);
        head.addChild(rEar);
        this.setRotateAngle(rEar, -0.7854F, -0.7418F, -0.2793F);
        rEar.texOffs(0, 59).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, true);

        lArm01 = new ModelPart(this);
        lArm01.setPos(3.3F, 0.6F, -7.5F);
        front.addChild(lArm01);
        this.setRotateAngle(lArm01, 0.2276F, 0.0F, 0.0F);
        lArm01.texOffs(33, 0).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 5.0F, 3.0F, 0.0F, false);

        lArm02 = new ModelPart(this);
        lArm02.setPos(0.0F, 3.5F, 0.25F);
        lArm01.addChild(lArm02);
        this.setRotateAngle(lArm02, -0.3643F, 0.0F, 0.0F);
        lArm02.texOffs(35, 8).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        lForepaw = new ModelPart(this);
        lForepaw.setPos(0.0F, 3.8F, 0.0F);
        lArm02.addChild(lForepaw);
        this.setRotateAngle(lForepaw, 0.0911F, 0.0F, 0.0F);
        lForepaw.texOffs(37, 15).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 1.0F, 3.0F, 0.1F, false);

        lClaw01 = new ModelPart(this);
        lClaw01.setPos(0.9F, 0.5F, -1.2F);
        lForepaw.addChild(lClaw01);
        this.setRotateAngle(lClaw01, 0.182F, 0.0873F, 0.0F);
        lClaw01.texOffs(37, 18).addBox(0.0F, -0.5F, -2.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);

        lClaw02 = new ModelPart(this);
        lClaw02.setPos(-0.9F, 0.5F, -1.2F);
        lForepaw.addChild(lClaw02);
        this.setRotateAngle(lClaw02, 0.182F, -0.0873F, 0.0F);
        lClaw02.texOffs(37, 18).addBox(0.0F, -0.5F, -2.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);

        lClaw03 = new ModelPart(this);
        lClaw03.setPos(-0.25F, 0.5F, -1.7F);
        lForepaw.addChild(lClaw03);
        this.setRotateAngle(lClaw03, 0.182F, 0.0F, 0.0F);
        lClaw03.texOffs(37, 18).addBox(0.0F, -0.5F, -2.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);

        lClaw04 = new ModelPart(this);
        lClaw04.setPos(0.25F, 0.5F, -1.7F);
        lForepaw.addChild(lClaw04);
        this.setRotateAngle(lClaw04, 0.182F, 0.0F, 0.0F);
        lClaw04.texOffs(37, 18).addBox(0.0F, -0.5F, -2.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);

        rArm01 = new ModelPart(this);
        rArm01.setPos(-3.3F, 0.6F, -7.5F);
        front.addChild(rArm01);
        this.setRotateAngle(rArm01, 0.2276F, 0.0F, 0.0F);
        rArm01.texOffs(33, 0).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 5.0F, 3.0F, 0.0F, true);

        rArm02 = new ModelPart(this);
        rArm02.setPos(0.0F, 3.5F, 0.25F);
        rArm01.addChild(rArm02);
        this.setRotateAngle(rArm02, -0.3643F, 0.0F, 0.0F);
        rArm02.texOffs(35, 8).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, true);

        rForepaw = new ModelPart(this);
        rForepaw.setPos(0.0F, 3.8F, 0.0F);
        rArm02.addChild(rForepaw);
        this.setRotateAngle(rForepaw, 0.0911F, 0.0F, 0.0F);
        rForepaw.texOffs(37, 15).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 1.0F, 3.0F, 0.1F, true);

        rClaw01 = new ModelPart(this);
        rClaw01.setPos(-0.9F, 0.5F, -1.2F);
        rForepaw.addChild(rClaw01);
        this.setRotateAngle(rClaw01, 0.182F, -0.0873F, 0.0F);
        rClaw01.texOffs(37, 18).addBox(0.0F, -0.5F, -2.0F, 0.0F, 1.0F, 2.0F, 0.0F, true);

        rClaw02 = new ModelPart(this);
        rClaw02.setPos(0.9F, 0.5F, -1.2F);
        rForepaw.addChild(rClaw02);
        this.setRotateAngle(rClaw02, 0.182F, 0.0873F, 0.0F);
        rClaw02.texOffs(37, 18).addBox(0.0F, -0.5F, -2.0F, 0.0F, 1.0F, 2.0F, 0.0F, true);

        rClaw03 = new ModelPart(this);
        rClaw03.setPos(0.25F, 0.5F, -1.7F);
        rForepaw.addChild(rClaw03);
        this.setRotateAngle(rClaw03, 0.182F, 0.0F, 0.0F);
        rClaw03.texOffs(37, 18).addBox(0.0F, -0.5F, -2.0F, 0.0F, 1.0F, 2.0F, 0.0F, true);

        rClaw04 = new ModelPart(this);
        rClaw04.setPos(-0.25F, 0.5F, -1.7F);
        rForepaw.addChild(rClaw04);
        this.setRotateAngle(rClaw04, 0.182F, 0.0F, 0.0F);
        rClaw04.texOffs(37, 18).addBox(0.0F, -0.5F, -2.0F, 0.0F, 1.0F, 2.0F, 0.0F, true);

        lLeg01 = new ModelPart(this);
        lLeg01.setPos(3.5F, -1.2F, 6.0F);
        lowerBack.addChild(lLeg01);
        lLeg01.texOffs(46, 0).addBox(-2.0F, -1.5F, -2.5F, 4.0F, 7.0F, 5.0F, 0.0F, false);

        lLeg02 = new ModelPart(this);
        lLeg02.setPos(0.25F, 4.7F, -0.6F);
        lLeg01.addChild(lLeg02);
        this.setRotateAngle(lLeg02, 0.5843F, 0.0F, 0.0F);
        lLeg02.texOffs(50, 12).addBox(-1.5F, -0.75F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);

        lLeg03 = new ModelPart(this);
        lLeg03.setPos(0.0F, 1.05F, 0.85F);
        lLeg02.addChild(lLeg03);
        this.setRotateAngle(lLeg03, -0.5009F, 0.0F, 0.0F);
        lLeg03.texOffs(52, 19).addBox(-1.0F, 2.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

        lFoot = new ModelPart(this);
        lFoot.setPos(0.0F, 3.3F, 0.0F);
        lLeg03.addChild(lFoot);
        this.setRotateAngle(lFoot, -0.0436F, 0.0F, 0.0F);
        lFoot.texOffs(37, 15).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 1.0F, 3.0F, 0.1F, false);

        lHindClaw01 = new ModelPart(this);
        lHindClaw01.setPos(0.9F, 0.5F, -1.2F);
        lFoot.addChild(lHindClaw01);
        this.setRotateAngle(lHindClaw01, 0.182F, 0.0873F, 0.0F);
        lHindClaw01.texOffs(37, 18).addBox(0.0F, -0.5F, -2.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);

        lHindClaw02 = new ModelPart(this);
        lHindClaw02.setPos(-0.9F, 0.5F, -1.2F);
        lFoot.addChild(lHindClaw02);
        this.setRotateAngle(lHindClaw02, 0.182F, -0.0873F, 0.0F);
        lHindClaw02.texOffs(37, 18).addBox(0.0F, -0.5F, -2.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);

        lHindClaw03 = new ModelPart(this);
        lHindClaw03.setPos(-0.25F, 0.5F, -1.7F);
        lFoot.addChild(lHindClaw03);
        this.setRotateAngle(lHindClaw03, 0.182F, 0.0F, 0.0F);
        lHindClaw03.texOffs(37, 18).addBox(0.0F, -0.5F, -2.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);

        lHindClaw04 = new ModelPart(this);
        lHindClaw04.setPos(0.25F, 0.5F, -1.7F);
        lFoot.addChild(lHindClaw04);
        this.setRotateAngle(lHindClaw04, 0.182F, 0.0F, 0.0F);
        lHindClaw04.texOffs(37, 18).addBox(0.0F, -0.5F, -2.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);

        rLeg01 = new ModelPart(this);
        rLeg01.setPos(-3.5F, -1.2F, 6.0F);
        lowerBack.addChild(rLeg01);
        rLeg01.texOffs(46, 0).addBox(-2.0F, -1.5F, -2.5F, 4.0F, 7.0F, 5.0F, 0.0F, true);

        rLeg02 = new ModelPart(this);
        rLeg02.setPos(-0.25F, 4.7F, -0.6F);
        rLeg01.addChild(rLeg02);
        this.setRotateAngle(rLeg02, 0.5843F, 0.0F, 0.0F);
        rLeg02.texOffs(50, 12).addBox(-1.5F, -0.75F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, true);

        rLeg03 = new ModelPart(this);
        rLeg03.setPos(0.0F, 1.05F, 0.85F);
        rLeg02.addChild(rLeg03);
        this.setRotateAngle(rLeg03, -0.5009F, 0.0F, 0.0F);
        rLeg03.texOffs(52, 19).addBox(-1.0F, 2.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, true);

        rFoot = new ModelPart(this);
        rFoot.setPos(0.0F, 3.3F, 0.0F);
        rLeg03.addChild(rFoot);
        this.setRotateAngle(rFoot, -0.0436F, 0.0F, 0.0F);
        rFoot.texOffs(37, 15).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 1.0F, 3.0F, 0.1F, true);

        rHindClaw01 = new ModelPart(this);
        rHindClaw01.setPos(-0.9F, 0.5F, -1.2F);
        rFoot.addChild(rHindClaw01);
        this.setRotateAngle(rHindClaw01, 0.182F, -0.0873F, 0.0F);
        rHindClaw01.texOffs(37, 18).addBox(0.0F, -0.5F, -2.0F, 0.0F, 1.0F, 2.0F, 0.0F, true);

        rHindClaw02 = new ModelPart(this);
        rHindClaw02.setPos(0.9F, 0.5F, -1.2F);
        rFoot.addChild(rHindClaw02);
        this.setRotateAngle(rHindClaw02, 0.182F, 0.0873F, 0.0F);
        rHindClaw02.texOffs(37, 18).addBox(0.0F, -0.5F, -2.0F, 0.0F, 1.0F, 2.0F, 0.0F, true);

        rHindClaw03 = new ModelPart(this);
        rHindClaw03.setPos(0.25F, 0.5F, -1.7F);
        rFoot.addChild(rHindClaw03);
        this.setRotateAngle(rHindClaw03, 0.182F, 0.0F, 0.0F);
        rHindClaw03.texOffs(37, 18).addBox(0.0F, -0.5F, -2.0F, 0.0F, 1.0F, 2.0F, 0.0F, true);

        rHindClaw04 = new ModelPart(this);
        rHindClaw04.setPos(-0.25F, 0.5F, -1.7F);
        rFoot.addChild(rHindClaw04);
        this.setRotateAngle(rHindClaw04, 0.182F, 0.0F, 0.0F);
        rHindClaw04.texOffs(37, 18).addBox(0.0F, -0.5F, -2.0F, 0.0F, 1.0F, 2.0F, 0.0F, true);

        tail = new ModelPart(this);
        tail.setPos(0.0F, -4.0F, 9.1F);
        lowerBack.addChild(tail);
        this.setRotateAngle(tail, -1.0472F, 0.0F, 0.0F);
        tail.texOffs(40, 26).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 5.0F, -0.1F, false);

        tail2 = new ModelPart(this);
        tail2.setPos(0.0F, 0.0F, 4.55F);
        tail.addChild(tail2);
        this.setRotateAngle(tail2, 0.2276F, 0.0F, 0.0F);
        tail2.texOffs(40, 26).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 5.0F, 0.0F, false);

        tailfloof = new ModelPart(this);
        tailfloof.setPos(0.5F, 1.35F, 0.5F);
        tail2.addChild(tailfloof);
        this.setRotateAngle(tailfloof, 0.2618F, 0.0F, 0.0F);
        tailfloof.texOffs(39, 34).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.lowerBack.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.quadriped(lLeg01, lArm01, rLeg01, rArm01, limbSwing * 0.8665F, limbSwingAmount * 1.5F);
    }

}