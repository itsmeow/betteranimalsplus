package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;

/**
 * Flying fish - Batman
 * Created using Tabula 7.0.1
 */
public class ModelFlyingFish<T extends LivingEntity> extends ModelBAP<T> {

    public ModelPart front;
    public ModelPart rear;
    public ModelPart head;
    public ModelPart leftFin;
    public ModelPart rightFin;
    public ModelPart rLF;
    public ModelPart tail;
    public ModelPart lLF;
    public ModelPart tail2;
    public ModelPart tTailFin;
    public ModelPart lTailFin;
    public ModelPart tailFin;
    public ModelPart topJaw;
    public ModelPart lowerJaw;
    public ModelPart snout;

    public ModelFlyingFish(ModelPart root) {
        this.front = root.getChild("front");
        this.rear = front.getChild("rear");
        this.tail = rear.getChild("tail");
        this.tail2 = tail.getChild("tail2");
        this.tailFin = tail2.getChild("tailFin");
        this.tTailFin = tail.getChild("tTailFin");
        this.lTailFin = tail.getChild("lTailFin");
        this.lLF = rear.getChild("lLF");
        this.head = front.getChild("head");
        this.topJaw = head.getChild("topJaw");
        this.snout = topJaw.getChild("snout");
        this.lowerJaw = head.getChild("lowerJaw");
        this.leftFin = front.getChild("leftFin");
        this.rightFin = front.getChild("rightFin");
        this.rLF = front.getChild("rLF");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition front = partdefinition.addOrReplaceChild("front", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -2.5F, -9.0F, 5.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, 0.0F));
        PartDefinition rear = front.addOrReplaceChild("rear", CubeListBuilder.create().texOffs(0, 15).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.2F, 0.0F));
        PartDefinition tail = rear.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 28).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 8.0F));
        PartDefinition tail2 = tail.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(0, 36).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 2.5F));
        PartDefinition tailFin = tail2.addOrReplaceChild("tailFin", CubeListBuilder.create().texOffs(0, 36).addBox(0.0F, -4.0F, 0.0F, 0.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 2.6F));
        PartDefinition tTailFin = tail.addOrReplaceChild("tTailFin", CubeListBuilder.create().texOffs(0, 97).addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.8F, 0.3F, -0.3187F, 0.0F, 0.0F));
        PartDefinition lTailFin = tail.addOrReplaceChild("lTailFin", CubeListBuilder.create().texOffs(8, 97).addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.7F, -0.1F, 0.4554F, 0.0F, 0.0F));
        PartDefinition lLF = rear.addOrReplaceChild("lLF", CubeListBuilder.create().texOffs(0, 99).mirror().addBox(0.0F, 0.0F, -2.0F, 0.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.3F, 1.2F, 4.0F, 0.182F, 0.0F, -0.3643F));
        PartDefinition head = front.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 52).addBox(-2.0F, -2.5F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.5F, 0.0298F, 0.0F, 0.0F));
        PartDefinition topJaw = head.addOrReplaceChild("topJaw", CubeListBuilder.create().texOffs(0, 61).addBox(-1.5F, -0.5F, -3.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.6F, -3.5F, -0.3187F, 0.0F, 0.0F));
        PartDefinition snout = topJaw.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(0, 67).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -3.0F, 0.4517F, 0.0F, 0.0F));
        PartDefinition lowerJaw = head.addOrReplaceChild("lowerJaw", CubeListBuilder.create().texOffs(0, 72).addBox(-1.0F, -0.5F, -3.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -3.7F, -0.3643F, 0.0F, 0.0F));
        PartDefinition leftFin = front.addOrReplaceChild("leftFin", CubeListBuilder.create().texOffs(0, 65).mirror().addBox(0.0F, 0.0F, -3.0F, 0.0F, 20.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.1F, 0.0F, -6.0F, 0.0F, 0.0F, -1.3659F));
        PartDefinition rightFin = front.addOrReplaceChild("rightFin", CubeListBuilder.create().texOffs(0, 65).mirror().addBox(0.0F, 0.0F, -3.0F, 0.0F, 20.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.1F, 0.0F, -6.0F, 0.0F, 0.0F, 1.3659F));
        PartDefinition rLF = front.addOrReplaceChild("rLF", CubeListBuilder.create().texOffs(0, 99).mirror().addBox(0.0F, 0.0F, -2.0F, 0.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.3F, 1.2F, 4.0F, 0.182F, 0.0F, 0.3643F));
        return LayerDefinition.create(meshdefinition, 30, 120);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.front.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float factor = (float) entityIn.getDeltaMovement().length() * 10;
        this.front.yRot = Mth.cos(ageInTicks * 0.3F) * (float) Math.PI * 0.05F * factor;
        this.head.yRot = -this.front.yRot * 1.5F;
        this.rear.yRot = this.front.yRot * 1.5F;
        this.tail.yRot = this.rear.yRot * 1.5F;
        this.rightFin.xRot = 0F;
        this.leftFin.xRot = 0F;
        this.rightFin.zRot = (this.front.yRot * 2F) + 1.3658946726107624F;
        this.leftFin.zRot = -(this.front.yRot * 2F) - 1.3658946726107624F;
    }

}
