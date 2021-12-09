package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import dev.itsmeow.betteranimalsplus.common.entity.EntityReindeer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;

public class ModelReindeer<T extends LivingEntity> extends ModelBAP<T> {

    public ModelPart body;
    public ModelPart ass;
    public ModelPart lHindLeg01;
    public ModelPart lHindLeg02;
    public ModelPart lHindLeg03;
    public ModelPart lHHoofClaw01a;
    public ModelPart lHHoofClaw01b;
    public ModelPart lHHoofClaw02a;
    public ModelPart lHHoofClaw02b;
    public ModelPart rHindLeg01;
    public ModelPart rHindLeg02;
    public ModelPart rHindLeg03;
    public ModelPart rHHoofClaw01a;
    public ModelPart rHHoofClaw01b;
    public ModelPart rHHoofClaw02a;
    public ModelPart rHHoofClaw02b;
    public ModelPart tail;
    public ModelPart lowerNeck;
    public ModelPart upperNeck;
    public ModelPart christmas_harness_bell_r1;
    public ModelPart head;
    public ModelPart lowerJawBack;
    public ModelPart lowerLip;
    public ModelPart lEar;
    public ModelPart rEar;
    public ModelPart lAntler01;
    public ModelPart lAntler02;
    public ModelPart lAntler03;
    public ModelPart lAntler04;
    public ModelPart lAntler05;
    public ModelPart lAntler08;
    public ModelPart lAntler09;
    public ModelPart lAntler06;
    public ModelPart lAntler07;
    public ModelPart lAntler10;
    public ModelPart lAntler11;
    public ModelPart lAntler12;
    public ModelPart lAntler13;
    public ModelPart lAntler14;
    public ModelPart lAntler15;
    public ModelPart lAntler16;
    public ModelPart snout;
    public ModelPart christmas_nose;
    public ModelPart rAntler01;
    public ModelPart rAntler02;
    public ModelPart rAntler03;
    public ModelPart rAntler04;
    public ModelPart rAntler05;
    public ModelPart rAntler08;
    public ModelPart rAntler09;
    public ModelPart rAntler06;
    public ModelPart rAntler07;
    public ModelPart rAntler10;
    public ModelPart rAntler11;
    public ModelPart rAntler12;
    public ModelPart rAntler13;
    public ModelPart rAntler14;
    public ModelPart rAntler15;
    public ModelPart rAntler16;
    public ModelPart mane01;
    public ModelPart mane02;
    public ModelPart mane03;
    public ModelPart mane04;
    public ModelPart lForeleg01;
    public ModelPart lForeleg02;
    public ModelPart lForeleg03;
    public ModelPart lFHoofClaw01a;
    public ModelPart lFHoofClaw01b;
    public ModelPart lFHoofClaw02a;
    public ModelPart lFHoofClaw02b;
    public ModelPart rForeleg01;
    public ModelPart rForeleg02;
    public ModelPart rForeleg03;
    public ModelPart rFHoofClaw01a;
    public ModelPart rFHoofClaw01b;
    public ModelPart rFHoofClaw02a;
    public ModelPart rFHoofClaw02b;
    public ModelPart bodyFur;

    public ModelReindeer() {
        texWidth = 128;
        texHeight = 64;

        body = new ModelPart(this);
        body.setPos(0.0F, 7.5F, 5.8F);
        body.texOffs(0, 13).addBox(-4.0F, -3.5F, -15.0F, 8.0F, 9.0F, 13.0F, 0.0F, false);
        body.texOffs(104, 35).addBox(-4.0F, -3.5F, -9.0F, 8.0F, 9.0F, 3.0F, 0.2F, false);
        body.texOffs(106, 12).addBox(-4.0F, -3.5F, -14.75F, 8.0F, 9.0F, 2.0F, 0.2F, false);
        body.texOffs(116, 26).addBox(4.19F, -3.5F, -12.75F, 0.0F, 4.0F, 4.0F, 0.0F, false);
        body.texOffs(116, 26).addBox(-4.19F, -3.5F, -12.75F, 0.0F, 4.0F, 4.0F, 0.0F, true);

        ass = new ModelPart(this);
        ass.setPos(0.0F, -0.3F, -2.7F);
        body.addChild(ass);
        setRotationAngle(ass, -0.182F, 0.0F, 0.0F);
        ass.texOffs(0, 35).addBox(-3.5F, -3.5F, 0.0F, 7.0F, 8.0F, 6.0F, 0.0F, false);

        lHindLeg01 = new ModelPart(this);
        lHindLeg01.setPos(2.5F, -1.1F, 3.3F);
        ass.addChild(lHindLeg01);
        setRotationAngle(lHindLeg01, -0.2276F, 0.0F, 0.0F);
        lHindLeg01.texOffs(64, 0).addBox(0.0F, -1.9F, -2.0F, 3.0F, 8.0F, 5.0F, 0.0F, false);

        lHindLeg02 = new ModelPart(this);
        lHindLeg02.setPos(1.4F, 5.0F, -1.1F);
        lHindLeg01.addChild(lHindLeg02);
        setRotationAngle(lHindLeg02, 0.9105F, 0.0F, 0.0F);
        lHindLeg02.texOffs(65, 16).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, 0.0F, false);

