package dev.itsmeow.betteranimalsplus.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * boarhead - cybercat5555 Created using Tabula 5.1.0
 */
public class ModelBoarHead extends EntityModel<Entity> {

    public ModelRenderer neck;
    public ModelRenderer neck02;
    public ModelRenderer chestFur01;
    public ModelRenderer head;
    public ModelRenderer mane01;
    public ModelRenderer snoot01;
    public ModelRenderer upperJaw;
    public ModelRenderer lowerJaw;
    public ModelRenderer lEar01;
    public ModelRenderer rEar01;
    public ModelRenderer snoot02;
    public ModelRenderer snoot;
    public ModelRenderer lTusk01;
    public ModelRenderer rTusk01;
    public ModelRenderer lTusk02;
    public ModelRenderer lTusk03;
    public ModelRenderer rTusk02;
    public ModelRenderer rTusk03;
    public ModelRenderer lEar02;
    public ModelRenderer rEar02;

    public ModelBoarHead() {
        this.texWidth = 128;
        this.texHeight = 64;
        this.neck = new ModelRenderer(this, 0, 34);
        this.neck.setPos(0.0F, 23.9F, 0.0F);
        this.neck.addBox(-3.0F, -3.5F, -4.0F, 6, 7, 4, 0.0F);
        this.lTusk01 = new ModelRenderer(this, 0, 0);
        this.lTusk01.setPos(1.3F, -0.5F, -2.8F);
        this.lTusk01.addBox(-0.5F, -0.8F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(this.lTusk01, 0.24434609527920614F, 0.0F, 0.6981317007977318F);
        this.rTusk03 = new ModelRenderer(this, 0, 0);
        this.rTusk03.mirror = true;
        this.rTusk03.setPos(0.1F, -0.8F, 0.0F);
        this.rTusk03.addBox(-0.4F, -1.7F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(this.rTusk03, 0.0F, 0.0F, 0.4363323129985824F);
        this.lEar02 = new ModelRenderer(this, 78, 37);
        this.lEar02.setPos(0.6F, 0.0F, 0.7F);
        this.lEar02.addBox(-1.0F, -4.0F, -0.5F, 2, 5, 1, 0.0F);
        this.setRotateAngle(this.lEar02, 0.22689280275926282F, 0.0F, 0.0F);
        this.lowerJaw = new ModelRenderer(this, 99, 25);
        this.lowerJaw.setPos(0.0F, 2.1F, -4.1F);
        this.lowerJaw.addBox(-1.5F, -0.5F, -4.7F, 3, 1, 5, 0.0F);
        this.setRotateAngle(this.lowerJaw, 0.2617993877991494F, 0.0F, 0.0F);
        this.rTusk02 = new ModelRenderer(this, 0, 0);
        this.rTusk02.mirror = true;
        this.rTusk02.setPos(0.0F, -1.0F, 0.0F);
        this.rTusk02.addBox(-0.45F, -0.7F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(this.rTusk02, 0.0F, 0.0F, 0.2617993877991494F);
        this.lEar01 = new ModelRenderer(this, 69, 37);
        this.lEar01.setPos(1.2F, -2.7F, -1.7F);
        this.lEar01.addBox(-0.8F, -3.0F, -0.5F, 3, 3, 1, 0.0F);
        this.setRotateAngle(this.lEar01, -0.22689280275926282F, -0.7853981633974483F, 0.7853981633974483F);
        this.rEar01 = new ModelRenderer(this, 69, 37);
        this.rEar01.mirror = true;
        this.rEar01.setPos(-1.2F, -2.7F, -1.7F);
        this.rEar01.addBox(-2.2F, -3.0F, -0.5F, 3, 3, 1, 0.0F);
        this.setRotateAngle(this.rEar01, -0.22689280275926282F, 0.7853981633974483F, -0.7853981633974483F);
        this.upperJaw = new ModelRenderer(this, 84, 25);
        this.upperJaw.setPos(0.0F, 0.7F, -4.4F);
        this.upperJaw.addBox(-1.5F, -1.0F, -4.0F, 3, 2, 4, 0.0F);
        this.snoot02 = new ModelRenderer(this, 101, 16);
        this.snoot02.setPos(0.0F, 0.0F, 0.0F);
        this.snoot02.addBox(0.7F, -1.5F, -4.7F, 1, 2, 5, 0.0F);
        this.chestFur01 = new ModelRenderer(this, 108, 50);
        this.chestFur01.setPos(0.0F, 2.9F, -1.6F);
        this.chestFur01.addBox(-2.5F, 0.0F, -1.0F, 5, 4, 2, 0.0F);
        this.setRotateAngle(this.chestFur01, 0.2792526803190927F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 84, 0);
        this.head.setPos(0.0F, -0.3F, -1.2F);
        this.head.addBox(-2.5F, -3.5F, -5.0F, 5, 6, 5, 0.0F);
        this.setRotateAngle(this.head, 0.33161255787892263F, 0.0F, 0.0F);
        this.mane01 = new ModelRenderer(this, 86, 35);
        this.mane01.setPos(0.0F, -2.7F, -1.8F);
        this.mane01.addBox(-2.0F, -1.2F, 0.0F, 4, 2, 5, 0.0F);
        this.setRotateAngle(this.mane01, 0.5235987755982988F, 0.0F, 0.0F);
        this.lTusk03 = new ModelRenderer(this, 0, 0);
        this.lTusk03.setPos(-0.1F, -0.8F, 0.0F);
        this.lTusk03.addBox(-0.6F, -1.7F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(this.lTusk03, 0.0F, 0.0F, -0.4363323129985824F);
        this.snoot01 = new ModelRenderer(this, 84, 16);
        this.snoot01.setPos(0.0F, -0.6F, -4.4F);
        this.snoot01.addBox(-1.7F, -1.5F, -4.7F, 3, 2, 5, 0.0F);
        this.setRotateAngle(this.snoot01, 0.27314402793711257F, 0.0F, 0.0F);
        this.rEar02 = new ModelRenderer(this, 78, 37);
        this.rEar02.mirror = true;
        this.rEar02.setPos(-0.6F, 0.0F, 0.7F);
        this.rEar02.addBox(-1.0F, -4.0F, -0.5F, 2, 5, 1, 0.0F);
        this.setRotateAngle(this.rEar02, 0.22689280275926282F, 0.0F, 0.0F);
        this.snoot = new ModelRenderer(this, 112, 16);
        this.snoot.setPos(0.0F, -0.4F, -4.3F);
        this.snoot.addBox(-1.5F, -1.5F, -0.8F, 3, 3, 1, 0.0F);
        this.setRotateAngle(this.snoot, -0.136659280431156F, 0.0F, 0.0F);
        this.neck02 = new ModelRenderer(this, 0, 48);
        this.neck02.setPos(0.0F, 0.1F, -3.8F);
        this.neck02.addBox(-2.0F, -3.0F, -3.0F, 4, 6, 3, 0.0F);
        this.setRotateAngle(this.neck02, -0.136659280431156F, 0.0F, 0.0F);
        this.rTusk01 = new ModelRenderer(this, 0, 0);
        this.rTusk01.mirror = true;
        this.rTusk01.setPos(-1.3F, -0.5F, -2.8F);
        this.rTusk01.addBox(-0.5F, -0.8F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(this.rTusk01, 0.24434609527920614F, 0.0F, -0.6981317007977318F);
        this.lTusk02 = new ModelRenderer(this, 0, 0);
        this.lTusk02.setPos(0.0F, -1.0F, 0.0F);
        this.lTusk02.addBox(-0.55F, -0.7F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(this.lTusk02, 0.0F, 0.0F, -0.2617993877991494F);
        this.lowerJaw.addChild(this.lTusk01);
        this.rTusk02.addChild(this.rTusk03);
        this.lEar01.addChild(this.lEar02);
        this.head.addChild(this.lowerJaw);
        this.rTusk01.addChild(this.rTusk02);
        this.head.addChild(this.lEar01);
        this.head.addChild(this.rEar01);
        this.head.addChild(this.upperJaw);
        this.snoot01.addChild(this.snoot02);
        this.neck.addChild(this.chestFur01);
        this.neck02.addChild(this.head);
        this.neck02.addChild(this.mane01);
        this.lTusk02.addChild(this.lTusk03);
        this.head.addChild(this.snoot01);
        this.rEar01.addChild(this.rEar02);
        this.snoot01.addChild(this.snoot);
        this.neck.addChild(this.neck02);
        this.lowerJaw.addChild(this.rTusk01);
        this.lTusk01.addChild(this.lTusk02);
    }

    @Override
    public void setupAnim(Entity entity, float f, float f1, float f2, float f3, float f4) {
        this.neck.yRot = (float) Math.toRadians(f);
        this.neck.xRot = (float) Math.toRadians(f1);
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.neck.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
