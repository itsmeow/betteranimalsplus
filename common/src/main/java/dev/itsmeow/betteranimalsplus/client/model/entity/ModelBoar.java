package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;

/**
 * boar - cybercat5555 Created using Tabula 5.1.0
 */
public class ModelBoar<T extends LivingEntity> extends ModelBAP<T> {

    public ModelPart body;
    public ModelPart neck;
    public ModelPart lArm01;
    public ModelPart rArm01;
    public ModelPart stomach;
    public ModelPart mane02;
    public ModelPart mane03;
    public ModelPart chestFur02;
    public ModelPart neck02;
    public ModelPart chestFur01;
    public ModelPart head;
    public ModelPart mane01;
    public ModelPart snoot01;
    public ModelPart upperJaw;
    public ModelPart lowerJaw;
    public ModelPart lEar01;
    public ModelPart rEar01;
    public ModelPart snoot02;
    public ModelPart snoot;
    public ModelPart lTusk01;
    public ModelPart rTusk01;
    public ModelPart lTusk02;
    public ModelPart lTusk03;
    public ModelPart rTusk02;
    public ModelPart rTusk03;
    public ModelPart lEar02;
    public ModelPart rEar02;
    public ModelPart lArm02;
    public ModelPart lArm03;
    public ModelPart lForeHoof;
    public ModelPart rArm02;
    public ModelPart rArm03;
    public ModelPart rForeHoof;
    public ModelPart ass;
    public ModelPart lLeg01;
    public ModelPart rLeg01;
    public ModelPart tail01a;
    public ModelPart lLeg02;
    public ModelPart lLeg03;
    public ModelPart lHindHoof;
    public ModelPart rLeg02;
    public ModelPart rLeg03;
    public ModelPart rHindHoof;
    public ModelPart tail01b;
    public ModelPart tail01c;
    public ModelPart tail01d;
    public ModelPart tail02;
    public ModelPart tail03;
    public ModelPart tail04;
    public ModelPart tailFur;

