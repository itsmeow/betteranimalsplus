package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;

public class ModelHorseshoeCrab<T extends LivingEntity> extends ModelBAP<T> {

    public ModelPart head;
    public ModelPart lowerBody;
    public ModelPart spine;
    public ModelPart cube_r1;
    public ModelPart tail;
    public ModelPart lSpinePlate;
    public ModelPart cube_r2;
    public ModelPart rSpinePlate;
    public ModelPart cube_r3;
    public ModelPart lRidge;
    public ModelPart cube_r4;
    public ModelPart rRidge;
    public ModelPart cube_r5;
    public ModelPart lLeg01;
    public ModelPart cube_r6;
    public ModelPart lLeg02;
    public ModelPart cube_r7;
    public ModelPart lLeg03;
    public ModelPart cube_r8;
    public ModelPart lLeg04;
    public ModelPart cube_r9;
    public ModelPart lLeg05;
    public ModelPart cube_r10;
    public ModelPart rLeg05;
    public ModelPart cube_r11;
    public ModelPart rLeg04;
    public ModelPart cube_r12;
    public ModelPart rLeg03;
    public ModelPart cube_r13;
    public ModelPart rLeg02;
    public ModelPart cube_r14;
    public ModelPart rLeg01;
    public ModelPart cube_r15;

