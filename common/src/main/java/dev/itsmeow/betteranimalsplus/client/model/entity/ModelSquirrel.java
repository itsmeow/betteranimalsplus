package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import dev.itsmeow.betteranimalsplus.common.entity.EntitySquirrel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;

/**
 * squirrelV2 - Batman, Cybercat5555 Created using Tabula 5.1.0
 */
public class ModelSquirrel<T extends LivingEntity> extends ModelBAP<T> {

    public ModelPart chest;
    public ModelPart stomach;
    public ModelPart lArm01;
    public ModelPart rArm01;
    public ModelPart neck;
    public ModelPart lLeg01;
    public ModelPart rLeg01;
    public ModelPart tail01;
    public ModelPart lLeg02;
    public ModelPart lFoot;
    public ModelPart rLeg02;
    public ModelPart rFoot;
    public ModelPart tail02;
    public ModelPart tail01Fluff;
    public ModelPart tail03;
    public ModelPart tail02Fluff;
    public ModelPart tail04;
    public ModelPart lArm02a;
    public ModelPart lArm02b;
    public ModelPart lPaw;
    public ModelPart rArm02a;
    public ModelPart rArm02b;
    public ModelPart rPaw;
    public ModelPart head;
    public ModelPart upperJaw;
    public ModelPart lowerJaw;
    public ModelPart lEar;
    public ModelPart rEar;
    public ModelPart snout;
    public ModelPart lEarFloof;
    public ModelPart rEarFloof;

