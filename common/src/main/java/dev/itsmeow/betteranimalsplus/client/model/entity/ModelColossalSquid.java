package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

/**
 * squid_colossal - Batman, Cybercat5555 Created using Tabula 8.0.0
 */
public class ModelColossalSquid<T extends Entity> extends ModelBAP<T> {

    protected final ModelPart[] mainTentacles;
    public ModelPart head;
    public ModelPart mantle;
    public ModelPart lEye;
    public ModelPart rEye;
    public ModelPart tentacleT0;
    public ModelPart tentacleLT0;
    public ModelPart tentacleRT0;
    public ModelPart tentacleRM0;
    public ModelPart tentacleLM0;
    public ModelPart tentacleLB0;
    public ModelPart tentacleRB0;
    public ModelPart tentacleB0;
    public ModelPart tentacleLongL0;
    public ModelPart tentacleLongR0;
    public ModelPart beakTop;
    public ModelPart beakLow;
    public ModelPart siphon;
    public ModelPart mantleBack;
    public ModelPart lFin0;
    public ModelPart rFin0;
    public ModelPart mantleTop;
    public ModelPart finBase;
    public ModelPart lFin1;
    public ModelPart rFin1;
    public ModelPart finTip;
    public ModelPart tentacleT1;
    public ModelPart tentacleT2;
    public ModelPart tentacleLT1;
    public ModelPart tentacleLT2;
    public ModelPart tentacleRT1;
    public ModelPart tentacleRT2;
    public ModelPart tentacleRM1;
    public ModelPart tentacleRM2;
    public ModelPart tentacleLM0_1;
    public ModelPart tentacleLM0_2;
    public ModelPart tentacleLB1;
    public ModelPart tentacleLB2;
    public ModelPart tentacleRB1;
    public ModelPart tentacleRB2;
    public ModelPart tentacleB1;
    public ModelPart tentacleB2;
    public ModelPart tentacleLongL1;
    public ModelPart tentacleLongL2;
    public ModelPart tentacleLongL3;
    public ModelPart tentacleLongL4;
    public ModelPart tentacleLongL5;
    public ModelPart tentacleLongL6;
    public ModelPart tentacleLongL7;
    public ModelPart tentacleLongLHand;
    public ModelPart tentacleLongR1;
    public ModelPart tentacleLongR2;
    public ModelPart tentacleLongR3;
    public ModelPart tentacleLongR4;
    public ModelPart tentacleLongR5;
    public ModelPart tentacleLongR6;
    public ModelPart tentacleLongR7;
    public ModelPart tentacleLongRHand;

