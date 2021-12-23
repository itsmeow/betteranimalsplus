package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;

/**
 * boar - cybercat5555 Created using Tabula 5.1.0
 */
public class ModelBoar<T extends LivingEntity> extends ModelBAP<T> {

    public ModelPart body;
    public ModelPart lArm01;
    public ModelPart lArm02;
    public ModelPart lArm03;
    public ModelPart lArmFur_r1;
    public ModelPart lFrontHoofClaw01a;
    public ModelPart lFrontHoofClaw01b;
    public ModelPart lFrontHoofClaw02a;
    public ModelPart lFrontHoofClaw02b;
    public ModelPart rArm01;
    public ModelPart rArm02;
    public ModelPart rArm03;
    public ModelPart rArmFur_r1;
    public ModelPart rFrontHoofClaw01a;
    public ModelPart rFrontHoofClaw01b;
    public ModelPart rFrontHoofClaw02a;
    public ModelPart rFrontHoofClaw02b;
    public ModelPart mane01;
    public ModelPart Box_r1;
    public ModelPart mane02;
    public ModelPart Box_r2;
    public ModelPart ass;
    public ModelPart lLeg01;
    public ModelPart lLeg02;
    public ModelPart lLeg03;
    public ModelPart lHindHoofClaw01a;
    public ModelPart lHindHoofClaw01b;
    public ModelPart lHindHoofClaw02a;
    public ModelPart lHindHoofClaw02b2;
    public ModelPart rLeg01;
    public ModelPart rLeg02;
    public ModelPart rLeg03;
    public ModelPart rHindHoofClaw01a;
    public ModelPart rHindHoofClaw01b;
    public ModelPart rHindHoofClaw02a;
    public ModelPart rHindHoofClaw02b;
    public ModelPart tail;
    public ModelPart tailFur;
    public ModelPart head;
    public ModelPart snoot;
    public ModelPart nose;
    public ModelPart upperJaw;
    public ModelPart lUpperTusk;
    public ModelPart rUpperTusk;
    public ModelPart lowerJaw;
    public ModelPart lTusk01;
    public ModelPart lTusk02;
    public ModelPart rTusk01;
    public ModelPart rTusk02;
    public ModelPart lEar01;
    public ModelPart lEar02;
    public ModelPart rEar01;
    public ModelPart rEar02;

    public ModelBoar() {
        texWidth = 64;
        texHeight = 64;

        body = new ModelPart(this);
        body.setPos(0.0F, 12.5F, -2.7F);
        body.texOffs(0, 0).addBox(-4.0F, -4.3F, -6.0F, 8.0F, 9.0F, 12.0F, 0.0F, false);

        lArm01 = new ModelPart(this);
        lArm01.setPos(1.8F, 0.5F, -2.7F);
        body.addChild(lArm01);
        lArm01.texOffs(0, 49).addBox(0.0F, -1.0F, -2.5F, 3.0F, 6.0F, 4.0F, 0.0F, false);

        lArm02 = new ModelPart(this);
        lArm02.setPos(1.2F, 4.6F, 0.0F);
        lArm01.addChild(lArm02);
        setRotationAngle(lArm02, -0.0436F, 0.0F, 0.0F);
        lArm02.texOffs(12, 58).addBox(-1.5F, -1.0F, -2.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);

        lArm03 = new ModelPart(this);
        lArm03.setPos(0.2F, 1.8F, 0.0F);
        lArm02.addChild(lArm03);
        lArm03.texOffs(14, 50).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        lArmFur_r1 = new ModelPart(this);
        lArmFur_r1.setPos(0.0F, 0.0F, 0.0F);
        lArm03.addChild(lArmFur_r1);
        setRotationAngle(lArmFur_r1, 0.1309F, 0.0F, 0.0F);
        lArmFur_r1.texOffs(56, 28).addBox(-0.5F, -2.5F, -1.25F, 1.0F, 7.0F, 3.0F, 0.0F, false);

        lFrontHoofClaw01a = new ModelPart(this);
        lFrontHoofClaw01a.setPos(0.35F, 4.5F, -0.55F);
        lArm03.addChild(lFrontHoofClaw01a);
        setRotationAngle(lFrontHoofClaw01a, 0.0F, -0.096F, 0.0F);
        lFrontHoofClaw01a.texOffs(30, 34).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, true);

