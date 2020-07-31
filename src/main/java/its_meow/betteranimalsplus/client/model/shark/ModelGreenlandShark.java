package its_meow.betteranimalsplus.client.model.shark;

import its_meow.betteranimalsplus.common.entity.EntityShark;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;

/**
 * Greenland Shark - Undefined
 * Created using Tabula 7.0.1
 */
public class ModelGreenlandShark extends EntityModel<EntityShark> {
    public RendererModel body;
    public RendererModel tail00;
    public RendererModel neck;
    public RendererModel dorsalFin00;
    public RendererModel lFin00;
    public RendererModel rFin00;
    public RendererModel tail01;
    public RendererModel tail02;
    public RendererModel upperTailFin;
    public RendererModel tail03;
    public RendererModel tail04;
    public RendererModel upperTailFin2;
    public RendererModel lLowerTailFin;
    public RendererModel rLowerTailFin;
    public RendererModel tail05;
    public RendererModel tailFinUpper00;
    public RendererModel tailFinLower00;
    public RendererModel tailFinUpper01;
    public RendererModel tailFinUpper02;
    public RendererModel tailFinLower01;
    public RendererModel tailFinLower02;
    public RendererModel head;
    public RendererModel lowerJaw;
    public RendererModel snout;
    public RendererModel teethUpper;
    public RendererModel headUpper;
    public RendererModel teethLower;
    public RendererModel dorsalFin01;
    public RendererModel dorsalFin03;
    public RendererModel dorsalFin02;
    public RendererModel dorsalFin04;
    public RendererModel lFin01;
    public RendererModel lFin02;
    public RendererModel rFin01;
    public RendererModel rFin02;