    public ModelColossalSquid(ModelPart root) {
        this.head = root.getChild("head");
        this.mantle = head.getChild("mantle");
        this.mantleBack = mantle.getChild("mantleBack");
        this.mantleTop = mantleBack.getChild("mantleTop");
        this.finBase = mantleTop.getChild("finBase");
        this.lFin1 = finBase.getChild("lFin1");
        this.rFin1 = finBase.getChild("rFin1");
        this.finTip = finBase.getChild("finTip");
        this.lFin0 = mantle.getChild("lFin0");
        this.rFin0 = mantle.getChild("rFin0");
        this.lEye = head.getChild("lEye");
        this.rEye = head.getChild("rEye");
        this.tentacleT0 = head.getChild("tentacleT0");
        this.tentacleT1 = tentacleT0.getChild("tentacleT1");
        this.tentacleT2 = tentacleT1.getChild("tentacleT2");
        this.tentacleLT0 = head.getChild("tentacleLT0");
        this.tentacleLT1 = tentacleLT0.getChild("tentacleLT1");
        this.tentacleLT2 = tentacleLT1.getChild("tentacleLT2");
        this.tentacleRT0 = head.getChild("tentacleRT0");
        this.tentacleRT1 = tentacleRT0.getChild("tentacleRT1");
        this.tentacleRT2 = tentacleRT1.getChild("tentacleRT2");
        this.tentacleRM0 = head.getChild("tentacleRM0");
        this.tentacleRM1 = tentacleRM0.getChild("tentacleRM1");
        this.tentacleRM2 = tentacleRM1.getChild("tentacleRM2");
        this.tentacleLM0 = head.getChild("tentacleLM0");
        this.tentacleLB0 = head.getChild("tentacleLB0");
        this.tentacleLB1 = tentacleLB0.getChild("tentacleLB1");
        this.tentacleLB2 = tentacleLB1.getChild("tentacleLB2");
        this.tentacleRB0 = head.getChild("tentacleRB0");
        this.tentacleRB1 = tentacleRB0.getChild("tentacleRB1");
        this.tentacleRB2 = tentacleRB1.getChild("tentacleRB2");
        this.tentacleB0 = head.getChild("tentacleB0");
        this.tentacleB1 = tentacleB0.getChild("tentacleB1");
        this.tentacleB2 = tentacleB1.getChild("tentacleB2");
        this.tentacleLongL0 = head.getChild("tentacleLongL0");
        this.tentacleLongL1 = tentacleLongL0.getChild("tentacleLongL1");
        this.tentacleLongL2 = tentacleLongL1.getChild("tentacleLongL2");
        this.tentacleLongL3 = tentacleLongL2.getChild("tentacleLongL3");
        this.tentacleLongL4 = tentacleLongL3.getChild("tentacleLongL4");
        this.tentacleLongL5 = tentacleLongL4.getChild("tentacleLongL5");
        this.tentacleLongL6 = tentacleLongL5.getChild("tentacleLongL6");
        this.tentacleLongL7 = tentacleLongL6.getChild("tentacleLongL7");
        this.tentacleLongLHand = tentacleLongL7.getChild("tentacleLongLHand");
        this.tentacleLongR0 = head.getChild("tentacleLongR0");
        this.tentacleLongR1 = tentacleLongR0.getChild("tentacleLongR1");
        this.tentacleLongR2 = tentacleLongR1.getChild("tentacleLongR2");
        this.tentacleLongR3 = tentacleLongR2.getChild("tentacleLongR3");
        this.tentacleLongR4 = tentacleLongR3.getChild("tentacleLongR4");
        this.tentacleLongR5 = tentacleLongR4.getChild("tentacleLongR5");
        this.tentacleLongR6 = tentacleLongR5.getChild("tentacleLongR6");
        this.tentacleLongR7 = tentacleLongR6.getChild("tentacleLongR7");
        this.tentacleLongRHand = tentacleLongR7.getChild("tentacleLongRHand");
        this.beakTop = head.getChild("beakTop");
        this.beakLow = head.getChild("beakLow");
        this.siphon = head.getChild("siphon");
        this.mainTentacles = new ModelPart[]{
                tentacleLT0,
                tentacleRT0,
                tentacleT0,
                tentacleRM0,
                tentacleRB0,
                tentacleLM0,
                tentacleLB0,
                tentacleB0
        };
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(86, 44).addBox(-5.0F, -4.5F, -9.0F, 10.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, 5.0F));
        PartDefinition mantle = head.addOrReplaceChild("mantle", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -6.0F, 0.0F, 12.0F, 11.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, -0.0456F, 0.0F, 0.0F));
        PartDefinition mantleBack = mantle.addOrReplaceChild("mantleBack", CubeListBuilder.create().texOffs(0, 42).addBox(-5.5F, 0.0F, 0.0F, 11.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.2F, 11.0F, 0.3187F, 0.0F, 0.0F));
        PartDefinition mantleTop = mantleBack.addOrReplaceChild("mantleTop", CubeListBuilder.create().texOffs(0, 24).addBox(-5.0F, 0.0F, 0.0F, 10.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.8F, 3.7F, -0.4098F, 0.0F, 0.0F));
        PartDefinition finBase = mantleTop.addOrReplaceChild("finBase", CubeListBuilder.create().texOffs(76, 0).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.4F, -0.2F, -0.0456F, 0.0F, 0.0F));
        PartDefinition lFin1 = finBase.addOrReplaceChild("lFin1", CubeListBuilder.create().texOffs(30, 18).mirror().addBox(0.0F, -0.5F, 0.0F, 11.0F, 1.0F, 23.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5F, 1.0F, 0.0F, 0.0F, -0.0911F, 0.0F));
        PartDefinition rFin1 = finBase.addOrReplaceChild("rFin1", CubeListBuilder.create().texOffs(30, 18).addBox(-11.0F, -0.5F, 0.0F, 11.0F, 1.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 1.0F, 0.0F, 0.0F, 0.0911F, 0.0F));
        PartDefinition finTip = finBase.addOrReplaceChild("finTip", CubeListBuilder.create().texOffs(40, 46).mirror().addBox(-15.0F, 0.0F, 0.0F, 15.0F, 1.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.1F, 13.0F, 0.0F, 0.7854F, 0.0F));
        PartDefinition lFin0 = mantle.addOrReplaceChild("lFin0", CubeListBuilder.create().texOffs(54, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 9.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, -5.0F, 0.0F, 0.0F, -0.2731F, 0.0F));
        PartDefinition rFin0 = mantle.addOrReplaceChild("rFin0", CubeListBuilder.create().texOffs(54, 0).addBox(-9.0F, 0.0F, 0.0F, 9.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -5.0F, 0.0F, 0.0F, 0.2731F, 0.0F));
        PartDefinition lEye = head.addOrReplaceChild("lEye", CubeListBuilder.create().texOffs(39, 0).mirror().addBox(10.0F, -2.5F, -2.5F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 0.0F, -5.0F, 1.5708F, 0.0F, 0.0F));
        PartDefinition rEye = head.addOrReplaceChild("rEye", CubeListBuilder.create().texOffs(39, 0).addBox(-11.0F, -2.5F, -2.5F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, -5.0F, 1.5708F, 0.0F, 0.0F));
        PartDefinition tentacleT0 = head.addOrReplaceChild("tentacleT0", CubeListBuilder.create().texOffs(105, 0).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.6F, -8.7F));
        PartDefinition tentacleT1 = tentacleT0.addOrReplaceChild("tentacleT1", CubeListBuilder.create().texOffs(105, 0).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleT2 = tentacleT1.addOrReplaceChild("tentacleT2", CubeListBuilder.create().texOffs(105, 0).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleLT0 = head.addOrReplaceChild("tentacleLT0", CubeListBuilder.create().texOffs(105, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -3.0F, -8.7F, 0.0F, 0.0F, 0.5236F));
        PartDefinition tentacleLT1 = tentacleLT0.addOrReplaceChild("tentacleLT1", CubeListBuilder.create().texOffs(105, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleLT2 = tentacleLT1.addOrReplaceChild("tentacleLT2", CubeListBuilder.create().texOffs(105, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleRT0 = head.addOrReplaceChild("tentacleRT0", CubeListBuilder.create().texOffs(105, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -3.0F, -8.7F, 0.0F, 0.0F, -0.5236F));
        PartDefinition tentacleRT1 = tentacleRT0.addOrReplaceChild("tentacleRT1", CubeListBuilder.create().texOffs(105, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleRT2 = tentacleRT1.addOrReplaceChild("tentacleRT2", CubeListBuilder.create().texOffs(105, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleRM0 = head.addOrReplaceChild("tentacleRM0", CubeListBuilder.create().texOffs(105, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.9F, 0.0F, -8.7F, 0.0F, 0.0F, -1.5708F));
        PartDefinition tentacleRM1 = tentacleRM0.addOrReplaceChild("tentacleRM1", CubeListBuilder.create().texOffs(105, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleRM2 = tentacleRM1.addOrReplaceChild("tentacleRM2", CubeListBuilder.create().texOffs(105, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleLM0 = head.addOrReplaceChild("tentacleLM0", CubeListBuilder.create().texOffs(105, 0).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.9F, 0.0F, -8.7F, 0.0F, 0.0F, 1.5708F));
        PartDefinition tentacleLM0 = tentacleLM0.addOrReplaceChild("tentacleLM0", CubeListBuilder.create().texOffs(105, 0).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleLM0 = tentacleLM0.addOrReplaceChild("tentacleLM0", CubeListBuilder.create().texOffs(105, 0).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleLB0 = head.addOrReplaceChild("tentacleLB0", CubeListBuilder.create().texOffs(105, 0).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 2.3F, -8.7F, 0.0F, 0.0F, 2.2689F));
        PartDefinition tentacleLB1 = tentacleLB0.addOrReplaceChild("tentacleLB1", CubeListBuilder.create().texOffs(105, 0).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleLB2 = tentacleLB1.addOrReplaceChild("tentacleLB2", CubeListBuilder.create().texOffs(105, 0).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleRB0 = head.addOrReplaceChild("tentacleRB0", CubeListBuilder.create().texOffs(105, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 2.3F, -8.7F, 0.0F, 0.0F, -2.2689F));
        PartDefinition tentacleRB1 = tentacleRB0.addOrReplaceChild("tentacleRB1", CubeListBuilder.create().texOffs(105, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleRB2 = tentacleRB1.addOrReplaceChild("tentacleRB2", CubeListBuilder.create().texOffs(105, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleB0 = head.addOrReplaceChild("tentacleB0", CubeListBuilder.create().texOffs(105, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 2.6F, -8.7F, 0.0F, 0.0F, -3.1416F));
        PartDefinition tentacleB1 = tentacleB0.addOrReplaceChild("tentacleB1", CubeListBuilder.create().texOffs(105, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleB2 = tentacleB1.addOrReplaceChild("tentacleB2", CubeListBuilder.create().texOffs(105, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleLongL0 = head.addOrReplaceChild("tentacleLongL0", CubeListBuilder.create().texOffs(105, 10).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.8F, -1.8F, -8.7F, 0.0F, -0.182F, 0.0F));
        PartDefinition tentacleLongL1 = tentacleLongL0.addOrReplaceChild("tentacleLongL1", CubeListBuilder.create().texOffs(105, 10).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleLongL2 = tentacleLongL1.addOrReplaceChild("tentacleLongL2", CubeListBuilder.create().texOffs(105, 10).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleLongL3 = tentacleLongL2.addOrReplaceChild("tentacleLongL3", CubeListBuilder.create().texOffs(105, 10).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleLongL4 = tentacleLongL3.addOrReplaceChild("tentacleLongL4", CubeListBuilder.create().texOffs(105, 10).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleLongL5 = tentacleLongL4.addOrReplaceChild("tentacleLongL5", CubeListBuilder.create().texOffs(105, 10).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -6.7F, 0.0F, 0.0911F, 0.0F));
        PartDefinition tentacleLongL6 = tentacleLongL5.addOrReplaceChild("tentacleLongL6", CubeListBuilder.create().texOffs(105, 10).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleLongL7 = tentacleLongL6.addOrReplaceChild("tentacleLongL7", CubeListBuilder.create().texOffs(105, 10).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -6.7F, 0.0F, 0.182F, 0.0F));
        PartDefinition tentacleLongLHand = tentacleLongL7.addOrReplaceChild("tentacleLongLHand", CubeListBuilder.create().texOffs(85, 26).mirror().addBox(-1.0F, -1.5F, -10.0F, 2.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -6.5F, 0.0F, 0.2276F, 0.0F));
        PartDefinition tentacleLongR0 = head.addOrReplaceChild("tentacleLongR0", CubeListBuilder.create().texOffs(105, 10).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8F, -1.8F, -8.7F, 0.0F, 0.182F, 0.0F));
        PartDefinition tentacleLongR1 = tentacleLongR0.addOrReplaceChild("tentacleLongR1", CubeListBuilder.create().texOffs(105, 10).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleLongR2 = tentacleLongR1.addOrReplaceChild("tentacleLongR2", CubeListBuilder.create().texOffs(105, 10).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleLongR3 = tentacleLongR2.addOrReplaceChild("tentacleLongR3", CubeListBuilder.create().texOffs(105, 10).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleLongR4 = tentacleLongR3.addOrReplaceChild("tentacleLongR4", CubeListBuilder.create().texOffs(105, 10).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleLongR5 = tentacleLongR4.addOrReplaceChild("tentacleLongR5", CubeListBuilder.create().texOffs(105, 10).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.7F, 0.0F, -0.0911F, 0.0F));
        PartDefinition tentacleLongR6 = tentacleLongR5.addOrReplaceChild("tentacleLongR6", CubeListBuilder.create().texOffs(105, 10).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleLongR7 = tentacleLongR6.addOrReplaceChild("tentacleLongR7", CubeListBuilder.create().texOffs(105, 10).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.7F, 0.0F, -0.3187F, 0.0F));
        PartDefinition tentacleLongRHand = tentacleLongR7.addOrReplaceChild("tentacleLongRHand", CubeListBuilder.create().texOffs(85, 26).addBox(-1.0F, -1.5F, -10.0F, 2.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.5F, 0.0F, -0.2276F, 0.0F));
        PartDefinition beakTop = head.addOrReplaceChild("beakTop", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -9.0F, 0.1367F, 0.0F, 0.0F));
        PartDefinition beakLow = head.addOrReplaceChild("beakLow", CubeListBuilder.create().texOffs(0, 6).addBox(-1.5F, -2.0F, -2.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -8.8F, -0.1367F, 0.0F, 0.0F));
        PartDefinition siphon = head.addOrReplaceChild("siphon", CubeListBuilder.create().texOffs(15, 57).addBox(-1.0F, -1.0F, -5.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, -0.7F, 0.182F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 128, 64);
    }
    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.head.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.xRot = (float) (Math.PI / 2F);
        for (ModelPart m : mainTentacles) {
            m.xRot = -ageInTicks / 2F;
        }
    }

}
