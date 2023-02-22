package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;

public class ModelCrocodile<T extends LivingEntity> extends ModelBAP<T> {

    public ModelPart butt;
    public ModelPart chest;
    public ModelPart neck;
    public ModelPart head;
    public ModelPart topJaw;
    public ModelPart topJawL;
    public ModelPart tTeethL2;
    public ModelPart topJawR;
    public ModelPart tTeethR2;
    public ModelPart snout;
    public ModelPart cranium;
    public ModelPart tTeethL3;
    public ModelPart tTeethR3;
    public ModelPart tTeethFront;
    public ModelPart lowJaw;
    public ModelPart lowJaw2;
    public ModelPart lowJaw3;
    public ModelPart tTeethL1;
    public ModelPart tTeethR1;
    public ModelPart lArm1;
    public ModelPart lArm2;
    public ModelPart lFoot;
    public ModelPart rArm1;
    public ModelPart rArm2;
    public ModelPart rHand;
    public ModelPart tail1;
    public ModelPart tail2;
    public ModelPart tail3;
    public ModelPart tail4;
    public ModelPart tail5;
    public ModelPart tail6;
    public ModelPart lLeg1;
    public ModelPart lLeg2;
    public ModelPart lFoot2;
    public ModelPart rLeg;
    public ModelPart rLeg2;
    public ModelPart rFoot;

