package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import dev.itsmeow.betteranimalsplus.common.entity.EntityPheasant;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;

public class ModelPheasant<T extends LivingEntity> extends ModelBAP<T> {

    public ModelPart body;
    public ModelPart tail01;
    public ModelPart tail01Feathers;
    public ModelPart lTailFeather01;
    public ModelPart lTailFeather01b;
    public ModelPart rTailFeather01;
    public ModelPart rTailFeather01b;
    public ModelPart lTailFeather02;
    public ModelPart rTailFeather02;
    public ModelPart lTailFeather03;
    public ModelPart rTailFeather03;
    public ModelPart lTailFeather04;
    public ModelPart rTailFeather04;
    public ModelPart lLeg01;
    public ModelPart lLeg02;
    public ModelPart lClaw01;
    public ModelPart lClaw02;
    public ModelPart lClaw03;
    public ModelPart lClaw04;
    public ModelPart rLeg01;
    public ModelPart rLeg02;
    public ModelPart rClaw01;
    public ModelPart rClaw02;
    public ModelPart rClaw03;
    public ModelPart rClaw04;
    public ModelPart neck01;
    public ModelPart neck02;
    public ModelPart head;
    public ModelPart beak01;
    public ModelPart beak02;
    public ModelPart lWing01;
    public ModelPart lWing02;
    public ModelPart lWingFeathers;
    public ModelPart rWing01;
    public ModelPart rWing02;
    public ModelPart rWingFeathers;

