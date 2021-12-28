package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import dev.itsmeow.betteranimalsplus.common.entity.EntityDeer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;

public class ModelDeer<T extends LivingEntity> extends ModelBAP<T> {

    public ModelPart body;
    public ModelPart ass;
    public ModelPart lHindLeg01;
    public ModelPart lHindLeg02;
    public ModelPart lHindLeg03;
    public ModelPart lHindHoofClaw01a;
    public ModelPart lHindHoofClaw01b;
    public ModelPart lHindHoofClaw02a;
    public ModelPart lHindHoofClaw02b2;
    public ModelPart rHindLeg01;
    public ModelPart rHindLeg02;
    public ModelPart rHindLeg03;
    public ModelPart rHindHoofClaw01a;
    public ModelPart rHindHoofClaw01b;
    public ModelPart rHindHoofClaw02a;
    public ModelPart rHindHoofClaw02b;
    public ModelPart tail;
    public ModelPart chest;
    public ModelPart neck;
    public ModelPart head;
    public ModelPart snout;
    public ModelPart christmas_nose;
    public ModelPart upperJaw;
    public ModelPart lEar;
    public ModelPart rEar;
    public ModelPart throat;
    public ModelPart lowerJaw;
    public ModelPart lAntler01;
    public ModelPart lAntler02;
    public ModelPart lAntler03;
    public ModelPart lAntler04;
    public ModelPart lAntler04b;
    public ModelPart lAntler05;
    public ModelPart lAntler06;
    public ModelPart lAntler06b;
    public ModelPart lAntler07;
    public ModelPart lAntler08;
    public ModelPart lAntler08b;
    public ModelPart lAntler08c;
    public ModelPart lAntler07b;
    public ModelPart lAntler03b;
    public ModelPart lAntler01b;
    public ModelPart rAntler01;
    public ModelPart rAntler02;
    public ModelPart rAntler03;
    public ModelPart rAntler04;
    public ModelPart rAntler04b;
    public ModelPart rAntler05;
    public ModelPart rAntler06;
    public ModelPart rAntler06b;
    public ModelPart rAntler07;
    public ModelPart rAntler08;
    public ModelPart rAntler08b;
    public ModelPart rAntler08c;
    public ModelPart rAntler07b;
    public ModelPart rAntler03b;
    public ModelPart rAntler01b;
    public ModelPart mane01;
    public ModelPart mane02;
    public ModelPart mane03;
    public ModelPart mane04;
    public ModelPart lForeleg01;
    public ModelPart lForeleg02;
    public ModelPart lForeleg03;
    public ModelPart lFrontHoofClaw01a;
    public ModelPart lFrontHoofClaw01b;
    public ModelPart lFrontHoofClaw02a;
    public ModelPart lFrontHoofClaw02b;
    public ModelPart rForeleg01;
    public ModelPart rForeleg02;
    public ModelPart rForeleg03;
    public ModelPart rFrontHoofClaw01a;
    public ModelPart rFrontHoofClaw01b;
    public ModelPart rFrontHoofClaw02a;
    public ModelPart rFrontHoofClaw02b;

    public ModelDeer() {
        texWidth = 64;
        texHeight = 64;

        body = new ModelPart(this);
        body.setPos(0.0F, 7.0F, -9.0F);
        body.texOffs(0, 13).addBox(-4.0F, -3.5F, 0.0F, 8.0F, 8.0F, 13.0F, 0.0F, false);

        ass = new ModelPart(this);
        ass.setPos(0.0F, -0.4F, 12.3F);
        body.addChild(ass);
        setRotationAngle(ass, -0.1745F, 0.0F, 0.0F);
        ass.texOffs(0, 34).addBox(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 6.0F, 0.0F, false);

        lHindLeg01 = new ModelPart(this);
        lHindLeg01.setPos(2.3F, -0.4F, 2.9F);
        ass.addChild(lHindLeg01);
        setRotationAngle(lHindLeg01, -0.2269F, 0.0F, 0.0F);
        lHindLeg01.texOffs(46, 0).addBox(0.0F, -1.9F, -2.0F, 3.0F, 8.0F, 5.0F, 0.0F, false);

        lHindLeg02 = new ModelPart(this);
        lHindLeg02.setPos(1.4F, 5.0F, -1.1F);
        lHindLeg01.addChild(lHindLeg02);
        setRotationAngle(lHindLeg02, 0.9076F, 0.0F, 0.0F);
        lHindLeg02.texOffs(48, 15).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, 0.0F, false);

