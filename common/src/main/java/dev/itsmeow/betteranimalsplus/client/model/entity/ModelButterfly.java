package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import dev.itsmeow.betteranimalsplus.common.entity.EntityButterfly;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Pose;

/**
 * butterfly - cybecat5555 Created using Tabula 8.0.0
 */
public class ModelButterfly<T extends Entity> extends ModelBAP<T> {
    public ModelPart thorax;
    public ModelPart head;
    public ModelPart abdomen;
    public ModelPart lLeg00;
    public ModelPart lLeg01;
    public ModelPart lLeg02;
    public ModelPart rLeg00;
    public ModelPart rLeg01;
    public ModelPart rLeg02;
    public ModelPart lWing;
    public ModelPart rWing;
    public ModelPart lAntenna;
    public ModelPart rAntenna;
    private boolean isOffset = false;
    private double xOff = 0;
    private double zOff = 0;

    public ModelButterfly(ModelPart root) {
        this.thorax = root.getChild("thorax");
        this.head = thorax.getChild("head");
        this.lAntenna = head.getChild("lAntenna");
        this.rAntenna = head.getChild("rAntenna");
        this.abdomen = thorax.getChild("abdomen");
        this.lLeg00 = thorax.getChild("lLeg00");
        this.lLeg01 = thorax.getChild("lLeg01");
        this.lLeg02 = thorax.getChild("lLeg02");
        this.rLeg00 = thorax.getChild("rLeg00");
        this.rLeg01 = thorax.getChild("rLeg01");
        this.rLeg02 = thorax.getChild("rLeg02");
        this.lWing = thorax.getChild("lWing");
        this.rWing = thorax.getChild("rWing");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition thorax = partdefinition.addOrReplaceChild("thorax", CubeListBuilder.create().texOffs(0, 7).addBox(-1.5F, -1.5F, -2.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.9F, 0.0F));
        PartDefinition head = thorax.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -3.0F, -3.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.2F, -1.4F, 0.7854F, 0.0F, 0.0F));
        PartDefinition lAntenna = head.addOrReplaceChild("lAntenna", CubeListBuilder.create().texOffs(11, 0).addBox(0.0F, 0.0F, -4.75F, 2.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4F, -3.0F, -2.0F, -0.7854F, -0.2793F, 0.0F));
        PartDefinition rAntenna = head.addOrReplaceChild("rAntenna", CubeListBuilder.create().texOffs(11, 0).mirror().addBox(-2.0F, 0.0F, -4.75F, 2.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.4F, -3.0F, -2.0F, -0.7854F, 0.2793F, 0.0F));
        PartDefinition abdomen = thorax.addOrReplaceChild("abdomen", CubeListBuilder.create().texOffs(0, 16).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.2F, 1.8F, -0.1222F, 0.0F, 0.0F));
        PartDefinition lLeg00 = thorax.addOrReplaceChild("lLeg00", CubeListBuilder.create().texOffs(17, 6).mirror().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.9F, 1.2F, -0.5F, -1.0472F, -0.8727F, 0.0F));
        PartDefinition lLeg01 = thorax.addOrReplaceChild("lLeg01", CubeListBuilder.create().texOffs(20, 5).mirror().addBox(0.0F, 0.0F, -0.5F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.9F, 1.2F, 0.0F, 0.0F, 0.0F, -1.0472F));
        PartDefinition lLeg02 = thorax.addOrReplaceChild("lLeg02", CubeListBuilder.create().texOffs(17, 6).mirror().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.9F, 1.2F, 0.5F, 1.0472F, 0.8727F, 0.0F));
        PartDefinition rLeg00 = thorax.addOrReplaceChild("rLeg00", CubeListBuilder.create().texOffs(17, 6).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9F, 1.2F, -0.5F, -1.0472F, 0.8727F, 0.0F));
        PartDefinition rLeg01 = thorax.addOrReplaceChild("rLeg01", CubeListBuilder.create().texOffs(20, 5).addBox(0.0F, 0.0F, -0.5F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9F, 1.2F, 0.0F, 0.0F, 0.0F, 1.0472F));
        PartDefinition rLeg02 = thorax.addOrReplaceChild("rLeg02", CubeListBuilder.create().texOffs(17, 6).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9F, 1.2F, 0.5F, 1.0472F, -0.8727F, 0.0F));
        PartDefinition lWing = thorax.addOrReplaceChild("lWing", CubeListBuilder.create().texOffs(-4, 0).addBox(0.0F, 0.0F, -4.5F, 20.0F, 0.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offset(1.2F, -1.0F, -1.0F));
        PartDefinition rWing = thorax.addOrReplaceChild("rWing", CubeListBuilder.create().texOffs(-4, 0).mirror().addBox(-20.0F, 0.0F, -4.5F, 20.0F, 0.0F, 27.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.2F, -1.0F, -1.0F));
        return LayerDefinition.create(meshdefinition, 64, 32);
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
        if (entityIn instanceof EntityButterfly) {
            EntityButterfly entity = (EntityButterfly) entityIn;
            if (entity.isLanded()) {
                this.setRotateAngle(lLeg00, -1.0471975511965976F, -0.8726646259971648F, 0.0F);
                this.setRotateAngle(rAntenna, -0.7853981633974483F, 0.2792526803190927F, 0.0F);
                this.setRotateAngle(lLeg01, 0.0F, 0.0F, -1.0471975511965976F);
                this.setRotateAngle(rLeg02, 1.0471975511965976F, -0.8726646259971648F, 0.0F);
                this.setRotateAngle(rLeg01, 0.0F, 0.0F, 1.0471975511965976F);
                this.setRotateAngle(lLeg02, 1.0471975511965976F, 0.8726646259971648F, 0.0F);
                this.setRotateAngle(abdomen, -0.12217304763960307F, 0.0F, 0.0F);
                this.setRotateAngle(head, 0.7853981633974483F, 0.0F, 0.0F);
                this.setRotateAngle(lAntenna, -0.7853981633974483F, -0.2792526803190927F, 0.0F);
                this.setRotateAngle(rLeg00, -1.0471975511965976F, 0.8726646259971648F, 0.0F);
                this.rWing.zRot = (float) Math.toRadians(3);
                this.lWing.zRot = (float) Math.toRadians(-3);
                this.lWing.yRot = (float) Math.toRadians(-30);
                this.rWing.yRot = (float) Math.toRadians(30);
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
                this.rWing.zRot = (float) Math.sin(ageInTicks);
                this.lWing.zRot = (float) -Math.sin(ageInTicks);
                this.lWing.yRot = 0;
                this.rWing.yRot = 0;
                this.thorax.xRot = 0;
                this.thorax.yRot = 0;
            }
        }
    }
}
