package dev.itsmeow.betteranimalsplus.client.model.block.head;

import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAPHead;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class ModelBrownBearHead<T extends Entity> extends ModelBAPHead<T> {

    public ModelPart head;
    public ModelPart nose_r1;
    public ModelPart lowerJaw;

    public ModelBrownBearHead(ModelPart root) {
        super(true);
        this.head = root.getChild("head");
        this.nose_r1 = head.getChild("nose_r1");
        this.lowerJaw = head.getChild("lowerJaw");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 87).addBox(-5.0F, -7.5F, -8.25F, 10.0F, 10.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(0, 9).addBox(1.75F, -10.0F, -5.25F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 9).mirror().addBox(-4.75F, -10.0F, -5.25F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(45, 81).addBox(-3.0F, -2.5F, -13.25F, 6.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(70, 83).addBox(-3.0F, 0.25F, -13.25F, 6.0F, 2.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offset(0.0F, 24.0F, 0.0F));
        PartDefinition nose_r1 = head.addOrReplaceChild("nose_r1", CubeListBuilder.create().texOffs(45, 0).addBox(-1.5F, -4.75F, -13.5F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0873F, 0.0F, 0.0F));
        PartDefinition lowerJaw = head.addOrReplaceChild("lowerJaw", CubeListBuilder.create().texOffs(45, 94).addBox(-2.5F, -1.0F, -5.0F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(70, 93).addBox(-2.5F, -2.5F, -5.0F, 5.0F, 2.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 1.0F, -7.0F, 0.5672F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public ModelPart basePart() {
        return head;
    }

    @Override
    public float wallOffsetX() {
        return 3.25F;
    }

    @Override
    public float globalOffsetY() {
        return 2F;
    }
}
