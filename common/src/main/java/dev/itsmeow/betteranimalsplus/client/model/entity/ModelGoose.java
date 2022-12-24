package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

/**
 * goose - cybercat5555
 * Created using Tabula 7.0.1
 */
public class ModelGoose<T extends LivingEntity> extends ModelBAP<T> {

    public ModelPart body;
    public ModelPart rear;
    public ModelPart lowerRear;
    public ModelPart neck00;
    public ModelPart lLeg01;
    public ModelPart rLeg01;
    public ModelPart lWing01;
    public ModelPart rWing01;
    public ModelPart lTailFeather01;
    public ModelPart rTailFeather01;
    public ModelPart lTailFeather02;
    public ModelPart rTailFeather02;
    public ModelPart lTailFeather03;
    public ModelPart rTailFeather03;
    public ModelPart neck01;
    public ModelPart neck02;
    public ModelPart neck03;
    public ModelPart head;
    public ModelPart billUpper;
    public ModelPart billLower;
    public ModelPart lLeg02;
    public ModelPart lClaw01;
    public ModelPart lClaw02;
    public ModelPart lClaw03;
    public ModelPart lClaw04;
    public ModelPart rLeg02;
    public ModelPart rClaw01;
    public ModelPart rClaw02;
    public ModelPart rClaw03;
    public ModelPart rClaw04;
    public ModelPart lWing02;
    public ModelPart lWingFeathers01;
    public ModelPart lWingFeathers02;
    public ModelPart rWing02;
    public ModelPart rWingFeathers01;
    public ModelPart rWingFeathers02;

