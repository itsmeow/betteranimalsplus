package dev.itsmeow.betteranimalsplus.client.model.entity;// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class ModelHoatzin<T extends LivingEntity> extends ModelBAP<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "hoatzin"), "main");
	private final ModelPart hoatzin;

	public ModelHoatzin(ModelPart root) {
		this.hoatzin = root.getChild("hoatzin");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition hoatzin = partdefinition.addOrReplaceChild("hoatzin", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 19.75F, 0.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition tail = hoatzin.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(19, 0).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.25F, 2.75F, 0.2182F, 0.0F, 0.0F));

		PartDefinition tailFeathers = tail.addOrReplaceChild("tailFeathers", CubeListBuilder.create().texOffs(14, 6).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 2.0F));

		PartDefinition lLeg = hoatzin.addOrReplaceChild("lLeg", CubeListBuilder.create().texOffs(0, 14).addBox(-1.0F, -0.1F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(1.25F, 0.25F, 1.5F, 0.2182F, 0.0F, 0.0F));

		PartDefinition rLeg = hoatzin.addOrReplaceChild("rLeg", CubeListBuilder.create().texOffs(0, 14).mirror().addBox(-1.0F, -0.1F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(-1.25F, 0.25F, 1.5F, 0.2182F, 0.0F, 0.0F));

		PartDefinition lWing01 = hoatzin.addOrReplaceChild("lWing01", CubeListBuilder.create().texOffs(0, 11).addBox(0.25F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.75F, -1.5F, -2.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition lWing02 = lWing01.addOrReplaceChild("lWing02", CubeListBuilder.create().texOffs(8, 11).addBox(0.0F, -1.0F, -0.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.25F, 0.0F, -0.5F));

		PartDefinition lWingFeathers02 = lWing02.addOrReplaceChild("lWingFeathers02", CubeListBuilder.create().texOffs(6, 24).addBox(-1.0F, -2.0F, -0.5F, 9.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 1.0F, 0.5F));

		PartDefinition lWingFeathers01 = lWing01.addOrReplaceChild("lWingFeathers01", CubeListBuilder.create().texOffs(0, 24).addBox(-1.0F, -2.0F, -0.5F, 3.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(1.25F, 1.0F, 0.0F));

		PartDefinition rWing01 = hoatzin.addOrReplaceChild("rWing01", CubeListBuilder.create().texOffs(0, 11).mirror().addBox(-3.25F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.75F, -1.5F, -2.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition rWing02 = rWing01.addOrReplaceChild("rWing02", CubeListBuilder.create().texOffs(8, 11).mirror().addBox(-4.0F, -1.0F, -0.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.25F, 0.0F, -0.5F));

		PartDefinition rWingFeathers01 = rWing02.addOrReplaceChild("rWingFeathers01", CubeListBuilder.create().texOffs(6, 24).mirror().addBox(-8.0F, -2.0F, -0.5F, 9.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 1.0F, 0.5F));

		PartDefinition rWingFeathers02 = rWing01.addOrReplaceChild("rWingFeathers02", CubeListBuilder.create().texOffs(0, 24).mirror().addBox(-2.0F, -2.0F, -0.5F, 3.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.25F, 1.0F, 0.0F));

		PartDefinition neck = hoatzin.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(8, 17).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.5F, -3.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(15, 12).addBox(-1.0F, -3.0F, -1.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(20, 12).addBox(0.0F, -6.0F, -1.5F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0513F, -0.2832F));

		PartDefinition beak = head.addOrReplaceChild("beak", CubeListBuilder.create().texOffs(26, 12).addBox(-0.75F, -1.5987F, -1.5F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.25F, -0.5F, -1.5F));

		PartDefinition beaktip = beak.addOrReplaceChild("beaktip", CubeListBuilder.create(), PartPose.offset(-0.25F, -0.6987F, -0.9668F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		hoatzin.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}