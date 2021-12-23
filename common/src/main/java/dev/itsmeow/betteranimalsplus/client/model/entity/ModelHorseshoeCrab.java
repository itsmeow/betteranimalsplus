package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;

public class ModelHorseshoeCrab<T extends LivingEntity> extends ModelBAP<T> {

    public ModelPart head;
    public ModelPart lowerBody;
    public ModelPart spine;
    public ModelPart cube_r1;
    public ModelPart tail;
    public ModelPart lSpinePlate;
    public ModelPart cube_r2;
    public ModelPart rSpinePlate;
    public ModelPart cube_r3;
    public ModelPart lRidge;
    public ModelPart cube_r4;
    public ModelPart rRidge;
    public ModelPart cube_r5;
    public ModelPart lLeg01;
    public ModelPart cube_r6;
    public ModelPart lLeg02;
    public ModelPart cube_r7;
    public ModelPart lLeg03;
    public ModelPart cube_r8;
    public ModelPart lLeg04;
    public ModelPart cube_r9;
    public ModelPart lLeg05;
    public ModelPart cube_r10;
    public ModelPart rLeg05;
    public ModelPart cube_r11;
    public ModelPart rLeg04;
    public ModelPart cube_r12;
    public ModelPart rLeg03;
    public ModelPart cube_r13;
    public ModelPart rLeg02;
    public ModelPart cube_r14;
    public ModelPart rLeg01;
    public ModelPart cube_r15;

    public ModelHorseshoeCrab() {
        texWidth = 32;
        texHeight = 32;

        head = new ModelPart(this);
        head.setPos(0.0F, 24.0F, -4.0F);
        head.texOffs(0, 23).addBox(-3.5F, -2.0F, -3.0F, 7.0F, 2.0F, 7.0F, -0.1F, false);
        head.texOffs(2, 24).addBox(-2.5F, -2.5F, -2.75F, 5.0F, 1.0F, 6.0F, 0.0F, false);
        head.texOffs(0, 9).addBox(3.41F, -1.9F, -2.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        head.texOffs(0, 9).addBox(-3.41F, -1.9F, -2.0F, 0.0F, 1.0F, 2.0F, 0.0F, true);

        lowerBody = new ModelPart(this);
        lowerBody.setPos(0.0F, -1.0F, 4.0F);
        head.addChild(lowerBody);
        lowerBody.texOffs(12, 11).addBox(-3.0F, 0.0F, -0.5F, 6.0F, 1.0F, 4.0F, -0.2F, false);

        spine = new ModelPart(this);
        spine.setPos(0.0F, 0.0F, 2.0F);
        lowerBody.addChild(spine);


        cube_r1 = new ModelPart(this);
        cube_r1.setPos(0.0F, 0.0F, 0.0F);
        spine.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, 0.0F, 0.7854F);
        cube_r1.texOffs(20, 17).addBox(-1.0F, -1.0F, -2.25F, 2.0F, 2.0F, 4.0F, 0.0F, false);

        tail = new ModelPart(this);
        tail.setPos(0.0F, 0.25F, 3.25F);
        lowerBody.addChild(tail);
        tail.texOffs(0, 10).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);

        lSpinePlate = new ModelPart(this);
        lSpinePlate.setPos(-1.0F, -0.5F, 0.0F);
        lowerBody.addChild(lSpinePlate);
        setRotationAngle(lSpinePlate, -0.0873F, 0.0F, -0.2182F);


