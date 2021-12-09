package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import dev.itsmeow.betteranimalsplus.common.entity.EntityTurkey;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;

public class ModelTurkey<T extends LivingEntity> extends ModelBAP<T> {

    public ModelPart root;
    public ModelPart body;
    public ModelPart lLeg01;
    public ModelPart lLeg02;
    public ModelPart lClaw01;
    public ModelPart lClaw02;
    public ModelPart lClaw03;
    public ModelPart lClaw04;
    public ModelPart box_r1;
    public ModelPart rLeg01;
    public ModelPart rLeg02;
    public ModelPart rClaw01;
    public ModelPart rClaw02;
    public ModelPart rClaw03;
    public ModelPart rClaw04;
    public ModelPart breast;
    public ModelPart neck;
    public ModelPart head;
    public ModelPart beak01;
    public ModelPart beak02;
    public ModelPart waddle;
    public ModelPart beard;
    public ModelPart tail01;
    public ModelPart lTailFeather01;
    public ModelPart rTailFeather01;
    public ModelPart lTailFeather02;
    public ModelPart rTailFeather02;
    public ModelPart lTailFeather03;
    public ModelPart rTailFeather03;
    public ModelPart lTailFeather04;
    public ModelPart rTailFeather04;
    public ModelPart lTailFeather05;
    public ModelPart rTailFeather05;
    public ModelPart tail02;
    public ModelPart hackles;
    public ModelPart lWing01;
    public ModelPart lWing02;
    public ModelPart lWingFeathers;
    public ModelPart rWing01;
    public ModelPart rWing02;
    public ModelPart rWingFeathers;

