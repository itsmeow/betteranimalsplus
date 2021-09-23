package dev.itsmeow.betteranimalsplus.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import dev.itsmeow.betteranimalsplus.common.entity.EntitySongbird;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;

/**
 * songbirdSmall - cybercat5555 Created using Tabula 5.1.0
 */
public class ModelSongbirdSmall<T extends LivingEntity> extends EntityModel<T> {
    public ModelRenderer body;
    public ModelRenderer tailBase;
    public ModelRenderer lLeg01;
    public ModelRenderer rLeg01;
    public ModelRenderer neck;
    public ModelRenderer lWing01;
    public ModelRenderer rWing01;
    public ModelRenderer tailCoverts;
    public ModelRenderer lTailFeather01;
    public ModelRenderer rTailFeather01;
    public ModelRenderer lTailFeather02;
    public ModelRenderer rTailFeather02;
    public ModelRenderer lTailFeather03;
    public ModelRenderer rTailFeather03;
    public ModelRenderer lLeg02;
    public ModelRenderer lFoot;
    public ModelRenderer rLeg02;
    public ModelRenderer rFoot;
    public ModelRenderer head;
    public ModelRenderer beak01;
    public ModelRenderer crest;
    public ModelRenderer beak02;
    public ModelRenderer beak02b;
    public ModelRenderer lWing02;
    public ModelRenderer lWingFeather01;
    public ModelRenderer lWing03;
    public ModelRenderer lWingFeather02;
    public ModelRenderer lWingFeather03;
    public ModelRenderer rWing02;
    public ModelRenderer rWingFeather01;
    public ModelRenderer rWing03;
    public ModelRenderer rWingFeather02;
    public ModelRenderer rWingFeather03;

