package dev.itsmeow.betteranimalsplus.client.model.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

/**
 * trilliummulti2 - cybercat5555 Created using Tabula 5.1.0
 */
public class ModelTrilliumMulti2<T extends Entity> extends ModelBAP<T> {

    public ModelPart stem01;
    public ModelPart stem02;
    public ModelPart stem03;
    public ModelPart stem04;
    public ModelPart stem05;
    public ModelPart stem02_1;
    public ModelPart stem03_1;
    public ModelPart stem04_1;
    public ModelPart stem05_1;
    public ModelPart stem02_2;
    public ModelPart stem03_2;
    public ModelPart stem04_2;
    public ModelPart stem05_2;

    private float rotation = 0;

    public ModelTrilliumMulti2(ModelPart root) {
        this.stem01 = root.getChild("stem01");
        this.stem02 = root.getChild("stem02");
        this.stem03 = root.getChild("stem03");
        this.stem04 = root.getChild("stem04");
        this.stem05 = root.getChild("stem05");
        this.stem02_1 = root.getChild("stem02_1");
        this.stem03_1 = root.getChild("stem03_1");
        this.stem04_1 = root.getChild("stem04_1");
        this.stem05_1 = root.getChild("stem05_1");
        this.stem02_2 = root.getChild("stem02_2");
        this.stem03_2 = root.getChild("stem03_2");
        this.stem04_2 = root.getChild("stem04_2");
        this.stem05_2 = root.getChild("stem05_2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition stem01 = partdefinition.addOrReplaceChild("stem01", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2F, 24.0F, -4.9F, 0.0F, -0.6732F, 0.0F));
        PartDefinition stem02 = partdefinition.addOrReplaceChild("stem02", CubeListBuilder.create().texOffs(0, 5).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2F, 22.1F, -4.9F, 0.0F, -0.6732F, 0.0F));
        PartDefinition stem03 = partdefinition.addOrReplaceChild("stem03", CubeListBuilder.create().texOffs(0, 11).addBox(-0.5F, -6.1F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2F, 19.4F, -4.9F, 0.0F, -0.6732F, 0.0F));
        PartDefinition stem04 = partdefinition.addOrReplaceChild("stem04", CubeListBuilder.create().texOffs(0, 19).addBox(-1.0F, -1.7F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2F, 13.4F, -4.9F, 0.0F, -0.4F, 0.0F));
        PartDefinition largeLeaf01a = stem04.addOrReplaceChild("largeLeaf01a", CubeListBuilder.create().texOffs(7, 0).mirror().addBox(-10.0F, 0.0F, -5.0F, 10.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.5F, 0.0F, 0.0F, 0.0F, -0.2731F));
        PartDefinition largeLeaf01b = largeLeaf01a.addOrReplaceChild("largeLeaf01b", CubeListBuilder.create().texOffs(11, 10).mirror().addBox(-8.0F, 0.0F, -3.0F, 8.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1367F));
        PartDefinition largeLeaf02a = stem04.addOrReplaceChild("largeLeaf02a", CubeListBuilder.create().texOffs(7, 0).mirror().addBox(-10.0F, 0.0F, -5.0F, 10.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.5F, 0.0F, -0.3643F, -2.0944F, 0.4554F));
        PartDefinition largeLeaf02b = largeLeaf02a.addOrReplaceChild("largeLeaf02b", CubeListBuilder.create().texOffs(11, 10).mirror().addBox(-8.0F, 0.0F, -3.0F, 8.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1367F));
        PartDefinition largeLeaf03a = stem04.addOrReplaceChild("largeLeaf03a", CubeListBuilder.create().texOffs(7, 0).mirror().addBox(-10.0F, 0.0F, -5.0F, 10.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.5F, 0.0F, 0.3643F, 2.0944F, 0.4554F));
        PartDefinition largeLeaf03b = largeLeaf03a.addOrReplaceChild("largeLeaf03b", CubeListBuilder.create().texOffs(11, 10).mirror().addBox(-8.0F, 0.0F, -3.0F, 8.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1367F));
        PartDefinition stem05 = partdefinition.addOrReplaceChild("stem05", CubeListBuilder.create().texOffs(0, 25).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2F, 12.0F, -4.9F, 0.0F, -0.4F, 0.0F));
        PartDefinition smallLeaf01a = stem05.addOrReplaceChild("smallLeaf01a", CubeListBuilder.create().texOffs(31, 0).mirror().addBox(-9.0F, 0.0F, -4.5F, 9.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, -0.1F, 0.0F, 0.0F, -3.1416F, -0.0911F));
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
        PartDefinition stem02_1 = partdefinition.addOrReplaceChild("stem02_1", CubeListBuilder.create().texOffs(0, 5).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.8F, 25.8F, 2.9F, 0.0F, 0.0F, -0.0911F));
        PartDefinition stem03_1 = partdefinition.addOrReplaceChild("stem03_1", CubeListBuilder.create().texOffs(0, 11).addBox(-0.5F, -6.1F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 23.1F, 2.9F, 0.0F, 0.0F, -0.0911F));
        PartDefinition stem04_1 = partdefinition.addOrReplaceChild("stem04_1", CubeListBuilder.create().texOffs(0, 19).addBox(-1.0F, -1.7F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, 17.1F, 2.9F, 0.0F, 0.0F, -0.0911F));
        PartDefinition largeLeaf01a_1 = stem04_1.addOrReplaceChild("largeLeaf01a_1", CubeListBuilder.create().texOffs(7, 0).mirror().addBox(-10.0F, 0.0F, -5.0F, 10.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.5F, 0.0F, 0.0F, 0.0F, -0.2731F));
        PartDefinition largeLeaf01b_1 = largeLeaf01a_1.addOrReplaceChild("largeLeaf01b_1", CubeListBuilder.create().texOffs(11, 10).mirror().addBox(-8.0F, 0.0F, -3.0F, 8.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1367F));
        PartDefinition largeLeaf02a_1 = stem04_1.addOrReplaceChild("largeLeaf02a_1", CubeListBuilder.create().texOffs(7, 0).mirror().addBox(-10.0F, 0.0F, -5.0F, 10.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.5F, 0.0F, -0.3643F, -2.0944F, 0.4554F));
        PartDefinition largeLeaf02b_1 = largeLeaf02a_1.addOrReplaceChild("largeLeaf02b_1", CubeListBuilder.create().texOffs(11, 10).mirror().addBox(-8.0F, 0.0F, -3.0F, 8.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1367F));
        PartDefinition largeLeaf03a_1 = stem04_1.addOrReplaceChild("largeLeaf03a_1", CubeListBuilder.create().texOffs(7, 0).mirror().addBox(-10.0F, 0.0F, -5.0F, 10.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.5F, 0.0F, 0.3643F, 2.0944F, 0.4554F));
        PartDefinition largeLeaf03b_1 = largeLeaf03a_1.addOrReplaceChild("largeLeaf03b_1", CubeListBuilder.create().texOffs(11, 10).mirror().addBox(-8.0F, 0.0F, -3.0F, 8.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1367F));
        PartDefinition stem05_1 = partdefinition.addOrReplaceChild("stem05_1", CubeListBuilder.create().texOffs(0, 25).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.6F, 15.7F, 2.9F, 0.0F, 0.0F, -0.0911F));
        PartDefinition smallLeaf01a_1 = stem05_1.addOrReplaceChild("smallLeaf01a_1", CubeListBuilder.create().texOffs(31, 0).mirror().addBox(-9.0F, 0.0F, -4.5F, 9.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, -0.3F, 0.0F, 0.0F, -3.1416F, -0.0911F));
        PartDefinition smallLeaf01b_1 = smallLeaf01a_1.addOrReplaceChild("smallLeaf01b_1", CubeListBuilder.create().texOffs(35, 9).mirror().addBox(-7.0F, 0.0F, -2.5F, 7.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0911F));
        PartDefinition smallLeaf02a_1 = stem05_1.addOrReplaceChild("smallLeaf02a_1", CubeListBuilder.create().texOffs(31, 0).mirror().addBox(-9.0F, 0.0F, -4.5F, 9.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, -0.3F, 0.0F, -0.0911F, -1.0472F, 0.0911F));
        PartDefinition smallLeaf02b_1 = smallLeaf02a_1.addOrReplaceChild("smallLeaf02b_1", CubeListBuilder.create().texOffs(35, 9).mirror().addBox(-7.0F, 0.0F, -2.5F, 7.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0911F));
        PartDefinition smallLeaf03a_1 = stem05_1.addOrReplaceChild("smallLeaf03a_1", CubeListBuilder.create().texOffs(31, 0).mirror().addBox(-9.0F, 0.0F, -4.5F, 9.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, -0.3F, 0.0F, 0.0911F, 1.0472F, 0.0911F));
        PartDefinition smallLeaf03b_1 = smallLeaf03a_1.addOrReplaceChild("smallLeaf03b_1", CubeListBuilder.create().texOffs(35, 9).mirror().addBox(-7.0F, 0.0F, -2.5F, 7.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0911F));
        PartDefinition petal01a_1 = stem05_1.addOrReplaceChild("petal01a_1", CubeListBuilder.create().texOffs(18, 19).addBox(-2.5F, -5.6F, -0.7F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.3F, 0.0F, 0.6374F, 0.0F, 0.0F));
        PartDefinition petal01b_1 = petal01a_1.addOrReplaceChild("petal01b_1", CubeListBuilder.create().texOffs(19, 24).addBox(-1.5F, -3.0F, 0.0F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.6F, -0.7F, -0.2276F, 0.0F, 0.0F));
        PartDefinition petal02a_1 = stem05_1.addOrReplaceChild("petal02a_1", CubeListBuilder.create().texOffs(18, 19).addBox(-2.5F, -5.6F, -0.7F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.3F, 0.0F, 0.6374F, -2.0944F, 0.0F));
        PartDefinition petal02b_1 = petal02a_1.addOrReplaceChild("petal02b_1", CubeListBuilder.create().texOffs(19, 24).addBox(-1.5F, -3.0F, 0.0F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.6F, -0.7F, -0.2276F, 0.0F, 0.0F));
        PartDefinition petal03a_1 = stem05_1.addOrReplaceChild("petal03a_1", CubeListBuilder.create().texOffs(18, 19).addBox(-2.5F, -5.6F, -0.7F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.3F, 0.0F, 0.6374F, 2.0944F, 0.0F));
        PartDefinition petal03b_1 = petal03a_1.addOrReplaceChild("petal03b_1", CubeListBuilder.create().texOffs(19, 24).addBox(-1.5F, -3.0F, 0.0F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.6F, -0.7F, -0.2276F, 0.0F, 0.0F));
        PartDefinition stem02_2 = partdefinition.addOrReplaceChild("stem02_2", CubeListBuilder.create().texOffs(0, 5).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, 25.8F, 3.1F, -0.134F, 0.0F, 0.0911F));
        PartDefinition stem03_2 = partdefinition.addOrReplaceChild("stem03_2", CubeListBuilder.create().texOffs(0, 11).addBox(-0.5F, -6.1F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.7F, 23.3F, 3.4F, -0.134F, 0.0F, 0.0911F));
        PartDefinition stem04_2 = partdefinition.addOrReplaceChild("stem04_2", CubeListBuilder.create().texOffs(0, 19).addBox(-1.0F, -1.7F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.3F, 18.6F, 4.2F, -0.134F, 0.0F, 0.0911F));
        PartDefinition largeLeaf01a_2 = stem04_2.addOrReplaceChild("largeLeaf01a_2", CubeListBuilder.create().texOffs(7, 0).mirror().addBox(-10.0F, 0.0F, -5.0F, 10.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.5F, 0.0F, 0.0F, 0.0F, -0.2731F));
        PartDefinition largeLeaf01b_2 = largeLeaf01a_2.addOrReplaceChild("largeLeaf01b_2", CubeListBuilder.create().texOffs(11, 10).mirror().addBox(-8.0F, 0.0F, -3.0F, 8.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1367F));
        PartDefinition largeLeaf02a_2 = stem04_2.addOrReplaceChild("largeLeaf02a_2", CubeListBuilder.create().texOffs(7, 0).mirror().addBox(-10.0F, 0.0F, -5.0F, 10.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.5F, 0.0F, -0.3643F, -2.0944F, 0.4554F));
        PartDefinition largeLeaf02b_2 = largeLeaf02a_2.addOrReplaceChild("largeLeaf02b_2", CubeListBuilder.create().texOffs(11, 10).mirror().addBox(-8.0F, 0.0F, -3.0F, 8.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1367F));
        PartDefinition largeLeaf03a_2 = stem04_2.addOrReplaceChild("largeLeaf03a_2", CubeListBuilder.create().texOffs(7, 0).mirror().addBox(-10.0F, 0.0F, -5.0F, 10.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.5F, 0.0F, 0.3643F, 2.0944F, 0.4554F));
        PartDefinition largeLeaf03b_2 = largeLeaf03a_2.addOrReplaceChild("largeLeaf03b_2", CubeListBuilder.create().texOffs(11, 10).mirror().addBox(-8.0F, 0.0F, -3.0F, 8.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1367F));
        PartDefinition stem05_2 = partdefinition.addOrReplaceChild("stem05_2", CubeListBuilder.create().texOffs(0, 25).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.4F, 17.5F, 4.3F, -0.134F, 0.0F, 0.0911F));
        PartDefinition smallLeaf01a_2 = stem05_2.addOrReplaceChild("smallLeaf01a_2", CubeListBuilder.create().texOffs(31, 0).mirror().addBox(-9.0F, 0.0F, -4.5F, 9.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, -0.3F, 0.0F, 0.0F, -3.1416F, -0.0911F));
        PartDefinition smallLeaf01b_2 = smallLeaf01a_2.addOrReplaceChild("smallLeaf01b_2", CubeListBuilder.create().texOffs(35, 9).mirror().addBox(-7.0F, 0.0F, -2.5F, 7.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0911F));
        PartDefinition smallLeaf02a_2 = stem05_2.addOrReplaceChild("smallLeaf02a_2", CubeListBuilder.create().texOffs(31, 0).mirror().addBox(-9.0F, 0.0F, -4.5F, 9.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, -0.3F, 0.0F, -0.0911F, -1.0472F, 0.0911F));
        PartDefinition smallLeaf02b_2 = smallLeaf02a_2.addOrReplaceChild("smallLeaf02b_2", CubeListBuilder.create().texOffs(35, 9).mirror().addBox(-7.0F, 0.0F, -2.5F, 7.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0911F));
        PartDefinition smallLeaf03a_2 = stem05_2.addOrReplaceChild("smallLeaf03a_2", CubeListBuilder.create().texOffs(31, 0).mirror().addBox(-9.0F, 0.0F, -4.5F, 9.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, -0.3F, 0.0F, 0.0911F, 1.0472F, 0.0911F));
        PartDefinition smallLeaf03b_2 = smallLeaf03a_2.addOrReplaceChild("smallLeaf03b_2", CubeListBuilder.create().texOffs(35, 9).mirror().addBox(-7.0F, 0.0F, -2.5F, 7.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0911F));
        PartDefinition petal01a_2 = stem05_2.addOrReplaceChild("petal01a_2", CubeListBuilder.create().texOffs(18, 19).addBox(-2.5F, -5.6F, -0.7F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.3F, 0.0F, 0.6374F, 0.0F, 0.0F));
        PartDefinition petal01b_2 = petal01a_2.addOrReplaceChild("petal01b_2", CubeListBuilder.create().texOffs(19, 24).addBox(-1.5F, -3.0F, 0.0F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.6F, -0.7F, -0.2276F, 0.0F, 0.0F));
        PartDefinition petal02a_2 = stem05_2.addOrReplaceChild("petal02a_2", CubeListBuilder.create().texOffs(18, 19).addBox(-2.5F, -5.6F, -0.7F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.3F, 0.0F, 0.6374F, -2.0944F, 0.0F));
        PartDefinition petal02b_2 = petal02a_2.addOrReplaceChild("petal02b_2", CubeListBuilder.create().texOffs(19, 24).addBox(-1.5F, -3.0F, 0.0F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.6F, -0.7F, -0.2276F, 0.0F, 0.0F));
        PartDefinition petal03a_2 = stem05_2.addOrReplaceChild("petal03a_2", CubeListBuilder.create().texOffs(18, 19).addBox(-2.5F, -5.6F, -0.7F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.3F, 0.0F, 0.6374F, 2.0944F, 0.0F));
        PartDefinition petal03b_2 = petal03a_2.addOrReplaceChild("petal03b_2", CubeListBuilder.create().texOffs(19, 24).addBox(-1.5F, -3.0F, 0.0F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.6F, -0.7F, -0.2276F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float r, float g, float b, float a) {
        poseStack.mulPose(Vector3f.YP.rotationDegrees(rotation)); // Yaw
        stem01.render(poseStack, buffer, packedLight, packedOverlay, r, g, b, a);
        stem02.render(poseStack, buffer, packedLight, packedOverlay, r, g, b, a);
        stem03.render(poseStack, buffer, packedLight, packedOverlay, r, g, b, a);
        stem04.render(poseStack, buffer, packedLight, packedOverlay, r, g, b, a);
        stem05.render(poseStack, buffer, packedLight, packedOverlay, r, g, b, a);
        stem02_1.render(poseStack, buffer, packedLight, packedOverlay, r, g, b, a);
        stem03_1.render(poseStack, buffer, packedLight, packedOverlay, r, g, b, a);
        stem04_1.render(poseStack, buffer, packedLight, packedOverlay, r, g, b, a);
        stem05_1.render(poseStack, buffer, packedLight, packedOverlay, r, g, b, a);
        stem02_2.render(poseStack, buffer, packedLight, packedOverlay, r, g, b, a);
        stem03_2.render(poseStack, buffer, packedLight, packedOverlay, r, g, b, a);
        stem04_2.render(poseStack, buffer, packedLight, packedOverlay, r, g, b, a);
        stem05_2.render(poseStack, buffer, packedLight, packedOverlay, r, g, b, a);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.rotation = netHeadYaw;
    }

}
