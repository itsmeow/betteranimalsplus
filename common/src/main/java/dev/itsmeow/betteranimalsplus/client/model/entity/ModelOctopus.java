package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.common.entity.EntityOctopus;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;

/**
 * octopus - Batman, Cybercat5555 Created using Tabula 7.1.0
 */
public class ModelOctopus<T extends EntityOctopus> extends EntityModel<T> {
    protected final ModelPart[] mainTentacles;
    public ModelPart head;
    public ModelPart lEye;
    public ModelPart rEye;
    public ModelPart siphon;
    public ModelPart beak01;
    public ModelPart beak02;
    public ModelPart lTentacle01a;
    public ModelPart rTentacle01a;
    public ModelPart lTentacle02a;
    public ModelPart rTentacle02a;
    public ModelPart lTentacle03a;
    public ModelPart rTentacle03a;
    public ModelPart lTentacle04a;
    public ModelPart rTentacle04a;
    public ModelPart mantle00;
    public ModelPart lTentacle01b;
    public ModelPart lTentacle01c;
    public ModelPart lTentacle01d;
    public ModelPart rTentacle01b;
    public ModelPart rTentacle01c;
    public ModelPart rTentacle01d;
    public ModelPart lTentacle02b;
    public ModelPart lTentacle02c;
    public ModelPart lTentacle02d;
    public ModelPart rTentacle02b;
    public ModelPart rTentacle02c;
    public ModelPart rTentacle02d;
    public ModelPart lTentacle03b;
    public ModelPart lTentacle03c;
    public ModelPart lTentacle03d;
    public ModelPart rTentacle03b;
    public ModelPart rTentacle03c;
    public ModelPart rTentacle03d;
    public ModelPart lTentacle04b;
    public ModelPart lTentacle04c;
    public ModelPart lTentacle04d;
    public ModelPart rTentacle04b;
    public ModelPart rTentacle04c;
    public ModelPart lTentacle04d_1;
    public ModelPart mantle01;

