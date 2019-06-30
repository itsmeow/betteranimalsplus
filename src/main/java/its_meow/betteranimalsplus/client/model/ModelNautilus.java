package its_meow.betteranimalsplus.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

/**
 * nautilus - cybercat5555
 * Created using Tabula 5.1.0
 */
public class ModelNautilus extends ModelBase {
    public ModelRenderer shell;
    public ModelRenderer lTentacle01a;
    public ModelRenderer lTentacle02a;
    public ModelRenderer lTentacle04a;
    public ModelRenderer lTentacle03a;
    public ModelRenderer rTentacle01a;
    public ModelRenderer rTentacle02a;
    public ModelRenderer rTentacle04a;
    public ModelRenderer rTentacle03a;
    public ModelRenderer shellEdge;
    public ModelRenderer headShield;
    public ModelRenderer head;
    public ModelRenderer lEye;
    public ModelRenderer rEye;
    public ModelRenderer lTentacle01b;
    public ModelRenderer lTentacle03b;
    public ModelRenderer lTentacle04b;
    public ModelRenderer lTentacle03b_1;
    public ModelRenderer rTentacle01b;
    public ModelRenderer rTentacle02b;
    public ModelRenderer rTentacle04b;
    public ModelRenderer rTentacle03b;

    public ModelNautilus() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.rTentacle01a = new ModelRenderer(this, 29, 19);
        this.rTentacle01a.mirror = true;
        this.rTentacle01a.setRotationPoint(-1.6F, 14.9F, -6.0F);
        this.rTentacle01a.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(rTentacle01a, 0.27314402793711257F, 0.22759093446006054F, 0.0F);
        this.shellEdge = new ModelRenderer(this, 0, 19);
        this.shellEdge.setRotationPoint(0.0F, 3.6F, -3.6F);
        this.shellEdge.addBox(-2.5F, -1.0F, -4.8F, 5, 2, 4, 0.0F);
        this.setRotateAngle(shellEdge, -0.091106186954104F, 0.0F, 0.0F);
        this.lTentacle04b = new ModelRenderer(this, 29, 19);
        this.lTentacle04b.setRotationPoint(0.0F, 0.0F, -2.9F);
        this.lTentacle04b.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(lTentacle04b, 0.18203784098300857F, 0.0F, 0.0F);
        this.rEye = new ModelRenderer(this, 44, 9);
        this.rEye.mirror = true;
        this.rEye.setRotationPoint(-1.3F, 0.2F, -1.1F);
        this.rEye.addBox(-1.0F, -1.0F, -1.0F, 1, 2, 2, 0.0F);
        this.setRotateAngle(rEye, 0.7853981633974483F, 0.0F, 0.0F);
        this.lTentacle02a = new ModelRenderer(this, 29, 19);
        this.lTentacle02a.setRotationPoint(1.6F, 16.5F, -6.0F);
        this.lTentacle02a.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(lTentacle02a, 0.4553564018453205F, -0.18203784098300857F, 0.0F);
        this.lTentacle03b = new ModelRenderer(this, 29, 19);
        this.lTentacle03b.setRotationPoint(0.0F, 0.0F, -2.9F);
        this.lTentacle03b.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(lTentacle03b, 0.18203784098300857F, 0.0F, 0.0F);
        this.lTentacle03b_1 = new ModelRenderer(this, 29, 19);
        this.lTentacle03b_1.setRotationPoint(0.0F, 0.0F, -2.9F);
        this.lTentacle03b_1.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(lTentacle03b_1, 0.18203784098300857F, 0.0F, 0.0F);
        this.lTentacle01b = new ModelRenderer(this, 29, 19);
        this.lTentacle01b.setRotationPoint(0.0F, 0.0F, -2.9F);
        this.lTentacle01b.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(lTentacle01b, 0.18203784098300857F, 0.0F, 0.0F);
        this.rTentacle03b = new ModelRenderer(this, 29, 19);
        this.rTentacle03b.mirror = true;
        this.rTentacle03b.setRotationPoint(0.0F, 0.0F, -2.9F);
        this.rTentacle03b.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(rTentacle03b, 0.18203784098300857F, 0.0F, 0.0F);
        this.rTentacle04b = new ModelRenderer(this, 29, 19);
        this.rTentacle04b.mirror = true;
        this.rTentacle04b.setRotationPoint(0.0F, 0.0F, -2.9F);
        this.rTentacle04b.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(rTentacle04b, 0.18203784098300857F, 0.0F, 0.0F);
        this.rTentacle02b = new ModelRenderer(this, 29, 19);
        this.rTentacle02b.mirror = true;
        this.rTentacle02b.setRotationPoint(0.0F, 0.0F, -2.9F);
        this.rTentacle02b.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(rTentacle02b, 0.18203784098300857F, 0.0F, 0.0F);
        this.rTentacle04a = new ModelRenderer(this, 29, 19);
        this.rTentacle04a.mirror = true;
        this.rTentacle04a.setRotationPoint(-0.6F, 15.0F, -6.0F);
        this.rTentacle04a.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(rTentacle04a, 0.31869712141416456F, 0.18203784098300857F, 0.0F);
        this.lTentacle04a = new ModelRenderer(this, 29, 19);
        this.lTentacle04a.setRotationPoint(0.6F, 15.0F, -6.0F);
        this.lTentacle04a.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(lTentacle04a, 0.31869712141416456F, -0.18203784098300857F, 0.0F);
        this.rTentacle02a = new ModelRenderer(this, 29, 19);
        this.rTentacle02a.mirror = true;
        this.rTentacle02a.setRotationPoint(-1.6F, 16.5F, -6.0F);
        this.rTentacle02a.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(rTentacle02a, 0.4553564018453205F, 0.18203784098300857F, 0.0F);
        this.lEye = new ModelRenderer(this, 44, 9);
        this.lEye.setRotationPoint(1.3F, 0.2F, -1.1F);
        this.lEye.addBox(0.0F, -1.0F, -1.0F, 1, 2, 2, 0.0F);
        this.setRotateAngle(lEye, 0.7853981633974483F, 0.0F, 0.0F);
        this.rTentacle01b = new ModelRenderer(this, 29, 19);
        this.rTentacle01b.mirror = true;
        this.rTentacle01b.setRotationPoint(0.0F, 0.0F, -2.9F);
        this.rTentacle01b.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(rTentacle01b, 0.18203784098300857F, 0.0F, 0.0F);
        this.rTentacle03a = new ModelRenderer(this, 29, 19);
        this.rTentacle03a.mirror = true;
        this.rTentacle03a.setRotationPoint(-0.6F, 16.2F, -6.0F);
        this.rTentacle03a.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(rTentacle03a, 0.36425021489121656F, 0.136659280431156F, 0.0F);
        this.lTentacle01a = new ModelRenderer(this, 29, 19);
        this.lTentacle01a.setRotationPoint(1.6F, 14.9F, -6.0F);
        this.lTentacle01a.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(lTentacle01a, 0.27314402793711257F, -0.22759093446006054F, 0.0F);
        this.headShield = new ModelRenderer(this, 21, 0);
        this.headShield.setRotationPoint(0.0F, -2.1F, -3.6F);
        this.headShield.addBox(-3.0F, -1.0F, -5.0F, 6, 2, 5, 0.0F);
        this.setRotateAngle(headShield, 0.18203784098300857F, 0.0F, 0.0F);
        this.shell = new ModelRenderer(this, 0, 0);
        this.shell.setRotationPoint(0.0F, 15.0F, 1.0F);
        this.shell.addBox(-2.5F, -4.5F, -4.5F, 5, 9, 9, 0.0F);
        this.lTentacle03a = new ModelRenderer(this, 29, 19);
        this.lTentacle03a.setRotationPoint(0.6F, 16.2F, -6.0F);
        this.lTentacle03a.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(lTentacle03a, 0.36425021489121656F, -0.136659280431156F, 0.0F);
        this.head = new ModelRenderer(this, 29, 9);
        this.head.setRotationPoint(0.0F, 1.0F, -4.4F);
        this.head.addBox(-2.0F, -2.0F, -3.0F, 4, 4, 3, 0.0F);
        this.shell.addChild(this.shellEdge);
        this.lTentacle04a.addChild(this.lTentacle04b);
        this.head.addChild(this.rEye);
        this.lTentacle02a.addChild(this.lTentacle03b);
        this.lTentacle03a.addChild(this.lTentacle03b_1);
        this.lTentacle01a.addChild(this.lTentacle01b);
        this.rTentacle03a.addChild(this.rTentacle03b);
        this.rTentacle04a.addChild(this.rTentacle04b);
        this.rTentacle02a.addChild(this.rTentacle02b);
        this.head.addChild(this.lEye);
        this.rTentacle01a.addChild(this.rTentacle01b);
        this.shell.addChild(this.headShield);
        this.shell.addChild(this.head);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.rTentacle01a.offsetX, this.rTentacle01a.offsetY, this.rTentacle01a.offsetZ);
        GlStateManager.translate(this.rTentacle01a.rotationPointX * f5, this.rTentacle01a.rotationPointY * f5, this.rTentacle01a.rotationPointZ * f5);
        GlStateManager.scale(0.8D, 0.8D, 0.8D);
        GlStateManager.translate(-this.rTentacle01a.offsetX, -this.rTentacle01a.offsetY, -this.rTentacle01a.offsetZ);
        GlStateManager.translate(-this.rTentacle01a.rotationPointX * f5, -this.rTentacle01a.rotationPointY * f5, -this.rTentacle01a.rotationPointZ * f5);
        this.rTentacle01a.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.lTentacle02a.offsetX, this.lTentacle02a.offsetY, this.lTentacle02a.offsetZ);
        GlStateManager.translate(this.lTentacle02a.rotationPointX * f5, this.lTentacle02a.rotationPointY * f5, this.lTentacle02a.rotationPointZ * f5);
        GlStateManager.scale(0.9D, 0.9D, 0.9D);
        GlStateManager.translate(-this.lTentacle02a.offsetX, -this.lTentacle02a.offsetY, -this.lTentacle02a.offsetZ);
        GlStateManager.translate(-this.lTentacle02a.rotationPointX * f5, -this.lTentacle02a.rotationPointY * f5, -this.lTentacle02a.rotationPointZ * f5);
        this.lTentacle02a.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.rTentacle04a.offsetX, this.rTentacle04a.offsetY, this.rTentacle04a.offsetZ);
        GlStateManager.translate(this.rTentacle04a.rotationPointX * f5, this.rTentacle04a.rotationPointY * f5, this.rTentacle04a.rotationPointZ * f5);
        GlStateManager.scale(0.9D, 0.9D, 0.9D);
        GlStateManager.translate(-this.rTentacle04a.offsetX, -this.rTentacle04a.offsetY, -this.rTentacle04a.offsetZ);
        GlStateManager.translate(-this.rTentacle04a.rotationPointX * f5, -this.rTentacle04a.rotationPointY * f5, -this.rTentacle04a.rotationPointZ * f5);
        this.rTentacle04a.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.lTentacle04a.offsetX, this.lTentacle04a.offsetY, this.lTentacle04a.offsetZ);
        GlStateManager.translate(this.lTentacle04a.rotationPointX * f5, this.lTentacle04a.rotationPointY * f5, this.lTentacle04a.rotationPointZ * f5);
        GlStateManager.scale(0.9D, 0.9D, 0.9D);
        GlStateManager.translate(-this.lTentacle04a.offsetX, -this.lTentacle04a.offsetY, -this.lTentacle04a.offsetZ);
        GlStateManager.translate(-this.lTentacle04a.rotationPointX * f5, -this.lTentacle04a.rotationPointY * f5, -this.lTentacle04a.rotationPointZ * f5);
        this.lTentacle04a.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.rTentacle02a.offsetX, this.rTentacle02a.offsetY, this.rTentacle02a.offsetZ);
        GlStateManager.translate(this.rTentacle02a.rotationPointX * f5, this.rTentacle02a.rotationPointY * f5, this.rTentacle02a.rotationPointZ * f5);
        GlStateManager.scale(0.9D, 0.9D, 0.9D);
        GlStateManager.translate(-this.rTentacle02a.offsetX, -this.rTentacle02a.offsetY, -this.rTentacle02a.offsetZ);
        GlStateManager.translate(-this.rTentacle02a.rotationPointX * f5, -this.rTentacle02a.rotationPointY * f5, -this.rTentacle02a.rotationPointZ * f5);
        this.rTentacle02a.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.rTentacle03a.offsetX, this.rTentacle03a.offsetY, this.rTentacle03a.offsetZ);
        GlStateManager.translate(this.rTentacle03a.rotationPointX * f5, this.rTentacle03a.rotationPointY * f5, this.rTentacle03a.rotationPointZ * f5);
        GlStateManager.scale(0.9D, 0.9D, 0.9D);
        GlStateManager.translate(-this.rTentacle03a.offsetX, -this.rTentacle03a.offsetY, -this.rTentacle03a.offsetZ);
        GlStateManager.translate(-this.rTentacle03a.rotationPointX * f5, -this.rTentacle03a.rotationPointY * f5, -this.rTentacle03a.rotationPointZ * f5);
        this.rTentacle03a.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.lTentacle01a.offsetX, this.lTentacle01a.offsetY, this.lTentacle01a.offsetZ);
        GlStateManager.translate(this.lTentacle01a.rotationPointX * f5, this.lTentacle01a.rotationPointY * f5, this.lTentacle01a.rotationPointZ * f5);
        GlStateManager.scale(0.8D, 0.8D, 0.8D);
        GlStateManager.translate(-this.lTentacle01a.offsetX, -this.lTentacle01a.offsetY, -this.lTentacle01a.offsetZ);
        GlStateManager.translate(-this.lTentacle01a.rotationPointX * f5, -this.lTentacle01a.rotationPointY * f5, -this.lTentacle01a.rotationPointZ * f5);
        this.lTentacle01a.render(f5);
        GlStateManager.popMatrix();
        this.shell.render(f5);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.lTentacle03a.offsetX, this.lTentacle03a.offsetY, this.lTentacle03a.offsetZ);
        GlStateManager.translate(this.lTentacle03a.rotationPointX * f5, this.lTentacle03a.rotationPointY * f5, this.lTentacle03a.rotationPointZ * f5);
        GlStateManager.scale(0.9D, 0.9D, 0.9D);
        GlStateManager.translate(-this.lTentacle03a.offsetX, -this.lTentacle03a.offsetY, -this.lTentacle03a.offsetZ);
        GlStateManager.translate(-this.lTentacle03a.rotationPointX * f5, -this.lTentacle03a.rotationPointY * f5, -this.lTentacle03a.rotationPointZ * f5);
        this.lTentacle03a.render(f5);
        GlStateManager.popMatrix();
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
            float headPitch, float scaleFactor, Entity entityIn) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        float mul = 0.3F;
        float div = 20F;
        float add = entityIn.getUniqueID().hashCode() * 0.001F;
        lTentacle01a.rotateAngleX = (float) Math.cos(ageInTicks * (mul + 0.05F) + add) / div;
        lTentacle02a.rotateAngleX = (float) Math.cos(ageInTicks * mul + add) / div;
        lTentacle04a.rotateAngleX = (float) Math.cos(ageInTicks * (mul + 0.1F) + add) / div;
        lTentacle03a.rotateAngleX = (float) Math.sin(ageInTicks * mul + add) / div;
        rTentacle01a.rotateAngleX = (float) Math.cos(ageInTicks * mul + add) / div;
        rTentacle02a.rotateAngleX = (float) Math.cos(ageInTicks * (mul + 0.03F) + add) / div;
        rTentacle04a.rotateAngleX = (float) Math.cos(ageInTicks * mul + add) / div;
        rTentacle03a.rotateAngleX = (float) Math.sin(ageInTicks * (mul + 0.15F) + add) / div;
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
