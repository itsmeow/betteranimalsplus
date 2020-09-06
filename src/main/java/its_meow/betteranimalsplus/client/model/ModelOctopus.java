package its_meow.betteranimalsplus.client.model;

import its_meow.betteranimalsplus.common.entity.EntityOctopus;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.util.math.MathHelper;

/**
 * octopus - Batman, Cybercat5555 Created using Tabula 7.1.0
 */
public class ModelOctopus<T extends EntityOctopus> extends EntityModel<T> {
    public RendererModel head;
    public RendererModel lEye;
    public RendererModel rEye;
    public RendererModel siphon;
    public RendererModel beak01;
    public RendererModel beak02;
    public RendererModel lTentacle01a;
    public RendererModel rTentacle01a;
    public RendererModel lTentacle02a;
    public RendererModel rTentacle02a;
    public RendererModel lTentacle03a;
    public RendererModel rTentacle03a;
    public RendererModel lTentacle04a;
    public RendererModel rTentacle04a;
    public RendererModel mantle00;
    public RendererModel lTentacle01b;
    public RendererModel lTentacle01c;
    public RendererModel lTentacle01d;
    public RendererModel rTentacle01b;
    public RendererModel rTentacle01c;
    public RendererModel rTentacle01d;
    public RendererModel lTentacle02b;
    public RendererModel lTentacle02c;
    public RendererModel lTentacle02d;
    public RendererModel rTentacle02b;
    public RendererModel rTentacle02c;
    public RendererModel rTentacle02d;
    public RendererModel lTentacle03b;
    public RendererModel lTentacle03c;
    public RendererModel lTentacle03d;
    public RendererModel rTentacle03b;
    public RendererModel rTentacle03c;
    public RendererModel rTentacle03d;
    public RendererModel lTentacle04b;
    public RendererModel lTentacle04c;
    public RendererModel lTentacle04d;
    public RendererModel rTentacle04b;
    public RendererModel rTentacle04c;
    public RendererModel lTentacle04d_1;
    public RendererModel mantle01;
    protected final RendererModel[] mainTentacles;

