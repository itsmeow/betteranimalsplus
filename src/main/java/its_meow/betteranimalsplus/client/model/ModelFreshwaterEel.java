package its_meow.betteranimalsplus.client.model;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;

/**
 * EelFreshWater - Batman
 * Created using Tabula 7.0.1
 */
public class ModelFreshwaterEel<T extends LivingEntity> extends EntityModel<T> {
    public RendererModel body;
    public RendererModel rear;
    public RendererModel neck;
    public RendererModel topFin1;
    public RendererModel lowFin1;
    public RendererModel lFin;
    public RendererModel rFin;
    public RendererModel tail1;
    public RendererModel topFin2;
    public RendererModel lowFin2;
    public RendererModel tail2;
    public RendererModel topFin3;
    public RendererModel lowFin3;
    public RendererModel topFin4;
    public RendererModel lowFin4;
    public RendererModel topJaw;
    public RendererModel lowJaw;
    public RendererModel snout;
    public RendererModel noseNubL;
    public RendererModel noseNubr;
    public RendererModel topTeeth1;
    public RendererModel topTeeth2;
    public RendererModel topTeeth3;
    public RendererModel lowTeeth;

    public ModelFreshwaterEel() {
        this.textureWidth = 40;
        this.textureHeight = 130;
        this.snout = new RendererModel(this, 0, 70);
        this.snout.setRotationPoint(0.0F, 0.0F, -2.8F);
        this.snout.addBox(-1.5F, -0.5F, 0.0F, 3, 1, 3, 0.0F);
        this.setRotateAngle(snout, 0.31869712141416456F, 0.0F, 0.0F);
        this.noseNubr = new RendererModel(this, 11, 75);
        this.noseNubr.setRotationPoint(-1.0F, 0.0F, -2.8F);
        this.noseNubr.addBox(-0.5F, -0.5F, -1.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(noseNubr, 0.091106186954104F, 0.136659280431156F, 0.0F);
        this.topTeeth2 = new RendererModel(this, 0, 0);
        this.topTeeth2.setRotationPoint(-1.1F, 0.2F, -2.5F);
        this.topTeeth2.addBox(0.0F, 0.0F, -0.2F, 0, 1, 2, 0.0F);
        this.lowTeeth = new RendererModel(this, 0, 6);
        this.lowTeeth.setRotationPoint(0.0F, -1.2F, -2.5F);
        this.lowTeeth.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
        this.body = new RendererModel(this, 0, 0);
        this.body.setRotationPoint(0.0F, 19.3F, 0.0F);
        this.body.addBox(-2.0F, -1.5F, -10.0F, 4, 3, 10, 0.0F);
        this.neck = new RendererModel(this, 0, 55);
        this.neck.setRotationPoint(0.0F, 0.0F, -9.7F);
        this.neck.addBox(-2.0F, -1.5F, -6.0F, 4, 3, 6, 0.0F);
        this.tail2 = new RendererModel(this, 0, 45);
        this.tail2.setRotationPoint(0.0F, 0.0F, 8.0F);
        this.tail2.addBox(-0.5F, -1.0F, 0.0F, 1, 3, 6, 0.0F);
        this.noseNubL = new RendererModel(this, 11, 75);
        this.noseNubL.setRotationPoint(1.0F, 0.0F, -2.8F);
        this.noseNubL.addBox(-0.5F, -0.5F, -1.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(noseNubL, 0.091106186954104F, -0.136659280431156F, 0.0F);
        this.lFin = new RendererModel(this, 0, 12);
        this.lFin.mirror = true;
        this.lFin.setRotationPoint(2.0F, 0.0F, -9.5F);
        this.lFin.addBox(0.0F, -1.0F, 0.0F, 0, 2, 3, 0.0F);
        this.setRotateAngle(lFin, 0.0F, 0.36425021489121656F, -0.31869712141416456F);
        this.rFin = new RendererModel(this, 0, 12);
        this.rFin.setRotationPoint(-2.0F, 0.0F, -9.5F);
        this.rFin.addBox(0.0F, -1.0F, 0.0F, 0, 2, 3, 0.0F);
        this.setRotateAngle(rFin, 0.0F, -0.36425021489121656F, 0.31869712141416456F);
        this.lowFin3 = new RendererModel(this, 0, 100);
        this.lowFin3.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.lowFin3.addBox(0.0F, 0.0F, 0.0F, 0, 3, 8, 0.0F);
        this.topFin4 = new RendererModel(this, 0, 84);
        this.topFin4.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.topFin4.addBox(0.0F, -3.0F, 0.0F, 0, 6, 9, 0.0F);
        this.topFin3 = new RendererModel(this, 0, 81);
        this.topFin3.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.topFin3.addBox(0.0F, -3.0F, 0.0F, 0, 3, 8, 0.0F);
        this.rear = new RendererModel(this, 0, 16);
        this.rear.setRotationPoint(0.0F, 0.0F, -0.3F);
        this.rear.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 10, 0.0F);
        this.topTeeth3 = new RendererModel(this, 0, 4);
        this.topTeeth3.setRotationPoint(0.0F, 0.0F, -2.6F);
        this.topTeeth3.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 0, 0.0F);
        this.topTeeth1 = new RendererModel(this, 0, 0);
        this.topTeeth1.setRotationPoint(1.1F, 0.2F, -2.5F);
        this.topTeeth1.addBox(0.0F, 0.0F, -0.2F, 0, 1, 2, 0.0F);
        this.lowFin4 = new RendererModel(this, 0, 103);
        this.lowFin4.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.lowFin4.addBox(0.0F, 0.0F, 0.0F, 0, 3, 9, 0.0F);
        this.lowFin2 = new RendererModel(this, 0, 94);
        this.lowFin2.setRotationPoint(0.0F, 4.5F, 0.0F);
        this.lowFin2.addBox(0.0F, -3.0F, 0.0F, 0, 3, 10, 0.0F);
        this.topJaw = new RendererModel(this, 0, 65);
        this.topJaw.setRotationPoint(0.0F, 0.1F, -6.0F);
        this.topJaw.addBox(-2.0F, -0.5F, -3.0F, 4, 1, 3, 0.0F);
        this.setRotateAngle(topJaw, -0.045553093477052F, 0.0F, 0.0F);
        this.tail1 = new RendererModel(this, 0, 32);
        this.tail1.setRotationPoint(0.0F, -0.5F, 9.6F);
        this.tail1.addBox(-1.0F, -1.0F, 0.0F, 2, 3, 8, 0.0F);
        this.lowJaw = new RendererModel(this, 0, 75);
        this.lowJaw.setRotationPoint(0.0F, 1.0F, -5.8F);
        this.lowJaw.addBox(-1.5F, -0.5F, -3.0F, 3, 1, 3, 0.0F);
        this.setRotateAngle(lowJaw, 0.7740535232594852F, 0.0F, 0.0F);
        this.topFin2 = new RendererModel(this, 0, 75);
        this.topFin2.setRotationPoint(0.0F, -1.5F, 0.0F);
        this.topFin2.addBox(0.0F, -3.0F, 0.0F, 0, 3, 10, 0.0F);
        this.topFin1 = new RendererModel(this, 0, 76);
        this.topFin1.setRotationPoint(0.0F, -1.5F, -5.0F);
        this.topFin1.addBox(0.0F, -3.0F, 0.0F, 0, 3, 5, 0.0F);
        this.lowFin1 = new RendererModel(this, 0, 97);
        this.lowFin1.setRotationPoint(0.0F, 1.5F, -3.0F);
        this.lowFin1.addBox(0.0F, 0.0F, 0.0F, 0, 3, 3, 0.0F);
        this.topJaw.addChild(this.snout);
        this.topJaw.addChild(this.noseNubr);
        this.topJaw.addChild(this.topTeeth2);
        this.lowJaw.addChild(this.lowTeeth);
        this.body.addChild(this.neck);
        this.tail1.addChild(this.tail2);
        this.topJaw.addChild(this.noseNubL);
        this.body.addChild(this.lFin);
        this.body.addChild(this.rFin);
        this.tail1.addChild(this.lowFin3);
        this.tail2.addChild(this.topFin4);
        this.tail1.addChild(this.topFin3);
        this.body.addChild(this.rear);
        this.topJaw.addChild(this.topTeeth3);
        this.topJaw.addChild(this.topTeeth1);
        this.tail2.addChild(this.lowFin4);
        this.rear.addChild(this.lowFin2);
        this.neck.addChild(this.topJaw);
        this.rear.addChild(this.tail1);
        this.neck.addChild(this.lowJaw);
        this.rear.addChild(this.topFin2);
        this.body.addChild(this.topFin1);
        this.body.addChild(this.lowFin1);
    }

    @Override
    public void render(T entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.body.render(f5);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
        super.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
        float factor = (float) entityIn.getMotion().length() * 10;
        this.body.rotateAngleY = MathHelper.cos(ageInTicks * 0.3F) * (float) Math.PI * 0.05F * factor;
        this.neck.rotateAngleY = -this.body.rotateAngleY * 1.5F;
        this.rear.rotateAngleY = this.body.rotateAngleY * 1.5F;
        this.tail1.rotateAngleY = this.rear.rotateAngleY * 1.5F;
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
