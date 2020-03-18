package its_meow.betteranimalsplus.client.model;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * goose - cybercat5555
 * Created using Tabula 7.0.1
 */
public class ModelGoose extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer rear;
    public ModelRenderer lowerRear;
    public ModelRenderer neck00;
    public ModelRenderer lLeg01;
    public ModelRenderer rLeg01;
    public ModelRenderer lWing01;
    public ModelRenderer rWing01;
    public ModelRenderer lTailFeather01;
    public ModelRenderer rTailFeather01;
    public ModelRenderer lTailFeather02;
    public ModelRenderer rTailFeather02;
    public ModelRenderer lTailFeather03;
    public ModelRenderer rTailFeather03;
    public ModelRenderer neck01;
    public ModelRenderer neck02;
    public ModelRenderer neck03;
    public ModelRenderer head;
    public ModelRenderer billUpper;
    public ModelRenderer billLower;
    public ModelRenderer lLeg02;
    public ModelRenderer lClaw01;
    public ModelRenderer lClaw02;
    public ModelRenderer lClaw03;
    public ModelRenderer lClaw04;
    public ModelRenderer rLeg02;
    public ModelRenderer rClaw01;
    public ModelRenderer rClaw02;
    public ModelRenderer rClaw03;
    public ModelRenderer rClaw04;
    public ModelRenderer lWing02;
    public ModelRenderer lWingFeathers01;
    public ModelRenderer lWingFeathers02;
    public ModelRenderer rWing02;
    public ModelRenderer rWingFeathers01;
    public ModelRenderer rWingFeathers02;

    public ModelGoose() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.lWingFeathers02 = new ModelRenderer(this, 18, 33);
        this.lWingFeathers02.setRotationPoint(0.0F, 0.0F, 1.2F);
        this.lWingFeathers02.addBox(1.1F, 0.01F, -2.7F, 13, 0, 10, 0.0F);
        this.setRotateAngle(lWingFeathers02, 0.0F, 0.12217304763960307F, -0.20943951023931953F);
        this.rClaw03 = new ModelRenderer(this, 0, 0);
        this.rClaw03.mirror = true;
        this.rClaw03.setRotationPoint(-0.5F, 4.3F, -0.7F);
        this.rClaw03.addBox(-0.9F, 0.0F, -3.0F, 2, 0, 4, 0.0F);
        this.setRotateAngle(rClaw03, 0.0F, 0.3490658503988659F, -0.03490658503988659F);
        this.rTailFeather03 = new ModelRenderer(this, -3, 19);
        this.rTailFeather03.mirror = true;
        this.rTailFeather03.setRotationPoint(-2.1F, 0.0F, 4.2F);
        this.rTailFeather03.addBox(-1.0F, -0.01F, 0.0F, 2, 0, 5, 0.0F);
        this.setRotateAngle(rTailFeather03, 0.0F, -0.24434609527920614F, 0.0F);
        this.lWing02 = new ModelRenderer(this, 45, 19);
        this.lWing02.setRotationPoint(7.7F, 0.0F, 0.0F);
        this.lWing02.addBox(0.0F, -0.5F, -1.0F, 6, 1, 2, 0.0F);
        this.setRotateAngle(lWing02, 0.0F, -0.5235987755982988F, 0.0F);
        this.rWingFeathers01 = new ModelRenderer(this, 21, 24);
        this.rWingFeathers01.mirror = true;
        this.rWingFeathers01.setRotationPoint(0.0F, 0.0F, 1.2F);
        this.rWingFeathers01.addBox(-11.8F, 0.0F, -0.7F, 12, 0, 8, 0.0F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0.0F, 15.3F, 0.0F);
        this.body.addBox(-4.0F, -4.0F, -5.0F, 8, 7, 10, 0.0F);
        this.lWing01 = new ModelRenderer(this, 22, 18);
        this.lWing01.setRotationPoint(3.0F, -2.8F, -4.0F);
        this.lWing01.addBox(0.0F, -0.5F, -1.5F, 8, 1, 3, 0.0F);
        this.setRotateAngle(lWing01, 0.0F, -1.3089969389957472F, 0.0F);
        this.rClaw02 = new ModelRenderer(this, 0, 0);
        this.rClaw02.setRotationPoint(0.5F, 4.3F, -0.7F);
        this.rClaw02.addBox(-1.1F, 0.0F, -3.0F, 2, 0, 4, 0.0F);
        this.setRotateAngle(rClaw02, 0.0F, -0.3490658503988659F, 0.03490658503988659F);
        this.lWingFeathers01 = new ModelRenderer(this, 21, 24);
        this.lWingFeathers01.setRotationPoint(0.0F, 0.0F, 1.2F);
        this.lWingFeathers01.addBox(-0.2F, 0.0F, -0.7F, 12, 0, 8, 0.0F);
        this.rClaw04 = new ModelRenderer(this, 0, 5);
        this.rClaw04.mirror = true;
        this.rClaw04.setRotationPoint(0.0F, 3.2F, 0.0F);
        this.rClaw04.addBox(-0.1F, -0.5F, 0.6F, 0, 1, 2, 0.0F);
        this.setRotateAngle(rClaw04, -0.3490658503988659F, 0.0F, 0.0F);
        this.rClaw01 = new ModelRenderer(this, 2, 5);
        this.rClaw01.setRotationPoint(0.0F, 4.6F, -0.4F);
        this.rClaw01.addBox(-0.5F, -0.5F, -3.7F, 1, 0, 4, 0.0F);
        this.setRotateAngle(rClaw01, 0.06981317007977318F, 0.0F, 0.0F);
        this.lLeg01 = new ModelRenderer(this, 38, 9);
        this.lLeg01.setRotationPoint(2.4F, 3.3F, 1.5F);
        this.lLeg01.addBox(-1.0F, -0.7F, -1.5F, 2, 2, 3, 0.0F);
        this.setRotateAngle(lLeg01, 0.20943951023931953F, 0.0F, 0.0F);
        this.rWing01 = new ModelRenderer(this, 22, 18);
        this.rWing01.mirror = true;
        this.rWing01.setRotationPoint(-3.0F, -2.8F, -4.0F);
        this.rWing01.addBox(-8.0F, -0.5F, -1.5F, 8, 1, 3, 0.0F);
        this.setRotateAngle(rWing01, 0.0F, 1.3089969389957472F, 0.0F);
        this.lTailFeather01 = new ModelRenderer(this, -3, 19);
        this.lTailFeather01.setRotationPoint(0.9F, -0.2F, 5.4F);
        this.lTailFeather01.addBox(-1.0F, 0.0F, 0.0F, 2, 0, 5, 0.0F);
        this.setRotateAngle(lTailFeather01, 0.0F, 0.03490658503988659F, 0.0F);
        this.lTailFeather03 = new ModelRenderer(this, -3, 19);
        this.lTailFeather03.setRotationPoint(2.1F, 0.0F, 4.2F);
        this.lTailFeather03.addBox(-1.0F, -0.01F, 0.0F, 2, 0, 5, 0.0F);
        this.setRotateAngle(lTailFeather03, 0.0F, 0.24434609527920614F, 0.0F);
        this.rear = new ModelRenderer(this, 0, 20);
        this.rear.setRotationPoint(0.0F, -1.8F, 4.7F);
        this.rear.addBox(-3.5F, -2.0F, 0.0F, 7, 2, 6, 0.0F);
        this.lLeg02 = new ModelRenderer(this, 49, 8);
        this.lLeg02.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.lLeg02.addBox(-0.5F, -0.4F, -1.0F, 1, 5, 2, 0.0F);
        this.setRotateAngle(lLeg02, -0.20943951023931953F, 0.0F, 0.0F);
        this.neck01 = new ModelRenderer(this, 0, 53);
        this.neck01.setRotationPoint(0.0F, 0.4F, -2.1F);
        this.neck01.addBox(-1.5F, -1.5F, -3.0F, 3, 3, 3, 0.0F);
        this.setRotateAngle(neck01, -0.5235987755982988F, 0.0F, 0.0F);
        this.lClaw01 = new ModelRenderer(this, 2, 5);
        this.lClaw01.setRotationPoint(0.0F, 4.6F, -0.4F);
        this.lClaw01.addBox(-0.5F, -0.5F, -3.7F, 1, 0, 4, 0.0F);
        this.setRotateAngle(lClaw01, 0.06981317007977318F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 31, 0);
        this.head.setRotationPoint(0.0F, 0.2F, -2.7F);
        this.head.addBox(-1.5F, -1.0F, -1.5F, 3, 3, 3, 0.0F);
        this.setRotateAngle(head, -0.20943951023931953F, 0.0F, 0.0F);
        this.rTailFeather02 = new ModelRenderer(this, -3, 19);
        this.rTailFeather02.mirror = true;
        this.rTailFeather02.setRotationPoint(-1.5F, -0.1F, 5.0F);
        this.rTailFeather02.addBox(-1.0F, 0.0F, 0.0F, 2, 0, 5, 0.0F);
        this.setRotateAngle(rTailFeather02, 0.0F, -0.17453292519943295F, 0.0F);
        this.neck02 = new ModelRenderer(this, 16, 55);
        this.neck02.setRotationPoint(0.0F, 0.1F, -2.5F);
        this.neck02.addBox(-1.0F, -1.0F, -4.0F, 2, 2, 4, 0.0F);
        this.setRotateAngle(neck02, -0.3490658503988659F, 0.0F, 0.0F);
        this.neck00 = new ModelRenderer(this, 0, 43);
        this.neck00.setRotationPoint(0.0F, -0.6F, -4.4F);
        this.neck00.addBox(-2.0F, -2.0F, -3.0F, 4, 4, 4, 0.0F);
        this.setRotateAngle(neck00, -0.6981317007977318F, 0.0F, 0.0F);
        this.billUpper = new ModelRenderer(this, 45, 0);
        this.billUpper.setRotationPoint(0.0F, 1.6F, -0.2F);
        this.billUpper.addBox(-1.0F, 0.0F, -0.5F, 2, 3, 1, 0.0F);
        this.setRotateAngle(billUpper, 0.15707963267948966F, 0.0F, 0.0F);
        this.lowerRear = new ModelRenderer(this, 0, 31);
        this.lowerRear.setRotationPoint(0.0F, 0.2F, 4.6F);
        this.lowerRear.addBox(-3.0F, -2.0F, 0.0F, 6, 4, 6, 0.0F);
        this.setRotateAngle(lowerRear, 0.17453292519943295F, 0.0F, 0.0F);
        this.rLeg01 = new ModelRenderer(this, 38, 9);
        this.rLeg01.mirror = true;
        this.rLeg01.setRotationPoint(-2.4F, 3.3F, 1.5F);
        this.rLeg01.addBox(-1.0F, -0.7F, -1.5F, 2, 2, 3, 0.0F);
        this.setRotateAngle(rLeg01, 0.20943951023931953F, 0.0F, 0.0F);
        this.lClaw02 = new ModelRenderer(this, 0, 0);
        this.lClaw02.setRotationPoint(0.5F, 4.3F, -0.7F);
        this.lClaw02.addBox(-1.1F, 0.0F, -3.0F, 2, 0, 4, 0.0F);
        this.setRotateAngle(lClaw02, 0.0F, -0.3490658503988659F, 0.03490658503988659F);
        this.lClaw04 = new ModelRenderer(this, 0, 5);
        this.lClaw04.setRotationPoint(0.0F, 3.2F, 0.0F);
        this.lClaw04.addBox(0.1F, -0.5F, 0.5F, 0, 1, 2, 0.0F);
        this.setRotateAngle(lClaw04, -0.3490658503988659F, 0.0F, 0.0F);
        this.neck03 = new ModelRenderer(this, 17, 56);
        this.neck03.setRotationPoint(0.0F, -0.05F, -3.8F);
        this.neck03.addBox(-1.0F, -0.95F, -2.9F, 2, 2, 3, 0.0F);
        this.setRotateAngle(neck03, 0.22689280275926282F, 0.0F, 0.0F);
        this.rTailFeather01 = new ModelRenderer(this, -3, 19);
        this.rTailFeather01.mirror = true;
        this.rTailFeather01.setRotationPoint(-0.9F, -0.2F, 5.4F);
        this.rTailFeather01.addBox(-1.0F, 0.0F, 0.0F, 2, 0, 5, 0.0F);
        this.setRotateAngle(rTailFeather01, 0.0F, -0.03490658503988659F, 0.0F);
        this.billLower = new ModelRenderer(this, 45, 0);
        this.billLower.setRotationPoint(0.0F, 1.5F, 0.6F);
        this.billLower.addBox(-1.0F, 0.0F, -0.5F, 2, 3, 1, 0.0F);
        this.lTailFeather02 = new ModelRenderer(this, -3, 19);
        this.lTailFeather02.setRotationPoint(1.5F, -0.1F, 5.0F);
        this.lTailFeather02.addBox(-1.0F, 0.0F, 0.0F, 2, 0, 5, 0.0F);
        this.setRotateAngle(lTailFeather02, 0.0F, 0.17453292519943295F, 0.0F);
        this.rLeg02 = new ModelRenderer(this, 49, 8);
        this.rLeg02.mirror = true;
        this.rLeg02.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.rLeg02.addBox(-0.5F, -0.4F, -1.0F, 1, 5, 2, 0.0F);
        this.setRotateAngle(rLeg02, -0.20943951023931953F, 0.0F, 0.0F);
        this.rWingFeathers02 = new ModelRenderer(this, 18, 33);
        this.rWingFeathers02.mirror = true;
        this.rWingFeathers02.setRotationPoint(0.0F, 0.0F, 1.2F);
        this.rWingFeathers02.addBox(-14.1F, 0.01F, -2.7F, 13, 0, 10, 0.0F);
        this.setRotateAngle(rWingFeathers02, 0.0F, -0.12217304763960307F, 0.20943951023931953F);
        this.lClaw03 = new ModelRenderer(this, 0, 0);
        this.lClaw03.mirror = true;
        this.lClaw03.setRotationPoint(-0.5F, 4.3F, -0.7F);
        this.lClaw03.addBox(-0.9F, 0.0F, -3.0F, 2, 0, 4, 0.0F);
        this.setRotateAngle(lClaw03, 0.0F, 0.3490658503988659F, -0.03490658503988659F);
        this.rWing02 = new ModelRenderer(this, 45, 19);
        this.rWing02.mirror = true;
        this.rWing02.setRotationPoint(-7.7F, 0.0F, 0.0F);
        this.rWing02.addBox(-6.0F, -0.5F, -1.0F, 6, 1, 2, 0.0F);
        this.setRotateAngle(rWing02, 0.0F, 0.5235987755982988F, 0.0F);
        this.lWing02.addChild(this.lWingFeathers02);
        this.rLeg02.addChild(this.rClaw03);
        this.rear.addChild(this.rTailFeather03);
        this.lWing01.addChild(this.lWing02);
        this.rWing01.addChild(this.rWingFeathers01);
        this.body.addChild(this.lWing01);
        this.rLeg02.addChild(this.rClaw02);
        this.lWing01.addChild(this.lWingFeathers01);
        this.rLeg02.addChild(this.rClaw04);
        this.rLeg02.addChild(this.rClaw01);
        this.body.addChild(this.lLeg01);
        this.body.addChild(this.rWing01);
        this.rear.addChild(this.lTailFeather01);
        this.rear.addChild(this.lTailFeather03);
        this.body.addChild(this.rear);
        this.lLeg01.addChild(this.lLeg02);
        this.neck00.addChild(this.neck01);
        this.lLeg02.addChild(this.lClaw01);
        this.neck03.addChild(this.head);
        this.rear.addChild(this.rTailFeather02);
        this.neck01.addChild(this.neck02);
        this.body.addChild(this.neck00);
        this.head.addChild(this.billUpper);
        this.body.addChild(this.lowerRear);
        this.body.addChild(this.rLeg01);
        this.lLeg02.addChild(this.lClaw02);
        this.lLeg02.addChild(this.lClaw04);
        this.neck02.addChild(this.neck03);
        this.rear.addChild(this.rTailFeather01);
        this.head.addChild(this.billLower);
        this.rear.addChild(this.lTailFeather02);
        this.rLeg01.addChild(this.rLeg02);
        this.rWing02.addChild(this.rWingFeathers02);
        this.lLeg02.addChild(this.lClaw03);
        this.rWing01.addChild(this.rWing02);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.body.render(f5);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.neck01.rotateAngleX = headPitch * 0.017453292F - 0.5235987755982988F;
        this.head.rotateAngleZ = netHeadYaw * 0.017453292F;
        if(!entityIn.isInWater()) {
            this.rLeg01.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount + 0.20943951023931953F;
            this.lLeg01.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount + 0.20943951023931953F;
            this.lLeg01.showModel = true;
            this.rLeg01.showModel = true;
        } else {
            this.lLeg01.showModel = false;
            this.rLeg01.showModel = false;
        }
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer ModelRenderer, float x, float y, float z) {
        ModelRenderer.rotateAngleX = x;
        ModelRenderer.rotateAngleY = y;
        ModelRenderer.rotateAngleZ = z;
    }
}
