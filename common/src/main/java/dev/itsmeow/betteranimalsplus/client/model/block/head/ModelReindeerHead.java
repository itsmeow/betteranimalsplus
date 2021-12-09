package dev.itsmeow.betteranimalsplus.client.model.block.head;

import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAPHead;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;

public class ModelReindeerHead<T extends Entity> extends ModelBAPHead<T> {

    public ModelPart lowerNeck;
    public ModelPart upperNeck;
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

    public ModelReindeerHead() {
        super(false);
        texWidth = 128;
        texHeight = 64;

        lowerNeck = new ModelPart(this);
        lowerNeck.setPos(-1.5F, 19.05F, 10.2F);
        lowerNeck.texOffs(0, 0).addBox(-3.5F, -3.0F, -5.0F, 7.0F, 6.0F, 5.0F, 0.0F, false);

        upperNeck = new ModelPart(this);
        upperNeck.setPos(0.0F, 0.3F, -4.0F);
        lowerNeck.addChild(upperNeck);
        setRotationAngle(upperNeck, -0.7114F, 0.0F, 0.0F);
        upperNeck.texOffs(88, 0).addBox(-2.5F, -2.5F, -5.0F, 5.0F, 5.0F, 5.0F, -0.1F, false);

        head = new ModelPart(this);
        head.setPos(0.0F, 1.1F, -4.0F);
        upperNeck.addChild(head);
        setRotationAngle(head, -0.3054F, 0.0F, 0.0F);
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
        mane01.setPos(0.0F, 1.5F, -1.3F);
        upperNeck.addChild(mane01);
        setRotationAngle(mane01, -0.8727F, 0.0F, 0.0F);
        mane01.texOffs(0, 50).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 1.0F, 5.0F, 0.0F, false);

        mane02 = new ModelPart(this);
        mane02.setPos(0.0F, 0.5F, -0.45F);
        upperNeck.addChild(mane02);
        setRotationAngle(mane02, -0.829F, 0.0F, 0.0F);
        mane02.texOffs(20, 50).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 1.0F, 6.0F, 0.0F, false);

        mane03 = new ModelPart(this);
        mane03.setPos(0.0F, 1.7F, -3.15F);
        lowerNeck.addChild(mane03);
        setRotationAngle(mane03, -1.5533F, 0.0F, 0.0F);
        mane03.texOffs(46, 50).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);

        mane04 = new ModelPart(this);
        mane04.setPos(0.0F, 1.8F, -1.1F);
        lowerNeck.addChild(mane04);
        setRotationAngle(mane04, -1.5708F, 0.0F, 0.0F);
        mane04.texOffs(72, 50).addBox(-3.0F, -1.0F, 0.0F, 6.0F, 2.0F, 6.0F, 0.0F, false);
    }

    @Override
    public ModelPart basePart() {
        return lowerNeck;
    }

    @Override
    public float wallOffsetX() {
        return 4F;
    }

    @Override
    public float globalOffsetY() {
        return 4.9F;
    }
}
