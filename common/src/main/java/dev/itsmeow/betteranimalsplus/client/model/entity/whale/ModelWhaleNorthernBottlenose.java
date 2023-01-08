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

public class ModelWhaleNorthernBottlenose<T extends EntityWhale> extends ModelBAP<T> {

	public ModelPart body;
	public ModelPart torso;
	public ModelPart head;
	public ModelPart cube_r1;
	public ModelPart topJaw;
	public ModelPart cube_r2;
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
	public ModelPart dorsalFin00;
	public ModelPart dorsalFin01;
	public ModelPart dorsalFin02;
	public ModelPart lFin00;
	public ModelPart lFin01;
	public ModelPart rFin00;
	public ModelPart rFin02;
	private boolean inWater;

	public ModelWhaleNorthernBottlenose(ModelPart root) {
		this.body = root.getChild("body");
		this.torso = body.getChild("torso");
		this.head = torso.getChild("head");
		this.cube_r1 = head.getChild("cube_r1");
		this.topJaw = head.getChild("topJaw");
		this.cube_r2 = topJaw.getChild("cube_r2");
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
		this.dorsalFin00 = tail01.getChild("dorsalFin00");
		this.dorsalFin01 = dorsalFin00.getChild("dorsalFin01");
		this.dorsalFin02 = dorsalFin01.getChild("dorsalFin02");
		this.lFin00 = body.getChild("lFin00");
		this.lFin01 = lFin00.getChild("lFin01");
		this.rFin00 = body.getChild("rFin00");
		this.rFin02 = rFin00.getChild("rFin02");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-11.0F, -4.0F, -16.0F, 22.0F, 25.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, -17.0F));
		PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 202).addBox(-9.5F, -3.0872F, -13.9981F, 21.0F, 24.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -0.5F, -20.0F, 0.0436F, 0.0F, 0.0F));
		PartDefinition head = torso.addOrReplaceChild("head", CubeListBuilder.create().texOffs(81, 218).addBox(-9.0F, -5.5F, -16.0F, 18.0F, 21.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 2.9128F, -13.9981F));
		PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(92, 23).addBox(-5.5F, -11.0F, 0.0F, 13.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 6.0F, -20.0F, 0.0873F, 0.0F, 0.0F));
		PartDefinition topJaw = head.addOrReplaceChild("topJaw", CubeListBuilder.create().texOffs(69, 0).addBox(-5.0F, -3.9981F, -10.9128F, 12.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(103, 46).addBox(-3.5F, 0.0F, -10.5F, 9.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 11.0F, -17.0F, 0.0436F, 0.0F, 0.0F));
		PartDefinition cube_r2 = topJaw.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(120, 0).addBox(-4.0F, 0.5553F, -0.0608F, 10.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.4981F, -10.9128F, 0.2182F, 0.0F, 0.0F));
		PartDefinition lowJaw = head.addOrReplaceChild("lowJaw", CubeListBuilder.create().texOffs(130, 20).addBox(-4.0F, 0.0F, -13.0F, 10.0F, 4.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(73, 51).addBox(-3.0F, -1.0F, -12.0F, 8.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 11.0F, -16.0F, -0.0873F, 0.0F, 0.0F));
		PartDefinition tail00 = body.addOrReplaceChild("tail00", CubeListBuilder.create().texOffs(0, 50).addBox(-10.5F, -4.1309F, -0.0029F, 21.0F, 23.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 6.0F, -0.0436F, 0.0F, 0.0F));
		PartDefinition tail01 = tail00.addOrReplaceChild("tail01", CubeListBuilder.create().texOffs(0, 103).addBox(-8.0F, -2.0872F, -1.0019F, 18.0F, 19.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -1.6309F, 26.9971F, -0.0436F, 0.0F, 0.0F));
		PartDefinition tail02 = tail01.addOrReplaceChild("tail02", CubeListBuilder.create().texOffs(0, 144).addBox(-6.0F, -2.0872F, -1.0019F, 14.0F, 15.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.1628F, 17.9981F, -0.0436F, 0.0F, 0.0F));
		PartDefinition tail03 = tail02.addOrReplaceChild("tail03", CubeListBuilder.create().texOffs(65, 150).addBox(-5.0F, -2.0872F, -1.0038F, 11.0F, 12.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.1628F, 14.9981F, -0.0873F, 0.0F, 0.0F));
		PartDefinition tail04 = tail03.addOrReplaceChild("tail04", CubeListBuilder.create().texOffs(0, 178).addBox(-5.0F, -2.0436F, -1.001F, 10.0F, 10.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.1628F, 8.9962F, -0.0436F, 0.0F, 0.0F));
		PartDefinition tail05 = tail04.addOrReplaceChild("tail05", CubeListBuilder.create().texOffs(44, 180).addBox(-4.0F, -2.0282F, -0.7561F, 8.0F, 7.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.7064F, 9.249F, -0.1309F, 0.0F, 0.0F));
		PartDefinition flukeMiddle = tail05.addOrReplaceChild("flukeMiddle", CubeListBuilder.create(), PartPose.offset(0.0F, 0.5218F, 8.2939F));
		PartDefinition flukeL01 = flukeMiddle.addOrReplaceChild("flukeL01", CubeListBuilder.create().texOffs(100, 66).mirror().addBox(-0.5F, -1.0F, -4.0F, 1.0F, 8.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.3F, 0.1F, -0.5F, 0.5009F, 0.0F, -1.3203F));
		PartDefinition flukeL02 = flukeL01.addOrReplaceChild("flukeL02", CubeListBuilder.create().texOffs(127, 68).mirror().addBox(-0.5F, 0.0F, -4.0F, 1.0F, 9.0F, 9.0F, new CubeDeformation(-0.05F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.75F, 0.0F, 0.0986F, 0.0F, 0.0F));
		PartDefinition flukeL03 = flukeL02.addOrReplaceChild("flukeL03", CubeListBuilder.create().texOffs(100, 88).mirror().addBox(-0.5F, 4.0F, -5.0F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.75F, 0.0F, 0.2276F, 0.0F, 0.0F));
		PartDefinition flukeR01 = flukeMiddle.addOrReplaceChild("flukeR01", CubeListBuilder.create().texOffs(100, 66).addBox(-0.5F, -1.0F, -4.0F, 1.0F, 8.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3F, 0.1F, -0.5F, 0.5009F, 0.0F, 1.3203F));
		PartDefinition flukeR02 = flukeR01.addOrReplaceChild("flukeR02", CubeListBuilder.create().texOffs(127, 68).addBox(-0.5F, 0.0F, -4.0F, 1.0F, 9.0F, 9.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(0.0F, 3.75F, 0.0F, 0.0986F, 0.0F, 0.0F));
		PartDefinition flukeR03 = flukeR02.addOrReplaceChild("flukeR03", CubeListBuilder.create().texOffs(100, 88).addBox(-0.5F, 4.0F, -5.0F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.75F, 0.0F, 0.2276F, 0.0F, 0.0F));
		PartDefinition dorsalFin00 = tail01.addOrReplaceChild("dorsalFin00", CubeListBuilder.create().texOffs(0, 51).addBox(-0.5F, -3.3792F, 3.2383F, 2.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.9191F, -3.6971F, -0.3358F, 0.0F, 0.0F));
		PartDefinition dorsalFin01 = dorsalFin00.addOrReplaceChild("dorsalFin01", CubeListBuilder.create().texOffs(0, 66).addBox(0.0F, -3.8486F, 2.8915F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(0.0F, -2.6081F, 0.1453F, -0.2676F, 0.0F, 0.0F));
		PartDefinition dorsalFin02 = dorsalFin01.addOrReplaceChild("dorsalFin02", CubeListBuilder.create().texOffs(17, 67).addBox(-1.0F, 6.4596F, -15.4369F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(1.0F, -10.4402F, 20.7809F, -0.2618F, 0.0F, 0.0F));
		PartDefinition lFin00 = body.addOrReplaceChild("lFin00", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(6.113F, -0.9402F, -11.6427F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.25F, 12.6F, -5.9F, 0.647F, 0.2182F, 0.0F));
		PartDefinition lFin01 = lFin00.addOrReplaceChild("lFin01", CubeListBuilder.create().texOffs(0, 12).mirror().addBox(9.613F, -18.5318F, -13.5352F, 1.0F, 5.0F, 3.0F, new CubeDeformation(-0.05F)).mirror(false), PartPose.offsetAndRotation(-3.5F, 17.4538F, 7.6063F, 0.3643F, 0.0F, 0.0F));
		PartDefinition rFin00 = body.addOrReplaceChild("rFin00", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.4698F, -2.0548F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, 17.6F, -15.15F, 0.647F, -0.2182F, 0.0F));
		PartDefinition rFin02 = rFin00.addOrReplaceChild("rFin02", CubeListBuilder.create().texOffs(0, 12).addBox(-0.5F, -6.5765F, -0.3406F, 1.0F, 4.0F, 3.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(0.0F, 11.4538F, 0.6063F, 0.3643F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 256, 256);
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
				this.lFin00.xRot = Mth.cos(ageInTicks * (mul + 0.05F) + add) / div + 0.647F;
				this.rFin00.xRot = Mth.cos(ageInTicks * (mul) + add) / div + 0.647F;
			}
		}
	}
}