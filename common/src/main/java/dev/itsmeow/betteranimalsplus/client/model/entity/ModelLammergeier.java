package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import dev.itsmeow.betteranimalsplus.common.entity.EntityLammergeier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;

public class ModelLammergeier<T extends EntityLammergeier> extends ModelBAP<T> {

    public ModelPart body;
    public ModelPart chest;
    public ModelPart neck;
    public ModelPart head;
    public ModelPart upperBeak;
    public ModelPart muzzle;
    public ModelPart lowerBeak;
    public ModelPart beard;
    public ModelPart headFeathers;
    public ModelPart neckFeather02;
    public ModelPart tail01;
    public ModelPart tail02;
    public ModelPart lTailFeather01;
    public ModelPart lTailFeather02;
    public ModelPart lTailFeather03;
    public ModelPart lTailFeather04;
    public ModelPart rTailFeather01;
    public ModelPart rTailFeather02;
    public ModelPart rTailFeather03;
    public ModelPart rTailFeather04;
    public ModelPart lLeg01;
    public ModelPart lLeg02;
    public ModelPart lFoot;
    public ModelPart lToe01;
    public ModelPart lToe02;
    public ModelPart lToe03;
    public ModelPart lToe04;
    public ModelPart lLegFeathers;
    public ModelPart rLeg01;
    public ModelPart rLeg02;
    public ModelPart rFoot;
    public ModelPart rToe01;
    public ModelPart rToe02;
    public ModelPart rToe03;
    public ModelPart rToe04;
    public ModelPart rLegFeathers;
    public ModelPart lWing01;
    public ModelPart lWing02;
    public ModelPart rWing01;
    public ModelPart rWing02;
    private boolean lastFlying = false;

    public ModelLammergeier() {
        texWidth = 64;
        texHeight = 32;

        body = new ModelPart(this);
        body.setPos(0.0F, 15.8F, -0.5F);
        setRotationAngle(body, -0.2276F, 0.0F, 0.0F);
        body.texOffs(0, 0).addBox(-3.0F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, 0.0F, false);

        chest = new ModelPart(this);
        chest.setPos(0.0F, 0.5F, -2.3F);
        body.addChild(chest);
        setRotationAngle(chest, -0.3643F, 0.0F, 0.0F);
        chest.texOffs(48, 0).addBox(-2.5F, -2.0F, -3.0F, 5.0F, 4.0F, 3.0F, 0.0F, false);

        neck = new ModelPart(this);
        neck.setPos(0.0F, 0.4F, -1.3F);
        chest.addChild(neck);
        setRotationAngle(neck, -0.3643F, 0.0F, 0.0F);
        neck.texOffs(36, 0).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 2.0F, 0.0F, false);

