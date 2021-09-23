package dev.itsmeow.betteranimalsplus.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.common.entity.EntityCoyote;
import dev.itsmeow.betteranimalsplus.common.entity.EntityFeralWolf;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;

/**
 * newwolf - cybercat5555 Created using Tabula 5.1.0
 */
public class ModelCoyote<T extends LivingEntity> extends ModelBetterAnimals<T> {
    public ModelPart chest;
    public ModelPart lArm01;
    public ModelPart body;
    public ModelPart neck;
    public ModelPart mane01;
    public ModelPart mane02;
    public ModelPart mane03;
    public ModelPart rArm01;
    public ModelPart lArm01_1;
    public ModelPart lForepaw;
    public ModelPart lHindLeg01;
    public ModelPart tail01;
    public ModelPart rHindLeg01;
    public ModelPart lHindLeg02;
    public ModelPart lHindLeg03;
    public ModelPart lHindpaw;
    public ModelPart tail02;
    public ModelPart tail03;
    public ModelPart rHindLeg02;
    public ModelPart rHindLeg03;
    public ModelPart rHindpaw;
    public ModelPart head;
    public ModelPart mane04;
    public ModelPart muzzleUpper;
    public ModelPart muzzleLower;
    public ModelPart snout;
    public ModelPart lEar01;
    public ModelPart rEar01;
    public ModelPart lEar02;
    public ModelPart lEar03;
    public ModelPart rEar02;
    public ModelPart rEar03;
    public ModelPart rArm01_1;
    public ModelPart rForepaw;

