package dev.itsmeow.betteranimalsplus.client.model.block.head;

import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAPHead;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class ModelBoarHead<T extends Entity> extends ModelBAPHead<T> {

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

    public ModelBoarHead(ModelPart root) {
        super(true);
        this.head = root.getChild("head");
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
        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(23, 38).addBox(-2.5F, -6.0F, -2.2F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
        PartDefinition snoot = head.addOrReplaceChild("snoot", CubeListBuilder.create().texOffs(42, 36).addBox(-1.5F, -1.5F, -4.7F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.15F, -1.6F, 0.2731F, 0.0F, 0.0F));
        PartDefinition nose = snoot.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(56, 50).addBox(-1.5F, -1.5F, -0.8F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, -0.4F, -4.3F, -0.1367F, 0.0F, 0.0F));
        PartDefinition upperJaw = head.addOrReplaceChild("upperJaw", CubeListBuilder.create().texOffs(44, 43).addBox(-1.5F, -1.0F, -4.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offset(0.0F, -1.85F, -1.6F));
        PartDefinition lUpperTusk = upperJaw.addOrReplaceChild("lUpperTusk", CubeListBuilder.create().texOffs(0, 1).mirror().addBox(-0.55F, -2.7F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.15F)).mirror(false), PartPose.offsetAndRotation(1.3F, 1.0F, -1.75F, 0.0F, 0.0F, 0.3054F));
        PartDefinition rUpperTusk = upperJaw.addOrReplaceChild("rUpperTusk", CubeListBuilder.create().texOffs(0, 1).addBox(-0.45F, -2.7F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(-1.3F, 1.0F, -1.75F, 0.0F, 0.0F, -0.3054F));
        PartDefinition lowerJaw = head.addOrReplaceChild("lowerJaw", CubeListBuilder.create().texOffs(44, 49).addBox(-1.5F, -0.5F, -4.7F, 3.0F, 1.0F, 5.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -0.35F, -1.3F, 0.5236F, 0.0F, 0.0F));
        PartDefinition lTusk01 = lowerJaw.addOrReplaceChild("lTusk01", CubeListBuilder.create().texOffs(0, 1).mirror().addBox(-0.5F, -1.8F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.3F, 0.0F, -2.8F, 0.2443F, 0.0F, 0.3054F));
        PartDefinition lTusk02 = lTusk01.addOrReplaceChild("lTusk02", CubeListBuilder.create().texOffs(0, 1).mirror().addBox(-0.55F, -1.7F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.75F, 0.0F, 0.0F, 0.0F, -0.1745F));
        PartDefinition rTusk01 = lowerJaw.addOrReplaceChild("rTusk01", CubeListBuilder.create().texOffs(0, 1).addBox(-0.5F, -1.8F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3F, 0.0F, -2.8F, 0.2443F, 0.0F, -0.3054F));
        PartDefinition rTusk02 = rTusk01.addOrReplaceChild("rTusk02", CubeListBuilder.create().texOffs(0, 1).addBox(-0.45F, -1.7F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -1.75F, 0.0F, 0.0F, 0.0F, 0.1745F));
        PartDefinition lEar01 = head.addOrReplaceChild("lEar01", CubeListBuilder.create().texOffs(56, 17).mirror().addBox(0.2F, -3.0F, -0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.7F, -5.25F, 0.1F, 0.0F, -0.3927F, 0.3927F));
        PartDefinition lEar02 = lEar01.addOrReplaceChild("lEar02", CubeListBuilder.create().texOffs(58, 9).mirror().addBox(-1.25F, -4.25F, -0.5F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.6F, 0.0F, 0.7F));
        PartDefinition rEar01 = head.addOrReplaceChild("rEar01", CubeListBuilder.create().texOffs(56, 17).addBox(-2.2F, -3.0F, -0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7F, -5.25F, 0.1F, 0.0F, 0.3927F, -0.3927F));
        PartDefinition rEar02 = rEar01.addOrReplaceChild("rEar02", CubeListBuilder.create().texOffs(58, 9).addBox(-1.0F, -4.0F, -0.5F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.35F, -0.25F, 0.7F));
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public ModelPart basePart() {
        return head;
    }

    @Override
    public float wallOffsetX() {
        return 1.25F;
    }

    @Override
    public float globalOffsetY() {
        return 1.9F;
    }

}
