package dev.itsmeow.betteranimalsplus.client.model.block.head;

import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAPHead;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;

public class ModelFeralWolfHead<T extends Entity> extends ModelBAPHead<T> {

    public ModelPart head;
    public ModelPart jawLower;
    public ModelPart lowerTeeth01;
    public ModelPart lowerTeeth02;
    public ModelPart snout;
    public ModelPart upperJaws;
    public ModelPart rUpperJaw;
    public ModelPart rUpperTeeth;
    public ModelPart lUpperJaw;
    public ModelPart lUpperTeeth;
    public ModelPart mUpperTeeth;
    public ModelPart cheekFurRotator;
    public ModelPart lCheekFur;
    public ModelPart rCheekFur;
    public ModelPart earsRotator;
    public ModelPart lEar01;
    public ModelPart lEar02;
    public ModelPart rEar01;
    public ModelPart rEar02;

    public ModelFeralWolfHead() {
        super(false);
        this.texWidth = 128;
        this.texHeight = 64;

        head = new ModelPart(this);
        head.setPos(0.0F, 0.0F, 0.0F);
        head.texOffs(27, 39).addBox(-3.5F, -6.0F, -2.5F, 7.0F, 6.0F, 5.0F, 0.0F, false);

        jawLower = new ModelPart(this);
        jawLower.setPos(0.0F, -0.5F, -1.41F);
        head.addChild(jawLower);
        setRotationAngle(jawLower, 2.0944F, 0.0F, 0.0F);
        jawLower.texOffs(39, 20).addBox(-1.5F, -4.5F, -0.5F, 3.0F, 5.0F, 1.0F, 0.0F, false);

        lowerTeeth01 = new ModelPart(this);
        lowerTeeth01.setPos(0.0F, -3.7F, 0.1F);
        jawLower.addChild(lowerTeeth01);
        lowerTeeth01.texOffs(57, 22).addBox(-1.6F, -0.7F, 0.4F, 1.0F, 3.0F, 1.0F, 0.0F, true);

        lowerTeeth02 = new ModelPart(this);
        lowerTeeth02.setPos(0.0F, 0.0F, 0.0F);
        lowerTeeth01.addChild(lowerTeeth02);
        lowerTeeth02.texOffs(57, 22).addBox(0.6F, -0.7F, 0.3F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        snout = new ModelPart(this);
        snout.setPos(0.0F, -3.3F, -2.3F);
        head.addChild(snout);
        setRotationAngle(snout, 1.7453F, 0.0F, 0.0F);
        snout.texOffs(40, 12).addBox(-1.5F, -4.6F, -1.2F, 3.0F, 5.0F, 2.0F, 0.0F, false);

        upperJaws = new ModelPart(this);
        upperJaws.setPos(0.25F, -4.0F, -1.0F);
        head.addChild(upperJaws);
        setRotationAngle(upperJaws, 1.5708F, 0.0F, 0.0F);


        rUpperJaw = new ModelPart(this);
        rUpperJaw.setPos(-1.45F, -1.85F, -2.0F);
        upperJaws.addChild(rUpperJaw);
        setRotationAngle(rUpperJaw, 0.0F, 0.0F, 0.1396F);
        rUpperJaw.texOffs(51, 12).addBox(-1.1F, -3.9F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, true);

        rUpperTeeth = new ModelPart(this);
        rUpperTeeth.setPos(0.0F, -2.8F, -1.0F);
        rUpperJaw.addChild(rUpperTeeth);
        rUpperTeeth.texOffs(50, 20).addBox(-0.5F, -1.0F, -0.89F, 1.0F, 4.0F, 2.0F, 0.0F, true);

        lUpperJaw = new ModelPart(this);
        lUpperJaw.setPos(0.95F, -1.85F, -2.0F);
        upperJaws.addChild(lUpperJaw);
        setRotationAngle(lUpperJaw, 0.0F, 0.0F, -0.1396F);
        lUpperJaw.texOffs(51, 12).addBox(-0.9F, -3.9F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        lUpperTeeth = new ModelPart(this);
        lUpperTeeth.setPos(0.0F, -2.8F, -1.0F);
        lUpperJaw.addChild(lUpperTeeth);
        lUpperTeeth.texOffs(50, 20).addBox(-0.5F, -1.0F, -0.89F, 1.0F, 4.0F, 2.0F, 0.0F, false);

        mUpperTeeth = new ModelPart(this);
        mUpperTeeth.setPos(-0.25F, -5.05F, -3.0F);
        upperJaws.addChild(mUpperTeeth);
        mUpperTeeth.texOffs(55, 28).addBox(-1.5F, -0.7F, -0.4F, 3.0F, 0.0F, 1.0F, 0.0F, true);

        cheekFurRotator = new ModelPart(this);
        cheekFurRotator.setPos(0.0F, 0.0F, 2.0F);
        head.addChild(cheekFurRotator);
        setRotationAngle(cheekFurRotator, 1.5708F, 0.0F, 0.0F);


        lCheekFur = new ModelPart(this);
        lCheekFur.setPos(3.5F, -2.9F, 2.5F);
        cheekFurRotator.addChild(lCheekFur);
        setRotationAngle(lCheekFur, -0.3491F, 0.0873F, -0.6981F);
        lCheekFur.texOffs(30, -6).addBox(0.0F, -0.9F, -3.8F, 0.0F, 5.0F, 6.0F, 0.0F, false);

        rCheekFur = new ModelPart(this);
        rCheekFur.setPos(-3.5F, -2.9F, 2.5F);
        cheekFurRotator.addChild(rCheekFur);
        setRotationAngle(rCheekFur, -0.3491F, -0.0873F, 0.6981F);
        rCheekFur.texOffs(30, -6).addBox(0.0F, -0.8F, -3.6F, 0.0F, 5.0F, 6.0F, 0.0F, false);

        earsRotator = new ModelPart(this);
        earsRotator.setPos(-0.5F, 0.0F, 2.25F);
        head.addChild(earsRotator);
        setRotationAngle(earsRotator, 1.5708F, 0.0F, 0.0F);


        lEar01 = new ModelPart(this);
        lEar01.setPos(2.6F, -2.6F, 5.0F);
        earsRotator.addChild(lEar01);
        setRotationAngle(lEar01, 0.0873F, 0.2269F, 0.3665F);
        lEar01.texOffs(0, 0).addBox(-1.5F, -0.5F, 0.3F, 3.0F, 1.0F, 3.0F, 0.0F, true);

        lEar02 = new ModelPart(this);
        lEar02.setPos(0.0F, 1.2F, 0.2F);
        lEar01.addChild(lEar02);
        setRotationAngle(lEar02, 0.3142F, 0.0F, 0.0F);
        lEar02.texOffs(0, 4).addBox(-1.0F, -0.7F, 0.2F, 2.0F, 1.0F, 4.0F, 0.0F, true);

        rEar01 = new ModelPart(this);
        rEar01.setPos(-1.6F, -2.6F, 5.0F);
        earsRotator.addChild(rEar01);
        setRotationAngle(rEar01, 0.0873F, -0.2269F, -0.3665F);
        rEar01.texOffs(0, 0).addBox(-1.5F, -0.5F, 0.3F, 3.0F, 1.0F, 3.0F, 0.0F, false);

        rEar02 = new ModelPart(this);
        rEar02.setPos(0.0F, 1.2F, 0.2F);
        rEar01.addChild(rEar02);
        setRotationAngle(rEar02, 0.3142F, 0.0F, 0.0F);
        rEar02.texOffs(0, 4).addBox(-1.0F, -0.7F, 0.2F, 2.0F, 1.0F, 4.0F, 0.0F, false);
    }

    @Override
    public ModelPart basePart() {
        return head;
    }

    @Override
    public float wallOffsetX() {
        return 3.5F;
    }

    @Override
    public float globalOffsetY() {
        return 0.5F;
    }
}