    public ModelOctopus() {
        this.texWidth = 64;
        this.texHeight = 32;
        this.rTentacle03c = new ModelPart(this, 41, 20);
        this.rTentacle03c.mirror = true;
        this.rTentacle03c.setPos(0.0F, 7.1F, 0.0F);
        this.rTentacle03c.addBox(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
        this.setRotateAngle(rTentacle03c, -0.03490658503988659F, 0.0F, 0.3490658503988659F);
        this.lTentacle01b = new ModelPart(this, 41, 21);
        this.lTentacle01b.setPos(0.0F, 6.2F, 0.0F);
        this.lTentacle01b.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
        this.setRotateAngle(lTentacle01b, -0.2792526803190927F, 0.20943951023931953F, -0.22689280275926282F);
        this.rTentacle01b = new ModelPart(this, 41, 21);
        this.rTentacle01b.mirror = true;
        this.rTentacle01b.setPos(0.0F, 6.2F, 0.0F);
        this.rTentacle01b.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
        this.setRotateAngle(rTentacle01b, -0.2792526803190927F, -0.20943951023931953F, 0.22689280275926282F);
        this.rTentacle03b = new ModelPart(this, 41, 21);
        this.rTentacle03b.mirror = true;
        this.rTentacle03b.setPos(0.0F, 6.2F, 0.0F);
        this.rTentacle03b.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
        this.setRotateAngle(rTentacle03b, -0.6981317007977318F, -0.5235987755982988F, 0.03490658503988659F);
        this.rTentacle02d = new ModelPart(this, 54, 21);
        this.rTentacle02d.mirror = true;
        this.rTentacle02d.setPos(0.0F, 8.2F, 0.0F);
        this.rTentacle02d.addBox(-1.0F, 0.0F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(rTentacle02d, -0.03490658503988659F, 0.0F, 0.3490658503988659F);
        this.lTentacle03a = new ModelPart(this, 41, 21);
        this.lTentacle03a.setPos(1.8F, -2.0F, 1.0F);
        this.lTentacle03a.addBox(-1.5F, 0.0F, -1.5F, 3, 7, 3, 0.0F);
        this.setRotateAngle(lTentacle03a, -0.7853981633974483F, -1.5707963267948966F, 0.0F);
        this.lTentacle03c = new ModelPart(this, 41, 20);
        this.lTentacle03c.setPos(0.0F, 7.1F, 0.0F);
        this.lTentacle03c.addBox(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
        this.setRotateAngle(lTentacle03c, -0.03490658503988659F, 0.0F, -0.3490658503988659F);
        this.lTentacle03b = new ModelPart(this, 41, 21);
        this.lTentacle03b.setPos(0.0F, 6.2F, 0.0F);
        this.lTentacle03b.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
        this.setRotateAngle(lTentacle03b, -0.6981317007977318F, 0.5235987755982988F, -0.03490658503988659F);
        this.beak01 = new ModelPart(this, 47, 0);
        this.beak01.setPos(0.0F, -1.5F, -1.2F);
        this.beak01.addBox(-1.5F, 0.0F, -0.5F, 3, 2, 3, 0.0F);
        this.setRotateAngle(beak01, -0.6373942428283291F, 0.0F, 0.0F);
        this.beak02 = new ModelPart(this, 55, 6);
        this.beak02.setPos(0.0F, -1.5F, 0.3F);
        this.beak02.addBox(-1.0F, 0.0F, -2.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(beak02, 0.5009094953223726F, 0.0F, 0.0F);
        this.mantle01 = new ModelPart(this, 29, 5);
        this.mantle01.setPos(0.0F, -0.2F, 5.3F);
        this.mantle01.addBox(-4.0F, -4.0F, 0.0F, 8, 8, 7, 0.0F);
        this.setRotateAngle(mantle01, -0.3490658503988659F, 0.0F, 0.0F);
        this.rTentacle01c = new ModelPart(this, 41, 20);
        this.rTentacle01c.mirror = true;
        this.rTentacle01c.setPos(0.0F, 7.1F, 0.0F);
        this.rTentacle01c.addBox(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
        this.setRotateAngle(rTentacle01c, -0.08726646259971647F, 0.22689280275926282F, 0.3490658503988659F);
        this.rTentacle01a = new ModelPart(this, 41, 21);
        this.rTentacle01a.mirror = true;
        this.rTentacle01a.setPos(-1.7F, -0.9F, -1.0F);
        this.rTentacle01a.addBox(-1.5F, 0.0F, -1.5F, 3, 7, 3, 0.0F);
        this.setRotateAngle(rTentacle01a, -0.6981317007977318F, 0.3141592653589793F, 0.0F);
        this.siphon = new ModelPart(this, 34, 0);
        this.siphon.setPos(-2.6F, -3.4F, -0.7F);
        this.siphon.addBox(-3.3F, -1.0F, -1.5F, 4, 2, 2, 0.0F);
        this.setRotateAngle(siphon, 0.0F, 0.7285004297824331F, 0.0F);
        this.lTentacle01d = new ModelPart(this, 54, 21);
        this.lTentacle01d.setPos(0.0F, 8.2F, 0.0F);
        this.lTentacle01d.addBox(-1.0F, 0.0F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(lTentacle01d, -0.03490658503988659F, 0.0F, -0.3490658503988659F);
        this.lTentacle04a = new ModelPart(this, 41, 21);
        this.lTentacle04a.setPos(1.8F, -2.4F, 2.0F);
        this.lTentacle04a.addBox(-1.5F, 0.0F, -1.5F, 3, 7, 3, 0.0F);
        this.setRotateAngle(lTentacle04a, -0.7853981633974483F, -2.0943951023931953F, 0.0F);
        this.lTentacle02b = new ModelPart(this, 41, 21);
        this.lTentacle02b.setPos(0.0F, 6.2F, 0.0F);
        this.lTentacle02b.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
        this.setRotateAngle(lTentacle02b, -0.40142572795869574F, 0.40142572795869574F, -0.03490658503988659F);
        this.rTentacle03a = new ModelPart(this, 41, 21);
        this.rTentacle03a.mirror = true;
        this.rTentacle03a.setPos(-1.8F, -2.0F, 1.0F);
        this.rTentacle03a.addBox(-1.5F, 0.0F, -1.5F, 3, 7, 3, 0.0F);
        this.setRotateAngle(rTentacle03a, -0.7853981633974483F, 1.5707963267948966F, 0.0F);
        this.rTentacle04b = new ModelPart(this, 41, 21);
        this.rTentacle04b.mirror = true;
        this.rTentacle04b.setPos(0.0F, 6.2F, 0.0F);
        this.rTentacle04b.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
        this.setRotateAngle(rTentacle04b, -0.8726646259971648F, -0.5235987755982988F, 0.03490658503988659F);
        this.lTentacle04d = new ModelPart(this, 54, 21);
        this.lTentacle04d.setPos(0.0F, 8.2F, 0.0F);
        this.lTentacle04d.addBox(-1.0F, 0.0F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(lTentacle04d, 0.0F, 0.0F, -0.3490658503988659F);
        this.rTentacle04a = new ModelPart(this, 41, 21);
        this.rTentacle04a.mirror = true;
        this.rTentacle04a.setPos(-1.8F, -2.4F, 2.0F);
        this.rTentacle04a.addBox(-1.5F, 0.0F, -1.5F, 3, 7, 3, 0.0F);
        this.setRotateAngle(rTentacle04a, -0.7853981633974483F, 2.0943951023931953F, 0.0F);
        this.rTentacle02b = new ModelPart(this, 41, 21);
        this.rTentacle02b.mirror = true;
        this.rTentacle02b.setPos(0.0F, 6.2F, 0.0F);
        this.rTentacle02b.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
        this.setRotateAngle(rTentacle02b, -0.40142572795869574F, -0.40142572795869574F, 0.03490658503988659F);
        this.lEye = new ModelPart(this, 23, 0);
        this.lEye.setPos(2.6F, -7.0F, -2.5F);
        this.lEye.addBox(-0.1F, -1.5F, -1.5F, 2, 3, 3, 0.0F);
        this.setRotateAngle(lEye, 0.5235987755982988F, 0.17453292519943295F, 0.0F);
        this.lTentacle04d_1 = new ModelPart(this, 54, 21);
        this.lTentacle04d_1.mirror = true;
        this.lTentacle04d_1.setPos(0.0F, 8.2F, 0.0F);
        this.lTentacle04d_1.addBox(-1.0F, 0.0F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(lTentacle04d_1, 0.0F, 0.0F, 0.3490658503988659F);
        this.lTentacle04c = new ModelPart(this, 41, 20);
        this.lTentacle04c.setPos(0.0F, 7.1F, 0.0F);
        this.lTentacle04c.addBox(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
        this.setRotateAngle(lTentacle04c, -0.08726646259971647F, 0.0F, -0.3490658503988659F);
        this.lTentacle02d = new ModelPart(this, 54, 21);
        this.lTentacle02d.setPos(0.0F, 8.2F, 0.0F);
        this.lTentacle02d.addBox(-1.0F, 0.0F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(lTentacle02d, -0.03490658503988659F, 0.0F, -0.3490658503988659F);
        this.lTentacle01c = new ModelPart(this, 41, 20);
        this.lTentacle01c.setPos(0.0F, 7.1F, 0.0F);
        this.lTentacle01c.addBox(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
        this.setRotateAngle(lTentacle01c, -0.08726646259971647F, -0.22689280275926282F, -0.3490658503988659F);
        this.mantle00 = new ModelPart(this, 0, 16);
        this.mantle00.setPos(0.0F, -5.4F, -1.2F);
        this.mantle00.addBox(-4.5F, -4.0F, -0.1F, 9, 8, 7, 0.0F);
        this.setRotateAngle(mantle00, 0.3665191429188092F, 0.0F, 0.0F);
        this.lTentacle03d = new ModelPart(this, 54, 21);
        this.lTentacle03d.setPos(0.0F, 8.2F, 0.0F);
        this.lTentacle03d.addBox(-1.0F, 0.0F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(lTentacle03d, 0.03490658503988659F, 0.0F, -0.3490658503988659F);
        this.rTentacle03d = new ModelPart(this, 54, 21);
        this.rTentacle03d.mirror = true;
        this.rTentacle03d.setPos(0.0F, 8.2F, 0.0F);
        this.rTentacle03d.addBox(-1.0F, 0.0F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(rTentacle03d, 0.03490658503988659F, 0.0F, 0.3490658503988659F);
        this.lTentacle02a = new ModelPart(this, 41, 21);
        this.lTentacle02a.setPos(1.7F, -1.5F, -0.3F);
        this.lTentacle02a.addBox(-1.5F, 0.0F, -1.5F, 3, 7, 3, 0.0F);
        this.setRotateAngle(lTentacle02a, -0.7853981633974483F, -1.0471975511965976F, 0.0F);
        this.lTentacle01a = new ModelPart(this, 41, 21);
        this.lTentacle01a.setPos(1.7F, -0.9F, -1.0F);
        this.lTentacle01a.addBox(-1.5F, 0.0F, -1.5F, 3, 7, 3, 0.0F);
        this.setRotateAngle(lTentacle01a, -0.6981317007977318F, -0.3141592653589793F, 0.0F);
        this.rTentacle02a = new ModelPart(this, 41, 21);
        this.rTentacle02a.mirror = true;
        this.rTentacle02a.setPos(-1.7F, -1.5F, -0.3F);
        this.rTentacle02a.addBox(-1.5F, 0.0F, -1.5F, 3, 7, 3, 0.0F);
        this.setRotateAngle(rTentacle02a, -0.7853981633974483F, 1.0471975511965976F, 0.0F);
        this.rTentacle01d = new ModelPart(this, 54, 21);
        this.rTentacle01d.mirror = true;
        this.rTentacle01d.setPos(0.0F, 8.2F, 0.0F);
        this.rTentacle01d.addBox(-1.0F, 0.0F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(rTentacle01d, -0.03490658503988659F, 0.0F, 0.3490658503988659F);
        this.head = new ModelPart(this, 0, 0);
        this.head.setPos(0.0F, 20.0F, 0.0F);
        this.head.addBox(-3.5F, -9.0F, -3.5F, 7, 9, 7, 0.0F);
        this.setRotateAngle(head, -0.40980330836826856F, 0.0F, 0.0F);
        this.rTentacle04c = new ModelPart(this, 41, 20);
        this.rTentacle04c.mirror = true;
        this.rTentacle04c.setPos(0.0F, 7.1F, 0.0F);
        this.rTentacle04c.addBox(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
        this.setRotateAngle(rTentacle04c, -0.08726646259971647F, 0.0F, 0.3490658503988659F);
        this.rEye = new ModelPart(this, 23, 0);
        this.rEye.mirror = true;
        this.rEye.setPos(-2.6F, -7.0F, -2.5F);
        this.rEye.addBox(-1.9F, -1.5F, -1.5F, 2, 3, 3, 0.0F);
        this.setRotateAngle(rEye, 0.5235987755982988F, -0.17453292519943295F, 0.0F);
        this.rTentacle02c = new ModelPart(this, 41, 20);
        this.rTentacle02c.mirror = true;
        this.rTentacle02c.setPos(0.0F, 7.1F, 0.0F);
        this.rTentacle02c.addBox(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
        this.setRotateAngle(rTentacle02c, -0.03490658503988659F, 0.0F, 0.3490658503988659F);
        this.lTentacle02c = new ModelPart(this, 41, 20);
        this.lTentacle02c.setPos(0.0F, 7.1F, 0.0F);
        this.lTentacle02c.addBox(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
        this.setRotateAngle(lTentacle02c, -0.03490658503988659F, 0.0F, -0.3490658503988659F);
        this.lTentacle04b = new ModelPart(this, 41, 21);
        this.lTentacle04b.setPos(0.0F, 6.2F, 0.0F);
        this.lTentacle04b.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
        this.setRotateAngle(lTentacle04b, -0.8726646259971648F, 0.5235987755982988F, -0.03490658503988659F);
        this.rTentacle03b.addChild(this.rTentacle03c);
        this.lTentacle01a.addChild(this.lTentacle01b);
        this.rTentacle01a.addChild(this.rTentacle01b);
        this.rTentacle03a.addChild(this.rTentacle03b);
        this.rTentacle02c.addChild(this.rTentacle02d);
        this.head.addChild(this.lTentacle03a);
        this.lTentacle03b.addChild(this.lTentacle03c);
        this.lTentacle03a.addChild(this.lTentacle03b);
        this.head.addChild(this.beak01);
        this.head.addChild(this.beak02);
        this.mantle00.addChild(this.mantle01);
        this.rTentacle01b.addChild(this.rTentacle01c);
        this.head.addChild(this.rTentacle01a);
        this.head.addChild(this.siphon);
        this.lTentacle01c.addChild(this.lTentacle01d);
        this.head.addChild(this.lTentacle04a);
        this.lTentacle02a.addChild(this.lTentacle02b);
        this.head.addChild(this.rTentacle03a);
        this.rTentacle04a.addChild(this.rTentacle04b);
        this.lTentacle04c.addChild(this.lTentacle04d);
        this.head.addChild(this.rTentacle04a);
        this.rTentacle02a.addChild(this.rTentacle02b);
        this.head.addChild(this.lEye);
        this.rTentacle04c.addChild(this.lTentacle04d_1);
        this.lTentacle04b.addChild(this.lTentacle04c);
        this.lTentacle02c.addChild(this.lTentacle02d);
        this.lTentacle01b.addChild(this.lTentacle01c);
        this.head.addChild(this.mantle00);
        this.lTentacle03c.addChild(this.lTentacle03d);
        this.rTentacle03c.addChild(this.rTentacle03d);
        this.head.addChild(this.lTentacle02a);
        this.head.addChild(this.lTentacle01a);
        this.head.addChild(this.rTentacle02a);
        this.rTentacle01c.addChild(this.rTentacle01d);
        this.rTentacle04b.addChild(this.rTentacle04c);
        this.head.addChild(this.rEye);
        this.rTentacle02b.addChild(this.rTentacle02c);
        this.lTentacle02b.addChild(this.lTentacle02c);
        this.lTentacle04a.addChild(this.lTentacle04b);
        this.mainTentacles = new ModelPart[]{
                lTentacle01a,
                lTentacle02a,
                lTentacle03a,
                lTentacle04a,
                rTentacle01a,
                rTentacle02a,
                rTentacle03a,
                rTentacle04a
        };
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.head.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        if(entityIn.isInWaterOrBubble() && (!entityIn.isAboveBlock() || entityIn.getDeltaMovement().length() > 0.01)) {
            this.setSwimPose();
            this.head.xRot = 0F;
            for (ModelPart m : mainTentacles) {
                m.xRot = -ageInTicks / 2F;
            }
        } else {
            this.setGroundPose();
            this.lTentacle01a.yRot -= Mth.sin(limbSwing) * limbSwingAmount / 2F;
            this.lTentacle02a.yRot -= Mth.sin(limbSwing) * limbSwingAmount / 2F;
            this.lTentacle03a.yRot += Mth.sin(limbSwing) * limbSwingAmount / 2F;
            this.lTentacle04a.yRot += Mth.sin(limbSwing) * limbSwingAmount / 2F;
            this.rTentacle01a.yRot -= Mth.sin(limbSwing) * limbSwingAmount / 2F;
            this.rTentacle02a.yRot -= Mth.sin(limbSwing) * limbSwingAmount / 2F;
            this.rTentacle03a.yRot += Mth.sin(limbSwing) * limbSwingAmount / 2F;
            this.rTentacle04a.yRot += Mth.sin(limbSwing) * limbSwingAmount / 2F;
        }
    }

    public void setSwimPose() {
        this.setRotateAngle(head, -1.5025539530419183F, 0.0F, 0.0F);
        this.setRotateAngle(lTentacle01a, 0.0F, -0.3141592653589793F, 0.0F);
        this.setRotateAngle(lTentacle01b, -0.2792526803190927F, 0.0F, 0.0F);
        this.setRotateAngle(lTentacle01c, 0.17453292519943295F, 0.0F, 0.0F);
        this.setRotateAngle(lTentacle01d, -0.03490658503988659F, 0.0F, 0.0F);
        this.setRotateAngle(lTentacle02a, 0.0F, -1.3962634015954636F, -0.17453292519943295F);
        this.setRotateAngle(lTentacle02b, 0.08726646259971647F, 0.0F, 0.0F);
        this.setRotateAngle(lTentacle02c, -0.03490658503988659F, 0.0F, 0.017453292519943295F);
        this.setRotateAngle(lTentacle02d, -0.03490658503988659F, 0.0F, 0.0F);
        this.setRotateAngle(lTentacle03a, -0.22689280275926282F, -2.2165681500327987F, 0.0F);
        this.setRotateAngle(lTentacle03c, -0.03490658503988659F, 0.0F, 0.0F);
        this.setRotateAngle(lTentacle03b, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lTentacle04a, -0.45378560551852565F, -2.897246558310587F, 0.0F);
        this.setRotateAngle(lTentacle04c, 0.08726646259971647F, 0.0F, 0.0F);
        this.setRotateAngle(lTentacle04b, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(mantle00, 1.2217304763960306F, 0.0F, 0.0F);
        this.setRotateAngle(lTentacle04d, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lTentacle04d_1, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(mantle01, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rTentacle01a, 0.0F, 0.3141592653589793F, 0.0F);
        this.setRotateAngle(rTentacle01b, -0.2792526803190927F, 0.0F, 0.0F);
        this.setRotateAngle(rTentacle01c, 0.17453292519943295F, 0.0F, 0.0F);
        this.setRotateAngle(rTentacle01d, -0.03490658503988659F, 0.0F, 0.0F);
        this.setRotateAngle(rTentacle02a, 0.0F, 1.3962634015954636F, 0.17453292519943295F);
        this.setRotateAngle(rTentacle02b, -0.08726646259971647F, 0.0F, 0.0F);
        this.setRotateAngle(rTentacle02c, -0.03490658503988659F, 0.0F, 0.0F);
        this.setRotateAngle(rTentacle03a, -0.22689280275926282F, 2.2165681500327987F, 0.0F);
        this.setRotateAngle(rTentacle03c, -0.03490658503988659F, 0.0F, 0.0F);
        this.setRotateAngle(rTentacle03b, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rTentacle04a, -0.45378560551852565F, 2.897246558310587F, 0.0F);
        this.setRotateAngle(rTentacle04c, 0.08726646259971647F, 0.0F, 0.0F);
        this.setRotateAngle(rTentacle04b, 0.0F, 0.0F, 0.0F);
    }

    public void setGroundPose() {
        this.setRotateAngle(head, -0.40980330836826856F, 0.0F, 0.0F);
        this.setRotateAngle(lTentacle01a, -0.6981317007977318F, -0.3141592653589793F, 0.0F);
        this.setRotateAngle(lTentacle01b, -0.2792526803190927F, 0.20943951023931953F, -0.22689280275926282F);
        this.setRotateAngle(lTentacle01c, -0.08726646259971647F, -0.22689280275926282F, -0.3490658503988659F);
        this.setRotateAngle(lTentacle01d, -0.03490658503988659F, 0.0F, -0.3490658503988659F);
        this.setRotateAngle(lTentacle02a, -0.7853981633974483F, -1.0471975511965976F, 0.0F);
        this.setRotateAngle(lTentacle02b, -0.40142572795869574F, 0.40142572795869574F, -0.03490658503988659F);
        this.setRotateAngle(lTentacle02c, -0.03490658503988659F, 0.0F, -0.3490658503988659F);
        this.setRotateAngle(lTentacle02d, -0.03490658503988659F, 0.0F, -0.3490658503988659F);
        this.setRotateAngle(lTentacle03a, -0.7853981633974483F, -1.5707963267948966F, 0.0F);
        this.setRotateAngle(lTentacle03b, -0.6981317007977318F, 0.5235987755982988F, -0.03490658503988659F);
        this.setRotateAngle(lTentacle03c, -0.03490658503988659F, 0.0F, -0.3490658503988659F);
        this.setRotateAngle(lTentacle04a, -0.7853981633974483F, -2.0943951023931953F, 0.0F);
        this.setRotateAngle(lTentacle04b, -0.8726646259971648F, 0.5235987755982988F, -0.03490658503988659F);
        this.setRotateAngle(lTentacle04c, -0.08726646259971647F, 0.0F, -0.3490658503988659F);
        this.setRotateAngle(lTentacle04d, 0.0F, 0.0F, -0.3490658503988659F);
        this.setRotateAngle(lTentacle04d_1, 0.0F, 0.0F, 0.3490658503988659F);
        this.setRotateAngle(mantle00, 0.3665191429188092F, 0.0F, 0.0F);
        this.setRotateAngle(mantle01, -0.3490658503988659F, 0.0F, 0.0F);
        this.setRotateAngle(rTentacle01a, -0.6981317007977318F, 0.3141592653589793F, 0.0F);
        this.setRotateAngle(rTentacle01b, -0.2792526803190927F, -0.20943951023931953F, 0.22689280275926282F);
        this.setRotateAngle(rTentacle01c, -0.08726646259971647F, 0.22689280275926282F, 0.3490658503988659F);
        this.setRotateAngle(rTentacle01d, -0.03490658503988659F, 0.0F, 0.3490658503988659F);
        this.setRotateAngle(rTentacle02a, -0.7853981633974483F, 1.0471975511965976F, 0.0F);
        this.setRotateAngle(rTentacle02b, -0.40142572795869574F, -0.40142572795869574F, 0.03490658503988659F);
        this.setRotateAngle(rTentacle02c, -0.03490658503988659F, 0.0F, 0.3490658503988659F);
        this.setRotateAngle(rTentacle03a, -0.7853981633974483F, 1.5707963267948966F, 0.0F);
        this.setRotateAngle(rTentacle03b, -0.6981317007977318F, -0.5235987755982988F, 0.03490658503988659F);
        this.setRotateAngle(rTentacle03c, -0.03490658503988659F, 0.0F, 0.3490658503988659F);
        this.setRotateAngle(rTentacle04a, -0.7853981633974483F, 2.0943951023931953F, 0.0F);
        this.setRotateAngle(rTentacle04b, -0.8726646259971648F, -0.5235987755982988F, 0.03490658503988659F);
        this.setRotateAngle(rTentacle04c, -0.08726646259971647F, 0.0F, 0.3490658503988659F);
    }

    public void setRotateAngle(ModelPart ModelRenderer, float x, float y, float z) {
        ModelRenderer.xRot = x;
        ModelRenderer.yRot = y;
        ModelRenderer.zRot = z;
    }
}
