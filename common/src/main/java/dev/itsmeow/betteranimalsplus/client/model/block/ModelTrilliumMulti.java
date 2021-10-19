package dev.itsmeow.betteranimalsplus.client.model.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import dev.itsmeow.imdlib.client.util.RenderUtil;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;

/**
 * trilliummulti - cybercat5555 Created using Tabula 5.1.0
 */
public class ModelTrilliumMulti<T extends Entity> extends EntityModel<T> {

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
    public ModelPart stem02_1;
    public ModelPart stem03_1;
    public ModelPart stem04_1;
    public ModelPart stem05_1;
    public ModelPart largeLeaf01a_1;
    public ModelPart largeLeaf02a_1;
    public ModelPart largeLeaf03a_1;
    public ModelPart largeLeaf01b_1;
    public ModelPart largeLeaf02b_1;
    public ModelPart largeLeaf03b_1;
    public ModelPart smallLeaf01a_1;
    public ModelPart smallLeaf02a_1;
    public ModelPart smallLeaf03a_1;
    public ModelPart petal01a_1;
    public ModelPart petal02a_1;
    public ModelPart petal03a_1;
    public ModelPart smallLeaf01b_1;
    public ModelPart smallLeaf02b_1;
    public ModelPart smallLeaf03b_1;
    public ModelPart petal01b_1;
    public ModelPart petal02b_1;
    public ModelPart petal03b_1;

    private float rotation = 0;

