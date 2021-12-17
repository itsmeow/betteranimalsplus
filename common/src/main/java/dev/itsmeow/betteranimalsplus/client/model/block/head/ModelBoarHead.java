package dev.itsmeow.betteranimalsplus.client.model.block.head;

import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAPHead;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

/**
 * boarhead - cybercat5555 Created using Tabula 5.1.0
 */
public class ModelBoarHead<T extends Entity> extends ModelBAPHead<T> {

    public ModelPart neck;
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

    public ModelBoarHead(ModelPart root) {
        super(true);
        this.neck = root.getChild("neck");
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
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition neck = partdefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 34).addBox(-3.0F, -7.1F, -3.9F, 6.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition neck02 = neck.addOrReplaceChild("neck02", CubeListBuilder.create().texOffs(0, 48).addBox(-2.0F, -3.0F, -3.0F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.5F, -3.0F, -0.1367F, 0.0F, 0.0F));
        PartDefinition head = neck02.addOrReplaceChild("head", CubeListBuilder.create().texOffs(84, 0).addBox(-2.5F, -3.5F, -5.0F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.3F, -1.2F, 0.3316F, 0.0F, 0.0F));
        PartDefinition snoot01 = head.addOrReplaceChild("snoot01", CubeListBuilder.create().texOffs(84, 16).mirror().addBox(-1.3F, -1.5F, -4.7F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -0.6F, -4.4F, 0.2731F, 0.0F, 0.0F));
        PartDefinition snoot02 = snoot01.addOrReplaceChild("snoot02", CubeListBuilder.create().texOffs(101, 16).addBox(-1.7F, -1.5F, -4.7F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition snoot = snoot01.addOrReplaceChild("snoot", CubeListBuilder.create().texOffs(112, 16).addBox(-1.5F, -1.5F, -0.8F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.4F, -4.3F, -0.1367F, 0.0F, 0.0F));
        PartDefinition upperJaw = head.addOrReplaceChild("upperJaw", CubeListBuilder.create().texOffs(84, 25).addBox(-1.5F, -1.0F, -4.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.7F, -4.4F));
        PartDefinition lowerJaw = head.addOrReplaceChild("lowerJaw", CubeListBuilder.create().texOffs(99, 25).addBox(-1.5F, -0.5F, -4.7F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.2F, -4.1F, 0.5672F, 0.0F, 0.0F));
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
        PartDefinition chestFur01 = neck.addOrReplaceChild("chestFur01", CubeListBuilder.create().texOffs(108, 50).addBox(-2.5F, 0.0F, -1.0F, 5.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -3.3F, 0.1745F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public ModelPart basePart() {
        return neck;
    }

    @Override
    public float wallOffsetX() {
        return 4F;
    }

}
