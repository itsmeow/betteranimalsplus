package dev.itsmeow.betteranimalsplus.client.model.block.head;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAPHead;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;

public class ModelCoyoteHead<T extends Entity> extends ModelBAPHead<T> {

    private final ModelPart head;
    private final ModelPart rCheekFur_r1;
    private final ModelPart lCheekFur_r1;
    private final ModelPart muzzle;
    private final ModelPart mUpperFang_r1;
    private final ModelPart rUpperFang_r1;
    private final ModelPart lUpperFang_r1;
    private final ModelPart rLip_r1;
    private final ModelPart lLip_r1;
    private final ModelPart lowerJaw;
    private final ModelPart lEar01;
    private final ModelPart lEar02;
    private final ModelPart cube_r1;
    private final ModelPart rEar01;
    private final ModelPart rEar02;
    private final ModelPart cube_r2;

    public ModelCoyoteHead() {
        super(false);
        texWidth = 64;
        texHeight = 64;

        head = new ModelPart(this);
        head.setPos(0.0F, 24.0F, 0.0F);
        head.texOffs(0, 46).addBox(-2.5F, -5.0F, -2.0F, 5.0F, 5.0F, 4.0F, -0.1F, false);

        rCheekFur_r1 = new ModelPart(this);
        rCheekFur_r1.setPos(-2.0F, 0.0F, 0.0F);
        head.addChild(rCheekFur_r1);
        setRotationAngle(rCheekFur_r1, 0.0F, 0.3927F, -0.4363F);
        rCheekFur_r1.texOffs(0, 56).addBox(-2.5F, -3.75F, 0.0F, 4.0F, 4.0F, 0.0F, 0.0F, true);

        lCheekFur_r1 = new ModelPart(this);
        lCheekFur_r1.setPos(3.0F, 0.0F, 0.0F);
        head.addChild(lCheekFur_r1);
        setRotationAngle(lCheekFur_r1, 0.0F, -0.3927F, 0.4363F);
        lCheekFur_r1.texOffs(0, 56).addBox(-2.5F, -3.5F, 0.0F, 4.0F, 4.0F, 0.0F, 0.0F, false);

        lowerJaw = new ModelPart(this);
        lowerJaw.setPos(0.25F, -1.25F, -2.0F);
        head.addChild(lowerJaw);
        setRotationAngle(lowerJaw, 0.7418F, 0.0F, 0.0F);
        lowerJaw.texOffs(19, 59).addBox(-1.0F, 0.0F, -2.5F, 2.0F, 1.0F, 3.0F, -0.2F, false);
        lowerJaw.texOffs(9, 56).addBox(-0.1F, -0.5F, -2.0F, 1.0F, 1.0F, 0.0F, -0.2F, false);
        lowerJaw.texOffs(9, 56).addBox(-0.9F, -0.5F, -2.0F, 1.0F, 1.0F, 0.0F, -0.2F, true);

        muzzle = new ModelPart(this);
        muzzle.setPos(0.25F, -2.5F, -2.0F);
        head.addChild(muzzle);
        setRotationAngle(muzzle, 0.1745F, 0.0F, 0.0F);
        muzzle.texOffs(19, 49).addBox(-1.0F, -0.5F, -2.5F, 2.0F, 1.0F, 3.0F, 0.0F, false);

        mUpperFang_r1 = new ModelPart(this);
        mUpperFang_r1.setPos(-0.5F, 1.0F, -2.25F);
        muzzle.addChild(mUpperFang_r1);
        setRotationAngle(mUpperFang_r1, -0.0873F, 0.0F, 0.0F);
        mUpperFang_r1.texOffs(13, 56).addBox(-0.5F, -0.5F, 0.05F, 2.0F, 1.0F, 0.0F, -0.1F, true);

        rUpperFang_r1 = new ModelPart(this);
        rUpperFang_r1.setPos(-0.5F, 1.0F, -2.25F);
        muzzle.addChild(rUpperFang_r1);
        setRotationAngle(rUpperFang_r1, 0.0F, 1.5708F, 0.0F);
        rUpperFang_r1.texOffs(9, 56).addBox(-0.5F, -0.25F, 0.0F, 1.0F, 1.0F, 0.0F, -0.1F, true);

        lUpperFang_r1 = new ModelPart(this);
        lUpperFang_r1.setPos(0.5F, 1.0F, -2.25F);
        muzzle.addChild(lUpperFang_r1);
        setRotationAngle(lUpperFang_r1, 0.0F, -1.5708F, 0.0F);
        lUpperFang_r1.texOffs(9, 56).addBox(-0.5F, -0.25F, 0.0F, 1.0F, 1.0F, 0.0F, -0.1F, false);

        rLip_r1 = new ModelPart(this);
        rLip_r1.setPos(0.0F, 0.0F, 0.0F);
        muzzle.addChild(rLip_r1);
        setRotationAngle(rLip_r1, -0.1309F, -0.1745F, 0.0F);
        rLip_r1.texOffs(5, 59).addBox(-1.4F, 0.25F, -2.35F, 1.0F, 1.0F, 4.0F, 0.0F, true);

        lLip_r1 = new ModelPart(this);
        lLip_r1.setPos(0.0F, 0.0F, 0.0F);
        muzzle.addChild(lLip_r1);
        setRotationAngle(lLip_r1, -0.1309F, 0.1745F, 0.0F);
        lLip_r1.texOffs(5, 59).addBox(0.4F, 0.25F, -2.35F, 1.0F, 1.0F, 4.0F, 0.0F, false);

        lEar01 = new ModelPart(this);
        lEar01.setPos(1.75F, -4.5F, 0.0F);
        head.addChild(lEar01);
        setRotationAngle(lEar01, 0.0F, -0.0873F, 0.2182F);
        lEar01.texOffs(31, 50).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

        lEar02 = new ModelPart(this);
        lEar02.setPos(0.0F, 0.25F, -0.75F);
        lEar01.addChild(lEar02);
        setRotationAngle(lEar02, 0.1745F, 0.0F, 0.0F);


        cube_r1 = new ModelPart(this);
        cube_r1.setPos(0.0F, 0.0F, 0.0F);
        lEar02.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, -0.829F, 0.0F);
        cube_r1.texOffs(31, 54).addBox(-0.25F, -3.5F, -0.25F, 2.0F, 4.0F, 2.0F, -0.1F, false);

        rEar01 = new ModelPart(this);
        rEar01.setPos(-1.5F, -4.25F, 0.0F);
        head.addChild(rEar01);
        setRotationAngle(rEar01, 0.0F, 0.0873F, -0.2182F);
        rEar01.texOffs(31, 50).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F, true);

        rEar02 = new ModelPart(this);
        rEar02.setPos(0.0F, 0.0F, -0.75F);
        rEar01.addChild(rEar02);
        setRotationAngle(rEar02, 0.2182F, 0.0F, 0.0F);


        cube_r2 = new ModelPart(this);
        cube_r2.setPos(0.0F, 0.0F, 0.0F);
        rEar02.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, 0.829F, 0.0F);
        cube_r2.texOffs(31, 54).addBox(-1.75F, -3.5F, -0.25F, 2.0F, 4.0F, 2.0F, -0.1F, true);
    }

    @Override
    public ModelPart basePart() {
        return head;
    }

    @Override
    public float wallOffsetX() {
        return 2F;
    }

    @Override
    public float wallOffsetZ() {
        return 2F;
    }
}
