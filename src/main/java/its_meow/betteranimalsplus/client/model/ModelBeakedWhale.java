package its_meow.betteranimalsplus.client.model;

import its_meow.betteranimalsplus.util.ModMathHelper;
import its_meow.betteranimalsplus.util.RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;

/**
 * BeakedWhale - Batman
 * Created using Tabula 7.0.1
 */
public class ModelBeakedWhale extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer tail00;
    public ModelRenderer neck;
    public ModelRenderer lFin00;
    public ModelRenderer rFin00;
    public ModelRenderer tail01;
    public ModelRenderer tail02;
    public ModelRenderer dorsalFin00;
    public ModelRenderer tail03;
    public ModelRenderer tail04;
    public ModelRenderer flukeMiddle;
    public ModelRenderer flukeL01;
    public ModelRenderer flukeR01;
    public ModelRenderer flukeL02;
    public ModelRenderer flukeL03;
    public ModelRenderer flukeR02;
    public ModelRenderer flukeR03;
    public ModelRenderer head;
    public ModelRenderer topJaw;
    public ModelRenderer lowJaw;
    public ModelRenderer snout;
    public ModelRenderer topTeeth;
    public ModelRenderer topTeeth2;
    public ModelRenderer lowTeeth;
    public ModelRenderer lFin01;
    public ModelRenderer lFin02;
    public ModelRenderer rFin01;
    public ModelRenderer rFin02;

    public ModelBeakedWhale() {
        this.textureWidth = 65;
        this.textureHeight = 200;
        this.rFin01 = new ModelRenderer(this, 12, 178);
        this.rFin01.setRotationPoint(-0.5F, 2.9F, 0.0F);
        this.rFin01.addBox(0.0F, 0.0F, 0.0F, 1, 4, 3, 0.0F);
        this.setRotateAngle(rFin01, 0.36425021489121656F, 0.0F, 0.0F);
        this.neck = new ModelRenderer(this, 0, 103);
        this.neck.setRotationPoint(0.0F, -1.0F, -13.4F);
        this.neck.addBox(-4.5F, -1.5F, -8.0F, 9, 10, 8, 0.0F);
        this.setRotateAngle(neck, 0.045553093477052F, 0.0F, 0.0F);
        this.tail04 = new ModelRenderer(this, 0, 93);
        this.tail04.setRotationPoint(0.0F, -0.4F, 5.9F);
        this.tail04.addBox(-2.5F, -0.5F, 0.0F, 5, 4, 5, 0.0F);
        this.setRotateAngle(tail04, -0.22759093446006054F, 0.0F, 0.0F);
        this.rFin02 = new ModelRenderer(this, 0, 188);
        this.rFin02.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.rFin02.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2, 0.0F);
        this.tail00 = new ModelRenderer(this, 0, 27);
        this.tail00.setRotationPoint(0.0F, -1.0F, -0.7F);
        this.tail00.addBox(-5.0F, -1.5F, 0.0F, 10, 10, 10, 0.0F);
        this.setRotateAngle(tail00, -0.091106186954104F, 0.0F, 0.0F);
        this.snout = new ModelRenderer(this, 28, 138);
        this.snout.setRotationPoint(0.0F, -1.0F, -7.0F);
        this.snout.addBox(-2.5F, 0.0F, 0.0F, 5, 2, 8, 0.0F);
        this.setRotateAngle(snout, 0.27314402793711257F, 0.0F, 0.0F);
        this.tail02 = new ModelRenderer(this, 0, 65);
        this.tail02.setRotationPoint(0.0F, 0.1F, 7.3F);
        this.tail02.addBox(-3.5F, -1.0F, 0.0F, 7, 8, 7, 0.0F);
        this.setRotateAngle(tail02, -0.045553093477052F, 0.0F, 0.0F);
        this.flukeL03 = new ModelRenderer(this, 34, 59);
        this.flukeL03.mirror = true;
        this.flukeL03.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.flukeL03.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 2, 0.0F);
        this.setRotateAngle(flukeL03, 0.22759093446006054F, 0.0F, 0.0F);
        this.lFin02 = new ModelRenderer(this, 0, 188);
        this.lFin02.mirror = true;
        this.lFin02.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.lFin02.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2, 0.0F);
        this.flukeR01 = new ModelRenderer(this, 41, 59);
        this.flukeR01.setRotationPoint(-2.0F, 0.1F, -0.5F);
        this.flukeR01.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 5, 0.0F);
        this.setRotateAngle(flukeR01, 0.5009094953223726F, 0.0F, 1.3203415791337103F);
        this.flukeL01 = new ModelRenderer(this, 41, 59);
        this.flukeL01.mirror = true;
        this.flukeL01.setRotationPoint(2.0F, 0.1F, -0.5F);
        this.flukeL01.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 5, 0.0F);
        this.setRotateAngle(flukeL01, 0.5009094953223726F, 0.0F, -1.3203415791337103F);
        this.flukeR03 = new ModelRenderer(this, 34, 59);
        this.flukeR03.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.flukeR03.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 2, 0.0F);
        this.setRotateAngle(flukeR03, 0.22759093446006054F, 0.0F, 0.0F);
        this.lowTeeth = new ModelRenderer(this, 25, 149);
        this.lowTeeth.setRotationPoint(0.0F, -1.5F, -6.5F);
        this.lowTeeth.addBox(-1.5F, 0.0F, 0.0F, 3, 1, 6, 0.0F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0.0F, 10.0F, 3.0F);
        this.body.addBox(-5.5F, -2.5F, -14.0F, 11, 11, 14, 0.0F);
        this.setRotateAngle(body, 0.022863813201125717F, 0.0F, 0.0F);
        this.topJaw = new ModelRenderer(this, 0, 138);
        this.topJaw.setRotationPoint(0.0F, 4.3F, -6.0F);
        this.topJaw.addBox(-3.0F, -1.0F, -7.0F, 6, 2, 7, 0.0F);
        this.topTeeth2 = new ModelRenderer(this, 0, 159);
        this.topTeeth2.setRotationPoint(0.1F, 0.5F, -6.4F);
        this.topTeeth2.addBox(-2.0F, 0.0F, 0.0F, 2, 1, 7, 0.0F);
        this.flukeMiddle = new ModelRenderer(this, 33, 51);
        this.flukeMiddle.setRotationPoint(0.0F, 0.6F, 4.8F);
        this.flukeMiddle.addBox(-1.5F, -1.0F, 0.0F, 3, 2, 4, 0.0F);
        this.head = new ModelRenderer(this, 0, 122);
        this.head.setRotationPoint(0.0F, 0.0F, -7.9F);
        this.head.addBox(-4.0F, -1.5F, -6.0F, 8, 9, 6, 0.0F);
        this.setRotateAngle(head, 0.045553093477052F, 0.0F, 0.0F);
        this.lFin00 = new ModelRenderer(this, 0, 178);
        this.lFin00.mirror = true;
        this.lFin00.setRotationPoint(5.0F, 7.0F, -13.9F);
        this.lFin00.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 4, 0.0F);
        this.setRotateAngle(lFin00, 0.5462880558742251F, 0.0F, -0.40980330836826856F);
        this.lowJaw = new ModelRenderer(this, 0, 148);
        this.lowJaw.setRotationPoint(0.0F, 6.5F, -5.5F);
        this.lowJaw.addBox(-2.0F, -1.0F, -7.0F, 4, 2, 7, 0.0F);
        this.setRotateAngle(lowJaw, -0.091106186954104F, 0.0F, 0.0F);
        this.flukeR02 = new ModelRenderer(this, 30, 67);
        this.flukeR02.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.flukeR02.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 3, 0.0F);
        this.setRotateAngle(flukeR02, 0.27314402793711257F, 0.0F, 0.0F);
        this.lFin01 = new ModelRenderer(this, 12, 178);
        this.lFin01.mirror = true;
        this.lFin01.setRotationPoint(-0.5F, 2.9F, 0.0F);
        this.lFin01.addBox(0.0F, 0.0F, 0.0F, 1, 4, 3, 0.0F);
        this.setRotateAngle(lFin01, 0.36425021489121656F, 0.0F, 0.0F);
        this.tail01 = new ModelRenderer(this, 0, 48);
        this.tail01.setRotationPoint(0.0F, -0.4F, 9.4F);
        this.tail01.addBox(-4.0F, -1.0F, 0.0F, 8, 9, 8, 0.0F);
        this.setRotateAngle(tail01, -0.091106186954104F, 0.0F, 0.0F);
        this.rFin00 = new ModelRenderer(this, 0, 178);
        this.rFin00.setRotationPoint(-5.0F, 7.0F, -13.9F);
        this.rFin00.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 4, 0.0F);
        this.setRotateAngle(rFin00, 0.5462880558742251F, 0.0F, 0.40980330836826856F);
        this.flukeL02 = new ModelRenderer(this, 30, 67);
        this.flukeL02.mirror = true;
        this.flukeL02.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.flukeL02.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 3, 0.0F);
        this.setRotateAngle(flukeL02, 0.27314402793711257F, 0.0F, 0.0F);
        this.tail03 = new ModelRenderer(this, 0, 80);
        this.tail03.setRotationPoint(0.0F, 0.0F, 6.7F);
        this.tail03.addBox(-3.0F, -1.0F, 0.0F, 6, 6, 6, 0.0F);
        this.setRotateAngle(tail03, -0.18203784098300857F, 0.0F, 0.0F);
        this.dorsalFin00 = new ModelRenderer(this, 29, 124);
        this.dorsalFin00.setRotationPoint(0.5F, -3.0F, 1.0F);
        this.dorsalFin00.addBox(-1.5F, -0.4F, 0.0F, 2, 3, 5, 0.0F);
        this.setRotateAngle(dorsalFin00, -0.5462880558742251F, 0.0F, 0.0F);
        this.topTeeth = new ModelRenderer(this, 0, 159);
        this.topTeeth.mirror = true;
        this.topTeeth.setRotationPoint(-0.1F, 0.5F, -6.4F);
        this.topTeeth.addBox(0.0F, 0.0F, 0.0F, 2, 1, 7, 0.0F);
        this.rFin00.addChild(this.rFin01);
        this.body.addChild(this.neck);
        this.tail03.addChild(this.tail04);
        this.rFin01.addChild(this.rFin02);
        this.body.addChild(this.tail00);
        this.topJaw.addChild(this.snout);
        this.tail01.addChild(this.tail02);
        this.flukeL02.addChild(this.flukeL03);
        this.lFin01.addChild(this.lFin02);
        this.flukeMiddle.addChild(this.flukeR01);
        this.flukeMiddle.addChild(this.flukeL01);
        this.flukeR02.addChild(this.flukeR03);
        this.lowJaw.addChild(this.lowTeeth);
        this.head.addChild(this.topJaw);
        this.topJaw.addChild(this.topTeeth2);
        this.tail04.addChild(this.flukeMiddle);
        this.neck.addChild(this.head);
        this.body.addChild(this.lFin00);
        this.head.addChild(this.lowJaw);
        this.flukeR01.addChild(this.flukeR02);
        this.lFin00.addChild(this.lFin01);
        this.tail00.addChild(this.tail01);
        this.body.addChild(this.rFin00);
        this.flukeL01.addChild(this.flukeL02);
        this.tail02.addChild(this.tail03);
        this.tail01.addChild(this.dorsalFin00);
        this.topJaw.addChild(this.topTeeth);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        if(!entity.isInWater()) {
            GlStateManager.translate(0F, 0.25F, 0F);
        }
        this.body.render(f5);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
        if(!Minecraft.getMinecraft().isGamePaused()) {
            if(entity instanceof EntityLivingBase) {
                EntityLivingBase entityL = (EntityLivingBase) entity;
                double motionLength = MathHelper.sqrt(entity.motionX * entity.motionX + entity.motionY * entity.motionY + entity.motionZ * entity.motionZ);
                if(entity.isInWater()) {
                    float pitch = (float) Math.toRadians(ModelBetterAnimals.getHeadPitch(entityL));
                    this.body.rotateAngleX = (float) ((pitch / Math.abs(pitch)) * Math.min(Math.abs(pitch), Math.toRadians(45F)));
                    this.body.rotateAngleY = (float) Math.toRadians(ModelBetterAnimals.getHeadYaw(entityL));
                } else {
                    this.body.rotateAngleY = -(float) Math.toRadians(ModMathHelper.interpolateRotation(entityL.renderYawOffset, entityL.prevRenderYawOffset, Minecraft.getMinecraft().getRenderPartialTicks()));
                    this.body.rotateAngleX = 0.022863813201125717F;
                }
                {
                    float ticks = ageInTicks / 5F + (float) motionLength * 0.05F;
                    float factor = 1F;
                    float offset = 0F;
                    float amplitude = (float) Math.min(motionLength * 1.1F + 0.01F, 0.1F);
                    if(!entity.isInWater()) {
                        amplitude = 0F;
                        offset = -0.1F;
                    }
                    float z01 = (float) RenderUtil.partLocation(this.tail00, this.tail01).z;
                    float z02 = (float) RenderUtil.partLocation(this.tail00, this.tail01, this.tail02).z;
                    float z03 = (float) RenderUtil.partLocation(this.tail00, this.tail01, this.tail02, this.tail03).z;
                    float z04 = (float) RenderUtil.partLocation(this.tail00, this.tail01, this.tail02, this.tail03, this.tail04).z;
                    this.tail01.rotateAngleX = MathHelper.sin(z01 * factor + ticks) * amplitude + offset;
                    this.tail02.rotateAngleX = MathHelper.sin(z02 * factor + ticks) * amplitude + offset;
                    this.tail03.rotateAngleX = MathHelper.sin(z03 * factor + ticks) * amplitude + offset;
                    this.tail04.rotateAngleX = MathHelper.sin(z04 * factor + ticks) * amplitude + offset;
                }
                {
                    float mul = 0.1F;
                    float div = 10F;
                    float add = entity.getUniqueID().hashCode() * 0.001F;
                    this.lFin00.rotateAngleX = (float) Math.cos(ageInTicks * (mul + 0.05F) + add) / div + 0.8651597102135892F;
                    this.rFin00.rotateAngleX = (float) Math.cos(ageInTicks * (mul) + add) / div + 0.8651597102135892F;
                }
            }
        }
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
