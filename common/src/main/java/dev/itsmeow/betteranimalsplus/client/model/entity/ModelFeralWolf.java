package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import dev.itsmeow.betteranimalsplus.common.entity.EntityFeralWolf;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;

/**
 * wolf_v2 - cybercat5555
 * Created using Tabula 7.0.1
 */
public class ModelFeralWolf<T extends LivingEntity> extends ModelBAP<T> {

    public ModelPart chest;
    public ModelPart torso;
    public ModelPart neck;
    public ModelPart lForeleg01;
    public ModelPart rForeleg01;
    public ModelPart hackles01;
    public ModelPart hackles02;
    public ModelPart tail01;
    public ModelPart lHindLeg01;
    public ModelPart rHindLeg01;
    public ModelPart tail02;
    public ModelPart tail03;
    public ModelPart tail04;
    public ModelPart lHindLeg02;
    public ModelPart lHindLeg03;
    public ModelPart lHindPaw;
    public ModelPart rHindLeg02;
    public ModelPart rHindLeg03;
    public ModelPart rHindPaw;
    public ModelPart head;
    public ModelPart mane01;
    public ModelPart mane02;
    public ModelPart mane03;
    public ModelPart mane04;
    public ModelPart jawUpper01;
    public ModelPart jawLower;
    public ModelPart lEar01;
    public ModelPart rEar01;
    public ModelPart lCheekFur;
    public ModelPart rCheekFur;
    public ModelPart snout;
    public ModelPart jawUpper02;
    public ModelPart upperTeeth01;
    public ModelPart upperTeeth03;
    public ModelPart upperTeeth02;
    public ModelPart lowerTeeth01;
    public ModelPart lowerTeeth02;
    public ModelPart lEar02;
    public ModelPart rEar02;
    public ModelPart lForeleg02;
    public ModelPart lForePaw;
    public ModelPart rForeleg02;
    public ModelPart rForePaw;

