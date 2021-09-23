package dev.itsmeow.betteranimalsplus.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

/**
 * Jellyfish - Batman Created using Tabula 5.1.0
 */
public class ModelJellyfish<T extends LivingEntity> extends EntityModel<T> {

    public ModelRenderer main;
    public ModelRenderer top01;
    public ModelRenderer body01;
    public ModelRenderer tentacles01;
    public ModelRenderer nub01;
    public ModelRenderer nub02;
    public ModelRenderer nub03;
    public ModelRenderer nub04;
    public ModelRenderer nub05;
    public ModelRenderer nub06;
    public ModelRenderer nub07;
    public ModelRenderer nub08;
    public ModelRenderer nub09;
    public ModelRenderer nub10;
    public ModelRenderer nub11;
    public ModelRenderer nub12;
    public ModelRenderer body02;
    public ModelRenderer tentacles02;
    public ModelRenderer tentaclesMid;

    public ModelJellyfish() {
        this.texWidth = 120;
        this.texHeight = 180;
        this.nub07 = new ModelRenderer(this, 0, 0);
        this.nub07.setPos(0.5F, -4.5F, 2.0F);
        this.nub07.addBox(0.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(this.nub07, -0.45378560551852565F, 0.0F, 0.0F);
        this.nub04 = new ModelRenderer(this, 0, 0);
        this.nub04.setPos(-1.5F, -4.0F, -3.0F);
        this.nub04.addBox(0.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(this.nub04, 0.45378560551852565F, 0.0F, 0.0F);
        this.tentacles02 = new ModelRenderer(this, 0, 50);
        this.tentacles02.setPos(0.0F, -0.1F, 0.0F);
        this.tentacles02.addBox(-9.5F, 0.0F, -9.5F, 19, 28, 19, 0.0F);
        this.setRotateAngle(this.tentacles02, -0.006283185307179587F, 0.0F, 0.0F);
        this.nub06 = new ModelRenderer(this, 0, 0);
        this.nub06.setPos(-1.5F, -4.5F, 2.0F);
        this.nub06.addBox(0.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(this.nub06, -0.45378560551852565F, 0.0F, 0.0F);
        this.tentaclesMid = new ModelRenderer(this, 30, 100);
        this.tentaclesMid.setPos(0.0F, 6.0F, 0.0F);
        this.tentaclesMid.addBox(-9.0F, 0.0F, -9.0F, 18, 8, 18, 0.0F);
        this.main = new ModelRenderer(this, 0, 132);
        this.main.setPos(0.0F, -5.0F, 0.0F);
        this.main.addBox(-4.0F, -7.0F, -4.0F, 8, 7, 8, 0.0F);
        this.nub10 = new ModelRenderer(this, 0, 0);
        this.nub10.setPos(2.5F, -4.5F, 2.0F);
        this.nub10.addBox(0.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(this.nub10, -0.45378560551852565F, 0.0F, 0.0F);
        this.nub11 = new ModelRenderer(this, 0, 0);
        this.nub11.setPos(2.5F, -4.5F, -0.5F);
        this.nub11.addBox(0.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(this.nub11, 0.0F, 0.0F, 0.45378560551852565F);
        this.nub01 = new ModelRenderer(this, 0, 0);
        this.nub01.setPos(-3.5F, -4.5F, 2.0F);
        this.nub01.addBox(0.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(this.nub01, -0.45378560551852565F, 0.0F, 0.0F);
        this.nub03 = new ModelRenderer(this, 0, 0);
        this.nub03.setPos(-3.5F, -4.0F, -3.0F);
        this.nub03.addBox(0.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(this.nub03, 0.45378560551852565F, 0.0F, 0.0F);
        this.body01 = new ModelRenderer(this, 0, 0);
        this.body01.setPos(0.0F, 0.0F, 0.0F);
        this.body01.addBox(-10.0F, -5.0F, -10.0F, 20, 5, 20, 0.0F);
        this.nub09 = new ModelRenderer(this, 0, 0);
        this.nub09.setPos(0.5F, -4.0F, -3.0F);
        this.nub09.addBox(0.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(this.nub09, 0.45378560551852565F, 0.0F, 0.0F);
        this.nub12 = new ModelRenderer(this, 0, 0);
        this.nub12.setPos(2.5F, -4.0F, -3.0F);
        this.nub12.addBox(0.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(this.nub12, 0.45378560551852565F, 0.0F, 0.0F);
        this.top01 = new ModelRenderer(this, 37, 131);
        this.top01.setPos(0.0F, -6.0F, 0.0F);
        this.top01.addBox(-4.0F, -5.0F, -4.0F, 8, 5, 8, 0.0F);
        this.tentacles01 = new ModelRenderer(this, 0, 100);
        this.tentacles01.setPos(0.0F, -0.5F, 0.0F);
        this.tentacles01.addBox(-3.5F, 0.0F, -3.5F, 7, 21, 7, 0.0F);
        this.body02 = new ModelRenderer(this, 0, 27);
        this.body02.setPos(1.0F, -9.0F, 0.0F);
        this.body02.addBox(-10.0F, 1.0F, -9.0F, 18, 3, 18, 0.0F);
        this.nub02 = new ModelRenderer(this, 0, 0);
        this.nub02.setPos(-3.5F, -4.5F, -0.5F);
        this.nub02.addBox(0.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(this.nub02, 0.0F, 0.0F, -0.45378560551852565F);
        this.nub08 = new ModelRenderer(this, 0, 0);
        this.nub08.setPos(0.5F, -4.5F, -0.5F);
        this.nub08.addBox(0.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(this.nub08, 0.0F, 0.0F, 0.22689280275926282F);
        this.nub05 = new ModelRenderer(this, 0, 0);
        this.nub05.setPos(-1.5F, -4.5F, -0.5F);
        this.nub05.addBox(0.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(this.nub05, 0.0F, 0.0F, -0.22689280275926282F);
        this.top01.addChild(this.nub07);
        this.top01.addChild(this.nub04);
        this.body01.addChild(this.tentacles02);
        this.top01.addChild(this.nub06);
        this.tentacles01.addChild(this.tentaclesMid);
        this.top01.addChild(this.nub10);
        this.top01.addChild(this.nub11);
        this.top01.addChild(this.nub01);
        this.top01.addChild(this.nub03);
        this.main.addChild(this.body01);
        this.top01.addChild(this.nub09);
        this.top01.addChild(this.nub12);
        this.main.addChild(this.top01);
        this.main.addChild(this.tentacles01);
        this.body01.addChild(this.body02);
        this.top01.addChild(this.nub02);
        this.top01.addChild(this.nub08);
        this.top01.addChild(this.nub05);
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.main.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
}