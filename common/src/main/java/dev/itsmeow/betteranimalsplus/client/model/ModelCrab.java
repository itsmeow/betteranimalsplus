package dev.itsmeow.betteranimalsplus.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.common.entity.EntityCrab;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;

/**
 * crab - Batman
 * Created using Tabula 7.0.1
 */
public class ModelCrab<T extends LivingEntity> extends EntityModel<T> {
    public ModelPart body;
    public ModelPart lShell;
    public ModelPart rShell;
    public ModelPart lArm00;
    public ModelPart rArm00;
    public ModelPart lEye;
    public ModelPart rEye;
    public ModelPart rMouth;
    public ModelPart lMouth;
    public ModelPart lLeg00a;
    public ModelPart lLeg01a;
    public ModelPart lLeg02a;
    public ModelPart rLeg00a;
    public ModelPart rLeg01a;
    public ModelPart rLeg02a;
    public ModelPart lLeg03a;
    public ModelPart rLeg03a;
    public ModelPart lClaw00;
    public ModelPart lClaw02;
    public ModelPart lClaw01;
    public ModelPart rClaw00;
    public ModelPart rClaw01;
    public ModelPart rClaw01_1;
    public ModelPart lLeg00b;
    public ModelPart lLeg00c;
    public ModelPart lLeg01b;
    public ModelPart lLeg01c;
    public ModelPart lLeg02b;
    public ModelPart lLeg02c;
    public ModelPart rLeg00b;
    public ModelPart rLeg00c;
    public ModelPart rLeg01b;
    public ModelPart rLeg01c;
    public ModelPart rLeg02b;
    public ModelPart rLeg02c;
    public ModelPart lLeg03b;
    public ModelPart lLeg03c;
    public ModelPart rLeg03b;
    public ModelPart rLeg03c;

    private int crabId = 0;

