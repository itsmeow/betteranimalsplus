package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import net.minecraft.client.model.geom.ModelPart;
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

    public ModelJellyfish() {
        texWidth = 128;
        texHeight = 80;

        base = new ModelPart(this);
        base.setPos(0.0F, 17.75F, -1.0F);
        base.texOffs(0, 0).addBox(-5.0F, -2.0F, -4.0F, 10.0F, 2.0F, 10.0F, 0.0F, false);
        base.texOffs(41, 0).addBox(-5.0F, -3.0F, -4.0F, 10.0F, 3.0F, 10.0F, 0.0F, false);
        base.texOffs(82, 0).addBox(-4.5F, -3.75F, -3.5F, 9.0F, 2.0F, 9.0F, 0.0F, false);
        base.texOffs(0, 13).addBox(-4.0F, -4.25F, -3.0F, 8.0F, 1.0F, 8.0F, 0.0F, false);
        base.texOffs(33, 13).addBox(-4.0F, -5.25F, -3.0F, 8.0F, 2.0F, 8.0F, 0.0F, false);
        base.texOffs(0, 35).addBox(-2.5F, -4.0F, -1.5F, 5.0F, 1.0F, 5.0F, 0.0F, false);
        base.texOffs(20, 36).addBox(-2.0F, -4.5F, -1.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);

        crown = new ModelPart(this);
        crown.setPos(0.0F, -3.0F, 1.0F);
        base.addChild(crown);
        crown.texOffs(0, 41).addBox(-4.5F, -1.0F, -4.5F, 9.0F, 1.0F, 9.0F, 0.0F, false);
        crown.texOffs(27, 42).addBox(-3.0F, -2.25F, -3.0F, 6.0F, 2.0F, 6.0F, 0.0F, false);

        cube_r1 = new ModelPart(this);
        cube_r1.setPos(-2.5F, -2.0F, 2.25F);
        crown.addChild(cube_r1);
        setRotationAngle(cube_r1, -0.5236F, 0.0F, -0.5236F);
        cube_r1.texOffs(47, 37).addBox(-0.75F, -1.5F, -0.25F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r2 = new ModelPart(this);
        cube_r2.setPos(-2.25F, -2.0F, -0.75F);
        crown.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.1309F, 0.0F, -0.6545F);
        cube_r2.texOffs(47, 37).addBox(-0.75F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r3 = new ModelPart(this);
        cube_r3.setPos(-0.75F, -2.0F, 2.25F);
        crown.addChild(cube_r3);
        setRotationAngle(cube_r3, -0.6981F, 0.0F, -0.0873F);
        cube_r3.texOffs(47, 37).addBox(-0.5F, -1.5F, -0.25F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r4 = new ModelPart(this);
        cube_r4.setPos(-0.75F, -2.0F, -0.75F);
        crown.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.1745F, 0.0F, -0.3491F);
        cube_r4.texOffs(47, 37).addBox(-0.5F, -1.75F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r5 = new ModelPart(this);
        cube_r5.setPos(0.75F, -2.0F, -0.75F);
        crown.addChild(cube_r5);
        setRotationAngle(cube_r5, 0.1745F, 0.0F, 0.3491F);
        cube_r5.texOffs(47, 37).addBox(-0.5F, -1.75F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r6 = new ModelPart(this);
        cube_r6.setPos(2.25F, -2.0F, -0.75F);
        crown.addChild(cube_r6);
        setRotationAngle(cube_r6, 0.1309F, 0.0F, 0.6545F);
        cube_r6.texOffs(47, 37).addBox(-0.25F, -1.75F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r7 = new ModelPart(this);
        cube_r7.setPos(2.25F, -2.0F, 2.25F);
        crown.addChild(cube_r7);
        setRotationAngle(cube_r7, -0.5236F, 0.0F, 0.5236F);
        cube_r7.texOffs(47, 37).addBox(-0.25F, -1.75F, -0.75F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r8 = new ModelPart(this);
        cube_r8.setPos(2.25F, -2.0F, 0.75F);
        crown.addChild(cube_r8);
        setRotationAngle(cube_r8, -0.1745F, 0.0F, 0.6545F);
        cube_r8.texOffs(47, 37).addBox(-0.25F, -1.75F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r9 = new ModelPart(this);
        cube_r9.setPos(2.0F, -2.0F, -2.0F);
        crown.addChild(cube_r9);
        setRotationAngle(cube_r9, 0.5236F, 0.0F, 0.5236F);
        cube_r9.texOffs(47, 37).addBox(0.0F, -1.75F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r10 = new ModelPart(this);
        cube_r10.setPos(0.75F, -2.0F, 2.25F);
        crown.addChild(cube_r10);
        setRotationAngle(cube_r10, -0.6981F, 0.0F, 0.0873F);
        cube_r10.texOffs(47, 37).addBox(-0.5F, -1.75F, -0.25F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r11 = new ModelPart(this);
        cube_r11.setPos(0.75F, -2.0F, 0.75F);
        crown.addChild(cube_r11);
        setRotationAngle(cube_r11, -0.1745F, 0.0F, 0.2182F);
        cube_r11.texOffs(47, 37).addBox(-0.5F, -1.75F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r12 = new ModelPart(this);
        cube_r12.setPos(0.75F, -2.0F, -2.0F);
        crown.addChild(cube_r12);
        setRotationAngle(cube_r12, 0.4363F, 0.0F, 0.2618F);
        cube_r12.texOffs(47, 37).addBox(-0.5F, -1.75F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r13 = new ModelPart(this);
        cube_r13.setPos(-0.75F, -2.0F, 0.75F);
        crown.addChild(cube_r13);
        setRotationAngle(cube_r13, -0.1745F, 0.0F, -0.2182F);
        cube_r13.texOffs(47, 37).addBox(-0.5F, -1.75F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r14 = new ModelPart(this);
        cube_r14.setPos(-0.75F, -2.0F, -2.0F);
        crown.addChild(cube_r14);
        setRotationAngle(cube_r14, 0.4363F, 0.0F, -0.2618F);
        cube_r14.texOffs(47, 37).addBox(-0.5F, -1.5F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r15 = new ModelPart(this);
        cube_r15.setPos(-2.0F, -2.0F, 0.75F);
        crown.addChild(cube_r15);
        setRotationAngle(cube_r15, -0.1745F, 0.0F, -0.6545F);
        cube_r15.texOffs(47, 37).addBox(-1.0F, -1.75F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r16 = new ModelPart(this);
        cube_r16.setPos(-2.0F, -2.0F, -2.0F);
        crown.addChild(cube_r16);
        setRotationAngle(cube_r16, 0.5236F, 0.0F, -0.5236F);
        cube_r16.texOffs(47, 37).addBox(-1.25F, -1.75F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        outerTentacleF1_1 = new ModelPart(this);
        outerTentacleF1_1.setPos(-3.25F, 0.0F, -3.25F);
        base.addChild(outerTentacleF1_1);
        outerTentacleF1_1.texOffs(65, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, false);

        outerTentacleF1_2 = new ModelPart(this);
        outerTentacleF1_2.setPos(0.0F, 7.0F, 0.0F);
        outerTentacleF1_1.addChild(outerTentacleF1_2);
        outerTentacleF1_2.texOffs(68, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, false);

        outerTentacleF1_3 = new ModelPart(this);
        outerTentacleF1_3.setPos(0.0F, 7.0F, 0.0F);
        outerTentacleF1_2.addChild(outerTentacleF1_3);
        outerTentacleF1_3.texOffs(71, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, false);

        outerTentacleB1_1 = new ModelPart(this);
        outerTentacleB1_1.setPos(-3.25F, 0.0F, 5.25F);
        base.addChild(outerTentacleB1_1);
        outerTentacleB1_1.texOffs(65, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, false);

        outerTentacleB1_2 = new ModelPart(this);
        outerTentacleB1_2.setPos(0.0F, 7.0F, 0.0F);
        outerTentacleB1_1.addChild(outerTentacleB1_2);
        outerTentacleB1_2.texOffs(68, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, false);

        outerTentacleB1_3 = new ModelPart(this);
        outerTentacleB1_3.setPos(0.0F, 7.0F, 0.0F);
        outerTentacleB1_2.addChild(outerTentacleB1_3);
        outerTentacleB1_3.texOffs(71, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, false);

        outerTentacleF2_1 = new ModelPart(this);
        outerTentacleF2_1.setPos(-1.5F, 0.0F, -3.25F);
        base.addChild(outerTentacleF2_1);
        outerTentacleF2_1.texOffs(65, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, false);

        outerTentacleF2_2 = new ModelPart(this);
        outerTentacleF2_2.setPos(0.0F, 7.0F, 0.0F);
        outerTentacleF2_1.addChild(outerTentacleF2_2);
        outerTentacleF2_2.texOffs(68, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, false);

        outerTentacleF2_3 = new ModelPart(this);
        outerTentacleF2_3.setPos(0.0F, 7.0F, 0.0F);
        outerTentacleF2_2.addChild(outerTentacleF2_3);
        outerTentacleF2_3.texOffs(71, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, false);

        outerTentacleB2_1 = new ModelPart(this);
        outerTentacleB2_1.setPos(-1.5F, 0.0F, 5.25F);
        base.addChild(outerTentacleB2_1);
        outerTentacleB2_1.texOffs(65, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, false);

        outerTentacleB2_2 = new ModelPart(this);
        outerTentacleB2_2.setPos(0.0F, 7.0F, 0.0F);
        outerTentacleB2_1.addChild(outerTentacleB2_2);
        outerTentacleB2_2.texOffs(68, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, false);

        outerTentacleB2_3 = new ModelPart(this);
        outerTentacleB2_3.setPos(0.0F, 7.0F, 0.0F);
        outerTentacleB2_2.addChild(outerTentacleB2_3);
        outerTentacleB2_3.texOffs(71, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, false);

        outerTentacleF3_1 = new ModelPart(this);
        outerTentacleF3_1.setPos(0.0F, 0.0F, -3.45F);
        base.addChild(outerTentacleF3_1);
        outerTentacleF3_1.texOffs(65, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, false);

        outerTentacleF3_2 = new ModelPart(this);
        outerTentacleF3_2.setPos(0.0F, 7.0F, 0.0F);
        outerTentacleF3_1.addChild(outerTentacleF3_2);
        outerTentacleF3_2.texOffs(68, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, false);

        outerTentacleF3_3 = new ModelPart(this);
        outerTentacleF3_3.setPos(0.0F, 7.0F, 0.0F);
        outerTentacleF3_2.addChild(outerTentacleF3_3);
        outerTentacleF3_3.texOffs(71, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, false);

        outerTentacleB3_1 = new ModelPart(this);
        outerTentacleB3_1.setPos(0.0F, 0.0F, 5.35F);
        base.addChild(outerTentacleB3_1);
        outerTentacleB3_1.texOffs(65, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, false);

        outerTentacleB3_2 = new ModelPart(this);
        outerTentacleB3_2.setPos(0.0F, 7.0F, 0.0F);
        outerTentacleB3_1.addChild(outerTentacleB3_2);
        outerTentacleB3_2.texOffs(68, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, false);

        outerTentacleB3_3 = new ModelPart(this);
        outerTentacleB3_3.setPos(0.0F, 7.0F, 0.0F);
        outerTentacleB3_2.addChild(outerTentacleB3_3);
        outerTentacleB3_3.texOffs(71, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, false);

        outerTentacleF4_1 = new ModelPart(this);
        outerTentacleF4_1.setPos(1.5F, 0.0F, -3.25F);
        base.addChild(outerTentacleF4_1);
        outerTentacleF4_1.texOffs(65, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, false);

        outerTentacleF4_2 = new ModelPart(this);
        outerTentacleF4_2.setPos(0.0F, 7.0F, 0.0F);
        outerTentacleF4_1.addChild(outerTentacleF4_2);
        outerTentacleF4_2.texOffs(68, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, false);

        outerTentacleF4_3 = new ModelPart(this);
        outerTentacleF4_3.setPos(0.0F, 7.0F, 0.0F);
        outerTentacleF4_2.addChild(outerTentacleF4_3);
        outerTentacleF4_3.texOffs(71, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, false);

        outerTentacleB4_1 = new ModelPart(this);
        outerTentacleB4_1.setPos(1.5F, 0.0F, 5.25F);
        base.addChild(outerTentacleB4_1);
        outerTentacleB4_1.texOffs(65, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, false);

        outerTentacleB4_2 = new ModelPart(this);
        outerTentacleB4_2.setPos(0.0F, 7.0F, 0.0F);
        outerTentacleB4_1.addChild(outerTentacleB4_2);
        outerTentacleB4_2.texOffs(68, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, false);

        outerTentacleB4_3 = new ModelPart(this);
        outerTentacleB4_3.setPos(0.0F, 7.0F, 0.0F);
        outerTentacleB4_2.addChild(outerTentacleB4_3);
        outerTentacleB4_3.texOffs(71, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, false);

        outerTentacleF5_1 = new ModelPart(this);
        outerTentacleF5_1.setPos(3.25F, 0.0F, -3.25F);
        base.addChild(outerTentacleF5_1);
        outerTentacleF5_1.texOffs(65, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, false);

        outerTentacleF5_2 = new ModelPart(this);
        outerTentacleF5_2.setPos(0.0F, 7.0F, 0.0F);
        outerTentacleF5_1.addChild(outerTentacleF5_2);
        outerTentacleF5_2.texOffs(68, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, false);

        outerTentacleF5_3 = new ModelPart(this);
        outerTentacleF5_3.setPos(0.0F, 7.0F, 0.0F);
        outerTentacleF5_2.addChild(outerTentacleF5_3);
        outerTentacleF5_3.texOffs(71, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, false);

        outerTentacleB5_1 = new ModelPart(this);
        outerTentacleB5_1.setPos(3.25F, 0.0F, 5.25F);
        base.addChild(outerTentacleB5_1);
        outerTentacleB5_1.texOffs(65, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, false);

        outerTentacleB5_2 = new ModelPart(this);
        outerTentacleB5_2.setPos(0.0F, 7.0F, 0.0F);
        outerTentacleB5_1.addChild(outerTentacleB5_2);
        outerTentacleB5_2.texOffs(68, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, false);

        outerTentacleB5_3 = new ModelPart(this);
        outerTentacleB5_3.setPos(0.0F, 7.0F, 0.0F);
        outerTentacleB5_2.addChild(outerTentacleB5_3);
        outerTentacleB5_3.texOffs(71, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, false);

        lTentacle1_1 = new ModelPart(this);
        lTentacle1_1.setPos(4.0F, 0.0F, -2.25F);
        base.addChild(lTentacle1_1);
        lTentacle1_1.texOffs(65, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, 0.0F, false);

        lTentacle1_2 = new ModelPart(this);
        lTentacle1_2.setPos(0.0F, 7.0F, 0.0F);
        lTentacle1_1.addChild(lTentacle1_2);
        lTentacle1_2.texOffs(68, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, 0.0F, false);

        lTentacle1_3 = new ModelPart(this);
        lTentacle1_3.setPos(0.0F, 7.0F, 0.0F);
        lTentacle1_2.addChild(lTentacle1_3);
        lTentacle1_3.texOffs(71, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, 0.0F, false);

        rTentacle1_1 = new ModelPart(this);
        rTentacle1_1.setPos(-4.0F, 0.0F, -2.25F);
        base.addChild(rTentacle1_1);
        rTentacle1_1.texOffs(65, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, 0.0F, false);

        rTentacle1_2 = new ModelPart(this);
        rTentacle1_2.setPos(0.0F, 7.0F, 0.0F);
        rTentacle1_1.addChild(rTentacle1_2);
        rTentacle1_2.texOffs(68, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, 0.0F, false);

        lTenracle1_3 = new ModelPart(this);
        lTenracle1_3.setPos(0.0F, 7.0F, 0.0F);
        rTentacle1_2.addChild(lTenracle1_3);
        lTenracle1_3.texOffs(71, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, 0.0F, false);

        lTentacle2_1 = new ModelPart(this);
        lTentacle2_1.setPos(4.0F, 0.0F, -0.5F);
        base.addChild(lTentacle2_1);
        lTentacle2_1.texOffs(65, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, 0.0F, false);

        lTentacle2_2 = new ModelPart(this);
        lTentacle2_2.setPos(0.0F, 7.0F, 0.0F);
        lTentacle2_1.addChild(lTentacle2_2);
        lTentacle2_2.texOffs(68, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, 0.0F, false);

        lTentacle2_3 = new ModelPart(this);
        lTentacle2_3.setPos(0.0F, 7.0F, 0.0F);
        lTentacle2_2.addChild(lTentacle2_3);
        lTentacle2_3.texOffs(71, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, 0.0F, false);

        rTentacle2_1 = new ModelPart(this);
        rTentacle2_1.setPos(-4.0F, 0.0F, -0.5F);
        base.addChild(rTentacle2_1);
        rTentacle2_1.texOffs(65, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, 0.0F, false);

        rTentacle2_2 = new ModelPart(this);
        rTentacle2_2.setPos(0.0F, 7.0F, 0.0F);
        rTentacle2_1.addChild(rTentacle2_2);
        rTentacle2_2.texOffs(68, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, 0.0F, false);

        rTentacle2_3 = new ModelPart(this);
        rTentacle2_3.setPos(0.0F, 7.0F, 0.0F);
        rTentacle2_2.addChild(rTentacle2_3);
        rTentacle2_3.texOffs(71, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, 0.0F, false);

        lTentacle3_1 = new ModelPart(this);
        lTentacle3_1.setPos(4.0F, 0.0F, 1.0F);
        base.addChild(lTentacle3_1);
        lTentacle3_1.texOffs(65, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, 0.0F, false);

        lTentacle3_2 = new ModelPart(this);
        lTentacle3_2.setPos(0.0F, 7.0F, 0.0F);
        lTentacle3_1.addChild(lTentacle3_2);
        lTentacle3_2.texOffs(68, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, 0.0F, false);

        lTentacle3_3 = new ModelPart(this);
        lTentacle3_3.setPos(0.0F, 7.0F, 0.0F);
        lTentacle3_2.addChild(lTentacle3_3);
        lTentacle3_3.texOffs(71, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, 0.0F, false);

        rTentacle3_1 = new ModelPart(this);
        rTentacle3_1.setPos(-4.0F, 0.0F, 1.0F);
        base.addChild(rTentacle3_1);
        rTentacle3_1.texOffs(65, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, 0.0F, false);

        rTentacle3_2 = new ModelPart(this);
        rTentacle3_2.setPos(0.0F, 7.0F, 0.0F);
        rTentacle3_1.addChild(rTentacle3_2);
        rTentacle3_2.texOffs(68, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, 0.0F, false);

        rTentacle3_3 = new ModelPart(this);
        rTentacle3_3.setPos(0.0F, 7.0F, 0.0F);
        rTentacle3_2.addChild(rTentacle3_3);
        rTentacle3_3.texOffs(71, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, 0.0F, false);

        lTentacle4_1 = new ModelPart(this);
        lTentacle4_1.setPos(4.0F, 0.0F, 2.5F);
        base.addChild(lTentacle4_1);
        lTentacle4_1.texOffs(65, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, 0.0F, false);

        lTentacle4_2 = new ModelPart(this);
        lTentacle4_2.setPos(0.0F, 7.0F, 0.0F);
        lTentacle4_1.addChild(lTentacle4_2);
        lTentacle4_2.texOffs(68, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, 0.0F, false);

        lTentacle4_3 = new ModelPart(this);
        lTentacle4_3.setPos(0.0F, 7.0F, 0.0F);
        lTentacle4_2.addChild(lTentacle4_3);
        lTentacle4_3.texOffs(71, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, 0.0F, false);

        rTentacle4_1 = new ModelPart(this);
        rTentacle4_1.setPos(-4.0F, 0.0F, 2.5F);
        base.addChild(rTentacle4_1);
        rTentacle4_1.texOffs(65, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, 0.0F, false);

        rTentacle4_2 = new ModelPart(this);
        rTentacle4_2.setPos(0.0F, 7.0F, 0.0F);
        rTentacle4_1.addChild(rTentacle4_2);
        rTentacle4_2.texOffs(68, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, 0.0F, false);

        rTentacle4_3 = new ModelPart(this);
        rTentacle4_3.setPos(0.0F, 7.0F, 0.0F);
        rTentacle4_2.addChild(rTentacle4_3);
        rTentacle4_3.texOffs(71, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, 0.0F, false);

        lTentacle5_1 = new ModelPart(this);
        lTentacle5_1.setPos(4.0F, 0.0F, 4.25F);
        base.addChild(lTentacle5_1);
        lTentacle5_1.texOffs(65, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, 0.0F, false);

        lTentacle5_2 = new ModelPart(this);
        lTentacle5_2.setPos(0.0F, 7.0F, 0.0F);
        lTentacle5_1.addChild(lTentacle5_2);
        lTentacle5_2.texOffs(68, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, 0.0F, false);

        lTentacle5_3 = new ModelPart(this);
        lTentacle5_3.setPos(0.0F, 7.0F, 0.0F);
        lTentacle5_2.addChild(lTentacle5_3);
        lTentacle5_3.texOffs(71, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, 0.0F, false);

        rTentacle5_1 = new ModelPart(this);
        rTentacle5_1.setPos(-4.0F, 0.0F, 4.25F);
        base.addChild(rTentacle5_1);
        rTentacle5_1.texOffs(65, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, 0.0F, false);

        rTentacle5_2 = new ModelPart(this);
        rTentacle5_2.setPos(0.0F, 7.0F, 0.0F);
        rTentacle5_1.addChild(rTentacle5_2);
        rTentacle5_2.texOffs(68, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, 0.0F, false);

        rTentacle5_3 = new ModelPart(this);
        rTentacle5_3.setPos(0.0F, 7.0F, 0.0F);
        rTentacle5_2.addChild(rTentacle5_3);
        rTentacle5_3.texOffs(71, 15).addBox(0.0F, 0.0F, -0.5F, 0.0F, 7.0F, 1.0F, 0.0F, false);

        pulsator = new ModelPart(this);
        pulsator.setPos(-0.5F, -0.75F, 1.0F);
        base.addChild(pulsator);
        pulsator.texOffs(0, 22).addBox(-2.0F, 0.0F, -2.5F, 5.0F, 2.0F, 5.0F, 0.0F, false);
        pulsator.texOffs(11, 23).addBox(-4.0F, 1.25F, -4.5F, 9.0F, 3.0F, 9.0F, 0.0F, false);
        pulsator.texOffs(38, 23).addBox(-2.5F, 1.0F, -3.5F, 6.0F, 2.0F, 7.0F, 0.0F, false);
        pulsator.texOffs(74, 13).addBox(-2.5F, 1.0F, -3.5F, 6.0F, 5.0F, 7.0F, 0.0F, false);
        pulsator.texOffs(30, 0).addBox(-2.75F, 0.5F, 1.25F, 1.0F, 6.0F, 2.0F, 0.0F, false);
        pulsator.texOffs(30, 0).addBox(2.75F, 0.25F, 1.25F, 1.0F, 6.0F, 2.0F, 0.0F, false);
        pulsator.texOffs(30, 0).addBox(-2.75F, 0.5F, -1.0F, 1.0F, 6.0F, 2.0F, 0.0F, false);
        pulsator.texOffs(30, 0).addBox(2.75F, 0.5F, -1.0F, 1.0F, 6.0F, 2.0F, 0.0F, false);
        pulsator.texOffs(30, 0).addBox(-2.75F, 0.5F, -3.25F, 1.0F, 6.0F, 2.0F, 0.0F, false);
        pulsator.texOffs(30, 0).addBox(2.75F, 0.5F, -3.25F, 1.0F, 6.0F, 2.0F, 0.0F, false);
        pulsator.texOffs(37, 1).addBox(-2.25F, 0.25F, -3.75F, 2.0F, 6.0F, 1.0F, 0.0F, false);
        pulsator.texOffs(37, 1).addBox(-2.25F, 0.25F, 2.75F, 2.0F, 6.0F, 1.0F, 0.0F, false);
        pulsator.texOffs(37, 1).addBox(1.25F, 0.25F, -3.75F, 2.0F, 6.0F, 1.0F, 0.0F, false);
        pulsator.texOffs(37, 1).addBox(1.25F, 0.5F, 2.75F, 2.0F, 6.0F, 1.0F, 0.0F, false);
        pulsator.texOffs(44, 1).addBox(-0.5F, 0.25F, -4.25F, 2.0F, 6.0F, 1.0F, 0.0F, false);
        pulsator.texOffs(44, 1).addBox(-0.5F, 0.25F, 3.25F, 2.0F, 6.0F, 1.0F, 0.0F, false);
        pulsator.texOffs(0, 14).addBox(0.0F, 6.25F, 3.5F, 1.0F, 5.0F, 0.0F, 0.0F, false);
        pulsator.texOffs(0, 14).addBox(0.0F, 6.25F, -3.5F, 1.0F, 5.0F, 0.0F, 0.0F, false);
        pulsator.texOffs(0, 14).addBox(1.75F, 6.25F, 3.25F, 1.0F, 5.0F, 0.0F, 0.0F, false);
        pulsator.texOffs(0, 14).addBox(1.75F, 6.25F, -3.25F, 1.0F, 5.0F, 0.0F, 0.0F, false);
        pulsator.texOffs(0, 14).addBox(-1.5F, 6.25F, 3.25F, 1.0F, 5.0F, 0.0F, 0.0F, false);
        pulsator.texOffs(0, 14).addBox(-1.5F, 6.25F, -3.25F, 1.0F, 5.0F, 0.0F, 0.0F, false);
        pulsator.texOffs(0, 13).addBox(3.0F, 6.5F, -0.5F, 0.0F, 5.0F, 1.0F, 0.0F, false);
        pulsator.texOffs(0, 13).addBox(3.0F, 6.5F, 1.5F, 0.0F, 5.0F, 1.0F, 0.0F, false);
        pulsator.texOffs(0, 13).addBox(3.0F, 6.5F, -2.5F, 0.0F, 5.0F, 1.0F, 0.0F, false);
        pulsator.texOffs(0, 13).addBox(-2.25F, 6.5F, -2.5F, 0.0F, 5.0F, 1.0F, 0.0F, false);
        pulsator.texOffs(0, 13).addBox(-2.25F, 6.5F, -0.5F, 0.0F, 5.0F, 1.0F, 0.0F, false);
        pulsator.texOffs(0, 13).addBox(-2.25F, 6.5F, 1.75F, 0.0F, 5.0F, 1.0F, 0.0F, false);

        middleTentacle1_1 = new ModelPart(this);
        middleTentacle1_1.setPos(0.5F, -1.25F, 3.0F);
        base.addChild(middleTentacle1_1);
        middleTentacle1_1.texOffs(65, 27).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 7.0F, 0.0F, 0.0F, false);

        middleTentacle1_2 = new ModelPart(this);
        middleTentacle1_2.setPos(0.0F, 7.0F, 0.0F);
        middleTentacle1_1.addChild(middleTentacle1_2);
        middleTentacle1_2.texOffs(72, 27).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 7.0F, 0.0F, 0.0F, false);

        middleTentacle1_3 = new ModelPart(this);
        middleTentacle1_3.setPos(0.0F, 7.0F, 0.0F);
        middleTentacle1_2.addChild(middleTentacle1_3);
        middleTentacle1_3.texOffs(79, 27).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 7.0F, 0.0F, 0.0F, false);

        middleTentacle2_1 = new ModelPart(this);
        middleTentacle2_1.setPos(0.5F, -0.75F, -1.0F);
        base.addChild(middleTentacle2_1);
        middleTentacle2_1.texOffs(65, 27).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 7.0F, 0.0F, 0.0F, false);

        middleTentacle2_2 = new ModelPart(this);
        middleTentacle2_2.setPos(0.0F, 7.0F, 0.0F);
        middleTentacle2_1.addChild(middleTentacle2_2);
        middleTentacle2_2.texOffs(72, 27).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 7.0F, 0.0F, 0.0F, false);

        middleTentacle2_3 = new ModelPart(this);
        middleTentacle2_3.setPos(0.0F, 7.0F, 0.0F);
        middleTentacle2_2.addChild(middleTentacle2_3);
        middleTentacle2_3.texOffs(79, 27).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 7.0F, 0.0F, 0.0F, false);

        middleTentacle3_1 = new ModelPart(this);
        middleTentacle3_1.setPos(-2.5F, 0.0F, 2.0F);
        middleTentacle2_1.addChild(middleTentacle3_1);
        middleTentacle3_1.texOffs(65, 24).addBox(0.0F, 0.0F, -1.5F, 0.0F, 7.0F, 3.0F, 0.0F, false);

        middleTentacle3_2 = new ModelPart(this);
        middleTentacle3_2.setPos(0.0F, 7.0F, 0.0F);
        middleTentacle3_1.addChild(middleTentacle3_2);
        middleTentacle3_2.texOffs(72, 24).addBox(0.0F, 0.0F, -1.5F, 0.0F, 7.0F, 3.0F, 0.0F, false);

        middleTentacle3_3 = new ModelPart(this);
        middleTentacle3_3.setPos(0.0F, 7.0F, 0.0F);
        middleTentacle3_2.addChild(middleTentacle3_3);
        middleTentacle3_3.texOffs(79, 24).addBox(0.0F, 0.0F, -1.5F, 0.0F, 7.0F, 3.0F, 0.0F, false);

        middleTentacle4_1 = new ModelPart(this);
        middleTentacle4_1.setPos(1.5F, -0.5F, 2.0F);
        middleTentacle2_1.addChild(middleTentacle4_1);
        middleTentacle4_1.texOffs(65, 24).addBox(0.0F, 0.0F, -1.5F, 0.0F, 7.0F, 3.0F, 0.0F, false);

        middleTentacle4_2 = new ModelPart(this);
        middleTentacle4_2.setPos(0.0F, 7.0F, 0.0F);
        middleTentacle4_1.addChild(middleTentacle4_2);
        middleTentacle4_2.texOffs(72, 24).addBox(0.0F, 0.0F, -1.5F, 0.0F, 7.0F, 3.0F, 0.0F, false);

        middleTentacle4_3 = new ModelPart(this);
        middleTentacle4_3.setPos(0.0F, 7.0F, 0.0F);
        middleTentacle4_2.addChild(middleTentacle4_3);
        middleTentacle4_3.texOffs(79, 24).addBox(0.0F, 0.0F, -1.5F, 0.0F, 7.0F, 3.0F, 0.0F, false);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.base.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
}