    public ModelGreenlandShark() {
        this.textureWidth = 60;
        this.textureHeight = 200;
        this.neck = new RendererModel(this, 0, 104);
        this.neck.setRotationPoint(0.0F, 0.0F, -13.6F);
        this.neck.addBox(-4.0F, -5.5F, -9.0F, 8, 9, 9, 0.0F);
        this.setRotateAngle(neck, 0.045553093477052F, 0.0F, 0.0F);
        this.dorsalFin01 = new RendererModel(this, 26, 134);
        this.dorsalFin01.setRotationPoint(0.0F, -1.1F, 0.0F);
        this.dorsalFin01.addBox(-1.0F, 0.0F, 0.0F, 1, 1, 5, 0.0F);
        this.tail04 = new RendererModel(this, 0, 89);
        this.tail04.setRotationPoint(0.0F, -0.4F, 4.9F);
        this.tail04.addBox(-1.0F, -1.5F, 0.0F, 2, 3, 4, 0.0F);
        this.snout = new RendererModel(this, 0, 135);
        this.snout.setRotationPoint(0.0F, -0.5F, -8.7F);
        this.snout.addBox(-2.5F, 0.0F, 0.0F, 5, 5, 3, 0.0F);
        this.setRotateAngle(snout, 1.2747884856566583F, 0.0F, 0.0F);
        this.rFin02 = new RendererModel(this, 0, 189);
        this.rFin02.setRotationPoint(0.0F, 2.7F, 1.0F);
        this.rFin02.addBox(0.0F, 0.0F, -1.0F, 1, 2, 4, 0.0F);
        this.setRotateAngle(rFin02, 0.136659280431156F, 0.0F, 0.0F);
        this.body = new RendererModel(this, 0, 0);
        this.body.setRotationPoint(0.0F, 13.0F, 3.0F);
        this.body.addBox(-4.5F, -5.5F, -14.0F, 9, 10, 14, 0.0F);
        this.setRotateAngle(body, 0.022863813201125717F, 0.0F, 0.0F);
        this.rFin01 = new RendererModel(this, 15, 178);
        this.rFin01.setRotationPoint(-0.5F, 4.9F, 0.0F);
        this.rFin01.addBox(0.0F, 0.0F, 0.0F, 1, 3, 5, 0.0F);
        this.setRotateAngle(rFin01, 0.22759093446006054F, 0.0F, 0.0F);
        this.head = new RendererModel(this, 0, 124);
        this.head.setRotationPoint(0.0F, 0.3F, -8.6F);
        this.head.addBox(-3.5F, -3.0F, -4.2F, 7, 4, 4, 0.0F);
        this.setRotateAngle(head, -0.136659280431156F, 0.0F, 0.0F);
        this.rFin00 = new RendererModel(this, 0, 175);
        this.rFin00.setRotationPoint(-3.6F, 0.7F, -13.9F);
        this.rFin00.addBox(-0.5F, 0.0F, 0.0F, 1, 5, 6, 0.0F);
        this.setRotateAngle(rFin00, 0.18203784098300857F, 0.0F, 0.7740535232594852F);
        this.dorsalFin00 = new RendererModel(this, 26, 124);
        this.dorsalFin00.setRotationPoint(0.5F, -6.9F, -6.7F);
        this.dorsalFin00.addBox(-1.5F, -0.4F, 0.0F, 2, 3, 6, 0.0F);
        this.setRotateAngle(dorsalFin00, -0.40980330836826856F, 0.0F, 0.0F);
        this.rLowerTailFin = new RendererModel(this, 11, 189);
        this.rLowerTailFin.mirror = true;
        this.rLowerTailFin.setRotationPoint(-1.2F, 2.0F, -0.9F);
        this.rLowerTailFin.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 4, 0.0F);
        this.setRotateAngle(rLowerTailFin, 0.36425021489121656F, 0.0F, 0.5462880558742251F);
        this.lLowerTailFin = new RendererModel(this, 11, 189);
        this.lLowerTailFin.setRotationPoint(1.2F, 2.0F, -0.9F);
        this.lLowerTailFin.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 4, 0.0F);
        this.setRotateAngle(lLowerTailFin, 0.36425021489121656F, 0.0F, -0.5462880558742251F);
        this.tailFinLower01 = new RendererModel(this, 15, 88);
        this.tailFinLower01.setRotationPoint(0.0F, 1.6F, -0.5F);
        this.tailFinLower01.addBox(-0.5F, 0.0F, -1.0F, 1, 3, 4, 0.0F);
        this.setRotateAngle(tailFinLower01, 0.36425021489121656F, 0.0F, 0.0F);
        this.tailFinUpper01 = new RendererModel(this, 25, 73);
        this.tailFinUpper01.setRotationPoint(0.0F, -5.8F, -0.5F);
        this.tailFinUpper01.addBox(-0.5F, -5.0F, -1.0F, 1, 5, 4, 0.0F);
        this.setRotateAngle(tailFinUpper01, -0.091106186954104F, 0.0F, 0.0F);
        this.headUpper = new RendererModel(this, 0, 146);
        this.headUpper.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.headUpper.addBox(-3.0F, 0.0F, 0.0F, 6, 3, 7, 0.0F);
        this.setRotateAngle(headUpper, -0.9436995265533339F, 0.0F, 0.0F);
        this.tailFinUpper00 = new RendererModel(this, 25, 61);
        this.tailFinUpper00.setRotationPoint(0.0F, -0.5F, 1.5F);
        this.tailFinUpper00.addBox(-0.51F, -6.0F, -1.5F, 1, 6, 5, 0.0F);
        this.setRotateAngle(tailFinUpper00, -0.8196066167365371F, 0.0F, 0.0F);
        this.dorsalFin04 = new RendererModel(this, 29, 150);
        this.dorsalFin04.setRotationPoint(0.0F, -2.9F, 0.8F);
        this.dorsalFin04.addBox(0.0F, 0.0F, -0.6F, 1, 5, 1, 0.0F);
        this.setRotateAngle(dorsalFin04, 1.1383037381507017F, 0.0F, 0.0F);
        this.tail02 = new RendererModel(this, 0, 65);
        this.tail02.setRotationPoint(0.0F, 0.1F, 5.3F);
        this.tail02.addBox(-2.0F, -3.0F, 0.0F, 4, 5, 6, 0.0F);
        this.setRotateAngle(tail02, -1.7453292519943296E-4F, 0.0F, 0.0F);
        this.lFin02 = new RendererModel(this, 0, 189);
        this.lFin02.mirror = true;
        this.lFin02.setRotationPoint(0.0F, 2.7F, 1.0F);
        this.lFin02.addBox(0.0F, 0.0F, -1.0F, 1, 2, 4, 0.0F);
        this.setRotateAngle(lFin02, 0.136659280431156F, 0.0F, 0.0F);
        this.lowerJaw = new RendererModel(this, 0, 157);
        this.lowerJaw.setRotationPoint(0.0F, 2.2F, -8.4F);
        this.lowerJaw.addBox(-3.0F, -1.0F, -3.0F, 6, 2, 3, 0.0F);
        this.setRotateAngle(lowerJaw, -0.136659280431156F, 0.0F, 0.0F);
        this.tail03 = new RendererModel(this, 0, 78);
        this.tail03.setRotationPoint(0.0F, -1.0F, 5.7F);
        this.tail03.addBox(-1.5F, -2.0F, 0.0F, 3, 4, 5, 0.0F);
        this.lFin00 = new RendererModel(this, 0, 175);
        this.lFin00.mirror = true;
        this.lFin00.setRotationPoint(3.6F, 0.7F, -13.9F);
        this.lFin00.addBox(-0.5F, 0.0F, 0.0F, 1, 5, 6, 0.0F);
        this.setRotateAngle(lFin00, 0.18203784098300857F, 0.0F, -0.7740535232594852F);
        this.tailFinLower02 = new RendererModel(this, 15, 97);
        this.tailFinLower02.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.tailFinLower02.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 3, 0.0F);
        this.setRotateAngle(tailFinLower02, 0.18203784098300857F, 0.0F, 0.0F);
        this.tail01 = new RendererModel(this, 0, 50);
        this.tail01.setRotationPoint(0.0F, -1.4F, 10.4F);
        this.tail01.addBox(-2.5F, -3.0F, 0.0F, 5, 7, 6, 0.0F);
        this.setRotateAngle(tail01, -0.04363323129985824F, 0.0F, 0.0F);
        this.teethUpper = new RendererModel(this, 0, 164);
        this.teethUpper.setRotationPoint(-2.5F, 0.8F, -2.4F);
        this.teethUpper.addBox(0.0F, 0.0F, 0.0F, 5, 1, 3, 0.0F);
        this.dorsalFin02 = new RendererModel(this, 26, 144);
        this.dorsalFin02.setRotationPoint(-1.0F, 1.2F, -0.1F);
        this.dorsalFin02.addBox(0.0F, -2.2F, 0.1F, 1, 1, 4, 0.0F);
        this.setRotateAngle(dorsalFin02, -0.045553093477052F, 0.0F, 0.0F);
        this.tailFinLower00 = new RendererModel(this, 25, 91);
        this.tailFinLower00.setRotationPoint(0.0F, 0.9F, 2.0F);
        this.tailFinLower00.addBox(-0.49F, 0.0F, -1.5F, 1, 2, 5, 0.0F);
        this.setRotateAngle(tailFinLower00, 0.22759093446006054F, 0.0F, 0.0F);
        this.tail00 = new RendererModel(this, 0, 27);
        this.tail00.setRotationPoint(0.0F, -1.0F, -0.7F);
        this.tail00.addBox(-3.5F, -4.5F, 0.0F, 7, 9, 11, 0.0F);
        this.setRotateAngle(tail00, -0.05969026041820607F, 0.0F, 0.0F);
        this.upperTailFin = new RendererModel(this, 23, 189);
        this.upperTailFin.setRotationPoint(-0.5F, -0.7F, 2.8F);
        this.upperTailFin.addBox(0.0F, 0.0F, 0.0F, 1, 3, 3, 0.0F);
        this.setRotateAngle(upperTailFin, 1.9577358219620393F, 0.0F, 0.0F);
        this.tail05 = new RendererModel(this, 25, 50);
        this.tail05.setRotationPoint(0.0F, 0.0F, 3.4F);
        this.tail05.addBox(-0.5F, -1.5F, 0.0F, 1, 3, 5, 0.0F);
        this.dorsalFin03 = new RendererModel(this, 26, 159);
        this.dorsalFin03.setRotationPoint(-1.0F, 0.5F, 1.3F);
        this.dorsalFin03.addBox(0.0F, -3.1F, -1.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(dorsalFin03, 0.045553093477052F, 0.0F, 0.0F);
        this.upperTailFin2 = new RendererModel(this, 23, 189);
        this.upperTailFin2.setRotationPoint(-0.5F, 0.4F, 1.8F);
        this.upperTailFin2.addBox(0.0F, 0.0F, 0.0F, 1, 3, 3, 0.0F);
        this.setRotateAngle(upperTailFin2, 1.8212510744560826F, 0.0F, 0.0F);
        this.tailFinUpper02 = new RendererModel(this, 25, 84);
        this.tailFinUpper02.setRotationPoint(0.0F, -4.8F, -0.5F);
        this.tailFinUpper02.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 3, 0.0F);
        this.setRotateAngle(tailFinUpper02, -0.136659280431156F, 0.0F, 0.0F);
        this.teethLower = new RendererModel(this, 0, 171);
        this.teethLower.setRotationPoint(-2.0F, -1.8F, -2.4F);
        this.teethLower.addBox(0.0F, 0.0F, 0.0F, 4, 1, 2, 0.0F);
        this.lFin01 = new RendererModel(this, 15, 178);
        this.lFin01.mirror = true;
        this.lFin01.setRotationPoint(-0.5F, 4.9F, 0.0F);
        this.lFin01.addBox(0.0F, 0.0F, 0.0F, 1, 3, 5, 0.0F);
        this.setRotateAngle(lFin01, 0.22759093446006054F, 0.0F, 0.0F);
        this.body.addChild(this.neck);
        this.dorsalFin00.addChild(this.dorsalFin01);
        this.tail03.addChild(this.tail04);
        this.head.addChild(this.snout);
        this.rFin01.addChild(this.rFin02);
        this.rFin00.addChild(this.rFin01);
        this.neck.addChild(this.head);
        this.body.addChild(this.rFin00);
        this.body.addChild(this.dorsalFin00);
        this.tail03.addChild(this.rLowerTailFin);
        this.tail03.addChild(this.lLowerTailFin);
        this.tailFinLower00.addChild(this.tailFinLower01);
        this.tailFinUpper00.addChild(this.tailFinUpper01);
        this.snout.addChild(this.headUpper);
        this.tail05.addChild(this.tailFinUpper00);
        this.dorsalFin03.addChild(this.dorsalFin04);
        this.tail01.addChild(this.tail02);
        this.lFin01.addChild(this.lFin02);
        this.neck.addChild(this.lowerJaw);
        this.tail02.addChild(this.tail03);
        this.body.addChild(this.lFin00);
        this.tailFinLower01.addChild(this.tailFinLower02);
        this.tail00.addChild(this.tail01);
        this.head.addChild(this.teethUpper);
        this.dorsalFin01.addChild(this.dorsalFin02);
        this.tail05.addChild(this.tailFinLower00);
        this.body.addChild(this.tail00);
        this.tail01.addChild(this.upperTailFin);
        this.tail04.addChild(this.tail05);
        this.dorsalFin00.addChild(this.dorsalFin03);
        this.tail03.addChild(this.upperTailFin2);
        this.tailFinUpper01.addChild(this.tailFinUpper02);
        this.lowerJaw.addChild(this.teethLower);
        this.lFin00.addChild(this.lFin01);
    }

    @Override
    public void render(EntityShark entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.body.render(f5);
    }

    @Override
    public void setRotationAngles(EntityShark entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
        ModelBullShark.animate(entity, ageInTicks, body, tail00, tail01, tail02, lowerJaw);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(RendererModel RendererModel, float x, float y, float z) {
        RendererModel.rotateAngleX = x;
        RendererModel.rotateAngleY = y;
        RendererModel.rotateAngleZ = z;
    }
}
