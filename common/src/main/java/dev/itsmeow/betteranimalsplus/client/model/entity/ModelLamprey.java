package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;

/**
 * Lamprey - Batman
 * Created using Tabula 5.1.0
 */
public class ModelLamprey<T extends LivingEntity> extends ModelBAP<T> {
    public ModelPart body01;
    public ModelPart body02;
    public ModelPart head;
    public ModelPart tail01;
    public ModelPart fin01;
    public ModelPart tail02;
    public ModelPart fin02;
    public ModelPart fin03;
    public ModelPart mouth;
    public ModelPart snout;
    public ModelPart jaw;
    public ModelPart lTeeth;
    public ModelPart rTeeth;
    public ModelPart fTeeth;
    private boolean putOnSide = false;

    public ModelLamprey(ModelPart root) {
        this.body01 = root.getChild("body01");
        this.body02 = body01.getChild("body02");
        this.tail01 = body02.getChild("tail01");
        this.tail02 = tail01.getChild("tail02");
        this.fin03 = tail02.getChild("fin03");
        this.fin02 = tail01.getChild("fin02");
        this.fin01 = body02.getChild("fin01");
        this.head = body01.getChild("head");
        this.mouth = head.getChild("mouth");
        this.snout = mouth.getChild("snout");
        this.jaw = mouth.getChild("jaw");
        this.lTeeth = jaw.getChild("lTeeth");
        this.rTeeth = jaw.getChild("rTeeth");
        this.fTeeth = jaw.getChild("fTeeth");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition body01 = partdefinition.addOrReplaceChild("body01", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.0F, -10.0F, 4.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.3F, 0.0F, 0.0175F, 0.0F, 0.0F));
        PartDefinition body02 = body01.addOrReplaceChild("body02", CubeListBuilder.create().texOffs(0, 16).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -0.3F, -0.0456F, 0.0F, 0.0F));
        PartDefinition tail01 = body02.addOrReplaceChild("tail01", CubeListBuilder.create().texOffs(0, 32).addBox(-1.0F, -1.5F, 0.0F, 2.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.4F, 9.6F, -0.0349F, 0.0F, 0.0F));
        PartDefinition tail02 = tail01.addOrReplaceChild("tail02", CubeListBuilder.create().texOffs(0, 45).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.4F, 8.0F));
        PartDefinition fin03 = tail02.addOrReplaceChild("fin03", CubeListBuilder.create().texOffs(0, 100).addBox(0.0F, -3.5F, 0.0F, 0.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.5F));
        PartDefinition fin02 = tail01.addOrReplaceChild("fin02", CubeListBuilder.create().texOffs(0, 91).addBox(0.0F, -4.0F, 0.0F, 0.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.2F, 0.0F));
        PartDefinition fin01 = body02.addOrReplaceChild("fin01", CubeListBuilder.create().texOffs(0, 91).addBox(0.0F, -3.0F, 0.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, 5.4F));
        PartDefinition head = body01.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 54).addBox(-2.0F, -1.5F, -6.0F, 4.0F, 3.0F, 6.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -0.4F, -9.7F, 0.0873F, 0.0F, 0.0F));
        PartDefinition mouth = head.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(0, 64).addBox(-1.5F, -1.0F, -4.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, -5.5F, -0.1745F, 0.0F, 0.0F));
        PartDefinition snout = mouth.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(0, 71).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -4.0F, 0.2269F, 0.0F, 0.0F));
        PartDefinition jaw = mouth.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(0, 77).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.4F, -4.0F, -0.0456F, 0.0F, 0.0F));
        PartDefinition lTeeth = jaw.addOrReplaceChild("lTeeth", CubeListBuilder.create().texOffs(0, 82).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.1F, 0.5F, 0.5F));
        PartDefinition rTeeth = jaw.addOrReplaceChild("rTeeth", CubeListBuilder.create().texOffs(0, 86).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.9F, 0.5F, 0.5F));
        PartDefinition fTeeth = jaw.addOrReplaceChild("fTeeth", CubeListBuilder.create().texOffs(0, 90).addBox(-1.0F, 0.0F, 0.1F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 0.5F, 0.0F));
        return LayerDefinition.create(meshdefinition, 40, 120);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        if (putOnSide) {
            matrixStackIn.mulPose(Vector3f.ZP.rotationDegrees(90F));
            matrixStackIn.translate(1.5F, -1.75F, 0F);
        }
        this.body01.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float factor = (float) entityIn.getDeltaMovement().length() * 10;
        this.body01.yRot = Mth.cos(ageInTicks * 0.3F) * (float) Math.PI * 0.05F * factor;
        this.head.yRot = -this.body01.yRot * 1.5F;
        this.body02.yRot = this.body01.yRot * 1.5F;
        this.tail01.yRot = this.body02.yRot * 1.5F;
        this.putOnSide = !entityIn.isInWater() && !entityIn.isPassenger();
    }

}
