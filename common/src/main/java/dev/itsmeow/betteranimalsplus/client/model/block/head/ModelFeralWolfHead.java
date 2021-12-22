package dev.itsmeow.betteranimalsplus.client.model.block.head;

import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAPHead;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class ModelFeralWolfHead<T extends Entity> extends ModelBAPHead<T> {

    public ModelPart head;

    public ModelFeralWolfHead(ModelPart root) {
        super(false);
        this.head = root.getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(27, 39).addBox(-3.5F, -6.0F, -2.5F, 7.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition jawLower = head.addOrReplaceChild("jawLower", CubeListBuilder.create().texOffs(39, 20).addBox(-1.5F, -4.5F, -0.5F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -1.41F, 2.0944F, 0.0F, 0.0F));
        PartDefinition lowerTeeth01 = jawLower.addOrReplaceChild("lowerTeeth01", CubeListBuilder.create().texOffs(57, 22).mirror().addBox(-1.6F, -0.7F, 0.4F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -3.7F, 0.1F));
        PartDefinition lowerTeeth02 = jawLower.addOrReplaceChild("lowerTeeth02", CubeListBuilder.create().texOffs(57, 22).addBox(0.6F, -0.7F, 0.3F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.7F, 0.1F));
        PartDefinition snout = head.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(40, 12).addBox(-1.5F, -4.6F, -1.2F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.3F, -2.3F, 1.7453F, 0.0F, 0.0F));
        PartDefinition upperJaws = head.addOrReplaceChild("upperJaws", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, -1.0F, 1.5708F, 0.0F, 0.0F));
        PartDefinition rUpperJaw = upperJaws.addOrReplaceChild("rUpperJaw", CubeListBuilder.create().texOffs(51, 12).mirror().addBox(-1.1F, -3.9F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.2F, -1.85F, -2.0F, 0.0F, 0.0F, 0.1396F));
        PartDefinition rUpperTeeth = rUpperJaw.addOrReplaceChild("rUpperTeeth", CubeListBuilder.create().texOffs(50, 20).mirror().addBox(-0.5F, -1.0F, -0.89F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -2.8F, -1.0F));
        PartDefinition lUpperJaw = upperJaws.addOrReplaceChild("lUpperJaw", CubeListBuilder.create().texOffs(51, 12).addBox(-0.9F, -3.9F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2F, -1.85F, -2.0F, 0.0F, 0.0F, -0.1396F));
        PartDefinition lUpperTeeth = lUpperJaw.addOrReplaceChild("lUpperTeeth", CubeListBuilder.create().texOffs(50, 20).addBox(-0.5F, -1.0F, -0.89F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.8F, -1.0F));
        PartDefinition mUpperTeeth = upperJaws.addOrReplaceChild("mUpperTeeth", CubeListBuilder.create().texOffs(55, 28).mirror().addBox(-1.5F, -0.7F, -0.4F, 3.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -5.05F, -3.0F));
        PartDefinition cheekFurRotator = head.addOrReplaceChild("cheekFurRotator", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 1.5708F, 0.0F, 0.0F));
        PartDefinition lCheekFur = cheekFurRotator.addOrReplaceChild("lCheekFur", CubeListBuilder.create().texOffs(30, -6).addBox(0.0F, -0.9F, -3.8F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -2.9F, 2.5F, -0.3491F, 0.0873F, -0.6981F));
        PartDefinition rCheekFur = cheekFurRotator.addOrReplaceChild("rCheekFur", CubeListBuilder.create().texOffs(30, -6).addBox(0.0F, -0.8F, -3.6F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -2.9F, 2.5F, -0.3491F, -0.0873F, 0.6981F));
        PartDefinition earsRotator = head.addOrReplaceChild("earsRotator", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.5F, 0.0F, 2.25F, 1.5708F, 0.0F, 0.0F));
        PartDefinition lEar01 = earsRotator.addOrReplaceChild("lEar01", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.5F, -0.5F, 0.3F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.6F, -2.6F, 5.0F, 0.0873F, 0.2269F, 0.3665F));
        PartDefinition lEar02 = lEar01.addOrReplaceChild("lEar02", CubeListBuilder.create().texOffs(0, 4).mirror().addBox(-1.0F, -0.7F, 0.2F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.2F, 0.2F, 0.3142F, 0.0F, 0.0F));
        PartDefinition rEar01 = earsRotator.addOrReplaceChild("rEar01", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -0.5F, 0.3F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6F, -2.6F, 5.0F, 0.0873F, -0.2269F, -0.3665F));
        PartDefinition rEar02 = rEar01.addOrReplaceChild("rEar02", CubeListBuilder.create().texOffs(0, 4).addBox(-1.0F, -0.7F, 0.2F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.2F, 0.2F, 0.3142F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public ModelPart basePart() {
        return head;
    }

    @Override
    public float wallOffsetX() {
        return 1.5F;
    }

    @Override
    public float globalOffsetY() {
        return 0.5F;
    }
}
