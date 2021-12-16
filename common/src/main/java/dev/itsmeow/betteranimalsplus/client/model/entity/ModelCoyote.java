package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import dev.itsmeow.betteranimalsplus.common.entity.EntityCoyote;
import dev.itsmeow.betteranimalsplus.common.entity.EntityFeralWolf;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;

public class ModelCoyote<T extends LivingEntity> extends ModelBAP<T> {

    public ModelPart body;
    public ModelPart stomach;
    public ModelPart tail01;
    public ModelPart tail02;
    public ModelPart tail03;
    public ModelPart tail04;
    public ModelPart lHindLeg01;
    public ModelPart lHindLeg02;
    public ModelPart lHindLeg03;
    public ModelPart lHindPaw;
    public ModelPart rHindLeg01;
    public ModelPart rHindLeg02;
    public ModelPart rHindLeg03;
    public ModelPart rHindPaw;
    public ModelPart neck;
    public ModelPart neckFur03_r1;
    public ModelPart neckFur02_r1;
    public ModelPart neckFur01_r1;
    public ModelPart head;
    public ModelPart rCheekFur_r1;
    public ModelPart lCheekFur_r1;
    public ModelPart muzzle;
    public ModelPart mUpperFang_r1;
    public ModelPart rUpperFang_r1;
    public ModelPart lUpperFang_r1;
    public ModelPart rLip_r1;
    public ModelPart lLip_r1;
    public ModelPart lowerJaw;
    public ModelPart lEar01;
    public ModelPart lEar02;
    public ModelPart cube_r1;
    public ModelPart rEar01;
    public ModelPart rEar02;
    public ModelPart cube_r2;
    public ModelPart lArm01;
    public ModelPart cube_r3;
    public ModelPart lArm02;
    public ModelPart cube_r4;
    public ModelPart lForePaw;
    public ModelPart rArm01;
    public ModelPart cube_r5;
    public ModelPart rArm02;
    public ModelPart cube_r6;
    public ModelPart rForePaw;

