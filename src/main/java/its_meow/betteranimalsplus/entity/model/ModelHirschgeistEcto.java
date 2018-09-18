package its_meow.betteranimalsplus.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * 0hirschgeist_ecto - cybercat5555
 * Created using Tabula 5.1.0
 */
public class ModelHirschgeistEcto extends ModelBase {
    public ModelRenderer ectoplasm01;
    public ModelRenderer ectoplasm01b;
    public ModelRenderer ectoplasm02;
    public ModelRenderer neckEctoplasm01;
    public ModelRenderer lArm01Ecto;
    public ModelRenderer rArm01Ecto;
    public ModelRenderer ectoplasm03;
    public ModelRenderer ectoplasm02b;
    public ModelRenderer lLeg01Ecto;
    public ModelRenderer rLeg01Ecto;
    public ModelRenderer ectoplasm03b;
    public ModelRenderer ectoplasmTail;
    public ModelRenderer lLeg02Ecto;
    public ModelRenderer lLeg03Ecto;
    public ModelRenderer lHindHoodEcto;
    public ModelRenderer rLeg02Ecto;
    public ModelRenderer rLeg03Ecto;
    public ModelRenderer rHindHoodEcto;
    public ModelRenderer neckEctoplasm02;
    public ModelRenderer head01Ecto;
    public ModelRenderer upperJawEcto;
    public ModelRenderer lowerJawEcto;
    public ModelRenderer lArm02Ecto;
    public ModelRenderer lArm03Ecto;
    public ModelRenderer lForeHoofEcto;
    public ModelRenderer rArm02Ecto;
    public ModelRenderer rArm03Ecto;
    public ModelRenderer rForeHoofEcto;

