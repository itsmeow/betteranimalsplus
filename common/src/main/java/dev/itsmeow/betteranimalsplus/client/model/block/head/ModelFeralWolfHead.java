package dev.itsmeow.betteranimalsplus.client.model.block.head;

import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAPHead;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class ModelFeralWolfHead<T extends Entity> extends ModelBAPHead<T> {

    public ModelPart head;
    public ModelPart jawUpper01;
    public ModelPart jawUpper02;
    public ModelPart upperTeeth02;
    public ModelPart upperTeeth01;
    public ModelPart upperTeeth03;
    public ModelPart jawLower;
    public ModelPart lowerTeeth01;
    public ModelPart lowerTeeth02;
    public ModelPart lEar01;
    public ModelPart lEar02;
    public ModelPart rEar01;
    public ModelPart rEar02;
    public ModelPart lCheekFur;
    public ModelPart rCheekFur;
    public ModelPart snout;

    public ModelFeralWolfHead(ModelPart root) {
        super(false);
        this.head = root.getChild("head");
        this.jawUpper01 = head.getChild("jawUpper01");
        this.jawUpper02 = jawUpper01.getChild("jawUpper02");
        this.upperTeeth02 = jawUpper02.getChild("upperTeeth02");
        this.upperTeeth01 = jawUpper01.getChild("upperTeeth01");
        this.upperTeeth03 = jawUpper01.getChild("upperTeeth03");
        this.jawLower = head.getChild("jawLower");
        this.lowerTeeth01 = jawLower.getChild("lowerTeeth01");
        this.lowerTeeth02 = lowerTeeth01.getChild("lowerTeeth02");
        this.lEar01 = head.getChild("lEar01");
        this.lEar02 = lEar01.getChild("lEar02");
        this.rEar01 = head.getChild("rEar01");
        this.rEar02 = rEar01.getChild("rEar02");
        this.lCheekFur = head.getChild("lCheekFur");
        this.rCheekFur = head.getChild("rCheekFur");
        this.snout = head.getChild("snout");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(40, 0).addBox(-3.5F, -4.4F, 0.1F, 7.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
        PartDefinition jawUpper01 = head.addOrReplaceChild("jawUpper01", CubeListBuilder.create().texOffs(51, 12).mirror().addBox(-1.1F, -4.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.2F, -4.6F, 2.0F, 0.0F, 0.0F, 0.1396F));
        PartDefinition jawUpper02 = jawUpper01.addOrReplaceChild("jawUpper02", CubeListBuilder.create().texOffs(51, 12).addBox(1.5F, -4.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.35F, 0.0F, 0.0F, 0.0F, -0.2793F));
        PartDefinition upperTeeth02 = jawUpper02.addOrReplaceChild("upperTeeth02", CubeListBuilder.create().texOffs(50, 20).addBox(-0.5F, -1.0F, -0.89F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.4F, -2.8F, -1.0F));
        PartDefinition upperTeeth01 = jawUpper01.addOrReplaceChild("upperTeeth01", CubeListBuilder.create().texOffs(50, 20).mirror().addBox(-0.5F, -1.0F, -0.89F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -2.8F, -1.0F));
        PartDefinition upperTeeth03 = jawUpper01.addOrReplaceChild("upperTeeth03", CubeListBuilder.create().texOffs(55, 28).mirror().addBox(-0.73F, -0.7F, -0.4F, 3.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -3.2F, -1.0F, 0.0F, 0.0F, -0.1309F));
        PartDefinition jawLower = head.addOrReplaceChild("jawLower", CubeListBuilder.create().texOffs(39, 20).addBox(-1.5F, -4.5F, -0.5F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -4.0F, 0.59F, 0.7418F, 0.0F, 0.0F));
        PartDefinition lowerTeeth01 = jawLower.addOrReplaceChild("lowerTeeth01", CubeListBuilder.create().texOffs(57, 22).mirror().addBox(-1.6F, -0.7F, 0.4F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -3.7F, 0.1F));
        PartDefinition lowerTeeth02 = lowerTeeth01.addOrReplaceChild("lowerTeeth02", CubeListBuilder.create().texOffs(57, 22).addBox(0.6F, -0.7F, 0.3F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition lEar01 = head.addOrReplaceChild("lEar01", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.5F, -0.5F, 0.3F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.9F, -2.6F, 5.0F, 0.0873F, 0.2269F, 0.3665F));
        PartDefinition lEar02 = lEar01.addOrReplaceChild("lEar02", CubeListBuilder.create().texOffs(0, 4).mirror().addBox(-1.0F, -0.7F, 0.2F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.2F, 0.2F, 0.3142F, 0.0F, 0.0F));
        PartDefinition rEar01 = head.addOrReplaceChild("rEar01", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -0.5F, 0.3F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.1F, -2.6F, 5.0F, 0.0873F, -0.2269F, -0.3665F));
        PartDefinition rEar02 = rEar01.addOrReplaceChild("rEar02", CubeListBuilder.create().texOffs(0, 4).addBox(-1.0F, -0.7F, 0.2F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.2F, 0.2F, 0.3142F, 0.0F, 0.0F));
        PartDefinition lCheekFur = head.addOrReplaceChild("lCheekFur", CubeListBuilder.create().texOffs(30, -6).addBox(0.0F, -0.9F, -3.8F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -2.9F, 2.5F, -0.3491F, 0.0873F, -0.6981F));
        PartDefinition rCheekFur = head.addOrReplaceChild("rCheekFur", CubeListBuilder.create().texOffs(30, -6).addBox(0.0F, -0.8F, -3.6F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, -2.9F, 2.5F, -0.3491F, -0.0873F, 0.6981F));
        PartDefinition snout = head.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(40, 12).addBox(-1.5F, -4.45F, -1.0F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -4.3F, 3.2F, 0.182F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public ModelPart basePart() {
        return head;
    }

    @Override
    public float wallOffsetX() {
        return 3.5F;
    }

    @Override
    public float globalOffsetY() {
        return 0.5F;
    }
}