    public ModelTurkey() {
        texWidth = 64;
        texHeight = 64;

        root = new ModelPart(this);
        root.setPos(0.0F, 0.0F, 0.0F);


        body = new ModelPart(this);
        body.setPos(0.0F, 10.8F, 0.0F);
        root.addChild(body);
        body.texOffs(0, 0).addBox(-4.5F, -4.5F, -6.0F, 9.0F, 9.0F, 12.0F, 0.0F, false);

        lLeg01 = new ModelPart(this);
        lLeg01.setPos(2.6F, 4.5F, 1.5F);
        body.addChild(lLeg01);
        setRotationAngle(lLeg01, 0.2094F, 0.0F, 0.0F);
        lLeg01.texOffs(33, 0).addBox(-1.5F, -0.7F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, true);

        lLeg02 = new ModelPart(this);
        lLeg02.setPos(0.0F, 3.1F, 0.0F);
        lLeg01.addChild(lLeg02);
        setRotationAngle(lLeg02, -0.2094F, 0.0F, 0.0F);
        lLeg02.texOffs(46, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, true);

        lClaw01 = new ModelPart(this);
        lClaw01.setPos(0.0F, 5.3F, -1.1F);
        lLeg02.addChild(lClaw01);
        setRotationAngle(lClaw01, 0.2443F, 0.0F, 0.0F);
        lClaw01.texOffs(0, 0).addBox(-0.5F, 0.0F, -2.5F, 1.0F, 0.0F, 3.0F, 0.0F, true);

        lClaw02 = new ModelPart(this);
        lClaw02.setPos(0.5F, 4.9F, -0.7F);
        lLeg02.addChild(lClaw02);
        setRotationAngle(lClaw02, 0.1571F, -0.3491F, 0.0F);
        lClaw02.texOffs(0, 0).addBox(-0.5F, 0.5F, -2.5F, 1.0F, 0.0F, 3.0F, 0.0F, true);

        lClaw03 = new ModelPart(this);
        lClaw03.setPos(-0.5F, 4.9F, -0.7F);
        lLeg02.addChild(lClaw03);
        setRotationAngle(lClaw03, 0.1571F, 0.3491F, 0.0F);
        lClaw03.texOffs(0, 0).addBox(-0.5F, 0.5F, -2.5F, 1.0F, 0.0F, 3.0F, 0.0F, false);

        lClaw04 = new ModelPart(this);
        lClaw04.setPos(0.0F, 5.5F, 0.9F);
        lLeg02.addChild(lClaw04);


        box_r1 = new ModelPart(this);
        box_r1.setPos(-2.6F, 0.1F, -2.4F);
        lClaw04.addChild(box_r1);
        setRotationAngle(box_r1, -0.0436F, 0.0F, 0.0F);
        box_r1.texOffs(0, 7).addBox(2.1F, -0.1F, 1.9F, 1.0F, 0.0F, 3.0F, 0.0F, true);

        rLeg01 = new ModelPart(this);
        rLeg01.setPos(-2.6F, 4.5F, 1.5F);
        body.addChild(rLeg01);
        setRotationAngle(rLeg01, 0.2094F, 0.0F, 0.0F);
        rLeg01.texOffs(33, 0).addBox(-1.5F, -0.7F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);

        rLeg02 = new ModelPart(this);
        rLeg02.setPos(0.0F, 3.1F, 0.0F);
        rLeg01.addChild(rLeg02);
        setRotationAngle(rLeg02, -0.2094F, 0.0F, 0.0F);
        rLeg02.texOffs(46, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

        rClaw01 = new ModelPart(this);
        rClaw01.setPos(0.0F, 4.8F, -1.1F);
        rLeg02.addChild(rClaw01);
        setRotationAngle(rClaw01, 0.2443F, 0.0F, 0.0F);
        rClaw01.texOffs(0, 0).addBox(-0.5F, 0.5F, -2.5F, 1.0F, 0.0F, 3.0F, 0.0F, false);

        rClaw02 = new ModelPart(this);
        rClaw02.setPos(-0.5F, 4.9F, -0.7F);
        rLeg02.addChild(rClaw02);
        setRotationAngle(rClaw02, 0.1571F, 0.3491F, 0.0F);
        rClaw02.texOffs(0, 0).addBox(-0.5F, 0.5F, -2.5F, 1.0F, 0.0F, 3.0F, 0.0F, false);

        rClaw03 = new ModelPart(this);
        rClaw03.setPos(0.5F, 4.9F, -0.7F);
        rLeg02.addChild(rClaw03);
        setRotationAngle(rClaw03, 0.1134F, -0.3491F, 0.0F);
        rClaw03.texOffs(0, 0).addBox(-0.5F, 0.5F, -2.5F, 1.0F, 0.0F, 3.0F, 0.0F, false);

        rClaw04 = new ModelPart(this);
        rClaw04.setPos(0.0F, 5.0F, 0.9F);
        rLeg02.addChild(rClaw04);
        rClaw04.texOffs(0, 7).addBox(-0.5F, 0.5F, -0.5F, 1.0F, 0.0F, 3.0F, 0.0F, false);

        breast = new ModelPart(this);
        breast.setPos(0.0F, 0.3F, -4.5F);
        body.addChild(breast);
        setRotationAngle(breast, 0.7854F, 0.0F, 0.0F);
        breast.texOffs(0, 23).addBox(-3.5F, -3.8F, -3.9F, 7.0F, 6.0F, 7.0F, 0.0F, false);

        neck = new ModelPart(this);
        neck.setPos(0.0F, -2.3F, -2.2F);
        breast.addChild(neck);
        setRotationAngle(neck, -1.0472F, 0.0F, 0.0F);
        neck.texOffs(0, 38).addBox(-1.49F, -7.5F, -2.0F, 3.0F, 8.0F, 4.0F, 0.0F, false);

        head = new ModelPart(this);
        head.setPos(0.0F, -6.8F, 0.0F);
        neck.addChild(head);
        setRotationAngle(head, 0.2618F, 0.0F, 0.0F);
        head.texOffs(0, 52).addBox(-1.5F, -4.0F, -1.9F, 3.0F, 4.0F, 4.0F, 0.0F, false);

        beak01 = new ModelPart(this);
        beak01.setPos(0.0F, -2.0F, -2.0F);
        head.addChild(beak01);
        setRotationAngle(beak01, -1.2217F, 0.0F, 0.0F);
        beak01.texOffs(57, 3).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.1F, false);

        beak02 = new ModelPart(this);
        beak02.setPos(0.0F, 0.2F, 0.0F);
        beak01.addChild(beak02);
        beak02.texOffs(57, 0).addBox(-1.0F, -0.7F, -0.7F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        waddle = new ModelPart(this);
        waddle.setPos(0.0F, -4.0F, -0.8F);
        neck.addChild(waddle);
        setRotationAngle(waddle, 0.4014F, 0.0F, 0.0F);
        waddle.texOffs(14, 36).addBox(0.0F, -3.0F, -3.0F, 0.0F, 7.0F, 3.0F, 0.0F, false);

        beard = new ModelPart(this);
        beard.setPos(0.0F, -1.5F, -3.5F);
        breast.addChild(beard);
        setRotationAngle(beard, -0.7854F, 0.0F, 0.0F);
        beard.texOffs(31, 52).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

        tail01 = new ModelPart(this);
        tail01.setPos(0.0F, -3.1F, 5.6F);
        body.addChild(tail01);
        tail01.texOffs(24, 32).addBox(-3.5F, -1.0F, 0.0F, 7.0F, 2.0F, 5.0F, 0.0F, false);

        lTailFeather01 = new ModelPart(this);
        lTailFeather01.setPos(0.9F, -0.3F, 4.9F);
        tail01.addChild(lTailFeather01);
        setRotationAngle(lTailFeather01, 0.0F, 0.0175F, 0.0F);
        lTailFeather01.texOffs(16, 52).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 0.0F, 9.0F, 0.0F, true);

        rTailFeather01 = new ModelPart(this);
        rTailFeather01.setPos(-0.9F, -0.3F, 4.9F);
        tail01.addChild(rTailFeather01);
        setRotationAngle(rTailFeather01, 0.0F, -0.0175F, 0.0F);
        rTailFeather01.texOffs(16, 52).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 0.0F, 9.0F, 0.0F, false);