    public ModelFeralWolf(ModelPart root) {
        this.chest = root.getChild("chest");
        this.torso = chest.getChild("torso");
        this.tail01 = torso.getChild("tail01");
        this.tail02 = tail01.getChild("tail02");
        this.tail03 = tail02.getChild("tail03");
        this.tail04 = tail03.getChild("tail04");
        this.lHindLeg01 = torso.getChild("lHindLeg01");
        this.lHindLeg02 = lHindLeg01.getChild("lHindLeg02");
        this.lHindLeg03 = lHindLeg02.getChild("lHindLeg03");
        this.lHindPaw = lHindLeg03.getChild("lHindPaw");
        this.rHindLeg01 = torso.getChild("rHindLeg01");
        this.rHindLeg02 = rHindLeg01.getChild("rHindLeg02");
        this.rHindLeg03 = rHindLeg02.getChild("rHindLeg03");
        this.rHindPaw = rHindLeg03.getChild("rHindPaw");
        this.neck = chest.getChild("neck");
        this.head = neck.getChild("head");
        this.jawUpper01 = head.getChild("jawUpper01");
        this.jawUpper02 = jawUpper01.getChild("jawUpper02");
        this.upperTeeth02 = jawUpper02.getChild("upperTeeth02");
        this.upperTeeth01 = jawUpper01.getChild("upperTeeth01");
        this.upperTeeth03 = jawUpper01.getChild("upperTeeth03");
        this.jawLower = head.getChild("jawLower");
        this.lowerTeeth01 = jawLower.getChild("lowerTeeth01");
        this.lowerTeeth02 = lowerTeeth01.getChild("lowerTeeth02");
        this.lEar01 = head.getChild("lEar01");
        this.lEar02 = lEar01.getChild("lEar02");
        this.rEar01 = head.getChild("rEar01");
        this.rEar02 = rEar01.getChild("rEar02");
        this.lCheekFur = head.getChild("lCheekFur");
        this.rCheekFur = head.getChild("rCheekFur");
        this.snout = head.getChild("snout");
        this.mane01 = neck.getChild("mane01");
        this.mane02 = neck.getChild("mane02");
        this.mane03 = neck.getChild("mane03");
        this.mane04 = neck.getChild("mane04");
        this.lForeleg01 = chest.getChild("lForeleg01");
        this.lForeleg02 = lForeleg01.getChild("lForeleg02");
        this.lForePaw = lForeleg02.getChild("lForePaw");
        this.rForeleg01 = chest.getChild("rForeleg01");
        this.rForeleg02 = rForeleg01.getChild("rForeleg02");
        this.rForePaw = rForeleg02.getChild("rForePaw");
        this.hackles01 = chest.getChild("hackles01");
        this.hackles02 = chest.getChild("hackles02");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition chest = partdefinition.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(3, 0).addBox(-4.0F, -4.0F, -5.0F, 8.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.8F, -5.0F, -0.0698F, 0.0F, 0.0F));
        PartDefinition torso = chest.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 19).addBox(-3.5F, -4.0F, 0.0F, 7.0F, 8.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.4F, 4.0F, 0.0698F, 0.0F, 0.0F));
        PartDefinition tail01 = torso.addOrReplaceChild("tail01", CubeListBuilder.create().texOffs(0, 39).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.9F, 10.0F, 0.6981F, 0.0F, 0.0F));
        PartDefinition tail02 = tail01.addOrReplaceChild("tail02", CubeListBuilder.create().texOffs(0, 47).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.5F, 0.0F, -0.3142F, 0.0F, 0.0F));
        PartDefinition tail03 = tail02.addOrReplaceChild("tail03", CubeListBuilder.create().texOffs(13, 39).addBox(-1.5F, 0.2F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.5F, 0.1F, 0.1396F, 0.0F, 0.0F));
        PartDefinition tail04 = tail03.addOrReplaceChild("tail04", CubeListBuilder.create().texOffs(18, 49).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.4F, 0.0698F, 0.0F, 0.0F));
        PartDefinition lHindLeg01 = torso.addOrReplaceChild("lHindLeg01", CubeListBuilder.create().texOffs(90, 0).addBox(0.0F, -1.0F, -3.0F, 4.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3F, -0.9F, 7.8F, -0.384F, 0.0F, -0.0524F));
        PartDefinition lHindLeg02 = lHindLeg01.addOrReplaceChild("lHindLeg02", CubeListBuilder.create().texOffs(90, 18).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9F, 5.6F, -1.1F, -0.2618F, 0.0F, 0.0F));
        PartDefinition lHindLeg03 = lHindLeg02.addOrReplaceChild("lHindLeg03", CubeListBuilder.create().texOffs(94, 30).addBox(-1.0F, -0.3F, -1.5F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, 0.0F, 5.8F, 0.5236F, 0.0F, 0.0524F));
        PartDefinition lHindPaw = lHindLeg03.addOrReplaceChild("lHindPaw", CubeListBuilder.create().texOffs(66, 27).addBox(-1.5F, 0.0F, -2.4F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.4F, -0.3F, 0.1222F, 0.0F, 0.0F));
        PartDefinition rHindLeg01 = torso.addOrReplaceChild("rHindLeg01", CubeListBuilder.create().texOffs(90, 0).mirror().addBox(-4.0F, -1.0F, -3.0F, 4.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.3F, -0.9F, 7.8F, -0.384F, 0.0F, 0.0524F));
        PartDefinition rHindLeg02 = rHindLeg01.addOrReplaceChild("rHindLeg02", CubeListBuilder.create().texOffs(90, 18).mirror().addBox(-1.5F, -1.5F, 0.0F, 3.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.9F, 5.6F, -1.1F, -0.2618F, 0.0F, 0.0F));
        PartDefinition rHindLeg03 = rHindLeg02.addOrReplaceChild("rHindLeg03", CubeListBuilder.create().texOffs(94, 30).mirror().addBox(-1.0F, -0.3F, -1.5F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.1F, 0.0F, 5.8F, 0.5236F, 0.0F, -0.0524F));
        PartDefinition rHindPaw = rHindLeg03.addOrReplaceChild("rHindPaw", CubeListBuilder.create().texOffs(66, 27).mirror().addBox(-1.5F, 0.0F, -2.4F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 6.4F, -0.3F, 0.1222F, 0.0F, 0.0F));
        PartDefinition neck = chest.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(38, 27).addBox(-3.0F, -2.5F, -5.0F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.7F, -3.3F, -0.5236F, 0.0F, 0.0F));
        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(40, 0).addBox(-3.5F, -5.0F, -3.0F, 7.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -3.6F, 2.1817F, 0.0F, 0.0F));
        PartDefinition jawUpper01 = head.addOrReplaceChild("jawUpper01", CubeListBuilder.create().texOffs(51, 12).mirror().addBox(-1.1F, -4.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.2F, -5.2F, -1.1F, 0.0F, 0.0F, 0.1396F));
        PartDefinition jawUpper02 = jawUpper01.addOrReplaceChild("jawUpper02", CubeListBuilder.create().texOffs(51, 12).addBox(1.5F, -4.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.35F, 0.0F, 0.0F, 0.0F, -0.2793F));
        PartDefinition upperTeeth02 = jawUpper02.addOrReplaceChild("upperTeeth02", CubeListBuilder.create().texOffs(50, 20).addBox(-0.5F, -1.0F, -0.89F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.4F, -2.8F, -1.0F));
        PartDefinition upperTeeth01 = jawUpper01.addOrReplaceChild("upperTeeth01", CubeListBuilder.create().texOffs(50, 20).mirror().addBox(-0.5F, -1.0F, -0.89F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -2.8F, -1.0F));
        PartDefinition upperTeeth03 = jawUpper01.addOrReplaceChild("upperTeeth03", CubeListBuilder.create().texOffs(55, 28).mirror().addBox(-0.73F, -0.7F, -0.4F, 3.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -3.2F, -1.0F, 0.0F, 0.0F, 0.1367F));
        PartDefinition jawLower = head.addOrReplaceChild("jawLower", CubeListBuilder.create().texOffs(39, 20).addBox(-1.5F, -4.5F, -0.5F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.6F, -2.51F));
        PartDefinition lowerTeeth01 = jawLower.addOrReplaceChild("lowerTeeth01", CubeListBuilder.create().texOffs(57, 22).addBox(-1.6F, -0.7F, 0.4F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.7F, 0.1F));
        PartDefinition lowerTeeth02 = lowerTeeth01.addOrReplaceChild("lowerTeeth02", CubeListBuilder.create().texOffs(57, 22).mirror().addBox(0.6F, -0.7F, 0.3F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition lEar01 = head.addOrReplaceChild("lEar01", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.5F, -0.5F, 0.3F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.1F, -2.2F, 1.9F, 0.0873F, 0.2269F, 0.3665F));
        PartDefinition lEar02 = lEar01.addOrReplaceChild("lEar02", CubeListBuilder.create().texOffs(0, 4).mirror().addBox(-1.0F, -0.7F, 0.2F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.2F, 0.2F, 0.3142F, 0.0F, 0.0F));
        PartDefinition rEar01 = head.addOrReplaceChild("rEar01", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -0.5F, 0.3F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1F, -2.2F, 1.9F, 0.0873F, -0.2269F, -0.3665F));
        PartDefinition rEar02 = rEar01.addOrReplaceChild("rEar02", CubeListBuilder.create().texOffs(0, 4).addBox(-1.0F, -0.7F, 0.2F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.2F, 0.2F, 0.3142F, 0.0F, 0.0F));
        PartDefinition lCheekFur = head.addOrReplaceChild("lCheekFur", CubeListBuilder.create().texOffs(30, -6).addBox(0.0F, -0.9F, -3.8F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -2.5F, -0.6F, -0.3491F, 0.0873F, -0.6981F));
        PartDefinition rCheekFur = head.addOrReplaceChild("rCheekFur", CubeListBuilder.create().texOffs(30, -6).addBox(0.0F, -0.8F, -3.6F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -2.5F, -0.6F, -0.3491F, -0.0873F, 0.6981F));
        PartDefinition snout = head.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(40, 12).addBox(-1.5F, -4.45F, -1.0F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.9F, 0.1F, 0.182F, 0.0F, 0.0F));
        PartDefinition mane01 = neck.addOrReplaceChild("mane01", CubeListBuilder.create().texOffs(36, 50).addBox(-2.0F, 0.0F, -0.5F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.1F, -3.9F, 0.5236F, 0.0F, 0.0F));
        PartDefinition mane02 = neck.addOrReplaceChild("mane02", CubeListBuilder.create().texOffs(49, 50).addBox(-2.0F, 0.0F, -0.5F, 4.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.1F, -3.2F, 0.6283F, 0.0F, 0.0F));
        PartDefinition mane03 = neck.addOrReplaceChild("mane03", CubeListBuilder.create().texOffs(61, 50).addBox(-2.5F, 0.0F, -0.5F, 5.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.1F, -2.0F, 0.6632F, 0.0F, 0.0F));
        PartDefinition mane04 = neck.addOrReplaceChild("mane04", CubeListBuilder.create().texOffs(75, 50).addBox(-3.0F, 0.0F, -0.5F, 6.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.1F, -0.8F, 0.6981F, 0.0F, 0.0F));
        PartDefinition lForeleg01 = chest.addOrReplaceChild("lForeleg01", CubeListBuilder.create().texOffs(69, 0).addBox(-1.0F, -1.1F, -3.4F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -0.2F, -1.2F, 0.1396F, 0.0F, 0.0F));
        PartDefinition lForeleg02 = lForeleg01.addOrReplaceChild("lForeleg02", CubeListBuilder.create().texOffs(69, 14).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 6.7F, -0.5F, -0.1047F, 0.0F, 0.0F));
        PartDefinition lForePaw = lForeleg02.addOrReplaceChild("lForePaw", CubeListBuilder.create().texOffs(66, 27).addBox(-1.5F, 0.0F, -2.4F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.8F, -0.5F, 0.0349F, 0.0F, 0.0F));
        PartDefinition rForeleg01 = chest.addOrReplaceChild("rForeleg01", CubeListBuilder.create().texOffs(69, 0).mirror().addBox(-3.0F, -1.1F, -3.4F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -0.2F, -1.2F, 0.1396F, 0.0F, 0.0F));
        PartDefinition rForeleg02 = rForeleg01.addOrReplaceChild("rForeleg02", CubeListBuilder.create().texOffs(69, 14).mirror().addBox(-1.0F, 0.0F, -1.5F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 6.7F, -0.5F, -0.1047F, 0.0F, 0.0F));
        PartDefinition rForePaw = rForeleg02.addOrReplaceChild("rForePaw", CubeListBuilder.create().texOffs(66, 27).mirror().addBox(-1.5F, 0.0F, -2.4F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 7.8F, -0.5F, 0.0349F, 0.0F, 0.0F));
        PartDefinition hackles01 = chest.addOrReplaceChild("hackles01", CubeListBuilder.create().texOffs(59, 37).addBox(-2.5F, -1.0F, 0.0F, 5.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.9F, -4.5F, 0.1396F, 0.0F, 0.0F));
        PartDefinition hackles02 = chest.addOrReplaceChild("hackles02", CubeListBuilder.create().texOffs(94, 42).addBox(-3.5F, -1.0F, 0.0F, 7.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.2F, -3.0F, 0.1047F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.chest.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.headPitch(head, headPitch);
        this.headYaw(head, netHeadYaw);
        boolean sit = false;

        if (entity instanceof EntityFeralWolf) {
            EntityFeralWolf wolf = (EntityFeralWolf) entity;
            this.tail01.xRot = ageInTicks + (wolf.isInSittingPose() ? 1.7453292519943295F : 0.6981317007977318F);
            if (wolf.isInSittingPose()) {
                sit = true;
                this.setRotateAngle(rHindPaw, 1.3089969389957472F, 0.20943951023931953F, 0.0F);
                this.setRotateAngle(lForePaw, 0.03490658503988659F, 0.0F, 0.0F);
                this.setRotateAngle(rForeleg02, -0.10471975511965977F, 0.0F, 0.0F);
                this.setRotateAngle(lForeleg01, 0.8726646259971648F, 0.0F, 0.0F);
                this.setRotateAngle(tail02, 0.5235987755982988F, 0.0F, 0.0F);
                this.setRotateAngle(tail04, 0.06981317007977318F, 0.0F, 0.0F);
                this.setRotateAngle(rHindLeg01, -0.20943951023931953F, 0.0F, 0.5235987755982988F);
                this.setRotateAngle(lHindPaw, 1.3089969389957472F, -0.20943951023931953F, 0.0F);
                this.setRotateAngle(lForeleg02, -0.10471975511965977F, 0.0F, 0.0F);
                this.setRotateAngle(tail03, -0.03490658503988659F, 0.0F, 0.0F);
                this.setRotateAngle(torso, -0.17453292519943295F, 0.0F, 0.0F);
                this.setRotateAngle(rForeleg01, 0.8726646259971648F, 0.0F, 0.0F);
                this.setRotateAngle(rForePaw, 0.03490658503988659F, 0.0F, 0.0F);
                this.setRotateAngle(neck, 0.22689280275926282F, 0.0F, 0.0F);
                this.setRotateAngle(lHindLeg03, -0.6981317007977318F, 0.0F, 0.05235987755982988F);
                this.setRotateAngle(rHindLeg02, 0.6981317007977318F, 0.0F, 0.0F);
                this.setRotateAngle(lHindLeg02, 0.6981317007977318F, 0.0F, 0.0F);
                this.setRotateAngle(rHindLeg03, -0.6981317007977318F, 0.0F, -0.05235987755982988F);
                this.setRotateAngle(lHindLeg01, -0.20943951023931953F, 0.0F, -0.5235987755982988F);
                this.setRotateAngle(chest, -0.8028514559173915F, 0.0F, 0.0F);
            } else {
                this.setRotateAngle(neck, -0.5235987755982988F, 0.0F, 0.0F);
                this.setRotateAngle(lHindLeg03, 0.5235987755982988F, 0.0F, 0.05235987755982988F);
                this.setRotateAngle(lHindPaw, 0.12217304763960307F, 0.0F, 0.0F);
                this.setRotateAngle(chest, -0.06981317007977318F, 0.0F, 0.0F);
                this.setRotateAngle(tail04, 0.06981317007977318F, 0.0F, 0.0F);
                this.setRotateAngle(lHindLeg02, -0.2617993877991494F, 0.0F, 0.0F);
                this.setRotateAngle(lForePaw, 0.03490658503988659F, 0.0F, 0.0F);
                this.setRotateAngle(rHindLeg01, -0.3839724354387525F, 0.0F, 0.05235987755982988F);
                this.setRotateAngle(rForeleg01, 0.13962634015954636F, 0.0F, 0.0F);
                this.setRotateAngle(tail02, -0.3141592653589793F, 0.0F, 0.0F);
                this.setRotateAngle(torso, 0.06981317007977318F, 0.0F, 0.0F);
                this.setRotateAngle(lForeleg01, 0.13962634015954636F, 0.0F, 0.0F);
                this.setRotateAngle(lHindLeg01, -0.3839724354387525F, 0.0F, -0.05235987755982988F);
                this.setRotateAngle(tail03, 0.13962634015954636F, 0.0F, 0.0F);
                this.setRotateAngle(rHindLeg02, -0.2617993877991494F, 0.0F, 0.0F);
                this.setRotateAngle(rForeleg02, -0.10471975511965977F, 0.0F, 0.0F);
                this.setRotateAngle(rHindLeg03, 0.5235987755982988F, 0.0F, -0.05235987755982988F);
                this.setRotateAngle(rForePaw, 0.03490658503988659F, 0.0F, 0.0F);
                this.setRotateAngle(lForeleg02, -0.10471975511965977F, 0.0F, 0.0F);
                this.setRotateAngle(rHindPaw, 0.12217304763960307F, 0.0F, 0.0F);
            }
        }
        if (!sit)
            this.quadriped(lHindLeg01, lForeleg01, rHindLeg01, rForeleg01, limbSwing * 0.8665F, limbSwingAmount * 0.9F);
    }

}
