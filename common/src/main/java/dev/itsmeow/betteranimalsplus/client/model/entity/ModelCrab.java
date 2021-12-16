package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import dev.itsmeow.betteranimalsplus.common.entity.EntityCrab;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;

/**
 * crab - Batman
 * Created using Tabula 7.0.1
 */
public class ModelCrab<T extends LivingEntity> extends ModelBAP<T> {

    public ModelPart body;
    public ModelPart lShell;
    public ModelPart rShell;
    public ModelPart lArm00;
    public ModelPart rArm00;
    public ModelPart lEye;
    public ModelPart rEye;
    public ModelPart rMouth;
    public ModelPart lMouth;
    public ModelPart lLeg00a;
    public ModelPart lLeg01a;
    public ModelPart lLeg02a;
    public ModelPart rLeg00a;
    public ModelPart rLeg01a;
    public ModelPart rLeg02a;
    public ModelPart lLeg03a;
    public ModelPart rLeg03a;
    public ModelPart lClaw00;
    public ModelPart lClaw02;
    public ModelPart lClaw01;
    public ModelPart rClaw00;
    public ModelPart rClaw01;
    public ModelPart rClaw02;
    public ModelPart lLeg00b;
    public ModelPart lLeg00c;
    public ModelPart lLeg01b;
    public ModelPart lLeg01c;
    public ModelPart lLeg02b;
    public ModelPart lLeg02c;
    public ModelPart rLeg00b;
    public ModelPart rLeg00c;
    public ModelPart rLeg01b;
    public ModelPart rLeg01c;
    public ModelPart rLeg02b;
    public ModelPart rLeg02c;
    public ModelPart lLeg03b;
    public ModelPart lLeg03c;
    public ModelPart rLeg03b;
    public ModelPart rLeg03c;

    private int crabId = 0;

