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

public class ModelWhaleSperm<T extends EntityWhale> extends ModelBAP<T> {

	public ModelPart body;
	public ModelPart lFin00;
	public ModelPart lFin02;
	public ModelPart lFin03;
	public ModelPart rFin00;
	public ModelPart rFin02;
	public ModelPart rFin03;
	public ModelPart torso;
	public ModelPart head;
	public ModelPart topJaw;
	public ModelPart lowJaw;
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
	public ModelPart backBump3;
	public ModelPart backBump1;
	public ModelPart backBump2;
	public ModelPart DorsalFin;
	private boolean inWater;

	public ModelWhaleSperm(ModelPart root) {
		this.body = root.getChild("body");
		this.lFin00 = body.getChild("lFin00");
		this.lFin02 = lFin00.getChild("lFin02");
		this.lFin03 = lFin02.getChild("lFin03");
		this.rFin00 = body.getChild("rFin00");
		this.rFin02 = rFin00.getChild("rFin02");
		this.rFin03 = rFin02.getChild("rFin03");
		this.torso = body.getChild("torso");
		this.head = torso.getChild("head");
		this.topJaw = head.getChild("topJaw");
		this.lowJaw = head.getChild("lowJaw");
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
		this.backBump3 = tail02.getChild("backBump3");
		this.backBump1 = tail01.getChild("backBump1");
		this.backBump2 = tail01.getChild("backBump2");
		this.DorsalFin = tail00.getChild("DorsalFin");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-26.0F, -5.0F, -58.0F, 52.0F, 55.0F, 58.0F, new CubeDeformation(0.0F)), PartPose.offset(0.25F, -25.0F, -7.0F));
		PartDefinition lFin00 = body.addOrReplaceChild("lFin00", CubeListBuilder.create().texOffs(230, 375).addBox(-1.3958F, -1.0135F, -3.8025F, 5.0F, 9.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(25.0F, 38.1F, -55.65F, 1.0472F, 0.0F, 0.0F));
		PartDefinition lFin02 = lFin00.addOrReplaceChild("lFin02", CubeListBuilder.create().texOffs(267, 372).addBox(4.0071F, -40.2404F, 40.8632F, 3.0F, 10.0F, 11.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(-4.4029F, 60.0442F, -27.6492F, 0.3643F, 0.0F, 0.0F));
		PartDefinition lFin03 = lFin02.addOrReplaceChild("lFin03", CubeListBuilder.create().texOffs(302, 371).addBox(4.0071F, -34.2982F, 44.9644F, 3.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.7F, 1.0F, 0.1367F, 0.0F, 0.0F));
		PartDefinition rFin00 = body.addOrReplaceChild("rFin00", CubeListBuilder.create().texOffs(230, 375).addBox(-2.3958F, -1.0135F, -3.8025F, 5.0F, 9.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-26.0F, 38.1F, -55.65F, 1.0472F, 0.0F, 0.0F));
		PartDefinition rFin02 = rFin00.addOrReplaceChild("rFin02", CubeListBuilder.create().texOffs(267, 372).addBox(4.0071F, -40.2404F, 40.8632F, 3.0F, 10.0F, 11.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(-5.4029F, 60.0442F, -27.6492F, 0.3643F, 0.0F, 0.0F));
		PartDefinition rFin03 = rFin02.addOrReplaceChild("rFin03", CubeListBuilder.create().texOffs(302, 371).addBox(4.0071F, -34.2982F, 44.9644F, 3.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.7F, 1.0F, 0.1367F, 0.0F, 0.0F));
		PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 424).addBox(-22.5F, -33.0872F, -23.9981F, 51.0F, 54.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 28.5F, -59.0F, 0.0436F, 0.0F, 0.0F));
		PartDefinition head = torso.addOrReplaceChild("head", CubeListBuilder.create().texOffs(154, 209).addBox(-22.0F, -3.5F, -16.0F, 48.0F, 51.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -29.0872F, -23.9981F));
		PartDefinition topJaw = head.addOrReplaceChild("topJaw", CubeListBuilder.create().texOffs(179, 107).addBox(-17.0F, -13.0F, -51.0F, 38.0F, 13.0F, 52.0F, new CubeDeformation(0.0F))
		.texOffs(344, 129).addBox(-14.0F, -1.0F, -49.0F, 33.0F, 3.0F, 51.0F, new CubeDeformation(0.0F))
		.texOffs(225, 0).addBox(-18.0F, -46.0F, -56.0F, 40.0F, 42.0F, 57.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 42.0F, -16.0F));
		PartDefinition lowJaw = head.addOrReplaceChild("lowJaw", CubeListBuilder.create().texOffs(305, 193).addBox(-14.5F, 0.0F, -51.0F, 34.0F, 5.0F, 51.0F, new CubeDeformation(0.0F))
		.texOffs(294, 259).addBox(-13.5F, -2.0F, -49.75F, 32.0F, 2.0F, 50.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 42.0F, -15.0F, -0.0436F, 0.0F, 0.0F));
		PartDefinition tail00 = body.addOrReplaceChild("tail00", CubeListBuilder.create().texOffs(0, 119).addBox(-21.5F, -4.1309F, -0.0029F, 48.0F, 51.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -0.75F, -2.0F));
		PartDefinition tail01 = tail00.addOrReplaceChild("tail01", CubeListBuilder.create().texOffs(0, 216).addBox(-18.0F, -4.1139F, 0.2194F, 43.0F, 47.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.3691F, 31.9971F, -0.0436F, 0.0F, 0.0F));
		PartDefinition tail02 = tail01.addOrReplaceChild("tail02", CubeListBuilder.create().texOffs(0, 298).addBox(-15.0F, -3.0872F, -1.0019F, 37.0F, 42.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.8639F, 28.2194F));
		PartDefinition tail03 = tail02.addOrReplaceChild("tail03", CubeListBuilder.create().texOffs(131, 304).addBox(-15.0F, -2.9839F, -2.736F, 32.0F, 36.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 0.1628F, 21.9981F, -0.0436F, 0.0F, 0.0F));
		PartDefinition tail04 = tail03.addOrReplaceChild("tail04", CubeListBuilder.create().texOffs(0, 371).addBox(-13.8377F, -2.0574F, 0.3308F, 28.0F, 27.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -0.7339F, 21.014F, -0.0441F, -0.0031F, 0.0054F));
		PartDefinition tail05 = tail04.addOrReplaceChild("tail05", CubeListBuilder.create().texOffs(110, 371).addBox(-9.0F, -3.0152F, 1.0463F, 24.0F, 22.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8377F, 1.6926F, 20.5808F, -0.0436F, 0.0F, 0.0F));
		PartDefinition flukeMiddle = tail05.addOrReplaceChild("flukeMiddle", CubeListBuilder.create(), PartPose.offset(3.0F, 6.4861F, 19.0614F));
		PartDefinition flukeL01 = flukeMiddle.addOrReplaceChild("flukeL01", CubeListBuilder.create().texOffs(338, 319).mirror().addBox(-2.5F, -1.0F, -4.0F, 3.0F, 17.0F, 19.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.3F, -1.9F, -0.5F, 0.2391F, 0.0F, -1.3203F));
		PartDefinition flukeL02 = flukeL01.addOrReplaceChild("flukeL02", CubeListBuilder.create().texOffs(291, 326).mirror().addBox(-2.5F, 0.0F, -4.0F, 3.0F, 16.0F, 15.0F, new CubeDeformation(-0.05F)).mirror(false), PartPose.offsetAndRotation(0.0F, 10.75F, 0.0F, 0.0986F, 0.0F, 0.0F));
		PartDefinition flukeL03 = flukeL02.addOrReplaceChild("flukeL03", CubeListBuilder.create().texOffs(256, 328).mirror().addBox(-2.5F, 0.0F, -4.0F, 3.0F, 19.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 14.75F, 0.0F, 0.2276F, 0.0F, 0.0F));
		PartDefinition flukeR01 = flukeMiddle.addOrReplaceChild("flukeR01", CubeListBuilder.create().texOffs(338, 319).addBox(-2.5F, -1.0F, -4.0F, 3.0F, 17.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3F, 0.1F, -0.5F, 0.2391F, 0.0F, 1.364F));
		PartDefinition flukeR02 = flukeR01.addOrReplaceChild("flukeR02", CubeListBuilder.create().texOffs(291, 326).addBox(-2.5F, 0.0F, -4.0F, 3.0F, 16.0F, 15.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(0.0F, 12.75F, 0.0F, 0.0986F, 0.0F, 0.0F));
		PartDefinition flukeR03 = flukeR02.addOrReplaceChild("flukeR03", CubeListBuilder.create().texOffs(256, 328).addBox(-2.5F, 0.0F, -4.0F, 3.0F, 19.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 14.75F, 0.0F, 0.2276F, 0.0F, 0.0F));
		PartDefinition backBump3 = tail02.addOrReplaceChild("backBump3", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 5.0F, 16.0F, 3.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 1.4681F, -15.9952F, 0.5236F, 0.0F, 0.0F));
		PartDefinition backBump1 = tail01.addOrReplaceChild("backBump1", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 5.0F, 16.0F, 3.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -0.3958F, -14.7758F, 0.5236F, 0.0F, 0.0F));
		PartDefinition backBump2 = tail01.addOrReplaceChild("backBump2", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 5.0F, 16.0F, 3.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -0.3958F, -0.7758F, 0.5236F, 0.0F, 0.0F));
		PartDefinition DorsalFin = tail00.addOrReplaceChild("DorsalFin", CubeListBuilder.create().texOffs(186, 0).addBox(-1.0F, -4.0F, 0.0F, 4.0F, 9.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 14.0F, 0.5236F, 0.0F, 0.0F));
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
				this.lFin00.xRot = Mth.cos(ageInTicks * (mul + 0.05F) + add) / div + 1.0472F;
				this.rFin00.xRot = Mth.cos(ageInTicks * (mul) + add) / div + 1.0472F;
			}
		}
	}
}