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
    public ModelPart lArm01;
    public ModelPart lArm02;
    public ModelPart lArm03;
    public ModelPart lArmFur_r1;
    public ModelPart lFrontHoofClaw01a;
    public ModelPart lFrontHoofClaw01b;
    public ModelPart lFrontHoofClaw02a;
    public ModelPart lFrontHoofClaw02b;
    public ModelPart rArm01;
    public ModelPart rArm02;
    public ModelPart rArm03;
    public ModelPart rArmFur_r1;
    public ModelPart rFrontHoofClaw01a;
    public ModelPart rFrontHoofClaw01b;
    public ModelPart rFrontHoofClaw02a;
    public ModelPart rFrontHoofClaw02b;
    public ModelPart mane01;
    public ModelPart Box_r1;
    public ModelPart mane02;
    public ModelPart Box_r2;
    public ModelPart ass;
    public ModelPart lLeg01;
    public ModelPart lLeg02;
    public ModelPart lLeg03;
    public ModelPart lHindHoofClaw01a;
    public ModelPart lHindHoofClaw01b;
    public ModelPart lHindHoofClaw02a;
    public ModelPart lHindHoofClaw02b2;
    public ModelPart rLeg01;
    public ModelPart rLeg02;
    public ModelPart rLeg03;
    public ModelPart rHindHoofClaw01a;
    public ModelPart rHindHoofClaw01b;
    public ModelPart rHindHoofClaw02a;
    public ModelPart rHindHoofClaw02b;
    public ModelPart tail;
    public ModelPart tailFur;
    public ModelPart head;
    public ModelPart snoot;
    public ModelPart nose;
    public ModelPart upperJaw;
    public ModelPart lUpperTusk;
    public ModelPart rUpperTusk;
    public ModelPart lowerJaw;
    public ModelPart lTusk01;
    public ModelPart lTusk02;
    public ModelPart rTusk01;
    public ModelPart rTusk02;
    public ModelPart lEar01;
    public ModelPart lEar02;
    public ModelPart rEar01;
    public ModelPart rEar02;

    public ModelBoar(ModelPart root) {
        this.body = root.getChild("body");
        this.lArm01 = body.getChild("lArm01");
        this.lArm02 = lArm01.getChild("lArm02");
        this.lArm03 = lArm02.getChild("lArm03");
        this.lArmFur_r1 = lArm03.getChild("lArmFur_r1");
        this.lFrontHoofClaw01a = lArm03.getChild("lFrontHoofClaw01a");
        this.lFrontHoofClaw01b = lFrontHoofClaw01a.getChild("lFrontHoofClaw01b");
        this.lFrontHoofClaw02a = lArm03.getChild("lFrontHoofClaw02a");
        this.lFrontHoofClaw02b = lFrontHoofClaw02a.getChild("lFrontHoofClaw02b");
        this.rArm01 = body.getChild("rArm01");
        this.rArm02 = rArm01.getChild("rArm02");
        this.rArm03 = rArm02.getChild("rArm03");
        this.rArmFur_r1 = rArm03.getChild("rArmFur_r1");
        this.rFrontHoofClaw01a = rArm03.getChild("rFrontHoofClaw01a");
        this.rFrontHoofClaw01b = rFrontHoofClaw01a.getChild("rFrontHoofClaw01b");
        this.rFrontHoofClaw02a = rArm03.getChild("rFrontHoofClaw02a");
        this.rFrontHoofClaw02b = rFrontHoofClaw02a.getChild("rFrontHoofClaw02b");
        this.mane01 = body.getChild("mane01");
        this.Box_r1 = mane01.getChild("Box_r1");
        this.mane02 = body.getChild("mane02");
        this.Box_r2 = mane02.getChild("Box_r2");
        this.ass = body.getChild("ass");
        this.lLeg01 = ass.getChild("lLeg01");
        this.lLeg02 = lLeg01.getChild("lLeg02");
        this.lLeg03 = lLeg02.getChild("lLeg03");
        this.lHindHoofClaw01a = lLeg03.getChild("lHindHoofClaw01a");
        this.lHindHoofClaw01b = lHindHoofClaw01a.getChild("lHindHoofClaw01b");
        this.lHindHoofClaw02a = lLeg03.getChild("lHindHoofClaw02a");
        this.lHindHoofClaw02b2 = lHindHoofClaw02a.getChild("lHindHoofClaw02b2");
        this.rLeg01 = ass.getChild("rLeg01");
        this.rLeg02 = rLeg01.getChild("rLeg02");
        this.rLeg03 = rLeg02.getChild("rLeg03");
        this.rHindHoofClaw01a = rLeg03.getChild("rHindHoofClaw01a");
        this.rHindHoofClaw01b = rHindHoofClaw01a.getChild("rHindHoofClaw01b");
        this.rHindHoofClaw02a = rLeg03.getChild("rHindHoofClaw02a");
        this.rHindHoofClaw02b = rHindHoofClaw02a.getChild("rHindHoofClaw02b");
        this.tail = ass.getChild("tail");
        this.tailFur = tail.getChild("tailFur");
        this.head = body.getChild("head");
        this.snoot = head.getChild("snoot");
        this.nose = snoot.getChild("nose");
        this.upperJaw = head.getChild("upperJaw");
        this.lUpperTusk = upperJaw.getChild("lUpperTusk");
        this.rUpperTusk = upperJaw.getChild("rUpperTusk");
        this.lowerJaw = head.getChild("lowerJaw");
        this.lTusk01 = lowerJaw.getChild("lTusk01");
        this.lTusk02 = lTusk01.getChild("lTusk02");
        this.rTusk01 = lowerJaw.getChild("rTusk01");
        this.rTusk02 = rTusk01.getChild("rTusk02");
        this.lEar01 = head.getChild("lEar01");
        this.lEar02 = lEar01.getChild("lEar02");
        this.rEar01 = head.getChild("rEar01");
        this.rEar02 = rEar01.getChild("rEar02");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.3F, -6.0F, 8.0F, 9.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.5F, -2.7F));
        PartDefinition lArm01 = body.addOrReplaceChild("lArm01", CubeListBuilder.create().texOffs(0, 49).addBox(0.0F, -1.0F, -2.5F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.8F, 0.5F, -2.7F));
        PartDefinition lArm02 = lArm01.addOrReplaceChild("lArm02", CubeListBuilder.create().texOffs(12, 58).addBox(-1.5F, -1.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2F, 4.6F, 0.0F, -0.0436F, 0.0F, 0.0F));
        PartDefinition lArm03 = lArm02.addOrReplaceChild("lArm03", CubeListBuilder.create().texOffs(14, 50).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.2F, 1.8F, 0.0F));
        PartDefinition lArmFur_r1 = lArm03.addOrReplaceChild("lArmFur_r1", CubeListBuilder.create().texOffs(56, 28).addBox(-0.5F, -2.5F, -1.25F, 1.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));
        PartDefinition lFrontHoofClaw01a = lArm03.addOrReplaceChild("lFrontHoofClaw01a", CubeListBuilder.create().texOffs(30, 34).mirror().addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.35F, 4.5F, -0.55F, 0.0F, -0.096F, 0.0F));
        PartDefinition lFrontHoofClaw01b = lFrontHoofClaw01a.addOrReplaceChild("lFrontHoofClaw01b", CubeListBuilder.create().texOffs(29, 28).mirror().addBox(-0.49F, -1.1F, -0.95F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.4363F, 0.0F, 0.0F));
        PartDefinition lFrontHoofClaw02a = lArm03.addOrReplaceChild("lFrontHoofClaw02a", CubeListBuilder.create().texOffs(30, 34).mirror().addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.65F, 4.5F, -0.55F, 0.0F, 0.0873F, 0.0F));
        PartDefinition lFrontHoofClaw02b = lFrontHoofClaw02a.addOrReplaceChild("lFrontHoofClaw02b", CubeListBuilder.create().texOffs(29, 28).mirror().addBox(-0.49F, -1.1F, -0.95F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.4363F, 0.0F, 0.0F));
        PartDefinition rArm01 = body.addOrReplaceChild("rArm01", CubeListBuilder.create().texOffs(0, 49).mirror().addBox(-3.0F, -1.0F, -2.5F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.8F, 0.5F, -2.7F));
        PartDefinition rArm02 = rArm01.addOrReplaceChild("rArm02", CubeListBuilder.create().texOffs(12, 58).mirror().addBox(-1.5F, -1.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.2F, 4.6F, 0.0F, -0.0436F, 0.0F, 0.0F));
        PartDefinition rArm03 = rArm02.addOrReplaceChild("rArm03", CubeListBuilder.create().texOffs(14, 50).mirror().addBox(-1.0F, 0.0F, -1.5F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.2F, 1.8F, 0.0F));
        PartDefinition rArmFur_r1 = rArm03.addOrReplaceChild("rArmFur_r1", CubeListBuilder.create().texOffs(56, 28).mirror().addBox(-0.5F, -2.5F, -1.25F, 1.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));
        PartDefinition rFrontHoofClaw01a = rArm03.addOrReplaceChild("rFrontHoofClaw01a", CubeListBuilder.create().texOffs(30, 34).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.35F, 4.5F, -0.55F, 0.0F, 0.096F, 0.0F));
        PartDefinition rFrontHoofClaw01b = rFrontHoofClaw01a.addOrReplaceChild("rFrontHoofClaw01b", CubeListBuilder.create().texOffs(29, 28).addBox(-0.51F, -1.1F, -0.95F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.4363F, 0.0F, 0.0F));
        PartDefinition rFrontHoofClaw02a = rArm03.addOrReplaceChild("rFrontHoofClaw02a", CubeListBuilder.create().texOffs(30, 34).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.65F, 4.5F, -0.55F, 0.0F, -0.0873F, 0.0F));
        PartDefinition rFrontHoofClaw02b = rFrontHoofClaw02a.addOrReplaceChild("rFrontHoofClaw02b", CubeListBuilder.create().texOffs(29, 28).addBox(-0.51F, -1.1F, -0.95F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.4363F, 0.0F, 0.0F));
        PartDefinition mane01 = body.addOrReplaceChild("mane01", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -3.4F, -6.95F, 0.5149F, 0.0F, 0.0F));
        PartDefinition Box_r1 = mane01.addOrReplaceChild("Box_r1", CubeListBuilder.create().texOffs(0, 38).addBox(-1.5F, -1.5F, -0.4F, 3.0F, 3.0F, 6.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -0.1F, -0.1F, 0.0F, 0.0F, 0.7854F));
        PartDefinition mane02 = body.addOrReplaceChild("mane02", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.65F, -4.1F, 0.1309F, 0.0F, 0.0F));
        PartDefinition Box_r2 = mane02.addOrReplaceChild("Box_r2", CubeListBuilder.create().texOffs(31, 13).addBox(-1.5F, -1.3F, -2.55F, 3.0F, 3.0F, 10.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -0.1F, 0.05F, 0.0F, 0.0F, 0.7854F));
        PartDefinition ass = body.addOrReplaceChild("ass", CubeListBuilder.create().texOffs(0, 22).addBox(-3.5F, -3.5F, 0.0F, 7.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 5.3F, -0.1309F, 0.0F, 0.0F));
        PartDefinition lLeg01 = ass.addOrReplaceChild("lLeg01", CubeListBuilder.create().texOffs(29, 0).addBox(-0.5F, -1.0F, -2.5F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2F, -1.7F, 3.95F, 0.0F, 0.0F, -0.0911F));
        PartDefinition lLeg02 = lLeg01.addOrReplaceChild("lLeg02", CubeListBuilder.create().texOffs(48, 0).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(1.7F, 3.9F, 0.15F, 0.3187F, 0.0F, 0.0911F));
        PartDefinition lLeg03 = lLeg02.addOrReplaceChild("lLeg03", CubeListBuilder.create().texOffs(47, 8).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.2F, 3.6F, 0.0F, -0.1745F, 0.0F, 0.0F));
        PartDefinition lHindHoofClaw01a = lLeg03.addOrReplaceChild("lHindHoofClaw01a", CubeListBuilder.create().texOffs(30, 34).mirror().addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.45F, 5.6F, -0.9F, 0.0F, -0.0524F, 0.0F));
        PartDefinition lHindHoofClaw01b = lHindHoofClaw01a.addOrReplaceChild("lHindHoofClaw01b", CubeListBuilder.create().texOffs(29, 28).mirror().addBox(-0.49F, -1.1F, -0.95F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.4363F, 0.0F, 0.0F));
        PartDefinition lHindHoofClaw02a = lLeg03.addOrReplaceChild("lHindHoofClaw02a", CubeListBuilder.create().texOffs(30, 34).mirror().addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.55F, 5.6F, -0.9F, 0.0F, 0.1309F, 0.0F));
        PartDefinition lHindHoofClaw02b2 = lHindHoofClaw02a.addOrReplaceChild("lHindHoofClaw02b2", CubeListBuilder.create().texOffs(29, 28).mirror().addBox(-0.49F, -1.1F, -0.95F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.4363F, 0.0F, 0.0F));
        PartDefinition rLeg01 = ass.addOrReplaceChild("rLeg01", CubeListBuilder.create().texOffs(29, 0).mirror().addBox(-3.5F, -1.0F, -2.5F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.2F, -1.7F, 3.95F, 0.0F, 0.0F, 0.0911F));
        PartDefinition rLeg02 = rLeg01.addOrReplaceChild("rLeg02", CubeListBuilder.create().texOffs(48, 0).mirror().addBox(-1.5F, 0.0F, -2.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-1.7F, 3.9F, 0.15F, 0.3187F, 0.0F, -0.0911F));
        PartDefinition rLeg03 = rLeg02.addOrReplaceChild("rLeg03", CubeListBuilder.create().texOffs(47, 8).mirror().addBox(-1.0F, 0.0F, -1.5F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-0.2F, 3.6F, 0.0F, -0.1745F, 0.0F, 0.0F));
        PartDefinition rHindHoofClaw01a = rLeg03.addOrReplaceChild("rHindHoofClaw01a", CubeListBuilder.create().texOffs(30, 34).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.45F, 5.6F, -0.9F, 0.0F, 0.0524F, 0.0F));
        PartDefinition rHindHoofClaw01b = rHindHoofClaw01a.addOrReplaceChild("rHindHoofClaw01b", CubeListBuilder.create().texOffs(29, 28).addBox(-0.51F, -1.1F, -0.95F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.4363F, 0.0F, 0.0F));
        PartDefinition rHindHoofClaw02a = rLeg03.addOrReplaceChild("rHindHoofClaw02a", CubeListBuilder.create().texOffs(30, 34).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.55F, 5.6F, -0.9F, 0.0F, -0.1309F, 0.0F));
        PartDefinition rHindHoofClaw02b = rHindHoofClaw02a.addOrReplaceChild("rHindHoofClaw02b", CubeListBuilder.create().texOffs(29, 28).addBox(-0.51F, -1.1F, -0.95F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.4363F, 0.0F, 0.0F));
        PartDefinition tail = ass.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(24, 53).addBox(-0.5F, 0.0F, -0.2F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.2F, 6.5F, 0.2618F, 0.0F, 0.0F));
        PartDefinition tailFur = tail.addOrReplaceChild("tailFur", CubeListBuilder.create().texOffs(36, 53).addBox(-0.9F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.95F, 0.2F, -0.0873F, 0.0F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(23, 38).addBox(-2.5F, -3.5F, -5.0F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.3F, -5.5F));
        PartDefinition snoot = head.addOrReplaceChild("snoot", CubeListBuilder.create().texOffs(42, 36).addBox(-1.55F, -1.5F, -4.7F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.6F, -4.4F, 0.2731F, 0.0F, 0.0F));
        PartDefinition nose = snoot.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(56, 50).addBox(-1.5F, -1.5F, -0.8F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, -0.4F, -4.3F, -0.1367F, 0.0F, 0.0F));
        PartDefinition upperJaw = head.addOrReplaceChild("upperJaw", CubeListBuilder.create().texOffs(44, 43).addBox(-1.5F, -1.0F, -4.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.7F, -4.4F));
        PartDefinition lUpperTusk = upperJaw.addOrReplaceChild("lUpperTusk", CubeListBuilder.create().texOffs(0, 1).mirror().addBox(-0.55F, -2.7F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.15F)).mirror(false), PartPose.offsetAndRotation(1.3F, 1.0F, -1.75F, 0.0F, 0.0F, 0.3054F));
        PartDefinition rUpperTusk = upperJaw.addOrReplaceChild("rUpperTusk", CubeListBuilder.create().texOffs(0, 1).addBox(-0.45F, -2.7F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(-1.3F, 1.0F, -1.75F, 0.0F, 0.0F, -0.3054F));
        PartDefinition lowerJaw = head.addOrReplaceChild("lowerJaw", CubeListBuilder.create().texOffs(44, 49).addBox(-1.5F, -0.5F, -4.7F, 3.0F, 1.0F, 5.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 2.2F, -4.1F, -0.0873F, 0.0F, 0.0F));
        PartDefinition lTusk01 = lowerJaw.addOrReplaceChild("lTusk01", CubeListBuilder.create().texOffs(0, 1).mirror().addBox(-0.5F, -1.8F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.3F, 0.0F, -2.8F, 0.2443F, 0.0F, 0.3054F));
        PartDefinition lTusk02 = lTusk01.addOrReplaceChild("lTusk02", CubeListBuilder.create().texOffs(0, 1).mirror().addBox(-0.55F, -1.7F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.75F, 0.0F, 0.0F, 0.0F, -0.1745F));
        PartDefinition rTusk01 = lowerJaw.addOrReplaceChild("rTusk01", CubeListBuilder.create().texOffs(0, 1).addBox(-0.5F, -1.8F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3F, 0.0F, -2.8F, 0.2443F, 0.0F, -0.3054F));
        PartDefinition rTusk02 = rTusk01.addOrReplaceChild("rTusk02", CubeListBuilder.create().texOffs(0, 1).addBox(-0.45F, -1.7F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -1.75F, 0.0F, 0.0F, 0.0F, 0.1745F));
        PartDefinition lEar01 = head.addOrReplaceChild("lEar01", CubeListBuilder.create().texOffs(56, 17).mirror().addBox(0.2F, -3.0F, -0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.7F, -2.7F, -2.7F, 0.0F, -0.3927F, 0.3927F));
        PartDefinition lEar02 = lEar01.addOrReplaceChild("lEar02", CubeListBuilder.create().texOffs(58, 9).mirror().addBox(-1.25F, -4.25F, -0.5F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.6F, 0.0F, 0.7F));
        PartDefinition rEar01 = head.addOrReplaceChild("rEar01", CubeListBuilder.create().texOffs(56, 17).addBox(-2.2F, -3.0F, -0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7F, -2.7F, -2.7F, 0.0F, 0.3927F, -0.3927F));
        PartDefinition rEar02 = rEar01.addOrReplaceChild("rEar02", CubeListBuilder.create().texOffs(58, 9).addBox(-1.0F, -4.0F, -0.5F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.35F, -0.25F, 0.7F));
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.quadriped(lLeg01, lArm01, rLeg01, rArm01, limbSwing * 0.666F, limbSwingAmount * 1.4F);
        this.headPitch(head, headPitch);
        this.headYaw(head, netHeadYaw);
    }

}
