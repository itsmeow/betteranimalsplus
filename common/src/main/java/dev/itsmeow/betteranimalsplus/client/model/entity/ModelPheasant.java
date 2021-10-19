package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.common.entity.EntityPheasant;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;

/**
 * pheasant - cybercat5555 Created using Tabula 5.1.0
 */
public class ModelPheasant<T extends LivingEntity> extends EntityModel<T> {

    public ModelPart body;
    public ModelPart tail01;
    public ModelPart lLeg01;
    public ModelPart rLeg01;
    public ModelPart neck01;
    public ModelPart lWing01;
    public ModelPart rWing01;
    public ModelPart tail01Feathers;
    public ModelPart lTailFeather01;
    public ModelPart rTailFeather01;
    public ModelPart lTailFeather02;
    public ModelPart rTailFeather02;
    public ModelPart lTailFeather03;
    public ModelPart rTailFeather03;
    public ModelPart lTailFeather04;
    public ModelPart rTailFeather04;
    public ModelPart lTailFeather01b;
    public ModelPart rTailFeather01b;
    public ModelPart lLeg02;
    public ModelPart lClaw01;
    public ModelPart lClaw02;
    public ModelPart lClaw03;
    public ModelPart lClaw04;
    public ModelPart rLeg02;
    public ModelPart rClaw01;
    public ModelPart rClaw02;
    public ModelPart rClaw02_1;
    public ModelPart rClaw04;
    public ModelPart neck02;
    public ModelPart head;
    public ModelPart headB;
    public ModelPart beak01;
    public ModelPart beak03;
    public ModelPart beak02;
    public ModelPart lWing02;
    public ModelPart lWing01Feathers;
    public ModelPart lWing02Feathers;
    public ModelPart rWing02;
    public ModelPart rWing01Feathers;
    public ModelPart rWing02Feathers;

