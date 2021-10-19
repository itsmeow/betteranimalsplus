package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.common.entity.EntitySongbird;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;

/**
 * songbirdSmall - cybercat5555 Created using Tabula 5.1.0
 */
public class ModelSongbirdSmall<T extends LivingEntity> extends EntityModel<T> {
    public ModelPart body;
    public ModelPart tailBase;
    public ModelPart lLeg01;
    public ModelPart rLeg01;
    public ModelPart neck;
    public ModelPart lWing01;
    public ModelPart rWing01;
    public ModelPart tailCoverts;
    public ModelPart lTailFeather01;
    public ModelPart rTailFeather01;
    public ModelPart lTailFeather02;
    public ModelPart rTailFeather02;
    public ModelPart lTailFeather03;
    public ModelPart rTailFeather03;
    public ModelPart lLeg02;
    public ModelPart lFoot;
    public ModelPart rLeg02;
    public ModelPart rFoot;
    public ModelPart head;
    public ModelPart beak01;
    public ModelPart crest;
    public ModelPart beak02;
    public ModelPart beak02b;
    public ModelPart lWing02;
    public ModelPart lWingFeather01;
    public ModelPart lWing03;
    public ModelPart lWingFeather02;
    public ModelPart lWingFeather03;
    public ModelPart rWing02;
    public ModelPart rWingFeather01;
    public ModelPart rWing03;
    public ModelPart rWingFeather02;
    public ModelPart rWingFeather03;

