package dev.itsmeow.betteranimalsplus.client.model.block.head;

import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAPHead;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class ModelGazelleHead<T extends Entity> extends ModelBAPHead<T> {

	public ModelPart chest;

	public ModelGazelleHead(ModelPart root) {
		super(false);
		this.chest = root.getChild("chest");
	}

	public static LayerDefinition createChinkaraLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition chest = partdefinition.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 34).addBox(-2.5F, -3.0F, -5.0F, 5.0F, 6.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition neck = chest.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 45).addBox(-2.0F, -2.5F, -6.0F, 4.0F, 5.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.65F, -2.5F, -0.6632F, 0.0F, 0.0F));
		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(17, 55).addBox(-2.0F, -3.25F, -4.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 1.1F, -5.0F, -0.3142F, 0.0F, 0.0F));
		PartDefinition snout = head.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(0, 57).addBox(-1.0F, -0.5F, -0.75F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.45F, -2.35F, 0.2618F, 0.0F, 0.0F));
		PartDefinition lEar = head.addOrReplaceChild("lEar", CubeListBuilder.create().texOffs(22, 48).mirror().addBox(-1.0F, -0.7F, -3.35F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.35F, -1.75F, -3.25F, -0.0873F, -0.9512F, 0.0F));
		PartDefinition rEar = head.addOrReplaceChild("rEar", CubeListBuilder.create().texOffs(22, 48).addBox(-1.0F, -0.7F, -3.35F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.35F, -1.5F, -3.25F, -0.0873F, 0.9512F, 0.0F));
		PartDefinition throat = head.addOrReplaceChild("throat", CubeListBuilder.create().texOffs(35, 57).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 0.95F, -0.24F));
		PartDefinition lowerJaw = throat.addOrReplaceChild("lowerJaw", CubeListBuilder.create().texOffs(36, 61).addBox(-1.0F, 0.0F, -0.49F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.75F, -0.01F));
		PartDefinition upperMuzzle = head.addOrReplaceChild("upperMuzzle", CubeListBuilder.create(), PartPose.offset(0.0F, 1.75F, -1.0F));
		PartDefinition rUpperLip_r1 = upperMuzzle.addOrReplaceChild("rUpperLip_r1", CubeListBuilder.create().texOffs(7, 56).mirror().addBox(-1.5F, -0.75F, -1.25F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.0436F, -0.1309F));
		PartDefinition lUpperLip_r1 = upperMuzzle.addOrReplaceChild("lUpperLip_r1", CubeListBuilder.create().texOffs(7, 56).addBox(-0.5F, -0.75F, -1.25F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0436F, 0.1309F));
		PartDefinition lHorn01 = head.addOrReplaceChild("lHorn01", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 0.2F, -3.4F, -0.2618F, -0.1745F, 0.0F));
		PartDefinition cube_r1 = lHorn01.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(22, 34).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition lHorn02 = lHorn01.addOrReplaceChild("lHorn02", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -2.25F, -0.2618F, -0.2618F, 0.0F));
		PartDefinition cube_r2 = lHorn02.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(22, 40).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition lHorn03 = lHorn02.addOrReplaceChild("lHorn03", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -1.75F, -0.3491F, 0.0873F, 0.0F));
		PartDefinition cube_r3 = lHorn03.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(29, 40).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition lHorn04 = lHorn03.addOrReplaceChild("lHorn04", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -1.5F, 0.1745F, 0.0873F, 0.0F));
		PartDefinition cube_r4 = lHorn04.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(36, 39).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition rHorn01 = head.addOrReplaceChild("rHorn01", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, 0.2F, -3.4F, -0.2618F, 0.1745F, 0.0F));
		PartDefinition cube_r5 = rHorn01.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(22, 34).mirror().addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.4F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition rHorn02 = rHorn01.addOrReplaceChild("rHorn02", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -2.25F, -0.2618F, 0.2618F, 0.0F));
		PartDefinition cube_r6 = rHorn02.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(22, 40).mirror().addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition rHorn03 = rHorn02.addOrReplaceChild("rHorn03", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -1.75F, -0.3491F, -0.0873F, 0.0F));
		PartDefinition cube_r7 = rHorn03.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(29, 40).mirror().addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition rHorn04 = rHorn03.addOrReplaceChild("rHorn04", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -1.5F, 0.1745F, -0.0873F, 0.0F));
		PartDefinition cube_r8 = rHorn04.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(36, 39).mirror().addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	public static LayerDefinition createBlackbuckLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition chest = partdefinition.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 34).addBox(-2.5F, -3.0F, -5.0F, 5.0F, 6.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offset(0.0F, 9.8F, -5.6F));
		PartDefinition neck = chest.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 45).addBox(-2.0F, -2.5F, -6.0F, 4.0F, 5.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.65F, -2.5F, -0.6632F, 0.0F, 0.0F));
		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(17, 55).addBox(-2.0F, -3.0F, -4.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 1.1F, -5.0F, -0.3142F, 0.0F, 0.0F));
		PartDefinition snout = head.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(0, 57).addBox(-1.0F, -0.45F, -0.75F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.45F, -2.35F, 0.2618F, 0.0F, 0.0F));
		PartDefinition lEar = head.addOrReplaceChild("lEar", CubeListBuilder.create().texOffs(22, 48).mirror().addBox(-1.0F, -0.7F, -3.35F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.35F, -1.75F, -3.25F, -0.0873F, -1.1257F, 0.0F));
		PartDefinition rEar = head.addOrReplaceChild("rEar", CubeListBuilder.create().texOffs(22, 48).addBox(-1.0F, -0.7F, -3.35F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.35F, -1.5F, -3.25F, -0.0873F, 1.1257F, 0.0F));
		PartDefinition throat = head.addOrReplaceChild("throat", CubeListBuilder.create().texOffs(35, 57).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 0.95F, -0.24F));
		PartDefinition lowerJaw = throat.addOrReplaceChild("lowerJaw", CubeListBuilder.create().texOffs(36, 61).addBox(-1.0F, 0.0F, -0.49F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.75F, -0.01F));
		PartDefinition upperMuzzle = head.addOrReplaceChild("upperMuzzle", CubeListBuilder.create(), PartPose.offset(0.0F, 1.75F, -1.0F));
		PartDefinition rUpperLip_r1 = upperMuzzle.addOrReplaceChild("rUpperLip_r1", CubeListBuilder.create().texOffs(7, 56).mirror().addBox(-1.5F, -0.75F, -1.25F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.0436F, -0.1309F));
		PartDefinition lUpperLip_r1 = upperMuzzle.addOrReplaceChild("lUpperLip_r1", CubeListBuilder.create().texOffs(7, 56).addBox(-0.5F, -0.75F, -1.25F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0436F, 0.1309F));
		PartDefinition lHorn01 = head.addOrReplaceChild("lHorn01", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 0.2F, -3.4F, -0.2618F, -0.3927F, 0.0F));
		PartDefinition cube_r1 = lHorn01.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(22, 34).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition lHorn02 = lHorn01.addOrReplaceChild("lHorn02", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -2.25F, 0.9163F, 0.0F, 0.3491F));
		PartDefinition cube_r2 = lHorn02.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(21, 39).addBox(-1.0F, -2.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));
		PartDefinition lHorn03 = lHorn02.addOrReplaceChild("lHorn03", CubeListBuilder.create().texOffs(30, 40).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.75F, 0.25F, -0.9163F, 0.5236F, 0.0F));
		PartDefinition lHorn04 = lHorn03.addOrReplaceChild("lHorn04", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -2.75F, 0.0F, -1.2217F, -1.6581F));
		PartDefinition cube_r3 = lHorn04.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(39, 42).addBox(-2.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));
		PartDefinition lHorn05 = lHorn04.addOrReplaceChild("lHorn05", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
		PartDefinition cube_r4 = lHorn05.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(32, 45).addBox(-0.4F, -0.5F, -2.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0873F));
		PartDefinition lHorn06 = lHorn05.addOrReplaceChild("lHorn06", CubeListBuilder.create().texOffs(41, 46).addBox(-0.5F, -0.5F, -0.65F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.25F, 0.0F, -2.25F, 0.0F, 1.4399F, 0.0F));
		PartDefinition rHorn01 = head.addOrReplaceChild("rHorn01", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, 0.2F, -3.4F, -0.2618F, 0.3927F, 0.0F));
		PartDefinition cube_r5 = rHorn01.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(22, 34).mirror().addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition rHorn02 = rHorn01.addOrReplaceChild("rHorn02", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -2.25F, 0.9163F, 0.0F, -0.3491F));
		PartDefinition cube_r6 = rHorn02.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(21, 39).mirror().addBox(-1.0F, -2.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.4F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
		PartDefinition rHorn03 = rHorn02.addOrReplaceChild("rHorn03", CubeListBuilder.create().texOffs(30, 40).mirror().addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.75F, 0.25F, -0.9163F, -0.5236F, 0.0F));
		PartDefinition rHorn04 = rHorn03.addOrReplaceChild("rHorn04", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -2.75F, 0.0F, 1.2217F, 1.6581F));
		PartDefinition cube_r7 = rHorn04.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(39, 42).mirror().addBox(0.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));
		PartDefinition rHorn05 = rHorn04.addOrReplaceChild("rHorn05", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.0F, -1.1781F, 0.0F));
		PartDefinition cube_r8 = rHorn05.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(32, 45).mirror().addBox(-0.6F, -0.5F, -2.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0873F));
		PartDefinition rHorn06 = rHorn05.addOrReplaceChild("rHorn06", CubeListBuilder.create().texOffs(41, 46).mirror().addBox(-1.5F, -0.5F, -0.65F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(-0.25F, 0.0F, -2.25F, 0.0F, -1.4399F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	public static LayerDefinition createSpringbokLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition chest = partdefinition.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 34).addBox(-2.5F, -3.0F, -5.0F, 5.0F, 6.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offset(0.0F, 9.8F, -5.6F));
		PartDefinition neck = chest.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 45).addBox(-2.0F, -2.5F, -6.0F, 4.0F, 5.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.65F, -2.0F, -0.6632F, 0.0F, 0.0F));
		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(17, 55).addBox(-2.0F, -3.25F, -4.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 1.1F, -5.0F, -0.3142F, 0.0F, 0.0F));
		PartDefinition snout = head.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(0, 57).addBox(-1.0F, -0.5F, -0.75F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.45F, -2.35F, 0.2618F, 0.0F, 0.0F));
		PartDefinition lEar = head.addOrReplaceChild("lEar", CubeListBuilder.create().texOffs(22, 48).mirror().addBox(-1.0F, -0.7F, -3.35F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.35F, -1.75F, -3.25F, -0.0873F, -0.9512F, 0.0F));
		PartDefinition rEar = head.addOrReplaceChild("rEar", CubeListBuilder.create().texOffs(22, 48).addBox(-1.0F, -0.7F, -3.35F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.35F, -1.5F, -3.25F, -0.0873F, 0.9512F, 0.0F));
		PartDefinition throat = head.addOrReplaceChild("throat", CubeListBuilder.create().texOffs(35, 57).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 0.95F, -0.24F));
		PartDefinition lowerJaw = throat.addOrReplaceChild("lowerJaw", CubeListBuilder.create().texOffs(36, 61).addBox(-1.0F, 0.0F, -0.49F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.75F, -0.01F));
		PartDefinition upperMuzzle = head.addOrReplaceChild("upperMuzzle", CubeListBuilder.create(), PartPose.offset(0.0F, 1.75F, -1.0F));
		PartDefinition rUpperLip_r1 = upperMuzzle.addOrReplaceChild("rUpperLip_r1", CubeListBuilder.create().texOffs(7, 56).mirror().addBox(-1.5F, -0.75F, -1.25F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.0436F, -0.1309F));
		PartDefinition lUpperLip_r1 = upperMuzzle.addOrReplaceChild("lUpperLip_r1", CubeListBuilder.create().texOffs(7, 56).addBox(-0.5F, -0.75F, -1.25F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0436F, 0.1309F));
		PartDefinition lHorn01 = head.addOrReplaceChild("lHorn01", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 0.2F, -3.4F, -0.2618F, -0.0873F, 0.0F));
		PartDefinition cube_r1 = lHorn01.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(22, 34).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition lHorn02 = lHorn01.addOrReplaceChild("lHorn02", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.25F, 0.0F, -1.75F, -0.1745F, -0.3054F, 0.0F));
		PartDefinition cube_r2 = lHorn02.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(22, 40).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.45F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition lHorn03 = lHorn02.addOrReplaceChild("lHorn03", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.1309F, -0.3927F, 0.0F));
		PartDefinition cube_r3 = lHorn03.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(33, 41).addBox(-0.55F, -0.4F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition lHorn04 = lHorn03.addOrReplaceChild("lHorn04", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -1.5F, -0.2182F, 0.4363F, 0.0F));
		PartDefinition cube_r4 = lHorn04.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(42, 41).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition lHorn05 = lHorn04.addOrReplaceChild("lHorn05", CubeListBuilder.create(), PartPose.offsetAndRotation(0.25F, 0.25F, -2.75F, -0.5236F, 0.5236F, 0.0F));
		PartDefinition cube_r5 = lHorn05.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(42, 46).addBox(-0.75F, -0.5F, -2.75F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition rHorn01 = head.addOrReplaceChild("rHorn01", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, 0.2F, -3.4F, -0.2618F, 0.0873F, 0.0F));
		PartDefinition cube_r6 = rHorn01.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(22, 34).mirror().addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.4F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition rHorn02 = rHorn01.addOrReplaceChild("rHorn02", CubeListBuilder.create(), PartPose.offsetAndRotation(0.25F, 0.0F, -1.75F, -0.1745F, 0.3054F, 0.0F));
		PartDefinition cube_r7 = rHorn02.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(22, 40).mirror().addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.45F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition rHorn03 = rHorn02.addOrReplaceChild("rHorn03", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.1309F, 0.3927F, 0.0F));
		PartDefinition cube_r8 = rHorn03.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(33, 41).mirror().addBox(-0.45F, -0.4F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.05F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition rHorn04 = rHorn03.addOrReplaceChild("rHorn04", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -1.5F, -0.2182F, -0.4363F, 0.0F));
		PartDefinition cube_r9 = rHorn04.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(42, 41).mirror().addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition rHorn05 = rHorn04.addOrReplaceChild("rHorn05", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.25F, 0.25F, -2.75F, -0.5236F, -0.5236F, 0.0F));
		PartDefinition cube_r10 = rHorn05.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(42, 46).mirror().addBox(-0.25F, -0.5F, -2.75F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	public static LayerDefinition createErlangerLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition chest = partdefinition.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 34).addBox(-2.5F, -3.0F, -5.0F, 5.0F, 6.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offset(0.0F, 9.8F, -5.6F));
		PartDefinition neck = chest.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 45).addBox(-2.0F, -2.5F, -6.0F, 4.0F, 5.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.65F, -2.0F, -0.6632F, 0.0F, 0.0F));
		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(17, 55).addBox(-2.0F, -3.25F, -4.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 1.1F, -5.0F, -0.3142F, 0.0F, 0.0F));
		PartDefinition snout = head.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(0, 57).addBox(-1.0F, -0.5F, -0.75F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.45F, -2.35F, 0.2618F, 0.0F, 0.0F));
		PartDefinition lEar = head.addOrReplaceChild("lEar", CubeListBuilder.create().texOffs(22, 48).mirror().addBox(-1.0F, -0.7F, -3.35F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.35F, -1.75F, -3.25F, -0.0873F, -0.9512F, 0.0F));
		PartDefinition rEar = head.addOrReplaceChild("rEar", CubeListBuilder.create().texOffs(22, 48).addBox(-1.0F, -0.7F, -3.35F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.35F, -1.5F, -3.25F, -0.0873F, 0.9512F, 0.0F));
		PartDefinition throat = head.addOrReplaceChild("throat", CubeListBuilder.create().texOffs(35, 57).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 0.95F, -0.24F));
		PartDefinition lowerJaw = throat.addOrReplaceChild("lowerJaw", CubeListBuilder.create().texOffs(36, 61).addBox(-1.0F, 0.0F, -0.49F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.75F, -0.01F));
		PartDefinition upperMuzzle = head.addOrReplaceChild("upperMuzzle", CubeListBuilder.create(), PartPose.offset(0.0F, 1.75F, -1.0F));
		PartDefinition rUpperLip_r1 = upperMuzzle.addOrReplaceChild("rUpperLip_r1", CubeListBuilder.create().texOffs(7, 56).mirror().addBox(-1.5F, -0.75F, -1.25F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.0436F, -0.1309F));
		PartDefinition lUpperLip_r1 = upperMuzzle.addOrReplaceChild("lUpperLip_r1", CubeListBuilder.create().texOffs(7, 56).addBox(-0.5F, -0.75F, -1.25F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0436F, 0.1309F));
		PartDefinition lHorn01 = head.addOrReplaceChild("lHorn01", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 0.2F, -3.15F, -0.48F, -0.1745F, 0.0F));
		PartDefinition cube_r1 = lHorn01.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(22, 34).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition lHorn02 = lHorn01.addOrReplaceChild("lHorn02", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.25F, -3.25F, -0.3927F, -0.1745F, 0.0F));
		PartDefinition cube_r2 = lHorn02.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(21, 41).addBox(-0.6F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition lHorn03 = lHorn02.addOrReplaceChild("lHorn03", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.25F, 0.25F, -3.0F, -0.2618F, -0.1745F, 0.0F));
		PartDefinition cube_r3 = lHorn03.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(30, 41).addBox(-0.5F, -0.75F, -2.75F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition lHorn04 = lHorn03.addOrReplaceChild("lHorn04", CubeListBuilder.create(), PartPose.offsetAndRotation(0.25F, -0.25F, -3.0F, 0.2618F, 0.2182F, 0.0F));
		PartDefinition cube_r4 = lHorn04.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(39, 41).addBox(-0.5F, -0.25F, -2.25F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition rHorn01 = head.addOrReplaceChild("rHorn01", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, 0.2F, -3.15F, -0.48F, 0.1745F, 0.0F));
		PartDefinition cube_r5 = rHorn01.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(22, 34).mirror().addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.4F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition rHorn02 = rHorn01.addOrReplaceChild("rHorn02", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.25F, -3.25F, -0.3927F, 0.1745F, 0.0F));
		PartDefinition cube_r6 = rHorn02.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(21, 41).mirror().addBox(-0.4F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition rHorn03 = rHorn02.addOrReplaceChild("rHorn03", CubeListBuilder.create(), PartPose.offsetAndRotation(0.25F, 0.25F, -3.0F, -0.2618F, 0.1745F, 0.0F));
		PartDefinition cube_r7 = rHorn03.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(30, 41).mirror().addBox(-0.5F, -0.75F, -2.75F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition rHorn04 = rHorn03.addOrReplaceChild("rHorn04", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.25F, -0.25F, -3.0F, 0.2618F, -0.2182F, 0.0F));
		PartDefinition cube_r8 = rHorn04.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(39, 41).mirror().addBox(-0.5F, -0.25F, -2.25F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public ModelPart basePart() {
		return chest;
	}

	@Override
	public float wallOffsetX() {
		return 4.2F;
	}

	@Override
	public float globalOffsetY() {
		return 3F;
	}
}