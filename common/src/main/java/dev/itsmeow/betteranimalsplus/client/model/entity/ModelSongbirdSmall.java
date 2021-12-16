package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import dev.itsmeow.betteranimalsplus.common.entity.EntitySongbird;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;

/**
 * songbirdSmall - cybercat5555 Created using Tabula 5.1.0
 */
public class ModelSongbirdSmall<T extends LivingEntity> extends ModelBAP<T> {

    public ModelPart body;
    public ModelPart tailBase;
    public ModelPart lLeg01;
    public ModelPart rLeg01;
    public ModelPart neck;
    public ModelPart lWing01;
    public ModelPart rWing01;
    public ModelPart tailCoverts;
    public ModelPart lTailFeather01;
    public ModelPart rTailFeather01;
    public ModelPart lTailFeather02;
    public ModelPart rTailFeather02;
    public ModelPart lTailFeather03;
    public ModelPart rTailFeather03;
    public ModelPart lLeg02;
    public ModelPart lFoot;
    public ModelPart rLeg02;
    public ModelPart rFoot;
    public ModelPart head;
    public ModelPart beak01;
    public ModelPart crest;
    public ModelPart beak02;
    public ModelPart beak02b;
    public ModelPart lWing02;
    public ModelPart lWingFeather01;
    public ModelPart lWing03;
    public ModelPart lWingFeather02;
    public ModelPart lWingFeather03;
    public ModelPart rWing02;
    public ModelPart rWingFeather01;
    public ModelPart rWing03;
    public ModelPart rWingFeather02;
    public ModelPart rWingFeather03;

