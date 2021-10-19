package dev.itsmeow.betteranimalsplus.client.model.armor;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

/**
 * WolfCape - cybercat5555
 * Created using Tabula 5.1.0
 */
public class ModelWolfCape<T extends LivingEntity> extends HumanoidModel<T> {

    public static final ModelWolfCape<LivingEntity> INSTANCE = new ModelWolfCape<>();

    public ModelPart wolfCapeMain;
    public ModelPart wolfCapeLower;
    public ModelPart wolfCapeArmL1;
    public ModelPart wolfCapeArmR1;
    public ModelPart wolfCapeTail01;
    public ModelPart wolfCapeTailSlope;
    public ModelPart wolfCapeTail02;
    public ModelPart wolfCapeTail03;
    public ModelPart wolfCapeArmL2;
    public ModelPart lClaw01;
    public ModelPart lClaw02;
    public ModelPart lClaw03;
    public ModelPart wolfCapeArmR2;
    public ModelPart rClaw01;
    public ModelPart rClaw02;
    public ModelPart rClaw03;
    public ModelPart baseCube;

    private float f1_r;
    private float f2_r;
    private float f3_r;
    private boolean isPlayer;

    public ModelWolfCape() {
        super(1F, 0.0F, 128, 64);
        this.baseCube = new ModelPart(this, 0, 0);
        this.baseCube.setPos(0.0F, 0.0F, 0.0F);
        this.baseCube.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.wolfCapeArmR2 = new ModelPart(this, 97, 8);
        this.wolfCapeArmR2.mirror = true;
        this.wolfCapeArmR2.setPos(0.0F, 0.5F, -4.9F);
        this.wolfCapeArmR2.addBox(-1.5F, -0.8F, -0.5F, 3, 3, 1, 0.0F);
        this.setRotateAngle(wolfCapeArmR2, -0.10471975511965977F, 0.0F, 0.0F);
        this.wolfCapeTail01 = new ModelPart(this, 107, 39);
        this.wolfCapeTail01.setPos(0.0F, 6.8F, 0.4F);
        this.wolfCapeTail01.addBox(-2.0F, 0.0F, -1.5F, 4, 6, 3, 0.0F);
        this.setRotateAngle(wolfCapeTail01, 0.5235987755982988F, 0.0F, 0.0F);
        this.lClaw01 = new ModelPart(this, 109, 8);
        this.lClaw01.setPos(-0.9F, 1.8F, 0.0F);
        this.lClaw01.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(lClaw01, 0.13962634015954636F, 0.0F, 0.10471975511965977F);
        this.wolfCapeArmR1 = new ModelPart(this, 97, 0);
        this.wolfCapeArmR1.mirror = true;
        this.wolfCapeArmR1.setPos(-3.0F, 0.0F, 2.4F);
        this.wolfCapeArmR1.addBox(-1.5F, -0.5F, -5.0F, 3, 1, 5, 0.0F);
        this.setRotateAngle(wolfCapeArmR1, -0.05235987755982988F, 0.06981317007977318F, -0.17453292519943295F);
        this.lClaw02 = new ModelPart(this, 109, 8);
        this.lClaw02.setPos(0.0F, 1.9F, 0.0F);
        this.lClaw02.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(lClaw02, 0.13962634015954636F, 0.0F, 0.0F);
        this.rClaw03 = new ModelPart(this, 109, 8);
        this.rClaw03.mirror = true;
        this.rClaw03.setPos(-0.9F, 1.9F, 0.0F);
        this.rClaw03.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(rClaw03, 0.13962634015954636F, 0.0F, 0.10471975511965977F);
        this.wolfCapeMain = new ModelPart(this, 71, 0);
        this.wolfCapeMain.setPos(0.0F, 0.0F, 0.0F);
        this.wolfCapeMain.addBox(-4.5F, 0.0F, 1.6F, 9, 8, 1, 0.0F);
        this.setRotateAngle(wolfCapeMain, 0.10471975511965977F, 0.0F, 0.0F);
        this.wolfCapeTailSlope = new ModelPart(this, 110, 34);
        this.wolfCapeTailSlope.setPos(0.0F, 7.3F, 0.9F);
        this.wolfCapeTailSlope.addBox(-1.5F, -3.0F, -0.5F, 3, 3, 1, 0.0F);
        this.setRotateAngle(wolfCapeTailSlope, 0.2792526803190927F, 0.0F, 0.0F);
        this.lClaw03 = new ModelPart(this, 109, 8);
        this.lClaw03.mirror = true;
        this.lClaw03.setPos(0.9F, 1.8F, 0.0F);
        this.lClaw03.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(lClaw03, 0.13962634015954636F, 0.0F, -0.10471975511965977F);
        this.wolfCapeArmL1 = new ModelPart(this, 97, 0);
        this.wolfCapeArmL1.setPos(3.0F, 0.0F, 2.4F);
        this.wolfCapeArmL1.addBox(-1.5F, -0.5F, -5.0F, 3, 1, 5, 0.0F);
        this.setRotateAngle(wolfCapeArmL1, -0.05235987755982988F, -0.06981317007977318F, 0.17453292519943295F);
        this.wolfCapeArmL2 = new ModelPart(this, 97, 8);
        this.wolfCapeArmL2.setPos(0.0F, 0.5F, -4.9F);
        this.wolfCapeArmL2.addBox(-1.5F, -0.8F, -0.5F, 3, 3, 1, 0.0F);
        this.setRotateAngle(wolfCapeArmL2, -0.10471975511965977F, 0.0F, 0.0F);
        this.rClaw01 = new ModelPart(this, 109, 8);
        this.rClaw01.mirror = true;
        this.rClaw01.setPos(1.0F, 1.9F, 0.0F);
        this.rClaw01.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(rClaw01, 0.13962634015954636F, 0.0F, -0.10471975511965977F);
        this.wolfCapeTail03 = new ModelPart(this, 97, 44);
        this.wolfCapeTail03.setPos(0.0F, 0.0F, 0.0F);
        this.wolfCapeTail03.addBox(-1.0F, -1.4F, -1.0F, 2, 7, 2, 0.0F);
        this.setRotateAngle(wolfCapeTail03, 0.05235987755982988F, 0.0F, 0.0F);
        this.rClaw02 = new ModelPart(this, 109, 8);
        this.rClaw02.mirror = true;
        this.rClaw02.setPos(0.0F, 1.9F, 0.0F);
        this.rClaw02.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(rClaw02, 0.13962634015954636F, 0.0F, 0.0F);
        this.wolfCapeLower = new ModelPart(this, 71, 11);
        this.wolfCapeLower.setPos(0.0F, 7.8F, 2.1F);
        this.wolfCapeLower.addBox(-4.0F, 0.0F, -0.5F, 8, 7, 1, 0.0F);
        this.setRotateAngle(wolfCapeLower, -0.08726646259971647F, 0.0F, 0.0F);
        this.wolfCapeTail02 = new ModelPart(this, 107, 48);
        this.wolfCapeTail02.setPos(0.0F, 5.9F, 0.0F);
        this.wolfCapeTail02.addBox(-1.5F, -0.5F, -1.5F, 3, 4, 3, 0.0F);
        this.setRotateAngle(wolfCapeTail02, 0.12217304763960307F, 0.0F, 0.0F);
        this.body.addChild(this.baseCube);
        this.wolfCapeArmR1.addChild(this.wolfCapeArmR2);
        this.wolfCapeLower.addChild(this.wolfCapeTail01);
        this.wolfCapeArmL2.addChild(this.lClaw01);
        this.baseCube.addChild(this.wolfCapeArmR1);
        this.wolfCapeArmL2.addChild(this.lClaw02);
        this.wolfCapeArmR2.addChild(this.rClaw03);
        this.baseCube.addChild(this.wolfCapeMain);
        this.wolfCapeLower.addChild(this.wolfCapeTailSlope);
        this.wolfCapeArmL2.addChild(this.lClaw03);
        this.baseCube.addChild(this.wolfCapeArmL1);
        this.wolfCapeArmL1.addChild(this.wolfCapeArmL2);
        this.wolfCapeArmR2.addChild(this.rClaw01);
        this.wolfCapeTail02.addChild(this.wolfCapeTail03);
        this.wolfCapeArmR2.addChild(this.rClaw02);
        this.wolfCapeMain.addChild(this.wolfCapeLower);
        this.wolfCapeTail01.addChild(this.wolfCapeTail02);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.leftArm.visible = false;
        this.rightArm.visible = false;
        if (isPlayer) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.0F, 0.05F, 0.025F);
            float angle = 6.0F + f2_r / 2.0F + f1_r;
            angle = Math.min(angle, 90F);
            matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(angle));
            matrixStackIn.mulPose(Vector3f.ZP.rotationDegrees(f3_r / 2.0F));
            super.renderToBuffer(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            matrixStackIn.popPose();
            this.wolfCapeArmL1.visible = true;
            this.wolfCapeArmR1.visible = true;
            this.wolfCapeMain.visible = false;
            super.renderToBuffer(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            this.wolfCapeArmL1.visible = false;
            this.wolfCapeArmR1.visible = false;
            this.wolfCapeMain.visible = true;
        } else {
            this.wolfCapeArmL1.visible = true;
            this.wolfCapeArmR1.visible = true;
            super.renderToBuffer(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        }
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float f33, float f44) {
        this.isPlayer = entity instanceof Player;
        if (isPlayer) {
            Player player = (Player) entity;
            float partialTicks = Minecraft.getInstance().getFrameTime();
            double d0 = player.xCloakO + (player.xCloak - player.xCloakO) * (double) partialTicks - (player.xo + (player.getX() - player.xo) * (double) partialTicks);
            double d1 = player.yCloakO + (player.yCloak - player.yCloakO) * (double) partialTicks - (player.yo + (player.getY() - player.yo) * (double) partialTicks);
            double d2 = player.zCloakO + (player.zCloak - player.zCloakO) * (double) partialTicks - (player.zo + (player.getZ() - player.zo) * (double) partialTicks);
            float f = player.yBodyRotO + (player.yBodyRot - player.yBodyRotO) * partialTicks;
            double d3 = Mth.sin(f * 0.017453292F);
            double d4 = -Mth.cos(f * 0.017453292F);
            float f1 = (float) d1 * 10.0F;
            f1 = Mth.clamp(f1, -6.0F, 32.0F);
            float f2 = (float) (d0 * d3 + d2 * d4) * 100.0F;
            float f3 = (float) (d0 * d4 - d2 * d3) * 100.0F;

            if (f2 < 0.0F) {
                f2 = 0.0F;
            }

            float f4 = player.oBob + (player.bob - player.oBob) * partialTicks;
            f1 = f1 + Mth.sin((player.walkDistO + (player.walkDist - player.walkDistO) * partialTicks) * 6.0F) * 32.0F * f4;
            this.f1_r = f1;
            this.f2_r = f2;
            this.f3_r = f3;
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
