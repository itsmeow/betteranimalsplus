package its_meow.betteranimalsplus.client.model;

import its_meow.betteranimalsplus.common.entity.EntityPheasant;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;

/**
 * pheasant - cybercat5555 Created using Tabula 5.1.0
 */
public class ModelPheasant<T extends LivingEntity> extends EntityModel<T> {

    public RendererModel body;
    public RendererModel tail01;
    public RendererModel lLeg01;
    public RendererModel rLeg01;
    public RendererModel neck01;
    public RendererModel lWing01;
    public RendererModel rWing01;
    public RendererModel tail01Feathers;
    public RendererModel lTailFeather01;
    public RendererModel rTailFeather01;
    public RendererModel lTailFeather02;
    public RendererModel rTailFeather02;
    public RendererModel lTailFeather03;
    public RendererModel rTailFeather03;
    public RendererModel lTailFeather04;
    public RendererModel rTailFeather04;
    public RendererModel lTailFeather01b;
    public RendererModel rTailFeather01b;
    public RendererModel lLeg02;
    public RendererModel lClaw01;
    public RendererModel lClaw02;
    public RendererModel lClaw03;
    public RendererModel lClaw04;
    public RendererModel rLeg02;
    public RendererModel rClaw01;
    public RendererModel rClaw02;
    public RendererModel rClaw02_1;
    public RendererModel rClaw04;
    public RendererModel neck02;
    public RendererModel head;
    public RendererModel headB;
    public RendererModel beak01;
    public RendererModel beak03;
    public RendererModel beak02;
    public RendererModel lWing02;
    public RendererModel lWing01Feathers;
    public RendererModel lWing02Feathers;
    public RendererModel rWing02;
    public RendererModel rWing01Feathers;
    public RendererModel rWing02Feathers;