    public ModelCrab(ModelPart root) {
        this.body = root.getChild("body");
        this.lShell = body.getChild("lShell");
        this.rShell = body.getChild("rShell");
        this.lArm00 = body.getChild("lArm00");
        this.lClaw00 = lArm00.getChild("lClaw00");
        this.lClaw02 = lClaw00.getChild("lClaw02");
        this.lClaw01 = lClaw00.getChild("lClaw01");
        this.rArm00 = body.getChild("rArm00");
        this.rClaw00 = rArm00.getChild("rClaw00");
        this.rClaw01 = rClaw00.getChild("rClaw01");
        this.rClaw02 = rClaw00.getChild("rClaw02");
        this.lEye = body.getChild("lEye");
        this.rEye = body.getChild("rEye");
        this.rMouth = body.getChild("rMouth");
        this.lMouth = body.getChild("lMouth");
        this.lLeg00a = body.getChild("lLeg00a");
        this.lLeg00b = lLeg00a.getChild("lLeg00b");
        this.lLeg00c = lLeg00b.getChild("lLeg00c");
        this.lLeg01a = body.getChild("lLeg01a");
        this.lLeg01b = lLeg01a.getChild("lLeg01b");
        this.lLeg01c = lLeg01b.getChild("lLeg01c");
        this.lLeg02a = body.getChild("lLeg02a");
        this.lLeg02b = lLeg02a.getChild("lLeg02b");
        this.lLeg02c = lLeg02b.getChild("lLeg02c");
        this.rLeg00a = body.getChild("rLeg00a");
        this.rLeg00b = rLeg00a.getChild("rLeg00b");
        this.rLeg00c = rLeg00b.getChild("rLeg00c");
        this.rLeg01a = body.getChild("rLeg01a");
        this.rLeg01b = rLeg01a.getChild("rLeg01b");
        this.rLeg01c = rLeg01b.getChild("rLeg01c");
        this.rLeg02a = body.getChild("rLeg02a");
        this.rLeg02b = rLeg02a.getChild("rLeg02b");
        this.rLeg02c = rLeg02b.getChild("rLeg02c");
        this.lLeg03a = body.getChild("lLeg03a");
        this.lLeg03b = lLeg03a.getChild("lLeg03b");
        this.lLeg03c = lLeg03b.getChild("lLeg03c");
        this.rLeg03a = body.getChild("rLeg03a");
        this.rLeg03b = rLeg03a.getChild("rLeg03b");
        this.rLeg03c = rLeg03b.getChild("rLeg03c");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -1.5F, -3.0F, 6.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, 0.0F));
        PartDefinition lShell = body.addOrReplaceChild("lShell", CubeListBuilder.create().texOffs(1, 13).mirror().addBox(0.0F, -0.5F, -1.5F, 7.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.6F, -0.6F, 3.7F, 0.0F, 1.0472F, 0.0F));
        PartDefinition rShell = body.addOrReplaceChild("rShell", CubeListBuilder.create().texOffs(1, 13).addBox(-7.0F, -0.5F, -1.5F, 7.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6F, -0.6F, 3.7F, 0.0F, -1.0472F, 0.0F));
        PartDefinition lArm00 = body.addOrReplaceChild("lArm00", CubeListBuilder.create().texOffs(11, 20).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 0.9F, -1.8F, 0.3491F, -1.0472F, 0.0F));
        PartDefinition lClaw00 = lArm00.addOrReplaceChild("lClaw00", CubeListBuilder.create().texOffs(11, 20).mirror().addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.1F, -3.8F, -0.1745F, 1.0472F, 0.0F));
        PartDefinition lClaw02 = lClaw00.addOrReplaceChild("lClaw02", CubeListBuilder.create().texOffs(20, 27).mirror().addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.7F, -3.9F));
        PartDefinition lClaw01 = lClaw00.addOrReplaceChild("lClaw01", CubeListBuilder.create().texOffs(11, 27).mirror().addBox(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -0.6F, -3.9F));
        PartDefinition rArm00 = body.addOrReplaceChild("rArm00", CubeListBuilder.create().texOffs(11, 20).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 0.9F, -1.8F, 0.3491F, 1.0472F, 0.0F));
        PartDefinition rClaw00 = rArm00.addOrReplaceChild("rClaw00", CubeListBuilder.create().texOffs(11, 20).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.1F, -2.8F, -0.1745F, -1.0472F, 0.0F));
        PartDefinition rClaw01 = rClaw00.addOrReplaceChild("rClaw01", CubeListBuilder.create().texOffs(11, 27).mirror().addBox(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -0.6F, -3.9F));
        PartDefinition rClaw02 = rClaw00.addOrReplaceChild("rClaw02", CubeListBuilder.create().texOffs(20, 27).mirror().addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.7F, -3.9F));
        PartDefinition lEye = body.addOrReplaceChild("lEye", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.3F, -1.2F, -2.5F, 0.3187F, 0.0F, 0.2276F));
        PartDefinition rEye = body.addOrReplaceChild("rEye", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.3F, -1.2F, -2.5F, 0.3187F, 0.0F, -0.2276F));
        PartDefinition rMouth = body.addOrReplaceChild("rMouth", CubeListBuilder.create().texOffs(0, 4).mirror().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.1F, -0.9F, -3.0F, 0.0F, -0.1745F, 0.0F));
        PartDefinition lMouth = body.addOrReplaceChild("lMouth", CubeListBuilder.create().texOffs(0, 4).addBox(-1.0F, 0.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8F, -0.9F, -3.0F, 0.0F, 0.1745F, 0.0F));
        PartDefinition lLeg00a = body.addOrReplaceChild("lLeg00a", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(0.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.8F, 1.0F, 0.8F, 0.0F, 0.3142F, 0.0F));
        PartDefinition lLeg00b = lLeg00a.addOrReplaceChild("lLeg00b", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(0.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.9F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4538F));
        PartDefinition lLeg00c = lLeg00b.addOrReplaceChild("lLeg00c", CubeListBuilder.create().texOffs(0, 26).mirror().addBox(0.0F, -0.5F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.9F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5236F));
        PartDefinition lLeg01a = body.addOrReplaceChild("lLeg01a", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(0.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.8F, 1.0F, 1.9F, 0.0F, 0.1396F, 0.0F));
        PartDefinition lLeg01b = lLeg01a.addOrReplaceChild("lLeg01b", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(0.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.9F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4538F));
        PartDefinition lLeg01c = lLeg01b.addOrReplaceChild("lLeg01c", CubeListBuilder.create().texOffs(0, 26).mirror().addBox(0.0F, -0.5F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.9F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5236F));
        PartDefinition lLeg02a = body.addOrReplaceChild("lLeg02a", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(0.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.8F, 1.0F, 2.7F, 0.0F, -0.1745F, 0.0F));
        PartDefinition lLeg02b = lLeg02a.addOrReplaceChild("lLeg02b", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(0.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.9F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4538F));
        PartDefinition lLeg02c = lLeg02b.addOrReplaceChild("lLeg02c", CubeListBuilder.create().texOffs(0, 26).mirror().addBox(0.0F, -0.5F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.9F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5236F));
        PartDefinition rLeg00a = body.addOrReplaceChild("rLeg00a", CubeListBuilder.create().texOffs(0, 20).addBox(-4.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8F, 1.0F, 0.8F, 0.0F, -0.3142F, 0.0F));
        PartDefinition rLeg00b = rLeg00a.addOrReplaceChild("rLeg00b", CubeListBuilder.create().texOffs(0, 23).addBox(-3.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4538F));
        PartDefinition rLeg00c = rLeg00b.addOrReplaceChild("rLeg00c", CubeListBuilder.create().texOffs(0, 26).mirror().addBox(-3.0F, -0.5F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.9F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5236F));
        PartDefinition rLeg01a = body.addOrReplaceChild("rLeg01a", CubeListBuilder.create().texOffs(0, 20).addBox(-4.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8F, 1.0F, 1.9F, 0.0F, -0.1396F, 0.0F));
        PartDefinition rLeg01b = rLeg01a.addOrReplaceChild("rLeg01b", CubeListBuilder.create().texOffs(0, 23).addBox(-3.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4538F));
        PartDefinition rLeg01c = rLeg01b.addOrReplaceChild("rLeg01c", CubeListBuilder.create().texOffs(0, 26).mirror().addBox(-3.0F, -0.5F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.9F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5236F));
        PartDefinition rLeg02a = body.addOrReplaceChild("rLeg02a", CubeListBuilder.create().texOffs(0, 20).addBox(-4.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8F, 1.0F, 2.7F, 0.0F, 0.1396F, 0.0F));
        PartDefinition rLeg02b = rLeg02a.addOrReplaceChild("rLeg02b", CubeListBuilder.create().texOffs(0, 23).addBox(-3.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4538F));
        PartDefinition rLeg02c = rLeg02b.addOrReplaceChild("rLeg02c", CubeListBuilder.create().texOffs(0, 26).mirror().addBox(-3.0F, -0.5F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.9F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5236F));
        PartDefinition lLeg03a = body.addOrReplaceChild("lLeg03a", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(0.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.8F, 1.0F, 3.7F, 0.0F, -0.4538F, 0.0F));
        PartDefinition lLeg03b = lLeg03a.addOrReplaceChild("lLeg03b", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(0.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.9F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4538F));
        PartDefinition lLeg03c = lLeg03b.addOrReplaceChild("lLeg03c", CubeListBuilder.create().texOffs(0, 26).mirror().addBox(0.0F, -0.5F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.9F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5236F));
        PartDefinition rLeg03a = body.addOrReplaceChild("rLeg03a", CubeListBuilder.create().texOffs(0, 20).addBox(-4.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8F, 1.0F, 3.7F, 0.0F, 0.4538F, 0.0F));
        PartDefinition rLeg03b = rLeg03a.addOrReplaceChild("rLeg03b", CubeListBuilder.create().texOffs(0, 23).addBox(-3.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4538F));
        PartDefinition rLeg03c = rLeg03b.addOrReplaceChild("rLeg03c", CubeListBuilder.create().texOffs(0, 26).mirror().addBox(-3.0F, -0.5F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.9F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5236F));
        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    private void resetPose() {
        this.rLeg00a.yRot = -0.3141592653589793F;
        this.lLeg00a.yRot = 0.3141592653589793F;
        this.rLeg01a.yRot = -0.13962634015954636F;
        this.lLeg01a.yRot = 0.13962634015954636F;
        this.rLeg02a.yRot = 0.13962634015954636F;
        this.lLeg02a.yRot = -0.13962634015954636F;
        this.rLeg03a.yRot = 0.45378560551852565F;
        this.lLeg03a.yRot = -0.45378560551852565F;
        this.rLeg00a.zRot = 0;
        this.lLeg00a.zRot = 0;
        this.rLeg01a.zRot = 0;
        this.lLeg01a.zRot = 0;
        this.rLeg02a.zRot = 0;
        this.lLeg02a.zRot = 0;
        this.rLeg03a.zRot = 0;
        this.lLeg03a.zRot = 0;
        this.rLeg00a.xRot = 0;
        this.lLeg00a.xRot = 0;
        this.rLeg01a.xRot = 0;
        this.lLeg01a.xRot = 0;
        this.rLeg02a.xRot = 0;
        this.lLeg02a.xRot = 0;
        this.rLeg03a.xRot = 0;
        this.lLeg03a.xRot = 0;
        this.body.x = 0;
        this.body.y = 0;
        this.body.z = 0;
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        matrixStackIn.translate(0F, 1.15F, 0F);
        if (crabId == 1) {
            matrixStackIn.translate(0, -0.25, 0);
        } else if (crabId == 2) {
            matrixStackIn.translate(0, -0.15, 0);
        } else if (crabId == 3) {
            matrixStackIn.translate(0, -0.05, 0);
        } else {
            matrixStackIn.translate(0F, 0.05F, 0F);
        }
        this.body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T entity, float f, float f1, float f2, float f3, float f4) {
        this.resetPose();
        if (entity instanceof EntityCrab) {
            EntityCrab crab = (EntityCrab) entity;
            int crabID = crab.getIsCrabRave();
            this.crabId = crabID;
            if (crabID == 1) {
                float xOff = (((float) Math.sin(((f2 + 100) / 2.5F) % 200F)) / 5);
                this.body.x = xOff * 16F;
                this.lArm00.xRot = -1.5F;
                this.rArm00.xRot = -1.5F;
                this.lArm00.yRot = 0F;
                this.rArm00.yRot = 0F;
                float rotOff = (float) Math.atan(xOff * 1.5F) * 1.5F;
                this.lArm00.zRot = 1F - rotOff;
                this.rArm00.zRot = -1F - rotOff;

                float mulFact = 2F;
                rotOff = -(float) Math.acos(xOff) * mulFact;

                this.rLeg00a.zRot = -90F * mulFact;
                this.lLeg00a.zRot = 90F * mulFact;
                this.rLeg01a.zRot = -90F * mulFact;
                this.lLeg01a.zRot = 90F * mulFact;
                this.rLeg02a.zRot = -90F * mulFact;
                this.lLeg02a.zRot = 90F * mulFact;
                this.rLeg03a.zRot = -90F * mulFact;
                this.lLeg03a.zRot = 90F * mulFact;

                this.rLeg00a.zRot += rotOff;
                this.lLeg00a.zRot += rotOff;
                this.rLeg01a.zRot += rotOff;
                this.lLeg01a.zRot += rotOff;
                this.rLeg02a.zRot += rotOff;
                this.lLeg02a.zRot += rotOff;
                this.rLeg03a.zRot += rotOff;
                this.lLeg03a.zRot += rotOff;
            } else if (crabID == 2) {
                float zOff = (((float) Math.sin(((f2 + 100) / 2.5F) % 200F)) / 5);
                this.body.z = zOff * 16F;
                this.lArm00.xRot = 0F;
                this.rArm00.xRot = 0F;
                this.lArm00.yRot = -1F + (float) Math.sin(f2 / 2.5F) / 2;
                this.rArm00.yRot = 1F - (float) Math.sin(f2 / 2.5F) / 2;
                this.lArm00.zRot = 0F;
                this.rArm00.zRot = 0F;

                float mulFact = -3F;
                float pi = (float) Math.PI;
                float rotOff = -(float) Math.acos(zOff) * mulFact;

                this.rLeg00a.zRot = -pi / 6;
                this.lLeg00a.zRot = pi / 6;
                this.rLeg01a.zRot = -pi / 6;
                this.lLeg01a.zRot = pi / 6;
                this.rLeg02a.zRot = -pi / 6;
                this.lLeg02a.zRot = pi / 6;
                this.rLeg03a.zRot = -pi / 6;
                this.lLeg03a.zRot = pi / 6;

                this.rLeg00a.xRot = (pi / 2) * mulFact;
                this.lLeg00a.xRot = (pi / 2) * mulFact;
                this.rLeg01a.xRot = (pi / 2) * mulFact;
                this.lLeg01a.xRot = (pi / 2) * mulFact;
                this.rLeg02a.xRot = (pi / 2) * mulFact;
                this.lLeg02a.xRot = (pi / 2) * mulFact;
                this.rLeg03a.xRot = (pi / 2) * mulFact;
                this.lLeg03a.xRot = (pi / 2) * mulFact;

                this.rLeg00a.xRot += rotOff;
                this.lLeg00a.xRot += rotOff;
                this.rLeg01a.xRot += rotOff;
                this.lLeg01a.xRot += rotOff;
                this.rLeg02a.xRot += rotOff;
                this.lLeg02a.xRot += rotOff;
                this.rLeg03a.xRot += rotOff;
                this.lLeg03a.xRot += rotOff;
            } else if (crabID == 3) {
                float yOff = (((float) Math.sin(((f2 + 100) / 2.5F) % 200F)) / 5);
                this.body.y = yOff * 16F;
                this.lArm00.xRot = -1.5F;
                this.rArm00.xRot = -1.5F;
                this.lArm00.yRot = -1.5F + (float) Math.sin(f2 / 2.5F) / 1.5F;
                this.rArm00.yRot = 1.5F - (float) Math.sin(f2 / 2.5F) / 1.5F;
                this.lArm00.zRot = 1.5F;
                this.rArm00.zRot = -1.5F;

                float mulFact = 2F;
                float rotOff = -(float) Math.acos(yOff) * mulFact - 0.25F;

                float pi = (float) Math.PI;
                this.rLeg00a.zRot = (pi / 2) * mulFact;
                this.lLeg00a.zRot = (pi / 2) * mulFact;
                this.rLeg01a.zRot = (pi / 2) * mulFact;
                this.lLeg01a.zRot = (pi / 2) * mulFact;
                this.rLeg02a.zRot = (pi / 2) * mulFact;
                this.lLeg02a.zRot = (pi / 2) * mulFact;
                this.rLeg03a.zRot = (pi / 2) * mulFact;
                this.lLeg03a.zRot = (pi / 2) * mulFact;

                this.rLeg00a.zRot += rotOff;
                this.lLeg00a.zRot -= rotOff;
                this.rLeg01a.zRot += rotOff;
                this.lLeg01a.zRot -= rotOff;
                this.rLeg02a.zRot += rotOff;
                this.lLeg02a.zRot -= rotOff;
                this.rLeg03a.zRot += rotOff;
                this.lLeg03a.zRot -= rotOff;
            } else {
                float f5 = -(Mth.cos(f * 0.6662F * 2.0F + 0.0F) * 1.0F) * f1;
                float f6 = -(Mth.cos(f * 0.6662F * 2.0F + (float) Math.PI) * 1.0F) * f1;
                float f7 = -(Mth.cos(f * 0.6662F * 2.0F + ((float) Math.PI / 2F)) * 1.0F) * f1;
                float f8 = -(Mth.cos(f * 0.6662F * 2.0F + ((float) Math.PI * 3F / 2F)) * 1.0F) * f1;
                this.rLeg00a.yRot += f5;
                this.lLeg00a.yRot += -f5;
                this.rLeg01a.yRot += f6;
                this.lLeg01a.yRot += -f6;
                this.rLeg02a.yRot += f7;
                this.lLeg02a.yRot += -f7;
                this.rLeg03a.yRot += f8;
                this.lLeg03a.yRot += -f8;
                this.lClaw02.xRot = 0;
                this.rClaw02.xRot = 0;
                this.lClaw01.xRot = 0;
                this.rClaw01.xRot = 0;
                if (crab.snipTime > 0) {
                    float angle = (crab.snipTime % 5) * 0.05F;
                    angle -= (crab.snipTime % 10) * 0.05F;
                    this.lClaw02.xRot = angle;
                    this.rClaw02.xRot = angle;
                    this.lClaw01.xRot = -angle;
                    this.rClaw01.xRot = -angle;
                }

                float mul = 0.05F;
                float div = 20F;
                if (f1 > 0.1) {
                    div = 5F;
                }
                float add = entity.getUUID().hashCode() * 0.001F;
                this.lArm00.xRot = (float) Math.cos(f2 * (mul + 0.05F) + add) / div + 0.3490658503988659F;
                this.rArm00.xRot = (float) Math.cos(-f2 * (mul + 0.05F) + add) / div + 0.3490658503988659F;
                this.lArm00.yRot = (float) Math.cos(f2 * (mul + 0.05F) + add) / div - 1.0471975511965976F;
                this.rArm00.yRot = (float) Math.cos(-f2 * (mul + 0.05F) + add) / div + 1.0471975511965976F;
                this.lArm00.zRot = (float) Math.cos(f2 * (mul + 0.05F) + add) / div;
                this.rArm00.zRot = (float) Math.cos(-f2 * (mul + 0.05F) + add) / div;
            }
        }
    }

}
