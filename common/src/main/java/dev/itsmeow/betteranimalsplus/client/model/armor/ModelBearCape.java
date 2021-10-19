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
 * BearCape - cybercat5555
 * Created using Tabula 7.0.1
 */
public class ModelBearCape<T extends LivingEntity> extends HumanoidModel<T> {

    public static final ModelBearCape<LivingEntity> INSTANCE = new ModelBearCape<>();

    public ModelPart baseCube;
    public ModelPart bearCapeArmR1;
    public ModelPart bearCapeArmL1;
    public ModelPart bearCapeMain;
    public ModelPart bearCapeArmL2;
    public ModelPart lClaw01;
    public ModelPart lClaw02;
    public ModelPart lClaw03;
    public ModelPart bearCapeLower;
    public ModelPart bearCapeTatter;
    public ModelPart bearCapeArmR2;
    public ModelPart rClaw01;
    public ModelPart rClaw02;
    public ModelPart rClaw03;

    private float f1_r;
    private float f2_r;
    private float f3_r;
    private boolean isPlayer;

    public ModelBearCape() {
        super(1F, 0.0F, 128, 64);
        this.lClaw02 = new ModelPart(this, 109, 8);
        this.lClaw02.setPos(0.0F, 2.4F, 0.0F);
        this.lClaw02.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(lClaw02, 0.13962634015954636F, 0.0F, 0.0F);
        this.bearCapeArmR2 = new ModelPart(this, 97, 8);
        this.bearCapeArmR2.mirror = true;
        this.bearCapeArmR2.setPos(0.0F, 0.5F, -4.9F);
        this.bearCapeArmR2.addBox(-2.0F, -0.8F, -0.5F, 4, 4, 1, 0.0F);
        this.setRotateAngle(bearCapeArmR2, -0.10471975511965977F, 0.0F, 0.0F);
        this.rClaw03 = new ModelPart(this, 109, 8);
        this.rClaw03.mirror = true;
        this.rClaw03.setPos(-1.4F, 2.4F, 0.0F);
        this.rClaw03.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(rClaw03, 0.13962634015954636F, 0.0F, 0.10471975511965977F);
        this.rClaw02 = new ModelPart(this, 109, 8);
        this.rClaw02.mirror = true;
        this.rClaw02.setPos(0.0F, 2.4F, 0.0F);
        this.rClaw02.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(rClaw02, 0.13962634015954636F, 0.0F, 0.0F);
        this.baseCube = new ModelPart(this, 0, 0);
        this.baseCube.setPos(0.0F, 0.0F, 0.0F);
        this.baseCube.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.lClaw03 = new ModelPart(this, 109, 8);
        this.lClaw03.mirror = true;
        this.lClaw03.setPos(1.4F, 2.4F, 0.0F);
        this.lClaw03.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(lClaw03, 0.13962634015954636F, 0.0F, -0.10471975511965977F);
        this.bearCapeArmL2 = new ModelPart(this, 97, 8);
        this.bearCapeArmL2.setPos(0.0F, 0.5F, -4.9F);
        this.bearCapeArmL2.addBox(-2.0F, -0.8F, -0.5F, 4, 4, 1, 0.0F);
        this.setRotateAngle(bearCapeArmL2, -0.10471975511965977F, 0.0F, 0.0F);
        this.bearCapeArmR1 = new ModelPart(this, 97, 0);
        this.bearCapeArmR1.mirror = true;
        this.bearCapeArmR1.setPos(-3.0F, 0.0F, 2.4F);
        this.bearCapeArmR1.addBox(-2.0F, -0.5F, -5.0F, 4, 1, 5, 0.0F);
        this.setRotateAngle(bearCapeArmR1, -0.05235987755982988F, 0.06981317007977318F, -0.17453292519943295F);
        this.rClaw01 = new ModelPart(this, 109, 8);
        this.rClaw01.mirror = true;
        this.rClaw01.setPos(1.4F, 2.4F, 0.0F);
        this.rClaw01.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(rClaw01, 0.13962634015954636F, 0.0F, -0.10471975511965977F);
        this.bearCapeArmL1 = new ModelPart(this, 97, 0);
        this.bearCapeArmL1.setPos(3.0F, 0.0F, 2.4F);
        this.bearCapeArmL1.addBox(-2.0F, -0.5F, -5.0F, 4, 1, 5, 0.0F);
        this.setRotateAngle(bearCapeArmL1, -0.05235987755982988F, -0.06981317007977318F, 0.17453292519943295F);
        this.bearCapeMain = new ModelPart(this, 71, 0);
        this.bearCapeMain.setPos(0.0F, 0.0F, 0.0F);
        this.bearCapeMain.addBox(-5.0F, 0.0F, 1.6F, 10, 9, 1, 0.0F);
        this.setRotateAngle(bearCapeMain, 0.10471975511965977F, 0.0F, 0.0F);
        this.lClaw01 = new ModelPart(this, 109, 8);
        this.lClaw01.setPos(-1.4F, 2.4F, 0.0F);
        this.lClaw01.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(lClaw01, 0.13962634015954636F, 0.0F, 0.10471975511965977F);
        this.bearCapeLower = new ModelPart(this, 71, 11);
        this.bearCapeLower.setPos(0.0F, 8.9F, 2.1F);
        this.bearCapeLower.addBox(-4.5F, 0.0F, -0.5F, 9, 7, 1, 0.0F);
        this.setRotateAngle(bearCapeLower, -0.08726646259971647F, 0.0F, 0.0F);
        this.bearCapeTatter = new ModelPart(this, 71, 21);
        this.bearCapeTatter.setPos(0.0F, 6.9F, 0.0F);
        this.bearCapeTatter.addBox(-4.0F, 0.0F, -0.5F, 8, 4, 1, 0.0F);
        this.setRotateAngle(bearCapeTatter, 0.08726646259971647F, 0.0F, 0.0F);
        this.bearCapeArmL2.addChild(this.lClaw02);
        this.bearCapeArmR1.addChild(this.bearCapeArmR2);
        this.bearCapeArmR2.addChild(this.rClaw03);
        this.bearCapeArmR2.addChild(this.rClaw02);
        this.body.addChild(this.baseCube);
        this.bearCapeArmL2.addChild(this.lClaw03);
        this.bearCapeArmL1.addChild(this.bearCapeArmL2);
        this.bearCapeArmR2.addChild(this.rClaw01);
        this.baseCube.addChild(this.bearCapeArmL1);
        this.baseCube.addChild(this.bearCapeArmR1);
        this.baseCube.addChild(this.bearCapeMain);
        this.bearCapeArmL2.addChild(this.lClaw01);
        this.bearCapeMain.addChild(this.bearCapeLower);
        this.bearCapeLower.addChild(this.bearCapeTatter);
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
            this.bearCapeArmL1.visible = true;
            this.bearCapeArmR1.visible = true;
            this.bearCapeMain.visible = false;
            super.renderToBuffer(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            this.bearCapeArmL1.visible = false;
            this.bearCapeArmR1.visible = false;
            this.bearCapeMain.visible = true;
        } else {
            this.bearCapeArmL1.visible = true;
            this.bearCapeArmR1.visible = true;
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
