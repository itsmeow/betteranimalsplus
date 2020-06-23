package its_meow.betteranimalsplus.client.model;

import com.mojang.blaze3d.platform.GlStateManager;

import dev.itsmeow.imdlib.client.util.RenderUtil;
import its_meow.betteranimalsplus.util.ModMathHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;

/**
 * SmallWhale - Batman
 * Created using Tabula 7.0.1
 */
public class ModelSmallWhale<T extends LivingEntity> extends EntityModel<T> {
    public RendererModel body;
    public RendererModel tail00;
    public RendererModel neck;
    public RendererModel lFin00;
    public RendererModel rFin00;
    public RendererModel dorsalFin00;
    public RendererModel tail01;
    public RendererModel tail02;
    public RendererModel tail03;
    public RendererModel tail04;
    public RendererModel flukeMiddle;
    public RendererModel flukeL01;
    public RendererModel flukeR01;
    public RendererModel flukeL02;
    public RendererModel flukeL03;
    public RendererModel flukeR02;
    public RendererModel flukeR03;
    public RendererModel head;
    public RendererModel topJaw;
    public RendererModel lowJaw;
    public RendererModel snout;
    public RendererModel topTeethL;
    public RendererModel topTeethR;
    public RendererModel horn;
    public RendererModel fKWSnout1;
    public RendererModel fKWSnout2;
    public RendererModel lowJaw2;
    public RendererModel lowTeeth;
    public RendererModel lFin01;
    public RendererModel lFin02;
    public RendererModel rFin01;
    public RendererModel rFin02;
    public RendererModel dorsalFin01;
    public RendererModel dorsalFin03;
    public RendererModel dorsalFin02;
    public RendererModel dorsalFin04;

