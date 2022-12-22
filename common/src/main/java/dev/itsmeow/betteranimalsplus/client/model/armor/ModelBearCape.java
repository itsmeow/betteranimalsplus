package dev.itsmeow.betteranimalsplus.client.model.armor;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

/**
 * BearCape - cybercat5555
 * Created using Tabula 7.0.1
 */
public class ModelBearCape<T extends LivingEntity> extends HumanoidModel<T> {

    public static ModelBearCape<LivingEntity> INSTANCE = null;

    public ModelPart baseCube;
    public ModelPart bearCapeArmR1;
    public ModelPart bearCapeArmL1;
    public ModelPart bearCapeMain;
    public ModelPart bearCapeArmL2;
    public ModelPart lClaw01;
    public ModelPart lClaw02;
    public ModelPart lClaw03;
    public ModelPart bearCapeLower;
    public ModelPart bearCapeTatter;
    public ModelPart bearCapeArmR2;
    public ModelPart rClaw01;
    public ModelPart rClaw02;
    public ModelPart rClaw03;

    private float f1_r;
    private float f2_r;
    private float f3_r;
    private boolean isPlayer;

    public ModelBearCape(ModelPart root) {
        super(root);
        this.baseCube = body.getChild("baseCube");
        this.bearCapeArmL1 = baseCube.getChild("bearCapeArmL1");
        this.bearCapeArmL2 = bearCapeArmL1.getChild("bearCapeArmL2");
        this.lClaw01 = bearCapeArmL2.getChild("lClaw01");
        this.lClaw02 = bearCapeArmL2.getChild("lClaw02");
        this.lClaw03 = bearCapeArmL2.getChild("lClaw03");
        this.bearCapeMain = baseCube.getChild("bearCapeMain");
        this.bearCapeLower = bearCapeMain.getChild("bearCapeLower");
        this.bearCapeTatter = bearCapeLower.getChild("bearCapeTatter");
        this.bearCapeArmR1 = baseCube.getChild("bearCapeArmR1");
        this.bearCapeArmR2 = bearCapeArmR1.getChild("bearCapeArmR2");
        this.rClaw01 = bearCapeArmR2.getChild("rClaw01");
        this.rClaw02 = bearCapeArmR2.getChild("rClaw02");
        this.rClaw03 = bearCapeArmR2.getChild("rClaw03");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = HumanoidModel.createMesh(new CubeDeformation(0F), 0F);
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition baseCube = partdefinition.getChild("body").addOrReplaceChild("baseCube", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition bearCapeArmL1 = baseCube.addOrReplaceChild("bearCapeArmL1", CubeListBuilder.create().texOffs(97, 0).mirror().addBox(-2.0F, -0.5F, -5.0F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 0.0F, 2.4F, -0.0524F, -0.0698F, 0.1745F));
        PartDefinition bearCapeArmL2 = bearCapeArmL1.addOrReplaceChild("bearCapeArmL2", CubeListBuilder.create().texOffs(97, 8).mirror().addBox(-2.0F, -0.8F, -0.5F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.5F, -4.9F, -0.1047F, 0.0F, 0.0F));
        PartDefinition lClaw01 = bearCapeArmL2.addOrReplaceChild("lClaw01", CubeListBuilder.create().texOffs(109, 8).mirror().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.4F, 2.4F, 0.0F, 0.1396F, 0.0F, 0.1047F));
        PartDefinition lClaw02 = bearCapeArmL2.addOrReplaceChild("lClaw02", CubeListBuilder.create().texOffs(109, 8).mirror().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 2.4F, 0.0F, 0.1396F, 0.0F, 0.0F));
        PartDefinition lClaw03 = bearCapeArmL2.addOrReplaceChild("lClaw03", CubeListBuilder.create().texOffs(109, 8).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4F, 2.4F, 0.0F, 0.1396F, 0.0F, -0.1047F));
        PartDefinition bearCapeMain = baseCube.addOrReplaceChild("bearCapeMain", CubeListBuilder.create().texOffs(71, 0).addBox(-5.0F, 0.0F, 1.6F, 10.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1047F, 0.0F, 0.0F));
        PartDefinition bearCapeLower = bearCapeMain.addOrReplaceChild("bearCapeLower", CubeListBuilder.create().texOffs(71, 11).addBox(-4.5F, 0.0F, -0.5F, 9.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.9F, 2.1F, -0.0873F, 0.0F, 0.0F));
        PartDefinition bearCapeTatter = bearCapeLower.addOrReplaceChild("bearCapeTatter", CubeListBuilder.create().texOffs(71, 21).addBox(-4.0F, 0.0F, -0.5F, 8.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.9F, 0.0F, 0.0873F, 0.0F, 0.0F));
        PartDefinition bearCapeArmR1 = baseCube.addOrReplaceChild("bearCapeArmR1", CubeListBuilder.create().texOffs(97, 0).addBox(-2.0F, -0.5F, -5.0F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 0.0F, 2.4F, -0.0524F, 0.0698F, -0.1745F));
        PartDefinition bearCapeArmR2 = bearCapeArmR1.addOrReplaceChild("bearCapeArmR2", CubeListBuilder.create().texOffs(97, 8).addBox(-2.0F, -0.8F, -0.5F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, -4.9F, -0.1047F, 0.0F, 0.0F));
        PartDefinition rClaw01 = bearCapeArmR2.addOrReplaceChild("rClaw01", CubeListBuilder.create().texOffs(109, 8).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4F, 2.4F, 0.0F, 0.1396F, 0.0F, -0.1047F));
        PartDefinition rClaw02 = bearCapeArmR2.addOrReplaceChild("rClaw02", CubeListBuilder.create().texOffs(109, 8).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.4F, 0.0F, 0.1396F, 0.0F, 0.0F));
        PartDefinition rClaw03 = bearCapeArmR2.addOrReplaceChild("rClaw03", CubeListBuilder.create().texOffs(109, 8).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4F, 2.4F, 0.0F, 0.1396F, 0.0F, 0.1047F));
        PartDefinition bipedLeftArm = partdefinition.addOrReplaceChild("bipedLeftArm", CubeListBuilder.create().texOffs(40, 16).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.0F, 0.0F, -0.1F));
        PartDefinition bipedLeftLeg = partdefinition.addOrReplaceChild("bipedLeftLeg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.9F, 12.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.leftArm.visible = false;
        this.rightArm.visible = false;
        if (isPlayer) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.0F, 0.05F, 0.025F);
            float angle = 6.0F + f2_r / 2.0F + f1_r;
            angle = Math.min(angle, 90F);
            matrixStackIn.mulPose(Axis.XP.rotationDegrees(angle));
            matrixStackIn.mulPose(Axis.ZP.rotationDegrees(f3_r / 2.0F));
            super.renderToBuffer(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            matrixStackIn.popPose();
            this.bearCapeArmL1.visible = true;
            this.bearCapeArmR1.visible = true;
            this.bearCapeMain.visible = false;
            super.renderToBuffer(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            this.bearCapeArmL1.visible = false;
            this.bearCapeArmR1.visible = false;
            this.bearCapeMain.visible = true;
        } else {
            this.bearCapeArmL1.visible = true;
            this.bearCapeArmR1.visible = true;
            super.renderToBuffer(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        }
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float f33, float f44) {
        this.isPlayer = entity instanceof Player;
        if (isPlayer) {
            Player player = (Player) entity;
            float partialTicks = Minecraft.getInstance().getFrameTime();
            double d0 = player.xCloakO + (player.xCloak - player.xCloakO) * (double) partialTicks - (player.xo + (player.getX() - player.xo) * (double) partialTicks);
            double d1 = player.yCloakO + (player.yCloak - player.yCloakO) * (double) partialTicks - (player.yo + (player.getY() - player.yo) * (double) partialTicks);
            double d2 = player.zCloakO + (player.zCloak - player.zCloakO) * (double) partialTicks - (player.zo + (player.getZ() - player.zo) * (double) partialTicks);
            float f = player.yBodyRotO + (player.yBodyRot - player.yBodyRotO) * partialTicks;
            double d3 = Mth.sin(f * 0.017453292F);
            double d4 = -Mth.cos(f * 0.017453292F);
            float f1 = (float) d1 * 10.0F;
            f1 = Mth.clamp(f1, -6.0F, 32.0F);
            float f2 = (float) (d0 * d3 + d2 * d4) * 100.0F;
            float f3 = (float) (d0 * d4 - d2 * d3) * 100.0F;

            if (f2 < 0.0F) {
                f2 = 0.0F;
            }

            float f4 = player.oBob + (player.bob - player.oBob) * partialTicks;
            f1 = f1 + Mth.sin((player.walkDistO + (player.walkDist - player.walkDistO) * partialTicks) * 6.0F) * 32.0F * f4;
            this.f1_r = f1;
            this.f2_r = f2;
            this.f3_r = f3;
        }
    }

}
