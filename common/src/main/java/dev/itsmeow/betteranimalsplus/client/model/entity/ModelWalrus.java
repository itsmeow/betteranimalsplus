package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;

/**
 * walrus - batman, cybercat5555 Created using Tabula 7.0.1
 */
public class ModelWalrus<T extends LivingEntity> extends ModelBAP<T> {

    public ModelPart body;
    public ModelPart body2;
    public ModelPart neck;
    public ModelPart lFlipper1;
    public ModelPart rFlipper1;
    public ModelPart body3;
    public ModelPart body4;
    public ModelPart lLeg1;
    public ModelPart rLeg1;
    public ModelPart tail;
    public ModelPart lLeg2;
    public ModelPart rLeg2;
    public ModelPart neck2;
    public ModelPart head;
    public ModelPart lowJaw;
    public ModelPart upperJawL;
    public ModelPart upperJawR;
    public ModelPart snout;
    public ModelPart lTusk01;
    public ModelPart lWhiskersF;
    public ModelPart lWhiskersB;
    public ModelPart lTusk02;
    public ModelPart rTusk01;
    public ModelPart rWhiskersF;
    public ModelPart rWhiskersB;
    public ModelPart rTusk02;
    public ModelPart lFlipper2;
    public ModelPart lFlipper3;
    public ModelPart rFlipper2;
    public ModelPart rFlipper3;

