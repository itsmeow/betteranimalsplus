package dev.itsmeow.betteranimalsplus.client.model.block.head;

import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAPHead;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;

public class ModelBoarHead<T extends Entity> extends ModelBAPHead<T> {

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

    public ModelBoarHead() {
        super(true);
        texWidth = 64;
        texHeight = 64;

        head = new ModelPart(this);
        head.setPos(0.0F, 0.0F, 0.0F);
        head.texOffs(23, 38).addBox(-2.5F, -6.0F, -2.2F, 5.0F, 6.0F, 5.0F, 0.0F, false);

        snoot = new ModelPart(this);
        snoot.setPos(0.0F, -3.15F, -1.6F);
        head.addChild(snoot);
        setRotationAngle(snoot, 0.2731F, 0.0F, 0.0F);
        snoot.texOffs(42, 36).addBox(-1.5F, -1.5F, -4.7F, 3.0F, 2.0F, 5.0F, 0.0F, false);

        nose = new ModelPart(this);
        nose.setPos(0.0F, -0.4F, -4.3F);
        snoot.addChild(nose);
        setRotationAngle(nose, -0.1367F, 0.0F, 0.0F);
        nose.texOffs(56, 50).addBox(-1.5F, -1.5F, -0.8F, 3.0F, 3.0F, 1.0F, 0.01F, false);

        upperJaw = new ModelPart(this);
        upperJaw.setPos(0.0F, -1.85F, -1.6F);
        head.addChild(upperJaw);
        upperJaw.texOffs(44, 43).addBox(-1.5F, -1.0F, -4.0F, 3.0F, 2.0F, 4.0F, -0.01F, false);

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
        lowerJaw.setPos(0.0F, -0.35F, -1.3F);
        head.addChild(lowerJaw);
        setRotationAngle(lowerJaw, 0.5236F, 0.0F, 0.0F);
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
        lEar01.setPos(0.7F, -5.25F, 0.1F);
        head.addChild(lEar01);
        setRotationAngle(lEar01, 0.0F, -0.3927F, 0.3927F);
        lEar01.texOffs(56, 17).addBox(0.2F, -3.0F, -0.5F, 2.0F, 3.0F, 1.0F, 0.0F, true);

        lEar02 = new ModelPart(this);
        lEar02.setPos(0.6F, 0.0F, 0.7F);
        lEar01.addChild(lEar02);
        lEar02.texOffs(58, 9).addBox(-1.25F, -4.25F, -0.5F, 2.0F, 5.0F, 0.0F, 0.0F, true);

        rEar01 = new ModelPart(this);
        rEar01.setPos(-0.7F, -5.25F, 0.1F);
        head.addChild(rEar01);
        setRotationAngle(rEar01, 0.0F, 0.3927F, -0.3927F);
        rEar01.texOffs(56, 17).addBox(-2.2F, -3.0F, -0.5F, 2.0F, 3.0F, 1.0F, 0.0F, false);

        rEar02 = new ModelPart(this);
        rEar02.setPos(-0.35F, -0.25F, 0.7F);
        rEar01.addChild(rEar02);
        rEar02.texOffs(58, 9).addBox(-1.0F, -4.0F, -0.5F, 2.0F, 5.0F, 0.0F, 0.0F, false);
    }

    @Override
    public ModelPart basePart() {
        return head;
    }

    @Override
    public float wallOffsetX() {
        return 1F;
    }

    @Override
    public float globalOffsetY() {
        return 1.9F;
    }
}