        lHindLeg03 = new ModelPart(this);
        lHindLeg03.setPos(0.1F, 5.4F, 0.5F);
        lHindLeg02.addChild(lHindLeg03);
        setRotationAngle(lHindLeg03, -0.5009F, 0.0F, 0.0F);
        lHindLeg03.texOffs(68, 30).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);

        lHHoofClaw01a = new ModelPart(this);
        lHHoofClaw01a.setPos(0.55F, 8.4F, -0.75F);
        lHindLeg03.addChild(lHHoofClaw01a);
        setRotationAngle(lHHoofClaw01a, 0.0F, -0.1309F, 0.0F);
        lHHoofClaw01a.texOffs(81, 19).addBox(-0.55F, -0.4F, -1.75F, 1.0F, 1.0F, 2.0F, 0.2F, false);

        lHHoofClaw01b = new ModelPart(this);
        lHHoofClaw01b.setPos(0.0F, 0.0F, -1.0F);
        lHHoofClaw01a.addChild(lHHoofClaw01b);
        setRotationAngle(lHHoofClaw01b, 0.4363F, 0.0F, 0.0F);
        lHHoofClaw01b.texOffs(83, 13).addBox(-0.54F, -1.0F, -0.95F, 1.0F, 1.0F, 3.0F, 0.0F, true);

        lHHoofClaw02a = new ModelPart(this);
        lHHoofClaw02a.setPos(-0.45F, 8.4F, -0.75F);
        lHindLeg03.addChild(lHHoofClaw02a);
        setRotationAngle(lHHoofClaw02a, 0.0F, 0.0436F, 0.0F);
        lHHoofClaw02a.texOffs(81, 19).addBox(-0.55F, -0.39F, -1.75F, 1.0F, 1.0F, 2.0F, 0.2F, true);

        lHHoofClaw02b = new ModelPart(this);
        lHHoofClaw02b.setPos(0.0F, 0.0F, -1.0F);
        lHHoofClaw02a.addChild(lHHoofClaw02b);
        setRotationAngle(lHHoofClaw02b, 0.4363F, 0.0F, 0.0F);
        lHHoofClaw02b.texOffs(83, 13).addBox(-0.54F, -1.0F, -0.95F, 1.0F, 1.0F, 3.0F, 0.0F, true);

        rHindLeg01 = new ModelPart(this);
        rHindLeg01.setPos(-2.5F, -1.1F, 3.3F);
        ass.addChild(rHindLeg01);
        setRotationAngle(rHindLeg01, -0.2276F, 0.0F, 0.0F);
        rHindLeg01.texOffs(64, 0).addBox(-3.0F, -1.9F, -2.0F, 3.0F, 8.0F, 5.0F, 0.0F, true);

        rHindLeg02 = new ModelPart(this);
        rHindLeg02.setPos(-1.4F, 5.0F, -1.1F);
        rHindLeg01.addChild(rHindLeg02);
        setRotationAngle(rHindLeg02, 0.9105F, 0.0F, 0.0F);
        rHindLeg02.texOffs(65, 16).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, 0.0F, true);

        rHindLeg03 = new ModelPart(this);
        rHindLeg03.setPos(-0.1F, 5.4F, 0.5F);
        rHindLeg02.addChild(rHindLeg03);
        setRotationAngle(rHindLeg03, -0.5009F, 0.0F, 0.0F);
        rHindLeg03.texOffs(68, 30).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, true);

        rHHoofClaw01a = new ModelPart(this);
        rHHoofClaw01a.setPos(-0.55F, 8.4F, -0.75F);
        rHindLeg03.addChild(rHHoofClaw01a);
        setRotationAngle(rHHoofClaw01a, 0.0F, 0.1309F, 0.0F);
        rHHoofClaw01a.texOffs(81, 19).addBox(-0.45F, -0.4F, -1.75F, 1.0F, 1.0F, 2.0F, 0.2F, true);

        rHHoofClaw01b = new ModelPart(this);
        rHHoofClaw01b.setPos(0.0F, 0.0F, -1.0F);
        rHHoofClaw01a.addChild(rHHoofClaw01b);
        setRotationAngle(rHHoofClaw01b, 0.4363F, 0.0F, 0.0F);
        rHHoofClaw01b.texOffs(83, 13).addBox(-0.46F, -1.0F, -0.95F, 1.0F, 1.0F, 3.0F, 0.0F, false);

        rHHoofClaw02a = new ModelPart(this);
        rHHoofClaw02a.setPos(0.45F, 8.4F, -0.75F);
        rHindLeg03.addChild(rHHoofClaw02a);
        setRotationAngle(rHHoofClaw02a, 0.0F, -0.0436F, 0.0F);
        rHHoofClaw02a.texOffs(81, 19).addBox(-0.45F, -0.39F, -1.75F, 1.0F, 1.0F, 2.0F, 0.2F, false);

        rHHoofClaw02b = new ModelPart(this);
        rHHoofClaw02b.setPos(0.0F, 0.0F, -1.0F);
        rHHoofClaw02a.addChild(rHHoofClaw02b);
        setRotationAngle(rHHoofClaw02b, 0.4363F, 0.0F, 0.0F);
        rHHoofClaw02b.texOffs(83, 13).addBox(-0.46F, -1.0F, -0.95F, 1.0F, 1.0F, 3.0F, 0.0F, false);

        tail = new ModelPart(this);
        tail.setPos(0.0F, -2.7F, 5.1F);
        ass.addChild(tail);
        setRotationAngle(tail, 0.5918F, 0.0F, 0.0F);
        tail.texOffs(33, 0).addBox(-1.5F, 0.0F, -1.0F, 3.0F, 4.0F, 2.0F, 0.0F, false);

        lowerNeck = new ModelPart(this);
        lowerNeck.setPos(0.0F, 0.8F, -12.6F);
        body.addChild(lowerNeck);
        setRotationAngle(lowerNeck, -0.6829F, 0.0F, 0.0F);
        lowerNeck.texOffs(0, 0).addBox(-3.5F, -3.0F, -5.0F, 7.0F, 6.0F, 5.0F, 0.0F, false);

        upperNeck = new ModelPart(this);
        upperNeck.setPos(0.0F, 0.3F, -4.0F);
        lowerNeck.addChild(upperNeck);
        setRotationAngle(upperNeck, -0.3187F, 0.0F, 0.0F);
        upperNeck.texOffs(88, 0).addBox(-2.5F, -2.5F, -5.0F, 5.0F, 5.0F, 5.0F, -0.1F, false);
        upperNeck.texOffs(114, 50).addBox(-2.5F, -2.5F, -3.75F, 5.0F, 5.0F, 2.0F, 0.2F, false);

        christmas_harness_bell_r1 = new ModelPart(this);
        christmas_harness_bell_r1.setPos(0.0F, 3.0F, -2.0F);
        upperNeck.addChild(christmas_harness_bell_r1);
        setRotationAngle(christmas_harness_bell_r1, -0.6109F, 0.0F, 0.0F);
        christmas_harness_bell_r1.texOffs(92, 47).addBox(-1.0F, -1.25F, -0.75F, 2.0F, 2.0F, 3.0F, 0.0F, false);

        head = new ModelPart(this);
        head.setPos(0.0F, 1.1F, -4.0F);
        upperNeck.addChild(head);
        setRotationAngle(head, -0.3491F, 0.0F, 0.0F);
        head.texOffs(88, 15).addBox(-2.5F, -3.0F, -4.0F, 5.0F, 5.0F, 4.0F, 0.0F, false);

        lowerJawBack = new ModelPart(this);
        lowerJawBack.setPos(0.0F, -0.2F, -0.9F);
        head.addChild(lowerJawBack);
        lowerJawBack.texOffs(102, 29).addBox(-1.5F, 1.6F, -1.25F, 3.0F, 2.0F, 2.0F, 0.2F, false);

        lowerLip = new ModelPart(this);
        lowerLip.setPos(0.0F, 3.0F, 0.7F);
        lowerJawBack.addChild(lowerLip);
        lowerLip.texOffs(103, 29).addBox(-1.5F, -0.65F, -0.95F, 3.0F, 3.0F, 1.0F, 0.1F, false);

        lEar = new ModelPart(this);
        lEar.setPos(1.8F, -1.75F, -3.0F);
        head.addChild(lEar);
        setRotationAngle(lEar, 0.2618F, -1.1519F, -0.3665F);
        lEar.texOffs(0, 13).addBox(-1.0F, -0.7F, -3.1F, 2.0F, 1.0F, 3.0F, 0.0F, false);

        rEar = new ModelPart(this);
        rEar.setPos(-1.8F, -1.75F, -3.0F);
        head.addChild(rEar);
        setRotationAngle(rEar, 0.2618F, 1.1519F, 0.3665F);
        rEar.texOffs(0, 13).addBox(-1.0F, -0.7F, -3.1F, 2.0F, 1.0F, 3.0F, 0.0F, true);

        lAntler01 = new ModelPart(this);
        lAntler01.setPos(1.35F, -1.0F, -4.25F);
        head.addChild(lAntler01);
        setRotationAngle(lAntler01, -0.2793F, -0.4363F, 0.0F);
        lAntler01.texOffs(117, 0).addBox(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);

        lAntler02 = new ModelPart(this);
        lAntler02.setPos(0.0F, 0.3F, -2.1F);
        lAntler01.addChild(lAntler02);
        setRotationAngle(lAntler02, 0.6981F, -0.1745F, 0.2094F);
        lAntler02.texOffs(117, 0).addBox(-0.5F, -6.0F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);

        lAntler03 = new ModelPart(this);
        lAntler03.setPos(0.0F, -5.7F, 0.1F);
        lAntler02.addChild(lAntler03);
        setRotationAngle(lAntler03, -0.9076F, 0.2269F, 0.2269F);
        lAntler03.texOffs(117, 0).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        lAntler04 = new ModelPart(this);
        lAntler04.setPos(0.0F, -0.1F, -1.6F);
        lAntler03.addChild(lAntler04);
        setRotationAngle(lAntler04, 0.6981F, 0.2269F, 0.0F);
        lAntler04.texOffs(117, 0).addBox(-0.5F, -0.5F, -5.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);

        lAntler05 = new ModelPart(this);
        lAntler05.setPos(0.2F, 0.0F, -4.6F);
        lAntler04.addChild(lAntler05);
        setRotationAngle(lAntler05, 0.0F, -0.6981F, 0.0F);
        lAntler05.texOffs(117, 0).addBox(-3.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        lAntler08 = new ModelPart(this);
        lAntler08.setPos(0.0F, -0.1F, -2.5F);
        lAntler04.addChild(lAntler08);
        setRotationAngle(lAntler08, 0.5934F, 0.0F, -0.3142F);
        lAntler08.texOffs(117, 0).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        lAntler09 = new ModelPart(this);
        lAntler09.setPos(0.0F, -1.8F, 0.0F);
        lAntler08.addChild(lAntler09);
        setRotationAngle(lAntler09, 0.0F, 0.0F, -0.3491F);
        lAntler09.texOffs(117, 0).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        lAntler06 = new ModelPart(this);
        lAntler06.setPos(0.0F, -0.1F, -1.6F);
        lAntler03.addChild(lAntler06);
        setRotationAngle(lAntler06, 0.3491F, 0.2269F, -0.3142F);
        lAntler06.texOffs(117, 0).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        lAntler07 = new ModelPart(this);
        lAntler07.setPos(0.0F, -2.8F, 0.0F);
        lAntler06.addChild(lAntler07);
        setRotationAngle(lAntler07, 0.0F, 0.0F, -0.3491F);
        lAntler07.texOffs(117, 0).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        lAntler10 = new ModelPart(this);
        lAntler10.setPos(0.0F, -0.9F, 0.0F);
        lAntler02.addChild(lAntler10);
        setRotationAngle(lAntler10, 0.4363F, -0.4363F, -0.2269F);
        lAntler10.texOffs(117, 0).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

        lAntler11 = new ModelPart(this);
        lAntler11.setPos(0.1F, 0.0F, -2.7F);
        lAntler10.addChild(lAntler11);
        setRotationAngle(lAntler11, 0.0F, 0.5236F, 0.0F);
        lAntler11.texOffs(117, 0).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        lAntler12 = new ModelPart(this);
        lAntler12.setPos(0.1F, 0.0F, -1.7F);
        lAntler11.addChild(lAntler12);
        setRotationAngle(lAntler12, -0.3665F, 0.5236F, 0.0F);
        lAntler12.texOffs(117, 0).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

        lAntler13 = new ModelPart(this);
        lAntler13.setPos(0.1F, 0.2F, -0.7F);
        lAntler11.addChild(lAntler13);
        setRotationAngle(lAntler13, 0.4538F, 0.3491F, 0.0F);
        lAntler13.texOffs(117, 0).addBox(-0.5F, -0.5F, -3.8F, 1.0F, 1.0F, 4.0F, 0.0F, false);

        lAntler14 = new ModelPart(this);
        lAntler14.setPos(0.0F, 0.4F, -0.3F);
        lAntler01.addChild(lAntler14);
        setRotationAngle(lAntler14, -0.192F, 0.0F, 0.0F);
        lAntler14.texOffs(117, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        lAntler15 = new ModelPart(this);
        lAntler15.setPos(0.0F, 2.8F, 0.0F);
        lAntler14.addChild(lAntler15);
        setRotationAngle(lAntler15, -0.3142F, 0.0F, 0.3665F);
        lAntler15.texOffs(117, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        lAntler16 = new ModelPart(this);
        lAntler16.setPos(0.0F, 2.5F, 0.0F);
        lAntler14.addChild(lAntler16);
        setRotationAngle(lAntler16, 0.4189F, 0.0F, 0.3665F);
        lAntler16.texOffs(117, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        snout = new ModelPart(this);
        snout.setPos(0.0F, 1.25F, -2.3F);
        head.addChild(snout);
        setRotationAngle(snout, 0.2618F, 0.0F, 0.0F);
        snout.texOffs(88, 35).addBox(-2.0F, -0.45F, -1.15F, 4.0F, 5.0F, 2.0F, 0.0F, false);

        christmas_nose = new ModelPart(this);
        christmas_nose.setPos(0.0F, 4.0F, -2.0F);
        snout.addChild(christmas_nose);
        christmas_nose.texOffs(22, 0).addBox(-1.0F, -0.75F, -0.15F, 2.0F, 2.0F, 2.0F, 0.0F, false);

        rAntler01 = new ModelPart(this);
        rAntler01.setPos(-1.35F, -1.0F, -4.25F);
        head.addChild(rAntler01);
        setRotationAngle(rAntler01, -0.2793F, 0.4363F, 0.0F);
        rAntler01.texOffs(117, 0).addBox(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 3.0F, 0.0F, true);

        rAntler02 = new ModelPart(this);
        rAntler02.setPos(0.0F, 0.3F, -2.1F);
        rAntler01.addChild(rAntler02);
        setRotationAngle(rAntler02, 0.6981F, 0.1745F, -0.2094F);
        rAntler02.texOffs(117, 0).addBox(-0.5F, -6.0F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, true);

        rAntler03 = new ModelPart(this);
        rAntler03.setPos(0.0F, -5.7F, 0.1F);
        rAntler02.addChild(rAntler03);
        setRotationAngle(rAntler03, -0.9076F, -0.2269F, -0.2269F);
        rAntler03.texOffs(117, 0).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, true);

        rAntler04 = new ModelPart(this);
        rAntler04.setPos(0.0F, -0.1F, -1.6F);
        rAntler03.addChild(rAntler04);
        setRotationAngle(rAntler04, 0.6981F, -0.2269F, 0.0F);
        rAntler04.texOffs(117, 0).addBox(-0.5F, -0.5F, -5.0F, 1.0F, 1.0F, 5.0F, 0.0F, true);

        rAntler05 = new ModelPart(this);
        rAntler05.setPos(-0.2F, 0.0F, -4.6F);
        rAntler04.addChild(rAntler05);
        setRotationAngle(rAntler05, 0.0F, 0.6981F, 0.0F);
        rAntler05.texOffs(117, 0).addBox(0.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, true);

        rAntler08 = new ModelPart(this);
        rAntler08.setPos(0.0F, -0.1F, -2.5F);
        rAntler04.addChild(rAntler08);
        setRotationAngle(rAntler08, 0.5934F, 0.0F, 0.3142F);
        rAntler08.texOffs(117, 0).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, true);

        rAntler09 = new ModelPart(this);
        rAntler09.setPos(0.0F, -1.8F, 0.0F);
        rAntler08.addChild(rAntler09);
        setRotationAngle(rAntler09, 0.0F, 0.0F, 0.3491F);
        rAntler09.texOffs(117, 0).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, true);

        rAntler06 = new ModelPart(this);
        rAntler06.setPos(0.0F, -0.1F, -1.6F);
        rAntler03.addChild(rAntler06);
        setRotationAngle(rAntler06, 0.3491F, -0.2269F, 0.3142F);
        rAntler06.texOffs(117, 0).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, true);

        rAntler07 = new ModelPart(this);
        rAntler07.setPos(0.0F, -2.8F, 0.0F);
        rAntler06.addChild(rAntler07);
        setRotationAngle(rAntler07, 0.0F, 0.0F, 0.3491F);
        rAntler07.texOffs(117, 0).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, true);

        rAntler10 = new ModelPart(this);
        rAntler10.setPos(0.0F, -0.9F, 0.0F);
        rAntler02.addChild(rAntler10);
        setRotationAngle(rAntler10, 0.4363F, 0.4363F, 0.2269F);
        rAntler10.texOffs(117, 0).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, 0.0F, true);

        rAntler11 = new ModelPart(this);
        rAntler11.setPos(-0.1F, 0.0F, -2.7F);
        rAntler10.addChild(rAntler11);
        setRotationAngle(rAntler11, 0.0F, -0.5236F, 0.0F);
        rAntler11.texOffs(117, 0).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, true);

        rAntler12 = new ModelPart(this);
        rAntler12.setPos(-0.1F, 0.0F, -1.7F);
        rAntler11.addChild(rAntler12);
        setRotationAngle(rAntler12, -0.3665F, -0.5236F, 0.0F);
        rAntler12.texOffs(117, 0).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, 0.0F, true);

        rAntler13 = new ModelPart(this);
        rAntler13.setPos(-0.1F, 0.2F, -0.7F);
        rAntler11.addChild(rAntler13);
        setRotationAngle(rAntler13, 0.4538F, -0.3491F, 0.0F);
        rAntler13.texOffs(117, 0).addBox(-0.5F, -0.5F, -3.8F, 1.0F, 1.0F, 4.0F, 0.0F, true);

        rAntler14 = new ModelPart(this);
        rAntler14.setPos(0.0F, 0.4F, -0.3F);
        rAntler01.addChild(rAntler14);
        setRotationAngle(rAntler14, -0.192F, 0.0F, 0.0F);
        rAntler14.texOffs(117, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, true);

        rAntler15 = new ModelPart(this);
        rAntler15.setPos(0.0F, 2.8F, 0.0F);
        rAntler14.addChild(rAntler15);
        setRotationAngle(rAntler15, -0.3142F, 0.0F, -0.3665F);
        rAntler15.texOffs(117, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, true);

        rAntler16 = new ModelPart(this);
        rAntler16.setPos(0.0F, 2.5F, 0.0F);
        rAntler14.addChild(rAntler16);
        setRotationAngle(rAntler16, 0.4189F, 0.0F, -0.3665F);
        rAntler16.texOffs(117, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, true);

        mane01 = new ModelPart(this);
        mane01.setPos(0.0F, 1.5F, -3.3F);
        upperNeck.addChild(mane01);
        setRotationAngle(mane01, -0.5463F, 0.0F, 0.0F);
        mane01.texOffs(0, 50).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 1.0F, 5.0F, 0.0F, false);

        mane02 = new ModelPart(this);
        mane02.setPos(0.0F, 1.5F, -1.95F);
        upperNeck.addChild(mane02);
        setRotationAngle(mane02, -0.5463F, 0.0F, 0.0F);
        mane02.texOffs(20, 50).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 1.0F, 6.0F, 0.0F, false);

        mane03 = new ModelPart(this);
        mane03.setPos(0.0F, 1.7F, -4.9F);
        lowerNeck.addChild(mane03);
        setRotationAngle(mane03, -0.7679F, 0.0F, 0.0F);
        mane03.texOffs(46, 50).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);

        mane04 = new ModelPart(this);
        mane04.setPos(0.0F, 1.8F, -3.1F);
        lowerNeck.addChild(mane04);
        setRotationAngle(mane04, -0.7679F, 0.0F, 0.0F);
        mane04.texOffs(72, 50).addBox(-3.0F, -1.0F, 0.0F, 6.0F, 2.0F, 6.0F, 0.0F, false);

        lForeleg01 = new ModelPart(this);
        lForeleg01.setPos(3.1F, 0.6F, -12.7F);
        body.addChild(lForeleg01);
        setRotationAngle(lForeleg01, 0.1367F, 0.0F, -0.0911F);
        lForeleg01.texOffs(45, 0).addBox(-1.0F, -2.4F, -2.5F, 3.0F, 7.0F, 5.0F, 0.0F, false);

        lForeleg02 = new ModelPart(this);
        lForeleg02.setPos(0.8F, 4.4F, 0.1F);
        lForeleg01.addChild(lForeleg02);
        setRotationAngle(lForeleg02, 0.0F, 0.0F, 0.0911F);
        lForeleg02.texOffs(48, 14).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 3.0F, 3.0F, 0.0F, false);

        lForeleg03 = new ModelPart(this);
        lForeleg03.setPos(0.0F, 1.7F, 0.0F);
        lForeleg02.addChild(lForeleg03);
        setRotationAngle(lForeleg03, -0.1367F, 0.0F, 0.0F);
        lForeleg03.texOffs(50, 26).addBox(-1.05F, 1.0F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);

        lFHoofClaw01a = new ModelPart(this);
        lFHoofClaw01a.setPos(0.65F, 9.45F, -0.4F);
        lForeleg03.addChild(lFHoofClaw01a);
        setRotationAngle(lFHoofClaw01a, 0.0F, -0.1309F, 0.0F);
        lFHoofClaw01a.texOffs(81, 19).addBox(-0.55F, -0.4F, -1.75F, 1.0F, 1.0F, 2.0F, 0.2F, false);

        lFHoofClaw01b = new ModelPart(this);
        lFHoofClaw01b.setPos(0.0F, 0.0F, -1.0F);
        lFHoofClaw01a.addChild(lFHoofClaw01b);
        setRotationAngle(lFHoofClaw01b, 0.4363F, 0.0F, 0.0F);
        lFHoofClaw01b.texOffs(83, 13).addBox(-0.54F, -0.95F, -1.2F, 1.0F, 1.0F, 3.0F, 0.0F, true);

        lFHoofClaw02a = new ModelPart(this);
        lFHoofClaw02a.setPos(-0.6F, 9.45F, -0.4F);
        lForeleg03.addChild(lFHoofClaw02a);
        lFHoofClaw02a.texOffs(81, 19).addBox(-0.55F, -0.39F, -1.75F, 1.0F, 1.0F, 2.0F, 0.2F, true);

        lFHoofClaw02b = new ModelPart(this);
        lFHoofClaw02b.setPos(0.0F, 0.0F, -1.0F);
        lFHoofClaw02a.addChild(lFHoofClaw02b);
        setRotationAngle(lFHoofClaw02b, 0.4363F, 0.0F, 0.0F);
        lFHoofClaw02b.texOffs(83, 13).addBox(-0.54F, -0.95F, -1.2F, 1.0F, 1.0F, 3.0F, 0.0F, true);

        rForeleg01 = new ModelPart(this);
        rForeleg01.setPos(-3.1F, 0.6F, -12.7F);
        body.addChild(rForeleg01);
        setRotationAngle(rForeleg01, 0.1367F, 0.0F, 0.0911F);
        rForeleg01.texOffs(45, 0).addBox(-2.0F, -2.4F, -2.5F, 3.0F, 7.0F, 5.0F, 0.0F, true);

        rForeleg02 = new ModelPart(this);
        rForeleg02.setPos(-0.8F, 4.4F, 0.1F);
        rForeleg01.addChild(rForeleg02);
        setRotationAngle(rForeleg02, 0.0F, 0.0F, -0.0911F);
        rForeleg02.texOffs(48, 14).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 3.0F, 3.0F, 0.0F, true);

        rForeleg03 = new ModelPart(this);
        rForeleg03.setPos(0.0F, 1.7F, 0.0F);
        rForeleg02.addChild(rForeleg03);
        setRotationAngle(rForeleg03, -0.1367F, 0.0F, 0.0F);
        rForeleg03.texOffs(50, 26).addBox(-0.95F, 1.0F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, true);

        rFHoofClaw01a = new ModelPart(this);
        rFHoofClaw01a.setPos(-0.65F, 9.45F, -0.4F);
        rForeleg03.addChild(rFHoofClaw01a);
        setRotationAngle(rFHoofClaw01a, 0.0F, 0.1309F, 0.0F);
        rFHoofClaw01a.texOffs(81, 19).addBox(-0.45F, -0.4F, -1.75F, 1.0F, 1.0F, 2.0F, 0.2F, true);

        rFHoofClaw01b = new ModelPart(this);
        rFHoofClaw01b.setPos(0.0F, 0.0F, -1.0F);
        rFHoofClaw01a.addChild(rFHoofClaw01b);
        setRotationAngle(rFHoofClaw01b, 0.4363F, 0.0F, 0.0F);
        rFHoofClaw01b.texOffs(83, 13).addBox(-0.46F, -0.95F, -1.2F, 1.0F, 1.0F, 3.0F, 0.0F, false);

        rFHoofClaw02a = new ModelPart(this);
        rFHoofClaw02a.setPos(0.6F, 9.45F, -0.4F);
        rForeleg03.addChild(rFHoofClaw02a);
        rFHoofClaw02a.texOffs(81, 19).addBox(-0.45F, -0.39F, -1.75F, 1.0F, 1.0F, 2.0F, 0.2F, false);

        rFHoofClaw02b = new ModelPart(this);
        rFHoofClaw02b.setPos(0.0F, 0.0F, -1.0F);
        rFHoofClaw02a.addChild(rFHoofClaw02b);
        setRotationAngle(rFHoofClaw02b, 0.4363F, 0.0F, 0.0F);
        rFHoofClaw02b.texOffs(83, 13).addBox(-0.46F, -0.95F, -1.2F, 1.0F, 1.0F, 3.0F, 0.0F, false);

        bodyFur = new ModelPart(this);
        bodyFur.setPos(0.0F, 5.3F, -13.7F);
        body.addChild(bodyFur);
        bodyFur.texOffs(94, 52).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 2.0F, 7.0F, 0.0F, false);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.body.render(poseStack, vertexConsumer, packedLightIn, packedOverlayIn);
    }

    private static float updateReindeerRotation(float p_110683_1_, float p_110683_2_, float p_110683_3_) {
        float f;
        for(f = p_110683_2_ - p_110683_1_; f < -180.0F; f += 360.0F) {

        }
        while(f >= 180.0F) {
            f -= 360.0F;
        }
        return p_110683_1_ + p_110683_3_ * f;
    }

    @Override
    public void prepareMobModel(T entity, float limbSwing, float limbSwingAmount, float partialTickTime) {
        float f = ModelReindeer.updateReindeerRotation(entity.yBodyRotO, entity.yBodyRot, partialTickTime);
        float f1 = ModelReindeer.updateReindeerRotation(entity.yHeadRotO, entity.yHeadRot, partialTickTime);
        float f2 = entity.xRotO + (entity.xRot - entity.xRotO) * partialTickTime;
        float f3 = Mth.clamp(f1 - f, -20F, 20F);
        float f4 = rad(f2);
        if(limbSwingAmount > 0.2F) {
            f4 += Mth.cos(limbSwing * 0.4F) * 0.15F * limbSwingAmount;
        }
        EntityReindeer entityreindeer = (EntityReindeer) entity;
        float f5 = entityreindeer.getGrassEatingAmount(partialTickTime);
        float f6 = entityreindeer.getRearingAmount(partialTickTime);
        float f7 = 1.0F - f6;
        float f8 = entityreindeer.getMouthOpennessAngle(partialTickTime);
        this.body.xRot = 0.0F;
        float f16 = f3 * 0.017453292F;
        this.body.xRot = (f6 * -((float) Math.PI / 4F) + f7 * this.body.xRot) * 0.65F;
        this.lowerNeck.xRot = f6 * (0.2617994F + f4) + f5 * 2.1816616F + (1.0F - Math.max(f6, f5)) * (0.5235988F + f4) - (float) Math.toRadians(55);
        this.snout.xRot = -0.09424778F * f8;
        this.lowerJawBack.xRot = 0.15707964F * f8;
        this.lowerNeck.yRot = f6 * f3 * 0.017453292F + (1.0F - Math.max(f6, f5)) * f16;
        float f9 = entity.tickCount + partialTickTime;
        float f10 = Mth.cos(limbSwing * 0.6662F + (float) Math.PI);
        float f11 = f10 * 0.8F * limbSwingAmount;
        float f12 = 0.2617994F * f6;
        float f13 = Mth.cos(f9 * 0.6F + (float) Math.PI);
        float f14 = ((-1.0471976F + f13) * f6 + f11 * f7) * 0.8F;
        float f15 = ((-1.0471976F - f13) * f6 + -f11 * f7) * 0.8F;
        this.lHindLeg01.xRot = f12 + -f10 * 0.5F * limbSwingAmount * f7 - 0.22759093446006054F;
        this.rHindLeg01.xRot = f12 + f10 * 0.5F * limbSwingAmount * f7 - 0.22759093446006054F;
        this.lForeleg01.xRot = f14 + 0.136659280431156F;
        this.rForeleg01.xRot = f15 + 0.136659280431156F;
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}
}
