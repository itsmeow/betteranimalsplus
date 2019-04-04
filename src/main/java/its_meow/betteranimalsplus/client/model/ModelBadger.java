package its_meow.betteranimalsplus.client.model;

import its_meow.betteranimalsplus.common.entity.EntityBadger;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;

/**
 * Badger - Batman
 * Created using Tabula 5.1.0
 */
public class ModelBadger extends ModelBase {
    public ModelRenderer rear;
    public ModelRenderer front;
    public ModelRenderer lLeg01;
    public ModelRenderer rLeg01;
    public ModelRenderer tail01;
    public ModelRenderer bellyFloof;
    public ModelRenderer neck;
    public ModelRenderer lArm01;
    public ModelRenderer rArm01;
    public ModelRenderer chestFloof;
    public ModelRenderer head;
    public ModelRenderer neckFloof;
    public ModelRenderer upperJaw;
    public ModelRenderer lowerJaw;
    public ModelRenderer lEar;
    public ModelRenderer rEar;
    public ModelRenderer snout;
    public ModelRenderer lArm02;
    public ModelRenderer lForepaw;
    public ModelRenderer lFClaw01;
    public ModelRenderer lFClaw04;
    public ModelRenderer lFClaw03;
    public ModelRenderer lFClaw02;
    public ModelRenderer rArm02;
    public ModelRenderer rForepaw;
    public ModelRenderer rFClaw04;
    public ModelRenderer rFClaw01;
    public ModelRenderer rFClaw02;
    public ModelRenderer rFClaw03;
    public ModelRenderer lLeg02;
    public ModelRenderer lLeg03;
    public ModelRenderer lFoot;
    public ModelRenderer lBClaw01;
    public ModelRenderer lBClaw04;
    public ModelRenderer lBClaw03;
    public ModelRenderer lBClaw02;
    public ModelRenderer rLeg02;
    public ModelRenderer rLeg03;
    public ModelRenderer rFoot;
    public ModelRenderer rBClaw04;
    public ModelRenderer rBClaw01;
    public ModelRenderer rBClaw02;
    public ModelRenderer rBClaw03;
    public ModelRenderer tail02;
    public ModelRenderer tail01Floof;
    public ModelRenderer tail02Floof;