    public ModelCoyote() {
        this.texWidth = 64;
        this.texHeight = 64;
        this.rEar02 = new ModelPart(this, 0, 0);
        this.rEar02.mirror = true;
        this.rEar02.setPos(0.0F, 0.0F, 0.0F);
        this.rEar02.addBox(-0.5F, -3.2F, 0.0F, 1, 1, 1, 0.0F);
        this.rHindLeg01 = new ModelPart(this, 27, 11);
        this.rHindLeg01.mirror = true;
        this.rHindLeg01.setPos(-1.0F, -0.2F, 4.8F);
        this.rHindLeg01.addBox(-3.0F, -1.9F, -2.0F, 3, 6, 4, 0.0F);
        this.setRotateAngle(this.rHindLeg01, -0.22759093446006054F, 0.0F, 0.0F);
        this.head = new ModelPart(this, 45, 24);
        this.head.setPos(0.0F, -1.1F, -3.2F);
        this.head.addBox(-2.5F, -2.0F, -3.5F, 5, 5, 4, 0.0F);
        this.setRotateAngle(this.head, 0.18203784098300857F, 0.0F, 0.0F);
        this.lHindLeg01 = new ModelPart(this, 27, 11);
        this.lHindLeg01.setPos(1.0F, -0.2F, 4.8F);
        this.lHindLeg01.addBox(0.0F, -1.9F, -2.0F, 3, 6, 4, 0.0F);
        this.setRotateAngle(this.lHindLeg01, -0.22759093446006054F, 0.0F, 0.0F);
        this.muzzleLower = new ModelPart(this, 14, 55);
        this.muzzleLower.setPos(0.0F, 2.5F, -3.3F);
        this.muzzleLower.addBox(-1.5F, -0.5F, -2.9F, 3, 1, 3, 0.0F);
        this.rForepaw = new ModelPart(this, 52, 0);
        this.rForepaw.mirror = true;
        this.rForepaw.setPos(-0.0F, 7.7F, 0.0F);
        this.rForepaw.addBox(-1.5F, -0.9F, -2.3F, 3, 2, 3, 0.0F);
        this.lHindLeg03 = new ModelPart(this, 55, 11);
        this.lHindLeg03.setPos(0.1F, 3.2F, 0.6F);
        this.lHindLeg03.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(this.lHindLeg03, -0.6373942428283291F, 0.0F, 0.0F);
        this.rEar01 = new ModelPart(this, 0, 4);
        this.rEar01.mirror = true;
        this.rEar01.setPos(-1.7F, -1.0F, -2.5F);
        this.rEar01.addBox(-1.0F, -2.2F, 0.0F, 2, 2, 1, 0.0F);
        this.setRotateAngle(this.rEar01, 0.18203784098300857F, 0.35168384427685734F, -0.18203784098300857F);
        this.mane01 = new ModelPart(this, 16, 34);
        this.mane01.setPos(0.0F, -2.3F, -6.6F);
        this.mane01.addBox(-3.0F, -1.0F, 0.0F, 6, 2, 6, 0.0F);
        this.setRotateAngle(this.mane01, 0.27314402793711257F, 0.0F, 0.0F);
        this.muzzleUpper = new ModelPart(this, 0, 55);
        this.muzzleUpper.setPos(0.0F, 1.7F, -3.3F);
        this.muzzleUpper.addBox(-1.5F, -0.7F, -3.0F, 3, 1, 3, 0.0F);
        this.rEar03 = new ModelPart(this, 21, 0);
        this.rEar03.mirror = true;
        this.rEar03.setPos(0.0F, -0.1F, 1.3F);
        this.rEar03.addBox(-0.5F, -2.6F, -0.4F, 1, 3, 1, 0.0F);
        this.setRotateAngle(this.rEar03, 0.27314402793711257F, 0.0F, 0.0F);
        this.rArm01_1 = new ModelPart(this, 44, 0);
        this.rArm01_1.mirror = true;
        this.rArm01_1.setPos(0.2F, 2.4F, 0.1F);
        this.rArm01_1.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.setRotateAngle(this.rArm01_1, -0.22759093446006054F, 0.0F, -0.091106186954104F);
        this.snout = new ModelPart(this, 28, 55);
        this.snout.setPos(0.0F, 0.7F, -3.3F);
        this.snout.addBox(-1.0F, -0.7F, -3.1F, 2, 1, 3, 0.0F);
        this.setRotateAngle(this.snout, 0.136659280431156F, 0.0F, 0.0F);
        this.lEar02 = new ModelPart(this, 0, 0);
        this.lEar02.setPos(0.0F, 0.0F, 0.0F);
        this.lEar02.addBox(-0.5F, -3.2F, 0.0F, 1, 1, 1, 0.0F);
        this.rHindpaw = new ModelPart(this, 52, 0);
        this.rHindpaw.mirror = true;
        this.rHindpaw.setPos(0.0F, 5.7F, 0.0F);
        this.rHindpaw.addBox(-1.5F, -0.9F, -2.3F, 3, 2, 3, 0.0F);
        this.mane04 = new ModelPart(this, 41, 44);
        this.mane04.setPos(0.0F, 1.8F, -1.6F);
        this.mane04.addBox(-1.5F, -0.3F, -1.6F, 3, 2, 5, 0.0F);
        this.setRotateAngle(this.mane04, -0.6373942428283291F, 0.0F, 0.0F);
        this.chest = new ModelPart(this, 0, 0);
        this.chest.setPos(0.0F, 12.8F, -0.8F);
        this.chest.addBox(-3.0F, -3.0F, -6.8F, 6, 6, 8, 0.0F);
        this.neck = new ModelPart(this, 27, 23);
        this.neck.setPos(0.0F, -0.7F, -5.6F);
        this.neck.addBox(-2.0F, -2.5F, -4.0F, 4, 5, 4, 0.0F);
        this.setRotateAngle(this.neck, -0.18203784098300857F, 0.0F, 0.0F);
        this.lEar01 = new ModelPart(this, 0, 4);
        this.lEar01.setPos(1.7F, -1.0F, -2.5F);
        this.lEar01.addBox(-1.0F, -2.2F, 0.0F, 2, 2, 1, 0.0F);
        this.setRotateAngle(this.lEar01, 0.18203784098300857F, -0.35168384427685734F, 0.18203784098300857F);
        this.tail02 = new ModelPart(this, 0, 36);
        this.tail02.setPos(0.0F, 0.2F, 1.8F);
        this.tail02.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 4, 0.0F);
        this.setRotateAngle(this.tail02, -0.4553564018453205F, 0.0F, 0.0F);
        this.rHindLeg03 = new ModelPart(this, 55, 11);
        this.rHindLeg03.mirror = true;
        this.rHindLeg03.setPos(-0.1F, 3.2F, 0.6F);
        this.rHindLeg03.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(this.rHindLeg03, -0.6373942428283291F, 0.0F, 0.0F);
        this.body = new ModelPart(this, 0, 16);
        this.body.setPos(0.0F, -0.2F, 1.0F);
        this.body.addBox(-2.5F, -2.5F, -0.2F, 5, 5, 7, 0.0F);
        this.setRotateAngle(this.body, -0.045553093477052F, 0.0F, 0.0F);
        this.lEar03 = new ModelPart(this, 21, 0);
        this.lEar03.setPos(0.0F, -0.1F, 1.3F);
        this.lEar03.addBox(-0.5F, -2.6F, -0.4F, 1, 3, 1, 0.0F);
        this.setRotateAngle(this.lEar03, 0.27314402793711257F, 0.0F, 0.0F);
        this.lHindpaw = new ModelPart(this, 52, 0);
        this.lHindpaw.setPos(0.0F, 5.7F, 0.0F);
        this.lHindpaw.addBox(-1.5F, -0.9F, -2.3F, 3, 2, 3, 0.0F);
        this.rHindLeg02 = new ModelPart(this, 42, 11);
        this.rHindLeg02.mirror = true;
        this.rHindLeg02.setPos(-1.4F, 2.8F, -1.1F);
        this.rHindLeg02.addBox(-1.5F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
        this.setRotateAngle(this.rHindLeg02, 0.9105382707654417F, 0.0F, 0.0F);
        this.tail03 = new ModelPart(this, 0, 44);
        this.tail03.setPos(0.0F, 0.0F, 3.5F);
        this.tail03.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 6, 0.0F);
        this.setRotateAngle(this.tail03, -0.31869712141416456F, 0.0F, 0.0F);
        this.rArm01 = new ModelPart(this, 30, 0);
        this.rArm01.mirror = true;
        this.rArm01.setPos(-3.1F, 0.2F, -3.3F);
        this.rArm01.addBox(-1.0F, -2.4F, -1.5F, 3, 6, 3, 0.0F);
        this.setRotateAngle(this.rArm01, 0.22759093446006054F, 0.0F, 0.091106186954104F);
        this.mane03 = new ModelPart(this, 21, 44);
        this.mane03.setPos(0.0F, 0.7F, -5.7F);
        this.mane03.addBox(-2.0F, 0.1F, -1.6F, 4, 2, 5, 0.0F);
        this.setRotateAngle(this.mane03, -0.6829473363053812F, 0.0F, 0.0F);
        this.lForepaw = new ModelPart(this, 52, 0);
        this.lForepaw.setPos(-0.0F, 7.7F, 0.0F);
        this.lForepaw.addBox(-1.5F, -0.9F, -2.3F, 3, 2, 3, 0.0F);
        this.mane02 = new ModelPart(this, 41, 34);
        this.mane02.setPos(0.0F, -2.4F, -3.5F);
        this.mane02.addBox(-2.5F, -1.0F, 0.0F, 5, 2, 6, 0.0F);
        this.setRotateAngle(this.mane02, 0.136659280431156F, 0.0F, 0.0F);
        this.lArm01_1 = new ModelPart(this, 44, 0);
        this.lArm01_1.setPos(0.8F, 2.4F, 0.1F);
        this.lArm01_1.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.setRotateAngle(this.lArm01_1, -0.22759093446006054F, 0.0F, 0.091106186954104F);
        this.lHindLeg02 = new ModelPart(this, 42, 11);
        this.lHindLeg02.setPos(1.4F, 2.8F, -1.1F);
        this.lHindLeg02.addBox(-1.5F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
        this.setRotateAngle(this.lHindLeg02, 0.9105382707654417F, 0.0F, 0.0F);
        this.lArm01 = new ModelPart(this, 30, 0);
        this.lArm01.setPos(2.1F, 0.2F, -3.3F);
        this.lArm01.addBox(-1.0F, -2.4F, -1.5F, 3, 6, 3, 0.0F);
        this.setRotateAngle(this.lArm01, 0.22759093446006054F, 0.0F, -0.091106186954104F);
        this.tail01 = new ModelPart(this, 0, 30);
        this.tail01.setPos(0.0F, -1.5F, 6.4F);
        this.tail01.addBox(-1.0F, -1.0F, -0.5F, 2, 2, 3, 0.0F);
        this.setRotateAngle(this.tail01, -0.6829473363053812F, 0.0F, 0.0F);
        this.rEar01.addChild(this.rEar02);
        this.body.addChild(this.rHindLeg01);
        this.neck.addChild(this.head);
        this.body.addChild(this.lHindLeg01);
        this.head.addChild(this.muzzleLower);
        this.rArm01_1.addChild(this.rForepaw);
        this.lHindLeg02.addChild(this.lHindLeg03);
        this.head.addChild(this.rEar01);
        this.chest.addChild(this.mane01);
        this.head.addChild(this.muzzleUpper);
        this.rEar01.addChild(this.rEar03);
        this.rArm01.addChild(this.rArm01_1);
        this.head.addChild(this.snout);
        this.lEar01.addChild(this.lEar02);
        this.rHindLeg03.addChild(this.rHindpaw);
        this.neck.addChild(this.mane04);
        this.chest.addChild(this.neck);
        this.head.addChild(this.lEar01);
        this.tail01.addChild(this.tail02);
        this.rHindLeg02.addChild(this.rHindLeg03);
        this.chest.addChild(this.body);
        this.lEar01.addChild(this.lEar03);
        this.lHindLeg03.addChild(this.lHindpaw);
        this.rHindLeg01.addChild(this.rHindLeg02);
        this.tail02.addChild(this.tail03);
        this.chest.addChild(this.rArm01);
        this.chest.addChild(this.mane03);
        this.lArm01_1.addChild(this.lForepaw);
        this.chest.addChild(this.mane02);
        this.lArm01.addChild(this.lArm01_1);
        this.lHindLeg01.addChild(this.lHindLeg02);
        this.chest.addChild(this.lArm01);
        this.body.addChild(this.tail01);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.chest.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }

