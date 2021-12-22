package dev.itsmeow.betteranimalsplus.client.model.block.head;

import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAPHead;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class ModelBlackBearHead<T extends Entity> extends ModelBAPHead<T> {

   public ModelPart head;
   public ModelPart nose_r1;
   public ModelPart lowerJaw;

    public ModelBlackBearHead(ModelPart root) {
        super(true);
        this.head = root.getChild("head");
        this.nose_r1 = head.getChild("nose_r1");
        this.lowerJaw = head.getChild("lowerJaw");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(93, 37).addBox(-4.0F, -5.5F, -7.25F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 7).addBox(2.25F, -7.5F, -4.25F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 7).mirror().addBox(-4.75F, -7.5F, -4.25F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 54).addBox(-2.5F, -2.5F, -11.25F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(50, 18).addBox(-2.5F, 0.25F, -11.25F, 5.0F, 2.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offset(0.0F, 24.0F, 0.0F));
        PartDefinition nose_r1 = head.addOrReplaceChild("nose_r1", CubeListBuilder.create().texOffs(45, 0).addBox(-1.5F, -5.5F, -11.25F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2182F, 0.0F, 0.0F));
        PartDefinition lowerJaw = head.addOrReplaceChild("lowerJaw", CubeListBuilder.create().texOffs(21, 55).addBox(-2.0F, -1.0F, -4.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(46, 27).addBox(-2.0F, -2.5F, -4.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 1.0F, -6.5F, 0.5672F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 128, 64);
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
        return 3F;
    }
}
