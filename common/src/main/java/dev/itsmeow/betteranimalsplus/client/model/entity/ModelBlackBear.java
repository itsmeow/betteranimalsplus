package dev.itsmeow.betteranimalsplus.client.model.entity;

import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBear;
import dev.itsmeow.betteranimalsplus.common.entity.EntityBearNeutral;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class ModelBlackBear<T extends EntityBearNeutral> extends ModelBear<T> {

    public ModelBlackBear(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition chest = partdefinition.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -6.0F, -23.0F, 12.0F, 12.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 9.0F, 10.0F));
        PartDefinition neck = chest.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(61, 46).addBox(-4.5F, -1.75F, -9.0F, 9.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -3.0F, -17.0F));
        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(93, 37).addBox(-4.0F, -5.5F, -8.25F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 7).addBox(2.25F, -7.5F, -5.25F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 7).mirror().addBox(-4.75F, -7.5F, -5.25F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 5.0F, -6.0F));
        PartDefinition nose_r1 = head.addOrReplaceChild("nose_r1", CubeListBuilder.create().texOffs(45, 0).addBox(-1.5F, -1.0F, -13.5F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, 0.75F, 0.2182F, 0.0F, 0.0F));
        PartDefinition lowerJaw = head.addOrReplaceChild("lowerJaw", CubeListBuilder.create().texOffs(21, 55).addBox(-2.0F, -1.0F, -4.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(46, 27).addBox(-2.0F, -2.5F, -4.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offset(0.0F, 1.0F, -8.0F));
        PartDefinition snout = head.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(0, 54).addBox(-2.5F, -2.5F, -12.25F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition upperTeeth = snout.addOrReplaceChild("upperTeeth", CubeListBuilder.create().texOffs(50, 18).addBox(-2.5F, 3.25F, -4.25F, 5.0F, 2.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offset(0.0F, -3.0F, -8.0F));
        PartDefinition ass = chest.addOrReplaceChild("ass", CubeListBuilder.create().texOffs(0, 26).addBox(-8.5F, -7.0F, 0.0F, 15.0F, 13.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -10.0F));
        PartDefinition lArm01 = chest.addOrReplaceChild("lArm01", CubeListBuilder.create().texOffs(63, 0).addBox(-1.5F, -3.0F, -3.5F, 7.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -0.75F, -16.0F));
        PartDefinition lArm02 = lArm01.addOrReplaceChild("lArm02", CubeListBuilder.create().texOffs(64, 19).addBox(0.0F, 2.0F, -4.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 5.0F, 1.0F, -0.0873F, 0.0F, 0.0F));
        PartDefinition lPaw = lArm02.addOrReplaceChild("lPaw", CubeListBuilder.create().texOffs(65, 34).addBox(-3.25F, 0.0F, -3.0F, 6.0F, 2.0F, 7.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(3.25F, 9.0F, -2.0F, 0.0873F, 0.0F, 0.0F));
        PartDefinition lFClaw04_r1 = lPaw.addOrReplaceChild("lFClaw04_r1", CubeListBuilder.create().texOffs(1, 0).mirror().addBox(-0.5F, 0.0F, -1.75F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.5F, 0.0F, -3.0F, 0.2182F, -0.0436F, 0.0F));
        PartDefinition lFClaw03_r1 = lPaw.addOrReplaceChild("lFClaw03_r1", CubeListBuilder.create().texOffs(1, 0).mirror().addBox(-0.5F, 0.0F, -2.5F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(1, 0).addBox(1.0F, 0.0F, -2.5F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, -3.0F, 0.2182F, 0.0F, 0.0F));
        PartDefinition lFClaw02_r1 = lPaw.addOrReplaceChild("lFClaw02_r1", CubeListBuilder.create().texOffs(1, 0).addBox(0.5F, 0.0F, -1.75F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, -3.0F, 0.2182F, -0.0436F, 0.0F));
        PartDefinition rArm01 = chest.addOrReplaceChild("rArm01", CubeListBuilder.create().texOffs(63, 0).mirror().addBox(-5.5F, -3.0F, -3.5F, 7.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, -0.75F, -16.0F));
        PartDefinition rArm02 = rArm01.addOrReplaceChild("rArm02", CubeListBuilder.create().texOffs(64, 19).mirror().addBox(-6.0F, 2.0F, -4.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 5.0F, 1.0F, -0.0873F, 0.0F, 0.0F));
        PartDefinition rPaw = rArm02.addOrReplaceChild("rPaw", CubeListBuilder.create().texOffs(65, 34).mirror().addBox(-2.75F, 0.0F, -3.0F, 6.0F, 2.0F, 7.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-3.25F, 9.0F, -2.0F, 0.0873F, 0.0F, 0.0F));
        PartDefinition rFClaw04_r1 = rPaw.addOrReplaceChild("rFClaw04_r1", CubeListBuilder.create().texOffs(1, 0).addBox(-0.5F, 0.0F, -1.75F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 0.0F, -3.0F, 0.2182F, 0.0436F, 0.0F));
        PartDefinition rFClaw03_r1 = rPaw.addOrReplaceChild("rFClaw03_r1", CubeListBuilder.create().texOffs(1, 0).addBox(-0.5F, 0.0F, -2.5F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(1, 0).mirror().addBox(-2.0F, 0.0F, -2.5F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 0.0F, -3.0F, 0.2182F, 0.0F, 0.0F));
        PartDefinition rFClaw02_r1 = rPaw.addOrReplaceChild("rFClaw02_r1", CubeListBuilder.create().texOffs(1, 0).mirror().addBox(-1.5F, 0.0F, -1.75F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 0.0F, -3.0F, 0.2182F, 0.0436F, 0.0F));
        PartDefinition lLeg01 = partdefinition.addOrReplaceChild("lLeg01", CubeListBuilder.create().texOffs(94, 0).addBox(-5.5F, -2.0F, -4.0F, 7.0F, 11.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 7.0F, 7.5F));
        PartDefinition lLeg02 = lLeg01.addOrReplaceChild("lLeg02", CubeListBuilder.create().texOffs(96, 20).addBox(-2.75F, 0.0F, 0.0F, 6.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 8.75F, -3.0F, 0.1309F, 0.0F, 0.0F));
        PartDefinition lFoot = lLeg02.addOrReplaceChild("lFoot", CubeListBuilder.create().texOffs(65, 34).addBox(-3.25F, 0.0F, -3.0F, 6.0F, 2.0F, 7.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.25F, 6.5F, 1.5F, -0.1309F, 0.0F, 0.0F));
        PartDefinition lHClaw04_r1 = lFoot.addOrReplaceChild("lHClaw04_r1", CubeListBuilder.create().texOffs(1, 0).mirror().addBox(-0.5F, 0.0F, -1.75F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.5F, 0.0F, -3.0F, 0.2182F, -0.0436F, 0.0F));
        PartDefinition lHClaw03_r1 = lFoot.addOrReplaceChild("lHClaw03_r1", CubeListBuilder.create().texOffs(1, 0).mirror().addBox(-0.5F, 0.0F, -2.5F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(1, 0).addBox(1.0F, 0.0F, -2.5F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, -3.0F, 0.2182F, 0.0F, 0.0F));
        PartDefinition lHClaw02_r1 = lFoot.addOrReplaceChild("lHClaw02_r1", CubeListBuilder.create().texOffs(1, 0).addBox(0.5F, 0.0F, -1.75F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, -3.0F, 0.2182F, -0.0436F, 0.0F));
        PartDefinition rLeg01 = partdefinition.addOrReplaceChild("rLeg01", CubeListBuilder.create().texOffs(94, 0).mirror().addBox(-1.5F, -2.0F, -4.0F, 7.0F, 11.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-8.0F, 7.0F, 7.5F));
        PartDefinition rLeg02 = rLeg01.addOrReplaceChild("rLeg02", CubeListBuilder.create().texOffs(96, 20).mirror().addBox(-3.25F, 0.0F, 0.0F, 6.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 8.75F, -3.0F, 0.1309F, 0.0F, 0.0F));
        PartDefinition rFoot = rLeg02.addOrReplaceChild("rFoot", CubeListBuilder.create().texOffs(65, 34).mirror().addBox(-2.75F, 0.0F, -3.0F, 6.0F, 2.0F, 7.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-0.25F, 6.5F, 1.5F, -0.1309F, 0.0F, 0.0F));
        PartDefinition rHClaw04_r1 = rFoot.addOrReplaceChild("rHClaw04_r1", CubeListBuilder.create().texOffs(1, 0).addBox(-0.5F, 0.0F, -1.75F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 0.0F, -3.0F, 0.2182F, 0.0436F, 0.0F));
        PartDefinition rHClaw03_r1 = rFoot.addOrReplaceChild("rHClaw03_r1", CubeListBuilder.create().texOffs(1, 0).addBox(-0.5F, 0.0F, -2.5F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(1, 0).mirror().addBox(-2.0F, 0.0F, -2.5F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 0.0F, -3.0F, 0.2182F, 0.0F, 0.0F));
        PartDefinition rHClaw02_r1 = rFoot.addOrReplaceChild("rHClaw02_r1", CubeListBuilder.create().texOffs(1, 0).mirror().addBox(-1.5F, 0.0F, -1.75F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 0.0F, -3.0F, 0.2182F, 0.0436F, 0.0F));
        return LayerDefinition.create(meshdefinition, 128, 64);
    }

}
