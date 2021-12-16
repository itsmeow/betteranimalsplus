package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;

/**
 * horseshoe_crab - Batman
 * Created using Tabula 7.0.1
 */
public class ModelHorseshoeCrab<T extends LivingEntity> extends ModelBAP<T> {

    public ModelPart spine;
    public ModelPart head;
    public ModelPart lBody;
    public ModelPart rBody;
    public ModelPart tail00;
    public ModelPart tail01;
    public ModelPart headSlope;
    public ModelPart lHorn00;
    public ModelPart rHorn00;
    public ModelPart head2;
    public ModelPart lSpines;
    public ModelPart rSpines;

    public ModelHorseshoeCrab(ModelPart root) {
        this.spine = root.getChild("spine");
        this.head = spine.getChild("head");
        this.headSlope = head.getChild("headSlope");
        this.head2 = headSlope.getChild("head2");
        this.lHorn00 = head.getChild("lHorn00");
        this.rHorn00 = head.getChild("rHorn00");
        this.lBody = spine.getChild("lBody");
        this.lSpines = lBody.getChild("lSpines");
        this.rBody = spine.getChild("rBody");
        this.rSpines = rBody.getChild("rSpines");
        this.tail00 = spine.getChild("tail00");
        this.tail01 = tail00.getChild("tail01");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition spine = partdefinition.addOrReplaceChild("spine", CubeListBuilder.create().texOffs(0, 28).addBox(-1.5F, -1.52F, 0.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.4F, 0.0F));
        PartDefinition head = spine.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-6.5F, -1.0F, -8.0F, 13.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, -0.4F));
        PartDefinition headSlope = head.addOrReplaceChild("headSlope", CubeListBuilder.create().texOffs(0, 21).addBox(-6.0F, 0.0F, 0.0F, 12.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -8.8F, 0.4098F, 0.0F, 0.0F));
        PartDefinition head2 = headSlope.addOrReplaceChild("head2", CubeListBuilder.create().texOffs(0, 12).addBox(-11.0F, 0.0F, 0.0F, 12.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 4.0F, -0.4098F, 0.0F, 0.0F));
        PartDefinition lHorn00 = head.addOrReplaceChild("lHorn00", CubeListBuilder.create().texOffs(31, 28).mirror().addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.5F, 0.0F, 0.8F, 0.0F, -0.0911F, 0.0F));
        PartDefinition rHorn00 = head.addOrReplaceChild("rHorn00", CubeListBuilder.create().texOffs(31, 28).mirror().addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.5F, 0.0F, 0.8F, 0.0F, 0.0911F, 0.0F));
        PartDefinition lBody = spine.addOrReplaceChild("lBody", CubeListBuilder.create().texOffs(38, 6).addBox(-1.5F, -1.01F, 0.0F, 3.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 0.5F, 0.0F, 0.0F, -0.0911F, 0.0F));
        PartDefinition lSpines = lBody.addOrReplaceChild("lSpines", CubeListBuilder.create().texOffs(39, 30).addBox(0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.4F, -0.3F, 0.0F));
        PartDefinition rBody = spine.addOrReplaceChild("rBody", CubeListBuilder.create().texOffs(34, 17).mirror().addBox(-1.5F, -1.01F, 0.0F, 3.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.5F, 0.5F, 0.0F, 0.0F, 0.0911F, 0.0F));
        PartDefinition rSpines = rBody.addOrReplaceChild("rSpines", CubeListBuilder.create().texOffs(39, 30).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.4F, -0.3F, 0.0F));
        PartDefinition tail00 = spine.addOrReplaceChild("tail00", CubeListBuilder.create().texOffs(0, 40).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, 7.9F));
        PartDefinition tail01 = tail00.addOrReplaceChild("tail01", CubeListBuilder.create().texOffs(10, 45).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 6.0F));
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.spine.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T entity, float f, float f1, float f2, float f3, float f4) {
        this.tail00.yRot = (float) Math.sin(f * 0.5F) * f1 * 0.5F;
    }

}
