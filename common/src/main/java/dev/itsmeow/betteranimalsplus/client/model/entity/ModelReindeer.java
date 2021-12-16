package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import dev.itsmeow.betteranimalsplus.common.entity.EntityReindeer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;

public class ModelReindeer<T extends LivingEntity> extends ModelBAP<T> {

    public ModelPart body;
    public ModelPart ass;
    public ModelPart lHindLeg01;
    public ModelPart lHindLeg02;
    public ModelPart lHindLeg03;
    public ModelPart lHHoofClaw01a;
    public ModelPart lHHoofClaw01b;
    public ModelPart lHHoofClaw02a;
    public ModelPart lHHoofClaw02b;
    public ModelPart rHindLeg01;
    public ModelPart rHindLeg02;
    public ModelPart rHindLeg03;
    public ModelPart rHHoofClaw01a;
    public ModelPart rHHoofClaw01b;
    public ModelPart rHHoofClaw02a;
    public ModelPart rHHoofClaw02b;
    public ModelPart tail;
    public ModelPart lowerNeck;
    public ModelPart upperNeck;
    public ModelPart christmas_harness_bell_r1;
    public ModelPart head;
    public ModelPart lowerJawBack;
    public ModelPart lowerLip;
    public ModelPart lEar;
    public ModelPart rEar;
    public ModelPart lAntler01;
    public ModelPart lAntler02;
    public ModelPart lAntler03;
    public ModelPart lAntler04;
    public ModelPart lAntler05;
    public ModelPart lAntler08;
    public ModelPart lAntler09;
    public ModelPart lAntler06;
    public ModelPart lAntler07;
    public ModelPart lAntler10;
    public ModelPart lAntler11;
    public ModelPart lAntler12;
    public ModelPart lAntler13;
    public ModelPart lAntler14;
    public ModelPart lAntler15;
    public ModelPart lAntler16;
    public ModelPart snout;
    public ModelPart christmas_nose;
    public ModelPart rAntler01;
    public ModelPart rAntler02;
    public ModelPart rAntler03;
    public ModelPart rAntler04;
    public ModelPart rAntler05;
    public ModelPart rAntler08;
    public ModelPart rAntler09;
    public ModelPart rAntler06;
    public ModelPart rAntler07;
    public ModelPart rAntler10;
    public ModelPart rAntler11;
    public ModelPart rAntler12;
    public ModelPart rAntler13;
    public ModelPart rAntler14;
    public ModelPart rAntler15;
    public ModelPart rAntler16;
    public ModelPart mane01;
    public ModelPart mane02;
    public ModelPart mane03;
    public ModelPart mane04;
    public ModelPart lForeleg01;
    public ModelPart lForeleg02;
    public ModelPart lForeleg03;
    public ModelPart lFHoofClaw01a;
    public ModelPart lFHoofClaw01b;
    public ModelPart lFHoofClaw02a;
    public ModelPart lFHoofClaw02b;
    public ModelPart rForeleg01;
    public ModelPart rForeleg02;
    public ModelPart rForeleg03;
    public ModelPart rFHoofClaw01a;
    public ModelPart rFHoofClaw01b;
    public ModelPart rFHoofClaw02a;
    public ModelPart rFHoofClaw02b;
    public ModelPart bodyFur;