        lTailFeather02 = new ModelPart(this);
        lTailFeather02.setPos(2.0F, -0.15F, 4.8F);
        tail01.addChild(lTailFeather02);
        setRotationAngle(lTailFeather02, 0.0F, 0.0524F, 0.0F);
        lTailFeather02.texOffs(16, 52).addBox(-1.0F, -0.5F, -0.7F, 2.0F, 0.0F, 9.0F, 0.0F, true);

        rTailFeather02 = new ModelPart(this);
        rTailFeather02.setPos(-2.0F, -0.15F, 4.8F);
        tail01.addChild(rTailFeather02);
        setRotationAngle(rTailFeather02, 0.0F, -0.0524F, 0.0F);
        rTailFeather02.texOffs(16, 52).addBox(-1.0F, -0.5F, -0.7F, 2.0F, 0.0F, 9.0F, 0.0F, false);

        lTailFeather03 = new ModelPart(this);
        lTailFeather03.setPos(2.6F, 0.1F, 5.1F);
        tail01.addChild(lTailFeather03);
        setRotationAngle(lTailFeather03, 0.0F, 0.1222F, 0.0F);
        lTailFeather03.texOffs(16, 52).addBox(-1.0F, -0.5F, -1.7F, 2.0F, 0.0F, 9.0F, 0.0F, true);

        rTailFeather03 = new ModelPart(this);
        rTailFeather03.setPos(-2.6F, 0.1F, 5.1F);
        tail01.addChild(rTailFeather03);
        setRotationAngle(rTailFeather03, 0.0F, -0.1222F, 0.0F);
        rTailFeather03.texOffs(16, 52).addBox(-1.0F, -0.5F, -1.7F, 2.0F, 0.0F, 9.0F, 0.0F, false);

        lTailFeather04 = new ModelPart(this);
        lTailFeather04.setPos(2.7F, 0.2F, 4.0F);
        tail01.addChild(lTailFeather04);
        setRotationAngle(lTailFeather04, 0.0F, 0.1745F, 0.0F);
        lTailFeather04.texOffs(16, 52).addBox(-1.0F, -0.5F, -1.7F, 2.0F, 0.0F, 9.0F, 0.0F, true);

        rTailFeather04 = new ModelPart(this);
        rTailFeather04.setPos(-2.7F, 0.2F, 4.0F);
        tail01.addChild(rTailFeather04);
        setRotationAngle(rTailFeather04, 0.0F, -0.1745F, 0.0F);
        rTailFeather04.texOffs(16, 52).addBox(-1.0F, -0.5F, -1.7F, 2.0F, 0.0F, 9.0F, 0.0F, false);

