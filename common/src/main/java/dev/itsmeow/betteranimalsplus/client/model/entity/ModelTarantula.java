package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;

public class ModelTarantula<T extends LivingEntity> extends ModelBAP<T> {

    protected final ModelPart bodyBase;
    protected final ModelPart abdomen;
    protected final ModelPart thorax;
    protected final ModelPart head;
    protected final ModelPart lMandible;
    protected final ModelPart lFang;
    protected final ModelPart Box_r1;
    protected final ModelPart rMandible;
    protected final ModelPart rFang;
    protected final ModelPart Box_r2;
    protected final ModelPart lLeg01a;
    protected final ModelPart lLeg01b;
    protected final ModelPart lLeg01Fur02_r1;
    protected final ModelPart lLeg01Fur01_r1;
    protected final ModelPart lLeg01c;
    protected final ModelPart lLeg01Fur04_r1;
    protected final ModelPart lLeg01Fur03_r1;
    protected final ModelPart lLeg01d;
    protected final ModelPart rLeg01a;
    protected final ModelPart rLeg01b;
    protected final ModelPart lLeg01Fur02_r2;
    protected final ModelPart lLeg01Fur01_r2;
    protected final ModelPart rLeg01c;
    protected final ModelPart lLeg01Fur04_r2;
    protected final ModelPart lLeg01Fur03_r2;
    protected final ModelPart rLeg01d;
    protected final ModelPart lLeg02a;
    protected final ModelPart lLeg02b;
    protected final ModelPart lLeg02Fur02_r1;
    protected final ModelPart lLeg02Fur01_r1;
    protected final ModelPart lLeg02c;
    protected final ModelPart lLeg02Fur04_r1;
    protected final ModelPart lLeg02Fur03_r1;
    protected final ModelPart lLeg02d;
    protected final ModelPart rLeg02a;
    protected final ModelPart rLeg02b;
    protected final ModelPart lLeg0Fur02_r1;
    protected final ModelPart lLeg02Fur01_r2;
    protected final ModelPart rLeg02c;
    protected final ModelPart lLeg02Fur04_r2;
    protected final ModelPart lLeg02Fur03_r2;
    protected final ModelPart rLeg02d;
    protected final ModelPart lLeg03a;
    protected final ModelPart lLeg03b;
    protected final ModelPart lLeg03Fur02_r1;
    protected final ModelPart lLeg03Fur01_r1;
    protected final ModelPart lLeg03c;
    protected final ModelPart lLeg03Fur04_r1;
    protected final ModelPart lLeg03Fur03_r1;
    protected final ModelPart lLeg03d;
    protected final ModelPart rLeg03a;
    protected final ModelPart rLeg03b;
    protected final ModelPart lLeg03Fur02_r2;
    protected final ModelPart lLeg03Fur01_r2;
    protected final ModelPart rLeg03c;
    protected final ModelPart lLeg03Fur04_r2;
    protected final ModelPart lLeg03Fur03_r2;
    protected final ModelPart rLeg03d;
    protected final ModelPart lLeg04a;
    protected final ModelPart lLeg04b;
    protected final ModelPart lLeg04Fur02_r1;
    protected final ModelPart lLeg04Fur01_r1;
    protected final ModelPart lLeg04c;
    protected final ModelPart lLeg04Fur04_r1;
    protected final ModelPart lLeg04Fur03_r1;
    protected final ModelPart lLeg04d;
    protected final ModelPart rLeg04a;
    protected final ModelPart rLeg04b;
    protected final ModelPart lLeg04Fur02_r2;
    protected final ModelPart lLeg04Fur01_r2;
    protected final ModelPart rLeg04c;
    protected final ModelPart lLeg04Fur04_r2;
    protected final ModelPart lLeg04Fur03_r2;
    protected final ModelPart rLeg04d;
    protected final ModelPart lPedipalp01;
    protected final ModelPart lPedipalp02;
    protected final ModelPart lPedipalp03;
    protected final ModelPart rPedipalp01;
    protected final ModelPart rPedipalp02;
    protected final ModelPart rPedipalp03;

