package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import dev.itsmeow.betteranimalsplus.common.entity.EntityCoyote;
import dev.itsmeow.betteranimalsplus.common.entity.EntityFeralWolf;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;

public class ModelCoyote<T extends LivingEntity> extends ModelBAP<T> {

    public ModelPart body;
    public ModelPart stomach;
    public ModelPart tail01;
    public ModelPart tail02;
    public ModelPart tail03;
    public ModelPart tail04;
    public ModelPart lHindLeg01;
    public ModelPart lHindLeg02;
    public ModelPart lHindLeg03;
    public ModelPart lHindPaw;
    public ModelPart rHindLeg01;
    public ModelPart rHindLeg02;
    public ModelPart rHindLeg03;
    public ModelPart rHindPaw;
    public ModelPart neck;
    public ModelPart neckFur03_r1;
    public ModelPart neckFur02_r1;
    public ModelPart neckFur01_r1;
    public ModelPart head;
    public ModelPart rCheekFur_r1;
    public ModelPart lCheekFur_r1;
    public ModelPart muzzle;
    public ModelPart mUpperFang_r1;
    public ModelPart rUpperFang_r1;
    public ModelPart lUpperFang_r1;
    public ModelPart rLip_r1;
    public ModelPart lLip_r1;
    public ModelPart lowerJaw;
    public ModelPart lEar01;
    public ModelPart lEar02;
    public ModelPart cube_r1;
    public ModelPart rEar01;
    public ModelPart rEar02;
    public ModelPart cube_r2;
    public ModelPart lArm01;
    public ModelPart cube_r3;
    public ModelPart lArm02;
    public ModelPart cube_r4;
    public ModelPart lForePaw;
    public ModelPart rArm01;
    public ModelPart cube_r5;
    public ModelPart rArm02;
    public ModelPart cube_r6;
    public ModelPart rForePaw;

    public ModelCoyote() {
        texWidth = 64;
        texHeight = 64;

        body = new ModelPart(this);
        body.setPos(0.0F, 13.25F, -2.0F);
        body.texOffs(0, 0).addBox(-3.0F, -2.5F, -5.0F, 6.0F, 6.0F, 8.0F, 0.0F, false);

        stomach = new ModelPart(this);
        stomach.setPos(0.0F, -0.25F, 3.0F);
        body.addChild(stomach);
        stomach.texOffs(0, 14).addBox(-2.5F, -2.0F, -0.5F, 5.0F, 5.0F, 7.0F, 0.0F, false);

        tail01 = new ModelPart(this);
        tail01.setPos(0.0F, -0.7F, 5.25F);
        stomach.addChild(tail01);
        this.setRotateAngle(tail01, 0.6981F, 0.0F, 0.0F);
        tail01.texOffs(0, 27).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 3.0F, 3.0F, 0.0F, false);

