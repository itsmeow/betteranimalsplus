package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import dev.itsmeow.betteranimalsplus.common.entity.EntityOctopus;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

/**
 * octopus - Batman, Cybercat5555 Created using Tabula 7.1.0
 */
public class ModelOctopus<T extends EntityOctopus> extends ModelBAP<T> {

    protected final ModelPart[] mainTentacles;
    public ModelPart head;
    public ModelPart lEye;
    public ModelPart rEye;
    public ModelPart siphon;
    public ModelPart beak01;
    public ModelPart beak02;
    public ModelPart lTentacle01a;
    public ModelPart rTentacle01a;
    public ModelPart lTentacle02a;
    public ModelPart rTentacle02a;
    public ModelPart lTentacle03a;
    public ModelPart rTentacle03a;
    public ModelPart lTentacle04a;
    public ModelPart rTentacle04a;
    public ModelPart mantle00;
    public ModelPart lTentacle01b;
    public ModelPart lTentacle01c;
    public ModelPart lTentacle01d;
    public ModelPart rTentacle01b;
    public ModelPart rTentacle01c;
    public ModelPart rTentacle01d;
    public ModelPart lTentacle02b;
    public ModelPart lTentacle02c;
    public ModelPart lTentacle02d;
    public ModelPart rTentacle02b;
    public ModelPart rTentacle02c;
    public ModelPart rTentacle02d;
    public ModelPart lTentacle03b;
    public ModelPart lTentacle03c;
    public ModelPart lTentacle03d;
    public ModelPart rTentacle03b;
    public ModelPart rTentacle03c;
    public ModelPart rTentacle03d;
    public ModelPart lTentacle04b;
    public ModelPart lTentacle04c;
    public ModelPart lTentacle04d;
    public ModelPart rTentacle04b;
    public ModelPart rTentacle04c;
    public ModelPart rTentacle04d;
    public ModelPart mantle01;

