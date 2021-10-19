package dev.itsmeow.betteranimalsplus.client.model.block.head;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAPHead;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;

public class ModelBlackBearHead<T extends Entity> extends ModelBAPHead<T> {

    private final ModelPart head;
    private final ModelPart nose_r1;
    private final ModelPart lowerJaw;

    public ModelBlackBearHead() {
        super(true);
        texWidth = 128;
        texHeight = 64;

        head = new ModelPart(this);
        head.setPos(0.0F, 23.9F, 0.0F);
        head.texOffs(93, 37).addBox(-4.0F, -5.5F, -8.25F, 8.0F, 8.0F, 8.0F, 0.0F, false);
        head.texOffs(0, 7).addBox(2.25F, -7.5F, -5.25F, 3.0F, 3.0F, 2.0F, 0.0F, false);
        head.texOffs(0, 7).addBox(-4.75F, -7.5F, -5.25F, 3.0F, 3.0F, 2.0F, 0.0F, true);
        head.texOffs(0, 54).addBox(-2.5F, -2.5F, -12.25F, 5.0F, 3.0F, 4.0F, 0.0F, false);
        head.texOffs(50, 18).addBox(-2.5F, 0.25F, -12.25F, 5.0F, 2.0F, 4.0F, -0.2F, false);

        nose_r1 = new ModelPart(this);
        nose_r1.setPos(0.0F, -5.0F, 0.75F);
        head.addChild(nose_r1);
        setRotationAngle(nose_r1, 0.2182F, 0.0F, 0.0F);
        nose_r1.texOffs(45, 0).addBox(-1.5F, -1.0F, -13.5F, 3.0F, 3.0F, 5.0F, 0.0F, false);

        lowerJaw = new ModelPart(this);
        lowerJaw.setPos(0.0F, 1.0F, -7.5F);
        head.addChild(lowerJaw);
        setRotationAngle(lowerJaw, 0.5672F, 0.0F, 0.0F);
        lowerJaw.texOffs(21, 55).addBox(-2.0F, -1.0F, -4.0F, 4.0F, 2.0F, 5.0F, 0.0F, false);
        lowerJaw.texOffs(46, 27).addBox(-2.0F, -2.5F, -4.0F, 4.0F, 2.0F, 5.0F, -0.2F, false);
    }

    @Override
    public ModelPart basePart() {
        return head;
    }

    @Override
    public void transform(PoseStack stack) {
        stack.translate(0F, 0.21875F, -0.025F);
    }
}
