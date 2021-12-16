package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;

/**
 * nautilus - cybercat5555
 * Created using Tabula 5.1.0
 */
public class ModelNautilus<T extends LivingEntity> extends ModelBAP<T> {

    public ModelPart shell;
    public ModelPart lTentacle01a;
    public ModelPart lTentacle02a;
    public ModelPart lTentacle04a;
    public ModelPart lTentacle03a;
    public ModelPart rTentacle01a;
    public ModelPart rTentacle02a;
    public ModelPart rTentacle04a;
    public ModelPart rTentacle03a;
    public ModelPart shellEdge;
    public ModelPart headShield;
    public ModelPart head;
    public ModelPart lEye;
    public ModelPart rEye;
    public ModelPart lTentacle01b;
    public ModelPart lTentacle02b;
    public ModelPart lTentacle03b;
    public ModelPart lTentacle04b;
    public ModelPart rTentacle01b;
    public ModelPart rTentacle02b;
    public ModelPart rTentacle04b;
    public ModelPart rTentacle03b;

    public ModelNautilus(ModelPart root) {
        this.shell = root.getChild("shell");
        this.shellEdge = shell.getChild("shellEdge");
        this.headShield = shell.getChild("headShield");
        this.head = shell.getChild("head");
        this.lEye = head.getChild("lEye");
        this.rEye = head.getChild("rEye");
        this.lTentacle01a = root.getChild("lTentacle01a");
        this.lTentacle01b = lTentacle01a.getChild("lTentacle01b");
        this.lTentacle02a = root.getChild("lTentacle02a");
        this.lTentacle02b = lTentacle02a.getChild("lTentacle02b");
        this.lTentacle04a = root.getChild("lTentacle04a");
        this.lTentacle04b = lTentacle04a.getChild("lTentacle04b");
        this.lTentacle03a = root.getChild("lTentacle03a");
        this.lTentacle03b = lTentacle03a.getChild("lTentacle03b");
        this.rTentacle01a = root.getChild("rTentacle01a");
        this.rTentacle01b = rTentacle01a.getChild("rTentacle01b");
        this.rTentacle02a = root.getChild("rTentacle02a");
        this.rTentacle02b = rTentacle02a.getChild("rTentacle02b");
        this.rTentacle04a = root.getChild("rTentacle04a");
        this.rTentacle04b = rTentacle04a.getChild("rTentacle04b");
        this.rTentacle03a = root.getChild("rTentacle03a");
        this.rTentacle03b = rTentacle03a.getChild("rTentacle03b");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition shell = partdefinition.addOrReplaceChild("shell", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -4.5F, -4.5F, 5.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, 1.0F));
        PartDefinition shellEdge = shell.addOrReplaceChild("shellEdge", CubeListBuilder.create().texOffs(0, 19).addBox(-2.5F, -1.0F, -4.8F, 5.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.6F, -3.6F, -0.0911F, 0.0F, 0.0F));
        PartDefinition headShield = shell.addOrReplaceChild("headShield", CubeListBuilder.create().texOffs(21, 0).addBox(-3.0F, -1.0F, -5.0F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.1F, -3.6F, 0.182F, 0.0F, 0.0F));
        PartDefinition head = shell.addOrReplaceChild("head", CubeListBuilder.create().texOffs(29, 9).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -4.4F));
        PartDefinition lEye = head.addOrReplaceChild("lEye", CubeListBuilder.create().texOffs(44, 9).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3F, 0.2F, -1.1F, 0.7854F, 0.0F, 0.0F));
        PartDefinition rEye = head.addOrReplaceChild("rEye", CubeListBuilder.create().texOffs(44, 9).mirror().addBox(0.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.3F, 0.2F, -1.1F, 0.7854F, 0.0F, 0.0F));
        PartDefinition lTentacle01a = partdefinition.addOrReplaceChild("lTentacle01a", CubeListBuilder.create().texOffs(29, 19).mirror().addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.6F, 14.9F, -6.0F, 0.2731F, -0.2276F, 0.0F));
        PartDefinition lTentacle01b = lTentacle01a.addOrReplaceChild("lTentacle01b", CubeListBuilder.create().texOffs(29, 19).mirror().addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -2.9F, 0.182F, 0.0F, 0.0F));
        PartDefinition lTentacle02a = partdefinition.addOrReplaceChild("lTentacle02a", CubeListBuilder.create().texOffs(29, 19).mirror().addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.6F, 16.5F, -6.0F, 0.4554F, -0.182F, 0.0F));
        PartDefinition lTentacle02b = lTentacle02a.addOrReplaceChild("lTentacle02b", CubeListBuilder.create().texOffs(29, 19).mirror().addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -2.9F, 0.182F, 0.0F, 0.0F));
        PartDefinition lTentacle04a = partdefinition.addOrReplaceChild("lTentacle04a", CubeListBuilder.create().texOffs(29, 19).mirror().addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.6F, 15.0F, -6.0F, 0.3187F, -0.182F, 0.0F));
        PartDefinition lTentacle04b = lTentacle04a.addOrReplaceChild("lTentacle04b", CubeListBuilder.create().texOffs(29, 19).mirror().addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -2.9F, 0.182F, 0.0F, 0.0F));
        PartDefinition lTentacle03a = partdefinition.addOrReplaceChild("lTentacle03a", CubeListBuilder.create().texOffs(29, 19).mirror().addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.6F, 16.2F, -6.0F, 0.3643F, -0.1367F, 0.0F));
        PartDefinition lTentacle03b = lTentacle03a.addOrReplaceChild("lTentacle03b", CubeListBuilder.create().texOffs(29, 19).mirror().addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -2.9F, 0.182F, 0.0F, 0.0F));
        PartDefinition rTentacle01a = partdefinition.addOrReplaceChild("rTentacle01a", CubeListBuilder.create().texOffs(29, 19).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6F, 14.9F, -6.0F, 0.2731F, 0.2276F, 0.0F));
        PartDefinition rTentacle01b = rTentacle01a.addOrReplaceChild("rTentacle01b", CubeListBuilder.create().texOffs(29, 19).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.9F, 0.182F, 0.0F, 0.0F));
        PartDefinition rTentacle02a = partdefinition.addOrReplaceChild("rTentacle02a", CubeListBuilder.create().texOffs(29, 19).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6F, 16.5F, -6.0F, 0.4554F, 0.182F, 0.0F));
        PartDefinition rTentacle02b = rTentacle02a.addOrReplaceChild("rTentacle02b", CubeListBuilder.create().texOffs(29, 19).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.9F, 0.182F, 0.0F, 0.0F));
        PartDefinition rTentacle04a = partdefinition.addOrReplaceChild("rTentacle04a", CubeListBuilder.create().texOffs(29, 19).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6F, 15.0F, -6.0F, 0.3187F, 0.182F, 0.0F));
        PartDefinition rTentacle04b = rTentacle04a.addOrReplaceChild("rTentacle04b", CubeListBuilder.create().texOffs(29, 19).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.9F, 0.182F, 0.0F, 0.0F));
        PartDefinition rTentacle03a = partdefinition.addOrReplaceChild("rTentacle03a", CubeListBuilder.create().texOffs(29, 19).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6F, 16.2F, -6.0F, 0.3643F, 0.1367F, 0.0F));
        PartDefinition rTentacle03b = rTentacle03a.addOrReplaceChild("rTentacle03b", CubeListBuilder.create().texOffs(29, 19).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.9F, 0.182F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        shell.render(poseStack, buffer, packedLight, packedOverlay);
        lTentacle01a.render(poseStack, buffer, packedLight, packedOverlay);
        lTentacle02a.render(poseStack, buffer, packedLight, packedOverlay);
        lTentacle04a.render(poseStack, buffer, packedLight, packedOverlay);
        lTentacle03a.render(poseStack, buffer, packedLight, packedOverlay);
        rTentacle01a.render(poseStack, buffer, packedLight, packedOverlay);
        rTentacle02a.render(poseStack, buffer, packedLight, packedOverlay);
        rTentacle04a.render(poseStack, buffer, packedLight, packedOverlay);
        rTentacle03a.render(poseStack, buffer, packedLight, packedOverlay);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float mul = 0.3F;
        float div = 20F;
        float add = entityIn.getUUID().hashCode() * 0.001F;
        lTentacle01a.xRot = (float) Math.cos(ageInTicks * (mul + 0.05F) + add) / div;
        lTentacle02a.xRot = (float) Math.cos(ageInTicks * mul + add) / div;
        lTentacle04a.xRot = (float) Math.cos(ageInTicks * (mul + 0.1F) + add) / div;
        lTentacle03a.xRot = (float) Math.sin(ageInTicks * mul + add) / div;
        rTentacle01a.xRot = (float) Math.cos(ageInTicks * mul + add) / div;
        rTentacle02a.xRot = (float) Math.cos(ageInTicks * (mul + 0.03F) + add) / div;
        rTentacle04a.xRot = (float) Math.cos(ageInTicks * mul + add) / div;
        rTentacle03a.xRot = (float) Math.sin(ageInTicks * (mul + 0.15F) + add) / div;
    }

}
