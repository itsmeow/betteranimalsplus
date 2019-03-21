package its_meow.betteranimalsplus.client.model;

import its_meow.betteranimalsplus.common.entity.EntitySquirrel;
import net.minecraft.client.renderer.entity.model.ModelBase;
import net.minecraft.client.renderer.entity.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.math.MathHelper;

/**
 * squirrelV2 - Batman, Cybercat5555 Created using Tabula 5.1.0
 */
public class ModelSquirrel extends ModelBase {

    public ModelRenderer chest;
    public ModelRenderer stomach;
    public ModelRenderer lArm01;
    public ModelRenderer rArm01;
    public ModelRenderer neck;
    public ModelRenderer lLeg01;
    public ModelRenderer rLeg01;
    public ModelRenderer tail01;
    public ModelRenderer lLeg02;
    public ModelRenderer lFoot;
    public ModelRenderer rLeg02;
    public ModelRenderer rFoot;
    public ModelRenderer tail02;
    public ModelRenderer tail01Fluff;
    public ModelRenderer tail03;
    public ModelRenderer tail02Fluff;
    public ModelRenderer tail04;
    public ModelRenderer lArm02a;
    public ModelRenderer lArm02b;
    public ModelRenderer lPaw;
    public ModelRenderer rArm02a;
    public ModelRenderer rArm02b;
    public ModelRenderer rPaw;
    public ModelRenderer head;
    public ModelRenderer upperJaw;
    public ModelRenderer lowerJaw;
    public ModelRenderer lEar;
    public ModelRenderer rEar;
    public ModelRenderer snout;
    public ModelRenderer lEarFloof;
    public ModelRenderer rEarFloof;

