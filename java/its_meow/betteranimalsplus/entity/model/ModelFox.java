package its_meow.betteranimalsplus.entity.model;

import its_meow.betteranimalsplus.entity.EntityFox;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;

/**
 * fox - cybercat5555
 * Created using Tabula 5.1.0
 */
public class ModelFox extends ModelBetterAnimals {
    public ModelRenderer body;
    public ModelRenderer rear;
    public ModelRenderer lArm01;
    public ModelRenderer rArm01;
    public ModelRenderer neck;
    public ModelRenderer fur04;
    public ModelRenderer lHindLeg01;
    public ModelRenderer rHindLeg01;
    public ModelRenderer tail01;
    public ModelRenderer lHindLeg02;
    public ModelRenderer lHindLeg03;
    public ModelRenderer lHindpaw;
    public ModelRenderer rHindLeg02;
    public ModelRenderer rHindLeg03;
    public ModelRenderer rHindpaw;
    public ModelRenderer tail02a;
    public ModelRenderer tail02b;
    public ModelRenderer tail02c;
    public ModelRenderer tail02d;
    public ModelRenderer tail03;
    public ModelRenderer tail04;
    public ModelRenderer tail05;
    public ModelRenderer lArm01_1;
    public ModelRenderer lForepaw;
    public ModelRenderer rArm01_1;
    public ModelRenderer rForepaw;
    public ModelRenderer head;
    public ModelRenderer fur01;
    public ModelRenderer fur02;
    public ModelRenderer fur03;
    public ModelRenderer snoot;
    public ModelRenderer lowerJawA;
    public ModelRenderer upperJaw;
    public ModelRenderer lEar01;
    public ModelRenderer rEar01;
    public ModelRenderer lCheekFur01;
    public ModelRenderer rCheekFur01;
    public ModelRenderer lowerJawB;
    public ModelRenderer lEar02;
    public ModelRenderer lEar03;
    public ModelRenderer lEar04;
    public ModelRenderer rEar02;
    public ModelRenderer rEar03;
    public ModelRenderer rEar04;
    public ModelRenderer lCheekFur02;
    public ModelRenderer rCheekFur02;