        tail02 = new ModelPart(this);
        tail02.setPos(0.0F, 2.5F, 0.25F);
        tail01.addChild(tail02);
        this.setRotateAngle(tail02, -0.3142F, 0.0F, 0.0F);
        tail02.texOffs(0, 34).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, 0.1F, false);

        tail03 = new ModelPart(this);
        tail03.setPos(0.0F, 4.75F, -0.4F);
        tail02.addChild(tail03);
        this.setRotateAngle(tail03, 0.2269F, 0.0F, 0.0F);
        tail03.texOffs(12, 27).addBox(-1.5F, 0.2F, -1.5F, 3.0F, 3.0F, 3.0F, -0.2F, false);

        tail04 = new ModelPart(this);
        tail04.setPos(0.0F, 0.0F, 0.4F);
        tail03.addChild(tail04);
        this.setRotateAngle(tail04, 0.0698F, 0.0F, 0.0F);
        tail04.texOffs(13, 35).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        lHindLeg01 = new ModelPart(this);
        lHindLeg01.setPos(1.5F, 2.0F, 4.5F);
        stomach.addChild(lHindLeg01);
        this.setRotateAngle(lHindLeg01, -0.384F, -0.0436F, -0.096F);
        lHindLeg01.texOffs(28, 12).addBox(-0.95F, -3.2F, -2.95F, 3.0F, 7.0F, 4.0F, 0.0F, false);

        lHindLeg02 = new ModelPart(this);
        lHindLeg02.setPos(0.25F, 2.0F, -2.3F);
        lHindLeg01.addChild(lHindLeg02);
        this.setRotateAngle(lHindLeg02, -0.2618F, 0.0F, 0.0F);
        lHindLeg02.texOffs(28, 24).addBox(-0.75F, 0.4F, 0.0F, 2.0F, 2.0F, 5.0F, 0.0F, false);

        lHindLeg03 = new ModelPart(this);
        lHindLeg03.setPos(0.3F, 1.0F, 4.8F);
        lHindLeg02.addChild(lHindLeg03);
        this.setRotateAngle(lHindLeg03, 0.5236F, 0.0F, 0.096F);
        lHindLeg03.texOffs(29, 32).addBox(-1.0F, -0.4F, -1.5F, 2.0F, 5.0F, 2.0F, -0.1F, false);

        lHindPaw = new ModelPart(this);
        lHindPaw.setPos(-0.05F, 4.0F, -0.5F);
        lHindLeg03.addChild(lHindPaw);
        this.setRotateAngle(lHindPaw, 0.1222F, 0.0F, 0.0F);
        lHindPaw.texOffs(27, 40).addBox(-1.45F, -0.2F, -2.2F, 3.0F, 1.0F, 3.0F, 0.0F, false);

        rHindLeg01 = new ModelPart(this);
        rHindLeg01.setPos(-1.5F, 2.0F, 4.5F);
        stomach.addChild(rHindLeg01);
        this.setRotateAngle(rHindLeg01, -0.384F, 0.0436F, 0.096F);
        rHindLeg01.texOffs(28, 12).addBox(-2.05F, -3.2F, -2.95F, 3.0F, 7.0F, 4.0F, 0.0F, true);

        rHindLeg02 = new ModelPart(this);
        rHindLeg02.setPos(-0.25F, 2.0F, -2.3F);
        rHindLeg01.addChild(rHindLeg02);
        this.setRotateAngle(rHindLeg02, -0.2618F, 0.0F, 0.0F);
        rHindLeg02.texOffs(28, 24).addBox(-1.25F, 0.4F, 0.0F, 2.0F, 2.0F, 5.0F, 0.0F, true);

        rHindLeg03 = new ModelPart(this);
        rHindLeg03.setPos(-0.3F, 1.0F, 4.8F);
        rHindLeg02.addChild(rHindLeg03);
        this.setRotateAngle(rHindLeg03, 0.5236F, 0.0F, -0.096F);
        rHindLeg03.texOffs(29, 32).addBox(-1.0F, -0.4F, -1.5F, 2.0F, 5.0F, 2.0F, -0.1F, true);

        rHindPaw = new ModelPart(this);
        rHindPaw.setPos(0.05F, 4.0F, -0.5F);
        rHindLeg03.addChild(rHindPaw);
        this.setRotateAngle(rHindPaw, 0.1222F, 0.0F, 0.0F);
        rHindPaw.texOffs(27, 40).addBox(-1.55F, -0.2F, -2.2F, 3.0F, 1.0F, 3.0F, 0.0F, true);

        neck = new ModelPart(this);
        neck.setPos(-0.5F, -1.0F, -5.0F);
        body.addChild(neck);
        this.setRotateAngle(neck, -0.1309F, 0.0F, 0.0F);
        neck.texOffs(29, 0).addBox(-1.5F, -1.65F, -4.5F, 4.0F, 5.0F, 6.0F, 0.0F, false);

        neckFur03_r1 = new ModelPart(this);
        neckFur03_r1.setPos(0.0F, -1.75F, -1.0F);
        neck.addChild(neckFur03_r1);
        this.setRotateAngle(neckFur03_r1, 0.3491F, 0.0F, 0.0F);
        neckFur03_r1.texOffs(41, 49).addBox(-1.0F, -0.25F, -1.5F, 3.0F, 2.0F, 5.0F, 0.0F, false);

        neckFur02_r1 = new ModelPart(this);
        neckFur02_r1.setPos(0.0F, -1.75F, -1.0F);
        neck.addChild(neckFur02_r1);
        this.setRotateAngle(neckFur02_r1, 0.2182F, 0.0F, 0.0F);
        neckFur02_r1.texOffs(41, 41).addBox(-1.5F, -0.25F, -0.5F, 4.0F, 2.0F, 5.0F, -0.1F, false);

        neckFur01_r1 = new ModelPart(this);
        neckFur01_r1.setPos(0.0F, 0.0F, 0.0F);
        neck.addChild(neckFur01_r1);
        this.setRotateAngle(neckFur01_r1, -0.2182F, 0.0F, 0.0F);
        neckFur01_r1.texOffs(42, 32).addBox(-1.5F, 2.5F, -4.0F, 4.0F, 2.0F, 6.0F, -0.1F, false);

        head = new ModelPart(this);
        head.setPos(0.0F, 0.25F, -4.0F);
        neck.addChild(head);
        this.setRotateAngle(head, 0.1309F, 0.0F, 0.0F);
        head.texOffs(0, 46).addBox(-2.0F, -2.25F, -2.0F, 5.0F, 5.0F, 4.0F, -0.1F, false);

        rCheekFur_r1 = new ModelPart(this);
        rCheekFur_r1.setPos(-2.0F, 0.0F, 0.0F);
        head.addChild(rCheekFur_r1);
        this.setRotateAngle(rCheekFur_r1, 0.0F, 0.3927F, -0.4363F);
        rCheekFur_r1.texOffs(0, 56).addBox(-3.25F, -0.75F, 0.0F, 4.0F, 4.0F, 0.0F, 0.0F, true);

        lCheekFur_r1 = new ModelPart(this);
        lCheekFur_r1.setPos(3.0F, 0.0F, 0.0F);
        head.addChild(lCheekFur_r1);
        this.setRotateAngle(lCheekFur_r1, 0.0F, -0.3927F, 0.4363F);
        lCheekFur_r1.texOffs(0, 56).addBox(-0.75F, -0.75F, 0.0F, 4.0F, 4.0F, 0.0F, 0.0F, false);

        muzzle = new ModelPart(this);
        muzzle.setPos(0.5F, 0.25F, -2.0F);
        head.addChild(muzzle);
        this.setRotateAngle(muzzle, 0.1745F, 0.0F, 0.0F);
        muzzle.texOffs(19, 49).addBox(-1.0F, -0.5F, -2.5F, 2.0F, 1.0F, 3.0F, 0.0F, false);

        mUpperFang_r1 = new ModelPart(this);
        mUpperFang_r1.setPos(-0.5F, 1.0F, -2.25F);
        muzzle.addChild(mUpperFang_r1);
        this.setRotateAngle(mUpperFang_r1, -0.0873F, 0.0F, 0.0F);
        mUpperFang_r1.texOffs(13, 56).addBox(-0.5F, -0.5F, 0.05F, 2.0F, 1.0F, 0.0F, -0.1F, true);

        rUpperFang_r1 = new ModelPart(this);
        rUpperFang_r1.setPos(-0.5F, 1.0F, -2.25F);
        muzzle.addChild(rUpperFang_r1);
        this.setRotateAngle(rUpperFang_r1, 0.0F, 1.5708F, 0.0F);
        rUpperFang_r1.texOffs(9, 56).addBox(-0.5F, -0.25F, 0.0F, 1.0F, 1.0F, 0.0F, -0.1F, true);

        lUpperFang_r1 = new ModelPart(this);
        lUpperFang_r1.setPos(0.5F, 1.0F, -2.25F);
        muzzle.addChild(lUpperFang_r1);
        this.setRotateAngle(lUpperFang_r1, 0.0F, -1.5708F, 0.0F);
        lUpperFang_r1.texOffs(9, 56).addBox(-0.5F, -0.25F, 0.0F, 1.0F, 1.0F, 0.0F, -0.1F, false);

        rLip_r1 = new ModelPart(this);
        rLip_r1.setPos(0.0F, 0.0F, 0.0F);
        muzzle.addChild(rLip_r1);
        this.setRotateAngle(rLip_r1, -0.1309F, -0.1745F, 0.0F);
        rLip_r1.texOffs(5, 59).addBox(-1.4F, 0.25F, -2.35F, 1.0F, 1.0F, 4.0F, 0.0F, true);

        lLip_r1 = new ModelPart(this);
        lLip_r1.setPos(0.0F, 0.0F, 0.0F);
        muzzle.addChild(lLip_r1);
        this.setRotateAngle(lLip_r1, -0.1309F, 0.1745F, 0.0F);
        lLip_r1.texOffs(5, 59).addBox(0.4F, 0.25F, -2.35F, 1.0F, 1.0F, 4.0F, 0.0F, false);

        lowerJaw = new ModelPart(this);
        lowerJaw.setPos(0.5F, 1.25F, -2.0F);
        head.addChild(lowerJaw);
        lowerJaw.texOffs(19, 59).addBox(-1.0F, 0.0F, -2.5F, 2.0F, 1.0F, 3.0F, -0.2F, false);
        lowerJaw.texOffs(9, 56).addBox(-0.1F, -0.5F, -2.0F, 1.0F, 1.0F, 0.0F, -0.2F, false);
        lowerJaw.texOffs(9, 56).addBox(-0.9F, -0.5F, -2.0F, 1.0F, 1.0F, 0.0F, -0.2F, true);

        lEar01 = new ModelPart(this);
        lEar01.setPos(2.25F, -1.5F, 0.0F);
        head.addChild(lEar01);
        this.setRotateAngle(lEar01, 0.0F, -0.0873F, 0.2182F);
        lEar01.texOffs(31, 50).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

        lEar02 = new ModelPart(this);
        lEar02.setPos(0.0F, 0.0F, -0.75F);
        lEar01.addChild(lEar02);
        this.setRotateAngle(lEar02, 0.1745F, 0.0F, 0.0F);


        cube_r1 = new ModelPart(this);
        cube_r1.setPos(0.0F, 0.0F, 0.0F);
        lEar02.addChild(cube_r1);
        this.setRotateAngle(cube_r1, 0.0F, -0.829F, 0.0F);
        cube_r1.texOffs(31, 54).addBox(-0.25F, -3.5F, -0.25F, 2.0F, 4.0F, 2.0F, -0.1F, false);

        rEar01 = new ModelPart(this);
        rEar01.setPos(-1.25F, -1.5F, 0.0F);
        head.addChild(rEar01);
        this.setRotateAngle(rEar01, 0.0F, 0.0873F, -0.2182F);
        rEar01.texOffs(31, 50).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F, true);

        rEar02 = new ModelPart(this);
        rEar02.setPos(0.0F, 0.0F, -0.75F);
        rEar01.addChild(rEar02);
        this.setRotateAngle(rEar02, 0.2182F, 0.0F, 0.0F);


        cube_r2 = new ModelPart(this);
        cube_r2.setPos(0.0F, 0.0F, 0.0F);
        rEar02.addChild(cube_r2);
        this.setRotateAngle(cube_r2, 0.0F, 0.829F, 0.0F);
        cube_r2.texOffs(31, 54).addBox(-1.75F, -3.5F, -0.25F, 2.0F, 4.0F, 2.0F, -0.1F, true);

        lArm01 = new ModelPart(this);
        lArm01.setPos(3.0F, 0.0F, -2.0F);
        body.addChild(lArm01);


        cube_r3 = new ModelPart(this);
        cube_r3.setPos(0.0F, 0.0F, 0.0F);
        lArm01.addChild(cube_r3);
        this.setRotateAngle(cube_r3, 0.1309F, 0.0F, 0.0F);
        cube_r3.texOffs(46, 12).addBox(-1.5F, -1.5F, -2.0F, 3.0F, 6.0F, 3.0F, 0.0F, false);

        lArm02 = new ModelPart(this);
        lArm02.setPos(0.0F, 4.5F, 0.0F);
        lArm01.addChild(lArm02);


        cube_r4 = new ModelPart(this);
        cube_r4.setPos(0.0F, 0.0F, 0.0F);
        lArm02.addChild(cube_r4);
        this.setRotateAngle(cube_r4, -0.0873F, 0.0F, 0.0F);
        cube_r4.texOffs(46, 22).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);

        lForePaw = new ModelPart(this);
        lForePaw.setPos(0.0F, 5.75F, -0.25F);
        lArm02.addChild(lForePaw);
        this.setRotateAngle(lForePaw, -0.0087F, 0.0F, 0.0F);
        lForePaw.texOffs(27, 40).addBox(-1.45F, -0.2F, -2.2F, 3.0F, 1.0F, 3.0F, 0.0F, false);

        rArm01 = new ModelPart(this);
        rArm01.setPos(-3.0F, 0.0F, -2.0F);
        body.addChild(rArm01);


        cube_r5 = new ModelPart(this);
        cube_r5.setPos(0.0F, 0.0F, 0.0F);
        rArm01.addChild(cube_r5);
        this.setRotateAngle(cube_r5, 0.1309F, 0.0F, 0.0F);
        cube_r5.texOffs(46, 12).addBox(-1.5F, -1.5F, -2.0F, 3.0F, 6.0F, 3.0F, 0.0F, true);

        rArm02 = new ModelPart(this);
        rArm02.setPos(0.0F, 4.5F, 0.0F);
        rArm01.addChild(rArm02);


        cube_r6 = new ModelPart(this);
        cube_r6.setPos(0.0F, 0.0F, 0.0F);
        rArm02.addChild(cube_r6);
        this.setRotateAngle(cube_r6, -0.0873F, 0.0F, 0.0F);
        cube_r6.texOffs(46, 22).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, true);

        rForePaw = new ModelPart(this);
        rForePaw.setPos(0.0F, 5.75F, -0.25F);
        rArm02.addChild(rForePaw);
        this.setRotateAngle(rForePaw, -0.0087F, 0.0F, 0.0F);
        rForePaw.texOffs(27, 40).addBox(-1.55F, -0.2F, -2.2F, 3.0F, 1.0F, 3.0F, 0.0F, true);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }

    @Override
    public void prepareMobModel(T entity, float limbSwing, float limbSwingAmount, float partialTickTime) {
        if (entity instanceof EntityFeralWolf) {
            EntityFeralWolf entityferalwolf = (EntityFeralWolf) entity;

        }
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float tailRot, float netHeadYaw, float headPitch) {
        this.quadriped(lHindLeg01, lArm01, rHindLeg01, rArm01, limbSwing * 0.8665F, limbSwingAmount * 0.9F);
        this.headPitch(head, headPitch);
        this.headYaw(head, netHeadYaw);
        this.rUpperFang_r1.visible = this.lUpperFang_r1.visible = true;
        this.lowerJaw.xRot = 0F;
        this.tail01.yRot = 0.0F;
        if (entity instanceof EntityCoyote) {
            EntityCoyote wolf = (EntityCoyote) entity;
            if (!wolf.isTame()) {
                this.tail01.yRot = 0.0F;
            } else {
                this.tail01.yRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
            }
            if (wolf.isInSittingPose()) {
                this.sitPose();
            } else {
                this.resetSitPose();
                if(wolf.isTame()) {
                    this.tail01.xRot = tailRot + 0.6981F;
                }
            }
            boolean hostile = !wolf.isTame() && (!wolf.isDaytime() || wolf.isHostileDaytime());
            this.rUpperFang_r1.visible = this.lUpperFang_r1.visible = hostile;
            this.lowerJaw.xRot = hostile ? rad(45F) : 0F;
        }
    }

    public void sitPose() {
        this.setRotateAngle(body, -0.7854F, 0.0F, 0.0F);
        this.setRotateAngle(lArm01, 0.5672F, 0.0F, 0.0F);
        this.setRotateAngle(lForePaw, 0.2094F, 0.0F, 0.0F);
        this.setRotateAngle(lHindLeg01, -0.8203F, -0.1745F, -0.5323F);
        this.setRotateAngle(lHindLeg02, 0.6981F, 0.0F, 0.0F);
        this.setRotateAngle(lHindLeg03, -0.3491F, 0.0F, 0.096F);
        this.setRotateAngle(lHindPaw, 1.5621F, 0.0F, 0.0F);
        this.setRotateAngle(neck, 0.5672F, 0.0F, 0.0F);
        this.setRotateAngle(rArm01, 0.5672F, 0.0F, 0.0F);
        this.setRotateAngle(rForePaw, 0.2094F, 0.0F, 0.0F);
        this.setRotateAngle(rHindLeg01, -0.8203F, 0.1745F, 0.5323F);
        this.setRotateAngle(rHindLeg02, 0.6981F, 0.0F, 0.0F);
        this.setRotateAngle(rHindLeg03, -0.3491F, 0.0F, -0.096F);
        this.setRotateAngle(rHindPaw, 1.5621F, 0.0F, 0.0F);
        this.setRotateAngle(stomach, -0.2618F, 0.0F, 0.0F);
        tail01.xRot = 2.6616F;
        head.xRot += rad(10F);
        body.setPos(0.0F, 15.5F, -2.0F);
        lForePaw.setPos(0.0F, 5.25F, -0.25F);
        rForePaw.setPos(0.0F, 5.25F, -0.25F);
        lHindPaw.setPos(-0.05F, 4.0F, -0.5F);
        rHindPaw.setPos(0.05F, 4.0F, -0.5F);
    }

    public void resetSitPose() {
        this.setRotateAngle(body, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lForePaw, -0.0087F, 0.0F, 0.0F);
        this.lHindLeg01.yRot = -0.0436F;
        this.lHindLeg01.zRot = -0.096F;
        this.setRotateAngle(lHindLeg02, -0.2618F, 0.0F, 0.0F);
        this.setRotateAngle(lHindLeg03, 0.5236F, 0.0F, 0.096F);
        this.setRotateAngle(lHindPaw, 0.1222F, 0.0F, 0.0F);
        this.setRotateAngle(neck, -0.1309F, 0.0F, 0.0F);
        this.setRotateAngle(rForePaw, -0.0087F, 0.0F, 0.0F);
        this.rHindLeg01.yRot = 0.0436F;
        this.rHindLeg01.zRot = 0.096F;
        this.setRotateAngle(rHindLeg02, -0.2618F, 0.0F, 0.0F);
        this.setRotateAngle(rHindLeg03, 0.5236F, 0.0F, -0.096F);
        this.setRotateAngle(rHindPaw, 0.1222F, 0.0F, 0.0F);
        this.setRotateAngle(stomach, 0.0F, 0.0F, 0.0F);
        tail01.xRot = 0.6981F;
        body.setPos(0.0F, 13.25F, -2.0F);
        lForePaw.setPos(0.0F, 5.75F, -0.25F);
        rForePaw.setPos(0.0F, 5.75F, -0.25F);
        lHindPaw.setPos(-0.05F, 4.0F, -0.5F);
        rHindPaw.setPos(0.05F, 4.0F, -0.5F);
    }

}
