package its_meow.betteranimalsplus.client.model;

import its_meow.betteranimalsplus.common.entity.EntityLammergeier;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;

/**
 * lammergeier - cybercat5555 Created using Tabula 5.1.0
 */
public class ModelLammergeier<T extends LivingEntity> extends EntityModel<T> {

    public boolean isFlying = false;

    public RendererModel body;
    public RendererModel chest;
    public RendererModel tail01;
    public RendererModel lLeg01;
    public RendererModel rLeg01;
    public RendererModel lWing01;
    public RendererModel rWing01;
    public RendererModel neck;
    public RendererModel neckFeather02;
    public RendererModel head;
    public RendererModel neckFeather01;
    public RendererModel neckFeather03;
    public RendererModel upperJaw01;
    public RendererModel muzzle;
    public RendererModel lowerJaw01;
    public RendererModel headFeathers;
    public RendererModel upperJawL;
    public RendererModel upperJawR;
    public RendererModel upperJawBeak;
    public RendererModel lowerJawBeak;
    public RendererModel beard;
    public RendererModel lowerJaw02;
    public RendererModel tail02;
    public RendererModel lTailFeather01;
    public RendererModel lTailFeather02;
    public RendererModel lTailFeather03;
    public RendererModel lTailFeather04;
    public RendererModel rTailFeather01;
    public RendererModel rTailFeather02;
    public RendererModel rTailFeather03;
    public RendererModel rTailFeather04;
    public RendererModel lLeg02;
    public RendererModel lLegFeathers;
    public RendererModel lFoot;
    public RendererModel lToe01;
    public RendererModel lToe02;
    public RendererModel lToe03;
    public RendererModel lToe04;
    public RendererModel rLeg02;
    public RendererModel rLegFeathers;
    public RendererModel rFoot;
    public RendererModel rToe01;
    public RendererModel rToe02;
    public RendererModel rToe03;
    public RendererModel rToe04;
    public RendererModel lWing02;
    public RendererModel lWingFeathers01;
    public RendererModel lWingFeathers02;
    public RendererModel rWing02;
    public RendererModel rWingFeathers01;
    public RendererModel rWingFeathers02;