    public ModelSongbirdSmall() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.tailCoverts = new ModelRenderer(this, 0, 26);
        this.tailCoverts.setRotationPoint(0.0F, -1.3F, -0.9F);
        this.tailCoverts.addBox(-2.0F, 1.5F, -0.1F, 4, 3, 5, 0.0F);
        this.setRotateAngle(tailCoverts, 0.10471975511965977F, 0.0F, 0.0F);
        this.neck = new ModelRenderer(this, 31, 9);
        this.neck.setRotationPoint(0.0F, 0.0F, -2.9F);
        this.neck.addBox(-1.5F, -2.1F, -3.8F, 3, 4, 3, 0.0F);
        this.setRotateAngle(neck, -0.2792526803190927F, 0.0F, 0.0F);
        this.lLeg02 = new ModelRenderer(this, 34, 0);
        this.lLeg02.setRotationPoint(0.0F, 1.3F, 0.0F);
        this.lLeg02.addBox(-0.5F, -0.2F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(lLeg02, -0.20943951023931953F, 0.0F, 0.0F);
        this.lWingFeather01 = new ModelRenderer(this, 17, 30);
        this.lWingFeather01.setRotationPoint(1.8F, 0.0F, 0.5F);
        this.lWingFeather01.addBox(-2.5F, 0.0F, 0.0F, 5, 0, 6, 0.0F);
        this.setRotateAngle(lWingFeather01, -0.5585053606381855F, 0.0F, 0.0F);
        this.rWing01 = new ModelRenderer(this, 0, 49);
        this.rWing01.mirror = true;
        this.rWing01.setRotationPoint(-2.9F, -1.1F, -1.9F);
        this.rWing01.addBox(-4.0F, -0.5F, -1.5F, 5, 1, 3, 0.0F);
        this.setRotateAngle(rWing01, 0.0F, 1.0821041362364843F, -0.9424777960769379F);
        this.lFoot = new ModelRenderer(this, 39, 0);
        this.lFoot.setRotationPoint(0.0F, 3.7F, 0.0F);
        this.lFoot.addBox(-0.49F, -0.5F, -2.5F, 1, 1, 3, 0.0F);
        this.setRotateAngle(lFoot, 0.19198621771937624F, -0.05235987755982988F, 0.0F);
        this.lWingFeather02 = new ModelRenderer(this, 16, 38);
        this.lWingFeather02.setRotationPoint(2.3F, 0.0F, 1.3F);
        this.lWingFeather02.addBox(-2.1F, 0.0F, -0.4F, 4, 0, 7, 0.0F);
        this.lWingFeather03 = new ModelRenderer(this, 15, 47);
        this.lWingFeather03.setRotationPoint(1.8F, 0.0F, 1.0F);
        this.lWingFeather03.addBox(-1.5F, 0.0F, -1.4F, 9, 0, 8, 0.0F);
        this.rWing02 = new ModelRenderer(this, 0, 55);
        this.rWing02.mirror = true;
        this.rWing02.setRotationPoint(-4.0F, 0.0F, -1.1F);
        this.rWing02.addBox(-4.0F, -0.5F, -0.4F, 4, 1, 2, 0.0F);
        this.setRotateAngle(rWing02, -0.3665191429188092F, 0.5235987755982988F, 0.0F);
        this.rWingFeather01 = new ModelRenderer(this, 17, 30);
        this.rWingFeather01.mirror = true;
        this.rWingFeather01.setRotationPoint(-1.8F, 0.0F, 0.5F);
        this.rWingFeather01.addBox(-2.5F, 0.0F, 0.0F, 5, 0, 6, 0.0F);
        this.setRotateAngle(rWingFeather01, -0.5585053606381855F, 0.0F, 0.0F);
        this.lTailFeather01 = new ModelRenderer(this, -6, 37);
        this.lTailFeather01.setRotationPoint(0.7F, -0.3F, 5.2F);
        this.lTailFeather01.addBox(-1.0F, 0.0F, 0.0F, 2, 0, 8, 0.0F);
        this.setRotateAngle(lTailFeather01, 0.06981317007977318F, 0.05235987755982988F, 0.0F);
        this.beak02b = new ModelRenderer(this, 49, 5);
        this.beak02b.mirror = true;
        this.beak02b.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.beak02b.addBox(-0.6F, -0.5F, -2.6F, 1, 1, 3, 0.0F);
        this.rWing03 = new ModelRenderer(this, 0, 60);
        this.rWing03.mirror = true;
        this.rWing03.setRotationPoint(-3.8F, 0.0F, 0.0F);
        this.rWing03.addBox(-3.0F, -0.5F, -0.4F, 3, 1, 2, 0.0F);
        this.setRotateAngle(rWing03, 0.0F, 0.2617993877991494F, 0.0F);
        this.beak02 = new ModelRenderer(this, 49, 5);
        this.beak02.setRotationPoint(0.0F, 0.5F, 0.2F);
        this.beak02.addBox(-0.4F, -0.5F, -2.6F, 1, 1, 3, 0.0F);
        this.setRotateAngle(beak02, -0.2792526803190927F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 25, 17);
        this.head.setRotationPoint(0.0F, -1.2F, -1.5F);
        this.head.addBox(-2.0F, -2.1F, -4.0F, 4, 4, 4, 0.0F);
        this.setRotateAngle(head, 0.5410520681182421F, 0.0F, 0.0F);
        this.lTailFeather02 = new ModelRenderer(this, -6, 37);
        this.lTailFeather02.setRotationPoint(1.4F, -0.1F, 4.4F);
        this.lTailFeather02.addBox(-1.0F, 0.0F, 0.0F, 2, 0, 8, 0.0F);
        this.setRotateAngle(lTailFeather02, 0.06981317007977318F, 0.06981317007977318F, 0.0F);
        this.rTailFeather02 = new ModelRenderer(this, -6, 37);
        this.rTailFeather02.mirror = true;
        this.rTailFeather02.setRotationPoint(-1.4F, -0.1F, 4.4F);
        this.rTailFeather02.addBox(-1.0F, 0.0F, 0.0F, 2, 0, 8, 0.0F);
        this.setRotateAngle(rTailFeather02, 0.06981317007977318F, -0.06981317007977318F, 0.0F);
        this.tailBase = new ModelRenderer(this, 0, 16);
        this.tailBase.setRotationPoint(0.0F, -0.9F, 2.1F);
        this.tailBase.addBox(-2.5F, -1.5F, 0.2F, 5, 2, 5, 0.0F);
        this.setRotateAngle(tailBase, 0.10471975511965977F, 0.0F, 0.0F);
        this.lWing02 = new ModelRenderer(this, 0, 55);
        this.lWing02.setRotationPoint(4.1F, 0.0F, -1.1F);
        this.lWing02.addBox(0.0F, -0.5F, -0.4F, 4, 1, 2, 0.0F);
        this.setRotateAngle(lWing02, -0.3665191429188092F, -0.5235987755982988F, 0.0F);
        this.rLeg01 = new ModelRenderer(this, 24, 0);
        this.rLeg01.mirror = true;
        this.rLeg01.setRotationPoint(-1.7F, 2.1F, 1.0F);
        this.rLeg01.addBox(-1.0F, -0.2F, -1.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(rLeg01, 0.2617993877991494F, 0.0F, 0.0F);
        this.crest = new ModelRenderer(this, 43, 11);
        this.crest.setRotationPoint(0.0F, -0.4F, -1.5F);
        this.crest.addBox(-1.5F, -2.5F, -1.5F, 3, 3, 5, 0.0F);
        this.setRotateAngle(crest, 0.47123889803846897F, 0.0F, 0.0F);
        this.rLeg02 = new ModelRenderer(this, 34, 0);
        this.rLeg02.mirror = true;
        this.rLeg02.setRotationPoint(0.0F, 1.3F, 0.0F);
        this.rLeg02.addBox(-0.5F, -0.2F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(rLeg02, -0.20943951023931953F, 0.0F, 0.0F);
        this.rTailFeather01 = new ModelRenderer(this, -6, 37);
        this.rTailFeather01.mirror = true;
        this.rTailFeather01.setRotationPoint(-0.7F, -0.3F, 5.2F);
        this.rTailFeather01.addBox(-1.0F, 0.0F, 0.0F, 2, 0, 8, 0.0F);
        this.setRotateAngle(rTailFeather01, 0.06981317007977318F, -0.05235987755982988F, 0.0F);
        this.lTailFeather03 = new ModelRenderer(this, -6, 37);
        this.lTailFeather03.setRotationPoint(1.1F, 0.1F, 3.5F);
        this.lTailFeather03.addBox(-1.0F, 0.0F, 0.0F, 2, 0, 8, 0.0F);
        this.setRotateAngle(lTailFeather03, 0.06981317007977318F, 0.17453292519943295F, 0.0F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0.0F, 16.5F, 0.0F);
        this.body.addBox(-3.0F, -3.0F, -4.5F, 6, 6, 7, 0.0F);
        this.setRotateAngle(body, -0.2617993877991494F, 0.0F, 0.0F);
        this.rTailFeather03 = new ModelRenderer(this, -6, 37);
        this.rTailFeather03.mirror = true;
        this.rTailFeather03.setRotationPoint(-1.1F, 0.1F, 3.5F);
        this.rTailFeather03.addBox(-1.0F, 0.0F, 0.0F, 2, 0, 8, 0.0F);
        this.setRotateAngle(rTailFeather03, 0.06981317007977318F, -0.17453292519943295F, 0.0F);
        this.lLeg01 = new ModelRenderer(this, 24, 0);
        this.lLeg01.setRotationPoint(1.7F, 2.1F, 1.0F);
        this.lLeg01.addBox(-1.0F, -0.2F, -1.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(lLeg01, 0.2617993877991494F, 0.0F, 0.0F);
        this.rWingFeather03 = new ModelRenderer(this, 15, 47);
        this.rWingFeather03.mirror = true;
        this.rWingFeather03.setRotationPoint(-1.8F, 0.0F, 1.0F);
        this.rWingFeather03.addBox(-7.5F, 0.0F, -1.4F, 9, 0, 8, 0.0F);
        this.lWing03 = new ModelRenderer(this, 0, 60);
        this.lWing03.setRotationPoint(3.8F, 0.0F, 0.0F);
        this.lWing03.addBox(0.0F, -0.5F, -0.4F, 3, 1, 2, 0.0F);
        this.setRotateAngle(lWing03, 0.0F, -0.2617993877991494F, 0.0F);
        this.rFoot = new ModelRenderer(this, 39, 0);
        this.rFoot.mirror = true;
        this.rFoot.setRotationPoint(0.0F, 3.7F, 0.0F);
        this.rFoot.addBox(-0.51F, -0.5F, -2.5F, 1, 1, 3, 0.0F);
        this.setRotateAngle(rFoot, 0.19198621771937624F, 0.05235987755982988F, 0.0F);
        this.beak01 = new ModelRenderer(this, 49, 0);
        this.beak01.setRotationPoint(0.0F, 0.7F, -4.2F);
        this.beak01.addBox(-0.5F, -0.9F, -2.3F, 1, 1, 4, 0.0F);
        this.setRotateAngle(beak01, 0.20943951023931953F, 0.0F, 0.0F);
        this.rWingFeather02 = new ModelRenderer(this, 16, 38);
        this.rWingFeather02.mirror = true;
        this.rWingFeather02.setRotationPoint(-2.3F, 0.0F, 1.3F);
        this.rWingFeather02.addBox(-1.9F, 0.0F, -0.4F, 4, 0, 7, 0.0F);
        this.lWing01 = new ModelRenderer(this, 0, 49);
        this.lWing01.setRotationPoint(2.9F, -1.1F, -1.9F);
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
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setRotationAngles(T entity, float f, float f1, float f2, float f3, float f4) {
        if (entity instanceof EntitySongbird) {
            EntitySongbird bird = (EntitySongbird) entity;
            boolean show;
            if (bird.isFlying()) {
                this.rWing01.rotateAngleY = 0F;
                this.lWing01.rotateAngleY = 0F;
                this.rWing02.rotateAngleY = 0F;
                this.lWing02.rotateAngleY = 0F;

                this.rWing01.rotateAngleX = 0F;
                this.lWing01.rotateAngleX = 0F;
                this.rWing02.rotateAngleX = 0F;
                this.lWing02.rotateAngleX = 0F;

                this.lWingFeather01.rotateAngleX = 0F;
                this.rWingFeather01.rotateAngleX = 0F;

                this.rLeg01.rotateAngleX = 0.2617993877991494F;
                this.lLeg01.rotateAngleX = 0.2617993877991494F;

                this.rWing01.rotateAngleZ = MathHelper.cos(f2) * (float) Math.PI / 5F;
                if ((Math.abs(bird.getMotion().getY()) > 0 && (Math.abs(bird.getMotion().getX()) > 0.05 || Math.abs(bird.getMotion().getZ()) > 0.05)) || Math.abs(bird.getMotion().getY()) > 0.25) {
                    float rotX = -((float) Math.atan2(bird.getMotion().getY(), Math.sqrt(Math.pow(bird.getMotion().getX(), 2) + Math.pow(bird.getMotion().getZ(), 2))) / 1.5F);
                    if (rotX < 0) {
                        rotX /= 3;
                    }
                    this.body.rotateAngleX = rotX - 0.2617993877991494F;
                } else {
                    this.body.rotateAngleX = -0.2617993877991494F;
                }

                this.lWing01.rotateAngleZ = -this.rWing01.rotateAngleZ;
                this.rWing02.rotateAngleZ = this.rWing01.rotateAngleZ * 0.5F;
                this.lWing02.rotateAngleZ = -this.rWing01.rotateAngleZ * 0.5F;
                show = false;
            } else {
                this.setRotateAngle(rWing01, 0.0F, 1.0821041362364843F, -0.9424777960769379F);
                this.setRotateAngle(lWing01, 0.0F, -1.0821041362364843F, 0.9424777960769379F);
                this.setRotateAngle(rWing02, -0.3665191429188092F, 0.5235987755982988F, 0.0F);
                this.setRotateAngle(lWing02, -0.3665191429188092F, -0.5235987755982988F, 0.0F);
                this.lWingFeather01.rotateAngleX = -0.5585053606381855F;
                this.rWingFeather01.rotateAngleX = -0.5585053606381855F;
                this.body.rotateAngleX = -0.2617993877991494F;

                boolean flag = entity.getTicksElytraFlying() > 4;
                float e = 1.0F;

                if (flag) {
                    e = (float) (entity.getMotion().getX() * entity.getMotion().getX() + entity.getMotion().getY() * entity.getMotion().getY() + entity.getMotion().getZ() * entity.getMotion().getZ());
                    e = e / 0.2F;
                    e = e * e * e;
                }

                if (e < 1.0F) {
                    e = 1.0F;
                }

                this.rLeg01.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1 / e + 0.2617993877991494F;
                this.lLeg01.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1 / e + 0.2617993877991494F;
                show = true;
            }
            this.lLeg01.showModel = show;
            this.lLeg02.showModel = show;
            this.rLeg01.showModel = show;
            this.rLeg02.showModel = show;
            this.lFoot.showModel = show;
            this.rFoot.showModel = show;
        }
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