        lTailFeather05 = new ModelPart(this);
        lTailFeather05.setPos(2.7F, 0.3F, 2.7F);
        tail01.addChild(lTailFeather05);
        setRotationAngle(lTailFeather05, 0.0F, 0.2618F, 0.0F);
        lTailFeather05.texOffs(16, 52).addBox(-1.0F, -0.5F, -1.7F, 2.0F, 0.0F, 9.0F, 0.0F, true);

        rTailFeather05 = new ModelPart(this);
        rTailFeather05.setPos(-2.7F, 0.3F, 2.7F);
        tail01.addChild(rTailFeather05);
        setRotationAngle(rTailFeather05, 0.0F, -0.2618F, 0.0F);
        rTailFeather05.texOffs(16, 52).addBox(-1.0F, -0.5F, -1.7F, 2.0F, 0.0F, 9.0F, 0.0F, false);

        tail02 = new ModelPart(this);
        tail02.setPos(0.0F, -0.3F, 5.4F);
        body.addChild(tail02);
        setRotationAngle(tail02, 0.1222F, 0.0F, 0.0F);
        tail02.texOffs(20, 40).addBox(-3.0F, -2.5F, 0.0F, 6.0F, 5.0F, 6.0F, 0.0F, true);

        hackles = new ModelPart(this);
        hackles.setPos(0.0F, -2.3F, 2.2F);
        body.addChild(hackles);
        setRotationAngle(hackles, 0.1745F, 0.0F, 0.0F);
        hackles.texOffs(33, 53).addBox(-3.0F, -2.5F, 0.0F, 6.0F, 3.0F, 7.0F, 0.0F, true);

        lWing01 = new ModelPart(this);
        lWing01.setPos(4.0F, -3.5F, -5.1F);
        body.addChild(lWing01);
        setRotationAngle(lWing01, 0.0F, -1.1345F, 0.0F);
        lWing01.texOffs(40, 40).addBox(0.0F, -0.5F, -1.0F, 7.0F, 1.0F, 5.0F, 0.0F, true);

        lWing02 = new ModelPart(this);
        lWing02.setPos(5.4F, 0.0F, -0.3F);
        lWing01.addChild(lWing02);
        setRotationAngle(lWing02, 0.0F, -0.6545F, 0.0F);
        lWing02.texOffs(46, 32).addBox(-0.25F, -0.51F, -0.5F, 6.0F, 1.0F, 3.0F, 0.0F, true);

        lWingFeathers = new ModelPart(this);
        lWingFeathers.setPos(0.0F, 0.0F, 0.0F);
        lWing02.addChild(lWingFeathers);
        lWingFeathers.texOffs(20, 21).addBox(-5.9F, -0.1F, -0.4F, 17.0F, 0.0F, 10.0F, 0.0F, false);

        rWing01 = new ModelPart(this);
        rWing01.setPos(-4.0F, -3.5F, -5.1F);
        body.addChild(rWing01);
        setRotationAngle(rWing01, 0.0F, 1.1345F, 0.0F);
        rWing01.texOffs(40, 40).addBox(-7.0F, -0.5F, -1.0F, 7.0F, 1.0F, 5.0F, 0.0F, false);

        rWing02 = new ModelPart(this);
        rWing02.setPos(-5.4F, 0.0F, -0.3F);
        rWing01.addChild(rWing02);
        setRotationAngle(rWing02, 0.0F, 0.6545F, 0.0F);
        rWing02.texOffs(46, 32).addBox(-5.75F, -0.51F, -0.5F, 6.0F, 1.0F, 3.0F, 0.0F, false);

