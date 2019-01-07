package its_meow.betteranimalsplus.client.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * hirschgeistskull2 - cybercat5555
 * Created using Tabula 5.1.0
 */
public class ModelHirschgeistHelmet extends ModelBiped {

    public ModelRenderer head01;
    public ModelRenderer muzzle;
    public ModelRenderer lowerJaw01;
    public ModelRenderer lAnter01;
    public ModelRenderer rAnter01;
    public ModelRenderer lowerJaw02;
    public ModelRenderer lAnter02;
    public ModelRenderer lAnter03;
    public ModelRenderer lAnter04;
    public ModelRenderer lAnter05a;
    public ModelRenderer lAnter06a;
    public ModelRenderer lAnter07a;
    public ModelRenderer lAnter05b;
    public ModelRenderer lAnter06b;
    public ModelRenderer lAnter06c;
    public ModelRenderer lAnter07b;
    public ModelRenderer rAnter02;
    public ModelRenderer rAnter03;
    public ModelRenderer rAnter04;
    public ModelRenderer rAnter05a;
    public ModelRenderer rAnter06a;
    public ModelRenderer rAnter07a;
    public ModelRenderer rAnter05b;
    public ModelRenderer rAnter06b;
    public ModelRenderer rAnter06c;
    public ModelRenderer rAnter07b;

