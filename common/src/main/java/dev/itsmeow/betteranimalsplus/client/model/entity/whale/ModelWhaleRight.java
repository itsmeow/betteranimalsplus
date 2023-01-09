package dev.itsmeow.betteranimalsplus.client.model.entity.whale;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import dev.itsmeow.betteranimalsplus.common.entity.EntityWhale;
import dev.itsmeow.betteranimalsplus.util.ModMathHelper;
import dev.itsmeow.imdlib.client.util.RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class ModelWhaleRight<T extends EntityWhale> extends ModelBAP<T> {

	public ModelPart body;
	public ModelPart lFin00;
	public ModelPart lFin02;
	public ModelPart lFin03;
	public ModelPart rFin00;
	public ModelPart rFin02;
	public ModelPart rFin03;
	public ModelPart torso;
	public ModelPart head;
	public ModelPart cube_r1;
	public ModelPart cube_r2;
	public ModelPart lowJaw;
	public ModelPart cube_r3;
	public ModelPart cube_r4;
	public ModelPart cube_r5;
	public ModelPart tail00;
	public ModelPart tail01;
	public ModelPart tail02;
	public ModelPart tail03;
	public ModelPart tail04;
	public ModelPart tail05;
	public ModelPart flukeMiddle;
	public ModelPart flukeL01;
	public ModelPart flukeL02;
	public ModelPart flukeL03;
	public ModelPart flukeR01;
	public ModelPart flukeR02;
	public ModelPart flukeR03;
	private boolean inWater;

	public ModelWhaleRight(ModelPart root) {
		this.body = root.getChild("body");
		this.lFin00 = body.getChild("lFin00");
		this.lFin02 = lFin00.getChild("lFin02");
		this.lFin03 = lFin02.getChild("lFin03");
		this.rFin00 = body.getChild("rFin00");
		this.rFin02 = rFin00.getChild("rFin02");
		this.rFin03 = rFin02.getChild("rFin03");
		this.torso = body.getChild("torso");
		this.head = torso.getChild("head");
		this.cube_r1 = head.getChild("cube_r1");
		this.cube_r2 = head.getChild("cube_r2");
		this.lowJaw = torso.getChild("lowJaw");
		this.cube_r3 = lowJaw.getChild("cube_r3");
		this.cube_r4 = lowJaw.getChild("cube_r4");
		this.cube_r5 = lowJaw.getChild("cube_r5");
		this.tail00 = body.getChild("tail00");
		this.tail01 = tail00.getChild("tail01");
		this.tail02 = tail01.getChild("tail02");
		this.tail03 = tail02.getChild("tail03");
		this.tail04 = tail03.getChild("tail04");
		this.tail05 = tail04.getChild("tail05");
		this.flukeMiddle = tail05.getChild("flukeMiddle");
		this.flukeL01 = flukeMiddle.getChild("flukeL01");
		this.flukeL02 = flukeL01.getChild("flukeL02");
		this.flukeL03 = flukeL02.getChild("flukeL03");
		this.flukeR01 = flukeMiddle.getChild("flukeR01");
		this.flukeR02 = flukeR01.getChild("flukeR02");
		this.flukeR03 = flukeR02.getChild("flukeR03");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -5.0F, -37.0F, 50.0F, 47.0F, 37.0F, new CubeDeformation(0.0F)), PartPose.offset(0.25F, -25.0F, -6.0F));
		PartDefinition lFin00 = body.addOrReplaceChild("lFin00", CubeListBuilder.create().texOffs(230, 375).addBox(-1.3958F, -1.0135F, -3.8025F, 5.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.0F, 38.1F, -50.65F, 0.7574F, 0.4851F, -0.4582F));
		PartDefinition lFin02 = lFin00.addOrReplaceChild("lFin02", CubeListBuilder.create().texOffs(267, 372).addBox(4.0071F, -1.1364F, 0.2692F, 3.0F, 6.0F, 11.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(-4.4029F, 8.0442F, -3.6492F, 0.3643F, 0.0F, 0.0F));
		PartDefinition lFin03 = lFin02.addOrReplaceChild("lFin03", CubeListBuilder.create().texOffs(302, 371).addBox(4.0071F, -38.2982F, 44.9644F, 3.0F, 12.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 48.804F, -39.5941F, 0.1367F, 0.0F, 0.0F));
		PartDefinition rFin00 = body.addOrReplaceChild("rFin00", CubeListBuilder.create().texOffs(230, 375).mirror().addBox(-3.6042F, -1.0135F, -3.8025F, 5.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-24.25F, 38.1F, -50.65F, 0.7574F, -0.4851F, 0.4582F));
		PartDefinition rFin02 = rFin00.addOrReplaceChild("rFin02", CubeListBuilder.create().texOffs(267, 372).mirror().addBox(-7.0071F, -1.1364F, 0.2692F, 3.0F, 6.0F, 11.0F, new CubeDeformation(-0.05F)).mirror(false), PartPose.offsetAndRotation(4.4029F, 8.0442F, -3.6492F, 0.3643F, 0.0F, 0.0F));
		PartDefinition rFin03 = rFin02.addOrReplaceChild("rFin03", CubeListBuilder.create().texOffs(302, 371).mirror().addBox(-7.0071F, -38.2982F, 44.9644F, 3.0F, 12.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 48.804F, -39.5941F, 0.1367F, 0.0F, 0.0F));
		PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 424).addBox(-20.5F, -33.0872F, -15.9981F, 49.0F, 48.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 28.5F, -39.0F, 0.0436F, 0.0F, 0.0F));
		PartDefinition head = torso.addOrReplaceChild("head", CubeListBuilder.create().texOffs(154, 209).addBox(-19.0F, -3.5F, -13.0F, 44.0F, 34.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(184, 4).addBox(-4.0F, -4.0F, -65.0F, 12.0F, 3.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(206, 76).addBox(-12.0F, -3.25F, -41.0F, 10.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(154, 6).addBox(-3.0F, -0.25F, -69.0F, 10.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-14.0F, -0.25F, -69.0F, 8.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(6, 20).addBox(12.0F, 0.75F, -69.0F, 6.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -29.0872F, -15.9981F));
		PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(295, 375).addBox(-16.0F, -4.7232F, 0.3431F, 37.0F, 19.0F, 54.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, -64.0F, -0.1745F, 0.0F, 0.0F));
		PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(278, 217).addBox(-17.0F, 0.0F, -55.0F, 39.0F, 14.0F, 54.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -12.0F, 0.0436F, 0.0F, 0.0F));
		PartDefinition lowJaw = torso.addOrReplaceChild("lowJaw", CubeListBuilder.create().texOffs(267, 173).addBox(-22.0F, -1.0F, -11.0F, 42.0F, 14.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(167, 102).addBox(-7.0F, -23.0F, -68.0F, 10.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(130, 115).addBox(1.0F, -20.0F, -67.5F, 10.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(160, 130).addBox(17.0F, -20.0F, -64.5F, 3.0F, 7.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(239, 163).addBox(17.0F, -20.0F, -51.5F, 4.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(204, 167).addBox(17.0F, -13.0F, -37.5F, 4.0F, 7.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(161, 161).addBox(17.0F, -23.0F, -29.5F, 4.0F, 12.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(204, 122).addBox(-19.0F, -20.0F, -69.0F, 7.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(141, 95).addBox(-24.0F, -19.0F, -66.0F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(104, 95).addBox(-23.0F, -20.0F, -60.0F, 3.0F, 7.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(65, 95).addBox(-24.0F, -17.0F, -52.0F, 3.0F, 9.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(0, 91).addBox(-24.0F, -22.0F, -38.0F, 3.0F, 12.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(0, 121).addBox(-24.0F, -11.0F, -23.0F, 3.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(202, 102).addBox(-11.0F, -23.0F, -69.0F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 2.0F, -18.0F));
		PartDefinition cube_r3 = lowJaw.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(200, 78).addBox(-21.5F, -11.8497F, -1.1134F, 40.0F, 12.0F, 60.0F, new CubeDeformation(-0.012F)), PartPose.offsetAndRotation(0.0F, -11.0F, -65.0F, -0.3927F, 0.0F, 0.0F));
		PartDefinition cube_r4 = lowJaw.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(354, 69).addBox(-21.95F, -32.0F, -62.0F, 41.0F, 13.0F, 21.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 16.0F, -9.0F, -0.1309F, 0.0F, 0.0F));
		PartDefinition cube_r5 = lowJaw.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(210, 0).addBox(-22.5F, -40.0F, -41.0F, 42.0F, 24.0F, 39.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 16.0F, -9.0F, -0.1096F, 0.0F, 0.0F));
		PartDefinition tail00 = body.addOrReplaceChild("tail00", CubeListBuilder.create().texOffs(0, 119).addBox(-19.5F, -4.1309F, -0.0029F, 45.0F, 44.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -0.75F, 0.0F));
		PartDefinition tail01 = tail00.addOrReplaceChild("tail01", CubeListBuilder.create().texOffs(0, 216).addBox(-16.0F, -4.1139F, 0.2194F, 39.0F, 40.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.3691F, 24.9971F, -0.0436F, 0.0F, 0.0F));
		PartDefinition tail02 = tail01.addOrReplaceChild("tail02", CubeListBuilder.create().texOffs(0, 298).addBox(-11.0F, -3.0872F, -1.0019F, 29.0F, 33.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.8639F, 28.2194F));
		PartDefinition tail03 = tail02.addOrReplaceChild("tail03", CubeListBuilder.create().texOffs(131, 304).addBox(-11.0F, -2.9839F, -2.736F, 24.0F, 30.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 0.1628F, 21.9981F, -0.0436F, 0.0F, 0.0F));
		PartDefinition tail04 = tail03.addOrReplaceChild("tail04", CubeListBuilder.create().texOffs(0, 371).addBox(-9.8377F, -2.0574F, 0.3308F, 20.0F, 25.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -0.7339F, 16.014F, -0.0441F, -0.0031F, 0.0054F));
		PartDefinition tail05 = tail04.addOrReplaceChild("tail05", CubeListBuilder.create().texOffs(110, 371).addBox(-5.0F, -3.0152F, 1.0463F, 16.0F, 20.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8377F, 1.6926F, 15.5808F, -0.0436F, 0.0F, 0.0F));
		PartDefinition flukeMiddle = tail05.addOrReplaceChild("flukeMiddle", CubeListBuilder.create(), PartPose.offset(3.0F, 6.4861F, 5.0614F));
		PartDefinition flukeL01 = flukeMiddle.addOrReplaceChild("flukeL01", CubeListBuilder.create().texOffs(338, 319).mirror().addBox(-1.5F, -1.0F, -4.0F, 3.0F, 15.0F, 19.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.3F, -1.9F, -0.5F, 0.2391F, 0.0F, -1.3203F));
		PartDefinition flukeL02 = flukeL01.addOrReplaceChild("flukeL02", CubeListBuilder.create().texOffs(291, 326).mirror().addBox(-1.5F, 0.0F, -4.0F, 2.0F, 14.0F, 15.0F, new CubeDeformation(-0.05F)).mirror(false), PartPose.offsetAndRotation(0.0F, 10.75F, 0.0F, 0.0986F, 0.0F, 0.0F));
		PartDefinition flukeL03 = flukeL02.addOrReplaceChild("flukeL03", CubeListBuilder.create().texOffs(256, 328).mirror().addBox(-1.5F, 0.0F, -4.0F, 1.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 12.75F, 0.0F, 0.2276F, 0.0F, 0.0F));
		PartDefinition flukeR01 = flukeMiddle.addOrReplaceChild("flukeR01", CubeListBuilder.create().texOffs(338, 319).addBox(-3.5F, -1.0F, -4.0F, 2.0F, 15.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3F, 0.1F, -0.5F, 0.2391F, 0.0F, 1.364F));
		PartDefinition flukeR02 = flukeR01.addOrReplaceChild("flukeR02", CubeListBuilder.create().texOffs(291, 326).addBox(-3.5F, 0.0F, -4.0F, 2.0F, 14.0F, 15.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(0.0F, 12.75F, 0.0F, 0.0986F, 0.0F, 0.0F));
		PartDefinition flukeR03 = flukeR02.addOrReplaceChild("flukeR03", CubeListBuilder.create().texOffs(256, 328).addBox(-2.5F, 0.0F, -4.0F, 1.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 12.75F, 0.0F, 0.2276F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		if (!inWater) {
			matrixStackIn.translate(0F, 0.25F, 0F);
		}
		this.body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!Minecraft.getInstance().isPaused()) {
			this.inWater = entity.isInWater();
			if (inWater) {
				float pitch = rad(headPitch);
				this.body.xRot = pitch == 0 ? 0 : (float) ((pitch / Math.abs(pitch)) * Math.min(Math.abs(pitch), Math.toRadians(45F)));
				this.body.yRot = rad(netHeadYaw);
			} else {
				this.body.yRot = -rad(ModMathHelper.interpolateRotation(entity.yBodyRot, entity.yBodyRotO, Minecraft.getInstance().getFrameTime()));
				this.body.xRot = 0F;
			}
			{
				float ticks = ageInTicks / 5F + (float) entity.getDeltaMovement().length() * 0.05F;
				float factor = 1F;
				float offset = 0F;
				float amplitude = (float) Math.min(entity.getDeltaMovement().length() * 1.1F + 0.01F, 0.1F);
				if (!entity.isInWater()) {
					amplitude = 0F;
					offset = -0.1F;
				}
				float z01 = (float) RenderUtil.partLocation(this.tail00, this.tail01).z();
				float z02 = (float) RenderUtil.partLocation(this.tail00, this.tail01, this.tail02).z();
				float z03 = (float) RenderUtil.partLocation(this.tail00, this.tail01, this.tail02, this.tail03).z();
				float z04 = (float) RenderUtil.partLocation(this.tail00, this.tail01, this.tail02, this.tail03, this.tail04).z();
				float z05 = (float) RenderUtil.partLocation(this.tail00, this.tail01, this.tail02, this.tail03, this.tail05).z();
				this.tail01.xRot = Mth.sin(z01 * factor + ticks) * amplitude + offset;
				this.tail02.xRot = Mth.sin(z02 * factor + ticks) * amplitude + offset;
				this.tail03.xRot = Mth.sin(z03 * factor + ticks) * amplitude + offset;
				this.tail04.xRot = Mth.sin(z04 * factor + ticks) * amplitude + offset;
				this.tail05.xRot = Mth.sin(z05 * factor + ticks) * amplitude + offset;
			}
			{
				float mul = 0.1F;
				float div = 10F;
				float add = entity.getUUID().hashCode() * 0.001F;
				this.lFin00.xRot = Mth.cos(ageInTicks * (mul + 0.05F) + add) / div + 0.7574F;
				this.rFin00.xRot = Mth.cos(ageInTicks * (mul) + add) / div + 0.7574F;
			}
		}
	}
}