    public ModelSongbirdSmall() {
        this.texWidth = 64;
        this.texHeight = 64;
        this.tailCoverts = new ModelPart(this, 0, 26);
        this.tailCoverts.setPos(0.0F, -1.3F, -0.9F);
        this.tailCoverts.addBox(-2.0F, 1.5F, -0.1F, 4, 3, 5, 0.0F);
        this.setRotateAngle(tailCoverts, 0.10471975511965977F, 0.0F, 0.0F);
        this.neck = new ModelPart(this, 31, 9);
        this.neck.setPos(0.0F, 0.0F, -2.9F);
        this.neck.addBox(-1.5F, -2.1F, -3.8F, 3, 4, 3, 0.0F);
        this.setRotateAngle(neck, -0.2792526803190927F, 0.0F, 0.0F);
        this.lLeg02 = new ModelPart(this, 34, 0);
        this.lLeg02.setPos(0.0F, 1.3F, 0.0F);
        this.lLeg02.addBox(-0.5F, -0.2F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(lLeg02, -0.20943951023931953F, 0.0F, 0.0F);
        this.lWingFeather01 = new ModelPart(this, 17, 30);
        this.lWingFeather01.setPos(1.8F, 0.0F, 0.5F);
        this.lWingFeather01.addBox(-2.5F, 0.0F, 0.0F, 5, 0, 6, 0.0F);
        this.setRotateAngle(lWingFeather01, -0.5585053606381855F, 0.0F, 0.0F);
        this.rWing01 = new ModelPart(this, 0, 49);
        this.rWing01.mirror = true;
        this.rWing01.setPos(-2.9F, -1.1F, -1.9F);
        this.rWing01.addBox(-4.0F, -0.5F, -1.5F, 5, 1, 3, 0.0F);
        this.setRotateAngle(rWing01, 0.0F, 1.0821041362364843F, -0.9424777960769379F);
        this.lFoot = new ModelPart(this, 39, 0);
        this.lFoot.setPos(0.0F, 3.7F, 0.0F);
        this.lFoot.addBox(-0.49F, -0.5F, -2.5F, 1, 1, 3, 0.0F);
        this.setRotateAngle(lFoot, 0.19198621771937624F, -0.05235987755982988F, 0.0F);
        this.lWingFeather02 = new ModelPart(this, 16, 38);
        this.lWingFeather02.setPos(2.3F, 0.0F, 1.3F);
        this.lWingFeather02.addBox(-2.1F, 0.0F, -0.4F, 4, 0, 7, 0.0F);
        this.lWingFeather03 = new ModelPart(this, 15, 47);
        this.lWingFeather03.setPos(1.8F, 0.0F, 1.0F);
        this.lWingFeather03.addBox(-1.5F, 0.0F, -1.4F, 9, 0, 8, 0.0F);
        this.rWing02 = new ModelPart(this, 0, 55);
        this.rWing02.mirror = true;
        this.rWing02.setPos(-4.0F, 0.0F, -1.1F);
        this.rWing02.addBox(-4.0F, -0.5F, -0.4F, 4, 1, 2, 0.0F);
        this.setRotateAngle(rWing02, -0.3665191429188092F, 0.5235987755982988F, 0.0F);
        this.rWingFeather01 = new ModelPart(this, 17, 30);
        this.rWingFeather01.mirror = true;
        this.rWingFeather01.setPos(-1.8F, 0.0F, 0.5F);
        this.rWingFeather01.addBox(-2.5F, 0.0F, 0.0F, 5, 0, 6, 0.0F);
        this.setRotateAngle(rWingFeather01, -0.5585053606381855F, 0.0F, 0.0F);
        this.lTailFeather01 = new ModelPart(this, -6, 37);
        this.lTailFeather01.setPos(0.7F, -0.3F, 5.2F);
        this.lTailFeather01.addBox(-1.0F, 0.0F, 0.0F, 2, 0, 8, 0.0F);
        this.setRotateAngle(lTailFeather01, 0.06981317007977318F, 0.05235987755982988F, 0.0F);
        this.beak02b = new ModelPart(this, 49, 5);
        this.beak02b.mirror = true;
        this.beak02b.setPos(0.0F, 0.0F, 0.0F);
        this.beak02b.addBox(-0.6F, -0.5F, -2.6F, 1, 1, 3, 0.0F);
        this.rWing03 = new ModelPart(this, 0, 60);
        this.rWing03.mirror = true;
        this.rWing03.setPos(-3.8F, 0.0F, 0.0F);
        this.rWing03.addBox(-3.0F, -0.5F, -0.4F, 3, 1, 2, 0.0F);
        this.setRotateAngle(rWing03, 0.0F, 0.2617993877991494F, 0.0F);
        this.beak02 = new ModelPart(this, 49, 5);
        this.beak02.setPos(0.0F, 0.5F, 0.2F);
        this.beak02.addBox(-0.4F, -0.5F, -2.6F, 1, 1, 3, 0.0F);
        this.setRotateAngle(beak02, -0.2792526803190927F, 0.0F, 0.0F);
        this.head = new ModelPart(this, 25, 17);
        this.head.setPos(0.0F, -1.2F, -1.5F);
        this.head.addBox(-2.0F, -2.1F, -4.0F, 4, 4, 4, 0.0F);
        this.setRotateAngle(head, 0.5410520681182421F, 0.0F, 0.0F);
        this.lTailFeather02 = new ModelPart(this, -6, 37);
        this.lTailFeather02.setPos(1.4F, -0.1F, 4.4F);
        this.lTailFeather02.addBox(-1.0F, 0.0F, 0.0F, 2, 0, 8, 0.0F);
        this.setRotateAngle(lTailFeather02, 0.06981317007977318F, 0.06981317007977318F, 0.0F);
        this.rTailFeather02 = new ModelPart(this, -6, 37);
        this.rTailFeather02.mirror = true;
        this.rTailFeather02.setPos(-1.4F, -0.1F, 4.4F);
        this.rTailFeather02.addBox(-1.0F, 0.0F, 0.0F, 2, 0, 8, 0.0F);
        this.setRotateAngle(rTailFeather02, 0.06981317007977318F, -0.06981317007977318F, 0.0F);
        this.tailBase = new ModelPart(this, 0, 16);
        this.tailBase.setPos(0.0F, -0.9F, 2.1F);
        this.tailBase.addBox(-2.5F, -1.5F, 0.2F, 5, 2, 5, 0.0F);
        this.setRotateAngle(tailBase, 0.10471975511965977F, 0.0F, 0.0F);
        this.lWing02 = new ModelPart(this, 0, 55);
        this.lWing02.setPos(4.1F, 0.0F, -1.1F);
        this.lWing02.addBox(0.0F, -0.5F, -0.4F, 4, 1, 2, 0.0F);
        this.setRotateAngle(lWing02, -0.3665191429188092F, -0.5235987755982988F, 0.0F);
        this.rLeg01 = new ModelPart(this, 24, 0);
        this.rLeg01.mirror = true;
        this.rLeg01.setPos(-1.7F, 2.1F, 1.0F);
        this.rLeg01.addBox(-1.0F, -0.2F, -1.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(rLeg01, 0.2617993877991494F, 0.0F, 0.0F);
        this.crest = new ModelPart(this, 43, 11);
        this.crest.setPos(0.0F, -0.4F, -1.5F);
        this.crest.addBox(-1.5F, -2.5F, -1.5F, 3, 3, 5, 0.0F);
        this.setRotateAngle(crest, 0.47123889803846897F, 0.0F, 0.0F);
        this.rLeg02 = new ModelPart(this, 34, 0);
        this.rLeg02.mirror = true;
        this.rLeg02.setPos(0.0F, 1.3F, 0.0F);
        this.rLeg02.addBox(-0.5F, -0.2F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(rLeg02, -0.20943951023931953F, 0.0F, 0.0F);
        this.rTailFeather01 = new ModelPart(this, -6, 37);
        this.rTailFeather01.mirror = true;
        this.rTailFeather01.setPos(-0.7F, -0.3F, 5.2F);
        this.rTailFeather01.addBox(-1.0F, 0.0F, 0.0F, 2, 0, 8, 0.0F);
        this.setRotateAngle(rTailFeather01, 0.06981317007977318F, -0.05235987755982988F, 0.0F);
        this.lTailFeather03 = new ModelPart(this, -6, 37);
        this.lTailFeather03.setPos(1.1F, 0.1F, 3.5F);
        this.lTailFeather03.addBox(-1.0F, 0.0F, 0.0F, 2, 0, 8, 0.0F);
        this.setRotateAngle(lTailFeather03, 0.06981317007977318F, 0.17453292519943295F, 0.0F);
        this.body = new ModelPart(this, 0, 0);
        this.body.setPos(0.0F, 16.5F, 0.0F);
        this.body.addBox(-3.0F, -3.0F, -4.5F, 6, 6, 7, 0.0F);
        this.setRotateAngle(body, -0.2617993877991494F, 0.0F, 0.0F);
        this.rTailFeather03 = new ModelPart(this, -6, 37);
        this.rTailFeather03.mirror = true;
        this.rTailFeather03.setPos(-1.1F, 0.1F, 3.5F);
        this.rTailFeather03.addBox(-1.0F, 0.0F, 0.0F, 2, 0, 8, 0.0F);
        this.setRotateAngle(rTailFeather03, 0.06981317007977318F, -0.17453292519943295F, 0.0F);
        this.lLeg01 = new ModelPart(this, 24, 0);
        this.lLeg01.setPos(1.7F, 2.1F, 1.0F);
        this.lLeg01.addBox(-1.0F, -0.2F, -1.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(lLeg01, 0.2617993877991494F, 0.0F, 0.0F);
        this.rWingFeather03 = new ModelPart(this, 15, 47);
        this.rWingFeather03.mirror = true;
        this.rWingFeather03.setPos(-1.8F, 0.0F, 1.0F);
        this.rWingFeather03.addBox(-7.5F, 0.0F, -1.4F, 9, 0, 8, 0.0F);
        this.lWing03 = new ModelPart(this, 0, 60);
        this.lWing03.setPos(3.8F, 0.0F, 0.0F);
        this.lWing03.addBox(0.0F, -0.5F, -0.4F, 3, 1, 2, 0.0F);
        this.setRotateAngle(lWing03, 0.0F, -0.2617993877991494F, 0.0F);
        this.rFoot = new ModelPart(this, 39, 0);
        this.rFoot.mirror = true;
        this.rFoot.setPos(0.0F, 3.7F, 0.0F);
        this.rFoot.addBox(-0.51F, -0.5F, -2.5F, 1, 1, 3, 0.0F);
        this.setRotateAngle(rFoot, 0.19198621771937624F, 0.05235987755982988F, 0.0F);
        this.beak01 = new ModelPart(this, 49, 0);
        this.beak01.setPos(0.0F, 0.7F, -4.2F);
        this.beak01.addBox(-0.5F, -0.9F, -2.3F, 1, 1, 4, 0.0F);
        this.setRotateAngle(beak01, 0.20943951023931953F, 0.0F, 0.0F);
        this.rWingFeather02 = new ModelPart(this, 16, 38);
        this.rWingFeather02.mirror = true;
        this.rWingFeather02.setPos(-2.3F, 0.0F, 1.3F);
        this.rWingFeather02.addBox(-1.9F, 0.0F, -0.4F, 4, 0, 7, 0.0F);
        this.lWing01 = new ModelPart(this, 0, 49);
        this.lWing01.setPos(2.9F, -1.1F, -1.9F);
        this.lWing01.addBox(-0.8F, -0.5F, -1.5F, 5, 1, 3, 0.0F);
        this.setRotateAngle(lWing01, 0.0F, -1.0821041362364843F, 0.9424777960769379F);
        this.tailBase.addChild(this.tailCoverts);
        this.body.addChild(this.neck);
        this.lLeg01.addChild(this.lLeg02);
        this.lWing01.addChild(this.lWingFeather01);
        this.body.addChild(this.rWing01);
        this.lLeg02.addChild(this.lFoot);
        this.lWing02.addChild(this.lWingFeather02);
        this.lWing03.addChild(this.lWingFeather03);
        this.rWing01.addChild(this.rWing02);
        this.rWing01.addChild(this.rWingFeather01);
        this.tailBase.addChild(this.lTailFeather01);
        this.beak02.addChild(this.beak02b);
        this.rWing02.addChild(this.rWing03);
        this.beak01.addChild(this.beak02);
        this.neck.addChild(this.head);
        this.tailBase.addChild(this.lTailFeather02);
        this.tailBase.addChild(this.rTailFeather02);
        this.body.addChild(this.tailBase);
        this.lWing01.addChild(this.lWing02);
        this.body.addChild(this.rLeg01);
        this.head.addChild(this.crest);
        this.rLeg01.addChild(this.rLeg02);
        this.tailBase.addChild(this.rTailFeather01);
        this.tailBase.addChild(this.lTailFeather03);
        this.tailBase.addChild(this.rTailFeather03);
        this.body.addChild(this.lLeg01);
        this.rWing03.addChild(this.rWingFeather03);
        this.lWing02.addChild(this.lWing03);
        this.rLeg02.addChild(this.rFoot);
        this.head.addChild(this.beak01);
        this.rWing02.addChild(this.rWingFeather02);
        this.body.addChild(this.lWing01);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T entity, float f, float f1, float f2, float f3, float f4) {
        if (entity instanceof EntitySongbird) {
            EntitySongbird bird = (EntitySongbird) entity;
            boolean show;
            if (bird.isFlying()) {
                this.rWing01.yRot = 0F;
                this.lWing01.yRot = 0F;
                this.rWing02.yRot = 0F;
                this.lWing02.yRot = 0F;

                this.rWing01.xRot = 0F;
                this.lWing01.xRot = 0F;
                this.rWing02.xRot = 0F;
                this.lWing02.xRot = 0F;

                this.lWingFeather01.xRot = 0F;
                this.rWingFeather01.xRot = 0F;

                this.rLeg01.xRot = 0.2617993877991494F;
                this.lLeg01.xRot = 0.2617993877991494F;

                this.rWing01.zRot = Mth.cos(f2) * (float) Math.PI / 5F;
                if ((Math.abs(bird.getDeltaMovement().y()) > 0 && (Math.abs(bird.getDeltaMovement().x()) > 0.05 || Math.abs(bird.getDeltaMovement().z()) > 0.05)) || Math.abs(bird.getDeltaMovement().y()) > 0.25) {
                    float rotX = -((float) Math.atan2(bird.getDeltaMovement().y(), Math.sqrt(Math.pow(bird.getDeltaMovement().x(), 2) + Math.pow(bird.getDeltaMovement().z(), 2))) / 1.5F);
                    if (rotX < 0) {
                        rotX /= 3;
                    }
                    this.body.xRot = rotX - 0.2617993877991494F;
                } else {
                    this.body.xRot = -0.2617993877991494F;
                }

                this.lWing01.zRot = -this.rWing01.zRot;
                this.rWing02.zRot = this.rWing01.zRot * 0.5F;
                this.lWing02.zRot = -this.rWing01.zRot * 0.5F;
                show = false;
            } else {
                this.setRotateAngle(rWing01, 0.0F, 1.0821041362364843F, -0.9424777960769379F);
                this.setRotateAngle(lWing01, 0.0F, -1.0821041362364843F, 0.9424777960769379F);
                this.setRotateAngle(rWing02, -0.3665191429188092F, 0.5235987755982988F, 0.0F);
                this.setRotateAngle(lWing02, -0.3665191429188092F, -0.5235987755982988F, 0.0F);
                this.lWingFeather01.xRot = -0.5585053606381855F;
                this.rWingFeather01.xRot = -0.5585053606381855F;
                this.body.xRot = -0.2617993877991494F;

                boolean flag = entity.getFallFlyingTicks() > 4;
                float e = 1.0F;

                if (flag) {
                    e = (float) (entity.getDeltaMovement().x() * entity.getDeltaMovement().x() + entity.getDeltaMovement().y() * entity.getDeltaMovement().y() + entity.getDeltaMovement().z() * entity.getDeltaMovement().z());
                    e = e / 0.2F;
                    e = e * e * e;
                }

                if (e < 1.0F) {
                    e = 1.0F;
                }

                this.rLeg01.xRot = Mth.cos(f * 0.6662F) * 1.4F * f1 / e + 0.2617993877991494F;
                this.lLeg01.xRot = Mth.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1 / e + 0.2617993877991494F;
                show = true;
            }
            this.lLeg01.visible = show;
            this.lLeg02.visible = show;
            this.rLeg01.visible = show;
            this.rLeg02.visible = show;
            this.lFoot.visible = show;
            this.rFoot.visible = show;
        }
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
