package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;

public class ModelTarantula<T extends LivingEntity> extends ModelBAP<T> {

    public ModelPart bodyBase;
    public ModelPart abdomen;
    public ModelPart thorax;
    public ModelPart head;
    public ModelPart lMandible;
    public ModelPart lFang;
    public ModelPart Box_r1;
    public ModelPart rMandible;
    public ModelPart rFang;
    public ModelPart Box_r2;
    public ModelPart lLeg01a;
    public ModelPart lLeg01b;
    public ModelPart lLeg01Fur02_r1;
    public ModelPart lLeg01Fur01_r1;
    public ModelPart lLeg01c;
    public ModelPart lLeg01Fur04_r1;
    public ModelPart lLeg01Fur03_r1;
    public ModelPart lLeg01d;
    public ModelPart rLeg01a;
    public ModelPart rLeg01b;
    public ModelPart lLeg01Fur02_r2;
    public ModelPart lLeg01Fur01_r2;
    public ModelPart rLeg01c;
    public ModelPart lLeg01Fur04_r2;
    public ModelPart lLeg01Fur03_r2;
    public ModelPart rLeg01d;
    public ModelPart lLeg02a;
    public ModelPart lLeg02b;
    public ModelPart lLeg02Fur02_r1;
    public ModelPart lLeg02Fur01_r1;
    public ModelPart lLeg02c;
    public ModelPart lLeg02Fur04_r1;
    public ModelPart lLeg02Fur03_r1;
    public ModelPart lLeg02d;
    public ModelPart rLeg02a;
    public ModelPart rLeg02b;
    public ModelPart lLeg0Fur02_r1;
    public ModelPart lLeg02Fur01_r2;
    public ModelPart rLeg02c;
    public ModelPart lLeg02Fur04_r2;
    public ModelPart lLeg02Fur03_r2;
    public ModelPart rLeg02d;
    public ModelPart lLeg03a;
    public ModelPart lLeg03b;
    public ModelPart lLeg03Fur02_r1;
    public ModelPart lLeg03Fur01_r1;
    public ModelPart lLeg03c;
    public ModelPart lLeg03Fur04_r1;
    public ModelPart lLeg03Fur03_r1;
    public ModelPart lLeg03d;
    public ModelPart rLeg03a;
    public ModelPart rLeg03b;
    public ModelPart lLeg03Fur02_r2;
    public ModelPart lLeg03Fur01_r2;
    public ModelPart rLeg03c;
    public ModelPart lLeg03Fur04_r2;
    public ModelPart lLeg03Fur03_r2;
    public ModelPart rLeg03d;
    public ModelPart lLeg04a;
    public ModelPart lLeg04b;
    public ModelPart lLeg04Fur02_r1;
    public ModelPart lLeg04Fur01_r1;
    public ModelPart lLeg04c;
    public ModelPart lLeg04Fur04_r1;
    public ModelPart lLeg04Fur03_r1;
    public ModelPart lLeg04d;
    public ModelPart rLeg04a;
    public ModelPart rLeg04b;
    public ModelPart lLeg04Fur02_r2;
    public ModelPart lLeg04Fur01_r2;
    public ModelPart rLeg04c;
    public ModelPart lLeg04Fur04_r2;
    public ModelPart lLeg04Fur03_r2;
    public ModelPart rLeg04d;
    public ModelPart lPedipalp01;
    public ModelPart lPedipalp02;
    public ModelPart lPedipalp03;
    public ModelPart rPedipalp01;
    public ModelPart rPedipalp02;
    public ModelPart rPedipalp03;

