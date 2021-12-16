package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;

public class ModelBadger<T extends LivingEntity> extends ModelBAP<T> {

    public ModelPart lowerBack;
    public ModelPart front;
    public ModelPart neck;
    public ModelPart head;
    public ModelPart topjaw;
    public ModelPart snout;
    public ModelPart lowerjaw;
    public ModelPart lEar;
    public ModelPart rEar;
    public ModelPart lArm01;
    public ModelPart lArm02;
    public ModelPart lForepaw;
    public ModelPart lClaw01;
    public ModelPart lClaw02;
    public ModelPart lClaw03;
    public ModelPart lClaw04;
    public ModelPart rArm01;
    public ModelPart rArm02;
    public ModelPart rForepaw;
    public ModelPart rClaw01;
    public ModelPart rClaw02;
    public ModelPart rClaw03;
    public ModelPart rClaw04;
    public ModelPart lLeg01;
    public ModelPart lLeg02;
    public ModelPart lLeg03;
    public ModelPart lFoot;
    public ModelPart lHindClaw01;
    public ModelPart lHindClaw02;
    public ModelPart lHindClaw03;
    public ModelPart lHindClaw04;
    public ModelPart rLeg01;
    public ModelPart rLeg02;
    public ModelPart rLeg03;
    public ModelPart rFoot;
    public ModelPart rHindClaw01;
    public ModelPart rHindClaw02;
    public ModelPart rHindClaw03;
    public ModelPart rHindClaw04;
    public ModelPart tail;
    public ModelPart tail2;
    public ModelPart tailfloof;

