package its_meow.betteranimalsplus.client.model;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;

/**
 * Flying fish - Batman
 * Created using Tabula 7.0.1
 */
public class ModelFlyingFish<T extends LivingEntity> extends EntityModel<T> {
    public RendererModel front;
    public RendererModel rear;
    public RendererModel head;
    public RendererModel leftFin;
    public RendererModel rightFin;
    public RendererModel rLF;
    public RendererModel tail;
    public RendererModel lLF;
    public RendererModel tail2;
    public RendererModel tTailFin;
    public RendererModel lTailFin;
    public RendererModel tailFin;
    public RendererModel topJaw;
    public RendererModel lowerJaw;
    public RendererModel snout;

    public ModelFlyingFish() {
        this.textureWidth = 30;
        this.textureHeight = 120;
        this.tailFin = new RendererModel(this, 0, 36);
        this.tailFin.setRotationPoint(0.0F, 0.0F, 2.6F);
        this.tailFin.addBox(0.0F, -4.0F, 0.0F, 0, 8, 7, 0.0F);
        this.topJaw = new RendererModel(this, 0, 61);
        this.topJaw.setRotationPoint(0.0F, -0.6F, -3.5F);
        this.topJaw.addBox(-1.5F, -0.5F, -3.0F, 3, 2, 3, 0.0F);
        this.setRotateAngle(topJaw, -0.31869712141416456F, 0.0F, 0.0F);
        this.lowerJaw = new RendererModel(this, 0, 72);
        this.lowerJaw.setRotationPoint(0.0F, 1.0F, -3.7F);
        this.lowerJaw.addBox(-1.0F, -0.5F, -3.0F, 2, 1, 3, 0.0F);
        this.setRotateAngle(lowerJaw, -0.36425021489121656F, 0.0F, 0.0F);
        this.leftFin = new RendererModel(this, 0, 65);
        this.leftFin.setRotationPoint(2.1F, 0.0F, -6.0F);
        this.leftFin.addBox(0.0F, 0.0F, -3.0F, 0, 20, 13, 0.0F);
        this.setRotateAngle(leftFin, 0.0F, 0.0F, -1.3658946726107624F);
        this.snout = new RendererModel(this, 0, 67);
        this.snout.setRotationPoint(0.0F, -0.5F, -3.0F);
        this.snout.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 3, 0.0F);
        this.setRotateAngle(snout, 0.45169121041613247F, 0.0F, 0.0F);
        this.tail2 = new RendererModel(this, 0, 36);
        this.tail2.setRotationPoint(0.0F, 0.0F, 2.5F);
        this.tail2.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 3, 0.0F);
        this.front = new RendererModel(this, 0, 0);
        this.front.setRotationPoint(0.0F, 15.0F, 0.0F);
        this.front.addBox(-2.5F, -2.5F, -9.0F, 5, 5, 9, 0.0F);
        this.head = new RendererModel(this, 0, 52);
        this.head.setRotationPoint(0.0F, 0.0F, -8.5F);
        this.head.addBox(-2.0F, -2.5F, -4.0F, 4, 4, 4, 0.0F);
        this.setRotateAngle(head, 0.029845130209103034F, 0.0F, 0.0F);
        this.tTailFin = new RendererModel(this, 0, 97);
        this.tTailFin.setRotationPoint(0.0F, -2.8F, 0.3F);
        this.tTailFin.addBox(0.0F, 0.0F, 0.0F, 0, 2, 3, 0.0F);
        this.setRotateAngle(tTailFin, -0.31869712141416456F, 0.0F, 0.0F);
        this.rightFin = new RendererModel(this, 0, 65);
        this.rightFin.setRotationPoint(-2.1F, 0.0F, -6.0F);
        this.rightFin.addBox(0.0F, 0.0F, -3.0F, 0, 20, 13, 0.0F);
        this.setRotateAngle(rightFin, 0.0F, 0.0F, 1.3658946726107624F);
        this.lLF = new RendererModel(this, 0, 99);
        this.lLF.setRotationPoint(1.3F, 1.2F, 4.0F);
        this.lLF.addBox(0.0F, 0.0F, -2.0F, 0, 7, 5, 0.0F);
        this.setRotateAngle(lLF, 0.18203784098300857F, 0.0F, -0.36425021489121656F);
        this.rear = new RendererModel(this, 0, 15);
        this.rear.setRotationPoint(0.0F, -0.2F, 0.0F);
        this.rear.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 8, 0.0F);
        this.rLF = new RendererModel(this, 0, 99);
        this.rLF.setRotationPoint(-1.3F, 1.2F, 4.0F);
        this.rLF.addBox(0.0F, 0.0F, -2.0F, 0, 7, 5, 0.0F);
        this.setRotateAngle(rLF, 0.18203784098300857F, 0.0F, 0.36425021489121656F);
        this.lTailFin = new RendererModel(this, 8, 97);
        this.lTailFin.setRotationPoint(0.0F, 0.7F, -0.1F);
        this.lTailFin.addBox(0.0F, 0.0F, 0.0F, 0, 2, 2, 0.0F);
        this.setRotateAngle(lTailFin, 0.4553564018453205F, 0.0F, 0.0F);
        this.tail = new RendererModel(this, 0, 28);
        this.tail.setRotationPoint(0.0F, 0.0F, 8.0F);
        this.tail.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 3, 0.0F);
        this.tail2.addChild(this.tailFin);
        this.head.addChild(this.topJaw);
        this.head.addChild(this.lowerJaw);
        this.front.addChild(this.leftFin);
        this.topJaw.addChild(this.snout);
        this.tail.addChild(this.tail2);
        this.front.addChild(this.head);
        this.tail.addChild(this.tTailFin);
        this.front.addChild(this.rightFin);
        this.rear.addChild(this.lLF);
        this.front.addChild(this.rear);
        this.front.addChild(this.rLF);
        this.tail.addChild(this.lTailFin);
        this.rear.addChild(this.tail);
    }

    @Override
    public void render(T entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.front.render(f5);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
        float factor = (float) entityIn.getMotion().length() * 10;
        this.front.rotateAngleY = MathHelper.cos(ageInTicks * 0.3F) * (float) Math.PI * 0.05F * factor;
        this.head.rotateAngleY = -this.front.rotateAngleY * 1.5F;
        this.rear.rotateAngleY = this.front.rotateAngleY * 1.5F;
        this.tail.rotateAngleY = this.rear.rotateAngleY * 1.5F;
        this.rightFin.rotateAngleX = 0F;
        this.leftFin.rotateAngleX = 0F;
        this.rightFin.rotateAngleZ = (this.front.rotateAngleY * 2F) + 1.3658946726107624F;
        this.leftFin.rotateAngleZ = -(this.front.rotateAngleY * 2F) - 1.3658946726107624F;
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
