package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import dev.itsmeow.betteranimalsplus.common.entity.EntitySquirrel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;

/**
 * squirrelV2 - Batman, Cybercat5555 Created using Tabula 5.1.0
 */
public class ModelSquirrel<T extends LivingEntity> extends ModelBAP<T> {

    public ModelPart chest;
    public ModelPart stomach;
    public ModelPart lArm01;
    public ModelPart rArm01;
    public ModelPart neck;
    public ModelPart lLeg01;
    public ModelPart rLeg01;
    public ModelPart tail01;
    public ModelPart lLeg02;
    public ModelPart lFoot;
    public ModelPart rLeg02;
    public ModelPart rFoot;
    public ModelPart tail02;
    public ModelPart tail01Fluff;
    public ModelPart tail03;
    public ModelPart tail02Fluff;
    public ModelPart tail04;
    public ModelPart lArm02a;
    public ModelPart lArm02b;
    public ModelPart lPaw;
    public ModelPart rArm02a;
    public ModelPart rArm02b;
    public ModelPart rPaw;
    public ModelPart head;
    public ModelPart upperJaw;
    public ModelPart lowerJaw;
    public ModelPart lEar;
    public ModelPart rEar;
    public ModelPart snout;
    public ModelPart lEarFloof;
    public ModelPart rEarFloof;

