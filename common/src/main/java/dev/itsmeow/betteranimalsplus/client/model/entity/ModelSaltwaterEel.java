package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import dev.itsmeow.betteranimalsplus.common.entity.EntitySaltwaterEel;
import dev.itsmeow.betteranimalsplus.util.ModMathHelper;
import dev.itsmeow.imdlib.client.util.RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;

/**
 * EelSaltwater - Batman Created using Tabula 7.0.1
 */
public class ModelSaltwaterEel<T extends LivingEntity> extends ModelBAP<T> {

    public ModelPart body00;
    public ModelPart body01;
    public ModelPart head;
    public ModelPart topFin01;
    public ModelPart lowFin01;
    public ModelPart lFin;
    public ModelPart rFin;
    public ModelPart body02;
    public ModelPart topFin02;
    public ModelPart lowFin02;
    public ModelPart body03;
    public ModelPart topFin03;
    public ModelPart lowFin03;
    public ModelPart body04;
    public ModelPart topFin04;
    public ModelPart lowFin04;
    public ModelPart body05;
    public ModelPart topFin05;
    public ModelPart lowFin05;
    public ModelPart body06;
    public ModelPart topFin06;
    public ModelPart lowFin06;
    public ModelPart topFin07;
    public ModelPart lowFin07;
    public ModelPart topJaw;
    public ModelPart lowerJaw;
    public ModelPart topTeethL;
    public ModelPart topTeethR;
    public ModelPart snout;
    public ModelPart lCrest;
    public ModelPart rCrest;
    public ModelPart lowerJawUnder;
    public ModelPart lowJawPieceL;
    public ModelPart lowJawPieceR;
    public ModelPart lowTeethL;
    public ModelPart lowTeethR;
    private boolean inWater = true;

