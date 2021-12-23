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

public class ModelSquirrel<T extends LivingEntity> extends ModelBAP<T> {

    public ModelPart lowerBody;
    public ModelPart chest;
    public ModelPart head;
    public ModelPart muzzle;
    public ModelPart lEar;
    public ModelPart rEar;
    public ModelPart lArm;
    public ModelPart rArm;
    public ModelPart lLeg01;
    public ModelPart lLeg02;
    public ModelPart rLeg01;
    public ModelPart rLeg02;
    public ModelPart tail01;
    public ModelPart tail02;
    public ModelPart tail03;
    public ModelPart tail04;

    public ModelSquirrel(ModelPart root) {
        this.lowerBody = root.getChild("lowerBody");
        this.chest = lowerBody.getChild("chest");
        this.head = chest.getChild("head");
        this.muzzle = head.getChild("muzzle");
        this.lEar = head.getChild("lEar");
        this.rEar = head.getChild("rEar");
        this.lArm = chest.getChild("lArm");
        this.rArm = chest.getChild("rArm");
        this.lLeg01 = lowerBody.getChild("lLeg01");
        this.lLeg02 = lLeg01.getChild("lLeg02");
        this.rLeg01 = lowerBody.getChild("rLeg01");
        this.rLeg02 = rLeg01.getChild("rLeg02");
        this.tail01 = lowerBody.getChild("tail01");
        this.tail02 = tail01.getChild("tail02");
        this.tail03 = tail02.getChild("tail03");
        this.tail04 = tail03.getChild("tail04");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition lowerBody = partdefinition.addOrReplaceChild("lowerBody", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.5F, -4.0F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 20.0F, 4.0F));
        PartDefinition chest = lowerBody.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 10).addBox(-2.0F, -2.0F, -4.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.25F));
        PartDefinition head = chest.addOrReplaceChild("head", CubeListBuilder.create().texOffs(19, 0).addBox(-1.5F, -1.75F, -2.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -4.0F));
        PartDefinition muzzle = head.addOrReplaceChild("muzzle", CubeListBuilder.create().texOffs(19, 5).addBox(-1.0F, -0.75F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.25F, -1.75F));
        PartDefinition lEar = head.addOrReplaceChild("lEar", CubeListBuilder.create().texOffs(14, 0).addBox(-0.75F, -3.0F, 0.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -1.0F, -1.0F, 0.0873F, -0.6545F, 0.3054F));
        PartDefinition rEar = head.addOrReplaceChild("rEar", CubeListBuilder.create().texOffs(14, 0).mirror().addBox(-1.25F, -3.0F, 0.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -1.0F, -1.0F, 0.0873F, 0.6545F, -0.3054F));
        PartDefinition lArm = chest.addOrReplaceChild("lArm", CubeListBuilder.create().texOffs(0, 0).addBox(-0.75F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, -2.5F));
        PartDefinition rArm = chest.addOrReplaceChild("rArm", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.25F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 0.0F, -2.5F));
        PartDefinition lLeg01 = lowerBody.addOrReplaceChild("lLeg01", CubeListBuilder.create().texOffs(0, 20).addBox(0.0F, -1.0F, -2.0F, 2.0F, 4.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(1.5F, 0.0F, -1.5F, -0.1309F, 0.0F, 0.0F));
        PartDefinition lLeg02 = lLeg01.addOrReplaceChild("lLeg02", CubeListBuilder.create().texOffs(11, 27).addBox(-1.0F, 0.0F, -3.75F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, 2.75F, 2.75F, 0.1309F, 0.0F, 0.0F));
        PartDefinition rLeg01 = lowerBody.addOrReplaceChild("rLeg01", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(-2.0F, -1.0F, -2.0F, 2.0F, 4.0F, 5.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 0.0F, -1.5F, -0.1309F, 0.0F, 0.0F));
        PartDefinition rLeg02 = rLeg01.addOrReplaceChild("rLeg02", CubeListBuilder.create().texOffs(11, 27).mirror().addBox(-1.0F, 0.0F, -3.75F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.75F, 2.75F, 2.75F, 0.1309F, 0.0F, 0.0F));
        PartDefinition tail01 = lowerBody.addOrReplaceChild("tail01", CubeListBuilder.create().texOffs(20, 9).addBox(-1.5F, -2.0F, -0.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 1.0F, -0.8727F, 0.0F, 0.0F));
        PartDefinition tail02 = tail01.addOrReplaceChild("tail02", CubeListBuilder.create().texOffs(20, 17).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, -1.75F, 1.0F, 0.9599F, 0.0F, 0.0F));
        PartDefinition tail03 = tail02.addOrReplaceChild("tail03", CubeListBuilder.create().texOffs(20, 9).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.9599F, 0.0F, 0.0F));
        PartDefinition tail04 = tail03.addOrReplaceChild("tail04", CubeListBuilder.create().texOffs(20, 17).addBox(-1.5F, -5.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, -3.25F, -0.25F, -0.6545F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.lowerBody.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.quadriped(lLeg01, lArm, rLeg01, rArm, limbSwing * 0.666F, limbSwingAmount * 1.4F);
        this.tail01.xRot = Mth.sin(limbSwing * 0.2F) * limbSwingAmount - rad(30F);
        this.headPitch(head, headPitch);
        this.headYaw(head, netHeadYaw, 0.5F, 0F);
        if (entityIn instanceof EntitySquirrel) {
            EntitySquirrel ent = (EntitySquirrel) entityIn;
            this.lowerBody.xRot = ent.isBesideClimbableBlock() ? rad(-90F) : 0F;
        }
    }

}