    public ModelWalrus(ModelPart root) {
        this.body = root.getChild("body");
        this.body2 = body.getChild("body2");
        this.body3 = body2.getChild("body3");
        this.body4 = body3.getChild("body4");
        this.lLeg1 = body4.getChild("lLeg1");
        this.lLeg2 = lLeg1.getChild("lLeg2");
        this.rLeg1 = body4.getChild("rLeg1");
        this.rLeg2 = rLeg1.getChild("rLeg2");
        this.tail = body4.getChild("tail");
        this.neck = body.getChild("neck");
        this.neck2 = neck.getChild("neck2");
        this.head = neck2.getChild("head");
        this.lowJaw = head.getChild("lowJaw");
        this.upperJawL = head.getChild("upperJawL");
        this.lTusk01 = upperJawL.getChild("lTusk01");
        this.lTusk02 = lTusk01.getChild("lTusk02");
        this.lWhiskersF = upperJawL.getChild("lWhiskersF");
        this.lWhiskersB = upperJawL.getChild("lWhiskersB");
        this.upperJawR = head.getChild("upperJawR");
        this.rTusk01 = upperJawR.getChild("rTusk01");
        this.rTusk02 = rTusk01.getChild("rTusk02");
        this.rWhiskersF = upperJawR.getChild("rWhiskersF");
        this.rWhiskersB = upperJawR.getChild("rWhiskersB");
        this.snout = head.getChild("snout");
        this.lFlipper1 = body.getChild("lFlipper1");
        this.lFlipper2 = lFlipper1.getChild("lFlipper2");
        this.lFlipper3 = lFlipper2.getChild("lFlipper3");
        this.rFlipper1 = body.getChild("rFlipper1");
        this.rFlipper2 = rFlipper1.getChild("rFlipper2");
        this.rFlipper3 = rFlipper2.getChild("rFlipper3");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -3.5F, -12.0F, 12.0F, 13.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.6F, -2.0F));
        PartDefinition body2 = body.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(0, 26).addBox(-5.5F, -2.5F, 0.0F, 11.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.4F, -0.7F, -0.0349F, 0.0F, 0.0F));
        PartDefinition body3 = body2.addOrReplaceChild("body3", CubeListBuilder.create().texOffs(45, 29).addBox(-4.5F, -2.0F, 0.0F, 9.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.4F, 9.4F, -0.1396F, 0.0F, 0.0F));
        PartDefinition body4 = body3.addOrReplaceChild("body4", CubeListBuilder.create().texOffs(0, 48).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.1F, 6.3F, -0.3142F, 0.0F, 0.0F));
        PartDefinition lLeg1 = body4.addOrReplaceChild("lLeg1", CubeListBuilder.create().texOffs(110, 0).mirror().addBox(-1.5F, 0.0F, -2.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.5F, 2.4F, 6.2F, 0.576F, 1.7453F, 0.0F));
        PartDefinition lLeg2 = lLeg1.addOrReplaceChild("lLeg2", CubeListBuilder.create().texOffs(110, 12).mirror().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.7F, -0.2F, 0.7854F, 0.7854F, -0.0873F));
        PartDefinition rLeg1 = body4.addOrReplaceChild("rLeg1", CubeListBuilder.create().texOffs(110, 0).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 2.4F, 6.2F, 0.576F, -1.7453F, 0.0F));
        PartDefinition rLeg2 = rLeg1.addOrReplaceChild("rLeg2", CubeListBuilder.create().texOffs(110, 12).addBox(-3.0F, 0.0F, -0.5F, 6.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.7F, -0.2F, 0.7854F, -0.7854F, 0.0873F));
        PartDefinition tail = body4.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(79, 37).addBox(-1.5F, -1.0F, 0.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.9F, 7.5F, -0.5236F, 0.0F, 0.0F));
        PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(86, 41).addBox(-5.0F, -1.5F, -11.0F, 10.0F, 10.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.3F, -5.1F, -0.7156F, 0.0F, 0.0F));
        PartDefinition neck2 = neck.addOrReplaceChild("neck2", CubeListBuilder.create().texOffs(42, 48).addBox(-4.0F, -1.5F, -7.0F, 8.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -10.6F, 0.1745F, 0.0F, 0.0F));
        PartDefinition head = neck2.addOrReplaceChild("head", CubeListBuilder.create().texOffs(58, 0).addBox(-3.5F, -1.5F, -6.0F, 7.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.4F, -5.8F, 0.6981F, 0.0F, 0.0F));
        PartDefinition lowJaw = head.addOrReplaceChild("lowJaw", CubeListBuilder.create().texOffs(41, 0).addBox(-2.0F, -0.5F, -3.5F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.9F, -5.4F));
        PartDefinition upperJawL = head.addOrReplaceChild("upperJawL", CubeListBuilder.create().texOffs(71, 15).addBox(-2.0F, -2.0F, -5.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 2.8F, -4.8F, 0.0F, 0.0349F, 0.2793F));
        PartDefinition lTusk01 = upperJawL.addOrReplaceChild("lTusk01", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 1.6F, -3.3F, 0.0349F, 0.0F, -0.2793F));
        PartDefinition lTusk02 = lTusk01.addOrReplaceChild("lTusk02", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.9F, 0.0F, 0.1222F, 0.0F, 0.0F));
        PartDefinition lWhiskersF = upperJawL.addOrReplaceChild("lWhiskersF", CubeListBuilder.create().texOffs(76, 50).addBox(-2.1F, 0.0F, -0.5F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.3F, -4.6F, -0.1745F, -0.0873F, -0.1745F));
        PartDefinition lWhiskersB = upperJawL.addOrReplaceChild("lWhiskersB", CubeListBuilder.create().texOffs(76, 51).addBox(-1.0F, 0.0F, -0.3F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.4F, -4.5F, 0.0F, 0.0F, -0.2618F));
        PartDefinition upperJawR = head.addOrReplaceChild("upperJawR", CubeListBuilder.create().texOffs(71, 15).mirror().addBox(-2.0F, -2.0F, -5.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 2.8F, -4.8F, 0.0F, -0.0349F, -0.2793F));
        PartDefinition rTusk01 = upperJawR.addOrReplaceChild("rTusk01", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 1.6F, -3.5F, 0.0349F, 0.0F, 0.2793F));
        PartDefinition rTusk02 = rTusk01.addOrReplaceChild("rTusk02", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.9F, 0.0F, 0.1222F, 0.0F, 0.0F));
        PartDefinition rWhiskersF = upperJawR.addOrReplaceChild("rWhiskersF", CubeListBuilder.create().texOffs(76, 50).mirror().addBox(-2.1F, 0.0F, -0.5F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.3F, -4.6F, -0.1745F, 0.0873F, 0.1745F));
        PartDefinition rWhiskersB = upperJawR.addOrReplaceChild("rWhiskersB", CubeListBuilder.create().texOffs(76, 51).mirror().addBox(0.0F, 0.0F, -1.7F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 0.4F, -3.0F, 0.0F, 0.0F, 0.2618F));
        PartDefinition snout = head.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(50, 15).addBox(-3.0F, -1.5F, -3.9F, 6.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -5.5F, 0.4554F, 0.0F, 0.0F));
        PartDefinition lFlipper1 = body.addOrReplaceChild("lFlipper1", CubeListBuilder.create().texOffs(89, 0).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 5.0F, -9.0F, -0.1396F, 0.0F, -0.9425F));
        PartDefinition lFlipper2 = lFlipper1.addOrReplaceChild("lFlipper2", CubeListBuilder.create().texOffs(90, 11).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 4.5F, -2.0F, 0.576F, 0.0F, -0.4538F));
        PartDefinition lFlipper3 = lFlipper2.addOrReplaceChild("lFlipper3", CubeListBuilder.create().texOffs(90, 21).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4F, 3.8F, 0.0F, 0.6283F, 0.0F, -0.0873F));
        PartDefinition rFlipper1 = body.addOrReplaceChild("rFlipper1", CubeListBuilder.create().texOffs(89, 0).mirror().addBox(-1.5F, 0.0F, -2.0F, 3.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 5.0F, -9.0F, -0.1396F, 0.0F, 0.9425F));
        PartDefinition rFlipper2 = rFlipper1.addOrReplaceChild("rFlipper2", CubeListBuilder.create().texOffs(90, 11).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, 4.5F, -2.0F, 0.576F, 0.0F, 0.4538F));
        PartDefinition rFlipper3 = rFlipper2.addOrReplaceChild("rFlipper3", CubeListBuilder.create().texOffs(90, 21).mirror().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.4F, 3.8F, 0.0F, 0.6283F, 0.0F, 0.0873F));
        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.setRotateAngle(lLeg2, 0.7853981633974483F, 0.7853981633974483F, -0.08726646259971647F);
        this.setRotateAngle(rLeg2, 0.7853981633974483F, -0.7853981633974483F, 0.08726646259971647F);
        this.setRotateAngle(lLeg1, 0.5759586531581287F, 1.7453292519943295F, 0.0F);
        this.setRotateAngle(rLeg1, 0.5759586531581287F, -1.7453292519943295F, 0.0F);
        this.setRotateAngle(rFlipper2, 0.5759586531581287F, 0.0F, 0.45378560551852565F);
        this.setRotateAngle(lFlipper2, 0.5759586531581287F, 0.0F, -0.45378560551852565F);
        this.neck.xRot = -0.7155849933176751F;
        this.neck.y = 2.3F;

        this.headPitch(head, headPitch, 0F, rad(40F));
        this.neck2.yRot = rad(Mth.clamp(netHeadYaw, -35F, 35F));
        if (!entity.isInWater()) {
            this.lLeg1.xRot = 0.5759586531581287F * 1.75F;
            this.rLeg1.xRot = 0.5759586531581287F * 1.75F;
            this.lLeg1.yRot = (float) Math.sin(limbSwing * 1.5F) * limbSwingAmount * 1.5F + 1.7453292519943295F - 0.6F;
            this.rLeg1.yRot = (float) Math.cos(limbSwing * 1.5F) * limbSwingAmount * 1.5F - 1.7453292519943295F + 0.6F;
            this.lFlipper2.xRot = (float) Math.cos(limbSwing * 1.5F) * limbSwingAmount * 1.5F - 0.5759586531581287F / 3F;
            this.rFlipper2.xRot = (float) Math.sin(limbSwing * 1.5F) * limbSwingAmount * 1.5F - 0.5759586531581287F / 3F;
        } else {
            this.head.xRot -= 0.6981317007977318F;
            this.neck.xRot = 0F;
            this.neck.y = -1.15F;
            this.lFlipper2.zRot = 0F;
            this.rFlipper2.zRot = 0F;
            this.lFlipper2.yRot = (float) Math.sin(-limbSwing * 0.25F) * limbSwingAmount * 0.5F;
            this.rFlipper2.yRot = (float) Math.sin(limbSwing * 0.25F) * limbSwingAmount * 0.5F;
            this.lLeg1.xRot = 0.5759586531581287F * 3F;
            this.rLeg1.xRot = 0.5759586531581287F * 3F;
            this.lLeg1.yRot = 0F;
            this.rLeg1.yRot = 0F;
            this.lLeg2.zRot = 0F;
            this.rLeg2.zRot = 0F;
            this.rLeg2.yRot = -(float) Math.PI / 2F;
            this.lLeg2.yRot = (float) Math.PI / 2F;
            this.rLeg2.xRot = -(float) Math.sin(-limbSwing * 0.25F) * limbSwingAmount * 1F;
            this.lLeg2.xRot = -(float) Math.sin(limbSwing * 0.25F) * limbSwingAmount * 1F;
        }
    }

}