    public ModelCrocodile(ModelPart root) {
        this.butt = root.getChild("butt");
        this.chest = butt.getChild("chest");
        this.neck = chest.getChild("neck");
        this.head = neck.getChild("head");
        this.topJaw = head.getChild("topJaw");
        this.topJawL = topJaw.getChild("topJawL");
        this.tTeethL2 = topJawL.getChild("tTeethL2");
        this.topJawR = topJaw.getChild("topJawR");
        this.tTeethR2 = topJawR.getChild("tTeethR2");
        this.snout = topJaw.getChild("snout");
        this.cranium = snout.getChild("cranium");
        this.tTeethL3 = snout.getChild("tTeethL3");
        this.tTeethR3 = snout.getChild("tTeethR3");
        this.tTeethFront = snout.getChild("tTeethFront");
        this.lowJaw = head.getChild("lowJaw");
        this.lowJaw2 = lowJaw.getChild("lowJaw2");
        this.lowJaw3 = lowJaw2.getChild("lowJaw3");
        this.tTeethL1 = head.getChild("tTeethL1");
        this.tTeethR1 = head.getChild("tTeethR1");
        this.lArm1 = chest.getChild("lArm1");
        this.lArm2 = lArm1.getChild("lArm2");
        this.lFoot = lArm2.getChild("lFoot");
        this.rArm1 = chest.getChild("rArm1");
        this.rArm2 = rArm1.getChild("rArm2");
        this.rHand = rArm2.getChild("rHand");
        this.tail1 = butt.getChild("tail1");
        this.tail2 = tail1.getChild("tail2");
        this.tail3 = tail2.getChild("tail3");
        this.tail4 = tail3.getChild("tail4");
        this.tail5 = tail4.getChild("tail5");
        this.tail6 = tail5.getChild("tail6");
        this.lLeg1 = butt.getChild("lLeg1");
        this.lLeg2 = lLeg1.getChild("lLeg2");
        this.lFoot2 = lLeg2.getChild("lFoot2");
        this.rLeg = butt.getChild("rLeg");
        this.rLeg2 = rLeg.getChild("rLeg2");
        this.rFoot = rLeg2.getChild("rFoot");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition butt = partdefinition.addOrReplaceChild("butt", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -2.0F, -0.1F, 16.0F, 10.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.5F, -7.5F));
        PartDefinition chest = butt.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 27).addBox(-7.0F, 0.0F, -12.0F, 14.0F, 9.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.7F, 1.3F, 0.0911F, 0.0F, 0.0F));
        PartDefinition neck = chest.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 47).addBox(-4.5F, -1.0F, -8.0F, 9.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -11.2F, 0.0456F, 0.0F, 0.0F));
        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 64).addBox(-4.5F, -2.0F, -4.0F, 9.0F, 5.0F, 4.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(0.0F, 1.0F, -7.5F, -0.0911F, 0.0F, 0.0F));
        PartDefinition topJaw = head.addOrReplaceChild("topJaw", CubeListBuilder.create().texOffs(37, 52).addBox(-2.5F, -2.0F, -12.0F, 5.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 75).addBox(-2.5F, 0.0F, -12.0F, 5.0F, 1.0F, 12.0F, new CubeDeformation(0.001F)), PartPose.offset(0.0F, 3.0F, -4.0F));
        PartDefinition topJawL = topJaw.addOrReplaceChild("topJawL", CubeListBuilder.create(), PartPose.offsetAndRotation(0.7F, -3.1F, -8.0F, 0.0F, -0.182F, 0.0F));
        PartDefinition tTeethL2 = topJawL.addOrReplaceChild("tTeethL2", CubeListBuilder.create(), PartPose.offset(-3.01F, 2.5F, -1.0F));
        PartDefinition topJawR = topJaw.addOrReplaceChild("topJawR", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.7F, -3.1F, -8.0F, 0.0F, 0.182F, 0.0F));
        PartDefinition tTeethR2 = topJawR.addOrReplaceChild("tTeethR2", CubeListBuilder.create(), PartPose.offset(4.01F, 2.5F, -1.0F));
        PartDefinition snout = topJaw.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(20, 98).addBox(-1.5F, -3.0F, -2.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -9.7F));
        PartDefinition cranium = snout.addOrReplaceChild("cranium", CubeListBuilder.create().texOffs(0, 96).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.3F, 0.0F, 0.182F, 0.0F, 0.0F));
        PartDefinition tTeethL3 = snout.addOrReplaceChild("tTeethL3", CubeListBuilder.create(), PartPose.offset(-2.51F, -0.7F, -1.9F));
        PartDefinition tTeethR3 = snout.addOrReplaceChild("tTeethR3", CubeListBuilder.create(), PartPose.offset(0.51F, -0.7F, -1.9F));
        PartDefinition tTeethFront = snout.addOrReplaceChild("tTeethFront", CubeListBuilder.create(), PartPose.offset(0.0F, -0.7F, -2.01F));
        PartDefinition lowJaw = head.addOrReplaceChild("lowJaw", CubeListBuilder.create().texOffs(0, 110).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.001F)), PartPose.offset(0.0F, 2.9F, 0.0F));
        PartDefinition lowJaw2 = lowJaw.addOrReplaceChild("lowJaw2", CubeListBuilder.create().texOffs(0, 118).addBox(-2.5F, 0.0F, -12.0F, 5.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(36, 117).addBox(-2.5F, -1.4F, -12.0F, 5.0F, 2.0F, 12.0F, new CubeDeformation(0.05F)), PartPose.offset(0.0F, 0.0F, -4.0F));
        PartDefinition lowJaw3 = lowJaw2.addOrReplaceChild("lowJaw3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.1F, -9.7F));
        PartDefinition tTeethL1 = head.addOrReplaceChild("tTeethL1", CubeListBuilder.create(), PartPose.offset(-4.51F, 2.0F, -4.0F));
        PartDefinition tTeethR1 = head.addOrReplaceChild("tTeethR1", CubeListBuilder.create(), PartPose.offset(4.51F, 2.0F, -4.0F));
        PartDefinition lArm1 = chest.addOrReplaceChild("lArm1", CubeListBuilder.create().texOffs(50, 0).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, 6.0F, -7.0F, 0.0F, 0.0F, -1.309F));
        PartDefinition lArm2 = lArm1.addOrReplaceChild("lArm2", CubeListBuilder.create().texOffs(68, 0).mirror().addBox(-1.5F, 0.158F, -1.9263F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.5F, 0.75F, -1.2298F, 0.0F, 0.0F));
        PartDefinition lFoot = lArm2.addOrReplaceChild("lFoot", CubeListBuilder.create().texOffs(71, 11).mirror().addBox(-2.0F, -0.25F, -4.0F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.4887F, -1.0996F, 1.1519F));
        PartDefinition rArm1 = chest.addOrReplaceChild("rArm1", CubeListBuilder.create().texOffs(50, 0).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 6.0F, -7.0F, 0.0F, 0.0F, 1.309F));
        PartDefinition rArm2 = rArm1.addOrReplaceChild("rArm2", CubeListBuilder.create().texOffs(68, 0).addBox(-1.5F, 0.158F, -1.9263F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.5F, 0.75F, -1.2298F, 0.0F, 0.0F));
        PartDefinition rHand = rArm2.addOrReplaceChild("rHand", CubeListBuilder.create().texOffs(71, 11).addBox(-2.0F, -0.25F, -4.0F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.4887F, 1.0996F, -1.1519F));
        PartDefinition tail1 = butt.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(0, 144).addBox(-6.0F, -4.5F, 0.0F, 12.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 15.0F, -0.1367F, 0.0F, 0.0F));
        PartDefinition tail2 = tail1.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(0, 160).addBox(-5.0F, -4.0F, 0.0F, 10.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 6.7F));
        PartDefinition tail3 = tail2.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(0, 177).addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 8.7F));
        PartDefinition tail4 = tail3.addOrReplaceChild("tail4", CubeListBuilder.create().texOffs(0, 194).addBox(-3.5F, -3.0F, 0.0F, 7.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 8.7F, 0.0456F, 0.0F, 0.0F));
        PartDefinition tail5 = tail4.addOrReplaceChild("tail5", CubeListBuilder.create().texOffs(0, 209).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 8.7F, -0.0456F, 0.0F, 0.0F));
        PartDefinition tail6 = tail5.addOrReplaceChild("tail6", CubeListBuilder.create().texOffs(0, 223).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 7.7F));
        PartDefinition tailSpikesL6 = tail6.addOrReplaceChild("tailSpikesL6", CubeListBuilder.create().texOffs(35, 97).addBox(0.0F, -3.0F, 0.0F, 0.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -2.7F, 0.0F, 0.0F, 0.0911F, 0.0F));
        PartDefinition tailSpikesR6 = tail6.addOrReplaceChild("tailSpikesR6", CubeListBuilder.create().texOffs(35, 97).addBox(0.0F, -3.0F, 0.0F, 0.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -2.7F, 0.0F, 0.0F, -0.0911F, 0.0F));
        PartDefinition tailSpikesL5 = tail5.addOrReplaceChild("tailSpikesL5", CubeListBuilder.create().texOffs(35, 92).addBox(0.0F, -3.0F, 0.0F, 0.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -3.2F, 0.0F, 0.0F, 0.0911F, 0.0F));
        PartDefinition tailSpikesR5 = tail5.addOrReplaceChild("tailSpikesR5", CubeListBuilder.create().texOffs(35, 92).addBox(0.0F, -3.0F, 0.0F, 0.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -3.2F, 0.0F, 0.0F, -0.0911F, 0.0F));
        PartDefinition tailSpikesL4 = tail4.addOrReplaceChild("tailSpikesL4", CubeListBuilder.create().texOffs(35, 86).addBox(0.0F, -3.0F, 0.0F, 0.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -3.8F, 0.0F, 0.0F, 0.0911F, 0.0F));
        PartDefinition tailSpikesR4 = tail4.addOrReplaceChild("tailSpikesR4", CubeListBuilder.create().texOffs(35, 86).addBox(0.0F, -3.0F, 0.0F, 0.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -3.8F, 0.0F, 0.0F, -0.0911F, 0.0F));
        PartDefinition tailSpikesL3 = tail3.addOrReplaceChild("tailSpikesL3", CubeListBuilder.create().texOffs(35, 82).addBox(0.0F, -2.0F, 0.0F, 0.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -4.2F, 0.0F, 0.0F, 0.0911F, 0.0F));
        PartDefinition tailSpikesR3 = tail3.addOrReplaceChild("tailSpikesR3", CubeListBuilder.create().texOffs(35, 82).addBox(0.0F, -2.0F, 0.0F, 0.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -4.2F, 0.0F, 0.0F, -0.0911F, 0.0F));
        PartDefinition tailSpikesL2 = tail2.addOrReplaceChild("tailSpikesL2", CubeListBuilder.create().texOffs(35, 78).addBox(0.0F, -2.0F, 0.0F, 0.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, -4.8F, 0.0F, 0.0F, 0.0911F, 0.0F));
        PartDefinition tailSpikesR2 = tail2.addOrReplaceChild("tailSpikesR2", CubeListBuilder.create().texOffs(35, 78).addBox(0.0F, -2.0F, 0.0F, 0.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1F, -4.8F, 0.0F, 0.0F, -0.0911F, 0.0F));
        PartDefinition tailSpikesL1 = tail1.addOrReplaceChild("tailSpikesL1", CubeListBuilder.create().texOffs(35, 76).addBox(0.0F, -2.0F, 0.0F, 0.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.2F, -5.0F, 0.0F, 0.0F, 0.0911F, 0.0F));
        PartDefinition tailSpikesR1 = tail1.addOrReplaceChild("tailSpikesR1", CubeListBuilder.create().texOffs(35, 76).addBox(0.0F, -2.0F, 0.0F, 0.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.8F, -5.0F, 0.0F, 0.0F, -0.0911F, 0.0F));
        PartDefinition lLeg1 = butt.addOrReplaceChild("lLeg1", CubeListBuilder.create().texOffs(53, 27).addBox(-3.0F, 0.0F, -2.5F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 1.0F, 15.5F, -1.0908F, 0.0F, -0.5672F));
        PartDefinition lLeg2 = lLeg1.addOrReplaceChild("lLeg2", CubeListBuilder.create().texOffs(74, 29).addBox(-2.0F, 0.0F, -1.5F, 4.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 7.5F, -0.25F, 1.9635F, 0.0F, 0.0F));
        PartDefinition lFoot2 = lLeg2.addOrReplaceChild("lFoot2", CubeListBuilder.create().texOffs(57, 42).addBox(-2.5F, 0.0F, -5.75F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.75F, 1.5F, -0.6109F, -0.1396F, 0.8727F));
        PartDefinition rLeg = butt.addOrReplaceChild("rLeg", CubeListBuilder.create().texOffs(53, 27).addBox(-3.0F, 0.0F, -2.5F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 1.5F, 15.5F, -1.0908F, 0.0F, 0.5672F));
        PartDefinition rLeg2 = rLeg.addOrReplaceChild("rLeg2", CubeListBuilder.create().texOffs(74, 29).addBox(-2.0F, 0.0F, -1.5F, 4.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 7.5F, -0.25F, 1.9635F, 0.0F, 0.0F));
        PartDefinition rFoot = rLeg2.addOrReplaceChild("rFoot", CubeListBuilder.create().texOffs(57, 42).addBox(-2.5F, 0.0F, -5.75F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.75F, 1.5F, -0.6109F, 0.1396F, -0.8727F));
        return LayerDefinition.create(meshdefinition, 90, 256);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        butt.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

}