    public ModelSaltwaterEel(ModelPart root) {
        this.body00 = root.getChild("body00");
        this.body01 = body00.getChild("body01");
        this.body02 = body01.getChild("body02");
        this.body03 = body02.getChild("body03");
        this.body04 = body03.getChild("body04");
        this.body05 = body04.getChild("body05");
        this.body06 = body05.getChild("body06");
        this.topFin07 = body06.getChild("topFin07");
        this.lowFin07 = body06.getChild("lowFin07");
        this.topFin06 = body05.getChild("topFin06");
        this.lowFin06 = body05.getChild("lowFin06");
        this.topFin05 = body04.getChild("topFin05");
        this.lowFin05 = body04.getChild("lowFin05");
        this.topFin04 = body03.getChild("topFin04");
        this.lowFin04 = body03.getChild("lowFin04");
        this.topFin03 = body02.getChild("topFin03");
        this.lowFin03 = body02.getChild("lowFin03");
        this.topFin02 = body01.getChild("topFin02");
        this.lowFin02 = body01.getChild("lowFin02");
        this.head = body00.getChild("head");
        this.topJaw = head.getChild("topJaw");
        this.snout = topJaw.getChild("snout");
        this.lCrest = snout.getChild("lCrest");
        this.rCrest = snout.getChild("rCrest");
        this.lowerJaw = head.getChild("lowerJaw");
        this.lowerJawUnder = lowerJaw.getChild("lowerJawUnder");
        this.lowJawPieceL = lowerJaw.getChild("lowJawPieceL");
        this.lowJawPieceR = lowerJaw.getChild("lowJawPieceR");
        this.lowTeethL = lowerJaw.getChild("lowTeethL");
        this.lowTeethR = lowerJaw.getChild("lowTeethR");
        this.topTeethL = head.getChild("topTeethL");
        this.topTeethR = head.getChild("topTeethR");
        this.topFin01 = body00.getChild("topFin01");
        this.lowFin01 = body00.getChild("lowFin01");
        this.lFin = body00.getChild("lFin");
        this.rFin = body00.getChild("rFin");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition body00 = partdefinition.addOrReplaceChild("body00", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -3.0F, 0.0F, 5.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 17.0F, -8.0F));
        PartDefinition body01 = body00.addOrReplaceChild("body01", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, -3.0F, 0.0F, 4.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 9.0F));
        PartDefinition body02 = body01.addOrReplaceChild("body02", CubeListBuilder.create().texOffs(0, 33).addBox(-1.5F, -3.0F, 0.0F, 3.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 9.0F));
        PartDefinition body03 = body02.addOrReplaceChild("body03", CubeListBuilder.create().texOffs(0, 49).addBox(-1.0F, -3.0F, 0.0F, 2.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 9.0F));
        PartDefinition body04 = body03.addOrReplaceChild("body04", CubeListBuilder.create().texOffs(0, 65).addBox(-1.0F, -2.5F, 0.0F, 2.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 9.0F));
        PartDefinition body05 = body04.addOrReplaceChild("body05", CubeListBuilder.create().texOffs(0, 80).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 9.0F));
        PartDefinition body06 = body05.addOrReplaceChild("body06", CubeListBuilder.create().texOffs(0, 94).addBox(-1.0F, -1.5F, 0.0F, 2.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 9.0F));
        PartDefinition topFin07 = body06.addOrReplaceChild("topFin07", CubeListBuilder.create().texOffs(0, 127).addBox(0.0F, -4.0F, 0.0F, 0.0F, 8.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.5F, 0.0F));
        PartDefinition lowFin07 = body06.addOrReplaceChild("lowFin07", CubeListBuilder.create().texOffs(0, 168).addBox(0.0F, 0.0F, 0.0F, 0.0F, 5.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.5F, 0.0F));
        PartDefinition topFin06 = body05.addOrReplaceChild("topFin06", CubeListBuilder.create().texOffs(0, 125).addBox(0.0F, -4.0F, 0.0F, 0.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.9F, 0.0F));
        PartDefinition lowFin06 = body05.addOrReplaceChild("lowFin06", CubeListBuilder.create().texOffs(0, 166).addBox(0.0F, 0.0F, 0.0F, 0.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.9F, 0.0F));
        PartDefinition topFin05 = body04.addOrReplaceChild("topFin05", CubeListBuilder.create().texOffs(0, 119).addBox(0.0F, -4.0F, 0.0F, 0.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.9F, 0.0F));
        PartDefinition lowFin05 = body04.addOrReplaceChild("lowFin05", CubeListBuilder.create().texOffs(0, 160).addBox(0.0F, 0.0F, 0.0F, 0.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));
        PartDefinition topFin04 = body03.addOrReplaceChild("topFin04", CubeListBuilder.create().texOffs(0, 114).addBox(0.0F, -4.0F, 0.0F, 0.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.9F, 0.0F));
        PartDefinition lowFin04 = body03.addOrReplaceChild("lowFin04", CubeListBuilder.create().texOffs(0, 155).addBox(0.0F, 0.0F, 0.0F, 0.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.9F, 0.0F));
        PartDefinition topFin03 = body02.addOrReplaceChild("topFin03", CubeListBuilder.create().texOffs(0, 109).addBox(0.0F, -4.0F, 0.0F, 0.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.9F, 0.0F));
        PartDefinition lowFin03 = body02.addOrReplaceChild("lowFin03", CubeListBuilder.create().texOffs(0, 150).addBox(0.0F, 0.0F, 0.0F, 0.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.9F, 0.0F));
        PartDefinition topFin02 = body01.addOrReplaceChild("topFin02", CubeListBuilder.create().texOffs(0, 104).addBox(0.0F, -4.0F, 0.0F, 0.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.9F, 0.0F));
        PartDefinition lowFin02 = body01.addOrReplaceChild("lowFin02", CubeListBuilder.create().texOffs(0, 145).addBox(0.0F, 0.0F, 0.0F, 0.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.9F, 0.0F));
        PartDefinition head = body00.addOrReplaceChild("head", CubeListBuilder.create().texOffs(17, 32).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offset(0.0F, -3.0F, 0.1F));
        PartDefinition topJaw = head.addOrReplaceChild("topJaw", CubeListBuilder.create().texOffs(21, 45).addBox(-1.5F, -1.0F, -4.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, -3.0F));
        PartDefinition snout = topJaw.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(26, 16).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -4.0F, 0.4061F, 0.0F, 0.0F));
        PartDefinition lCrest = snout.addOrReplaceChild("lCrest", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4F, 0.5F, 4.3F, 0.0F, 0.0F, -0.3187F));
        PartDefinition rCrest = snout.addOrReplaceChild("rCrest", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.5F, 4.3F, 0.0F, 0.0F, 0.3187F));
        PartDefinition lowerJaw = head.addOrReplaceChild("lowerJaw", CubeListBuilder.create().texOffs(16, 59).addBox(-1.0F, -1.0F, -7.0F, 3.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 5.0F, 0.3F));
        PartDefinition lowerJawUnder = lowerJaw.addOrReplaceChild("lowerJawUnder", CubeListBuilder.create().texOffs(16, 74).addBox(-0.5F, 0.0F, 0.0F, 2.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -6.9F, -0.1367F, 0.0F, 0.0F));
        PartDefinition lowJawPieceL = lowerJaw.addOrReplaceChild("lowJawPieceL", CubeListBuilder.create().texOffs(4, 3).addBox(0.0F, -0.5F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -6.4F, 0.3187F, 0.182F, 0.0F));
        PartDefinition lowJawPieceR = lowerJaw.addOrReplaceChild("lowJawPieceR", CubeListBuilder.create().texOffs(4, 3).addBox(0.0F, -0.5F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -0.5F, -6.4F, 0.3187F, -0.182F, 0.0F));
        PartDefinition lowTeethL = lowerJaw.addOrReplaceChild("lowTeethL", CubeListBuilder.create().texOffs(30, 4).mirror().addBox(-1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.3F, -1.5F, -6.5F));
        PartDefinition lowTeethR = lowerJaw.addOrReplaceChild("lowTeethR", CubeListBuilder.create().texOffs(30, 4).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.7F, -1.5F, -6.5F));
        PartDefinition topTeethL = head.addOrReplaceChild("topTeethL", CubeListBuilder.create().texOffs(20, 0).mirror().addBox(-1.0F, 0.0F, -5.5F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.3F, 4.0F, -1.0F));
        PartDefinition topTeethR = head.addOrReplaceChild("topTeethR", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, 0.0F, -5.5F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.3F, 4.0F, -1.0F));
        PartDefinition topFin01 = body00.addOrReplaceChild("topFin01", CubeListBuilder.create().texOffs(0, 99).addBox(0.0F, -4.0F, 0.0F, 0.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.9F, 0.0F));
        PartDefinition lowFin01 = body00.addOrReplaceChild("lowFin01", CubeListBuilder.create().texOffs(0, 140).addBox(0.0F, 0.0F, 0.0F, 0.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.9F, 0.0F));
        PartDefinition lFin = body00.addOrReplaceChild("lFin", CubeListBuilder.create().texOffs(18, 11).mirror().addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.5F, 0.8F, 4.0F, 0.0F, 0.2731F, 0.0F));
        PartDefinition rFin = body00.addOrReplaceChild("rFin", CubeListBuilder.create().texOffs(18, 11).mirror().addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 0.8F, 4.0F, 0.0F, -0.2731F, 0.0F));
        return LayerDefinition.create(meshdefinition, 50, 200);
    }

    @Override
    public void renderToBuffer(PoseStack stack, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        stack.pushPose();
        if (!inWater) {
            stack.translate(0F, 0.5F, 0F);
        }
        this.body00.render(stack, bufferIn, packedLightIn, packedOverlayIn);
        stack.popPose();
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float partialTicks = Minecraft.getInstance().getFrameTime();
        float ticks = ageInTicks / 5F + (float) entity.getDeltaMovement().length() * 0.05F;
        float factor = 1F;
        float offset = 0F;
        float amplitude = (float) Math.min(entity.getDeltaMovement().length() * 2.5F + 0.25F, 0.5F);
        if (!entity.isInWater()) {
            amplitude = 0.15F;
            ticks = ageInTicks / 2F;
        }
        this.body00.xRot = 0F;
        if (entity instanceof EntitySaltwaterEel) {
            EntitySaltwaterEel eel = (EntitySaltwaterEel) entity;
            if (entity.getDeltaMovement().length() > 0) {
                float rotX = (float) Math.toRadians(headPitch);
                if (rotX < 0) {
                    rotX /= 2;
                }
                this.body00.xRot = Mth.lerp(partialTicks, eel.lastBodyRotation, rotX);
                eel.lastBodyRotation = rotX;
            }
            this.head.yRot = Mth.sin((float) RenderUtil.partLocation(this.body00, this.head).z() * factor - ticks) * 0.5F + ((float) Math.toRadians(netHeadYaw) * 0.0625F);
            float z01 = (float) RenderUtil.partLocation(this.body00, this.body01).z();
            float z02 = (float) RenderUtil.partLocation(this.body00, this.body01, this.body02).z();
            float z03 = (float) RenderUtil.partLocation(this.body00, this.body01, this.body02, this.body03).z();
            float z04 = (float) RenderUtil.partLocation(this.body00, this.body01, this.body02, this.body03, this.body04).z();
            float z05 = (float) RenderUtil.partLocation(this.body00, this.body01, this.body02, this.body03, this.body04, this.body05).z();
            float z06 = (float) RenderUtil.partLocation(this.body00, this.body01, this.body02, this.body03, this.body04, this.body05, this.body06).z();
            float newBody01 = -Mth.sin(z01 * factor + ticks) * amplitude + offset;
            float newBody02 = -Mth.sin(z02 * factor + ticks) * amplitude + offset;
            float newBody03 = Mth.sin(z03 * factor + ticks) * amplitude + offset;
            float newBody04 = Mth.sin(z04 * factor + ticks) * amplitude + offset;
            float newBody05 = Mth.sin(z05 * factor + ticks) * amplitude + offset;
            float newBody06 = -Mth.sin(z06 * factor + ticks) * amplitude + offset;
            this.body01.yRot = ModMathHelper.interpolateRotation(eel.body01, newBody01, partialTicks);
            this.body02.yRot = ModMathHelper.interpolateRotation(eel.body02, newBody02, partialTicks);
            this.body03.yRot = ModMathHelper.interpolateRotation(eel.body03, newBody03, partialTicks);
            this.body04.yRot = ModMathHelper.interpolateRotation(eel.body04, newBody04, partialTicks);
            this.body05.yRot = ModMathHelper.interpolateRotation(eel.body05, newBody05, partialTicks);
            this.body06.yRot = ModMathHelper.interpolateRotation(eel.body06, newBody06, partialTicks);
            eel.body01 = newBody01;
            eel.body02 = newBody02;
            eel.body03 = newBody03;
            eel.body04 = newBody04;
            eel.body05 = newBody05;
            eel.body06 = newBody06;
            this.body00.x = 0.5F + Mth.sin((float) RenderUtil.partLocation(this.body00).z() * factor + ticks) * (10F * amplitude);
        }
        this.inWater = entity.isInWater();
    }

}