    public ModelFox() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.rHindLeg01 = new ModelRenderer(this, 31, 1);
        this.rHindLeg01.mirror = true;
        this.rHindLeg01.setRotationPoint(-1.0F, 0.2F, 3.4F);
        this.rHindLeg01.addBox(-3.0F, -2.1F, -2.0F, 3, 6, 4, 0.0F);
        this.setRotateAngle(rHindLeg01, -0.18203784098300857F, 0.0F, 0.0F);
        this.lHindpaw = new ModelRenderer(this, 32, 28);
        this.lHindpaw.setRotationPoint(0.0F, 4.6F, 0.0F);
        this.lHindpaw.addBox(-1.5F, -0.5F, -2.3F, 3, 2, 3, 0.0F);
        this.lForepaw = new ModelRenderer(this, 32, 28);
        this.lForepaw.setRotationPoint(-0.0F, 6.5F, 0.0F);
        this.lForepaw.addBox(-1.5F, -0.9F, -2.3F, 3, 2, 3, 0.0F);
        this.fur01 = new ModelRenderer(this, 47, 20);
        this.fur01.setRotationPoint(0.0F, 0.7F, -1.5F);
        this.fur01.addBox(-1.5F, 0.0F, 0.0F, 3, 2, 4, 0.0F);
        this.setRotateAngle(fur01, -0.8651597102135892F, 0.0F, 0.0F);
        this.rCheekFur02 = new ModelRenderer(this, 0, 5);
        this.rCheekFur02.mirror = true;
        this.rCheekFur02.setRotationPoint(0.2F, 0.7F, -0.4F);
        this.rCheekFur02.addBox(-2.1F, -1.4F, -1.0F, 3, 3, 1, 0.0F);
        this.setRotateAngle(rCheekFur02, 0.0F, 0.045553093477052F, -0.22759093446006054F);
        this.upperJaw = new ModelRenderer(this, 34, 43);
        this.upperJaw.setRotationPoint(0.0F, 1.0F, -4.1F);
        this.upperJaw.addBox(-1.5F, -1.0F, -2.6F, 3, 1, 3, 0.0F);
        this.rHindLeg02 = new ModelRenderer(this, 32, 12);
        this.rHindLeg02.mirror = true;
        this.rHindLeg02.setRotationPoint(-1.4F, 2.6F, -0.7F);
        this.rHindLeg02.addBox(-1.5F, 0.0F, -1.5F, 3, 3, 3, 0.0F);
        this.setRotateAngle(rHindLeg02, 0.8196066167365371F, 0.0F, 0.0F);
        this.lEar02 = new ModelRenderer(this, 21, 5);
        this.lEar02.setRotationPoint(0.5F, -1.7F, 0.0F);
        this.lEar02.addBox(-0.5F, -1.0F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(lEar02, 0.0F, 0.0F, -0.40980330836826856F);
        this.rHindpaw = new ModelRenderer(this, 32, 28);
        this.rHindpaw.mirror = true;
        this.rHindpaw.setRotationPoint(0.0F, 4.6F, 0.0F);
        this.rHindpaw.addBox(-1.5F, -0.5F, -2.3F, 3, 2, 3, 0.0F);
        this.neck = new ModelRenderer(this, 0, 30);
        this.neck.setRotationPoint(0.0F, -0.9F, -4.0F);
        this.neck.addBox(-2.0F, -2.0F, -3.0F, 4, 4, 3, 0.0F);
        this.setRotateAngle(neck, -0.36425021489121656F, 0.0F, 0.0F);
        this.rArm01_1 = new ModelRenderer(this, 51, 10);
        this.rArm01_1.mirror = true;
        this.rArm01_1.setRotationPoint(-0.8F, 3.1F, 0.1F);
        this.rArm01_1.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(rArm01_1, -0.22759093446006054F, 0.0F, -0.091106186954104F);
        this.fur03 = new ModelRenderer(this, 47, 35);
        this.fur03.setRotationPoint(0.0F, -1.1F, -1.4F);
        this.fur03.addBox(-2.0F, -1.0F, 0.0F, 4, 2, 4, 0.0F);
        this.setRotateAngle(fur03, 0.6829473363053812F, 0.0F, 0.0F);
        this.lHindLeg01 = new ModelRenderer(this, 31, 1);
        this.lHindLeg01.setRotationPoint(1.0F, 0.2F, 3.4F);
        this.lHindLeg01.addBox(0.0F, -2.1F, -2.0F, 3, 6, 4, 0.0F);
        this.setRotateAngle(lHindLeg01, -0.18203784098300857F, 0.0F, 0.0F);
        this.lowerJawA = new ModelRenderer(this, 23, 48);
        this.lowerJawA.setRotationPoint(0.0F, 1.6F, -3.9F);
        this.lowerJawA.addBox(-1.2F, -0.6F, -2.6F, 2, 1, 3, 0.0F);
        this.setRotateAngle(lowerJawA, -0.091106186954104F, 0.0F, 0.0F);
        this.rCheekFur01 = new ModelRenderer(this, 0, 0);
        this.rCheekFur01.mirror = true;
        this.rCheekFur01.setRotationPoint(-1.9F, 0.0F, -0.6F);
        this.rCheekFur01.addBox(-1.4F, -1.0F, -1.0F, 2, 3, 1, 0.0F);
        this.setRotateAngle(rCheekFur01, 0.0F, 0.40980330836826856F, -0.27314402793711257F);
        this.fur02 = new ModelRenderer(this, 46, 27);
        this.fur02.setRotationPoint(0.0F, 0.5F, -0.5F);
        this.fur02.addBox(-2.0F, 0.0F, 0.0F, 4, 2, 5, 0.0F);
        this.setRotateAngle(fur02, -0.7740535232594852F, 0.0F, 0.0F);
        this.fur04 = new ModelRenderer(this, 44, 43);
        this.fur04.setRotationPoint(0.0F, -2.1F, -3.8F);
        this.fur04.addBox(-2.5F, -1.0F, 0.0F, 5, 2, 5, 0.0F);
        this.setRotateAngle(fur04, 0.22759093446006054F, 0.0F, 0.0F);
        this.tail02c = new ModelRenderer(this, 0, 45);
        this.tail02c.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail02c.addBox(-0.31F, -0.3F, 0.0F, 2, 2, 3, 0.0F);
        this.lEar03 = new ModelRenderer(this, 29, 0);
        this.lEar03.setRotationPoint(0.0F, 0.5F, 0.8F);
        this.lEar03.addBox(-0.5F, -3.7F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(lEar03, 0.22759093446006054F, 0.0F, 0.0F);
        this.lArm01 = new ModelRenderer(this, 48, 0);
        this.lArm01.setRotationPoint(1.9F, 0.1F, -2.5F);
        this.lArm01.addBox(-1.0F, -2.4F, -1.5F, 3, 6, 3, 0.0F);
        this.setRotateAngle(lArm01, 0.22759093446006054F, 0.0F, -0.091106186954104F);
        this.tail02a = new ModelRenderer(this, 0, 45);
        this.tail02a.setRotationPoint(0.0F, -0.1F, 1.6F);
        this.tail02a.addBox(-0.3F, -1.7F, 0.0F, 2, 2, 3, 0.0F);
        this.setRotateAngle(tail02a, -0.18203784098300857F, 0.0F, 0.0F);
        this.lEar04 = new ModelRenderer(this, 21, 5);
        this.lEar04.mirror = true;
        this.lEar04.setRotationPoint(-0.5F, -1.7F, 0.0F);
        this.lEar04.addBox(-0.5F, -1.0F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(lEar04, 0.0F, 0.0F, 0.40980330836826856F);
        this.tail04 = new ModelRenderer(this, 21, 53);
        this.tail04.setRotationPoint(0.0F, 0.0F, 5.6F);
        this.tail04.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 4, 0.0F);
        this.setRotateAngle(tail04, 0.136659280431156F, 0.0F, 0.0F);
        this.lHindLeg03 = new ModelRenderer(this, 34, 19);
        this.lHindLeg03.setRotationPoint(0.1F, 2.4F, 0.2F);
        this.lHindLeg03.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(lHindLeg03, -0.5462880558742251F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 17, 34);
        this.head.setRotationPoint(0.0F, -0.5F, -1.9F);
        this.head.addBox(-2.5F, -2.0F, -4.0F, 5, 4, 4, 0.0F);
        this.setRotateAngle(head, 0.36425021489121656F, 0.0F, 0.0F);
        this.rArm01 = new ModelRenderer(this, 48, 0);
        this.rArm01.mirror = true;
        this.rArm01.setRotationPoint(-1.9F, 0.1F, -2.5F);
        this.rArm01.addBox(-2.0F, -2.4F, -1.5F, 3, 6, 3, 0.0F);
        this.setRotateAngle(rArm01, 0.22759093446006054F, 0.0F, 0.091106186954104F);
        this.rEar03 = new ModelRenderer(this, 29, 0);
        this.rEar03.mirror = true;
        this.rEar03.setRotationPoint(0.0F, 0.5F, 0.8F);
        this.rEar03.addBox(-0.5F, -3.7F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(rEar03, 0.22759093446006054F, 0.0F, 0.0F);
        this.lCheekFur01 = new ModelRenderer(this, 0, 0);
        this.lCheekFur01.setRotationPoint(1.9F, 0.0F, -0.6F);
        this.lCheekFur01.addBox(-0.6F, -1.0F, -1.0F, 2, 3, 1, 0.0F);
        this.setRotateAngle(lCheekFur01, 0.0F, -0.40980330836826856F, 0.27314402793711257F);
        this.rHindLeg03 = new ModelRenderer(this, 34, 19);
        this.rHindLeg03.mirror = true;
        this.rHindLeg03.setRotationPoint(-0.1F, 2.4F, 0.2F);
        this.rHindLeg03.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(rHindLeg03, -0.5462880558742251F, 0.0F, 0.0F);
        this.rear = new ModelRenderer(this, 0, 17);
        this.rear.setRotationPoint(0.0F, -0.4F, 2.8F);
        this.rear.addBox(-2.5F, -2.5F, -0.3F, 5, 4, 6, 0.0F);
        this.setRotateAngle(rear, -0.091106186954104F, 0.0F, 0.0F);
        this.rEar02 = new ModelRenderer(this, 21, 5);
        this.rEar02.mirror = true;
        this.rEar02.setRotationPoint(-0.5F, -1.7F, 0.0F);
        this.rEar02.addBox(-0.5F, -1.0F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(rEar02, 0.0F, 0.0F, 0.40980330836826856F);
        this.tail05 = new ModelRenderer(this, 36, 53);
        this.tail05.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail05.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 6, 0.0F);
        this.setRotateAngle(tail05, 0.045553093477052F, 0.0F, 0.0F);
        this.tail01 = new ModelRenderer(this, 0, 39);
        this.tail01.setRotationPoint(0.0F, -1.1F, 4.8F);
        this.tail01.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 2, 0.0F);
        this.setRotateAngle(tail01, -0.6829473363053812F, 0.0F, 0.0F);
        this.lHindLeg02 = new ModelRenderer(this, 32, 12);
        this.lHindLeg02.setRotationPoint(1.4F, 2.6F, -0.6F);
        this.lHindLeg02.addBox(-1.5F, 0.0F, -1.5F, 3, 3, 3, 0.0F);
        this.setRotateAngle(lHindLeg02, 0.8196066167365371F, 0.0F, 0.0F);
        this.rForepaw = new ModelRenderer(this, 32, 28);
        this.rForepaw.mirror = true;
        this.rForepaw.setRotationPoint(-0.0F, 6.5F, 0.0F);
        this.rForepaw.addBox(-1.5F, -0.9F, -2.3F, 3, 2, 3, 0.0F);
        this.rEar04 = new ModelRenderer(this, 21, 5);
        this.rEar04.setRotationPoint(0.5F, -1.7F, 0.0F);
        this.rEar04.addBox(-0.5F, -1.0F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(rEar04, 0.0F, 0.0F, -0.40980330836826856F);
        this.snoot = new ModelRenderer(this, 23, 43);
        this.snoot.setRotationPoint(0.0F, 0.1F, -4.2F);
        this.snoot.addBox(-1.0F, -1.0F, -2.6F, 2, 1, 3, 0.0F);
        this.setRotateAngle(snoot, 0.22759093446006054F, 0.0F, 0.0F);
        this.tail02b = new ModelRenderer(this, 12, 45);
        this.tail02b.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail02b.addBox(-1.7F, -1.7F, 0.0F, 2, 2, 3, 0.0F);
        this.body = new ModelRenderer(this, 0, 2);
        this.body.setRotationPoint(0.0F, 14.1F, -1.7F);
        this.body.addBox(-3.0F, -3.0F, -5.0F, 6, 5, 8, 0.0F);
        this.lowerJawB = new ModelRenderer(this, 34, 48);
        this.lowerJawB.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lowerJawB.addBox(0.2F, -0.6F, -2.6F, 1, 1, 3, 0.0F);
        this.tail03 = new ModelRenderer(this, 0, 51);
        this.tail03.setRotationPoint(0.0F, 0.0F, 2.6F);
        this.tail03.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 6, 0.0F);
        this.setRotateAngle(tail03, 0.136659280431156F, 0.0F, 0.0F);
        this.lArm01_1 = new ModelRenderer(this, 51, 10);
        this.lArm01_1.setRotationPoint(0.8F, 3.1F, 0.1F);
        this.lArm01_1.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(lArm01_1, -0.22759093446006054F, 0.0F, 0.091106186954104F);
        this.tail02d = new ModelRenderer(this, 12, 45);
        this.tail02d.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail02d.addBox(-1.69F, -0.3F, 0.0F, 2, 2, 3, 0.0F);
        this.rEar01 = new ModelRenderer(this, 21, 0);
        this.rEar01.mirror = true;
        this.rEar01.setRotationPoint(-1.6F, -1.4F, -1.5F);
        this.rEar01.addBox(-1.0F, -1.9F, -0.5F, 2, 2, 1, 0.0F);
        this.setRotateAngle(rEar01, 0.0F, 0.40980330836826856F, -0.27314402793711257F);
        this.lCheekFur02 = new ModelRenderer(this, 0, 5);
        this.lCheekFur02.setRotationPoint(-0.2F, 0.7F, -0.4F);
        this.lCheekFur02.addBox(-0.9F, -1.4F, -1.0F, 3, 3, 1, 0.0F);
        this.setRotateAngle(lCheekFur02, 0.0F, -0.045553093477052F, 0.22759093446006054F);
        this.lEar01 = new ModelRenderer(this, 21, 0);
        this.lEar01.setRotationPoint(1.6F, -1.4F, -1.5F);
        this.lEar01.addBox(-1.0F, -1.9F, -0.5F, 2, 2, 1, 0.0F);
        this.setRotateAngle(lEar01, 0.0F, -0.40980330836826856F, 0.27314402793711257F);
        this.rear.addChild(this.rHindLeg01);
        this.lHindLeg03.addChild(this.lHindpaw);
        this.lArm01_1.addChild(this.lForepaw);
        this.neck.addChild(this.fur01);
        this.rCheekFur01.addChild(this.rCheekFur02);
        this.head.addChild(this.upperJaw);
        this.rHindLeg01.addChild(this.rHindLeg02);
        this.lEar01.addChild(this.lEar02);
        this.rHindLeg03.addChild(this.rHindpaw);
        this.body.addChild(this.neck);
        this.rArm01.addChild(this.rArm01_1);
        this.neck.addChild(this.fur03);
        this.rear.addChild(this.lHindLeg01);
        this.head.addChild(this.lowerJawA);
        this.head.addChild(this.rCheekFur01);
        this.neck.addChild(this.fur02);
        this.body.addChild(this.fur04);
        this.tail02a.addChild(this.tail02c);
        this.lEar01.addChild(this.lEar03);
        this.body.addChild(this.lArm01);
        this.tail01.addChild(this.tail02a);
        this.lEar01.addChild(this.lEar04);
        this.tail03.addChild(this.tail04);
        this.lHindLeg02.addChild(this.lHindLeg03);
        this.neck.addChild(this.head);
        this.body.addChild(this.rArm01);
        this.rEar01.addChild(this.rEar03);
        this.head.addChild(this.lCheekFur01);
        this.rHindLeg02.addChild(this.rHindLeg03);
        this.body.addChild(this.rear);
        this.rEar01.addChild(this.rEar02);
        this.tail04.addChild(this.tail05);
        this.rear.addChild(this.tail01);
        this.lHindLeg01.addChild(this.lHindLeg02);
        this.rArm01_1.addChild(this.rForepaw);
        this.rEar01.addChild(this.rEar04);
        this.head.addChild(this.snoot);
        this.tail02a.addChild(this.tail02b);
        this.lowerJawA.addChild(this.lowerJawB);
        this.tail02a.addChild(this.tail03);
        this.lArm01.addChild(this.lArm01_1);
        this.tail02a.addChild(this.tail02d);
        this.head.addChild(this.rEar01);
        this.lCheekFur01.addChild(this.lCheekFur02);
        this.head.addChild(this.lEar01);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.body.render(f5);
    }
    
    /**
	 * Used for easily adding entity-dependent animations. The second and third float params here are the same second
	 * and third as in the setRotationAngles method.
	 */
	public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime)
	{
		EntityFox entityfox = (EntityFox)entitylivingbaseIn;

		if (!entityfox.isTamed())
		{
			this.tail01.rotateAngleY = 0.0F;
		}
		else
		{
			this.tail01.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		}



		/*if (entityfox.isSitting())
        {
            this.neck.setRotationPoint(-1.0F, 16.0F, -3.0F);
            this.neck.rotateAngleX = ((float)Math.PI * 2F / 5F);
            this.neck.rotateAngleY = 0.0F;
            this.body.setRotationPoint(0.0F, 18.0F, 0.0F);
            this.body.rotateAngleX = ((float)Math.PI / 4F);
            this.tail01.setRotationPoint(-1.0F, 21.0F, 6.0F);
            this.lArm01.setRotationPoint(-2.5F, 22.0F, 2.0F);
            this.lArm01.rotateAngleX = ((float)Math.PI * 3F / 2F);
            this.rArm01.setRotationPoint(0.5F, 22.0F, 2.0F);
            this.rArm01.rotateAngleX = ((float)Math.PI * 3F / 2F);
            this.lHindLeg01.rotateAngleX = 5.811947F;
            this.lHindLeg01.setRotationPoint(-2.49F, 17.0F, -4.0F);
            this.rHindLeg01.rotateAngleX = 5.811947F;
            this.rHindLeg01.setRotationPoint(0.51F, 17.0F, -4.0F);
        }
        else
        {
            this.body.setRotationPoint(0.0F, 14.0F, 2.0F);
            this.body.rotateAngleX = ((float)Math.PI / 2F);
            this.neck.setRotationPoint(-1.0F, 14.0F, -3.0F);
            this.neck.rotateAngleX = this.body.rotateAngleX;
            this.tail01.setRotationPoint(-1.0F, 12.0F, 8.0F);
            this.lArm01.setRotationPoint(-2.5F, 16.0F, 7.0F);
            this.rArm01.setRotationPoint(0.5F, 16.0F, 7.0F);
            this.lHindLeg01.setRotationPoint(-2.5F, 16.0F, -4.0F);
            this.rHindLeg01.setRotationPoint(0.5F, 16.0F, -4.0F);
            this.lArm01.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
            this.rArm01.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
            this.lHindLeg01.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
            this.rHindLeg02.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        }*/



		this.head.rotateAngleZ = entityfox.getInterestedAngle(partialTickTime) + entityfox.getShakeAngle(partialTickTime, 0.0F);
		this.neck.rotateAngleZ = entityfox.getShakeAngle(partialTickTime, -0.08F);
		this.rear.rotateAngleZ = entityfox.getShakeAngle(partialTickTime, -0.16F);
		this.tail01.rotateAngleZ = entityfox.getShakeAngle(partialTickTime, -0.2F);
	}


	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
		float swingModifier = 0.9f;
		float partialTicks = Minecraft.getMinecraft().getRenderPartialTicks();
		if (entity instanceof EntityLivingBase) {
			EntityLivingBase living = (EntityLivingBase) entity;
			limbSwing = limbSwing + this.getSwingProgressPrev(living);
			//this.head.rotateAngleZ = this.head.rotateAngleY;
			lHindLeg01.rotateAngleX = MathHelper.sin(limbSwing * 0.8665F + (float) Math.PI) * swingModifier * limbSwingAmount;
			rHindLeg01.rotateAngleX = MathHelper.cos(limbSwing * 0.8665F) * swingModifier * limbSwingAmount;
			lArm01.rotateAngleX = MathHelper.sin(limbSwing * 0.8665F) * swingModifier * limbSwingAmount;
			rArm01.rotateAngleX = MathHelper.cos(limbSwing * 0.8665F + (float) Math.PI) * swingModifier * limbSwingAmount;
			this.neck.rotateAngleX = -0.6F;
		}

		this.head.rotateAngleX = (float) Math.toRadians(this.getHeadPitch((EntityLivingBase) entity)) + 0.6f;
		this.head.rotateAngleY = netHeadYaw * 0.017453292F;

		if(entity instanceof EntityFox) {
			EntityFox fox = (EntityFox) entity;
			this.tail01.rotateAngleX = ageInTicks;
			if(fox.isSitting()) {
				this.rear.rotateAngleX = -1F;
				this.tail01.rotateAngleX = 0F;
				this.body.rotateAngleX = -0.3F;
			}else {
				this.rear.rotateAngleX = 0;
				this.body.rotateAngleX = 0;
			}
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