        lHindLeg03 = new ModelPart(this);
        lHindLeg03.setPos(0.1F, 5.8F, 0.3F);
        lHindLeg02.addChild(lHindLeg03);
        setRotationAngle(lHindLeg03, -0.4887F, 0.0F, 0.0F);
        lHindLeg03.texOffs(45, 26).addBox(-1.0F, -0.55F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);

        lHindHoofClaw01a = new ModelPart(this);
        lHindHoofClaw01a.setPos(0.5F, 7.9F, -0.35F);
        lHindLeg03.addChild(lHindHoofClaw01a);
        setRotationAngle(lHindHoofClaw01a, 0.0F, -0.0524F, 0.0F);
        lHindHoofClaw01a.texOffs(39, 23).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, true);

        lHindHoofClaw01b = new ModelPart(this);
        lHindHoofClaw01b.setPos(0.0F, 0.0F, -1.0F);
        lHindHoofClaw01a.addChild(lHindHoofClaw01b);
        setRotationAngle(lHindHoofClaw01b, 0.4363F, 0.0F, 0.0F);
        lHindHoofClaw01b.texOffs(31, 23).addBox(-0.49F, -1.1F, -0.7F, 1.0F, 1.0F, 2.0F, 0.0F, true);

        lHindHoofClaw02a = new ModelPart(this);
        lHindHoofClaw02a.setPos(-0.5F, 7.9F, -0.35F);
        lHindLeg03.addChild(lHindHoofClaw02a);
        setRotationAngle(lHindHoofClaw02a, 0.0F, 0.0873F, 0.0F);
        lHindHoofClaw02a.texOffs(39, 23).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, true);

        lHindHoofClaw02b2 = new ModelPart(this);
        lHindHoofClaw02b2.setPos(0.0F, 0.0F, -1.0F);
        lHindHoofClaw02a.addChild(lHindHoofClaw02b2);
        setRotationAngle(lHindHoofClaw02b2, 0.4363F, 0.0F, 0.0F);
        lHindHoofClaw02b2.texOffs(30, 22).addBox(-0.49F, -1.1F, -0.7F, 1.0F, 1.0F, 3.0F, 0.0F, true);

        rHindLeg01 = new ModelPart(this);
        rHindLeg01.setPos(-2.3F, -0.4F, 2.9F);
        ass.addChild(rHindLeg01);
        setRotationAngle(rHindLeg01, -0.2269F, 0.0F, 0.0F);
        rHindLeg01.texOffs(46, 0).addBox(-3.0F, -1.9F, -2.0F, 3.0F, 8.0F, 5.0F, 0.0F, true);

        rHindLeg02 = new ModelPart(this);
        rHindLeg02.setPos(-1.4F, 5.0F, -1.1F);
        rHindLeg01.addChild(rHindLeg02);
        setRotationAngle(rHindLeg02, 0.9076F, 0.0F, 0.0F);
        rHindLeg02.texOffs(48, 15).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, 0.0F, true);

        rHindLeg03 = new ModelPart(this);
        rHindLeg03.setPos(-0.1F, 5.8F, 0.3F);
        rHindLeg02.addChild(rHindLeg03);
        setRotationAngle(rHindLeg03, -0.4887F, 0.0F, 0.0F);
        rHindLeg03.texOffs(45, 26).addBox(-1.0F, -0.55F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, true);

        rHindHoofClaw01a = new ModelPart(this);
        rHindHoofClaw01a.setPos(-0.5F, 7.9F, -0.35F);
        rHindLeg03.addChild(rHindHoofClaw01a);
        setRotationAngle(rHindHoofClaw01a, 0.0F, 0.0524F, 0.0F);
        rHindHoofClaw01a.texOffs(39, 23).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        rHindHoofClaw01b = new ModelPart(this);
        rHindHoofClaw01b.setPos(0.0F, 0.0F, -1.0F);
        rHindHoofClaw01a.addChild(rHindHoofClaw01b);
        setRotationAngle(rHindHoofClaw01b, 0.4363F, 0.0F, 0.0F);
        rHindHoofClaw01b.texOffs(31, 23).addBox(-0.51F, -1.1F, -0.7F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        rHindHoofClaw02a = new ModelPart(this);
        rHindHoofClaw02a.setPos(0.5F, 7.9F, -0.35F);
        rHindLeg03.addChild(rHindHoofClaw02a);
        setRotationAngle(rHindHoofClaw02a, 0.0F, -0.0873F, 0.0F);
        rHindHoofClaw02a.texOffs(39, 23).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        rHindHoofClaw02b = new ModelPart(this);
        rHindHoofClaw02b.setPos(0.0F, 0.0F, -1.0F);
        rHindHoofClaw02a.addChild(rHindHoofClaw02b);
        setRotationAngle(rHindHoofClaw02b, 0.4363F, 0.0F, 0.0F);
        rHindHoofClaw02b.texOffs(30, 22).addBox(-0.51F, -1.1F, -0.7F, 1.0F, 1.0F, 3.0F, 0.0F, false);

        tail = new ModelPart(this);
        tail.setPos(0.0F, -2.7F, 5.4F);
        ass.addChild(tail);
        setRotationAngle(tail, 0.576F, 0.0F, 0.0F);
        tail.texOffs(54, 25).addBox(-1.5F, 0.0F, -1.0F, 3.0F, 4.0F, 2.0F, 0.0F, false);

        chest = new ModelPart(this);
        chest.setPos(0.0F, 0.8F, 2.4F);
        body.addChild(chest);
        setRotationAngle(chest, -0.8378F, 0.0F, 0.0F);
        chest.texOffs(0, 0).addBox(-3.5F, -3.0F, -5.0F, 7.0F, 6.0F, 5.0F, 0.0F, false);

        neck = new ModelPart(this);
        neck.setPos(0.0F, 0.4F, -3.0F);
        chest.addChild(neck);
        setRotationAngle(neck, -0.3142F, 0.0F, 0.0F);
        neck.texOffs(26, 37).addBox(-2.5F, -2.5F, -6.0F, 5.0F, 5.0F, 5.0F, -0.1F, false);

        head = new ModelPart(this);
        head.setPos(0.0F, 1.1F, -5.0F);
        neck.addChild(head);
        setRotationAngle(head, -0.3142F, 0.0F, 0.0F);
        head.texOffs(46, 39).addBox(-2.5F, -3.0F, -4.0F, 5.0F, 5.0F, 4.0F, 0.0F, false);

        snout = new ModelPart(this);
        snout.setPos(0.0F, 1.7F, -3.1F);
        head.addChild(snout);
        setRotationAngle(snout, 0.3491F, 0.0F, 0.0F);
        snout.texOffs(54, 31).addBox(-1.5F, 0.0F, -1.0F, 3.0F, 4.0F, 2.0F, 0.0F, false);

        christmas_nose = new ModelPart(this);
        christmas_nose.setPos(0.0F, 3.95F, -1.4F);
        snout.addChild(christmas_nose);
        christmas_nose.texOffs(56, 53).addBox(-1.0F, -0.75F, -0.15F, 2.0F, 2.0F, 2.0F, 0.0F, false);

        upperJaw = new ModelPart(this);
        upperJaw.setPos(0.0F, 1.3F, -1.0F);
        head.addChild(upperJaw);
        upperJaw.texOffs(19, 57).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 4.0F, 1.0F, 0.0F, false);

        lEar = new ModelPart(this);
        lEar.setPos(2.1F, -1.0F, -3.0F);
        head.addChild(lEar);
        setRotationAngle(lEar, 0.2793F, -1.0821F, 0.0F);
        lEar.texOffs(21, 0).addBox(-1.0F, -0.7F, -3.1F, 2.0F, 1.0F, 3.0F, 0.0F, true);

        rEar = new ModelPart(this);
        rEar.setPos(-2.1F, -1.0F, -3.0F);
        head.addChild(rEar);
        setRotationAngle(rEar, 0.2793F, 1.0821F, 0.0F);
        rEar.texOffs(21, 0).addBox(-1.0F, -0.7F, -3.1F, 2.0F, 1.0F, 3.0F, 0.0F, false);

        throat = new ModelPart(this);
        throat.setPos(0.0F, 1.2F, -0.49F);
        head.addChild(throat);
        throat.texOffs(41, 48).addBox(-2.0F, 0.0F, -0.5F, 4.0F, 2.0F, 1.0F, 0.0F, false);

        lowerJaw = new ModelPart(this);
        lowerJaw.setPos(0.0F, 2.0F, 0.0F);
        throat.addChild(lowerJaw);
        lowerJaw.texOffs(52, 48).addBox(-2.0F, 0.0F, -0.5F, 4.0F, 2.0F, 1.0F, 0.0F, false);

        lAntler01 = new ModelPart(this);
        lAntler01.setPos(1.5F, -0.5F, -3.9F);
        head.addChild(lAntler01);
        setRotationAngle(lAntler01, 0.0F, -0.2618F, 0.2618F);
        lAntler01.texOffs(0, 13).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, true);

        lAntler02 = new ModelPart(this);
        lAntler02.setPos(-0.1F, 0.1F, 0.0F);
        lAntler01.addChild(lAntler02);
        setRotationAngle(lAntler02, -0.5236F, 0.0F, 0.0F);
        lAntler02.texOffs(0, 13).addBox(-0.5F, -0.4F, -2.3F, 1.0F, 1.0F, 3.0F, 0.0F, true);

        lAntler03 = new ModelPart(this);
        lAntler03.setPos(0.0F, 0.5F, -1.4F);
        lAntler02.addChild(lAntler03);
        setRotationAngle(lAntler03, -0.4887F, -0.2269F, 0.0F);
        lAntler03.texOffs(0, 13).addBox(-0.5F, -0.5F, -3.1F, 1.0F, 1.0F, 3.0F, 0.0F, true);

        lAntler04 = new ModelPart(this);
        lAntler04.setPos(0.0F, -0.1F, -2.6F);
        lAntler03.addChild(lAntler04);
        setRotationAngle(lAntler04, 0.4538F, 0.2269F, 0.0F);
        lAntler04.texOffs(0, 13).addBox(-0.5F, -0.5F, -3.1F, 1.0F, 1.0F, 3.0F, 0.0F, true);

        lAntler04b = new ModelPart(this);
        lAntler04b.setPos(0.0F, 0.0F, -2.8F);
        lAntler04.addChild(lAntler04b);
        setRotationAngle(lAntler04b, 0.4014F, 0.3491F, 0.0F);
        lAntler04b.texOffs(0, 20).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, true);

        lAntler05 = new ModelPart(this);
        lAntler05.setPos(0.0F, -0.1F, -0.3F);
        lAntler04.addChild(lAntler05);
        setRotationAngle(lAntler05, -0.8029F, -0.2269F, 0.0F);
        lAntler05.texOffs(0, 19).addBox(-0.5F, -0.5F, -4.0F, 1.0F, 1.0F, 4.0F, 0.0F, true);

        lAntler06 = new ModelPart(this);
        lAntler06.setPos(0.0F, 0.0F, -3.0F);
        lAntler05.addChild(lAntler06);
        setRotationAngle(lAntler06, 0.8727F, 0.2269F, 0.0F);
        lAntler06.texOffs(0, 19).addBox(-0.5F, -0.5F, -3.1F, 1.0F, 1.0F, 3.0F, 0.0F, true);

        lAntler06b = new ModelPart(this);
        lAntler06b.setPos(0.0F, 0.0F, -2.8F);
        lAntler06.addChild(lAntler06b);
        setRotationAngle(lAntler06b, 0.3142F, 0.4538F, 0.0F);
        lAntler06b.texOffs(2, 21).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, true);

        lAntler07 = new ModelPart(this);
        lAntler07.setPos(0.0F, 0.0F, -3.8F);
        lAntler05.addChild(lAntler07);
        setRotationAngle(lAntler07, 0.0F, 0.4887F, 0.0F);
        lAntler07.texOffs(0, 19).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, 0.0F, true);

        lAntler08 = new ModelPart(this);
        lAntler08.setPos(0.0F, 0.0F, -2.8F);
        lAntler07.addChild(lAntler08);
        setRotationAngle(lAntler08, -0.3142F, 0.6109F, 0.0F);
        lAntler08.texOffs(0, 19).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, 0.0F, true);

        lAntler08b = new ModelPart(this);
        lAntler08b.setPos(0.0F, 0.0F, -0.7F);
        lAntler08.addChild(lAntler08b);
        setRotationAngle(lAntler08b, 0.7854F, 0.4014F, 0.0F);
        lAntler08b.texOffs(0, 19).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, true);

        lAntler08c = new ModelPart(this);
        lAntler08c.setPos(0.0F, -0.2F, 0.2F);
        lAntler08.addChild(lAntler08c);
        setRotationAngle(lAntler08c, -0.3491F, -0.6109F, -1.2217F);
        lAntler08c.texOffs(0, 19).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, true);

        lAntler07b = new ModelPart(this);
        lAntler07b.setPos(0.0F, 0.0F, -1.0F);
        lAntler07.addChild(lAntler07b);
        setRotationAngle(lAntler07b, 0.8727F, 0.0F, 0.7854F);
        lAntler07b.texOffs(0, 19).addBox(-0.5F, -0.5F, -3.1F, 1.0F, 1.0F, 3.0F, 0.0F, true);

        lAntler03b = new ModelPart(this);
        lAntler03b.setPos(0.0F, 0.0F, -1.3F);
        lAntler03.addChild(lAntler03b);
        setRotationAngle(lAntler03b, 1.3963F, -0.9599F, 0.0F);
        lAntler03b.texOffs(0, 12).addBox(-0.5F, -0.5F, -2.7F, 1.0F, 1.0F, 3.0F, 0.0F, true);

        lAntler01b = new ModelPart(this);
        lAntler01b.setPos(0.0F, 0.0F, -1.2F);
        lAntler01.addChild(lAntler01b);
        setRotationAngle(lAntler01b, 0.9599F, -0.6981F, 0.3142F);
        lAntler01b.texOffs(0, 12).addBox(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 3.0F, 0.0F, true);

        rAntler01 = new ModelPart(this);
        rAntler01.setPos(-1.5F, -0.5F, -3.9F);
        head.addChild(rAntler01);
        setRotationAngle(rAntler01, 0.0F, 0.2618F, -0.2618F);
        rAntler01.texOffs(0, 13).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        rAntler02 = new ModelPart(this);
        rAntler02.setPos(0.1F, 0.1F, 0.0F);
        rAntler01.addChild(rAntler02);
        setRotationAngle(rAntler02, -0.5236F, 0.0F, 0.0F);
        rAntler02.texOffs(0, 13).addBox(-0.5F, -0.4F, -2.3F, 1.0F, 1.0F, 3.0F, 0.0F, false);

        rAntler03 = new ModelPart(this);
        rAntler03.setPos(0.0F, 0.5F, -1.4F);
        rAntler02.addChild(rAntler03);
        setRotationAngle(rAntler03, -0.4887F, 0.2269F, 0.0F);
        rAntler03.texOffs(0, 13).addBox(-0.5F, -0.5F, -3.1F, 1.0F, 1.0F, 3.0F, 0.0F, false);

        rAntler04 = new ModelPart(this);
        rAntler04.setPos(0.0F, -0.1F, -2.6F);
        rAntler03.addChild(rAntler04);
        setRotationAngle(rAntler04, 0.4538F, -0.2269F, 0.0F);
        rAntler04.texOffs(0, 13).addBox(-0.5F, -0.5F, -3.1F, 1.0F, 1.0F, 3.0F, 0.0F, false);

        rAntler04b = new ModelPart(this);
        rAntler04b.setPos(0.0F, 0.0F, -2.8F);
        rAntler04.addChild(rAntler04b);
        setRotationAngle(rAntler04b, 0.4014F, -0.3491F, 0.0F);
        rAntler04b.texOffs(0, 20).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        rAntler05 = new ModelPart(this);
        rAntler05.setPos(0.0F, -0.1F, -0.3F);
        rAntler04.addChild(rAntler05);
        setRotationAngle(rAntler05, -0.8029F, 0.2269F, 0.0F);
        rAntler05.texOffs(0, 19).addBox(-0.5F, -0.5F, -4.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);

        rAntler06 = new ModelPart(this);
        rAntler06.setPos(0.0F, 0.0F, -3.0F);
        rAntler05.addChild(rAntler06);
        setRotationAngle(rAntler06, 0.8727F, -0.2269F, 0.0F);
        rAntler06.texOffs(0, 19).addBox(-0.5F, -0.5F, -3.1F, 1.0F, 1.0F, 3.0F, 0.0F, false);

        rAntler06b = new ModelPart(this);
        rAntler06b.setPos(0.0F, 0.0F, -2.8F);
        rAntler06.addChild(rAntler06b);
        setRotationAngle(rAntler06b, 0.3142F, -0.4538F, 0.0F);
        rAntler06b.texOffs(2, 21).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        rAntler07 = new ModelPart(this);
        rAntler07.setPos(0.0F, 0.0F, -3.8F);
        rAntler05.addChild(rAntler07);
        setRotationAngle(rAntler07, 0.0F, -0.4887F, 0.0F);
        rAntler07.texOffs(0, 19).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

        rAntler08 = new ModelPart(this);
        rAntler08.setPos(0.0F, 0.0F, -2.8F);
        rAntler07.addChild(rAntler08);
        setRotationAngle(rAntler08, -0.3142F, -0.6109F, 0.0F);
        rAntler08.texOffs(0, 19).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

        rAntler08b = new ModelPart(this);
        rAntler08b.setPos(0.0F, 0.0F, -0.7F);
        rAntler08.addChild(rAntler08b);
        setRotationAngle(rAntler08b, 0.7854F, -0.4014F, 0.0F);
        rAntler08b.texOffs(0, 19).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        rAntler08c = new ModelPart(this);
        rAntler08c.setPos(0.0F, -0.3F, 0.2F);
        rAntler08.addChild(rAntler08c);
        setRotationAngle(rAntler08c, -0.3491F, 0.6109F, 1.2217F);
        rAntler08c.texOffs(0, 19).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        rAntler07b = new ModelPart(this);
        rAntler07b.setPos(0.0F, 0.0F, -1.0F);
        rAntler07.addChild(rAntler07b);
        setRotationAngle(rAntler07b, 0.8727F, 0.0F, -0.7854F);
        rAntler07b.texOffs(0, 19).addBox(-0.5F, -0.5F, -3.1F, 1.0F, 1.0F, 3.0F, 0.0F, false);

        rAntler03b = new ModelPart(this);
        rAntler03b.setPos(0.0F, 0.0F, -1.3F);
        rAntler03.addChild(rAntler03b);
        setRotationAngle(rAntler03b, 1.3963F, 0.9599F, 0.0F);
        rAntler03b.texOffs(0, 12).addBox(-0.5F, -0.5F, -2.7F, 1.0F, 1.0F, 3.0F, 0.0F, false);

        rAntler01b = new ModelPart(this);
        rAntler01b.setPos(0.0F, 0.0F, -1.2F);
        rAntler01.addChild(rAntler01b);
        setRotationAngle(rAntler01b, 0.9599F, 0.6981F, -0.3142F);
        rAntler01b.texOffs(0, 12).addBox(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);

        mane01 = new ModelPart(this);
        mane01.setPos(0.0F, 1.6F, -4.0F);
        neck.addChild(mane01);
        setRotationAngle(mane01, -0.5411F, 0.0F, 0.0F);
        mane01.texOffs(0, 48).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 1.0F, 6.0F, 0.0F, false);

        mane02 = new ModelPart(this);
        mane02.setPos(0.0F, 1.7F, -2.2F);
        neck.addChild(mane02);
        setRotationAngle(mane02, -0.5411F, 0.0F, 0.0F);
        mane02.texOffs(0, 56).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 1.0F, 7.0F, 0.0F, false);

        mane03 = new ModelPart(this);
        mane03.setPos(0.0F, 1.8F, -4.7F);
        chest.addChild(mane03);
        setRotationAngle(mane03, -0.6981F, 0.0F, 0.0F);
        mane03.texOffs(17, 48).addBox(-3.0F, -0.1F, -0.1F, 6.0F, 1.0F, 8.0F, 0.0F, false);

        mane04 = new ModelPart(this);
        mane04.setPos(0.0F, 2.0F, -3.1F);
        chest.addChild(mane04);
        setRotationAngle(mane04, -0.6109F, 0.0F, 0.0F);
        mane04.texOffs(36, 54).addBox(-3.0F, -1.0F, 0.0F, 6.0F, 2.0F, 8.0F, 0.0F, false);

        lForeleg01 = new ModelPart(this);
        lForeleg01.setPos(3.1F, 0.9F, 2.3F);
        body.addChild(lForeleg01);
        setRotationAngle(lForeleg01, 0.1396F, 0.0F, -0.0873F);
        lForeleg01.texOffs(29, 0).addBox(-1.0F, -2.4F, -2.5F, 3.0F, 7.0F, 5.0F, 0.0F, false);

        lForeleg02 = new ModelPart(this);
        lForeleg02.setPos(0.8F, 4.4F, 0.1F);
        lForeleg01.addChild(lForeleg02);
        setRotationAngle(lForeleg02, 0.0F, 0.0F, 0.0873F);
        lForeleg02.texOffs(31, 13).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 3.0F, 4.0F, 0.0F, false);

        lForeleg03 = new ModelPart(this);
        lForeleg03.setPos(-0.4F, 2.7F, 0.0F);
        lForeleg02.addChild(lForeleg03);
        setRotationAngle(lForeleg03, -0.1396F, 0.0F, 0.0F);
        lForeleg03.texOffs(45, 26).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);

        lFrontHoofClaw01a = new ModelPart(this);
        lFrontHoofClaw01a.setPos(0.55F, 8.65F, -0.35F);
        lForeleg03.addChild(lFrontHoofClaw01a);
        setRotationAngle(lFrontHoofClaw01a, 0.0F, -0.0524F, 0.0F);
        lFrontHoofClaw01a.texOffs(39, 23).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, true);

        lFrontHoofClaw01b = new ModelPart(this);
        lFrontHoofClaw01b.setPos(0.0F, 0.0F, -1.0F);
        lFrontHoofClaw01a.addChild(lFrontHoofClaw01b);
        setRotationAngle(lFrontHoofClaw01b, 0.4363F, 0.0F, 0.0F);
        lFrontHoofClaw01b.texOffs(31, 23).addBox(-0.49F, -1.1F, -0.7F, 1.0F, 1.0F, 2.0F, 0.0F, true);

        lFrontHoofClaw02a = new ModelPart(this);
        lFrontHoofClaw02a.setPos(-0.45F, 8.65F, -0.35F);
        lForeleg03.addChild(lFrontHoofClaw02a);
        setRotationAngle(lFrontHoofClaw02a, 0.0F, 0.0873F, 0.0F);
        lFrontHoofClaw02a.texOffs(39, 23).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, true);

        lFrontHoofClaw02b = new ModelPart(this);
        lFrontHoofClaw02b.setPos(0.0F, 0.0F, -1.0F);
        lFrontHoofClaw02a.addChild(lFrontHoofClaw02b);
        setRotationAngle(lFrontHoofClaw02b, 0.4363F, 0.0F, 0.0F);
        lFrontHoofClaw02b.texOffs(30, 22).addBox(-0.49F, -1.1F, -0.7F, 1.0F, 1.0F, 3.0F, 0.0F, true);

        rForeleg01 = new ModelPart(this);
        rForeleg01.setPos(-3.1F, 0.9F, 2.3F);
        body.addChild(rForeleg01);
        setRotationAngle(rForeleg01, 0.1396F, 0.0F, 0.0873F);
        rForeleg01.texOffs(29, 0).addBox(-2.0F, -2.4F, -2.5F, 3.0F, 7.0F, 5.0F, 0.0F, true);

        rForeleg02 = new ModelPart(this);
        rForeleg02.setPos(-0.8F, 4.4F, 0.1F);
        rForeleg01.addChild(rForeleg02);
        setRotationAngle(rForeleg02, 0.0F, 0.0F, -0.0873F);
        rForeleg02.texOffs(31, 13).addBox(-1.0F, 0.0F, -2.0F, 3.0F, 3.0F, 4.0F, 0.0F, true);

        rForeleg03 = new ModelPart(this);
        rForeleg03.setPos(0.4F, 2.7F, 0.0F);
        rForeleg02.addChild(rForeleg03);
        setRotationAngle(rForeleg03, -0.1396F, 0.0F, 0.0F);
        rForeleg03.texOffs(45, 26).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, true);

        rFrontHoofClaw01a = new ModelPart(this);
        rFrontHoofClaw01a.setPos(-0.55F, 8.65F, -0.35F);
        rForeleg03.addChild(rFrontHoofClaw01a);
        setRotationAngle(rFrontHoofClaw01a, 0.0F, 0.0524F, 0.0F);
        rFrontHoofClaw01a.texOffs(39, 23).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        rFrontHoofClaw01b = new ModelPart(this);
        rFrontHoofClaw01b.setPos(0.0F, 0.0F, -1.0F);
        rFrontHoofClaw01a.addChild(rFrontHoofClaw01b);
        setRotationAngle(rFrontHoofClaw01b, 0.4363F, 0.0F, 0.0F);
        rFrontHoofClaw01b.texOffs(31, 23).addBox(-0.51F, -1.1F, -0.7F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        rFrontHoofClaw02a = new ModelPart(this);
        rFrontHoofClaw02a.setPos(0.45F, 8.65F, -0.35F);
        rForeleg03.addChild(rFrontHoofClaw02a);
        setRotationAngle(rFrontHoofClaw02a, 0.0F, -0.0873F, 0.0F);
        rFrontHoofClaw02a.texOffs(39, 23).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        rFrontHoofClaw02b = new ModelPart(this);
        rFrontHoofClaw02b.setPos(0.0F, 0.0F, -1.0F);
        rFrontHoofClaw02a.addChild(rFrontHoofClaw02b);
        setRotationAngle(rFrontHoofClaw02b, 0.4363F, 0.0F, 0.0F);
        rFrontHoofClaw02b.texOffs(30, 22).addBox(-0.51F, -1.1F, -0.7F, 1.0F, 1.0F, 3.0F, 0.0F, false);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.quadriped(lHindLeg01, rHindLeg01, lForeleg01, rForeleg01, limbSwing * 0.666F, limbSwingAmount * 1.4F);
        this.headYaw(head, netHeadYaw, 0.5F, 0F);
        if (entity instanceof EntityDeer) {
            EntityDeer deer = (EntityDeer) entity;
            float eatTime = deer.getEatTime();
            if (eatTime > 0) {
                this.chest.xRot = rad(15F);
                this.neck.xRot = rad(40F);
                this.head.xRot = rad(-65F);
                this.lowerJaw.xRot = rad(eatTime % 20F) + 0.1F;
            } else {
                this.chest.xRot = -0.8378F;
                this.neck.xRot = -0.3142F;
                this.lowerJaw.xRot = 0F;
                this.headPitch(head, headPitch, 1F, 0F);
            }
        }
    }

}