    public ModelSquirrel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.lFoot = new ModelRenderer(this, 50, 14);
        this.lFoot.setRotationPoint(0.2F, 4.0F, -0.1F);
        this.lFoot.addBox(-1.0F, -0.5F, -3.2F, 2, 1, 5, 0.0F);
        this.setRotateAngle(this.lFoot, -0.3490658503988659F, -0.17453292519943295F, 0.05235987755982988F);
        this.tail01Fluff = new ModelRenderer(this, 26, 37);
        this.tail01Fluff.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail01Fluff.addBox(-1.0F, 0.5F, -2.9F, 2, 3, 5, 0.0F);
        this.setRotateAngle(this.tail01Fluff, -0.08726646259971647F, 0.0F, 0.0F);
        this.rLeg01 = new ModelRenderer(this, 46, 0);
        this.rLeg01.mirror = true;
        this.rLeg01.setRotationPoint(-1.6F, -0.4F, 3.7F);
        this.rLeg01.addBox(-2.7F, -0.9F, -2.5F, 3, 6, 4, 0.0F);
        this.setRotateAngle(this.rLeg01, -0.17453292519943295F, 0.0F, 0.0F);
        this.lArm01 = new ModelRenderer(this, 31, 0);
        this.lArm01.setRotationPoint(3.0F, 0.7F, -5.0F);
        this.lArm01.addBox(-1.0F, -1.6F, -1.0F, 2, 5, 3, 0.0F);
        this.setRotateAngle(this.lArm01, -0.20943951023931953F, 0.0F, 0.0F);
        this.rArm02b = new ModelRenderer(this, 31, 8);
        this.rArm02b.mirror = true;
        this.rArm02b.setRotationPoint(-1.2F, 0.0F, -1.0F);
        this.rArm02b.addBox(0.6F, 0.0F, 0.0F, 1, 4, 2, 0.0F);
        this.snout = new ModelRenderer(this, 29, 31);
        this.snout.setRotationPoint(0.0F, -0.4F, -2.0F);
        this.snout.addBox(-1.0F, -0.5F, 0.2F, 2, 1, 3, 0.0F);
        this.setRotateAngle(this.snout, 0.20943951023931953F, 0.0F, 0.0F);
        this.lEar = new ModelRenderer(this, 55, 21);
        this.lEar.setRotationPoint(1.5F, -1.5F, -0.5F);
        this.lEar.addBox(-0.5F, -2.0F, -1.0F, 1, 2, 2, 0.0F);
        this.setRotateAngle(this.lEar, -0.4363323129985824F, 0.4886921905584123F, 0.2617993877991494F);
        this.lowerJaw = new ModelRenderer(this, 40, 29);
        this.lowerJaw.setRotationPoint(0.0F, 1.3F, -2.8F);
        this.lowerJaw.addBox(-1.0F, -0.5F, -2.0F, 2, 1, 2, 0.0F);
        this.upperJaw = new ModelRenderer(this, 40, 21);
        this.upperJaw.setRotationPoint(0.0F, -0.2F, -3.5F);
        this.upperJaw.addBox(-1.5F, -0.9F, -1.8F, 3, 2, 3, 0.0F);
        this.setRotateAngle(this.upperJaw, 0.22689280275926282F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 23, 23);
        this.head.setRotationPoint(0.0F, -0.2F, -1.8F);
        this.head.addBox(-2.0F, -2.0F, -3.0F, 4, 4, 3, 0.0F);
        this.setRotateAngle(this.head, 0.17453292519943295F, 0.0F, 0.0F);
        this.rEar = new ModelRenderer(this, 55, 21);
        this.rEar.mirror = true;
        this.rEar.setRotationPoint(-1.5F, -1.5F, -0.5F);
        this.rEar.addBox(-0.5F, -2.0F, -1.0F, 1, 2, 2, 0.0F);
        this.setRotateAngle(this.rEar, -0.4363323129985824F, -0.4886921905584123F, -0.2617993877991494F);
        this.stomach = new ModelRenderer(this, 0, 13);
        this.stomach.setRotationPoint(0.0F, 0.0F, -0.5F);
        this.stomach.addBox(-2.5F, -2.9F, -0.9F, 5, 6, 6, 0.0F);
        this.setRotateAngle(this.stomach, -0.2792526803190927F, 0.0F, 0.0F);
        this.rLeg02 = new ModelRenderer(this, 44, 11);
        this.rLeg02.mirror = true;
        this.rLeg02.setRotationPoint(-1.2F, 4.2F, -1.2F);
        this.rLeg02.addBox(-1.0F, 0.0F, -1.2F, 2, 4, 3, 0.0F);
        this.setRotateAngle(this.rLeg02, 0.6981317007977318F, 0.0F, 0.0F);
        this.tail02 = new ModelRenderer(this, 0, 40);
        this.tail02.setRotationPoint(0.0F, 0.0F, 1.0F);
        this.tail02.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 6, 0.0F);
        this.setRotateAngle(this.tail02, 1.0471975511965976F, 0.0F, 0.0F);
        this.lLeg01 = new ModelRenderer(this, 46, 0);
        this.lLeg01.setRotationPoint(1.6F, -0.4F, 3.7F);
        this.lLeg01.addBox(-0.3F, -0.9F, -2.5F, 3, 6, 4, 0.0F);
        this.setRotateAngle(this.lLeg01, -0.17453292519943295F, 0.0F, 0.0F);
        this.rArm02a = new ModelRenderer(this, 38, 8);
        this.rArm02a.mirror = true;
        this.rArm02a.setRotationPoint(0.41F, 3.1F, 0.5F);
        this.rArm02a.addBox(-1.3F, 0.0F, -1.0F, 1, 4, 2, 0.0F);
        this.setRotateAngle(this.rArm02a, -0.3141592653589793F, 0.0F, 0.0F);
        this.lArm02a = new ModelRenderer(this, 38, 8);
        this.lArm02a.setRotationPoint(0.39F, 3.1F, 0.5F);
        this.lArm02a.addBox(-0.4F, 0.0F, -1.0F, 1, 4, 2, 0.0F);
        this.setRotateAngle(this.lArm02a, -0.3141592653589793F, 0.0F, 0.0F);
        this.lPaw = new ModelRenderer(this, 30, 15);
        this.lPaw.setRotationPoint(-0.35F, 3.1F, 0.5F);
        this.lPaw.addBox(-1.0F, -0.3F, -3.2F, 2, 1, 4, 0.0F);
        this.setRotateAngle(this.lPaw, 0.41887902047863906F, 0.0F, 0.0F);
        this.lEarFloof = new ModelRenderer(this, 55, 23);
        this.lEarFloof.setRotationPoint(0.0F, -1.8F, 0.0F);
        this.lEarFloof.addBox(-0.2F, -3.0F, -1.5F, 0, 5, 3, 0.0F);
        this.chest = new ModelRenderer(this, 0, 0);
        this.chest.setRotationPoint(0.0F, 16.1F, 3.0F);
        this.chest.addBox(-3.0F, -2.9F, -7.5F, 6, 5, 8, 0.0F);
        this.setRotateAngle(this.chest, 0.10471975511965977F, 0.0F, 0.0F);
        this.lArm02b = new ModelRenderer(this, 31, 8);
        this.lArm02b.setRotationPoint(-1.2F, 0.0F, -1.0F);
        this.lArm02b.addBox(0.0F, 0.0F, 0.0F, 1, 4, 2, 0.0F);
        this.rEarFloof = new ModelRenderer(this, 55, 23);
        this.rEarFloof.mirror = true;
        this.rEarFloof.setRotationPoint(0.0F, -1.8F, 0.0F);
        this.rEarFloof.addBox(0.2F, -3.0F, -1.5F, 0, 5, 3, 0.0F);
        this.rFoot = new ModelRenderer(this, 50, 14);
        this.rFoot.mirror = true;
        this.rFoot.setRotationPoint(-0.2F, 4.0F, -0.1F);
        this.rFoot.addBox(-1.0F, -0.5F, -3.2F, 2, 1, 5, 0.0F);
        this.setRotateAngle(this.rFoot, -0.3490658503988659F, 0.17453292519943295F, -0.05235987755982988F);
        this.tail01 = new ModelRenderer(this, 0, 33);
        this.tail01.setRotationPoint(0.0F, -1.5F, 4.4F);
        this.tail01.addBox(-1.5F, -1.7F, -0.5F, 3, 3, 3, 0.0F);
        this.setRotateAngle(this.tail01, 1.0471975511965976F, 0.0F, 0.0F);
        this.tail04 = new ModelRenderer(this, 26, 49);
        this.tail04.setRotationPoint(0.0F, 0.0F, 5.0F);
        this.tail04.addBox(-2.51F, -2.1F, -0.6F, 5, 4, 8, 0.0F);
        this.setRotateAngle(this.tail04, -0.8726646259971648F, 0.0F, 0.0F);
        this.rArm01 = new ModelRenderer(this, 31, 0);
        this.rArm01.mirror = true;
        this.rArm01.setRotationPoint(-3.0F, 0.7F, -5.0F);
        this.rArm01.addBox(-1.0F, -1.6F, -1.0F, 2, 5, 3, 0.0F);
        this.setRotateAngle(this.rArm01, -0.20943951023931953F, 0.0F, 0.0F);
        this.rPaw = new ModelRenderer(this, 30, 15);
        this.rPaw.mirror = true;
        this.rPaw.setRotationPoint(-0.35F, 3.1F, 0.5F);
        this.rPaw.addBox(-1.0F, -0.3F, -3.2F, 2, 1, 4, 0.0F);
        this.setRotateAngle(this.rPaw, 0.41887902047863906F, 0.0F, 0.0F);
        this.tail03 = new ModelRenderer(this, 0, 50);
        this.tail03.setRotationPoint(0.0F, 0.0F, 5.4F);
        this.tail03.addBox(-2.5F, -1.9F, -0.8F, 5, 4, 7, 0.0F);
        this.setRotateAngle(this.tail03, 0.8726646259971648F, 0.0F, 0.0F);
        this.neck = new ModelRenderer(this, 0, 25);
        this.neck.setRotationPoint(0.0F, -0.8F, -6.9F);
        this.neck.addBox(-1.5F, -2.0F, -2.2F, 3, 4, 2, 0.0F);
        this.setRotateAngle(this.neck, -0.19198621771937624F, 0.0F, 0.0F);
        this.lLeg02 = new ModelRenderer(this, 44, 11);
        this.lLeg02.setRotationPoint(1.2F, 4.2F, -1.2F);
        this.lLeg02.addBox(-1.0F, 0.0F, -1.2F, 2, 4, 3, 0.0F);
        this.setRotateAngle(this.lLeg02, 0.6981317007977318F, 0.0F, 0.0F);
        this.tail02Fluff = new ModelRenderer(this, 41, 37);
        this.tail02Fluff.setRotationPoint(0.0F, 0.0F, 2.5F);
        this.tail02Fluff.addBox(-1.5F, 1.0F, -4.3F, 3, 3, 8, 0.0F);
        this.setRotateAngle(this.tail02Fluff, 0.19198621771937624F, 0.0F, 0.0F);
        this.lLeg02.addChild(this.lFoot);
        this.tail01.addChild(this.tail01Fluff);
        this.stomach.addChild(this.rLeg01);
        this.chest.addChild(this.lArm01);
        this.rArm02a.addChild(this.rArm02b);
        this.upperJaw.addChild(this.snout);
        this.head.addChild(this.lEar);
        this.head.addChild(this.lowerJaw);
        this.head.addChild(this.upperJaw);
        this.neck.addChild(this.head);
        this.head.addChild(this.rEar);
        this.chest.addChild(this.stomach);
        this.rLeg01.addChild(this.rLeg02);
        this.tail01.addChild(this.tail02);
        this.stomach.addChild(this.lLeg01);
        this.rArm01.addChild(this.rArm02a);
        this.lArm01.addChild(this.lArm02a);
        this.lArm02a.addChild(this.lPaw);
        this.lEar.addChild(this.lEarFloof);
        this.lArm02a.addChild(this.lArm02b);
        this.rEar.addChild(this.rEarFloof);
        this.rLeg02.addChild(this.rFoot);
        this.stomach.addChild(this.tail01);
        this.tail03.addChild(this.tail04);
        this.chest.addChild(this.rArm01);
        this.rArm02a.addChild(this.rPaw);
        this.tail02.addChild(this.tail03);
        this.chest.addChild(this.neck);
        this.lLeg01.addChild(this.lLeg02);
        this.tail02.addChild(this.tail02Fluff);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.chest.render(f5);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
            float headPitch, float scaleFactor, Entity entityIn) {
        float f = limbSwing;
        float f1 = limbSwingAmount;

        this.lArm01.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1 - 0.20943951023931953F;
        this.rArm01.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1 - 0.20943951023931953F;
        this.rLeg01.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1 - 0.17453292519943295F;
        this.lLeg01.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1 - 0.17453292519943295F;
        this.tail01.rotateAngleX = MathHelper.sin(f * 0.2F) * f1 - (float) Math.toRadians(30);

        if (entityIn instanceof EntityLiving) {
            this.neck.rotateAngleX = ModelBetterAnimals.getHeadPitch((EntityLiving) entityIn) * 0.017453292F - 13;
            this.neck.rotateAngleY = ModelBetterAnimals.getHeadYaw((EntityLiving) entityIn) * 0.017453292F * 0.5F;
            if (entityIn instanceof EntitySquirrel) {
                EntitySquirrel ent = (EntitySquirrel) entityIn;
                this.chest.rotateAngleX = ent.isBesideClimbableBlock() ? (float) Math.toRadians(-90)
                        : 0.10471975511965977F;
            }
        }

        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
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