    public ModelPheasant(ModelPart root) {
        this.body = root.getChild("body");
        this.tail01 = body.getChild("tail01");
        this.tail01Feathers = tail01.getChild("tail01Feathers");
        this.lTailFeather01 = tail01.getChild("lTailFeather01");
        this.lTailFeather01b = lTailFeather01.getChild("lTailFeather01b");
        this.rTailFeather01 = tail01.getChild("rTailFeather01");
        this.rTailFeather01b = rTailFeather01.getChild("rTailFeather01b");
        this.lTailFeather02 = tail01.getChild("lTailFeather02");
        this.rTailFeather02 = tail01.getChild("rTailFeather02");
        this.lTailFeather03 = tail01.getChild("lTailFeather03");
        this.rTailFeather03 = tail01.getChild("rTailFeather03");
        this.lTailFeather04 = tail01.getChild("lTailFeather04");
        this.rTailFeather04 = tail01.getChild("rTailFeather04");
        this.lLeg01 = body.getChild("lLeg01");
        this.lLeg02 = lLeg01.getChild("lLeg02");
        this.lClaw01 = lLeg02.getChild("lClaw01");
        this.lClaw02 = lLeg02.getChild("lClaw02");
        this.lClaw03 = lLeg02.getChild("lClaw03");
        this.lClaw04 = lLeg02.getChild("lClaw04");
        this.rLeg01 = body.getChild("rLeg01");
        this.rLeg02 = rLeg01.getChild("rLeg02");
        this.rClaw01 = rLeg02.getChild("rClaw01");
        this.rClaw02 = rLeg02.getChild("rClaw02");
        this.rClaw03 = rLeg02.getChild("rClaw03");
        this.rClaw04 = rLeg02.getChild("rClaw04");
        this.neck01 = body.getChild("neck01");
        this.neck02 = neck01.getChild("neck02");
        this.head = neck02.getChild("head");
        this.beak01 = head.getChild("beak01");
        this.beak02 = beak01.getChild("beak02");
        this.lWing01 = body.getChild("lWing01");
        this.lWing02 = lWing01.getChild("lWing02");
        this.lWingFeathers = lWing02.getChild("lWingFeathers");
        this.rWing01 = body.getChild("rWing01");
        this.rWing02 = rWing01.getChild("rWing02");
        this.rWingFeathers = rWing02.getChild("rWingFeathers");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -3.0F, -4.0F, 5.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.7F, 0.0F, -0.1396F, 0.0F, 0.0F));
        PartDefinition tail01 = body.addOrReplaceChild("tail01", CubeListBuilder.create().texOffs(19, 0).addBox(-2.5F, -1.0F, 0.0F, 5.0F, 2.0F, 5.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -1.8F, 3.6F, 0.0524F, 0.0F, 0.0F));
        PartDefinition tail01Feathers = tail01.addOrReplaceChild("tail01Feathers", CubeListBuilder.create().texOffs(44, 1).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.7F, -0.1F, 0.1222F, 0.0F, 0.0F));
        PartDefinition lTailFeather01 = tail01.addOrReplaceChild("lTailFeather01", CubeListBuilder.create().texOffs(42, 25).addBox(-1.2F, 0.0F, 0.0F, 3.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9F, -0.6F, 4.3F, 0.0F, 0.0698F, 0.0F));
        PartDefinition lTailFeather01b = lTailFeather01.addOrReplaceChild("lTailFeather01b", CubeListBuilder.create().texOffs(42, 18).addBox(-1.25F, 0.0F, 0.0F, 2.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 6.8F, 0.0873F, 0.0F, 0.0F));
        PartDefinition rTailFeather01 = tail01.addOrReplaceChild("rTailFeather01", CubeListBuilder.create().texOffs(42, 25).mirror().addBox(-1.8F, 0.0F, 0.0F, 3.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.9F, -0.6F, 4.3F, 0.0F, -0.0698F, 0.0F));
        PartDefinition rTailFeather01b = rTailFeather01.addOrReplaceChild("rTailFeather01b", CubeListBuilder.create().texOffs(42, 18).mirror().addBox(-1.75F, 0.0F, 0.0F, 2.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 0.0F, 6.8F, 0.0873F, 0.0F, 0.0F));
        PartDefinition lTailFeather02 = tail01.addOrReplaceChild("lTailFeather02", CubeListBuilder.create().texOffs(50, 25).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -0.3F, 4.4F, 0.0F, 0.2618F, 0.0F));
        PartDefinition rTailFeather02 = tail01.addOrReplaceChild("rTailFeather02", CubeListBuilder.create().texOffs(50, 25).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -0.3F, 4.4F, 0.0F, -0.2618F, 0.0F));
        PartDefinition lTailFeather03 = tail01.addOrReplaceChild("lTailFeather03", CubeListBuilder.create().texOffs(51, 18).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8F, 0.1F, 3.5F, 0.0F, 0.5236F, 0.0F));
        PartDefinition rTailFeather03 = tail01.addOrReplaceChild("rTailFeather03", CubeListBuilder.create().texOffs(51, 18).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.8F, 0.1F, 3.5F, 0.0F, -0.5236F, 0.0F));
        PartDefinition lTailFeather04 = tail01.addOrReplaceChild("lTailFeather04", CubeListBuilder.create().texOffs(51, 18).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.3F, 2.7F, 0.0F, 0.6283F, 0.0F));
        PartDefinition rTailFeather04 = tail01.addOrReplaceChild("rTailFeather04", CubeListBuilder.create().texOffs(51, 18).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 0.3F, 2.7F, 0.0F, -0.6283F, 0.0F));
        PartDefinition lLeg01 = body.addOrReplaceChild("lLeg01", CubeListBuilder.create().texOffs(0, 15).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8F, 2.6F, 2.7F, 0.2094F, 0.0F, 0.0F));
        PartDefinition lLeg02 = lLeg01.addOrReplaceChild("lLeg02", CubeListBuilder.create().texOffs(9, 14).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.6F, 0.0F, -0.2094F, 0.0F, 0.0F));
        PartDefinition lClaw01 = lLeg02.addOrReplaceChild("lClaw01", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.5F, -2.5F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.1F, -0.5F, 0.2443F, 0.0F, 0.0F));
        PartDefinition lClaw02 = lLeg02.addOrReplaceChild("lClaw02", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.5F, -2.5F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 3.2F, -0.2F, 0.1571F, -0.3491F, 0.0F));
        PartDefinition lClaw03 = lLeg02.addOrReplaceChild("lClaw03", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.5F, -2.5F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 3.2F, -0.2F, 0.1571F, 0.3491F, 0.0F));
        PartDefinition lClaw04 = lLeg02.addOrReplaceChild("lClaw04", CubeListBuilder.create().texOffs(0, 19).addBox(-0.5F, 0.5F, -0.5F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 0.2F));
        PartDefinition rLeg01 = body.addOrReplaceChild("rLeg01", CubeListBuilder.create().texOffs(0, 15).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.8F, 2.6F, 2.7F, 0.2094F, 0.0F, 0.0F));
        PartDefinition rLeg02 = rLeg01.addOrReplaceChild("rLeg02", CubeListBuilder.create().texOffs(9, 14).mirror().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.6F, 0.0F, -0.2094F, 0.0F, 0.0F));
        PartDefinition rClaw01 = rLeg02.addOrReplaceChild("rClaw01", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.5F, 0.5F, -2.5F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.1F, -0.5F, 0.2443F, 0.0F, 0.0F));
        PartDefinition rClaw02 = rLeg02.addOrReplaceChild("rClaw02", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.5F, 0.5F, -2.5F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 3.2F, -0.2F, 0.1571F, 0.3491F, 0.0F));
        PartDefinition rClaw03 = rLeg02.addOrReplaceChild("rClaw03", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.5F, 0.5F, -2.5F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, 3.2F, -0.2F, 0.1571F, -0.3491F, 0.0F));
        PartDefinition rClaw04 = rLeg02.addOrReplaceChild("rClaw04", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-0.5F, 0.5F, -0.5F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 3.0F, 0.2F));
        PartDefinition neck01 = body.addOrReplaceChild("neck01", CubeListBuilder.create().texOffs(13, 15).addBox(-2.0F, -2.0F, -3.2F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.6F, -2.7F, -0.9076F, 0.0F, 0.0F));
        PartDefinition neck02 = neck01.addOrReplaceChild("neck02", CubeListBuilder.create().texOffs(0, 24).addBox(-1.5F, -1.5F, -2.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.1F, -2.7F, -0.0349F, 0.0F, 0.0F));
        PartDefinition head = neck02.addOrReplaceChild("head", CubeListBuilder.create().texOffs(27, 7).addBox(-1.5F, -2.1F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 0.3F, -3.1F, -0.4538F, 0.0F, 0.0F));
        PartDefinition beak01 = head.addOrReplaceChild("beak01", CubeListBuilder.create().texOffs(53, 12).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 1.7F, 0.0F, 0.2094F, 0.0F, 0.0F));
        PartDefinition beak02 = beak01.addOrReplaceChild("beak02", CubeListBuilder.create().texOffs(58, 0).addBox(-1.0F, -0.7F, -0.7F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.2F, 0.0F));
        PartDefinition lWing01 = body.addOrReplaceChild("lWing01", CubeListBuilder.create().texOffs(25, 18).mirror().addBox(0.0F, -0.5F, -1.0F, 7.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, -1.4F, -2.1F, 0.0F, -1.3526F, 0.0F));
        PartDefinition lWing02 = lWing01.addOrReplaceChild("lWing02", CubeListBuilder.create().texOffs(30, 14).mirror().addBox(-0.25F, -0.51F, -0.5F, 6.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.4F, 0.0F, -0.3F, 0.0F, -0.5672F, 0.0F));
        PartDefinition lWingFeathers = lWing02.addOrReplaceChild("lWingFeathers", CubeListBuilder.create().texOffs(4, 24).addBox(-5.9F, -0.1F, -0.4F, 18.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition rWing01 = body.addOrReplaceChild("rWing01", CubeListBuilder.create().texOffs(25, 18).addBox(-7.0F, -0.5F, -1.0F, 7.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -1.4F, -2.1F, 0.0F, 1.3526F, 0.0F));
        PartDefinition rWing02 = rWing01.addOrReplaceChild("rWing02", CubeListBuilder.create().texOffs(30, 14).addBox(-5.75F, -0.51F, -0.5F, 6.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.4F, 0.0F, -0.3F, 0.0F, 0.5672F, 0.0F));
        PartDefinition rWingFeathers = rWing02.addOrReplaceChild("rWingFeathers", CubeListBuilder.create().texOffs(4, 24).mirror().addBox(-12.1F, -0.1F, -0.4F, 18.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.headPitch(neck01, headPitch);
        this.headYaw(neck01, netHeadYaw);
        if (entityIn instanceof EntityPheasant) {
            EntityPheasant ent = (EntityPheasant) entityIn;
            float peckTime = ent.getPeckTime();
            if (peckTime <= 60) {
                this.neck01.xRot = rad(peckTime % (60F / peckTime)) * 6F + rad(30F);
            }
        }
        this.biped(lLeg01, rLeg01, limbSwing * 0.6662F, limbSwingAmount * 1.4F);
        this.rWing01.zRot = ageInTicks - 0.4F;
        this.lWing01.zRot = -ageInTicks + 0.4F;
        this.rWing01.yRot = ageInTicks == 0 ? 1.3526F : 0;
        this.lWing01.yRot = -this.rWing01.yRot;
        this.lWingFeathers.visible = this.rWingFeathers.visible = ageInTicks > 0;
    }

}