    public ModelOctopus(ModelPart root) {
        this.head = root.getChild("head");
        this.lEye = head.getChild("lEye");
        this.rEye = head.getChild("rEye");
        this.siphon = head.getChild("siphon");
        this.beak01 = head.getChild("beak01");
        this.beak02 = head.getChild("beak02");
        this.lTentacle01a = head.getChild("lTentacle01a");
        this.lTentacle01b = lTentacle01a.getChild("lTentacle01b");
        this.lTentacle01c = lTentacle01b.getChild("lTentacle01c");
        this.lTentacle01d = lTentacle01c.getChild("lTentacle01d");
        this.rTentacle01a = head.getChild("rTentacle01a");
        this.rTentacle01b = rTentacle01a.getChild("rTentacle01b");
        this.rTentacle01c = rTentacle01b.getChild("rTentacle01c");
        this.rTentacle01d = rTentacle01c.getChild("rTentacle01d");
        this.lTentacle02a = head.getChild("lTentacle02a");
        this.lTentacle02b = lTentacle02a.getChild("lTentacle02b");
        this.lTentacle02c = lTentacle02b.getChild("lTentacle02c");
        this.lTentacle02d = lTentacle02c.getChild("lTentacle02d");
        this.rTentacle02a = head.getChild("rTentacle02a");
        this.rTentacle02b = rTentacle02a.getChild("rTentacle02b");
        this.rTentacle02c = rTentacle02b.getChild("rTentacle02c");
        this.rTentacle02d = rTentacle02c.getChild("rTentacle02d");
        this.lTentacle03a = head.getChild("lTentacle03a");
        this.lTentacle03b = lTentacle03a.getChild("lTentacle03b");
        this.lTentacle03c = lTentacle03b.getChild("lTentacle03c");
        this.lTentacle03d = lTentacle03c.getChild("lTentacle03d");
        this.rTentacle03a = head.getChild("rTentacle03a");
        this.rTentacle03b = rTentacle03a.getChild("rTentacle03b");
        this.rTentacle03c = rTentacle03b.getChild("rTentacle03c");
        this.rTentacle03d = rTentacle03c.getChild("rTentacle03d");
        this.lTentacle04a = head.getChild("lTentacle04a");
        this.lTentacle04b = lTentacle04a.getChild("lTentacle04b");
        this.lTentacle04c = lTentacle04b.getChild("lTentacle04c");
        this.lTentacle04d = lTentacle04c.getChild("lTentacle04d");
        this.rTentacle04a = head.getChild("rTentacle04a");
        this.rTentacle04b = rTentacle04a.getChild("rTentacle04b");
        this.rTentacle04c = rTentacle04b.getChild("rTentacle04c");
        this.rTentacle04d = rTentacle04c.getChild("rTentacle04d");
        this.mantle00 = head.getChild("mantle00");
        this.mantle01 = mantle00.getChild("mantle01");
        this.mainTentacles = new ModelPart[]{
                lTentacle01a,
                lTentacle02a,
                lTentacle03a,
                lTentacle04a,
                rTentacle01a,
                rTentacle02a,
                rTentacle03a,
                rTentacle04a
        };
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -9.0F, -3.5F, 7.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 20.0F, 0.0F, -0.4098F, 0.0F, 0.0F));
        PartDefinition lEye = head.addOrReplaceChild("lEye", CubeListBuilder.create().texOffs(23, 0).addBox(-0.1F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6F, -7.0F, -2.5F, 0.5236F, 0.1745F, 0.0F));
        PartDefinition rEye = head.addOrReplaceChild("rEye", CubeListBuilder.create().texOffs(23, 0).mirror().addBox(-1.9F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.6F, -7.0F, -2.5F, 0.5236F, -0.1745F, 0.0F));
        PartDefinition siphon = head.addOrReplaceChild("siphon", CubeListBuilder.create().texOffs(34, 0).addBox(-0.7F, -1.0F, -1.5F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6F, -3.4F, -0.7F, 0.0F, -0.7285F, 0.0F));
        PartDefinition beak01 = head.addOrReplaceChild("beak01", CubeListBuilder.create().texOffs(47, 0).addBox(-1.5F, 0.0F, -0.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5F, -1.2F, -0.6374F, 0.0F, 0.0F));
        PartDefinition beak02 = head.addOrReplaceChild("beak02", CubeListBuilder.create().texOffs(55, 6).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5F, 0.3F, 0.5009F, 0.0F, 0.0F));
        PartDefinition lTentacle01a = head.addOrReplaceChild("lTentacle01a", CubeListBuilder.create().texOffs(41, 21).mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.7F, -0.9F, -1.0F, -0.6981F, -0.3142F, 0.0F));
        PartDefinition lTentacle01b = lTentacle01a.addOrReplaceChild("lTentacle01b", CubeListBuilder.create().texOffs(41, 21).mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 6.2F, 0.0F, -0.2793F, 0.2094F, -0.2269F));
        PartDefinition lTentacle01c = lTentacle01b.addOrReplaceChild("lTentacle01c", CubeListBuilder.create().texOffs(41, 20).mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 7.1F, 0.0F, -0.0873F, -0.2269F, -0.3491F));
        PartDefinition lTentacle01d = lTentacle01c.addOrReplaceChild("lTentacle01d", CubeListBuilder.create().texOffs(54, 21).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 8.2F, 0.0F, -0.0349F, 0.0F, -0.3491F));
        PartDefinition rTentacle01a = head.addOrReplaceChild("rTentacle01a", CubeListBuilder.create().texOffs(41, 21).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7F, -0.9F, -1.0F, -0.6981F, 0.3142F, 0.0F));
        PartDefinition rTentacle01b = rTentacle01a.addOrReplaceChild("rTentacle01b", CubeListBuilder.create().texOffs(41, 21).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.2F, 0.0F, -0.2793F, -0.2094F, 0.2269F));
        PartDefinition rTentacle01c = rTentacle01b.addOrReplaceChild("rTentacle01c", CubeListBuilder.create().texOffs(41, 20).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.1F, 0.0F, -0.0873F, 0.2269F, 0.3491F));
        PartDefinition rTentacle01d = rTentacle01c.addOrReplaceChild("rTentacle01d", CubeListBuilder.create().texOffs(54, 21).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.2F, 0.0F, -0.0349F, 0.0F, 0.3491F));
        PartDefinition lTentacle02a = head.addOrReplaceChild("lTentacle02a", CubeListBuilder.create().texOffs(41, 21).mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.7F, -1.5F, -0.3F, -0.7854F, -1.0472F, 0.0F));
        PartDefinition lTentacle02b = lTentacle02a.addOrReplaceChild("lTentacle02b", CubeListBuilder.create().texOffs(41, 21).mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 6.2F, 0.0F, -0.4014F, 0.4014F, -0.0349F));
        PartDefinition lTentacle02c = lTentacle02b.addOrReplaceChild("lTentacle02c", CubeListBuilder.create().texOffs(41, 20).mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 7.1F, 0.0F, -0.0349F, 0.0F, -0.3491F));
        PartDefinition lTentacle02d = lTentacle02c.addOrReplaceChild("lTentacle02d", CubeListBuilder.create().texOffs(54, 21).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 8.2F, 0.0F, -0.0349F, 0.0F, -0.3491F));
        PartDefinition rTentacle02a = head.addOrReplaceChild("rTentacle02a", CubeListBuilder.create().texOffs(41, 21).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7F, -1.5F, -0.3F, -0.7854F, 1.0472F, 0.0F));
        PartDefinition rTentacle02b = rTentacle02a.addOrReplaceChild("rTentacle02b", CubeListBuilder.create().texOffs(41, 21).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.2F, 0.0F, -0.4014F, -0.4014F, 0.0349F));
        PartDefinition rTentacle02c = rTentacle02b.addOrReplaceChild("rTentacle02c", CubeListBuilder.create().texOffs(41, 20).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.1F, 0.0F, -0.0349F, 0.0F, 0.3491F));
        PartDefinition rTentacle02d = rTentacle02c.addOrReplaceChild("rTentacle02d", CubeListBuilder.create().texOffs(54, 21).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.2F, 0.0F, -0.0349F, 0.0F, 0.3491F));
        PartDefinition lTentacle03a = head.addOrReplaceChild("lTentacle03a", CubeListBuilder.create().texOffs(41, 21).mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.8F, -2.0F, 1.0F, -0.7854F, -1.5708F, 0.0F));
        PartDefinition lTentacle03b = lTentacle03a.addOrReplaceChild("lTentacle03b", CubeListBuilder.create().texOffs(41, 21).mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 6.2F, 0.0F, -0.6109F, 0.5236F, -0.0349F));
        PartDefinition lTentacle03c = lTentacle03b.addOrReplaceChild("lTentacle03c", CubeListBuilder.create().texOffs(41, 20).mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 7.1F, 0.0F, -0.0698F, 0.0F, -0.3491F));
        PartDefinition lTentacle03d = lTentacle03c.addOrReplaceChild("lTentacle03d", CubeListBuilder.create().texOffs(54, 21).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 8.2F, 0.0F, 0.0F, 0.0F, -0.3491F));
        PartDefinition rTentacle03a = head.addOrReplaceChild("rTentacle03a", CubeListBuilder.create().texOffs(41, 21).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8F, -2.0F, 1.0F, -0.7854F, 1.5708F, 0.0F));
        PartDefinition rTentacle03b = rTentacle03a.addOrReplaceChild("rTentacle03b", CubeListBuilder.create().texOffs(41, 21).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.2F, 0.0F, -0.6109F, -0.5236F, 0.0349F));
        PartDefinition rTentacle03c = rTentacle03b.addOrReplaceChild("rTentacle03c", CubeListBuilder.create().texOffs(41, 20).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.1F, 0.0F, -0.0698F, 0.0F, 0.3491F));
        PartDefinition rTentacle03d = rTentacle03c.addOrReplaceChild("rTentacle03d", CubeListBuilder.create().texOffs(54, 21).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.2F, 0.0F, 0.0F, 0.0F, 0.3491F));
        PartDefinition lTentacle04a = head.addOrReplaceChild("lTentacle04a", CubeListBuilder.create().texOffs(41, 21).mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.8F, -2.4F, 2.0F, -0.7854F, -2.0944F, 0.0F));
        PartDefinition lTentacle04b = lTentacle04a.addOrReplaceChild("lTentacle04b", CubeListBuilder.create().texOffs(41, 21).mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 6.2F, 0.0F, -0.8727F, 0.5236F, -0.0349F));
        PartDefinition lTentacle04c = lTentacle04b.addOrReplaceChild("lTentacle04c", CubeListBuilder.create().texOffs(41, 20).mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 7.1F, 0.0F, -0.0873F, 0.0F, -0.3491F));
        PartDefinition lTentacle04d = lTentacle04c.addOrReplaceChild("lTentacle04d", CubeListBuilder.create().texOffs(54, 21).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 8.2F, 0.0F, 0.0F, 0.0F, -0.3491F));
        PartDefinition rTentacle04a = head.addOrReplaceChild("rTentacle04a", CubeListBuilder.create().texOffs(41, 21).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8F, -2.4F, 2.0F, -0.7854F, 2.0944F, 0.0F));
        PartDefinition rTentacle04b = rTentacle04a.addOrReplaceChild("rTentacle04b", CubeListBuilder.create().texOffs(41, 21).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.2F, 0.0F, -0.8727F, -0.5236F, 0.0349F));
        PartDefinition rTentacle04c = rTentacle04b.addOrReplaceChild("rTentacle04c", CubeListBuilder.create().texOffs(41, 20).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.1F, 0.0F, -0.0873F, 0.0F, 0.3491F));
        PartDefinition rTentacle04d = rTentacle04c.addOrReplaceChild("rTentacle04d", CubeListBuilder.create().texOffs(54, 21).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.2F, 0.0F, 0.0F, 0.0F, 0.3491F));
        PartDefinition mantle00 = head.addOrReplaceChild("mantle00", CubeListBuilder.create().texOffs(0, 16).addBox(-4.5F, -4.0F, -0.1F, 9.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.4F, -1.2F, 0.3665F, 0.0F, 0.0F));
        PartDefinition mantle01 = mantle00.addOrReplaceChild("mantle01", CubeListBuilder.create().texOffs(29, 5).addBox(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2F, 5.3F, -0.3491F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.head.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        if(entityIn.isInWaterOrBubble() && (!entityIn.isAboveBlock() || entityIn.getDeltaMovement().length() > 0.01)) {
            this.setSwimPose();
            this.head.xRot = 0F;
            for (ModelPart m : mainTentacles) {
                m.xRot = -ageInTicks / 2F;
            }
        } else {
            this.setGroundPose();
            this.lTentacle01a.yRot -= Mth.sin(limbSwing) * limbSwingAmount / 2F;
            this.lTentacle02a.yRot -= Mth.sin(limbSwing) * limbSwingAmount / 2F;
            this.lTentacle03a.yRot += Mth.sin(limbSwing) * limbSwingAmount / 2F;
            this.lTentacle04a.yRot += Mth.sin(limbSwing) * limbSwingAmount / 2F;
            this.rTentacle01a.yRot -= Mth.sin(limbSwing) * limbSwingAmount / 2F;
            this.rTentacle02a.yRot -= Mth.sin(limbSwing) * limbSwingAmount / 2F;
            this.rTentacle03a.yRot += Mth.sin(limbSwing) * limbSwingAmount / 2F;
            this.rTentacle04a.yRot += Mth.sin(limbSwing) * limbSwingAmount / 2F;
        }
    }

    public void setSwimPose() {
        this.setRotateAngle(head, -1.5025539530419183F, 0.0F, 0.0F);
        this.setRotateAngle(lTentacle01a, 0.0F, -0.3141592653589793F, 0.0F);
        this.setRotateAngle(lTentacle01b, -0.2792526803190927F, 0.0F, 0.0F);
        this.setRotateAngle(lTentacle01c, 0.17453292519943295F, 0.0F, 0.0F);
        this.setRotateAngle(lTentacle01d, -0.03490658503988659F, 0.0F, 0.0F);
        this.setRotateAngle(lTentacle02a, 0.0F, -1.3962634015954636F, -0.17453292519943295F);
        this.setRotateAngle(lTentacle02b, 0.08726646259971647F, 0.0F, 0.0F);
        this.setRotateAngle(lTentacle02c, -0.03490658503988659F, 0.0F, 0.017453292519943295F);
        this.setRotateAngle(lTentacle02d, -0.03490658503988659F, 0.0F, 0.0F);
        this.setRotateAngle(lTentacle03a, -0.22689280275926282F, -2.2165681500327987F, 0.0F);
        this.setRotateAngle(lTentacle03c, -0.03490658503988659F, 0.0F, 0.0F);
        this.setRotateAngle(lTentacle03b, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lTentacle04a, -0.45378560551852565F, -2.897246558310587F, 0.0F);
        this.setRotateAngle(lTentacle04c, 0.08726646259971647F, 0.0F, 0.0F);
        this.setRotateAngle(lTentacle04b, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(mantle00, 1.2217304763960306F, 0.0F, 0.0F);
        this.setRotateAngle(lTentacle04d, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rTentacle04d, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(mantle01, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rTentacle01a, 0.0F, 0.3141592653589793F, 0.0F);
        this.setRotateAngle(rTentacle01b, -0.2792526803190927F, 0.0F, 0.0F);
        this.setRotateAngle(rTentacle01c, 0.17453292519943295F, 0.0F, 0.0F);
        this.setRotateAngle(rTentacle01d, -0.03490658503988659F, 0.0F, 0.0F);
        this.setRotateAngle(rTentacle02a, 0.0F, 1.3962634015954636F, 0.17453292519943295F);
        this.setRotateAngle(rTentacle02b, -0.08726646259971647F, 0.0F, 0.0F);
        this.setRotateAngle(rTentacle02c, -0.03490658503988659F, 0.0F, 0.0F);
        this.setRotateAngle(rTentacle03a, -0.22689280275926282F, 2.2165681500327987F, 0.0F);
        this.setRotateAngle(rTentacle03c, -0.03490658503988659F, 0.0F, 0.0F);
        this.setRotateAngle(rTentacle03b, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rTentacle04a, -0.45378560551852565F, 2.897246558310587F, 0.0F);
        this.setRotateAngle(rTentacle04c, 0.08726646259971647F, 0.0F, 0.0F);
        this.setRotateAngle(rTentacle04b, 0.0F, 0.0F, 0.0F);
    }

    public void setGroundPose() {
        this.setRotateAngle(head, -0.40980330836826856F, 0.0F, 0.0F);
        this.setRotateAngle(lTentacle01a, -0.6981317007977318F, -0.3141592653589793F, 0.0F);
        this.setRotateAngle(lTentacle01b, -0.2792526803190927F, 0.20943951023931953F, -0.22689280275926282F);
        this.setRotateAngle(lTentacle01c, -0.08726646259971647F, -0.22689280275926282F, -0.3490658503988659F);
        this.setRotateAngle(lTentacle01d, -0.03490658503988659F, 0.0F, -0.3490658503988659F);
        this.setRotateAngle(lTentacle02a, -0.7853981633974483F, -1.0471975511965976F, 0.0F);
        this.setRotateAngle(lTentacle02b, -0.40142572795869574F, 0.40142572795869574F, -0.03490658503988659F);
        this.setRotateAngle(lTentacle02c, -0.03490658503988659F, 0.0F, -0.3490658503988659F);
        this.setRotateAngle(lTentacle02d, -0.03490658503988659F, 0.0F, -0.3490658503988659F);
        this.setRotateAngle(lTentacle03a, -0.7853981633974483F, -1.5707963267948966F, 0.0F);
        this.setRotateAngle(lTentacle03b, -0.6981317007977318F, 0.5235987755982988F, -0.03490658503988659F);
        this.setRotateAngle(lTentacle03c, -0.03490658503988659F, 0.0F, -0.3490658503988659F);
        this.setRotateAngle(lTentacle04a, -0.7853981633974483F, -2.0943951023931953F, 0.0F);
        this.setRotateAngle(lTentacle04b, -0.8726646259971648F, 0.5235987755982988F, -0.03490658503988659F);
        this.setRotateAngle(lTentacle04c, -0.08726646259971647F, 0.0F, -0.3490658503988659F);
        this.setRotateAngle(lTentacle04d, 0.0F, 0.0F, -0.3490658503988659F);
        this.setRotateAngle(rTentacle04d, 0.0F, 0.0F, 0.3490658503988659F);
        this.setRotateAngle(mantle00, 0.3665191429188092F, 0.0F, 0.0F);
        this.setRotateAngle(mantle01, -0.3490658503988659F, 0.0F, 0.0F);
        this.setRotateAngle(rTentacle01a, -0.6981317007977318F, 0.3141592653589793F, 0.0F);
        this.setRotateAngle(rTentacle01b, -0.2792526803190927F, -0.20943951023931953F, 0.22689280275926282F);
        this.setRotateAngle(rTentacle01c, -0.08726646259971647F, 0.22689280275926282F, 0.3490658503988659F);
        this.setRotateAngle(rTentacle01d, -0.03490658503988659F, 0.0F, 0.3490658503988659F);
        this.setRotateAngle(rTentacle02a, -0.7853981633974483F, 1.0471975511965976F, 0.0F);
        this.setRotateAngle(rTentacle02b, -0.40142572795869574F, -0.40142572795869574F, 0.03490658503988659F);
        this.setRotateAngle(rTentacle02c, -0.03490658503988659F, 0.0F, 0.3490658503988659F);
        this.setRotateAngle(rTentacle03a, -0.7853981633974483F, 1.5707963267948966F, 0.0F);
        this.setRotateAngle(rTentacle03b, -0.6981317007977318F, -0.5235987755982988F, 0.03490658503988659F);
        this.setRotateAngle(rTentacle03c, -0.03490658503988659F, 0.0F, 0.3490658503988659F);
        this.setRotateAngle(rTentacle04a, -0.7853981633974483F, 2.0943951023931953F, 0.0F);
        this.setRotateAngle(rTentacle04b, -0.8726646259971648F, -0.5235987755982988F, 0.03490658503988659F);
        this.setRotateAngle(rTentacle04c, -0.08726646259971647F, 0.0F, 0.3490658503988659F);
    }

}
