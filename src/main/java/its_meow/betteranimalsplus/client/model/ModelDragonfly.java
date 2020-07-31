package its_meow.betteranimalsplus.client.model;

import com.mojang.blaze3d.platform.GlStateManager;

import its_meow.betteranimalsplus.common.entity.EntityDragonfly;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;

/**
 * dragonfly - cybercat5555 Created using Tabula 7.1.0
 */
public class ModelDragonfly<T extends LivingEntity> extends EntityModel<T> {
    public RendererModel thorax;
    public RendererModel head;
    public RendererModel abdomin;
    public RendererModel lLeg00;
    public RendererModel lLeg01;
    public RendererModel lLeg02;
    public RendererModel rLeg00;
    public RendererModel rLeg01;
    public RendererModel rLeg02;
    public RendererModel lWing01;
    public RendererModel lWing02;
    public RendererModel rWing01;
    public RendererModel rWing02;
    public RendererModel lAntenna;
    public RendererModel rAntenna;

    public ModelDragonfly() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.rWing01 = new RendererModel(this, 19, 12);
        this.rWing01.mirror = true;
        this.rWing01.setRotationPoint(-1.2F, -1.2F, -0.6F);
        this.rWing01.addBox(-16.0F, 0.0F, -2.5F, 16, 0, 6, 0.0F);
        this.setRotateAngle(rWing01, 0.0F, -0.13962634015954636F, 0.0F);
        this.abdomin = new RendererModel(this, 0, 16);
        this.abdomin.setRotationPoint(0.0F, 0.2F, 1.8F);
        this.abdomin.addBox(-1.0F, -1.5F, 0.0F, 2, 2, 13, 0.0F);
        this.setRotateAngle(abdomin, -0.05235987755982988F, 0.0F, 0.0F);
        this.rLeg00 = new RendererModel(this, 17, 6);
        this.rLeg00.mirror = true;
        this.rLeg00.setRotationPoint(-0.9F, 1.2F, -0.5F);
        this.rLeg00.addBox(-0.5F, 0.0F, -0.0F, 1, 4, 0, 0.0F);
        this.setRotateAngle(rLeg00, -1.0471975511965976F, 0.8726646259971648F, 0.0F);
        this.lLeg00 = new RendererModel(this, 17, 6);
        this.lLeg00.setRotationPoint(0.9F, 1.2F, -0.5F);
        this.lLeg00.addBox(-0.5F, 0.0F, -0.0F, 1, 4, 0, 0.0F);
        this.setRotateAngle(lLeg00, -1.0471975511965976F, -0.8726646259971648F, 0.0F);
        this.lLeg02 = new RendererModel(this, 17, 6);
        this.lLeg02.setRotationPoint(0.9F, 1.2F, 0.5F);
        this.lLeg02.addBox(-0.5F, 0.0F, -0.0F, 1, 4, 0, 0.0F);
        this.setRotateAngle(lLeg02, 1.0471975511965976F, 0.8726646259971648F, 0.0F);
        this.lWing01 = new RendererModel(this, 19, 12);
        this.lWing01.setRotationPoint(1.2F, -1.2F, -0.6F);
        this.lWing01.addBox(0.0F, 0.0F, -2.5F, 16, 0, 6, 0.0F);
        this.setRotateAngle(lWing01, 0.0F, 0.13962634015954636F, 0.0F);
        this.rLeg01 = new RendererModel(this, 20, 5);
        this.rLeg01.mirror = true;
        this.rLeg01.setRotationPoint(-0.9F, 1.2F, 0.0F);
        this.rLeg01.addBox(-0.0F, 0.0F, -0.5F, 0, 4, 1, 0.0F);
        this.setRotateAngle(rLeg01, 0.0F, 0.0F, 1.0471975511965976F);
        this.rLeg02 = new RendererModel(this, 17, 6);
        this.rLeg02.mirror = true;
        this.rLeg02.setRotationPoint(-0.9F, 1.2F, 0.5F);
        this.rLeg02.addBox(-0.5F, 0.0F, -0.0F, 1, 4, 0, 0.0F);
        this.setRotateAngle(rLeg02, 1.0471975511965976F, -0.8726646259971648F, 0.0F);
        this.rAntenna = new RendererModel(this, 11, 0);
        this.rAntenna.mirror = true;
        this.rAntenna.setRotationPoint(-0.4F, -3.0F, -2.0F);
        this.rAntenna.addBox(-1.0F, 0.0F, -5.0F, 1, 0, 5, 0.0F);
        this.setRotateAngle(rAntenna, -0.7853981633974483F, 0.2792526803190927F, 0.0F);
        this.rWing02 = new RendererModel(this, 19, 12);
        this.rWing02.mirror = true;
        this.rWing02.setRotationPoint(-1.2F, -1.0F, 1.1F);
        this.rWing02.addBox(-16.0F, 0.0F, -1.5F, 16, 0, 6, 0.0F);
        this.setRotateAngle(rWing02, 0.0F, 0.13962634015954636F, 0.0F);
        this.head = new RendererModel(this, 0, 0);
        this.head.setRotationPoint(0.0F, 0.2F, -1.4F);
        this.head.addBox(-1.5F, -3.0F, -3.0F, 3, 3, 3, 0.0F);
        this.setRotateAngle(head, 0.7853981633974483F, 0.0F, 0.0F);
        this.thorax = new RendererModel(this, 0, 7);
        this.thorax.setRotationPoint(0.0F, 20.9F, 0.0F);
        this.thorax.addBox(-1.5F, -1.5F, -2.0F, 3, 3, 4, 0.0F);
        this.lLeg01 = new RendererModel(this, 20, 5);
        this.lLeg01.setRotationPoint(0.9F, 1.2F, 0.0F);
        this.lLeg01.addBox(-0.0F, 0.0F, -0.5F, 0, 4, 1, 0.0F);
        this.setRotateAngle(lLeg01, 0.0F, 0.0F, -1.0471975511965976F);
        this.lWing02 = new RendererModel(this, 19, 12);
        this.lWing02.setRotationPoint(1.2F, -1.0F, 1.1F);
        this.lWing02.addBox(0.0F, 0.0F, -1.5F, 16, 0, 6, 0.0F);
        this.setRotateAngle(lWing02, 0.0F, -0.13962634015954636F, 0.0F);
        this.lAntenna = new RendererModel(this, 11, 0);
        this.lAntenna.setRotationPoint(0.4F, -3.0F, -2.0F);
        this.lAntenna.addBox(0.0F, 0.0F, -5.0F, 1, 0, 5, 0.0F);
        this.setRotateAngle(lAntenna, -0.7853981633974483F, -0.2792526803190927F, 0.0F);
        this.thorax.addChild(this.rWing01);
        this.thorax.addChild(this.abdomin);
        this.thorax.addChild(this.rLeg00);
        this.thorax.addChild(this.lLeg00);
        this.thorax.addChild(this.lLeg02);
        this.thorax.addChild(this.lWing01);
        this.thorax.addChild(this.rLeg01);
        this.thorax.addChild(this.rLeg02);
        this.head.addChild(this.rAntenna);
        this.thorax.addChild(this.rWing02);
        this.thorax.addChild(this.head);
        this.thorax.addChild(this.lLeg01);
        this.thorax.addChild(this.lWing02);
        this.head.addChild(this.lAntenna);
    }

    @Override
    public void render(T entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.thorax.render(f5);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
        if(entityIn instanceof EntityDragonfly) {
            EntityDragonfly entity = (EntityDragonfly) entityIn;
            if(entity.isLanded()) {
                this.rWing01.rotateAngleZ = (float) Math.toRadians(3);
                this.lWing01.rotateAngleZ = (float) Math.toRadians(-3);
                this.lWing01.rotateAngleY = (float) Math.toRadians(-15);
                this.rWing01.rotateAngleY = (float) Math.toRadians(15);
                this.rWing02.rotateAngleZ = (float) Math.toRadians(3);
                this.lWing02.rotateAngleZ = (float) Math.toRadians(-3);
                this.lWing02.rotateAngleY = (float) Math.toRadians(-15);
                this.rWing02.rotateAngleY = (float) Math.toRadians(15);
                if(Direction.byIndex(entity.getLandedInteger()) != Direction.DOWN) {
                    this.thorax.rotateAngleX = (float) Math.toRadians(-90);
                    this.thorax.rotateAngleY = (float) Math.toRadians(Direction.byIndex(entity.getLandedInteger()).getHorizontalAngle());
                    double x = Math.floor(entity.posX) + 0.5D;
                    double z = Math.floor(entity.posZ) + 0.5D;
                    BlockPos pos = new BlockPos(x, entity.posY, z);
                    BlockPos offset = pos.offset(Direction.byIndex(entity.getLandedInteger()));
                    BlockPos diff = pos.subtract(offset);
                    double xOff = ((double) diff.getX()) / (13D * entity.getSize(Pose.STANDING).width);
                    double zOff = ((double) diff.getZ()) / (13D * entity.getSize(Pose.STANDING).width);
                    GlStateManager.translated(-xOff, 0D, zOff);
                } else {
                    this.thorax.rotateAngleX = 0;
                    this.thorax.rotateAngleY = 0;
                }
            } else {
                this.rWing01.rotateAngleZ = (float) Math.sin(ageInTicks * 2);
                this.lWing01.rotateAngleZ = (float) -Math.sin(ageInTicks * 2);
                this.lWing01.rotateAngleY = 0;
                this.rWing01.rotateAngleY = 0;
                this.rWing02.rotateAngleZ = (float) -Math.sin(ageInTicks * 2);
                this.lWing02.rotateAngleZ = (float) Math.sin(ageInTicks * 2);
                this.lWing02.rotateAngleY = 0;
                this.rWing02.rotateAngleY = 0;
                this.thorax.rotateAngleX = 0;
                this.thorax.rotateAngleY = 0;
            }
        }
    }

    public void setRotateAngle(RendererModel RendererModel, float x, float y, float z) {
        RendererModel.rotateAngleX = x;
        RendererModel.rotateAngleY = y;
        RendererModel.rotateAngleZ = z;
    }
}