    public ModelCrab() {
        this.texWidth = 32;
        this.texHeight = 32;
        this.rLeg03a = new ModelPart(this, 0, 20);
        this.rLeg03a.mirror = true;
        this.rLeg03a.setPos(-2.8F, 1.0F, 3.7F);
        this.rLeg03a.addBox(-4.0F, -0.5F, -0.5F, 4, 1, 1, 0.0F);
        this.setRotateAngle(rLeg03a, 0.0F, 0.45378560551852565F, 0.0F);
        this.lClaw01 = new ModelPart(this, 11, 27);
        this.lClaw01.setPos(0.0F, -0.6F, -3.9F);
        this.lClaw01.addBox(-0.5F, -0.5F, -2.5F, 1, 1, 3, 0.0F);
        this.rLeg01a = new ModelPart(this, 0, 20);
        this.rLeg01a.mirror = true;
        this.rLeg01a.setPos(-2.8F, 1.0F, 1.9F);
        this.rLeg01a.addBox(-4.0F, -0.5F, -0.5F, 4, 1, 1, 0.0F);
        this.setRotateAngle(rLeg01a, 0.0F, -0.13962634015954636F, 0.0F);
        this.rLeg00c = new ModelPart(this, 0, 26);
        this.rLeg00c.setPos(-2.9F, 0.0F, 0.0F);
        this.rLeg00c.addBox(-3.0F, -0.5F, 0.0F, 3, 1, 0, 0.0F);
        this.setRotateAngle(rLeg00c, 0.0F, 0.0F, -0.5235987755982988F);
        this.lLeg01b = new ModelPart(this, 0, 23);
        this.lLeg01b.setPos(3.9F, 0.0F, 0.0F);
        this.lLeg01b.addBox(0.0F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(lLeg01b, 0.0F, 0.0F, 0.45378560551852565F);
        this.rLeg02b = new ModelPart(this, 0, 23);
        this.rLeg02b.mirror = true;
        this.rLeg02b.setPos(-3.9F, 0.0F, 0.0F);
        this.rLeg02b.addBox(-3.0F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(rLeg02b, 0.0F, 0.0F, -0.45378560551852565F);
        this.rLeg03c = new ModelPart(this, 0, 26);
        this.rLeg03c.setPos(-2.9F, 0.0F, 0.0F);
        this.rLeg03c.addBox(-3.0F, -0.5F, 0.0F, 3, 1, 0, 0.0F);
        this.setRotateAngle(rLeg03c, 0.0F, 0.0F, -0.5235987755982988F);
        this.rShell = new ModelPart(this, 1, 13);
        this.rShell.mirror = true;
        this.rShell.setPos(-0.6F, -0.6F, 3.7F);
        this.rShell.addBox(-7.0F, -0.5F, -1.5F, 7, 2, 3, 0.0F);
        this.setRotateAngle(rShell, 0.0F, -1.0471975511965976F, 0.0F);
        this.lLeg03a = new ModelPart(this, 0, 20);
        this.lLeg03a.setPos(2.8F, 1.0F, 3.7F);
        this.lLeg03a.addBox(0.0F, -0.5F, -0.5F, 4, 1, 1, 0.0F);
        this.setRotateAngle(lLeg03a, 0.0F, -0.45378560551852565F, 0.0F);
        this.lLeg01a = new ModelPart(this, 0, 20);
        this.lLeg01a.setPos(2.8F, 1.0F, 1.9F);
        this.lLeg01a.addBox(0.0F, -0.5F, -0.5F, 4, 1, 1, 0.0F);
        this.setRotateAngle(lLeg01a, 0.0F, 0.13962634015954636F, 0.0F);
        this.rLeg02c = new ModelPart(this, 0, 26);
        this.rLeg02c.setPos(-2.9F, 0.0F, 0.0F);
        this.rLeg02c.addBox(-3.0F, -0.5F, 0.0F, 3, 1, 0, 0.0F);
        this.setRotateAngle(rLeg02c, 0.0F, 0.0F, -0.5235987755982988F);
        this.lLeg00a = new ModelPart(this, 0, 20);
        this.lLeg00a.setPos(2.8F, 1.0F, 0.8F);
        this.lLeg00a.addBox(0.0F, -0.5F, -0.5F, 4, 1, 1, 0.0F);
        this.setRotateAngle(lLeg00a, 0.0F, 0.3141592653589793F, 0.0F);
        this.rClaw00 = new ModelPart(this, 11, 20);
        this.rClaw00.mirror = true;
        this.rClaw00.setPos(0.0F, 0.1F, -2.8F);
        this.rClaw00.addBox(-1.0F, -1.0F, -4.0F, 2, 2, 4, 0.0F);
        this.setRotateAngle(rClaw00, -0.17453292519943295F, -1.0471975511965976F, 0.0F);
        this.rLeg00b = new ModelPart(this, 0, 23);
        this.rLeg00b.mirror = true;
        this.rLeg00b.setPos(-3.9F, 0.0F, 0.0F);
        this.rLeg00b.addBox(-3.0F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(rLeg00b, 0.0F, 0.0F, -0.45378560551852565F);
        this.lMouth = new ModelPart(this, 0, 4);
        this.lMouth.setPos(0.8F, -0.9F, -3.0F);
        this.lMouth.addBox(-1.0F, 0.0F, -0.5F, 2, 2, 1, 0.0F);
        this.setRotateAngle(lMouth, 0.0F, -0.17453292519943295F, 0.0F);
        this.lLeg03c = new ModelPart(this, 0, 26);
        this.lLeg03c.setPos(2.9F, 0.0F, 0.0F);
        this.lLeg03c.addBox(0.0F, -0.5F, 0.0F, 3, 1, 0, 0.0F);
        this.setRotateAngle(lLeg03c, 0.0F, 0.0F, 0.5235987755982988F);
        this.lLeg02c = new ModelPart(this, 0, 26);
        this.lLeg02c.setPos(2.9F, 0.0F, 0.0F);
        this.lLeg02c.addBox(0.0F, -0.5F, 0.0F, 3, 1, 0, 0.0F);
        this.setRotateAngle(lLeg02c, 0.0F, 0.0F, 0.5235987755982988F);
        this.lEye = new ModelPart(this, 0, 0);
        this.lEye.setPos(1.3F, -1.2F, -2.5F);
        this.lEye.addBox(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(lEye, 0.31869712141416456F, 0.0F, 0.22759093446006054F);
        this.rArm00 = new ModelPart(this, 11, 20);
        this.rArm00.mirror = true;
        this.rArm00.setPos(-2.5F, 0.9F, -1.8F);
        this.rArm00.addBox(-1.0F, -1.0F, -3.0F, 2, 2, 4, 0.0F);
        this.setRotateAngle(rArm00, 0.3490658503988659F, 1.0471975511965976F, 0.0F);
        this.lClaw02 = new ModelPart(this, 20, 27);
        this.lClaw02.setPos(0.0F, 0.7F, -3.9F);
        this.lClaw02.addBox(-0.5F, -0.5F, -2.0F, 1, 1, 2, 0.0F);
        this.lLeg03b = new ModelPart(this, 0, 23);
        this.lLeg03b.setPos(3.9F, 0.0F, 0.0F);
        this.lLeg03b.addBox(0.0F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(lLeg03b, 0.0F, 0.0F, 0.45378560551852565F);
        this.rEye = new ModelPart(this, 0, 0);
        this.rEye.setPos(-1.3F, -1.2F, -2.5F);
        this.rEye.addBox(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(rEye, 0.31869712141416456F, 0.0F, -0.22759093446006054F);
        this.lLeg01c = new ModelPart(this, 0, 26);
        this.lLeg01c.setPos(2.9F, 0.0F, 0.0F);
        this.lLeg01c.addBox(0.0F, -0.5F, 0.0F, 3, 1, 0, 0.0F);
        this.setRotateAngle(lLeg01c, 0.0F, 0.0F, 0.5235987755982988F);
        this.lLeg00c = new ModelPart(this, 0, 26);
        this.lLeg00c.setPos(2.9F, 0.0F, 0.0F);
        this.lLeg00c.addBox(0.0F, -0.5F, 0.0F, 3, 1, 0, 0.0F);
        this.setRotateAngle(lLeg00c, 0.0F, 0.0F, 0.5235987755982988F);
        this.body = new ModelPart(this, 0, 0);
        this.body.setPos(0.0F, 20.0F, 0.0F);
        this.body.addBox(-3.0F, -1.5F, -3.0F, 6, 3, 8, 0.0F);
        this.lArm00 = new ModelPart(this, 11, 20);
        this.lArm00.mirror = true;
        this.lArm00.setPos(2.5F, 0.9F, -1.8F);
        this.lArm00.addBox(-1.0F, -1.0F, -4.0F, 2, 2, 4, 0.0F);
        this.setRotateAngle(lArm00, 0.3490658503988659F, -1.0471975511965976F, 0.0F);
        this.rLeg00a = new ModelPart(this, 0, 20);
        this.rLeg00a.mirror = true;
        this.rLeg00a.setPos(-2.8F, 1.0F, 0.8F);
        this.rLeg00a.addBox(-4.0F, -0.5F, -0.5F, 4, 1, 1, 0.0F);
        this.setRotateAngle(rLeg00a, 0.0F, -0.3141592653589793F, 0.0F);
        this.rLeg01c = new ModelPart(this, 0, 26);
        this.rLeg01c.setPos(-2.9F, 0.0F, 0.0F);
        this.rLeg01c.addBox(-3.0F, -0.5F, 0.0F, 3, 1, 0, 0.0F);
        this.setRotateAngle(rLeg01c, 0.0F, 0.0F, -0.5235987755982988F);
        this.lClaw00 = new ModelPart(this, 11, 20);
        this.lClaw00.setPos(0.0F, 0.1F, -3.8F);
        this.lClaw00.addBox(-1.0F, -1.0F, -4.0F, 2, 2, 4, 0.0F);
        this.setRotateAngle(lClaw00, -0.17453292519943295F, 1.0471975511965976F, 0.0F);
        this.rClaw01 = new ModelPart(this, 11, 27);
        this.rClaw01.setPos(0.0F, -0.6F, -3.9F);
        this.rClaw01.addBox(-0.5F, -0.5F, -2.5F, 1, 1, 3, 0.0F);
        this.lLeg02a = new ModelPart(this, 0, 20);
        this.lLeg02a.setPos(2.8F, 1.0F, 2.7F);
        this.lLeg02a.addBox(0.0F, -0.5F, -0.5F, 4, 1, 1, 0.0F);
        this.setRotateAngle(lLeg02a, 0.0F, -0.17453292519943295F, 0.0F);
        this.lLeg02b = new ModelPart(this, 0, 23);
        this.lLeg02b.setPos(3.9F, 0.0F, 0.0F);
        this.lLeg02b.addBox(0.0F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(lLeg02b, 0.0F, 0.0F, 0.45378560551852565F);
        this.rLeg02a = new ModelPart(this, 0, 20);
        this.rLeg02a.mirror = true;
        this.rLeg02a.setPos(-2.8F, 1.0F, 2.7F);
        this.rLeg02a.addBox(-4.0F, -0.5F, -0.5F, 4, 1, 1, 0.0F);
        this.setRotateAngle(rLeg02a, 0.0F, 0.13962634015954636F, 0.0F);
        this.rClaw01_1 = new ModelPart(this, 20, 27);
        this.rClaw01_1.setPos(0.0F, 0.7F, -3.9F);
        this.rClaw01_1.addBox(-0.5F, -0.5F, -2.0F, 1, 1, 2, 0.0F);
        this.rLeg03b = new ModelPart(this, 0, 23);
        this.rLeg03b.mirror = true;
        this.rLeg03b.setPos(-3.9F, 0.0F, 0.0F);
        this.rLeg03b.addBox(-3.0F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(rLeg03b, 0.0F, 0.0F, -0.45378560551852565F);
        this.rMouth = new ModelPart(this, 0, 4);
        this.rMouth.mirror = true;
        this.rMouth.setPos(-1.1F, -0.9F, -3.0F);
        this.rMouth.addBox(-1.0F, 0.0F, -0.5F, 2, 2, 1, 0.0F);
        this.setRotateAngle(rMouth, 0.0F, 0.17453292519943295F, 0.0F);
        this.lLeg00b = new ModelPart(this, 0, 23);
        this.lLeg00b.setPos(3.9F, 0.0F, 0.0F);
        this.lLeg00b.addBox(0.0F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(lLeg00b, 0.0F, 0.0F, 0.45378560551852565F);
        this.lShell = new ModelPart(this, 1, 13);
        this.lShell.setPos(0.6F, -0.6F, 3.7F);
        this.lShell.addBox(0.0F, -0.5F, -1.5F, 7, 2, 3, 0.0F);
        this.setRotateAngle(lShell, 0.0F, 1.0471975511965976F, 0.0F);
        this.rLeg01b = new ModelPart(this, 0, 23);
        this.rLeg01b.mirror = true;
        this.rLeg01b.setPos(-3.9F, 0.0F, 0.0F);
        this.rLeg01b.addBox(-3.0F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(rLeg01b, 0.0F, 0.0F, -0.45378560551852565F);
        this.body.addChild(this.rLeg03a);
        this.lClaw00.addChild(this.lClaw01);
        this.body.addChild(this.rLeg01a);
        this.rLeg00b.addChild(this.rLeg00c);
        this.lLeg01a.addChild(this.lLeg01b);
        this.rLeg02a.addChild(this.rLeg02b);
        this.rLeg03b.addChild(this.rLeg03c);
        this.body.addChild(this.rShell);
        this.body.addChild(this.lLeg03a);
        this.body.addChild(this.lLeg01a);
        this.rLeg02b.addChild(this.rLeg02c);
        this.body.addChild(this.lLeg00a);
        this.rArm00.addChild(this.rClaw00);
        this.rLeg00a.addChild(this.rLeg00b);
        this.body.addChild(this.lMouth);
        this.lLeg03b.addChild(this.lLeg03c);
        this.lLeg02b.addChild(this.lLeg02c);
        this.body.addChild(this.lEye);
        this.body.addChild(this.rArm00);
        this.lClaw00.addChild(this.lClaw02);
        this.lLeg03a.addChild(this.lLeg03b);
        this.body.addChild(this.rEye);
        this.lLeg01b.addChild(this.lLeg01c);
        this.lLeg00b.addChild(this.lLeg00c);
        this.body.addChild(this.lArm00);
        this.body.addChild(this.rLeg00a);
        this.rLeg01b.addChild(this.rLeg01c);
        this.lArm00.addChild(this.lClaw00);
        this.rClaw00.addChild(this.rClaw01);
        this.body.addChild(this.lLeg02a);
        this.lLeg02a.addChild(this.lLeg02b);
        this.body.addChild(this.rLeg02a);
        this.rClaw00.addChild(this.rClaw01_1);
        this.rLeg03a.addChild(this.rLeg03b);
        this.body.addChild(this.rMouth);
        this.lLeg00a.addChild(this.lLeg00b);
        this.body.addChild(this.lShell);
        this.rLeg01a.addChild(this.rLeg01b);
    }

    private void resetPose() {
        this.rLeg00a.yRot = -0.3141592653589793F;
        this.lLeg00a.yRot = 0.3141592653589793F;
        this.rLeg01a.yRot = -0.13962634015954636F;
        this.lLeg01a.yRot = 0.13962634015954636F;
        this.rLeg02a.yRot = 0.13962634015954636F;
        this.lLeg02a.yRot = -0.13962634015954636F;
        this.rLeg03a.yRot = 0.45378560551852565F;
        this.lLeg03a.yRot = -0.45378560551852565F;
        this.rLeg00a.zRot = 0;
        this.lLeg00a.zRot = 0;
        this.rLeg01a.zRot = 0;
        this.lLeg01a.zRot = 0;
        this.rLeg02a.zRot = 0;
        this.lLeg02a.zRot = 0;
        this.rLeg03a.zRot = 0;
        this.lLeg03a.zRot = 0;
        this.rLeg00a.xRot = 0;
        this.lLeg00a.xRot = 0;
        this.rLeg01a.xRot = 0;
        this.lLeg01a.xRot = 0;
        this.rLeg02a.xRot = 0;
        this.lLeg02a.xRot = 0;
        this.rLeg03a.xRot = 0;
        this.lLeg03a.xRot = 0;
        this.body.x = 0;
        this.body.y = 0;
        this.body.z = 0;
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        matrixStackIn.translate(0F, 1.15F, 0F);
        if (crabId == 1) {
            matrixStackIn.translate(0, -0.25, 0);
        } else if (crabId == 2) {
            matrixStackIn.translate(0, -0.15, 0);
        } else if (crabId == 3) {
            matrixStackIn.translate(0, -0.05, 0);
        } else {
            matrixStackIn.translate(0F, 0.05F, 0F);
        }
        this.body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T entity, float f, float f1, float f2, float f3, float f4) {
        this.resetPose();
        if (entity instanceof EntityCrab) {
            EntityCrab crab = (EntityCrab) entity;
            int crabID = crab.getIsCrabRave();
            this.crabId = crabID;
            if (crabID == 1) {
                float xOff = (((float) Math.sin(((f2 + 100) / 2.5F) % 200F)) / 5);
                this.body.x = xOff * 16F;
                this.lArm00.xRot = -1.5F;
                this.rArm00.xRot = -1.5F;
                this.lArm00.yRot = 0F;
                this.rArm00.yRot = 0F;
                float rotOff = (float) Math.atan(xOff * 1.5F) * 1.5F;
                this.lArm00.zRot = 1F - rotOff;
                this.rArm00.zRot = -1F - rotOff;

                float mulFact = 2F;
                rotOff = -(float) Math.acos(xOff) * mulFact;

                this.rLeg00a.zRot = -90F * mulFact;
                this.lLeg00a.zRot = 90F * mulFact;
                this.rLeg01a.zRot = -90F * mulFact;
                this.lLeg01a.zRot = 90F * mulFact;
                this.rLeg02a.zRot = -90F * mulFact;
                this.lLeg02a.zRot = 90F * mulFact;
                this.rLeg03a.zRot = -90F * mulFact;
                this.lLeg03a.zRot = 90F * mulFact;

                this.rLeg00a.zRot += rotOff;
                this.lLeg00a.zRot += rotOff;
                this.rLeg01a.zRot += rotOff;
                this.lLeg01a.zRot += rotOff;
                this.rLeg02a.zRot += rotOff;
                this.lLeg02a.zRot += rotOff;
                this.rLeg03a.zRot += rotOff;
                this.lLeg03a.zRot += rotOff;
            } else if (crabID == 2) {
                float zOff = (((float) Math.sin(((f2 + 100) / 2.5F) % 200F)) / 5);
                this.body.z = zOff * 16F;
                this.lArm00.xRot = 0F;
                this.rArm00.xRot = 0F;
                this.lArm00.yRot = -1F + (float) Math.sin(f2 / 2.5F) / 2;
                this.rArm00.yRot = 1F - (float) Math.sin(f2 / 2.5F) / 2;
                this.lArm00.zRot = 0F;
                this.rArm00.zRot = 0F;

                float mulFact = -3F;
                float pi = (float) Math.PI;
                float rotOff = -(float) Math.acos(zOff) * mulFact;

                this.rLeg00a.zRot = -pi / 6;
                this.lLeg00a.zRot = pi / 6;
                this.rLeg01a.zRot = -pi / 6;
                this.lLeg01a.zRot = pi / 6;
                this.rLeg02a.zRot = -pi / 6;
                this.lLeg02a.zRot = pi / 6;
                this.rLeg03a.zRot = -pi / 6;
                this.lLeg03a.zRot = pi / 6;

                this.rLeg00a.xRot = (pi / 2) * mulFact;
                this.lLeg00a.xRot = (pi / 2) * mulFact;
                this.rLeg01a.xRot = (pi / 2) * mulFact;
                this.lLeg01a.xRot = (pi / 2) * mulFact;
                this.rLeg02a.xRot = (pi / 2) * mulFact;
                this.lLeg02a.xRot = (pi / 2) * mulFact;
                this.rLeg03a.xRot = (pi / 2) * mulFact;
                this.lLeg03a.xRot = (pi / 2) * mulFact;

                this.rLeg00a.xRot += rotOff;
                this.lLeg00a.xRot += rotOff;
                this.rLeg01a.xRot += rotOff;
                this.lLeg01a.xRot += rotOff;
                this.rLeg02a.xRot += rotOff;
                this.lLeg02a.xRot += rotOff;
                this.rLeg03a.xRot += rotOff;
                this.lLeg03a.xRot += rotOff;
            } else if (crabID == 3) {
                float yOff = (((float) Math.sin(((f2 + 100) / 2.5F) % 200F)) / 5);
                this.body.y = yOff * 16F;
                this.lArm00.xRot = -1.5F;
                this.rArm00.xRot = -1.5F;
                this.lArm00.yRot = -1.5F + (float) Math.sin(f2 / 2.5F) / 1.5F;
                this.rArm00.yRot = 1.5F - (float) Math.sin(f2 / 2.5F) / 1.5F;
                this.lArm00.zRot = 1.5F;
                this.rArm00.zRot = -1.5F;

                float mulFact = 2F;
                float rotOff = -(float) Math.acos(yOff) * mulFact - 0.25F;

                float pi = (float) Math.PI;
                this.rLeg00a.zRot = (pi / 2) * mulFact;
                this.lLeg00a.zRot = (pi / 2) * mulFact;
                this.rLeg01a.zRot = (pi / 2) * mulFact;
                this.lLeg01a.zRot = (pi / 2) * mulFact;
                this.rLeg02a.zRot = (pi / 2) * mulFact;
                this.lLeg02a.zRot = (pi / 2) * mulFact;
                this.rLeg03a.zRot = (pi / 2) * mulFact;
                this.lLeg03a.zRot = (pi / 2) * mulFact;

                this.rLeg00a.zRot += rotOff;
                this.lLeg00a.zRot -= rotOff;
                this.rLeg01a.zRot += rotOff;
                this.lLeg01a.zRot -= rotOff;
                this.rLeg02a.zRot += rotOff;
                this.lLeg02a.zRot -= rotOff;
                this.rLeg03a.zRot += rotOff;
                this.lLeg03a.zRot -= rotOff;
            } else {
                float f5 = -(Mth.cos(f * 0.6662F * 2.0F + 0.0F) * 1.0F) * f1;
                float f6 = -(Mth.cos(f * 0.6662F * 2.0F + (float) Math.PI) * 1.0F) * f1;
                float f7 = -(Mth.cos(f * 0.6662F * 2.0F + ((float) Math.PI / 2F)) * 1.0F) * f1;
                float f8 = -(Mth.cos(f * 0.6662F * 2.0F + ((float) Math.PI * 3F / 2F)) * 1.0F) * f1;
                this.rLeg00a.yRot += f5;
                this.lLeg00a.yRot += -f5;
                this.rLeg01a.yRot += f6;
                this.lLeg01a.yRot += -f6;
                this.rLeg02a.yRot += f7;
                this.lLeg02a.yRot += -f7;
                this.rLeg03a.yRot += f8;
                this.lLeg03a.yRot += -f8;
                this.lClaw02.xRot = 0;
                this.rClaw01_1.xRot = 0;
                this.lClaw01.xRot = 0;
                this.rClaw01.xRot = 0;
                if (crab.snipTime > 0) {
                    float angle = (crab.snipTime % 5) * 0.05F;
                    angle -= (crab.snipTime % 10) * 0.05F;
                    this.lClaw02.xRot = angle;
                    this.rClaw01_1.xRot = angle;
                    this.lClaw01.xRot = -angle;
                    this.rClaw01.xRot = -angle;
                }

                float mul = 0.05F;
                float div = 20F;
                if (f1 > 0.1) {
                    div = 5F;
                }
                float add = entity.getUUID().hashCode() * 0.001F;
                this.lArm00.xRot = (float) Math.cos(f2 * (mul + 0.05F) + add) / div + 0.3490658503988659F;
                this.rArm00.xRot = (float) Math.cos(-f2 * (mul + 0.05F) + add) / div + 0.3490658503988659F;
                this.lArm00.yRot = (float) Math.cos(f2 * (mul + 0.05F) + add) / div - 1.0471975511965976F;
                this.rArm00.yRot = (float) Math.cos(-f2 * (mul + 0.05F) + add) / div + 1.0471975511965976F;
                this.lArm00.zRot = (float) Math.cos(f2 * (mul + 0.05F) + add) / div;
                this.rArm00.zRot = (float) Math.cos(-f2 * (mul + 0.05F) + add) / div;
            }
        }
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelPart ModelRenderer, float x, float y, float z) {
        ModelRenderer.xRot = x;
        ModelRenderer.yRot = y;
        ModelRenderer.zRot = z;
    }
}
