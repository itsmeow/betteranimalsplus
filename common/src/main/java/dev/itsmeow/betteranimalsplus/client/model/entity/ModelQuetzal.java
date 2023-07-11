package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;

public class ModelQuetzal<T extends LivingEntity> extends ModelBAP<T> {
	private final ModelPart quetzal;

	public ModelQuetzal(ModelPart root) {
		this.quetzal = root.getChild("quetzal");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition quetzal = partdefinition.addOrReplaceChild("quetzal", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -4.0513F, -1.7832F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.5F, 0.0F));

		PartDefinition head = quetzal.addOrReplaceChild("head", CubeListBuilder.create().texOffs(18, 0).addBox(-1.5F, -3.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(16, 1).addBox(0.0F, -5.0F, -1.5F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.8013F, 0.2168F));

		PartDefinition beak = head.addOrReplaceChild("beak", CubeListBuilder.create().texOffs(13, 0).addBox(-0.75F, -1.0987F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.25F, -0.5F, -1.5F));

		PartDefinition beaktip = beak.addOrReplaceChild("beaktip", CubeListBuilder.create(), PartPose.offset(-0.25F, -0.6987F, -0.9668F));

		PartDefinition cube_r1 = beaktip.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(13, 2).addBox(-0.5F, -0.4F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition lowerBody = quetzal.addOrReplaceChild("lowerBody", CubeListBuilder.create().texOffs(0, 8).addBox(-1.5F, 0.0F, -1.25F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5513F, 0.2168F, 0.1309F, 0.0F, 0.0F));

		PartDefinition tail = lowerBody.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(8, 17).addBox(-2.0F, 0.1478F, -1.0265F, 4.0F, 5.0F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition lTailFeather = tail.addOrReplaceChild("lTailFeather", CubeListBuilder.create().texOffs(26, 6).addBox(-1.75F, -2.0F, -0.25F, 3.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 1.8978F, 1.2235F, 0.0F, 0.0436F, -0.1745F));

		PartDefinition rTailFeather = tail.addOrReplaceChild("rTailFeather", CubeListBuilder.create().texOffs(26, 6).mirror().addBox(-1.25F, -2.0F, -0.25F, 3.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 1.8978F, 1.2235F, 0.0F, -0.0436F, 0.1745F));

		PartDefinition lLeg = quetzal.addOrReplaceChild("lLeg", CubeListBuilder.create().texOffs(0, 14).addBox(-1.0F, -0.1F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offset(1.0F, -0.25F, 0.5F));

		PartDefinition rLeg = quetzal.addOrReplaceChild("rLeg", CubeListBuilder.create().texOffs(0, 14).mirror().addBox(-1.0F, -0.1F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offset(-1.0F, -0.25F, 0.5F));

		PartDefinition lWing01 = quetzal.addOrReplaceChild("lWing01", CubeListBuilder.create().texOffs(8, 14).addBox(0.25F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.75F, -3.0F, 1.0F));

		PartDefinition lWing02 = lWing01.addOrReplaceChild("lWing02", CubeListBuilder.create().texOffs(16, 14).addBox(0.0F, -1.0F, -0.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.25F, 0.0F, -0.5F));

		PartDefinition lWingFeathers02 = lWing02.addOrReplaceChild("lWingFeathers02", CubeListBuilder.create().texOffs(6, 24).addBox(-1.0F, -2.0F, -0.5F, 13.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 1.0F, 0.5F));

		PartDefinition lWingFeathers01 = lWing01.addOrReplaceChild("lWingFeathers01", CubeListBuilder.create().texOffs(0, 24).addBox(-1.0F, -2.0F, -0.5F, 3.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(1.25F, 1.0F, 0.0F));

		PartDefinition rWing01 = quetzal.addOrReplaceChild("rWing01", CubeListBuilder.create().texOffs(8, 14).mirror().addBox(-3.25F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.75F, -3.0F, 1.0F));

		PartDefinition rWing02 = rWing01.addOrReplaceChild("rWing02", CubeListBuilder.create().texOffs(16, 14).mirror().addBox(-4.0F, -1.0F, -0.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.25F, 0.0F, -0.5F));

		PartDefinition rWingFeathers01 = rWing02.addOrReplaceChild("rWingFeathers01", CubeListBuilder.create().texOffs(6, 24).mirror().addBox(-12.0F, -2.0F, -0.5F, 13.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 1.0F, 0.5F));

		PartDefinition rWingFeathers02 = rWing01.addOrReplaceChild("rWingFeathers02", CubeListBuilder.create().texOffs(0, 24).mirror().addBox(-2.0F, -2.0F, -0.5F, 3.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.25F, 1.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		quetzal.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}