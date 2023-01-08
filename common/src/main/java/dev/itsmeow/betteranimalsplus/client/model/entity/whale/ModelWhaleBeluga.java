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

public class ModelWhaleBeluga<T extends EntityWhale> extends ModelBAP<T> {

	public ModelPart body;
	public ModelPart tail00;
	public ModelPart tail1;
	public ModelPart tail2;
	public ModelPart tail3;
	public ModelPart flukeMiddle;
	public ModelPart flukeL01;
	public ModelPart flukeL02;
	public ModelPart flukeL03;
	public ModelPart flukeR01;
	public ModelPart flukeR02;
	public ModelPart flukeR03;
	public ModelPart Torso;
	public ModelPart head;
	public ModelPart topJaw;
	public ModelPart cube_r1;
	public ModelPart lowJaw;
	public ModelPart rFin00;
	public ModelPart rFin01;
	public ModelPart rFin02;
	public ModelPart lFin;
	public ModelPart lFin2;
	public ModelPart lFin3;
	private boolean inWater = true;

	public ModelWhaleBeluga(ModelPart root) {
		this.body = root.getChild("body");
		this.tail00 = body.getChild("tail00");
		this.tail1 = tail00.getChild("tail1");
		this.tail2 = tail1.getChild("tail2");
		this.tail3 = tail2.getChild("tail3");
		this.flukeMiddle = tail3.getChild("flukeMiddle");
		this.flukeL01 = flukeMiddle.getChild("flukeL01");
		this.flukeL02 = flukeL01.getChild("flukeL02");
		this.flukeL03 = flukeL02.getChild("flukeL03");
		this.flukeR01 = flukeMiddle.getChild("flukeR01");
		this.flukeR02 = flukeR01.getChild("flukeR02");
		this.flukeR03 = flukeR02.getChild("flukeR03");
		this.Torso = body.getChild("Torso");
		this.head = Torso.getChild("head");
		this.topJaw = head.getChild("topJaw");
		this.cube_r1 = topJaw.getChild("cube_r1");
		this.lowJaw = head.getChild("lowJaw");
		this.rFin00 = Torso.getChild("rFin00");
		this.rFin01 = rFin00.getChild("rFin01");
		this.rFin02 = rFin01.getChild("rFin02");
		this.lFin = Torso.getChild("lFin");
		this.lFin2 = lFin.getChild("lFin2");
		this.lFin3 = lFin2.getChild("lFin3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -1.75F, 0.0F, 12.0F, 11.0F, 13.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, 11.5F, -13.25F, -0.0436F, 0.0F, 0.0F));
		PartDefinition tail00 = body.addOrReplaceChild("tail00", CubeListBuilder.create().texOffs(0, 25).addBox(-5.0F, -0.75F, 0.0F, 10.0F, 10.0F, 12.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, -1.0F, 13.0F, -0.0436F, 0.0F, 0.0F));
		PartDefinition tail1 = tail00.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(0, 48).addBox(-4.0F, -0.75F, 0.0F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 11.75F, -0.0873F, 0.0F, 0.0F));
		PartDefinition tail2 = tail1.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(0, 65).addBox(-3.0F, -0.75F, 0.0F, 6.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 7.0F, -0.0873F, 0.0F, 0.0F));
		PartDefinition tail3 = tail2.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(0, 80).addBox(-2.0F, -0.75F, 0.0F, 4.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 7.75F, -0.1309F, 0.0F, 0.0F));
		PartDefinition flukeMiddle = tail3.addOrReplaceChild("flukeMiddle", CubeListBuilder.create(), PartPose.offset(0.0F, 0.8F, 3.05F));
		PartDefinition flukeL01 = flukeMiddle.addOrReplaceChild("flukeL01", CubeListBuilder.create().texOffs(21, 86).mirror().addBox(-0.5F, -1.0F, -1.0F, 1.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.3F, 0.1F, -0.5F, 0.5009F, 0.0F, -1.3203F));
		PartDefinition flukeL02 = flukeL01.addOrReplaceChild("flukeL02", CubeListBuilder.create().texOffs(0, 101).mirror().addBox(-0.5F, 0.0F, -1.0F, 1.0F, 4.0F, 6.0F, new CubeDeformation(-0.05F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.75F, 0.0F, 0.0986F, 0.0F, 0.0F));
		PartDefinition flukeL03 = flukeL02.addOrReplaceChild("flukeL03", CubeListBuilder.create().texOffs(20, 101).mirror().addBox(-0.5F, 0.0F, -1.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.75F, 0.0F, 0.2276F, 0.0F, 0.0F));
		PartDefinition flukeR01 = flukeMiddle.addOrReplaceChild("flukeR01", CubeListBuilder.create().texOffs(21, 86).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3F, 0.1F, -0.5F, 0.5009F, 0.0F, 1.3203F));
		PartDefinition flukeR02 = flukeR01.addOrReplaceChild("flukeR02", CubeListBuilder.create().texOffs(0, 101).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 4.0F, 6.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(0.0F, 3.75F, 0.0F, 0.0986F, 0.0F, 0.0F));
		PartDefinition flukeR03 = flukeR02.addOrReplaceChild("flukeR03", CubeListBuilder.create().texOffs(20, 101).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.75F, 0.0F, 0.2276F, 0.0F, 0.0F));
		PartDefinition Torso = body.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(52, 0).addBox(-5.5F, -0.9333F, -8.02F, 11.0F, 10.0F, 11.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, -0.5F, -2.75F, 0.0873F, 0.0F, 0.0F));
		PartDefinition head = Torso.addOrReplaceChild("head", CubeListBuilder.create().texOffs(51, 25).addBox(-5.0F, -0.5F, -1.75F, 10.0F, 9.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 0.0667F, -8.02F));
		PartDefinition topJaw = head.addOrReplaceChild("topJaw", CubeListBuilder.create().texOffs(44, 46).addBox(-5.0F, -2.0F, -6.0F, 9.0F, 2.0F, 6.0F, new CubeDeformation(0.25F))
		.texOffs(45, 61).addBox(-4.5F, -0.5F, -5.5F, 8.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 6.5F, -1.75F));
		PartDefinition cube_r1 = topJaw.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(41, 84).addBox(-4.5F, -0.5F, -2.75F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, -6.0F, -3.5F, 0.1745F, 0.0F, 0.0F));
		PartDefinition lowJaw = head.addOrReplaceChild("lowJaw", CubeListBuilder.create().texOffs(39, 103).addBox(-4.5F, 0.3434F, -6.5373F, 8.0F, 2.0F, 6.0F, new CubeDeformation(0.25F))
		.texOffs(41, 73).addBox(-4.5F, -0.25F, -6.75F, 8.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 6.25F, -0.75F, -0.0873F, 0.0F, 0.0F));
		PartDefinition rFin00 = Torso.addOrReplaceChild("rFin00", CubeListBuilder.create().texOffs(0, 114).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 7.6F, -0.9F, 0.4288F, 0.0F, 1.0036F));
		PartDefinition rFin01 = rFin00.addOrReplaceChild("rFin01", CubeListBuilder.create().texOffs(17, 111).addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(-0.5F, 3.9F, 0.0F, 0.3643F, 0.0F, 0.0F));
		PartDefinition rFin02 = rFin01.addOrReplaceChild("rFin02", CubeListBuilder.create().texOffs(24, 121).addBox(0.0F, 0.0F, -1.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.7F, 1.0F, 0.1367F, 0.0F, 0.0F));
		PartDefinition lFin = Torso.addOrReplaceChild("lFin", CubeListBuilder.create().texOffs(0, 133).mirror().addBox(-0.5F, -1.0F, 0.0F, 1.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.75F, 7.6F, -0.9F, 0.4288F, 0.0F, -1.0036F));
		PartDefinition lFin2 = lFin.addOrReplaceChild("lFin2", CubeListBuilder.create().texOffs(16, 129).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(-0.05F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 2.9F, 0.0F, 0.3643F, 0.0F, 0.0F));
		PartDefinition lFin3 = lFin2.addOrReplaceChild("lFin3", CubeListBuilder.create().texOffs(17, 139).mirror().addBox(0.0F, 0.0F, -1.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 2.7F, 1.0F, 0.1367F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 180, 180);
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
				this.body.xRot = -0.0436F;
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
				float z01 = (float) RenderUtil.partLocation(this.tail00, this.tail1).z();
				float z02 = (float) RenderUtil.partLocation(this.tail00, this.tail1, this.tail2).z();
				float z03 = (float) RenderUtil.partLocation(this.tail00, this.tail1, this.tail2, this.tail3).z();
				this.tail1.xRot = Mth.sin(z01 * factor + ticks) * amplitude + offset;
				this.tail2.xRot = Mth.sin(z02 * factor + ticks) * amplitude + offset;
				this.tail3.xRot = Mth.sin(z03 * factor + ticks) * amplitude + offset;
			}
			{
				float mul = 0.1F;
				float div = 10F;
				float add = entity.getUUID().hashCode() * 0.001F;
				this.lFin.xRot = Mth.cos(ageInTicks * (mul + 0.05F) + add) / div + 0.4288F;
				this.rFin00.xRot = Mth.cos(ageInTicks * (mul) + add) / div + 0.4288F;
			}
		}
	}
}