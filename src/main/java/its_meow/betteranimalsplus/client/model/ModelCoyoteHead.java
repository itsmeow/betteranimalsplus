package its_meow.betteranimalsplus.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * HeadWolf - cybercat5555
 * Created using Tabula 5.1.0
 */
public class ModelCoyoteHead extends ModelBase {
    public ModelRenderer head;
    public ModelRenderer muzzleUpper;
    public ModelRenderer muzzleLower;
    public ModelRenderer snout;
    public ModelRenderer lEar01;
    public ModelRenderer rEar01;
    public ModelRenderer lEar02;
    public ModelRenderer lEar03;
    public ModelRenderer rEar02;
    public ModelRenderer rEar03;

    public ModelCoyoteHead() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.head = new ModelRenderer(this, 45, 24);
        this.head.setRotationPoint(0.0F, 23.9F, 0.0F);
        this.head.addBox(-2.5F, -2.0F, -3.5F, 5, 5, 4, 0.0F);
        this.snout = new ModelRenderer(this, 28, 55);
        this.snout.setRotationPoint(0.0F, 0.7F, -3.3F);
        this.snout.addBox(-1.0F, -0.7F, -3.1F, 2, 1, 3, 0.0F);
        this.setRotateAngle(this.snout, 0.136659280431156F, 0.0F, 0.0F);
        this.muzzleUpper = new ModelRenderer(this, 0, 55);
        this.muzzleUpper.setRotationPoint(0.0F, 1.7F, -3.3F);
        this.muzzleUpper.addBox(-1.5F, -0.7F, -3.0F, 3, 1, 3, 0.0F);
        this.rEar01 = new ModelRenderer(this, 0, 4);
        this.rEar01.mirror = true;
        this.rEar01.setRotationPoint(-1.7F, -1.0F, -2.5F);
        this.rEar01.addBox(-1.0F, -2.2F, 0.0F, 2, 2, 1, 0.0F);
        this.setRotateAngle(this.rEar01, 0.18203784098300857F, 0.35168384427685734F, -0.18203784098300857F);
        this.lEar02 = new ModelRenderer(this, 0, 0);
        this.lEar02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lEar02.addBox(-0.5F, -3.2F, 0.0F, 1, 1, 1, 0.0F);
        this.muzzleLower = new ModelRenderer(this, 14, 55);
        this.muzzleLower.setRotationPoint(0.0F, 2.5F, -3.3F);
        this.muzzleLower.addBox(-1.5F, -0.5F, -2.9F, 3, 1, 3, 0.0F);
        this.lEar03 = new ModelRenderer(this, 21, 0);
        this.lEar03.setRotationPoint(0.0F, -0.1F, 1.3F);
        this.lEar03.addBox(-0.5F, -2.6F, -0.4F, 1, 3, 1, 0.0F);
        this.setRotateAngle(this.lEar03, 0.27314402793711257F, 0.0F, 0.0F);
        this.rEar02 = new ModelRenderer(this, 0, 0);
        this.rEar02.mirror = true;
        this.rEar02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rEar02.addBox(-0.5F, -3.2F, 0.0F, 1, 1, 1, 0.0F);
        this.lEar01 = new ModelRenderer(this, 0, 4);
        this.lEar01.setRotationPoint(1.7F, -1.0F, -2.5F);
        this.lEar01.addBox(-1.0F, -2.2F, 0.0F, 2, 2, 1, 0.0F);
        this.setRotateAngle(this.lEar01, 0.18203784098300857F, -0.35168384427685734F, 0.18203784098300857F);
        this.rEar03 = new ModelRenderer(this, 21, 0);
        this.rEar03.mirror = true;
        this.rEar03.setRotationPoint(0.0F, -0.1F, 1.3F);
        this.rEar03.addBox(-0.5F, -2.6F, -0.4F, 1, 3, 1, 0.0F);
        this.setRotateAngle(this.rEar03, 0.27314402793711257F, 0.0F, 0.0F);
        this.head.addChild(this.snout);
        this.head.addChild(this.muzzleUpper);
        this.head.addChild(this.rEar01);
        this.lEar01.addChild(this.lEar02);
        this.head.addChild(this.muzzleLower);
        this.lEar01.addChild(this.lEar03);
        this.rEar01.addChild(this.rEar02);
        this.head.addChild(this.lEar01);
        this.rEar01.addChild(this.rEar03);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.head.rotateAngleY = (float) Math.toRadians(f);
        //this.head.rotateAngleX = (float) Math.toRadians(f1);
        this.head.render(f5);
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
