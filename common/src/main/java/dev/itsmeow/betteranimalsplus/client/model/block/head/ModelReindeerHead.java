package dev.itsmeow.betteranimalsplus.client.model.block.head;

import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAPHead;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class ModelReindeerHead<T extends Entity> extends ModelBAPHead<T> {

    public ModelPart lowerNeck;
    public ModelPart upperNeck;
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

    public ModelReindeerHead(ModelPart root) {
        super(false);
        this.lowerNeck = root.getChild("lowerNeck");
        this.upperNeck = lowerNeck.getChild("upperNeck");
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
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition lowerNeck = partdefinition.addOrReplaceChild("lowerNeck", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -5.95F, -4.8F, 7.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition upperNeck = lowerNeck.addOrReplaceChild("upperNeck", CubeListBuilder.create().texOffs(88, 0).addBox(-2.5F, -2.5F, -5.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -2.65F, -3.8F, -0.7114F, 0.0F, 0.0F));
        PartDefinition head = upperNeck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(88, 15).addBox(-2.5F, -3.0F, -4.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.1F, -4.0F, -0.3054F, 0.0F, 0.0F));
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
        PartDefinition christmas_nose = snout.addOrReplaceChild("christmas_nose", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, -2.0F));
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
        PartDefinition mane01 = upperNeck.addOrReplaceChild("mane01", CubeListBuilder.create().texOffs(0, 50).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.5F, -1.3F, -0.8727F, 0.0F, 0.0F));
        PartDefinition mane02 = upperNeck.addOrReplaceChild("mane02", CubeListBuilder.create().texOffs(20, 50).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, -0.45F, -0.829F, 0.0F, 0.0F));
        PartDefinition mane03 = lowerNeck.addOrReplaceChild("mane03", CubeListBuilder.create().texOffs(46, 50).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.25F, -2.95F, -1.5533F, 0.0F, 0.0F));
        PartDefinition mane04 = lowerNeck.addOrReplaceChild("mane04", CubeListBuilder.create().texOffs(72, 50).addBox(-3.0F, -1.0F, 0.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.15F, -0.9F, -1.5708F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public ModelPart basePart() {
        return lowerNeck;
    }

    @Override
    public float wallOffsetX() {
        return 4F;
    }

}
