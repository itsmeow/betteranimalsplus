package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;

public class ModelBarracuda<T extends LivingEntity> extends ModelBAP<T> {

    public ModelPart body;
    public ModelPart rear;
    public ModelPart tail;
    public ModelPart tail2;
    public ModelPart tail3;
    public ModelPart tailfin;
    public ModelPart topfin2;
    public ModelPart lowfin;
    public ModelPart neck;
    public ModelPart head;
    public ModelPart topjaw;
    public ModelPart snout;
    public ModelPart topteeth1;
    public ModelPart topteeth2;
    public ModelPart lowerjaw;
    public ModelPart lowteeth;
    public ModelPart rightfin01;
    public ModelPart leftfin2;
    public ModelPart leftfin01;
    public ModelPart rightfin2;
    public ModelPart topfin1;
    public ModelPart rightlowfin;
    public ModelPart leftlowfin;

    public ModelBarracuda(ModelPart root) {
        this.body = root.getChild("body");
        this.rear = body.getChild("rear");
        this.tail = rear.getChild("tail");
        this.tail2 = tail.getChild("tail2");
        this.tail3 = tail2.getChild("tail3");
        this.tailfin = tail3.getChild("tailfin");
        this.topfin2 = rear.getChild("topfin2");
        this.lowfin = rear.getChild("lowfin");
        this.neck = body.getChild("neck");
        this.head = neck.getChild("head");
        this.topjaw = head.getChild("topjaw");
        this.snout = topjaw.getChild("snout");
        this.topteeth1 = topjaw.getChild("topteeth1");
        this.topteeth2 = topjaw.getChild("topteeth2");
        this.lowerjaw = head.getChild("lowerjaw");
        this.lowteeth = lowerjaw.getChild("lowteeth");
        this.rightfin01 = neck.getChild("rightfin01");
        this.leftfin2 = rightfin01.getChild("leftfin2");
        this.leftfin01 = neck.getChild("leftfin01");
        this.rightfin2 = leftfin01.getChild("rightfin2");
        this.topfin1 = body.getChild("topfin1");
        this.rightlowfin = body.getChild("rightlowfin");
        this.leftlowfin = body.getChild("leftlowfin");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -4.0F, -13.0F, 7.0F, 7.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 14.0F, 3.0F, 0.007F, 0.0F, 0.0F));
        PartDefinition rear = body.addOrReplaceChild("rear", CubeListBuilder.create().texOffs(0, 22).addBox(-3.0F, -3.5F, 0.0F, 6.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.4F, 0.0F, -0.0087F, 0.0F, 0.0F));
        PartDefinition tail = rear.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 41).addBox(-2.0F, -2.5F, 0.0F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.9F, 11.0F));
        PartDefinition tail2 = tail.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(20, 41).addBox(-1.5F, -2.5F, 0.0F, 3.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, 5.0F));
        PartDefinition tail3 = tail2.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(0, 53).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 5.0F));
        PartDefinition tailfin = tail3.addOrReplaceChild("tailfin", CubeListBuilder.create().texOffs(18, 44).addBox(0.0F, -8.0F, 0.0F, 0.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 4.0F));
        PartDefinition topfin2 = rear.addOrReplaceChild("topfin2", CubeListBuilder.create().texOffs(13, 115).addBox(0.0F, 0.0F, 0.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.7F, 3.7F, 0.5463F, 0.0F, 0.0F));
        PartDefinition lowfin = rear.addOrReplaceChild("lowfin", CubeListBuilder.create().texOffs(27, 115).addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.7F, 4.9F, -0.7741F, 0.0F, 0.0F));
        PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 68).addBox(-3.0F, -4.0F, -4.0F, 6.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -12.3F, 0.0456F, 0.0F, 0.0F));
        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(21, 71).addBox(-2.5F, -4.0F, -5.0F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.9F));
        PartDefinition topjaw = head.addOrReplaceChild("topjaw", CubeListBuilder.create().texOffs(0, 81).addBox(-2.0F, -1.0F, -12.0F, 4.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.7F, -2.9F, -0.0911F, 0.0F, 0.0F));
        PartDefinition snout = topjaw.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(22, 85).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -11.8F, 0.1855F, 0.0F, 0.0F));
        PartDefinition topteeth1 = topjaw.addOrReplaceChild("topteeth1", CubeListBuilder.create().texOffs(23, 99).addBox(-2.0F, 0.0F, 0.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(1.8F, 1.0F, -11.9F));
        PartDefinition topteeth2 = topjaw.addOrReplaceChild("topteeth2", CubeListBuilder.create().texOffs(0, 95).addBox(-2.0F, 0.0F, 0.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.2F, 1.0F, -11.9F));
        PartDefinition lowerjaw = head.addOrReplaceChild("lowerjaw", CubeListBuilder.create().texOffs(39, 79).addBox(-1.5F, -1.0F, -11.0F, 3.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.3F, -4.5F, -0.1367F, 0.0F, 0.0F));
        PartDefinition lowteeth = lowerjaw.addOrReplaceChild("lowteeth", CubeListBuilder.create().texOffs(0, 108).addBox(-2.0F, 0.0F, 0.0F, 2.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -2.0F, -9.9F, -0.0489F, 0.0F, 0.0F));
        PartDefinition rightfin01 = neck.addOrReplaceChild("rightfin01", CubeListBuilder.create().texOffs(16, 112).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 0.7F, -1.0F, -0.4098F, -0.6829F, 0.0F));
        PartDefinition leftfin2 = rightfin01.addOrReplaceChild("leftfin2", CubeListBuilder.create().texOffs(26, 109).addBox(0.0F, -1.5F, 0.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 0.6F));
        PartDefinition leftfin01 = neck.addOrReplaceChild("leftfin01", CubeListBuilder.create().texOffs(16, 112).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.7F, -1.0F, -0.4098F, 0.6829F, 0.0F));
        PartDefinition rightfin2 = leftfin01.addOrReplaceChild("rightfin2", CubeListBuilder.create().texOffs(26, 109).addBox(0.0F, -1.5F, 0.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 0.6F));
        PartDefinition topfin1 = body.addOrReplaceChild("topfin1", CubeListBuilder.create().texOffs(0, 115).addBox(0.0F, -5.0F, 0.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -9.0F, -0.2276F, 0.0F, 0.0F));
        PartDefinition rightlowfin = body.addOrReplaceChild("rightlowfin", CubeListBuilder.create().texOffs(37, 109).addBox(0.0F, -1.5F, 0.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6F, 2.0F, -11.0F, -0.6829F, 0.0F, 0.5009F));
        PartDefinition leftlowfin = body.addOrReplaceChild("leftlowfin", CubeListBuilder.create().texOffs(37, 109).addBox(0.0F, -1.5F, 0.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6F, 2.0F, -11.0F, -0.6829F, 0.0F, -0.5009F));
        return LayerDefinition.create(meshdefinition, 70, 130);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float factor = (float) entityIn.getDeltaMovement().length() * 10;
        this.body.yRot = Mth.cos(ageInTicks * 0.3F) * (float) Math.PI * 0.05F * factor;
        this.head.yRot = -this.body.yRot * 1.5F;
        this.rear.yRot = this.body.yRot * 1.5F;
        this.tail.yRot = this.rear.yRot * 1.5F;
    }
}
