package dev.itsmeow.betteranimalsplus.client.model.block.head;

import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAPHead;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

/**
 * moose_head - cybercat5555
 * Created using Tabula 7.0.1
 */
public class ModelMooseHead<T extends Entity> extends ModelBAPHead<T> {

    public ModelPart neck;
    public ModelPart head;
    public ModelPart snout;
    public ModelPart throat;
    public ModelPart snoutSlope;
    public ModelPart lEar;
    public ModelPart rEar;
    public ModelPart lAntler00;
    public ModelPart rAntler00;
    public ModelPart beard;
    public ModelPart lowerJaw;
    public ModelPart lAntler01a;
    public ModelPart lAntler01b;
    public ModelPart lAntler01c;
    public ModelPart lAntler01e;
    public ModelPart lAntler02a;
    public ModelPart lAntler01d;
    public ModelPart lAntler03a;
    public ModelPart lAntler04a;
    public ModelPart lAntler05a;
    public ModelPart lAntler06a;
    public ModelPart lAntler07a;
    public ModelPart lAntler08a;
    public ModelPart lAntler09a;
    public ModelPart lAntler07b;
    public ModelPart lAntler08b;
    public ModelPart lAntler09b;
    public ModelPart lAntler04b;
    public ModelPart lAntler05b;
    public ModelPart lAntler06b;
    public ModelPart rAntler01a;
    public ModelPart rAntler01b;
    public ModelPart rAntler01c;
    public ModelPart rAntler01e;
    public ModelPart rAntler02a;
    public ModelPart rAntler01d;
    public ModelPart rAntler03a;
    public ModelPart rAntler04a;
    public ModelPart rAntler05a;
    public ModelPart rAntler06a;
    public ModelPart rAntler07a;
    public ModelPart rAntler08a;
    public ModelPart rAntler09a;
    public ModelPart rAntler07b;
    public ModelPart rAntler08b;
    public ModelPart rAntler09b;
    public ModelPart rAntler04b;
    public ModelPart rAntler05b;
    public ModelPart rAntler06b;

