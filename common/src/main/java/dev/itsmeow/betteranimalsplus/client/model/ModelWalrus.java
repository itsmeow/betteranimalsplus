package dev.itsmeow.betteranimalsplus.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;

/**
 * walrus - batman, cybercat5555 Created using Tabula 7.0.1
 */
public class ModelWalrus<T extends LivingEntity> extends EntityModel<T> {
    public ModelPart body;
    public ModelPart body2;
    public ModelPart neck;
    public ModelPart lFlipper1;
    public ModelPart rFlipper1;
    public ModelPart body3;
    public ModelPart body4;
    public ModelPart lLeg1;
    public ModelPart rLeg1;
    public ModelPart tail;
    public ModelPart lLeg2;
    public ModelPart rLeg2;
    public ModelPart neck2;
    public ModelPart head;
    public ModelPart lowJaw;
    public ModelPart upperJawL;
    public ModelPart upperJawR;
    public ModelPart snout;
    public ModelPart lTusk01;
    public ModelPart lWhiskersF;
    public ModelPart lWhiskersB;
    public ModelPart lTusk02;
    public ModelPart rTusk01;
    public ModelPart rWhiskersF;
    public ModelPart rWhiskersB;
    public ModelPart rTusk02;
    public ModelPart lFlipper2;
    public ModelPart lFlipper3;
    public ModelPart rFlipper2;
    public ModelPart rFlipper3;

