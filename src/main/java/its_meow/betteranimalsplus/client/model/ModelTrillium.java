package its_meow.betteranimalsplus.client.model;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.model.ModelBase;
import net.minecraft.client.renderer.entity.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * trillium - cybercat5555 Created using Tabula 5.1.0
 */
public class ModelTrillium extends ModelBase {

    public ModelRenderer stem01;
    public ModelRenderer stem02;
    public ModelRenderer stem03;
    public ModelRenderer stem04;
    public ModelRenderer stem05;
    public ModelRenderer largeLeaf01a;
    public ModelRenderer largeLeaf02a;
    public ModelRenderer largeLeaf03a;
    public ModelRenderer largeLeaf01b;
    public ModelRenderer largeLeaf02b;
    public ModelRenderer largeLeaf03b;
    public ModelRenderer smallLeaf01a;
    public ModelRenderer smallLeaf02a;
    public ModelRenderer smallLeaf03a;
    public ModelRenderer petal01a;
    public ModelRenderer petal02a;
    public ModelRenderer petal03a;
    public ModelRenderer smallLeaf01b;
    public ModelRenderer smallLeaf02b;
    public ModelRenderer smallLeaf03b;
    public ModelRenderer petal01b;
    public ModelRenderer petal02b;
    public ModelRenderer petal03b;

