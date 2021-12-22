package dev.itsmeow.betteranimalsplus.client.model.block.head;

import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAPHead;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class ModelCoyoteHead<T extends Entity> extends ModelBAPHead<T> {

    public ModelPart head;
    public ModelPart rCheekFur_r1;
    public ModelPart lCheekFur_r1;
    public ModelPart muzzle;
    public ModelPart mUpperFang_r1;
    public ModelPart rUpperFang_r1;
    public ModelPart lUpperFang_r1;
    public ModelPart rLip_r1;
    public ModelPart lLip_r1;
    public ModelPart lowerJaw;
    public ModelPart lEar01;
    public ModelPart lEar02;
    public ModelPart cube_r1;
    public ModelPart rEar01;
    public ModelPart rEar02;
    public ModelPart cube_r2;

    public ModelCoyoteHead(ModelPart root) {
        super(false);
        this.head = root.getChild("head");
        this.rCheekFur_r1 = head.getChild("rCheekFur_r1");
        this.lCheekFur_r1 = head.getChild("lCheekFur_r1");
        this.lowerJaw = head.getChild("lowerJaw");
        this.muzzle = head.getChild("muzzle");
        this.mUpperFang_r1 = muzzle.getChild("mUpperFang_r1");
        this.rUpperFang_r1 = muzzle.getChild("rUpperFang_r1");
        this.lUpperFang_r1 = muzzle.getChild("lUpperFang_r1");
        this.rLip_r1 = muzzle.getChild("rLip_r1");
        this.lLip_r1 = muzzle.getChild("lLip_r1");
        this.lEar01 = head.getChild("lEar01");
        this.lEar02 = lEar01.getChild("lEar02");
        this.cube_r1 = lEar02.getChild("cube_r1");
        this.rEar01 = head.getChild("rEar01");
        this.rEar02 = rEar01.getChild("rEar02");
        this.cube_r2 = rEar02.getChild("cube_r2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 46).addBox(-2.5F, -4.75F, -2.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition rCheekFur_r1 = head.addOrReplaceChild("rCheekFur_r1", CubeListBuilder.create().texOffs(0, 56).mirror().addBox(-4.5F, -4.75F, -0.5F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.3927F, -0.4363F));
        PartDefinition lCheekFur_r1 = head.addOrReplaceChild("lCheekFur_r1", CubeListBuilder.create().texOffs(0, 56).addBox(0.5F, -4.5F, -0.5F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.3927F, 0.4363F));
        PartDefinition lowerJaw = head.addOrReplaceChild("lowerJaw", CubeListBuilder.create().texOffs(19, 59).addBox(-1.0F, 0.0F, -2.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(-0.2F))
                .texOffs(9, 56).addBox(-0.1F, -0.5F, -2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.2F))
                .texOffs(9, 56).mirror().addBox(-0.9F, -0.5F, -2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.25F, -2.0F, 0.7418F, 0.0F, 0.0F));
        PartDefinition muzzle = head.addOrReplaceChild("muzzle", CubeListBuilder.create().texOffs(19, 49).addBox(-1.0F, -0.5F, -2.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.5F, -2.0F, 0.1745F, 0.0F, 0.0F));
        PartDefinition mUpperFang_r1 = muzzle.addOrReplaceChild("mUpperFang_r1", CubeListBuilder.create().texOffs(13, 56).mirror().addBox(-1.0F, -1.5F, -4.45F, 2.0F, 1.0F, 0.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, 2.5F, 2.0F, -0.0873F, 0.0F, 0.0F));
        PartDefinition rUpperFang_r1 = muzzle.addOrReplaceChild("rUpperFang_r1", CubeListBuilder.create().texOffs(9, 56).mirror().addBox(3.5F, -1.75F, -0.75F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, 2.5F, 2.0F, 0.0F, 1.5708F, 0.0F));
        PartDefinition lUpperFang_r1 = muzzle.addOrReplaceChild("lUpperFang_r1", CubeListBuilder.create().texOffs(9, 56).addBox(-4.5F, -1.75F, -0.75F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 2.5F, 2.0F, 0.0F, -1.5708F, 0.0F));
        PartDefinition rLip_r1 = muzzle.addOrReplaceChild("rLip_r1", CubeListBuilder.create().texOffs(5, 59).mirror().addBox(-1.75F, -2.0F, -4.6F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 2.5F, 2.0F, -0.1309F, -0.1745F, 0.0F));
        PartDefinition lLip_r1 = muzzle.addOrReplaceChild("lLip_r1", CubeListBuilder.create().texOffs(5, 59).addBox(0.75F, -2.0F, -4.6F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.5F, 2.0F, -0.1309F, 0.1745F, 0.0F));
        PartDefinition lEar01 = head.addOrReplaceChild("lEar01", CubeListBuilder.create().texOffs(31, 50).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.75F, -4.5F, 0.0F, 0.0F, -0.0873F, 0.2182F));
        PartDefinition lEar02 = lEar01.addOrReplaceChild("lEar02", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.25F, -0.75F, 0.1745F, 0.0F, 0.0F));
        PartDefinition cube_r1 = lEar02.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(31, 54).addBox(0.5F, -7.75F, -2.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-1.75F, 4.25F, 0.75F, 0.0F, -0.829F, 0.0F));
        PartDefinition rEar01 = head.addOrReplaceChild("rEar01", CubeListBuilder.create().texOffs(31, 50).mirror().addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, -4.25F, 0.0F, 0.0F, 0.0873F, -0.2182F));
        PartDefinition rEar02 = rEar01.addOrReplaceChild("rEar02", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -0.75F, 0.2182F, 0.0F, 0.0F));
        PartDefinition cube_r2 = rEar02.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(31, 54).mirror().addBox(-2.25F, -7.75F, -2.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(1.5F, 4.25F, 0.75F, 0.0F, 0.829F, 0.0F));
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public ModelPart basePart() {
        return head;
    }

    @Override
    public float wallOffsetX() {
        return 2F;
    }

}