    public ModelOctopus() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.rTentacle03c = new RendererModel(this, 41, 20);
        this.rTentacle03c.mirror = true;
        this.rTentacle03c.setRotationPoint(0.0F, 7.1F, 0.0F);
        this.rTentacle03c.addBox(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
        this.setRotateAngle(rTentacle03c, -0.03490658503988659F, 0.0F, 0.3490658503988659F);
        this.lTentacle01b = new RendererModel(this, 41, 21);
        this.lTentacle01b.setRotationPoint(0.0F, 6.2F, 0.0F);
        this.lTentacle01b.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
        this.setRotateAngle(lTentacle01b, -0.2792526803190927F, 0.20943951023931953F, -0.22689280275926282F);
        this.rTentacle01b = new RendererModel(this, 41, 21);
        this.rTentacle01b.mirror = true;
        this.rTentacle01b.setRotationPoint(0.0F, 6.2F, 0.0F);
        this.rTentacle01b.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
        this.setRotateAngle(rTentacle01b, -0.2792526803190927F, -0.20943951023931953F, 0.22689280275926282F);
        this.rTentacle03b = new RendererModel(this, 41, 21);
        this.rTentacle03b.mirror = true;
        this.rTentacle03b.setRotationPoint(0.0F, 6.2F, 0.0F);
        this.rTentacle03b.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
        this.setRotateAngle(rTentacle03b, -0.6981317007977318F, -0.5235987755982988F, 0.03490658503988659F);
        this.rTentacle02d = new RendererModel(this, 54, 21);
        this.rTentacle02d.mirror = true;
        this.rTentacle02d.setRotationPoint(0.0F, 8.2F, 0.0F);
        this.rTentacle02d.addBox(-1.0F, 0.0F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(rTentacle02d, -0.03490658503988659F, 0.0F, 0.3490658503988659F);
        this.lTentacle03a = new RendererModel(this, 41, 21);
        this.lTentacle03a.setRotationPoint(1.8F, -2.0F, 1.0F);
        this.lTentacle03a.addBox(-1.5F, 0.0F, -1.5F, 3, 7, 3, 0.0F);
        this.setRotateAngle(lTentacle03a, -0.7853981633974483F, -1.5707963267948966F, 0.0F);
        this.lTentacle03c = new RendererModel(this, 41, 20);
        this.lTentacle03c.setRotationPoint(0.0F, 7.1F, 0.0F);
        this.lTentacle03c.addBox(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
        this.setRotateAngle(lTentacle03c, -0.03490658503988659F, 0.0F, -0.3490658503988659F);
        this.lTentacle03b = new RendererModel(this, 41, 21);
        this.lTentacle03b.setRotationPoint(0.0F, 6.2F, 0.0F);
        this.lTentacle03b.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
        this.setRotateAngle(lTentacle03b, -0.6981317007977318F, 0.5235987755982988F, -0.03490658503988659F);
        this.beak01 = new RendererModel(this, 47, 0);
        this.beak01.setRotationPoint(0.0F, -1.5F, -1.2F);
        this.beak01.addBox(-1.5F, 0.0F, -0.5F, 3, 2, 3, 0.0F);
        this.setRotateAngle(beak01, -0.6373942428283291F, 0.0F, 0.0F);
        this.beak02 = new RendererModel(this, 55, 6);
        this.beak02.setRotationPoint(0.0F, -1.5F, 0.3F);
        this.beak02.addBox(-1.0F, 0.0F, -2.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(beak02, 0.5009094953223726F, 0.0F, 0.0F);
        this.mantle01 = new RendererModel(this, 29, 5);
        this.mantle01.setRotationPoint(0.0F, -0.2F, 5.3F);
        this.mantle01.addBox(-4.0F, -4.0F, 0.0F, 8, 8, 7, 0.0F);
        this.setRotateAngle(mantle01, -0.3490658503988659F, 0.0F, 0.0F);
        this.rTentacle01c = new RendererModel(this, 41, 20);
        this.rTentacle01c.mirror = true;
        this.rTentacle01c.setRotationPoint(0.0F, 7.1F, 0.0F);
        this.rTentacle01c.addBox(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
        this.setRotateAngle(rTentacle01c, -0.08726646259971647F, 0.22689280275926282F, 0.3490658503988659F);
        this.rTentacle01a = new RendererModel(this, 41, 21);
        this.rTentacle01a.mirror = true;
        this.rTentacle01a.setRotationPoint(-1.7F, -0.9F, -1.0F);
        this.rTentacle01a.addBox(-1.5F, 0.0F, -1.5F, 3, 7, 3, 0.0F);
        this.setRotateAngle(rTentacle01a, -0.6981317007977318F, 0.3141592653589793F, 0.0F);
        this.siphon = new RendererModel(this, 34, 0);
        this.siphon.setRotationPoint(-2.6F, -3.4F, -0.7F);
        this.siphon.addBox(-3.3F, -1.0F, -1.5F, 4, 2, 2, 0.0F);
        this.setRotateAngle(siphon, 0.0F, 0.7285004297824331F, 0.0F);
        this.lTentacle01d = new RendererModel(this, 54, 21);
        this.lTentacle01d.setRotationPoint(0.0F, 8.2F, 0.0F);
        this.lTentacle01d.addBox(-1.0F, 0.0F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(lTentacle01d, -0.03490658503988659F, 0.0F, -0.3490658503988659F);
        this.lTentacle04a = new RendererModel(this, 41, 21);
        this.lTentacle04a.setRotationPoint(1.8F, -2.4F, 2.0F);
        this.lTentacle04a.addBox(-1.5F, 0.0F, -1.5F, 3, 7, 3, 0.0F);
        this.setRotateAngle(lTentacle04a, -0.7853981633974483F, -2.0943951023931953F, 0.0F);
        this.lTentacle02b = new RendererModel(this, 41, 21);
        this.lTentacle02b.setRotationPoint(0.0F, 6.2F, 0.0F);
        this.lTentacle02b.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
        this.setRotateAngle(lTentacle02b, -0.40142572795869574F, 0.40142572795869574F, -0.03490658503988659F);
        this.rTentacle03a = new RendererModel(this, 41, 21);
        this.rTentacle03a.mirror = true;
        this.rTentacle03a.setRotationPoint(-1.8F, -2.0F, 1.0F);
        this.rTentacle03a.addBox(-1.5F, 0.0F, -1.5F, 3, 7, 3, 0.0F);
        this.setRotateAngle(rTentacle03a, -0.7853981633974483F, 1.5707963267948966F, 0.0F);
        this.rTentacle04b = new RendererModel(this, 41, 21);
        this.rTentacle04b.mirror = true;
        this.rTentacle04b.setRotationPoint(0.0F, 6.2F, 0.0F);
        this.rTentacle04b.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
        this.setRotateAngle(rTentacle04b, -0.8726646259971648F, -0.5235987755982988F, 0.03490658503988659F);
        this.lTentacle04d = new RendererModel(this, 54, 21);
        this.lTentacle04d.setRotationPoint(0.0F, 8.2F, 0.0F);
        this.lTentacle04d.addBox(-1.0F, 0.0F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(lTentacle04d, 0.0F, 0.0F, -0.3490658503988659F);
        this.rTentacle04a = new RendererModel(this, 41, 21);
        this.rTentacle04a.mirror = true;
        this.rTentacle04a.setRotationPoint(-1.8F, -2.4F, 2.0F);
        this.rTentacle04a.addBox(-1.5F, 0.0F, -1.5F, 3, 7, 3, 0.0F);
        this.setRotateAngle(rTentacle04a, -0.7853981633974483F, 2.0943951023931953F, 0.0F);
        this.rTentacle02b = new RendererModel(this, 41, 21);
        this.rTentacle02b.mirror = true;
        this.rTentacle02b.setRotationPoint(0.0F, 6.2F, 0.0F);
        this.rTentacle02b.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
        this.setRotateAngle(rTentacle02b, -0.40142572795869574F, -0.40142572795869574F, 0.03490658503988659F);
        this.lEye = new RendererModel(this, 23, 0);
        this.lEye.setRotationPoint(2.6F, -7.0F, -2.5F);
        this.lEye.addBox(-0.1F, -1.5F, -1.5F, 2, 3, 3, 0.0F);
        this.setRotateAngle(lEye, 0.5235987755982988F, 0.17453292519943295F, 0.0F);
        this.lTentacle04d_1 = new RendererModel(this, 54, 21);
        this.lTentacle04d_1.mirror = true;
        this.lTentacle04d_1.setRotationPoint(0.0F, 8.2F, 0.0F);
        this.lTentacle04d_1.addBox(-1.0F, 0.0F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(lTentacle04d_1, 0.0F, 0.0F, 0.3490658503988659F);
        this.lTentacle04c = new RendererModel(this, 41, 20);
        this.lTentacle04c.setRotationPoint(0.0F, 7.1F, 0.0F);
        this.lTentacle04c.addBox(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
        this.setRotateAngle(lTentacle04c, -0.08726646259971647F, 0.0F, -0.3490658503988659F);
        this.lTentacle02d = new RendererModel(this, 54, 21);
        this.lTentacle02d.setRotationPoint(0.0F, 8.2F, 0.0F);
        this.lTentacle02d.addBox(-1.0F, 0.0F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(lTentacle02d, -0.03490658503988659F, 0.0F, -0.3490658503988659F);
        this.lTentacle01c = new RendererModel(this, 41, 20);
        this.lTentacle01c.setRotationPoint(0.0F, 7.1F, 0.0F);
        this.lTentacle01c.addBox(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
        this.setRotateAngle(lTentacle01c, -0.08726646259971647F, -0.22689280275926282F, -0.3490658503988659F);
        this.mantle00 = new RendererModel(this, 0, 16);
        this.mantle00.setRotationPoint(0.0F, -5.4F, -1.2F);
        this.mantle00.addBox(-4.5F, -4.0F, -0.1F, 9, 8, 7, 0.0F);
        this.setRotateAngle(mantle00, 0.3665191429188092F, 0.0F, 0.0F);
        this.lTentacle03d = new RendererModel(this, 54, 21);
        this.lTentacle03d.setRotationPoint(0.0F, 8.2F, 0.0F);
        this.lTentacle03d.addBox(-1.0F, 0.0F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(lTentacle03d, 0.03490658503988659F, 0.0F, -0.3490658503988659F);
        this.rTentacle03d = new RendererModel(this, 54, 21);
        this.rTentacle03d.mirror = true;
        this.rTentacle03d.setRotationPoint(0.0F, 8.2F, 0.0F);
        this.rTentacle03d.addBox(-1.0F, 0.0F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(rTentacle03d, 0.03490658503988659F, 0.0F, 0.3490658503988659F);
        this.lTentacle02a = new RendererModel(this, 41, 21);
        this.lTentacle02a.setRotationPoint(1.7F, -1.5F, -0.3F);
        this.lTentacle02a.addBox(-1.5F, 0.0F, -1.5F, 3, 7, 3, 0.0F);
        this.setRotateAngle(lTentacle02a, -0.7853981633974483F, -1.0471975511965976F, 0.0F);
        this.lTentacle01a = new RendererModel(this, 41, 21);
        this.lTentacle01a.setRotationPoint(1.7F, -0.9F, -1.0F);
        this.lTentacle01a.addBox(-1.5F, 0.0F, -1.5F, 3, 7, 3, 0.0F);
        this.setRotateAngle(lTentacle01a, -0.6981317007977318F, -0.3141592653589793F, 0.0F);
        this.rTentacle02a = new RendererModel(this, 41, 21);
        this.rTentacle02a.mirror = true;
        this.rTentacle02a.setRotationPoint(-1.7F, -1.5F, -0.3F);
        this.rTentacle02a.addBox(-1.5F, 0.0F, -1.5F, 3, 7, 3, 0.0F);
        this.setRotateAngle(rTentacle02a, -0.7853981633974483F, 1.0471975511965976F, 0.0F);
        this.rTentacle01d = new RendererModel(this, 54, 21);
        this.rTentacle01d.mirror = true;
        this.rTentacle01d.setRotationPoint(0.0F, 8.2F, 0.0F);
        this.rTentacle01d.addBox(-1.0F, 0.0F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(rTentacle01d, -0.03490658503988659F, 0.0F, 0.3490658503988659F);
        this.head = new RendererModel(this, 0, 0);
        this.head.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.head.addBox(-3.5F, -9.0F, -3.5F, 7, 9, 7, 0.0F);
        this.setRotateAngle(head, -0.40980330836826856F, 0.0F, 0.0F);
        this.rTentacle04c = new RendererModel(this, 41, 20);
        this.rTentacle04c.mirror = true;
        this.rTentacle04c.setRotationPoint(0.0F, 7.1F, 0.0F);
        this.rTentacle04c.addBox(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
        this.setRotateAngle(rTentacle04c, -0.08726646259971647F, 0.0F, 0.3490658503988659F);
        this.rEye = new RendererModel(this, 23, 0);
        this.rEye.mirror = true;
        this.rEye.setRotationPoint(-2.6F, -7.0F, -2.5F);
        this.rEye.addBox(-1.9F, -1.5F, -1.5F, 2, 3, 3, 0.0F);
        this.setRotateAngle(rEye, 0.5235987755982988F, -0.17453292519943295F, 0.0F);
        this.rTentacle02c = new RendererModel(this, 41, 20);
        this.rTentacle02c.mirror = true;
        this.rTentacle02c.setRotationPoint(0.0F, 7.1F, 0.0F);
        this.rTentacle02c.addBox(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
        this.setRotateAngle(rTentacle02c, -0.03490658503988659F, 0.0F, 0.3490658503988659F);
        this.lTentacle02c = new RendererModel(this, 41, 20);
        this.lTentacle02c.setRotationPoint(0.0F, 7.1F, 0.0F);
        this.lTentacle02c.addBox(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
        this.setRotateAngle(lTentacle02c, -0.03490658503988659F, 0.0F, -0.3490658503988659F);
        this.lTentacle04b = new RendererModel(this, 41, 21);
        this.lTentacle04b.setRotationPoint(0.0F, 6.2F, 0.0F);
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
        this.mainTentacles = new RendererModel[] {
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
    public void render(T entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.head.render(f5);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
        if(entityIn.isInWaterOrBubbleColumn() && (!entityIn.isAboveBlock() || entityIn.getMotion().length() > 0.01)) {
            this.setSwimPose();
            this.head.rotateAngleX = 0F;
            for(RendererModel m : mainTentacles) {
                m.rotateAngleX = -ageInTicks / 2F;
            }
        } else {
            this.setGroundPose();
            this.lTentacle01a.rotateAngleY -= MathHelper.sin(limbSwing) * limbSwingAmount / 2F;
            this.lTentacle02a.rotateAngleY -= MathHelper.sin(limbSwing) * limbSwingAmount / 2F;
            this.lTentacle03a.rotateAngleY += MathHelper.sin(limbSwing) * limbSwingAmount / 2F;
            this.lTentacle04a.rotateAngleY += MathHelper.sin(limbSwing) * limbSwingAmount / 2F;
            this.rTentacle01a.rotateAngleY -= MathHelper.sin(limbSwing) * limbSwingAmount / 2F;
            this.rTentacle02a.rotateAngleY -= MathHelper.sin(limbSwing) * limbSwingAmount / 2F;
            this.rTentacle03a.rotateAngleY += MathHelper.sin(limbSwing) * limbSwingAmount / 2F;
            this.rTentacle04a.rotateAngleY += MathHelper.sin(limbSwing) * limbSwingAmount / 2F;
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

    public void setRotateAngle(RendererModel RendererModel, float x, float y, float z) {
        RendererModel.rotateAngleX = x;
        RendererModel.rotateAngleY = y;
        RendererModel.rotateAngleZ = z;
    }
}
