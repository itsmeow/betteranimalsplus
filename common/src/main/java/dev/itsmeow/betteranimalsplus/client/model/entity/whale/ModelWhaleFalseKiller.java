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

public class ModelWhaleFalseKiller<T extends EntityWhale> extends ModelBAP<T> {

	public ModelPart Body;
	public ModelPart torso;
	public ModelPart head;
	public ModelPart topJaw;
	public ModelPart cube_r1;
	public ModelPart lowJaw;
	public ModelPart lFin00;
	public ModelPart lFin01;
	public ModelPart lFin02;
	public ModelPart rFin;
	public ModelPart rFin2;
	public ModelPart rFin3;
	public ModelPart tail00;
	public ModelPart tail01;
	public ModelPart tail02;
	public ModelPart tail03;
	public ModelPart tail04;
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
	public ModelPart dorsalFin04;
	public ModelPart Box_r1;
	public ModelPart dorsalFin03;
	private boolean inWater;

	public ModelWhaleFalseKiller(ModelPart root) {
		this.Body = root.getChild("Body");
		this.torso = Body.getChild("torso");
		this.head = torso.getChild("head");
		this.topJaw = head.getChild("topJaw");
		this.cube_r1 = topJaw.getChild("cube_r1");
		this.lowJaw = head.getChild("lowJaw");
		this.lFin00 = torso.getChild("lFin00");
		this.lFin01 = lFin00.getChild("lFin01");
		this.lFin02 = lFin01.getChild("lFin02");
		this.rFin = torso.getChild("rFin");
		this.rFin2 = rFin.getChild("rFin2");
		this.rFin3 = rFin2.getChild("rFin3");
		this.tail00 = Body.getChild("tail00");
		this.tail01 = tail00.getChild("tail01");
		this.tail02 = tail01.getChild("tail02");
		this.tail03 = tail02.getChild("tail03");
		this.tail04 = tail03.getChild("tail04");
		this.flukeMiddle = tail04.getChild("flukeMiddle");
		this.flukeL01 = flukeMiddle.getChild("flukeL01");
		this.flukeL02 = flukeL01.getChild("flukeL02");
		this.flukeL03 = flukeL02.getChild("flukeL03");
		this.flukeR01 = flukeMiddle.getChild("flukeR01");
		this.flukeR02 = flukeR01.getChild("flukeR02");
		this.flukeR03 = flukeR02.getChild("flukeR03");
		this.dorsalFin00 = tail00.getChild("dorsalFin00");
		this.dorsalFin01 = dorsalFin00.getChild("dorsalFin01");
		this.dorsalFin02 = dorsalFin01.getChild("dorsalFin02");
		this.dorsalFin04 = dorsalFin02.getChild("dorsalFin04");
		this.Box_r1 = dorsalFin04.getChild("Box_r1");
		this.dorsalFin03 = dorsalFin00.getChild("dorsalFin03");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -3.0F, 0.0F, 14.0F, 14.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 9.75F, -24.25F));
		PartDefinition torso = Body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(38, 108).addBox(-6.0F, -3.0F, -12.0F, 13.0F, 13.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.25F, 1.25F, 0.0436F, 0.0F, 0.0F));
		PartDefinition head = torso.addOrReplaceChild("head", CubeListBuilder.create().texOffs(26, 142).addBox(-6.5F, -4.5F, -7.0F, 12.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 2.0F, -10.0F));
		PartDefinition topJaw = head.addOrReplaceChild("topJaw", CubeListBuilder.create().texOffs(0, 162).addBox(-6.0F, -6.0237F, -11.2164F, 11.0F, 6.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(0, 197).addBox(-5.0F, -0.25F, -10.25F, 9.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.5F, -5.25F, 0.0873F, 0.0F, 0.0F));
		PartDefinition cube_r1 = topJaw.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(41, 174).addBox(-5.5F, -1.0F, 0.0F, 10.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0237F, -10.2164F, 0.3054F, 0.0F, 0.0F));
		PartDefinition lowJaw = head.addOrReplaceChild("lowJaw", CubeListBuilder.create().texOffs(55, 156).addBox(-4.5F, -0.5F, -9.0F, 10.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(0, 184).addBox(-3.5F, -1.25F, -8.25F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 5.0F, -6.75F, -0.0436F, 0.0F, 0.0F));
		PartDefinition lFin00 = torso.addOrReplaceChild("lFin00", CubeListBuilder.create().texOffs(51, 0).addBox(-0.5F, -0.03F, -1.6512F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, 8.6F, -4.0F, 0.3852F, 0.0F, -0.5236F));
		PartDefinition lFin01 = lFin00.addOrReplaceChild("lFin01", CubeListBuilder.create().texOffs(66, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 3.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(-0.5F, 4.87F, -1.6512F, 0.3643F, 0.0F, 0.0F));
		PartDefinition lFin02 = lFin01.addOrReplaceChild("lFin02", CubeListBuilder.create().texOffs(70, 11).addBox(0.0F, 0.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.7F, 1.0F, 0.1367F, 0.0F, 0.0F));
		PartDefinition rFin = torso.addOrReplaceChild("rFin", CubeListBuilder.create().texOffs(51, 0).addBox(-0.5F, -0.03F, -1.6512F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, 8.6F, -4.0F, 0.3852F, 0.0F, 0.5236F));
		PartDefinition rFin2 = rFin.addOrReplaceChild("rFin2", CubeListBuilder.create().texOffs(66, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 3.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(-0.5F, 4.87F, -1.6512F, 0.3643F, 0.0F, 0.0F));
		PartDefinition rFin3 = rFin2.addOrReplaceChild("rFin3", CubeListBuilder.create().texOffs(70, 11).addBox(0.0F, 0.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.7F, 1.0F, 0.1367F, 0.0F, 0.0F));
		PartDefinition tail00 = Body.addOrReplaceChild("tail00", CubeListBuilder.create().texOffs(0, 35).addBox(-6.0F, -1.0F, 0.0F, 12.0F, 13.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 17.75F, -0.0436F, 0.0F, 0.0F));
		PartDefinition tail01 = tail00.addOrReplaceChild("tail01", CubeListBuilder.create().texOffs(0, 61).addBox(-5.0F, -1.0F, 0.0F, 10.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 8.5F, -0.0436F, 0.0F, 0.0F));
		PartDefinition tail02 = tail01.addOrReplaceChild("tail02", CubeListBuilder.create().texOffs(0, 86).addBox(-4.0F, -1.0F, 0.0F, 8.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 11.0F, -0.0436F, 0.0F, 0.0F));
		PartDefinition tail03 = tail02.addOrReplaceChild("tail03", CubeListBuilder.create().texOffs(0, 108).addBox(-3.0F, -1.0F, 0.0F, 6.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 10.0F, -0.0436F, 0.0F, 0.0F));
		PartDefinition tail04 = tail03.addOrReplaceChild("tail04", CubeListBuilder.create().texOffs(0, 129).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 10.0F));
		PartDefinition flukeMiddle = tail04.addOrReplaceChild("flukeMiddle", CubeListBuilder.create().texOffs(0, 147).addBox(-1.5F, -1.3223F, 6.0742F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.8F, 0.55F));
		PartDefinition flukeL01 = flukeMiddle.addOrReplaceChild("flukeL01", CubeListBuilder.create().texOffs(47, 72).mirror().addBox(-0.1877F, 1.8469F, 4.3663F, 1.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.3F, 0.1F, -0.5F, 0.5009F, 0.0F, -1.3203F));
		PartDefinition flukeL02 = flukeL01.addOrReplaceChild("flukeL02", CubeListBuilder.create().texOffs(40, 90).mirror().addBox(-0.1877F, 3.3614F, 4.06F, 1.0F, 4.0F, 6.0F, new CubeDeformation(-0.05F)).mirror(false), PartPose.offsetAndRotation(0.0F, 4.75F, 0.0F, 0.0986F, 0.0F, 0.0F));
		PartDefinition flukeL03 = flukeL02.addOrReplaceChild("flukeL03", CubeListBuilder.create().texOffs(59, 90).mirror().addBox(-0.1877F, 4.4164F, 3.1711F, 1.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.75F, 0.0F, 0.2276F, 0.0F, 0.0F));
		PartDefinition flukeR01 = flukeMiddle.addOrReplaceChild("flukeR01", CubeListBuilder.create().texOffs(47, 72).addBox(-0.8123F, 1.8469F, 4.3663F, 1.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3F, 0.1F, -0.5F, 0.5009F, 0.0F, 1.3203F));
		PartDefinition flukeR02 = flukeR01.addOrReplaceChild("flukeR02", CubeListBuilder.create().texOffs(40, 90).addBox(-0.8123F, 3.3614F, 4.06F, 1.0F, 4.0F, 6.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(0.0F, 4.75F, 0.0F, 0.0986F, 0.0F, 0.0F));
		PartDefinition flukeR03 = flukeR02.addOrReplaceChild("flukeR03", CubeListBuilder.create().texOffs(59, 90).addBox(-0.8123F, 4.4164F, 3.1711F, 1.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.75F, 0.0F, 0.2276F, 0.0F, 0.0F));
		PartDefinition dorsalFin00 = tail00.addOrReplaceChild("dorsalFin00", CubeListBuilder.create().texOffs(48, 37).addBox(-0.5F, -2.5581F, -0.5853F, 2.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -0.8F, 1.8F, -0.2922F, 0.0F, 0.0F));
		PartDefinition dorsalFin01 = dorsalFin00.addOrReplaceChild("dorsalFin01", CubeListBuilder.create().texOffs(47, 50).addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(0.0F, -5.2581F, 0.3147F, -0.3112F, 0.0F, 0.0F));
		PartDefinition dorsalFin02 = dorsalFin01.addOrReplaceChild("dorsalFin02", CubeListBuilder.create().texOffs(63, 51).addBox(-1.0F, -3.2F, 0.1F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -1.8F, 0.45F, -0.2618F, 0.0F, 0.0F));
		PartDefinition dorsalFin04 = dorsalFin02.addOrReplaceChild("dorsalFin04", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 1.4F, 0.182F, 0.0F, 0.0F));
		PartDefinition Box_r1 = dorsalFin04.addOrReplaceChild("Box_r1", CubeListBuilder.create().texOffs(47, 61).addBox(-0.5F, -5.95F, -1.15F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 5.2F, 0.7F, 0.0027F, -0.0133F, -0.0069F));
		PartDefinition dorsalFin03 = dorsalFin00.addOrReplaceChild("dorsalFin03", CubeListBuilder.create().texOffs(57, 62).addBox(-1.0F, -5.1F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.09F)), PartPose.offsetAndRotation(1.0F, -7.6081F, 2.4647F, -0.9163F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 96, 256);
	}

	@Override
	public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		if (!inWater) {
			matrixStackIn.translate(0F, 0.25F, 0F);
		}
		this.Body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!Minecraft.getInstance().isPaused()) {
			this.inWater = entity.isInWater();
			if (inWater) {
				float pitch = rad(headPitch);
				this.Body.xRot = pitch == 0 ? 0 : (float) ((pitch / Math.abs(pitch)) * Math.min(Math.abs(pitch), Math.toRadians(45F)));
				this.Body.yRot = rad(netHeadYaw);
			} else {
				this.Body.yRot = -rad(ModMathHelper.interpolateRotation(entity.yBodyRot, entity.yBodyRotO, Minecraft.getInstance().getFrameTime()));
				this.Body.xRot = 0F;
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
				this.tail01.xRot = Mth.sin(z01 * factor + ticks) * amplitude + offset;
				this.tail02.xRot = Mth.sin(z02 * factor + ticks) * amplitude + offset;
				this.tail03.xRot = Mth.sin(z03 * factor + ticks) * amplitude + offset;
				this.tail04.xRot = Mth.sin(z04 * factor + ticks) * amplitude + offset;
			}
			{
				float mul = 0.1F;
				float div = 10F;
				float add = entity.getUUID().hashCode() * 0.001F;
				this.lFin00.xRot = Mth.cos(ageInTicks * (mul + 0.05F) + add) / div + 0.3852F;
				this.rFin.xRot = Mth.cos(ageInTicks * (mul) + add) / div + 0.3852F;
			}
		}
	}
}