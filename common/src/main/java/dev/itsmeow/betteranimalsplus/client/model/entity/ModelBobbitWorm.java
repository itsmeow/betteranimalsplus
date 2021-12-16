package dev.itsmeow.betteranimalsplus.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.itsmeow.betteranimalsplus.client.model.abstracts.ModelBAP;
import dev.itsmeow.betteranimalsplus.common.entity.EntityBobbitWorm;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;

/**
 * bobbit_worm - cybercat5555
 * Created using Tabula 7.0.1
 */
public class ModelBobbitWorm<T extends LivingEntity> extends ModelBAP<T> {

    public ModelPart body;
    public ModelPart lFin00a;
    public ModelPart rFin00a;
    public ModelPart lFin00b;
    public ModelPart rFin00b;
    public ModelPart head;
    public ModelPart tail00;
    public ModelPart mAntenna;
    public ModelPart lAntenna00;
    public ModelPart rAntenna00;
    public ModelPart lAntenna01;
    public ModelPart rAntenna01;
    public ModelPart lMandible00;
    public ModelPart rMandible00;
    public ModelPart lMandible01;
    public ModelPart lMandible02;
    public ModelPart rMandible01;
    public ModelPart rMandible02;
    public ModelPart lFin01a;
    public ModelPart rFin01a;
    public ModelPart lFin01b;
    public ModelPart rFin01b;
    public ModelPart lFin01c;
    public ModelPart rFin01c;
    public ModelPart tail01;
    public ModelPart lFin02a;
    public ModelPart rFin02a;
    public ModelPart lFin02b;
    public ModelPart rFin02b;
    public ModelPart lFin02c;
    public ModelPart rFin02c;
    public ModelPart tail02;
    public ModelPart lFin03a;
    public ModelPart rFin03a;
    public ModelPart lFin03b;
    public ModelPart rFin03b;
    public ModelPart lFin03c;
    public ModelPart rFin03c;
    public ModelPart tail03;
    public ModelPart lFin04a;
    public ModelPart rFin04a;
    public ModelPart lFin04b;
    public ModelPart rFin04b;
    public ModelPart lFin04c;
    public ModelPart rFin04c;
    public ModelPart tail04;
    public ModelPart lFin05a;
    public ModelPart rFin05a;
    public ModelPart lFin05b;
    public ModelPart rFin05b;
    public ModelPart lFin05c;
    public ModelPart rFin05c;
    public ModelPart tail05;
    public ModelPart lFin06a;
    public ModelPart rFin06a;
    public ModelPart lFin06b;
    public ModelPart rFin06b;
    public ModelPart lFin06c;
    public ModelPart rFin06c;

