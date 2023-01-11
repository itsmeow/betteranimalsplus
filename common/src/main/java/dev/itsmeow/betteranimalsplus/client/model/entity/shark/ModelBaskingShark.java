package dev.itsmeow.betteranimalsplus.client.model.entity.shark;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import dev.itsmeow.betteranimalsplus.common.entity.EntityShark;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class ModelBaskingShark<T extends EntityShark> extends ModelBAP<T> {

	public ModelPart body;
	public ModelPart tail00;
	public ModelPart tail01;
	public ModelPart tail02;
	public ModelPart tail03;
	public ModelPart tail04;
	public ModelPart topTailFin00;
	public ModelPart topTailFin01;
	public ModelPart topTailFin02;
	public ModelPart lowTailFin00;
	public ModelPart lowTailFin01;
	public ModelPart lowTailFin02;
	public ModelPart topFin2;
	public ModelPart lowFin2;
	public ModelPart lLowFin;
	public ModelPart rLowFin;
	public ModelPart dorsalFin00;
	public ModelPart dorsalFin01;
	public ModelPart dorsalFin2;
	public ModelPart dorsalFin3;
	public ModelPart cube_r1;
	public ModelPart neck;
	public ModelPart head;
	public ModelPart topJaw;
	public ModelPart snout;
	public ModelPart snout2;
	public ModelPart headLower;
	public ModelPart lowJaw;
	public ModelPart lFin1;
	public ModelPart lFin2;
	public ModelPart lFin3;
	public ModelPart rFin1;
	public ModelPart rFin2;
	public ModelPart rFin3;

	public ModelBaskingShark(ModelPart root) {
		this.body = root.getChild("body");
		this.tail00 = body.getChild("tail00");
		this.tail01 = tail00.getChild("tail01");
		this.tail02 = tail01.getChild("tail02");
		this.tail03 = tail02.getChild("tail03");
		this.tail04 = tail03.getChild("tail04");
		this.topTailFin00 = tail04.getChild("topTailFin00");
		this.topTailFin01 = topTailFin00.getChild("topTailFin01");
		this.topTailFin02 = topTailFin01.getChild("topTailFin02");
		this.lowTailFin00 = topTailFin00.getChild("lowTailFin00");
		this.lowTailFin01 = lowTailFin00.getChild("lowTailFin01");
		this.lowTailFin02 = lowTailFin01.getChild("lowTailFin02");
		this.topFin2 = tail03.getChild("topFin2");
		this.lowFin2 = tail03.getChild("lowFin2");
		this.lLowFin = tail01.getChild("lLowFin");
		this.rLowFin = tail01.getChild("rLowFin");
		this.dorsalFin00 = tail00.getChild("dorsalFin00");
		this.dorsalFin01 = dorsalFin00.getChild("dorsalFin01");
		this.dorsalFin2 = dorsalFin01.getChild("dorsalFin2");
		this.dorsalFin3 = dorsalFin2.getChild("dorsalFin3");
		this.cube_r1 = dorsalFin3.getChild("cube_r1");
		this.neck = body.getChild("neck");
		this.head = neck.getChild("head");
		this.topJaw = head.getChild("topJaw");
		this.snout = topJaw.getChild("snout");
		this.snout2 = topJaw.getChild("snout2");
		this.headLower = neck.getChild("headLower");
		this.lowJaw = headLower.getChild("lowJaw");
		this.lFin1 = body.getChild("lFin1");
		this.lFin2 = lFin1.getChild("lFin2");
		this.lFin3 = lFin2.getChild("lFin3");
		this.rFin1 = body.getChild("rFin1");
		this.rFin2 = rFin1.getChild("rFin2");
		this.rFin3 = rFin2.getChild("rFin3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-14.5F, -14.0F, -23.0F, 29.0F, 31.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -17.0F, 0.0175F, 0.0F, 0.0F));
		PartDefinition tail00 = body.addOrReplaceChild("tail00", CubeListBuilder.create().texOffs(0, 70).addBox(-13.0F, -14.0F, -1.0F, 26.0F, 28.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.0F, -0.0436F, 0.0F, 0.0F));
		PartDefinition tail01 = tail00.addOrReplaceChild("tail01", CubeListBuilder.create().texOffs(0, 136).addBox(-11.0F, 0.0F, 0.0F, 22.0F, 24.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -14.0F, 27.0F));
		PartDefinition tail02 = tail01.addOrReplaceChild("tail02", CubeListBuilder.create().texOffs(0, 192).addBox(-9.0F, 0.0F, 0.0F, 18.0F, 20.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 21.0F));
		PartDefinition tail03 = tail02.addOrReplaceChild("tail03", CubeListBuilder.create().texOffs(0, 239).addBox(-7.0F, 0.0F, 0.0F, 14.0F, 16.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 17.0F));
		PartDefinition tail04 = tail03.addOrReplaceChild("tail04", CubeListBuilder.create().texOffs(0, 281).addBox(-6.0F, 0.0F, 0.0F, 12.0F, 12.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 15.0F));
		PartDefinition topTailFin00 = tail04.addOrReplaceChild("topTailFin00", CubeListBuilder.create().texOffs(67, 275).addBox(-2.0F, -16.0F, -3.0F, 4.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 11.0F, -0.4363F, 0.0F, 0.0F));
		PartDefinition topTailFin01 = topTailFin00.addOrReplaceChild("topTailFin01", CubeListBuilder.create().texOffs(72, 242).addBox(-1.5F, -13.0F, -1.0F, 3.0F, 13.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.5F, -2.0F, -0.2618F, 0.0F, 0.0F));
		PartDefinition topTailFin02 = topTailFin01.addOrReplaceChild("topTailFin02", CubeListBuilder.create().texOffs(83, 203).addBox(-1.0F, -13.0F, 0.0F, 2.0F, 13.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.0F, -1.0F, -0.1309F, 0.0F, 0.0F));
		PartDefinition lowTailFin00 = topTailFin00.addOrReplaceChild("lowTailFin00", CubeListBuilder.create().texOffs(0, 320).addBox(-2.0F, -1.0F, -1.0F, 3.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.6545F, 0.0F, 0.0F));
		PartDefinition lowTailFin01 = lowTailFin00.addOrReplaceChild("lowTailFin01", CubeListBuilder.create().texOffs(39, 323).addBox(-1.5F, 0.0F, 0.0F, 2.0F, 9.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, -1.0F, 0.2182F, 0.0F, 0.0F));
		PartDefinition lowTailFin02 = lowTailFin01.addOrReplaceChild("lowTailFin02", CubeListBuilder.create().texOffs(75, 323).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.3491F, 0.0F, 0.0F));
		PartDefinition topFin2 = tail03.addOrReplaceChild("topFin2", CubeListBuilder.create().texOffs(134, 159).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));
		PartDefinition lowFin2 = tail03.addOrReplaceChild("lowFin2", CubeListBuilder.create().texOffs(125, 128).addBox(-0.5F, -7.0F, 0.0F, 1.0F, 7.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 16.0F, 2.0F, -0.7854F, 0.0F, 0.0F));
		PartDefinition lLowFin = tail01.addOrReplaceChild("lLowFin", CubeListBuilder.create().texOffs(125, 92).addBox(-1.0F, 0.0F, -4.0F, 2.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, 22.0F, 3.0F, 0.6389F, 0.1395F, -0.2223F));
		PartDefinition rLowFin = tail01.addOrReplaceChild("rLowFin", CubeListBuilder.create().texOffs(125, 92).mirror().addBox(-1.0F, 0.0F, -4.0F, 2.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.0F, 22.0F, 3.0F, 0.6389F, -0.1395F, 0.2223F));
		PartDefinition dorsalFin00 = tail00.addOrReplaceChild("dorsalFin00", CubeListBuilder.create().texOffs(125, 186).addBox(-2.0F, -7.0F, 0.0F, 4.0F, 7.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, -1.0F, -0.1745F, 0.0F, 0.0F));
		PartDefinition dorsalFin01 = dorsalFin00.addOrReplaceChild("dorsalFin01", CubeListBuilder.create().texOffs(128, 214).addBox(-1.5F, -11.0F, 0.0F, 3.0F, 11.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, -0.1309F, 0.0F, 0.0F));
		PartDefinition dorsalFin2 = dorsalFin01.addOrReplaceChild("dorsalFin2", CubeListBuilder.create().texOffs(136, 248).addBox(-1.5F, -7.0F, 0.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, -0.3491F, 0.0F, 0.0F));
		PartDefinition dorsalFin3 = dorsalFin2.addOrReplaceChild("dorsalFin3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -7.0F, 5.0F, 1.0036F, 0.0F, 0.0F));
		PartDefinition cube_r1 = dorsalFin3.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(142, 281).addBox(-1.0F, -21.0F, -8.0F, 2.0F, 20.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 20.2269F, 0.0481F, 0.0436F, 0.0F, 0.0F));
		PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 356).addBox(-14.0F, 0.0F, -16.0F, 28.0F, 29.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, -24.0F, 0.0436F, 0.0F, 0.0F));
		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(103, 359).addBox(-12.0F, -14.0F, -12.0F, 24.0F, 19.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 14.0F, -16.0F, -0.1396F, 0.0F, 0.0F));
		PartDefinition topJaw = head.addOrReplaceChild("topJaw", CubeListBuilder.create().texOffs(83, 415).addBox(-11.0F, -12.0F, -9.0F, 22.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, -13.0F, -0.1309F, 0.0F, 0.0F));
		PartDefinition snout = topJaw.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(164, 409).addBox(-8.0F, -8.0F, -16.0F, 15.0F, 8.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -9.0F, -0.2618F, 0.0F, 0.0F));
		PartDefinition snout2 = topJaw.addOrReplaceChild("snout2", CubeListBuilder.create().texOffs(198, 356).addBox(-8.0F, -5.6641F, 0.2583F, 14.0F, 7.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -5.5F, -25.0F, 0.2618F, 0.0F, 0.0F));
		PartDefinition headLower = neck.addOrReplaceChild("headLower", CubeListBuilder.create().texOffs(0, 415).addBox(-12.0F, 0.0F, -12.0F, 24.0F, 9.0F, 13.0F, new CubeDeformation(-0.01F))
		.texOffs(75, 454).addBox(10.0F, -15.0F, -12.0F, 1.0F, 15.0F, 13.0F, new CubeDeformation(-0.01F))
		.texOffs(75, 454).mirror().addBox(-11.0F, -15.0F, -12.0F, 1.0F, 15.0F, 13.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(0.0F, 19.0F, -16.0F, 0.7069F, 0.0F, 0.0F));
		PartDefinition lowJaw = headLower.addOrReplaceChild("lowJaw", CubeListBuilder.create().texOffs(0, 445).addBox(-8.0F, -3.6955F, -11.5307F, 16.0F, 8.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 4.0F, -11.75F));
		PartDefinition lFin1 = body.addOrReplaceChild("lFin1", CubeListBuilder.create().texOffs(122, 0).addBox(-1.5F, 0.0F, -4.0F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.5F, 11.0F, -20.0F, 0.4796F, 0.0201F, -0.3878F));
		PartDefinition lFin2 = lFin1.addOrReplaceChild("lFin2", CubeListBuilder.create().texOffs(122, 22).addBox(-0.5F, 0.0F, 0.0F, 2.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 6.0F, -4.0F));
		PartDefinition lFin3 = lFin2.addOrReplaceChild("lFin3", CubeListBuilder.create().texOffs(125, 53).addBox(-2.0F, 0.0F, 0.0F, 2.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 10.0F, 0.0F));
		PartDefinition rFin1 = body.addOrReplaceChild("rFin1", CubeListBuilder.create().texOffs(122, 0).mirror().addBox(-1.5F, 0.0F, -4.0F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-12.5F, 11.0F, -20.0F, 0.4796F, -0.0201F, 0.3878F));
		PartDefinition rFin2 = rFin1.addOrReplaceChild("rFin2", CubeListBuilder.create().texOffs(122, 22).mirror().addBox(-1.5F, 0.0F, 0.0F, 2.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.5F, 6.0F, -4.0F));
		PartDefinition rFin3 = rFin2.addOrReplaceChild("rFin3", CubeListBuilder.create().texOffs(125, 53).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.5F, 10.0F, 0.0F));
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