package dev.itsmeow.betteranimalsplus.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.common.entity.EntityDragonfly;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;

/**
 * dragonfly - cybercat5555 Created using Tabula 7.1.0
 */
public class ModelDragonfly<T extends LivingEntity> extends EntityModel<T> {
    public ModelPart thorax;
    public ModelPart head;
    public ModelPart abdomin;
    public ModelPart lLeg00;
    public ModelPart lLeg01;
    public ModelPart lLeg02;
    public ModelPart rLeg00;
    public ModelPart rLeg01;
    public ModelPart rLeg02;
    public ModelPart lWing01;
    public ModelPart lWing02;
    public ModelPart rWing01;
    public ModelPart rWing02;
    public ModelPart lAntenna;
    public ModelPart rAntenna;
    private boolean isOffset = false;
    private double xOff = 0;
    private double zOff = 0;

    public ModelDragonfly() {
        this.texWidth = 64;
        this.texHeight = 32;
        this.rWing01 = new ModelPart(this, 19, 12);
        this.rWing01.mirror = true;
        this.rWing01.setPos(-1.2F, -1.2F, -0.6F);
        this.rWing01.addBox(-16.0F, 0.0F, -2.5F, 16, 0, 6, 0.0F);
        this.setRotateAngle(rWing01, 0.0F, -0.13962634015954636F, 0.0F);
        this.abdomin = new ModelPart(this, 0, 16);
        this.abdomin.setPos(0.0F, 0.2F, 1.8F);
        this.abdomin.addBox(-1.0F, -1.5F, 0.0F, 2, 2, 13, 0.0F);
        this.setRotateAngle(abdomin, -0.05235987755982988F, 0.0F, 0.0F);
        this.rLeg00 = new ModelPart(this, 17, 6);
        this.rLeg00.mirror = true;
        this.rLeg00.setPos(-0.9F, 1.2F, -0.5F);
        this.rLeg00.addBox(-0.5F, 0.0F, -0.0F, 1, 4, 0, 0.0F);
        this.setRotateAngle(rLeg00, -1.0471975511965976F, 0.8726646259971648F, 0.0F);
        this.lLeg00 = new ModelPart(this, 17, 6);
        this.lLeg00.setPos(0.9F, 1.2F, -0.5F);
        this.lLeg00.addBox(-0.5F, 0.0F, -0.0F, 1, 4, 0, 0.0F);
        this.setRotateAngle(lLeg00, -1.0471975511965976F, -0.8726646259971648F, 0.0F);
        this.lLeg02 = new ModelPart(this, 17, 6);
        this.lLeg02.setPos(0.9F, 1.2F, 0.5F);
        this.lLeg02.addBox(-0.5F, 0.0F, -0.0F, 1, 4, 0, 0.0F);
        this.setRotateAngle(lLeg02, 1.0471975511965976F, 0.8726646259971648F, 0.0F);
        this.lWing01 = new ModelPart(this, 19, 12);
        this.lWing01.setPos(1.2F, -1.2F, -0.6F);
        this.lWing01.addBox(0.0F, 0.0F, -2.5F, 16, 0, 6, 0.0F);
        this.setRotateAngle(lWing01, 0.0F, 0.13962634015954636F, 0.0F);
        this.rLeg01 = new ModelPart(this, 20, 5);
        this.rLeg01.mirror = true;
        this.rLeg01.setPos(-0.9F, 1.2F, 0.0F);
        this.rLeg01.addBox(-0.0F, 0.0F, -0.5F, 0, 4, 1, 0.0F);
        this.setRotateAngle(rLeg01, 0.0F, 0.0F, 1.0471975511965976F);
        this.rLeg02 = new ModelPart(this, 17, 6);
        this.rLeg02.mirror = true;
        this.rLeg02.setPos(-0.9F, 1.2F, 0.5F);
        this.rLeg02.addBox(-0.5F, 0.0F, -0.0F, 1, 4, 0, 0.0F);
        this.setRotateAngle(rLeg02, 1.0471975511965976F, -0.8726646259971648F, 0.0F);
        this.rAntenna = new ModelPart(this, 11, 0);
        this.rAntenna.mirror = true;
        this.rAntenna.setPos(-0.4F, -3.0F, -2.0F);
        this.rAntenna.addBox(-1.0F, 0.0F, -5.0F, 1, 0, 5, 0.0F);
        this.setRotateAngle(rAntenna, -0.7853981633974483F, 0.2792526803190927F, 0.0F);
        this.rWing02 = new ModelPart(this, 19, 12);
        this.rWing02.mirror = true;
        this.rWing02.setPos(-1.2F, -1.0F, 1.1F);
        this.rWing02.addBox(-16.0F, 0.0F, -1.5F, 16, 0, 6, 0.0F);
        this.setRotateAngle(rWing02, 0.0F, 0.13962634015954636F, 0.0F);
        this.head = new ModelPart(this, 0, 0);
        this.head.setPos(0.0F, 0.2F, -1.4F);
        this.head.addBox(-1.5F, -3.0F, -3.0F, 3, 3, 3, 0.0F);
        this.setRotateAngle(head, 0.7853981633974483F, 0.0F, 0.0F);
        this.thorax = new ModelPart(this, 0, 7);
        this.thorax.setPos(0.0F, 20.9F, 0.0F);
        this.thorax.addBox(-1.5F, -1.5F, -2.0F, 3, 3, 4, 0.0F);
        this.lLeg01 = new ModelPart(this, 20, 5);
        this.lLeg01.setPos(0.9F, 1.2F, 0.0F);
        this.lLeg01.addBox(-0.0F, 0.0F, -0.5F, 0, 4, 1, 0.0F);
        this.setRotateAngle(lLeg01, 0.0F, 0.0F, -1.0471975511965976F);
        this.lWing02 = new ModelPart(this, 19, 12);
        this.lWing02.setPos(1.2F, -1.0F, 1.1F);
        this.lWing02.addBox(0.0F, 0.0F, -1.5F, 16, 0, 6, 0.0F);
        this.setRotateAngle(lWing02, 0.0F, -0.13962634015954636F, 0.0F);
        this.lAntenna = new ModelPart(this, 11, 0);
        this.lAntenna.setPos(0.4F, -3.0F, -2.0F);
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
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        if (this.isOffset) {
            matrixStackIn.translate(-this.xOff, 0D, this.zOff);
        }
        this.thorax.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entityIn instanceof EntityDragonfly) {
            EntityDragonfly entity = (EntityDragonfly) entityIn;
            if (entity.isLanded()) {
                this.rWing01.zRot = (float) Math.toRadians(3);
                this.lWing01.zRot = (float) Math.toRadians(-3);
                this.lWing01.yRot = (float) Math.toRadians(-15);
                this.rWing01.yRot = (float) Math.toRadians(15);
                this.rWing02.zRot = (float) Math.toRadians(3);
                this.lWing02.zRot = (float) Math.toRadians(-3);
                this.lWing02.yRot = (float) Math.toRadians(-15);
                this.rWing02.yRot = (float) Math.toRadians(15);
                this.isOffset = Direction.from3DDataValue(entity.getLandedInteger()) != Direction.DOWN;
                if (isOffset) {
                    this.thorax.xRot = (float) Math.toRadians(-90);
                    this.thorax.yRot = (float) Math.toRadians(Direction.from3DDataValue(entity.getLandedInteger()).toYRot());
                    double x = Math.floor(entity.getX()) + 0.5D;
                    double z = Math.floor(entity.getZ()) + 0.5D;
                    BlockPos pos = new BlockPos(x, entity.getY(), z);
                    BlockPos offset = pos.relative(Direction.from3DDataValue(entity.getLandedInteger()));
                    BlockPos diff = pos.subtract(offset);
                    this.xOff = ((double) diff.getX()) / (13D * entity.getDimensions(Pose.STANDING).width);
                    this.zOff = ((double) diff.getZ()) / (13D * entity.getDimensions(Pose.STANDING).width);
                } else {
                    this.thorax.xRot = 0;
                    this.thorax.yRot = 0;
                }
            } else {
                this.rWing01.zRot = (float) Math.sin(ageInTicks * 2);
                this.lWing01.zRot = (float) -Math.sin(ageInTicks * 2);
                this.lWing01.yRot = 0;
                this.rWing01.yRot = 0;
                this.rWing02.zRot = (float) -Math.sin(ageInTicks * 2);
                this.lWing02.zRot = (float) Math.sin(ageInTicks * 2);
                this.lWing02.yRot = 0;
                this.rWing02.yRot = 0;
                this.thorax.xRot = 0;
                this.thorax.yRot = 0;
            }
        }
    }

    public void setRotateAngle(ModelPart ModelRenderer, float x, float y, float z) {
        ModelRenderer.xRot = x;
        ModelRenderer.yRot = y;
        ModelRenderer.zRot = z;
    }
}