    public ModelCoyote(ModelPart root) {
        this.body = root.getChild("body");
        this.stomach = body.getChild("stomach");
        this.tail01 = stomach.getChild("tail01");
        this.tail02 = tail01.getChild("tail02");
        this.tail03 = tail02.getChild("tail03");
        this.tail04 = tail03.getChild("tail04");
        this.lHindLeg01 = stomach.getChild("lHindLeg01");
        this.lHindLeg02 = lHindLeg01.getChild("lHindLeg02");
        this.lHindLeg03 = lHindLeg02.getChild("lHindLeg03");
        this.lHindPaw = lHindLeg03.getChild("lHindPaw");
        this.rHindLeg01 = stomach.getChild("rHindLeg01");
        this.rHindLeg02 = rHindLeg01.getChild("rHindLeg02");
        this.rHindLeg03 = rHindLeg02.getChild("rHindLeg03");
        this.rHindPaw = rHindLeg03.getChild("rHindPaw");
        this.neck = body.getChild("neck");
        this.neckFur03_r1 = neck.getChild("neckFur03_r1");
        this.neckFur02_r1 = neck.getChild("neckFur02_r1");
        this.neckFur01_r1 = neck.getChild("neckFur01_r1");
        this.head = neck.getChild("head");
        this.rCheekFur_r1 = head.getChild("rCheekFur_r1");
        this.lCheekFur_r1 = head.getChild("lCheekFur_r1");
        this.muzzle = head.getChild("muzzle");
        this.mUpperFang_r1 = muzzle.getChild("mUpperFang_r1");
        this.rUpperFang_r1 = muzzle.getChild("rUpperFang_r1");
        this.lUpperFang_r1 = muzzle.getChild("lUpperFang_r1");
        this.rLip_r1 = muzzle.getChild("rLip_r1");
        this.lLip_r1 = muzzle.getChild("lLip_r1");
        this.lowerJaw = head.getChild("lowerJaw");
        this.lEar01 = head.getChild("lEar01");
        this.lEar02 = lEar01.getChild("lEar02");
        this.cube_r1 = lEar02.getChild("cube_r1");
        this.rEar01 = head.getChild("rEar01");
        this.rEar02 = rEar01.getChild("rEar02");
        this.cube_r2 = rEar02.getChild("cube_r2");
        this.lArm01 = body.getChild("lArm01");
        this.cube_r3 = lArm01.getChild("cube_r3");
        this.lArm02 = lArm01.getChild("lArm02");
        this.cube_r4 = lArm02.getChild("cube_r4");
        this.lForePaw = lArm02.getChild("lForePaw");
        this.rArm01 = body.getChild("rArm01");
        this.cube_r5 = rArm01.getChild("cube_r5");
        this.rArm02 = rArm01.getChild("rArm02");
        this.cube_r6 = rArm02.getChild("cube_r6");
        this.rForePaw = rArm02.getChild("rForePaw");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -2.5F, -5.0F, 6.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.25F, -2.0F));
        PartDefinition stomach = body.addOrReplaceChild("stomach", CubeListBuilder.create().texOffs(0, 14).addBox(-2.5F, -2.0F, -0.5F, 5.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.25F, 3.0F));
        PartDefinition tail01 = stomach.addOrReplaceChild("tail01", CubeListBuilder.create().texOffs(0, 27).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.7F, 5.25F, 0.6981F, 0.0F, 0.0F));
        PartDefinition tail02 = tail01.addOrReplaceChild("tail02", CubeListBuilder.create().texOffs(0, 34).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 2.5F, 0.25F, -0.3142F, 0.0F, 0.0F));
        PartDefinition tail03 = tail02.addOrReplaceChild("tail03", CubeListBuilder.create().texOffs(12, 27).addBox(-1.5F, 0.2F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 4.75F, -0.4F, 0.2269F, 0.0F, 0.0F));
        PartDefinition tail04 = tail03.addOrReplaceChild("tail04", CubeListBuilder.create().texOffs(13, 35).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.4F, 0.0698F, 0.0F, 0.0F));
        PartDefinition lHindLeg01 = stomach.addOrReplaceChild("lHindLeg01", CubeListBuilder.create().texOffs(28, 12).addBox(-0.95F, -3.2F, -2.95F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 2.0F, 4.5F, -0.384F, -0.0436F, -0.096F));
        PartDefinition lHindLeg02 = lHindLeg01.addOrReplaceChild("lHindLeg02", CubeListBuilder.create().texOffs(28, 24).addBox(-0.75F, 0.4F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, 2.0F, -2.3F, -0.2618F, 0.0F, 0.0F));
        PartDefinition lHindLeg03 = lHindLeg02.addOrReplaceChild("lHindLeg03", CubeListBuilder.create().texOffs(29, 32).addBox(-1.0F, -0.4F, -1.5F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.3F, 1.0F, 4.8F, 0.5236F, 0.0F, 0.096F));
        PartDefinition lHindPaw = lHindLeg03.addOrReplaceChild("lHindPaw", CubeListBuilder.create().texOffs(27, 40).addBox(-1.45F, -0.2F, -2.2F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.05F, 4.0F, -0.5F, 0.1222F, 0.0F, 0.0F));
        PartDefinition rHindLeg01 = stomach.addOrReplaceChild("rHindLeg01", CubeListBuilder.create().texOffs(28, 12).mirror().addBox(-2.05F, -3.2F, -2.95F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 2.0F, 4.5F, -0.384F, 0.0436F, 0.096F));
        PartDefinition rHindLeg02 = rHindLeg01.addOrReplaceChild("rHindLeg02", CubeListBuilder.create().texOffs(28, 24).mirror().addBox(-1.25F, 0.4F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.25F, 2.0F, -2.3F, -0.2618F, 0.0F, 0.0F));
        PartDefinition rHindLeg03 = rHindLeg02.addOrReplaceChild("rHindLeg03", CubeListBuilder.create().texOffs(29, 32).mirror().addBox(-1.0F, -0.4F, -1.5F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(-0.3F, 1.0F, 4.8F, 0.5236F, 0.0F, -0.096F));
        PartDefinition rHindPaw = rHindLeg03.addOrReplaceChild("rHindPaw", CubeListBuilder.create().texOffs(27, 40).mirror().addBox(-1.55F, -0.2F, -2.2F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.05F, 4.0F, -0.5F, 0.1222F, 0.0F, 0.0F));
        PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(29, 0).addBox(-1.5F, -1.65F, -4.5F, 4.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.0F, -5.0F, -0.1309F, 0.0F, 0.0F));
        PartDefinition neckFur03_r1 = neck.addOrReplaceChild("neckFur03_r1", CubeListBuilder.create().texOffs(41, 49).addBox(-1.0F, -0.25F, -1.5F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.75F, -1.0F, 0.3491F, 0.0F, 0.0F));
        PartDefinition neckFur02_r1 = neck.addOrReplaceChild("neckFur02_r1", CubeListBuilder.create().texOffs(41, 41).addBox(-1.5F, -0.25F, -0.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -1.75F, -1.0F, 0.2182F, 0.0F, 0.0F));
        PartDefinition neckFur01_r1 = neck.addOrReplaceChild("neckFur01_r1", CubeListBuilder.create().texOffs(42, 32).addBox(-1.5F, 2.5F, -4.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));
        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 46).addBox(-2.0F, -2.25F, -2.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.25F, -4.0F, 0.1309F, 0.0F, 0.0F));
        PartDefinition rCheekFur_r1 = head.addOrReplaceChild("rCheekFur_r1", CubeListBuilder.create().texOffs(0, 56).mirror().addBox(-3.25F, -0.75F, 0.0F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 0.3927F, -0.4363F));
        PartDefinition lCheekFur_r1 = head.addOrReplaceChild("lCheekFur_r1", CubeListBuilder.create().texOffs(0, 56).addBox(-0.75F, -0.75F, 0.0F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, 0.0F, -0.3927F, 0.4363F));
        PartDefinition muzzle = head.addOrReplaceChild("muzzle", CubeListBuilder.create().texOffs(19, 49).addBox(-1.0F, -0.5F, -2.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.25F, -2.0F, 0.1745F, 0.0F, 0.0F));
        PartDefinition mUpperFang_r1 = muzzle.addOrReplaceChild("mUpperFang_r1", CubeListBuilder.create().texOffs(13, 56).mirror().addBox(-0.5F, -0.5F, 0.05F, 2.0F, 1.0F, 0.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 1.0F, -2.25F, -0.0873F, 0.0F, 0.0F));
        PartDefinition rUpperFang_r1 = muzzle.addOrReplaceChild("rUpperFang_r1", CubeListBuilder.create().texOffs(9, 56).mirror().addBox(-0.5F, -0.25F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 1.0F, -2.25F, 0.0F, 1.5708F, 0.0F));
        PartDefinition lUpperFang_r1 = muzzle.addOrReplaceChild("lUpperFang_r1", CubeListBuilder.create().texOffs(9, 56).addBox(-0.5F, -0.25F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.5F, 1.0F, -2.25F, 0.0F, -1.5708F, 0.0F));
        PartDefinition rLip_r1 = muzzle.addOrReplaceChild("rLip_r1", CubeListBuilder.create().texOffs(5, 59).mirror().addBox(-1.4F, 0.25F, -2.35F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1309F, -0.1745F, 0.0F));
        PartDefinition lLip_r1 = muzzle.addOrReplaceChild("lLip_r1", CubeListBuilder.create().texOffs(5, 59).addBox(0.4F, 0.25F, -2.35F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1309F, 0.1745F, 0.0F));
        PartDefinition lowerJaw = head.addOrReplaceChild("lowerJaw", CubeListBuilder.create().texOffs(19, 59).addBox(-1.0F, 0.0F, -2.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(-0.2F)).texOffs(9, 56).addBox(-0.1F, -0.5F, -2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.2F)).texOffs(9, 56).mirror().addBox(-0.9F, -0.5F, -2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offset(0.5F, 1.25F, -2.0F));
        PartDefinition lEar01 = head.addOrReplaceChild("lEar01", CubeListBuilder.create().texOffs(31, 50).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.25F, -1.5F, 0.0F, 0.0F, -0.0873F, 0.2182F));
        PartDefinition lEar02 = lEar01.addOrReplaceChild("lEar02", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -0.75F, 0.1745F, 0.0F, 0.0F));
        PartDefinition cube_r1 = lEar02.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(31, 54).addBox(-0.25F, -3.5F, -0.25F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.829F, 0.0F));
        PartDefinition rEar01 = head.addOrReplaceChild("rEar01", CubeListBuilder.create().texOffs(31, 50).mirror().addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.25F, -1.5F, 0.0F, 0.0F, 0.0873F, -0.2182F));
        PartDefinition rEar02 = rEar01.addOrReplaceChild("rEar02", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -0.75F, 0.2182F, 0.0F, 0.0F));
        PartDefinition cube_r2 = rEar02.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(31, 54).mirror().addBox(-1.75F, -3.5F, -0.25F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.829F, 0.0F));
        PartDefinition lArm01 = body.addOrReplaceChild("lArm01", CubeListBuilder.create(), PartPose.offset(3.0F, 0.0F, -2.0F));
        PartDefinition cube_r3 = lArm01.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(46, 12).addBox(-1.5F, -1.5F, -2.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));
        PartDefinition lArm02 = lArm01.addOrReplaceChild("lArm02", CubeListBuilder.create(), PartPose.offset(0.0F, 4.5F, 0.0F));
        PartDefinition cube_r4 = lArm02.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(46, 22).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));
        PartDefinition lForePaw = lArm02.addOrReplaceChild("lForePaw", CubeListBuilder.create().texOffs(27, 40).addBox(-1.45F, -0.2F, -2.2F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.75F, -0.25F, -0.0087F, 0.0F, 0.0F));
        PartDefinition rArm01 = body.addOrReplaceChild("rArm01", CubeListBuilder.create(), PartPose.offset(-3.0F, 0.0F, -2.0F));
        PartDefinition cube_r5 = rArm01.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(46, 12).mirror().addBox(-1.5F, -1.5F, -2.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));
        PartDefinition rArm02 = rArm01.addOrReplaceChild("rArm02", CubeListBuilder.create(), PartPose.offset(0.0F, 4.5F, 0.0F));
        PartDefinition cube_r6 = rArm02.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(46, 22).mirror().addBox(-1.0F, -1.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));
        PartDefinition rForePaw = rArm02.addOrReplaceChild("rForePaw", CubeListBuilder.create().texOffs(27, 40).mirror().addBox(-1.55F, -0.2F, -2.2F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.75F, -0.25F, -0.0087F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float tailRot, float netHeadYaw, float headPitch) {
        this.quadriped(lHindLeg01, lArm01, rHindLeg01, rArm01, limbSwing * 0.8665F, limbSwingAmount * 0.9F);
        this.headPitch(head, headPitch);
        this.headYaw(head, netHeadYaw);
        this.rUpperFang_r1.visible = this.lUpperFang_r1.visible = true;
        this.lowerJaw.xRot = 0F;
        this.tail01.yRot = 0.0F;
        if (entity instanceof EntityCoyote) {
            EntityCoyote wolf = (EntityCoyote) entity;
            if (!wolf.isTame()) {
                this.tail01.yRot = 0.0F;
            } else {
                this.tail01.yRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
            }
            if (wolf.isInSittingPose()) {
                this.sitPose();
            } else {
                this.resetSitPose();
                if(wolf.isTame()) {
                    this.tail01.xRot = tailRot + 0.6981F;
                }
            }
            boolean hostile = !wolf.isTame() && (!wolf.isDaytime() || wolf.isHostileDaytime());
            this.rUpperFang_r1.visible = this.lUpperFang_r1.visible = hostile;
            this.lowerJaw.xRot = hostile ? rad(45F) : 0F;
        }
    }

    public void sitPose() {
        this.setRotateAngle(body, -0.7854F, 0.0F, 0.0F);
        this.setRotateAngle(lArm01, 0.5672F, 0.0F, 0.0F);
        this.setRotateAngle(lForePaw, 0.2094F, 0.0F, 0.0F);
        this.setRotateAngle(lHindLeg01, -0.8203F, -0.1745F, -0.5323F);
        this.setRotateAngle(lHindLeg02, 0.6981F, 0.0F, 0.0F);
        this.setRotateAngle(lHindLeg03, -0.3491F, 0.0F, 0.096F);
        this.setRotateAngle(lHindPaw, 1.5621F, 0.0F, 0.0F);
        this.setRotateAngle(neck, 0.5672F, 0.0F, 0.0F);
        this.setRotateAngle(rArm01, 0.5672F, 0.0F, 0.0F);
        this.setRotateAngle(rForePaw, 0.2094F, 0.0F, 0.0F);
        this.setRotateAngle(rHindLeg01, -0.8203F, 0.1745F, 0.5323F);
        this.setRotateAngle(rHindLeg02, 0.6981F, 0.0F, 0.0F);
        this.setRotateAngle(rHindLeg03, -0.3491F, 0.0F, -0.096F);
        this.setRotateAngle(rHindPaw, 1.5621F, 0.0F, 0.0F);
        this.setRotateAngle(stomach, -0.2618F, 0.0F, 0.0F);
        tail01.xRot = 2.6616F;
        head.xRot += rad(10F);
        body.setPos(0.0F, 15.5F, -2.0F);
        lForePaw.setPos(0.0F, 5.25F, -0.25F);
        rForePaw.setPos(0.0F, 5.25F, -0.25F);
        lHindPaw.setPos(-0.05F, 4.0F, -0.5F);
        rHindPaw.setPos(0.05F, 4.0F, -0.5F);
    }

    public void resetSitPose() {
        this.setRotateAngle(body, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lForePaw, -0.0087F, 0.0F, 0.0F);
        this.lHindLeg01.yRot = -0.0436F;
        this.lHindLeg01.zRot = -0.096F;
        this.setRotateAngle(lHindLeg02, -0.2618F, 0.0F, 0.0F);
        this.setRotateAngle(lHindLeg03, 0.5236F, 0.0F, 0.096F);
        this.setRotateAngle(lHindPaw, 0.1222F, 0.0F, 0.0F);
        this.setRotateAngle(neck, -0.1309F, 0.0F, 0.0F);
        this.setRotateAngle(rForePaw, -0.0087F, 0.0F, 0.0F);
        this.rHindLeg01.yRot = 0.0436F;
        this.rHindLeg01.zRot = 0.096F;
        this.setRotateAngle(rHindLeg02, -0.2618F, 0.0F, 0.0F);
        this.setRotateAngle(rHindLeg03, 0.5236F, 0.0F, -0.096F);
        this.setRotateAngle(rHindPaw, 0.1222F, 0.0F, 0.0F);
        this.setRotateAngle(stomach, 0.0F, 0.0F, 0.0F);
        tail01.xRot = 0.6981F;
        body.setPos(0.0F, 13.25F, -2.0F);
        lForePaw.setPos(0.0F, 5.75F, -0.25F);
        rForePaw.setPos(0.0F, 5.75F, -0.25F);
        lHindPaw.setPos(-0.05F, 4.0F, -0.5F);
        rHindPaw.setPos(0.05F, 4.0F, -0.5F);
    }

}
