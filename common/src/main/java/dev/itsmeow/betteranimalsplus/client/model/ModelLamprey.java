package dev.itsmeow.betteranimalsplus.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;

/**
 * Lamprey - Batman
 * Created using Tabula 5.1.0
 */
public class ModelLamprey<T extends LivingEntity> extends EntityModel<T> {
    public ModelRenderer body01;
    public ModelRenderer body02;
    public ModelRenderer head;
    public ModelRenderer tail01;
    public ModelRenderer fin01;
    public ModelRenderer tail02;
    public ModelRenderer fin02;
    public ModelRenderer fin03;
    public ModelRenderer mouth;
    public ModelRenderer snout;
    public ModelRenderer jaw;
    public ModelRenderer lTeeth;
    public ModelRenderer rTeeth;
    public ModelRenderer fTeeth;
    private boolean putOnSide = false;

    public ModelLamprey() {
        this.texWidth = 40;
        this.texHeight = 120;
        this.body01 = new ModelRenderer(this, 0, 0);
        this.body01.setPos(0.0F, 21.3F, 0.0F);
        this.body01.addBox(-2.0F, -2.0F, -10.0F, 4, 4, 10, 0.0F);
        this.setRotateAngle(body01, 0.017453292519943295F, 0.0F, 0.0F);
        this.fin03 = new ModelRenderer(this, 0, 100);
        this.fin03.setPos(0.0F, 0.0F, 0.5F);
        this.fin03.addBox(0.0F, -3.5F, 0.0F, 0, 6, 5, 0.0F);
        this.head = new ModelRenderer(this, 0, 54);
        this.head.setPos(0.0F, -0.4F, -9.7F);
        this.head.addBox(-2.0F, -1.5F, -6.0F, 4, 3, 6, 0.0F);
        this.setRotateAngle(head, 0.08726646259971647F, 0.0F, 0.0F);
        this.body02 = new ModelRenderer(this, 0, 16);
        this.body02.setPos(0.0F, 0.0F, -0.3F);
        this.body02.addBox(-1.5F, -2.0F, 0.0F, 3, 4, 10, 0.0F);
        this.setRotateAngle(body02, -0.045553093477052F, 0.0F, 0.0F);
        this.fin01 = new ModelRenderer(this, 0, 91);
        this.fin01.setPos(0.0F, -1.5F, 5.4F);
        this.fin01.addBox(0.0F, -3.0F, 0.0F, 0, 3, 4, 0.0F);
        this.fTeeth = new ModelRenderer(this, 0, 90);
        this.fTeeth.setPos(-0.5F, 0.5F, 0.0F);
        this.fTeeth.addBox(0.0F, 0.0F, 0.1F, 1, 1, 3, 0.0F);
        this.snout = new ModelRenderer(this, 0, 71);
        this.snout.setPos(0.0F, -1.0F, -4.0F);
        this.snout.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 4, 0.0F);
        this.setRotateAngle(snout, 0.22689280275926282F, 0.0F, 0.0F);
        this.tail02 = new ModelRenderer(this, 0, 45);
        this.tail02.setPos(0.0F, -0.4F, 8.0F);
        this.tail02.addBox(-0.5F, -1.0F, 0.0F, 1, 2, 6, 0.0F);
        this.fin02 = new ModelRenderer(this, 0, 91);
        this.fin02.setPos(0.0F, -1.2F, 0.0F);
        this.fin02.addBox(0.0F, -4.0F, 0.0F, 0, 4, 8, 0.0F);
        this.jaw = new ModelRenderer(this, 0, 77);
        this.jaw.setPos(0.0F, 0.4F, -4.0F);
        this.jaw.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 3, 0.0F);
        this.setRotateAngle(jaw, -0.045553093477052F, 0.0F, 0.0F);
        this.lTeeth = new ModelRenderer(this, 0, 82);
        this.lTeeth.setPos(-0.1F, 0.5F, 0.5F);
        this.lTeeth.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.rTeeth = new ModelRenderer(this, 0, 86);
        this.rTeeth.setPos(-0.9F, 0.5F, 0.5F);
        this.rTeeth.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.tail01 = new ModelRenderer(this, 0, 32);
        this.tail01.setPos(0.0F, -0.4F, 9.6F);
        this.tail01.addBox(-1.0F, -1.5F, 0.0F, 2, 3, 8, 0.0F);
        this.setRotateAngle(tail01, -0.03490658503988659F, 0.0F, 0.0F);
        this.mouth = new ModelRenderer(this, 0, 64);
        this.mouth.setPos(0.0F, 0.5F, -5.5F);
        this.mouth.addBox(-1.5F, -1.0F, -4.0F, 3, 2, 4, 0.0F);
        this.setRotateAngle(mouth, -0.17453292519943295F, 0.0F, 0.0F);
        this.tail02.addChild(this.fin03);
        this.body01.addChild(this.head);
        this.body01.addChild(this.body02);
        this.body02.addChild(this.fin01);
        this.jaw.addChild(this.fTeeth);
        this.mouth.addChild(this.snout);
        this.tail01.addChild(this.tail02);
        this.tail01.addChild(this.fin02);
        this.mouth.addChild(this.jaw);
        this.jaw.addChild(this.lTeeth);
        this.jaw.addChild(this.rTeeth);
        this.body02.addChild(this.tail01);
        this.head.addChild(this.mouth);
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        if(putOnSide) {
            matrixStackIn.mulPose(Vector3f.ZP.rotationDegrees(90F));
            matrixStackIn.translate(1.5F, -1.75F, 0F);
        }
        this.body01.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }
    
    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float factor = (float) entityIn.getDeltaMovement().length() * 10;
        this.body01.yRot = MathHelper.cos(ageInTicks * 0.3F) * (float) Math.PI * 0.05F * factor;
        this.head.yRot = -this.body01.yRot * 1.5F;
        this.body02.yRot = this.body01.yRot * 1.5F;
        this.tail01.yRot = this.body02.yRot * 1.5F;
        this.putOnSide = !entityIn.isInWater() && !entityIn.isPassenger();
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
