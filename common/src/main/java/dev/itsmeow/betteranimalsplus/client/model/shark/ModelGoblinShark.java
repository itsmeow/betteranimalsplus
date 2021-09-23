package dev.itsmeow.betteranimalsplus.client.model.shark;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.common.entity.EntityShark;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;

/**
 * GoblinShark - Batman Created using Tabula 7.0.1
 */
public class ModelGoblinShark extends EntityModel<EntityShark> {
    public ModelPart body;
    public ModelPart tail00;
    public ModelPart neck;
    public ModelPart dorsalFin00;
    public ModelPart lFin00;
    public ModelPart rFin00;
    public ModelPart tail01;
    public ModelPart tail02;
    public ModelPart lLowerTailFin;
    public ModelPart rLowerTailFin;
    public ModelPart tail03;
    public ModelPart upperTailFin;
    public ModelPart tail04;
    public ModelPart mLowerTailFin;
    public ModelPart tail05;
    public ModelPart tailFinUpper00;
    public ModelPart tailFinUpper01;
    public ModelPart tailFinFlap;
    public ModelPart tailFinUpper02;
    public ModelPart head;
    public ModelPart lowerJaw;
    public ModelPart snout;
    public ModelPart teethUpper;
    public ModelPart nose;
    public ModelPart nose2;
    public ModelPart teethLower;
    public ModelPart dorsalFin01;
    public ModelPart dorsalFin02;
    public ModelPart lFin01;
    public ModelPart lFin02;
    public ModelPart rFin01;
    public ModelPart rFin02;