    public ModelTrilliumMulti() {
        this.texWidth = 64;
        this.texHeight = 32;
        this.smallLeaf02b = new ModelPart(this, 35, 9);
        this.smallLeaf02b.setPos(9.0F, 0.0F, 0.0F);
        this.smallLeaf02b.addBox(0.0F, 0.0F, -2.5F, 7, 0, 5, 0.0F);
        this.setRotateAngle(this.smallLeaf02b, 0.0F, 0.0F, 0.091106186954104F);
        this.petal02a = new ModelPart(this, 18, 19);
        this.petal02a.setPos(0.0F, -0.3F, 0.0F);
        this.petal02a.addBox(-2.5F, -5.6F, -0.7F, 5, 5, 0, 0.0F);
        this.setRotateAngle(this.petal02a, 0.6373942428283291F, 2.0943951023931953F, 0.0F);
        this.stem04_1 = new ModelPart(this, 0, 19);
        this.stem04_1.setPos(5.699999999999998F, 17.10000000000001F, 3.9000000000000017F);
        this.stem04_1.addBox(-1.0F, -1.7F, -1.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(this.stem04_1, 0.0F, 1.1220721761071544F, 0.091106186954104F);
        this.smallLeaf03a_1 = new ModelPart(this, 31, 0);
        this.smallLeaf03a_1.setPos(0.5F, -0.3F, 0.0F);
        this.smallLeaf03a_1.addBox(0.0F, 0.0F, -4.5F, 9, 0, 9, 0.0F);
        this.setRotateAngle(this.smallLeaf03a_1, 0.091106186954104F, -1.0471975511965976F, -0.091106186954104F);
        this.smallLeaf01b = new ModelPart(this, 35, 9);
        this.smallLeaf01b.setPos(9.0F, 0.0F, 0.0F);
        this.smallLeaf01b.addBox(0.0F, 0.0F, -2.5F, 7, 0, 5, 0.0F);
        this.setRotateAngle(this.smallLeaf01b, 0.0F, 0.0F, 0.091106186954104F);
        this.stem05_1 = new ModelPart(this, 0, 25);
        this.stem05_1.setPos(5.799999999999998F, 15.899999999999993F, 3.9000000000000017F);
        this.stem05_1.addBox(-1.0F, -1.0F, -1.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(this.stem05_1, 0.0F, 1.1220721761071544F, 0.091106186954104F);
        this.petal02a_1 = new ModelPart(this, 18, 19);
        this.petal02a_1.setPos(0.0F, -0.3F, 0.0F);
        this.petal02a_1.addBox(-2.5F, -5.6F, -0.7F, 5, 5, 0, 0.0F);
        this.setRotateAngle(this.petal02a_1, 0.6373942428283291F, 2.0943951023931953F, 0.0F);
        this.petal03a_1 = new ModelPart(this, 18, 19);
        this.petal03a_1.setPos(0.0F, -0.3F, 0.0F);
        this.petal03a_1.addBox(-2.5F, -5.6F, -0.7F, 5, 5, 0, 0.0F);
        this.setRotateAngle(this.petal03a_1, 0.6373942428283291F, -2.0943951023931953F, 0.0F);
        this.smallLeaf01b_1 = new ModelPart(this, 35, 9);
        this.smallLeaf01b_1.setPos(9.0F, 0.0F, 0.0F);
        this.smallLeaf01b_1.addBox(0.0F, 0.0F, -2.5F, 7, 0, 5, 0.0F);
        this.setRotateAngle(this.smallLeaf01b_1, 0.0F, 0.0F, 0.091106186954104F);
        this.petal03b_1 = new ModelPart(this, 19, 24);
        this.petal03b_1.setPos(0.0F, -5.6F, -0.7F);
        this.petal03b_1.addBox(-1.5F, -3.0F, 0.0F, 3, 3, 0, 0.0F);
        this.setRotateAngle(this.petal03b_1, -0.22759093446006054F, 0.0F, 0.0F);
        this.stem03 = new ModelPart(this, 0, 11);
        this.stem03.setPos(-2.300000000000001F, 19.4F, -5.099999999999999F);
        this.stem03.addBox(-0.5F, -6.1F, -0.5F, 1, 6, 1, 0.0F);
        this.largeLeaf02a = new ModelPart(this, 7, 0);
        this.largeLeaf02a.setPos(0.0F, -1.5F, 0.0F);
        this.largeLeaf02a.addBox(0.0F, 0.0F, -5.0F, 10, 0, 10, 0.0F);
        this.setRotateAngle(this.largeLeaf02a, -0.36425021489121656F, 2.0943951023931953F, -0.4553564018453205F);
        this.largeLeaf03a = new ModelPart(this, 7, 0);
        this.largeLeaf03a.setPos(0.0F, -1.5F, 0.0F);
        this.largeLeaf03a.addBox(0.0F, 0.0F, -5.0F, 10, 0, 10, 0.0F);
        this.setRotateAngle(this.largeLeaf03a, 0.36425021489121656F, -2.0943951023931953F, -0.4553564018453205F);
        this.smallLeaf02b_1 = new ModelPart(this, 35, 9);
        this.smallLeaf02b_1.setPos(9.0F, 0.0F, 0.0F);
        this.smallLeaf02b_1.addBox(0.0F, 0.0F, -2.5F, 7, 0, 5, 0.0F);
        this.setRotateAngle(this.smallLeaf02b_1, 0.0F, 0.0F, 0.091106186954104F);
        this.stem05 = new ModelPart(this, 0, 25);
        this.stem05.setPos(-2.3F, 12.0F, -5.1F);
        this.stem05.addBox(-1.0F, -1.0F, -1.0F, 2, 1, 2, 0.0F);
        this.largeLeaf02b = new ModelPart(this, 11, 10);
        this.largeLeaf02b.setPos(10.0F, 0.0F, 0.0F);
        this.largeLeaf02b.addBox(0.0F, 0.0F, -3.0F, 8, 0, 6, 0.0F);
        this.setRotateAngle(this.largeLeaf02b, 0.0F, 0.0F, 0.136659280431156F);
        this.smallLeaf03b = new ModelPart(this, 35, 9);
        this.smallLeaf03b.setPos(9.0F, 0.0F, 0.0F);
        this.smallLeaf03b.addBox(0.0F, 0.0F, -2.5F, 7, 0, 5, 0.0F);
        this.setRotateAngle(this.smallLeaf03b, 0.0F, 0.0F, 0.091106186954104F);
        this.stem02 = new ModelPart(this, 0, 5);
        this.stem02.setPos(-2.300000000000001F, 22.1F, -5.099999999999999F);
        this.stem02.addBox(-1.0F, -3.0F, -1.0F, 2, 3, 2, 0.0F);
        this.smallLeaf01a_1 = new ModelPart(this, 31, 0);
        this.smallLeaf01a_1.setPos(0.5F, -0.3F, 0.0F);
        this.smallLeaf01a_1.addBox(0.0F, 0.0F, -4.5F, 9, 0, 9, 0.0F);
        this.setRotateAngle(this.smallLeaf01a_1, 0.0F, 3.141592653589793F, 0.091106186954104F);
        this.smallLeaf03b_1 = new ModelPart(this, 35, 9);
        this.smallLeaf03b_1.setPos(9.0F, 0.0F, 0.0F);
        this.smallLeaf03b_1.addBox(0.0F, 0.0F, -2.5F, 7, 0, 5, 0.0F);
        this.setRotateAngle(this.smallLeaf03b_1, 0.0F, 0.0F, 0.091106186954104F);
        this.largeLeaf03b_1 = new ModelPart(this, 11, 10);
        this.largeLeaf03b_1.setPos(10.0F, 0.0F, 0.0F);
        this.largeLeaf03b_1.addBox(0.0F, 0.0F, -3.0F, 8, 0, 6, 0.0F);
        this.setRotateAngle(this.largeLeaf03b_1, 0.0F, 0.0F, 0.136659280431156F);
        this.largeLeaf03a_1 = new ModelPart(this, 7, 0);
        this.largeLeaf03a_1.setPos(0.0F, -1.5F, 0.0F);
        this.largeLeaf03a_1.addBox(0.0F, 0.0F, -5.0F, 10, 0, 10, 0.0F);
        this.setRotateAngle(this.largeLeaf03a_1, 0.36425021489121656F, -2.0943951023931953F, -0.4553564018453205F);
        this.largeLeaf01b = new ModelPart(this, 11, 10);
        this.largeLeaf01b.setPos(10.0F, 0.0F, 0.0F);
        this.largeLeaf01b.addBox(0.0F, 0.0F, -3.0F, 8, 0, 6, 0.0F);
        this.setRotateAngle(this.largeLeaf01b, 0.0F, 0.0F, 0.136659280431156F);
        this.largeLeaf01a = new ModelPart(this, 7, 0);
        this.largeLeaf01a.setPos(0.0F, -1.5F, 0.0F);
        this.largeLeaf01a.addBox(0.0F, 0.0F, -5.0F, 10, 0, 10, 0.0F);
        this.setRotateAngle(this.largeLeaf01a, 0.0F, 0.0F, 0.27314402793711257F);
        this.petal02b = new ModelPart(this, 19, 24);
        this.petal02b.setPos(0.0F, -5.6F, -0.7F);
        this.petal02b.addBox(-1.5F, -3.0F, 0.0F, 3, 3, 0, 0.0F);
        this.setRotateAngle(this.petal02b, -0.22759093446006054F, 0.0F, 0.0F);
        this.petal03b = new ModelPart(this, 19, 24);
        this.petal03b.setPos(0.0F, -5.6F, -0.7F);
        this.petal03b.addBox(-1.5F, -3.0F, 0.0F, 3, 3, 0, 0.0F);
        this.setRotateAngle(this.petal03b, -0.22759093446006054F, 0.0F, 0.0F);
        this.smallLeaf02a = new ModelPart(this, 31, 0);
        this.smallLeaf02a.setPos(0.5F, -0.3F, 0.0F);
        this.smallLeaf02a.addBox(0.0F, 0.0F, -4.5F, 9, 0, 9, 0.0F);
        this.setRotateAngle(this.smallLeaf02a, -0.091106186954104F, 1.0471975511965976F, -0.091106186954104F);
        this.smallLeaf02a_1 = new ModelPart(this, 31, 0);
        this.smallLeaf02a_1.setPos(0.5F, -0.3F, 0.0F);
        this.smallLeaf02a_1.addBox(0.0F, 0.0F, -4.5F, 9, 0, 9, 0.0F);
        this.setRotateAngle(this.smallLeaf02a_1, -0.091106186954104F, 1.0471975511965976F, -0.091106186954104F);
        this.stem04 = new ModelPart(this, 0, 19);
        this.stem04.setPos(-2.300000000000001F, 13.4F, -5.099999999999999F);
        this.stem04.addBox(-1.0F, -1.7F, -1.0F, 2, 2, 2, 0.0F);
        this.petal01a = new ModelPart(this, 18, 19);
        this.petal01a.setPos(0.0F, -0.3F, 0.0F);
        this.petal01a.addBox(-2.5F, -5.6F, -0.7F, 5, 5, 0, 0.0F);
        this.setRotateAngle(this.petal01a, 0.6373942428283291F, 0.0F, 0.0F);
        this.largeLeaf02b_1 = new ModelPart(this, 11, 10);
        this.largeLeaf02b_1.setPos(10.0F, 0.0F, 0.0F);
        this.largeLeaf02b_1.addBox(0.0F, 0.0F, -3.0F, 8, 0, 6, 0.0F);
        this.setRotateAngle(this.largeLeaf02b_1, 0.0F, 0.0F, 0.136659280431156F);
        this.stem01 = new ModelPart(this, 0, 0);
        this.stem01.setPos(-2.300000000000001F, 24.0F, -5.099999999999999F);
        this.stem01.addBox(-1.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
        this.largeLeaf03b = new ModelPart(this, 11, 10);
        this.largeLeaf03b.setPos(10.0F, 0.0F, 0.0F);
        this.largeLeaf03b.addBox(0.0F, 0.0F, -3.0F, 8, 0, 6, 0.0F);
        this.setRotateAngle(this.largeLeaf03b, 0.0F, 0.0F, 0.136659280431156F);
        this.largeLeaf01a_1 = new ModelPart(this, 7, 0);
        this.largeLeaf01a_1.setPos(0.0F, -1.5F, 0.0F);
        this.largeLeaf01a_1.addBox(0.0F, 0.0F, -5.0F, 10, 0, 10, 0.0F);
        this.setRotateAngle(this.largeLeaf01a_1, 0.0F, 0.0F, 0.27314402793711257F);
        this.petal01b = new ModelPart(this, 19, 24);
        this.petal01b.setPos(0.0F, -5.6F, -0.7F);
        this.petal01b.addBox(-1.5F, -3.0F, 0.0F, 3, 3, 0, 0.0F);
        this.setRotateAngle(this.petal01b, -0.22759093446006054F, 0.0F, 0.0F);
        this.stem02_1 = new ModelPart(this, 0, 5);
        this.stem02_1.setPos(5.0F, 24.300000000000015F, 3.9000000000000017F);
        this.stem02_1.addBox(-1.0F, -3.0F, -1.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(this.stem02_1, 0.0F, 1.1220721761071544F, 0.091106186954104F);
        this.smallLeaf01a = new ModelPart(this, 31, 0);
        this.smallLeaf01a.setPos(0.5F, -0.1F, 0.0F);
        this.smallLeaf01a.addBox(0.0F, 0.0F, -4.5F, 9, 0, 9, 0.0F);
        this.setRotateAngle(this.smallLeaf01a, 0.0F, 3.141592653589793F, 0.091106186954104F);
        this.stem03_1 = new ModelPart(this, 0, 11);
        this.stem03_1.setPos(5.199999999999999F, 22.200000000000014F, 3.9000000000000017F);
        this.stem03_1.addBox(-0.5F, -6.1F, -0.5F, 1, 6, 1, 0.0F);
        this.setRotateAngle(this.stem03_1, 0.0F, 1.1220721761071544F, 0.091106186954104F);
        this.smallLeaf03a = new ModelPart(this, 31, 0);
        this.smallLeaf03a.setPos(0.5F, -0.3F, 0.0F);
        this.smallLeaf03a.addBox(0.0F, 0.0F, -4.5F, 9, 0, 9, 0.0F);
        this.setRotateAngle(this.smallLeaf03a, 0.091106186954104F, -1.0471975511965976F, -0.091106186954104F);
        this.petal02b_1 = new ModelPart(this, 19, 24);
        this.petal02b_1.setPos(0.0F, -5.6F, -0.7F);
        this.petal02b_1.addBox(-1.5F, -3.0F, 0.0F, 3, 3, 0, 0.0F);
        this.setRotateAngle(this.petal02b_1, -0.22759093446006054F, 0.0F, 0.0F);
        this.petal01a_1 = new ModelPart(this, 18, 19);
        this.petal01a_1.setPos(0.0F, -0.3F, 0.0F);
        this.petal01a_1.addBox(-2.5F, -5.6F, -0.7F, 5, 5, 0, 0.0F);
        this.setRotateAngle(this.petal01a_1, 0.6373942428283291F, 0.0F, 0.0F);
        this.largeLeaf02a_1 = new ModelPart(this, 7, 0);
        this.largeLeaf02a_1.setPos(0.0F, -1.5F, 0.0F);
        this.largeLeaf02a_1.addBox(0.0F, 0.0F, -5.0F, 10, 0, 10, 0.0F);
        this.setRotateAngle(this.largeLeaf02a_1, -0.36425021489121656F, 2.0943951023931953F, -0.4553564018453205F);
        this.largeLeaf01b_1 = new ModelPart(this, 11, 10);
        this.largeLeaf01b_1.setPos(10.0F, 0.0F, 0.0F);
        this.largeLeaf01b_1.addBox(0.0F, 0.0F, -3.0F, 8, 0, 6, 0.0F);
        this.setRotateAngle(this.largeLeaf01b_1, 0.0F, 0.0F, 0.136659280431156F);
        this.petal01b_1 = new ModelPart(this, 19, 24);
        this.petal01b_1.setPos(0.0F, -5.6F, -0.7F);
        this.petal01b_1.addBox(-1.5F, -3.0F, 0.0F, 3, 3, 0, 0.0F);
        this.setRotateAngle(this.petal01b_1, -0.22759093446006054F, 0.0F, 0.0F);
        this.petal03a = new ModelPart(this, 18, 19);
        this.petal03a.setPos(0.0F, -0.3F, 0.0F);
        this.petal03a.addBox(-2.5F, -5.6F, -0.7F, 5, 5, 0, 0.0F);
        this.setRotateAngle(this.petal03a, 0.6373942428283291F, -2.0943951023931953F, 0.0F);
        this.smallLeaf02a.addChild(this.smallLeaf02b);
        this.stem05.addChild(this.petal02a);
        this.stem05_1.addChild(this.smallLeaf03a_1);
        this.smallLeaf01a.addChild(this.smallLeaf01b);
        this.stem05_1.addChild(this.petal02a_1);
        this.stem05_1.addChild(this.petal03a_1);
        this.smallLeaf01a_1.addChild(this.smallLeaf01b_1);
        this.petal03a_1.addChild(this.petal03b_1);
        this.stem04.addChild(this.largeLeaf02a);
        this.stem04.addChild(this.largeLeaf03a);
        this.smallLeaf02a_1.addChild(this.smallLeaf02b_1);
        this.largeLeaf02a.addChild(this.largeLeaf02b);
        this.smallLeaf03a.addChild(this.smallLeaf03b);
        this.stem05_1.addChild(this.smallLeaf01a_1);
        this.smallLeaf03a_1.addChild(this.smallLeaf03b_1);
        this.largeLeaf03a_1.addChild(this.largeLeaf03b_1);
        this.stem04_1.addChild(this.largeLeaf03a_1);
        this.largeLeaf01a.addChild(this.largeLeaf01b);
        this.stem04.addChild(this.largeLeaf01a);
        this.petal02a.addChild(this.petal02b);
        this.petal03a.addChild(this.petal03b);
        this.stem05.addChild(this.smallLeaf02a);
        this.stem05_1.addChild(this.smallLeaf02a_1);
        this.stem05.addChild(this.petal01a);
        this.largeLeaf02a_1.addChild(this.largeLeaf02b_1);
        this.largeLeaf03a.addChild(this.largeLeaf03b);
        this.stem04_1.addChild(this.largeLeaf01a_1);
        this.petal01a.addChild(this.petal01b);
        this.stem05.addChild(this.smallLeaf01a);
        this.stem05.addChild(this.smallLeaf03a);
        this.petal02a_1.addChild(this.petal02b_1);
        this.stem05_1.addChild(this.petal01a_1);
        this.stem04_1.addChild(this.largeLeaf02a_1);
        this.largeLeaf01a_1.addChild(this.largeLeaf01b_1);
        this.petal01a_1.addChild(this.petal01b_1);
        this.stem05.addChild(this.petal03a);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.rotation = netHeadYaw;
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(rotation)); // Yaw

        matrixStackIn.pushPose();
        {
            RenderUtil.partScaleTranslate(matrixStackIn, stem04_1, 0.8F, 0.81F, 0.8F);
            this.stem04_1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        }
        matrixStackIn.popPose();

        matrixStackIn.pushPose();
        {
            RenderUtil.partScaleTranslate(matrixStackIn, stem05_1, 0.4F, 0.57F, 0.4F);
            this.stem05_1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        }
        matrixStackIn.popPose();

        this.stem03.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);

        matrixStackIn.pushPose();
        {
            RenderUtil.partScaleTranslate(matrixStackIn, stem05, 0.4F, 0.7F, 0.4F);
            this.stem05.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        }
        matrixStackIn.popPose();

        matrixStackIn.pushPose();
        {
            RenderUtil.partScaleTranslate(matrixStackIn, stem02, 0.7F, 1.0F, 0.7F);
            this.stem02.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        }
        matrixStackIn.popPose();

        matrixStackIn.pushPose();
        {
            RenderUtil.partScaleTranslate(matrixStackIn, stem04, 0.8F, 1.0F, 0.8F);
            this.stem04.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        }
        matrixStackIn.popPose();

        matrixStackIn.pushPose();
        {
            RenderUtil.partScaleTranslate(matrixStackIn, stem01, 0.8F, 1.0F, 0.8F);
            this.stem01.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        }
        matrixStackIn.popPose();

        matrixStackIn.pushPose();
        {
            RenderUtil.partScaleTranslate(matrixStackIn, stem02_1, 0.7F, 0.8F, 0.7F);
            this.stem02_1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        }
        matrixStackIn.popPose();
        matrixStackIn.pushPose();
        {
            RenderUtil.partScaleTranslate(matrixStackIn, stem03_1, 1.0F, 0.81F, 1.0F);
            this.stem03_1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        }
        matrixStackIn.popPose();
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelPart modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