        rWingFeathers = new ModelPart(this);
        rWingFeathers.setPos(0.0F, 0.0F, 0.0F);
        rWing02.addChild(rWingFeathers);
        rWingFeathers.texOffs(20, 21).addBox(-11.1F, -0.1F, -0.4F, 17.0F, 0.0F, 10.0F, 0.0F, true);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.headYaw(this.head, netHeadYaw);
        this.headPitch(head, headPitch);
        this.lWingFeathers.visible = this.rWingFeathers.visible = false;
        if (entityIn instanceof EntityTurkey) {
            EntityTurkey ent = (EntityTurkey) entityIn;
            float peckTime = ent.getPeckTime();
            if (peckTime <= 60) {
                this.neck.xRot = rad((peckTime % (60F / peckTime))) * 6F + rad(80F);
                this.head.yRot = 0;
            } else {
                this.neck.xRot = rad(-60F);
            }
            if (ent.isTailUp()) {
                this.setRotateAngle(tail01, 0.9424777960769379F, 0.0F, 0.0F);
                this.setRotateAngle(rTailFeather01, 0.0F, -0.06981317007977318F, 0.0F);
                this.setRotateAngle(lTailFeather04, 0.0F, 1.0471975511965976F, 0.0F);
                this.setRotateAngle(tail02, 0.45378560551852565F, 0.0F, 0.0F);
                this.setRotateAngle(rTailFeather05, 0.0F, -1.3089969389957472F, 0.0F);
                this.setRotateAngle(lTailFeather02, 0.0F, 0.296705972839036F, 0.0F);
                this.setRotateAngle(rTailFeather02, 0.0F, -0.296705972839036F, 0.0F);
                this.setRotateAngle(rTailFeather03, 0.0F, -0.6981317007977318F, 0.0F);
                this.setRotateAngle(hackles, 0.7330382858376184F, 0.0F, 0.0F);
                this.setRotateAngle(lTailFeather03, 0.0F, 0.6981317007977318F, 0.0F);
                this.setRotateAngle(lTailFeather05, 0.0F, 1.3089969389957472F, 0.0F);
                this.setRotateAngle(lTailFeather01, 0.0F, 0.06981317007977318F, 0.0F);
                this.setRotateAngle(rTailFeather04, 0.0F, -1.0471975511965976F, 0.0F);
            } else {
                this.setRotateAngle(rTailFeather04, 0.0F, -0.17453292519943295F, 0.0F);
                this.setRotateAngle(lTailFeather01, 0.0F, 0.017453292519943295F, 0.0F);
                this.setRotateAngle(lTailFeather05, 0.0F, 0.2617993877991494F, 0.0F);
                this.setRotateAngle(lTailFeather03, 0.0F, 0.12217304763960307F, 0.0F);
                this.setRotateAngle(hackles, 0.17453292519943295F, 0.0F, 0.0F);
                this.setRotateAngle(rTailFeather03, 0.0F, -0.12217304763960307F, 0.0F);
                this.setRotateAngle(rTailFeather02, 0.0F, -0.05235987755982988F, 0.0F);
                this.setRotateAngle(lTailFeather02, 0.0F, 0.05235987755982988F, 0.0F);
                this.setRotateAngle(rTailFeather05, 0.0F, -0.2617993877991494F, 0.0F);
                this.setRotateAngle(tail02, 0.12217304763960307F, 0.0F, 0.0F);
                this.setRotateAngle(lTailFeather04, 0.0F, 0.17453292519943295F, 0.0F);
                this.setRotateAngle(rTailFeather02, 0.0F, -0.05235987755982988F, 0.0F);
                this.setRotateAngle(lTailFeather02, 0.0F, 0.05235987755982988F, 0.0F);
                this.setRotateAngle(tail02, 0.12217304763960307F, 0.0F, 0.0F);
                this.setRotateAngle(lTailFeather04, 0.0F, 0.17453292519943295F, 0.0F);
                this.setRotateAngle(rTailFeather01, 0.0F, -0.017453292519943295F, 0.0F);
                this.setRotateAngle(tail01, 0.0F, 0.0F, 0.0F);
            }
            this.lWingFeathers.visible = this.rWingFeathers.visible = ageInTicks > 0 || ent.isTailUp();
        }
        this.biped(lLeg01, rLeg01, limbSwing * 0.6662F, limbSwingAmount * 1.4F);
        this.rWing01.zRot = ageInTicks - 0.4F;
        this.lWing01.zRot = -ageInTicks + 0.4F;
        this.rWing01.yRot = ageInTicks == 0 ? 1.1345F : 0;
        this.lWing01.yRot = -this.rWing01.yRot;
    }

}