    public ModelTarantula(ModelPart root) {
        this.bodyBase = root.getChild("bodyBase");
        this.abdomen = bodyBase.getChild("abdomen");
        this.thorax = bodyBase.getChild("thorax");
        this.head = thorax.getChild("head");
        this.lMandible = head.getChild("lMandible");
        this.lFang = lMandible.getChild("lFang");
        this.Box_r1 = lFang.getChild("Box_r1");
        this.rMandible = head.getChild("rMandible");
        this.rFang = rMandible.getChild("rFang");
        this.Box_r2 = rFang.getChild("Box_r2");
        this.lLeg01a = thorax.getChild("lLeg01a");
        this.lLeg01b = lLeg01a.getChild("lLeg01b");
        this.lLeg01Fur02_r1 = lLeg01b.getChild("lLeg01Fur02_r1");
        this.lLeg01Fur01_r1 = lLeg01b.getChild("lLeg01Fur01_r1");
        this.lLeg01c = lLeg01b.getChild("lLeg01c");
        this.lLeg01Fur04_r1 = lLeg01c.getChild("lLeg01Fur04_r1");
        this.lLeg01Fur03_r1 = lLeg01c.getChild("lLeg01Fur03_r1");
        this.lLeg01d = lLeg01c.getChild("lLeg01d");
        this.rLeg01a = thorax.getChild("rLeg01a");
        this.rLeg01b = rLeg01a.getChild("rLeg01b");
        this.lLeg01Fur02_r2 = rLeg01b.getChild("lLeg01Fur02_r2");
        this.lLeg01Fur01_r2 = rLeg01b.getChild("lLeg01Fur01_r2");
        this.rLeg01c = rLeg01b.getChild("rLeg01c");
        this.lLeg01Fur04_r2 = rLeg01c.getChild("lLeg01Fur04_r2");
        this.lLeg01Fur03_r2 = rLeg01c.getChild("lLeg01Fur03_r2");
        this.rLeg01d = rLeg01c.getChild("rLeg01d");
        this.lLeg02a = thorax.getChild("lLeg02a");
        this.lLeg02b = lLeg02a.getChild("lLeg02b");
        this.lLeg02Fur02_r1 = lLeg02b.getChild("lLeg02Fur02_r1");
        this.lLeg02Fur01_r1 = lLeg02b.getChild("lLeg02Fur01_r1");
        this.lLeg02c = lLeg02b.getChild("lLeg02c");
        this.lLeg02Fur04_r1 = lLeg02c.getChild("lLeg02Fur04_r1");
        this.lLeg02Fur03_r1 = lLeg02c.getChild("lLeg02Fur03_r1");
        this.lLeg02d = lLeg02c.getChild("lLeg02d");
        this.rLeg02a = thorax.getChild("rLeg02a");
        this.rLeg02b = rLeg02a.getChild("rLeg02b");
        this.lLeg0Fur02_r1 = rLeg02b.getChild("lLeg0Fur02_r1");
        this.lLeg02Fur01_r2 = rLeg02b.getChild("lLeg02Fur01_r2");
        this.rLeg02c = rLeg02b.getChild("rLeg02c");
        this.lLeg02Fur04_r2 = rLeg02c.getChild("lLeg02Fur04_r2");
        this.lLeg02Fur03_r2 = rLeg02c.getChild("lLeg02Fur03_r2");
        this.rLeg02d = rLeg02c.getChild("rLeg02d");
        this.lLeg03a = thorax.getChild("lLeg03a");
        this.lLeg03b = lLeg03a.getChild("lLeg03b");
        this.lLeg03Fur02_r1 = lLeg03b.getChild("lLeg03Fur02_r1");
        this.lLeg03Fur01_r1 = lLeg03b.getChild("lLeg03Fur01_r1");
        this.lLeg03c = lLeg03b.getChild("lLeg03c");
        this.lLeg03Fur04_r1 = lLeg03c.getChild("lLeg03Fur04_r1");
        this.lLeg03Fur03_r1 = lLeg03c.getChild("lLeg03Fur03_r1");
        this.lLeg03d = lLeg03c.getChild("lLeg03d");
        this.rLeg03a = thorax.getChild("rLeg03a");
        this.rLeg03b = rLeg03a.getChild("rLeg03b");
        this.lLeg03Fur02_r2 = rLeg03b.getChild("lLeg03Fur02_r2");
        this.lLeg03Fur01_r2 = rLeg03b.getChild("lLeg03Fur01_r2");
        this.rLeg03c = rLeg03b.getChild("rLeg03c");
        this.lLeg03Fur04_r2 = rLeg03c.getChild("lLeg03Fur04_r2");
        this.lLeg03Fur03_r2 = rLeg03c.getChild("lLeg03Fur03_r2");
        this.rLeg03d = rLeg03c.getChild("rLeg03d");
        this.lLeg04a = thorax.getChild("lLeg04a");
        this.lLeg04b = lLeg04a.getChild("lLeg04b");
        this.lLeg04Fur02_r1 = lLeg04b.getChild("lLeg04Fur02_r1");
        this.lLeg04Fur01_r1 = lLeg04b.getChild("lLeg04Fur01_r1");
        this.lLeg04c = lLeg04b.getChild("lLeg04c");
        this.lLeg04Fur04_r1 = lLeg04c.getChild("lLeg04Fur04_r1");
        this.lLeg04Fur03_r1 = lLeg04c.getChild("lLeg04Fur03_r1");
        this.lLeg04d = lLeg04c.getChild("lLeg04d");
        this.rLeg04a = thorax.getChild("rLeg04a");
        this.rLeg04b = rLeg04a.getChild("rLeg04b");
        this.lLeg04Fur02_r2 = rLeg04b.getChild("lLeg04Fur02_r2");
        this.lLeg04Fur01_r2 = rLeg04b.getChild("lLeg04Fur01_r2");
        this.rLeg04c = rLeg04b.getChild("rLeg04c");
        this.lLeg04Fur04_r2 = rLeg04c.getChild("lLeg04Fur04_r2");
        this.lLeg04Fur03_r2 = rLeg04c.getChild("lLeg04Fur03_r2");
        this.rLeg04d = rLeg04c.getChild("rLeg04d");
        this.lPedipalp01 = thorax.getChild("lPedipalp01");
        this.lPedipalp02 = lPedipalp01.getChild("lPedipalp02");
        this.lPedipalp03 = lPedipalp02.getChild("lPedipalp03");
        this.rPedipalp01 = thorax.getChild("rPedipalp01");
        this.rPedipalp02 = rPedipalp01.getChild("rPedipalp02");
        this.rPedipalp03 = rPedipalp02.getChild("rPedipalp03");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition bodyBase = partdefinition.addOrReplaceChild("bodyBase", CubeListBuilder.create().texOffs(25, 0).addBox(-3.0F, -2.5F, 0.0F, 6.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.25F, 16.45F, 2.0F));
        PartDefinition abdomen = bodyBase.addOrReplaceChild("abdomen", CubeListBuilder.create().texOffs(0, 19).addBox(-4.5F, -3.0F, 0.0F, 9.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.3F, 0.6F, -0.182F, 0.0F, 0.0F));
        PartDefinition thorax = bodyBase.addOrReplaceChild("thorax", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -2.0F, -8.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.6F, 0.0F));
        PartDefinition head = thorax.addOrReplaceChild("head", CubeListBuilder.create().texOffs(36, 0).addBox(-4.0F, -3.0F, -3.0F, 7.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -0.1F, -7.2F));
        PartDefinition lMandible = head.addOrReplaceChild("lMandible", CubeListBuilder.create().texOffs(50, 12).mirror().addBox(-1.55F, -2.45F, -1.95F, 3.0F, 5.0F, 2.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(1.3F, 2.5F, -2.55F, 0.2618F, 0.0F, 0.0F));
        PartDefinition lFang = lMandible.addOrReplaceChild("lFang", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 2.25F, -1.25F, -0.2618F, 0.0F, 0.0F));
        PartDefinition Box_r1 = lFang.addOrReplaceChild("Box_r1", CubeListBuilder.create().texOffs(49, 19).mirror().addBox(-0.8F, -0.6F, -0.3F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
        PartDefinition rMandible = head.addOrReplaceChild("rMandible", CubeListBuilder.create().texOffs(50, 12).addBox(-1.45F, -2.45F, -1.95F, 3.0F, 5.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-2.3F, 2.5F, -2.55F, 0.2618F, 0.0F, 0.0F));
        PartDefinition rFang = rMandible.addOrReplaceChild("rFang", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 2.25F, -1.25F, -0.2618F, 0.0F, 0.0F));
        PartDefinition Box_r2 = rFang.addOrReplaceChild("Box_r2", CubeListBuilder.create().texOffs(49, 19).addBox(-0.2F, -0.6F, -0.3F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
        PartDefinition lLeg01a = thorax.addOrReplaceChild("lLeg01a", CubeListBuilder.create().texOffs(41, 42).mirror().addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.5F, 1.0F, -6.3F, 0.4363F, 0.3054F, 0.903F));
        PartDefinition lLeg01b = lLeg01a.addOrReplaceChild("lLeg01b", CubeListBuilder.create().texOffs(42, 26).mirror().addBox(-0.5F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(0.3F, -5.6F, 0.0F, -0.3054F, 0.0F, -0.5236F));
        PartDefinition lLeg01Fur02_r1 = lLeg01b.addOrReplaceChild("lLeg01Fur02_r1", CubeListBuilder.create().texOffs(0, 47).addBox(-1.0F, -3.0F, 0.0F, 10.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));
        PartDefinition lLeg01Fur01_r1 = lLeg01b.addOrReplaceChild("lLeg01Fur01_r1", CubeListBuilder.create().texOffs(0, 40).addBox(-1.0F, -3.0F, 0.0F, 10.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));
        PartDefinition lLeg01c = lLeg01b.addOrReplaceChild("lLeg01c", CubeListBuilder.create().texOffs(43, 32).mirror().addBox(0.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.7F, -0.2F, 0.0F, 0.0F, -0.2618F, 0.7741F));
        PartDefinition lLeg01Fur04_r1 = lLeg01c.addOrReplaceChild("lLeg01Fur04_r1", CubeListBuilder.create().texOffs(21, 46).addBox(-1.0F, -2.25F, 0.0F, 9.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));
        PartDefinition lLeg01Fur03_r1 = lLeg01c.addOrReplaceChild("lLeg01Fur03_r1", CubeListBuilder.create().texOffs(21, 40).addBox(-1.0F, -2.25F, 0.0F, 9.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));
        PartDefinition lLeg01d = lLeg01c.addOrReplaceChild("lLeg01d", CubeListBuilder.create().texOffs(49, 38).mirror().addBox(-0.55F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(6.7F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3054F));
        PartDefinition rLeg01a = thorax.addOrReplaceChild("rLeg01a", CubeListBuilder.create().texOffs(41, 42).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 1.0F, -6.3F, 0.4363F, -0.3054F, -0.903F));
        PartDefinition rLeg01b = rLeg01a.addOrReplaceChild("rLeg01b", CubeListBuilder.create().texOffs(42, 26).addBox(-8.5F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-0.3F, -5.6F, 0.0F, -0.3054F, 0.0F, 0.5236F));
        PartDefinition lLeg01Fur02_r2 = rLeg01b.addOrReplaceChild("lLeg01Fur02_r2", CubeListBuilder.create().texOffs(0, 47).mirror().addBox(-9.0F, -3.0F, 0.0F, 10.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));
        PartDefinition lLeg01Fur01_r2 = rLeg01b.addOrReplaceChild("lLeg01Fur01_r2", CubeListBuilder.create().texOffs(0, 40).mirror().addBox(-9.0F, -3.0F, 0.0F, 10.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));
        PartDefinition rLeg01c = rLeg01b.addOrReplaceChild("rLeg01c", CubeListBuilder.create().texOffs(43, 32).addBox(-7.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.7F, -0.2F, 0.0F, 0.0F, 0.2618F, -0.7741F));
        PartDefinition lLeg01Fur04_r2 = rLeg01c.addOrReplaceChild("lLeg01Fur04_r2", CubeListBuilder.create().texOffs(21, 46).mirror().addBox(-8.0F, -2.25F, 0.0F, 9.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));
        PartDefinition lLeg01Fur03_r2 = rLeg01c.addOrReplaceChild("lLeg01Fur03_r2", CubeListBuilder.create().texOffs(21, 40).mirror().addBox(-8.0F, -2.25F, 0.0F, 9.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));
        PartDefinition rLeg01d = rLeg01c.addOrReplaceChild("rLeg01d", CubeListBuilder.create().texOffs(49, 38).addBox(-4.45F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-6.7F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3054F));
        PartDefinition lLeg02a = thorax.addOrReplaceChild("lLeg02a", CubeListBuilder.create().texOffs(41, 42).mirror().addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.5F, 1.0F, -5.3F, 0.0873F, 0.0F, 0.7721F));
        PartDefinition lLeg02b = lLeg02a.addOrReplaceChild("lLeg02b", CubeListBuilder.create().texOffs(42, 26).mirror().addBox(-0.5F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(0.3F, -5.6F, 0.0F, -0.1309F, 0.0436F, -0.3927F));
        PartDefinition lLeg02Fur02_r1 = lLeg02b.addOrReplaceChild("lLeg02Fur02_r1", CubeListBuilder.create().texOffs(0, 47).addBox(-1.0F, -3.0F, 0.0F, 10.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));
        PartDefinition lLeg02Fur01_r1 = lLeg02b.addOrReplaceChild("lLeg02Fur01_r1", CubeListBuilder.create().texOffs(0, 40).addBox(-1.0F, -3.0F, 0.0F, 10.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));
        PartDefinition lLeg02c = lLeg02b.addOrReplaceChild("lLeg02c", CubeListBuilder.create().texOffs(43, 32).mirror().addBox(0.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.7F, -0.2F, 0.0F, 0.0F, -0.0436F, 0.7741F));
        PartDefinition lLeg02Fur04_r1 = lLeg02c.addOrReplaceChild("lLeg02Fur04_r1", CubeListBuilder.create().texOffs(21, 46).addBox(-1.0F, -2.25F, 0.0F, 9.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));
        PartDefinition lLeg02Fur03_r1 = lLeg02c.addOrReplaceChild("lLeg02Fur03_r1", CubeListBuilder.create().texOffs(21, 40).addBox(-1.0F, -2.25F, 0.0F, 9.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));
        PartDefinition lLeg02d = lLeg02c.addOrReplaceChild("lLeg02d", CubeListBuilder.create().texOffs(49, 38).mirror().addBox(-0.55F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(6.7F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3054F));
        PartDefinition rLeg02a = thorax.addOrReplaceChild("rLeg02a", CubeListBuilder.create().texOffs(41, 42).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 1.0F, -5.3F, 0.0873F, 0.0F, -0.7721F));
        PartDefinition rLeg02b = rLeg02a.addOrReplaceChild("rLeg02b", CubeListBuilder.create().texOffs(42, 26).addBox(-8.5F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-0.3F, -5.6F, 0.0F, -0.1309F, -0.0436F, 0.3927F));
        PartDefinition lLeg0Fur02_r1 = rLeg02b.addOrReplaceChild("lLeg0Fur02_r1", CubeListBuilder.create().texOffs(0, 47).mirror().addBox(-9.0F, -3.0F, 0.0F, 10.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));
        PartDefinition lLeg02Fur01_r2 = rLeg02b.addOrReplaceChild("lLeg02Fur01_r2", CubeListBuilder.create().texOffs(0, 40).mirror().addBox(-9.0F, -3.0F, 0.0F, 10.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));
        PartDefinition rLeg02c = rLeg02b.addOrReplaceChild("rLeg02c", CubeListBuilder.create().texOffs(43, 32).addBox(-7.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.7F, -0.2F, 0.0F, 0.0F, 0.0436F, -0.7741F));
        PartDefinition lLeg02Fur04_r2 = rLeg02c.addOrReplaceChild("lLeg02Fur04_r2", CubeListBuilder.create().texOffs(21, 46).mirror().addBox(-8.0F, -2.25F, 0.0F, 9.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));
        PartDefinition lLeg02Fur03_r2 = rLeg02c.addOrReplaceChild("lLeg02Fur03_r2", CubeListBuilder.create().texOffs(21, 40).mirror().addBox(-8.0F, -2.25F, 0.0F, 9.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));
        PartDefinition rLeg02d = rLeg02c.addOrReplaceChild("rLeg02d", CubeListBuilder.create().texOffs(49, 38).addBox(-4.45F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-6.7F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3054F));
        PartDefinition lLeg03a = thorax.addOrReplaceChild("lLeg03a", CubeListBuilder.create().texOffs(41, 42).mirror().addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.5F, 1.0F, -3.3F, -0.0436F, 0.0F, 0.7721F));
        PartDefinition lLeg03b = lLeg03a.addOrReplaceChild("lLeg03b", CubeListBuilder.create().texOffs(42, 26).mirror().addBox(-0.5F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(0.3F, -5.6F, 0.0F, -0.0436F, -0.1745F, -0.3927F));
        PartDefinition lLeg03Fur02_r1 = lLeg03b.addOrReplaceChild("lLeg03Fur02_r1", CubeListBuilder.create().texOffs(0, 47).addBox(-1.0F, -3.0F, 0.0F, 10.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));
        PartDefinition lLeg03Fur01_r1 = lLeg03b.addOrReplaceChild("lLeg03Fur01_r1", CubeListBuilder.create().texOffs(0, 40).addBox(-1.0F, -3.0F, 0.0F, 10.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));
        PartDefinition lLeg03c = lLeg03b.addOrReplaceChild("lLeg03c", CubeListBuilder.create().texOffs(43, 32).mirror().addBox(0.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.7F, -0.2F, 0.0F, 0.0F, -0.0436F, 0.7741F));
        PartDefinition lLeg03Fur04_r1 = lLeg03c.addOrReplaceChild("lLeg03Fur04_r1", CubeListBuilder.create().texOffs(21, 46).addBox(-1.0F, -2.25F, 0.0F, 9.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));
        PartDefinition lLeg03Fur03_r1 = lLeg03c.addOrReplaceChild("lLeg03Fur03_r1", CubeListBuilder.create().texOffs(21, 40).addBox(-1.0F, -2.25F, 0.0F, 9.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));
        PartDefinition lLeg03d = lLeg03c.addOrReplaceChild("lLeg03d", CubeListBuilder.create().texOffs(49, 38).mirror().addBox(-0.55F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(6.7F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3054F));
        PartDefinition rLeg03a = thorax.addOrReplaceChild("rLeg03a", CubeListBuilder.create().texOffs(41, 42).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 1.0F, -3.3F, -0.0436F, 0.0F, -0.7721F));
        PartDefinition rLeg03b = rLeg03a.addOrReplaceChild("rLeg03b", CubeListBuilder.create().texOffs(42, 26).addBox(-8.5F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-0.3F, -5.6F, 0.0F, -0.0436F, 0.1745F, 0.3927F));
        PartDefinition lLeg03Fur02_r2 = rLeg03b.addOrReplaceChild("lLeg03Fur02_r2", CubeListBuilder.create().texOffs(0, 47).mirror().addBox(-9.0F, -3.0F, 0.0F, 10.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));
        PartDefinition lLeg03Fur01_r2 = rLeg03b.addOrReplaceChild("lLeg03Fur01_r2", CubeListBuilder.create().texOffs(0, 40).mirror().addBox(-9.0F, -3.0F, 0.0F, 10.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));
        PartDefinition rLeg03c = rLeg03b.addOrReplaceChild("rLeg03c", CubeListBuilder.create().texOffs(43, 32).addBox(-7.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.7F, -0.2F, 0.0F, 0.0F, 0.0436F, -0.7741F));
        PartDefinition lLeg03Fur04_r2 = rLeg03c.addOrReplaceChild("lLeg03Fur04_r2", CubeListBuilder.create().texOffs(21, 46).mirror().addBox(-8.0F, -2.25F, 0.0F, 9.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));
        PartDefinition lLeg03Fur03_r2 = rLeg03c.addOrReplaceChild("lLeg03Fur03_r2", CubeListBuilder.create().texOffs(21, 40).mirror().addBox(-8.0F, -2.25F, 0.0F, 9.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));
        PartDefinition rLeg03d = rLeg03c.addOrReplaceChild("rLeg03d", CubeListBuilder.create().texOffs(49, 38).addBox(-4.45F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-6.7F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3054F));
        PartDefinition lLeg04a = thorax.addOrReplaceChild("lLeg04a", CubeListBuilder.create().texOffs(41, 42).mirror().addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.5F, 1.0F, -1.8F, -0.3491F, -0.3054F, 0.7721F));
        PartDefinition lLeg04b = lLeg04a.addOrReplaceChild("lLeg04b", CubeListBuilder.create().texOffs(42, 26).mirror().addBox(-0.5F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(0.3F, -5.6F, 0.0F, 0.0F, 0.0436F, -0.3491F));
        PartDefinition lLeg04Fur02_r1 = lLeg04b.addOrReplaceChild("lLeg04Fur02_r1", CubeListBuilder.create().texOffs(0, 47).addBox(-1.0F, -3.0F, 0.0F, 10.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));
        PartDefinition lLeg04Fur01_r1 = lLeg04b.addOrReplaceChild("lLeg04Fur01_r1", CubeListBuilder.create().texOffs(0, 40).addBox(-1.0F, -3.0F, 0.0F, 10.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));
        PartDefinition lLeg04c = lLeg04b.addOrReplaceChild("lLeg04c", CubeListBuilder.create().texOffs(43, 32).mirror().addBox(0.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.7F, -0.2F, 0.0F, 0.0F, -0.0436F, 0.7741F));
        PartDefinition lLeg04Fur04_r1 = lLeg04c.addOrReplaceChild("lLeg04Fur04_r1", CubeListBuilder.create().texOffs(21, 46).addBox(-1.0F, -2.25F, 0.0F, 9.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));
        PartDefinition lLeg04Fur03_r1 = lLeg04c.addOrReplaceChild("lLeg04Fur03_r1", CubeListBuilder.create().texOffs(21, 40).addBox(-1.0F, -2.25F, 0.0F, 9.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));
        PartDefinition lLeg04d = lLeg04c.addOrReplaceChild("lLeg04d", CubeListBuilder.create().texOffs(49, 38).mirror().addBox(-0.55F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(6.7F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3054F));
        PartDefinition rLeg04a = thorax.addOrReplaceChild("rLeg04a", CubeListBuilder.create().texOffs(41, 42).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 1.0F, -1.8F, -0.3491F, 0.3054F, -0.7721F));
        PartDefinition rLeg04b = rLeg04a.addOrReplaceChild("rLeg04b", CubeListBuilder.create().texOffs(42, 26).addBox(-8.5F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-0.3F, -5.6F, 0.0F, 0.0F, -0.0436F, 0.3491F));
        PartDefinition lLeg04Fur02_r2 = rLeg04b.addOrReplaceChild("lLeg04Fur02_r2", CubeListBuilder.create().texOffs(0, 47).mirror().addBox(-9.0F, -3.0F, 0.0F, 10.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));
        PartDefinition lLeg04Fur01_r2 = rLeg04b.addOrReplaceChild("lLeg04Fur01_r2", CubeListBuilder.create().texOffs(0, 40).mirror().addBox(-9.0F, -3.0F, 0.0F, 10.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));
        PartDefinition rLeg04c = rLeg04b.addOrReplaceChild("rLeg04c", CubeListBuilder.create().texOffs(43, 32).addBox(-7.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.7F, -0.2F, 0.0F, 0.0F, 0.0436F, -0.7741F));
        PartDefinition lLeg04Fur04_r2 = rLeg04c.addOrReplaceChild("lLeg04Fur04_r2", CubeListBuilder.create().texOffs(21, 46).mirror().addBox(-8.0F, -2.25F, 0.0F, 9.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));
        PartDefinition lLeg04Fur03_r2 = rLeg04c.addOrReplaceChild("lLeg04Fur03_r2", CubeListBuilder.create().texOffs(21, 40).mirror().addBox(-8.0F, -2.25F, 0.0F, 9.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));
        PartDefinition rLeg04d = rLeg04c.addOrReplaceChild("rLeg04d", CubeListBuilder.create().texOffs(49, 38).addBox(-4.45F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-6.7F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3054F));
        PartDefinition lPedipalp01 = thorax.addOrReplaceChild("lPedipalp01", CubeListBuilder.create().texOffs(29, 20).mirror().addBox(-1.0F, -1.0F, -5.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.05F, 1.3F, -7.6F, -0.1367F, -0.3491F, 0.0F));
        PartDefinition lPedipalp02 = lPedipalp01.addOrReplaceChild("lPedipalp02", CubeListBuilder.create().texOffs(30, 13).mirror().addBox(-0.94F, -1.0F, -4.05F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.05F, -0.4F, -4.15F, 0.9948F, 0.0F, 0.0F));
        PartDefinition lPedipalp03 = lPedipalp02.addOrReplaceChild("lPedipalp03", CubeListBuilder.create().texOffs(28, 11).addBox(-1.0F, -0.5F, -5.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.05F, 0.0F, -4.55F, 0.7418F, 0.0F, 0.0F));
        PartDefinition rPedipalp01 = thorax.addOrReplaceChild("rPedipalp01", CubeListBuilder.create().texOffs(29, 20).addBox(-1.0F, -1.0F, -5.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.05F, 1.3F, -7.6F, -0.1367F, 0.3491F, 0.0F));
        PartDefinition rPedipalp02 = rPedipalp01.addOrReplaceChild("rPedipalp02", CubeListBuilder.create().texOffs(30, 13).addBox(-1.06F, -1.0F, -4.05F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.05F, -0.4F, -4.15F, 0.9948F, 0.0F, 0.0F));
        PartDefinition rPedipalp03 = rPedipalp02.addOrReplaceChild("rPedipalp03", CubeListBuilder.create().texOffs(28, 11).mirror().addBox(-1.0F, -0.5F, -5.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.05F, 0.0F, -4.55F, 0.7418F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.bodyBase.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.headYaw(head, netHeadYaw);
        this.headPitch(head, headPitch);

        this.rLeg01a.zRot = -0.903F;
        this.lLeg01a.zRot = 0.903F;

        this.rLeg02a.zRot = -0.7721F;
        this.lLeg02a.zRot = 0.7721F;

        this.rLeg03a.zRot = -0.7721F;
        this.lLeg03a.zRot = 0.7721F;

        this.rLeg04a.zRot = -0.7721F;
        this.lLeg04a.zRot = 0.7721F;

        this.rLeg01a.yRot = -0.3054F;
        this.lLeg01a.yRot = 0.3054F;

        this.rLeg02a.yRot = 0F;
        this.lLeg02a.yRot = 0F;

        this.rLeg03a.yRot = 0F;
        this.lLeg03a.yRot = 0F;

        this.rLeg04a.yRot = 0.3054F;
        this.lLeg04a.yRot = -0.3054F;

        float y1Rot = -(Mth.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount;
        float y2Rot = -(Mth.cos(limbSwing * 0.6662F * 2.0F + pi()) * 0.4F) * limbSwingAmount;
        float y3Rot = -(Mth.cos(limbSwing * 0.6662F * 2.0F + pi() * 0.5F) * 0.4F) * limbSwingAmount;
        float y4Rot = -(Mth.cos(limbSwing * 0.6662F * 2.0F + pi() * 1.5F) * 0.4F) * limbSwingAmount;
        float z1Rot = Math.abs(Mth.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount;
        float z2Rot = Math.abs(Mth.sin(limbSwing * 0.6662F + pi()) * 0.4F) * limbSwingAmount;
        float z3Rot = Math.abs(Mth.sin(limbSwing * 0.6662F + pi() * 0.5F) * 0.4F) * limbSwingAmount;
        float z4Rot = Math.abs(Mth.sin(limbSwing * 0.6662F + pi() * 1.5F) * 0.4F) * limbSwingAmount;

        this.rLeg01a.yRot += y1Rot;
        this.lLeg01a.yRot += -y1Rot;

        this.rLeg02a.yRot += y2Rot;
        this.lLeg02a.yRot += -y2Rot;

        this.rLeg03a.yRot += y3Rot;
        this.lLeg03a.yRot += -y3Rot;

        this.rLeg04a.yRot += y4Rot;
        this.lLeg04a.yRot += -y4Rot;

        this.rLeg01a.zRot += z1Rot;
        this.lLeg01a.zRot += -z1Rot;

        this.rLeg02a.zRot += z2Rot;
        this.lLeg02a.zRot += -z2Rot;

        this.rLeg03a.zRot += z3Rot;
        this.lLeg03a.zRot += -z3Rot;

        this.rLeg04a.zRot += z4Rot;
        this.lLeg04a.zRot += -z4Rot;

        this.biped(lPedipalp01, rPedipalp01, limbSwing * 0.6662F, limbSwingAmount * 0.5F);

        this.abdomen.xRot = wiggleAlt(ageInTicks) - 0.182F;
        this.abdomen.zRot = wiggle(ageInTicks);

        this.rMandible.xRot = wiggleAlt(ageInTicks) - 0.2618F;
        this.rMandible.zRot = wiggle(ageInTicks);

        this.lMandible.xRot = -wiggleAlt(ageInTicks) - 0.2618F;
        this.lMandible.zRot = -wiggle(ageInTicks);
    }

}
