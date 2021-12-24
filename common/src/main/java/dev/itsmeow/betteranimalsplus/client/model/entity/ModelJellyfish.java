package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;

public class ModelJellyfish<T extends LivingEntity> extends ModelBAP<T> {

    public ModelPart base;
    public ModelPart crown;
    public ModelPart cube_r1;
    public ModelPart cube_r2;
    public ModelPart cube_r3;
    public ModelPart cube_r4;
    public ModelPart cube_r5;
    public ModelPart cube_r6;
    public ModelPart cube_r7;
    public ModelPart cube_r8;
    public ModelPart cube_r9;
    public ModelPart cube_r10;
    public ModelPart cube_r11;
    public ModelPart cube_r12;
    public ModelPart cube_r13;
    public ModelPart cube_r14;
    public ModelPart cube_r15;
    public ModelPart cube_r16;
    public ModelPart outerTentacleF1_1;
    public ModelPart outerTentacleF1_2;
    public ModelPart outerTentacleF1_3;
    public ModelPart outerTentacleB1_1;
    public ModelPart outerTentacleB1_2;
    public ModelPart outerTentacleB1_3;
    public ModelPart outerTentacleF2_1;
    public ModelPart outerTentacleF2_2;
    public ModelPart outerTentacleF2_3;
    public ModelPart outerTentacleB2_1;
    public ModelPart outerTentacleB2_2;
    public ModelPart outerTentacleB2_3;
    public ModelPart outerTentacleF3_1;
    public ModelPart outerTentacleF3_2;
    public ModelPart outerTentacleF3_3;
    public ModelPart outerTentacleB3_1;
    public ModelPart outerTentacleB3_2;
    public ModelPart outerTentacleB3_3;
    public ModelPart outerTentacleF4_1;
    public ModelPart outerTentacleF4_2;
    public ModelPart outerTentacleF4_3;
    public ModelPart outerTentacleB4_1;
    public ModelPart outerTentacleB4_2;
    public ModelPart outerTentacleB4_3;
    public ModelPart outerTentacleF5_1;
    public ModelPart outerTentacleF5_2;
    public ModelPart outerTentacleF5_3;
    public ModelPart outerTentacleB5_1;
    public ModelPart outerTentacleB5_2;
    public ModelPart outerTentacleB5_3;
    public ModelPart lTentacle1_1;
    public ModelPart lTentacle1_2;
    public ModelPart lTentacle1_3;
    public ModelPart rTentacle1_1;
    public ModelPart rTentacle1_2;
    public ModelPart lTenracle1_3;
    public ModelPart lTentacle2_1;
    public ModelPart lTentacle2_2;
    public ModelPart lTentacle2_3;
    public ModelPart rTentacle2_1;
    public ModelPart rTentacle2_2;
    public ModelPart rTentacle2_3;
    public ModelPart lTentacle3_1;
    public ModelPart lTentacle3_2;
    public ModelPart lTentacle3_3;
    public ModelPart rTentacle3_1;
    public ModelPart rTentacle3_2;
    public ModelPart rTentacle3_3;
    public ModelPart lTentacle4_1;
    public ModelPart lTentacle4_2;
    public ModelPart lTentacle4_3;
    public ModelPart rTentacle4_1;
    public ModelPart rTentacle4_2;
    public ModelPart rTentacle4_3;
    public ModelPart lTentacle5_1;
    public ModelPart lTentacle5_2;
    public ModelPart lTentacle5_3;
    public ModelPart rTentacle5_1;
    public ModelPart rTentacle5_2;
    public ModelPart rTentacle5_3;
    public ModelPart pulsator;
    public ModelPart middleTentacle1_1;
    public ModelPart middleTentacle1_2;
    public ModelPart middleTentacle1_3;
    public ModelPart middleTentacle2_1;
    public ModelPart middleTentacle2_2;
    public ModelPart middleTentacle2_3;
    public ModelPart middleTentacle3_1;
    public ModelPart middleTentacle3_2;
    public ModelPart middleTentacle3_3;
    public ModelPart middleTentacle4_1;
    public ModelPart middleTentacle4_2;
    public ModelPart middleTentacle4_3;