    public ModelSmallWhale() {
        this.textureWidth = 60;
        this.textureHeight = 200;
        this.snout = new RendererModel(this, 0, 141);
        this.snout.setRotationPoint(-1.0F, -3.9F, -4.5F);
        this.snout.addBox(-2.0F, -1.0F, -1.0F, 6, 5, 5, 0.0F);
        this.tail03 = new RendererModel(this, 0, 78);
        this.tail03.setRotationPoint(0.0F, 0.0F, 4.7F);
        this.tail03.addBox(-2.0F, -1.0F, 0.0F, 4, 5, 5, 0.0F);
        this.setRotateAngle(tail03, -0.18203784098300857F, 0.0F, 0.0F);
        this.flukeR01 = new RendererModel(this, 41, 51);
        this.flukeR01.setRotationPoint(-1.3F, 0.1F, -0.5F);
        this.flukeR01.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 5, 0.0F);
        this.setRotateAngle(flukeR01, 0.5009094953223726F, 0.0F, 1.3203415791337103F);
        this.flukeMiddle = new RendererModel(this, 25, 51);
        this.flukeMiddle.setRotationPoint(0.0F, 1.0F, 3.7F);
        this.flukeMiddle.addBox(-1.5F, -1.0F, 0.0F, 3, 2, 4, 0.0F);
        this.rFin02 = new RendererModel(this, 0, 189);
        this.rFin02.setRotationPoint(0.0F, 3.7F, 1.0F);
        this.rFin02.addBox(0.0F, 0.0F, -1.0F, 1, 4, 2, 0.0F);
        this.setRotateAngle(rFin02, 0.136659280431156F, 0.0F, 0.0F);
        this.tail04 = new RendererModel(this, 0, 89);
        this.tail04.setRotationPoint(0.0F, -0.4F, 4.9F);
        this.tail04.addBox(-1.5F, -0.5F, 0.0F, 3, 4, 4, 0.0F);
        this.setRotateAngle(tail04, -0.22759093446006054F, 0.0F, 0.0F);
        this.lFin01 = new RendererModel(this, 12, 178);
        this.lFin01.mirror = true;
        this.lFin01.setRotationPoint(-0.5F, 4.9F, 0.0F);
        this.lFin01.addBox(0.0F, 0.0F, 0.0F, 1, 4, 3, 0.0F);
        this.setRotateAngle(lFin01, 0.36425021489121656F, 0.0F, 0.0F);
        this.dorsalFin01 = new RendererModel(this, 26, 134);
        this.dorsalFin01.setRotationPoint(0.0F, -3.1F, 0.4F);
        this.dorsalFin01.addBox(-1.0F, 0.0F, 0.0F, 1, 3, 5, 0.0F);
        this.setRotateAngle(dorsalFin01, -0.136659280431156F, 0.0F, 0.0F);
        this.dorsalFin02 = new RendererModel(this, 26, 144);
        this.dorsalFin02.setRotationPoint(-1.0F, -1.8F, 0.2F);
        this.dorsalFin02.addBox(0.0F, -2.2F, 0.1F, 1, 4, 4, 0.0F);
        this.setRotateAngle(dorsalFin02, -0.08726646259971647F, 0.0F, 0.0F);
        this.dorsalFin03 = new RendererModel(this, 26, 159);
        this.dorsalFin03.setRotationPoint(-1.0F, -6.2F, 2.3F);
        this.dorsalFin03.addBox(0.0F, -3.1F, -1.0F, 1, 3, 2, 0.0F);
        this.setRotateAngle(dorsalFin03, -0.5235987755982988F, 0.0F, 0.0F);
        this.rFin00 = new RendererModel(this, 0, 178);
        this.rFin00.setRotationPoint(-4.5F, 6.6F, -12.9F);
        this.rFin00.addBox(-0.5F, 0.0F, 0.0F, 1, 5, 4, 0.0F);
        this.setRotateAngle(rFin00, 0.8651597102135892F, 0.0F, 0.40980330836826856F);
        this.lFin00 = new RendererModel(this, 0, 178);
        this.lFin00.mirror = true;
        this.lFin00.setRotationPoint(4.5F, 6.6F, -12.9F);
        this.lFin00.addBox(-0.5F, 0.0F, 0.0F, 1, 5, 4, 0.0F);
        this.setRotateAngle(lFin00, 0.8651597102135892F, 0.0F, -0.40980330836826856F);
        this.head = new RendererModel(this, 0, 122);
        this.head.setRotationPoint(0.0F, -0.5F, -7.8F);
        this.head.addBox(-4.0F, -1.0F, -3.0F, 8, 7, 3, 0.0F);
        this.setRotateAngle(head, 0.136659280431156F, 0.0F, 0.0F);
        this.flukeL01 = new RendererModel(this, 41, 51);
        this.flukeL01.mirror = true;
        this.flukeL01.setRotationPoint(1.3F, 0.1F, -0.5F);
        this.flukeL01.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 5, 0.0F);
        this.setRotateAngle(flukeL01, 0.5009094953223726F, 0.0F, -1.3203415791337103F);
        this.lFin02 = new RendererModel(this, 0, 189);
        this.lFin02.mirror = true;
        this.lFin02.setRotationPoint(0.0F, 3.7F, 1.0F);
        this.lFin02.addBox(0.0F, 0.0F, -1.0F, 1, 4, 2, 0.0F);
        this.setRotateAngle(lFin02, 0.136659280431156F, 0.0F, 0.0F);
        this.body = new RendererModel(this, 0, 0);
        this.body.setRotationPoint(0.0F, 12.0F, 3.0F);
        this.body.addBox(-5.0F, -2.5F, -14.0F, 10, 10, 14, 0.0F);
        this.setRotateAngle(body, 0.022863813201125717F, 0.0F, 0.0F);
        this.tail01 = new RendererModel(this, 0, 50);
        this.tail01.setRotationPoint(0.0F, -0.4F, 8.4F);
        this.tail01.addBox(-3.0F, -1.0F, 0.0F, 6, 8, 6, 0.0F);
        this.setRotateAngle(tail01, -0.091106186954104F, 0.0F, 0.0F);
        this.horn = new RendererModel(this, 21, 31);
        this.horn.setRotationPoint(0.0F, 0.9F, -4.0F);
        this.horn.addBox(-0.5F, -0.5F, -17.0F, 1, 1, 17, 0.0F);
        this.topJaw = new RendererModel(this, 0, 133);
        this.topJaw.setRotationPoint(0.0F, 4.0F, -2.5F);
        this.topJaw.addBox(-3.5F, 0.0F, -5.0F, 7, 2, 5, 0.0F);
        this.lowJaw = new RendererModel(this, 0, 159);
        this.lowJaw.setRotationPoint(0.0F, 5.8F, -0.6F);
        this.lowJaw.addBox(-3.5F, 0.0F, -3.0F, 7, 2, 3, 0.0F);
        this.setRotateAngle(lowJaw, -0.045553093477052F, 0.0F, 0.0F);
        this.topTeethR = new RendererModel(this, 13, 169);
        this.topTeethR.setRotationPoint(-2.8F, 1.6F, -4.5F);
        this.topTeethR.addBox(0.0F, 0.0F, 0.0F, 3, 1, 6, 0.0F);
        this.neck = new RendererModel(this, 0, 103);
        this.neck.setRotationPoint(0.0F, -1.0F, -13.4F);
        this.neck.addBox(-4.5F, -1.5F, -8.0F, 9, 9, 8, 0.0F);
        this.setRotateAngle(neck, 0.091106186954104F, 0.0F, 0.0F);
        this.fKWSnout2 = new RendererModel(this, 19, 80);
        this.fKWSnout2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.fKWSnout2.addBox(-3.0F, 0.0F, 0.0F, 6, 2, 5, 0.0F);
        this.setRotateAngle(fKWSnout2, 0.40980330836826856F, 0.0F, 0.0F);
        this.lowJaw2 = new RendererModel(this, 0, 152);
        this.lowJaw2.setRotationPoint(0.0F, 0.0F, -2.8F);
        this.lowJaw2.addBox(-3.0F, 0.0F, -4.0F, 6, 2, 4, 0.0F);
        this.setRotateAngle(lowJaw2, -0.091106186954104F, 0.0F, 0.0F);
        this.tail02 = new RendererModel(this, 0, 65);
        this.tail02.setRotationPoint(0.0F, 0.1F, 5.3F);
        this.tail02.addBox(-2.5F, -1.0F, 0.0F, 5, 7, 5, 0.0F);
        this.setRotateAngle(tail02, -0.045553093477052F, 0.0F, 0.0F);
        this.flukeR02 = new RendererModel(this, 25, 59);
        this.flukeR02.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.flukeR02.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 3, 0.0F);
        this.setRotateAngle(flukeR02, 0.27314402793711257F, 0.0F, 0.0F);
        this.dorsalFin04 = new RendererModel(this, 26, 152);
        this.dorsalFin04.setRotationPoint(0.0F, -4.0F, 1.4F);
        this.dorsalFin04.addBox(0.0F, 0.0F, -0.6F, 1, 6, 2, 0.0F);
        this.setRotateAngle(dorsalFin04, 0.18203784098300857F, 0.0F, 0.0F);
        this.tail00 = new RendererModel(this, 0, 27);
        this.tail00.setRotationPoint(0.0F, -1.0F, -0.7F);
        this.tail00.addBox(-4.0F, -1.5F, 0.0F, 8, 9, 9, 0.0F);
        this.setRotateAngle(tail00, -0.091106186954104F, 0.0F, 0.0F);
        this.rFin01 = new RendererModel(this, 12, 178);
        this.rFin01.setRotationPoint(-0.5F, 4.9F, 0.0F);
        this.rFin01.addBox(0.0F, 0.0F, 0.0F, 1, 4, 3, 0.0F);
        this.setRotateAngle(rFin01, 0.36425021489121656F, 0.0F, 0.0F);
        this.flukeL02 = new RendererModel(this, 25, 59);
        this.flukeL02.mirror = true;
        this.flukeL02.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.flukeL02.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 3, 0.0F);
        this.setRotateAngle(flukeL02, 0.27314402793711257F, 0.0F, 0.0F);
        this.fKWSnout1 = new RendererModel(this, 22, 68);
        this.fKWSnout1.setRotationPoint(0.0F, -3.0F, -5.0F);
        this.fKWSnout1.addBox(-3.5F, 0.0F, 0.0F, 7, 3, 7, 0.0F);
        this.dorsalFin00 = new RendererModel(this, 26, 124);
        this.dorsalFin00.setRotationPoint(0.5F, -2.3F, -7.7F);
        this.dorsalFin00.addBox(-1.5F, -0.4F, 0.0F, 2, 3, 5, 0.0F);
        this.setRotateAngle(dorsalFin00, -0.7285004297824331F, 0.0F, 0.0F);
        this.topTeethL = new RendererModel(this, 0, 165);
        this.topTeethL.setRotationPoint(1.8F, 1.6F, -4.5F);
        this.topTeethL.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 6, 0.0F);
        this.lowTeeth = new RendererModel(this, 23, 178);
        this.lowTeeth.setRotationPoint(0.0F, -1.0F, -6.5F);
        this.lowTeeth.addBox(-2.5F, 0.0F, 0.0F, 5, 1, 6, 0.0F);
        this.setRotateAngle(lowTeeth, -0.091106186954104F, 0.0F, 0.0F);
        this.flukeL03 = new RendererModel(this, 34, 59);
        this.flukeL03.mirror = true;
        this.flukeL03.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.flukeL03.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 2, 0.0F);
        this.setRotateAngle(flukeL03, 0.22759093446006054F, 0.0F, 0.0F);
        this.flukeR03 = new RendererModel(this, 34, 59);
        this.flukeR03.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.flukeR03.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 2, 0.0F);
        this.setRotateAngle(flukeR03, 0.22759093446006054F, 0.0F, 0.0F);
        this.topJaw.addChild(this.snout);
        this.tail02.addChild(this.tail03);
        this.flukeMiddle.addChild(this.flukeR01);
        this.tail04.addChild(this.flukeMiddle);
        this.rFin01.addChild(this.rFin02);
        this.tail03.addChild(this.tail04);
        this.lFin00.addChild(this.lFin01);
        this.dorsalFin00.addChild(this.dorsalFin01);
        this.dorsalFin01.addChild(this.dorsalFin02);
        this.dorsalFin00.addChild(this.dorsalFin03);
        this.body.addChild(this.rFin00);
        this.body.addChild(this.lFin00);
        this.neck.addChild(this.head);
        this.flukeMiddle.addChild(this.flukeL01);
        this.lFin01.addChild(this.lFin02);
        this.tail00.addChild(this.tail01);
        this.topJaw.addChild(this.horn);
        this.head.addChild(this.topJaw);
        this.head.addChild(this.lowJaw);
        this.topJaw.addChild(this.topTeethR);
        this.body.addChild(this.neck);
        this.fKWSnout1.addChild(this.fKWSnout2);
        this.lowJaw.addChild(this.lowJaw2);
        this.tail01.addChild(this.tail02);
        this.flukeR01.addChild(this.flukeR02);
        this.dorsalFin02.addChild(this.dorsalFin04);
        this.body.addChild(this.tail00);
        this.rFin00.addChild(this.rFin01);
        this.flukeL01.addChild(this.flukeL02);
        this.topJaw.addChild(this.fKWSnout1);
        this.body.addChild(this.dorsalFin00);
        this.topJaw.addChild(this.topTeethL);
        this.lowJaw.addChild(this.lowTeeth);
        this.flukeL02.addChild(this.flukeL03);
        this.flukeR02.addChild(this.flukeR03);
    }

    @Override
    public void render(T entity, float f, float f1, float f2, float f3, float f4, float f5) {
        if(!entity.isInWater()) {
            GlStateManager.translatef(0F, 0.25F, 0F);
        }
        this.body.render(f5);
    }

    @Override
    public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
        if(!Minecraft.getInstance().isGamePaused()) {
            if(entity.isInWater()) {
                this.body.rotateAngleX = (float) Math.toRadians(ModelBetterAnimals.getHeadPitch(entity));
                this.body.rotateAngleY = (float) Math.toRadians(ModelBetterAnimals.getHeadYaw(entity));
            } else {
                this.body.rotateAngleY = -(float) Math.toRadians(ModMathHelper.interpolateRotation(entity.renderYawOffset, entity.prevRenderYawOffset, Minecraft.getInstance().getRenderPartialTicks()));
                this.body.rotateAngleX = 0.022863813201125717F;
            }
            {
                float ticks = ageInTicks / 5F + (float) entity.getMotion().length() * 0.05F;
                float factor = 1F;
                float offset = 0F;
                float amplitude = (float) Math.min(entity.getMotion().length() * 1.1F + 0.01F, 0.1F);
                if(!entity.isInWater()) {
                    amplitude = 0F;
                    offset = -0.1F;
                }
                float z01 = (float)RenderUtil.partLocation(this.tail00, this.tail01).getZ();
                float z02 = (float)RenderUtil.partLocation(this.tail00, this.tail01, this.tail02).getZ();
                float z03 = (float)RenderUtil.partLocation(this.tail00, this.tail01, this.tail02, this.tail03).getZ();
                float z04 = (float)RenderUtil.partLocation(this.tail00, this.tail01, this.tail02, this.tail03, this.tail04).getZ();
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

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(RendererModel RendererModel, float x, float y, float z) {
        RendererModel.rotateAngleX = x;
        RendererModel.rotateAngleY = y;
        RendererModel.rotateAngleZ = z;
    }
}