    public ModelBadger(ModelPart root) {
        this.lowerBack = root.getChild("lowerBack");
        this.front = lowerBack.getChild("front");
        this.neck = front.getChild("neck");
        this.head = neck.getChild("head");
        this.topjaw = head.getChild("topjaw");
        this.snout = topjaw.getChild("snout");
        this.lowerjaw = head.getChild("lowerjaw");
        this.lEar = head.getChild("lEar");
        this.rEar = head.getChild("rEar");
        this.lArm01 = front.getChild("lArm01");
        this.lArm02 = lArm01.getChild("lArm02");
        this.lForepaw = lArm02.getChild("lForepaw");
        this.lClaw01 = lForepaw.getChild("lClaw01");
        this.lClaw02 = lForepaw.getChild("lClaw02");
        this.lClaw03 = lForepaw.getChild("lClaw03");
        this.lClaw04 = lForepaw.getChild("lClaw04");
        this.rArm01 = front.getChild("rArm01");
        this.rArm02 = rArm01.getChild("rArm02");
        this.rForepaw = rArm02.getChild("rForepaw");
        this.rClaw01 = rForepaw.getChild("rClaw01");
        this.rClaw02 = rForepaw.getChild("rClaw02");
        this.rClaw03 = rForepaw.getChild("rClaw03");
        this.rClaw04 = rForepaw.getChild("rClaw04");
        this.lLeg01 = lowerBack.getChild("lLeg01");
        this.lLeg02 = lLeg01.getChild("lLeg02");
        this.lLeg03 = lLeg02.getChild("lLeg03");
        this.lFoot = lLeg03.getChild("lFoot");
        this.lHindClaw01 = lFoot.getChild("lHindClaw01");
        this.lHindClaw02 = lFoot.getChild("lHindClaw02");
        this.lHindClaw03 = lFoot.getChild("lHindClaw03");
        this.lHindClaw04 = lFoot.getChild("lHindClaw04");
        this.rLeg01 = lowerBack.getChild("rLeg01");
        this.rLeg02 = rLeg01.getChild("rLeg02");
        this.rLeg03 = rLeg02.getChild("rLeg03");
        this.rFoot = rLeg03.getChild("rFoot");
        this.rHindClaw01 = rFoot.getChild("rHindClaw01");
        this.rHindClaw02 = rFoot.getChild("rHindClaw02");
        this.rHindClaw03 = rFoot.getChild("rHindClaw03");
        this.rHindClaw04 = rFoot.getChild("rHindClaw04");
        this.tail = lowerBack.getChild("tail");
        this.tail2 = tail.getChild("tail2");
        this.tailfloof = tail2.getChild("tailfloof");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition lowerBack = partdefinition.addOrReplaceChild("lowerBack", CubeListBuilder.create().texOffs(0, 15).addBox(-4.5F, -4.7F, 0.0F, 9.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.5F, -1.0F, -0.0456F, 0.0F, 0.0F));
        PartDefinition front = lowerBack.addOrReplaceChild("front", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -10.0F, 8.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 3.4F, 0.0911F, 0.0F, 0.0F));
        PartDefinition neck = front.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 34).addBox(-3.0F, -3.0F, -4.0F, 6.0F, 6.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, -0.7F, -9.0F, -0.182F, 0.0F, 0.0F));
        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 45).addBox(-3.0F, -3.0F, -5.5F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2F, -3.15F, 0.3187F, 0.0F, 0.0F));
        PartDefinition topjaw = head.addOrReplaceChild("topjaw", CubeListBuilder.create().texOffs(24, 49).addBox(-2.0F, 0.0F, -4.5F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.1F, -4.45F));
        PartDefinition snout = topjaw.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(23, 41).addBox(-1.5F, 0.0F, -0.5F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.6F, 0.2276F, 0.0F, 0.0F));
        PartDefinition lowerjaw = head.addOrReplaceChild("lowerjaw", CubeListBuilder.create().texOffs(26, 56).addBox(-1.5F, -0.5F, -3.5F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 1.4F, -5.3F, -0.1367F, 0.0F, 0.0F));
        PartDefinition lEar = head.addOrReplaceChild("lEar", CubeListBuilder.create().texOffs(0, 59).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3F, -1.65F, -1.25F, -0.7854F, 0.7418F, 0.2793F));
        PartDefinition rEar = head.addOrReplaceChild("rEar", CubeListBuilder.create().texOffs(0, 59).mirror().addBox(-0.5F, -2.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.3F, -1.65F, -1.25F, -0.7854F, -0.7418F, -0.2793F));
        PartDefinition lArm01 = front.addOrReplaceChild("lArm01", CubeListBuilder.create().texOffs(33, 0).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.3F, 0.6F, -7.5F, 0.2276F, 0.0F, 0.0F));
        PartDefinition lArm02 = lArm01.addOrReplaceChild("lArm02", CubeListBuilder.create().texOffs(35, 8).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.5F, 0.25F, -0.3643F, 0.0F, 0.0F));
        PartDefinition lForepaw = lArm02.addOrReplaceChild("lForepaw", CubeListBuilder.create().texOffs(37, 15).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 3.8F, 0.0F, 0.0911F, 0.0F, 0.0F));
        PartDefinition lClaw01 = lForepaw.addOrReplaceChild("lClaw01", CubeListBuilder.create().texOffs(37, 18).addBox(0.0F, -0.5F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9F, 0.5F, -1.2F, 0.182F, 0.0873F, 0.0F));
        PartDefinition lClaw02 = lForepaw.addOrReplaceChild("lClaw02", CubeListBuilder.create().texOffs(37, 18).addBox(0.0F, -0.5F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9F, 0.5F, -1.2F, 0.182F, -0.0873F, 0.0F));
        PartDefinition lClaw03 = lForepaw.addOrReplaceChild("lClaw03", CubeListBuilder.create().texOffs(37, 18).addBox(0.0F, -0.5F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, 0.5F, -1.7F, 0.182F, 0.0F, 0.0F));
        PartDefinition lClaw04 = lForepaw.addOrReplaceChild("lClaw04", CubeListBuilder.create().texOffs(37, 18).addBox(0.0F, -0.5F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, 0.5F, -1.7F, 0.182F, 0.0F, 0.0F));
        PartDefinition rArm01 = front.addOrReplaceChild("rArm01", CubeListBuilder.create().texOffs(33, 0).mirror().addBox(-1.5F, -1.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.3F, 0.6F, -7.5F, 0.2276F, 0.0F, 0.0F));
        PartDefinition rArm02 = rArm01.addOrReplaceChild("rArm02", CubeListBuilder.create().texOffs(35, 8).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.5F, 0.25F, -0.3643F, 0.0F, 0.0F));
        PartDefinition rForepaw = rArm02.addOrReplaceChild("rForepaw", CubeListBuilder.create().texOffs(37, 15).mirror().addBox(-1.0F, 0.0F, -2.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.8F, 0.0F, 0.0911F, 0.0F, 0.0F));
        PartDefinition rClaw01 = rForepaw.addOrReplaceChild("rClaw01", CubeListBuilder.create().texOffs(37, 18).mirror().addBox(0.0F, -0.5F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.9F, 0.5F, -1.2F, 0.182F, -0.0873F, 0.0F));
        PartDefinition rClaw02 = rForepaw.addOrReplaceChild("rClaw02", CubeListBuilder.create().texOffs(37, 18).mirror().addBox(0.0F, -0.5F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.9F, 0.5F, -1.2F, 0.182F, 0.0873F, 0.0F));
        PartDefinition rClaw03 = rForepaw.addOrReplaceChild("rClaw03", CubeListBuilder.create().texOffs(37, 18).mirror().addBox(0.0F, -0.5F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.25F, 0.5F, -1.7F, 0.182F, 0.0F, 0.0F));
        PartDefinition rClaw04 = rForepaw.addOrReplaceChild("rClaw04", CubeListBuilder.create().texOffs(37, 18).mirror().addBox(0.0F, -0.5F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.25F, 0.5F, -1.7F, 0.182F, 0.0F, 0.0F));
        PartDefinition lLeg01 = lowerBack.addOrReplaceChild("lLeg01", CubeListBuilder.create().texOffs(46, 0).addBox(-2.0F, -1.5F, -2.5F, 4.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, -1.2F, 6.0F));
        PartDefinition lLeg02 = lLeg01.addOrReplaceChild("lLeg02", CubeListBuilder.create().texOffs(50, 12).addBox(-1.5F, -0.75F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, 4.7F, -0.6F, 0.5843F, 0.0F, 0.0F));
        PartDefinition lLeg03 = lLeg02.addOrReplaceChild("lLeg03", CubeListBuilder.create().texOffs(52, 19).addBox(-1.0F, 2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.05F, 0.85F, -0.5009F, 0.0F, 0.0F));
        PartDefinition lFoot = lLeg03.addOrReplaceChild("lFoot", CubeListBuilder.create().texOffs(37, 15).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 3.3F, 0.0F, -0.0436F, 0.0F, 0.0F));
        PartDefinition lHindClaw01 = lFoot.addOrReplaceChild("lHindClaw01", CubeListBuilder.create().texOffs(37, 18).addBox(0.0F, -0.5F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9F, 0.5F, -1.2F, 0.182F, 0.0873F, 0.0F));
        PartDefinition lHindClaw02 = lFoot.addOrReplaceChild("lHindClaw02", CubeListBuilder.create().texOffs(37, 18).addBox(0.0F, -0.5F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9F, 0.5F, -1.2F, 0.182F, -0.0873F, 0.0F));
        PartDefinition lHindClaw03 = lFoot.addOrReplaceChild("lHindClaw03", CubeListBuilder.create().texOffs(37, 18).addBox(0.0F, -0.5F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, 0.5F, -1.7F, 0.182F, 0.0F, 0.0F));
        PartDefinition lHindClaw04 = lFoot.addOrReplaceChild("lHindClaw04", CubeListBuilder.create().texOffs(37, 18).addBox(0.0F, -0.5F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, 0.5F, -1.7F, 0.182F, 0.0F, 0.0F));
        PartDefinition rLeg01 = lowerBack.addOrReplaceChild("rLeg01", CubeListBuilder.create().texOffs(46, 0).mirror().addBox(-2.0F, -1.5F, -2.5F, 4.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.5F, -1.2F, 6.0F));
        PartDefinition rLeg02 = rLeg01.addOrReplaceChild("rLeg02", CubeListBuilder.create().texOffs(50, 12).mirror().addBox(-1.5F, -0.75F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.25F, 4.7F, -0.6F, 0.5843F, 0.0F, 0.0F));
        PartDefinition rLeg03 = rLeg02.addOrReplaceChild("rLeg03", CubeListBuilder.create().texOffs(52, 19).mirror().addBox(-1.0F, 2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.05F, 0.85F, -0.5009F, 0.0F, 0.0F));
        PartDefinition rFoot = rLeg03.addOrReplaceChild("rFoot", CubeListBuilder.create().texOffs(37, 15).mirror().addBox(-1.0F, 0.0F, -2.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.3F, 0.0F, -0.0436F, 0.0F, 0.0F));
        PartDefinition rHindClaw01 = rFoot.addOrReplaceChild("rHindClaw01", CubeListBuilder.create().texOffs(37, 18).mirror().addBox(0.0F, -0.5F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.9F, 0.5F, -1.2F, 0.182F, -0.0873F, 0.0F));
        PartDefinition rHindClaw02 = rFoot.addOrReplaceChild("rHindClaw02", CubeListBuilder.create().texOffs(37, 18).mirror().addBox(0.0F, -0.5F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.9F, 0.5F, -1.2F, 0.182F, 0.0873F, 0.0F));
        PartDefinition rHindClaw03 = rFoot.addOrReplaceChild("rHindClaw03", CubeListBuilder.create().texOffs(37, 18).mirror().addBox(0.0F, -0.5F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.25F, 0.5F, -1.7F, 0.182F, 0.0F, 0.0F));
        PartDefinition rHindClaw04 = rFoot.addOrReplaceChild("rHindClaw04", CubeListBuilder.create().texOffs(37, 18).mirror().addBox(0.0F, -0.5F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.25F, 0.5F, -1.7F, 0.182F, 0.0F, 0.0F));
        PartDefinition tail = lowerBack.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(40, 26).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -4.0F, 9.1F, -1.0472F, 0.0F, 0.0F));
        PartDefinition tail2 = tail.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(40, 26).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.55F, 0.2276F, 0.0F, 0.0F));
        PartDefinition tailfloof = tail2.addOrReplaceChild("tailfloof", CubeListBuilder.create().texOffs(39, 34).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 1.35F, 0.5F, 0.2618F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.lowerBack.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.quadriped(lLeg01, lArm01, rLeg01, rArm01, limbSwing * 0.8665F, limbSwingAmount * 1.5F);
    }

}