    public ModelHirschgeistEcto() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.ectoplasmTail = new ModelRenderer(this, 92, 72);
        this.ectoplasmTail.setRotationPoint(0.0F, -4.0F, 7.2F);
        this.ectoplasmTail.addBox(-1.5F, -1.0F, 0.0F, 3, 2, 5, 0.0F);
        this.setRotateAngle(ectoplasmTail, -0.36425021489121656F, 0.0F, 0.0F);
        this.lLeg01Ecto = new ModelRenderer(this, 27, 84);
        this.lLeg01Ecto.setRotationPoint(2.0F, -0.5F, 8.8F);
        this.lLeg01Ecto.addBox(-1.0F, -2.5F, -9.0F, 3, 5, 11, 0.0F);
        this.setRotateAngle(lLeg01Ecto, 1.1838568316277536F, 0.0F, -0.136659280431156F);
        this.neckEctoplasm02 = new ModelRenderer(this, 1, 90);
        this.neckEctoplasm02.setRotationPoint(0.0F, 0.1F, -5.6F);
        this.neckEctoplasm02.addBox(-2.0F, -3.1F, -9.3F, 4, 6, 9, 0.0F);
        this.setRotateAngle(neckEctoplasm02, -0.40980330836826856F, 0.0F, 0.0F);
        this.ectoplasm03b = new ModelRenderer(this, 92, 64);
        this.ectoplasm03b.setRotationPoint(0.0F, -3.4F, 3.8F);
        this.ectoplasm03b.addBox(-2.0F, -1.9F, -0.2F, 4, 2, 4, 0.0F);
        this.head01Ecto = new ModelRenderer(this, 92, 81);
        this.head01Ecto.setRotationPoint(0.0F, 0.3F, -5.7F);
        this.head01Ecto.addBox(-3.0F, -2.5F, -6.7F, 6, 7, 5, 0.0F);
        this.setRotateAngle(head01Ecto, -0.5009094953223726F, 0.0F, 0.0F);
        this.ectoplasm01 = new ModelRenderer(this, 66, 0);
        this.ectoplasm01.setRotationPoint(0.0F, 2.3F, -7.5F);
        this.ectoplasm01.addBox(-4.5F, -2.6F, -5.7F, 9, 11, 15, 0.0F);
        this.ectoplasm02 = new ModelRenderer(this, 69, 27);
        this.ectoplasm02.setRotationPoint(0.0F, 0.1F, 7.7F);
        this.ectoplasm02.addBox(-4.0F, -2.5F, -0.2F, 8, 8, 10, 0.0F);
        this.setRotateAngle(ectoplasm02, -0.091106186954104F, 0.0F, 0.0F);
        this.lLeg02Ecto = new ModelRenderer(this, 27, 102);
        this.lLeg02Ecto.setRotationPoint(0.5F, -1.2F, -7.2F);
        this.lLeg02Ecto.addBox(-1.5F, -2.0F, -7.9F, 3, 4, 8, 0.0F);
        this.setRotateAngle(lLeg02Ecto, 0.9105382707654417F, 0.0F, 0.136659280431156F);
        this.rArm03Ecto = new ModelRenderer(this, 66, 106);
        this.rArm03Ecto.mirror = true;
        this.rArm03Ecto.setRotationPoint(-0.4F, 11.2F, 0.0F);
        this.rArm03Ecto.addBox(-0.9F, -0.1F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(rArm03Ecto, -0.045553093477052F, 0.18203784098300857F, 0.0F);
        this.rArm02Ecto = new ModelRenderer(this, 66, 99);
        this.rArm02Ecto.mirror = true;
        this.rArm02Ecto.setRotationPoint(-0.4F, 8.4F, 0.0F);
        this.rArm02Ecto.addBox(-1.0F, -0.1F, -1.5F, 2, 3, 3, 0.0F);
        this.lArm02Ecto = new ModelRenderer(this, 66, 99);
        this.lArm02Ecto.setRotationPoint(0.4F, 8.4F, 0.0F);
        this.lArm02Ecto.addBox(-1.0F, -0.1F, -1.5F, 2, 3, 3, 0.0F);
        this.ectoplasm01b = new ModelRenderer(this, 29, 67);
        this.ectoplasm01b.setRotationPoint(0.0F, -2.1F, 2.0F);
        this.ectoplasm01b.addBox(-3.0F, -2.5F, -5.6F, 6, 3, 12, 0.0F);
        this.lHindHoodEcto = new ModelRenderer(this, 113, 28);
        this.lHindHoodEcto.setRotationPoint(0.0F, 0.1F, -8.5F);
        this.lHindHoodEcto.addBox(-1.5F, -3.9F, -1.3F, 3, 5, 2, 0.0F);
        this.setRotateAngle(lHindHoodEcto, 0.045553093477052F, 0.0F, 0.0F);
        this.rLeg02Ecto = new ModelRenderer(this, 27, 102);
        this.rLeg02Ecto.mirror = true;
        this.rLeg02Ecto.setRotationPoint(-0.5F, -1.2F, -7.2F);
        this.rLeg02Ecto.addBox(-1.5F, -2.0F, -7.9F, 3, 4, 8, 0.0F);
        this.setRotateAngle(rLeg02Ecto, 0.9105382707654417F, 0.0F, -0.136659280431156F);
        this.rArm01Ecto = new ModelRenderer(this, 66, 84);
        this.rArm01Ecto.mirror = true;
        this.rArm01Ecto.setRotationPoint(-3.0F, 1.0F, 0.8F);
        this.rArm01Ecto.addBox(-2.0F, -0.6F, -2.5F, 3, 9, 5, 0.0F);
        this.setRotateAngle(rArm01Ecto, 0.0F, 0.0F, 0.045553093477052F);
        this.rForeHoofEcto = new ModelRenderer(this, 1, 107);
        this.rForeHoofEcto.mirror = true;
        this.rForeHoofEcto.setRotationPoint(0.2F, 9.3F, -0.5F);
        this.rForeHoofEcto.addBox(-1.5F, -1.3F, -3.2F, 3, 2, 5, 0.0F);
        this.setRotateAngle(rForeHoofEcto, 0.045553093477052F, 0.0F, 0.0F);
        this.ectoplasm02b = new ModelRenderer(this, 92, 50);
        this.ectoplasm02b.setRotationPoint(0.0F, -2.2F, 0.0F);
        this.ectoplasm02b.addBox(-2.5F, -2.0F, 0.0F, 5, 2, 10, 0.0F);
        this.lForeHoofEcto = new ModelRenderer(this, 1, 107);
        this.lForeHoofEcto.setRotationPoint(-0.2F, 9.3F, -0.5F);
        this.lForeHoofEcto.addBox(-1.5F, -1.3F, -3.2F, 3, 2, 5, 0.0F);
        this.setRotateAngle(lForeHoofEcto, 0.045553093477052F, 0.0F, 0.0F);
        this.neckEctoplasm01 = new ModelRenderer(this, 1, 70);
        this.neckEctoplasm01.setRotationPoint(0.0F, 0.1F, -2.1F);
        this.neckEctoplasm01.addBox(-2.5F, -4.1F, -7.6F, 5, 7, 8, 0.0F);
        this.setRotateAngle(neckEctoplasm01, -0.5009094953223726F, 0.0F, 0.0F);
        this.upperJawEcto = new ModelRenderer(this, 88, 99);
        this.upperJawEcto.setRotationPoint(0.0F, 3.2F, -2.2F);
        this.upperJawEcto.addBox(-2.5F, -0.1F, -3.6F, 5, 4, 3, 0.0F);
        this.setRotateAngle(upperJawEcto, 0.136659280431156F, 0.0F, 0.0F);
        this.lLeg03Ecto = new ModelRenderer(this, 68, 71);
        this.lLeg03Ecto.setRotationPoint(0.0F, 0.0F, -6.6F);
        this.lLeg03Ecto.addBox(-1.0F, -1.0F, -9.0F, 2, 2, 9, 0.0F);
        this.setRotateAngle(lLeg03Ecto, -0.4553564018453205F, 0.091106186954104F, 0.0F);
        this.rLeg03Ecto = new ModelRenderer(this, 68, 71);
        this.rLeg03Ecto.mirror = true;
        this.rLeg03Ecto.setRotationPoint(0.0F, 0.0F, -6.6F);
        this.rLeg03Ecto.addBox(-1.0F, -1.0F, -9.0F, 2, 2, 9, 0.0F);
        this.setRotateAngle(rLeg03Ecto, -0.4553564018453205F, -0.091106186954104F, 0.0F);
        this.lArm01Ecto = new ModelRenderer(this, 66, 84);
        this.lArm01Ecto.setRotationPoint(3.0F, 1.0F, 0.8F);
        this.lArm01Ecto.addBox(-1.0F, -0.6F, -2.5F, 3, 9, 5, 0.0F);
        this.setRotateAngle(lArm01Ecto, 0.0F, 0.0F, -0.045553093477052F);
        this.rHindHoodEcto = new ModelRenderer(this, 113, 28);
        this.rHindHoodEcto.mirror = true;
        this.rHindHoodEcto.setRotationPoint(0.0F, 0.1F, -8.5F);
        this.rHindHoodEcto.addBox(-1.5F, -3.9F, -1.3F, 3, 5, 2, 0.0F);
        this.setRotateAngle(rHindHoodEcto, 0.045553093477052F, 0.0F, 0.0F);
        this.ectoplasm03 = new ModelRenderer(this, 69, 47);
        this.ectoplasm03.setRotationPoint(0.0F, -0.3F, 4.6F);
        this.ectoplasm03.addBox(-3.5F, -3.7F, 4.1F, 7, 6, 4, 0.0F);
        this.setRotateAngle(ectoplasm03, -0.31869712141416456F, 0.0F, 0.0F);
        this.lowerJawEcto = new ModelRenderer(this, 88, 108);
        this.lowerJawEcto.setRotationPoint(0.0F, 3.0F, -1.3F);
        this.lowerJawEcto.addBox(-2.0F, 0.2F, -3.6F, 4, 4, 3, 0.0F);
        this.setRotateAngle(lowerJawEcto, -0.045553093477052F, 0.0F, 0.0F);
        this.lArm03Ecto = new ModelRenderer(this, 66, 106);
        this.lArm03Ecto.setRotationPoint(0.4F, 11.2F, 0.0F);
        this.lArm03Ecto.addBox(-1.1F, -0.1F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(lArm03Ecto, -0.045553093477052F, -0.18203784098300857F, 0.0F);
        this.rLeg01Ecto = new ModelRenderer(this, 27, 84);
        this.rLeg01Ecto.mirror = true;
        this.rLeg01Ecto.setRotationPoint(-2.0F, -0.5F, 8.8F);
        this.rLeg01Ecto.addBox(-2.0F, -2.5F, -9.0F, 3, 5, 11, 0.0F);
        this.setRotateAngle(rLeg01Ecto, 1.1838568316277536F, 0.0F, 0.136659280431156F);
        this.ectoplasm03.addChild(this.ectoplasmTail);
        this.ectoplasm02.addChild(this.lLeg01Ecto);
        this.neckEctoplasm01.addChild(this.neckEctoplasm02);
        this.ectoplasm03.addChild(this.ectoplasm03b);
        this.neckEctoplasm02.addChild(this.head01Ecto);
        this.ectoplasm01.addChild(this.ectoplasm02);
        this.lLeg01Ecto.addChild(this.lLeg02Ecto);
        this.rArm01Ecto.addChild(this.rArm03Ecto);
        this.rArm01Ecto.addChild(this.rArm02Ecto);
        this.lArm01Ecto.addChild(this.lArm02Ecto);
        this.ectoplasm01.addChild(this.ectoplasm01b);
        this.lLeg03Ecto.addChild(this.lHindHoodEcto);
        this.rLeg01Ecto.addChild(this.rLeg02Ecto);
        this.ectoplasm01.addChild(this.rArm01Ecto);
        this.rArm03Ecto.addChild(this.rForeHoofEcto);
        this.ectoplasm02.addChild(this.ectoplasm02b);
        this.lArm03Ecto.addChild(this.lForeHoofEcto);
        this.ectoplasm01.addChild(this.neckEctoplasm01);
        this.head01Ecto.addChild(this.upperJawEcto);
        this.lLeg02Ecto.addChild(this.lLeg03Ecto);
        this.rLeg02Ecto.addChild(this.rLeg03Ecto);
        this.ectoplasm01.addChild(this.lArm01Ecto);
        this.rLeg03Ecto.addChild(this.rHindHoodEcto);
        this.ectoplasm02.addChild(this.ectoplasm03);
        this.head01Ecto.addChild(this.lowerJawEcto);
        this.lArm01Ecto.addChild(this.lArm03Ecto);
        this.ectoplasm02.addChild(this.rLeg01Ecto);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.ectoplasm01.render(f5);
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
