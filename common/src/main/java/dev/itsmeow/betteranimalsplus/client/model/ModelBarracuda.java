package dev.itsmeow.betteranimalsplus.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;

/**
 * Baracuda - Batman Created using Tabula 7.0.1
 */
public class ModelBarracuda<T extends LivingEntity> extends EntityModel<T> {
    public ModelRenderer body;
    public ModelRenderer rear;
    public ModelRenderer neck;
    public ModelRenderer topfin1;
    public ModelRenderer leftlowfin;
    public ModelRenderer rightlowfin;
    public ModelRenderer tail;
    public ModelRenderer topfin2;
    public ModelRenderer lowfin;
    public ModelRenderer tail2;
    public ModelRenderer tail3;
    public ModelRenderer tailfin;
    public ModelRenderer head;
    public ModelRenderer leftfin1;
    public ModelRenderer rightfin1;
    public ModelRenderer topjaw;
    public ModelRenderer lowerjaw;
    public ModelRenderer snout;
    public ModelRenderer topteeth1;
    public ModelRenderer topteeth2;
    public ModelRenderer lowteeth;
    public ModelRenderer leftfin2;
    public ModelRenderer rightfin2;

    public ModelBarracuda() {
        this.textureWidth = 70;
        this.textureHeight = 130;
        this.tail = new ModelRenderer(this, 0, 41);
        this.tail.setRotationPoint(0.0F, -0.9F, 11.0F);
        this.tail.addBox(-2.0F, -2.5F, 0.0F, 4, 6, 5, 0.0F);
        this.leftfin2 = new ModelRenderer(this, 26, 109);
        this.leftfin2.setRotationPoint(0.0F, -0.5F, 0.6F);
        this.leftfin2.addBox(0.0F, -1.5F, 0.0F, 0, 3, 4, 0.0F);
        this.rear = new ModelRenderer(this, 0, 22);
        this.rear.setRotationPoint(0.0F, -0.4F, 0.0F);
        this.rear.addBox(-3.0F, -3.5F, 0.0F, 6, 6, 11, 0.0F);
        this.setRotateAngle(rear, -0.008726646259971648F, 0.0F, 0.0F);
        this.topfin2 = new ModelRenderer(this, 13, 115);
        this.topfin2.setRotationPoint(0.0F, -3.7F, 3.7F);
        this.topfin2.addBox(0.0F, 0.0F, 0.0F, 0, 6, 6, 0.0F);
        this.setRotateAngle(topfin2, 0.5462880558742251F, 0.0F, 0.0F);
        this.rightlowfin = new ModelRenderer(this, 37, 109);
        this.rightlowfin.setRotationPoint(-1.6F, 2.0F, -11.0F);
        this.rightlowfin.addBox(0.0F, -1.5F, 0.0F, 0, 3, 5, 0.0F);
        this.setRotateAngle(rightlowfin, -0.6829473363053812F, 0.0F, 0.5009094953223726F);
        this.snout = new ModelRenderer(this, 22, 85);
        this.snout.setRotationPoint(0.0F, -1.0F, -11.8F);
        this.snout.addBox(-1.5F, 0.0F, 0.0F, 3, 2, 10, 0.0F);
        this.setRotateAngle(snout, 0.18552849948699726F, 0.0F, 0.0F);
        this.tail3 = new ModelRenderer(this, 0, 53);
        this.tail3.setRotationPoint(0.0F, 0.0F, 5.0F);
        this.tail3.addBox(-1.0F, -2.0F, 0.0F, 2, 4, 5, 0.0F);
        this.leftlowfin = new ModelRenderer(this, 37, 109);
        this.leftlowfin.setRotationPoint(1.6F, 2.0F, -11.0F);
        this.leftlowfin.addBox(0.0F, -1.5F, 0.0F, 0, 3, 5, 0.0F);
        this.setRotateAngle(leftlowfin, -0.6829473363053812F, 0.0F, -0.5009094953223726F);
        this.tail2 = new ModelRenderer(this, 20, 41);
        this.tail2.setRotationPoint(0.0F, 0.5F, 5.0F);
        this.tail2.addBox(-1.5F, -2.5F, 0.0F, 3, 5, 5, 0.0F);
        this.head = new ModelRenderer(this, 21, 71);
        this.head.setRotationPoint(0.0F, 0.0F, -3.9F);
        this.head.addBox(-2.5F, -4.0F, -5.0F, 5, 7, 5, 0.0F);
        this.rightfin1 = new ModelRenderer(this, 16, 112);
        this.rightfin1.setRotationPoint(-3.0F, 0.7F, -1.0F);
        this.rightfin1.addBox(-0.5F, -1.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(rightfin1, -0.40980330836826856F, -0.6829473363053812F, 0.0F);
        this.lowfin = new ModelRenderer(this, 27, 115);
        this.lowfin.setRotationPoint(0.0F, 0.7F, 4.9F);
        this.lowfin.addBox(0.0F, -2.0F, 0.0F, 0, 4, 6, 0.0F);
        this.setRotateAngle(lowfin, -0.7740535232594852F, 0.0F, 0.0F);
        this.lowerjaw = new ModelRenderer(this, 39, 79);
        this.lowerjaw.setRotationPoint(0.0F, 1.3F, -4.5F);
        this.lowerjaw.addBox(-1.5F, -1.0F, -11.0F, 3, 2, 11, 0.0F);
        this.setRotateAngle(lowerjaw, -0.136659280431156F, 0.0F, 0.0F);
        this.leftfin1 = new ModelRenderer(this, 16, 112);
        this.leftfin1.setRotationPoint(3.0F, 0.7F, -1.0F);
        this.leftfin1.addBox(-0.5F, -1.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(leftfin1, -0.40980330836826856F, 0.6829473363053812F, 0.0F);
        this.topteeth2 = new ModelRenderer(this, 0, 95);
        this.topteeth2.setRotationPoint(-0.2F, 1.0F, -11.9F);
        this.topteeth2.addBox(0.0F, 0.0F, 0.0F, 2, 2, 10, 0.0F);
        this.topteeth1 = new ModelRenderer(this, 23, 99);
        this.topteeth1.setRotationPoint(-1.8F, 1.0F, -11.9F);
        this.topteeth1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 10, 0.0F);
        this.lowteeth = new ModelRenderer(this, 0, 108);
        this.lowteeth.setRotationPoint(-1.0F, -2.0F, -9.9F);
        this.lowteeth.addBox(0.0F, 0.0F, 0.0F, 2, 1, 9, 0.0F);
        this.setRotateAngle(lowteeth, -0.048869219055841226F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0.0F, 14.0F, 3.0F);
        this.body.addBox(-3.5F, -4.0F, -13.0F, 7, 7, 13, 0.0F);
        this.setRotateAngle(body, 0.006981317007977318F, 0.0F, 0.0F);
        this.topjaw = new ModelRenderer(this, 0, 81);
        this.topjaw.setRotationPoint(0.0F, -0.7F, -2.9F);
        this.topjaw.addBox(-2.0F, -1.0F, -12.0F, 4, 2, 10, 0.0F);
        this.setRotateAngle(topjaw, -0.091106186954104F, 0.0F, 0.0F);
        this.neck = new ModelRenderer(this, 0, 68);
        this.neck.setRotationPoint(0.0F, 0.0F, -12.3F);
        this.neck.addBox(-3.0F, -4.0F, -4.0F, 6, 7, 4, 0.0F);
        this.setRotateAngle(neck, 0.045553093477052F, 0.0F, 0.0F);
        this.topfin1 = new ModelRenderer(this, 0, 115);
        this.topfin1.setRotationPoint(0.0F, -4.0F, -9.0F);
        this.topfin1.addBox(0.0F, -5.0F, 0.0F, 0, 5, 5, 0.0F);
        this.setRotateAngle(topfin1, -0.22759093446006054F, 0.0F, 0.0F);
        this.rightfin2 = new ModelRenderer(this, 26, 109);
        this.rightfin2.setRotationPoint(0.0F, -0.5F, 0.6F);
        this.rightfin2.addBox(0.0F, -1.5F, 0.0F, 0, 3, 4, 0.0F);
        this.tailfin = new ModelRenderer(this, 18, 44);
        this.tailfin.setRotationPoint(0.0F, 0.0F, 4.0F);
        this.tailfin.addBox(0.0F, -8.0F, 0.0F, 0, 16, 9, 0.0F);
        this.rear.addChild(this.tail);
        this.leftfin1.addChild(this.leftfin2);
        this.body.addChild(this.rear);
        this.rear.addChild(this.topfin2);
        this.body.addChild(this.rightlowfin);
        this.topjaw.addChild(this.snout);
        this.tail2.addChild(this.tail3);
        this.body.addChild(this.leftlowfin);
        this.tail.addChild(this.tail2);
        this.neck.addChild(this.head);
        this.neck.addChild(this.rightfin1);
        this.rear.addChild(this.lowfin);
        this.head.addChild(this.lowerjaw);
        this.neck.addChild(this.leftfin1);
        this.topjaw.addChild(this.topteeth2);
        this.topjaw.addChild(this.topteeth1);
        this.lowerjaw.addChild(this.lowteeth);
        this.head.addChild(this.topjaw);
        this.body.addChild(this.neck);
        this.body.addChild(this.topfin1);
        this.rightfin1.addChild(this.rightfin2);
        this.tail3.addChild(this.tailfin);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float factor = (float) entityIn.getMotion().length() * 10;
        this.body.rotateAngleY = MathHelper.cos(ageInTicks * 0.3F) * (float) Math.PI * 0.05F * factor;
        this.head.rotateAngleY = -this.body.rotateAngleY * 1.5F;
        this.rear.rotateAngleY = this.body.rotateAngleY * 1.5F;
        this.tail.rotateAngleY = this.rear.rotateAngleY * 1.5F;
    }

    public void setRotateAngle(ModelRenderer ModelRenderer, float x, float y, float z) {
        ModelRenderer.rotateAngleX = x;
        ModelRenderer.rotateAngleY = y;
        ModelRenderer.rotateAngleZ = z;
    }
}
