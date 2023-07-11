// Made with Blockbench 4.7.4
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

public class ModelArapaima<T extends LivingEntity> extends ModelBAP<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "arapaima"), "main");
	private final ModelPart body;

	public ModelArapaima(ModelPart root) {
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(1, 1).addBox(-3.0F, -5.0F, -5.0F, 6.0F, 8.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.0F, -10.0F));

		PartDefinition body2 = body.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(55, 0).addBox(-2.5F, -6.0F, -1.0F, 5.0F, 9.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, 15.0F));

		PartDefinition tailFin = body2.addOrReplaceChild("tailFin", CubeListBuilder.create().texOffs(1, 4).addBox(0.0F, -4.0F, 0.0F, 0.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 13.0F));

		PartDefinition dorsalFin = body2.addOrReplaceChild("dorsalFin", CubeListBuilder.create().texOffs(55, 9).addBox(0.0F, -3.0F, -1.0F, 0.0F, 4.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

		PartDefinition lowFin = body2.addOrReplaceChild("lowFin", CubeListBuilder.create().texOffs(98, 4).addBox(0.0F, -3.0F, -1.0F, 0.0F, 4.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition leftFin2 = body2.addOrReplaceChild("leftFin2", CubeListBuilder.create().texOffs(82, 0).addBox(0.0F, -0.5F, 0.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.25F, 1.25F, 0.0F, -0.4956F, 0.1395F, -0.2223F));

		PartDefinition rightFin2 = body2.addOrReplaceChild("rightFin2", CubeListBuilder.create().texOffs(82, 0).mirror().addBox(0.0F, -0.5F, 0.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.25F, 1.25F, 0.0F, -0.4956F, -0.1395F, 0.2223F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(95, 0).addBox(-2.5F, 0.0F, -9.0F, 5.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, -5.0F));

		PartDefinition leftFin1 = body.addOrReplaceChild("leftFin1", CubeListBuilder.create().texOffs(56, 0).addBox(0.0F, -1.5F, 0.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 1.5F, -3.0F, -0.4956F, 0.1395F, -0.2223F));

		PartDefinition rightFin1 = body.addOrReplaceChild("rightFin1", CubeListBuilder.create().texOffs(56, 0).mirror().addBox(0.0F, -1.5F, 0.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 1.5F, -3.0F, -0.4956F, -0.1395F, 0.2223F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}