    public ModelTrillium() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.petal02a = new ModelRenderer(this, 18, 19);
        this.petal02a.setRotationPoint(0.0F, -0.3F, 0.0F);
        this.petal02a.addBox(-2.5F, -5.6F, -0.7F, 5, 5, 0, 0.0F);
        this.setRotateAngle(this.petal02a, 0.6373942428283291F, 2.0943951023931953F, 0.0F);
        this.petal02b = new ModelRenderer(this, 19, 24);
        this.petal02b.setRotationPoint(0.0F, -5.6F, -0.7F);
        this.petal02b.addBox(-1.5F, -3.0F, 0.0F, 3, 3, 0, 0.0F);
        this.setRotateAngle(this.petal02b, -0.22759093446006054F, 0.0F, 0.0F);
        this.largeLeaf03b = new ModelRenderer(this, 11, 10);
        this.largeLeaf03b.setRotationPoint(10.0F, 0.0F, 0.0F);
        this.largeLeaf03b.addBox(0.0F, 0.0F, -3.0F, 8, 0, 6, 0.0F);
        this.setRotateAngle(this.largeLeaf03b, 0.0F, 0.0F, 0.136659280431156F);
        this.largeLeaf02b = new ModelRenderer(this, 11, 10);
        this.largeLeaf02b.setRotationPoint(10.0F, 0.0F, 0.0F);
        this.largeLeaf02b.addBox(0.0F, 0.0F, -3.0F, 8, 0, 6, 0.0F);
        this.setRotateAngle(this.largeLeaf02b, 0.0F, 0.0F, 0.136659280431156F);
        this.largeLeaf03a = new ModelRenderer(this, 7, 0);
        this.largeLeaf03a.setRotationPoint(0.0F, -1.5F, 0.0F);
        this.largeLeaf03a.addBox(0.0F, 0.0F, -5.0F, 10, 0, 10, 0.0F);
        this.setRotateAngle(this.largeLeaf03a, 0.36425021489121656F, -2.0943951023931953F, -0.4553564018453205F);
        this.smallLeaf03a = new ModelRenderer(this, 31, 0);
        this.smallLeaf03a.setRotationPoint(0.5F, -0.3F, 0.0F);
        this.smallLeaf03a.addBox(0.0F, 0.0F, -4.5F, 9, 0, 9, 0.0F);
        this.setRotateAngle(this.smallLeaf03a, 0.091106186954104F, -1.0471975511965976F, -0.091106186954104F);
        this.largeLeaf01a = new ModelRenderer(this, 7, 0);
        this.largeLeaf01a.setRotationPoint(0.0F, -1.5F, 0.0F);
        this.largeLeaf01a.addBox(0.0F, 0.0F, -5.0F, 10, 0, 10, 0.0F);
        this.setRotateAngle(this.largeLeaf01a, 0.0F, 0.0F, 0.27314402793711257F);
        this.smallLeaf01a = new ModelRenderer(this, 31, 0);
        this.smallLeaf01a.setRotationPoint(0.5F, -0.3F, 0.0F);
        this.smallLeaf01a.addBox(0.0F, 0.0F, -4.5F, 9, 0, 9, 0.0F);
        this.setRotateAngle(this.smallLeaf01a, 0.0F, 3.141592653589793F, 0.091106186954104F);
        this.stem05 = new ModelRenderer(this, 0, 25);
        this.stem05.setRotationPoint(0.0F, 12.0F, 0.0F);
        this.stem05.addBox(-1.0F, -1.0F, -1.0F, 2, 1, 2, 0.0F);
        this.largeLeaf01b = new ModelRenderer(this, 11, 10);
        this.largeLeaf01b.setRotationPoint(10.0F, 0.0F, 0.0F);
        this.largeLeaf01b.addBox(0.0F, 0.0F, -3.0F, 8, 0, 6, 0.0F);
        this.setRotateAngle(this.largeLeaf01b, 0.0F, 0.0F, 0.136659280431156F);
        this.largeLeaf02a = new ModelRenderer(this, 7, 0);
        this.largeLeaf02a.setRotationPoint(0.0F, -1.5F, 0.0F);
        this.largeLeaf02a.addBox(0.0F, 0.0F, -5.0F, 10, 0, 10, 0.0F);
        this.setRotateAngle(this.largeLeaf02a, -0.36425021489121656F, 2.0943951023931953F, -0.4553564018453205F);
        this.petal01a = new ModelRenderer(this, 18, 19);
        this.petal01a.setRotationPoint(0.0F, -0.3F, 0.0F);
        this.petal01a.addBox(-2.5F, -5.6F, -0.7F, 5, 5, 0, 0.0F);
        this.setRotateAngle(this.petal01a, 0.6373942428283291F, 0.0F, 0.0F);
        this.stem01 = new ModelRenderer(this, 0, 0);
        this.stem01.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.stem01.addBox(-1.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
        this.stem02 = new ModelRenderer(this, 0, 5);
        this.stem02.setRotationPoint(0.0F, 22.1F, 0.0F);
        this.stem02.addBox(-1.0F, -3.0F, -1.0F, 2, 3, 2, 0.0F);
        this.stem04 = new ModelRenderer(this, 0, 19);
        this.stem04.setRotationPoint(0.0F, 13.4F, 0.0F);
        this.stem04.addBox(-1.0F, -1.7F, -1.0F, 2, 2, 2, 0.0F);
        this.smallLeaf03b = new ModelRenderer(this, 35, 9);
        this.smallLeaf03b.setRotationPoint(9.0F, 0.0F, 0.0F);
        this.smallLeaf03b.addBox(0.0F, 0.0F, -2.5F, 7, 0, 5, 0.0F);
        this.setRotateAngle(this.smallLeaf03b, 0.0F, 0.0F, 0.091106186954104F);
        this.stem03 = new ModelRenderer(this, 0, 11);
        this.stem03.setRotationPoint(0.0F, 19.4F, 0.0F);
        this.stem03.addBox(-0.5F, -6.1F, -0.5F, 1, 6, 1, 0.0F);
        this.smallLeaf01b = new ModelRenderer(this, 35, 9);
        this.smallLeaf01b.setRotationPoint(9.0F, 0.0F, 0.0F);
        this.smallLeaf01b.addBox(0.0F, 0.0F, -2.5F, 7, 0, 5, 0.0F);
        this.setRotateAngle(this.smallLeaf01b, 0.0F, 0.0F, 0.091106186954104F);
        this.petal01b = new ModelRenderer(this, 19, 24);
        this.petal01b.setRotationPoint(0.0F, -5.6F, -0.7F);
        this.petal01b.addBox(-1.5F, -3.0F, 0.0F, 3, 3, 0, 0.0F);
        this.setRotateAngle(this.petal01b, -0.22759093446006054F, 0.0F, 0.0F);
        this.petal03a = new ModelRenderer(this, 18, 19);
        this.petal03a.setRotationPoint(0.0F, -0.3F, 0.0F);
        this.petal03a.addBox(-2.5F, -5.6F, -0.7F, 5, 5, 0, 0.0F);
        this.setRotateAngle(this.petal03a, 0.6373942428283291F, -2.0943951023931953F, 0.0F);
        this.smallLeaf02a = new ModelRenderer(this, 31, 0);
        this.smallLeaf02a.setRotationPoint(0.5F, -0.3F, 0.0F);
        this.smallLeaf02a.addBox(0.0F, 0.0F, -4.5F, 9, 0, 9, 0.0F);
        this.setRotateAngle(this.smallLeaf02a, -0.091106186954104F, 1.0471975511965976F, -0.091106186954104F);
        this.smallLeaf02b = new ModelRenderer(this, 35, 9);
        this.smallLeaf02b.setRotationPoint(9.0F, 0.0F, 0.0F);
        this.smallLeaf02b.addBox(0.0F, 0.0F, -2.5F, 7, 0, 5, 0.0F);
        this.setRotateAngle(this.smallLeaf02b, 0.0F, 0.0F, 0.091106186954104F);
        this.petal03b = new ModelRenderer(this, 19, 24);
        this.petal03b.setRotationPoint(0.0F, -5.6F, -0.7F);
        this.petal03b.addBox(-1.5F, -3.0F, 0.0F, 3, 3, 0, 0.0F);
        this.setRotateAngle(this.petal03b, -0.22759093446006054F, 0.0F, 0.0F);
        this.stem05.addChild(this.petal02a);
        this.petal02a.addChild(this.petal02b);
        this.largeLeaf03a.addChild(this.largeLeaf03b);
        this.largeLeaf02a.addChild(this.largeLeaf02b);
        this.stem04.addChild(this.largeLeaf03a);
        this.stem05.addChild(this.smallLeaf03a);
        this.stem04.addChild(this.largeLeaf01a);
        this.stem05.addChild(this.smallLeaf01a);
        this.largeLeaf01a.addChild(this.largeLeaf01b);
        this.stem04.addChild(this.largeLeaf02a);
        this.stem05.addChild(this.petal01a);
        this.smallLeaf03a.addChild(this.smallLeaf03b);
        this.smallLeaf01a.addChild(this.smallLeaf01b);
        this.petal01a.addChild(this.petal01b);
        this.stem05.addChild(this.petal03a);
        this.stem05.addChild(this.smallLeaf02a);
        this.smallLeaf02a.addChild(this.smallLeaf02b);
        this.petal03a.addChild(this.petal03b);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.rotatef(f3, 0, 1, 0); // Yaw
        GlStateManager.pushMatrix();
        GlStateManager.translatef(this.stem05.offsetX, this.stem05.offsetY, this.stem05.offsetZ);
        GlStateManager.translatef(this.stem05.rotationPointX * f5, this.stem05.rotationPointY * f5,
                this.stem05.rotationPointZ * f5);
        GlStateManager.scaled(0.4D, 0.7D, 0.4D);
        GlStateManager.translatef(-this.stem05.offsetX, -this.stem05.offsetY, -this.stem05.offsetZ);
        GlStateManager.translatef(-this.stem05.rotationPointX * f5, -this.stem05.rotationPointY * f5,
                -this.stem05.rotationPointZ * f5);
        this.stem05.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translatef(this.stem01.offsetX, this.stem01.offsetY, this.stem01.offsetZ);
        GlStateManager.translatef(this.stem01.rotationPointX * f5, this.stem01.rotationPointY * f5,
                this.stem01.rotationPointZ * f5);
        GlStateManager.scaled(0.8D, 1.0D, 0.8D);
        GlStateManager.translatef(-this.stem01.offsetX, -this.stem01.offsetY, -this.stem01.offsetZ);
        GlStateManager.translatef(-this.stem01.rotationPointX * f5, -this.stem01.rotationPointY * f5,
                -this.stem01.rotationPointZ * f5);
        this.stem01.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translatef(this.stem02.offsetX, this.stem02.offsetY, this.stem02.offsetZ);
        GlStateManager.translatef(this.stem02.rotationPointX * f5, this.stem02.rotationPointY * f5,
                this.stem02.rotationPointZ * f5);
        GlStateManager.scaled(0.7D, 1.0D, 0.7D);
        GlStateManager.translatef(-this.stem02.offsetX, -this.stem02.offsetY, -this.stem02.offsetZ);
        GlStateManager.translatef(-this.stem02.rotationPointX * f5, -this.stem02.rotationPointY * f5,
                -this.stem02.rotationPointZ * f5);
        this.stem02.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translatef(this.stem04.offsetX, this.stem04.offsetY, this.stem04.offsetZ);
        GlStateManager.translatef(this.stem04.rotationPointX * f5, this.stem04.rotationPointY * f5,
                this.stem04.rotationPointZ * f5);
        GlStateManager.scaled(0.8D, 1.0D, 0.8D);
        GlStateManager.translatef(-this.stem04.offsetX, -this.stem04.offsetY, -this.stem04.offsetZ);
        GlStateManager.translatef(-this.stem04.rotationPointX * f5, -this.stem04.rotationPointY * f5,
                -this.stem04.rotationPointZ * f5);
        this.stem04.render(f5);
        GlStateManager.popMatrix();
        this.stem03.render(f5);
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
