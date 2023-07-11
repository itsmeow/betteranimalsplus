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

public class ModelCrayfish<T extends LivingEntity> extends ModelBAP<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "crayfish"), "main");
	private final ModelPart crayfish;

	public ModelCrayfish(ModelPart root) {
		this.crayfish = root.getChild("crayfish");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition crayfish = partdefinition.addOrReplaceChild("crayfish", CubeListBuilder.create().texOffs(0, 6).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.01F)), PartPose.offset(0.0F, 21.25F, -2.0F));

		PartDefinition cube_r1 = crayfish.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -2.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition lFeeler = crayfish.addOrReplaceChild("lFeeler", CubeListBuilder.create().texOffs(10, 10).addBox(-0.5F, 0.0F, -6.0F, 1.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, -0.5F, -2.0F, -0.3491F, -0.2182F, 0.0F));

		PartDefinition rFeeler = crayfish.addOrReplaceChild("rFeeler", CubeListBuilder.create().texOffs(10, 10).mirror().addBox(-0.5F, 0.0F, -6.0F, 1.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.75F, -0.5F, -2.0F, -0.3491F, 0.2182F, 0.0F));

		PartDefinition tail = crayfish.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 12).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 2.75F, -0.1745F, 0.0F, 0.0F));

		PartDefinition lFin = tail.addOrReplaceChild("lFin", CubeListBuilder.create().texOffs(7, 0).addBox(-1.0F, 0.0F, -3.0F, 4.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.48F));

		PartDefinition rFin = tail.addOrReplaceChild("rFin", CubeListBuilder.create().texOffs(7, 0).mirror().addBox(-3.0F, 0.0F, -3.0F, 4.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 0.0F, 2.0F, 0.0F, 0.0F, -0.48F));

		PartDefinition lClaw = crayfish.addOrReplaceChild("lClaw", CubeListBuilder.create().texOffs(-6, 26).addBox(-0.25F, 0.0F, -5.0F, 5.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.5F, -2.0F, 0.0F, 0.0873F, 0.0F));

		PartDefinition rClaw = crayfish.addOrReplaceChild("rClaw", CubeListBuilder.create().texOffs(-6, 26).mirror().addBox(-4.75F, 0.0F, -5.0F, 5.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 0.5F, -2.0F, 0.0F, -0.0873F, 0.0F));

		PartDefinition lLegs = crayfish.addOrReplaceChild("lLegs", CubeListBuilder.create().texOffs(-4, 20).addBox(0.0F, 0.0F, -2.0F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.25F, 0.0F, 0.0F, 0.0F, 0.5672F));

		PartDefinition rLegs = crayfish.addOrReplaceChild("rLegs", CubeListBuilder.create().texOffs(-4, 20).mirror().addBox(-5.0F, 0.0F, -2.0F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 0.25F, 0.0F, 0.0F, 0.0F, -0.5672F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		crayfish.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}