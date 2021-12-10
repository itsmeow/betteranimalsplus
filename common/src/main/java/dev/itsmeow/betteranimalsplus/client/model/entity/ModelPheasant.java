package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import dev.itsmeow.betteranimalsplus.common.entity.EntityPheasant;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;

public class ModelPheasant<T extends LivingEntity> extends ModelBAP<T> {

    public ModelPart root;
    public ModelPart body;
    public ModelPart tail01;
    public ModelPart tail01Feathers;
    public ModelPart lTailFeather01;
    public ModelPart lTailFeather01b;
    public ModelPart rTailFeather01;
    public ModelPart rTailFeather01b;
    public ModelPart lTailFeather02;
    public ModelPart rTailFeather02;
    public ModelPart lTailFeather03;
    public ModelPart rTailFeather03;
    public ModelPart lTailFeather04;
    public ModelPart rTailFeather04;
    public ModelPart lLeg01;
    public ModelPart lLeg02;
    public ModelPart lClaw01;
    public ModelPart lClaw02;
    public ModelPart lClaw03;
    public ModelPart lClaw04;
    public ModelPart rLeg01;
    public ModelPart rLeg02;
    public ModelPart rClaw01;
    public ModelPart rClaw02;
    public ModelPart rClaw03;
    public ModelPart rClaw04;
    public ModelPart neck01;
    public ModelPart neck02;
    public ModelPart head;
    public ModelPart beak01;
    public ModelPart beak02;
    public ModelPart lWing01;
    public ModelPart lWing02;
    public ModelPart lWingFeathers;
    public ModelPart rWing01;
    public ModelPart rWing02;
    public ModelPart rWingFeathers;

    public ModelPheasant() {
        texWidth = 64;
        texHeight = 32;

        root = new ModelPart(this);
        root.setPos(0.0F, 0.0F, 0.0F);


        body = new ModelPart(this);
        body.setPos(0.0F, 15.7F, 0.0F);
        root.addChild(body);
        setRotationAngle(body, -0.1396F, 0.0F, 0.0F);
        body.texOffs(0, 0).addBox(-2.5F, -3.0F, -4.0F, 5.0F, 6.0F, 8.0F, 0.0F, false);

        tail01 = new ModelPart(this);
        tail01.setPos(0.0F, -1.8F, 3.6F);
        body.addChild(tail01);
        setRotationAngle(tail01, 0.0524F, 0.0F, 0.0F);
        tail01.texOffs(19, 0).addBox(-2.5F, -1.0F, 0.0F, 5.0F, 2.0F, 5.0F, -0.1F, false);

        tail01Feathers = new ModelPart(this);
        tail01Feathers.setPos(0.0F, 2.7F, -0.1F);
        tail01.addChild(tail01Feathers);
        setRotationAngle(tail01Feathers, 0.1222F, 0.0F, 0.0F);
        tail01Feathers.texOffs(44, 1).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 6.0F, 0.0F, false);

        lTailFeather01 = new ModelPart(this);
        lTailFeather01.setPos(0.9F, -0.6F, 4.3F);
        tail01.addChild(lTailFeather01);
        setRotationAngle(lTailFeather01, 0.0F, 0.0698F, 0.0F);
        lTailFeather01.texOffs(42, 25).addBox(-1.2F, 0.0F, 0.0F, 3.0F, 0.0F, 7.0F, 0.0F, false);

        lTailFeather01b = new ModelPart(this);
        lTailFeather01b.setPos(0.0F, 0.0F, 6.8F);
        lTailFeather01.addChild(lTailFeather01b);
        setRotationAngle(lTailFeather01b, 0.0873F, 0.0F, 0.0F);
        lTailFeather01b.texOffs(42, 18).addBox(-1.25F, 0.0F, 0.0F, 2.0F, 0.0F, 7.0F, 0.0F, false);