    public ModelLammergeier() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.rTailFeather04 = new RendererModel(this, 0, 54);
        this.rTailFeather04.mirror = true;
        this.rTailFeather04.setRotationPoint(0.0F, 0.55F, 5.2F);
        this.rTailFeather04.addBox(-1.0F, 0.0F, 0.4F, 2, 0, 8, 0.0F);
        this.setRotateAngle(this.rTailFeather04, -0.091106186954104F, -0.091106186954104F, 0.0F);
        this.beard = new RendererModel(this, 0, 0);
        this.beard.setRotationPoint(0.0F, 1.7F, 0.4F);
        this.beard.addBox(0.0F, -1.0F, -0.3F, 0, 2, 2, 0.0F);
        this.setRotateAngle(this.beard, 0.18203784098300857F, 0.0F, -0.091106186954104F);
        this.rWing02 = new RendererModel(this, 25, 30);
        this.rWing02.mirror = true;
        this.rWing02.setRotationPoint(-7.7F, 0.0F, -0.2F);
        this.rWing02.addBox(-10.0F, -0.5F, -1.0F, 10, 1, 2, 0.0F);
        this.setRotateAngle(this.rWing02, 0.0F, 0.40980330836826856F, 0.0F);
        this.lFoot = new RendererModel(this, 43, 15);
        this.lFoot.setRotationPoint(0.0F, 1.8F, 0.0F);
        this.lFoot.addBox(-1.0F, 0.0F, -1.5F, 2, 1, 3, 0.0F);
        this.setRotateAngle(this.lFoot, 0.136659280431156F, 0.0F, 0.0F);
        this.rLeg01 = new RendererModel(this, 30, 13);
        this.rLeg01.mirror = true;
        this.rLeg01.setRotationPoint(-0.5F, 0.6F, 3.2F);
        this.rLeg01.addBox(-3.0F, -0.5F, -1.5F, 3, 5, 3, 0.0F);
        this.setRotateAngle(this.rLeg01, 0.136659280431156F, 0.0F, 0.0F);
        this.lWingFeathers01 = new RendererModel(this, 5, 35);
        this.lWingFeathers01.setRotationPoint(0.0F, 0.0F, 1.2F);
        this.lWingFeathers01.addBox(-0.2F, 0.0F, -0.7F, 12, 0, 8, 0.0F);
        this.rLegFeathers = new RendererModel(this, 2, 35);
        this.rLegFeathers.mirror = true;
        this.rLegFeathers.setRotationPoint(-0.5F, 1.9F, -0.1F);
        this.rLegFeathers.addBox(-2.1F, 0.0F, 0.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(this.rLegFeathers, 0.18203784098300857F, -0.27314402793711257F, 0.0F);
        this.rToe01 = new RendererModel(this, 54, 10);
        this.rToe01.mirror = true;
        this.rToe01.setRotationPoint(-0.5F, 0.1F, -1.2F);
        this.rToe01.addBox(-0.5F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(this.rToe01, 0.136659280431156F, 0.36425021489121656F, 0.0F);
        this.chest = new RendererModel(this, 29, 0);
        this.chest.setRotationPoint(0.0F, 0.5F, -2.3F);
        this.chest.addBox(-2.5F, -2.0F, -3.0F, 5, 4, 3, 0.0F);
        this.setRotateAngle(this.chest, -0.36425021489121656F, 0.0F, 0.0F);
        this.lowerJaw02 = new RendererModel(this, 53, 26);
        this.lowerJaw02.mirror = true;
        this.lowerJaw02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lowerJaw02.addBox(-1.0F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(this.lowerJaw02, 0.0F, 0.0F, -0.18203784098300857F);
        this.lTailFeather01 = new RendererModel(this, 0, 54);
        this.lTailFeather01.setRotationPoint(1.2F, 0.7F, 2.9F);
        this.lTailFeather01.addBox(-1.0F, 0.0F, 0.4F, 2, 0, 8, 0.0F);
        this.setRotateAngle(this.lTailFeather01, -0.091106186954104F, 0.4553564018453205F, 0.0F);
        this.upperJawR = new RendererModel(this, 53, 21);
        this.upperJawR.mirror = true;
        this.upperJawR.setRotationPoint(-0.7F, -0.1F, 0.1F);
        this.upperJawR.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(this.upperJawR, 0.0F, 0.0F, -0.22759093446006054F);
        this.neck = new RendererModel(this, 48, 0);
        this.neck.setRotationPoint(0.0F, 0.4F, -1.3F);
        this.neck.addBox(-2.0F, -2.0F, -3.0F, 4, 4, 2, 0.0F);
        this.setRotateAngle(this.neck, -0.36425021489121656F, 0.0F, 0.0F);
        this.rTailFeather01 = new RendererModel(this, 0, 54);
        this.rTailFeather01.mirror = true;
        this.rTailFeather01.setRotationPoint(-1.2F, 0.7F, 2.9F);
        this.rTailFeather01.addBox(-1.0F, 0.0F, 0.4F, 2, 0, 8, 0.0F);
        this.setRotateAngle(this.rTailFeather01, -0.091106186954104F, -0.4553564018453205F, 0.0F);
        this.neckFeather01 = new RendererModel(this, 48, 45);
        this.neckFeather01.setRotationPoint(0.0F, 1.1F, -2.3F);
        this.neckFeather01.addBox(-1.5F, -1.0F, 0.0F, 3, 2, 3, 0.0F);
        this.setRotateAngle(this.neckFeather01, -0.4553564018453205F, 0.0F, 0.0F);
        this.lTailFeather04 = new RendererModel(this, 0, 54);
        this.lTailFeather04.setRotationPoint(0.0F, 0.55F, 5.2F);
        this.lTailFeather04.addBox(-1.0F, 0.0F, 0.4F, 2, 0, 8, 0.0F);
        this.setRotateAngle(this.lTailFeather04, -0.091106186954104F, 0.091106186954104F, 0.0F);
        this.rFoot = new RendererModel(this, 43, 15);
        this.rFoot.mirror = true;
        this.rFoot.setRotationPoint(0.0F, 1.8F, 0.0F);
        this.rFoot.addBox(-1.0F, 0.0F, -1.5F, 2, 1, 3, 0.0F);
        this.setRotateAngle(this.rFoot, 0.136659280431156F, 0.0F, 0.0F);
        this.lToe02 = new RendererModel(this, 54, 10);
        this.lToe02.setRotationPoint(0.0F, 0.0F, -1.3F);
        this.lToe02.addBox(-0.5F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(this.lToe02, 0.136659280431156F, 0.0F, 0.0F);
        this.rTailFeather02 = new RendererModel(this, 0, 54);
        this.rTailFeather02.mirror = true;
        this.rTailFeather02.setRotationPoint(-1.2F, 0.65F, 3.8F);
        this.rTailFeather02.addBox(-1.0F, 0.0F, 0.4F, 2, 0, 8, 0.0F);
        this.setRotateAngle(this.rTailFeather02, -0.091106186954104F, -0.31869712141416456F, 0.0F);
        this.neckFeather03 = new RendererModel(this, 17, 56);
        this.neckFeather03.setRotationPoint(0.0F, -1.3F, -1.7F);
        this.neckFeather03.addBox(-2.0F, -1.0F, 0.0F, 4, 2, 4, 0.0F);
        this.setRotateAngle(this.neckFeather03, 1.0471975511965976F, 0.0F, 0.0F);
        this.rWing01 = new RendererModel(this, 25, 24);
        this.rWing01.mirror = true;
        this.rWing01.setRotationPoint(-3.0F, -1.7F, -1.7F);
        this.rWing01.addBox(-8.0F, -0.5F, -1.5F, 8, 1, 3, 0.0F);
        this.setRotateAngle(this.rWing01, 0.22759093446006054F, 1.1838568316277536F, -0.18203784098300857F);
        this.tail02 = new RendererModel(this, 0, 25);
        this.tail02.setRotationPoint(0.0F, 1.4F, 0.0F);
        this.tail02.addBox(-2.0F, -1.0F, 0.4F, 4, 2, 5, 0.0F);
        this.setRotateAngle(this.tail02, 0.22759093446006054F, 0.0F, 0.0F);
        this.lWingFeathers02 = new RendererModel(this, 3, 44);
        this.lWingFeathers02.setRotationPoint(0.0F, 0.0F, 1.2F);
        this.lWingFeathers02.addBox(1.1F, 0.0F, -2.7F, 16, 0, 10, 0.0F);
        this.lLegFeathers = new RendererModel(this, 2, 35);
        this.lLegFeathers.setRotationPoint(0.5F, 1.9F, -0.1F);
        this.lLegFeathers.addBox(0.1F, 0.0F, 0.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(this.lLegFeathers, 0.18203784098300857F, 0.27314402793711257F, 0.0F);
        this.lToe01 = new RendererModel(this, 54, 10);
        this.lToe01.setRotationPoint(0.5F, 0.1F, -1.2F);
        this.lToe01.addBox(-0.5F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(this.lToe01, 0.136659280431156F, -0.36425021489121656F, 0.0F);
        this.tail01 = new RendererModel(this, 0, 16);
        this.tail01.setRotationPoint(0.0F, -0.5F, 4.8F);
        this.tail01.addBox(-2.5F, -1.0F, 0.4F, 5, 2, 6, 0.0F);
        this.setRotateAngle(this.tail01, -0.18203784098300857F, 0.0F, 0.0F);
        this.upperJawL = new RendererModel(this, 53, 21);
        this.upperJawL.setRotationPoint(0.7F, -0.1F, 0.1F);
        this.upperJawL.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(this.upperJawL, 0.0F, 0.0F, 0.22759093446006054F);
        this.headFeathers = new RendererModel(this, 35, 56);
        this.headFeathers.setRotationPoint(0.0F, -1.3F, -1.8F);
        this.headFeathers.addBox(-1.5F, -2.0F, -1.2F, 3, 2, 2, 0.0F);
        this.setRotateAngle(this.headFeathers, -0.136659280431156F, 0.0F, 0.0F);
        this.lToe03 = new RendererModel(this, 54, 10);
        this.lToe03.setRotationPoint(-0.6F, 0.1F, -1.2F);
        this.lToe03.addBox(-0.5F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(this.lToe03, 0.136659280431156F, 0.36425021489121656F, 0.0F);
        this.lLeg02 = new RendererModel(this, 44, 10);
        this.lLeg02.setRotationPoint(1.5F, 4.3F, 0.1F);
        this.lLeg02.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(this.lLeg02, -0.091106186954104F, 0.0F, 0.0F);
        this.head = new RendererModel(this, 48, 35);
        this.head.setRotationPoint(0.0F, 0.3F, -2.6F);
        this.head.addBox(-2.0F, -2.0F, -3.0F, 4, 4, 3, 0.0F);
        this.setRotateAngle(this.head, -0.36425021489121656F, 0.0F, 0.0F);
        this.lTailFeather03 = new RendererModel(this, 0, 54);
        this.lTailFeather03.setRotationPoint(0.2F, 0.6F, 4.5F);
        this.lTailFeather03.addBox(-1.0F, 0.0F, 0.4F, 2, 0, 8, 0.0F);
        this.setRotateAngle(this.lTailFeather03, -0.091106186954104F, 0.27314402793711257F, 0.0F);
        this.lowerJaw01 = new RendererModel(this, 53, 26);
        this.lowerJaw01.setRotationPoint(0.0F, 1.6F, -1.0F);
        this.lowerJaw01.addBox(-0.1F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(this.lowerJaw01, -0.091106186954104F, 0.0F, 0.091106186954104F);
        this.upperJawBeak = new RendererModel(this, 58, 21);
        this.upperJawBeak.setRotationPoint(0.0F, 2.6F, 0.0F);
        this.upperJawBeak.addBox(-0.5F, -0.5F, -0.2F, 1, 1, 1, 0.0F);
        this.setRotateAngle(this.upperJawBeak, -0.4553564018453205F, 0.4553564018453205F, 0.7740535232594852F);
        this.lTailFeather02 = new RendererModel(this, 0, 54);
        this.lTailFeather02.setRotationPoint(1.2F, 0.65F, 3.8F);
        this.lTailFeather02.addBox(-1.0F, 0.0F, 0.4F, 2, 0, 8, 0.0F);
        this.setRotateAngle(this.lTailFeather02, -0.091106186954104F, 0.31869712141416456F, 0.0F);
        this.muzzle = new RendererModel(this, 48, 26);
        this.muzzle.setRotationPoint(0.0F, 1.7F, -2.3F);
        this.muzzle.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(this.muzzle, 0.22759093446006054F, 0.0F, 0.0F);
        this.rToe04 = new RendererModel(this, 54, 14);
        this.rToe04.mirror = true;
        this.rToe04.setRotationPoint(0.0F, 0.0F, 1.3F);
        this.rToe04.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(this.rToe04, -0.136659280431156F, 0.0F, 0.0F);
        this.rWingFeathers02 = new RendererModel(this, 3, 44);
        this.rWingFeathers02.mirror = true;
        this.rWingFeathers02.setRotationPoint(0.0F, 0.0F, 1.2F);
        this.rWingFeathers02.addBox(-17.1F, 0.0F, -2.7F, 16, 0, 10, 0.0F);
        this.rToe03 = new RendererModel(this, 54, 10);
        this.rToe03.mirror = true;
        this.rToe03.setRotationPoint(0.5F, 0.1F, -1.2F);
        this.rToe03.addBox(-0.5F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(this.rToe03, 0.136659280431156F, -0.36425021489121656F, 0.0F);
        this.neckFeather02 = new RendererModel(this, 48, 52);
        this.neckFeather02.setRotationPoint(0.0F, 1.3F, -2.4F);
        this.neckFeather02.addBox(-2.0F, -1.0F, 0.0F, 4, 2, 3, 0.0F);
        this.setRotateAngle(this.neckFeather02, -0.5918411493512771F, 0.0F, 0.0F);
        this.upperJaw01 = new RendererModel(this, 48, 21);
        this.upperJaw01.setRotationPoint(0.0F, 1.8F, -1.6F);
        this.upperJaw01.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.lowerJawBeak = new RendererModel(this, 58, 26);
        this.lowerJawBeak.setRotationPoint(0.2F, 2.4F, 0.1F);
        this.lowerJawBeak.addBox(-0.5F, -0.5F, -1.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(this.lowerJawBeak, 0.4553564018453205F, -0.5009094953223726F, 0.6981317007977318F);
        this.lToe04 = new RendererModel(this, 54, 14);
        this.lToe04.setRotationPoint(0.0F, 0.0F, 1.3F);
        this.lToe04.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(this.lToe04, -0.136659280431156F, 0.0F, 0.0F);
        this.rTailFeather03 = new RendererModel(this, 0, 54);
        this.rTailFeather03.mirror = true;
        this.rTailFeather03.setRotationPoint(-0.2F, 0.6F, 4.5F);
        this.rTailFeather03.addBox(-1.0F, 0.0F, 0.4F, 2, 0, 8, 0.0F);
        this.setRotateAngle(this.rTailFeather03, -0.091106186954104F, -0.27314402793711257F, 0.0F);
        this.lWing02 = new RendererModel(this, 25, 30);
        this.lWing02.setRotationPoint(7.7F, 0.0F, 0.0F);
        this.lWing02.addBox(0.0F, -0.5F, -1.0F, 10, 1, 2, 0.0F);
        this.setRotateAngle(this.lWing02, 0.0F, -0.40980330836826856F, 0.0F);
        this.rToe02 = new RendererModel(this, 54, 10);
        this.rToe02.mirror = true;
        this.rToe02.setRotationPoint(0.0F, 0.0F, -1.3F);
        this.rToe02.addBox(-0.5F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(this.rToe02, 0.136659280431156F, 0.0F, 0.0F);
        this.rWingFeathers01 = new RendererModel(this, 5, 35);
        this.rWingFeathers01.mirror = true;
        this.rWingFeathers01.setRotationPoint(0.0F, 0.0F, 1.2F);
        this.rWingFeathers01.addBox(-11.8F, -0.1F, -0.7F, 12, 0, 8, 0.0F);
        this.lWing01 = new RendererModel(this, 25, 24);
        this.lWing01.setRotationPoint(3.0F, -1.7F, -1.7F);
        this.lWing01.addBox(0.0F, -0.5F, -1.5F, 8, 1, 3, 0.0F);
        this.setRotateAngle(this.lWing01, 0.22759093446006054F, -1.1838568316277536F, 0.18203784098300857F);
        this.body = new RendererModel(this, 0, 0);
        this.body.setRotationPoint(0.0F, 15.8F, -2.5F);
        this.body.addBox(-3.0F, -2.5F, -4.0F, 6, 5, 10, 0.0F);
        this.setRotateAngle(this.body, -0.22759093446006054F, 0.0F, 0.0F);
        this.rLeg02 = new RendererModel(this, 44, 10);
        this.rLeg02.mirror = true;
        this.rLeg02.setRotationPoint(-1.5F, 4.3F, 0.1F);
        this.rLeg02.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(this.rLeg02, -0.091106186954104F, 0.0F, 0.0F);
        this.lLeg01 = new RendererModel(this, 30, 13);
        this.lLeg01.setRotationPoint(0.5F, 0.6F, 3.2F);
        this.lLeg01.addBox(0.0F, -0.5F, -1.5F, 3, 5, 3, 0.0F);
        this.setRotateAngle(this.lLeg01, 0.136659280431156F, 0.0F, 0.0F);
        this.tail02.addChild(this.rTailFeather04);
        this.lowerJaw01.addChild(this.beard);
        this.rWing01.addChild(this.rWing02);
        this.lLeg02.addChild(this.lFoot);
        this.body.addChild(this.rLeg01);
        this.lWing01.addChild(this.lWingFeathers01);
        this.rLeg01.addChild(this.rLegFeathers);
        this.rFoot.addChild(this.rToe01);
        this.body.addChild(this.chest);
        this.lowerJaw01.addChild(this.lowerJaw02);
        this.tail02.addChild(this.lTailFeather01);
        this.upperJaw01.addChild(this.upperJawR);
        this.chest.addChild(this.neck);
        this.tail02.addChild(this.rTailFeather01);
        this.neck.addChild(this.neckFeather01);
        this.tail02.addChild(this.lTailFeather04);
        this.rLeg02.addChild(this.rFoot);
        this.lFoot.addChild(this.lToe02);
        this.tail02.addChild(this.rTailFeather02);
        this.neck.addChild(this.neckFeather03);
        this.body.addChild(this.rWing01);
        this.tail01.addChild(this.tail02);
        this.lWing02.addChild(this.lWingFeathers02);
        this.lLeg01.addChild(this.lLegFeathers);
        this.lFoot.addChild(this.lToe01);
        this.body.addChild(this.tail01);
        this.upperJaw01.addChild(this.upperJawL);
        this.head.addChild(this.headFeathers);
        this.lFoot.addChild(this.lToe03);
        this.lLeg01.addChild(this.lLeg02);
        this.neck.addChild(this.head);
        this.tail02.addChild(this.lTailFeather03);
        this.head.addChild(this.lowerJaw01);
        this.upperJaw01.addChild(this.upperJawBeak);
        this.tail02.addChild(this.lTailFeather02);
        this.head.addChild(this.muzzle);
        this.rFoot.addChild(this.rToe04);
        this.rWing02.addChild(this.rWingFeathers02);
        this.rFoot.addChild(this.rToe03);
        this.chest.addChild(this.neckFeather02);
        this.head.addChild(this.upperJaw01);
        this.lowerJaw01.addChild(this.lowerJawBeak);
        this.lFoot.addChild(this.lToe04);
        this.tail02.addChild(this.rTailFeather03);
        this.lWing01.addChild(this.lWing02);
        this.rFoot.addChild(this.rToe02);
        this.rWing01.addChild(this.rWingFeathers01);
        this.body.addChild(this.lWing01);
        this.rLeg01.addChild(this.rLeg02);
        this.body.addChild(this.lLeg01);
    }

    public void switchToFlight() {
        this.neckFeather02.setRotationPoint(0.0F, 1.3F, -2.4F);
        this.setRotateAngle(this.neckFeather02, -0.5918411493512771F, 0.0F, 0.0F);
        this.lTailFeather02.setRotationPoint(1.2F, 0.65F, 3.8F);
        this.setRotateAngle(this.lTailFeather02, -0.091106186954104F, 0.31869712141416456F, 0.0F);
        this.rToe02.mirror = true;
        this.rToe02.setRotationPoint(0.0F, 0.0F, -1.3F);
        this.setRotateAngle(this.rToe02, 0.136659280431156F, 0.0F, 0.0F);
        this.lToe02.setRotationPoint(0.0F, 0.0F, -1.3F);
        this.setRotateAngle(this.lToe02, 0.136659280431156F, 0.0F, 0.0F);
        this.rWingFeathers02.mirror = true;
        this.rWingFeathers02.setRotationPoint(0.0F, 0.0F, 1.2F);
        this.rTailFeather04.mirror = true;
        this.rTailFeather04.setRotationPoint(0.0F, 0.55F, 5.2F);
        this.setRotateAngle(this.rTailFeather04, -0.091106186954104F, -0.091106186954104F, 0.0F);
        this.lLegFeathers.setRotationPoint(0.5F, 1.9F, -0.1F);
        this.setRotateAngle(this.lLegFeathers, 0.18203784098300857F, 0.27314402793711257F, 0.0F);
        this.rTailFeather02.mirror = true;
        this.rTailFeather02.setRotationPoint(-1.2F, 0.65F, 3.8F);
        this.setRotateAngle(this.rTailFeather02, -0.091106186954104F, -0.31869712141416456F, 0.0F);
        this.lowerJaw01.setRotationPoint(0.0F, 1.6F, -1.0F);
        this.setRotateAngle(this.lowerJaw01, -0.091106186954104F, 0.0F, 0.091106186954104F);
        this.lWing01.setRotationPoint(3.0F, -1.7F, -1.7F);
        this.rLegFeathers.mirror = true;
        this.rLegFeathers.setRotationPoint(-0.5F, 1.9F, -0.1F);
        this.setRotateAngle(this.rLegFeathers, 0.18203784098300857F, -0.27314402793711257F, 0.0F);
        this.rWing02.mirror = true;
        this.rWing02.setRotationPoint(-7.7F, 0.0F, -0.2F);
        this.setRotateAngle(this.rWing02, 0.0F, -0.27314402793711257F, 0.0F);
        this.rTailFeather03.mirror = true;
        this.rTailFeather03.setRotationPoint(-0.2F, 0.6F, 4.5F);
        this.setRotateAngle(this.rTailFeather03, -0.091106186954104F, -0.27314402793711257F, 0.0F);
        this.rTailFeather01.mirror = true;
        this.rTailFeather01.setRotationPoint(-1.2F, 0.7F, 2.9F);
        this.setRotateAngle(this.rTailFeather01, -0.091106186954104F, -0.4553564018453205F, 0.0F);
        this.beard.setRotationPoint(0.0F, 1.7F, 0.4F);
        this.setRotateAngle(this.beard, 0.18203784098300857F, 0.0F, -0.091106186954104F);
        this.upperJawR.mirror = true;
        this.upperJawR.setRotationPoint(-0.7F, -0.1F, 0.1F);
        this.setRotateAngle(this.upperJawR, 0.0F, 0.0F, -0.22759093446006054F);
        this.rToe01.mirror = true;
        this.rToe01.setRotationPoint(-0.5F, 0.1F, -1.2F);
        this.setRotateAngle(this.rToe01, 0.136659280431156F, 0.36425021489121656F, 0.0F);
        this.lToe04.setRotationPoint(0.0F, 0.0F, 1.3F);
        this.setRotateAngle(this.lToe04, -0.136659280431156F, 0.0F, 0.0F);
        this.rLeg01.mirror = true;
        this.rLeg01.setRotationPoint(-0.5F, 0.6F, 3.2F);
        this.setRotateAngle(this.rLeg01, 1.3658946726107624F, 0.0F, 0.0F);
        this.muzzle.setRotationPoint(0.0F, 1.7F, -2.3F);
        this.setRotateAngle(this.muzzle, 0.22759093446006054F, 0.0F, 0.0F);
        this.tail01.setRotationPoint(0.0F, -0.5F, 4.8F);
        this.setRotateAngle(this.tail01, -0.18203784098300857F, 0.0F, 0.0F);
        this.rWing01.mirror = true;

        this.setRotateAngle(this.rWing01, 0, 0, 0);
        this.setRotateAngle(this.lWing01, 0, 0, 0);

        this.rWing01.setRotationPoint(-3.0F, -1.7F, -1.7F);
        this.rToe03.mirror = true;
        this.rToe03.setRotationPoint(0.5F, 0.1F, -1.2F);
        this.setRotateAngle(this.rToe03, 0.136659280431156F, -0.36425021489121656F, 0.0F);
        this.neckFeather01.setRotationPoint(0.0F, 1.1F, -2.3F);
        this.setRotateAngle(this.neckFeather01, -0.4553564018453205F, 0.0F, 0.0F);
        this.headFeathers.setRotationPoint(0.0F, -1.3F, -1.8F);
        this.setRotateAngle(this.headFeathers, -0.136659280431156F, 0.0F, 0.0F);
        this.rWingFeathers01.mirror = true;
        this.rWingFeathers01.setRotationPoint(0.0F, 0.0F, 1.2F);
        this.lowerJaw02.mirror = true;
        this.lowerJaw02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.setRotateAngle(this.lowerJaw02, 0.0F, 0.0F, -0.18203784098300857F);
        this.lowerJawBeak.setRotationPoint(0.2F, 2.4F, 0.1F);
        this.setRotateAngle(this.lowerJawBeak, 0.4553564018453205F, -0.5009094953223726F, 0.6981317007977318F);
        this.neckFeather03.setRotationPoint(0.0F, -1.3F, -1.7F);
        this.setRotateAngle(this.neckFeather03, 0.7285004297824331F, 0.0F, 0.0F);
        this.rToe04.mirror = true;
        this.rToe04.setRotationPoint(0.0F, 0.0F, 1.3F);
        this.setRotateAngle(this.rToe04, -0.136659280431156F, 0.0F, 0.0F);
        this.lTailFeather03.setRotationPoint(0.2F, 0.6F, 4.5F);
        this.setRotateAngle(this.lTailFeather03, -0.091106186954104F, 0.27314402793711257F, 0.0F);
        this.rFoot.mirror = true;
        this.rFoot.setRotationPoint(0.0F, 1.8F, 0.0F);
        this.setRotateAngle(this.rFoot, 0.136659280431156F, 0.0F, 0.0F);
        this.upperJawL.setRotationPoint(0.7F, -0.1F, 0.1F);
        this.setRotateAngle(this.upperJawL, 0.0F, 0.0F, 0.22759093446006054F);
        this.upperJaw01.setRotationPoint(0.0F, 1.8F, -1.6F);
        this.tail02.setRotationPoint(0.0F, 1.4F, 0.0F);
        this.setRotateAngle(this.tail02, 0.22759093446006054F, 0.0F, 0.0F);
        this.lToe01.setRotationPoint(0.5F, 0.1F, -1.2F);
        this.setRotateAngle(this.lToe01, 0.136659280431156F, -0.36425021489121656F, 0.0F);
        this.head.setRotationPoint(0.0F, 0.3F, -2.6F);
        this.setRotateAngle(this.head, -0.8196066167365371F, 0.0F, 0.0F);
        this.lTailFeather04.setRotationPoint(0.0F, 0.55F, 5.2F);
        this.setRotateAngle(this.lTailFeather04, -0.091106186954104F, 0.091106186954104F, 0.0F);
        this.upperJawBeak.setRotationPoint(0.0F, 2.6F, 0.0F);
        this.setRotateAngle(this.upperJawBeak, -0.4553564018453205F, 0.4553564018453205F, 0.7740535232594852F);
        this.lToe03.setRotationPoint(-0.6F, 0.1F, -1.2F);
        this.setRotateAngle(this.lToe03, 0.136659280431156F, 0.36425021489121656F, 0.0F);
        this.lLeg01.setRotationPoint(0.5F, 0.6F, 3.2F);
        this.setRotateAngle(this.lLeg01, 1.3658946726107624F, 0.0F, 0.0F);
        this.rLeg02.mirror = true;
        this.rLeg02.setRotationPoint(-1.5F, 4.3F, 0.1F);
        this.setRotateAngle(this.rLeg02, -1.593485607070823F, 0.0F, 0.0F);
        this.lWingFeathers01.setRotationPoint(0.0F, 0.0F, 1.2F);
        this.lTailFeather01.setRotationPoint(1.2F, 0.7F, 2.9F);
        this.setRotateAngle(this.lTailFeather01, -0.091106186954104F, 0.4553564018453205F, 0.0F);
        this.lLeg02.setRotationPoint(1.5F, 4.3F, 0.1F);
        this.setRotateAngle(this.lLeg02, -1.593485607070823F, 0.0F, 0.0F);
        this.lFoot.setRotationPoint(0.0F, 1.8F, 0.0F);
        this.setRotateAngle(this.lFoot, 0.136659280431156F, 0.0F, 0.0F);
        this.body.setRotationPoint(0.0F, 15.8F, -2.5F);
        this.setRotateAngle(this.body, 0.045553093477052F, 0.0F, 0.0F);
        this.neck.setRotationPoint(0.0F, 0.4F, -1.3F);
        this.setRotateAngle(this.neck, -0.045553093477052F, 0.0F, 0.0F);
        this.lWing02.setRotationPoint(7.7F, 0.0F, 0.0F);
        this.setRotateAngle(this.lWing02, 0.0F, 0.27314402793711257F, 0.0F);
        this.chest.setRotationPoint(0.0F, 0.5F, -2.3F);
        this.setRotateAngle(this.chest, -0.091106186954104F, 0.0F, 0.0F);
        this.lWingFeathers02.setRotationPoint(0.0F, 0.0F, 1.2F);
    }

    public void switchToWalk() {
        this.rTailFeather04.mirror = true;
        this.rTailFeather04.setRotationPoint(0.0F, 0.55F, 5.2F);
        this.setRotateAngle(this.rTailFeather04, -0.091106186954104F, -0.091106186954104F, 0.0F);
        this.beard.setRotationPoint(0.0F, 1.7F, 0.4F);
        this.setRotateAngle(this.beard, 0.18203784098300857F, 0.0F, -0.091106186954104F);
        this.rWing02.mirror = true;
        this.rWing02.setRotationPoint(-7.7F, 0.0F, -0.2F);
        this.setRotateAngle(this.rWing02, 0.0F, 0.40980330836826856F, 0.0F);
        this.lFoot.setRotationPoint(0.0F, 1.8F, 0.0F);
        this.setRotateAngle(this.lFoot, 0.136659280431156F, 0.0F, 0.0F);
        this.rLeg01.mirror = true;
        this.rLeg01.setRotationPoint(-0.5F, 0.6F, 3.2F);
        this.setRotateAngle(this.rLeg01, 0.136659280431156F, 0.0F, 0.0F);
        this.lWingFeathers01.setRotationPoint(0.0F, 0.0F, 1.2F);
        this.rLegFeathers.mirror = true;
        this.rLegFeathers.setRotationPoint(-0.5F, 1.9F, -0.1F);
        this.setRotateAngle(this.rLegFeathers, 0.18203784098300857F, -0.27314402793711257F, 0.0F);
        this.rToe01.mirror = true;
        this.rToe01.setRotationPoint(-0.5F, 0.1F, -1.2F);
        this.setRotateAngle(this.rToe01, 0.136659280431156F, 0.36425021489121656F, 0.0F);
        this.chest.setRotationPoint(0.0F, 0.5F, -2.3F);
        this.setRotateAngle(this.chest, -0.36425021489121656F, 0.0F, 0.0F);
        this.lowerJaw02.mirror = true;
        this.lowerJaw02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.setRotateAngle(this.lowerJaw02, 0.0F, 0.0F, -0.18203784098300857F);
        this.lTailFeather01.setRotationPoint(1.2F, 0.7F, 2.9F);
        this.setRotateAngle(this.lTailFeather01, -0.091106186954104F, 0.4553564018453205F, 0.0F);
        this.upperJawR.mirror = true;
        this.upperJawR.setRotationPoint(-0.7F, -0.1F, 0.1F);
        this.setRotateAngle(this.upperJawR, 0.0F, 0.0F, -0.22759093446006054F);
        this.neck.setRotationPoint(0.0F, 0.4F, -1.3F);
        this.setRotateAngle(this.neck, -0.36425021489121656F, 0.0F, 0.0F);
        this.rTailFeather01.mirror = true;
        this.rTailFeather01.setRotationPoint(-1.2F, 0.7F, 2.9F);
        this.setRotateAngle(this.rTailFeather01, -0.091106186954104F, -0.4553564018453205F, 0.0F);
        this.neckFeather01.setRotationPoint(0.0F, 1.1F, -2.3F);
        this.setRotateAngle(this.neckFeather01, -0.4553564018453205F, 0.0F, 0.0F);
        this.lTailFeather04.setRotationPoint(0.0F, 0.55F, 5.2F);
        this.setRotateAngle(this.lTailFeather04, -0.091106186954104F, 0.091106186954104F, 0.0F);
        this.rFoot.mirror = true;
        this.rFoot.setRotationPoint(0.0F, 1.8F, 0.0F);
        this.setRotateAngle(this.rFoot, 0.136659280431156F, 0.0F, 0.0F);
        this.lToe02.setRotationPoint(0.0F, 0.0F, -1.3F);
        this.setRotateAngle(this.lToe02, 0.136659280431156F, 0.0F, 0.0F);
        this.rTailFeather02.mirror = true;
        this.rTailFeather02.setRotationPoint(-1.2F, 0.65F, 3.8F);
        this.setRotateAngle(this.rTailFeather02, -0.091106186954104F, -0.31869712141416456F, 0.0F);
        this.neckFeather03.setRotationPoint(0.0F, -1.3F, -1.7F);
        this.setRotateAngle(this.neckFeather03, 1.0471975511965976F, 0.0F, 0.0F);
        this.rWing01.mirror = true;
        this.rWing01.setRotationPoint(-3.0F, -1.7F, -1.7F);
        this.setRotateAngle(this.rWing01, 0.22759093446006054F, 1.1838568316277536F, -0.18203784098300857F);
        this.tail02.setRotationPoint(0.0F, 1.4F, 0.0F);
        this.setRotateAngle(this.tail02, 0.22759093446006054F, 0.0F, 0.0F);
        this.lWingFeathers02.setRotationPoint(0.0F, 0.0F, 1.2F);
        this.lLegFeathers.setRotationPoint(0.5F, 1.9F, -0.1F);
        this.setRotateAngle(this.lLegFeathers, 0.18203784098300857F, 0.27314402793711257F, 0.0F);
        this.lToe01.setRotationPoint(0.5F, 0.1F, -1.2F);
        this.setRotateAngle(this.lToe01, 0.136659280431156F, -0.36425021489121656F, 0.0F);
        this.tail01.setRotationPoint(0.0F, -0.5F, 4.8F);
        this.setRotateAngle(this.tail01, -0.18203784098300857F, 0.0F, 0.0F);
        this.upperJawL.setRotationPoint(0.7F, -0.1F, 0.1F);
        this.setRotateAngle(this.upperJawL, 0.0F, 0.0F, 0.22759093446006054F);
        this.headFeathers.setRotationPoint(0.0F, -1.3F, -1.8F);
        this.setRotateAngle(this.headFeathers, -0.136659280431156F, 0.0F, 0.0F);
        this.lToe03.setRotationPoint(-0.6F, 0.1F, -1.2F);
        this.setRotateAngle(this.lToe03, 0.136659280431156F, 0.36425021489121656F, 0.0F);
        this.lLeg02.setRotationPoint(1.5F, 4.3F, 0.1F);
        this.setRotateAngle(this.lLeg02, -0.091106186954104F, 0.0F, 0.0F);
        this.head.setRotationPoint(0.0F, 0.3F, -2.6F);
        this.setRotateAngle(this.head, -0.36425021489121656F, 0.0F, 0.0F);
        this.lTailFeather03.setRotationPoint(0.2F, 0.6F, 4.5F);
        this.setRotateAngle(this.lTailFeather03, -0.091106186954104F, 0.27314402793711257F, 0.0F);
        this.lowerJaw01.setRotationPoint(0.0F, 1.6F, -1.0F);
        this.setRotateAngle(this.lowerJaw01, -0.091106186954104F, 0.0F, 0.091106186954104F);
        this.upperJawBeak.setRotationPoint(0.0F, 2.6F, 0.0F);
        this.setRotateAngle(this.upperJawBeak, -0.4553564018453205F, 0.4553564018453205F, 0.7740535232594852F);
        this.lTailFeather02.setRotationPoint(1.2F, 0.65F, 3.8F);
        this.setRotateAngle(this.lTailFeather02, -0.091106186954104F, 0.31869712141416456F, 0.0F);
        this.muzzle.setRotationPoint(0.0F, 1.7F, -2.3F);
        this.setRotateAngle(this.muzzle, 0.22759093446006054F, 0.0F, 0.0F);
        this.rToe04.mirror = true;
        this.rToe04.setRotationPoint(0.0F, 0.0F, 1.3F);
        this.setRotateAngle(this.rToe04, -0.136659280431156F, 0.0F, 0.0F);
        this.rWingFeathers02.mirror = true;
        this.rWingFeathers02.setRotationPoint(0.0F, 0.0F, 1.2F);
        this.rToe03.mirror = true;
        this.rToe03.setRotationPoint(0.5F, 0.1F, -1.2F);
        this.setRotateAngle(this.rToe03, 0.136659280431156F, -0.36425021489121656F, 0.0F);
        this.neckFeather02.setRotationPoint(0.0F, 1.3F, -2.4F);
        this.setRotateAngle(this.neckFeather02, -0.5918411493512771F, 0.0F, 0.0F);
        this.upperJaw01.setRotationPoint(0.0F, 1.8F, -1.6F);
        this.lowerJawBeak.setRotationPoint(0.2F, 2.4F, 0.1F);
        this.setRotateAngle(this.lowerJawBeak, 0.4553564018453205F, -0.5009094953223726F, 0.6981317007977318F);
        this.lToe04.setRotationPoint(0.0F, 0.0F, 1.3F);
        this.setRotateAngle(this.lToe04, -0.136659280431156F, 0.0F, 0.0F);
        this.rTailFeather03.mirror = true;
        this.rTailFeather03.setRotationPoint(-0.2F, 0.6F, 4.5F);
        this.setRotateAngle(this.rTailFeather03, -0.091106186954104F, -0.27314402793711257F, 0.0F);
        this.lWing02.setRotationPoint(7.7F, 0.0F, 0.0F);
        this.setRotateAngle(this.lWing02, 0.0F, -0.40980330836826856F, 0.0F);
        this.rToe02.mirror = true;
        this.rToe02.setRotationPoint(0.0F, 0.0F, -1.3F);
        this.setRotateAngle(this.rToe02, 0.136659280431156F, 0.0F, 0.0F);
        this.rWingFeathers01.mirror = true;
        this.rWingFeathers01.setRotationPoint(0.0F, 0.0F, 1.2F);
        this.lWing01.setRotationPoint(3.0F, -1.7F, -1.7F);
        this.setRotateAngle(this.lWing01, 0.22759093446006054F, -1.1838568316277536F, 0.18203784098300857F);
        this.body.setRotationPoint(0.0F, 15.8F, -2.5F);
        this.setRotateAngle(this.body, -0.22759093446006054F, 0.0F, 0.0F);
        this.rLeg02.mirror = true;
        this.rLeg02.setRotationPoint(-1.5F, 4.3F, 0.1F);
        this.setRotateAngle(this.rLeg02, -0.091106186954104F, 0.0F, 0.0F);
        this.lLeg01.setRotationPoint(0.5F, 0.6F, 3.2F);
        this.setRotateAngle(this.lLeg01, 0.136659280431156F, 0.0F, 0.0F);
    }

    @Override
    public void render(T entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.body.render(f5);
    }

    boolean lastFlying = false;

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
            float headPitch, float scaleFactor) {

        EntityLammergeier lammergeier = (EntityLammergeier) entityIn;
        this.rLeg01.offsetY = 0.0F;
        this.lLeg01.offsetY = 0.0F;
        this.isFlying = !entityIn.getEntityWorld().getBlockState(entityIn.getPosition().down()).isSolid();

        if (this.isFlying) {
            this.rWing01.rotateAngleZ = MathHelper.cos(ageInTicks * 0.3F) * (float) Math.PI * 0.25F;

            if ((Math.abs(lammergeier.getMotion().getY()) > 0
                    && (Math.abs(lammergeier.getMotion().getX()) > 0.05 || Math.abs(lammergeier.getMotion().getZ()) > 0.05))
                    || Math.abs(lammergeier.getMotion().getY()) > 0.25) {
                float rotX = -((float) Math.atan(lammergeier.getMotion().getY()
                        / Math.sqrt(Math.pow(lammergeier.getMotion().getX(), 2) + Math.pow(lammergeier.getMotion().getZ(), 2))) / 1.5F);
                if (rotX < 0) {
                    rotX /= 3;
                }
                if (Math.abs(lammergeier.getMotion().getY() + lammergeier.lastMotionY) > 0.05 && lammergeier.getMotion().getY() < 0) {
                    this.rWing01.rotateAngleZ = MathHelper.cos(225 * 0.3F) * (float) Math.PI * 0.25F;
                }
                this.body.rotateAngleX = rotX;
            } else {
                this.body.rotateAngleX = 0;
            }
            this.lWing01.rotateAngleZ = -this.rWing01.rotateAngleZ;
            this.rWing02.rotateAngleZ = this.rWing01.rotateAngleZ * 0.5F;
            this.lWing02.rotateAngleZ = -this.rWing01.rotateAngleZ * 0.5F;
            if (this.lastFlying == false) {
                this.switchToFlight();
            }
        } else {
            if (this.lastFlying == true) {
                this.switchToWalk();
            }
            boolean flag = entityIn instanceof LivingEntity
                    && ((LivingEntity) entityIn).getTicksElytraFlying() > 4;
            float f = 1.0F;

            if (flag) {
                f = (float) (entityIn.getMotion().getX() * entityIn.getMotion().getX() + entityIn.getMotion().getY() * entityIn.getMotion().getY()
                        + entityIn.getMotion().getZ() * entityIn.getMotion().getZ());
                f = f / 0.2F;
                f = f * f * f;
            }

            if (f < 1.0F) {
                f = 1.0F;
            }

            this.rLeg01.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
            this.lLeg01.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount
                    / f;

        }

        if (lammergeier.isSitting()) {
            this.head.rotateAngleX = 0;
        } else {
            this.head.rotateAngleX = -0.81F;
        }

        this.lastFlying = this.isFlying;
        super.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(RendererModel modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