    public ModelTarantula() {
        texWidth = 64;
        texHeight = 64;

        bodyBase = new ModelPart(this);
        bodyBase.setPos(-0.25F, 16.45F, 2.0F);
        bodyBase.texOffs(25, 0).addBox(-3.0F, -2.5F, 0.0F, 6.0F, 5.0F, 1.0F, 0.0F, false);

        abdomen = new ModelPart(this);
        abdomen.setPos(0.0F, -0.3F, 0.6F);
        bodyBase.addChild(abdomen);
        setRotationAngle(abdomen, -0.182F, 0.0F, 0.0F);
        abdomen.texOffs(0, 19).addBox(-4.5F, -3.0F, 0.0F, 9.0F, 7.0F, 10.0F, 0.0F, false);

        thorax = new ModelPart(this);
        thorax.setPos(0.0F, -1.6F, 0.0F);
        bodyBase.addChild(thorax);
        thorax.texOffs(0, 0).addBox(-4.0F, -2.0F, -8.0F, 8.0F, 4.0F, 8.0F, 0.0F, false);

        head = new ModelPart(this);
        head.setPos(0.5F, -0.1F, -7.2F);
        thorax.addChild(head);
        head.texOffs(36, 0).addBox(-4.0F, -3.0F, -3.0F, 7.0F, 5.0F, 6.0F, 0.0F, false);

        lMandible = new ModelPart(this);
        lMandible.setPos(1.3F, 2.5F, -2.55F);
        head.addChild(lMandible);
        setRotationAngle(lMandible, 0.2618F, 0.0F, 0.0F);
        lMandible.texOffs(50, 12).addBox(-1.55F, -2.45F, -1.95F, 3.0F, 5.0F, 2.0F, -0.1F, true);

        lFang = new ModelPart(this);
        lFang.setPos(0.0F, 2.25F, -1.25F);
        lMandible.addChild(lFang);
        setRotationAngle(lFang, -0.2618F, 0.0F, 0.0F);


        Box_r1 = new ModelPart(this);
        Box_r1.setPos(0.0F, 0.0F, 0.0F);
        lFang.addChild(Box_r1);
        setRotationAngle(Box_r1, 0.0F, 0.0F, 0.7854F);
        Box_r1.texOffs(49, 19).addBox(-0.8F, -0.6F, -0.3F, 1.0F, 1.0F, 3.0F, 0.0F, true);

        rMandible = new ModelPart(this);
        rMandible.setPos(-2.3F, 2.5F, -2.55F);
        head.addChild(rMandible);
        setRotationAngle(rMandible, 0.2618F, 0.0F, 0.0F);
        rMandible.texOffs(50, 12).addBox(-1.45F, -2.45F, -1.95F, 3.0F, 5.0F, 2.0F, -0.1F, false);

        rFang = new ModelPart(this);
        rFang.setPos(0.0F, 2.25F, -1.25F);
        rMandible.addChild(rFang);
        setRotationAngle(rFang, -0.2618F, 0.0F, 0.0F);


        Box_r2 = new ModelPart(this);
        Box_r2.setPos(0.0F, 0.0F, 0.0F);
        rFang.addChild(Box_r2);
        setRotationAngle(Box_r2, 0.0F, 0.0F, -0.7854F);
        Box_r2.texOffs(49, 19).addBox(-0.2F, -0.6F, -0.3F, 1.0F, 1.0F, 3.0F, 0.0F, false);

        lLeg01a = new ModelPart(this);
        lLeg01a.setPos(2.5F, 1.0F, -6.3F);
        thorax.addChild(lLeg01a);
        setRotationAngle(lLeg01a, 0.4363F, 0.3054F, 0.903F);
        lLeg01a.texOffs(41, 42).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, true);

        lLeg01b = new ModelPart(this);
        lLeg01b.setPos(0.3F, -5.6F, 0.0F);
        lLeg01a.addChild(lLeg01b);
        setRotationAngle(lLeg01b, -0.3054F, 0.0F, -0.5236F);
        lLeg01b.texOffs(42, 26).addBox(-0.5F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F, -0.01F, true);

        lLeg01Fur02_r1 = new ModelPart(this);
        lLeg01Fur02_r1.setPos(0.0F, 0.0F, 0.0F);
        lLeg01b.addChild(lLeg01Fur02_r1);
        setRotationAngle(lLeg01Fur02_r1, 0.7854F, 0.0F, 0.0F);
        lLeg01Fur02_r1.texOffs(0, 47).addBox(-1.0F, -3.0F, 0.0F, 10.0F, 6.0F, 0.0F, 0.0F, false);

        lLeg01Fur01_r1 = new ModelPart(this);
        lLeg01Fur01_r1.setPos(0.0F, 0.0F, 0.0F);
        lLeg01b.addChild(lLeg01Fur01_r1);
        setRotationAngle(lLeg01Fur01_r1, -0.7854F, 0.0F, 0.0F);
        lLeg01Fur01_r1.texOffs(0, 40).addBox(-1.0F, -3.0F, 0.0F, 10.0F, 6.0F, 0.0F, 0.0F, false);

        lLeg01c = new ModelPart(this);
        lLeg01c.setPos(7.7F, -0.2F, 0.0F);
        lLeg01b.addChild(lLeg01c);
        setRotationAngle(lLeg01c, 0.0F, -0.2618F, 0.7741F);
        lLeg01c.texOffs(43, 32).addBox(0.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, 0.0F, true);

