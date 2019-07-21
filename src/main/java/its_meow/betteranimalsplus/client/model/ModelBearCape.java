package its_meow.betteranimalsplus.client.model;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;

/**
 * BearCape - cybercat5555
 * Created using Tabula 7.0.1
 */
public class ModelBearCape<T extends LivingEntity> extends BipedModel<T> {
    
    public static final ModelBearCape<LivingEntity> INSTANCE = new ModelBearCape<LivingEntity>();
    
    public RendererModel baseCube;
    public RendererModel bearCapeArmR1;
    public RendererModel bearCapeArmL1;
    public RendererModel bearCapeMain;
    public RendererModel bearCapeArmL2;
    public RendererModel lClaw01;
    public RendererModel lClaw02;
    public RendererModel lClaw03;
    public RendererModel bearCapeLower;
    public RendererModel bearCapeTatter;
    public RendererModel bearCapeArmR2;
    public RendererModel rClaw01;
    public RendererModel rClaw02;
    public RendererModel rClaw03;

    public ModelBearCape() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.lClaw02 = new RendererModel(this, 109, 8);
        this.lClaw02.setRotationPoint(0.0F, 2.4F, 0.0F);
        this.lClaw02.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(lClaw02, 0.13962634015954636F, 0.0F, 0.0F);
        this.bearCapeArmR2 = new RendererModel(this, 97, 8);
        this.bearCapeArmR2.mirror = true;
        this.bearCapeArmR2.setRotationPoint(0.0F, 0.5F, -4.9F);
        this.bearCapeArmR2.addBox(-2.0F, -0.8F, -0.5F, 4, 4, 1, 0.0F);
        this.setRotateAngle(bearCapeArmR2, -0.10471975511965977F, 0.0F, 0.0F);
        this.rClaw03 = new RendererModel(this, 109, 8);
        this.rClaw03.mirror = true;
        this.rClaw03.setRotationPoint(-1.4F, 2.4F, 0.0F);
        this.rClaw03.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(rClaw03, 0.13962634015954636F, 0.0F, 0.10471975511965977F);
        this.rClaw02 = new RendererModel(this, 109, 8);
        this.rClaw02.mirror = true;
        this.rClaw02.setRotationPoint(0.0F, 2.4F, 0.0F);
        this.rClaw02.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(rClaw02, 0.13962634015954636F, 0.0F, 0.0F);
        this.baseCube = new RendererModel(this, 0, 0);
        this.baseCube.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.baseCube.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.lClaw03 = new RendererModel(this, 109, 8);
        this.lClaw03.mirror = true;
        this.lClaw03.setRotationPoint(1.4F, 2.4F, 0.0F);
        this.lClaw03.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(lClaw03, 0.13962634015954636F, 0.0F, -0.10471975511965977F);
        this.bearCapeArmL2 = new RendererModel(this, 97, 8);
        this.bearCapeArmL2.setRotationPoint(0.0F, 0.5F, -4.9F);
        this.bearCapeArmL2.addBox(-2.0F, -0.8F, -0.5F, 4, 4, 1, 0.0F);
        this.setRotateAngle(bearCapeArmL2, -0.10471975511965977F, 0.0F, 0.0F);
        this.bearCapeArmR1 = new RendererModel(this, 97, 0);
        this.bearCapeArmR1.mirror = true;
        this.bearCapeArmR1.setRotationPoint(-3.0F, 0.0F, 2.4F);
        this.bearCapeArmR1.addBox(-2.0F, -0.5F, -5.0F, 4, 1, 5, 0.0F);
        this.setRotateAngle(bearCapeArmR1, -0.05235987755982988F, 0.06981317007977318F, -0.17453292519943295F);
        this.rClaw01 = new RendererModel(this, 109, 8);
        this.rClaw01.mirror = true;
        this.rClaw01.setRotationPoint(1.4F, 2.4F, 0.0F);
        this.rClaw01.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(rClaw01, 0.13962634015954636F, 0.0F, -0.10471975511965977F);
        this.bearCapeArmL1 = new RendererModel(this, 97, 0);
        this.bearCapeArmL1.setRotationPoint(3.0F, 0.0F, 2.4F);
        this.bearCapeArmL1.addBox(-2.0F, -0.5F, -5.0F, 4, 1, 5, 0.0F);
        this.setRotateAngle(bearCapeArmL1, -0.05235987755982988F, -0.06981317007977318F, 0.17453292519943295F);
        this.bearCapeMain = new RendererModel(this, 71, 0);
        this.bearCapeMain.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bearCapeMain.addBox(-5.0F, 0.0F, 1.6F, 10, 9, 1, 0.0F);
        this.setRotateAngle(bearCapeMain, 0.10471975511965977F, 0.0F, 0.0F);
        this.lClaw01 = new RendererModel(this, 109, 8);
        this.lClaw01.setRotationPoint(-1.4F, 2.4F, 0.0F);
        this.lClaw01.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(lClaw01, 0.13962634015954636F, 0.0F, 0.10471975511965977F);
        this.bearCapeLower = new RendererModel(this, 71, 11);
        this.bearCapeLower.setRotationPoint(0.0F, 8.9F, 2.1F);
        this.bearCapeLower.addBox(-4.5F, 0.0F, -0.5F, 9, 7, 1, 0.0F);
        this.setRotateAngle(bearCapeLower, -0.08726646259971647F, 0.0F, 0.0F);
        this.bearCapeTatter = new RendererModel(this, 71, 21);
        this.bearCapeTatter.setRotationPoint(0.0F, 6.9F, 0.0F);
        this.bearCapeTatter.addBox(-4.0F, 0.0F, -0.5F, 8, 4, 1, 0.0F);
        this.setRotateAngle(bearCapeTatter, 0.08726646259971647F, 0.0F, 0.0F);
        this.bearCapeArmL2.addChild(this.lClaw02);
        this.bearCapeArmR1.addChild(this.bearCapeArmR2);
        this.bearCapeArmR2.addChild(this.rClaw03);
        this.bearCapeArmR2.addChild(this.rClaw02);
        this.bipedBody.addChild(this.baseCube);
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
    public void render(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float f33, float f44, float f55) { 
        this.bipedLeftArm.showModel = false;
        this.bipedRightArm.showModel = false;
        if(entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.pushMatrix();
            GlStateManager.translatef(0.0F, 0.0F, 0.125F);
            float partialTicks = Minecraft.getInstance().getRenderPartialTicks();
            double d0 = player.prevChasingPosX + (player.chasingPosX - player.prevChasingPosX) * (double)partialTicks - (player.prevPosX + (player.posX - player.prevPosX) * (double)partialTicks);
            double d1 = player.prevChasingPosY + (player.chasingPosY - player.prevChasingPosY) * (double)partialTicks - (player.prevPosY + (player.posY - player.prevPosY) * (double)partialTicks);
            double d2 = player.prevChasingPosZ + (player.chasingPosZ - player.prevChasingPosZ) * (double)partialTicks - (player.prevPosZ + (player.posZ - player.prevPosZ) * (double)partialTicks);
            float f = player.prevRenderYawOffset + (player.renderYawOffset - player.prevRenderYawOffset) * partialTicks;
            double d3 = (double)MathHelper.sin(f * 0.017453292F);
            double d4 = (double)(-MathHelper.cos(f * 0.017453292F));
            float f1 = (float)d1 * 10.0F;
            f1 = MathHelper.clamp(f1, -6.0F, 32.0F);
            float f2 = (float)(d0 * d3 + d2 * d4) * 100.0F;
            float f3 = (float)(d0 * d4 - d2 * d3) * 100.0F;

            if (f2 < 0.0F) {
                f2 = 0.0F;
            }

            float f4 = player.prevCameraYaw + (player.cameraYaw - player.prevCameraYaw) * partialTicks;
            f1 = f1 + MathHelper.sin((player.prevDistanceWalkedModified + (player.distanceWalkedModified - player.prevDistanceWalkedModified) * partialTicks) * 6.0F) * 32.0F * f4;

            GlStateManager.translatef(0F, 0.05F, -0.1F);
            float angle = 6.0F + f2 / 2.0F + f1;
            angle = angle > 90F ? 90F : angle;
            GlStateManager.rotatef(angle, 1.0F, 0.0F, 0.0F);
            GlStateManager.rotatef(f3 / 2.0F, 0.0F, 0.0F, 1.0F);
            //GlStateManager.rotate(-f3 / 2.0F, 0.0F, 1.0F, 0.0F);
            super.render(entity, limbSwing, limbSwingAmount, ageInTicks, f33, f44, f55);
            GlStateManager.popMatrix();
            this.bearCapeArmL1.showModel = true;
            this.bearCapeArmR1.showModel = true;
            this.bearCapeMain.showModel = false;
            super.render(entity, limbSwing, limbSwingAmount, ageInTicks, f33, f44, f55);
            this.bearCapeArmL1.showModel = false;
            this.bearCapeArmR1.showModel = false;
            this.bearCapeMain.showModel = true;
        } else {
            super.render(entity, limbSwing, limbSwingAmount, ageInTicks, f33, f44, f55);
        }
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(RendererModel RendererModel, float x, float y, float z) {
        RendererModel.rotateAngleX = x;
        RendererModel.rotateAngleY = y;
        RendererModel.rotateAngleZ = z;
    }
}
