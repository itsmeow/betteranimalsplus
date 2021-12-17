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
 * EelFreshWater - Batman Created using Tabula 7.0.1
 */
public class ModelFreshwaterEel<T extends LivingEntity> extends ModelBAP<T> {

    public ModelPart body;
    public ModelPart rear;
    public ModelPart neck;
    public ModelPart topFin1;
    public ModelPart lowFin1;
    public ModelPart lFin;
    public ModelPart rFin;
    public ModelPart tail1;
    public ModelPart topFin2;
    public ModelPart lowFin2;
    public ModelPart tail2;
    public ModelPart topFin3;
    public ModelPart lowFin3;
    public ModelPart topFin4;
    public ModelPart lowFin4;
    public ModelPart topJaw;
    public ModelPart lowJaw;
    public ModelPart snout;
    public ModelPart noseNubL;
    public ModelPart noseNubR;
    public ModelPart topTeeth1;
    public ModelPart topTeeth2;
    public ModelPart topTeeth3;
    public ModelPart lowTeeth;

    public ModelFreshwaterEel(ModelPart root) {
        this.body = root.getChild("body");
        this.rear = body.getChild("rear");
        this.tail1 = rear.getChild("tail1");
        this.tail2 = tail1.getChild("tail2");
        this.topFin4 = tail2.getChild("topFin4");
        this.lowFin4 = tail2.getChild("lowFin4");
        this.topFin3 = tail1.getChild("topFin3");
        this.lowFin3 = tail1.getChild("lowFin3");
        this.topFin2 = rear.getChild("topFin2");
        this.lowFin2 = rear.getChild("lowFin2");
        this.neck = body.getChild("neck");
        this.topJaw = neck.getChild("topJaw");
        this.snout = topJaw.getChild("snout");
        this.topTeeth1 = topJaw.getChild("topTeeth1");
        this.topTeeth2 = topJaw.getChild("topTeeth2");
        this.topTeeth3 = topJaw.getChild("topTeeth3");
        this.lowJaw = neck.getChild("lowJaw");
        this.lowTeeth = lowJaw.getChild("lowTeeth");
        this.topFin1 = body.getChild("topFin1");
        this.lowFin1 = body.getChild("lowFin1");
        this.lFin = body.getChild("lFin");
        this.rFin = body.getChild("rFin");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -1.5F, -10.0F, 4.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.3F, 0.0F));
        PartDefinition rear = body.addOrReplaceChild("rear", CubeListBuilder.create().texOffs(0, 16).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -0.05F));
        PartDefinition tail1 = rear.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(0, 32).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 9.85F));
        PartDefinition tail2 = tail1.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(0, 45).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 8.0F));
        PartDefinition topFin4 = tail2.addOrReplaceChild("topFin4", CubeListBuilder.create().texOffs(0, 84).addBox(0.0F, -3.0F, 0.0F, 0.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));
        PartDefinition lowFin4 = tail2.addOrReplaceChild("lowFin4", CubeListBuilder.create().texOffs(0, 103).addBox(0.0F, 0.0F, 0.0F, 0.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));
        PartDefinition topFin3 = tail1.addOrReplaceChild("topFin3", CubeListBuilder.create().texOffs(0, 81).addBox(0.0F, -3.0F, 0.0F, 0.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));
        PartDefinition lowFin3 = tail1.addOrReplaceChild("lowFin3", CubeListBuilder.create().texOffs(0, 100).addBox(0.0F, 0.0F, 0.0F, 0.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));
        PartDefinition topFin2 = rear.addOrReplaceChild("topFin2", CubeListBuilder.create().texOffs(0, 75).addBox(0.0F, -3.0F, 0.0F, 0.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, 0.0F));
        PartDefinition lowFin2 = rear.addOrReplaceChild("lowFin2", CubeListBuilder.create().texOffs(0, 94).addBox(0.0F, -3.0F, 0.0F, 0.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.5F, 0.0F));
        PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 55).addBox(-2.0F, -1.5F, -6.0F, 4.0F, 3.0F, 6.0F, new CubeDeformation(-0.1F)), PartPose.offset(0.0F, 0.0F, -9.7F));
        PartDefinition topJaw = neck.addOrReplaceChild("topJaw", CubeListBuilder.create().texOffs(0, 65).addBox(-2.0F, -0.5F, -3.0F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.1F, -6.0F, -0.0456F, 0.0F, 0.0F));
        PartDefinition snout = topJaw.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(0, 70).addBox(-1.5F, -0.5F, 0.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.8F, 0.3187F, 0.0F, 0.0F));
        PartDefinition topTeeth1 = topJaw.addOrReplaceChild("topTeeth1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, -0.2F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.1F, 0.2F, -2.5F));
        PartDefinition topTeeth2 = topJaw.addOrReplaceChild("topTeeth2", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, -0.2F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.1F, 0.2F, -2.5F));
        PartDefinition topTeeth3 = topJaw.addOrReplaceChild("topTeeth3", CubeListBuilder.create().texOffs(0, 4).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -2.6F));
        PartDefinition lowJaw = neck.addOrReplaceChild("lowJaw", CubeListBuilder.create().texOffs(0, 75).addBox(-1.5F, -0.5F, -3.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -5.8F, 0.7741F, 0.0F, 0.0F));
        PartDefinition lowTeeth = lowJaw.addOrReplaceChild("lowTeeth", CubeListBuilder.create().texOffs(0, 6).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.2F, -2.5F));
        PartDefinition topFin1 = body.addOrReplaceChild("topFin1", CubeListBuilder.create().texOffs(0, 76).addBox(0.0F, -3.0F, 0.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, -5.0F));
        PartDefinition lowFin1 = body.addOrReplaceChild("lowFin1", CubeListBuilder.create().texOffs(0, 97).addBox(0.0F, 0.0F, 0.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.5F, -3.0F));
        PartDefinition lFin = body.addOrReplaceChild("lFin", CubeListBuilder.create().texOffs(0, 12).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, -9.5F, 0.0F, 0.3643F, -0.3187F));
        PartDefinition rFin = body.addOrReplaceChild("rFin", CubeListBuilder.create().texOffs(0, 12).mirror().addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 0.0F, -9.5F, 0.0F, -0.3643F, 0.3187F));
        return LayerDefinition.create(meshdefinition, 40, 130);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float factor = (float) entity.getDeltaMovement().length() * 10;
        this.body.yRot = Mth.cos(ageInTicks * 0.3F) * (float) Math.PI * 0.05F * factor;
        this.neck.yRot = -this.body.yRot * 1.5F;
        this.rear.yRot = this.body.yRot * 1.5F;
        this.tail1.yRot = this.rear.yRot * 1.5F;
    }

}