    public ModelGoblinShark() {
        this.texWidth = 80;
        this.texHeight = 200;
        this.tailFinUpper02 = new ModelPart(this, 25, 88);
        this.tailFinUpper02.setPos(0.0F, -8.8F, 0.5F);
        this.tailFinUpper02.addBox(-0.5F, -5.0F, -0.5F, 1, 5, 3, 0.0F);
        this.setRotateAngle(tailFinUpper02, -0.136659280431156F, 0.0F, 0.0F);
        this.tail04 = new ModelPart(this, 0, 89);
        this.tail04.setPos(0.0F, -0.4F, 4.9F);
        this.tail04.addBox(-1.0F, -1.5F, 0.0F, 2, 3, 4, 0.0F);
        this.lFin01 = new ModelPart(this, 0, 189);
        this.lFin01.mirror = true;
        this.lFin01.setPos(-0.5F, 3.9F, 0.0F);
        this.lFin01.addBox(0.0F, 0.0F, 0.0F, 1, 3, 5, 0.0F);
        this.setRotateAngle(lFin01, 0.22759093446006054F, 0.0F, 0.0F);
        this.nose2 = new ModelPart(this, 40, 45);
        this.nose2.setPos(0.0F, -1.0F, -13.0F);
        this.nose2.addBox(-1.5F, 0.0F, 0.0F, 3, 2, 12, 0.0F);
        this.setRotateAngle(nose2, 0.16283921921107095F, 0.0F, 0.0F);
        this.upperTailFin = new ModelPart(this, 20, 170);
        this.upperTailFin.setPos(-0.5F, -2.6F, 1.8F);
        this.upperTailFin.addBox(0.0F, 0.0F, 0.0F, 1, 2, 5, 0.0F);
        this.setRotateAngle(upperTailFin, 0.7285004297824331F, 0.0F, 0.0F);
        this.tailFinUpper01 = new ModelPart(this, 25, 73);
        this.tailFinUpper01.setPos(0.0F, -6.7F, -1.5F);
        this.tailFinUpper01.addBox(-0.5F, -9.0F, 0.0F, 1, 9, 4, 0.0F);
        this.setRotateAngle(tailFinUpper01, -0.136659280431156F, 0.0F, 0.0F);
        this.lLowerTailFin = new ModelPart(this, 24, 162);
        this.lLowerTailFin.mirror = true;
        this.lLowerTailFin.setPos(2.2F, 4.0F, 1.5F);
        this.lLowerTailFin.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 4, 0.0F);
        this.setRotateAngle(lLowerTailFin, 0.36425021489121656F, 0.0F, -0.5462880558742251F);
        this.rLowerTailFin = new ModelPart(this, 24, 162);
        this.rLowerTailFin.setPos(-2.2F, 4.0F, 1.5F);
        this.rLowerTailFin.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 4, 0.0F);
        this.setRotateAngle(rLowerTailFin, 0.36425021489121656F, 0.0F, 0.5462880558742251F);
        this.tailFinFlap = new ModelPart(this, 38, 20);
        this.tailFinFlap.setPos(0.0F, -1.0F, 2.0F);
        this.tailFinFlap.addBox(0.0F, -14.0F, 0.0F, 0, 15, 5, 0.0F);
        this.rFin02 = new ModelPart(this, 14, 189);
        this.rFin02.setPos(0.0F, 2.7F, 1.0F);
        this.rFin02.addBox(0.0F, 0.0F, -1.0F, 1, 3, 4, 0.0F);
        this.setRotateAngle(rFin02, 0.136659280431156F, 0.0F, 0.0F);
        this.teethLower = new ModelPart(this, 0, 171);
        this.teethLower.setPos(-2.0F, -1.8F, -3.0F);
        this.teethLower.addBox(0.0F, -1.0F, 0.0F, 4, 2, 5, 0.0F);
        this.body = new ModelPart(this, 0, 0);
        this.body.setPos(0.0F, 13.0F, 3.0F);
        this.body.addBox(-4.5F, -5.5F, -14.0F, 9, 9, 14, 0.0F);
        this.setRotateAngle(body, 0.022863813201125717F, 0.0F, 0.0F);
        this.head = new ModelPart(this, 0, 124);
        this.head.setPos(0.0F, 0.3F, -8.6F);
        this.head.addBox(-3.5F, -3.0F, -4.2F, 7, 3, 4, 0.0F);
        this.setRotateAngle(head, -0.136659280431156F, 0.0F, 0.0F);
        this.snout = new ModelPart(this, 0, 135);
        this.snout.setPos(0.0F, -3.9F, -5.8F);
        this.snout.addBox(-2.5F, 0.0F, 0.0F, 5, 4, 5, 0.0F);
        this.setRotateAngle(snout, 0.36425021489121656F, 0.0F, 0.0F);
        this.nose = new ModelPart(this, 40, 28);
        this.nose.setPos(0.0F, -1.0F, -4.0F);
        this.nose.addBox(-2.0F, -1.0F, -13.0F, 4, 2, 14, 0.0F);
        this.tail05 = new ModelPart(this, 25, 50);
        this.tail05.setPos(0.0F, 0.0F, 3.4F);
        this.tail05.addBox(-0.5F, -1.5F, 0.0F, 1, 3, 4, 0.0F);
        this.dorsalFin00 = new ModelPart(this, 26, 124);
        this.dorsalFin00.setPos(0.5F, -7.6F, -6.7F);
        this.dorsalFin00.addBox(-1.5F, -0.4F, 0.0F, 2, 3, 6, 0.0F);
        this.setRotateAngle(dorsalFin00, -0.40980330836826856F, 0.0F, 0.0F);
        this.tailFinUpper00 = new ModelPart(this, 25, 61);
        this.tailFinUpper00.setPos(0.0F, 0.0F, 2.5F);
        this.tailFinUpper00.addBox(-0.51F, -7.0F, -1.5F, 1, 7, 4, 0.0F);
        this.setRotateAngle(tailFinUpper00, -1.0016444577195458F, 0.0F, 0.0F);
        this.rFin01 = new ModelPart(this, 0, 189);
        this.rFin01.setPos(-0.5F, 3.9F, 0.0F);
        this.rFin01.addBox(0.0F, 0.0F, 0.0F, 1, 3, 5, 0.0F);
        this.setRotateAngle(rFin01, 0.22759093446006054F, 0.0F, 0.0F);
        this.lFin02 = new ModelPart(this, 14, 189);
        this.lFin02.mirror = true;
        this.lFin02.setPos(0.0F, 2.7F, 1.0F);
        this.lFin02.addBox(0.0F, 0.0F, -1.0F, 1, 3, 4, 0.0F);
        this.setRotateAngle(lFin02, 0.136659280431156F, 0.0F, 0.0F);
        this.tail02 = new ModelPart(this, 0, 65);
        this.tail02.setPos(0.0F, 0.1F, 5.3F);
        this.tail02.addBox(-2.0F, -3.0F, 0.0F, 4, 5, 6, 0.0F);
        this.setRotateAngle(tail02, -1.7453292519943296E-4F, 0.0F, 0.0F);
        this.dorsalFin02 = new ModelPart(this, 26, 144);
        this.dorsalFin02.setPos(-1.0F, 0.2F, 0.2F);
        this.dorsalFin02.addBox(0.0F, -2.2F, 0.1F, 1, 2, 4, 0.0F);
        this.setRotateAngle(dorsalFin02, -0.08726646259971647F, 0.0F, 0.0F);
        this.lowerJaw = new ModelPart(this, 0, 147);
        this.lowerJaw.setPos(0.0F, 1.2F, -8.4F);
        this.lowerJaw.addBox(-3.0F, -1.0F, -4.0F, 6, 2, 4, 0.0F);
        this.setRotateAngle(lowerJaw, -0.136659280431156F, 0.0F, 0.0F);
        this.neck = new ModelPart(this, 0, 103);
        this.neck.setPos(0.0F, 0.0F, -13.6F);
        this.neck.addBox(-4.0F, -5.5F, -9.0F, 8, 8, 9, 0.0F);
        this.setRotateAngle(neck, 0.045553093477052F, 0.0F, 0.0F);
        this.mLowerTailFin = new ModelPart(this, 22, 179);
        this.mLowerTailFin.setPos(-0.5F, 1.7F, 0.6F);
        this.mLowerTailFin.addBox(0.0F, 0.0F, 0.0F, 1, 3, 4, 0.0F);
        this.setRotateAngle(mLowerTailFin, 0.27314402793711257F, 0.0F, 0.0F);
        this.teethUpper = new ModelPart(this, 0, 157);
        this.teethUpper.setPos(-2.5F, -0.2F, -3.4F);
        this.teethUpper.addBox(0.0F, 0.0F, 0.0F, 5, 2, 6, 0.0F);
        this.tail00 = new ModelPart(this, 0, 27);
        this.tail00.setPos(0.0F, -1.0F, -0.7F);
        this.tail00.addBox(-3.5F, -4.5F, 0.0F, 7, 8, 11, 0.0F);
        this.setRotateAngle(tail00, -0.05969026041820607F, 0.0F, 0.0F);
        this.dorsalFin01 = new ModelPart(this, 26, 134);
        this.dorsalFin01.setPos(0.0F, -2.1F, 0.4F);
        this.dorsalFin01.addBox(-1.0F, 0.0F, 0.0F, 1, 2, 5, 0.0F);
        this.setRotateAngle(dorsalFin01, -0.136659280431156F, 0.0F, 0.0F);
        this.rFin00 = new ModelPart(this, 0, 178);
        this.rFin00.setPos(-3.6F, 2.0F, -13.9F);
        this.rFin00.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 6, 0.0F);
        this.setRotateAngle(rFin00, 0.18203784098300857F, 0.0F, 0.7740535232594852F);
        this.lFin00 = new ModelPart(this, 0, 178);
        this.lFin00.mirror = true;
        this.lFin00.setPos(3.6F, 2.0F, -13.9F);
        this.lFin00.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 6, 0.0F);
        this.setRotateAngle(lFin00, 0.18203784098300857F, 0.0F, -0.7740535232594852F);
        this.tail03 = new ModelPart(this, 0, 78);
        this.tail03.setPos(0.0F, -1.0F, 5.7F);
        this.tail03.addBox(-1.5F, -2.0F, 0.0F, 3, 4, 5, 0.0F);
        this.tail01 = new ModelPart(this, 0, 50);
        this.tail01.setPos(0.0F, -1.4F, 10.4F);
        this.tail01.addBox(-2.5F, -3.0F, 0.0F, 5, 7, 6, 0.0F);
        this.setRotateAngle(tail01, -0.04363323129985824F, 0.0F, 0.0F);
        this.tailFinUpper01.addChild(this.tailFinUpper02);
        this.tail03.addChild(this.tail04);
        this.lFin00.addChild(this.lFin01);
        this.nose.addChild(this.nose2);
        this.tail02.addChild(this.upperTailFin);
        this.tailFinUpper00.addChild(this.tailFinUpper01);
        this.tail01.addChild(this.lLowerTailFin);
        this.tail01.addChild(this.rLowerTailFin);
        this.tailFinUpper00.addChild(this.tailFinFlap);
        this.rFin01.addChild(this.rFin02);
        this.lowerJaw.addChild(this.teethLower);
        this.neck.addChild(this.head);
        this.head.addChild(this.snout);
        this.head.addChild(this.nose);
        this.tail04.addChild(this.tail05);
        this.body.addChild(this.dorsalFin00);
        this.tail05.addChild(this.tailFinUpper00);
        this.rFin00.addChild(this.rFin01);
        this.lFin01.addChild(this.lFin02);
        this.tail01.addChild(this.tail02);
        this.dorsalFin01.addChild(this.dorsalFin02);
        this.neck.addChild(this.lowerJaw);
        this.body.addChild(this.neck);
        this.tail03.addChild(this.mLowerTailFin);
        this.head.addChild(this.teethUpper);
        this.body.addChild(this.tail00);
        this.dorsalFin00.addChild(this.dorsalFin01);
        this.body.addChild(this.rFin00);
        this.body.addChild(this.lFin00);
        this.tail02.addChild(this.tail03);
        this.tail00.addChild(this.tail01);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(EntityShark entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        ModelBullShark.animate(entity, ageInTicks, body, tail00, tail01, tail02, lowerJaw);
        if (entity.getPassengers().size() == 0) {
            lowerJaw.xRot = 0.7285004297824331F;
        } else {
            lowerJaw.xRot = -0.136659280431156F;
        }
    }

    public void setRotateAngle(ModelPart ModelRenderer, float x, float y, float z) {
        ModelRenderer.xRot = x;
        ModelRenderer.yRot = y;
        ModelRenderer.zRot = z;
    }
}