    public ModelBoar(ModelPart root) {
        this.body = root.getChild("body");
        this.neck = body.getChild("neck");
        this.neck02 = neck.getChild("neck02");
        this.head = neck02.getChild("head");
        this.snoot01 = head.getChild("snoot01");
        this.snoot02 = snoot01.getChild("snoot02");
        this.snoot = snoot01.getChild("snoot");
        this.upperJaw = head.getChild("upperJaw");
        this.lowerJaw = head.getChild("lowerJaw");
        this.lTusk01 = lowerJaw.getChild("lTusk01");
        this.lTusk02 = lTusk01.getChild("lTusk02");
        this.lTusk03 = lTusk02.getChild("lTusk03");
        this.rTusk01 = lowerJaw.getChild("rTusk01");
        this.rTusk02 = rTusk01.getChild("rTusk02");
        this.rTusk03 = rTusk02.getChild("rTusk03");
        this.lEar01 = head.getChild("lEar01");
        this.lEar02 = lEar01.getChild("lEar02");
        this.rEar01 = head.getChild("rEar01");
        this.rEar02 = rEar01.getChild("rEar02");
        this.mane01 = neck02.getChild("mane01");
        this.chestFur01 = neck.getChild("chestFur01");
        this.lArm01 = body.getChild("lArm01");
        this.lArm02 = lArm01.getChild("lArm02");
        this.lArm03 = lArm02.getChild("lArm03");
        this.lForeHoof = lArm03.getChild("lForeHoof");
        this.rArm01 = body.getChild("rArm01");
        this.rArm02 = rArm01.getChild("rArm02");
        this.rArm03 = rArm02.getChild("rArm03");
        this.rForeHoof = rArm03.getChild("rForeHoof");
        this.stomach = body.getChild("stomach");
        this.ass = stomach.getChild("ass");
        this.lLeg01 = ass.getChild("lLeg01");
        this.lLeg02 = lLeg01.getChild("lLeg02");
        this.lLeg03 = lLeg02.getChild("lLeg03");
        this.lHindHoof = lLeg03.getChild("lHindHoof");
        this.rLeg01 = ass.getChild("rLeg01");
        this.rLeg02 = rLeg01.getChild("rLeg02");
        this.rLeg03 = rLeg02.getChild("rLeg03");
        this.rHindHoof = rLeg03.getChild("rHindHoof");
        this.tail01a = ass.getChild("tail01a");
        this.tail01b = tail01a.getChild("tail01b");
        this.tail01c = tail01a.getChild("tail01c");
        this.tail01d = tail01a.getChild("tail01d");
        this.tail02 = tail01a.getChild("tail02");
        this.tail03 = tail02.getChild("tail03");
        this.tail04 = tail03.getChild("tail04");
        this.tailFur = tail04.getChild("tailFur");
        this.mane02 = body.getChild("mane02");
        this.mane03 = body.getChild("mane03");
        this.chestFur02 = body.getChild("chestFur02");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -4.3F, -6.0F, 7.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.5F, -3.7F));
        PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 34).addBox(-3.0F, -3.5F, -2.7F, 6.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.1F, -5.0F, -0.0911F, 0.0F, 0.0F));
        PartDefinition neck02 = neck.addOrReplaceChild("neck02", CubeListBuilder.create().texOffs(0, 48).addBox(-2.0F, -3.0F, -3.0F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.1F, -1.8F, -0.1367F, 0.0F, 0.0F));
        PartDefinition head = neck02.addOrReplaceChild("head", CubeListBuilder.create().texOffs(84, 0).addBox(-2.5F, -3.5F, -5.0F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.3F, -1.2F, 0.3316F, 0.0F, 0.0F));
        PartDefinition snoot01 = head.addOrReplaceChild("snoot01", CubeListBuilder.create().texOffs(84, 16).mirror().addBox(-1.3F, -1.5F, -4.7F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -0.6F, -4.4F, 0.2731F, 0.0F, 0.0F));
        PartDefinition snoot02 = snoot01.addOrReplaceChild("snoot02", CubeListBuilder.create().texOffs(101, 16).addBox(-1.7F, -1.5F, -4.7F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition snoot = snoot01.addOrReplaceChild("snoot", CubeListBuilder.create().texOffs(112, 16).addBox(-1.5F, -1.5F, -0.8F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.4F, -4.3F, -0.1367F, 0.0F, 0.0F));
        PartDefinition upperJaw = head.addOrReplaceChild("upperJaw", CubeListBuilder.create().texOffs(84, 25).addBox(-1.5F, -1.0F, -4.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.7F, -4.4F));
        PartDefinition lowerJaw = head.addOrReplaceChild("lowerJaw", CubeListBuilder.create().texOffs(99, 25).addBox(-1.5F, -0.5F, -4.7F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.2F, -4.1F, -0.0873F, 0.0F, 0.0F));
        PartDefinition lTusk01 = lowerJaw.addOrReplaceChild("lTusk01", CubeListBuilder.create().texOffs(0, 1).mirror().addBox(-0.5F, -0.8F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.3F, -0.5F, -2.8F, 0.2443F, 0.0F, 0.6981F));
        PartDefinition lTusk02 = lTusk01.addOrReplaceChild("lTusk02", CubeListBuilder.create().texOffs(0, 1).mirror().addBox(-0.55F, -0.7F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 0.0F, -0.2618F));
        PartDefinition lTusk03 = lTusk02.addOrReplaceChild("lTusk03", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.6F, -1.7F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.1F, -0.8F, 0.0F, 0.0F, 0.0F, -0.4363F));
        PartDefinition rTusk01 = lowerJaw.addOrReplaceChild("rTusk01", CubeListBuilder.create().texOffs(0, 1).addBox(-0.5F, -0.8F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3F, -0.5F, -2.8F, 0.2443F, 0.0F, -0.6981F));
        PartDefinition rTusk02 = rTusk01.addOrReplaceChild("rTusk02", CubeListBuilder.create().texOffs(0, 1).addBox(-0.45F, -0.7F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.2618F));
        PartDefinition rTusk03 = rTusk02.addOrReplaceChild("rTusk03", CubeListBuilder.create().texOffs(0, 0).addBox(-0.4F, -1.7F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -0.8F, 0.0F, 0.0F, 0.0F, 0.4363F));
        PartDefinition lEar01 = head.addOrReplaceChild("lEar01", CubeListBuilder.create().texOffs(69, 37).mirror().addBox(-0.8F, -3.0F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.2F, -2.7F, -1.7F, -0.2269F, -0.7854F, 0.7854F));
        PartDefinition lEar02 = lEar01.addOrReplaceChild("lEar02", CubeListBuilder.create().texOffs(78, 37).mirror().addBox(-1.0F, -4.0F, -0.5F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.6F, 0.0F, 0.7F, 0.2269F, 0.0F, 0.0F));
        PartDefinition rEar01 = head.addOrReplaceChild("rEar01", CubeListBuilder.create().texOffs(69, 37).addBox(-2.2F, -3.0F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2F, -2.7F, -1.7F, -0.2269F, 0.7854F, -0.7854F));
        PartDefinition rEar02 = rEar01.addOrReplaceChild("rEar02", CubeListBuilder.create().texOffs(78, 37).addBox(-1.0F, -4.0F, -0.5F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6F, 0.0F, 0.7F, 0.2269F, 0.0F, 0.0F));
        PartDefinition mane01 = neck02.addOrReplaceChild("mane01", CubeListBuilder.create().texOffs(86, 35).addBox(-2.0F, -1.2F, 0.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.7F, -1.8F, 0.6981F, 0.0F, 0.0F));
        PartDefinition chestFur01 = neck.addOrReplaceChild("chestFur01", CubeListBuilder.create().texOffs(108, 50).addBox(-2.5F, 0.0F, -1.0F, 5.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.6F, -2.1F, 0.1745F, 0.0F, 0.0F));
        PartDefinition lArm01 = body.addOrReplaceChild("lArm01", CubeListBuilder.create().texOffs(65, 0).mirror().addBox(0.0F, -1.0F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.8F, -1.0F, -2.7F, 0.0911F, 0.0F, -0.1367F));
        PartDefinition lArm02 = lArm01.addOrReplaceChild("lArm02", CubeListBuilder.create().texOffs(65, 13).mirror().addBox(-1.5F, 0.0F, -2.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.2F, 4.6F, 0.0F, 0.0F, 0.0F, 0.0873F));
        PartDefinition lArm03 = lArm02.addOrReplaceChild("lArm03", CubeListBuilder.create().texOffs(38, 21).mirror().addBox(-1.0F, 0.0F, -1.5F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.2F, 1.8F, 0.0F, -0.0911F, 0.0F, 0.0349F));
        PartDefinition lForeHoof = lArm03.addOrReplaceChild("lForeHoof", CubeListBuilder.create().texOffs(49, 21).mirror().addBox(-1.0F, 0.0F, -1.8F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.1F, 4.6F, -0.3F));
        PartDefinition rArm01 = body.addOrReplaceChild("rArm01", CubeListBuilder.create().texOffs(65, 0).addBox(-3.0F, -1.0F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8F, -1.0F, -2.7F, 0.0911F, 0.0F, 0.1367F));
        PartDefinition rArm02 = rArm01.addOrReplaceChild("rArm02", CubeListBuilder.create().texOffs(65, 13).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2F, 4.6F, 0.0F, 0.0F, 0.0F, -0.0873F));
        PartDefinition rArm03 = rArm02.addOrReplaceChild("rArm03", CubeListBuilder.create().texOffs(38, 21).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, 1.8F, 0.0F, -0.0911F, 0.0F, -0.0349F));
        PartDefinition rForeHoof = rArm03.addOrReplaceChild("rForeHoof", CubeListBuilder.create().texOffs(49, 21).addBox(-1.0F, 0.0F, -1.8F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.1F, 4.6F, -0.3F));
        PartDefinition stomach = body.addOrReplaceChild("stomach", CubeListBuilder.create().texOffs(27, 30).addBox(-4.0F, -4.6F, -3.0F, 8.0F, 9.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.6F, 3.6F, -0.0524F, 0.0F, 0.0F));
        PartDefinition ass = stomach.addOrReplaceChild("ass", CubeListBuilder.create().texOffs(0, 18).addBox(-3.5F, -3.5F, 0.0F, 7.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.1F, 4.2F, -0.1222F, 0.0F, 0.0F));
        PartDefinition lLeg01 = ass.addOrReplaceChild("lLeg01", CubeListBuilder.create().texOffs(38, 0).mirror().addBox(-0.5F, -1.0F, -2.5F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.2F, -1.2F, 4.7F, -0.0349F, 0.0F, -0.0911F));
        PartDefinition lLeg02 = lLeg01.addOrReplaceChild("lLeg02", CubeListBuilder.create().texOffs(41, 13).mirror().addBox(-1.5F, 0.0F, -2.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.7F, 3.9F, -0.1F, 0.3187F, 0.0F, 0.0911F));
        PartDefinition lLeg03 = lLeg02.addOrReplaceChild("lLeg03", CubeListBuilder.create().texOffs(38, 21).mirror().addBox(-1.0F, 0.0F, -1.5F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.2F, 2.6F, 0.0F, -0.1745F, 0.0F, 0.0F));
        PartDefinition lHindHoof = lLeg03.addOrReplaceChild("lHindHoof", CubeListBuilder.create().texOffs(49, 21).mirror().addBox(-1.0F, 0.0F, -1.8F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.1F, 4.1F, -0.3F, 0.0698F, 0.0F, 0.0F));
        PartDefinition rLeg01 = ass.addOrReplaceChild("rLeg01", CubeListBuilder.create().texOffs(38, 0).addBox(-3.5F, -1.0F, -2.5F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2F, -1.2F, 4.7F, -0.0349F, 0.0F, 0.0911F));
        PartDefinition rLeg02 = rLeg01.addOrReplaceChild("rLeg02", CubeListBuilder.create().texOffs(41, 13).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7F, 3.9F, -0.1F, 0.3187F, 0.0F, -0.0911F));
        PartDefinition rLeg03 = rLeg02.addOrReplaceChild("rLeg03", CubeListBuilder.create().texOffs(38, 21).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, 2.6F, 0.0F, -0.1745F, 0.0F, 0.0F));
        PartDefinition rHindHoof = rLeg03.addOrReplaceChild("rHindHoof", CubeListBuilder.create().texOffs(49, 21).addBox(-1.0F, 0.0F, -1.8F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, 4.1F, -0.3F, 0.0698F, 0.0F, 0.0F));
        PartDefinition tail01a = ass.addOrReplaceChild("tail01a", CubeListBuilder.create().texOffs(24, 53).addBox(-0.8F, 0.0F, -0.2F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.7F, 6.5F, 0.8652F, 0.0F, 0.0F));
        PartDefinition tail01b = tail01a.addOrReplaceChild("tail01b", CubeListBuilder.create().texOffs(24, 53).addBox(-0.2F, 0.0F, -0.2F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition tail01c = tail01a.addOrReplaceChild("tail01c", CubeListBuilder.create().texOffs(24, 53).addBox(-0.8F, 0.0F, -0.8F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition tail01d = tail01a.addOrReplaceChild("tail01d", CubeListBuilder.create().texOffs(24, 53).addBox(-0.2F, 0.0F, -0.8F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition tail02 = tail01a.addOrReplaceChild("tail02", CubeListBuilder.create().texOffs(30, 53).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.5F, 0.3F, -0.6374F, 0.0F, 0.0F));
        PartDefinition tail03 = tail02.addOrReplaceChild("tail03", CubeListBuilder.create().texOffs(30, 53).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.7F, 0.0F, -0.2094F, 0.0F, 0.0F));
        PartDefinition tail04 = tail03.addOrReplaceChild("tail04", CubeListBuilder.create().texOffs(30, 53).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.9F, 0.0F, 0.192F, 0.0F, 0.0F));
        PartDefinition tailFur = tail04.addOrReplaceChild("tailFur", CubeListBuilder.create().texOffs(36, 53).addBox(-0.9F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.6F, -0.1F));
        PartDefinition mane02 = body.addOrReplaceChild("mane02", CubeListBuilder.create().texOffs(102, 38).addBox(-2.5F, -1.1F, -0.5F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.4F, -5.2F, 0.384F, 0.0F, 0.0F));
        PartDefinition mane03 = body.addOrReplaceChild("mane03", CubeListBuilder.create().texOffs(79, 45).addBox(-3.0F, -0.9F, -0.5F, 6.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.4F, -3.1F, 0.2793F, 0.0F, 0.0F));
        PartDefinition chestFur02 = body.addOrReplaceChild("chestFur02", CubeListBuilder.create().texOffs(52, 45).addBox(-3.0F, 0.0F, -2.0F, 6.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.6F, -3.8F, -0.0873F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.quadriped(lLeg01, lArm01, rLeg01, rArm01, limbSwing * 0.666F, limbSwingAmount * 1.4F);
        this.headPitch(neck, headPitch);
        this.headYaw(neck, netHeadYaw);
    }

}
