package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import dev.itsmeow.betteranimalsplus.common.entity.EntitySquirrel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;

public class ModelSquirrel<T extends LivingEntity> extends ModelBAP<T> {

    public ModelPart lowerBody;
    public ModelPart chest;
    public ModelPart head;
    public ModelPart muzzle;
    public ModelPart lEar;
    public ModelPart rEar;
    public ModelPart lArm;
    public ModelPart rArm;
    public ModelPart lLeg01;
    public ModelPart lLeg02;
    public ModelPart rLeg01;
    public ModelPart rLeg02;
    public ModelPart tail01;
    public ModelPart tail02;
    public ModelPart tail03;
    public ModelPart tail04;

    public ModelSquirrel() {
        texWidth = 32;
        texHeight = 32;

        lowerBody = new ModelPart(this);
        lowerBody.setPos(0.0F, 20.0F, 4.0F);
        lowerBody.texOffs(0, 0).addBox(-2.0F, -2.5F, -4.0F, 4.0F, 5.0F, 5.0F, 0.1F, false);

        chest = new ModelPart(this);
        chest.setPos(0.0F, 0.0F, -3.25F);
        lowerBody.addChild(chest);
        chest.texOffs(0, 10).addBox(-2.0F, -2.0F, -4.0F, 4.0F, 4.0F, 6.0F, 0.0F, false);

        head = new ModelPart(this);
        head.setPos(0.0F, 0.0F, -4.0F);
        chest.addChild(head);
        head.texOffs(19, 0).addBox(-1.5F, -1.75F, -2.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

        muzzle = new ModelPart(this);
        muzzle.setPos(0.0F, -0.25F, -1.75F);
        head.addChild(muzzle);
        muzzle.texOffs(19, 5).addBox(-1.0F, -0.75F, -1.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);

        lEar = new ModelPart(this);
        lEar.setPos(1.0F, -1.0F, -1.0F);
        head.addChild(lEar);
        setRotationAngle(lEar, 0.0873F, -0.6545F, 0.3054F);
        lEar.texOffs(14, 0).addBox(-0.75F, -3.0F, 0.0F, 2.0F, 3.0F, 0.0F, 0.0F, false);

        rEar = new ModelPart(this);
        rEar.setPos(-1.0F, -1.0F, -1.0F);
        head.addChild(rEar);
        setRotationAngle(rEar, 0.0873F, 0.6545F, -0.3054F);
        rEar.texOffs(14, 0).addBox(-1.25F, -3.0F, 0.0F, 2.0F, 3.0F, 0.0F, 0.0F, true);

        lArm = new ModelPart(this);
        lArm.setPos(2.0F, 0.0F, -2.5F);
        chest.addChild(lArm);
        lArm.texOffs(0, 0).addBox(-0.75F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

        rArm = new ModelPart(this);
        rArm.setPos(-2.0F, 0.0F, -2.5F);
        chest.addChild(rArm);
        rArm.texOffs(0, 0).addBox(-0.25F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, true);

        lLeg01 = new ModelPart(this);
        lLeg01.setPos(1.5F, 0.0F, -1.5F);
        lowerBody.addChild(lLeg01);
        setRotationAngle(lLeg01, -0.1309F, 0.0F, 0.0F);
        lLeg01.texOffs(0, 20).addBox(0.0F, -1.0F, -2.0F, 2.0F, 4.0F, 5.0F, -0.2F, false);

        lLeg02 = new ModelPart(this);
        lLeg02.setPos(0.75F, 2.75F, 2.75F);
        lLeg01.addChild(lLeg02);
        setRotationAngle(lLeg02, 0.1309F, 0.0F, 0.0F);
        lLeg02.texOffs(11, 27).addBox(-1.0F, 0.0F, -3.75F, 2.0F, 1.0F, 4.0F, 0.0F, false);

        rLeg01 = new ModelPart(this);
        rLeg01.setPos(-1.5F, 0.0F, -1.5F);
        lowerBody.addChild(rLeg01);
        setRotationAngle(rLeg01, -0.1309F, 0.0F, 0.0F);
        rLeg01.texOffs(0, 20).addBox(-2.0F, -1.0F, -2.0F, 2.0F, 4.0F, 5.0F, -0.2F, true);

        rLeg02 = new ModelPart(this);
        rLeg02.setPos(-0.75F, 2.75F, 2.75F);
        rLeg01.addChild(rLeg02);
        setRotationAngle(rLeg02, 0.1309F, 0.0F, 0.0F);
        rLeg02.texOffs(11, 27).addBox(-1.0F, 0.0F, -3.75F, 2.0F, 1.0F, 4.0F, 0.0F, true);

        tail01 = new ModelPart(this);
        tail01.setPos(0.0F, -2.0F, 1.0F);
        lowerBody.addChild(tail01);
        setRotationAngle(tail01, -0.8727F, 0.0F, 0.0F);
        tail01.texOffs(20, 9).addBox(-1.5F, -2.0F, -0.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);

        tail02 = new ModelPart(this);
        tail02.setPos(0.0F, -1.75F, 1.0F);
        tail01.addChild(tail02);
        setRotationAngle(tail02, 0.9599F, 0.0F, 0.0F);
        tail02.texOffs(20, 17).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 5.0F, 3.0F, 0.2F, false);

        tail03 = new ModelPart(this);
        tail03.setPos(0.0F, -4.0F, 0.0F);
        tail02.addChild(tail03);
        setRotationAngle(tail03, 0.9599F, 0.0F, 0.0F);
        tail03.texOffs(20, 9).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 5.0F, 3.0F, 0.3F, false);

        tail04 = new ModelPart(this);
        tail04.setPos(0.0F, -3.25F, -0.25F);
        tail03.addChild(tail04);
        setRotationAngle(tail04, -0.6545F, 0.0F, 0.0F);
        tail04.texOffs(20, 17).addBox(-1.5F, -5.0F, -1.5F, 3.0F, 5.0F, 3.0F, 0.1F, false);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.lowerBody.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.quadriped(lLeg01, lArm, rLeg01, rArm, limbSwing * 0.666F, limbSwingAmount * 1.4F);
        this.tail01.xRot = Mth.sin(limbSwing * 0.2F) * limbSwingAmount - rad(30F);
        this.headPitch(head, headPitch);
        this.headYaw(head, netHeadYaw, 0.5F, 0F);
        if (entityIn instanceof EntitySquirrel) {
            EntitySquirrel ent = (EntitySquirrel) entityIn;
            this.lowerBody.xRot = ent.isBesideClimbableBlock() ? rad(-90F) : 0F;
        }
    }

}