    public ModelWalrus() {
        this.texWidth = 128;
        this.texHeight = 64;
        this.body2 = new ModelPart(this, 0, 26);
        this.body2.setPos(0.0F, -0.4F, -0.7F);
        this.body2.addBox(-5.5F, -2.5F, 0.0F, 11, 12, 10, 0.0F);
        this.setRotateAngle(body2, -0.03490658503988659F, 0.0F, 0.0F);
        this.lFlipper1 = new ModelPart(this, 89, 0);
        this.lFlipper1.setPos(4.0F, 5.0F, -9.0F);
        this.lFlipper1.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 5, 0.0F);
        this.setRotateAngle(lFlipper1, -0.13962634015954636F, 0.0F, -0.9424777960769379F);
        this.rTusk01 = new ModelPart(this, 0, 0);
        this.rTusk01.mirror = true;
        this.rTusk01.setPos(-1.0F, 1.6F, -3.5F);
        this.rTusk01.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(rTusk01, 0.03490658503988659F, 0.0F, 0.2792526803190927F);
        this.lLeg2 = new ModelPart(this, 110, 12);
        this.lLeg2.setPos(0.0F, 5.7F, -0.2F);
        this.lLeg2.addBox(-3.0F, 0.0F, -0.5F, 6, 8, 1, 0.0F);
        this.setRotateAngle(lLeg2, 0.7853981633974483F, 0.7853981633974483F, -0.08726646259971647F);
        this.snout = new ModelPart(this, 50, 15);
        this.snout.setPos(0.0F, 0.0F, -5.5F);
        this.snout.addBox(-3.0F, -1.5F, -3.9F, 6, 3, 4, 0.0F);
        this.setRotateAngle(snout, 0.4553564018453205F, 0.0F, 0.0F);
        this.lTusk02 = new ModelPart(this, 0, 0);
        this.lTusk02.setPos(0.0F, 3.9F, 0.0F);
        this.lTusk02.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(lTusk02, 0.12217304763960307F, 0.0F, 0.0F);
        this.rLeg2 = new ModelPart(this, 110, 12);
        this.rLeg2.mirror = true;
        this.rLeg2.setPos(0.0F, 5.7F, -0.2F);
        this.rLeg2.addBox(-3.0F, 0.0F, -0.5F, 6, 8, 1, 0.0F);
        this.setRotateAngle(rLeg2, 0.7853981633974483F, -0.7853981633974483F, 0.08726646259971647F);
        this.rTusk02 = new ModelPart(this, 0, 0);
        this.rTusk02.mirror = true;
        this.rTusk02.setPos(0.0F, 3.9F, 0.0F);
        this.rTusk02.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(rTusk02, 0.12217304763960307F, 0.0F, 0.0F);
        this.lTusk01 = new ModelPart(this, 0, 0);
        this.lTusk01.setPos(1.0F, 1.6F, -3.3F);
        this.lTusk01.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(lTusk01, 0.03490658503988659F, 0.0F, -0.2792526803190927F);
        this.rWhiskersF = new ModelPart(this, 76, 50);
        this.rWhiskersF.mirror = true;
        this.rWhiskersF.setPos(0.0F, 0.3F, -4.6F);
        this.rWhiskersF.addBox(-2.1F, 0.0F, -0.5F, 4, 4, 0, 0.0F);
        this.setRotateAngle(rWhiskersF, -0.17453292519943295F, 0.08726646259971647F, 0.17453292519943295F);
        this.lFlipper3 = new ModelPart(this, 90, 21);
        this.lFlipper3.setPos(-0.4F, 3.8F, 0.0F);
        this.lFlipper3.addBox(-0.5F, 0.0F, 0.0F, 1, 8, 5, 0.0F);
        this.setRotateAngle(lFlipper3, 0.6283185307179586F, 0.0F, -0.08726646259971647F);
        this.upperJawL = new ModelPart(this, 71, 15);
        this.upperJawL.setPos(1.5F, 2.8F, -4.8F);
        this.upperJawL.addBox(-2.0F, -2.0F, -5.0F, 4, 4, 5, 0.0F);
        this.setRotateAngle(upperJawL, 0.0F, 0.03490658503988659F, 0.2792526803190927F);
        this.neck = new ModelPart(this, 86, 41);
        this.neck.setPos(0.0F, 2.3F, -5.1F);
        this.neck.addBox(-5.0F, -1.5F, -11.0F, 10, 10, 11, 0.0F);
        this.setRotateAngle(neck, -0.7155849933176751F, 0.0F, 0.0F);
        this.upperJawR = new ModelPart(this, 71, 15);
        this.upperJawR.mirror = true;
        this.upperJawR.setPos(-1.5F, 2.8F, -4.8F);
        this.upperJawR.addBox(-2.0F, -2.0F, -5.0F, 4, 4, 5, 0.0F);
        this.setRotateAngle(upperJawR, 0.0F, -0.03490658503988659F, -0.2792526803190927F);
        this.rFlipper2 = new ModelPart(this, 90, 11);
        this.rFlipper2.mirror = true;
        this.rFlipper2.setPos(0.5F, 4.5F, -2.0F);
        this.rFlipper2.addBox(-1.0F, 0.0F, 0.0F, 2, 4, 5, 0.0F);
        this.setRotateAngle(rFlipper2, 0.5759586531581287F, 0.0F, 0.45378560551852565F);
        this.lWhiskersF = new ModelPart(this, 76, 50);
        this.lWhiskersF.setPos(0.0F, 0.3F, -4.6F);
        this.lWhiskersF.addBox(-2.1F, 0.0F, -0.5F, 4, 4, 0, 0.0F);
        this.setRotateAngle(lWhiskersF, -0.17453292519943295F, -0.08726646259971647F, -0.17453292519943295F);
        this.lFlipper2 = new ModelPart(this, 90, 11);
        this.lFlipper2.setPos(-0.5F, 4.5F, -2.0F);
        this.lFlipper2.addBox(-1.0F, 0.0F, 0.0F, 2, 4, 5, 0.0F);
        this.setRotateAngle(lFlipper2, 0.5759586531581287F, 0.0F, -0.45378560551852565F);
        this.head = new ModelPart(this, 58, 0);
        this.head.setPos(0.0F, -0.4F, -5.8F);
        this.head.addBox(-3.5F, -1.5F, -6.0F, 7, 7, 6, 0.0F);
        this.setRotateAngle(head, 0.6981317007977318F, 0.0F, 0.0F);
        this.rWhiskersB = new ModelPart(this, 76, 51);
        this.rWhiskersB.mirror = true;
        this.rWhiskersB.setPos(-2.0F, 0.4F, -3.0F);
        this.rWhiskersB.addBox(0.0F, 0.0F, -1.7F, 0, 5, 4, 0.0F);
        this.setRotateAngle(rWhiskersB, 0.0F, 0.0F, 0.2617993877991494F);
        this.body4 = new ModelPart(this, 0, 48);
        this.body4.setPos(0.0F, 0.1F, 6.3F);
        this.body4.addBox(-4.0F, -2.0F, 0.0F, 8, 8, 8, 0.0F);
        this.setRotateAngle(body4, -0.3141592653589793F, 0.0F, 0.0F);
        this.lLeg1 = new ModelPart(this, 110, 0);
        this.lLeg1.setPos(2.5F, 2.4F, 6.2F);
        this.lLeg1.addBox(-1.5F, 0.0F, -2.0F, 3, 7, 4, 0.0F);
        this.setRotateAngle(lLeg1, 0.5759586531581287F, 1.7453292519943295F, 0.0F);
        this.body = new ModelPart(this, 0, 0);
        this.body.setPos(0.0F, 14.6F, -2.0F);
        this.body.addBox(-6.0F, -3.5F, -12.0F, 12, 13, 12, 0.0F);
        this.neck2 = new ModelPart(this, 42, 48);
        this.neck2.setPos(0.0F, 0.0F, -10.6F);
        this.neck2.addBox(-4.0F, -1.5F, -7.0F, 8, 9, 7, 0.0F);
        this.setRotateAngle(neck2, 0.17453292519943295F, 0.0F, 0.0F);
        this.rFlipper3 = new ModelPart(this, 90, 21);
        this.rFlipper3.mirror = true;
        this.rFlipper3.setPos(0.4F, 3.8F, 0.0F);
        this.rFlipper3.addBox(-0.5F, 0.0F, 0.0F, 1, 8, 5, 0.0F);
        this.setRotateAngle(rFlipper3, 0.6283185307179586F, 0.0F, 0.08726646259971647F);
        this.rFlipper1 = new ModelPart(this, 89, 0);
        this.rFlipper1.mirror = true;
        this.rFlipper1.setPos(-4.0F, 5.0F, -9.0F);
        this.rFlipper1.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 5, 0.0F);
        this.setRotateAngle(rFlipper1, -0.13962634015954636F, 0.0F, 0.9424777960769379F);
        this.lowJaw = new ModelPart(this, 41, 0);
        this.lowJaw.setPos(0.0F, 4.9F, -5.4F);
        this.lowJaw.addBox(-2.0F, -0.5F, -3.5F, 4, 1, 4, 0.0F);
        this.rLeg1 = new ModelPart(this, 110, 0);
        this.rLeg1.mirror = true;
        this.rLeg1.setPos(-2.5F, 2.4F, 6.2F);
        this.rLeg1.addBox(-1.5F, 0.0F, -2.0F, 3, 7, 4, 0.0F);
        this.setRotateAngle(rLeg1, 0.5759586531581287F, -1.7453292519943295F, 0.0F);
        this.tail = new ModelPart(this, 79, 37);
        this.tail.setPos(0.0F, -0.9F, 7.5F);
        this.tail.addBox(-1.5F, -1.0F, 0.0F, 3, 2, 4, 0.0F);
        this.setRotateAngle(tail, -0.5235987755982988F, 0.0F, 0.0F);
        this.lWhiskersB = new ModelPart(this, 76, 51);
        this.lWhiskersB.setPos(3.0F, 0.4F, -4.5F);
        this.lWhiskersB.addBox(-1.0F, 0.0F, -0.3F, 0, 5, 4, 0.0F);
        this.setRotateAngle(lWhiskersB, 0.0F, 0.0F, -0.2617993877991494F);
        this.body3 = new ModelPart(this, 45, 29);
        this.body3.setPos(0.0F, -0.4F, 9.4F);
        this.body3.addBox(-4.5F, -2.0F, 0.0F, 9, 11, 7, 0.0F);
        this.setRotateAngle(body3, -0.13962634015954636F, 0.0F, 0.0F);
        this.body.addChild(this.body2);
        this.body.addChild(this.lFlipper1);
        this.upperJawR.addChild(this.rTusk01);
        this.lLeg1.addChild(this.lLeg2);
        this.head.addChild(this.snout);
        this.lTusk01.addChild(this.lTusk02);
        this.rLeg1.addChild(this.rLeg2);
        this.rTusk01.addChild(this.rTusk02);
        this.upperJawL.addChild(this.lTusk01);
        this.upperJawR.addChild(this.rWhiskersF);
        this.lFlipper2.addChild(this.lFlipper3);
        this.head.addChild(this.upperJawL);
        this.body.addChild(this.neck);
        this.head.addChild(this.upperJawR);
        this.rFlipper1.addChild(this.rFlipper2);
        this.upperJawL.addChild(this.lWhiskersF);
        this.lFlipper1.addChild(this.lFlipper2);
        this.neck2.addChild(this.head);
        this.upperJawR.addChild(this.rWhiskersB);
        this.body3.addChild(this.body4);
        this.body4.addChild(this.lLeg1);
        this.neck.addChild(this.neck2);
        this.rFlipper2.addChild(this.rFlipper3);
        this.body.addChild(this.rFlipper1);
        this.head.addChild(this.lowJaw);
        this.body4.addChild(this.rLeg1);
        this.body4.addChild(this.tail);
        this.upperJawL.addChild(this.lWhiskersB);
        this.body2.addChild(this.body3);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.setRotateAngle(lLeg2, 0.7853981633974483F, 0.7853981633974483F, -0.08726646259971647F);
        this.setRotateAngle(rLeg2, 0.7853981633974483F, -0.7853981633974483F, 0.08726646259971647F);
        this.setRotateAngle(lLeg1, 0.5759586531581287F, 1.7453292519943295F, 0.0F);
        this.setRotateAngle(rLeg1, 0.5759586531581287F, -1.7453292519943295F, 0.0F);
        this.setRotateAngle(rFlipper2, 0.5759586531581287F, 0.0F, 0.45378560551852565F);
        this.setRotateAngle(lFlipper2, 0.5759586531581287F, 0.0F, -0.45378560551852565F);
        this.neck.xRot = -0.7155849933176751F;
        this.neck.y = 2.3F;

        this.head.xRot = (float) Math.toRadians(ModelBetterAnimals.getHeadPitch(entity)) + 0.6981317007977318F;
        this.neck2.yRot = (float) Mth.clamp(Math.toRadians(ModelBetterAnimals.getHeadYaw(entity)), Math.toRadians(-35F), Math.toRadians(35F));
        if (!entity.isInWater()) {
            this.lLeg1.xRot = 0.5759586531581287F * 1.75F;
            this.rLeg1.xRot = 0.5759586531581287F * 1.75F;
            this.lLeg1.yRot = (float) Math.sin(limbSwing * 1.5F) * limbSwingAmount * 1.5F + 1.7453292519943295F - 0.6F;
            this.rLeg1.yRot = (float) Math.cos(limbSwing * 1.5F) * limbSwingAmount * 1.5F - 1.7453292519943295F + 0.6F;
            this.lFlipper2.xRot = (float) Math.cos(limbSwing * 1.5F) * limbSwingAmount * 1.5F - 0.5759586531581287F / 3F;
            this.rFlipper2.xRot = (float) Math.sin(limbSwing * 1.5F) * limbSwingAmount * 1.5F - 0.5759586531581287F / 3F;
        } else {
            this.head.xRot -= 0.6981317007977318F;
            this.neck.xRot = 0F;
            this.neck.y = -1.15F;
            this.lFlipper2.zRot = 0F;
            this.rFlipper2.zRot = 0F;
            this.lFlipper2.yRot = (float) Math.sin(-limbSwing * 0.25F) * limbSwingAmount * 0.5F;
            this.rFlipper2.yRot = (float) Math.sin(limbSwing * 0.25F) * limbSwingAmount * 0.5F;
            this.lLeg1.xRot = 0.5759586531581287F * 3F;
            this.rLeg1.xRot = 0.5759586531581287F * 3F;
            this.lLeg1.yRot = 0F;
            this.rLeg1.yRot = 0F;
            this.lLeg2.zRot = 0F;
            this.rLeg2.zRot = 0F;
            this.rLeg2.yRot = -(float) Math.PI / 2F;
            this.lLeg2.yRot = (float) Math.PI / 2F;
            this.rLeg2.xRot = -(float) Math.sin(-limbSwing * 0.25F) * limbSwingAmount * 1F;
            this.lLeg2.xRot = -(float) Math.sin(limbSwing * 0.25F) * limbSwingAmount * 1F;
        }
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelPart ModelRenderer, float x, float y, float z) {
        ModelRenderer.xRot = x;
        ModelRenderer.yRot = y;
        ModelRenderer.zRot = z;
    }
}
