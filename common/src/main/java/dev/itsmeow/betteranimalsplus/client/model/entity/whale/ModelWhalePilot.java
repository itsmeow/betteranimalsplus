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

public class ModelWhalePilot<T extends EntityWhale> extends ModelBAP<T> {

	public ModelPart body;
	public ModelPart torso;
	public ModelPart head;
	public ModelPart cube_r1;
	public ModelPart lowJaw;
	public ModelPart topJaw;
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
	public ModelPart lFin00;
	public ModelPart lFin01;
	public ModelPart lFin02;
	public ModelPart rFin00;
	public ModelPart rFin02;
	public ModelPart rFin03;
	public ModelPart dorsalFin00;
	public ModelPart dorsalFin01;
	public ModelPart dorsalFin02;
	public ModelPart dorsalFin04;
	public ModelPart Box_r1;
	public ModelPart dorsalFin03;
	private boolean inWater;

	public ModelWhalePilot(ModelPart root) {
		this.body = root.getChild("body");
		this.torso = body.getChild("torso");
		this.head = torso.getChild("head");
		this.cube_r1 = head.getChild("cube_r1");
		this.lowJaw = head.getChild("lowJaw");
		this.topJaw = head.getChild("topJaw");
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
		this.lFin00 = body.getChild("lFin00");
		this.lFin01 = lFin00.getChild("lFin01");
		this.lFin02 = lFin01.getChild("lFin02");
		this.rFin00 = body.getChild("rFin00");
		this.rFin02 = rFin00.getChild("rFin02");
		this.rFin03 = rFin02.getChild("rFin03");
		this.dorsalFin00 = body.getChild("dorsalFin00");
		this.dorsalFin01 = dorsalFin00.getChild("dorsalFin01");
		this.dorsalFin02 = dorsalFin01.getChild("dorsalFin02");
		this.dorsalFin04 = dorsalFin02.getChild("dorsalFin04");
		this.Box_r1 = dorsalFin04.getChild("Box_r1");
		this.dorsalFin03 = dorsalFin00.getChild("dorsalFin03");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -4.0F, -14.0F, 16.0F, 18.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, -13.0F, 0.0436F, 0.0F, 0.0F));
		PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 44).addBox(-7.5F, -3.0872F, -13.9981F, 15.0F, 17.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -1.0F, -13.5F, 0.0436F, 0.0F, 0.0F));
		PartDefinition head = torso.addOrReplaceChild("head", CubeListBuilder.create().texOffs(70, 0).addBox(-7.0F, -5.5F, -1.0F, 14.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.9128F, -15.9981F));
		PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(55, 190).addBox(-6.0F, -3.0F, -8.25F, 12.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -3.0F, 0.0436F, 0.0F, 0.0F));
		PartDefinition lowJaw = head.addOrReplaceChild("lowJaw", CubeListBuilder.create().texOffs(62, 50).addBox(-7.0F, 0.0F, -10.0F, 12.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(61, 164).addBox(-5.5F, -0.75F, -9.25F, 9.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 6.5F, -0.75F, -0.0436F, 0.0F, 0.0F));
		PartDefinition topJaw = head.addOrReplaceChild("topJaw", CubeListBuilder.create().texOffs(71, 26).addBox(-6.5F, -1.0F, -8.0F, 13.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(63, 150).addBox(-4.75F, 1.75F, -7.75F, 10.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, -3.0F, 0.0873F, 0.0F, 0.0F));
		PartDefinition tail00 = body.addOrReplaceChild("tail00", CubeListBuilder.create().texOffs(0, 80).addBox(-8.5F, -4.0F, 0.0F, 15.0F, 19.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, -0.0436F, 0.0F, 0.0F));
		PartDefinition tail01 = tail00.addOrReplaceChild("tail01", CubeListBuilder.create().texOffs(0, 123).addBox(-7.0F, -2.0F, 0.0F, 14.0F, 17.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -2.0F, 19.0F, -0.0436F, 0.0F, 0.0F));
		PartDefinition tail02 = tail01.addOrReplaceChild("tail02", CubeListBuilder.create().texOffs(0, 160).addBox(-6.0F, -2.0F, 0.0F, 12.0F, 15.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 14.0F, -0.0436F, 0.0F, 0.0F));
		PartDefinition tail03 = tail02.addOrReplaceChild("tail03", CubeListBuilder.create().texOffs(0, 195).addBox(-5.0F, -2.0F, 1.0F, 10.0F, 13.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 15.0F, -0.0873F, 0.0F, 0.0F));
		PartDefinition tail04 = tail03.addOrReplaceChild("tail04", CubeListBuilder.create().texOffs(0, 224).addBox(-5.0F, -2.0F, 1.0F, 9.0F, 11.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 11.0F, -0.0436F, 0.0F, 0.0F));
		PartDefinition tail05 = tail04.addOrReplaceChild("tail05", CubeListBuilder.create().texOffs(40, 240).addBox(-4.0F, -1.3755F, -2.7133F, 8.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -0.25F, 10.25F, -0.1309F, 0.0F, 0.0F));
		PartDefinition flukeMiddle = tail05.addOrReplaceChild("flukeMiddle", CubeListBuilder.create(), PartPose.offset(0.0F, 3.1745F, 0.3367F));
		PartDefinition flukeL01 = flukeMiddle.addOrReplaceChild("flukeL01", CubeListBuilder.create().texOffs(68, 127).mirror().addBox(-0.5F, -1.0F, -1.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.3F, 0.1F, -0.5F, 0.37F, 0.0F, -1.3203F));
		PartDefinition flukeL02 = flukeL01.addOrReplaceChild("flukeL02", CubeListBuilder.create().texOffs(92, 124).mirror().addBox(-0.5F, 0.0F, -1.0F, 1.0F, 9.0F, 6.0F, new CubeDeformation(-0.05F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.75F, 0.0F, 0.0986F, 0.0F, 0.0F));
		PartDefinition flukeL03 = flukeL02.addOrReplaceChild("flukeL03", CubeListBuilder.create().texOffs(110, 125).mirror().addBox(-0.5F, 4.75F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.75F, 0.0F, 0.2276F, 0.0F, 0.0F));
		PartDefinition flukeR01 = flukeMiddle.addOrReplaceChild("flukeR01", CubeListBuilder.create().texOffs(68, 127).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3F, 0.1F, -0.5F, 0.37F, 0.0F, 1.3203F));
		PartDefinition flukeR02 = flukeR01.addOrReplaceChild("flukeR02", CubeListBuilder.create().texOffs(92, 124).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 9.0F, 6.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(0.0F, 3.75F, 0.0F, 0.0986F, 0.0F, 0.0F));
		PartDefinition flukeR03 = flukeR02.addOrReplaceChild("flukeR03", CubeListBuilder.create().texOffs(110, 125).addBox(-0.5F, 4.75F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.75F, 0.0F, 0.2276F, 0.0F, 0.0F));
		PartDefinition lFin00 = body.addOrReplaceChild("lFin00", CubeListBuilder.create().texOffs(63, 70).mirror().addBox(-0.5F, -2.4698F, -2.0548F, 1.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.75F, 11.6F, -10.9F, 0.647F, 0.2182F, 0.0F));
		PartDefinition lFin01 = lFin00.addOrReplaceChild("lFin01", CubeListBuilder.create().texOffs(81, 72).mirror().addBox(3.0F, -16.5453F, -4.0313F, 1.0F, 7.0F, 4.0F, new CubeDeformation(-0.05F)).mirror(false), PartPose.offsetAndRotation(-3.5F, 19.4538F, 7.6063F, 0.3643F, 0.0F, 0.0F));
		PartDefinition lFin02 = lFin01.addOrReplaceChild("lFin02", CubeListBuilder.create().texOffs(96, 70).mirror().addBox(-1.0F, -0.1947F, -0.2478F, 1.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, -9.55F, -3.75F, 0.3112F, 0.0F, 0.0F));
		PartDefinition rFin00 = body.addOrReplaceChild("rFin00", CubeListBuilder.create().texOffs(63, 70).addBox(-0.5F, -0.4698F, -2.0548F, 1.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 9.6F, -12.15F, 0.647F, -0.2182F, 0.0F));
		PartDefinition rFin02 = rFin00.addOrReplaceChild("rFin02", CubeListBuilder.create().texOffs(81, 72).addBox(-0.5F, -6.5765F, -0.3406F, 1.0F, 7.0F, 4.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(0.0F, 13.4538F, 0.6063F, 0.3643F, 0.0F, 0.0F));
		PartDefinition rFin03 = rFin02.addOrReplaceChild("rFin03", CubeListBuilder.create().texOffs(96, 70).addBox(-0.5F, 0.087F, -0.0342F, 1.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.1689F, -0.3093F, 0.3112F, 0.0F, 0.0F));
		PartDefinition dorsalFin00 = body.addOrReplaceChild("dorsalFin00", CubeListBuilder.create().texOffs(73, 88).addBox(-0.5F, -2.5581F, -0.5853F, 2.0F, 3.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -3.55F, -5.7F, -0.3358F, 0.0F, 0.0F));
		PartDefinition dorsalFin01 = dorsalFin00.addOrReplaceChild("dorsalFin01", CubeListBuilder.create().texOffs(100, 80).addBox(0.0F, -2.5745F, -0.6502F, 1.0F, 3.0F, 10.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(0.0F, -2.6081F, 0.1453F, -0.2676F, 0.0F, 0.0F));
		PartDefinition dorsalFin02 = dorsalFin01.addOrReplaceChild("dorsalFin02", CubeListBuilder.create().texOffs(75, 110).addBox(-1.0F, 8.0893F, -18.5963F, 1.0F, 5.0F, 7.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(1.0F, -10.4402F, 20.7809F, -0.2618F, 0.0F, 0.0F));
		PartDefinition dorsalFin04 = dorsalFin02.addOrReplaceChild("dorsalFin04", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 1.65F, 0.182F, 0.0F, 0.0F));
		PartDefinition Box_r1 = dorsalFin04.addOrReplaceChild("Box_r1", CubeListBuilder.create().texOffs(100, 110).addBox(-0.5F, -5.4859F, -2.5959F, 1.0F, 5.0F, 3.0F, new CubeDeformation(-0.009F)), PartPose.offsetAndRotation(-0.5F, 7.2F, -18.3F, -0.87F, -0.0133F, -0.0069F));
		PartDefinition dorsalFin03 = dorsalFin00.addOrReplaceChild("dorsalFin03", CubeListBuilder.create().texOffs(109, 98).addBox(-1.0F, 10.8237F, -14.8053F, 1.0F, 5.0F, 5.0F, new CubeDeformation(-0.009F)), PartPose.offsetAndRotation(1.0F, -6.9581F, 24.2953F, -0.9163F, 0.0F, 0.0F));
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
				this.body.xRot = 0.0436F;
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