        cube_r2 = new ModelPart(this);
        cube_r2.setPos(0.0F, 0.0F, 0.0F);
        lSpinePlate.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, 0.2618F, 0.0F);
        cube_r2.texOffs(11, 0).addBox(-4.0F, 0.0F, -1.0F, 4.0F, 0.0F, 7.0F, 0.0F, false);

        rSpinePlate = new ModelPart(this);
        rSpinePlate.setPos(1.0F, -0.5F, 0.0F);
        lowerBody.addChild(rSpinePlate);
        setRotationAngle(rSpinePlate, -0.0873F, 0.0F, 0.2182F);


        cube_r3 = new ModelPart(this);
        cube_r3.setPos(0.0F, 0.0F, 0.0F);
        rSpinePlate.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.0F, -0.2618F, 0.0F);
        cube_r3.texOffs(11, 0).addBox(0.0F, 0.0F, -1.0F, 4.0F, 0.0F, 7.0F, 0.0F, true);

        lRidge = new ModelPart(this);
        lRidge.setPos(2.5F, -0.75F, 0.0F);
        head.addChild(lRidge);
        setRotationAngle(lRidge, 0.0F, 0.3491F, 0.0F);


        cube_r4 = new ModelPart(this);
        cube_r4.setPos(0.0F, 0.0F, 0.0F);
        lRidge.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.0F, 0.0F, 0.5672F);
        cube_r4.texOffs(0, 0).addBox(-1.5F, -0.75F, -2.5F, 4.0F, 1.0F, 9.0F, 0.0F, false);

        rRidge = new ModelPart(this);
        rRidge.setPos(-2.5F, -0.75F, 0.0F);
        head.addChild(rRidge);
        setRotationAngle(rRidge, 0.0F, -0.3491F, 0.0F);


        cube_r5 = new ModelPart(this);
        cube_r5.setPos(0.0F, 0.0F, 0.0F);
        rRidge.addChild(cube_r5);
        setRotationAngle(cube_r5, 0.0F, 0.0F, -0.5672F);
        cube_r5.texOffs(0, 0).addBox(-2.5F, -0.75F, -2.5F, 4.0F, 1.0F, 9.0F, 0.0F, true);

        lLeg01 = new ModelPart(this);
        lLeg01.setPos(1.0F, 0.0F, -1.0F);
        head.addChild(lLeg01);
        setRotationAngle(lLeg01, 0.0F, -0.7854F, 0.0F);


        cube_r6 = new ModelPart(this);
        cube_r6.setPos(0.0F, 0.0F, 0.0F);
        lLeg01.addChild(cube_r6);
        setRotationAngle(cube_r6, 0.2618F, 0.0F, 0.0F);
        cube_r6.texOffs(-3, 0).addBox(-0.5F, 0.0F, -3.75F, 1.0F, 0.0F, 4.0F, 0.0F, false);

        lLeg02 = new ModelPart(this);
        lLeg02.setPos(1.0F, 0.0F, -0.25F);
        head.addChild(lLeg02);
        setRotationAngle(lLeg02, 0.0F, -0.5672F, 0.0F);


        cube_r7 = new ModelPart(this);
        cube_r7.setPos(0.0F, 0.0F, 0.0F);
        lLeg02.addChild(cube_r7);
        setRotationAngle(cube_r7, 0.2618F, -0.5236F, 0.0F);
        cube_r7.texOffs(-3, 0).addBox(-0.5F, 0.0F, -3.75F, 1.0F, 0.0F, 4.0F, 0.0F, false);

        lLeg03 = new ModelPart(this);
        lLeg03.setPos(1.0F, 0.0F, 0.75F);
        head.addChild(lLeg03);
        setRotationAngle(lLeg03, 0.0F, -0.829F, 0.0F);


        cube_r8 = new ModelPart(this);
        cube_r8.setPos(0.0F, 0.0F, 0.0F);
        lLeg03.addChild(cube_r8);
        setRotationAngle(cube_r8, 0.2618F, -0.5236F, 0.0F);
        cube_r8.texOffs(-3, 0).addBox(-0.75F, 0.0F, -3.75F, 1.0F, 0.0F, 4.0F, 0.0F, false);

        lLeg04 = new ModelPart(this);
        lLeg04.setPos(1.0F, 0.0F, 1.25F);
        head.addChild(lLeg04);
        setRotationAngle(lLeg04, 0.0F, -1.2217F, 0.0F);


        cube_r9 = new ModelPart(this);
        cube_r9.setPos(0.0F, 0.0F, 0.0F);
        lLeg04.addChild(cube_r9);
        setRotationAngle(cube_r9, 0.2618F, -0.5236F, 0.0F);
        cube_r9.texOffs(-3, 0).addBox(-0.5F, 0.0F, -3.75F, 1.0F, 0.0F, 4.0F, 0.0F, false);

        lLeg05 = new ModelPart(this);
        lLeg05.setPos(1.0F, 0.0F, 2.0F);
        head.addChild(lLeg05);
        setRotationAngle(lLeg05, 0.0F, -1.5708F, 0.0F);


        cube_r10 = new ModelPart(this);
        cube_r10.setPos(0.0F, 0.0F, 0.0F);
        lLeg05.addChild(cube_r10);
        setRotationAngle(cube_r10, 0.2618F, -0.5236F, 0.0F);
        cube_r10.texOffs(-3, 0).addBox(-0.5F, 0.0F, -3.75F, 1.0F, 0.0F, 4.0F, 0.0F, false);

        rLeg05 = new ModelPart(this);
        rLeg05.setPos(-1.0F, 0.0F, 2.0F);
        head.addChild(rLeg05);
        setRotationAngle(rLeg05, 0.0F, 1.5708F, 0.0F);


        cube_r11 = new ModelPart(this);
        cube_r11.setPos(0.0F, 0.0F, 0.0F);
        rLeg05.addChild(cube_r11);
        setRotationAngle(cube_r11, 0.2618F, 0.5236F, 0.0F);
        cube_r11.texOffs(-3, 0).addBox(-0.5F, 0.0F, -3.75F, 1.0F, 0.0F, 4.0F, 0.0F, true);

        rLeg04 = new ModelPart(this);
        rLeg04.setPos(-1.0F, 0.0F, 1.25F);
        head.addChild(rLeg04);
        setRotationAngle(rLeg04, 0.0F, 1.2217F, 0.0F);


        cube_r12 = new ModelPart(this);
        cube_r12.setPos(0.0F, 0.0F, 0.0F);
        rLeg04.addChild(cube_r12);
        setRotationAngle(cube_r12, 0.2618F, 0.5236F, 0.0F);
        cube_r12.texOffs(-3, 0).addBox(-0.5F, 0.0F, -3.75F, 1.0F, 0.0F, 4.0F, 0.0F, true);

        rLeg03 = new ModelPart(this);
        rLeg03.setPos(-1.0F, 0.0F, 0.5F);
        head.addChild(rLeg03);
        setRotationAngle(rLeg03, 0.0F, 0.829F, 0.0F);


        cube_r13 = new ModelPart(this);
        cube_r13.setPos(0.0F, 0.0F, 0.0F);
        rLeg03.addChild(cube_r13);
        setRotationAngle(cube_r13, 0.2618F, 0.5236F, 0.0F);
        cube_r13.texOffs(-3, 0).addBox(-0.5F, 0.0F, -3.75F, 1.0F, 0.0F, 4.0F, 0.0F, true);

        rLeg02 = new ModelPart(this);
        rLeg02.setPos(-1.0F, 0.0F, -0.25F);
        head.addChild(rLeg02);
        setRotationAngle(rLeg02, 0.0F, 0.5672F, 0.0F);


        cube_r14 = new ModelPart(this);
        cube_r14.setPos(0.0F, 0.0F, 0.0F);
        rLeg02.addChild(cube_r14);
        setRotationAngle(cube_r14, 0.2618F, 0.5236F, 0.0F);
        cube_r14.texOffs(-3, 0).addBox(-0.5F, 0.0F, -3.75F, 1.0F, 0.0F, 4.0F, 0.0F, true);

        rLeg01 = new ModelPart(this);
        rLeg01.setPos(-1.0F, 0.0F, -1.0F);
        head.addChild(rLeg01);
        setRotationAngle(rLeg01, 0.0F, 0.7854F, 0.0F);


        cube_r15 = new ModelPart(this);
        cube_r15.setPos(0.0F, 0.0F, 0.0F);
        rLeg01.addChild(cube_r15);
        setRotationAngle(cube_r15, 0.2618F, 0.0F, 0.0F);
        cube_r15.texOffs(-3, 0).addBox(-0.5F, 0.0F, -3.75F, 1.0F, 0.0F, 4.0F, 0.0F, true);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.head.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T entity, float f, float f1, float f2, float f3, float f4) {
        this.tail.yRot = (float) Math.sin(f * 0.5F) * f1 * 0.5F;
    }

}