        head = new ModelPart(this);
        head.setPos(0.0F, 0.3F, -3.1F);
        neck.addChild(head);
        setRotationAngle(head, -0.3643F, 0.0F, 0.0F);
        head.texOffs(20, 0).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 4.0F, -0.2F, false);

        upperBeak = new ModelPart(this);
        upperBeak.setPos(0.0F, 1.8F, -1.1F);
        head.addChild(upperBeak);
        upperBeak.texOffs(36, 8).addBox(-1.0F, 0.0F, -0.2F, 2.0F, 3.0F, 1.0F, 0.0F, false);
        upperBeak.texOffs(50, 7).addBox(-0.5F, 2.5F, -0.25F, 1.0F, 1.0F, 2.0F, -0.1F, false);

        muzzle = new ModelPart(this);
        muzzle.setPos(0.0F, -0.1F, -0.7F);
        upperBeak.addChild(muzzle);
        setRotationAngle(muzzle, 0.3054F, 0.0F, 0.0F);
        muzzle.texOffs(29, 8).addBox(-1.0F, 0.0F, -0.5F, 2.0F, 3.0F, 1.0F, -0.1F, false);

        lowerBeak = new ModelPart(this);
        lowerBeak.setPos(0.0F, 1.5F, -0.8F);
        head.addChild(lowerBeak);
        lowerBeak.texOffs(43, 8).addBox(-1.0F, 0.1F, 0.25F, 2.0F, 3.0F, 1.0F, -0.1F, false);

        beard = new ModelPart(this);
        beard.setPos(0.0F, 1.5F, 0.75F);
        lowerBeak.addChild(beard);
        setRotationAngle(beard, -0.1309F, 0.0F, 0.0F);
        beard.texOffs(0, 0).addBox(0.0F, -1.95F, 0.0F, 0.0F, 3.0F, 3.0F, 0.0F, false);

        headFeathers = new ModelPart(this);
        headFeathers.setPos(0.0F, -1.05F, -1.05F);
        head.addChild(headFeathers);
        setRotationAngle(headFeathers, 0.48F, 0.0F, 0.0F);
        headFeathers.texOffs(16, 13).addBox(-1.5F, -2.25F, -1.2F, 3.0F, 2.0F, 4.0F, -0.1F, false);

        neckFeather02 = new ModelPart(this);
        neckFeather02.setPos(0.0F, 1.3F, -2.4F);
        chest.addChild(neckFeather02);
        setRotationAngle(neckFeather02, -0.5918F, 0.0F, 0.0F);
        neckFeather02.texOffs(48, 52).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 3.0F, 0.0F, false);

        tail01 = new ModelPart(this);
        tail01.setPos(0.0F, -1.25F, 2.8F);
        body.addChild(tail01);
        tail01.texOffs(0, 13).addBox(-2.5F, -1.0F, 0.4F, 5.0F, 2.0F, 6.0F, 0.0F, false);

        tail02 = new ModelPart(this);
        tail02.setPos(0.0F, 1.4F, 0.0F);
        tail01.addChild(tail02);
        setRotationAngle(tail02, 0.1745F, 0.0F, 0.0F);
        tail02.texOffs(0, 24).addBox(-2.0F, -1.0F, 0.65F, 4.0F, 3.0F, 5.0F, 0.0F, false);

        lTailFeather01 = new ModelPart(this);
        lTailFeather01.setPos(1.2F, -0.15F, 2.9F);
        tail01.addChild(lTailFeather01);
        setRotationAngle(lTailFeather01, -0.0911F, 0.4554F, 0.0F);
        lTailFeather01.texOffs(15, 24).addBox(-1.0F, -0.1F, 0.4F, 2.0F, 0.0F, 8.0F, 0.0F, true);

        lTailFeather02 = new ModelPart(this);
        lTailFeather02.setPos(1.2F, 2.05F, 3.8F);
        tail01.addChild(lTailFeather02);
        setRotationAngle(lTailFeather02, -0.0911F, 0.3187F, 0.0F);
        lTailFeather02.texOffs(15, 24).addBox(-1.0F, -2.2F, 0.4F, 2.0F, 0.0F, 8.0F, 0.0F, true);

        lTailFeather03 = new ModelPart(this);
        lTailFeather03.setPos(0.2F, 2.0F, 4.5F);
        tail01.addChild(lTailFeather03);
        setRotationAngle(lTailFeather03, -0.0911F, 0.2731F, 0.0F);
        lTailFeather03.texOffs(15, 24).addBox(-1.0F, -2.05F, 0.4F, 2.0F, 0.0F, 8.0F, 0.0F, true);

        lTailFeather04 = new ModelPart(this);
        lTailFeather04.setPos(0.0F, 1.95F, 5.2F);
        tail01.addChild(lTailFeather04);
        setRotationAngle(lTailFeather04, -0.0911F, 0.0911F, 0.0F);
        lTailFeather04.texOffs(15, 24).addBox(-1.0F, -1.9F, 0.4F, 2.0F, 0.0F, 8.0F, 0.0F, true);

        rTailFeather01 = new ModelPart(this);
        rTailFeather01.setPos(-1.2F, 2.1F, 2.9F);
        tail01.addChild(rTailFeather01);
        setRotationAngle(rTailFeather01, -0.0911F, -0.4554F, 0.0F);
        rTailFeather01.texOffs(15, 24).addBox(-1.0F, -2.35F, 0.4F, 2.0F, 0.0F, 8.0F, 0.0F, false);

        rTailFeather02 = new ModelPart(this);
        rTailFeather02.setPos(-1.2F, 2.05F, 3.8F);
        tail01.addChild(rTailFeather02);
        setRotationAngle(rTailFeather02, -0.0911F, -0.3187F, 0.0F);
        rTailFeather02.texOffs(15, 24).addBox(-1.0F, -2.2F, 0.4F, 2.0F, 0.0F, 8.0F, 0.0F, false);

        rTailFeather03 = new ModelPart(this);
        rTailFeather03.setPos(-0.2F, 2.0F, 4.5F);
        tail01.addChild(rTailFeather03);
        setRotationAngle(rTailFeather03, -0.0911F, -0.2731F, 0.0F);
        rTailFeather03.texOffs(15, 24).addBox(-1.0F, -2.05F, 0.4F, 2.0F, 0.0F, 8.0F, 0.0F, false);

        rTailFeather04 = new ModelPart(this);
        rTailFeather04.setPos(0.0F, 1.95F, 5.2F);
        tail01.addChild(rTailFeather04);
        setRotationAngle(rTailFeather04, -0.0911F, -0.0911F, 0.0F);
        rTailFeather04.texOffs(15, 24).addBox(-1.0F, -1.9F, 0.4F, 2.0F, 0.0F, 8.0F, 0.0F, false);

        lLeg01 = new ModelPart(this);
        lLeg01.setPos(0.5F, 0.6F, 2.2F);
        body.addChild(lLeg01);
        setRotationAngle(lLeg01, 0.1367F, 0.0F, 0.0F);
        lLeg01.texOffs(30, 13).addBox(0.0F, -0.5F, -1.5F, 3.0F, 5.0F, 3.0F, 0.0F, false);

        lLeg02 = new ModelPart(this);
        lLeg02.setPos(1.5F, 4.3F, 0.1F);
        lLeg01.addChild(lLeg02);
        setRotationAngle(lLeg02, -0.0911F, 0.0F, 0.0F);
        lLeg02.texOffs(40, 19).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

        lFoot = new ModelPart(this);
        lFoot.setPos(0.0F, 1.8F, 0.0F);
        lLeg02.addChild(lFoot);
        setRotationAngle(lFoot, 0.1367F, 0.0F, 0.0F);
        lFoot.texOffs(22, 19).addBox(-0.99F, 0.0F, -1.5F, 2.0F, 1.0F, 3.0F, 0.0F, false);

        lToe01 = new ModelPart(this);
        lToe01.setPos(0.5F, 0.1F, -1.2F);
        lFoot.addChild(lToe01);
        setRotationAngle(lToe01, 0.1367F, -0.3643F, 0.0F);
        lToe01.texOffs(0, 13).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        lToe02 = new ModelPart(this);
        lToe02.setPos(0.0F, 0.0F, -1.3F);
        lFoot.addChild(lToe02);
        setRotationAngle(lToe02, 0.1367F, 0.0F, 0.0F);
        lToe02.texOffs(0, 13).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        lToe03 = new ModelPart(this);
        lToe03.setPos(-0.6F, 0.1F, -1.2F);
        lFoot.addChild(lToe03);
        setRotationAngle(lToe03, 0.1367F, 0.3643F, 0.0F);
        lToe03.texOffs(0, 13).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        lToe04 = new ModelPart(this);
        lToe04.setPos(0.0F, 0.0F, 1.3F);
        lFoot.addChild(lToe04);
        setRotationAngle(lToe04, -0.1367F, 0.0F, 0.0F);
        lToe04.texOffs(0, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        lLegFeathers = new ModelPart(this);
        lLegFeathers.setPos(0.5F, 1.9F, -0.1F);
        lLeg01.addChild(lLegFeathers);
        setRotationAngle(lLegFeathers, 0.182F, 0.2731F, 0.0F);
        lLegFeathers.texOffs(42, 12).addBox(0.0F, 0.45F, -0.1F, 1.0F, 4.0F, 2.0F, 0.0F, false);

        rLeg01 = new ModelPart(this);
        rLeg01.setPos(-0.5F, 0.6F, 2.2F);
        body.addChild(rLeg01);
        setRotationAngle(rLeg01, 0.1367F, 0.0F, 0.0F);
        rLeg01.texOffs(30, 13).addBox(-3.0F, -0.5F, -1.5F, 3.0F, 5.0F, 3.0F, 0.0F, true);

        rLeg02 = new ModelPart(this);
        rLeg02.setPos(-1.5F, 4.3F, 0.1F);
        rLeg01.addChild(rLeg02);
        setRotationAngle(rLeg02, -0.0911F, 0.0F, 0.0F);
        rLeg02.texOffs(40, 19).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, true);

        rFoot = new ModelPart(this);
        rFoot.setPos(0.0F, 1.8F, 0.0F);
        rLeg02.addChild(rFoot);
        setRotationAngle(rFoot, 0.1367F, 0.0F, 0.0F);
        rFoot.texOffs(22, 19).addBox(-1.01F, 0.0F, -1.5F, 2.0F, 1.0F, 3.0F, 0.0F, true);

        rToe01 = new ModelPart(this);
        rToe01.setPos(-0.5F, 0.1F, -1.2F);
        rFoot.addChild(rToe01);
        setRotationAngle(rToe01, 0.1367F, 0.3643F, 0.0F);
        rToe01.texOffs(0, 13).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, true);

        rToe02 = new ModelPart(this);
        rToe02.setPos(0.0F, 0.0F, -1.3F);
        rFoot.addChild(rToe02);
        setRotationAngle(rToe02, 0.1367F, 0.0F, 0.0F);
        rToe02.texOffs(0, 13).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, true);

        rToe03 = new ModelPart(this);
        rToe03.setPos(0.6F, 0.1F, -1.2F);
        rFoot.addChild(rToe03);
        setRotationAngle(rToe03, 0.1367F, -0.3643F, 0.0F);
        rToe03.texOffs(0, 13).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, true);

        rToe04 = new ModelPart(this);
        rToe04.setPos(0.0F, 0.0F, 1.3F);
        rFoot.addChild(rToe04);
        setRotationAngle(rToe04, -0.1367F, 0.0F, 0.0F);
        rToe04.texOffs(0, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, true);

        rLegFeathers = new ModelPart(this);
        rLegFeathers.setPos(-0.5F, 1.9F, -0.1F);
        rLeg01.addChild(rLegFeathers);
        setRotationAngle(rLegFeathers, 0.182F, -0.2731F, 0.0F);
        rLegFeathers.texOffs(42, 12).addBox(-1.0F, 0.45F, -0.1F, 1.0F, 4.0F, 2.0F, 0.0F, true);

        lWing01 = new ModelPart(this);
        lWing01.setPos(2.75F, -1.7F, -1.7F);
        body.addChild(lWing01);
        setRotationAngle(lWing01, -0.0436F, -1.3526F, 0.0F);
        lWing01.texOffs(46, 10).addBox(0.0F, -0.5F, -1.5F, 6.0F, 1.0F, 3.0F, 0.0F, true);
        lWing01.texOffs(39, 14).addBox(-1.0F, 0.0F, -1.0F, 8.0F, 0.0F, 9.0F, 0.0F, false);

        lWing02 = new ModelPart(this);
        lWing02.setPos(5.45F, 0.0F, -0.5F);
        lWing01.addChild(lWing02);
        setRotationAngle(lWing02, 0.0F, -0.6109F, 0.0F);
        lWing02.texOffs(0, 21).addBox(-1.0F, -0.5F, -1.0F, 9.0F, 1.0F, 2.0F, -0.01F, true);
        lWing02.texOffs(21, 23).addBox(-2.0F, -0.1F, -1.0F, 17.0F, 0.0F, 9.0F, 0.0F, false);

        rWing01 = new ModelPart(this);
        rWing01.setPos(-2.75F, -1.7F, -1.7F);
        body.addChild(rWing01);
        setRotationAngle(rWing01, -0.0436F, 1.3526F, 0.0F);
        rWing01.texOffs(46, 10).addBox(-6.0F, -0.5F, -1.5F, 6.0F, 1.0F, 3.0F, 0.0F, false);
        rWing01.texOffs(39, 14).addBox(-7.0F, 0.0F, -1.0F, 8.0F, 0.0F, 9.0F, 0.0F, true);

        rWing02 = new ModelPart(this);
        rWing02.setPos(-5.45F, 0.0F, -0.5F);
        rWing01.addChild(rWing02);
        setRotationAngle(rWing02, 0.0F, 0.6109F, 0.0F);
        rWing02.texOffs(0, 21).addBox(-8.0F, -0.5F, -1.0F, 9.0F, 1.0F, 2.0F, -0.01F, false);
        rWing02.texOffs(21, 23).addBox(-15.0F, -0.1F, -1.0F, 17.0F, 0.0F, 9.0F, 0.0F, true);
    }

    public void switchToFlight() {
        setRotationAngle(lWing01, 0F, 0F, 0F);
        setRotationAngle(lWing02, 0F, 0F, 0F);
        setRotationAngle(rWing01, 0F, 0F, 0F);
        setRotationAngle(rWing02, 0F, 0F, 0F);
        setRotationAngleDeg(lLeg01, 95F, 0F, 0F);
        setRotationAngleDeg(rLeg01, 95F, 0F, 0F);
    }

    public void switchToWalk() {
        setRotationAngle(lWing01, -0.0436F, -1.3526F, 0.0F);
        setRotationAngle(lWing02, 0.0F, -0.6109F, 0.0F);
        setRotationAngle(rWing01, -0.0436F, 1.3526F, 0.0F);
        setRotationAngle(rWing02, 0.0F, 0.6109F, 0.0F);
        setRotationAngle(lLeg01, 0.1367F, 0.0F, 0.0F);
        setRotationAngle(rLeg01, 0.1367F, 0.0F, 0.0F);
        setRotationAngle(body, -0.2276F, 0.0F, 0.0F);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T lammergeier, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        if (lammergeier.getFlying()) {
            this.rWing01.zRot = Mth.cos(ageInTicks * 0.3F) * (float) Math.PI * 0.25F;

            if ((Math.abs(lammergeier.getDeltaMovement().y()) > 0 && (Math.abs(lammergeier.getDeltaMovement().x()) > 0.05 || Math.abs(lammergeier.getDeltaMovement().z()) > 0.05)) || Math.abs(lammergeier.getDeltaMovement().y()) > 0.25) {
                if (Math.abs(lammergeier.getDeltaMovement().y() + lammergeier.lastMotionY) > 0.05 && lammergeier.getDeltaMovement().y() < 0) {
                    this.rWing01.zRot = Mth.cos(225 * 0.3F) * (float) Math.PI * 0.25F;
                }
            }
            this.body.xRot = (float) Mth.clampedLerp(lammergeier.lastRotX, lammergeier.rotX, Minecraft.getInstance().getFrameTime());
            this.lWing01.zRot = -this.rWing01.zRot;
            this.rWing02.zRot = this.rWing01.zRot * 0.5F;
            this.lWing02.zRot = -this.rWing01.zRot * 0.5F;
            if (!this.lastFlying) {
                this.switchToFlight();
            }
            this.lastFlying = true;
        } else {
            if (this.lastFlying) {
                this.switchToWalk();
            }
            this.body.xRot = 0F;
            boolean flag = lammergeier.getFallFlyingTicks() > 4;
            float f = 1.0F;

            if (flag) {
                f = (float) (lammergeier.getDeltaMovement().x() * lammergeier.getDeltaMovement().x() + lammergeier.getDeltaMovement().y() * lammergeier.getDeltaMovement().y() + lammergeier.getDeltaMovement().z() * lammergeier.getDeltaMovement().z());
                f = f / 0.2F;
                f = f * f * f;
            }

            if (f < 1.0F) {
                f = 1.0F;
            }

            this.rLeg01.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
            this.lLeg01.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount / f;
            this.lastFlying = false;
        }

        if (lammergeier.isInSittingPose()) {
            this.head.xRot = 0.15F;
        } else {
            this.head.xRot = -0.3643F;
        }
    }

}
