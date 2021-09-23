package dev.itsmeow.betteranimalsplus.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

/**
 * horseshoe_crab - Batman
 * Created using Tabula 7.0.1
 */
public class ModelHorseshoeCrab<T extends LivingEntity> extends EntityModel<T> {
    public ModelRenderer spine;
    public ModelRenderer head;
    public ModelRenderer lBody;
    public ModelRenderer rBody;
    public ModelRenderer tail00;
    public ModelRenderer headSlope;
    public ModelRenderer lHorn00;
    public ModelRenderer rHorn00;
    public ModelRenderer head_1;
    public ModelRenderer lSpines;
    public ModelRenderer rSpines;

    public ModelHorseshoeCrab() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.headSlope = new ModelRenderer(this, 0, 21);
        this.headSlope.setRotationPoint(0.0F, -1.0F, -8.8F);
        this.headSlope.addBox(-6.0F, 0.0F, 0.0F, 12, 2, 4, 0.0F);
        this.setRotateAngle(headSlope, 0.40980330836826856F, 0.0F, 0.0F);
        this.head_1 = new ModelRenderer(this, 0, 12);
        this.head_1.setRotationPoint(-5.0F, 0.0F, 4.0F);
        this.head_1.addBox(-1.0F, 0.0F, 0.0F, 12, 2, 6, 0.0F);
        this.setRotateAngle(head_1, -0.40980330836826856F, 0.0F, 0.0F);
        this.spine = new ModelRenderer(this, 0, 28);
        this.spine.setRotationPoint(0.0F, 22.4F, 0.0F);
        this.spine.addBox(-1.5F, -1.52F, 0.0F, 3, 3, 8, 0.0F);
        this.tail00 = new ModelRenderer(this, 0, 40);
        this.tail00.setRotationPoint(0.0F, 0.5F, 7.9F);
        this.tail00.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 11, 0.0F);
        this.lSpines = new ModelRenderer(this, 39, 30);
        this.lSpines.setRotationPoint(0.4F, -0.3F, 0.0F);
        this.lSpines.addBox(0.0F, 0.0F, 0.0F, 2, 0, 8, 0.0F);
        this.lBody = new ModelRenderer(this, 38, 6);
        this.lBody.setRotationPoint(2.5F, 0.5F, 0.0F);
        this.lBody.addBox(-1.5F, -1.01F, 0.0F, 3, 2, 8, 0.0F);
        this.setRotateAngle(lBody, 0.0F, -0.091106186954104F, 0.0F);
        this.lHorn00 = new ModelRenderer(this, 31, 28);
        this.lHorn00.setRotationPoint(5.5F, 0.0F, 0.8F);
        this.lHorn00.addBox(-0.5F, -1.0F, 0.0F, 1, 2, 2, 0.0F);
        this.setRotateAngle(lHorn00, 0.0F, -0.091106186954104F, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 0.5F, -0.4F);
        this.head.addBox(-6.5F, -1.0F, -8.0F, 13, 2, 9, 0.0F);
        this.rHorn00 = new ModelRenderer(this, 31, 28);
        this.rHorn00.setRotationPoint(-5.5F, 0.0F, 0.8F);
        this.rHorn00.addBox(-0.5F, -1.0F, 0.0F, 1, 2, 2, 0.0F);
        this.setRotateAngle(rHorn00, 0.0F, 0.091106186954104F, 0.0F);
        this.rBody = new ModelRenderer(this, 34, 17);
        this.rBody.setRotationPoint(-2.5F, 0.5F, 0.0F);
        this.rBody.addBox(-1.5F, -1.01F, 0.0F, 3, 2, 8, 0.0F);
        this.setRotateAngle(rBody, 0.0F, 0.091106186954104F, 0.0F);
        this.rSpines = new ModelRenderer(this, 39, 30);
        this.rSpines.mirror = true;
        this.rSpines.setRotationPoint(-2.4F, -0.3F, 0.0F);
        this.rSpines.addBox(0.0F, 0.0F, 0.0F, 2, 0, 8, 0.0F);
        this.head.addChild(this.headSlope);
        this.headSlope.addChild(this.head_1);
        this.spine.addChild(this.tail00);
        this.lBody.addChild(this.lSpines);
        this.spine.addChild(this.lBody);
        this.head.addChild(this.lHorn00);
        this.spine.addChild(this.head);
        this.head.addChild(this.rHorn00);
        this.spine.addChild(this.rBody);
        this.rBody.addChild(this.rSpines);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.spine.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setRotationAngles(T entity, float f, float f1, float f2, float f3, float f4) { 
        this.tail00.rotateAngleY = (float) Math.sin(f * 0.5F) * f1 * 0.5F;
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer ModelRenderer, float x, float y, float z) {
        ModelRenderer.rotateAngleX = x;
        ModelRenderer.rotateAngleY = y;
        ModelRenderer.rotateAngleZ = z;
    }
}
