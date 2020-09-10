package its_meow.betteranimalsplus.client.model;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * Piranha - Batman
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class ModelPiranha<T extends Entity> extends EntityModel<T> {
    public RendererModel body;
    public RendererModel neck;
    public RendererModel rear;
    public RendererModel TopFin;
    public RendererModel leftFin;
    public RendererModel RightFin;
    public RendererModel throat;
    public RendererModel TopJaw;
    public RendererModel LowerJaw;
    public RendererModel snout;
    public RendererModel TopTeeth01;
    public RendererModel TopTeeth02;
    public RendererModel TopTeeth03;
    public RendererModel LowTeeth;
    public RendererModel tail01;
    public RendererModel LowFin01;
    public RendererModel tail02;
    public RendererModel LowFin02;
    public RendererModel SmallTopFin;
    public RendererModel TailFin;
    public RendererModel LowFin03;

    public ModelPiranha() {
        this.textureWidth = 36;
        this.textureHeight = 160;
        this.rear = new RendererModel(this, 0, 63);
        this.rear.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rear.addBox(-2.0F, -4.5F, 0.0F, 4, 8, 3, 0.0F);
        this.throat = new RendererModel(this, 0, 34);
        this.throat.setRotationPoint(0.0F, -0.9F, -3.9F);
        this.throat.addBox(-2.5F, 0.0F, 0.0F, 5, 4, 5, 0.0F);
        this.setRotateAngle(throat, -0.5462880558742251F, 0.0F, 0.0F);
        this.TopTeeth01 = new RendererModel(this, 0, 139);
        this.TopTeeth01.setRotationPoint(-1.8F, 1.3F, -2.6F);
        this.TopTeeth01.addBox(0.0F, 0.0F, 0.0F, 0, 1, 3, 0.0F);
        this.body = new RendererModel(this, 0, 0);
        this.body.setRotationPoint(0.0F, 13.0F, 4.0F);
        this.body.addBox(-2.5F, -5.0F, -9.0F, 5, 10, 9, 0.0F);
        this.leftFin = new RendererModel(this, 26, 20);
        this.leftFin.setRotationPoint(2.0F, 3.5F, -7.0F);
        this.leftFin.addBox(0.0F, 0.0F, -1.5F, 0, 6, 3, 0.0F);
        this.setRotateAngle(leftFin, 0.6373942428283291F, 0.0F, -2.1399481958702475F);
        this.TopJaw = new RendererModel(this, 0, 44);
        this.TopJaw.setRotationPoint(0.0F, -1.0F, -5.5F);
        this.TopJaw.addBox(-2.5F, -1.5F, -3.0F, 5, 3, 3, 0.0F);
        this.setRotateAngle(TopJaw, -0.18203784098300857F, 0.0F, 0.0F);
        this.snout = new RendererModel(this, 0, 51);
        this.snout.setRotationPoint(0.0F, -1.5F, -3.0F);
        this.snout.addBox(-2.0F, 0.0F, 0.0F, 4, 2, 3, 0.0F);
        this.setRotateAngle(snout, 0.6829473363053812F, 0.0F, 0.0F);
        this.LowFin01 = new RendererModel(this, 0, 92);
        this.LowFin01.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.LowFin01.addBox(0.0F, 0.0F, 0.0F, 0, 5, 3, 0.0F);
        this.LowFin03 = new RendererModel(this, 0, 105);
        this.LowFin03.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.LowFin03.addBox(0.0F, 0.0F, 0.0F, 0, 6, 3, 0.0F);
        this.TopTeeth03 = new RendererModel(this, 7, 138);
        this.TopTeeth03.setRotationPoint(0.0F, 1.3F, -2.5F);
        this.TopTeeth03.addBox(-1.5F, 0.0F, 0.0F, 3, 1, 0, 0.0F);
        this.TopFin = new RendererModel(this, 0, 125);
        this.TopFin.setRotationPoint(0.0F, -4.8F, -5.0F);
        this.TopFin.addBox(0.0F, -4.0F, -1.0F, 0, 4, 7, 0.0F);
        this.setRotateAngle(TopFin, -0.091106186954104F, 0.0F, 0.0F);
        this.LowTeeth = new RendererModel(this, 0, 145);
        this.LowTeeth.setRotationPoint(0.0F, -1.5F, -2.5F);
        this.LowTeeth.addBox(-1.5F, 0.0F, 0.0F, 3, 1, 3, 0.0F);
        this.LowFin02 = new RendererModel(this, 0, 98);
        this.LowFin02.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.LowFin02.addBox(0.0F, 0.0F, 0.0F, 0, 6, 3, 0.0F);
        this.tail02 = new RendererModel(this, 0, 86);
        this.tail02.setRotationPoint(0.0F, -1.0F, 3.0F);
        this.tail02.addBox(-1.0F, -2.0F, 0.0F, 2, 4, 3, 0.0F);
        this.RightFin = new RendererModel(this, 26, 20);
        this.RightFin.setRotationPoint(-2.0F, 3.5F, -7.0F);
        this.RightFin.addBox(0.0F, 0.0F, -1.5F, 0, 6, 3, 0.0F);
        this.setRotateAngle(RightFin, 0.6373942428283291F, 0.0F, 2.1399481958702475F);
        this.neck = new RendererModel(this, 0, 20);
        this.neck.setRotationPoint(0.0F, -0.5F, -8.0F);
        this.neck.addBox(-3.0F, -4.5F, -6.0F, 6, 7, 6, 0.0F);
        this.setRotateAngle(neck, 0.136659280431156F, 0.0F, 0.0F);
        this.tail01 = new RendererModel(this, 0, 76);
        this.tail01.setRotationPoint(0.0F, -0.5F, 3.0F);
        this.tail01.addBox(-1.5F, -3.5F, 0.0F, 3, 6, 3, 0.0F);
        this.SmallTopFin = new RendererModel(this, 0, 135);
        this.SmallTopFin.setRotationPoint(0.0F, -5.3F, 1.7F);
        this.SmallTopFin.addBox(0.0F, 0.0F, 0.0F, 0, 2, 2, 0.0F);
        this.setRotateAngle(SmallTopFin, -0.27314402793711257F, 0.0F, 0.0F);
        this.TopTeeth02 = new RendererModel(this, 0, 139);
        this.TopTeeth02.setRotationPoint(1.8F, 1.3F, -2.6F);
        this.TopTeeth02.addBox(0.0F, 0.0F, 0.0F, 0, 1, 3, 0.0F);
        this.LowerJaw = new RendererModel(this, 0, 57);
        this.LowerJaw.setRotationPoint(0.0F, 1.4F, -5.5F);
        this.LowerJaw.addBox(-2.0F, -1.0F, -3.0F, 4, 2, 3, 0.0F);
        this.setRotateAngle(LowerJaw, -0.22759093446006054F, 0.0F, 0.0F);
        this.TailFin = new RendererModel(this, 0, 106);
        this.TailFin.setRotationPoint(0.0F, 0.5F, 2.5F);
        this.TailFin.addBox(0.0F, -8.5F, 0.0F, 0, 16, 9, 0.0F);
        this.body.addChild(this.rear);
        this.neck.addChild(this.throat);
        this.TopJaw.addChild(this.TopTeeth01);
        this.body.addChild(this.leftFin);
        this.neck.addChild(this.TopJaw);
        this.TopJaw.addChild(this.snout);
        this.rear.addChild(this.LowFin01);
        this.tail02.addChild(this.LowFin03);
        this.TopJaw.addChild(this.TopTeeth03);
        this.body.addChild(this.TopFin);
        this.LowerJaw.addChild(this.LowTeeth);
        this.tail01.addChild(this.LowFin02);
        this.tail01.addChild(this.tail02);
        this.body.addChild(this.RightFin);
        this.body.addChild(this.neck);
        this.rear.addChild(this.tail01);
        this.tail01.addChild(this.SmallTopFin);
        this.TopJaw.addChild(this.TopTeeth02);
        this.neck.addChild(this.LowerJaw);
        this.tail02.addChild(this.TailFin);
    }

    @Override
    public void render(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        GlStateManager.pushMatrix();
        {
            if(!entityIn.isInWater()) {
                GlStateManager.rotatef(90F, 0F, 0F, 1.0F);
                GlStateManager.translatef(2F, -1F, 0F);
            }
            this.body.render(scale);
        }
        GlStateManager.popMatrix();
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
        float factor = (float) entityIn.getMotion().length() * 10;
        this.body.rotateAngleY = MathHelper.cos(ageInTicks * 0.3F) * (float) Math.PI * 0.05F * factor;
        this.tail01.rotateAngleY = this.body.rotateAngleY * 1.5F;
    }

    public void setRotateAngle(RendererModel RendererModel, float x, float y, float z) {
        RendererModel.rotateAngleX = x;
        RendererModel.rotateAngleY = y;
        RendererModel.rotateAngleZ = z;
    }
}
