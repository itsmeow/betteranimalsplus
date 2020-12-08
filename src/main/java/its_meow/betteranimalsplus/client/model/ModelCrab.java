package its_meow.betteranimalsplus.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import its_meow.betteranimalsplus.common.entity.EntityCrab;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;

/**
 * crab - Batman
 * Created using Tabula 7.0.1
 */
public class ModelCrab<T extends LivingEntity> extends EntityModel<T> {
    public ModelRenderer body;
    public ModelRenderer lShell;
    public ModelRenderer rShell;
    public ModelRenderer lArm00;
    public ModelRenderer rArm00;
    public ModelRenderer lEye;
    public ModelRenderer rEye;
    public ModelRenderer rMouth;
    public ModelRenderer lMouth;
    public ModelRenderer lLeg00a;
    public ModelRenderer lLeg01a;
    public ModelRenderer lLeg02a;
    public ModelRenderer rLeg00a;
    public ModelRenderer rLeg01a;
    public ModelRenderer rLeg02a;
    public ModelRenderer lLeg03a;
    public ModelRenderer rLeg03a;
    public ModelRenderer lClaw00;
    public ModelRenderer lClaw02;
    public ModelRenderer lClaw01;
    public ModelRenderer rClaw00;
    public ModelRenderer rClaw01;
    public ModelRenderer rClaw01_1;
    public ModelRenderer lLeg00b;
    public ModelRenderer lLeg00c;
    public ModelRenderer lLeg01b;
    public ModelRenderer lLeg01c;
    public ModelRenderer lLeg02b;
    public ModelRenderer lLeg02c;
    public ModelRenderer rLeg00b;
    public ModelRenderer rLeg00c;
    public ModelRenderer rLeg01b;
    public ModelRenderer rLeg01c;
    public ModelRenderer rLeg02b;
    public ModelRenderer rLeg02c;
    public ModelRenderer lLeg03b;
    public ModelRenderer lLeg03c;
    public ModelRenderer rLeg03b;
    public ModelRenderer rLeg03c;

    private int crabId = 0;