    public ModelPheasant() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.beak03 = new RendererModel(this, 58, 0);
        this.beak03.setRotationPoint(0.0F, 0.2F, 0.0F);
        this.beak03.addBox(-1.0F, -0.7F, -0.7F, 2, 1, 1, 0.0F);
        this.lClaw01 = new RendererModel(this, 0, 0);
        this.lClaw01.setRotationPoint(0.0F, 3.6F, -0.5F);
        this.lClaw01.addBox(-0.5F, -0.5F, -2.5F, 1, 1, 3, 0.0F);
        this.setRotateAngle(this.lClaw01, 0.24434609527920614F, 0.0F, 0.0F);
        this.rClaw02_1 = new RendererModel(this, 0, 0);
        this.rClaw02_1.setRotationPoint(0.5F, 3.7F, -0.2F);
        this.rClaw02_1.addBox(-0.5F, -0.5F, -2.5F, 1, 1, 3, 0.0F);
        this.setRotateAngle(this.rClaw02_1, 0.24434609527920614F, -0.3490658503988659F, 0.0F);
        this.body = new RendererModel(this, 0, 0);
        this.body.setRotationPoint(0.0F, 15.7F, 0.0F);
        this.body.addBox(-2.5F, -3.0F, -4.0F, 5, 6, 8, 0.2F);
        this.setRotateAngle(this.body, -0.13962634015954636F, 0.0F, 0.0F);
        this.headB = new RendererModel(this, 40, 0);
        this.headB.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headB.addBox(-1.7F, -2.1F, -1.5F, 1, 4, 3, 0.0F);
        this.rLeg02 = new RendererModel(this, 9, 14);
        this.rLeg02.mirror = true;
        this.rLeg02.setRotationPoint(0.0F, 1.6F, 0.0F);
        this.rLeg02.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(this.rLeg02, -0.20943951023931953F, 0.0F, 0.0F);
        this.rTailFeather04 = new RendererModel(this, 51, 18);
        this.rTailFeather04.mirror = true;
        this.rTailFeather04.setRotationPoint(-2.0F, 0.3F, 2.7F);
        this.rTailFeather04.addBox(-1.0F, 0.0F, 0.0F, 2, 0, 6, 0.0F);
        this.setRotateAngle(this.rTailFeather04, 0.0F, -0.6283185307179586F, 0.0F);
        this.rClaw04 = new RendererModel(this, 0, 19);
        this.rClaw04.mirror = true;
        this.rClaw04.setRotationPoint(0.0F, 3.5F, 0.2F);
        this.rClaw04.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 3, 0.0F);
        this.rWing01Feathers = new RendererModel(this, 26, 19);
        this.rWing01Feathers.mirror = true;
        this.rWing01Feathers.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rWing01Feathers.addBox(-4.0F, 0.0F, -0.7F, 4, 0, 6, 0.0F);
        this.lClaw02 = new RendererModel(this, 0, 0);
        this.lClaw02.setRotationPoint(0.5F, 3.7F, -0.2F);
        this.lClaw02.addBox(-0.5F, -0.5F, -2.5F, 1, 1, 3, 0.0F);
        this.setRotateAngle(this.lClaw02, 0.24434609527920614F, -0.3490658503988659F, 0.0F);
        this.beak01 = new RendererModel(this, 53, 12);
        this.beak01.setRotationPoint(0.0F, 1.7F, 0.0F);
        this.beak01.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(this.beak01, 0.20943951023931953F, 0.0F, 0.0F);
        this.rTailFeather02 = new RendererModel(this, 50, 25);
        this.rTailFeather02.mirror = true;
        this.rTailFeather02.setRotationPoint(-2.0F, -0.3F, 4.4F);
        this.rTailFeather02.addBox(-1.0F, 0.0F, 0.0F, 2, 0, 7, 0.0F);
        this.setRotateAngle(this.rTailFeather02, 0.0F, -0.2617993877991494F, 0.0F);
        this.lWing01Feathers = new RendererModel(this, 26, 19);
        this.lWing01Feathers.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lWing01Feathers.addBox(0.0F, 0.0F, -0.7F, 4, 0, 6, 0.0F);
        this.lTailFeather01b = new RendererModel(this, 42, 18);
        this.lTailFeather01b.setRotationPoint(0.0F, 0.0F, 6.8F);
        this.lTailFeather01b.addBox(-1.0F, 0.0F, 0.0F, 2, 0, 7, 0.0F);
        this.setRotateAngle(this.lTailFeather01b, 0.08726646259971647F, 0.0F, 0.0F);
        this.neck02 = new RendererModel(this, 0, 24);
        this.neck02.setRotationPoint(0.0F, 0.1F, -2.7F);
        this.neck02.addBox(-1.5F, -1.5F, -2.5F, 3, 3, 3, 0.0F);
        this.setRotateAngle(this.neck02, -0.03490658503988659F, 0.0F, 0.0F);
        this.lWing02Feathers = new RendererModel(this, 26, 26);
        this.lWing02Feathers.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lWing02Feathers.addBox(1.0F, -0.1F, -0.4F, 8, 0, 6, 0.0F);
        this.neck01 = new RendererModel(this, 13, 15);
        this.neck01.setRotationPoint(0.0F, -0.6F, -2.7F);
        this.neck01.addBox(-2.0F, -2.0F, -3.2F, 4, 4, 4, 0.0F);
        this.setRotateAngle(this.neck01, -0.9075712110370513F, 0.0F, 0.0F);
        this.rTailFeather03 = new RendererModel(this, 51, 18);
        this.rTailFeather03.mirror = true;
        this.rTailFeather03.setRotationPoint(-1.8F, 0.1F, 3.5F);
        this.rTailFeather03.addBox(-1.0F, 0.0F, 0.0F, 2, 0, 6, 0.0F);
        this.setRotateAngle(this.rTailFeather03, 0.0F, -0.5235987755982988F, 0.0F);
        this.head = new RendererModel(this, 27, 8);
        this.head.setRotationPoint(0.0F, 0.3F, -3.1F);
        this.head.addBox(-1.3F, -2.1F, -1.5F, 3, 4, 3, 0.0F);
        this.setRotateAngle(this.head, -0.45378560551852565F, 0.0F, 0.0F);
        this.beak02 = new RendererModel(this, 53, 12);
        this.beak02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.beak02.addBox(-0.5F, -0.2F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(this.beak02, -0.10471975511965977F, 0.0F, 0.0F);
        this.rWing02 = new RendererModel(this, 14, 29);
        this.rWing02.mirror = true;
        this.rWing02.setRotationPoint(-2.9F, 0.0F, -0.3F);
        this.rWing02.addBox(-4.0F, -0.51F, -0.5F, 4, 1, 1, 0.0F);
        this.setRotateAngle(this.rWing02, 0.0F, 0.5235987755982988F, 0.0F);
        this.rWing01 = new RendererModel(this, 14, 24);
        this.rWing01.mirror = true;
        this.rWing01.setRotationPoint(-2.5F, -1.4F, -2.1F);
        this.rWing01.addBox(-3.0F, -0.5F, -1.0F, 3, 1, 2, 0.0F);
        this.setRotateAngle(this.rWing01, 0.0F, 1.2217304763960306F, 0.0F);
        this.lClaw03 = new RendererModel(this, 0, 0);
        this.lClaw03.mirror = true;
        this.lClaw03.setRotationPoint(-0.5F, 3.7F, -0.2F);
        this.lClaw03.addBox(-0.5F, -0.5F, -2.5F, 1, 1, 3, 0.0F);
        this.setRotateAngle(this.lClaw03, 0.24434609527920614F, 0.3490658503988659F, 0.0F);
        this.rLeg01 = new RendererModel(this, 0, 15);
        this.rLeg01.mirror = true;
        this.rLeg01.setRotationPoint(-1.8F, 2.6F, 2.7F);
        this.rLeg01.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(this.rLeg01, 0.20943951023931953F, 0.0F, 0.0F);
        this.tail01Feathers = new RendererModel(this, 44, 1);
        this.tail01Feathers.setRotationPoint(0.0F, 2.7F, -0.1F);
        this.tail01Feathers.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 6, 0.0F);
        this.setRotateAngle(this.tail01Feathers, 0.12217304763960307F, 0.0F, 0.0F);
        this.lLeg01 = new RendererModel(this, 0, 15);
        this.lLeg01.setRotationPoint(1.8F, 2.6F, 2.7F);
        this.lLeg01.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(this.lLeg01, 0.20943951023931953F, 0.0F, 0.0F);
        this.tail01 = new RendererModel(this, 19, 0);
        this.tail01.setRotationPoint(0.0F, -1.8F, 3.6F);
        this.tail01.addBox(-2.5F, -1.0F, 0.0F, 5, 2, 5, 0.0F);
        this.setRotateAngle(this.tail01, 0.05235987755982988F, 0.0F, 0.0F);
        this.rWing02Feathers = new RendererModel(this, 26, 26);
        this.rWing02Feathers.mirror = true;
        this.rWing02Feathers.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rWing02Feathers.addBox(-9.0F, -0.1F, -0.4F, 8, 0, 6, 0.0F);
        this.lWing02 = new RendererModel(this, 14, 29);
        this.lWing02.setRotationPoint(2.9F, 0.0F, -0.3F);
        this.lWing02.addBox(0.0F, -0.51F, -0.5F, 4, 1, 1, 0.0F);
        this.setRotateAngle(this.lWing02, 0.0F, -0.5235987755982988F, 0.0F);
        this.lTailFeather02 = new RendererModel(this, 50, 25);
        this.lTailFeather02.setRotationPoint(2.0F, -0.3F, 4.4F);
        this.lTailFeather02.addBox(-1.0F, 0.0F, 0.0F, 2, 0, 7, 0.0F);
        this.setRotateAngle(this.lTailFeather02, 0.0F, 0.2617993877991494F, 0.0F);
        this.rClaw01 = new RendererModel(this, 0, 0);
        this.rClaw01.mirror = true;
        this.rClaw01.setRotationPoint(0.0F, 3.6F, -0.5F);
        this.rClaw01.addBox(-0.5F, -0.5F, -2.5F, 1, 1, 3, 0.0F);
        this.setRotateAngle(this.rClaw01, 0.24434609527920614F, 0.0F, 0.0F);
        this.lTailFeather01 = new RendererModel(this, 42, 25);
        this.lTailFeather01.setRotationPoint(0.9F, -0.6F, 4.3F);
        this.lTailFeather01.addBox(-1.2F, 0.0F, 0.0F, 3, 0, 7, 0.0F);
        this.setRotateAngle(this.lTailFeather01, 0.0F, 0.06981317007977318F, 0.0F);
        this.rClaw02 = new RendererModel(this, 0, 0);
        this.rClaw02.mirror = true;
        this.rClaw02.setRotationPoint(-0.5F, 3.7F, -0.2F);
        this.rClaw02.addBox(-0.5F, -0.5F, -2.5F, 1, 1, 3, 0.0F);
        this.setRotateAngle(this.rClaw02, 0.24434609527920614F, 0.3490658503988659F, 0.0F);
        this.lLeg02 = new RendererModel(this, 9, 14);
        this.lLeg02.setRotationPoint(0.0F, 1.6F, 0.0F);
        this.lLeg02.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(this.lLeg02, -0.20943951023931953F, 0.0F, 0.0F);
        this.lTailFeather03 = new RendererModel(this, 51, 18);
        this.lTailFeather03.setRotationPoint(1.8F, 0.1F, 3.5F);
        this.lTailFeather03.addBox(-1.0F, 0.0F, 0.0F, 2, 0, 6, 0.0F);
        this.setRotateAngle(this.lTailFeather03, 0.0F, 0.5235987755982988F, 0.0F);
        this.lTailFeather04 = new RendererModel(this, 51, 18);
        this.lTailFeather04.setRotationPoint(2.0F, 0.3F, 2.7F);
        this.lTailFeather04.addBox(-1.0F, 0.0F, 0.0F, 2, 0, 6, 0.0F);
        this.setRotateAngle(this.lTailFeather04, 0.0F, 0.6283185307179586F, 0.0F);
        this.rTailFeather01 = new RendererModel(this, 42, 25);
        this.rTailFeather01.mirror = true;
        this.rTailFeather01.setRotationPoint(-0.9F, -0.6F, 4.3F);
        this.rTailFeather01.addBox(-1.8F, 0.0F, 0.0F, 3, 0, 7, 0.0F);
        this.setRotateAngle(this.rTailFeather01, 0.0F, -0.06981317007977318F, 0.0F);
        this.lWing01 = new RendererModel(this, 14, 24);
        this.lWing01.setRotationPoint(2.5F, -1.4F, -2.1F);
        this.lWing01.addBox(0.0F, -0.5F, -1.0F, 3, 1, 2, 0.0F);
        this.setRotateAngle(this.lWing01, 0.0F, -1.2217304763960306F, 0.0F);
        this.lClaw04 = new RendererModel(this, 0, 19);
        this.lClaw04.setRotationPoint(0.0F, 3.5F, 0.2F);
        this.lClaw04.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 3, 0.0F);
        this.rTailFeather01b = new RendererModel(this, 42, 18);
        this.rTailFeather01b.mirror = true;
        this.rTailFeather01b.setRotationPoint(0.0F, 0.0F, 6.8F);
        this.rTailFeather01b.addBox(-1.0F, 0.0F, 0.0F, 2, 0, 7, 0.0F);
        this.setRotateAngle(this.rTailFeather01b, 0.08726646259971647F, 0.0F, 0.0F);
        this.beak01.addChild(this.beak03);
        this.lLeg02.addChild(this.lClaw01);
        this.rLeg02.addChild(this.rClaw02_1);
        this.head.addChild(this.headB);
        this.rLeg01.addChild(this.rLeg02);
        this.tail01.addChild(this.rTailFeather04);
        this.rLeg02.addChild(this.rClaw04);
        this.rWing01.addChild(this.rWing01Feathers);
        this.lLeg02.addChild(this.lClaw02);
        this.head.addChild(this.beak01);
        this.tail01.addChild(this.rTailFeather02);
        this.lWing01.addChild(this.lWing01Feathers);
        this.lTailFeather01.addChild(this.lTailFeather01b);
        this.neck01.addChild(this.neck02);
        this.lWing02.addChild(this.lWing02Feathers);
        this.body.addChild(this.neck01);
        this.tail01.addChild(this.rTailFeather03);
        this.neck02.addChild(this.head);
        this.beak01.addChild(this.beak02);
        this.rWing01.addChild(this.rWing02);
        this.body.addChild(this.rWing01);
        this.lLeg02.addChild(this.lClaw03);
        this.body.addChild(this.rLeg01);
        this.tail01.addChild(this.tail01Feathers);
        this.body.addChild(this.lLeg01);
        this.body.addChild(this.tail01);
        this.rWing02.addChild(this.rWing02Feathers);
        this.lWing01.addChild(this.lWing02);
        this.tail01.addChild(this.lTailFeather02);
        this.rLeg02.addChild(this.rClaw01);
        this.tail01.addChild(this.lTailFeather01);
        this.rLeg02.addChild(this.rClaw02);
        this.lLeg01.addChild(this.lLeg02);
        this.tail01.addChild(this.lTailFeather03);
        this.tail01.addChild(this.lTailFeather04);
        this.tail01.addChild(this.rTailFeather01);
        this.body.addChild(this.lWing01);
        this.lLeg02.addChild(this.lClaw04);
        this.rTailFeather01.addChild(this.rTailFeather01b);
    }

    @Override
    public void render(T entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.body.render(f5);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
            float headPitch, float scaleFactor) {
        if (entityIn instanceof EntityPheasant) {
            EntityPheasant ent = (EntityPheasant) entityIn;
            float peckTime = ent.getPeckTime();
            if (peckTime <= 60) {
                this.neck01.rotateAngleX = (float) Math.toRadians(peckTime % (60F / peckTime)) * 6F
                        + (float) Math.toRadians(30);
            } else {
                this.neck01.rotateAngleX = headPitch * 0.017453292F - 0.9075712110370513F;
            }
        }
        this.neck01.rotateAngleY = netHeadYaw * 0.017453292F;
        this.rLeg01.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.lLeg01.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.rWing01.rotateAngleZ = ageInTicks - 0.4F;
        this.lWing01.rotateAngleZ = -ageInTicks + 0.4F;
        this.rWing01.rotateAngleY = ageInTicks == 0 ? 1.2217304763960306F : 0;
        this.lWing01.rotateAngleY = -this.rWing01.rotateAngleY;
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(RendererModel modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
