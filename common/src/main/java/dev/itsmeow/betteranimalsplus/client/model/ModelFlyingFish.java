package dev.itsmeow.betteranimalsplus.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;

/**
 * Flying fish - Batman
 * Created using Tabula 7.0.1
 */
public class ModelFlyingFish<T extends LivingEntity> extends EntityModel<T> {
    public ModelRenderer front;
    public ModelRenderer rear;
    public ModelRenderer head;
    public ModelRenderer leftFin;
    public ModelRenderer rightFin;
    public ModelRenderer rLF;
    public ModelRenderer tail;
    public ModelRenderer lLF;
    public ModelRenderer tail2;
    public ModelRenderer tTailFin;
    public ModelRenderer lTailFin;
    public ModelRenderer tailFin;
    public ModelRenderer topJaw;
    public ModelRenderer lowerJaw;
    public ModelRenderer snout;

    public ModelFlyingFish() {
        this.texWidth = 30;
        this.texHeight = 120;
        this.tailFin = new ModelRenderer(this, 0, 36);
        this.tailFin.setPos(0.0F, 0.0F, 2.6F);
        this.tailFin.addBox(0.0F, -4.0F, 0.0F, 0, 8, 7, 0.0F);
        this.topJaw = new ModelRenderer(this, 0, 61);
        this.topJaw.setPos(0.0F, -0.6F, -3.5F);
        this.topJaw.addBox(-1.5F, -0.5F, -3.0F, 3, 2, 3, 0.0F);
        this.setRotateAngle(topJaw, -0.31869712141416456F, 0.0F, 0.0F);
        this.lowerJaw = new ModelRenderer(this, 0, 72);
        this.lowerJaw.setPos(0.0F, 1.0F, -3.7F);
        this.lowerJaw.addBox(-1.0F, -0.5F, -3.0F, 2, 1, 3, 0.0F);
        this.setRotateAngle(lowerJaw, -0.36425021489121656F, 0.0F, 0.0F);
        this.leftFin = new ModelRenderer(this, 0, 65);
        this.leftFin.setPos(2.1F, 0.0F, -6.0F);
        this.leftFin.addBox(0.0F, 0.0F, -3.0F, 0, 20, 13, 0.0F);
        this.setRotateAngle(leftFin, 0.0F, 0.0F, -1.3658946726107624F);
        this.snout = new ModelRenderer(this, 0, 67);
        this.snout.setPos(0.0F, -0.5F, -3.0F);
        this.snout.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 3, 0.0F);
        this.setRotateAngle(snout, 0.45169121041613247F, 0.0F, 0.0F);
        this.tail2 = new ModelRenderer(this, 0, 36);
        this.tail2.setPos(0.0F, 0.0F, 2.5F);
        this.tail2.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 3, 0.0F);
        this.front = new ModelRenderer(this, 0, 0);
        this.front.setPos(0.0F, 15.0F, 0.0F);
        this.front.addBox(-2.5F, -2.5F, -9.0F, 5, 5, 9, 0.0F);
        this.head = new ModelRenderer(this, 0, 52);
        this.head.setPos(0.0F, 0.0F, -8.5F);
        this.head.addBox(-2.0F, -2.5F, -4.0F, 4, 4, 4, 0.0F);
        this.setRotateAngle(head, 0.029845130209103034F, 0.0F, 0.0F);
        this.tTailFin = new ModelRenderer(this, 0, 97);
        this.tTailFin.setPos(0.0F, -2.8F, 0.3F);
        this.tTailFin.addBox(0.0F, 0.0F, 0.0F, 0, 2, 3, 0.0F);
        this.setRotateAngle(tTailFin, -0.31869712141416456F, 0.0F, 0.0F);
        this.rightFin = new ModelRenderer(this, 0, 65);
        this.rightFin.setPos(-2.1F, 0.0F, -6.0F);
        this.rightFin.addBox(0.0F, 0.0F, -3.0F, 0, 20, 13, 0.0F);
        this.setRotateAngle(rightFin, 0.0F, 0.0F, 1.3658946726107624F);
        this.lLF = new ModelRenderer(this, 0, 99);
        this.lLF.setPos(1.3F, 1.2F, 4.0F);
        this.lLF.addBox(0.0F, 0.0F, -2.0F, 0, 7, 5, 0.0F);
        this.setRotateAngle(lLF, 0.18203784098300857F, 0.0F, -0.36425021489121656F);
        this.rear = new ModelRenderer(this, 0, 15);
        this.rear.setPos(0.0F, -0.2F, 0.0F);
        this.rear.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 8, 0.0F);
        this.rLF = new ModelRenderer(this, 0, 99);
        this.rLF.setPos(-1.3F, 1.2F, 4.0F);
        this.rLF.addBox(0.0F, 0.0F, -2.0F, 0, 7, 5, 0.0F);
        this.setRotateAngle(rLF, 0.18203784098300857F, 0.0F, 0.36425021489121656F);
        this.lTailFin = new ModelRenderer(this, 8, 97);
        this.lTailFin.setPos(0.0F, 0.7F, -0.1F);
        this.lTailFin.addBox(0.0F, 0.0F, 0.0F, 0, 2, 2, 0.0F);
        this.setRotateAngle(lTailFin, 0.4553564018453205F, 0.0F, 0.0F);
        this.tail = new ModelRenderer(this, 0, 28);
        this.tail.setPos(0.0F, 0.0F, 8.0F);
        this.tail.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 3, 0.0F);
        this.tail2.addChild(this.tailFin);
        this.head.addChild(this.topJaw);
        this.head.addChild(this.lowerJaw);
        this.front.addChild(this.leftFin);
        this.topJaw.addChild(this.snout);
        this.tail.addChild(this.tail2);
        this.front.addChild(this.head);
        this.tail.addChild(this.tTailFin);
        this.front.addChild(this.rightFin);
        this.rear.addChild(this.lLF);
        this.front.addChild(this.rear);
        this.front.addChild(this.rLF);
        this.tail.addChild(this.lTailFin);
        this.rear.addChild(this.tail);
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.front.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float factor = (float) entityIn.getDeltaMovement().length() * 10;
        this.front.yRot = MathHelper.cos(ageInTicks * 0.3F) * (float) Math.PI * 0.05F * factor;
        this.head.yRot = -this.front.yRot * 1.5F;
        this.rear.yRot = this.front.yRot * 1.5F;
        this.tail.yRot = this.rear.yRot * 1.5F;
        this.rightFin.xRot = 0F;
        this.leftFin.xRot = 0F;
        this.rightFin.zRot = (this.front.yRot * 2F) + 1.3658946726107624F;
        this.leftFin.zRot = -(this.front.yRot * 2F) - 1.3658946726107624F;
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer ModelRenderer, float x, float y, float z) {
        ModelRenderer.xRot = x;
        ModelRenderer.yRot = y;
        ModelRenderer.zRot = z;
    }
}
