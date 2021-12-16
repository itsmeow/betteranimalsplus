package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import dev.itsmeow.betteranimalsplus.common.entity.EntityLammergeier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class ModelLammergeier<T extends EntityLammergeier> extends ModelBAP<T> {

    public ModelPart body;
    public ModelPart chest;
    public ModelPart neck;
    public ModelPart head;
    public ModelPart upperBeak;
    public ModelPart muzzle;
    public ModelPart lowerBeak;
    public ModelPart beard;
    public ModelPart headFeathers;
    public ModelPart neckFeather02;
    public ModelPart tail01;
    public ModelPart tail02;
    public ModelPart lTailFeather01;
    public ModelPart lTailFeather02;
    public ModelPart lTailFeather03;
    public ModelPart lTailFeather04;
    public ModelPart rTailFeather01;
    public ModelPart rTailFeather02;
    public ModelPart rTailFeather03;
    public ModelPart rTailFeather04;
    public ModelPart lLeg01;
    public ModelPart lLeg02;
    public ModelPart lFoot;
    public ModelPart lToe01;
    public ModelPart lToe02;
    public ModelPart lToe03;
    public ModelPart lToe04;
    public ModelPart lLegFeathers;
    public ModelPart rLeg01;
    public ModelPart rLeg02;
    public ModelPart rFoot;
    public ModelPart rToe01;
    public ModelPart rToe02;
    public ModelPart rToe03;
    public ModelPart rToe04;
    public ModelPart rLegFeathers;
    public ModelPart lWing01;
    public ModelPart lWing02;
    public ModelPart rWing01;
    public ModelPart rWing02;
    private boolean lastFlying = false;

    public ModelLammergeier(ModelPart root) {
        this.body = root.getChild("body");
        this.chest = body.getChild("chest");
        this.neck = chest.getChild("neck");
        this.head = neck.getChild("head");
        this.upperBeak = head.getChild("upperBeak");
        this.muzzle = upperBeak.getChild("muzzle");
        this.lowerBeak = head.getChild("lowerBeak");
        this.beard = lowerBeak.getChild("beard");
        this.headFeathers = head.getChild("headFeathers");
        this.neckFeather02 = chest.getChild("neckFeather02");
        this.tail01 = body.getChild("tail01");
        this.tail02 = tail01.getChild("tail02");
        this.lTailFeather01 = tail01.getChild("lTailFeather01");
        this.lTailFeather02 = tail01.getChild("lTailFeather02");
        this.lTailFeather03 = tail01.getChild("lTailFeather03");
        this.lTailFeather04 = tail01.getChild("lTailFeather04");
        this.rTailFeather01 = tail01.getChild("rTailFeather01");
        this.rTailFeather02 = tail01.getChild("rTailFeather02");
        this.rTailFeather03 = tail01.getChild("rTailFeather03");
        this.rTailFeather04 = tail01.getChild("rTailFeather04");
        this.lLeg01 = body.getChild("lLeg01");
        this.lLeg02 = lLeg01.getChild("lLeg02");
        this.lFoot = lLeg02.getChild("lFoot");
        this.lToe01 = lFoot.getChild("lToe01");
        this.lToe02 = lFoot.getChild("lToe02");
        this.lToe03 = lFoot.getChild("lToe03");
        this.lToe04 = lFoot.getChild("lToe04");
        this.lLegFeathers = lLeg01.getChild("lLegFeathers");
        this.rLeg01 = body.getChild("rLeg01");
        this.rLeg02 = rLeg01.getChild("rLeg02");
        this.rFoot = rLeg02.getChild("rFoot");
        this.rToe01 = rFoot.getChild("rToe01");
        this.rToe02 = rFoot.getChild("rToe02");
        this.rToe03 = rFoot.getChild("rToe03");
        this.rToe04 = rFoot.getChild("rToe04");
        this.rLegFeathers = rLeg01.getChild("rLegFeathers");
        this.lWing01 = body.getChild("lWing01");
        this.lWing02 = lWing01.getChild("lWing02");
        this.rWing01 = body.getChild("rWing01");
        this.rWing02 = rWing01.getChild("rWing02");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.8F, -0.5F, -0.2276F, 0.0F, 0.0F));
        PartDefinition chest = body.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(48, 0).addBox(-2.5F, -2.0F, -3.0F, 5.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, -2.3F, -0.3643F, 0.0F, 0.0F));
        PartDefinition neck = chest.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(36, 0).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.4F, -1.3F, -0.3643F, 0.0F, 0.0F));
        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(20, 0).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.3F, -3.1F, -0.3643F, 0.0F, 0.0F));
        PartDefinition upperBeak = head.addOrReplaceChild("upperBeak", CubeListBuilder.create().texOffs(36, 8).addBox(-1.0F, 0.0F, -0.2F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(50, 7).addBox(-0.5F, 2.5F, -0.25F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offset(0.0F, 1.8F, -1.1F));
        PartDefinition muzzle = upperBeak.addOrReplaceChild("muzzle", CubeListBuilder.create().texOffs(29, 8).addBox(-1.0F, 0.0F, -0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -0.1F, -0.7F, 0.3054F, 0.0F, 0.0F));
        PartDefinition lowerBeak = head.addOrReplaceChild("lowerBeak", CubeListBuilder.create().texOffs(43, 8).addBox(-1.0F, 0.1F, 0.25F, 2.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offset(0.0F, 1.5F, -0.8F));
        PartDefinition beard = lowerBeak.addOrReplaceChild("beard", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.95F, 0.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.5F, 0.75F, -0.1309F, 0.0F, 0.0F));
        PartDefinition headFeathers = head.addOrReplaceChild("headFeathers", CubeListBuilder.create().texOffs(16, 13).addBox(-1.5F, -2.25F, -1.2F, 3.0F, 2.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -1.05F, -1.05F, 0.48F, 0.0F, 0.0F));
        PartDefinition neckFeather02 = chest.addOrReplaceChild("neckFeather02", CubeListBuilder.create().texOffs(48, 52).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.3F, -2.4F, -0.5918F, 0.0F, 0.0F));
        PartDefinition tail01 = body.addOrReplaceChild("tail01", CubeListBuilder.create().texOffs(0, 13).addBox(-2.5F, -1.0F, 0.4F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.25F, 2.8F));
        PartDefinition tail02 = tail01.addOrReplaceChild("tail02", CubeListBuilder.create().texOffs(0, 24).addBox(-2.0F, -1.0F, 0.65F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.4F, 0.0F, 0.1745F, 0.0F, 0.0F));
        PartDefinition lTailFeather01 = tail01.addOrReplaceChild("lTailFeather01", CubeListBuilder.create().texOffs(15, 24).mirror().addBox(-1.0F, -0.1F, 0.4F, 2.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.2F, -0.15F, 2.9F, -0.0911F, 0.4554F, 0.0F));
        PartDefinition lTailFeather02 = tail01.addOrReplaceChild("lTailFeather02", CubeListBuilder.create().texOffs(15, 24).mirror().addBox(-1.0F, -2.2F, 0.4F, 2.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.2F, 2.05F, 3.8F, -0.0911F, 0.3187F, 0.0F));
        PartDefinition lTailFeather03 = tail01.addOrReplaceChild("lTailFeather03", CubeListBuilder.create().texOffs(15, 24).mirror().addBox(-1.0F, -2.05F, 0.4F, 2.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.2F, 2.0F, 4.5F, -0.0911F, 0.2731F, 0.0F));
        PartDefinition lTailFeather04 = tail01.addOrReplaceChild("lTailFeather04", CubeListBuilder.create().texOffs(15, 24).mirror().addBox(-1.0F, -1.9F, 0.4F, 2.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.95F, 5.2F, -0.0911F, 0.0911F, 0.0F));
        PartDefinition rTailFeather01 = tail01.addOrReplaceChild("rTailFeather01", CubeListBuilder.create().texOffs(15, 24).addBox(-1.0F, -2.35F, 0.4F, 2.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2F, 2.1F, 2.9F, -0.0911F, -0.4554F, 0.0F));
        PartDefinition rTailFeather02 = tail01.addOrReplaceChild("rTailFeather02", CubeListBuilder.create().texOffs(15, 24).addBox(-1.0F, -2.2F, 0.4F, 2.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2F, 2.05F, 3.8F, -0.0911F, -0.3187F, 0.0F));
        PartDefinition rTailFeather03 = tail01.addOrReplaceChild("rTailFeather03", CubeListBuilder.create().texOffs(15, 24).addBox(-1.0F, -2.05F, 0.4F, 2.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, 2.0F, 4.5F, -0.0911F, -0.2731F, 0.0F));
        PartDefinition rTailFeather04 = tail01.addOrReplaceChild("rTailFeather04", CubeListBuilder.create().texOffs(15, 24).addBox(-1.0F, -1.9F, 0.4F, 2.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.95F, 5.2F, -0.0911F, -0.0911F, 0.0F));
        PartDefinition lLeg01 = body.addOrReplaceChild("lLeg01", CubeListBuilder.create().texOffs(30, 13).addBox(0.0F, -0.5F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.6F, 2.2F, 0.1367F, 0.0F, 0.0F));
        PartDefinition lLeg02 = lLeg01.addOrReplaceChild("lLeg02", CubeListBuilder.create().texOffs(40, 19).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 4.3F, 0.1F, -0.0911F, 0.0F, 0.0F));
        PartDefinition lFoot = lLeg02.addOrReplaceChild("lFoot", CubeListBuilder.create().texOffs(22, 19).addBox(-0.99F, 0.0F, -1.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.8F, 0.0F, 0.1367F, 0.0F, 0.0F));
        PartDefinition lToe01 = lFoot.addOrReplaceChild("lToe01", CubeListBuilder.create().texOffs(0, 13).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.1F, -1.2F, 0.1367F, -0.3643F, 0.0F));
        PartDefinition lToe02 = lFoot.addOrReplaceChild("lToe02", CubeListBuilder.create().texOffs(0, 13).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.3F, 0.1367F, 0.0F, 0.0F));
        PartDefinition lToe03 = lFoot.addOrReplaceChild("lToe03", CubeListBuilder.create().texOffs(0, 13).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6F, 0.1F, -1.2F, 0.1367F, 0.3643F, 0.0F));
        PartDefinition lToe04 = lFoot.addOrReplaceChild("lToe04", CubeListBuilder.create().texOffs(0, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.3F, -0.1367F, 0.0F, 0.0F));
        PartDefinition lLegFeathers = lLeg01.addOrReplaceChild("lLegFeathers", CubeListBuilder.create().texOffs(42, 12).addBox(0.0F, 0.45F, -0.1F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 1.9F, -0.1F, 0.182F, 0.2731F, 0.0F));
        PartDefinition rLeg01 = body.addOrReplaceChild("rLeg01", CubeListBuilder.create().texOffs(30, 13).mirror().addBox(-3.0F, -0.5F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 0.6F, 2.2F, 0.1367F, 0.0F, 0.0F));
        PartDefinition rLeg02 = rLeg01.addOrReplaceChild("rLeg02", CubeListBuilder.create().texOffs(40, 19).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 4.3F, 0.1F, -0.0911F, 0.0F, 0.0F));
        PartDefinition rFoot = rLeg02.addOrReplaceChild("rFoot", CubeListBuilder.create().texOffs(22, 19).mirror().addBox(-1.01F, 0.0F, -1.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.8F, 0.0F, 0.1367F, 0.0F, 0.0F));
        PartDefinition rToe01 = rFoot.addOrReplaceChild("rToe01", CubeListBuilder.create().texOffs(0, 13).mirror().addBox(-0.5F, 0.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 0.1F, -1.2F, 0.1367F, 0.3643F, 0.0F));
        PartDefinition rToe02 = rFoot.addOrReplaceChild("rToe02", CubeListBuilder.create().texOffs(0, 13).mirror().addBox(-0.5F, 0.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -1.3F, 0.1367F, 0.0F, 0.0F));
        PartDefinition rToe03 = rFoot.addOrReplaceChild("rToe03", CubeListBuilder.create().texOffs(0, 13).mirror().addBox(-0.5F, 0.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.6F, 0.1F, -1.2F, 0.1367F, -0.3643F, 0.0F));
        PartDefinition rToe04 = rFoot.addOrReplaceChild("rToe04", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 1.3F, -0.1367F, 0.0F, 0.0F));
        PartDefinition rLegFeathers = rLeg01.addOrReplaceChild("rLegFeathers", CubeListBuilder.create().texOffs(42, 12).mirror().addBox(-1.0F, 0.45F, -0.1F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 1.9F, -0.1F, 0.182F, -0.2731F, 0.0F));
        PartDefinition lWing01 = body.addOrReplaceChild("lWing01", CubeListBuilder.create().texOffs(46, 10).mirror().addBox(0.0F, -0.5F, -1.5F, 6.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(39, 14).addBox(-1.0F, 0.0F, -1.0F, 8.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.75F, -1.7F, -1.7F, -0.0436F, -1.3526F, 0.0F));
        PartDefinition lWing02 = lWing01.addOrReplaceChild("lWing02", CubeListBuilder.create().texOffs(0, 21).mirror().addBox(-1.0F, -0.5F, -1.0F, 9.0F, 1.0F, 2.0F, new CubeDeformation(-0.01F)).mirror(false)
                .texOffs(21, 23).addBox(-2.0F, -0.1F, -1.0F, 17.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.45F, 0.0F, -0.5F, 0.0F, -0.6109F, 0.0F));
        PartDefinition rWing01 = body.addOrReplaceChild("rWing01", CubeListBuilder.create().texOffs(46, 10).addBox(-6.0F, -0.5F, -1.5F, 6.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(39, 14).mirror().addBox(-7.0F, 0.0F, -1.0F, 8.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.75F, -1.7F, -1.7F, -0.0436F, 1.3526F, 0.0F));
        PartDefinition rWing02 = rWing01.addOrReplaceChild("rWing02", CubeListBuilder.create().texOffs(0, 21).addBox(-8.0F, -0.5F, -1.0F, 9.0F, 1.0F, 2.0F, new CubeDeformation(-0.01F))
                .texOffs(21, 23).mirror().addBox(-15.0F, -0.1F, -1.0F, 17.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.45F, 0.0F, -0.5F, 0.0F, 0.6109F, 0.0F));
        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    public void switchToFlight() {
        setRotationAngle(lWing01, 0F, 0F, 0F);
        setRotationAngle(lWing02, 0F, 0F, 0F);
        setRotationAngle(rWing01, 0F, 0F, 0F);
        setRotationAngle(rWing02, 0F, 0F, 0F);
        setRotationAngleDeg(lLeg01, 95F, 0F, 0F);
        setRotationAngleDeg(rLeg01, 95F, 0F, 0F);
    }

    public void switchToWalk() {
        setRotationAngle(lWing01, -0.0436F, -1.3526F, 0.0F);
        setRotationAngle(lWing02, 0.0F, -0.6109F, 0.0F);
        setRotationAngle(rWing01, -0.0436F, 1.3526F, 0.0F);
        setRotationAngle(rWing02, 0.0F, 0.6109F, 0.0F);
        setRotationAngle(lLeg01, 0.1367F, 0.0F, 0.0F);
        setRotationAngle(rLeg01, 0.1367F, 0.0F, 0.0F);
        setRotationAngle(body, -0.2276F, 0.0F, 0.0F);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T lammergeier, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        if (lammergeier.getFlying()) {
            this.rWing01.zRot = Mth.cos(ageInTicks * 0.3F) * (float) Math.PI * 0.25F;

            if ((Math.abs(lammergeier.getDeltaMovement().y()) > 0 && (Math.abs(lammergeier.getDeltaMovement().x()) > 0.05 || Math.abs(lammergeier.getDeltaMovement().z()) > 0.05)) || Math.abs(lammergeier.getDeltaMovement().y()) > 0.25) {
                if (Math.abs(lammergeier.getDeltaMovement().y() + lammergeier.lastMotionY) > 0.05 && lammergeier.getDeltaMovement().y() < 0) {
                    this.rWing01.zRot = Mth.cos(225 * 0.3F) * (float) Math.PI * 0.25F;
                }
            }
            this.body.xRot = (float) Mth.clampedLerp(lammergeier.lastRotX, lammergeier.rotX, Minecraft.getInstance().getFrameTime());
            this.lWing01.zRot = -this.rWing01.zRot;
            this.rWing02.zRot = this.rWing01.zRot * 0.5F;
            this.lWing02.zRot = -this.rWing01.zRot * 0.5F;
            if (!this.lastFlying) {
                this.switchToFlight();
            }
            this.lastFlying = true;
        } else {
            if (this.lastFlying) {
                this.switchToWalk();
            }
            this.body.xRot = 0F;
            boolean flag = lammergeier.getFallFlyingTicks() > 4;
            float f = 1.0F;

            if (flag) {
                f = (float) (lammergeier.getDeltaMovement().x() * lammergeier.getDeltaMovement().x() + lammergeier.getDeltaMovement().y() * lammergeier.getDeltaMovement().y() + lammergeier.getDeltaMovement().z() * lammergeier.getDeltaMovement().z());
                f = f / 0.2F;
                f = f * f * f;
            }

            if (f < 1.0F) {
                f = 1.0F;
            }

            this.rLeg01.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
            this.lLeg01.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount / f;
            this.lastFlying = false;
        }

        if (lammergeier.isInSittingPose()) {
            this.head.xRot = 0.15F;
        } else {
            this.head.xRot = -0.3643F;
        }
    }

}