        rTailFeather01 = new ModelPart(this);
        rTailFeather01.setPos(-0.9F, -0.6F, 4.3F);
        tail01.addChild(rTailFeather01);
        setRotationAngle(rTailFeather01, 0.0F, -0.0698F, 0.0F);
        rTailFeather01.texOffs(42, 25).addBox(-1.8F, 0.0F, 0.0F, 3.0F, 0.0F, 7.0F, 0.0F, true);

        rTailFeather01b = new ModelPart(this);
        rTailFeather01b.setPos(1.0F, 0.0F, 6.8F);
        rTailFeather01.addChild(rTailFeather01b);
        setRotationAngle(rTailFeather01b, 0.0873F, 0.0F, 0.0F);
        rTailFeather01b.texOffs(42, 18).addBox(-1.75F, 0.0F, 0.0F, 2.0F, 0.0F, 7.0F, 0.0F, true);

        lTailFeather02 = new ModelPart(this);
        lTailFeather02.setPos(2.0F, -0.3F, 4.4F);
        tail01.addChild(lTailFeather02);
        setRotationAngle(lTailFeather02, 0.0F, 0.2618F, 0.0F);
        lTailFeather02.texOffs(50, 25).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 7.0F, 0.0F, false);

        rTailFeather02 = new ModelPart(this);
        rTailFeather02.setPos(-2.0F, -0.3F, 4.4F);
        tail01.addChild(rTailFeather02);
        setRotationAngle(rTailFeather02, 0.0F, -0.2618F, 0.0F);
        rTailFeather02.texOffs(50, 25).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 7.0F, 0.0F, true);

        lTailFeather03 = new ModelPart(this);
        lTailFeather03.setPos(1.8F, 0.1F, 3.5F);
        tail01.addChild(lTailFeather03);
        setRotationAngle(lTailFeather03, 0.0F, 0.5236F, 0.0F);
        lTailFeather03.texOffs(51, 18).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 6.0F, 0.0F, false);

        rTailFeather03 = new ModelPart(this);
        rTailFeather03.setPos(-1.8F, 0.1F, 3.5F);
        tail01.addChild(rTailFeather03);
        setRotationAngle(rTailFeather03, 0.0F, -0.5236F, 0.0F);
        rTailFeather03.texOffs(51, 18).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 6.0F, 0.0F, true);

        lTailFeather04 = new ModelPart(this);
        lTailFeather04.setPos(2.0F, 0.3F, 2.7F);
        tail01.addChild(lTailFeather04);
        setRotationAngle(lTailFeather04, 0.0F, 0.6283F, 0.0F);
        lTailFeather04.texOffs(51, 18).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 6.0F, 0.0F, false);

        rTailFeather04 = new ModelPart(this);
        rTailFeather04.setPos(-2.0F, 0.3F, 2.7F);
        tail01.addChild(rTailFeather04);
        setRotationAngle(rTailFeather04, 0.0F, -0.6283F, 0.0F);
        rTailFeather04.texOffs(51, 18).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 6.0F, 0.0F, true);

        lLeg01 = new ModelPart(this);
        lLeg01.setPos(1.8F, 2.6F, 2.7F);
        body.addChild(lLeg01);
        setRotationAngle(lLeg01, 0.2094F, 0.0F, 0.0F);
        lLeg01.texOffs(0, 15).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

        lLeg02 = new ModelPart(this);
        lLeg02.setPos(0.0F, 1.6F, 0.0F);
        lLeg01.addChild(lLeg02);
        setRotationAngle(lLeg02, -0.2094F, 0.0F, 0.0F);
        lLeg02.texOffs(9, 14).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

        lClaw01 = new ModelPart(this);
        lClaw01.setPos(0.0F, 3.1F, -0.5F);
        lLeg02.addChild(lClaw01);
        setRotationAngle(lClaw01, 0.2443F, 0.0F, 0.0F);
        lClaw01.texOffs(0, 0).addBox(-0.5F, 0.5F, -2.5F, 1.0F, 0.0F, 3.0F, 0.0F, false);

        lClaw02 = new ModelPart(this);
        lClaw02.setPos(0.5F, 3.2F, -0.2F);
        lLeg02.addChild(lClaw02);
        setRotationAngle(lClaw02, 0.1571F, -0.3491F, 0.0F);
        lClaw02.texOffs(0, 0).addBox(-0.5F, 0.5F, -2.5F, 1.0F, 0.0F, 3.0F, 0.0F, false);

        lClaw03 = new ModelPart(this);
        lClaw03.setPos(-0.5F, 3.2F, -0.2F);
        lLeg02.addChild(lClaw03);
        setRotationAngle(lClaw03, 0.1571F, 0.3491F, 0.0F);
        lClaw03.texOffs(0, 0).addBox(-0.5F, 0.5F, -2.5F, 1.0F, 0.0F, 3.0F, 0.0F, false);

        lClaw04 = new ModelPart(this);
        lClaw04.setPos(0.0F, 3.0F, 0.2F);
        lLeg02.addChild(lClaw04);
        lClaw04.texOffs(0, 19).addBox(-0.5F, 0.5F, -0.5F, 1.0F, 0.0F, 3.0F, 0.0F, false);

        rLeg01 = new ModelPart(this);
        rLeg01.setPos(-1.8F, 2.6F, 2.7F);
        body.addChild(rLeg01);
        setRotationAngle(rLeg01, 0.2094F, 0.0F, 0.0F);
        rLeg01.texOffs(0, 15).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, true);

        rLeg02 = new ModelPart(this);
        rLeg02.setPos(0.0F, 1.6F, 0.0F);
        rLeg01.addChild(rLeg02);
        setRotationAngle(rLeg02, -0.2094F, 0.0F, 0.0F);
        rLeg02.texOffs(9, 14).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, true);

        rClaw01 = new ModelPart(this);
        rClaw01.setPos(0.0F, 3.1F, -0.5F);
        rLeg02.addChild(rClaw01);
        setRotationAngle(rClaw01, 0.2443F, 0.0F, 0.0F);
        rClaw01.texOffs(0, 0).addBox(-0.5F, 0.5F, -2.5F, 1.0F, 0.0F, 3.0F, 0.0F, true);

        rClaw02 = new ModelPart(this);
        rClaw02.setPos(-0.5F, 3.2F, -0.2F);
        rLeg02.addChild(rClaw02);
        setRotationAngle(rClaw02, 0.1571F, 0.3491F, 0.0F);
        rClaw02.texOffs(0, 0).addBox(-0.5F, 0.5F, -2.5F, 1.0F, 0.0F, 3.0F, 0.0F, true);

        rClaw03 = new ModelPart(this);
        rClaw03.setPos(0.5F, 3.2F, -0.2F);
        rLeg02.addChild(rClaw03);
        setRotationAngle(rClaw03, 0.1571F, -0.3491F, 0.0F);
        rClaw03.texOffs(0, 0).addBox(-0.5F, 0.5F, -2.5F, 1.0F, 0.0F, 3.0F, 0.0F, true);

        rClaw04 = new ModelPart(this);
        rClaw04.setPos(0.0F, 3.0F, 0.2F);
        rLeg02.addChild(rClaw04);
        rClaw04.texOffs(0, 19).addBox(-0.5F, 0.5F, -0.5F, 1.0F, 0.0F, 3.0F, 0.0F, true);

        neck01 = new ModelPart(this);
        neck01.setPos(0.0F, -0.6F, -2.7F);
        body.addChild(neck01);
        setRotationAngle(neck01, -0.9076F, 0.0F, 0.0F);
        neck01.texOffs(13, 15).addBox(-2.0F, -2.0F, -3.2F, 4.0F, 4.0F, 4.0F, 0.0F, false);

        neck02 = new ModelPart(this);
        neck02.setPos(0.0F, 0.1F, -2.7F);
        neck01.addChild(neck02);
        setRotationAngle(neck02, -0.0349F, 0.0F, 0.0F);
        neck02.texOffs(0, 24).addBox(-1.5F, -1.5F, -2.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

        head = new ModelPart(this);
        head.setPos(0.0F, 0.3F, -3.1F);
        neck02.addChild(head);
        setRotationAngle(head, -0.4538F, 0.0F, 0.0F);
        head.texOffs(27, 7).addBox(-1.5F, -2.1F, -1.5F, 3.0F, 4.0F, 3.0F, 0.01F, false);

        beak01 = new ModelPart(this);
        beak01.setPos(0.0F, 1.7F, 0.0F);
        head.addChild(beak01);
        setRotationAngle(beak01, 0.2094F, 0.0F, 0.0F);
        beak01.texOffs(53, 12).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.1F, false);

        beak02 = new ModelPart(this);
        beak02.setPos(0.0F, 0.2F, 0.0F);
        beak01.addChild(beak02);
        beak02.texOffs(58, 0).addBox(-1.0F, -0.7F, -0.7F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        lWing01 = new ModelPart(this);
        lWing01.setPos(2.0F, -1.4F, -2.1F);
        body.addChild(lWing01);
        setRotationAngle(lWing01, 0.0F, -1.3526F, 0.0F);
        lWing01.texOffs(25, 18).addBox(0.0F, -0.5F, -1.0F, 7.0F, 1.0F, 5.0F, 0.0F, true);

        lWing02 = new ModelPart(this);
        lWing02.setPos(5.4F, 0.0F, -0.3F);
        lWing01.addChild(lWing02);
        setRotationAngle(lWing02, 0.0F, -0.5672F, 0.0F);
        lWing02.texOffs(30, 14).addBox(-0.25F, -0.51F, -0.5F, 6.0F, 1.0F, 3.0F, 0.0F, true);

        lWingFeathers = new ModelPart(this);
        lWingFeathers.setPos(0.0F, 0.0F, 0.0F);
        lWing02.addChild(lWingFeathers);
        lWingFeathers.texOffs(4, 24).addBox(-5.9F, -0.1F, -0.4F, 18.0F, 0.0F, 8.0F, 0.0F, false);

        rWing01 = new ModelPart(this);
        rWing01.setPos(-2.0F, -1.4F, -2.1F);
        body.addChild(rWing01);
        setRotationAngle(rWing01, 0.0F, 1.3526F, 0.0F);
        rWing01.texOffs(25, 18).addBox(-7.0F, -0.5F, -1.0F, 7.0F, 1.0F, 5.0F, 0.0F, false);

        rWing02 = new ModelPart(this);
        rWing02.setPos(-5.4F, 0.0F, -0.3F);
        rWing01.addChild(rWing02);
        setRotationAngle(rWing02, 0.0F, 0.5672F, 0.0F);
        rWing02.texOffs(30, 14).addBox(-5.75F, -0.51F, -0.5F, 6.0F, 1.0F, 3.0F, 0.0F, false);

        rWingFeathers = new ModelPart(this);
        rWingFeathers.setPos(0.0F, 0.0F, 0.0F);
        rWing02.addChild(rWingFeathers);
        rWingFeathers.texOffs(4, 24).addBox(-12.1F, -0.1F, -0.4F, 18.0F, 0.0F, 8.0F, 0.0F, true);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.root.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.headPitch(neck01, headPitch);
        this.headYaw(neck01, netHeadYaw);
        if (entityIn instanceof EntityPheasant) {
            EntityPheasant ent = (EntityPheasant) entityIn;
            float peckTime = ent.getPeckTime();
            if (peckTime <= 60) {
                this.neck01.xRot = rad(peckTime % (60F / peckTime)) * 6F + rad(30F);
            }
        }
        this.biped(lLeg01, rLeg01, limbSwing * 0.6662F, limbSwingAmount * 1.4F);
        this.rWing01.zRot = ageInTicks - 0.4F;
        this.lWing01.zRot = -ageInTicks + 0.4F;
        this.rWing01.yRot = ageInTicks == 0 ? 1.3526F : 0;
        this.lWing01.yRot = -this.rWing01.yRot;
        this.lWingFeathers.visible = this.rWingFeathers.visible = ageInTicks > 0;
    }

}