    public ModelSquirrel() {
        this.texWidth = 64;
        this.texHeight = 64;
        this.lFoot = new ModelPart(this, 50, 14);
        this.lFoot.setPos(0.2F, 4.0F, -0.1F);
        this.lFoot.addBox(-1.0F, -0.5F, -3.2F, 2, 1, 5, 0.0F);
        this.setRotateAngle(this.lFoot, -0.3490658503988659F, -0.17453292519943295F, 0.05235987755982988F);
        this.tail01Fluff = new ModelPart(this, 26, 37);
        this.tail01Fluff.setPos(0.0F, 0.0F, 0.0F);
        this.tail01Fluff.addBox(-1.0F, 0.5F, -2.9F, 2, 3, 5, 0.0F);
        this.setRotateAngle(this.tail01Fluff, -0.08726646259971647F, 0.0F, 0.0F);
        this.rLeg01 = new ModelPart(this, 46, 0);
        this.rLeg01.mirror = true;
        this.rLeg01.setPos(-1.6F, -0.4F, 3.7F);
        this.rLeg01.addBox(-2.7F, -0.9F, -2.5F, 3, 6, 4, 0.0F);
        this.setRotateAngle(this.rLeg01, -0.17453292519943295F, 0.0F, 0.0F);
        this.lArm01 = new ModelPart(this, 31, 0);
        this.lArm01.setPos(3.0F, 0.7F, -5.0F);
        this.lArm01.addBox(-1.0F, -1.6F, -1.0F, 2, 5, 3, 0.0F);
        this.setRotateAngle(this.lArm01, -0.20943951023931953F, 0.0F, 0.0F);
        this.rArm02b = new ModelPart(this, 31, 8);
        this.rArm02b.mirror = true;
        this.rArm02b.setPos(-1.2F, 0.0F, -1.0F);
        this.rArm02b.addBox(0.6F, 0.0F, 0.0F, 1, 4, 2, 0.0F);
        this.snout = new ModelPart(this, 29, 31);
        this.snout.setPos(0.0F, -0.4F, -2.0F);
        this.snout.addBox(-1.0F, -0.5F, 0.2F, 2, 1, 3, 0.0F);
        this.setRotateAngle(this.snout, 0.20943951023931953F, 0.0F, 0.0F);
        this.lEar = new ModelPart(this, 55, 21);
        this.lEar.setPos(1.5F, -1.5F, -0.5F);
        this.lEar.addBox(-0.5F, -2.0F, -1.0F, 1, 2, 2, 0.0F);
        this.setRotateAngle(this.lEar, -0.4363323129985824F, 0.4886921905584123F, 0.2617993877991494F);
        this.lowerJaw = new ModelPart(this, 40, 29);
        this.lowerJaw.setPos(0.0F, 1.3F, -2.8F);
        this.lowerJaw.addBox(-1.0F, -0.5F, -2.0F, 2, 1, 2, 0.0F);
        this.upperJaw = new ModelPart(this, 40, 21);
        this.upperJaw.setPos(0.0F, -0.2F, -3.5F);
        this.upperJaw.addBox(-1.5F, -0.9F, -1.8F, 3, 2, 3, 0.0F);
        this.setRotateAngle(this.upperJaw, 0.22689280275926282F, 0.0F, 0.0F);
        this.head = new ModelPart(this, 23, 23);
        this.head.setPos(0.0F, -0.2F, -1.8F);
        this.head.addBox(-2.0F, -2.0F, -3.0F, 4, 4, 3, 0.0F);
        this.setRotateAngle(this.head, 0.17453292519943295F, 0.0F, 0.0F);
        this.rEar = new ModelPart(this, 55, 21);
        this.rEar.mirror = true;
        this.rEar.setPos(-1.5F, -1.5F, -0.5F);
        this.rEar.addBox(-0.5F, -2.0F, -1.0F, 1, 2, 2, 0.0F);
        this.setRotateAngle(this.rEar, -0.4363323129985824F, -0.4886921905584123F, -0.2617993877991494F);
        this.stomach = new ModelPart(this, 0, 13);
        this.stomach.setPos(0.0F, 0.0F, -0.5F);
        this.stomach.addBox(-2.5F, -2.9F, -0.9F, 5, 6, 6, 0.0F);
        this.setRotateAngle(this.stomach, -0.2792526803190927F, 0.0F, 0.0F);
        this.rLeg02 = new ModelPart(this, 44, 11);
        this.rLeg02.mirror = true;
        this.rLeg02.setPos(-1.2F, 4.2F, -1.2F);
        this.rLeg02.addBox(-1.0F, 0.0F, -1.2F, 2, 4, 3, 0.0F);
        this.setRotateAngle(this.rLeg02, 0.6981317007977318F, 0.0F, 0.0F);
        this.tail02 = new ModelPart(this, 0, 40);
        this.tail02.setPos(0.0F, 0.0F, 1.0F);
        this.tail02.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 6, 0.0F);
        this.setRotateAngle(this.tail02, 1.0471975511965976F, 0.0F, 0.0F);
        this.lLeg01 = new ModelPart(this, 46, 0);
        this.lLeg01.setPos(1.6F, -0.4F, 3.7F);
        this.lLeg01.addBox(-0.3F, -0.9F, -2.5F, 3, 6, 4, 0.0F);
        this.setRotateAngle(this.lLeg01, -0.17453292519943295F, 0.0F, 0.0F);
        this.rArm02a = new ModelPart(this, 38, 8);
        this.rArm02a.mirror = true;
        this.rArm02a.setPos(0.41F, 3.1F, 0.5F);
        this.rArm02a.addBox(-1.3F, 0.0F, -1.0F, 1, 4, 2, 0.0F);
        this.setRotateAngle(this.rArm02a, -0.3141592653589793F, 0.0F, 0.0F);
        this.lArm02a = new ModelPart(this, 38, 8);
        this.lArm02a.setPos(0.39F, 3.1F, 0.5F);
        this.lArm02a.addBox(-0.4F, 0.0F, -1.0F, 1, 4, 2, 0.0F);
        this.setRotateAngle(this.lArm02a, -0.3141592653589793F, 0.0F, 0.0F);
        this.lPaw = new ModelPart(this, 30, 15);
        this.lPaw.setPos(-0.35F, 3.1F, 0.5F);
        this.lPaw.addBox(-1.0F, -0.3F, -3.2F, 2, 1, 4, 0.0F);
        this.setRotateAngle(this.lPaw, 0.41887902047863906F, 0.0F, 0.0F);
        this.lEarFloof = new ModelPart(this, 55, 23);
        this.lEarFloof.setPos(0.0F, -1.8F, 0.0F);
        this.lEarFloof.addBox(-0.2F, -3.0F, -1.5F, 0, 5, 3, 0.0F);
        this.chest = new ModelPart(this, 0, 0);
        this.chest.setPos(0.0F, 16.1F, 3.0F);
        this.chest.addBox(-3.0F, -2.9F, -7.5F, 6, 5, 8, 0.0F);
        this.setRotateAngle(this.chest, 0.10471975511965977F, 0.0F, 0.0F);
        this.lArm02b = new ModelPart(this, 31, 8);
        this.lArm02b.setPos(-1.2F, 0.0F, -1.0F);
        this.lArm02b.addBox(0.0F, 0.0F, 0.0F, 1, 4, 2, 0.0F);
        this.rEarFloof = new ModelPart(this, 55, 23);
        this.rEarFloof.mirror = true;
        this.rEarFloof.setPos(0.0F, -1.8F, 0.0F);
        this.rEarFloof.addBox(0.2F, -3.0F, -1.5F, 0, 5, 3, 0.0F);
        this.rFoot = new ModelPart(this, 50, 14);
        this.rFoot.mirror = true;
        this.rFoot.setPos(-0.2F, 4.0F, -0.1F);
        this.rFoot.addBox(-1.0F, -0.5F, -3.2F, 2, 1, 5, 0.0F);
        this.setRotateAngle(this.rFoot, -0.3490658503988659F, 0.17453292519943295F, -0.05235987755982988F);
        this.tail01 = new ModelPart(this, 0, 33);
        this.tail01.setPos(0.0F, -1.5F, 4.4F);
        this.tail01.addBox(-1.5F, -1.7F, -0.5F, 3, 3, 3, 0.0F);
        this.setRotateAngle(this.tail01, 1.0471975511965976F, 0.0F, 0.0F);
        this.tail04 = new ModelPart(this, 26, 49);
        this.tail04.setPos(0.0F, 0.0F, 5.0F);
        this.tail04.addBox(-2.51F, -2.1F, -0.6F, 5, 4, 8, 0.0F);
        this.setRotateAngle(this.tail04, -0.8726646259971648F, 0.0F, 0.0F);
        this.rArm01 = new ModelPart(this, 31, 0);
        this.rArm01.mirror = true;
        this.rArm01.setPos(-3.0F, 0.7F, -5.0F);
        this.rArm01.addBox(-1.0F, -1.6F, -1.0F, 2, 5, 3, 0.0F);
        this.setRotateAngle(this.rArm01, -0.20943951023931953F, 0.0F, 0.0F);
        this.rPaw = new ModelPart(this, 30, 15);
        this.rPaw.mirror = true;
        this.rPaw.setPos(-0.35F, 3.1F, 0.5F);
        this.rPaw.addBox(-1.0F, -0.3F, -3.2F, 2, 1, 4, 0.0F);
        this.setRotateAngle(this.rPaw, 0.41887902047863906F, 0.0F, 0.0F);
        this.tail03 = new ModelPart(this, 0, 50);
        this.tail03.setPos(0.0F, 0.0F, 5.4F);
        this.tail03.addBox(-2.5F, -1.9F, -0.8F, 5, 4, 7, 0.0F);
        this.setRotateAngle(this.tail03, 0.8726646259971648F, 0.0F, 0.0F);
        this.neck = new ModelPart(this, 0, 25);
        this.neck.setPos(0.0F, -0.8F, -6.9F);
        this.neck.addBox(-1.5F, -2.0F, -2.2F, 3, 4, 2, 0.0F);
        this.setRotateAngle(this.neck, -0.19198621771937624F, 0.0F, 0.0F);
        this.lLeg02 = new ModelPart(this, 44, 11);
        this.lLeg02.setPos(1.2F, 4.2F, -1.2F);
        this.lLeg02.addBox(-1.0F, 0.0F, -1.2F, 2, 4, 3, 0.0F);
        this.setRotateAngle(this.lLeg02, 0.6981317007977318F, 0.0F, 0.0F);
        this.tail02Fluff = new ModelPart(this, 41, 37);
        this.tail02Fluff.setPos(0.0F, 0.0F, 2.5F);
        this.tail02Fluff.addBox(-1.5F, 1.0F, -4.3F, 3, 3, 8, 0.0F);
        this.setRotateAngle(this.tail02Fluff, 0.19198621771937624F, 0.0F, 0.0F);
        this.lLeg02.addChild(this.lFoot);
        this.tail01.addChild(this.tail01Fluff);
        this.stomach.addChild(this.rLeg01);
        this.chest.addChild(this.lArm01);
        this.rArm02a.addChild(this.rArm02b);
        this.upperJaw.addChild(this.snout);
        this.head.addChild(this.lEar);
        this.head.addChild(this.lowerJaw);
        this.head.addChild(this.upperJaw);
        this.neck.addChild(this.head);
        this.head.addChild(this.rEar);
        this.chest.addChild(this.stomach);
        this.rLeg01.addChild(this.rLeg02);
        this.tail01.addChild(this.tail02);
        this.stomach.addChild(this.lLeg01);
        this.rArm01.addChild(this.rArm02a);
        this.lArm01.addChild(this.lArm02a);
        this.lArm02a.addChild(this.lPaw);
        this.lEar.addChild(this.lEarFloof);
        this.lArm02a.addChild(this.lArm02b);
        this.rEar.addChild(this.rEarFloof);
        this.rLeg02.addChild(this.rFoot);
        this.stomach.addChild(this.tail01);
        this.tail03.addChild(this.tail04);
        this.chest.addChild(this.rArm01);
        this.rArm02a.addChild(this.rPaw);
        this.tail02.addChild(this.tail03);
        this.chest.addChild(this.neck);
        this.lLeg01.addChild(this.lLeg02);
        this.tail02.addChild(this.tail02Fluff);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.chest.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.quadriped(lLeg01, lArm01, rLeg01, rArm01, limbSwing * 0.666F, limbSwingAmount * 1.4F);
        this.tail01.xRot = Mth.sin(limbSwing * 0.2F) * limbSwingAmount - rad(30F);
        this.headPitch(neck, headPitch, 1F, -13F);
        this.headYaw(neck, netHeadYaw, 0.5F, 0F);
        if (entityIn instanceof EntitySquirrel) {
            EntitySquirrel ent = (EntitySquirrel) entityIn;
            this.chest.xRot = ent.isBesideClimbableBlock() ? rad(-90F) : 0.10471975511965977F;
        }
    }

}