    public ModelBobbitWorm(ModelPart root) {
        this.body = root.getChild("body");
        this.lFin00a = body.getChild("lFin00a");
        this.rFin00a = body.getChild("rFin00a");
        this.lFin00b = body.getChild("lFin00b");
        this.rFin00b = body.getChild("rFin00b");
        this.head = body.getChild("head");
        this.mAntenna = head.getChild("mAntenna");
        this.lAntenna00 = head.getChild("lAntenna00");
        this.rAntenna00 = head.getChild("rAntenna00");
        this.lAntenna01 = head.getChild("lAntenna01");
        this.rAntenna01 = head.getChild("rAntenna01");
        this.lMandible00 = head.getChild("lMandible00");
        this.lMandible01 = lMandible00.getChild("lMandible01");
        this.lMandible02 = lMandible00.getChild("lMandible02");
        this.rMandible00 = head.getChild("rMandible00");
        this.rMandible01 = rMandible00.getChild("rMandible01");
        this.rMandible02 = rMandible00.getChild("rMandible02");
        this.tail00 = body.getChild("tail00");
        this.lFin01a = tail00.getChild("lFin01a");
        this.rFin01a = tail00.getChild("rFin01a");
        this.lFin01b = tail00.getChild("lFin01b");
        this.rFin01b = tail00.getChild("rFin01b");
        this.lFin01c = tail00.getChild("lFin01c");
        this.rFin01c = tail00.getChild("rFin01c");
        this.tail01 = tail00.getChild("tail01");
        this.lFin02a = tail01.getChild("lFin02a");
        this.rFin02a = tail01.getChild("rFin02a");
        this.lFin02b = tail01.getChild("lFin02b");
        this.rFin02b = tail01.getChild("rFin02b");
        this.lFin02c = tail01.getChild("lFin02c");
        this.rFin02c = tail01.getChild("rFin02c");
        this.tail02 = tail01.getChild("tail02");
        this.lFin03a = tail02.getChild("lFin03a");
        this.rFin03a = tail02.getChild("rFin03a");
        this.lFin03b = tail02.getChild("lFin03b");
        this.rFin03b = tail02.getChild("rFin03b");
        this.lFin03c = tail02.getChild("lFin03c");
        this.rFin03c = tail02.getChild("rFin03c");
        this.tail03 = tail02.getChild("tail03");
        this.lFin04a = tail03.getChild("lFin04a");
        this.rFin04a = tail03.getChild("rFin04a");
        this.lFin04b = tail03.getChild("lFin04b");
        this.rFin04b = tail03.getChild("rFin04b");
        this.lFin04c = tail03.getChild("lFin04c");
        this.rFin04c = tail03.getChild("rFin04c");
        this.tail04 = tail03.getChild("tail04");
        this.lFin05a = tail04.getChild("lFin05a");
        this.rFin05a = tail04.getChild("rFin05a");
        this.lFin05b = tail04.getChild("lFin05b");
        this.rFin05b = tail04.getChild("rFin05b");
        this.lFin05c = tail04.getChild("lFin05c");
        this.rFin05c = tail04.getChild("rFin05c");
        this.tail05 = tail04.getChild("tail05");
        this.lFin06a = tail05.getChild("lFin06a");
        this.rFin06a = tail05.getChild("rFin06a");
        this.lFin06b = tail05.getChild("lFin06b");
        this.rFin06b = tail05.getChild("rFin06b");
        this.lFin06c = tail05.getChild("lFin06c");
        this.rFin06c = tail05.getChild("rFin06c");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 13).addBox(-3.0F, -2.0F, -4.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, 0.0F));
        PartDefinition lFin00a = body.addOrReplaceChild("lFin00a", CubeListBuilder.create().texOffs(28, 0).addBox(0.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.8F, 1.2F, -0.1F));
        PartDefinition rFin00a = body.addOrReplaceChild("rFin00a", CubeListBuilder.create().texOffs(28, 0).mirror().addBox(-5.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.8F, 1.2F, -0.1F));
        PartDefinition lFin00b = body.addOrReplaceChild("lFin00b", CubeListBuilder.create().texOffs(28, 0).addBox(0.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.8F, 0.6F, 2.5F));
        PartDefinition rFin00b = body.addOrReplaceChild("rFin00b", CubeListBuilder.create().texOffs(28, 0).mirror().addBox(-5.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.8F, 0.6F, 2.5F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -2.0F, -7.0F, 7.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -4.0F));
        PartDefinition mAntenna = head.addOrReplaceChild("mAntenna", CubeListBuilder.create().texOffs(37, 0).addBox(-0.5F, 0.0F, -6.0F, 1.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.7F, -6.2F, -0.3142F, 0.0F, 0.0F));
        PartDefinition lAntenna00 = head.addOrReplaceChild("lAntenna00", CubeListBuilder.create().texOffs(37, 0).addBox(-0.5F, 0.0F, -6.0F, 1.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -1.3F, -6.2F, -0.2793F, 0.384F, 0.0F));
        PartDefinition rAntenna00 = head.addOrReplaceChild("rAntenna00", CubeListBuilder.create().texOffs(37, 0).mirror().addBox(-0.5F, 0.0F, -6.0F, 1.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, -1.3F, -6.2F, -0.2793F, -0.384F, 0.0F));
        PartDefinition lAntenna01 = head.addOrReplaceChild("lAntenna01", CubeListBuilder.create().texOffs(37, 0).addBox(-0.5F, 0.0F, -6.0F, 1.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3F, -0.9F, -6.2F, -0.1745F, 0.1745F, 0.0F));
        PartDefinition rAntenna01 = head.addOrReplaceChild("rAntenna01", CubeListBuilder.create().texOffs(37, 0).mirror().addBox(-0.5F, 0.0F, -6.0F, 1.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.3F, -0.9F, -6.2F, -0.1745F, -0.1745F, 0.0F));
        PartDefinition lMandible00 = head.addOrReplaceChild("lMandible00", CubeListBuilder.create().texOffs(31, 7).addBox(-7.0F, -1.4F, -2.5F, 7.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9F, 0.5F, -5.3F, 0.0F, -0.384F, 0.0F));
        PartDefinition lMandible01 = lMandible00.addOrReplaceChild("lMandible01", CubeListBuilder.create().texOffs(31, 13).addBox(-5.0F, -0.5F, -1.3F, 5.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.4F, -0.8F, -0.2F, 0.0F, -0.5236F, 0.1745F));
        PartDefinition lMandible02 = lMandible00.addOrReplaceChild("lMandible02", CubeListBuilder.create().texOffs(31, 13).addBox(-5.0F, -0.5F, -1.3F, 5.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.4F, -0.1F, -0.2F, 0.0F, -0.5236F, 0.0F));
        PartDefinition rMandible00 = head.addOrReplaceChild("rMandible00", CubeListBuilder.create().texOffs(31, 7).mirror().addBox(0.0F, -1.4F, -2.5F, 7.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.9F, 0.5F, -5.3F, 0.0F, 0.384F, 0.0F));
        PartDefinition rMandible01 = rMandible00.addOrReplaceChild("rMandible01", CubeListBuilder.create().texOffs(31, 13).mirror().addBox(0.0F, -0.5F, -1.3F, 5.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.4F, -0.8F, -0.2F, 0.0F, 0.5236F, -0.1745F));
        PartDefinition rMandible02 = rMandible00.addOrReplaceChild("rMandible02", CubeListBuilder.create().texOffs(31, 13).mirror().addBox(0.0F, -0.5F, -1.3F, 5.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.4F, -0.1F, -0.2F, 0.0F, 0.5236F, 0.0F));
        PartDefinition tail00 = body.addOrReplaceChild("tail00", CubeListBuilder.create().texOffs(0, 13).addBox(-3.0F, -2.0F, 0.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 4.0F));
        PartDefinition lFin01a = tail00.addOrReplaceChild("lFin01a", CubeListBuilder.create().texOffs(28, 0).addBox(0.0F, 0.0F, -1.1F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.8F, 0.0F, 1.2F));
        PartDefinition rFin01a = tail00.addOrReplaceChild("rFin01a", CubeListBuilder.create().texOffs(28, 0).mirror().addBox(-5.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.8F, 0.0F, 1.2F));
        PartDefinition lFin01b = tail00.addOrReplaceChild("lFin01b", CubeListBuilder.create().texOffs(28, 0).addBox(0.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.8F, 0.0F, 4.0F));
        PartDefinition rFin01b = tail00.addOrReplaceChild("rFin01b", CubeListBuilder.create().texOffs(28, 0).mirror().addBox(-5.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.8F, 0.0F, 4.0F));
        PartDefinition lFin01c = tail00.addOrReplaceChild("lFin01c", CubeListBuilder.create().texOffs(28, 0).addBox(0.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.8F, 0.0F, 6.6F));
        PartDefinition rFin01c = tail00.addOrReplaceChild("rFin01c", CubeListBuilder.create().texOffs(28, 0).mirror().addBox(-5.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.8F, 0.0F, 6.6F));
        PartDefinition tail01 = tail00.addOrReplaceChild("tail01", CubeListBuilder.create().texOffs(0, 13).mirror().addBox(-3.0F, -2.0F, 0.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 8.0F));
        PartDefinition lFin02a = tail01.addOrReplaceChild("lFin02a", CubeListBuilder.create().texOffs(28, 0).addBox(0.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.8F, 0.0F, 1.2F));
        PartDefinition rFin02a = tail01.addOrReplaceChild("rFin02a", CubeListBuilder.create().texOffs(28, 0).mirror().addBox(-5.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.8F, 0.0F, 1.2F));
        PartDefinition lFin02b = tail01.addOrReplaceChild("lFin02b", CubeListBuilder.create().texOffs(28, 0).addBox(0.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.8F, 0.0F, 4.0F));
        PartDefinition rFin02b = tail01.addOrReplaceChild("rFin02b", CubeListBuilder.create().texOffs(28, 0).mirror().addBox(-5.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.8F, 0.0F, 4.0F));
        PartDefinition lFin02c = tail01.addOrReplaceChild("lFin02c", CubeListBuilder.create().texOffs(28, 0).addBox(0.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.8F, 0.0F, 6.6F));
        PartDefinition rFin02c = tail01.addOrReplaceChild("rFin02c", CubeListBuilder.create().texOffs(28, 0).mirror().addBox(-5.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.8F, 0.0F, 6.6F));
        PartDefinition tail02 = tail01.addOrReplaceChild("tail02", CubeListBuilder.create().texOffs(0, 13).addBox(-3.0F, -2.0F, 0.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 8.0F));
        PartDefinition lFin03a = tail02.addOrReplaceChild("lFin03a", CubeListBuilder.create().texOffs(28, 0).addBox(0.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.8F, 0.0F, 1.2F));
        PartDefinition rFin03a = tail02.addOrReplaceChild("rFin03a", CubeListBuilder.create().texOffs(28, 0).mirror().addBox(-5.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.8F, 0.0F, 1.2F));
        PartDefinition lFin03b = tail02.addOrReplaceChild("lFin03b", CubeListBuilder.create().texOffs(28, 0).addBox(0.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.8F, 0.0F, 4.0F));
        PartDefinition rFin03b = tail02.addOrReplaceChild("rFin03b", CubeListBuilder.create().texOffs(28, 0).mirror().addBox(-5.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.8F, 0.0F, 4.0F));
        PartDefinition lFin03c = tail02.addOrReplaceChild("lFin03c", CubeListBuilder.create().texOffs(28, 0).addBox(0.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.8F, 0.0F, 6.6F));
        PartDefinition rFin03c = tail02.addOrReplaceChild("rFin03c", CubeListBuilder.create().texOffs(28, 0).mirror().addBox(-5.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.8F, 0.0F, 6.6F));
        PartDefinition tail03 = tail02.addOrReplaceChild("tail03", CubeListBuilder.create().texOffs(0, 13).mirror().addBox(-3.0F, -2.0F, 0.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 8.0F));
        PartDefinition lFin04a = tail03.addOrReplaceChild("lFin04a", CubeListBuilder.create().texOffs(28, 0).addBox(0.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.8F, 0.0F, 1.2F));
        PartDefinition rFin04a = tail03.addOrReplaceChild("rFin04a", CubeListBuilder.create().texOffs(28, 0).mirror().addBox(-5.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.8F, 0.0F, 1.2F));
        PartDefinition lFin04b = tail03.addOrReplaceChild("lFin04b", CubeListBuilder.create().texOffs(28, 0).addBox(0.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.8F, 0.0F, 4.0F));
        PartDefinition rFin04b = tail03.addOrReplaceChild("rFin04b", CubeListBuilder.create().texOffs(28, 0).mirror().addBox(-5.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.8F, 0.0F, 4.0F));
        PartDefinition lFin04c = tail03.addOrReplaceChild("lFin04c", CubeListBuilder.create().texOffs(28, 0).addBox(0.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.8F, 0.0F, 6.6F));
        PartDefinition rFin04c = tail03.addOrReplaceChild("rFin04c", CubeListBuilder.create().texOffs(28, 0).mirror().addBox(-5.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.8F, 0.0F, 6.6F));
        PartDefinition tail04 = tail03.addOrReplaceChild("tail04", CubeListBuilder.create().texOffs(20, 19).addBox(-2.5F, -2.0F, 0.0F, 5.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 8.0F));
        PartDefinition lFin05a = tail04.addOrReplaceChild("lFin05a", CubeListBuilder.create().texOffs(28, 0).addBox(0.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.3F, 0.0F, 1.2F));
        PartDefinition rFin05a = tail04.addOrReplaceChild("rFin05a", CubeListBuilder.create().texOffs(28, 0).mirror().addBox(-5.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.3F, 0.0F, 1.2F));
        PartDefinition lFin05b = tail04.addOrReplaceChild("lFin05b", CubeListBuilder.create().texOffs(28, 0).addBox(0.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.8F, 0.0F, 3.8F));
        PartDefinition rFin05b = tail04.addOrReplaceChild("rFin05b", CubeListBuilder.create().texOffs(28, 0).mirror().addBox(-5.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.8F, 0.0F, 3.8F));
        PartDefinition lFin05c = tail04.addOrReplaceChild("lFin05c", CubeListBuilder.create().texOffs(28, 0).addBox(0.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1F, 0.0F, 6.2F, 0.0F, -0.0698F, 0.0F));
        PartDefinition rFin05c = tail04.addOrReplaceChild("rFin05c", CubeListBuilder.create().texOffs(28, 0).mirror().addBox(-5.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.1F, 0.0F, 6.2F, 0.0F, 0.0698F, 0.0F));
        PartDefinition tail05 = tail04.addOrReplaceChild("tail05", CubeListBuilder.create().texOffs(39, 13).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 8.0F));
        PartDefinition lFin06a = tail05.addOrReplaceChild("lFin06a", CubeListBuilder.create().texOffs(28, 3).addBox(0.0F, 0.0F, -1.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8F, 0.0F, 1.2F, 0.0F, -0.1396F, 0.0F));
        PartDefinition rFin06a = tail05.addOrReplaceChild("rFin06a", CubeListBuilder.create().texOffs(28, 3).mirror().addBox(-4.0F, 0.0F, -1.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.8F, 0.0F, 1.2F, 0.0F, 0.1396F, 0.0F));
        PartDefinition lFin06b = tail05.addOrReplaceChild("lFin06b", CubeListBuilder.create().texOffs(28, 3).addBox(0.0F, 0.0F, -1.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3F, 0.0F, 3.8F, 0.0F, -0.2793F, 0.0F));
        PartDefinition rFin06b = tail05.addOrReplaceChild("rFin06b", CubeListBuilder.create().texOffs(28, 3).mirror().addBox(-4.0F, 0.0F, -1.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.3F, 0.0F, 3.8F, 0.0F, 0.2793F, 0.0F));
        PartDefinition lFin06c = tail05.addOrReplaceChild("lFin06c", CubeListBuilder.create().texOffs(28, 3).addBox(0.0F, 0.0F, -1.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6F, 0.0F, 6.2F, 0.0F, -0.3491F, 0.0F));
        PartDefinition rFin06c = tail05.addOrReplaceChild("rFin06c", CubeListBuilder.create().texOffs(28, 3).mirror().addBox(-4.0F, 0.0F, -1.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.6F, 0.0F, 6.2F, 0.0F, 0.3491F, 0.0F));
        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        matrixStackIn.translate(0, 1, 0);
        this.body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entity instanceof EntityBobbitWorm) {
            EntityBobbitWorm worm = (EntityBobbitWorm) entity;
            int attack = worm.getAttackState();

            float add = entity.getUUID().hashCode() * 0.001F;
            if (attack > 0) {
                float angle = ((30 - attack) % 60) * 0.04F + 0.3839724354387525F;
                this.lMandible00.yRot = angle;
                this.rMandible00.yRot = -angle;
            } else {
                float mul = 0.1F;
                float div = 40F;
                this.lMandible00.yRot = (float) Math.cos(ageInTicks * (mul + 0.03F) + add) / div + 0.3839724354387525F;
                this.rMandible00.yRot = (float) Math.cos(ageInTicks * (mul) + add) / div - 0.3839724354387525F;
            }
            this.body.xRot = 0;
            this.body.y = 0;
            if (worm.getDeltaMovement().x() < 0.03 && worm.getDeltaMovement().z() < 0.03 && worm.getDeltaMovement().y() < 0.03 && !worm.getMoveControl().hasWanted() && worm.isGoodBurrowingPosition(worm.blockPosition())) {
                this.body.xRot = -(float) Math.toRadians(60F);
                this.body.y = 0.3F;
            }
            float mul = 0.3F;
            float div = 20F;
            this.lAntenna00.xRot = (float) Math.cos(ageInTicks * (mul + 0.05F) + add) / div;
            this.lAntenna01.xRot = (float) Math.cos(ageInTicks * mul + add) / div;
            this.mAntenna.xRot = (float) Math.cos(ageInTicks * (mul + 0.1F) + add) / div;
            this.rAntenna00.xRot = (float) Math.cos(ageInTicks * mul + add) / div;
            this.rAntenna01.xRot = (float) Math.cos(ageInTicks * (mul + 0.03F) + add) / div;
        }
    }

}
