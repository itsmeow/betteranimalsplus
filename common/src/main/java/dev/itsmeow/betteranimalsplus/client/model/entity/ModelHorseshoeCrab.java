package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;

/**
 * horseshoe_crab - Batman
 * Created using Tabula 7.0.1
 */
public class ModelHorseshoeCrab<T extends LivingEntity> extends EntityModel<T> {
    public ModelPart spine;
    public ModelPart head;
    public ModelPart lBody;
    public ModelPart rBody;
    public ModelPart tail00;
    public ModelPart headSlope;
    public ModelPart lHorn00;
    public ModelPart rHorn00;
    public ModelPart head_1;
    public ModelPart lSpines;
    public ModelPart rSpines;

    public ModelHorseshoeCrab() {
        this.texWidth = 64;
        this.texHeight = 64;
        this.headSlope = new ModelPart(this, 0, 21);
        this.headSlope.setPos(0.0F, -1.0F, -8.8F);
        this.headSlope.addBox(-6.0F, 0.0F, 0.0F, 12, 2, 4, 0.0F);
        this.setRotateAngle(headSlope, 0.40980330836826856F, 0.0F, 0.0F);
        this.head_1 = new ModelPart(this, 0, 12);
        this.head_1.setPos(-5.0F, 0.0F, 4.0F);
        this.head_1.addBox(-1.0F, 0.0F, 0.0F, 12, 2, 6, 0.0F);
        this.setRotateAngle(head_1, -0.40980330836826856F, 0.0F, 0.0F);
        this.spine = new ModelPart(this, 0, 28);
        this.spine.setPos(0.0F, 22.4F, 0.0F);
        this.spine.addBox(-1.5F, -1.52F, 0.0F, 3, 3, 8, 0.0F);
        this.tail00 = new ModelPart(this, 0, 40);
        this.tail00.setPos(0.0F, 0.5F, 7.9F);
        this.tail00.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 11, 0.0F);
        this.lSpines = new ModelPart(this, 39, 30);
        this.lSpines.setPos(0.4F, -0.3F, 0.0F);
        this.lSpines.addBox(0.0F, 0.0F, 0.0F, 2, 0, 8, 0.0F);
        this.lBody = new ModelPart(this, 38, 6);
        this.lBody.setPos(2.5F, 0.5F, 0.0F);
        this.lBody.addBox(-1.5F, -1.01F, 0.0F, 3, 2, 8, 0.0F);
        this.setRotateAngle(lBody, 0.0F, -0.091106186954104F, 0.0F);
        this.lHorn00 = new ModelPart(this, 31, 28);
        this.lHorn00.setPos(5.5F, 0.0F, 0.8F);
        this.lHorn00.addBox(-0.5F, -1.0F, 0.0F, 1, 2, 2, 0.0F);
        this.setRotateAngle(lHorn00, 0.0F, -0.091106186954104F, 0.0F);
        this.head = new ModelPart(this, 0, 0);
        this.head.setPos(0.0F, 0.5F, -0.4F);
        this.head.addBox(-6.5F, -1.0F, -8.0F, 13, 2, 9, 0.0F);
        this.rHorn00 = new ModelPart(this, 31, 28);
        this.rHorn00.setPos(-5.5F, 0.0F, 0.8F);
        this.rHorn00.addBox(-0.5F, -1.0F, 0.0F, 1, 2, 2, 0.0F);
        this.setRotateAngle(rHorn00, 0.0F, 0.091106186954104F, 0.0F);
        this.rBody = new ModelPart(this, 34, 17);
        this.rBody.setPos(-2.5F, 0.5F, 0.0F);
        this.rBody.addBox(-1.5F, -1.01F, 0.0F, 3, 2, 8, 0.0F);
        this.setRotateAngle(rBody, 0.0F, 0.091106186954104F, 0.0F);
        this.rSpines = new ModelPart(this, 39, 30);
        this.rSpines.mirror = true;
        this.rSpines.setPos(-2.4F, -0.3F, 0.0F);
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
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.spine.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T entity, float f, float f1, float f2, float f3, float f4) {
        this.tail00.yRot = (float) Math.sin(f * 0.5F) * f1 * 0.5F;
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelPart ModelRenderer, float x, float y, float z) {
        ModelRenderer.xRot = x;
        ModelRenderer.yRot = y;
        ModelRenderer.zRot = z;
    }
}