    public ModelReindeer(ModelPart root) {
        this.body = root.getChild("body");
        this.ass = body.getChild("ass");
        this.lHindLeg01 = ass.getChild("lHindLeg01");
        this.lHindLeg02 = lHindLeg01.getChild("lHindLeg02");
        this.lHindLeg03 = lHindLeg02.getChild("lHindLeg03");
        this.lHHoofClaw01a = lHindLeg03.getChild("lHHoofClaw01a");
        this.lHHoofClaw01b = lHHoofClaw01a.getChild("lHHoofClaw01b");
        this.lHHoofClaw02a = lHindLeg03.getChild("lHHoofClaw02a");
        this.lHHoofClaw02b = lHHoofClaw02a.getChild("lHHoofClaw02b");
        this.rHindLeg01 = ass.getChild("rHindLeg01");
        this.rHindLeg02 = rHindLeg01.getChild("rHindLeg02");
        this.rHindLeg03 = rHindLeg02.getChild("rHindLeg03");
        this.rHHoofClaw01a = rHindLeg03.getChild("rHHoofClaw01a");
        this.rHHoofClaw01b = rHHoofClaw01a.getChild("rHHoofClaw01b");
        this.rHHoofClaw02a = rHindLeg03.getChild("rHHoofClaw02a");
        this.rHHoofClaw02b = rHHoofClaw02a.getChild("rHHoofClaw02b");
        this.tail = ass.getChild("tail");
        this.lowerNeck = body.getChild("lowerNeck");
        this.upperNeck = lowerNeck.getChild("upperNeck");
        this.christmas_harness_bell_r1 = upperNeck.getChild("christmas_harness_bell_r1");
        this.head = upperNeck.getChild("head");
        this.lowerJawBack = head.getChild("lowerJawBack");
        this.lowerLip = lowerJawBack.getChild("lowerLip");
        this.lEar = head.getChild("lEar");
        this.rEar = head.getChild("rEar");
        this.lAntler01 = head.getChild("lAntler01");
        this.lAntler02 = lAntler01.getChild("lAntler02");
        this.lAntler03 = lAntler02.getChild("lAntler03");
        this.lAntler04 = lAntler03.getChild("lAntler04");
        this.lAntler05 = lAntler04.getChild("lAntler05");
        this.lAntler08 = lAntler04.getChild("lAntler08");
        this.lAntler09 = lAntler08.getChild("lAntler09");
        this.lAntler06 = lAntler03.getChild("lAntler06");
        this.lAntler07 = lAntler06.getChild("lAntler07");
        this.lAntler10 = lAntler02.getChild("lAntler10");
        this.lAntler11 = lAntler10.getChild("lAntler11");
        this.lAntler12 = lAntler11.getChild("lAntler12");
        this.lAntler13 = lAntler11.getChild("lAntler13");
        this.lAntler14 = lAntler01.getChild("lAntler14");
        this.lAntler15 = lAntler14.getChild("lAntler15");
        this.lAntler16 = lAntler14.getChild("lAntler16");
        this.snout = head.getChild("snout");
        this.christmas_nose = snout.getChild("christmas_nose");
        this.rAntler01 = head.getChild("rAntler01");
        this.rAntler02 = rAntler01.getChild("rAntler02");
        this.rAntler03 = rAntler02.getChild("rAntler03");
        this.rAntler04 = rAntler03.getChild("rAntler04");
        this.rAntler05 = rAntler04.getChild("rAntler05");
        this.rAntler08 = rAntler04.getChild("rAntler08");
        this.rAntler09 = rAntler08.getChild("rAntler09");
        this.rAntler06 = rAntler03.getChild("rAntler06");
        this.rAntler07 = rAntler06.getChild("rAntler07");
        this.rAntler10 = rAntler02.getChild("rAntler10");
        this.rAntler11 = rAntler10.getChild("rAntler11");
        this.rAntler12 = rAntler11.getChild("rAntler12");
        this.rAntler13 = rAntler11.getChild("rAntler13");
        this.rAntler14 = rAntler01.getChild("rAntler14");
        this.rAntler15 = rAntler14.getChild("rAntler15");
        this.rAntler16 = rAntler14.getChild("rAntler16");
        this.mane01 = upperNeck.getChild("mane01");
        this.mane02 = upperNeck.getChild("mane02");
        this.mane03 = lowerNeck.getChild("mane03");
        this.mane04 = lowerNeck.getChild("mane04");
        this.lForeleg01 = body.getChild("lForeleg01");
        this.lForeleg02 = lForeleg01.getChild("lForeleg02");
        this.lForeleg03 = lForeleg02.getChild("lForeleg03");
        this.lFHoofClaw01a = lForeleg03.getChild("lFHoofClaw01a");
        this.lFHoofClaw01b = lFHoofClaw01a.getChild("lFHoofClaw01b");
        this.lFHoofClaw02a = lForeleg03.getChild("lFHoofClaw02a");
        this.lFHoofClaw02b = lFHoofClaw02a.getChild("lFHoofClaw02b");
        this.rForeleg01 = body.getChild("rForeleg01");
        this.rForeleg02 = rForeleg01.getChild("rForeleg02");
        this.rForeleg03 = rForeleg02.getChild("rForeleg03");
        this.rFHoofClaw01a = rForeleg03.getChild("rFHoofClaw01a");
        this.rFHoofClaw01b = rFHoofClaw01a.getChild("rFHoofClaw01b");
        this.rFHoofClaw02a = rForeleg03.getChild("rFHoofClaw02a");
        this.rFHoofClaw02b = rFHoofClaw02a.getChild("rFHoofClaw02b");
        this.bodyFur = body.getChild("bodyFur");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 13).addBox(-4.0F, -3.5F, -15.0F, 8.0F, 9.0F, 13.0F, new CubeDeformation(0.0F))
                .texOffs(104, 35).addBox(-4.0F, -3.5F, -9.0F, 8.0F, 9.0F, 3.0F, new CubeDeformation(0.2F))
                .texOffs(106, 12).addBox(-4.0F, -3.5F, -14.75F, 8.0F, 9.0F, 2.0F, new CubeDeformation(0.2F))
                .texOffs(116, 26).addBox(4.19F, -3.5F, -12.75F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(116, 26).mirror().addBox(-4.19F, -3.5F, -12.75F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 7.5F, 5.8F));
        PartDefinition ass = body.addOrReplaceChild("ass", CubeListBuilder.create().texOffs(0, 35).addBox(-3.5F, -3.5F, 0.0F, 7.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.3F, -2.7F, -0.182F, 0.0F, 0.0F));
        PartDefinition lHindLeg01 = ass.addOrReplaceChild("lHindLeg01", CubeListBuilder.create().texOffs(64, 0).addBox(0.0F, -1.9F, -2.0F, 3.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -1.1F, 3.3F, -0.2276F, 0.0F, 0.0F));
        PartDefinition lHindLeg02 = lHindLeg01.addOrReplaceChild("lHindLeg02", CubeListBuilder.create().texOffs(65, 16).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4F, 5.0F, -1.1F, 0.9105F, 0.0F, 0.0F));
        PartDefinition lHindLeg03 = lHindLeg02.addOrReplaceChild("lHindLeg03", CubeListBuilder.create().texOffs(68, 30).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, 5.4F, 0.5F, -0.5009F, 0.0F, 0.0F));
        PartDefinition lHHoofClaw01a = lHindLeg03.addOrReplaceChild("lHHoofClaw01a", CubeListBuilder.create().texOffs(81, 19).addBox(-0.55F, -0.4F, -1.75F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.55F, 8.4F, -0.75F, 0.0F, -0.1309F, 0.0F));
        PartDefinition lHHoofClaw01b = lHHoofClaw01a.addOrReplaceChild("lHHoofClaw01b", CubeListBuilder.create().texOffs(83, 13).mirror().addBox(-0.54F, -1.0F, -0.95F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.4363F, 0.0F, 0.0F));
        PartDefinition lHHoofClaw02a = lHindLeg03.addOrReplaceChild("lHHoofClaw02a", CubeListBuilder.create().texOffs(81, 19).mirror().addBox(-0.55F, -0.39F, -1.75F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-0.45F, 8.4F, -0.75F, 0.0F, 0.0436F, 0.0F));
        PartDefinition lHHoofClaw02b = lHHoofClaw02a.addOrReplaceChild("lHHoofClaw02b", CubeListBuilder.create().texOffs(83, 13).mirror().addBox(-0.54F, -1.0F, -0.95F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.4363F, 0.0F, 0.0F));
        PartDefinition rHindLeg01 = ass.addOrReplaceChild("rHindLeg01", CubeListBuilder.create().texOffs(64, 0).mirror().addBox(-3.0F, -1.9F, -2.0F, 3.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.5F, -1.1F, 3.3F, -0.2276F, 0.0F, 0.0F));
        PartDefinition rHindLeg02 = rHindLeg01.addOrReplaceChild("rHindLeg02", CubeListBuilder.create().texOffs(65, 16).mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.4F, 5.0F, -1.1F, 0.9105F, 0.0F, 0.0F));
        PartDefinition rHindLeg03 = rHindLeg02.addOrReplaceChild("rHindLeg03", CubeListBuilder.create().texOffs(68, 30).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.1F, 5.4F, 0.5F, -0.5009F, 0.0F, 0.0F));
        PartDefinition rHHoofClaw01a = rHindLeg03.addOrReplaceChild("rHHoofClaw01a", CubeListBuilder.create().texOffs(81, 19).mirror().addBox(-0.45F, -0.4F, -1.75F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-0.55F, 8.4F, -0.75F, 0.0F, 0.1309F, 0.0F));
        PartDefinition rHHoofClaw01b = rHHoofClaw01a.addOrReplaceChild("rHHoofClaw01b", CubeListBuilder.create().texOffs(83, 13).addBox(-0.46F, -1.0F, -0.95F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.4363F, 0.0F, 0.0F));
        PartDefinition rHHoofClaw02a = rHindLeg03.addOrReplaceChild("rHHoofClaw02a", CubeListBuilder.create().texOffs(81, 19).addBox(-0.45F, -0.39F, -1.75F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.45F, 8.4F, -0.75F, 0.0F, -0.0436F, 0.0F));
        PartDefinition rHHoofClaw02b = rHHoofClaw02a.addOrReplaceChild("rHHoofClaw02b", CubeListBuilder.create().texOffs(83, 13).addBox(-0.46F, -1.0F, -0.95F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.4363F, 0.0F, 0.0F));
        PartDefinition tail = ass.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(33, 0).addBox(-1.5F, 0.0F, -1.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.7F, 5.1F, 0.5918F, 0.0F, 0.0F));
        PartDefinition lowerNeck = body.addOrReplaceChild("lowerNeck", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -3.0F, -5.0F, 7.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.8F, -12.6F, -0.6829F, 0.0F, 0.0F));
        PartDefinition upperNeck = lowerNeck.addOrReplaceChild("upperNeck", CubeListBuilder.create().texOffs(88, 0).addBox(-2.5F, -2.5F, -5.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.1F))
                .texOffs(114, 50).addBox(-2.5F, -2.5F, -3.75F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 0.3F, -4.0F, -0.3187F, 0.0F, 0.0F));
        PartDefinition christmas_harness_bell_r1 = upperNeck.addOrReplaceChild("christmas_harness_bell_r1", CubeListBuilder.create().texOffs(92, 47).addBox(-1.0F, -1.25F, -0.75F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -2.0F, -0.6109F, 0.0F, 0.0F));
        PartDefinition head = upperNeck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(88, 15).addBox(-2.5F, -3.0F, -4.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.1F, -4.0F, -0.3491F, 0.0F, 0.0F));
        PartDefinition lowerJawBack = head.addOrReplaceChild("lowerJawBack", CubeListBuilder.create().texOffs(102, 29).addBox(-1.5F, 1.6F, -1.25F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offset(0.0F, -0.2F, -0.9F));
        PartDefinition lowerLip = lowerJawBack.addOrReplaceChild("lowerLip", CubeListBuilder.create().texOffs(103, 29).addBox(-1.5F, -0.65F, -0.95F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 3.0F, 0.7F));
        PartDefinition lEar = head.addOrReplaceChild("lEar", CubeListBuilder.create().texOffs(0, 13).addBox(-1.0F, -0.7F, -3.1F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8F, -1.75F, -3.0F, 0.2618F, -1.1519F, -0.3665F));
        PartDefinition rEar = head.addOrReplaceChild("rEar", CubeListBuilder.create().texOffs(0, 13).mirror().addBox(-1.0F, -0.7F, -3.1F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.8F, -1.75F, -3.0F, 0.2618F, 1.1519F, 0.3665F));
        PartDefinition lAntler01 = head.addOrReplaceChild("lAntler01", CubeListBuilder.create().texOffs(117, 0).addBox(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.35F, -1.0F, -4.25F, -0.2793F, -0.4363F, 0.0F));
        PartDefinition lAntler02 = lAntler01.addOrReplaceChild("lAntler02", CubeListBuilder.create().texOffs(117, 0).addBox(-0.5F, -6.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.3F, -2.1F, 0.6981F, -0.1745F, 0.2094F));
        PartDefinition lAntler03 = lAntler02.addOrReplaceChild("lAntler03", CubeListBuilder.create().texOffs(117, 0).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.7F, 0.1F, -0.9076F, 0.2269F, 0.2269F));
        PartDefinition lAntler04 = lAntler03.addOrReplaceChild("lAntler04", CubeListBuilder.create().texOffs(117, 0).addBox(-0.5F, -0.5F, -5.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.1F, -1.6F, 0.6981F, 0.2269F, 0.0F));
        PartDefinition lAntler05 = lAntler04.addOrReplaceChild("lAntler05", CubeListBuilder.create().texOffs(117, 0).addBox(-3.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2F, 0.0F, -4.6F, 0.0F, -0.6981F, 0.0F));
        PartDefinition lAntler08 = lAntler04.addOrReplaceChild("lAntler08", CubeListBuilder.create().texOffs(117, 0).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.1F, -2.5F, 0.5934F, 0.0F, -0.3142F));
        PartDefinition lAntler09 = lAntler08.addOrReplaceChild("lAntler09", CubeListBuilder.create().texOffs(117, 0).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.8F, 0.0F, 0.0F, 0.0F, -0.3491F));
        PartDefinition lAntler06 = lAntler03.addOrReplaceChild("lAntler06", CubeListBuilder.create().texOffs(117, 0).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.1F, -1.6F, 0.3491F, 0.2269F, -0.3142F));
        PartDefinition lAntler07 = lAntler06.addOrReplaceChild("lAntler07", CubeListBuilder.create().texOffs(117, 0).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.8F, 0.0F, 0.0F, 0.0F, -0.3491F));
        PartDefinition lAntler10 = lAntler02.addOrReplaceChild("lAntler10", CubeListBuilder.create().texOffs(117, 0).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.9F, 0.0F, 0.4363F, -0.4363F, -0.2269F));
        PartDefinition lAntler11 = lAntler10.addOrReplaceChild("lAntler11", CubeListBuilder.create().texOffs(117, 0).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, 0.0F, -2.7F, 0.0F, 0.5236F, 0.0F));
        PartDefinition lAntler12 = lAntler11.addOrReplaceChild("lAntler12", CubeListBuilder.create().texOffs(117, 0).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, 0.0F, -1.7F, -0.3665F, 0.5236F, 0.0F));
        PartDefinition lAntler13 = lAntler11.addOrReplaceChild("lAntler13", CubeListBuilder.create().texOffs(117, 0).addBox(-0.5F, -0.5F, -3.8F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, 0.2F, -0.7F, 0.4538F, 0.3491F, 0.0F));
        PartDefinition lAntler14 = lAntler01.addOrReplaceChild("lAntler14", CubeListBuilder.create().texOffs(117, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.4F, -0.3F, -0.192F, 0.0F, 0.0F));
        PartDefinition lAntler15 = lAntler14.addOrReplaceChild("lAntler15", CubeListBuilder.create().texOffs(117, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.8F, 0.0F, -0.3142F, 0.0F, 0.3665F));
        PartDefinition lAntler16 = lAntler14.addOrReplaceChild("lAntler16", CubeListBuilder.create().texOffs(117, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, 0.4189F, 0.0F, 0.3665F));
        PartDefinition snout = head.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(88, 35).addBox(-2.0F, -0.45F, -1.15F, 4.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.25F, -2.3F, 0.2618F, 0.0F, 0.0F));
        PartDefinition christmas_nose = snout.addOrReplaceChild("christmas_nose", CubeListBuilder.create().texOffs(22, 0).addBox(-1.0F, -0.75F, -0.15F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, -2.0F));
        PartDefinition rAntler01 = head.addOrReplaceChild("rAntler01", CubeListBuilder.create().texOffs(117, 0).mirror().addBox(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.35F, -1.0F, -4.25F, -0.2793F, 0.4363F, 0.0F));
        PartDefinition rAntler02 = rAntler01.addOrReplaceChild("rAntler02", CubeListBuilder.create().texOffs(117, 0).mirror().addBox(-0.5F, -6.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.3F, -2.1F, 0.6981F, 0.1745F, -0.2094F));
        PartDefinition rAntler03 = rAntler02.addOrReplaceChild("rAntler03", CubeListBuilder.create().texOffs(117, 0).mirror().addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -5.7F, 0.1F, -0.9076F, -0.2269F, -0.2269F));
        PartDefinition rAntler04 = rAntler03.addOrReplaceChild("rAntler04", CubeListBuilder.create().texOffs(117, 0).mirror().addBox(-0.5F, -0.5F, -5.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -0.1F, -1.6F, 0.6981F, -0.2269F, 0.0F));
        PartDefinition rAntler05 = rAntler04.addOrReplaceChild("rAntler05", CubeListBuilder.create().texOffs(117, 0).mirror().addBox(0.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.2F, 0.0F, -4.6F, 0.0F, 0.6981F, 0.0F));
        PartDefinition rAntler08 = rAntler04.addOrReplaceChild("rAntler08", CubeListBuilder.create().texOffs(117, 0).mirror().addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -0.1F, -2.5F, 0.5934F, 0.0F, 0.3142F));
        PartDefinition rAntler09 = rAntler08.addOrReplaceChild("rAntler09", CubeListBuilder.create().texOffs(117, 0).mirror().addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.8F, 0.0F, 0.0F, 0.0F, 0.3491F));
        PartDefinition rAntler06 = rAntler03.addOrReplaceChild("rAntler06", CubeListBuilder.create().texOffs(117, 0).mirror().addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -0.1F, -1.6F, 0.3491F, -0.2269F, 0.3142F));
        PartDefinition rAntler07 = rAntler06.addOrReplaceChild("rAntler07", CubeListBuilder.create().texOffs(117, 0).mirror().addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.8F, 0.0F, 0.0F, 0.0F, 0.3491F));
        PartDefinition rAntler10 = rAntler02.addOrReplaceChild("rAntler10", CubeListBuilder.create().texOffs(117, 0).mirror().addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -0.9F, 0.0F, 0.4363F, 0.4363F, 0.2269F));
        PartDefinition rAntler11 = rAntler10.addOrReplaceChild("rAntler11", CubeListBuilder.create().texOffs(117, 0).mirror().addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.1F, 0.0F, -2.7F, 0.0F, -0.5236F, 0.0F));
        PartDefinition rAntler12 = rAntler11.addOrReplaceChild("rAntler12", CubeListBuilder.create().texOffs(117, 0).mirror().addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.1F, 0.0F, -1.7F, -0.3665F, -0.5236F, 0.0F));
        PartDefinition rAntler13 = rAntler11.addOrReplaceChild("rAntler13", CubeListBuilder.create().texOffs(117, 0).mirror().addBox(-0.5F, -0.5F, -3.8F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.1F, 0.2F, -0.7F, 0.4538F, -0.3491F, 0.0F));
        PartDefinition rAntler14 = rAntler01.addOrReplaceChild("rAntler14", CubeListBuilder.create().texOffs(117, 0).mirror().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.4F, -0.3F, -0.192F, 0.0F, 0.0F));
        PartDefinition rAntler15 = rAntler14.addOrReplaceChild("rAntler15", CubeListBuilder.create().texOffs(117, 0).mirror().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 2.8F, 0.0F, -0.3142F, 0.0F, -0.3665F));
        PartDefinition rAntler16 = rAntler14.addOrReplaceChild("rAntler16", CubeListBuilder.create().texOffs(117, 0).mirror().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, 0.4189F, 0.0F, -0.3665F));
        PartDefinition mane01 = upperNeck.addOrReplaceChild("mane01", CubeListBuilder.create().texOffs(0, 50).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.5F, -3.3F, -0.5463F, 0.0F, 0.0F));
        PartDefinition mane02 = upperNeck.addOrReplaceChild("mane02", CubeListBuilder.create().texOffs(20, 50).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.5F, -1.95F, -0.5463F, 0.0F, 0.0F));
        PartDefinition mane03 = lowerNeck.addOrReplaceChild("mane03", CubeListBuilder.create().texOffs(46, 50).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.7F, -4.9F, -0.7679F, 0.0F, 0.0F));
        PartDefinition mane04 = lowerNeck.addOrReplaceChild("mane04", CubeListBuilder.create().texOffs(72, 50).addBox(-3.0F, -1.0F, 0.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.8F, -3.1F, -0.7679F, 0.0F, 0.0F));
        PartDefinition lForeleg01 = body.addOrReplaceChild("lForeleg01", CubeListBuilder.create().texOffs(45, 0).addBox(-1.0F, -2.4F, -2.5F, 3.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1F, 0.6F, -12.7F, 0.1367F, 0.0F, -0.0911F));
        PartDefinition lForeleg02 = lForeleg01.addOrReplaceChild("lForeleg02", CubeListBuilder.create().texOffs(48, 14).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8F, 4.4F, 0.1F, 0.0F, 0.0F, 0.0911F));
        PartDefinition lForeleg03 = lForeleg02.addOrReplaceChild("lForeleg03", CubeListBuilder.create().texOffs(50, 26).addBox(-1.05F, 1.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.7F, 0.0F, -0.1367F, 0.0F, 0.0F));
        PartDefinition lFHoofClaw01a = lForeleg03.addOrReplaceChild("lFHoofClaw01a", CubeListBuilder.create().texOffs(81, 19).addBox(-0.55F, -0.4F, -1.75F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.65F, 9.45F, -0.4F, 0.0F, -0.1309F, 0.0F));
        PartDefinition lFHoofClaw01b = lFHoofClaw01a.addOrReplaceChild("lFHoofClaw01b", CubeListBuilder.create().texOffs(83, 13).mirror().addBox(-0.54F, -0.95F, -1.2F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.4363F, 0.0F, 0.0F));
        PartDefinition lFHoofClaw02a = lForeleg03.addOrReplaceChild("lFHoofClaw02a", CubeListBuilder.create().texOffs(81, 19).mirror().addBox(-0.55F, -0.39F, -1.75F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offset(-0.6F, 9.45F, -0.4F));
        PartDefinition lFHoofClaw02b = lFHoofClaw02a.addOrReplaceChild("lFHoofClaw02b", CubeListBuilder.create().texOffs(83, 13).mirror().addBox(-0.54F, -0.95F, -1.2F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.4363F, 0.0F, 0.0F));
        PartDefinition rForeleg01 = body.addOrReplaceChild("rForeleg01", CubeListBuilder.create().texOffs(45, 0).mirror().addBox(-2.0F, -2.4F, -2.5F, 3.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.1F, 0.6F, -12.7F, 0.1367F, 0.0F, 0.0911F));
        PartDefinition rForeleg02 = rForeleg01.addOrReplaceChild("rForeleg02", CubeListBuilder.create().texOffs(48, 14).mirror().addBox(-1.0F, 0.0F, -1.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.8F, 4.4F, 0.1F, 0.0F, 0.0F, -0.0911F));
        PartDefinition rForeleg03 = rForeleg02.addOrReplaceChild("rForeleg03", CubeListBuilder.create().texOffs(50, 26).mirror().addBox(-0.95F, 1.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.7F, 0.0F, -0.1367F, 0.0F, 0.0F));
        PartDefinition rFHoofClaw01a = rForeleg03.addOrReplaceChild("rFHoofClaw01a", CubeListBuilder.create().texOffs(81, 19).mirror().addBox(-0.45F, -0.4F, -1.75F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-0.65F, 9.45F, -0.4F, 0.0F, 0.1309F, 0.0F));
        PartDefinition rFHoofClaw01b = rFHoofClaw01a.addOrReplaceChild("rFHoofClaw01b", CubeListBuilder.create().texOffs(83, 13).addBox(-0.46F, -0.95F, -1.2F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.4363F, 0.0F, 0.0F));
        PartDefinition rFHoofClaw02a = rForeleg03.addOrReplaceChild("rFHoofClaw02a", CubeListBuilder.create().texOffs(81, 19).addBox(-0.45F, -0.39F, -1.75F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offset(0.6F, 9.45F, -0.4F));
        PartDefinition rFHoofClaw02b = rFHoofClaw02a.addOrReplaceChild("rFHoofClaw02b", CubeListBuilder.create().texOffs(83, 13).addBox(-0.46F, -0.95F, -1.2F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.4363F, 0.0F, 0.0F));
        PartDefinition bodyFur = body.addOrReplaceChild("bodyFur", CubeListBuilder.create().texOffs(94, 52).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.3F, -13.7F));
        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.body.render(poseStack, vertexConsumer, packedLightIn, packedOverlayIn);
    }

    private static float updateReindeerRotation(float p_110683_1_, float p_110683_2_, float p_110683_3_) {
        float f;
        for(f = p_110683_2_ - p_110683_1_; f < -180.0F; f += 360.0F) {

        }
        while(f >= 180.0F) {
            f -= 360.0F;
        }
        return p_110683_1_ + p_110683_3_ * f;
    }

    @Override
    public void prepareMobModel(T entity, float limbSwing, float limbSwingAmount, float partialTickTime) {
        float f = ModelReindeer.updateReindeerRotation(entity.yBodyRotO, entity.yBodyRot, partialTickTime);
        float f1 = ModelReindeer.updateReindeerRotation(entity.yHeadRotO, entity.yHeadRot, partialTickTime);
        float f2 = entity.xRotO + (entity.getXRot() - entity.xRotO) * partialTickTime;
        float f3 = Mth.clamp(f1 - f, -20F, 20F);
        float f4 = rad(f2);
        if(limbSwingAmount > 0.2F) {
            f4 += Mth.cos(limbSwing * 0.4F) * 0.15F * limbSwingAmount;
        }
        EntityReindeer entityreindeer = (EntityReindeer) entity;
        float f5 = entityreindeer.getGrassEatingAmount(partialTickTime);
        float f6 = entityreindeer.getRearingAmount(partialTickTime);
        float f7 = 1.0F - f6;
        float f8 = entityreindeer.getMouthOpennessAngle(partialTickTime);
        this.body.xRot = 0.0F;
        float f16 = f3 * 0.017453292F;
        this.body.xRot = (f6 * -((float) Math.PI / 4F) + f7 * this.body.xRot) * 0.65F;
        this.lowerNeck.xRot = f6 * (0.2617994F + f4) + f5 * 2.1816616F + (1.0F - Math.max(f6, f5)) * (0.5235988F + f4) - (float) Math.toRadians(55);
        this.snout.xRot = -0.09424778F * f8;
        this.lowerJawBack.xRot = 0.15707964F * f8;
        this.lowerNeck.yRot = f6 * f3 * 0.017453292F + (1.0F - Math.max(f6, f5)) * f16;
        float f9 = entity.tickCount + partialTickTime;
        float f10 = Mth.cos(limbSwing * 0.6662F + (float) Math.PI);
        float f11 = f10 * 0.8F * limbSwingAmount;
        float f12 = 0.2617994F * f6;
        float f13 = Mth.cos(f9 * 0.6F + (float) Math.PI);
        float f14 = ((-1.0471976F + f13) * f6 + f11 * f7) * 0.8F;
        float f15 = ((-1.0471976F - f13) * f6 + -f11 * f7) * 0.8F;
        this.lHindLeg01.xRot = f12 + -f10 * 0.5F * limbSwingAmount * f7 - 0.22759093446006054F;
        this.rHindLeg01.xRot = f12 + f10 * 0.5F * limbSwingAmount * f7 - 0.22759093446006054F;
        this.lForeleg01.xRot = f14 + 0.136659280431156F;
        this.rForeleg01.xRot = f15 + 0.136659280431156F;
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}
}