    public ModelBadger() {
        this.textureWidth = 60;
        this.textureHeight = 120;
        this.rFClaw04 = new ModelRenderer(this, 0, 0);
        this.rFClaw04.setRotationPoint(-1.4F, 0.5F, -1.7F);
        this.rFClaw04.addBox(0.0F, -0.5F, -2.0F, 0, 1, 2, 0.0F);
        this.setRotateAngle(rFClaw04, 0.18203784098300857F, 0.0F, 0.0F);
        this.tail02 = new ModelRenderer(this, 37, 78);
        this.tail02.setRotationPoint(0.0F, 0.0F, 4.8F);
        this.tail02.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 5, 0.0F);
        this.setRotateAngle(tail02, 0.22759093446006054F, 0.0F, 0.0F);
        this.upperJaw = new ModelRenderer(this, 14, 54);
        this.upperJaw.setRotationPoint(0.0F, -1.1F, -4.2F);
        this.upperJaw.addBox(-1.5F, 0.0F, -4.0F, 3, 2, 4, 0.0F);
        this.lFClaw01 = new ModelRenderer(this, 0, 0);
        this.lFClaw01.setRotationPoint(-1.4F, 0.5F, -1.7F);
        this.lFClaw01.addBox(0.0F, -0.5F, -2.0F, 0, 1, 2, 0.0F);
        this.setRotateAngle(lFClaw01, 0.18203784098300857F, 0.0F, 0.0F);
        this.rArm02 = new ModelRenderer(this, 0, 71);
        this.rArm02.setRotationPoint(0.0F, 3.5F, 0.5F);
        this.rArm02.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(rArm02, -0.36425021489121656F, 0.0F, 0.0F);
        this.snout = new ModelRenderer(this, 30, 54);
        this.snout.setRotationPoint(0.0F, 0.0F, -4.6F);
        this.snout.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 5, 0.0F);
        this.setRotateAngle(snout, 0.22759093446006054F, 0.0F, 0.0F);
        this.rArm01 = new ModelRenderer(this, 27, 62);
        this.rArm01.setRotationPoint(-3.3F, 1.6F, -8.5F);
        this.rArm01.addBox(-1.5F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
        this.setRotateAngle(rArm01, 0.22759093446006054F, 0.0F, 0.0F);
        this.lFClaw04 = new ModelRenderer(this, 0, 0);
        this.lFClaw04.setRotationPoint(1.4F, 0.5F, -1.7F);
        this.lFClaw04.addBox(0.0F, -0.5F, -2.0F, 0, 1, 2, 0.0F);
        this.setRotateAngle(lFClaw04, 0.18203784098300857F, 0.0F, 0.0F);
        this.lFoot = new ModelRenderer(this, 9, 71);
        this.lFoot.setRotationPoint(0.0F, 3.3F, 0.0F);
        this.lFoot.addBox(-1.5F, 0.0F, -2.0F, 3, 1, 3, 0.0F);
        this.setRotateAngle(lFoot, 0.136659280431156F, 0.0F, 0.0F);
        this.lowerJaw = new ModelRenderer(this, 0, 60);
        this.lowerJaw.setRotationPoint(0.0F, 1.4F, -4.8F);
        this.lowerJaw.addBox(-1.0F, -0.5F, -3.0F, 2, 1, 3, 0.0F);
        this.setRotateAngle(lowerJaw, -0.136659280431156F, 0.0F, 0.0F);
        this.rForepaw = new ModelRenderer(this, 9, 71);
        this.rForepaw.setRotationPoint(0.0F, 3.8F, 0.0F);
        this.rForepaw.addBox(-1.5F, 0.0F, -2.0F, 3, 1, 3, 0.0F);
        this.setRotateAngle(rForepaw, 0.091106186954104F, 0.0F, 0.0F);
        this.tail01 = new ModelRenderer(this, 26, 82);
        this.tail01.setRotationPoint(0.0F, -3.0F, 9.1F);
        this.tail01.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 5, 0.0F);
        this.setRotateAngle(tail01, -1.0471975511965976F, 0.0F, 0.0F);
        this.rFClaw03 = new ModelRenderer(this, 0, 0);
        this.rFClaw03.setRotationPoint(-0.5F, 0.5F, -1.7F);
        this.rFClaw03.addBox(0.0F, -0.5F, -2.0F, 0, 1, 2, 0.0F);
        this.setRotateAngle(rFClaw03, 0.18203784098300857F, 0.0F, 0.0F);
        this.chestFloof = new ModelRenderer(this, 0, 84);
        this.chestFloof.setRotationPoint(-3.5F, 3.8F, -9.9F);
        this.chestFloof.addBox(0.0F, 0.0F, 0.0F, 7, 1, 10, 0.0F);
        this.rLeg03 = new ModelRenderer(this, 0, 79);
        this.rLeg03.setRotationPoint(0.0F, 2.3F, 0.6F);
        this.rLeg03.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(rLeg03, -0.5009094953223726F, 0.0F, 0.0F);
        this.lFClaw03 = new ModelRenderer(this, 0, 0);
        this.lFClaw03.setRotationPoint(0.5F, 0.5F, -1.7F);
        this.lFClaw03.addBox(0.0F, -0.5F, -2.0F, 0, 1, 2, 0.0F);
        this.setRotateAngle(lFClaw03, 0.18203784098300857F, 0.0F, 0.0F);
        this.lLeg02 = new ModelRenderer(this, 36, 70);
        this.lLeg02.setRotationPoint(0.0F, 3.2F, -1.1F);
        this.lLeg02.addBox(-1.5F, 0.0F, -1.5F, 3, 3, 3, 0.0F);
        this.setRotateAngle(lLeg02, 0.40980330836826856F, 0.0F, 0.0F);
        this.neck = new ModelRenderer(this, 0, 42);
        this.neck.setRotationPoint(0.0F, -0.7F, -9.0F);
        this.neck.addBox(-2.5F, -3.0F, -6.0F, 5, 5, 6, 0.0F);
        this.setRotateAngle(neck, -0.18203784098300857F, 0.0F, 0.0F);
        this.lFClaw02 = new ModelRenderer(this, 0, 0);
        this.lFClaw02.setRotationPoint(-0.5F, 0.5F, -1.7F);
        this.lFClaw02.addBox(0.0F, -0.5F, -2.0F, 0, 1, 2, 0.0F);
        this.setRotateAngle(lFClaw02, 0.18203784098300857F, 0.0F, 0.0F);
        this.rFClaw01 = new ModelRenderer(this, 0, 0);
        this.rFClaw01.setRotationPoint(1.4F, 0.5F, -1.7F);
        this.rFClaw01.addBox(0.0F, -0.5F, -2.0F, 0, 1, 2, 0.0F);
        this.setRotateAngle(rFClaw01, 0.18203784098300857F, 0.0F, 0.0F);
        this.lBClaw02 = new ModelRenderer(this, 0, 0);
        this.lBClaw02.setRotationPoint(-0.5F, 0.5F, -1.7F);
        this.lBClaw02.addBox(0.0F, -0.5F, -2.0F, 0, 1, 2, 0.0F);
        this.setRotateAngle(lBClaw02, 0.18203784098300857F, 0.0F, 0.0F);
        this.rFoot = new ModelRenderer(this, 9, 71);
        this.rFoot.setRotationPoint(0.0F, 3.3F, 0.0F);
        this.rFoot.addBox(-1.5F, 0.0F, -2.0F, 3, 1, 3, 0.0F);
        this.setRotateAngle(rFoot, 0.136659280431156F, 0.0F, 0.0F);
        this.lLeg03 = new ModelRenderer(this, 0, 79);
        this.lLeg03.setRotationPoint(0.0F, 2.3F, 0.6F);
        this.lLeg03.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(lLeg03, -0.5009094953223726F, 0.0F, 0.0F);
        this.lEar = new ModelRenderer(this, 0, 54);
        this.lEar.setRotationPoint(2.3F, -1.4F, -1.0F);
        this.lEar.addBox(-0.5F, -2.0F, -1.0F, 1, 2, 2, 0.0F);
        this.setRotateAngle(lEar, -0.8196066167365371F, 0.40980330836826856F, 0.27314402793711257F);
        this.rear = new ModelRenderer(this, 0, 0);
        this.rear.setRotationPoint(0.0F, 14.5F, 0.0F);
        this.rear.addBox(-4.5F, -4.7F, 0.0F, 9, 9, 10, 0.0F);
        this.setRotateAngle(rear, -0.045553093477052F, 0.0F, 0.0F);
        this.rBClaw01 = new ModelRenderer(this, 0, 0);
        this.rBClaw01.setRotationPoint(1.4F, 0.5F, -1.7F);
        this.rBClaw01.addBox(0.0F, -0.5F, -2.0F, 0, 1, 2, 0.0F);
        this.setRotateAngle(rBClaw01, 0.18203784098300857F, 0.0F, 0.0F);
        this.lBClaw01 = new ModelRenderer(this, 0, 0);
        this.lBClaw01.setRotationPoint(-1.4F, 0.5F, -1.7F);
        this.lBClaw01.addBox(0.0F, -0.5F, -2.0F, 0, 1, 2, 0.0F);
        this.setRotateAngle(lBClaw01, 0.18203784098300857F, 0.0F, 0.0F);
        this.rFClaw02 = new ModelRenderer(this, 0, 0);
        this.rFClaw02.setRotationPoint(0.5F, 0.5F, -1.7F);
        this.rFClaw02.addBox(0.0F, -0.5F, -2.0F, 0, 1, 2, 0.0F);
        this.setRotateAngle(rFClaw02, 0.18203784098300857F, 0.0F, 0.0F);
        this.rLeg01 = new ModelRenderer(this, 19, 72);
        this.rLeg01.setRotationPoint(-4.0F, -0.2F, 7.0F);
        this.rLeg01.addBox(-2.0F, 0.0F, -2.5F, 4, 4, 4, 0.0F);
        this.lArm02 = new ModelRenderer(this, 0, 71);
        this.lArm02.setRotationPoint(0.0F, 3.5F, 0.5F);
        this.lArm02.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(lArm02, -0.36425021489121656F, 0.0F, 0.0F);
        this.lBClaw04 = new ModelRenderer(this, 0, 0);
        this.lBClaw04.setRotationPoint(1.4F, 0.5F, -1.7F);
        this.lBClaw04.addBox(0.0F, -0.5F, -2.0F, 0, 1, 2, 0.0F);
        this.setRotateAngle(lBClaw04, 0.18203784098300857F, 0.0F, 0.0F);
        this.front = new ModelRenderer(this, 0, 22);
        this.front.setRotationPoint(0.0F, -0.5F, 0.4F);
        this.front.addBox(-4.0F, -4.0F, -10.0F, 8, 8, 10, 0.0F);
        this.setRotateAngle(front, 0.091106186954104F, 0.0F, 0.0F);
        this.lForepaw = new ModelRenderer(this, 9, 71);
        this.lForepaw.setRotationPoint(0.0F, 3.8F, 0.0F);
        this.lForepaw.addBox(-1.5F, 0.0F, -2.0F, 3, 1, 3, 0.0F);
        this.setRotateAngle(lForepaw, 0.091106186954104F, 0.0F, 0.0F);
        this.tail01Floof = new ModelRenderer(this, 39, 87);
        this.tail01Floof.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.tail01Floof.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 5, 0.0F);
        this.rBClaw04 = new ModelRenderer(this, 0, 0);
        this.rBClaw04.setRotationPoint(-1.4F, 0.5F, -1.7F);
        this.rBClaw04.addBox(0.0F, -0.5F, -2.0F, 0, 1, 2, 0.0F);
        this.setRotateAngle(rBClaw04, 0.18203784098300857F, 0.0F, 0.0F);
        this.neckFloof = new ModelRenderer(this, 5, 61);
        this.neckFloof.setRotationPoint(0.0F, 1.5F, -6.0F);
        this.neckFloof.addBox(-2.0F, 0.0F, 0.0F, 4, 2, 6, 0.0F);
        this.rBClaw03 = new ModelRenderer(this, 0, 0);
        this.rBClaw03.setRotationPoint(-0.5F, 0.5F, -1.7F);
        this.rBClaw03.addBox(0.0F, -0.5F, -2.0F, 0, 1, 2, 0.0F);
        this.setRotateAngle(rBClaw03, 0.18203784098300857F, 0.0F, 0.0F);
        this.bellyFloof = new ModelRenderer(this, 0, 96);
        this.bellyFloof.setRotationPoint(-4.0F, 4.0F, -0.1F);
        this.bellyFloof.addBox(0.0F, 0.0F, 0.0F, 8, 1, 10, 0.0F);
        this.rBClaw02 = new ModelRenderer(this, 0, 0);
        this.rBClaw02.setRotationPoint(0.5F, 0.5F, -1.7F);
        this.rBClaw02.addBox(0.0F, -0.5F, -2.0F, 0, 1, 2, 0.0F);
        this.setRotateAngle(rBClaw02, 0.18203784098300857F, 0.0F, 0.0F);
        this.lArm01 = new ModelRenderer(this, 27, 62);
        this.lArm01.setRotationPoint(3.3F, 1.6F, -8.5F);
        this.lArm01.addBox(-1.5F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
        this.setRotateAngle(lArm01, 0.22759093446006054F, 0.0F, 0.0F);
        this.lBClaw03 = new ModelRenderer(this, 0, 0);
        this.lBClaw03.setRotationPoint(0.5F, 0.5F, -1.7F);
        this.lBClaw03.addBox(0.0F, -0.5F, -2.0F, 0, 1, 2, 0.0F);
        this.setRotateAngle(lBClaw03, 0.18203784098300857F, 0.0F, 0.0F);
        this.lLeg01 = new ModelRenderer(this, 19, 72);
        this.lLeg01.setRotationPoint(4.0F, -0.2F, 8.0F);
        this.lLeg01.addBox(-2.0F, 0.0F, -2.5F, 4, 4, 4, 0.0F);
        this.rLeg02 = new ModelRenderer(this, 36, 70);
        this.rLeg02.setRotationPoint(0.0F, 3.2F, -0.1F);
        this.rLeg02.addBox(-1.5F, 0.0F, -1.5F, 3, 3, 3, 0.0F);
        this.setRotateAngle(rLeg02, 0.40980330836826856F, 0.0F, 0.0F);
        this.rEar = new ModelRenderer(this, 7, 54);
        this.rEar.setRotationPoint(-2.3F, -1.4F, -1.0F);
        this.rEar.addBox(-0.5F, -2.0F, -1.0F, 1, 2, 2, 0.0F);
        this.setRotateAngle(rEar, -0.8196066167365371F, -0.40980330836826856F, -0.27314402793711257F);
        this.head = new ModelRenderer(this, 23, 42);
        this.head.setRotationPoint(0.0F, -0.2F, -4.9F);
        this.head.addBox(-3.0F, -3.0F, -5.0F, 6, 5, 5, 0.0F);
        this.setRotateAngle(head, 0.31869712141416456F, 0.0F, 0.0F);
        this.tail02Floof = new ModelRenderer(this, 30, 95);
        this.tail02Floof.setRotationPoint(-0.5F, 1.1F, 0.0F);
        this.tail02Floof.addBox(0.0F, -2.0F, 0.0F, 1, 3, 6, 0.0F);
        this.rForepaw.addChild(this.rFClaw04);
        this.tail01.addChild(this.tail02);
        this.head.addChild(this.upperJaw);
        this.lForepaw.addChild(this.lFClaw01);
        this.rArm01.addChild(this.rArm02);
        this.upperJaw.addChild(this.snout);
        this.front.addChild(this.rArm01);
        this.lForepaw.addChild(this.lFClaw04);
        this.lLeg03.addChild(this.lFoot);
        this.head.addChild(this.lowerJaw);
        this.rArm02.addChild(this.rForepaw);
        this.rear.addChild(this.tail01);
        this.rForepaw.addChild(this.rFClaw03);
        this.front.addChild(this.chestFloof);
        this.rLeg02.addChild(this.rLeg03);
        this.lForepaw.addChild(this.lFClaw03);
        this.lLeg01.addChild(this.lLeg02);
        this.front.addChild(this.neck);
        this.lForepaw.addChild(this.lFClaw02);
        this.rForepaw.addChild(this.rFClaw01);
        this.lFoot.addChild(this.lBClaw02);
        this.rLeg03.addChild(this.rFoot);
        this.lLeg02.addChild(this.lLeg03);
        this.head.addChild(this.lEar);
        this.rFoot.addChild(this.rBClaw01);
        this.lFoot.addChild(this.lBClaw01);
        this.rForepaw.addChild(this.rFClaw02);
        this.rear.addChild(this.rLeg01);
        this.lArm01.addChild(this.lArm02);
        this.lFoot.addChild(this.lBClaw04);
        this.rear.addChild(this.front);
        this.lArm02.addChild(this.lForepaw);
        this.tail01.addChild(this.tail01Floof);
        this.rFoot.addChild(this.rBClaw04);
        this.neck.addChild(this.neckFloof);
        this.rFoot.addChild(this.rBClaw03);
        this.rear.addChild(this.bellyFloof);
        this.rFoot.addChild(this.rBClaw02);
        this.front.addChild(this.lArm01);
        this.lFoot.addChild(this.lBClaw03);
        this.rear.addChild(this.lLeg01);
        this.rLeg01.addChild(this.rLeg02);
        this.head.addChild(this.rEar);
        this.neck.addChild(this.head);
        this.tail02.addChild(this.tail02Floof);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.rear.render(f5);
    }

    @Override
    public void setLivingAnimations(EntityLivingBase entity, float limbSwing, float limbSwingAmount,
            float partialTickTime) {

        if(entity instanceof EntityBadger) {
            EntityBadger badger = (EntityBadger) entity;
            int f1 = badger.getDigOffset();
            if(f1 > 0) {
                float r = (float) Math.toRadians(f1);
                this.lArm01.rotateAngleX = Math.max(MathHelper.sin(r*10) * 2.5F * 10 + 0.22759093446006054F, 0.22759093446006054F);
                this.rArm01.rotateAngleX = Math.max(MathHelper.cos(r*10 + (float) Math.PI) * 2.5F * 10 + 0.22759093446006054F, 0.22759093446006054F);
                this.rear.rotateAngleX = (float) (Math.toRadians(Math.max((r * 100), 45F)) - 0.045553093477052F);
                EntityLivingBase t = badger.getAttackTarget();
                if(t != null) {
                    this.rear.rotateAngleY = (float) Math.toRadians(Math.atan2((badger.posZ - t.posZ), (badger.posX - t.posX)));
                } else {
                    this.rear.rotateAngleY = 0F;
                }
            } else {
                this.lLeg01.rotateAngleX = MathHelper.sin(limbSwing * 0.8665F + (float) Math.PI) * 1.5F * limbSwingAmount;
                this.rLeg01.rotateAngleX = MathHelper.cos(limbSwing * 0.8665F) * 1.5F * limbSwingAmount;
                this.lArm01.rotateAngleX = MathHelper.sin(limbSwing * 0.8665F) * 1.5F * limbSwingAmount + 0.22759093446006054F;
                this.rArm01.rotateAngleX = MathHelper.cos(limbSwing * 0.8665F + (float) Math.PI) * 1.5F * limbSwingAmount + 0.22759093446006054F;
                this.rear.rotateAngleX = -0.045553093477052F;
                this.rear.rotateAngleY = 0F;
            }
        }

        super.setLivingAnimations(entity, limbSwing, limbSwingAmount, partialTickTime);
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