    @Override
    public void prepareMobModel(T entity, float limbSwing, float limbSwingAmount,
                                    float partialTickTime) {
        if (entity instanceof EntityFeralWolf) {
            EntityFeralWolf entityferalwolf = (EntityFeralWolf) entity;
            if (!entityferalwolf.isTame()) {
                this.tail01.yRot = 0.0F;
            } else {
                this.tail01.yRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
            }
        }
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float swingModifier = 0.9f;
        float newLimbSwing = limbSwing + getSwingProgressPrev(entity);
        this.lHindLeg01.xRot = Mth.cos(newLimbSwing * 0.8665F + (float) Math.PI) * swingModifier * limbSwingAmount - 0.22759093446006054F;
        this.rHindLeg01.xRot = Mth.cos(newLimbSwing * 0.8665F) * swingModifier * limbSwingAmount - 0.22759093446006054F;
        this.lArm01.xRot = Mth.cos(newLimbSwing * 0.8665F) * swingModifier * limbSwingAmount + 0.22759093446006054F;
        this.rArm01.xRot = Mth.cos(newLimbSwing * 0.8665F + (float) Math.PI) * swingModifier * limbSwingAmount + 0.22759093446006054F;
        this.neck.xRot = -0.6F;

        this.head.xRot = (float) Math.toRadians(getHeadPitch(entity)) + 0.6F;
        this.head.yRot = netHeadYaw * 0.017453292F;

        if (entity instanceof EntityCoyote) {
            EntityCoyote wolf = (EntityCoyote) entity;
            this.tail01.xRot = ageInTicks;
            if (wolf.isInSittingPose()) {
                ModelCoyote.setRotateAngle360(this.neck, 30, 0, 0);
                ModelCoyote.setRotateAngle360(this.chest, -40, 0, 0);
                ModelCoyote.setRotateAngle360(this.body, -40, 0, 0);
                ModelCoyote.setRotateAngle360(this.tail01, 90, 0, 0);
                ModelCoyote.setRotateAngle360(this.lArm01, 36, 0, -5);
                ModelCoyote.setRotateAngle360(this.lArm01_1, -26, 0, 5);
                ModelCoyote.setRotateAngle360(this.lForepaw, 28, 0, 0);
                ModelCoyote.setRotateAngle360(this.rArm01, 36, 0, 5);
                ModelCoyote.setRotateAngle360(this.rArm01_1, -26, 0, -5);
                ModelCoyote.setRotateAngle360(this.rForepaw, 28, 0, 0);
                ModelCoyote.setRotateAngle360(this.lHindLeg01, -13, 0, -16);
                this.setRotateAngle(this.lHindLeg02, 0.8996066167365371F, 0.0F, 0.0F);
                ModelCoyote.setRotateAngle360(this.lHindpaw, 90, 0, 0);
                ModelCoyote.setRotateAngle360(this.rHindLeg01, -13, 0, 16);
                this.setRotateAngle(this.rHindLeg02, 0.8996066167365371F, 0.0F, 0.0F);
                ModelCoyote.setRotateAngle360(this.rHindpaw, 90, 0, 0);
                this.head.xRot -= Math.toRadians(20);
                this.chest.setPos(0F, 16.8F, -0.8F);
            } else {
                this.setRotateAngle(this.rHindLeg02, 0.8196066167365371F, 0.0F, 0.0F);
                this.setRotateAngle(this.lHindLeg02, 0.8196066167365371F, 0.0F, 0.0F);
                this.lArm01.zRot = -0.091106186954104F;
                this.setRotateAngle(this.lArm01_1, -0.22759093446006054F, 0.0F, 0.091106186954104F);
                this.rArm01.zRot = 0.091106186954104F;
                this.setRotateAngle(this.rArm01_1, -0.22759093446006054F, 0.0F, -0.091106186954104F);
                this.lHindLeg01.zRot = 0;
                this.rHindLeg01.zRot = 0;
                this.setRotateAngle(this.rHindpaw, 0, 0, 0);
                this.setRotateAngle(this.lHindpaw, 0, 0, 0);
                this.body.xRot = -0.091106186954104F;
                this.setRotateAngle(this.chest, 0, 0, 0);
                this.setRotateAngle(this.lForepaw, 0, 0, 0);
                this.setRotateAngle(this.rForepaw, 0, 0, 0);
                this.chest.setPos(0F, 12.8F, -0.8F);
            }
        }

    }

    @Override
    public void setRotateAngle(ModelPart ModelRenderer, float x, float y, float z) {
        ModelRenderer.xRot = x;
        ModelRenderer.yRot = y;
        ModelRenderer.zRot = z;
    }

    public static void setRotateAngle360(ModelPart ModelRenderer, float x, float y, float z) {
        ModelRenderer.xRot = (float) Math.toRadians(x);
        ModelRenderer.yRot = (float) Math.toRadians(y);
        ModelRenderer.zRot = (float) Math.toRadians(z);
    }

}