    public ModelJellyfish(ModelPart root) {
        this.base = root.getChild("base");
        this.crown = base.getChild("crown");
        this.cube_r1 = crown.getChild("cube_r1");
        this.cube_r2 = crown.getChild("cube_r2");
        this.cube_r3 = crown.getChild("cube_r3");
        this.cube_r4 = crown.getChild("cube_r4");
        this.cube_r5 = crown.getChild("cube_r5");
        this.cube_r6 = crown.getChild("cube_r6");
        this.cube_r7 = crown.getChild("cube_r7");
        this.cube_r8 = crown.getChild("cube_r8");
        this.cube_r9 = crown.getChild("cube_r9");
        this.cube_r10 = crown.getChild("cube_r10");
        this.cube_r11 = crown.getChild("cube_r11");
        this.cube_r12 = crown.getChild("cube_r12");
        this.cube_r13 = crown.getChild("cube_r13");
        this.cube_r14 = crown.getChild("cube_r14");
        this.cube_r15 = crown.getChild("cube_r15");
        this.cube_r16 = crown.getChild("cube_r16");
        this.outerTentacleF1_1 = base.getChild("outerTentacleF1_1");
        this.outerTentacleF1_2 = outerTentacleF1_1.getChild("outerTentacleF1_2");
        this.outerTentacleF1_3 = outerTentacleF1_2.getChild("outerTentacleF1_3");
        this.outerTentacleB1_1 = base.getChild("outerTentacleB1_1");
        this.outerTentacleB1_2 = outerTentacleB1_1.getChild("outerTentacleB1_2");
        this.outerTentacleB1_3 = outerTentacleB1_2.getChild("outerTentacleB1_3");
        this.outerTentacleF2_1 = base.getChild("outerTentacleF2_1");
        this.outerTentacleF2_2 = outerTentacleF2_1.getChild("outerTentacleF2_2");
        this.outerTentacleF2_3 = outerTentacleF2_2.getChild("outerTentacleF2_3");
        this.outerTentacleB2_1 = base.getChild("outerTentacleB2_1");
        this.outerTentacleB2_2 = outerTentacleB2_1.getChild("outerTentacleB2_2");
        this.outerTentacleB2_3 = outerTentacleB2_2.getChild("outerTentacleB2_3");
        this.outerTentacleF3_1 = base.getChild("outerTentacleF3_1");
        this.outerTentacleF3_2 = outerTentacleF3_1.getChild("outerTentacleF3_2");
        this.outerTentacleF3_3 = outerTentacleF3_2.getChild("outerTentacleF3_3");
        this.outerTentacleB3_1 = base.getChild("outerTentacleB3_1");
        this.outerTentacleB3_2 = outerTentacleB3_1.getChild("outerTentacleB3_2");
        this.outerTentacleB3_3 = outerTentacleB3_2.getChild("outerTentacleB3_3");
        this.outerTentacleF4_1 = base.getChild("outerTentacleF4_1");
        this.outerTentacleF4_2 = outerTentacleF4_1.getChild("outerTentacleF4_2");
        this.outerTentacleF4_3 = outerTentacleF4_2.getChild("outerTentacleF4_3");
        this.outerTentacleB4_1 = base.getChild("outerTentacleB4_1");
        this.outerTentacleB4_2 = outerTentacleB4_1.getChild("outerTentacleB4_2");
        this.outerTentacleB4_3 = outerTentacleB4_2.getChild("outerTentacleB4_3");
        this.outerTentacleF5_1 = base.getChild("outerTentacleF5_1");
        this.outerTentacleF5_2 = outerTentacleF5_1.getChild("outerTentacleF5_2");
        this.outerTentacleF5_3 = outerTentacleF5_2.getChild("outerTentacleF5_3");
        this.outerTentacleB5_1 = base.getChild("outerTentacleB5_1");
        this.outerTentacleB5_2 = outerTentacleB5_1.getChild("outerTentacleB5_2");
        this.outerTentacleB5_3 = outerTentacleB5_2.getChild("outerTentacleB5_3");
        this.lTentacle1_1 = base.getChild("lTentacle1_1");
        this.lTentacle1_2 = lTentacle1_1.getChild("lTentacle1_2");
        this.lTentacle1_3 = lTentacle1_2.getChild("lTentacle1_3");
        this.rTentacle1_1 = base.getChild("rTentacle1_1");
        this.rTentacle1_2 = rTentacle1_1.getChild("rTentacle1_2");
        this.lTenracle1_3 = rTentacle1_2.getChild("lTenracle1_3");
        this.lTentacle2_1 = base.getChild("lTentacle2_1");
        this.lTentacle2_2 = lTentacle2_1.getChild("lTentacle2_2");
        this.lTentacle2_3 = lTentacle2_2.getChild("lTentacle2_3");
        this.rTentacle2_1 = base.getChild("rTentacle2_1");
        this.rTentacle2_2 = rTentacle2_1.getChild("rTentacle2_2");
        this.rTentacle2_3 = rTentacle2_2.getChild("rTentacle2_3");
        this.lTentacle3_1 = base.getChild("lTentacle3_1");
        this.lTentacle3_2 = lTentacle3_1.getChild("lTentacle3_2");
        this.lTentacle3_3 = lTentacle3_2.getChild("lTentacle3_3");
        this.rTentacle3_1 = base.getChild("rTentacle3_1");
        this.rTentacle3_2 = rTentacle3_1.getChild("rTentacle3_2");
        this.rTentacle3_3 = rTentacle3_2.getChild("rTentacle3_3");
        this.lTentacle4_1 = base.getChild("lTentacle4_1");
        this.lTentacle4_2 = lTentacle4_1.getChild("lTentacle4_2");
        this.lTentacle4_3 = lTentacle4_2.getChild("lTentacle4_3");
        this.rTentacle4_1 = base.getChild("rTentacle4_1");
        this.rTentacle4_2 = rTentacle4_1.getChild("rTentacle4_2");
        this.rTentacle4_3 = rTentacle4_2.getChild("rTentacle4_3");
        this.lTentacle5_1 = base.getChild("lTentacle5_1");
        this.lTentacle5_2 = lTentacle5_1.getChild("lTentacle5_2");
        this.lTentacle5_3 = lTentacle5_2.getChild("lTentacle5_3");
        this.rTentacle5_1 = base.getChild("rTentacle5_1");
        this.rTentacle5_2 = rTentacle5_1.getChild("rTentacle5_2");
        this.rTentacle5_3 = rTentacle5_2.getChild("rTentacle5_3");
        this.pulsator = base.getChild("pulsator");
        this.middleTentacle1_1 = base.getChild("middleTentacle1_1");
        this.middleTentacle1_2 = middleTentacle1_1.getChild("middleTentacle1_2");
        this.middleTentacle1_3 = middleTentacle1_2.getChild("middleTentacle1_3");
        this.middleTentacle2_1 = base.getChild("middleTentacle2_1");
        this.middleTentacle2_2 = middleTentacle2_1.getChild("middleTentacle2_2");
        this.middleTentacle2_3 = middleTentacle2_2.getChild("middleTentacle2_3");
        this.middleTentacle3_1 = base.getChild("middleTentacle3_1");
        this.middleTentacle3_2 = middleTentacle3_1.getChild("middleTentacle3_2");
        this.middleTentacle3_3 = middleTentacle3_2.getChild("middleTentacle3_3");
        this.middleTentacle4_1 = base.getChild("middleTentacle4_1");
        this.middleTentacle4_2 = middleTentacle4_1.getChild("middleTentacle4_2");
        this.middleTentacle4_3 = middleTentacle4_2.getChild("middleTentacle4_3");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition base = partdefinition.addOrReplaceChild("base", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -2.0F, -4.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(41, 0).addBox(-5.0F, -3.0F, -4.0F, 10.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(82, 0).addBox(-4.5F, -3.75F, -3.5F, 9.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(0, 13).addBox(-4.0F, -4.25F, -3.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(33, 13).addBox(-4.0F, -5.25F, -3.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 35).addBox(-2.5F, -4.0F, -1.5F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(20, 36).addBox(-2.0F, -4.5F, -1.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -1.0F));
        PartDefinition crown = base.addOrReplaceChild("crown", CubeListBuilder.create().texOffs(0, 41).addBox(-4.5F, -1.0F, -4.5F, 9.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(27, 42).addBox(-3.0F, -2.25F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 1.0F));
        PartDefinition cube_r1 = crown.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(47, 37).addBox(-0.75F, -1.5F, -0.25F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -2.0F, 2.25F, -0.5236F, 0.0F, -0.5236F));
        PartDefinition cube_r2 = crown.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(47, 37).addBox(-0.75F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.25F, -2.0F, -0.75F, 0.1309F, 0.0F, -0.6545F));
        PartDefinition cube_r3 = crown.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(47, 37).addBox(-0.5F, -1.5F, -0.25F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, -2.0F, 2.25F, -0.6981F, 0.0F, -0.0873F));
        PartDefinition cube_r4 = crown.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(47, 37).addBox(-0.5F, -1.75F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, -2.0F, -0.75F, 0.1745F, 0.0F, -0.3491F));
        PartDefinition cube_r5 = crown.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(47, 37).addBox(-0.5F, -1.75F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, -2.0F, -0.75F, 0.1745F, 0.0F, 0.3491F));
        PartDefinition cube_r6 = crown.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(47, 37).addBox(-0.25F, -1.75F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.25F, -2.0F, -0.75F, 0.1309F, 0.0F, 0.6545F));
        PartDefinition cube_r7 = crown.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(47, 37).addBox(-0.25F, -1.75F, -0.75F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.25F, -2.0F, 2.25F, -0.5236F, 0.0F, 0.5236F));
        PartDefinition cube_r8 = crown.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(47, 37).addBox(-0.25F, -1.75F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.25F, -2.0F, 0.75F, -0.1745F, 0.0F, 0.6545F));
        PartDefinition cube_r9 = crown.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(47, 37).addBox(0.0F, -1.75F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -2.0F, -2.0F, 0.5236F, 0.0F, 0.5236F));
        PartDefinition cube_r10 = crown.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(47, 37).addBox(-0.5F, -1.75F, -0.25F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, -2.0F, 2.25F, -0.6981F, 0.0F, 0.0873F));
        PartDefinition cube_r11 = crown.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(47, 37).addBox(-0.5F, -1.75F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, -2.0F, 0.75F, -0.1745F, 0.0F, 0.2182F));
        PartDefinition cube_r12 = crown.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(47, 37).addBox(-0.5F, -1.75F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, -2.0F, -2.0F, 0.4363F, 0.0F, 0.2618F));
        PartDefinition cube_r13 = crown.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(47, 37).addBox(-0.5F, -1.75F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, -2.0F, 0.75F, -0.1745F, 0.0F, -0.2182F));
        PartDefinition cube_r14 = crown.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(47, 37).addBox(-0.5F, -1.5F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, -2.0F, -2.0F, 0.4363F, 0.0F, -0.2618F));
        PartDefinition cube_r15 = crown.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(47, 37).addBox(-1.0F, -1.75F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -2.0F, 0.75F, -0.1745F, 0.0F, -0.6545F));
        PartDefinition cube_r16 = crown.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(47, 37).addBox(-1.25F, -1.75F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -2.0F, -2.0F, 0.5236F, 0.0F, -0.5236F));
        PartDefinition outerTentacleF1_1 = base.addOrReplaceChild("outerTentacleF1_1", CubeListBuilder.create().texOffs(65, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.25F, 0.0F, -3.25F));
        PartDefinition outerTentacleF1_2 = outerTentacleF1_1.addOrReplaceChild("outerTentacleF1_2", CubeListBuilder.create().texOffs(68, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition outerTentacleF1_3 = outerTentacleF1_2.addOrReplaceChild("outerTentacleF1_3", CubeListBuilder.create().texOffs(71, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition outerTentacleB1_1 = base.addOrReplaceChild("outerTentacleB1_1", CubeListBuilder.create().texOffs(65, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.25F, 0.0F, 5.25F));
        PartDefinition outerTentacleB1_2 = outerTentacleB1_1.addOrReplaceChild("outerTentacleB1_2", CubeListBuilder.create().texOffs(68, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition outerTentacleB1_3 = outerTentacleB1_2.addOrReplaceChild("outerTentacleB1_3", CubeListBuilder.create().texOffs(71, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition outerTentacleF2_1 = base.addOrReplaceChild("outerTentacleF2_1", CubeListBuilder.create().texOffs(65, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 0.0F, -3.25F));
        PartDefinition outerTentacleF2_2 = outerTentacleF2_1.addOrReplaceChild("outerTentacleF2_2", CubeListBuilder.create().texOffs(68, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition outerTentacleF2_3 = outerTentacleF2_2.addOrReplaceChild("outerTentacleF2_3", CubeListBuilder.create().texOffs(71, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition outerTentacleB2_1 = base.addOrReplaceChild("outerTentacleB2_1", CubeListBuilder.create().texOffs(65, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 0.0F, 5.25F));
        PartDefinition outerTentacleB2_2 = outerTentacleB2_1.addOrReplaceChild("outerTentacleB2_2", CubeListBuilder.create().texOffs(68, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition outerTentacleB2_3 = outerTentacleB2_2.addOrReplaceChild("outerTentacleB2_3", CubeListBuilder.create().texOffs(71, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition outerTentacleF3_1 = base.addOrReplaceChild("outerTentacleF3_1", CubeListBuilder.create().texOffs(65, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.45F));
        PartDefinition outerTentacleF3_2 = outerTentacleF3_1.addOrReplaceChild("outerTentacleF3_2", CubeListBuilder.create().texOffs(68, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition outerTentacleF3_3 = outerTentacleF3_2.addOrReplaceChild("outerTentacleF3_3", CubeListBuilder.create().texOffs(71, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition outerTentacleB3_1 = base.addOrReplaceChild("outerTentacleB3_1", CubeListBuilder.create().texOffs(65, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 5.35F));
        PartDefinition outerTentacleB3_2 = outerTentacleB3_1.addOrReplaceChild("outerTentacleB3_2", CubeListBuilder.create().texOffs(68, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition outerTentacleB3_3 = outerTentacleB3_2.addOrReplaceChild("outerTentacleB3_3", CubeListBuilder.create().texOffs(71, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition outerTentacleF4_1 = base.addOrReplaceChild("outerTentacleF4_1", CubeListBuilder.create().texOffs(65, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 0.0F, -3.25F));
        PartDefinition outerTentacleF4_2 = outerTentacleF4_1.addOrReplaceChild("outerTentacleF4_2", CubeListBuilder.create().texOffs(68, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition outerTentacleF4_3 = outerTentacleF4_2.addOrReplaceChild("outerTentacleF4_3", CubeListBuilder.create().texOffs(71, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition outerTentacleB4_1 = base.addOrReplaceChild("outerTentacleB4_1", CubeListBuilder.create().texOffs(65, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 0.0F, 5.25F));
        PartDefinition outerTentacleB4_2 = outerTentacleB4_1.addOrReplaceChild("outerTentacleB4_2", CubeListBuilder.create().texOffs(68, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition outerTentacleB4_3 = outerTentacleB4_2.addOrReplaceChild("outerTentacleB4_3", CubeListBuilder.create().texOffs(71, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition outerTentacleF5_1 = base.addOrReplaceChild("outerTentacleF5_1", CubeListBuilder.create().texOffs(65, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(3.25F, 0.0F, -3.25F));
        PartDefinition outerTentacleF5_2 = outerTentacleF5_1.addOrReplaceChild("outerTentacleF5_2", CubeListBuilder.create().texOffs(68, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition outerTentacleF5_3 = outerTentacleF5_2.addOrReplaceChild("outerTentacleF5_3", CubeListBuilder.create().texOffs(71, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition outerTentacleB5_1 = base.addOrReplaceChild("outerTentacleB5_1", CubeListBuilder.create().texOffs(65, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(3.25F, 0.0F, 5.25F));
        PartDefinition outerTentacleB5_2 = outerTentacleB5_1.addOrReplaceChild("outerTentacleB5_2", CubeListBuilder.create().texOffs(68, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition outerTentacleB5_3 = outerTentacleB5_2.addOrReplaceChild("outerTentacleB5_3", CubeListBuilder.create().texOffs(71, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition lTentacle1_1 = base.addOrReplaceChild("lTentacle1_1", CubeListBuilder.create().texOffs(65, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 0.0F, -2.25F));
        PartDefinition lTentacle1_2 = lTentacle1_1.addOrReplaceChild("lTentacle1_2", CubeListBuilder.create().texOffs(68, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition lTentacle1_3 = lTentacle1_2.addOrReplaceChild("lTentacle1_3", CubeListBuilder.create().texOffs(71, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition rTentacle1_1 = base.addOrReplaceChild("rTentacle1_1", CubeListBuilder.create().texOffs(65, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 0.0F, -2.25F));
        PartDefinition rTentacle1_2 = rTentacle1_1.addOrReplaceChild("rTentacle1_2", CubeListBuilder.create().texOffs(68, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition lTenracle1_3 = rTentacle1_2.addOrReplaceChild("lTenracle1_3", CubeListBuilder.create().texOffs(71, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition lTentacle2_1 = base.addOrReplaceChild("lTentacle2_1", CubeListBuilder.create().texOffs(65, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 0.0F, -0.5F));
        PartDefinition lTentacle2_2 = lTentacle2_1.addOrReplaceChild("lTentacle2_2", CubeListBuilder.create().texOffs(68, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition lTentacle2_3 = lTentacle2_2.addOrReplaceChild("lTentacle2_3", CubeListBuilder.create().texOffs(71, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition rTentacle2_1 = base.addOrReplaceChild("rTentacle2_1", CubeListBuilder.create().texOffs(65, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 0.0F, -0.5F));
        PartDefinition rTentacle2_2 = rTentacle2_1.addOrReplaceChild("rTentacle2_2", CubeListBuilder.create().texOffs(68, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition rTentacle2_3 = rTentacle2_2.addOrReplaceChild("rTentacle2_3", CubeListBuilder.create().texOffs(71, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition lTentacle3_1 = base.addOrReplaceChild("lTentacle3_1", CubeListBuilder.create().texOffs(65, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 0.0F, 1.0F));
        PartDefinition lTentacle3_2 = lTentacle3_1.addOrReplaceChild("lTentacle3_2", CubeListBuilder.create().texOffs(68, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition lTentacle3_3 = lTentacle3_2.addOrReplaceChild("lTentacle3_3", CubeListBuilder.create().texOffs(71, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition rTentacle3_1 = base.addOrReplaceChild("rTentacle3_1", CubeListBuilder.create().texOffs(65, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 0.0F, 1.0F));
        PartDefinition rTentacle3_2 = rTentacle3_1.addOrReplaceChild("rTentacle3_2", CubeListBuilder.create().texOffs(68, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition rTentacle3_3 = rTentacle3_2.addOrReplaceChild("rTentacle3_3", CubeListBuilder.create().texOffs(71, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition lTentacle4_1 = base.addOrReplaceChild("lTentacle4_1", CubeListBuilder.create().texOffs(65, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 0.0F, 2.5F));
        PartDefinition lTentacle4_2 = lTentacle4_1.addOrReplaceChild("lTentacle4_2", CubeListBuilder.create().texOffs(68, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition lTentacle4_3 = lTentacle4_2.addOrReplaceChild("lTentacle4_3", CubeListBuilder.create().texOffs(71, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition rTentacle4_1 = base.addOrReplaceChild("rTentacle4_1", CubeListBuilder.create().texOffs(65, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 0.0F, 2.5F));
        PartDefinition rTentacle4_2 = rTentacle4_1.addOrReplaceChild("rTentacle4_2", CubeListBuilder.create().texOffs(68, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition rTentacle4_3 = rTentacle4_2.addOrReplaceChild("rTentacle4_3", CubeListBuilder.create().texOffs(71, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition lTentacle5_1 = base.addOrReplaceChild("lTentacle5_1", CubeListBuilder.create().texOffs(65, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 0.0F, 4.25F));
        PartDefinition lTentacle5_2 = lTentacle5_1.addOrReplaceChild("lTentacle5_2", CubeListBuilder.create().texOffs(68, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition lTentacle5_3 = lTentacle5_2.addOrReplaceChild("lTentacle5_3", CubeListBuilder.create().texOffs(71, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition rTentacle5_1 = base.addOrReplaceChild("rTentacle5_1", CubeListBuilder.create().texOffs(65, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 0.0F, 4.25F));
        PartDefinition rTentacle5_2 = rTentacle5_1.addOrReplaceChild("rTentacle5_2", CubeListBuilder.create().texOffs(68, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition rTentacle5_3 = rTentacle5_2.addOrReplaceChild("rTentacle5_3", CubeListBuilder.create().texOffs(71, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition pulsator = base.addOrReplaceChild("pulsator", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.5F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(11, 23).addBox(-4.0F, 1.25F, -4.5F, 9.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(38, 23).addBox(-2.5F, 1.0F, -3.5F, 6.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(74, 13).addBox(-2.5F, 1.0F, -3.5F, 6.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(30, 0).addBox(-2.75F, 0.5F, 1.25F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(30, 0).addBox(2.75F, 0.25F, 1.25F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(30, 0).addBox(-2.75F, 0.5F, -1.0F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(30, 0).addBox(2.75F, 0.5F, -1.0F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(30, 0).addBox(-2.75F, 0.5F, -3.25F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(30, 0).addBox(2.75F, 0.5F, -3.25F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(37, 1).addBox(-2.25F, 0.25F, -3.75F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(37, 1).addBox(-2.25F, 0.25F, 2.75F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(37, 1).addBox(1.25F, 0.25F, -3.75F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(37, 1).addBox(1.25F, 0.5F, 2.75F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(44, 1).addBox(-0.5F, 0.25F, -4.25F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(44, 1).addBox(-0.5F, 0.25F, 3.25F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(0.0F, 6.25F, 3.5F, 1.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(0.0F, 6.25F, -3.5F, 1.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(1.75F, 6.25F, 3.25F, 1.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(1.75F, 6.25F, -3.25F, 1.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(-1.5F, 6.25F, 3.25F, 1.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(-1.5F, 6.25F, -3.25F, 1.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 13).addBox(3.0F, 6.5F, -0.5F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 13).addBox(3.0F, 6.5F, 1.5F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 13).addBox(3.0F, 6.5F, -2.5F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 13).addBox(-2.25F, 6.5F, -2.5F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 13).addBox(-2.25F, 6.5F, -0.5F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 13).addBox(-2.25F, 6.5F, 1.75F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -0.75F, 1.0F));
        PartDefinition middleTentacle1_1 = base.addOrReplaceChild("middleTentacle1_1", CubeListBuilder.create().texOffs(65, 27).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -1.25F, 3.0F));
        PartDefinition middleTentacle1_2 = middleTentacle1_1.addOrReplaceChild("middleTentacle1_2", CubeListBuilder.create().texOffs(72, 27).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition middleTentacle1_3 = middleTentacle1_2.addOrReplaceChild("middleTentacle1_3", CubeListBuilder.create().texOffs(79, 27).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition middleTentacle2_1 = base.addOrReplaceChild("middleTentacle2_1", CubeListBuilder.create().texOffs(65, 27).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -0.75F, -1.0F));
        PartDefinition middleTentacle2_2 = middleTentacle2_1.addOrReplaceChild("middleTentacle2_2", CubeListBuilder.create().texOffs(72, 27).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition middleTentacle2_3 = middleTentacle2_2.addOrReplaceChild("middleTentacle2_3", CubeListBuilder.create().texOffs(79, 27).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition middleTentacle3_1 = base.addOrReplaceChild("middleTentacle3_1", CubeListBuilder.create().texOffs(65, 24).addBox(0.0F, 0.0F, -1.5F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -0.75F, 1.0F));
        PartDefinition middleTentacle3_2 = middleTentacle3_1.addOrReplaceChild("middleTentacle3_2", CubeListBuilder.create().texOffs(72, 24).addBox(0.0F, 0.0F, -1.5F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition middleTentacle3_3 = middleTentacle3_2.addOrReplaceChild("middleTentacle3_3", CubeListBuilder.create().texOffs(79, 24).addBox(0.0F, 0.0F, -1.5F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition middleTentacle4_1 = base.addOrReplaceChild("middleTentacle4_1", CubeListBuilder.create().texOffs(65, 24).addBox(0.0F, 0.0F, -1.5F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -1.25F, 1.0F));
        PartDefinition middleTentacle4_2 = middleTentacle4_1.addOrReplaceChild("middleTentacle4_2", CubeListBuilder.create().texOffs(72, 24).addBox(0.0F, 0.0F, -1.5F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition middleTentacle4_3 = middleTentacle4_2.addOrReplaceChild("middleTentacle4_3", CubeListBuilder.create().texOffs(79, 24).addBox(0.0F, 0.0F, -1.5F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 128, 80);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.base.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
}
