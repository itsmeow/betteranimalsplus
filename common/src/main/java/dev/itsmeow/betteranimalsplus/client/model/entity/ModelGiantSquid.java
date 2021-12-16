package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

/**
 * squid_giant - Batman, Cybercat5555
 * Created using Tabula 8.0.0
 */
public class ModelGiantSquid<T extends Entity> extends ModelBAP<T> {

    public ModelPart head;
    public ModelPart mantle;
    public ModelPart lEye;
    public ModelPart rEye;
    public ModelPart tentacleLongL0;
    public ModelPart tentacleLT0;
    public ModelPart tentacleRT0;
    public ModelPart tentacleT0;
    public ModelPart tentacleRM0;
    public ModelPart tentacleRB0;
    public ModelPart tentacleLM0;
    public ModelPart tentacleLB0;
    public ModelPart tentacleB0;
    public ModelPart tentacleLongR0;
    public ModelPart siphon;
    public ModelPart beakTop;
    public ModelPart beakLow;
    public ModelPart mantleBack;
    public ModelPart mantleTop;
    public ModelPart mantleTipTop;
    public ModelPart mantleTipLow;
    public ModelPart fin0;
    public ModelPart fin1;
    public ModelPart tentacleLongL1;
    public ModelPart tentacleLongL2;
    public ModelPart tentacleLongL3;
    public ModelPart tentacleLongL4;
    public ModelPart tentacleLongL5;
    public ModelPart tentacleLongL6;
    public ModelPart tentacleLongL7;
    public ModelPart tentacleLongLHand;
    public ModelPart tentacleLT1;
    public ModelPart tentacleLT2;
    public ModelPart tentacleLT3;
    public ModelPart tentacleLT4;
    public ModelPart tentacleRT1;
    public ModelPart tentacleRT2;
    public ModelPart tentacleRT3;
    public ModelPart tentacleRT4;
    public ModelPart tentacleT1;
    public ModelPart tentacleT2;
    public ModelPart tentacleT3;
    public ModelPart tentacleT4;
    public ModelPart tentacleRM1;
    public ModelPart tentacleRM2;
    public ModelPart tentacleRM3;
    public ModelPart tentacleRM4;
    public ModelPart tentacleRB1;
    public ModelPart tentacleRB2;
    public ModelPart tentacleRB3;
    public ModelPart tentacleRB4;
    public ModelPart tentacleLM1;
    public ModelPart tentacleLM2;
    public ModelPart tentacleLM3;
    public ModelPart tentacleLM4;
    public ModelPart tentacleLB1;
    public ModelPart tentacleLB2;
    public ModelPart tentacleLB3;
    public ModelPart tentacleLB4;
    public ModelPart tentacleB1;
    public ModelPart tentacleB2;
    public ModelPart tentacleB3;
    public ModelPart tentacleB4;
    public ModelPart tentacleLongR1;
    public ModelPart tentacleLongR2;
    public ModelPart tentacleLongR3;
    public ModelPart tentacleLongR4;
    public ModelPart tentacleLongR5;
    public ModelPart tentacleLongR6;
    public ModelPart tentacleLongR7;
    public ModelPart tentacleLongRHand;
    protected ModelPart[] mainTentacles;

