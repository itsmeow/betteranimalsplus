package dev.itsmeow.betteranimalsplus.client.model.block.head;

import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAPHead;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;

public class ModelBrownBearHead<T extends Entity> extends ModelBAPHead<T> {

    public ModelPart head;
    public ModelPart nose_r1;
    public ModelPart lowerJaw;

    public ModelBrownBearHead() {
        super(true);
        texWidth = 128;
        texHeight = 128;

        head = new ModelPart(this);
        head.setPos(0.0F, 24.0F, 0.0F);
        head.texOffs(0, 87).addBox(-5.0F, -7.5F, -8.25F, 10.0F, 10.0F, 9.0F, 0.0F, false);
        head.texOffs(0, 9).addBox(1.75F, -10.0F, -5.25F, 3.0F, 3.0F, 2.0F, 0.0F, false);
        head.texOffs(0, 9).addBox(-4.75F, -10.0F, -5.25F, 3.0F, 3.0F, 2.0F, 0.0F, true);
        head.texOffs(45, 81).addBox(-3.0F, -2.5F, -13.25F, 6.0F, 3.0F, 5.0F, 0.0F, false);
        head.texOffs(70, 83).addBox(-3.0F, 0.25F, -13.25F, 6.0F, 2.0F, 5.0F, -0.2F, false);

        nose_r1 = new ModelPart(this);
        nose_r1.setPos(0.0F, -5.0F, 0.75F);
        head.addChild(nose_r1);
        setRotationAngle(nose_r1, 0.0873F, 0.0F, 0.0F);
        nose_r1.texOffs(45, 0).addBox(-1.5F, 0.0F, -14.5F, 3.0F, 3.0F, 6.0F, 0.0F, false);

        lowerJaw = new ModelPart(this);
        lowerJaw.setPos(0.0F, 1.0F, -7.0F);
        head.addChild(lowerJaw);
        setRotationAngle(lowerJaw, 0.5672F, 0.0F, 0.0F);
        lowerJaw.texOffs(45, 94).addBox(-2.5F, -1.0F, -5.0F, 5.0F, 2.0F, 6.0F, 0.0F, false);
        lowerJaw.texOffs(70, 93).addBox(-2.5F, -2.5F, -5.0F, 5.0F, 2.0F, 6.0F, -0.2F, false);
    }

    @Override
    public ModelPart basePart() {
        return head;
    }

    @Override
    public float wallOffsetX() {
        return 3.1F;
    }

    @Override
    public float globalOffsetY() {
        return 2F;
    }
}