    public ModelPheasant() {
        this.texWidth = 64;
        this.texHeight = 32;
        this.beak03 = new ModelPart(this, 58, 0);
        this.beak03.setPos(0.0F, 0.2F, 0.0F);
        this.beak03.addBox(-1.0F, -0.7F, -0.7F, 2, 1, 1, 0.0F);
        this.lClaw01 = new ModelPart(this, 0, 0);
        this.lClaw01.setPos(0.0F, 3.6F, -0.5F);
        this.lClaw01.addBox(-0.5F, -0.5F, -2.5F, 1, 1, 3, 0.0F);
        this.setRotateAngle(this.lClaw01, 0.24434609527920614F, 0.0F, 0.0F);
        this.rClaw02_1 = new ModelPart(this, 0, 0);
        this.rClaw02_1.setPos(0.5F, 3.7F, -0.2F);
        this.rClaw02_1.addBox(-0.5F, -0.5F, -2.5F, 1, 1, 3, 0.0F);
        this.setRotateAngle(this.rClaw02_1, 0.24434609527920614F, -0.3490658503988659F, 0.0F);
        this.body = new ModelPart(this, 0, 0);
        this.body.setPos(0.0F, 15.7F, 0.0F);
        this.body.addBox(-2.5F, -3.0F, -4.0F, 5, 6, 8, 0.2F);
        this.setRotateAngle(this.body, -0.13962634015954636F, 0.0F, 0.0F);
        this.headB = new ModelPart(this, 40, 0);
        this.headB.setPos(0.0F, 0.0F, 0.0F);
        this.headB.addBox(-1.7F, -2.1F, -1.5F, 1, 4, 3, 0.0F);
        this.rLeg02 = new ModelPart(this, 9, 14);
        this.rLeg02.mirror = true;
        this.rLeg02.setPos(0.0F, 1.6F, 0.0F);
        this.rLeg02.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(this.rLeg02, -0.20943951023931953F, 0.0F, 0.0F);
        this.rTailFeather04 = new ModelPart(this, 51, 18);
        this.rTailFeather04.mirror = true;
        this.rTailFeather04.setPos(-2.0F, 0.3F, 2.7F);
        this.rTailFeather04.addBox(-1.0F, 0.0F, 0.0F, 2, 0, 6, 0.0F);
        this.setRotateAngle(this.rTailFeather04, 0.0F, -0.6283185307179586F, 0.0F);
        this.rClaw04 = new ModelPart(this, 0, 19);
        this.rClaw04.mirror = true;
        this.rClaw04.setPos(0.0F, 3.5F, 0.2F);
        this.rClaw04.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 3, 0.0F);
        this.rWing01Feathers = new ModelPart(this, 26, 19);
        this.rWing01Feathers.mirror = true;
        this.rWing01Feathers.setPos(0.0F, 0.0F, 0.0F);
        this.rWing01Feathers.addBox(-4.0F, 0.0F, -0.7F, 4, 0, 6, 0.0F);
        this.lClaw02 = new ModelPart(this, 0, 0);
        this.lClaw02.setPos(0.5F, 3.7F, -0.2F);
        this.lClaw02.addBox(-0.5F, -0.5F, -2.5F, 1, 1, 3, 0.0F);
        this.setRotateAngle(this.lClaw02, 0.24434609527920614F, -0.3490658503988659F, 0.0F);
        this.beak01 = new ModelPart(this, 53, 12);
        this.beak01.setPos(0.0F, 1.7F, 0.0F);
        this.beak01.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(this.beak01, 0.20943951023931953F, 0.0F, 0.0F);
        this.rTailFeather02 = new ModelPart(this, 50, 25);
        this.rTailFeather02.mirror = true;
        this.rTailFeather02.setPos(-2.0F, -0.3F, 4.4F);
        this.rTailFeather02.addBox(-1.0F, 0.0F, 0.0F, 2, 0, 7, 0.0F);
        this.setRotateAngle(this.rTailFeather02, 0.0F, -0.2617993877991494F, 0.0F);
        this.lWing01Feathers = new ModelPart(this, 26, 19);
        this.lWing01Feathers.setPos(0.0F, 0.0F, 0.0F);
        this.lWing01Feathers.addBox(0.0F, 0.0F, -0.7F, 4, 0, 6, 0.0F);
        this.lTailFeather01b = new ModelPart(this, 42, 18);
        this.lTailFeather01b.setPos(0.0F, 0.0F, 6.8F);
        this.lTailFeather01b.addBox(-1.0F, 0.0F, 0.0F, 2, 0, 7, 0.0F);
        this.setRotateAngle(this.lTailFeather01b, 0.08726646259971647F, 0.0F, 0.0F);
        this.neck02 = new ModelPart(this, 0, 24);
        this.neck02.setPos(0.0F, 0.1F, -2.7F);
        this.neck02.addBox(-1.5F, -1.5F, -2.5F, 3, 3, 3, 0.0F);
        this.setRotateAngle(this.neck02, -0.03490658503988659F, 0.0F, 0.0F);
        this.lWing02Feathers = new ModelPart(this, 26, 26);
        this.lWing02Feathers.setPos(0.0F, 0.0F, 0.0F);
        this.lWing02Feathers.addBox(1.0F, -0.1F, -0.4F, 8, 0, 6, 0.0F);
        this.neck01 = new ModelPart(this, 13, 15);
        this.neck01.setPos(0.0F, -0.6F, -2.7F);
        this.neck01.addBox(-2.0F, -2.0F, -3.2F, 4, 4, 4, 0.0F);
        this.setRotateAngle(this.neck01, -0.9075712110370513F, 0.0F, 0.0F);
        this.rTailFeather03 = new ModelPart(this, 51, 18);
        this.rTailFeather03.mirror = true;
        this.rTailFeather03.setPos(-1.8F, 0.1F, 3.5F);
        this.rTailFeather03.addBox(-1.0F, 0.0F, 0.0F, 2, 0, 6, 0.0F);
        this.setRotateAngle(this.rTailFeather03, 0.0F, -0.5235987755982988F, 0.0F);
        this.head = new ModelPart(this, 27, 8);
        this.head.setPos(0.0F, 0.3F, -3.1F);
        this.head.addBox(-1.3F, -2.1F, -1.5F, 3, 4, 3, 0.0F);
        this.setRotateAngle(this.head, -0.45378560551852565F, 0.0F, 0.0F);
        this.beak02 = new ModelPart(this, 53, 12);
        this.beak02.setPos(0.0F, 0.0F, 0.0F);
        this.beak02.addBox(-0.5F, -0.2F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(this.beak02, -0.10471975511965977F, 0.0F, 0.0F);
        this.rWing02 = new ModelPart(this, 14, 29);
        this.rWing02.mirror = true;
        this.rWing02.setPos(-2.9F, 0.0F, -0.3F);
        this.rWing02.addBox(-4.0F, -0.51F, -0.5F, 4, 1, 1, 0.0F);
        this.setRotateAngle(this.rWing02, 0.0F, 0.5235987755982988F, 0.0F);
        this.rWing01 = new ModelPart(this, 14, 24);
        this.rWing01.mirror = true;
        this.rWing01.setPos(-2.5F, -1.4F, -2.1F);
        this.rWing01.addBox(-3.0F, -0.5F, -1.0F, 3, 1, 2, 0.0F);
        this.setRotateAngle(this.rWing01, 0.0F, 1.2217304763960306F, 0.0F);
        this.lClaw03 = new ModelPart(this, 0, 0);
        this.lClaw03.mirror = true;
        this.lClaw03.setPos(-0.5F, 3.7F, -0.2F);
        this.lClaw03.addBox(-0.5F, -0.5F, -2.5F, 1, 1, 3, 0.0F);
        this.setRotateAngle(this.lClaw03, 0.24434609527920614F, 0.3490658503988659F, 0.0F);
        this.rLeg01 = new ModelPart(this, 0, 15);
        this.rLeg01.mirror = true;
        this.rLeg01.setPos(-1.8F, 2.6F, 2.7F);
        this.rLeg01.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(this.rLeg01, 0.20943951023931953F, 0.0F, 0.0F);
        this.tail01Feathers = new ModelPart(this, 44, 1);
        this.tail01Feathers.setPos(0.0F, 2.7F, -0.1F);
        this.tail01Feathers.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 6, 0.0F);
        this.setRotateAngle(this.tail01Feathers, 0.12217304763960307F, 0.0F, 0.0F);
        this.lLeg01 = new ModelPart(this, 0, 15);
        this.lLeg01.setPos(1.8F, 2.6F, 2.7F);
        this.lLeg01.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(this.lLeg01, 0.20943951023931953F, 0.0F, 0.0F);
        this.tail01 = new ModelPart(this, 19, 0);
        this.tail01.setPos(0.0F, -1.8F, 3.6F);
        this.tail01.addBox(-2.5F, -1.0F, 0.0F, 5, 2, 5, 0.0F);
        this.setRotateAngle(this.tail01, 0.05235987755982988F, 0.0F, 0.0F);
        this.rWing02Feathers = new ModelPart(this, 26, 26);
        this.rWing02Feathers.mirror = true;
        this.rWing02Feathers.setPos(0.0F, 0.0F, 0.0F);
        this.rWing02Feathers.addBox(-9.0F, -0.1F, -0.4F, 8, 0, 6, 0.0F);
        this.lWing02 = new ModelPart(this, 14, 29);
        this.lWing02.setPos(2.9F, 0.0F, -0.3F);
        this.lWing02.addBox(0.0F, -0.51F, -0.5F, 4, 1, 1, 0.0F);
        this.setRotateAngle(this.lWing02, 0.0F, -0.5235987755982988F, 0.0F);
        this.lTailFeather02 = new ModelPart(this, 50, 25);
        this.lTailFeather02.setPos(2.0F, -0.3F, 4.4F);
        this.lTailFeather02.addBox(-1.0F, 0.0F, 0.0F, 2, 0, 7, 0.0F);
        this.setRotateAngle(this.lTailFeather02, 0.0F, 0.2617993877991494F, 0.0F);
        this.rClaw01 = new ModelPart(this, 0, 0);
        this.rClaw01.mirror = true;
        this.rClaw01.setPos(0.0F, 3.6F, -0.5F);
        this.rClaw01.addBox(-0.5F, -0.5F, -2.5F, 1, 1, 3, 0.0F);
        this.setRotateAngle(this.rClaw01, 0.24434609527920614F, 0.0F, 0.0F);
        this.lTailFeather01 = new ModelPart(this, 42, 25);
        this.lTailFeather01.setPos(0.9F, -0.6F, 4.3F);
        this.lTailFeather01.addBox(-1.2F, 0.0F, 0.0F, 3, 0, 7, 0.0F);
        this.setRotateAngle(this.lTailFeather01, 0.0F, 0.06981317007977318F, 0.0F);
        this.rClaw02 = new ModelPart(this, 0, 0);
        this.rClaw02.mirror = true;
        this.rClaw02.setPos(-0.5F, 3.7F, -0.2F);
        this.rClaw02.addBox(-0.5F, -0.5F, -2.5F, 1, 1, 3, 0.0F);
        this.setRotateAngle(this.rClaw02, 0.24434609527920614F, 0.3490658503988659F, 0.0F);
        this.lLeg02 = new ModelPart(this, 9, 14);
        this.lLeg02.setPos(0.0F, 1.6F, 0.0F);
        this.lLeg02.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(this.lLeg02, -0.20943951023931953F, 0.0F, 0.0F);
        this.lTailFeather03 = new ModelPart(this, 51, 18);
        this.lTailFeather03.setPos(1.8F, 0.1F, 3.5F);
        this.lTailFeather03.addBox(-1.0F, 0.0F, 0.0F, 2, 0, 6, 0.0F);
        this.setRotateAngle(this.lTailFeather03, 0.0F, 0.5235987755982988F, 0.0F);
        this.lTailFeather04 = new ModelPart(this, 51, 18);
        this.lTailFeather04.setPos(2.0F, 0.3F, 2.7F);
        this.lTailFeather04.addBox(-1.0F, 0.0F, 0.0F, 2, 0, 6, 0.0F);
        this.setRotateAngle(this.lTailFeather04, 0.0F, 0.6283185307179586F, 0.0F);
        this.rTailFeather01 = new ModelPart(this, 42, 25);
        this.rTailFeather01.mirror = true;
        this.rTailFeather01.setPos(-0.9F, -0.6F, 4.3F);
        this.rTailFeather01.addBox(-1.8F, 0.0F, 0.0F, 3, 0, 7, 0.0F);
        this.setRotateAngle(this.rTailFeather01, 0.0F, -0.06981317007977318F, 0.0F);
        this.lWing01 = new ModelPart(this, 14, 24);
        this.lWing01.setPos(2.5F, -1.4F, -2.1F);
        this.lWing01.addBox(0.0F, -0.5F, -1.0F, 3, 1, 2, 0.0F);
        this.setRotateAngle(this.lWing01, 0.0F, -1.2217304763960306F, 0.0F);
        this.lClaw04 = new ModelPart(this, 0, 19);
        this.lClaw04.setPos(0.0F, 3.5F, 0.2F);
        this.lClaw04.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 3, 0.0F);
        this.rTailFeather01b = new ModelPart(this, 42, 18);
        this.rTailFeather01b.mirror = true;
        this.rTailFeather01b.setPos(0.0F, 0.0F, 6.8F);
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
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entityIn instanceof EntityPheasant) {
            EntityPheasant ent = (EntityPheasant) entityIn;
            float peckTime = ent.getPeckTime();
            if (peckTime <= 60) {
                this.neck01.xRot = (float) Math.toRadians(peckTime % (60F / peckTime)) * 6F
                        + (float) Math.toRadians(30);
            } else {
                this.neck01.xRot = headPitch * 0.017453292F - 0.9075712110370513F;
            }
        }
        this.neck01.yRot = netHeadYaw * 0.017453292F;
        this.rLeg01.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.lLeg01.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.rWing01.zRot = ageInTicks - 0.4F;
        this.lWing01.zRot = -ageInTicks + 0.4F;
        this.rWing01.yRot = ageInTicks == 0 ? 1.2217304763960306F : 0;
        this.lWing01.yRot = -this.rWing01.yRot;
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelPart modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
