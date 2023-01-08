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

public class ModelWhaleNarwhal<T extends EntityWhale> extends ModelBAP<T> {

	public ModelPart torso;
	public ModelPart neck;
	public ModelPart neck2;
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
	public ModelPart tail00;
	public ModelPart tail01;
	public ModelPart tail02;
	public ModelPart tail03;
	public ModelPart flukeMiddle;
	public ModelPart flukeL01;
	public ModelPart flukeL02;
	public ModelPart flukeL03;
	public ModelPart flukeR01;
	public ModelPart flukeR02;
	public ModelPart flukeR03;
	private boolean inWater;

	public ModelWhaleNarwhal(ModelPart root) {
		this.torso = root.getChild("torso");
		this.neck = torso.getChild("neck");
		this.neck2 = neck.getChild("neck2");
		this.head = neck2.getChild("head");
		this.topJaw = head.getChild("topJaw");
		this.cube_r1 = topJaw.getChild("cube_r1");
		this.lowJaw = head.getChild("lowJaw");
		this.rFin00 = neck.getChild("rFin00");
		this.rFin01 = rFin00.getChild("rFin01");
		this.rFin02 = rFin01.getChild("rFin02");
		this.lFin = neck.getChild("lFin");
		this.lFin2 = lFin.getChild("lFin2");
		this.lFin3 = lFin2.getChild("lFin3");
		this.tail00 = torso.getChild("tail00");
		this.tail01 = tail00.getChild("tail01");
		this.tail02 = tail01.getChild("tail02");
		this.tail03 = tail02.getChild("tail03");
		this.flukeMiddle = tail03.getChild("flukeMiddle");
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
		PartDefinition torso = partdefinition.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 0).addBox(-6.5F, -6.0F, -16.0F, 12.0F, 12.0F, 16.0F, new CubeDeformation(0.5F)), PartPose.offset(0.5F, 16.0F, -1.0F));
		PartDefinition neck = torso.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 126).addBox(-6.0F, -5.5F, -10.0F, 11.0F, 11.0F, 10.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, -16.0F));
		PartDefinition neck2 = neck.addOrReplaceChild("neck2", CubeListBuilder.create().texOffs(0, 151).addBox(-5.5F, -5.0F, -4.0F, 10.0F, 10.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, -10.0F));
		PartDefinition head = neck2.addOrReplaceChild("head", CubeListBuilder.create().texOffs(28, 107).addBox(-5.0F, -5.0F, -3.5F, 10.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 0.0F, -4.0F));
		PartDefinition topJaw = head.addOrReplaceChild("topJaw", CubeListBuilder.create().texOffs(35, 89).addBox(-4.5F, -5.0F, -6.0F, 9.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.25F, -3.0F, 0.0436F, 0.0F, 0.0F));
		PartDefinition cube_r1 = topJaw.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 167).addBox(-0.5F, 1.5F, -46.0F, 1.0F, 1.0F, 40.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0436F, 0.0F, 0.0F));
		PartDefinition lowJaw = head.addOrReplaceChild("lowJaw", CubeListBuilder.create().texOffs(39, 126).addBox(-4.0F, 0.0F, -5.0F, 8.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -3.25F, -0.1309F, 0.0F, 0.0F));
		PartDefinition rFin00 = neck.addOrReplaceChild("rFin00", CubeListBuilder.create().texOffs(0, 178).addBox(-0.2314F, -2.4625F, -4.3719F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.25F, 2.6F, 0.1F, 0.167F, 0.0F, 1.1345F));
		PartDefinition rFin01 = rFin00.addOrReplaceChild("rFin01", CubeListBuilder.create().texOffs(12, 178).addBox(0.2686F, -3.8585F, -3.2078F, 1.0F, 3.0F, 4.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(-0.5F, 3.9F, -0.5F, 0.3643F, 0.0F, 0.0F));
		PartDefinition rFin02 = rFin01.addOrReplaceChild("rFin02", CubeListBuilder.create().texOffs(0, 189).addBox(0.2686F, -4.2595F, -3.6523F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.7F, 1.0F, 0.1367F, 0.0F, 0.0F));
		PartDefinition lFin = neck.addOrReplaceChild("lFin", CubeListBuilder.create().texOffs(0, 178).mirror().addBox(-0.2314F, -2.4625F, -4.3719F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, 2.6F, 0.1F, 0.167F, 0.0F, -1.1345F));
		PartDefinition lFin2 = lFin.addOrReplaceChild("lFin2", CubeListBuilder.create().texOffs(12, 178).mirror().addBox(0.2686F, -3.8585F, -3.2078F, 1.0F, 3.0F, 4.0F, new CubeDeformation(-0.05F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 3.9F, -0.5F, 0.3643F, 0.0F, 0.0F));
		PartDefinition lFin3 = lFin2.addOrReplaceChild("lFin3", CubeListBuilder.create().texOffs(0, 189).mirror().addBox(0.2686F, -4.2595F, -3.6523F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 2.7F, 1.0F, 0.1367F, 0.0F, 0.0F));
		PartDefinition tail00 = torso.addOrReplaceChild("tail00", CubeListBuilder.create().texOffs(0, 31).addBox(-5.5F, -1.5F, 0.0F, 11.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -5.0F, 0.0F, -0.0436F, 0.0F, 0.0F));
		PartDefinition tail01 = tail00.addOrReplaceChild("tail01", CubeListBuilder.create().texOffs(0, 58).addBox(-4.0F, -1.5F, 0.0F, 8.0F, 10.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 11.75F, -0.0436F, 0.0F, 0.0F));
		PartDefinition tail02 = tail01.addOrReplaceChild("tail02", CubeListBuilder.create().texOffs(0, 80).addBox(-3.0F, -1.0F, 0.0F, 6.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 8.5F, -0.0436F, 0.0F, 0.0F));
		PartDefinition tail03 = tail02.addOrReplaceChild("tail03", CubeListBuilder.create().texOffs(0, 101).addBox(-2.5F, -1.0F, 0.0F, 5.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 9.25F, -0.0873F, 0.0F, 0.0F));
		PartDefinition flukeMiddle = tail03.addOrReplaceChild("flukeMiddle", CubeListBuilder.create().texOffs(0, 116).addBox(-1.5F, -1.3223F, 6.0742F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.8F, 0.05F));
		PartDefinition flukeL01 = flukeMiddle.addOrReplaceChild("flukeL01", CubeListBuilder.create().texOffs(14, 190).mirror().addBox(-0.1877F, 1.8469F, 4.3663F, 1.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.3F, 0.1F, -0.5F, 0.5009F, 0.0F, -1.3203F));
		PartDefinition flukeL02 = flukeL01.addOrReplaceChild("flukeL02", CubeListBuilder.create().texOffs(22, 168).mirror().addBox(-0.1877F, 3.3614F, 4.06F, 1.0F, 4.0F, 6.0F, new CubeDeformation(-0.05F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.75F, 0.0F, 0.0986F, 0.0F, 0.0F));
		PartDefinition flukeL03 = flukeL02.addOrReplaceChild("flukeL03", CubeListBuilder.create().texOffs(26, 184).mirror().addBox(-0.1877F, 4.4164F, 3.1711F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.75F, 0.0F, 0.2276F, 0.0F, 0.0F));
		PartDefinition flukeR01 = flukeMiddle.addOrReplaceChild("flukeR01", CubeListBuilder.create().texOffs(14, 190).addBox(-0.8123F, 1.8469F, 4.3663F, 1.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3F, 0.1F, -0.5F, 0.5009F, 0.0F, 1.3203F));
		PartDefinition flukeR02 = flukeR01.addOrReplaceChild("flukeR02", CubeListBuilder.create().texOffs(22, 168).addBox(-0.8123F, 3.3614F, 4.06F, 1.0F, 4.0F, 6.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(0.0F, 3.75F, 0.0F, 0.0986F, 0.0F, 0.0F));
		PartDefinition flukeR03 = flukeR02.addOrReplaceChild("flukeR03", CubeListBuilder.create().texOffs(26, 184).addBox(-0.8123F, 4.4164F, 3.1711F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.75F, 0.0F, 0.2276F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 96, 256);
	}

	@Override
	public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		if (!inWater) {
			matrixStackIn.translate(0F, 0.25F, 0F);
		}
		this.torso.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!Minecraft.getInstance().isPaused()) {
			this.inWater = entity.isInWater();
			if (inWater) {
				float pitch = rad(headPitch);
				this.torso.xRot = pitch == 0 ? 0 : (float) ((pitch / Math.abs(pitch)) * Math.min(Math.abs(pitch), Math.toRadians(45F)));
				this.torso.yRot = rad(netHeadYaw);
			} else {
				this.torso.yRot = -rad(ModMathHelper.interpolateRotation(entity.yBodyRot, entity.yBodyRotO, Minecraft.getInstance().getFrameTime()));
				this.torso.xRot = 0F;
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
				this.tail01.xRot = Mth.sin(z01 * factor + ticks) * amplitude + offset;
				this.tail02.xRot = Mth.sin(z02 * factor + ticks) * amplitude + offset;
				this.tail03.xRot = Mth.sin(z03 * factor + ticks) * amplitude + offset;
			}
			{
				float mul = 0.1F;
				float div = 10F;
				float add = entity.getUUID().hashCode() * 0.001F;
				this.lFin.xRot = Mth.cos(ageInTicks * (mul + 0.05F) + add) / div + 0.167F;
				this.rFin00.xRot = Mth.cos(ageInTicks * (mul) + add) / div + 0.167F;
			}
		}
	}
}