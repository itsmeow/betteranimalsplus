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

public class ModelWhaleBlue<T extends EntityWhale> extends ModelBAP<T> {

	public ModelPart body;
	public ModelPart tail00;
	public ModelPart tail01;
	public ModelPart DorsalFin;
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
	public ModelPart torso;
	public ModelPart head;
	public ModelPart topJaw;
	public ModelPart cube_r1;
	public ModelPart Baleen;
	public ModelPart cube_r2;
	public ModelPart topJaw2;
	public ModelPart cube_r3;
	public ModelPart lowJaw;
	public ModelPart cube_r4;
	public ModelPart lFin00;
	public ModelPart lFin01;
	public ModelPart lFin02;
	public ModelPart rFin00;
	public ModelPart rFin01;
	public ModelPart rFin02;
	private boolean inWater;

	public ModelWhaleBlue(ModelPart root) {
		this.body = root.getChild("body");
		this.tail00 = body.getChild("tail00");
		this.tail01 = tail00.getChild("tail01");
		this.DorsalFin = tail01.getChild("DorsalFin");
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
		this.torso = body.getChild("torso");
		this.head = torso.getChild("head");
		this.topJaw = head.getChild("topJaw");
		this.cube_r1 = topJaw.getChild("cube_r1");
		this.Baleen = topJaw.getChild("Baleen");
		this.cube_r2 = Baleen.getChild("cube_r2");
		this.topJaw2 = head.getChild("topJaw2");
		this.cube_r3 = topJaw2.getChild("cube_r3");
		this.lowJaw = torso.getChild("lowJaw");
		this.cube_r4 = lowJaw.getChild("cube_r4");
		this.lFin00 = body.getChild("lFin00");
		this.lFin01 = lFin00.getChild("lFin01");
		this.lFin02 = lFin01.getChild("lFin02");
		this.rFin00 = body.getChild("rFin00");
		this.rFin01 = rFin00.getChild("rFin01");
		this.rFin02 = rFin01.getChild("rFin02");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-29.0F, -1.0F, -93.0F, 61.0F, 61.0F, 92.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -25.0F, -3.0F));
		PartDefinition tail00 = body.addOrReplaceChild("tail00", CubeListBuilder.create().texOffs(0, 161).addBox(-26.0F, 1.0F, 15.0F, 56.0F, 57.0F, 82.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -16.0F));
		PartDefinition tail01 = tail00.addOrReplaceChild("tail01", CubeListBuilder.create().texOffs(0, 312).addBox(-20.0F, -3.0F, -1.0F, 45.0F, 51.0F, 34.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 97.0F, -0.0436F, 0.0F, 0.0F));
		PartDefinition DorsalFin = tail01.addOrReplaceChild("DorsalFin", CubeListBuilder.create().texOffs(208, 178).addBox(-1.0F, -4.0F, 0.0F, 4.0F, 9.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.75F, 0.25F, 1.0F, 0.3927F, 0.0F, 0.0F));
		PartDefinition tail02 = tail01.addOrReplaceChild("tail02", CubeListBuilder.create().texOffs(0, 403).addBox(-16.0F, -3.0F, 0.0F, 38.0F, 46.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 33.0F, -0.0873F, 0.0F, 0.0F));
		PartDefinition tail03 = tail02.addOrReplaceChild("tail03", CubeListBuilder.create().texOffs(173, 314).addBox(-13.0F, 0.0F, 0.0F, 32.0F, 41.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 32.0F, -0.0436F, 0.0F, 0.0F));
		PartDefinition tail04 = tail03.addOrReplaceChild("tail04", CubeListBuilder.create().texOffs(161, 392).addBox(-9.0F, 0.0F, 0.0F, 25.0F, 35.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 26.0F, -0.0873F, 0.0F, 0.0F));
		PartDefinition tail05 = tail04.addOrReplaceChild("tail05", CubeListBuilder.create().texOffs(259, 445).addBox(-6.0F, 0.0F, 4.0F, 19.0F, 27.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 26.0F, -0.1309F, 0.0F, 0.0F));
		PartDefinition flukeMiddle = tail05.addOrReplaceChild("flukeMiddle", CubeListBuilder.create(), PartPose.offset(3.9123F, 4.3628F, 24.871F));
		PartDefinition flukeL01 = flukeMiddle.addOrReplaceChild("flukeL01", CubeListBuilder.create().texOffs(391, 288).mirror().addBox(-2.5F, -1.0F, -4.0F, 3.0F, 17.0F, 22.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.3F, -1.9F, -0.5F, 0.37F, 0.0F, -1.3203F));
		PartDefinition flukeL02 = flukeL01.addOrReplaceChild("flukeL02", CubeListBuilder.create().texOffs(344, 295).mirror().addBox(-2.5F, 0.0F, -4.0F, 3.0F, 23.0F, 17.0F, new CubeDeformation(-0.05F)).mirror(false), PartPose.offsetAndRotation(0.0F, 10.75F, 0.0F, -0.0323F, 0.0F, 0.0F));
		PartDefinition flukeL03 = flukeL02.addOrReplaceChild("flukeL03", CubeListBuilder.create().texOffs(309, 297).mirror().addBox(-2.5F, 0.0F, -4.0F, 3.0F, 19.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 21.75F, 0.0F, 0.2276F, 0.0F, 0.0F));
		PartDefinition flukeR01 = flukeMiddle.addOrReplaceChild("flukeR01", CubeListBuilder.create().texOffs(391, 288).addBox(-2.5F, -1.0F, -4.0F, 3.0F, 17.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3F, 0.1F, -0.5F, 0.37F, 0.0F, 1.364F));
		PartDefinition flukeR02 = flukeR01.addOrReplaceChild("flukeR02", CubeListBuilder.create().texOffs(344, 295).addBox(-2.5F, 0.0F, -4.0F, 3.0F, 23.0F, 17.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(0.0F, 12.75F, 0.0F, -0.0323F, 0.0F, 0.0F));
		PartDefinition flukeR03 = flukeR02.addOrReplaceChild("flukeR03", CubeListBuilder.create().texOffs(309, 297).addBox(-2.5F, 0.0F, -4.0F, 3.0F, 19.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.75F, 0.0F, 0.2276F, 0.0F, 0.0F));
		PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(225, 0).addBox(-27.0F, -1.0F, -31.0F, 57.0F, 57.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -93.0F));
		PartDefinition head = torso.addOrReplaceChild("head", CubeListBuilder.create().texOffs(315, 96).addBox(-28.0F, -31.0F, -27.0F, 59.0F, 28.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 29.0F, -29.0F));
		PartDefinition topJaw = head.addOrReplaceChild("topJaw", CubeListBuilder.create(), PartPose.offset(0.0F, -3.0F, -23.0F));
		PartDefinition cube_r1 = topJaw.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(293, 164).addBox(-26.0F, -13.0F, -95.0F, 55.0F, 13.0F, 96.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0436F, 0.0F, 0.0F));
		PartDefinition Baleen = topJaw.addOrReplaceChild("Baleen", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -3.0F, -96.0F, -0.1309F, 0.0F, 0.0F));
		PartDefinition cube_r2 = Baleen.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 486).addBox(-24.0F, -13.0F, -93.0F, 51.0F, 20.0F, 94.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 96.0F, -0.0436F, 0.0F, 0.0F));
		PartDefinition topJaw2 = head.addOrReplaceChild("topJaw2", CubeListBuilder.create().texOffs(246, 167).addBox(-4.0F, -5.441F, -12.7914F, 13.0F, 3.0F, 51.0F, new CubeDeformation(0.0F))
		.texOffs(433, 25).addBox(-8.0F, -5.441F, 38.2086F, 21.0F, 5.0F, 40.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -17.0F, -103.0F, 0.1745F, 0.0F, 0.0F));
		PartDefinition cube_r3 = topJaw2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(309, 483).addBox(-24.0F, -0.659F, 4.2038F, 51.0F, 18.0F, 91.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -17.0F, -0.0436F, 0.0F, 0.0F));
		PartDefinition lowJaw = torso.addOrReplaceChild("lowJaw", CubeListBuilder.create().texOffs(341, 400).addBox(-29.0F, -2.0F, -26.0F, 61.0F, 32.0F, 26.0F, new CubeDeformation(0.0F))
		.texOffs(482, 307).addBox(-27.0F, -7.0F, -70.0F, 57.0F, 25.0F, 47.0F, new CubeDeformation(0.0F))
		.texOffs(490, 612).addBox(-27.0F, -7.0F, -118.0F, 57.0F, 17.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 22.0F, -30.0F, 0.0436F, 0.0F, 0.0F));
		PartDefinition cube_r4 = lowJaw.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(218, 602).addBox(-26.0F, -17.0F, 3.0F, 55.0F, 17.0F, 81.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.0F, -108.0F, -0.2182F, 0.0F, 0.0F));
		PartDefinition lFin00 = body.addOrReplaceChild("lFin00", CubeListBuilder.create().texOffs(302, 342).addBox(-1.7649F, -1.9567F, -6.7542F, 5.0F, 9.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(30.75F, 39.1F, -82.65F, 0.6337F, 0.2635F, -0.1564F));
		PartDefinition lFin01 = lFin00.addOrReplaceChild("lFin01", CubeListBuilder.create().texOffs(344, 341).addBox(-0.9929F, 1.7543F, -8.184F, 3.0F, 33.0F, 17.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(0.228F, 3.101F, -1.6008F, 0.3643F, 0.0F, 0.0F));
		PartDefinition lFin02 = lFin01.addOrReplaceChild("lFin02", CubeListBuilder.create().texOffs(389, 339).addBox(-1.9929F, 0.9072F, -7.3193F, 3.0F, 39.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 32.6947F, 0.9527F, 0.1367F, 0.0F, 0.0F));
		PartDefinition rFin00 = body.addOrReplaceChild("rFin00", CubeListBuilder.create().texOffs(302, 342).mirror().addBox(-3.2351F, -1.9567F, -6.7542F, 5.0F, 9.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-25.75F, 39.1F, -82.65F, 0.6337F, -0.2635F, 0.1564F));
		PartDefinition rFin01 = rFin00.addOrReplaceChild("rFin01", CubeListBuilder.create().texOffs(344, 341).mirror().addBox(-2.0071F, 1.7543F, -8.184F, 3.0F, 33.0F, 17.0F, new CubeDeformation(-0.05F)).mirror(false), PartPose.offsetAndRotation(-0.228F, 3.101F, -1.6008F, 0.3643F, 0.0F, 0.0F));
		PartDefinition rFin02 = rFin01.addOrReplaceChild("rFin02", CubeListBuilder.create().texOffs(389, 339).mirror().addBox(-1.0071F, 0.9072F, -7.3193F, 3.0F, 39.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 32.6947F, 0.9527F, 0.1367F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 700, 700);
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
				this.lFin00.xRot = Mth.cos(ageInTicks * (mul + 0.05F) + add) / div + 0.6337F;
				this.rFin00.xRot = Mth.cos(ageInTicks * (mul) + add) / div + 0.6337F;
			}
		}
	}
}