        lLeg01Fur04_r1 = new ModelPart(this);
        lLeg01Fur04_r1.setPos(0.0F, 0.0F, 0.0F);
        lLeg01c.addChild(lLeg01Fur04_r1);
        setRotationAngle(lLeg01Fur04_r1, 0.7854F, 0.0F, 0.0F);
        lLeg01Fur04_r1.texOffs(21, 46).addBox(-1.0F, -2.25F, 0.0F, 9.0F, 5.0F, 0.0F, 0.0F, false);

        lLeg01Fur03_r1 = new ModelPart(this);
        lLeg01Fur03_r1.setPos(0.0F, 0.0F, 0.0F);
        lLeg01c.addChild(lLeg01Fur03_r1);
        setRotationAngle(lLeg01Fur03_r1, -0.7854F, 0.0F, 0.0F);
        lLeg01Fur03_r1.texOffs(21, 40).addBox(-1.0F, -2.25F, 0.0F, 9.0F, 5.0F, 0.0F, 0.0F, false);

        lLeg01d = new ModelPart(this);
        lLeg01d.setPos(6.7F, 0.0F, 0.0F);
        lLeg01c.addChild(lLeg01d);
        setRotationAngle(lLeg01d, 0.0F, 0.0F, -0.3054F);
        lLeg01d.texOffs(49, 38).addBox(-0.55F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, -0.2F, true);

        rLeg01a = new ModelPart(this);
        rLeg01a.setPos(-2.5F, 1.0F, -6.3F);
        thorax.addChild(rLeg01a);
        setRotationAngle(rLeg01a, 0.4363F, -0.3054F, -0.903F);
        rLeg01a.texOffs(41, 42).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

        rLeg01b = new ModelPart(this);
        rLeg01b.setPos(-0.3F, -5.6F, 0.0F);
        rLeg01a.addChild(rLeg01b);
        setRotationAngle(rLeg01b, -0.3054F, 0.0F, 0.5236F);
        rLeg01b.texOffs(42, 26).addBox(-8.5F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F, -0.01F, false);

        lLeg01Fur02_r2 = new ModelPart(this);
        lLeg01Fur02_r2.setPos(0.0F, 0.0F, 0.0F);
        rLeg01b.addChild(lLeg01Fur02_r2);
        setRotationAngle(lLeg01Fur02_r2, 0.7854F, 0.0F, 0.0F);
        lLeg01Fur02_r2.texOffs(0, 47).addBox(-9.0F, -3.0F, 0.0F, 10.0F, 6.0F, 0.0F, 0.0F, true);

        lLeg01Fur01_r2 = new ModelPart(this);
        lLeg01Fur01_r2.setPos(0.0F, 0.0F, 0.0F);
        rLeg01b.addChild(lLeg01Fur01_r2);
        setRotationAngle(lLeg01Fur01_r2, -0.7854F, 0.0F, 0.0F);
        lLeg01Fur01_r2.texOffs(0, 40).addBox(-9.0F, -3.0F, 0.0F, 10.0F, 6.0F, 0.0F, 0.0F, true);

        rLeg01c = new ModelPart(this);
        rLeg01c.setPos(-7.7F, -0.2F, 0.0F);
        rLeg01b.addChild(rLeg01c);
        setRotationAngle(rLeg01c, 0.0F, 0.2618F, -0.7741F);
        rLeg01c.texOffs(43, 32).addBox(-7.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, 0.0F, false);

        lLeg01Fur04_r2 = new ModelPart(this);
        lLeg01Fur04_r2.setPos(0.0F, 0.0F, 0.0F);
        rLeg01c.addChild(lLeg01Fur04_r2);
        setRotationAngle(lLeg01Fur04_r2, 0.7854F, 0.0F, 0.0F);
        lLeg01Fur04_r2.texOffs(21, 46).addBox(-8.0F, -2.25F, 0.0F, 9.0F, 5.0F, 0.0F, 0.0F, true);

        lLeg01Fur03_r2 = new ModelPart(this);
        lLeg01Fur03_r2.setPos(0.0F, 0.0F, 0.0F);
        rLeg01c.addChild(lLeg01Fur03_r2);
        setRotationAngle(lLeg01Fur03_r2, -0.7854F, 0.0F, 0.0F);
        lLeg01Fur03_r2.texOffs(21, 40).addBox(-8.0F, -2.25F, 0.0F, 9.0F, 5.0F, 0.0F, 0.0F, true);