    public ModelHirschgeistHelmet() {
    	super(0.125F, 0, 128, 128);
    	this.textureWidth = 128;
        this.textureHeight = 128;
        float scale = 0.125F;
        this.lAnter07b = new ModelRenderer(this, 60, 18);
        this.lAnter07b.setRotationPoint(0.0F, 3.7F, 0.0F);
        this.lAnter07b.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, scale);
        this.setRotateAngle(lAnter07b, -0.40980330836826856F, 0.0F, 0.0F);
        this.lAnter05a = new ModelRenderer(this, 60, 18);
        this.lAnter05a.setRotationPoint(0.5F, 0.0F, 0.4F);
        this.lAnter05a.addBox(-0.5F, -0.5F, -5.4F, 1, 1, 6, scale);
        this.setRotateAngle(lAnter05a, -0.27314402793711257F, -0.40980330836826856F, 0.0F);
        this.rAnter07a = new ModelRenderer(this, 60, 18);
        this.rAnter07a.mirror = true;
        this.rAnter07a.setRotationPoint(0.3F, 0.4F, 6.0F);
        this.rAnter07a.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, scale);
        this.lAnter02 = new ModelRenderer(this, 60, 18);
        this.lAnter02.setRotationPoint(0.0F, 0.0F, -3.6F);
        this.lAnter02.addBox(-1.0F, -1.0F, -4.8F, 2, 2, 5, scale);
        this.setRotateAngle(lAnter02, 0.0F, 0.091106186954104F, 0.0F);
        this.rAnter02 = new ModelRenderer(this, 60, 18);
        this.rAnter02.mirror = true;
        this.rAnter02.setRotationPoint(0.0F, 0.0F, -3.6F);
        this.rAnter02.addBox(-1.0F, -1.0F, -4.8F, 2, 2, 5, scale);
        this.setRotateAngle(rAnter02, 0.0F, -0.091106186954104F, 0.0F);
        this.rAnter03 = new ModelRenderer(this, 60, 18);
        this.rAnter03.mirror = true;
        this.rAnter03.setRotationPoint(0.0F, 0.0F, -3.7F);
        this.rAnter03.addBox(-0.5F, -0.5F, -3.8F, 1, 1, 4, scale);
        this.setRotateAngle(rAnter03, 0.0F, -0.091106186954104F, 0.0F);
        this.rAnter06b = new ModelRenderer(this, 60, 18);
        this.rAnter06b.mirror = true;
        this.rAnter06b.setRotationPoint(0.0F, 3.8F, 0.0F);
        this.rAnter06b.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, scale);
        this.setRotateAngle(rAnter06b, 0.22759093446006054F, 0.0F, 0.0F);
        this.lAnter03 = new ModelRenderer(this, 60, 18);
        this.lAnter03.setRotationPoint(0.0F, 0.0F, -3.7F);
        this.lAnter03.addBox(-0.5F, -0.5F, -3.8F, 1, 1, 4, scale);
        this.setRotateAngle(lAnter03, 0.0F, 0.091106186954104F, 0.0F);
        this.rAnter05a = new ModelRenderer(this, 60, 18);
        this.rAnter05a.mirror = true;
        this.rAnter05a.setRotationPoint(-0.5F, 0.0F, 0.4F);
        this.rAnter05a.addBox(-0.5F, -0.5F, -5.4F, 1, 1, 6, scale);
        this.setRotateAngle(rAnter05a, -0.27314402793711257F, 0.40980330836826856F, 0.0F);
        this.lAnter06a = new ModelRenderer(this, 60, 18);
        this.lAnter06a.setRotationPoint(-0.3F, 0.3F, 4.2F);
        this.lAnter06a.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, scale);
        this.setRotateAngle(lAnter06a, -0.7740535232594852F, 0.0F, -1.1838568316277536F);
        this.rAnter07b = new ModelRenderer(this, 60, 18);
        this.rAnter07b.mirror = true;
        this.rAnter07b.setRotationPoint(0.0F, 3.7F, 0.0F);
        this.rAnter07b.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, scale);
        this.setRotateAngle(rAnter07b, -0.40980330836826856F, 0.0F, 0.0F);
        this.rAnter04 = new ModelRenderer(this, 60, 18);
        this.rAnter04.mirror = true;
        this.rAnter04.setRotationPoint(0.0F, 0.0F, -3.7F);
        this.rAnter04.addBox(-0.5F, -0.5F, -3.8F, 1, 1, 4, scale);
        this.setRotateAngle(rAnter04, 0.22759093446006054F, -0.18203784098300857F, 0.0F);
        this.rAnter06c = new ModelRenderer(this, 60, 18);
        this.rAnter06c.mirror = true;
        this.rAnter06c.setRotationPoint(0.0F, 2.8F, 0.1F);
        this.rAnter06c.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, scale);
        this.setRotateAngle(rAnter06c, -0.4553564018453205F, 0.0F, 0.0F);
        this.rAnter05b = new ModelRenderer(this, 60, 18);
        this.rAnter05b.mirror = true;
        this.rAnter05b.setRotationPoint(0.0F, 0.0F, -5.3F);
        this.rAnter05b.addBox(-0.5F, -0.5F, -5.6F, 1, 1, 6, scale);
        this.setRotateAngle(rAnter05b, 0.18203784098300857F, -0.18203784098300857F, 0.0F);
        this.lAnter06c = new ModelRenderer(this, 60, 18);
        this.lAnter06c.setRotationPoint(0.0F, 2.8F, 0.1F);
        this.lAnter06c.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, scale);
        this.setRotateAngle(lAnter06c, -0.4553564018453205F, 0.0F, 0.0F);
        this.lAnter01 = new ModelRenderer(this, 60, 18);
        this.lAnter01.setRotationPoint(2.3F, -2.5F, -7.4F);
        this.lAnter01.addBox(-1.5F, -1.5F, -4.0F, 3, 3, 4, scale);
        this.setRotateAngle(lAnter01, -0.4363323129985824F, -0.5462880558742251F, 0.0F);
        this.head01 = new ModelRenderer(this, 59, 0);
        this.head01.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head01.addBox(-4.5F, -5F, -8.5F, 9, 10, 7, scale);
        this.setRotateAngle(head01, -1.5707963267948966F, 0.0F, 0.0F);
        this.lowerJaw01 = new ModelRenderer(this, 102, 9);
        this.lowerJaw01.setRotationPoint(0.0F, 4.4F, -3.1F);
        this.lowerJaw01.addBox(-3.2F, 0.0F, 0.0F, 7, 5, 2, scale);
        this.setRotateAngle(lowerJaw01, -0.045553093477052F, 0.0F, 0.0F);
        this.lAnter07a = new ModelRenderer(this, 60, 18);
        this.lAnter07a.setRotationPoint(-0.3F, 0.4F, 6.0F);
        this.lAnter07a.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, scale);
        this.lAnter04 = new ModelRenderer(this, 60, 18);
        this.lAnter04.setRotationPoint(0.0F, 0.0F, -3.7F);
        this.lAnter04.addBox(-0.5F, -0.5F, -3.8F, 1, 1, 4, scale);
        this.setRotateAngle(lAnter04, 0.22759093446006054F, 0.18203784098300857F, 0.0F);
        this.rAnter06a = new ModelRenderer(this, 60, 18);
        this.rAnter06a.mirror = true;
        this.rAnter06a.setRotationPoint(0.3F, 0.3F, 4.2F);
        this.rAnter06a.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, scale);
        this.setRotateAngle(rAnter06a, -0.7740535232594852F, 0.0F, 1.1838568316277536F);
        this.rAnter01 = new ModelRenderer(this, 60, 18);
        this.rAnter01.mirror = true;
        this.rAnter01.setRotationPoint(-2.3F, -2.5F, -7.4F);
        this.rAnter01.addBox(-1.5F, -1.5F, -4.0F, 3, 3, 4, scale);
        this.setRotateAngle(rAnter01, -0.4363323129985824F, 0.5462880558742251F, 0.0F);
        this.lowerJaw02 = new ModelRenderer(this, 94, 9);
        this.lowerJaw02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lowerJaw02.addBox(-3.8F, 0.0F, 0.0F, 1, 5, 2, scale);
        this.muzzle = new ModelRenderer(this, 93, 0);
        this.muzzle.setRotationPoint(0.0F, 0.0F, -0.3F);
        this.muzzle.addBox(-4.0F, 4.2F, -6.6F, 8, 5, 4, scale);
        this.setRotateAngle(muzzle, 0.136659280431156F, 0.0F, 0.0F);
        this.lAnter05b = new ModelRenderer(this, 60, 18);
        this.lAnter05b.setRotationPoint(0.0F, 0.0F, -5.3F);
        this.lAnter05b.addBox(-0.5F, -0.5F, -5.6F, 1, 1, 6, scale);
        this.setRotateAngle(lAnter05b, 0.18203784098300857F, 0.18203784098300857F, 0.0F);
        this.lAnter06b = new ModelRenderer(this, 60, 18);
        this.lAnter06b.setRotationPoint(0.0F, 3.8F, 0.0F);
        this.lAnter06b.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, scale);
        this.setRotateAngle(lAnter06b, 0.22759093446006054F, 0.0F, 0.0F);
        this.lAnter07a.addChild(this.lAnter07b);
        this.lAnter03.addChild(this.lAnter05a);
        this.rAnter03.addChild(this.rAnter07a);
        this.lAnter01.addChild(this.lAnter02);
        this.rAnter01.addChild(this.rAnter02);
        this.rAnter02.addChild(this.rAnter03);
        this.rAnter06a.addChild(this.rAnter06b);
        this.lAnter02.addChild(this.lAnter03);
        this.rAnter03.addChild(this.rAnter05a);
        this.lAnter03.addChild(this.lAnter06a);
        this.rAnter07a.addChild(this.rAnter07b);
        this.rAnter03.addChild(this.rAnter04);
        this.rAnter06b.addChild(this.rAnter06c);
        this.rAnter05a.addChild(this.rAnter05b);
        this.lAnter06b.addChild(this.lAnter06c);
        this.head01.addChild(this.lAnter01);
        this.head01.addChild(this.lowerJaw01);
        this.lAnter03.addChild(this.lAnter07a);
        this.lAnter03.addChild(this.lAnter04);
        this.rAnter03.addChild(this.rAnter06a);
        this.head01.addChild(this.rAnter01);
        this.lowerJaw01.addChild(this.lowerJaw02);
        this.head01.addChild(this.muzzle);
        this.lAnter05a.addChild(this.lAnter05b);
        this.lAnter06a.addChild(this.lAnter06b);
        
        this.bipedHead.addChild(this.head01);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	super.render(entity, f, f1, f2, f3, f4, f5);
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