    public ModelGoose(ModelPart root) {
        this.body = root.getChild("body");
        this.rear = body.getChild("rear");
        this.lTailFeather01 = rear.getChild("lTailFeather01");
        this.rTailFeather01 = rear.getChild("rTailFeather01");
        this.lTailFeather02 = rear.getChild("lTailFeather02");
        this.rTailFeather02 = rear.getChild("rTailFeather02");
        this.lTailFeather03 = rear.getChild("lTailFeather03");
        this.rTailFeather03 = rear.getChild("rTailFeather03");
        this.lowerRear = body.getChild("lowerRear");
        this.neck00 = body.getChild("neck00");
        this.neck01 = neck00.getChild("neck01");
        this.neck02 = neck01.getChild("neck02");
        this.neck03 = neck02.getChild("neck03");
        this.head = neck03.getChild("head");
        this.billUpper = head.getChild("billUpper");
        this.billLower = head.getChild("billLower");
        this.lLeg01 = body.getChild("lLeg01");
        this.lLeg02 = lLeg01.getChild("lLeg02");
        this.lClaw01 = lLeg02.getChild("lClaw01");
        this.lClaw02 = lLeg02.getChild("lClaw02");
        this.lClaw03 = lLeg02.getChild("lClaw03");
        this.lClaw04 = lLeg02.getChild("lClaw04");
        this.rLeg01 = body.getChild("rLeg01");
        this.rLeg02 = rLeg01.getChild("rLeg02");
        this.rClaw01 = rLeg02.getChild("rClaw01");
        this.rClaw02 = rLeg02.getChild("rClaw02");
        this.rClaw03 = rLeg02.getChild("rClaw03");
        this.rClaw04 = rLeg02.getChild("rClaw04");
        this.lWing01 = body.getChild("lWing01");
        this.lWing02 = lWing01.getChild("lWing02");
        this.lWingFeathers02 = lWing02.getChild("lWingFeathers02");
        this.lWingFeathers01 = lWing01.getChild("lWingFeathers01");
        this.rWing01 = body.getChild("rWing01");
        this.rWing02 = rWing01.getChild("rWing02");
        this.rWingFeathers02 = rWing02.getChild("rWingFeathers02");
        this.rWingFeathers01 = rWing01.getChild("rWingFeathers01");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -5.0F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.3F, 0.0F));
        PartDefinition rear = body.addOrReplaceChild("rear", CubeListBuilder.create().texOffs(0, 20).addBox(-3.5F, -2.0F, 0.0F, 7.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.8F, 4.7F));
        PartDefinition lTailFeather01 = rear.addOrReplaceChild("lTailFeather01", CubeListBuilder.create().texOffs(-3, 19).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.9F, -0.2F, 5.4F, 0.0F, 0.0349F, 0.0F));
        PartDefinition rTailFeather01 = rear.addOrReplaceChild("rTailFeather01", CubeListBuilder.create().texOffs(-3, 19).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9F, -0.2F, 5.4F, 0.0F, -0.0349F, 0.0F));
        PartDefinition lTailFeather02 = rear.addOrReplaceChild("lTailFeather02", CubeListBuilder.create().texOffs(-3, 19).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5F, -0.1F, 5.0F, 0.0F, 0.1745F, 0.0F));
        PartDefinition rTailFeather02 = rear.addOrReplaceChild("rTailFeather02", CubeListBuilder.create().texOffs(-3, 19).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -0.1F, 5.0F, 0.0F, -0.1745F, 0.0F));
        PartDefinition lTailFeather03 = rear.addOrReplaceChild("lTailFeather03", CubeListBuilder.create().texOffs(-3, 19).mirror().addBox(-1.0F, -0.01F, 0.0F, 2.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.1F, 0.0F, 4.2F, 0.0F, 0.2443F, 0.0F));
        PartDefinition rTailFeather03 = rear.addOrReplaceChild("rTailFeather03", CubeListBuilder.create().texOffs(-3, 19).addBox(-1.0F, -0.01F, 0.0F, 2.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1F, 0.0F, 4.2F, 0.0F, -0.2443F, 0.0F));
        PartDefinition lowerRear = body.addOrReplaceChild("lowerRear", CubeListBuilder.create().texOffs(0, 31).addBox(-3.0F, -2.0F, 0.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.2F, 4.6F, 0.1745F, 0.0F, 0.0F));
        PartDefinition neck00 = body.addOrReplaceChild("neck00", CubeListBuilder.create().texOffs(0, 43).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.6F, -4.4F, -0.6981F, 0.0F, 0.0F));
        PartDefinition neck01 = neck00.addOrReplaceChild("neck01", CubeListBuilder.create().texOffs(0, 53).addBox(-1.5F, -1.5F, -3.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.4F, -2.1F, -0.5236F, 0.0F, 0.0F));
        PartDefinition neck02 = neck01.addOrReplaceChild("neck02", CubeListBuilder.create().texOffs(16, 55).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.1F, -2.5F, -0.3491F, 0.0F, 0.0F));
        PartDefinition neck03 = neck02.addOrReplaceChild("neck03", CubeListBuilder.create().texOffs(17, 56).addBox(-1.0F, -0.95F, -2.9F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, -0.05F, -3.8F, 0.2269F, 0.0F, 0.0F));
        PartDefinition head = neck03.addOrReplaceChild("head", CubeListBuilder.create().texOffs(31, 0).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.2F, -2.7F, -0.2094F, 0.0F, 0.0F));
        PartDefinition billUpper = head.addOrReplaceChild("billUpper", CubeListBuilder.create().texOffs(45, 0).addBox(-1.0F, 0.0F, -0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.6F, -0.2F, 0.1571F, 0.0F, 0.0F));
        PartDefinition billLower = head.addOrReplaceChild("billLower", CubeListBuilder.create().texOffs(45, 0).addBox(-1.0F, 0.0F, -0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.5F, 0.6F));
        PartDefinition lLeg01 = body.addOrReplaceChild("lLeg01", CubeListBuilder.create().texOffs(38, 9).mirror().addBox(-1.0F, -0.7F, -1.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.4F, 3.3F, 1.5F, 0.2094F, 0.0F, 0.0F));
        PartDefinition lLeg02 = lLeg01.addOrReplaceChild("lLeg02", CubeListBuilder.create().texOffs(49, 8).mirror().addBox(-0.5F, -0.4F, -1.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, -0.2094F, 0.0F, 0.0F));
        PartDefinition lClaw01 = lLeg02.addOrReplaceChild("lClaw01", CubeListBuilder.create().texOffs(2, 5).mirror().addBox(-0.5F, -0.5F, -3.7F, 1.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 4.6F, -0.4F, 0.0698F, 0.0F, 0.0F));
        PartDefinition lClaw02 = lLeg02.addOrReplaceChild("lClaw02", CubeListBuilder.create().texOffs(0, 0).addBox(-1.1F, 0.0F, -3.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 4.3F, -0.7F, 0.0F, -0.3491F, -0.0349F));
        PartDefinition lClaw03 = lLeg02.addOrReplaceChild("lClaw03", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.9F, 0.0F, -3.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 4.3F, -0.7F, 0.0F, 0.3491F, 0.0349F));
        PartDefinition lClaw04 = lLeg02.addOrReplaceChild("lClaw04", CubeListBuilder.create().texOffs(0, 5).mirror().addBox(0.1F, -0.5F, 0.5F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.2F, 0.0F, -0.3491F, 0.0F, 0.0F));
        PartDefinition rLeg01 = body.addOrReplaceChild("rLeg01", CubeListBuilder.create().texOffs(38, 9).addBox(-1.0F, -0.7F, -1.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4F, 3.3F, 1.5F, 0.2094F, 0.0F, 0.0F));
        PartDefinition rLeg02 = rLeg01.addOrReplaceChild("rLeg02", CubeListBuilder.create().texOffs(49, 8).addBox(-0.5F, -0.4F, -1.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, -0.2094F, 0.0F, 0.0F));
        PartDefinition rClaw01 = rLeg02.addOrReplaceChild("rClaw01", CubeListBuilder.create().texOffs(2, 5).mirror().addBox(-0.5F, -0.5F, -3.7F, 1.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 4.6F, -0.4F, 0.0698F, 0.0F, 0.0F));
        PartDefinition rClaw02 = rLeg02.addOrReplaceChild("rClaw02", CubeListBuilder.create().texOffs(0, 0).addBox(-1.1F, 0.0F, -3.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 4.3F, -0.7F, 0.0F, -0.3491F, -0.0349F));
        PartDefinition rClaw03 = rLeg02.addOrReplaceChild("rClaw03", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.9F, 0.0F, -3.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 4.3F, -0.7F, 0.0F, 0.3491F, 0.0349F));
        PartDefinition rClaw04 = rLeg02.addOrReplaceChild("rClaw04", CubeListBuilder.create().texOffs(0, 5).addBox(-0.1F, -0.5F, 0.6F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.2F, 0.0F, -0.3491F, 0.0F, 0.0F));
        PartDefinition lWing01 = body.addOrReplaceChild("lWing01", CubeListBuilder.create().texOffs(22, 18).mirror().addBox(0.0F, -0.5F, -1.5F, 8.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -2.8F, -4.0F, 0.0F, -1.309F, 0.0F));
        PartDefinition lWing02 = lWing01.addOrReplaceChild("lWing02", CubeListBuilder.create().texOffs(45, 19).mirror().addBox(0.0F, -0.5F, -1.0F, 6.0F, 1.0F, 2.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(7.7F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));
        PartDefinition lWingFeathers02 = lWing02.addOrReplaceChild("lWingFeathers02", CubeListBuilder.create().texOffs(18, 33).addBox(1.1F, 0.01F, -2.7F, 13.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.2F, 0.0F, 0.1222F, 0.2094F));
        PartDefinition lWingFeathers01 = lWing01.addOrReplaceChild("lWingFeathers01", CubeListBuilder.create().texOffs(21, 24).mirror().addBox(-0.2F, 0.0F, -0.7F, 12.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 1.2F));
        PartDefinition rWing01 = body.addOrReplaceChild("rWing01", CubeListBuilder.create().texOffs(22, 18).addBox(-8.0F, -0.5F, -1.5F, 8.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.8F, -4.0F, 0.0F, 1.309F, 0.0F));
        PartDefinition rWing02 = rWing01.addOrReplaceChild("rWing02", CubeListBuilder.create().texOffs(45, 19).addBox(-6.0F, -0.5F, -1.0F, 6.0F, 1.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-7.7F, 0.0F, 0.0F, 0.0F, 0.5236F, 0.0F));
        PartDefinition rWingFeathers02 = rWing02.addOrReplaceChild("rWingFeathers02", CubeListBuilder.create().texOffs(18, 33).mirror().addBox(-14.1F, 0.01F, -2.7F, 13.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 1.2F, 0.0F, -0.1222F, -0.2094F));
        PartDefinition rWingFeathers01 = rWing01.addOrReplaceChild("rWingFeathers01", CubeListBuilder.create().texOffs(21, 24).addBox(-11.8F, 0.0F, -0.7F, 12.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.2F));
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.neck01.xRot = headPitch * 0.017453292F - 0.5235987755982988F;
        this.neck01.zRot = 0F;
        this.head.zRot = netHeadYaw * 0.017453292F;
        this.rLeg01.y = 3.3F;
        this.lLeg01.y = 3.3F;
        this.body.y = 15.3F;
        this.setRotateAngle(rWing01, 0.0F, 1.3089969389957472F, 0.0F);
        this.setRotateAngle(lWing01, 0.0F, -1.3089969389957472F, 0.0F);
        this.setRotateAngle(rWing02, 0.0F, 0.5235987755982988F, 0.0F);
        this.setRotateAngle(lWing02, 0.0F, -0.5235987755982988F, 0.0F);
        this.lLeg01.visible = true;
        this.rLeg01.visible = true;
        if (!entityIn.isInWater()) {
            this.rLeg01.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount + 0.20943951023931953F;
            this.lLeg01.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount + 0.20943951023931953F;
        } else {
            this.lLeg01.visible = false;
            this.rLeg01.visible = false;
        }

        if (entityIn instanceof Player) {
            Player player = (Player) entityIn;
            if (player.isShiftKeyDown()) {
                this.rLeg01.y = 3.3F;
                this.lLeg01.y = 3.3F;
                this.body.y = 15.3F;
            }
            if ((player.getAbilities().mayfly && player.getAbilities().flying) || (player != Minecraft.getInstance().player && player.hasImpulse)) {
                this.rWing01.yRot = 0F;
                this.lWing01.yRot = 0F;
                float rot = Mth.sin(ageInTicks * player.getAbilities().getFlyingSpeed() * 8F) * 0.5F;
                this.rWing01.zRot = rot;
                this.lWing01.zRot = -rot;
                this.rWing02.zRot = rot * 0.8F;
                this.lWing02.zRot = -rot * 0.8F;
                this.lLeg01.visible = false;
                this.rLeg01.visible = false;
                this.neck01.xRot += Math.toRadians(60F);
            }
            if (this.attackTime > 0.0F) {
                float f2 = Mth.sin((1.0F - (float) Math.pow(1.0F - this.attackTime, 3)) * (float) Math.PI);
                float f3 = Mth.sin(this.attackTime * (float) Math.PI) * 0.7F * 0.75F;
                this.neck01.xRot += f2 * 1.2F + f3;
            }
        }
    }

}
