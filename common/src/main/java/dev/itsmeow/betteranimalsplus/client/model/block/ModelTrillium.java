package dev.itsmeow.betteranimalsplus.client.model.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

/**
 * trillium - cybercat5555 Created using Tabula 5.1.0
 */
public class ModelTrillium<T extends Entity> extends ModelBAP<T> {

    public ModelPart stem01;
    public ModelPart stem02;
    public ModelPart stem03;
    public ModelPart stem04;
    public ModelPart stem05;
    public ModelPart largeLeaf01a;
    public ModelPart largeLeaf02a;
    public ModelPart largeLeaf03a;
    public ModelPart largeLeaf01b;
    public ModelPart largeLeaf02b;
    public ModelPart largeLeaf03b;
    public ModelPart smallLeaf01a;
    public ModelPart smallLeaf02a;
    public ModelPart smallLeaf03a;
    public ModelPart petal01a;
    public ModelPart petal02a;
    public ModelPart petal03a;
    public ModelPart smallLeaf01b;
    public ModelPart smallLeaf02b;
    public ModelPart smallLeaf03b;
    public ModelPart petal01b;
    public ModelPart petal02b;
    public ModelPart petal03b;

    private float rotation = 0;

    public ModelTrillium(ModelPart root) {
        this.stem01 = root.getChild("stem01");
        this.stem02 = root.getChild("stem02");
        this.stem03 = root.getChild("stem03");
        this.stem04 = root.getChild("stem04");
        this.largeLeaf01a = stem04.getChild("largeLeaf01a");
        this.largeLeaf01b = largeLeaf01a.getChild("largeLeaf01b");
        this.largeLeaf02a = stem04.getChild("largeLeaf02a");
        this.largeLeaf02b = largeLeaf02a.getChild("largeLeaf02b");
        this.largeLeaf03a = stem04.getChild("largeLeaf03a");
        this.largeLeaf03b = largeLeaf03a.getChild("largeLeaf03b");
        this.stem05 = root.getChild("stem05");
        this.smallLeaf01a = stem05.getChild("smallLeaf01a");
        this.smallLeaf01b = smallLeaf01a.getChild("smallLeaf01b");
        this.smallLeaf02a = stem05.getChild("smallLeaf02a");
        this.smallLeaf02b = smallLeaf02a.getChild("smallLeaf02b");
        this.smallLeaf03a = stem05.getChild("smallLeaf03a");
        this.smallLeaf03b = smallLeaf03a.getChild("smallLeaf03b");
        this.petal01a = stem05.getChild("petal01a");
        this.petal01b = petal01a.getChild("petal01b");
        this.petal02a = stem05.getChild("petal02a");
        this.petal02b = petal02a.getChild("petal02b");
        this.petal03a = stem05.getChild("petal03a");
        this.petal03b = petal03a.getChild("petal03b");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition stem01 = partdefinition.addOrReplaceChild("stem01", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
        PartDefinition stem02 = partdefinition.addOrReplaceChild("stem02", CubeListBuilder.create().texOffs(0, 5).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.1F, 0.0F));
        PartDefinition stem03 = partdefinition.addOrReplaceChild("stem03", CubeListBuilder.create().texOffs(0, 11).addBox(-0.5F, -6.1F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.4F, 0.0F));
        PartDefinition stem04 = partdefinition.addOrReplaceChild("stem04", CubeListBuilder.create().texOffs(0, 19).addBox(-1.0F, -1.7F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.4F, 0.0F));
        PartDefinition largeLeaf01a = stem04.addOrReplaceChild("largeLeaf01a", CubeListBuilder.create().texOffs(7, 0).mirror().addBox(-10.0F, 0.0F, -5.0F, 10.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.5F, 0.0F, 0.0F, 0.0F, -0.2731F));
        PartDefinition largeLeaf01b = largeLeaf01a.addOrReplaceChild("largeLeaf01b", CubeListBuilder.create().texOffs(11, 10).mirror().addBox(-8.0F, 0.0F, -3.0F, 8.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1367F));
        PartDefinition largeLeaf02a = stem04.addOrReplaceChild("largeLeaf02a", CubeListBuilder.create().texOffs(7, 0).mirror().addBox(-10.0F, 0.0F, -5.0F, 10.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.5F, 0.0F, -0.3643F, -2.0944F, 0.4554F));
        PartDefinition largeLeaf02b = largeLeaf02a.addOrReplaceChild("largeLeaf02b", CubeListBuilder.create().texOffs(11, 10).mirror().addBox(-8.0F, 0.0F, -3.0F, 8.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1367F));
        PartDefinition largeLeaf03a = stem04.addOrReplaceChild("largeLeaf03a", CubeListBuilder.create().texOffs(7, 0).mirror().addBox(-10.0F, 0.0F, -5.0F, 10.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.5F, 0.0F, 0.3643F, 2.0944F, 0.4554F));
        PartDefinition largeLeaf03b = largeLeaf03a.addOrReplaceChild("largeLeaf03b", CubeListBuilder.create().texOffs(11, 10).mirror().addBox(-8.0F, 0.0F, -3.0F, 8.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1367F));
        PartDefinition stem05 = partdefinition.addOrReplaceChild("stem05", CubeListBuilder.create().texOffs(0, 25).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));
        PartDefinition smallLeaf01a = stem05.addOrReplaceChild("smallLeaf01a", CubeListBuilder.create().texOffs(31, 0).mirror().addBox(-9.0F, 0.0F, -4.5F, 9.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, -0.3F, 0.0F, 0.0F, -3.1416F, -0.0911F));
        PartDefinition smallLeaf01b = smallLeaf01a.addOrReplaceChild("smallLeaf01b", CubeListBuilder.create().texOffs(35, 9).mirror().addBox(-7.0F, 0.0F, -2.5F, 7.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0911F));
        PartDefinition smallLeaf02a = stem05.addOrReplaceChild("smallLeaf02a", CubeListBuilder.create().texOffs(31, 0).mirror().addBox(-9.0F, 0.0F, -4.5F, 9.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, -0.3F, 0.0F, -0.0911F, -1.0472F, 0.0911F));
        PartDefinition smallLeaf02b = smallLeaf02a.addOrReplaceChild("smallLeaf02b", CubeListBuilder.create().texOffs(35, 9).mirror().addBox(-7.0F, 0.0F, -2.5F, 7.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0911F));
        PartDefinition smallLeaf03a = stem05.addOrReplaceChild("smallLeaf03a", CubeListBuilder.create().texOffs(31, 0).mirror().addBox(-9.0F, 0.0F, -4.5F, 9.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, -0.3F, 0.0F, 0.0911F, 1.0472F, 0.0911F));
        PartDefinition smallLeaf03b = smallLeaf03a.addOrReplaceChild("smallLeaf03b", CubeListBuilder.create().texOffs(35, 9).mirror().addBox(-7.0F, 0.0F, -2.5F, 7.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0911F));
        PartDefinition petal01a = stem05.addOrReplaceChild("petal01a", CubeListBuilder.create().texOffs(18, 19).addBox(-2.5F, -5.6F, -0.7F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.3F, 0.0F, 0.6374F, 0.0F, 0.0F));
        PartDefinition petal01b = petal01a.addOrReplaceChild("petal01b", CubeListBuilder.create().texOffs(19, 24).addBox(-1.5F, -3.0F, 0.0F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.6F, -0.7F, -0.2276F, 0.0F, 0.0F));
        PartDefinition petal02a = stem05.addOrReplaceChild("petal02a", CubeListBuilder.create().texOffs(18, 19).addBox(-2.5F, -5.6F, -0.7F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.3F, 0.0F, 0.6374F, -2.0944F, 0.0F));
        PartDefinition petal02b = petal02a.addOrReplaceChild("petal02b", CubeListBuilder.create().texOffs(19, 24).addBox(-1.5F, -3.0F, 0.0F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.6F, -0.7F, -0.2276F, 0.0F, 0.0F));
        PartDefinition petal03a = stem05.addOrReplaceChild("petal03a", CubeListBuilder.create().texOffs(18, 19).addBox(-2.5F, -5.6F, -0.7F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.3F, 0.0F, 0.6374F, 2.0944F, 0.0F));
        PartDefinition petal03b = petal03a.addOrReplaceChild("petal03b", CubeListBuilder.create().texOffs(19, 24).addBox(-1.5F, -3.0F, 0.0F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.6F, -0.7F, -0.2276F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.rotation = netHeadYaw;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float r, float g, float b, float a) {
        poseStack.mulPose(Axis.YP.rotationDegrees(rotation)); // Yaw
        stem01.render(poseStack, buffer, packedLight, packedOverlay, r, g, b, a);
        stem02.render(poseStack, buffer, packedLight, packedOverlay, r, g, b, a);
        stem03.render(poseStack, buffer, packedLight, packedOverlay, r, g, b, a);
        stem04.render(poseStack, buffer, packedLight, packedOverlay, r, g, b, a);
        stem05.render(poseStack, buffer, packedLight, packedOverlay, r, g, b, a);
    }

}