    public ModelSquirrel(ModelPart root) {
        this.chest = root.getChild("chest");
        this.stomach = chest.getChild("stomach");
        this.lLeg01 = stomach.getChild("lLeg01");
        this.lLeg02 = lLeg01.getChild("lLeg02");
        this.lFoot = lLeg02.getChild("lFoot");
        this.rLeg01 = stomach.getChild("rLeg01");
        this.rLeg02 = rLeg01.getChild("rLeg02");
        this.rFoot = rLeg02.getChild("rFoot");
        this.tail01 = stomach.getChild("tail01");
        this.tail02 = tail01.getChild("tail02");
        this.tail03 = tail02.getChild("tail03");
        this.tail04 = tail03.getChild("tail04");
        this.tail02Fluff = tail02.getChild("tail02Fluff");
        this.tail01Fluff = tail01.getChild("tail01Fluff");
        this.lArm01 = chest.getChild("lArm01");
        this.lArm02a = lArm01.getChild("lArm02a");
        this.lArm02b = lArm02a.getChild("lArm02b");
        this.lPaw = lArm02a.getChild("lPaw");
        this.rArm01 = chest.getChild("rArm01");
        this.rArm02a = rArm01.getChild("rArm02a");
        this.rArm02b = rArm02a.getChild("rArm02b");
        this.rPaw = rArm02a.getChild("rPaw");
        this.neck = chest.getChild("neck");
        this.head = neck.getChild("head");
        this.upperJaw = head.getChild("upperJaw");
        this.snout = upperJaw.getChild("snout");
        this.lowerJaw = head.getChild("lowerJaw");
        this.lEar = head.getChild("lEar");
        this.lEarFloof = lEar.getChild("lEarFloof");
        this.rEar = head.getChild("rEar");
        this.rEarFloof = rEar.getChild("rEarFloof");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition chest = partdefinition.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -2.9F, -7.5F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 16.1F, 3.0F, 0.1047F, 0.0F, 0.0F));
        PartDefinition stomach = chest.addOrReplaceChild("stomach", CubeListBuilder.create().texOffs(0, 13).addBox(-2.5F, -2.9F, -0.9F, 5.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -0.5F, -0.2793F, 0.0F, 0.0F));
        PartDefinition lLeg01 = stomach.addOrReplaceChild("lLeg01", CubeListBuilder.create().texOffs(46, 0).mirror().addBox(-0.3F, -0.9F, -2.5F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.6F, -0.4F, 3.7F, -0.1745F, 0.0F, 0.0F));
        PartDefinition lLeg02 = lLeg01.addOrReplaceChild("lLeg02", CubeListBuilder.create().texOffs(44, 11).mirror().addBox(-1.0F, 0.0F, -1.2F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.2F, 4.2F, -1.2F, 0.6981F, 0.0F, 0.0F));
        PartDefinition lFoot = lLeg02.addOrReplaceChild("lFoot", CubeListBuilder.create().texOffs(50, 14).mirror().addBox(-1.0F, -0.5F, -3.2F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.2F, 4.0F, -0.1F, -0.3491F, -0.1745F, 0.0524F));
        PartDefinition rLeg01 = stomach.addOrReplaceChild("rLeg01", CubeListBuilder.create().texOffs(46, 0).addBox(-2.7F, -0.9F, -2.5F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6F, -0.4F, 3.7F, -0.1745F, 0.0F, 0.0F));
        PartDefinition rLeg02 = rLeg01.addOrReplaceChild("rLeg02", CubeListBuilder.create().texOffs(44, 11).addBox(-1.0F, 0.0F, -1.2F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2F, 4.2F, -1.2F, 0.6981F, 0.0F, 0.0F));
        PartDefinition rFoot = rLeg02.addOrReplaceChild("rFoot", CubeListBuilder.create().texOffs(50, 14).addBox(-1.0F, -0.5F, -3.2F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, 4.0F, -0.1F, -0.3491F, 0.1745F, -0.0524F));
        PartDefinition tail01 = stomach.addOrReplaceChild("tail01", CubeListBuilder.create().texOffs(0, 33).addBox(-1.5F, -1.7F, -0.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5F, 4.4F, 1.0472F, 0.0F, 0.0F));
        PartDefinition tail02 = tail01.addOrReplaceChild("tail02", CubeListBuilder.create().texOffs(0, 40).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 1.0472F, 0.0F, 0.0F));
        PartDefinition tail03 = tail02.addOrReplaceChild("tail03", CubeListBuilder.create().texOffs(0, 50).addBox(-2.5F, -1.9F, -0.8F, 5.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.4F, 0.8727F, 0.0F, 0.0F));
        PartDefinition tail04 = tail03.addOrReplaceChild("tail04", CubeListBuilder.create().texOffs(26, 49).addBox(-2.49F, -2.1F, -0.6F, 5.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, -0.8727F, 0.0F, 0.0F));
        PartDefinition tail02Fluff = tail02.addOrReplaceChild("tail02Fluff", CubeListBuilder.create().texOffs(41, 37).addBox(-1.5F, 1.0F, -4.3F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.5F, 0.192F, 0.0F, 0.0F));
        PartDefinition tail01Fluff = tail01.addOrReplaceChild("tail01Fluff", CubeListBuilder.create().texOffs(26, 37).addBox(-1.0F, 0.5F, -2.9F, 2.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));
        PartDefinition lArm01 = chest.addOrReplaceChild("lArm01", CubeListBuilder.create().texOffs(31, 0).mirror().addBox(-1.0F, -1.6F, -1.0F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 0.7F, -5.0F, -0.2094F, 0.0F, 0.0F));
        PartDefinition lArm02a = lArm01.addOrReplaceChild("lArm02a", CubeListBuilder.create().texOffs(38, 8).mirror().addBox(-0.4F, 0.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.39F, 3.1F, 0.5F, -0.3142F, 0.0F, 0.0F));
        PartDefinition lArm02b = lArm02a.addOrReplaceChild("lArm02b", CubeListBuilder.create().texOffs(31, 8).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.2F, 0.0F, -1.0F));
        PartDefinition lPaw = lArm02a.addOrReplaceChild("lPaw", CubeListBuilder.create().texOffs(30, 15).mirror().addBox(-1.0F, -0.3F, -3.2F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.35F, 3.1F, 0.5F, 0.4189F, 0.0F, 0.0F));
        PartDefinition rArm01 = chest.addOrReplaceChild("rArm01", CubeListBuilder.create().texOffs(31, 0).addBox(-1.0F, -1.6F, -1.0F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 0.7F, -5.0F, -0.2094F, 0.0F, 0.0F));
        PartDefinition rArm02a = rArm01.addOrReplaceChild("rArm02a", CubeListBuilder.create().texOffs(38, 8).addBox(-1.3F, 0.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.41F, 3.1F, 0.5F, -0.3142F, 0.0F, 0.0F));
        PartDefinition rArm02b = rArm02a.addOrReplaceChild("rArm02b", CubeListBuilder.create().texOffs(31, 8).addBox(0.6F, 0.0F, 0.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.2F, 0.0F, -1.0F));
        PartDefinition rPaw = rArm02a.addOrReplaceChild("rPaw", CubeListBuilder.create().texOffs(30, 15).addBox(-1.0F, -0.3F, -3.2F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.35F, 3.1F, 0.5F, 0.4189F, 0.0F, 0.0F));
        PartDefinition neck = chest.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 25).addBox(-1.5F, -2.0F, -2.2F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.8F, -6.9F, -0.192F, 0.0F, 0.0F));
        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(23, 23).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2F, -1.8F, 0.1745F, 0.0F, 0.0F));
        PartDefinition upperJaw = head.addOrReplaceChild("upperJaw", CubeListBuilder.create().texOffs(40, 21).addBox(-1.5F, -0.9F, -1.8F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2F, -3.5F, 0.2269F, 0.0F, 0.0F));
        PartDefinition snout = upperJaw.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(29, 31).addBox(-1.0F, -0.5F, 0.2F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.4F, -2.0F, 0.2094F, 0.0F, 0.0F));
        PartDefinition lowerJaw = head.addOrReplaceChild("lowerJaw", CubeListBuilder.create().texOffs(40, 29).addBox(-1.0F, -0.5F, -2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.3F, -2.8F));
        PartDefinition lEar = head.addOrReplaceChild("lEar", CubeListBuilder.create().texOffs(55, 21).mirror().addBox(-0.5F, -2.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5F, -1.5F, -0.5F, -0.4363F, 0.4887F, 0.2618F));
        PartDefinition lEarFloof = lEar.addOrReplaceChild("lEarFloof", CubeListBuilder.create().texOffs(55, 23).mirror().addBox(-0.2F, -3.0F, -1.5F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -1.8F, 0.0F));
        PartDefinition rEar = head.addOrReplaceChild("rEar", CubeListBuilder.create().texOffs(55, 21).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -1.5F, -0.5F, -0.4363F, -0.4887F, -0.2618F));
        PartDefinition rEarFloof = rEar.addOrReplaceChild("rEarFloof", CubeListBuilder.create().texOffs(55, 23).addBox(0.2F, -3.0F, -1.5F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.8F, 0.0F));
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.chest.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.quadriped(lLeg01, lArm01, rLeg01, rArm01, limbSwing * 0.666F, limbSwingAmount * 1.4F);
        this.tail01.xRot = Mth.sin(limbSwing * 0.2F) * limbSwingAmount - rad(30F);
        this.headPitch(neck, headPitch, 1F, -13F);
        this.headYaw(neck, netHeadYaw, 0.5F, 0F);
        if (entityIn instanceof EntitySquirrel) {
            EntitySquirrel ent = (EntitySquirrel) entityIn;
            this.chest.xRot = ent.isBesideClimbableBlock() ? rad(-90F) : 0.10471975511965977F;
        }
    }

}
