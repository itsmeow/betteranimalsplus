package dev.itsmeow.betteranimalsplus.client.model.abstracts;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public abstract class ModelBAP<T extends Entity> extends EntityModel<T> {

    private boolean limbInit = false;
    private float lArmInit = 0F;
    private float rArmInit = 0F;
    private float rLegInit = 0F;
    private float lLegInit = 0F;

    private boolean bipedInit = false;
    private float rLegBInit = 0F;
    private float lLegBInit = 0F;

    private boolean head_pInit = false;
    private float headPitchInit = 0F;

    private boolean head_yInit = false;
    private float headYawInit = 0F;

    private boolean flapInit = false;
    private float flapLeftInit = 0F;
    private float flapRightInit = 0F;

    public static float pi() {
        return (float) Math.PI;
    }

    public static float rad(float deg) {
        return (float) Math.toRadians(deg);
    }

    public void quadriped(ModelPart lLeg, ModelPart lArm, ModelPart rLeg, ModelPart rArm, float limbSwing, float limbSwingAmount) {
        if(!limbInit) {
            limbInit = true;
            lArmInit = lArm.xRot;
            rArmInit = rArm.xRot;
            lLegInit = lLeg.xRot;
            rLegInit = rLeg.xRot;
        }
        lArm.xRot = Mth.cos(limbSwing) * limbSwingAmount + lArmInit;
        rArm.xRot = Mth.cos(limbSwing + pi()) * limbSwingAmount + rArmInit;
        rLeg.xRot = Mth.cos(limbSwing) * limbSwingAmount + rLegInit;
        lLeg.xRot = Mth.cos(limbSwing + pi()) * limbSwingAmount + lLegInit;
    }

    public void biped(ModelPart lLeg, ModelPart rLeg, float limbSwing, float limbSwingAmount) {
        if(!bipedInit) {
            bipedInit = true;
            lLegBInit = lLeg.xRot;
            rLegBInit = rLeg.xRot;
        }
        rLeg.xRot = Mth.cos(limbSwing) * limbSwingAmount + rLegInit;
        lLeg.xRot = Mth.cos(limbSwing + pi()) * limbSwingAmount + lLegInit;
    }

    public void flap(ModelPart left, ModelPart right, float ageInTicks, float amplitude, boolean inverse) {
        if(!flapInit) {
            flapInit = true;
            flapLeftInit = left.xRot;
            flapRightInit = right.xRot;
        }
        left.xRot = Mth.sin(ageInTicks) * amplitude + lArmInit;
        right.xRot = (inverse ? -1 : 1) * Mth.sin(ageInTicks) * amplitude + rArmInit;
    }

    public void headPitch(ModelPart head, float headPitch, float amplitude, float offset) {
        if(!head_pInit) {
            head_pInit = true;
            headPitchInit = head.xRot;
        }
        head.xRot = rad(headPitch) * amplitude + offset + headPitchInit;
    }

    public void headPitch(ModelPart head, float headPitch) {
        headPitch(head, headPitch, 1F, 0F);
    }

    public void headYaw(ModelPart head, float netHeadYaw, float amplitude, float offset) {
        if(!head_yInit) {
            head_yInit = true;
            headYawInit = head.yRot;
        }
        head.yRot = rad(netHeadYaw) * amplitude + offset + headYawInit;
    }

    public void headYaw(ModelPart head, float netHeadYaw) {
        headYaw(head, netHeadYaw, 1F, 0F);
    }

    public float wiggle(float ageInTicks) {
        return wiggle(ageInTicks, 1F, 1F);
    }

    public float wiggle(float ageInTicks, float mul, float amp) {
        return Mth.cos(ageInTicks * 0.09F * mul) * 0.05F * amp;
    }

    public float wiggleAlt(float ageInTicks) {
        return wiggleAlt(ageInTicks, 1F, 1F);
    }

    public float wiggleAlt(float ageInTicks, float mul, float amp) {
        return Mth.sin(ageInTicks * 0.09F * mul) * 0.05F * amp;
    }

    public void setRotateAngle(ModelPart modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }

    public void setRotationAngle(ModelPart modelRenderer, float x, float y, float z) {
        setRotateAngle(modelRenderer, x, y, z);
    }

    public void setRotateAngleDeg(ModelPart modelRenderer, float x, float y, float z) {
        setRotateAngle(modelRenderer, rad(x), rad(y), rad(z));
    }

    public void setRotationAngleDeg(ModelPart modelRenderer, float x, float y, float z) {
        setRotateAngleDeg(modelRenderer, x, y, z);
    }
}