    public ModelMooseHead(ModelPart root) {
        super(true);
        this.neck = root.getChild("neck");
        this.head = neck.getChild("head");
        this.snout = head.getChild("snout");
        this.throat = head.getChild("throat");
        this.beard = throat.getChild("beard");
        this.lowerJaw = throat.getChild("lowerJaw");
        this.snoutSlope = head.getChild("snoutSlope");
        this.lEar = head.getChild("lEar");
        this.rEar = head.getChild("rEar");
        this.lAntler00 = head.getChild("lAntler00");
        this.lAntler01a = lAntler00.getChild("lAntler01a");
        this.lAntler01b = lAntler01a.getChild("lAntler01b");
        this.lAntler01c = lAntler01a.getChild("lAntler01c");
        this.lAntler01d = lAntler01c.getChild("lAntler01d");
        this.lAntler01e = lAntler01a.getChild("lAntler01e");
        this.lAntler02a = lAntler01a.getChild("lAntler02a");
        this.lAntler03a = lAntler02a.getChild("lAntler03a");
        this.lAntler07a = lAntler03a.getChild("lAntler07a");
        this.lAntler07b = lAntler07a.getChild("lAntler07b");
        this.lAntler08a = lAntler03a.getChild("lAntler08a");
        this.lAntler08b = lAntler08a.getChild("lAntler08b");
        this.lAntler09a = lAntler03a.getChild("lAntler09a");
        this.lAntler09b = lAntler09a.getChild("lAntler09b");
        this.lAntler04a = lAntler02a.getChild("lAntler04a");
        this.lAntler04b = lAntler04a.getChild("lAntler04b");
        this.lAntler05a = lAntler02a.getChild("lAntler05a");
        this.lAntler05b = lAntler05a.getChild("lAntler05b");
        this.lAntler06a = lAntler02a.getChild("lAntler06a");
        this.lAntler06b = lAntler06a.getChild("lAntler06b");
        this.rAntler00 = head.getChild("rAntler00");
        this.rAntler01a = rAntler00.getChild("rAntler01a");
        this.rAntler01b = rAntler01a.getChild("rAntler01b");
        this.rAntler01c = rAntler01a.getChild("rAntler01c");
        this.rAntler01d = rAntler01c.getChild("rAntler01d");
        this.rAntler01e = rAntler01a.getChild("rAntler01e");
        this.rAntler02a = rAntler01a.getChild("rAntler02a");
        this.rAntler03a = rAntler02a.getChild("rAntler03a");
        this.rAntler07a = rAntler03a.getChild("rAntler07a");
        this.rAntler07b = rAntler07a.getChild("rAntler07b");
        this.rAntler08a = rAntler03a.getChild("rAntler08a");
        this.rAntler08b = rAntler08a.getChild("rAntler08b");
        this.rAntler09a = rAntler03a.getChild("rAntler09a");
        this.rAntler09b = rAntler09a.getChild("rAntler09b");
        this.rAntler04a = rAntler02a.getChild("rAntler04a");
        this.rAntler04b = rAntler04a.getChild("rAntler04b");
        this.rAntler05a = rAntler02a.getChild("rAntler05a");
        this.rAntler05b = rAntler05a.getChild("rAntler05b");
        this.rAntler06a = rAntler02a.getChild("rAntler06a");
        this.rAntler06b = rAntler06a.getChild("rAntler06b");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition neck = partdefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(88, 0).addBox(-2.5F, -7.5F, -6.5F, 5.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(88, 16).addBox(-3.0F, -3.0F, -5.1F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -5.2F, 0.5236F, 0.0F, 0.0F));
        PartDefinition snout = head.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(104, 36).addBox(-2.5F, -1.2F, -5.9F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, -5.1F));
        PartDefinition throat = head.addOrReplaceChild("throat", CubeListBuilder.create().texOffs(102, 47).addBox(-2.5F, 0.6F, -2.7F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.6F, -5.2F));
        PartDefinition beard = throat.addOrReplaceChild("beard", CubeListBuilder.create().texOffs(56, 46).addBox(-1.5F, -0.2F, -3.8F, 3.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.6F, 1.7F, -0.5061F, 0.0F, 0.0F));
        PartDefinition lowerJaw = throat.addOrReplaceChild("lowerJaw", CubeListBuilder.create().texOffs(102, 54).addBox(-2.0F, -0.6F, -3.4F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.1F, -1.9F));
        PartDefinition snoutSlope = head.addOrReplaceChild("snoutSlope", CubeListBuilder.create().texOffs(78, 36).addBox(-2.0F, -1.3F, -6.6F, 4.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.6F, -5.0F, 0.1745F, 0.0F, 0.0F));
        PartDefinition lEar = head.addOrReplaceChild("lEar", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, -1.5F, -0.5F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, -2.3F, 0.0F, 0.2269F, 0.0F, -0.9599F));
        PartDefinition rEar = head.addOrReplaceChild("rEar", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -1.5F, -0.5F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -2.3F, 0.0F, 0.2269F, 0.0F, 0.9599F));
        PartDefinition lAntler00 = head.addOrReplaceChild("lAntler00", CubeListBuilder.create().texOffs(84, 57).mirror().addBox(0.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, -2.4F, -2.1F, 0.0F, 0.1745F, -0.3491F));
        PartDefinition lAntler01a = lAntler00.addOrReplaceChild("lAntler01a", CubeListBuilder.create().texOffs(84, 57).mirror().addBox(0.0F, -0.8F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.9F, 0.0F, 0.1F, 0.0F, 0.4363F, 0.1396F));
        PartDefinition lAntler01b = lAntler01a.addOrReplaceChild("lAntler01b", CubeListBuilder.create().texOffs(84, 57).mirror().addBox(0.0F, -0.2F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition lAntler01c = lAntler01a.addOrReplaceChild("lAntler01c", CubeListBuilder.create().texOffs(84, 57).mirror().addBox(-0.5F, -3.2F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.9F, 0.0F, 0.0F, 0.3491F, 0.1745F, 1.1345F));
        PartDefinition lAntler01d = lAntler01c.addOrReplaceChild("lAntler01d", CubeListBuilder.create().texOffs(84, 57).mirror().addBox(-0.5F, -0.9F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, 0.0F, -0.3665F));
        PartDefinition lAntler01e = lAntler01a.addOrReplaceChild("lAntler01e", CubeListBuilder.create().texOffs(84, 57).mirror().addBox(-0.5F, -4.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, 0.5236F, 0.0F, 0.4712F));
        PartDefinition lAntler02a = lAntler01a.addOrReplaceChild("lAntler02a", CubeListBuilder.create().texOffs(83, 57).mirror().addBox(-1.5F, -0.6F, 0.4F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.8F, 0.0F, -0.3F, 0.4363F, -0.0873F, 0.0F));
        PartDefinition lAntler03a = lAntler02a.addOrReplaceChild("lAntler03a", CubeListBuilder.create().texOffs(78, 47).mirror().addBox(-2.2F, -0.61F, -0.7F, 5.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.4F, 0.0F, 5.3F, 0.2094F, -0.4363F, 0.0F));
        PartDefinition lAntler07a = lAntler03a.addOrReplaceChild("lAntler07a", CubeListBuilder.create().texOffs(84, 50).mirror().addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.9F, 0.0F, 2.8F, -0.7854F, 0.1745F, 1.1345F));
        PartDefinition lAntler07b = lAntler07a.addOrReplaceChild("lAntler07b", CubeListBuilder.create().texOffs(84, 50).mirror().addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.8F, 0.0F, 0.0F, 0.0F, -0.3665F));
        PartDefinition lAntler08a = lAntler03a.addOrReplaceChild("lAntler08a", CubeListBuilder.create().texOffs(84, 50).mirror().addBox(-0.5F, -2.2F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.9F, -0.1F, 5.3F, -1.0472F, 0.0F, 1.4835F));
        PartDefinition lAntler08b = lAntler08a.addOrReplaceChild("lAntler08b", CubeListBuilder.create().texOffs(84, 50).mirror().addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 0.0F, -0.3665F));
        PartDefinition lAntler09a = lAntler03a.addOrReplaceChild("lAntler09a", CubeListBuilder.create().texOffs(84, 50).mirror().addBox(-0.5F, -2.2F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.3F, -0.1F, 5.7F, -1.4835F, -0.1745F, 1.5359F));
        PartDefinition lAntler09b = lAntler09a.addOrReplaceChild("lAntler09b", CubeListBuilder.create().texOffs(84, 50).mirror().addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 0.0F, -0.3665F));
        PartDefinition lAntler04a = lAntler02a.addOrReplaceChild("lAntler04a", CubeListBuilder.create().texOffs(84, 57).mirror().addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.9F, 0.0F, 1.1F, -0.3142F, 0.1745F, 1.1345F));
        PartDefinition lAntler04b = lAntler04a.addOrReplaceChild("lAntler04b", CubeListBuilder.create().texOffs(84, 57).mirror().addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.8F, 0.0F, 0.0F, 0.0F, -0.3665F));
        PartDefinition lAntler05a = lAntler02a.addOrReplaceChild("lAntler05a", CubeListBuilder.create().texOffs(84, 57).mirror().addBox(-0.5F, -4.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.9F, 0.0F, 3.1F, -0.5236F, 0.1745F, 1.1345F));
        PartDefinition lAntler05b = lAntler05a.addOrReplaceChild("lAntler05b", CubeListBuilder.create().texOffs(84, 57).mirror().addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -3.9F, 0.0F, 0.0F, 0.0F, -0.3665F));
        PartDefinition lAntler06a = lAntler02a.addOrReplaceChild("lAntler06a", CubeListBuilder.create().texOffs(84, 57).mirror().addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.9F, 0.0F, 5.0F, -0.7854F, 0.1745F, 1.0472F));
        PartDefinition lAntler06b = lAntler06a.addOrReplaceChild("lAntler06b", CubeListBuilder.create().texOffs(84, 57).mirror().addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.8F, 0.0F, 0.0F, 0.0F, -0.3665F));
        PartDefinition rAntler00 = head.addOrReplaceChild("rAntler00", CubeListBuilder.create().texOffs(84, 57).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -2.4F, -2.1F, 0.0F, -0.1745F, 0.3491F));
        PartDefinition rAntler01a = rAntler00.addOrReplaceChild("rAntler01a", CubeListBuilder.create().texOffs(84, 57).addBox(-5.0F, -0.8F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9F, 0.0F, 0.1F, 0.0F, -0.4363F, -0.1396F));
        PartDefinition rAntler01b = rAntler01a.addOrReplaceChild("rAntler01b", CubeListBuilder.create().texOffs(84, 57).addBox(-5.0F, -0.2F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition rAntler01c = rAntler01a.addOrReplaceChild("rAntler01c", CubeListBuilder.create().texOffs(84, 57).addBox(-0.5F, -3.2F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.9F, 0.0F, 0.0F, 0.3491F, -0.1745F, -1.1345F));
        PartDefinition rAntler01d = rAntler01c.addOrReplaceChild("rAntler01d", CubeListBuilder.create().texOffs(84, 57).addBox(-0.5F, -0.9F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.3665F));
        PartDefinition rAntler01e = rAntler01a.addOrReplaceChild("rAntler01e", CubeListBuilder.create().texOffs(84, 57).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 0.0F, 0.0F, 0.5236F, 0.0F, -0.4712F));
        PartDefinition rAntler02a = rAntler01a.addOrReplaceChild("rAntler02a", CubeListBuilder.create().texOffs(83, 57).addBox(-2.5F, -0.6F, 0.4F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8F, 0.0F, -0.3F, 0.4363F, 0.0873F, 0.0F));
        PartDefinition rAntler03a = rAntler02a.addOrReplaceChild("rAntler03a", CubeListBuilder.create().texOffs(78, 47).addBox(-2.8F, -0.61F, -0.7F, 5.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4F, 0.0F, 5.3F, 0.2094F, 0.4363F, 0.0F));
        PartDefinition rAntler07a = rAntler03a.addOrReplaceChild("rAntler07a", CubeListBuilder.create().texOffs(84, 50).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9F, 0.0F, 2.8F, -0.7854F, -0.1745F, -1.1345F));
        PartDefinition rAntler07b = rAntler07a.addOrReplaceChild("rAntler07b", CubeListBuilder.create().texOffs(84, 50).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.8F, 0.0F, 0.0F, 0.0F, 0.3665F));
        PartDefinition rAntler08a = rAntler03a.addOrReplaceChild("rAntler08a", CubeListBuilder.create().texOffs(84, 50).addBox(-0.5F, -2.2F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9F, -0.1F, 5.3F, -1.0472F, 0.0F, -1.4835F));
        PartDefinition rAntler08b = rAntler08a.addOrReplaceChild("rAntler08b", CubeListBuilder.create().texOffs(84, 50).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.3665F));
        PartDefinition rAntler09a = rAntler03a.addOrReplaceChild("rAntler09a", CubeListBuilder.create().texOffs(84, 50).addBox(-0.5F, -2.2F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3F, -0.1F, 5.7F, -1.4835F, 0.1745F, -1.5359F));
        PartDefinition rAntler09b = rAntler09a.addOrReplaceChild("rAntler09b", CubeListBuilder.create().texOffs(84, 50).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.3665F));
        PartDefinition rAntler04a = rAntler02a.addOrReplaceChild("rAntler04a", CubeListBuilder.create().texOffs(84, 57).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9F, 0.0F, 1.1F, -0.3142F, -0.1745F, -1.1345F));
        PartDefinition rAntler04b = rAntler04a.addOrReplaceChild("rAntler04b", CubeListBuilder.create().texOffs(84, 57).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.8F, 0.0F, 0.0F, 0.0F, 0.3665F));
        PartDefinition rAntler05a = rAntler02a.addOrReplaceChild("rAntler05a", CubeListBuilder.create().texOffs(84, 57).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9F, 0.0F, 3.1F, -0.5236F, -0.1745F, -1.1345F));
        PartDefinition rAntler05b = rAntler05a.addOrReplaceChild("rAntler05b", CubeListBuilder.create().texOffs(84, 57).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.9F, 0.0F, 0.0F, 0.0F, 0.3665F));
        PartDefinition rAntler06a = rAntler02a.addOrReplaceChild("rAntler06a", CubeListBuilder.create().texOffs(84, 57).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9F, 0.0F, 5.0F, -0.7854F, -0.1745F, -1.0472F));
        PartDefinition rAntler06b = rAntler06a.addOrReplaceChild("rAntler06b", CubeListBuilder.create().texOffs(84, 57).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.8F, 0.0F, 0.0F, 0.0F, 0.3665F));
        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public ModelPart basePart() {
        return neck;
    }

    @Override
    public float wallOffsetX() {
        return 4.1F;
    }

}