        rLeg01d = new ModelPart(this);
        rLeg01d.setPos(-6.7F, 0.0F, 0.0F);
        rLeg01c.addChild(rLeg01d);
        setRotationAngle(rLeg01d, 0.0F, 0.0F, 0.3054F);
        rLeg01d.texOffs(49, 38).addBox(-4.45F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, -0.2F, false);

        lLeg02a = new ModelPart(this);
        lLeg02a.setPos(2.5F, 1.0F, -5.3F);
        thorax.addChild(lLeg02a);
        setRotationAngle(lLeg02a, 0.0873F, 0.0F, 0.7721F);
        lLeg02a.texOffs(41, 42).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, true);

        lLeg02b = new ModelPart(this);
        lLeg02b.setPos(0.3F, -5.6F, 0.0F);
        lLeg02a.addChild(lLeg02b);
        setRotationAngle(lLeg02b, -0.1309F, 0.0436F, -0.3927F);
        lLeg02b.texOffs(42, 26).addBox(-0.5F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F, -0.01F, true);

        lLeg02Fur02_r1 = new ModelPart(this);
        lLeg02Fur02_r1.setPos(0.0F, 0.0F, 0.0F);
        lLeg02b.addChild(lLeg02Fur02_r1);
        setRotationAngle(lLeg02Fur02_r1, 0.7854F, 0.0F, 0.0F);
        lLeg02Fur02_r1.texOffs(0, 47).addBox(-1.0F, -3.0F, 0.0F, 10.0F, 6.0F, 0.0F, 0.0F, false);

        lLeg02Fur01_r1 = new ModelPart(this);
        lLeg02Fur01_r1.setPos(0.0F, 0.0F, 0.0F);
        lLeg02b.addChild(lLeg02Fur01_r1);
        setRotationAngle(lLeg02Fur01_r1, -0.7854F, 0.0F, 0.0F);
        lLeg02Fur01_r1.texOffs(0, 40).addBox(-1.0F, -3.0F, 0.0F, 10.0F, 6.0F, 0.0F, 0.0F, false);

        lLeg02c = new ModelPart(this);
        lLeg02c.setPos(7.7F, -0.2F, 0.0F);
        lLeg02b.addChild(lLeg02c);
        setRotationAngle(lLeg02c, 0.0F, -0.0436F, 0.7741F);
        lLeg02c.texOffs(43, 32).addBox(0.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, 0.0F, true);

        lLeg02Fur04_r1 = new ModelPart(this);
        lLeg02Fur04_r1.setPos(0.0F, 0.0F, 0.0F);
        lLeg02c.addChild(lLeg02Fur04_r1);
        setRotationAngle(lLeg02Fur04_r1, 0.7854F, 0.0F, 0.0F);
        lLeg02Fur04_r1.texOffs(21, 46).addBox(-1.0F, -2.25F, 0.0F, 9.0F, 5.0F, 0.0F, 0.0F, false);

        lLeg02Fur03_r1 = new ModelPart(this);
        lLeg02Fur03_r1.setPos(0.0F, 0.0F, 0.0F);
        lLeg02c.addChild(lLeg02Fur03_r1);
        setRotationAngle(lLeg02Fur03_r1, -0.7854F, 0.0F, 0.0F);
        lLeg02Fur03_r1.texOffs(21, 40).addBox(-1.0F, -2.25F, 0.0F, 9.0F, 5.0F, 0.0F, 0.0F, false);

        lLeg02d = new ModelPart(this);
        lLeg02d.setPos(6.7F, 0.0F, 0.0F);
        lLeg02c.addChild(lLeg02d);
        setRotationAngle(lLeg02d, 0.0F, 0.0F, -0.3054F);
        lLeg02d.texOffs(49, 38).addBox(-0.55F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, -0.2F, true);

        rLeg02a = new ModelPart(this);
        rLeg02a.setPos(-2.5F, 1.0F, -5.3F);
        thorax.addChild(rLeg02a);
        setRotationAngle(rLeg02a, 0.0873F, 0.0F, -0.7721F);
        rLeg02a.texOffs(41, 42).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

        rLeg02b = new ModelPart(this);
        rLeg02b.setPos(-0.3F, -5.6F, 0.0F);
        rLeg02a.addChild(rLeg02b);
        setRotationAngle(rLeg02b, -0.1309F, -0.0436F, 0.3927F);
        rLeg02b.texOffs(42, 26).addBox(-8.5F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F, -0.01F, false);

        lLeg0Fur02_r1 = new ModelPart(this);
        lLeg0Fur02_r1.setPos(0.0F, 0.0F, 0.0F);
        rLeg02b.addChild(lLeg0Fur02_r1);
        setRotationAngle(lLeg0Fur02_r1, 0.7854F, 0.0F, 0.0F);
        lLeg0Fur02_r1.texOffs(0, 47).addBox(-9.0F, -3.0F, 0.0F, 10.0F, 6.0F, 0.0F, 0.0F, true);

        lLeg02Fur01_r2 = new ModelPart(this);
        lLeg02Fur01_r2.setPos(0.0F, 0.0F, 0.0F);
        rLeg02b.addChild(lLeg02Fur01_r2);
        setRotationAngle(lLeg02Fur01_r2, -0.7854F, 0.0F, 0.0F);
        lLeg02Fur01_r2.texOffs(0, 40).addBox(-9.0F, -3.0F, 0.0F, 10.0F, 6.0F, 0.0F, 0.0F, true);

        rLeg02c = new ModelPart(this);
        rLeg02c.setPos(-7.7F, -0.2F, 0.0F);
        rLeg02b.addChild(rLeg02c);
        setRotationAngle(rLeg02c, 0.0F, 0.0436F, -0.7741F);
        rLeg02c.texOffs(43, 32).addBox(-7.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, 0.0F, false);

        lLeg02Fur04_r2 = new ModelPart(this);
        lLeg02Fur04_r2.setPos(0.0F, 0.0F, 0.0F);
        rLeg02c.addChild(lLeg02Fur04_r2);
        setRotationAngle(lLeg02Fur04_r2, 0.7854F, 0.0F, 0.0F);
        lLeg02Fur04_r2.texOffs(21, 46).addBox(-8.0F, -2.25F, 0.0F, 9.0F, 5.0F, 0.0F, 0.0F, true);

        lLeg02Fur03_r2 = new ModelPart(this);
        lLeg02Fur03_r2.setPos(0.0F, 0.0F, 0.0F);
        rLeg02c.addChild(lLeg02Fur03_r2);
        setRotationAngle(lLeg02Fur03_r2, -0.7854F, 0.0F, 0.0F);
        lLeg02Fur03_r2.texOffs(21, 40).addBox(-8.0F, -2.25F, 0.0F, 9.0F, 5.0F, 0.0F, 0.0F, true);

        rLeg02d = new ModelPart(this);
        rLeg02d.setPos(-6.7F, 0.0F, 0.0F);
        rLeg02c.addChild(rLeg02d);
        setRotationAngle(rLeg02d, 0.0F, 0.0F, 0.3054F);
        rLeg02d.texOffs(49, 38).addBox(-4.45F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, -0.2F, false);

        lLeg03a = new ModelPart(this);
        lLeg03a.setPos(2.5F, 1.0F, -3.3F);
        thorax.addChild(lLeg03a);
        setRotationAngle(lLeg03a, -0.0436F, 0.0F, 0.7721F);
        lLeg03a.texOffs(41, 42).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, true);

        lLeg03b = new ModelPart(this);
        lLeg03b.setPos(0.3F, -5.6F, 0.0F);
        lLeg03a.addChild(lLeg03b);
        setRotationAngle(lLeg03b, -0.0436F, -0.1745F, -0.3927F);
        lLeg03b.texOffs(42, 26).addBox(-0.5F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F, -0.01F, true);

        lLeg03Fur02_r1 = new ModelPart(this);
        lLeg03Fur02_r1.setPos(0.0F, 0.0F, 0.0F);
        lLeg03b.addChild(lLeg03Fur02_r1);
        setRotationAngle(lLeg03Fur02_r1, 0.7854F, 0.0F, 0.0F);
        lLeg03Fur02_r1.texOffs(0, 47).addBox(-1.0F, -3.0F, 0.0F, 10.0F, 6.0F, 0.0F, 0.0F, false);

        lLeg03Fur01_r1 = new ModelPart(this);
        lLeg03Fur01_r1.setPos(0.0F, 0.0F, 0.0F);
        lLeg03b.addChild(lLeg03Fur01_r1);
        setRotationAngle(lLeg03Fur01_r1, -0.7854F, 0.0F, 0.0F);
        lLeg03Fur01_r1.texOffs(0, 40).addBox(-1.0F, -3.0F, 0.0F, 10.0F, 6.0F, 0.0F, 0.0F, false);

        lLeg03c = new ModelPart(this);
        lLeg03c.setPos(7.7F, -0.2F, 0.0F);
        lLeg03b.addChild(lLeg03c);
        setRotationAngle(lLeg03c, 0.0F, -0.0436F, 0.7741F);
        lLeg03c.texOffs(43, 32).addBox(0.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, 0.0F, true);

        lLeg03Fur04_r1 = new ModelPart(this);
        lLeg03Fur04_r1.setPos(0.0F, 0.0F, 0.0F);
        lLeg03c.addChild(lLeg03Fur04_r1);
        setRotationAngle(lLeg03Fur04_r1, 0.7854F, 0.0F, 0.0F);
        lLeg03Fur04_r1.texOffs(21, 46).addBox(-1.0F, -2.25F, 0.0F, 9.0F, 5.0F, 0.0F, 0.0F, false);

        lLeg03Fur03_r1 = new ModelPart(this);
        lLeg03Fur03_r1.setPos(0.0F, 0.0F, 0.0F);
        lLeg03c.addChild(lLeg03Fur03_r1);
        setRotationAngle(lLeg03Fur03_r1, -0.7854F, 0.0F, 0.0F);
        lLeg03Fur03_r1.texOffs(21, 40).addBox(-1.0F, -2.25F, 0.0F, 9.0F, 5.0F, 0.0F, 0.0F, false);

        lLeg03d = new ModelPart(this);
        lLeg03d.setPos(6.7F, 0.0F, 0.0F);
        lLeg03c.addChild(lLeg03d);
        setRotationAngle(lLeg03d, 0.0F, 0.0F, -0.3054F);
        lLeg03d.texOffs(49, 38).addBox(-0.55F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, -0.2F, true);

        rLeg03a = new ModelPart(this);
        rLeg03a.setPos(-2.5F, 1.0F, -3.3F);
        thorax.addChild(rLeg03a);
        setRotationAngle(rLeg03a, -0.0436F, 0.0F, -0.7721F);
        rLeg03a.texOffs(41, 42).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

        rLeg03b = new ModelPart(this);
        rLeg03b.setPos(-0.3F, -5.6F, 0.0F);
        rLeg03a.addChild(rLeg03b);
        setRotationAngle(rLeg03b, -0.0436F, 0.1745F, 0.3927F);
        rLeg03b.texOffs(42, 26).addBox(-8.5F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F, -0.01F, false);

        lLeg03Fur02_r2 = new ModelPart(this);
        lLeg03Fur02_r2.setPos(0.0F, 0.0F, 0.0F);
        rLeg03b.addChild(lLeg03Fur02_r2);
        setRotationAngle(lLeg03Fur02_r2, 0.7854F, 0.0F, 0.0F);
        lLeg03Fur02_r2.texOffs(0, 47).addBox(-9.0F, -3.0F, 0.0F, 10.0F, 6.0F, 0.0F, 0.0F, true);

        lLeg03Fur01_r2 = new ModelPart(this);
        lLeg03Fur01_r2.setPos(0.0F, 0.0F, 0.0F);
        rLeg03b.addChild(lLeg03Fur01_r2);
        setRotationAngle(lLeg03Fur01_r2, -0.7854F, 0.0F, 0.0F);
        lLeg03Fur01_r2.texOffs(0, 40).addBox(-9.0F, -3.0F, 0.0F, 10.0F, 6.0F, 0.0F, 0.0F, true);

        rLeg03c = new ModelPart(this);
        rLeg03c.setPos(-7.7F, -0.2F, 0.0F);
        rLeg03b.addChild(rLeg03c);
        setRotationAngle(rLeg03c, 0.0F, 0.0436F, -0.7741F);
        rLeg03c.texOffs(43, 32).addBox(-7.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, 0.0F, false);

        lLeg03Fur04_r2 = new ModelPart(this);
        lLeg03Fur04_r2.setPos(0.0F, 0.0F, 0.0F);
        rLeg03c.addChild(lLeg03Fur04_r2);
        setRotationAngle(lLeg03Fur04_r2, 0.7854F, 0.0F, 0.0F);
        lLeg03Fur04_r2.texOffs(21, 46).addBox(-8.0F, -2.25F, 0.0F, 9.0F, 5.0F, 0.0F, 0.0F, true);

        lLeg03Fur03_r2 = new ModelPart(this);
        lLeg03Fur03_r2.setPos(0.0F, 0.0F, 0.0F);
        rLeg03c.addChild(lLeg03Fur03_r2);
        setRotationAngle(lLeg03Fur03_r2, -0.7854F, 0.0F, 0.0F);
        lLeg03Fur03_r2.texOffs(21, 40).addBox(-8.0F, -2.25F, 0.0F, 9.0F, 5.0F, 0.0F, 0.0F, true);

        rLeg03d = new ModelPart(this);
        rLeg03d.setPos(-6.7F, 0.0F, 0.0F);
        rLeg03c.addChild(rLeg03d);
        setRotationAngle(rLeg03d, 0.0F, 0.0F, 0.3054F);
        rLeg03d.texOffs(49, 38).addBox(-4.45F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, -0.2F, false);

        lLeg04a = new ModelPart(this);
        lLeg04a.setPos(2.5F, 1.0F, -1.8F);
        thorax.addChild(lLeg04a);
        setRotationAngle(lLeg04a, -0.3491F, -0.3054F, 0.7721F);
        lLeg04a.texOffs(41, 42).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, true);

        lLeg04b = new ModelPart(this);
        lLeg04b.setPos(0.3F, -5.6F, 0.0F);
        lLeg04a.addChild(lLeg04b);
        setRotationAngle(lLeg04b, 0.0F, 0.0436F, -0.3491F);
        lLeg04b.texOffs(42, 26).addBox(-0.5F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F, -0.01F, true);

        lLeg04Fur02_r1 = new ModelPart(this);
        lLeg04Fur02_r1.setPos(0.0F, 0.0F, 0.0F);
        lLeg04b.addChild(lLeg04Fur02_r1);
        setRotationAngle(lLeg04Fur02_r1, 0.7854F, 0.0F, 0.0F);
        lLeg04Fur02_r1.texOffs(0, 47).addBox(-1.0F, -3.0F, 0.0F, 10.0F, 6.0F, 0.0F, 0.0F, false);

        lLeg04Fur01_r1 = new ModelPart(this);
        lLeg04Fur01_r1.setPos(0.0F, 0.0F, 0.0F);
        lLeg04b.addChild(lLeg04Fur01_r1);
        setRotationAngle(lLeg04Fur01_r1, -0.7854F, 0.0F, 0.0F);
        lLeg04Fur01_r1.texOffs(0, 40).addBox(-1.0F, -3.0F, 0.0F, 10.0F, 6.0F, 0.0F, 0.0F, false);

        lLeg04c = new ModelPart(this);
        lLeg04c.setPos(7.7F, -0.2F, 0.0F);
        lLeg04b.addChild(lLeg04c);
        setRotationAngle(lLeg04c, 0.0F, -0.0436F, 0.7741F);
        lLeg04c.texOffs(43, 32).addBox(0.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, 0.0F, true);

        lLeg04Fur04_r1 = new ModelPart(this);
        lLeg04Fur04_r1.setPos(0.0F, 0.0F, 0.0F);
        lLeg04c.addChild(lLeg04Fur04_r1);
        setRotationAngle(lLeg04Fur04_r1, 0.7854F, 0.0F, 0.0F);
        lLeg04Fur04_r1.texOffs(21, 46).addBox(-1.0F, -2.25F, 0.0F, 9.0F, 5.0F, 0.0F, 0.0F, false);

        lLeg04Fur03_r1 = new ModelPart(this);
        lLeg04Fur03_r1.setPos(0.0F, 0.0F, 0.0F);
        lLeg04c.addChild(lLeg04Fur03_r1);
        setRotationAngle(lLeg04Fur03_r1, -0.7854F, 0.0F, 0.0F);
        lLeg04Fur03_r1.texOffs(21, 40).addBox(-1.0F, -2.25F, 0.0F, 9.0F, 5.0F, 0.0F, 0.0F, false);

        lLeg04d = new ModelPart(this);
        lLeg04d.setPos(6.7F, 0.0F, 0.0F);
        lLeg04c.addChild(lLeg04d);
        setRotationAngle(lLeg04d, 0.0F, 0.0F, -0.3054F);
        lLeg04d.texOffs(49, 38).addBox(-0.55F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, -0.2F, true);

        rLeg04a = new ModelPart(this);
        rLeg04a.setPos(-2.5F, 1.0F, -1.8F);
        thorax.addChild(rLeg04a);
        setRotationAngle(rLeg04a, -0.3491F, 0.3054F, -0.7721F);
        rLeg04a.texOffs(41, 42).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

        rLeg04b = new ModelPart(this);
        rLeg04b.setPos(-0.3F, -5.6F, 0.0F);
        rLeg04a.addChild(rLeg04b);
        setRotationAngle(rLeg04b, 0.0F, -0.0436F, 0.3491F);
        rLeg04b.texOffs(42, 26).addBox(-8.5F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F, -0.01F, false);

        lLeg04Fur02_r2 = new ModelPart(this);
        lLeg04Fur02_r2.setPos(0.0F, 0.0F, 0.0F);
        rLeg04b.addChild(lLeg04Fur02_r2);
        setRotationAngle(lLeg04Fur02_r2, 0.7854F, 0.0F, 0.0F);
        lLeg04Fur02_r2.texOffs(0, 47).addBox(-9.0F, -3.0F, 0.0F, 10.0F, 6.0F, 0.0F, 0.0F, true);

        lLeg04Fur01_r2 = new ModelPart(this);
        lLeg04Fur01_r2.setPos(0.0F, 0.0F, 0.0F);
        rLeg04b.addChild(lLeg04Fur01_r2);
        setRotationAngle(lLeg04Fur01_r2, -0.7854F, 0.0F, 0.0F);
        lLeg04Fur01_r2.texOffs(0, 40).addBox(-9.0F, -3.0F, 0.0F, 10.0F, 6.0F, 0.0F, 0.0F, true);

        rLeg04c = new ModelPart(this);
        rLeg04c.setPos(-7.7F, -0.2F, 0.0F);
        rLeg04b.addChild(rLeg04c);
        setRotationAngle(rLeg04c, 0.0F, 0.0436F, -0.7741F);
        rLeg04c.texOffs(43, 32).addBox(-7.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, 0.0F, false);

        lLeg04Fur04_r2 = new ModelPart(this);
        lLeg04Fur04_r2.setPos(0.0F, 0.0F, 0.0F);
        rLeg04c.addChild(lLeg04Fur04_r2);
        setRotationAngle(lLeg04Fur04_r2, 0.7854F, 0.0F, 0.0F);
        lLeg04Fur04_r2.texOffs(21, 46).addBox(-8.0F, -2.25F, 0.0F, 9.0F, 5.0F, 0.0F, 0.0F, true);

        lLeg04Fur03_r2 = new ModelPart(this);
        lLeg04Fur03_r2.setPos(0.0F, 0.0F, 0.0F);
        rLeg04c.addChild(lLeg04Fur03_r2);
        setRotationAngle(lLeg04Fur03_r2, -0.7854F, 0.0F, 0.0F);
        lLeg04Fur03_r2.texOffs(21, 40).addBox(-8.0F, -2.25F, 0.0F, 9.0F, 5.0F, 0.0F, 0.0F, true);

        rLeg04d = new ModelPart(this);
        rLeg04d.setPos(-6.7F, 0.0F, 0.0F);
        rLeg04c.addChild(rLeg04d);
        setRotationAngle(rLeg04d, 0.0F, 0.0F, 0.3054F);
        rLeg04d.texOffs(49, 38).addBox(-4.45F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, -0.2F, false);

        lPedipalp01 = new ModelPart(this);
        lPedipalp01.setPos(3.05F, 1.3F, -7.6F);
        thorax.addChild(lPedipalp01);
        setRotationAngle(lPedipalp01, -0.1367F, -0.3491F, 0.0F);
        lPedipalp01.texOffs(29, 20).addBox(-1.0F, -1.0F, -5.0F, 2.0F, 2.0F, 5.0F, 0.0F, true);

        lPedipalp02 = new ModelPart(this);
        lPedipalp02.setPos(-0.05F, -0.4F, -4.15F);
        lPedipalp01.addChild(lPedipalp02);
        setRotationAngle(lPedipalp02, 0.9948F, 0.0F, 0.0F);
        lPedipalp02.texOffs(30, 13).addBox(-0.94F, -1.0F, -4.05F, 2.0F, 2.0F, 4.0F, 0.0F, true);

        lPedipalp03 = new ModelPart(this);
        lPedipalp03.setPos(0.05F, 0.0F, -4.55F);
        lPedipalp02.addChild(lPedipalp03);
        setRotationAngle(lPedipalp03, 0.7418F, 0.0F, 0.0F);
        lPedipalp03.texOffs(28, 11).addBox(-1.0F, -0.5F, -5.0F, 2.0F, 2.0F, 6.0F, 0.0F, false);

        rPedipalp01 = new ModelPart(this);
        rPedipalp01.setPos(-3.05F, 1.3F, -7.6F);
        thorax.addChild(rPedipalp01);
        setRotationAngle(rPedipalp01, -0.1367F, 0.3491F, 0.0F);
        rPedipalp01.texOffs(29, 20).addBox(-1.0F, -1.0F, -5.0F, 2.0F, 2.0F, 5.0F, 0.0F, false);

        rPedipalp02 = new ModelPart(this);
        rPedipalp02.setPos(0.05F, -0.4F, -4.15F);
        rPedipalp01.addChild(rPedipalp02);
        setRotationAngle(rPedipalp02, 0.9948F, 0.0F, 0.0F);
        rPedipalp02.texOffs(30, 13).addBox(-1.06F, -1.0F, -4.05F, 2.0F, 2.0F, 4.0F, 0.0F, false);

        rPedipalp03 = new ModelPart(this);
        rPedipalp03.setPos(-0.05F, 0.0F, -4.55F);
        rPedipalp02.addChild(rPedipalp03);
        setRotationAngle(rPedipalp03, 0.7418F, 0.0F, 0.0F);
        rPedipalp03.texOffs(28, 11).addBox(-1.0F, -0.5F, -5.0F, 2.0F, 2.0F, 6.0F, 0.0F, true);
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