    public ModelHorseshoeCrab(ModelPart root) {
        this.head = root.getChild("head");
        this.lowerBody = head.getChild("lowerBody");
        this.spine = lowerBody.getChild("spine");
        this.cube_r1 = spine.getChild("cube_r1");
        this.tail = lowerBody.getChild("tail");
        this.lSpinePlate = lowerBody.getChild("lSpinePlate");
        this.cube_r2 = lSpinePlate.getChild("cube_r2");
        this.rSpinePlate = lowerBody.getChild("rSpinePlate");
        this.cube_r3 = rSpinePlate.getChild("cube_r3");
        this.lRidge = head.getChild("lRidge");
        this.cube_r4 = lRidge.getChild("cube_r4");
        this.rRidge = head.getChild("rRidge");
        this.cube_r5 = rRidge.getChild("cube_r5");
        this.lLeg01 = head.getChild("lLeg01");
        this.cube_r6 = lLeg01.getChild("cube_r6");
        this.lLeg02 = head.getChild("lLeg02");
        this.cube_r7 = lLeg02.getChild("cube_r7");
        this.lLeg03 = head.getChild("lLeg03");
        this.cube_r8 = lLeg03.getChild("cube_r8");
        this.lLeg04 = head.getChild("lLeg04");
        this.cube_r9 = lLeg04.getChild("cube_r9");
        this.lLeg05 = head.getChild("lLeg05");
        this.cube_r10 = lLeg05.getChild("cube_r10");
        this.rLeg05 = head.getChild("rLeg05");
        this.cube_r11 = rLeg05.getChild("cube_r11");
        this.rLeg04 = head.getChild("rLeg04");
        this.cube_r12 = rLeg04.getChild("cube_r12");
        this.rLeg03 = head.getChild("rLeg03");
        this.cube_r13 = rLeg03.getChild("cube_r13");
        this.rLeg02 = head.getChild("rLeg02");
        this.cube_r14 = rLeg02.getChild("cube_r14");
        this.rLeg01 = head.getChild("rLeg01");
        this.cube_r15 = rLeg01.getChild("cube_r15");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 23).addBox(-3.5F, -2.0F, -3.0F, 7.0F, 2.0F, 7.0F, new CubeDeformation(-0.1F))
                .texOffs(2, 24).addBox(-2.5F, -2.5F, -2.75F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 9).addBox(3.41F, -1.9F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 9).mirror().addBox(-3.41F, -1.9F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 24.0F, -4.0F));
        PartDefinition lowerBody = head.addOrReplaceChild("lowerBody", CubeListBuilder.create().texOffs(12, 11).addBox(-3.0F, 0.0F, -0.5F, 6.0F, 1.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offset(0.0F, -1.0F, 4.0F));
        PartDefinition spine = lowerBody.addOrReplaceChild("spine", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 2.0F));
        PartDefinition cube_r1 = spine.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(20, 17).addBox(-1.0F, -1.0F, -2.25F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
        PartDefinition tail = lowerBody.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 10).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.25F, 3.25F));
        PartDefinition lSpinePlate = lowerBody.addOrReplaceChild("lSpinePlate", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, -0.5F, 0.0F, -0.0873F, 0.0F, -0.2182F));
        PartDefinition cube_r2 = lSpinePlate.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(11, 0).addBox(-4.0F, 0.0F, -1.0F, 4.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.2618F, 0.0F));
        PartDefinition rSpinePlate = lowerBody.addOrReplaceChild("rSpinePlate", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, -0.5F, 0.0F, -0.0873F, 0.0F, 0.2182F));
        PartDefinition cube_r3 = rSpinePlate.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(11, 0).mirror().addBox(0.0F, 0.0F, -1.0F, 4.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.2618F, 0.0F));
        PartDefinition lRidge = head.addOrReplaceChild("lRidge", CubeListBuilder.create(), PartPose.offsetAndRotation(2.5F, -0.75F, 0.0F, 0.0F, 0.3491F, 0.0F));
        PartDefinition cube_r4 = lRidge.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -0.75F, -2.5F, 4.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5672F));
        PartDefinition rRidge = head.addOrReplaceChild("rRidge", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.5F, -0.75F, 0.0F, 0.0F, -0.3491F, 0.0F));
        PartDefinition cube_r5 = rRidge.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.5F, -0.75F, -2.5F, 4.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5672F));
        PartDefinition lLeg01 = head.addOrReplaceChild("lLeg01", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 0.0F, -1.0F, 0.0F, -0.7854F, 0.0F));
        PartDefinition cube_r6 = lLeg01.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(-3, 0).addBox(-0.5F, 0.0F, -3.75F, 1.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, 0.0F, 0.0F));
        PartDefinition lLeg02 = head.addOrReplaceChild("lLeg02", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 0.0F, -0.25F, 0.0F, -0.5672F, 0.0F));
        PartDefinition cube_r7 = lLeg02.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(-3, 0).addBox(-0.5F, 0.0F, -3.75F, 1.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, -0.5236F, 0.0F));
        PartDefinition lLeg03 = head.addOrReplaceChild("lLeg03", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 0.0F, 0.75F, 0.0F, -0.829F, 0.0F));
        PartDefinition cube_r8 = lLeg03.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(-3, 0).addBox(-0.75F, 0.0F, -3.75F, 1.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, -0.5236F, 0.0F));
        PartDefinition lLeg04 = head.addOrReplaceChild("lLeg04", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 0.0F, 1.25F, 0.0F, -1.2217F, 0.0F));
        PartDefinition cube_r9 = lLeg04.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(-3, 0).addBox(-0.5F, 0.0F, -3.75F, 1.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, -0.5236F, 0.0F));
        PartDefinition lLeg05 = head.addOrReplaceChild("lLeg05", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 0.0F, 2.0F, 0.0F, -1.5708F, 0.0F));
        PartDefinition cube_r10 = lLeg05.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(-3, 0).addBox(-0.5F, 0.0F, -3.75F, 1.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, -0.5236F, 0.0F));
        PartDefinition rLeg05 = head.addOrReplaceChild("rLeg05", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, 0.0F, 2.0F, 0.0F, 1.5708F, 0.0F));
        PartDefinition cube_r11 = rLeg05.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(-3, 0).mirror().addBox(-0.5F, 0.0F, -3.75F, 1.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, 0.5236F, 0.0F));
        PartDefinition rLeg04 = head.addOrReplaceChild("rLeg04", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, 0.0F, 1.25F, 0.0F, 1.2217F, 0.0F));
        PartDefinition cube_r12 = rLeg04.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(-3, 0).mirror().addBox(-0.5F, 0.0F, -3.75F, 1.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, 0.5236F, 0.0F));
        PartDefinition rLeg03 = head.addOrReplaceChild("rLeg03", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.5F, 0.0F, 0.829F, 0.0F));
        PartDefinition cube_r13 = rLeg03.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(-3, 0).mirror().addBox(-0.5F, 0.0F, -3.75F, 1.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, 0.5236F, 0.0F));
        PartDefinition rLeg02 = head.addOrReplaceChild("rLeg02", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, 0.0F, -0.25F, 0.0F, 0.5672F, 0.0F));
        PartDefinition cube_r14 = rLeg02.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(-3, 0).mirror().addBox(-0.5F, 0.0F, -3.75F, 1.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, 0.5236F, 0.0F));
        PartDefinition rLeg01 = head.addOrReplaceChild("rLeg01", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, 0.0F, -1.0F, 0.0F, 0.7854F, 0.0F));
        PartDefinition cube_r15 = rLeg01.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(-3, 0).mirror().addBox(-0.5F, 0.0F, -3.75F, 1.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.head.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T entity, float f, float f1, float f2, float f3, float f4) {
        this.tail.yRot = (float) Math.sin(f * 0.5F) * f1 * 0.5F;
    }

}
