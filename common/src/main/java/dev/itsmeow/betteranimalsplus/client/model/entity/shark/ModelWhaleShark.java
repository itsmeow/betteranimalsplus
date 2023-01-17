package dev.itsmeow.betteranimalsplus.client.model.entity.shark;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import dev.itsmeow.betteranimalsplus.common.entity.EntityShark;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class ModelWhaleShark<T extends EntityShark> extends ModelBAP<T> {

	public ModelPart body;
	public ModelPart tail00;
	public ModelPart tail01;
	public ModelPart tail02;
	public ModelPart tail03;
	public ModelPart tail04;
	public ModelPart tailFinUpper00;
	public ModelPart tailFinUpper01;
	public ModelPart tailFinUpper02;
	public ModelPart tailFinLower00;
	public ModelPart tailFinLower01;
	public ModelPart tailFinLower2;
	public ModelPart smallTopFin;
	public ModelPart lowSmallFin;
	public ModelPart dorsalFin00;
	public ModelPart dorsalFin1;
	public ModelPart dorsalFin2;
	public ModelPart cube_r1;
	public ModelPart smallLFin;
	public ModelPart smallRFin;
	public ModelPart neck;
	public ModelPart throat;
	public ModelPart head;
	public ModelPart cube_r2;
	public ModelPart topJaw;
	public ModelPart cube_r3;
	public ModelPart cube_r4;
	public ModelPart lowJaw;
	public ModelPart lFin1;
	public ModelPart lFin2;
	public ModelPart lFin3;
	public ModelPart cube_r5;
	public ModelPart rFin1;
	public ModelPart rFin2;
	public ModelPart rFin3;
	public ModelPart cube_r6;

	public ModelWhaleShark(ModelPart root) {
		this.body = root.getChild("body");
		this.tail00 = body.getChild("tail00");
		this.tail01 = tail00.getChild("tail01");
		this.tail02 = tail01.getChild("tail02");
		this.tail03 = tail02.getChild("tail03");
		this.tail04 = tail03.getChild("tail04");
		this.tailFinUpper00 = tail04.getChild("tailFinUpper00");
		this.tailFinUpper01 = tailFinUpper00.getChild("tailFinUpper01");
		this.tailFinUpper02 = tailFinUpper01.getChild("tailFinUpper02");
		this.tailFinLower00 = tailFinUpper00.getChild("tailFinLower00");
		this.tailFinLower01 = tailFinLower00.getChild("tailFinLower01");
		this.tailFinLower2 = tailFinLower01.getChild("tailFinLower2");
		this.smallTopFin = tail02.getChild("smallTopFin");
		this.lowSmallFin = tail02.getChild("lowSmallFin");
		this.dorsalFin00 = tail00.getChild("dorsalFin00");
		this.dorsalFin1 = dorsalFin00.getChild("dorsalFin1");
		this.dorsalFin2 = dorsalFin00.getChild("dorsalFin2");
		this.cube_r1 = dorsalFin2.getChild("cube_r1");
		this.smallLFin = tail00.getChild("smallLFin");
		this.smallRFin = tail00.getChild("smallRFin");
		this.neck = body.getChild("neck");
		this.throat = neck.getChild("throat");
		this.head = neck.getChild("head");
		this.cube_r2 = head.getChild("cube_r2");
		this.topJaw = head.getChild("topJaw");
		this.cube_r3 = topJaw.getChild("cube_r3");
		this.cube_r4 = topJaw.getChild("cube_r4");
		this.lowJaw = head.getChild("lowJaw");
		this.lFin1 = body.getChild("lFin1");
		this.lFin2 = lFin1.getChild("lFin2");
		this.lFin3 = lFin2.getChild("lFin3");
		this.cube_r5 = lFin3.getChild("cube_r5");
		this.rFin1 = body.getChild("rFin1");
		this.rFin2 = rFin1.getChild("rFin2");
		this.rFin3 = rFin2.getChild("rFin3");
		this.cube_r6 = rFin3.getChild("cube_r6");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-23.0F, -12.0F, -53.0F, 45.0F, 45.0F, 54.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, -18.0F, -22.0F, 0.0175F, 0.0F, 0.0F));
		PartDefinition tail00 = body.addOrReplaceChild("tail00", CubeListBuilder.create().texOffs(0, 111).addBox(-20.0F, -12.0F, -1.0F, 39.0F, 40.0F, 42.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0349F, 0.0F, 0.0F));
		PartDefinition tail01 = tail00.addOrReplaceChild("tail01", CubeListBuilder.create().texOffs(0, 203).addBox(-17.0F, -12.0F, -1.0F, 33.0F, 32.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 41.0F, -0.0175F, 0.0F, 0.0F));
		PartDefinition tail02 = tail01.addOrReplaceChild("tail02", CubeListBuilder.create().texOffs(0, 275).addBox(-14.0F, -11.0F, 0.0F, 27.0F, 28.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 25.0F));
		PartDefinition tail03 = tail02.addOrReplaceChild("tail03", CubeListBuilder.create().texOffs(0, 339).addBox(-11.0F, -12.0F, -1.0F, 21.0F, 23.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 26.0F));
		PartDefinition tail04 = tail03.addOrReplaceChild("tail04", CubeListBuilder.create().texOffs(0, 398).addBox(-7.0F, -12.0F, -1.0F, 14.0F, 17.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 27.0F));
		PartDefinition tailFinUpper00 = tail04.addOrReplaceChild("tailFinUpper00", CubeListBuilder.create().texOffs(0, 451).addBox(-2.5F, -2.0F, -1.0F, 5.0F, 18.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 14.0F, 0.7854F, 0.0F, 0.0F));
		PartDefinition tailFinUpper01 = tailFinUpper00.addOrReplaceChild("tailFinUpper01", CubeListBuilder.create().texOffs(64, 448).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 14.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 19.0F, -0.1745F, 0.0F, 0.0F));
		PartDefinition tailFinUpper02 = tailFinUpper01.addOrReplaceChild("tailFinUpper02", CubeListBuilder.create().texOffs(131, 445).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 10.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 20.0F, -0.0436F, 0.0F, 0.0F));
		PartDefinition tailFinLower00 = tailFinUpper00.addOrReplaceChild("tailFinLower00", CubeListBuilder.create().texOffs(106, 392).addBox(-2.0F, 2.0F, -7.0F, 4.0F, 22.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, -2.0F, -0.3491F, 0.0F, 0.0F));
		PartDefinition tailFinLower01 = tailFinLower00.addOrReplaceChild("tailFinLower01", CubeListBuilder.create().texOffs(164, 401).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 16.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 24.0F, -7.0F, 0.1309F, 0.0F, 0.0F));
		PartDefinition tailFinLower2 = tailFinLower01.addOrReplaceChild("tailFinLower2", CubeListBuilder.create().texOffs(195, 429).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 16.0F, 1.0F, 0.1309F, 0.0F, 0.0F));
		PartDefinition smallTopFin = tail02.addOrReplaceChild("smallTopFin", CubeListBuilder.create().texOffs(250, 378).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 10.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 1.0F, 0.6981F, 0.0F, 0.0F));
		PartDefinition lowSmallFin = tail02.addOrReplaceChild("lowSmallFin", CubeListBuilder.create().texOffs(292, 273).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 7.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 2.0F, -0.6109F, 0.0F, 0.0F));
		PartDefinition dorsalFin00 = tail00.addOrReplaceChild("dorsalFin00", CubeListBuilder.create().texOffs(136, 287).addBox(-2.5F, 0.0F, -1.0F, 5.0F, 13.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, -12.0F, 0.0F, 0.8727F, 0.0F, 0.0F));
		PartDefinition dorsalFin1 = dorsalFin00.addOrReplaceChild("dorsalFin1", CubeListBuilder.create().texOffs(189, 289).addBox(-1.5F, 0.0F, -1.0F, 3.0F, 11.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 12.0F, -0.0873F, 0.0F, 0.0F));
		PartDefinition dorsalFin2 = dorsalFin00.addOrReplaceChild("dorsalFin2", CubeListBuilder.create().texOffs(239, 287).addBox(-1.0F, 0.2588F, 0.0341F, 2.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 26.0F, -0.48F, 0.0F, 0.0F));
		PartDefinition cube_r1 = dorsalFin2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(128, 323).addBox(-1.0F, 0.0F, -18.0F, 2.0F, 12.0F, 19.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 11.0F, 10.0F, -0.1309F, 0.0F, 0.0F));
		PartDefinition smallLFin = tail00.addOrReplaceChild("smallLFin", CubeListBuilder.create().texOffs(209, 334).mirror().addBox(-1.0F, -5.0F, -1.0F, 2.0F, 10.0F, 17.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-18.75F, 23.0F, 29.0F, -0.8027F, -0.1841F, 0.1872F));
		PartDefinition smallRFin = tail00.addOrReplaceChild("smallRFin", CubeListBuilder.create().texOffs(209, 334).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 10.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(18.25F, 23.0F, 29.0F, -0.8027F, 0.1841F, -0.1872F));
		PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(209, 0).addBox(-21.0F, 0.0F, -50.0F, 41.0F, 27.0F, 51.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, -53.0F, 0.2618F, 0.0F, 0.0F));
		PartDefinition throat = neck.addOrReplaceChild("throat", CubeListBuilder.create().texOffs(198, 95).addBox(-20.0F, -17.0F, 2.0F, 39.0F, 17.0F, 42.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 27.0F, -52.0F, -0.3927F, 0.0F, 0.0F));
		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(175, 173).addBox(-20.0F, -1.0F, -16.0F, 39.0F, 18.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -48.25F, 0.0873F, 0.0F, 0.0F));
		PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(298, 170).addBox(-19.5F, -0.5F, -1.25F, 38.0F, 19.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -15.0F, -0.4363F, 0.0F, 0.0F));
		PartDefinition topJaw = head.addOrReplaceChild("topJaw", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 11.0F, -18.0F, -0.2182F, 0.0F, 0.0F));
		PartDefinition cube_r3 = topJaw.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(250, 231).addBox(-18.0F, -0.25F, 2.0F, 34.0F, 4.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.75F, -14.0F, 0.2182F, 0.0F, 0.0F));
		PartDefinition cube_r4 = topJaw.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(134, 225).addBox(-19.0F, -2.0F, -12.0F, 36.0F, 7.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.9743F, -0.3916F, -0.0873F, 0.0F, 0.0F));
		PartDefinition lowJaw = head.addOrReplaceChild("lowJaw", CubeListBuilder.create().texOffs(150, 262).addBox(-18.0F, 0.0F, -10.0F, 34.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, -20.0F, -0.5236F, 0.0F, 0.0F));
		PartDefinition lFin1 = body.addOrReplaceChild("lFin1", CubeListBuilder.create().texOffs(378, 267).addBox(-2.1472F, -0.3617F, -14.0F, 4.0F, 15.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0F, 23.0F, -38.75F, 0.0F, 0.0F, -0.6109F));
		PartDefinition lFin2 = lFin1.addOrReplaceChild("lFin2", CubeListBuilder.create().texOffs(384, 337).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 20.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1472F, 14.6383F, -14.0F, 0.4363F, 0.0F, 0.0F));
		PartDefinition lFin3 = lFin2.addOrReplaceChild("lFin3", CubeListBuilder.create(), PartPose.offset(0.0F, 20.0F, 0.0F));
		PartDefinition cube_r5 = lFin3.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(398, 403).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 21.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, 0.0F, 0.0F));
		PartDefinition rFin1 = body.addOrReplaceChild("rFin1", CubeListBuilder.create().texOffs(378, 267).mirror().addBox(-1.8528F, -0.3617F, -14.0F, 4.0F, 15.0F, 32.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-20.5F, 23.0F, -38.75F, 0.0F, 0.0F, 0.6109F));
		PartDefinition rFin2 = rFin1.addOrReplaceChild("rFin2", CubeListBuilder.create().texOffs(384, 337).mirror().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 20.0F, 22.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.1472F, 14.6383F, -14.0F, 0.4363F, 0.0F, 0.0F));
		PartDefinition rFin3 = rFin2.addOrReplaceChild("rFin3", CubeListBuilder.create(), PartPose.offset(0.0F, 20.0F, 0.0F));
		PartDefinition cube_r6 = rFin3.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(398, 403).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 21.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		this.body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
	}

	@Override
	public void setupAnim(EntityShark entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		ModelBullShark.animate(entity, ageInTicks, body, tail00, tail01, tail02, lowJaw);
	}
}