    public ModelGiantSquid(ModelPart root) {
        this.head = root.getChild("head");
        this.mantle = head.getChild("mantle");
        this.mantleBack = mantle.getChild("mantleBack");
        this.mantleTop = mantleBack.getChild("mantleTop");
        this.mantleTipTop = mantleTop.getChild("mantleTipTop");
        this.mantleTipLow = mantleTipTop.getChild("mantleTipLow");
        this.fin0 = mantleTipTop.getChild("fin0");
        this.fin1 = fin0.getChild("fin1");
        this.lEye = head.getChild("lEye");
        this.rEye = head.getChild("rEye");
        this.tentacleLongL0 = head.getChild("tentacleLongL0");
        this.tentacleLongL1 = tentacleLongL0.getChild("tentacleLongL1");
        this.tentacleLongL2 = tentacleLongL1.getChild("tentacleLongL2");
        this.tentacleLongL3 = tentacleLongL2.getChild("tentacleLongL3");
        this.tentacleLongL4 = tentacleLongL3.getChild("tentacleLongL4");
        this.tentacleLongL5 = tentacleLongL4.getChild("tentacleLongL5");
        this.tentacleLongL6 = tentacleLongL5.getChild("tentacleLongL6");
        this.tentacleLongL7 = tentacleLongL6.getChild("tentacleLongL7");
        this.tentacleLongLHand = tentacleLongL7.getChild("tentacleLongLHand");
        this.tentacleLT0 = head.getChild("tentacleLT0");
        this.tentacleLT1 = tentacleLT0.getChild("tentacleLT1");
        this.tentacleLT2 = tentacleLT1.getChild("tentacleLT2");
        this.tentacleLT3 = tentacleLT2.getChild("tentacleLT3");
        this.tentacleLT4 = tentacleLT3.getChild("tentacleLT4");
        this.tentacleRT0 = head.getChild("tentacleRT0");
        this.tentacleRT1 = tentacleRT0.getChild("tentacleRT1");
        this.tentacleRT2 = tentacleRT1.getChild("tentacleRT2");
        this.tentacleRT3 = tentacleRT2.getChild("tentacleRT3");
        this.tentacleRT4 = tentacleRT3.getChild("tentacleRT4");
        this.tentacleT0 = head.getChild("tentacleT0");
        this.tentacleT1 = tentacleT0.getChild("tentacleT1");
        this.tentacleT2 = tentacleT1.getChild("tentacleT2");
        this.tentacleT3 = tentacleT2.getChild("tentacleT3");
        this.tentacleT4 = tentacleT3.getChild("tentacleT4");
        this.tentacleRM0 = head.getChild("tentacleRM0");
        this.tentacleRM1 = tentacleRM0.getChild("tentacleRM1");
        this.tentacleRM2 = tentacleRM1.getChild("tentacleRM2");
        this.tentacleRM3 = tentacleRM2.getChild("tentacleRM3");
        this.tentacleRM4 = tentacleRM3.getChild("tentacleRM4");
        this.tentacleRB0 = head.getChild("tentacleRB0");
        this.tentacleRB1 = tentacleRB0.getChild("tentacleRB1");
        this.tentacleRB2 = tentacleRB1.getChild("tentacleRB2");
        this.tentacleRB3 = tentacleRB2.getChild("tentacleRB3");
        this.tentacleRB4 = tentacleRB3.getChild("tentacleRB4");
        this.tentacleLM0 = head.getChild("tentacleLM0");
        this.tentacleLM1 = tentacleLM0.getChild("tentacleLM1");
        this.tentacleLM2 = tentacleLM1.getChild("tentacleLM2");
        this.tentacleLM3 = tentacleLM2.getChild("tentacleLM3");
        this.tentacleLM4 = tentacleLM3.getChild("tentacleLM4");
        this.tentacleLB0 = head.getChild("tentacleLB0");
        this.tentacleLB1 = tentacleLB0.getChild("tentacleLB1");
        this.tentacleLB2 = tentacleLB1.getChild("tentacleLB2");
        this.tentacleLB3 = tentacleLB2.getChild("tentacleLB3");
        this.tentacleLB4 = tentacleLB3.getChild("tentacleLB4");
        this.tentacleB0 = head.getChild("tentacleB0");
        this.tentacleB1 = tentacleB0.getChild("tentacleB1");
        this.tentacleB2 = tentacleB1.getChild("tentacleB2");
        this.tentacleB3 = tentacleB2.getChild("tentacleB3");
        this.tentacleB4 = tentacleB3.getChild("tentacleB4");
        this.tentacleLongR0 = head.getChild("tentacleLongR0");
        this.tentacleLongR1 = tentacleLongR0.getChild("tentacleLongR1");
        this.tentacleLongR2 = tentacleLongR1.getChild("tentacleLongR2");
        this.tentacleLongR3 = tentacleLongR2.getChild("tentacleLongR3");
        this.tentacleLongR4 = tentacleLongR3.getChild("tentacleLongR4");
        this.tentacleLongR5 = tentacleLongR4.getChild("tentacleLongR5");
        this.tentacleLongR6 = tentacleLongR5.getChild("tentacleLongR6");
        this.tentacleLongR7 = tentacleLongR6.getChild("tentacleLongR7");
        this.tentacleLongRHand = tentacleLongR7.getChild("tentacleLongRHand");
        this.siphon = head.getChild("siphon");
        this.beakTop = head.getChild("beakTop");
        this.beakLow = head.getChild("beakLow");
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
        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(35, 50).addBox(-3.5F, -3.5F, -7.0F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, 3.0F));
        PartDefinition mantle = head.addOrReplaceChild("mantle", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, -0.0456F, 0.0F, 0.0F));
        PartDefinition mantleBack = mantle.addOrReplaceChild("mantleBack", CubeListBuilder.create().texOffs(0, 34).addBox(-3.0F, -1.0F, 0.0F, 6.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.1F, 10.0F, 0.1367F, 0.0F, 0.0F));
        PartDefinition mantleTop = mantleBack.addOrReplaceChild("mantleTop", CubeListBuilder.create().texOffs(0, 19).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.5F, 1.5F, -0.3187F, 0.0F, 0.0F));
        PartDefinition mantleTipTop = mantleTop.addOrReplaceChild("mantleTipTop", CubeListBuilder.create().texOffs(25, 22).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 11.0F));
        PartDefinition mantleTipLow = mantleTipTop.addOrReplaceChild("mantleTipLow", CubeListBuilder.create().texOffs(21, 50).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.3F, 0.3643F, 0.0F, 0.0F));
        PartDefinition fin0 = mantleTipTop.addOrReplaceChild("fin0", CubeListBuilder.create().texOffs(32, 37).addBox(-4.5F, 0.0F, 0.0F, 9.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 1.0F));
        PartDefinition fin1 = fin0.addOrReplaceChild("fin1", CubeListBuilder.create().texOffs(0, 56).mirror().addBox(-7.0F, 0.0F, 0.0F, 7.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.1F, 2.0F, 0.0F, 0.7854F, 0.0F));
        PartDefinition lEye = head.addOrReplaceChild("lEye", CubeListBuilder.create().texOffs(0, 34).mirror().addBox(0.0F, -1.5F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 0.0F, -4.0F));
        PartDefinition rEye = head.addOrReplaceChild("rEye", CubeListBuilder.create().texOffs(0, 34).addBox(-1.0F, -1.5F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 0.0F, -4.0F));
        PartDefinition tentacleLongL0 = head.addOrReplaceChild("tentacleLongL0", CubeListBuilder.create().texOffs(39, 10).mirror().addBox(-1.0F, -1.0F, -10.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.5F, -1.0F, -6.4F, 0.0F, -0.2731F, 0.0F));
        PartDefinition tentacleLongL1 = tentacleLongL0.addOrReplaceChild("tentacleLongL1", CubeListBuilder.create().texOffs(39, 10).mirror().addBox(-1.0F, -1.0F, -10.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -9.7F));
        PartDefinition tentacleLongL2 = tentacleLongL1.addOrReplaceChild("tentacleLongL2", CubeListBuilder.create().texOffs(39, 10).mirror().addBox(-1.0F, -1.0F, -10.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -9.7F));
        PartDefinition tentacleLongL3 = tentacleLongL2.addOrReplaceChild("tentacleLongL3", CubeListBuilder.create().texOffs(27, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -9.7F, 0.0F, 0.2276F, 0.0F));
        PartDefinition tentacleLongL4 = tentacleLongL3.addOrReplaceChild("tentacleLongL4", CubeListBuilder.create().texOffs(27, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleLongL5 = tentacleLongL4.addOrReplaceChild("tentacleLongL5", CubeListBuilder.create().texOffs(27, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleLongL6 = tentacleLongL5.addOrReplaceChild("tentacleLongL6", CubeListBuilder.create().texOffs(27, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -6.7F, 0.0F, 0.1367F, 0.0F));
        PartDefinition tentacleLongL7 = tentacleLongL6.addOrReplaceChild("tentacleLongL7", CubeListBuilder.create().texOffs(27, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleLongLHand = tentacleLongL7.addOrReplaceChild("tentacleLongLHand", CubeListBuilder.create().texOffs(35, 24).mirror().addBox(-1.0F, -1.5F, -10.0F, 2.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -6.5F, 0.0F, 0.2276F, 0.0F));
        PartDefinition tentacleLT0 = head.addOrReplaceChild("tentacleLT0", CubeListBuilder.create().texOffs(46, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.3F, -2.2F, -6.7F, 0.0F, 0.0F, 0.3187F));
        PartDefinition tentacleLT1 = tentacleLT0.addOrReplaceChild("tentacleLT1", CubeListBuilder.create().texOffs(46, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleLT2 = tentacleLT1.addOrReplaceChild("tentacleLT2", CubeListBuilder.create().texOffs(46, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleLT3 = tentacleLT2.addOrReplaceChild("tentacleLT3", CubeListBuilder.create().texOffs(46, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleLT4 = tentacleLT3.addOrReplaceChild("tentacleLT4", CubeListBuilder.create().texOffs(46, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleRT0 = head.addOrReplaceChild("tentacleRT0", CubeListBuilder.create().texOffs(46, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.3F, -2.2F, -6.7F, 0.0F, 0.0F, -0.3187F));
        PartDefinition tentacleRT1 = tentacleRT0.addOrReplaceChild("tentacleRT1", CubeListBuilder.create().texOffs(46, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleRT2 = tentacleRT1.addOrReplaceChild("tentacleRT2", CubeListBuilder.create().texOffs(46, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleRT3 = tentacleRT2.addOrReplaceChild("tentacleRT3", CubeListBuilder.create().texOffs(46, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleRT4 = tentacleRT3.addOrReplaceChild("tentacleRT4", CubeListBuilder.create().texOffs(46, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleT0 = head.addOrReplaceChild("tentacleT0", CubeListBuilder.create().texOffs(46, 0).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.4F, -6.7F));
        PartDefinition tentacleT1 = tentacleT0.addOrReplaceChild("tentacleT1", CubeListBuilder.create().texOffs(46, 0).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleT2 = tentacleT1.addOrReplaceChild("tentacleT2", CubeListBuilder.create().texOffs(46, 0).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleT3 = tentacleT2.addOrReplaceChild("tentacleT3", CubeListBuilder.create().texOffs(46, 0).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleT4 = tentacleT3.addOrReplaceChild("tentacleT4", CubeListBuilder.create().texOffs(46, 0).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleRM0 = head.addOrReplaceChild("tentacleRM0", CubeListBuilder.create().texOffs(46, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.3F, 0.2F, -6.7F, 0.0F, 0.0F, -1.5708F));
        PartDefinition tentacleRM1 = tentacleRM0.addOrReplaceChild("tentacleRM1", CubeListBuilder.create().texOffs(46, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleRM2 = tentacleRM1.addOrReplaceChild("tentacleRM2", CubeListBuilder.create().texOffs(46, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleRM3 = tentacleRM2.addOrReplaceChild("tentacleRM3", CubeListBuilder.create().texOffs(46, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleRM4 = tentacleRM3.addOrReplaceChild("tentacleRM4", CubeListBuilder.create().texOffs(46, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleRB0 = head.addOrReplaceChild("tentacleRB0", CubeListBuilder.create().texOffs(46, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.3F, 2.5F, -6.7F, 0.0F, 0.0F, -2.2689F));
        PartDefinition tentacleRB1 = tentacleRB0.addOrReplaceChild("tentacleRB1", CubeListBuilder.create().texOffs(46, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleRB2 = tentacleRB1.addOrReplaceChild("tentacleRB2", CubeListBuilder.create().texOffs(46, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleRB3 = tentacleRB2.addOrReplaceChild("tentacleRB3", CubeListBuilder.create().texOffs(46, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleRB4 = tentacleRB3.addOrReplaceChild("tentacleRB4", CubeListBuilder.create().texOffs(46, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleLM0 = head.addOrReplaceChild("tentacleLM0", CubeListBuilder.create().texOffs(46, 0).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3F, 0.2F, -6.7F, 0.0F, 0.0F, 1.5708F));
        PartDefinition tentacleLM1 = tentacleLM0.addOrReplaceChild("tentacleLM1", CubeListBuilder.create().texOffs(46, 0).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleLM2 = tentacleLM1.addOrReplaceChild("tentacleLM2", CubeListBuilder.create().texOffs(46, 0).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleLM3 = tentacleLM2.addOrReplaceChild("tentacleLM3", CubeListBuilder.create().texOffs(46, 0).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleLM4 = tentacleLM3.addOrReplaceChild("tentacleLM4", CubeListBuilder.create().texOffs(46, 0).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleLB0 = head.addOrReplaceChild("tentacleLB0", CubeListBuilder.create().texOffs(46, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.3F, 2.5F, -6.7F, 0.0F, 0.0F, 2.2689F));
        PartDefinition tentacleLB1 = tentacleLB0.addOrReplaceChild("tentacleLB1", CubeListBuilder.create().texOffs(46, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleLB2 = tentacleLB1.addOrReplaceChild("tentacleLB2", CubeListBuilder.create().texOffs(46, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleLB3 = tentacleLB2.addOrReplaceChild("tentacleLB3", CubeListBuilder.create().texOffs(46, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleLB4 = tentacleLB3.addOrReplaceChild("tentacleLB4", CubeListBuilder.create().texOffs(46, 0).mirror().addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleB0 = head.addOrReplaceChild("tentacleB0", CubeListBuilder.create().texOffs(46, 0).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.5F, -6.7F, -0.0349F, 0.0F, 3.1416F));
        PartDefinition tentacleB1 = tentacleB0.addOrReplaceChild("tentacleB1", CubeListBuilder.create().texOffs(46, 0).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleB2 = tentacleB1.addOrReplaceChild("tentacleB2", CubeListBuilder.create().texOffs(46, 0).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleB3 = tentacleB2.addOrReplaceChild("tentacleB3", CubeListBuilder.create().texOffs(46, 0).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleB4 = tentacleB3.addOrReplaceChild("tentacleB4", CubeListBuilder.create().texOffs(46, 0).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleLongR0 = head.addOrReplaceChild("tentacleLongR0", CubeListBuilder.create().texOffs(39, 10).addBox(-1.0F, -1.0F, -10.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -1.0F, -6.4F, 0.0F, 0.2731F, 0.0F));
        PartDefinition tentacleLongR1 = tentacleLongR0.addOrReplaceChild("tentacleLongR1", CubeListBuilder.create().texOffs(39, 10).addBox(-1.0F, -1.0F, -10.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -9.7F));
        PartDefinition tentacleLongR2 = tentacleLongR1.addOrReplaceChild("tentacleLongR2", CubeListBuilder.create().texOffs(39, 10).addBox(-1.0F, -1.0F, -10.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -9.7F));
        PartDefinition tentacleLongR3 = tentacleLongR2.addOrReplaceChild("tentacleLongR3", CubeListBuilder.create().texOffs(27, 0).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -9.7F, 0.0F, -0.2276F, 0.0F));
        PartDefinition tentacleLongR4 = tentacleLongR3.addOrReplaceChild("tentacleLongR4", CubeListBuilder.create().texOffs(27, 0).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleLongR5 = tentacleLongR4.addOrReplaceChild("tentacleLongR5", CubeListBuilder.create().texOffs(27, 0).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleLongR6 = tentacleLongR5.addOrReplaceChild("tentacleLongR6", CubeListBuilder.create().texOffs(27, 0).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.7F, 0.0F, -0.1367F, 0.0F));
        PartDefinition tentacleLongR7 = tentacleLongR6.addOrReplaceChild("tentacleLongR7", CubeListBuilder.create().texOffs(27, 0).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.7F));
        PartDefinition tentacleLongRHand = tentacleLongR7.addOrReplaceChild("tentacleLongRHand", CubeListBuilder.create().texOffs(35, 24).addBox(-1.0F, -1.5F, -10.0F, 2.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.5F, 0.0F, -0.2276F, 0.0F));
        PartDefinition siphon = head.addOrReplaceChild("siphon", CubeListBuilder.create().texOffs(0, 22).addBox(-0.5F, -0.5F, -4.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.3F, -0.7F, 0.4098F, 0.0F, 0.0F));
        PartDefinition beakTop = head.addOrReplaceChild("beakTop", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -9.0F, 0.1367F, 0.0F, 0.0F));
        PartDefinition beakLow = head.addOrReplaceChild("beakLow", CubeListBuilder.create().texOffs(0, 5).addBox(-1.5F, -2.0F, -2.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -8.8F, -0.1367F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 64, 64);
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