    public ModelCrab() {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.rLeg03a = new ModelRenderer(this, 0, 20);
        this.rLeg03a.mirror = true;
        this.rLeg03a.setRotationPoint(-2.8F, 1.0F, 3.7F);
        this.rLeg03a.addBox(-4.0F, -0.5F, -0.5F, 4, 1, 1, 0.0F);
        this.setRotateAngle(rLeg03a, 0.0F, 0.45378560551852565F, 0.0F);
        this.lClaw01 = new ModelRenderer(this, 11, 27);
        this.lClaw01.setRotationPoint(0.0F, -0.6F, -3.9F);
        this.lClaw01.addBox(-0.5F, -0.5F, -2.5F, 1, 1, 3, 0.0F);
        this.rLeg01a = new ModelRenderer(this, 0, 20);
        this.rLeg01a.mirror = true;
        this.rLeg01a.setRotationPoint(-2.8F, 1.0F, 1.9F);
        this.rLeg01a.addBox(-4.0F, -0.5F, -0.5F, 4, 1, 1, 0.0F);
        this.setRotateAngle(rLeg01a, 0.0F, -0.13962634015954636F, 0.0F);
        this.rLeg00c = new ModelRenderer(this, 0, 26);
        this.rLeg00c.setRotationPoint(-2.9F, 0.0F, 0.0F);
        this.rLeg00c.addBox(-3.0F, -0.5F, 0.0F, 3, 1, 0, 0.0F);
        this.setRotateAngle(rLeg00c, 0.0F, 0.0F, -0.5235987755982988F);
        this.lLeg01b = new ModelRenderer(this, 0, 23);
        this.lLeg01b.setRotationPoint(3.9F, 0.0F, 0.0F);
        this.lLeg01b.addBox(0.0F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(lLeg01b, 0.0F, 0.0F, 0.45378560551852565F);
        this.rLeg02b = new ModelRenderer(this, 0, 23);
        this.rLeg02b.mirror = true;
        this.rLeg02b.setRotationPoint(-3.9F, 0.0F, 0.0F);
        this.rLeg02b.addBox(-3.0F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(rLeg02b, 0.0F, 0.0F, -0.45378560551852565F);
        this.rLeg03c = new ModelRenderer(this, 0, 26);
        this.rLeg03c.setRotationPoint(-2.9F, 0.0F, 0.0F);
        this.rLeg03c.addBox(-3.0F, -0.5F, 0.0F, 3, 1, 0, 0.0F);
        this.setRotateAngle(rLeg03c, 0.0F, 0.0F, -0.5235987755982988F);
        this.rShell = new ModelRenderer(this, 1, 13);
        this.rShell.mirror = true;
        this.rShell.setRotationPoint(-0.6F, -0.6F, 3.7F);
        this.rShell.addBox(-7.0F, -0.5F, -1.5F, 7, 2, 3, 0.0F);
        this.setRotateAngle(rShell, 0.0F, -1.0471975511965976F, 0.0F);
        this.lLeg03a = new ModelRenderer(this, 0, 20);
        this.lLeg03a.setRotationPoint(2.8F, 1.0F, 3.7F);
        this.lLeg03a.addBox(0.0F, -0.5F, -0.5F, 4, 1, 1, 0.0F);
        this.setRotateAngle(lLeg03a, 0.0F, -0.45378560551852565F, 0.0F);
        this.lLeg01a = new ModelRenderer(this, 0, 20);
        this.lLeg01a.setRotationPoint(2.8F, 1.0F, 1.9F);
        this.lLeg01a.addBox(0.0F, -0.5F, -0.5F, 4, 1, 1, 0.0F);
        this.setRotateAngle(lLeg01a, 0.0F, 0.13962634015954636F, 0.0F);
        this.rLeg02c = new ModelRenderer(this, 0, 26);
        this.rLeg02c.setRotationPoint(-2.9F, 0.0F, 0.0F);
        this.rLeg02c.addBox(-3.0F, -0.5F, 0.0F, 3, 1, 0, 0.0F);
        this.setRotateAngle(rLeg02c, 0.0F, 0.0F, -0.5235987755982988F);
        this.lLeg00a = new ModelRenderer(this, 0, 20);
        this.lLeg00a.setRotationPoint(2.8F, 1.0F, 0.8F);
        this.lLeg00a.addBox(0.0F, -0.5F, -0.5F, 4, 1, 1, 0.0F);
        this.setRotateAngle(lLeg00a, 0.0F, 0.3141592653589793F, 0.0F);
        this.rClaw00 = new ModelRenderer(this, 11, 20);
        this.rClaw00.mirror = true;
        this.rClaw00.setRotationPoint(0.0F, 0.1F, -2.8F);
        this.rClaw00.addBox(-1.0F, -1.0F, -4.0F, 2, 2, 4, 0.0F);
        this.setRotateAngle(rClaw00, -0.17453292519943295F, -1.0471975511965976F, 0.0F);
        this.rLeg00b = new ModelRenderer(this, 0, 23);
        this.rLeg00b.mirror = true;
        this.rLeg00b.setRotationPoint(-3.9F, 0.0F, 0.0F);
        this.rLeg00b.addBox(-3.0F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(rLeg00b, 0.0F, 0.0F, -0.45378560551852565F);
        this.lMouth = new ModelRenderer(this, 0, 4);
        this.lMouth.setRotationPoint(0.8F, -0.9F, -3.0F);
        this.lMouth.addBox(-1.0F, 0.0F, -0.5F, 2, 2, 1, 0.0F);
        this.setRotateAngle(lMouth, 0.0F, -0.17453292519943295F, 0.0F);
        this.lLeg03c = new ModelRenderer(this, 0, 26);
        this.lLeg03c.setRotationPoint(2.9F, 0.0F, 0.0F);
        this.lLeg03c.addBox(0.0F, -0.5F, 0.0F, 3, 1, 0, 0.0F);
        this.setRotateAngle(lLeg03c, 0.0F, 0.0F, 0.5235987755982988F);
        this.lLeg02c = new ModelRenderer(this, 0, 26);
        this.lLeg02c.setRotationPoint(2.9F, 0.0F, 0.0F);
        this.lLeg02c.addBox(0.0F, -0.5F, 0.0F, 3, 1, 0, 0.0F);
        this.setRotateAngle(lLeg02c, 0.0F, 0.0F, 0.5235987755982988F);
        this.lEye = new ModelRenderer(this, 0, 0);
        this.lEye.setRotationPoint(1.3F, -1.2F, -2.5F);
        this.lEye.addBox(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(lEye, 0.31869712141416456F, 0.0F, 0.22759093446006054F);
        this.rArm00 = new ModelRenderer(this, 11, 20);
        this.rArm00.mirror = true;
        this.rArm00.setRotationPoint(-2.5F, 0.9F, -1.8F);
        this.rArm00.addBox(-1.0F, -1.0F, -3.0F, 2, 2, 4, 0.0F);
        this.setRotateAngle(rArm00, 0.3490658503988659F, 1.0471975511965976F, 0.0F);
        this.lClaw02 = new ModelRenderer(this, 20, 27);
        this.lClaw02.setRotationPoint(0.0F, 0.7F, -3.9F);
        this.lClaw02.addBox(-0.5F, -0.5F, -2.0F, 1, 1, 2, 0.0F);
        this.lLeg03b = new ModelRenderer(this, 0, 23);
        this.lLeg03b.setRotationPoint(3.9F, 0.0F, 0.0F);
        this.lLeg03b.addBox(0.0F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(lLeg03b, 0.0F, 0.0F, 0.45378560551852565F);
        this.rEye = new ModelRenderer(this, 0, 0);
        this.rEye.setRotationPoint(-1.3F, -1.2F, -2.5F);
        this.rEye.addBox(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(rEye, 0.31869712141416456F, 0.0F, -0.22759093446006054F);
        this.lLeg01c = new ModelRenderer(this, 0, 26);
        this.lLeg01c.setRotationPoint(2.9F, 0.0F, 0.0F);
        this.lLeg01c.addBox(0.0F, -0.5F, 0.0F, 3, 1, 0, 0.0F);
        this.setRotateAngle(lLeg01c, 0.0F, 0.0F, 0.5235987755982988F);
        this.lLeg00c = new ModelRenderer(this, 0, 26);
        this.lLeg00c.setRotationPoint(2.9F, 0.0F, 0.0F);
        this.lLeg00c.addBox(0.0F, -0.5F, 0.0F, 3, 1, 0, 0.0F);
        this.setRotateAngle(lLeg00c, 0.0F, 0.0F, 0.5235987755982988F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.body.addBox(-3.0F, -1.5F, -3.0F, 6, 3, 8, 0.0F);
        this.lArm00 = new ModelRenderer(this, 11, 20);
        this.lArm00.mirror = true;
        this.lArm00.setRotationPoint(2.5F, 0.9F, -1.8F);
        this.lArm00.addBox(-1.0F, -1.0F, -4.0F, 2, 2, 4, 0.0F);
        this.setRotateAngle(lArm00, 0.3490658503988659F, -1.0471975511965976F, 0.0F);
        this.rLeg00a = new ModelRenderer(this, 0, 20);
        this.rLeg00a.mirror = true;
        this.rLeg00a.setRotationPoint(-2.8F, 1.0F, 0.8F);
        this.rLeg00a.addBox(-4.0F, -0.5F, -0.5F, 4, 1, 1, 0.0F);
        this.setRotateAngle(rLeg00a, 0.0F, -0.3141592653589793F, 0.0F);
        this.rLeg01c = new ModelRenderer(this, 0, 26);
        this.rLeg01c.setRotationPoint(-2.9F, 0.0F, 0.0F);
        this.rLeg01c.addBox(-3.0F, -0.5F, 0.0F, 3, 1, 0, 0.0F);
        this.setRotateAngle(rLeg01c, 0.0F, 0.0F, -0.5235987755982988F);
        this.lClaw00 = new ModelRenderer(this, 11, 20);
        this.lClaw00.setRotationPoint(0.0F, 0.1F, -3.8F);
        this.lClaw00.addBox(-1.0F, -1.0F, -4.0F, 2, 2, 4, 0.0F);
        this.setRotateAngle(lClaw00, -0.17453292519943295F, 1.0471975511965976F, 0.0F);
        this.rClaw01 = new ModelRenderer(this, 11, 27);
        this.rClaw01.setRotationPoint(0.0F, -0.6F, -3.9F);
        this.rClaw01.addBox(-0.5F, -0.5F, -2.5F, 1, 1, 3, 0.0F);
        this.lLeg02a = new ModelRenderer(this, 0, 20);
        this.lLeg02a.setRotationPoint(2.8F, 1.0F, 2.7F);
        this.lLeg02a.addBox(0.0F, -0.5F, -0.5F, 4, 1, 1, 0.0F);
        this.setRotateAngle(lLeg02a, 0.0F, -0.17453292519943295F, 0.0F);
        this.lLeg02b = new ModelRenderer(this, 0, 23);
        this.lLeg02b.setRotationPoint(3.9F, 0.0F, 0.0F);
        this.lLeg02b.addBox(0.0F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(lLeg02b, 0.0F, 0.0F, 0.45378560551852565F);
        this.rLeg02a = new ModelRenderer(this, 0, 20);
        this.rLeg02a.mirror = true;
        this.rLeg02a.setRotationPoint(-2.8F, 1.0F, 2.7F);
        this.rLeg02a.addBox(-4.0F, -0.5F, -0.5F, 4, 1, 1, 0.0F);
        this.setRotateAngle(rLeg02a, 0.0F, 0.13962634015954636F, 0.0F);
        this.rClaw01_1 = new ModelRenderer(this, 20, 27);
        this.rClaw01_1.setRotationPoint(0.0F, 0.7F, -3.9F);
        this.rClaw01_1.addBox(-0.5F, -0.5F, -2.0F, 1, 1, 2, 0.0F);
        this.rLeg03b = new ModelRenderer(this, 0, 23);
        this.rLeg03b.mirror = true;
        this.rLeg03b.setRotationPoint(-3.9F, 0.0F, 0.0F);
        this.rLeg03b.addBox(-3.0F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(rLeg03b, 0.0F, 0.0F, -0.45378560551852565F);
        this.rMouth = new ModelRenderer(this, 0, 4);
        this.rMouth.mirror = true;
        this.rMouth.setRotationPoint(-1.1F, -0.9F, -3.0F);
        this.rMouth.addBox(-1.0F, 0.0F, -0.5F, 2, 2, 1, 0.0F);
        this.setRotateAngle(rMouth, 0.0F, 0.17453292519943295F, 0.0F);
        this.lLeg00b = new ModelRenderer(this, 0, 23);
        this.lLeg00b.setRotationPoint(3.9F, 0.0F, 0.0F);
        this.lLeg00b.addBox(0.0F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(lLeg00b, 0.0F, 0.0F, 0.45378560551852565F);
        this.lShell = new ModelRenderer(this, 1, 13);
        this.lShell.setRotationPoint(0.6F, -0.6F, 3.7F);
        this.lShell.addBox(0.0F, -0.5F, -1.5F, 7, 2, 3, 0.0F);
        this.setRotateAngle(lShell, 0.0F, 1.0471975511965976F, 0.0F);
        this.rLeg01b = new ModelRenderer(this, 0, 23);
        this.rLeg01b.mirror = true;
        this.rLeg01b.setRotationPoint(-3.9F, 0.0F, 0.0F);
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

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        matrixStackIn.translate(0F, 1.15F, 0F);
        if(crabId == 1 || crabId == 2) {
            matrixStackIn.translate(0, -0.25, 0);
        } else if(crabId == 3) {
            matrixStackIn.translate(0, -0.05, 0);
        }
        this.body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);

        this.rLeg00a.rotateAngleY = -0.3141592653589793F;
        this.lLeg00a.rotateAngleY = 0.3141592653589793F;
        this.rLeg01a.rotateAngleY = -0.13962634015954636F;
        this.lLeg01a.rotateAngleY = 0.13962634015954636F;
        this.rLeg02a.rotateAngleY = 0.13962634015954636F;
        this.lLeg02a.rotateAngleY = -0.13962634015954636F;
        this.rLeg03a.rotateAngleY = 0.45378560551852565F;
        this.lLeg03a.rotateAngleY = -0.45378560551852565F;
        this.rLeg00a.rotateAngleZ = 0;
        this.lLeg00a.rotateAngleZ = 0;
        this.rLeg01a.rotateAngleZ = 0;
        this.lLeg01a.rotateAngleZ = 0;
        this.rLeg02a.rotateAngleZ = 0;
        this.lLeg02a.rotateAngleZ = 0;
        this.rLeg03a.rotateAngleZ = 0;
        this.lLeg03a.rotateAngleZ = 0;
        this.rLeg00a.rotateAngleX = 0;
        this.lLeg00a.rotateAngleX = 0;
        this.rLeg01a.rotateAngleX = 0;
        this.lLeg01a.rotateAngleX = 0;
        this.rLeg02a.rotateAngleX = 0;
        this.lLeg02a.rotateAngleX = 0;
        this.rLeg03a.rotateAngleX = 0;
        this.lLeg03a.rotateAngleX = 0;
        this.body.rotationPointX = 0;
        this.body.rotationPointY = 0;
        this.body.rotationPointZ = 0;
    }

    @Override
    public void setRotationAngles(T entity, float f, float f1, float f2, float f3, float f4) {
        {
            if(entity instanceof EntityCrab) {
                EntityCrab crab = (EntityCrab) entity;
                int crabID = crab.getIsCrabRave();
                this.crabId = crabID;
                if(crabID == 1) {
                    float xOff = (((float) Math.sin(((f2 + 100) / 2.5F) % 200F)) / 5);
                    this.body.rotationPointX = xOff * 16F;
                    this.lArm00.rotateAngleX = -1.5F;
                    this.rArm00.rotateAngleX = -1.5F;
                    this.lArm00.rotateAngleY = 0F;
                    this.rArm00.rotateAngleY = 0F;
                    float rotOff = (float) Math.atan(xOff * 1.5F) * 1.5F;
                    this.lArm00.rotateAngleZ = 1F - rotOff;
                    this.rArm00.rotateAngleZ = -1F - rotOff;

                    float mulFact = 2F;
                    rotOff = -(float) Math.acos(xOff) * mulFact;

                    this.rLeg00a.rotateAngleZ = -90F * mulFact;
                    this.lLeg00a.rotateAngleZ = 90F * mulFact;
                    this.rLeg01a.rotateAngleZ = -90F * mulFact;
                    this.lLeg01a.rotateAngleZ = 90F * mulFact;
                    this.rLeg02a.rotateAngleZ = -90F * mulFact;
                    this.lLeg02a.rotateAngleZ = 90F * mulFact;
                    this.rLeg03a.rotateAngleZ = -90F * mulFact;
                    this.lLeg03a.rotateAngleZ = 90F * mulFact;

                    this.rLeg00a.rotateAngleZ += rotOff;
                    this.lLeg00a.rotateAngleZ += rotOff;
                    this.rLeg01a.rotateAngleZ += rotOff;
                    this.lLeg01a.rotateAngleZ += rotOff;
                    this.rLeg02a.rotateAngleZ += rotOff;
                    this.lLeg02a.rotateAngleZ += rotOff;
                    this.rLeg03a.rotateAngleZ += rotOff;
                    this.lLeg03a.rotateAngleZ += rotOff;
                } else if(crabID == 2) {
                    float zOff = (((float) Math.sin(((f2 + 100) / 2.5F) % 200F)) / 5);
                    this.body.rotationPointZ = zOff * 16F;
                    this.lArm00.rotateAngleX = 0F;
                    this.rArm00.rotateAngleX = 0F;
                    this.lArm00.rotateAngleY = -1F + (float) Math.sin(f2 / 2.5F) / 2;
                    this.rArm00.rotateAngleY = 1F - (float) Math.sin(f2 / 2.5F) / 2;
                    this.lArm00.rotateAngleZ = 0F;
                    this.rArm00.rotateAngleZ = 0F;

                    float mulFact = -3F;
                    float pi = (float) Math.PI;
                    float rotOff =-(float) Math.acos(zOff) * mulFact;

                    this.rLeg00a.rotateAngleZ = -pi / 6;
                    this.lLeg00a.rotateAngleZ = pi / 6;
                    this.rLeg01a.rotateAngleZ = -pi / 6;
                    this.lLeg01a.rotateAngleZ = pi / 6;
                    this.rLeg02a.rotateAngleZ = -pi / 6;
                    this.lLeg02a.rotateAngleZ = pi / 6;
                    this.rLeg03a.rotateAngleZ = -pi / 6;
                    this.lLeg03a.rotateAngleZ = pi / 6;

                    this.rLeg00a.rotateAngleX = (pi / 2) * mulFact;
                    this.lLeg00a.rotateAngleX = (pi / 2) * mulFact;
                    this.rLeg01a.rotateAngleX = (pi / 2) * mulFact;
                    this.lLeg01a.rotateAngleX = (pi / 2) * mulFact;
                    this.rLeg02a.rotateAngleX = (pi / 2) * mulFact;
                    this.lLeg02a.rotateAngleX = (pi / 2) * mulFact;
                    this.rLeg03a.rotateAngleX = (pi / 2) * mulFact;
                    this.lLeg03a.rotateAngleX = (pi / 2) * mulFact;

                    this.rLeg00a.rotateAngleX += rotOff;
                    this.lLeg00a.rotateAngleX += rotOff;
                    this.rLeg01a.rotateAngleX += rotOff;
                    this.lLeg01a.rotateAngleX += rotOff;
                    this.rLeg02a.rotateAngleX += rotOff;
                    this.lLeg02a.rotateAngleX += rotOff;
                    this.rLeg03a.rotateAngleX += rotOff;
                    this.lLeg03a.rotateAngleX += rotOff;
                } else if(crabID == 3) {
                    float yOff = (((float) Math.sin(((f2 + 100) / 2.5F) % 200F)) / 5);
                    this.body.rotationPointY = yOff * 16F;
                    this.lArm00.rotateAngleX = -1.5F;
                    this.rArm00.rotateAngleX = -1.5F;
                    this.lArm00.rotateAngleY = -1.5F + (float) Math.sin(f2 / 2.5F) / 1.5F;
                    this.rArm00.rotateAngleY = 1.5F - (float) Math.sin(f2 / 2.5F) / 1.5F;
                    this.lArm00.rotateAngleZ = 1.5F;
                    this.rArm00.rotateAngleZ = -1.5F;

                    float mulFact = 2F;
                    float rotOff = -(float) Math.acos(yOff) * mulFact - 0.25F;

                    float pi = (float) Math.PI;
                    this.rLeg00a.rotateAngleZ = (pi / 2) * mulFact;
                    this.lLeg00a.rotateAngleZ = (pi / 2) * mulFact;
                    this.rLeg01a.rotateAngleZ = (pi / 2) * mulFact;
                    this.lLeg01a.rotateAngleZ = (pi / 2) * mulFact;
                    this.rLeg02a.rotateAngleZ = (pi / 2) * mulFact;
                    this.lLeg02a.rotateAngleZ = (pi / 2) * mulFact;
                    this.rLeg03a.rotateAngleZ = (pi / 2) * mulFact;
                    this.lLeg03a.rotateAngleZ = (pi / 2) * mulFact;

                    this.rLeg00a.rotateAngleZ += rotOff;
                    this.lLeg00a.rotateAngleZ -= rotOff;
                    this.rLeg01a.rotateAngleZ += rotOff;
                    this.lLeg01a.rotateAngleZ -= rotOff;
                    this.rLeg02a.rotateAngleZ += rotOff;
                    this.lLeg02a.rotateAngleZ -= rotOff;
                    this.rLeg03a.rotateAngleZ += rotOff;
                    this.lLeg03a.rotateAngleZ -= rotOff;
                } else {
                    this.rLeg00a.rotateAngleZ = 0;
                    this.lLeg00a.rotateAngleZ = 0;
                    this.rLeg01a.rotateAngleZ = 0;
                    this.lLeg01a.rotateAngleZ = 0;
                    this.rLeg02a.rotateAngleZ = 0;
                    this.lLeg02a.rotateAngleZ = 0;
                    this.rLeg03a.rotateAngleZ = 0;
                    this.lLeg03a.rotateAngleZ = 0;
                    this.rLeg00a.rotateAngleX = 0;
                    this.lLeg00a.rotateAngleX = 0;
                    this.rLeg01a.rotateAngleX = 0;
                    this.lLeg01a.rotateAngleX = 0;
                    this.rLeg02a.rotateAngleX = 0;
                    this.lLeg02a.rotateAngleX = 0;
                    this.rLeg03a.rotateAngleX = 0;
                    this.lLeg03a.rotateAngleX = 0;
                    this.body.rotationPointX = 0;
                    this.body.rotationPointY = 0;
                    this.body.rotationPointZ = 0;
                    this.rLeg00a.rotateAngleY = -0.3141592653589793F;
                    this.lLeg00a.rotateAngleY = 0.3141592653589793F;
                    this.rLeg01a.rotateAngleY = -0.13962634015954636F;
                    this.lLeg01a.rotateAngleY = 0.13962634015954636F;
                    this.rLeg02a.rotateAngleY = 0.13962634015954636F;
                    this.lLeg02a.rotateAngleY = -0.13962634015954636F;
                    this.rLeg03a.rotateAngleY = 0.45378560551852565F;
                    this.lLeg03a.rotateAngleY = -0.45378560551852565F;
                    float f5 = -(MathHelper.cos(f * 0.6662F * 2.0F + 0.0F) * 0.4F) * f1;
                    float f6 = -(MathHelper.cos(f * 0.6662F * 2.0F + (float) Math.PI) * 0.4F) * f1;
                    float f7 = -(MathHelper.cos(f * 0.6662F * 2.0F + ((float) Math.PI / 2F)) * 0.4F) * f1;
                    float f8 = -(MathHelper.cos(f * 0.6662F * 2.0F + ((float) Math.PI * 3F / 2F)) * 0.4F) * f1;
                    this.rLeg00a.rotateAngleY += f5;
                    this.lLeg00a.rotateAngleY += -f5;
                    this.rLeg01a.rotateAngleY += f6;
                    this.lLeg01a.rotateAngleY += -f6;
                    this.rLeg02a.rotateAngleY += f7;
                    this.lLeg02a.rotateAngleY += -f7;
                    this.rLeg03a.rotateAngleY += f8;
                    this.lLeg03a.rotateAngleY += -f8;
                    this.lClaw02.rotateAngleX = 0;
                    this.rClaw01_1.rotateAngleX = 0;
                    this.lClaw01.rotateAngleX = 0;
                    this.rClaw01.rotateAngleX = 0;
                    if(crab.snipTime > 0) {
                        float angle = (crab.snipTime % 5) * 0.05F;
                        angle -= (crab.snipTime % 10) * 0.05F;
                        this.lClaw02.rotateAngleX = angle;
                        this.rClaw01_1.rotateAngleX = angle;
                        this.lClaw01.rotateAngleX = -angle;
                        this.rClaw01.rotateAngleX = -angle;
                    }

                    float mul = 0.05F;
                    float div = 20F;
                    if(f1 > 0.1) {
                        div = 5F;
                    }
                    float add = entity.getUniqueID().hashCode() * 0.001F;
                    float tick = f2;
                    this.lArm00.rotateAngleX = (float) Math.cos(tick * (mul + 0.05F) + add) / div + 0.3490658503988659F;
                    this.rArm00.rotateAngleX = (float) Math.cos(-tick * (mul + 0.05F) + add) / div + 0.3490658503988659F;
                    this.lArm00.rotateAngleY = (float) Math.cos(tick * (mul + 0.05F) + add) / div - 1.0471975511965976F;
                    this.rArm00.rotateAngleY = (float) Math.cos(-tick * (mul + 0.05F) + add) / div + 1.0471975511965976F;
                    this.lArm00.rotateAngleZ = (float) Math.cos(tick * (mul + 0.05F) + add) / div;
                    this.rArm00.rotateAngleZ = (float) Math.cos(-tick * (mul + 0.05F) + add) / div;
                }
            }
        }
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer ModelRenderer, float x, float y, float z) {
        ModelRenderer.rotateAngleX = x;
        ModelRenderer.rotateAngleY = y;
        ModelRenderer.rotateAngleZ = z;
    }
}
