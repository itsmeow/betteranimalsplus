package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import dev.itsmeow.betteranimalsplus.common.entity.EntityTurkey;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
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

    public ModelTurkey(ModelPart root) {
        this.root = root.getChild("root");
        this.body = root.getChild("body");
        this.lLeg01 = body.getChild("lLeg01");
        this.lLeg02 = lLeg01.getChild("lLeg02");
        this.lClaw01 = lLeg02.getChild("lClaw01");
        this.lClaw02 = lLeg02.getChild("lClaw02");
        this.lClaw03 = lLeg02.getChild("lClaw03");
        this.lClaw04 = lLeg02.getChild("lClaw04");
        this.box_r1 = lClaw04.getChild("box_r1");
        this.rLeg01 = body.getChild("rLeg01");
        this.rLeg02 = rLeg01.getChild("rLeg02");
        this.rClaw01 = rLeg02.getChild("rClaw01");
        this.rClaw02 = rLeg02.getChild("rClaw02");
        this.rClaw03 = rLeg02.getChild("rClaw03");
        this.rClaw04 = rLeg02.getChild("rClaw04");
        this.breast = body.getChild("breast");
        this.neck = breast.getChild("neck");
        this.head = neck.getChild("head");
        this.beak01 = head.getChild("beak01");
        this.beak02 = beak01.getChild("beak02");
        this.waddle = neck.getChild("waddle");
        this.beard = breast.getChild("beard");
        this.tail01 = body.getChild("tail01");
        this.lTailFeather01 = tail01.getChild("lTailFeather01");
        this.rTailFeather01 = tail01.getChild("rTailFeather01");
        this.lTailFeather02 = tail01.getChild("lTailFeather02");
        this.rTailFeather02 = tail01.getChild("rTailFeather02");
        this.lTailFeather03 = tail01.getChild("lTailFeather03");
        this.rTailFeather03 = tail01.getChild("rTailFeather03");
        this.lTailFeather04 = tail01.getChild("lTailFeather04");
        this.rTailFeather04 = tail01.getChild("rTailFeather04");
        this.lTailFeather05 = tail01.getChild("lTailFeather05");
        this.rTailFeather05 = tail01.getChild("rTailFeather05");
        this.tail02 = body.getChild("tail02");
        this.hackles = body.getChild("hackles");
        this.lWing01 = body.getChild("lWing01");
        this.lWing02 = lWing01.getChild("lWing02");
        this.lWingFeathers = lWing02.getChild("lWingFeathers");
        this.rWing01 = body.getChild("rWing01");
        this.rWing02 = rWing01.getChild("rWing02");
        this.rWingFeathers = rWing02.getChild("rWingFeathers");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -4.5F, -6.0F, 9.0F, 9.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.8F, 0.0F));
        PartDefinition lLeg01 = body.addOrReplaceChild("lLeg01", CubeListBuilder.create().texOffs(33, 0).mirror().addBox(-1.5F, -0.7F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.6F, 4.5F, 1.5F, 0.2094F, 0.0F, 0.0F));
        PartDefinition lLeg02 = lLeg01.addOrReplaceChild("lLeg02", CubeListBuilder.create().texOffs(46, 0).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.1F, 0.0F, -0.2094F, 0.0F, 0.0F));
        PartDefinition lClaw01 = lLeg02.addOrReplaceChild("lClaw01", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.5F, 0.0F, -2.5F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.3F, -1.1F, 0.2443F, 0.0F, 0.0F));
        PartDefinition lClaw02 = lLeg02.addOrReplaceChild("lClaw02", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.5F, 0.5F, -2.5F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, 4.9F, -0.7F, 0.1571F, -0.3491F, 0.0F));
        PartDefinition lClaw03 = lLeg02.addOrReplaceChild("lClaw03", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.5F, -2.5F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 4.9F, -0.7F, 0.1571F, 0.3491F, 0.0F));
        PartDefinition lClaw04 = lLeg02.addOrReplaceChild("lClaw04", CubeListBuilder.create(), PartPose.offset(0.0F, 5.5F, 0.9F));
        PartDefinition box_r1 = lClaw04.addOrReplaceChild("box_r1", CubeListBuilder.create().texOffs(0, 7).mirror().addBox(2.1F, -0.1F, 1.9F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.6F, 0.1F, -2.4F, -0.0436F, 0.0F, 0.0F));
        PartDefinition rLeg01 = body.addOrReplaceChild("rLeg01", CubeListBuilder.create().texOffs(33, 0).addBox(-1.5F, -0.7F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6F, 4.5F, 1.5F, 0.2094F, 0.0F, 0.0F));
        PartDefinition rLeg02 = rLeg01.addOrReplaceChild("rLeg02", CubeListBuilder.create().texOffs(46, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.1F, 0.0F, -0.2094F, 0.0F, 0.0F));
        PartDefinition rClaw01 = rLeg02.addOrReplaceChild("rClaw01", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.5F, -2.5F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.8F, -1.1F, 0.2443F, 0.0F, 0.0F));
        PartDefinition rClaw02 = rLeg02.addOrReplaceChild("rClaw02", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.5F, -2.5F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 4.9F, -0.7F, 0.1571F, 0.3491F, 0.0F));
        PartDefinition rClaw03 = rLeg02.addOrReplaceChild("rClaw03", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.5F, -2.5F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 4.9F, -0.7F, 0.1134F, -0.3491F, 0.0F));
        PartDefinition rClaw04 = rLeg02.addOrReplaceChild("rClaw04", CubeListBuilder.create().texOffs(0, 7).addBox(-0.5F, 0.5F, -0.5F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.9F));
        PartDefinition breast = body.addOrReplaceChild("breast", CubeListBuilder.create().texOffs(0, 23).addBox(-3.5F, -3.8F, -3.9F, 7.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.3F, -4.5F, 0.7854F, 0.0F, 0.0F));
        PartDefinition neck = breast.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 38).addBox(-1.49F, -7.5F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.3F, -2.2F, -1.0472F, 0.0F, 0.0F));
        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 52).addBox(-1.5F, -4.0F, -1.9F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.8F, 0.0F, 0.2618F, 0.0F, 0.0F));
        PartDefinition beak01 = head.addOrReplaceChild("beak01", CubeListBuilder.create().texOffs(57, 3).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, -2.0F, -2.0F, -1.2217F, 0.0F, 0.0F));
        PartDefinition beak02 = beak01.addOrReplaceChild("beak02", CubeListBuilder.create().texOffs(57, 0).addBox(-1.0F, -0.7F, -0.7F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.2F, 0.0F));
        PartDefinition waddle = neck.addOrReplaceChild("waddle", CubeListBuilder.create().texOffs(14, 36).addBox(0.0F, -3.0F, -3.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -0.8F, 0.4014F, 0.0F, 0.0F));
        PartDefinition beard = breast.addOrReplaceChild("beard", CubeListBuilder.create().texOffs(31, 52).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5F, -3.5F, -0.7854F, 0.0F, 0.0F));
        PartDefinition tail01 = body.addOrReplaceChild("tail01", CubeListBuilder.create().texOffs(24, 32).addBox(-3.5F, -1.0F, 0.0F, 7.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.1F, 5.6F));
        PartDefinition lTailFeather01 = tail01.addOrReplaceChild("lTailFeather01", CubeListBuilder.create().texOffs(16, 52).mirror().addBox(-1.0F, -0.5F, 0.0F, 2.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.9F, -0.3F, 4.9F, 0.0F, 0.0175F, 0.0F));
        PartDefinition rTailFeather01 = tail01.addOrReplaceChild("rTailFeather01", CubeListBuilder.create().texOffs(16, 52).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9F, -0.3F, 4.9F, 0.0F, -0.0175F, 0.0F));
        PartDefinition lTailFeather02 = tail01.addOrReplaceChild("lTailFeather02", CubeListBuilder.create().texOffs(16, 52).mirror().addBox(-1.0F, -0.5F, -0.7F, 2.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, -0.15F, 4.8F, 0.0F, 0.0524F, 0.0F));
        PartDefinition rTailFeather02 = tail01.addOrReplaceChild("rTailFeather02", CubeListBuilder.create().texOffs(16, 52).addBox(-1.0F, -0.5F, -0.7F, 2.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -0.15F, 4.8F, 0.0F, -0.0524F, 0.0F));
        PartDefinition lTailFeather03 = tail01.addOrReplaceChild("lTailFeather03", CubeListBuilder.create().texOffs(16, 52).mirror().addBox(-1.0F, -0.5F, -1.7F, 2.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.6F, 0.1F, 5.1F, 0.0F, 0.1222F, 0.0F));
        PartDefinition rTailFeather03 = tail01.addOrReplaceChild("rTailFeather03", CubeListBuilder.create().texOffs(16, 52).addBox(-1.0F, -0.5F, -1.7F, 2.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6F, 0.1F, 5.1F, 0.0F, -0.1222F, 0.0F));
        PartDefinition lTailFeather04 = tail01.addOrReplaceChild("lTailFeather04", CubeListBuilder.create().texOffs(16, 52).mirror().addBox(-1.0F, -0.5F, -1.7F, 2.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.7F, 0.2F, 4.0F, 0.0F, 0.1745F, 0.0F));
        PartDefinition rTailFeather04 = tail01.addOrReplaceChild("rTailFeather04", CubeListBuilder.create().texOffs(16, 52).addBox(-1.0F, -0.5F, -1.7F, 2.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7F, 0.2F, 4.0F, 0.0F, -0.1745F, 0.0F));
        PartDefinition lTailFeather05 = tail01.addOrReplaceChild("lTailFeather05", CubeListBuilder.create().texOffs(16, 52).mirror().addBox(-1.0F, -0.5F, -1.7F, 2.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.7F, 0.3F, 2.7F, 0.0F, 0.2618F, 0.0F));
        PartDefinition rTailFeather05 = tail01.addOrReplaceChild("rTailFeather05", CubeListBuilder.create().texOffs(16, 52).addBox(-1.0F, -0.5F, -1.7F, 2.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7F, 0.3F, 2.7F, 0.0F, -0.2618F, 0.0F));
        PartDefinition tail02 = body.addOrReplaceChild("tail02", CubeListBuilder.create().texOffs(20, 40).mirror().addBox(-3.0F, -2.5F, 0.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -0.3F, 5.4F, 0.1222F, 0.0F, 0.0F));
        PartDefinition hackles = body.addOrReplaceChild("hackles", CubeListBuilder.create().texOffs(33, 53).mirror().addBox(-3.0F, -2.5F, 0.0F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.3F, 2.2F, 0.1745F, 0.0F, 0.0F));
        PartDefinition lWing01 = body.addOrReplaceChild("lWing01", CubeListBuilder.create().texOffs(40, 40).mirror().addBox(0.0F, -0.5F, -1.0F, 7.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, -3.5F, -5.1F, 0.0F, -1.1345F, 0.0F));
        PartDefinition lWing02 = lWing01.addOrReplaceChild("lWing02", CubeListBuilder.create().texOffs(46, 32).mirror().addBox(-0.25F, -0.51F, -0.5F, 6.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.4F, 0.0F, -0.3F, 0.0F, -0.6545F, 0.0F));
        PartDefinition lWingFeathers = lWing02.addOrReplaceChild("lWingFeathers", CubeListBuilder.create().texOffs(20, 21).addBox(-5.9F, -0.1F, -0.4F, 17.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition rWing01 = body.addOrReplaceChild("rWing01", CubeListBuilder.create().texOffs(40, 40).addBox(-7.0F, -0.5F, -1.0F, 7.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -3.5F, -5.1F, 0.0F, 1.1345F, 0.0F));
        PartDefinition rWing02 = rWing01.addOrReplaceChild("rWing02", CubeListBuilder.create().texOffs(46, 32).addBox(-5.75F, -0.51F, -0.5F, 6.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.4F, 0.0F, -0.3F, 0.0F, 0.6545F, 0.0F));
        PartDefinition rWingFeathers = rWing02.addOrReplaceChild("rWingFeathers", CubeListBuilder.create().texOffs(20, 21).mirror().addBox(-11.1F, -0.1F, -0.4F, 17.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 64, 64);
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