    public ModelSongbirdSmall(ModelPart root) {
        this.body = root.getChild("body");
        this.tailBase = body.getChild("tailBase");
        this.tailCoverts = tailBase.getChild("tailCoverts");
        this.lTailFeather01 = tailBase.getChild("lTailFeather01");
        this.rTailFeather01 = tailBase.getChild("rTailFeather01");
        this.lTailFeather02 = tailBase.getChild("lTailFeather02");
        this.rTailFeather02 = tailBase.getChild("rTailFeather02");
        this.lTailFeather03 = tailBase.getChild("lTailFeather03");
        this.rTailFeather03 = tailBase.getChild("rTailFeather03");
        this.lLeg01 = body.getChild("lLeg01");
        this.lLeg02 = lLeg01.getChild("lLeg02");
        this.lFoot = lLeg02.getChild("lFoot");
        this.rLeg01 = body.getChild("rLeg01");
        this.rLeg02 = rLeg01.getChild("rLeg02");
        this.rFoot = rLeg02.getChild("rFoot");
        this.neck = body.getChild("neck");
        this.head = neck.getChild("head");
        this.beak01 = head.getChild("beak01");
        this.beak02 = beak01.getChild("beak02");
        this.beak02b = beak02.getChild("beak02b");
        this.crest = head.getChild("crest");
        this.lWing01 = body.getChild("lWing01");
        this.lWing02 = lWing01.getChild("lWing02");
        this.lWing03 = lWing02.getChild("lWing03");
        this.lWingFeather03 = lWing03.getChild("lWingFeather03");
        this.lWingFeather02 = lWing02.getChild("lWingFeather02");
        this.lWingFeather01 = lWing01.getChild("lWingFeather01");
        this.rWing01 = body.getChild("rWing01");
        this.rWing02 = rWing01.getChild("rWing02");
        this.rWing03 = rWing02.getChild("rWing03");
        this.rWingFeather03 = rWing03.getChild("rWingFeather03");
        this.rWingFeather02 = rWing02.getChild("rWingFeather02");
        this.rWingFeather01 = rWing01.getChild("rWingFeather01");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -3.0F, -4.5F, 6.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 16.5F, 0.0F, -0.2618F, 0.0F, 0.0F));
        PartDefinition tailBase = body.addOrReplaceChild("tailBase", CubeListBuilder.create().texOffs(0, 16).addBox(-2.5F, -1.5F, 0.2F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.9F, 2.1F, 0.1047F, 0.0F, 0.0F));
        PartDefinition tailCoverts = tailBase.addOrReplaceChild("tailCoverts", CubeListBuilder.create().texOffs(0, 26).addBox(-2.0F, 1.5F, -0.1F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.3F, -0.9F, 0.1047F, 0.0F, 0.0F));
        PartDefinition lTailFeather01 = tailBase.addOrReplaceChild("lTailFeather01", CubeListBuilder.create().texOffs(-6, 37).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7F, -0.3F, 5.2F, 0.0698F, -0.0524F, 0.0F));
        PartDefinition rTailFeather01 = tailBase.addOrReplaceChild("rTailFeather01", CubeListBuilder.create().texOffs(-6, 37).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.7F, -0.3F, 5.2F, 0.0698F, 0.0524F, 0.0F));
        PartDefinition lTailFeather02 = tailBase.addOrReplaceChild("lTailFeather02", CubeListBuilder.create().texOffs(-6, 37).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4F, -0.1F, 4.4F, 0.0698F, -0.0698F, 0.0F));
        PartDefinition rTailFeather02 = tailBase.addOrReplaceChild("rTailFeather02", CubeListBuilder.create().texOffs(-6, 37).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.4F, -0.1F, 4.4F, 0.0698F, 0.0698F, 0.0F));
        PartDefinition lTailFeather03 = tailBase.addOrReplaceChild("lTailFeather03", CubeListBuilder.create().texOffs(-6, 37).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1F, 0.1F, 3.5F, 0.0698F, -0.1745F, 0.0F));
        PartDefinition rTailFeather03 = tailBase.addOrReplaceChild("rTailFeather03", CubeListBuilder.create().texOffs(-6, 37).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.1F, 0.1F, 3.5F, 0.0698F, 0.1745F, 0.0F));
        PartDefinition lLeg01 = body.addOrReplaceChild("lLeg01", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -0.2F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7F, 2.1F, 1.0F, 0.2618F, 0.0F, 0.0F));
        PartDefinition lLeg02 = lLeg01.addOrReplaceChild("lLeg02", CubeListBuilder.create().texOffs(34, 0).addBox(-0.5F, -0.2F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.3F, 0.0F, -0.2094F, 0.0F, 0.0F));
        PartDefinition lFoot = lLeg02.addOrReplaceChild("lFoot", CubeListBuilder.create().texOffs(39, 0).addBox(-0.49F, -0.5F, -2.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.7F, 0.0F, 0.192F, -0.0524F, 0.0F));
        PartDefinition rLeg01 = body.addOrReplaceChild("rLeg01", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-1.0F, -0.2F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.7F, 2.1F, 1.0F, 0.2618F, 0.0F, 0.0F));
        PartDefinition rLeg02 = rLeg01.addOrReplaceChild("rLeg02", CubeListBuilder.create().texOffs(34, 0).mirror().addBox(-0.5F, -0.2F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.3F, 0.0F, -0.2094F, 0.0F, 0.0F));
        PartDefinition rFoot = rLeg02.addOrReplaceChild("rFoot", CubeListBuilder.create().texOffs(39, 0).mirror().addBox(-0.51F, -0.5F, -2.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.7F, 0.0F, 0.192F, 0.0524F, 0.0F));
        PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(31, 9).addBox(-1.5F, -2.1F, -3.8F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.9F, -0.2793F, 0.0F, 0.0F));
        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(25, 17).addBox(-2.0F, -2.1F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.2F, -1.5F, 0.5411F, 0.0F, 0.0F));
        PartDefinition beak01 = head.addOrReplaceChild("beak01", CubeListBuilder.create().texOffs(49, 0).addBox(-0.5F, -0.9F, -2.3F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.7F, -4.2F, 0.2094F, 0.0F, 0.0F));
        PartDefinition beak02 = beak01.addOrReplaceChild("beak02", CubeListBuilder.create().texOffs(49, 5).addBox(-0.6F, -0.5F, -2.6F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, 0.2F, -0.2793F, 0.0F, 0.0F));
        PartDefinition beak02b = beak02.addOrReplaceChild("beak02b", CubeListBuilder.create().texOffs(49, 5).mirror().addBox(-0.4F, -0.5F, -2.6F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition crest = head.addOrReplaceChild("crest", CubeListBuilder.create().texOffs(43, 11).addBox(-1.5F, -2.5F, -1.5F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.4F, -1.5F, 0.4712F, 0.0F, 0.0F));
        PartDefinition lWing01 = body.addOrReplaceChild("lWing01", CubeListBuilder.create().texOffs(0, 49).addBox(-0.8F, -0.5F, -1.5F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9F, -1.1F, -1.9F, 0.0F, -1.0821F, 0.9425F));
        PartDefinition lWing02 = lWing01.addOrReplaceChild("lWing02", CubeListBuilder.create().texOffs(0, 55).addBox(0.0F, -0.5F, -0.4F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1F, 0.0F, -1.1F, -0.3665F, -0.5236F, 0.0F));
        PartDefinition lWing03 = lWing02.addOrReplaceChild("lWing03", CubeListBuilder.create().texOffs(0, 60).addBox(0.0F, -0.5F, -0.4F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8F, 0.0F, 0.0F, 0.0F, -0.2618F, 0.0F));
        PartDefinition lWingFeather03 = lWing03.addOrReplaceChild("lWingFeather03", CubeListBuilder.create().texOffs(15, 47).addBox(-1.5F, 0.0F, -1.4F, 9.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(1.8F, 0.0F, 1.0F));
        PartDefinition lWingFeather02 = lWing02.addOrReplaceChild("lWingFeather02", CubeListBuilder.create().texOffs(16, 38).addBox(-2.1F, 0.0F, -0.4F, 4.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(2.3F, 0.0F, 1.3F));
        PartDefinition lWingFeather01 = lWing01.addOrReplaceChild("lWingFeather01", CubeListBuilder.create().texOffs(17, 30).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8F, 0.0F, 0.5F, -0.5585F, 0.0F, 0.0F));
        PartDefinition rWing01 = body.addOrReplaceChild("rWing01", CubeListBuilder.create().texOffs(0, 49).mirror().addBox(-4.0F, -0.5F, -1.5F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.9F, -1.1F, -1.9F, 0.0F, 1.0821F, -0.9425F));
        PartDefinition rWing02 = rWing01.addOrReplaceChild("rWing02", CubeListBuilder.create().texOffs(0, 55).mirror().addBox(-4.0F, -0.5F, -0.4F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 0.0F, -1.1F, -0.3665F, 0.5236F, 0.0F));
        PartDefinition rWing03 = rWing02.addOrReplaceChild("rWing03", CubeListBuilder.create().texOffs(0, 60).mirror().addBox(-3.0F, -0.5F, -0.4F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.8F, 0.0F, 0.0F, 0.0F, 0.2618F, 0.0F));
        PartDefinition rWingFeather03 = rWing03.addOrReplaceChild("rWingFeather03", CubeListBuilder.create().texOffs(15, 47).mirror().addBox(-7.5F, 0.0F, -1.4F, 9.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.8F, 0.0F, 1.0F));
        PartDefinition rWingFeather02 = rWing02.addOrReplaceChild("rWingFeather02", CubeListBuilder.create().texOffs(16, 38).mirror().addBox(-1.9F, 0.0F, -0.4F, 4.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.3F, 0.0F, 1.3F));
        PartDefinition rWingFeather01 = rWing01.addOrReplaceChild("rWingFeather01", CubeListBuilder.create().texOffs(17, 30).mirror().addBox(-2.5F, 0.0F, 0.0F, 5.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.8F, 0.0F, 0.5F, -0.5585F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T entity, float f, float f1, float f2, float f3, float f4) {
        if (entity instanceof EntitySongbird) {
            EntitySongbird bird = (EntitySongbird) entity;
            boolean show;
            if (bird.isFlying()) {
                this.rWing01.yRot = 0F;
                this.lWing01.yRot = 0F;
                this.rWing02.yRot = 0F;
                this.lWing02.yRot = 0F;

                this.rWing01.xRot = 0F;
                this.lWing01.xRot = 0F;
                this.rWing02.xRot = 0F;
                this.lWing02.xRot = 0F;

                this.lWingFeather01.xRot = 0F;
                this.rWingFeather01.xRot = 0F;

                this.rLeg01.xRot = 0.2617993877991494F;
                this.lLeg01.xRot = 0.2617993877991494F;

                this.rWing01.zRot = Mth.cos(f2) * (float) Math.PI / 5F;
                if ((Math.abs(bird.getDeltaMovement().y()) > 0 && (Math.abs(bird.getDeltaMovement().x()) > 0.05 || Math.abs(bird.getDeltaMovement().z()) > 0.05)) || Math.abs(bird.getDeltaMovement().y()) > 0.25) {
                    float rotX = -((float) Math.atan2(bird.getDeltaMovement().y(), Math.sqrt(Math.pow(bird.getDeltaMovement().x(), 2) + Math.pow(bird.getDeltaMovement().z(), 2))) / 1.5F);
                    if (rotX < 0) {
                        rotX /= 3;
                    }
                    this.body.xRot = rotX - 0.2617993877991494F;
                } else {
                    this.body.xRot = -0.2617993877991494F;
                }

                this.lWing01.zRot = -this.rWing01.zRot;
                this.rWing02.zRot = this.rWing01.zRot * 0.5F;
                this.lWing02.zRot = -this.rWing01.zRot * 0.5F;
                show = false;
            } else {
                this.setRotateAngle(rWing01, 0.0F, 1.0821041362364843F, -0.9424777960769379F);
                this.setRotateAngle(lWing01, 0.0F, -1.0821041362364843F, 0.9424777960769379F);
                this.setRotateAngle(rWing02, -0.3665191429188092F, 0.5235987755982988F, 0.0F);
                this.setRotateAngle(lWing02, -0.3665191429188092F, -0.5235987755982988F, 0.0F);
                this.lWingFeather01.xRot = -0.5585053606381855F;
                this.rWingFeather01.xRot = -0.5585053606381855F;
                this.body.xRot = -0.2617993877991494F;

                boolean flag = entity.getFallFlyingTicks() > 4;
                float e = 1.0F;

                if (flag) {
                    e = (float) (entity.getDeltaMovement().x() * entity.getDeltaMovement().x() + entity.getDeltaMovement().y() * entity.getDeltaMovement().y() + entity.getDeltaMovement().z() * entity.getDeltaMovement().z());
                    e = e / 0.2F;
                    e = e * e * e;
                }

                if (e < 1.0F) {
                    e = 1.0F;
                }

                this.rLeg01.xRot = Mth.cos(f * 0.6662F) * 1.4F * f1 / e + 0.2617993877991494F;
                this.lLeg01.xRot = Mth.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1 / e + 0.2617993877991494F;
                show = true;
            }
            this.lLeg01.visible = show;
            this.lLeg02.visible = show;
            this.rLeg01.visible = show;
            this.rLeg02.visible = show;
            this.lFoot.visible = show;
            this.rFoot.visible = show;
        }
    }

}