        lFrontHoofClaw01b = new ModelPart(this);
        lFrontHoofClaw01b.setPos(0.0F, 0.0F, -1.0F);
        lFrontHoofClaw01a.addChild(lFrontHoofClaw01b);
        setRotationAngle(lFrontHoofClaw01b, 0.4363F, 0.0F, 0.0F);
        lFrontHoofClaw01b.texOffs(29, 28).addBox(-0.49F, -1.1F, -0.95F, 1.0F, 1.0F, 3.0F, 0.0F, true);

        lFrontHoofClaw02a = new ModelPart(this);
        lFrontHoofClaw02a.setPos(-0.65F, 4.5F, -0.55F);
        lArm03.addChild(lFrontHoofClaw02a);
        setRotationAngle(lFrontHoofClaw02a, 0.0F, 0.0873F, 0.0F);
        lFrontHoofClaw02a.texOffs(30, 34).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, true);

        lFrontHoofClaw02b = new ModelPart(this);
        lFrontHoofClaw02b.setPos(0.0F, 0.0F, -1.0F);
        lFrontHoofClaw02a.addChild(lFrontHoofClaw02b);
        setRotationAngle(lFrontHoofClaw02b, 0.4363F, 0.0F, 0.0F);
        lFrontHoofClaw02b.texOffs(29, 28).addBox(-0.49F, -1.1F, -0.95F, 1.0F, 1.0F, 3.0F, 0.0F, true);

        rArm01 = new ModelPart(this);
        rArm01.setPos(-1.8F, 0.5F, -2.7F);
        body.addChild(rArm01);
        rArm01.texOffs(0, 49).addBox(-3.0F, -1.0F, -2.5F, 3.0F, 6.0F, 4.0F, 0.0F, true);

        rArm02 = new ModelPart(this);
        rArm02.setPos(-1.2F, 4.6F, 0.0F);
        rArm01.addChild(rArm02);
        setRotationAngle(rArm02, -0.0436F, 0.0F, 0.0F);
        rArm02.texOffs(12, 58).addBox(-1.5F, -1.0F, -2.0F, 3.0F, 3.0F, 3.0F, 0.0F, true);

        rArm03 = new ModelPart(this);
        rArm03.setPos(-0.2F, 1.8F, 0.0F);
        rArm02.addChild(rArm03);
        rArm03.texOffs(14, 50).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 5.0F, 2.0F, 0.0F, true);

        rArmFur_r1 = new ModelPart(this);
        rArmFur_r1.setPos(0.0F, 0.0F, 0.0F);
        rArm03.addChild(rArmFur_r1);
        setRotationAngle(rArmFur_r1, 0.1309F, 0.0F, 0.0F);
        rArmFur_r1.texOffs(56, 28).addBox(-0.5F, -2.5F, -1.25F, 1.0F, 7.0F, 3.0F, 0.0F, true);

        rFrontHoofClaw01a = new ModelPart(this);
        rFrontHoofClaw01a.setPos(-0.35F, 4.5F, -0.55F);
        rArm03.addChild(rFrontHoofClaw01a);
        setRotationAngle(rFrontHoofClaw01a, 0.0F, 0.096F, 0.0F);
        rFrontHoofClaw01a.texOffs(30, 34).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        rFrontHoofClaw01b = new ModelPart(this);
        rFrontHoofClaw01b.setPos(0.0F, 0.0F, -1.0F);
        rFrontHoofClaw01a.addChild(rFrontHoofClaw01b);
        setRotationAngle(rFrontHoofClaw01b, 0.4363F, 0.0F, 0.0F);
        rFrontHoofClaw01b.texOffs(29, 28).addBox(-0.51F, -1.1F, -0.95F, 1.0F, 1.0F, 3.0F, 0.0F, false);

        rFrontHoofClaw02a = new ModelPart(this);
        rFrontHoofClaw02a.setPos(0.65F, 4.5F, -0.55F);
        rArm03.addChild(rFrontHoofClaw02a);
        setRotationAngle(rFrontHoofClaw02a, 0.0F, -0.0873F, 0.0F);
        rFrontHoofClaw02a.texOffs(30, 34).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        rFrontHoofClaw02b = new ModelPart(this);
        rFrontHoofClaw02b.setPos(0.0F, 0.0F, -1.0F);
        rFrontHoofClaw02a.addChild(rFrontHoofClaw02b);
        setRotationAngle(rFrontHoofClaw02b, 0.4363F, 0.0F, 0.0F);
        rFrontHoofClaw02b.texOffs(29, 28).addBox(-0.51F, -1.1F, -0.95F, 1.0F, 1.0F, 3.0F, 0.0F, false);

        mane01 = new ModelPart(this);
        mane01.setPos(0.0F, -3.4F, -6.95F);
        body.addChild(mane01);
        setRotationAngle(mane01, 0.5149F, 0.0F, 0.0F);


        Box_r1 = new ModelPart(this);
        Box_r1.setPos(0.0F, -0.1F, -0.1F);
        mane01.addChild(Box_r1);
        setRotationAngle(Box_r1, 0.0F, 0.0F, 0.7854F);
        Box_r1.texOffs(0, 38).addBox(-1.5F, -1.5F, -0.4F, 3.0F, 3.0F, 6.0F, -0.1F, false);

        mane02 = new ModelPart(this);
        mane02.setPos(0.0F, -4.65F, -4.1F);
        body.addChild(mane02);
        setRotationAngle(mane02, 0.1309F, 0.0F, 0.0F);


        Box_r2 = new ModelPart(this);
        Box_r2.setPos(0.0F, -0.1F, 0.05F);
        mane02.addChild(Box_r2);
        setRotationAngle(Box_r2, 0.0F, 0.0F, 0.7854F);
        Box_r2.texOffs(31, 13).addBox(-1.5F, -1.3F, -2.55F, 3.0F, 3.0F, 10.0F, -0.2F, false);

        ass = new ModelPart(this);
        ass.setPos(0.0F, -0.5F, 5.3F);
        body.addChild(ass);
        setRotationAngle(ass, -0.1309F, 0.0F, 0.0F);
        ass.texOffs(0, 22).addBox(-3.5F, -3.5F, 0.0F, 7.0F, 8.0F, 7.0F, 0.0F, false);

        lLeg01 = new ModelPart(this);
        lLeg01.setPos(1.2F, -1.7F, 3.95F);
        ass.addChild(lLeg01);
        setRotationAngle(lLeg01, 0.0F, 0.0F, -0.0911F);
        lLeg01.texOffs(29, 0).addBox(-0.5F, -1.0F, -2.5F, 4.0F, 6.0F, 5.0F, 0.0F, false);

        lLeg02 = new ModelPart(this);
        lLeg02.setPos(1.7F, 3.9F, 0.15F);
        lLeg01.addChild(lLeg02);
        setRotationAngle(lLeg02, 0.3187F, 0.0F, 0.0911F);
        lLeg02.texOffs(48, 0).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 5.0F, 3.0F, 0.1F, false);

        lLeg03 = new ModelPart(this);
        lLeg03.setPos(0.2F, 3.6F, 0.0F);
        lLeg02.addChild(lLeg03);
        setRotationAngle(lLeg03, -0.1745F, 0.0F, 0.0F);
        lLeg03.texOffs(47, 8).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 6.0F, 2.0F, 0.1F, false);

        lHindHoofClaw01a = new ModelPart(this);
        lHindHoofClaw01a.setPos(0.45F, 5.6F, -0.9F);
        lLeg03.addChild(lHindHoofClaw01a);
        setRotationAngle(lHindHoofClaw01a, 0.0F, -0.0524F, 0.0F);
        lHindHoofClaw01a.texOffs(30, 34).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, true);

        lHindHoofClaw01b = new ModelPart(this);
        lHindHoofClaw01b.setPos(0.0F, 0.0F, -1.0F);
        lHindHoofClaw01a.addChild(lHindHoofClaw01b);
        setRotationAngle(lHindHoofClaw01b, 0.4363F, 0.0F, 0.0F);
        lHindHoofClaw01b.texOffs(29, 28).addBox(-0.49F, -1.1F, -0.95F, 1.0F, 1.0F, 3.0F, 0.0F, true);

        lHindHoofClaw02a = new ModelPart(this);
        lHindHoofClaw02a.setPos(-0.55F, 5.6F, -0.9F);
        lLeg03.addChild(lHindHoofClaw02a);
        setRotationAngle(lHindHoofClaw02a, 0.0F, 0.1309F, 0.0F);
        lHindHoofClaw02a.texOffs(30, 34).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, true);

        lHindHoofClaw02b2 = new ModelPart(this);
        lHindHoofClaw02b2.setPos(0.0F, 0.0F, -1.0F);
        lHindHoofClaw02a.addChild(lHindHoofClaw02b2);
        setRotationAngle(lHindHoofClaw02b2, 0.4363F, 0.0F, 0.0F);
        lHindHoofClaw02b2.texOffs(29, 28).addBox(-0.49F, -1.1F, -0.95F, 1.0F, 1.0F, 3.0F, 0.0F, true);

        rLeg01 = new ModelPart(this);
        rLeg01.setPos(-1.2F, -1.7F, 3.95F);
        ass.addChild(rLeg01);
        setRotationAngle(rLeg01, 0.0F, 0.0F, 0.0911F);
        rLeg01.texOffs(29, 0).addBox(-3.5F, -1.0F, -2.5F, 4.0F, 6.0F, 5.0F, 0.0F, true);

        rLeg02 = new ModelPart(this);
        rLeg02.setPos(-1.7F, 3.9F, 0.15F);
        rLeg01.addChild(rLeg02);
        setRotationAngle(rLeg02, 0.3187F, 0.0F, -0.0911F);
        rLeg02.texOffs(48, 0).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 5.0F, 3.0F, 0.1F, true);

        rLeg03 = new ModelPart(this);
        rLeg03.setPos(-0.2F, 3.6F, 0.0F);
        rLeg02.addChild(rLeg03);
        setRotationAngle(rLeg03, -0.1745F, 0.0F, 0.0F);
        rLeg03.texOffs(47, 8).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 6.0F, 2.0F, 0.1F, true);

        rHindHoofClaw01a = new ModelPart(this);
        rHindHoofClaw01a.setPos(-0.45F, 5.6F, -0.9F);
        rLeg03.addChild(rHindHoofClaw01a);
        setRotationAngle(rHindHoofClaw01a, 0.0F, 0.0524F, 0.0F);
        rHindHoofClaw01a.texOffs(30, 34).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        rHindHoofClaw01b = new ModelPart(this);
        rHindHoofClaw01b.setPos(0.0F, 0.0F, -1.0F);
        rHindHoofClaw01a.addChild(rHindHoofClaw01b);
        setRotationAngle(rHindHoofClaw01b, 0.4363F, 0.0F, 0.0F);
        rHindHoofClaw01b.texOffs(29, 28).addBox(-0.51F, -1.1F, -0.95F, 1.0F, 1.0F, 3.0F, 0.0F, false);

        rHindHoofClaw02a = new ModelPart(this);
        rHindHoofClaw02a.setPos(0.55F, 5.6F, -0.9F);
        rLeg03.addChild(rHindHoofClaw02a);
        setRotationAngle(rHindHoofClaw02a, 0.0F, -0.1309F, 0.0F);
        rHindHoofClaw02a.texOffs(30, 34).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        rHindHoofClaw02b = new ModelPart(this);
        rHindHoofClaw02b.setPos(0.0F, 0.0F, -1.0F);
        rHindHoofClaw02a.addChild(rHindHoofClaw02b);
        setRotationAngle(rHindHoofClaw02b, 0.4363F, 0.0F, 0.0F);
        rHindHoofClaw02b.texOffs(29, 28).addBox(-0.51F, -1.1F, -0.95F, 1.0F, 1.0F, 3.0F, 0.0F, false);

        tail = new ModelPart(this);
        tail.setPos(0.0F, -3.2F, 6.5F);
        ass.addChild(tail);
        setRotationAngle(tail, 0.2618F, 0.0F, 0.0F);
        tail.texOffs(24, 53).addBox(-0.5F, 0.0F, -0.2F, 1.0F, 5.0F, 1.0F, 0.0F, false);

        tailFur = new ModelPart(this);
        tailFur.setPos(0.0F, 4.95F, 0.2F);
        tail.addChild(tailFur);
        setRotationAngle(tailFur, -0.0873F, 0.0F, 0.0F);
        tailFur.texOffs(36, 53).addBox(-0.9F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        head = new ModelPart(this);
        head.setPos(0.0F, -0.3F, -5.5F);
        body.addChild(head);
        head.texOffs(23, 38).addBox(-2.5F, -3.5F, -5.0F, 5.0F, 6.0F, 5.0F, 0.0F, false);

        snoot = new ModelPart(this);
        snoot.setPos(0.0F, -0.6F, -4.4F);
        head.addChild(snoot);
        setRotationAngle(snoot, 0.2731F, 0.0F, 0.0F);
        snoot.texOffs(42, 36).addBox(-1.55F, -1.5F, -4.7F, 3.0F, 2.0F, 5.0F, 0.0F, false);

        nose = new ModelPart(this);
        nose.setPos(0.0F, -0.4F, -4.3F);
        snoot.addChild(nose);
        setRotationAngle(nose, -0.1367F, 0.0F, 0.0F);
        nose.texOffs(56, 50).addBox(-1.5F, -1.5F, -0.8F, 3.0F, 3.0F, 1.0F, 0.01F, false);

        upperJaw = new ModelPart(this);
        upperJaw.setPos(0.0F, 0.7F, -4.4F);
        head.addChild(upperJaw);
        upperJaw.texOffs(44, 43).addBox(-1.5F, -1.0F, -4.0F, 3.0F, 2.0F, 4.0F, 0.0F, false);

        lUpperTusk = new ModelPart(this);
        lUpperTusk.setPos(1.3F, 1.0F, -1.75F);
        upperJaw.addChild(lUpperTusk);
        setRotationAngle(lUpperTusk, 0.0F, 0.0F, 0.3054F);
        lUpperTusk.texOffs(0, 1).addBox(-0.55F, -2.7F, -0.5F, 1.0F, 3.0F, 1.0F, -0.15F, true);

        rUpperTusk = new ModelPart(this);
        rUpperTusk.setPos(-1.3F, 1.0F, -1.75F);
        upperJaw.addChild(rUpperTusk);
        setRotationAngle(rUpperTusk, 0.0F, 0.0F, -0.3054F);
        rUpperTusk.texOffs(0, 1).addBox(-0.45F, -2.7F, -0.5F, 1.0F, 3.0F, 1.0F, -0.15F, false);

        lowerJaw = new ModelPart(this);
        lowerJaw.setPos(0.0F, 2.2F, -4.1F);
        head.addChild(lowerJaw);
        setRotationAngle(lowerJaw, -0.0873F, 0.0F, 0.0F);
        lowerJaw.texOffs(44, 49).addBox(-1.5F, -0.5F, -4.7F, 3.0F, 1.0F, 5.0F, -0.1F, false);

        lTusk01 = new ModelPart(this);
        lTusk01.setPos(1.3F, 0.0F, -2.8F);
        lowerJaw.addChild(lTusk01);
        setRotationAngle(lTusk01, 0.2443F, 0.0F, 0.3054F);
        lTusk01.texOffs(0, 1).addBox(-0.5F, -1.8F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, true);

        lTusk02 = new ModelPart(this);
        lTusk02.setPos(0.0F, -1.75F, 0.0F);
        lTusk01.addChild(lTusk02);
        setRotationAngle(lTusk02, 0.0F, 0.0F, -0.1745F);
        lTusk02.texOffs(0, 1).addBox(-0.55F, -1.7F, -0.5F, 1.0F, 2.0F, 1.0F, -0.1F, true);

        rTusk01 = new ModelPart(this);
        rTusk01.setPos(-1.3F, 0.0F, -2.8F);
        lowerJaw.addChild(rTusk01);
        setRotationAngle(rTusk01, 0.2443F, 0.0F, -0.3054F);
        rTusk01.texOffs(0, 1).addBox(-0.5F, -1.8F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        rTusk02 = new ModelPart(this);
        rTusk02.setPos(0.0F, -1.75F, 0.0F);
        rTusk01.addChild(rTusk02);
        setRotationAngle(rTusk02, 0.0F, 0.0F, 0.1745F);
        rTusk02.texOffs(0, 1).addBox(-0.45F, -1.7F, -0.5F, 1.0F, 2.0F, 1.0F, -0.1F, false);

        lEar01 = new ModelPart(this);
        lEar01.setPos(0.7F, -2.7F, -2.7F);
        head.addChild(lEar01);
        setRotationAngle(lEar01, 0.0F, -0.3927F, 0.3927F);
        lEar01.texOffs(56, 17).addBox(0.2F, -3.0F, -0.5F, 2.0F, 3.0F, 1.0F, 0.0F, true);

        lEar02 = new ModelPart(this);
        lEar02.setPos(0.6F, 0.0F, 0.7F);
        lEar01.addChild(lEar02);
        lEar02.texOffs(58, 9).addBox(-1.25F, -4.25F, -0.5F, 2.0F, 5.0F, 0.0F, 0.0F, true);

        rEar01 = new ModelPart(this);
        rEar01.setPos(-0.7F, -2.7F, -2.7F);
        head.addChild(rEar01);
        setRotationAngle(rEar01, 0.0F, 0.3927F, -0.3927F);
        rEar01.texOffs(56, 17).addBox(-2.2F, -3.0F, -0.5F, 2.0F, 3.0F, 1.0F, 0.0F, false);

        rEar02 = new ModelPart(this);
        rEar02.setPos(-0.35F, -0.25F, 0.7F);
        rEar01.addChild(rEar02);
        rEar02.texOffs(58, 9).addBox(-1.0F, -4.0F, -0.5F, 2.0F, 5.0F, 0.0F, 0.0F, false);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.quadriped(lLeg01, lArm01, rLeg01, rArm01, limbSwing * 0.666F, limbSwingAmount * 1.4F);
        this.headPitch(head, headPitch);
        this.headYaw(head, netHeadYaw);
    }

}
