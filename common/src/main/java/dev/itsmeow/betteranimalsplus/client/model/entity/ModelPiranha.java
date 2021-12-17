package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

/**
 * Piranha - Batman
 * Created using Tabula 8.0.0
 */
public class ModelPiranha<T extends Entity> extends ModelBAP<T> {

    public ModelPart body;
    public ModelPart neck;
    public ModelPart rear;
    public ModelPart TopFin;
    public ModelPart LeftFin;
    public ModelPart RightFin;
    public ModelPart throat;
    public ModelPart TopJaw;
    public ModelPart LowerJaw;
    public ModelPart snout;
    public ModelPart TopTeeth01;
    public ModelPart TopTeeth02;
    public ModelPart TopTeeth03;
    public ModelPart LowTeeth;
    public ModelPart tail01;
    public ModelPart LowFin01;
    public ModelPart tail02;
    public ModelPart LowFin02;
    public ModelPart SmallTopFin;
    public ModelPart TailFin;
    public ModelPart LowFin03;
    private boolean isInWater;

    public ModelPiranha(ModelPart root) {
        this.body = root.getChild("body");
        this.rear = body.getChild("rear");
        this.LowFin01 = rear.getChild("LowFin01");
        this.tail01 = rear.getChild("tail01");
        this.LowFin02 = tail01.getChild("LowFin02");
        this.tail02 = tail01.getChild("tail02");
        this.LowFin03 = tail02.getChild("LowFin03");
        this.TailFin = tail02.getChild("TailFin");
        this.SmallTopFin = tail01.getChild("SmallTopFin");
        this.LeftFin = body.getChild("LeftFin");
        this.TopFin = body.getChild("TopFin");
        this.RightFin = body.getChild("RightFin");
        this.neck = body.getChild("neck");
        this.throat = neck.getChild("throat");
        this.TopJaw = neck.getChild("TopJaw");
        this.TopTeeth01 = TopJaw.getChild("TopTeeth01");
        this.snout = TopJaw.getChild("snout");
        this.TopTeeth03 = TopJaw.getChild("TopTeeth03");
        this.TopTeeth02 = TopJaw.getChild("TopTeeth02");
        this.LowerJaw = neck.getChild("LowerJaw");
        this.LowTeeth = LowerJaw.getChild("LowTeeth");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -5.0F, -9.0F, 5.0F, 10.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, 4.0F));
        PartDefinition rear = body.addOrReplaceChild("rear", CubeListBuilder.create().texOffs(0, 63).addBox(-2.0F, -4.5F, 0.0F, 4.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition LowFin01 = rear.addOrReplaceChild("LowFin01", CubeListBuilder.create().texOffs(0, 92).addBox(0.0F, 0.0F, 0.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 0.0F));
        PartDefinition tail01 = rear.addOrReplaceChild("tail01", CubeListBuilder.create().texOffs(0, 76).addBox(-1.5F, -3.5F, 0.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 3.0F));
        PartDefinition LowFin02 = tail01.addOrReplaceChild("LowFin02", CubeListBuilder.create().texOffs(0, 98).addBox(0.0F, 0.0F, 0.0F, 0.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));
        PartDefinition tail02 = tail01.addOrReplaceChild("tail02", CubeListBuilder.create().texOffs(0, 86).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 3.0F));
        PartDefinition LowFin03 = tail02.addOrReplaceChild("LowFin03", CubeListBuilder.create().texOffs(0, 105).addBox(0.0F, 0.0F, 0.0F, 0.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));
        PartDefinition TailFin = tail02.addOrReplaceChild("TailFin", CubeListBuilder.create().texOffs(0, 106).addBox(0.0F, -8.5F, 0.0F, 0.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, 2.5F));
        PartDefinition SmallTopFin = tail01.addOrReplaceChild("SmallTopFin", CubeListBuilder.create().texOffs(0, 135).addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.3F, 1.7F, -0.2731F, 0.0F, 0.0F));
        PartDefinition LeftFin = body.addOrReplaceChild("LeftFin", CubeListBuilder.create().texOffs(26, 20).mirror().addBox(0.0F, 0.0F, -1.5F, 0.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 3.5F, -7.0F, 0.6374F, 0.0F, -2.1399F));
        PartDefinition TopFin = body.addOrReplaceChild("TopFin", CubeListBuilder.create().texOffs(0, 125).addBox(0.0F, -4.0F, -1.0F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.8F, -5.0F, -0.0911F, 0.0F, 0.0F));
        PartDefinition RightFin = body.addOrReplaceChild("RightFin", CubeListBuilder.create().texOffs(26, 20).mirror().addBox(0.0F, 0.0F, -1.5F, 0.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 3.5F, -7.0F, 0.6374F, 0.0F, 2.1399F));
        PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 20).addBox(-3.0F, -4.5F, -6.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -8.0F, 0.1367F, 0.0F, 0.0F));
        PartDefinition throat = neck.addOrReplaceChild("throat", CubeListBuilder.create().texOffs(0, 34).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.9F, -3.9F, -0.5463F, 0.0F, 0.0F));
        PartDefinition TopJaw = neck.addOrReplaceChild("TopJaw", CubeListBuilder.create().texOffs(0, 44).addBox(-2.5F, -1.5F, -3.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -5.5F, -0.182F, 0.0F, 0.0F));
        PartDefinition TopTeeth01 = TopJaw.addOrReplaceChild("TopTeeth01", CubeListBuilder.create().texOffs(0, 139).addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.8F, 1.3F, -2.6F));
        PartDefinition snout = TopJaw.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(0, 51).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5F, -3.0F, 0.6829F, 0.0F, 0.0F));
        PartDefinition TopTeeth03 = TopJaw.addOrReplaceChild("TopTeeth03", CubeListBuilder.create().texOffs(7, 138).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.3F, -2.5F));
        PartDefinition TopTeeth02 = TopJaw.addOrReplaceChild("TopTeeth02", CubeListBuilder.create().texOffs(0, 139).addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.8F, 1.3F, -2.6F));
        PartDefinition LowerJaw = neck.addOrReplaceChild("LowerJaw", CubeListBuilder.create().texOffs(0, 57).addBox(-2.0F, -1.0F, -3.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.4F, -5.5F, -0.2276F, 0.0F, 0.0F));
        PartDefinition LowTeeth = LowerJaw.addOrReplaceChild("LowTeeth", CubeListBuilder.create().texOffs(0, 145).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, -2.5F));
        return LayerDefinition.create(meshdefinition, 36, 160);
    }

    @Override
    public void renderToBuffer(PoseStack stack, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        stack.pushPose();
        {
            if (!this.isInWater) {
                stack.mulPose(Vector3f.ZP.rotationDegrees(90F));
                stack.translate(2F, -1F, 0F);
            }
            this.body.render(stack, bufferIn, packedLightIn, packedOverlayIn);
        }
        stack.popPose();
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float factor = (float) entityIn.getDeltaMovement().length() * 10;
        this.body.yRot = Mth.cos(ageInTicks * 0.3F) * (float) Math.PI * 0.05F * factor;
        this.tail01.yRot = this.body.yRot * 1.5F;
        this.isInWater = entityIn.isInWater();
    }

}
