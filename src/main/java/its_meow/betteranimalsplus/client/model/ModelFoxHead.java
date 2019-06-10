package its_meow.betteranimalsplus.client.model;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.Entity;

/**
 * foxhead - cybercat5555 Created using Tabula 5.1.0
 */
public class ModelFoxHead extends EntityModel<Entity> {

    public RendererModel head;
    public RendererModel snoot;
    public RendererModel lowerJawA;
    public RendererModel upperJaw;
    public RendererModel lEar01;
    public RendererModel rEar01;
    public RendererModel lCheekFur01;
    public RendererModel rCheekFur01;
    public RendererModel lowerJawB;
    public RendererModel lEar02;
    public RendererModel lEar03;
    public RendererModel lEar04;
    public RendererModel rEar02;
    public RendererModel rEar03;
    public RendererModel rEar04;
    public RendererModel lCheekFur02;
    public RendererModel rCheekFur02;

    public ModelFoxHead() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.head = new RendererModel(this, 17, 34);
        this.head.setRotationPoint(0.0F, 23.9F, 0.0F);
        this.head.addBox(-2.5F, -3.0F, -4.0F, 5, 4, 4, 0.0F);
        this.rCheekFur02 = new RendererModel(this, 0, 5);
        this.rCheekFur02.mirror = true;
        this.rCheekFur02.setRotationPoint(0.2F, 0.7F, -0.4F);
        this.rCheekFur02.addBox(-2.1F, -1.4F, -1.0F, 3, 3, 1, 0.0F);
        this.setRotateAngle(this.rCheekFur02, 0.0F, 0.045553093477052F, -0.22759093446006054F);
        this.upperJaw = new RendererModel(this, 34, 43);
        this.upperJaw.setRotationPoint(0.0F, 0.0F, -4.1F);
        this.upperJaw.addBox(-1.5F, -1.0F, -2.6F, 3, 1, 3, 0.0F);
        this.lowerJawA = new RendererModel(this, 23, 48);
        this.lowerJawA.setRotationPoint(0.0F, 0.6F, -3.9F);
        this.lowerJawA.addBox(-1.2F, -0.6F, -2.6F, 2, 1, 3, 0.0F);
        this.setRotateAngle(this.lowerJawA, -0.091106186954104F, 0.0F, 0.0F);
        this.rCheekFur01 = new RendererModel(this, 0, 0);
        this.rCheekFur01.mirror = true;
        this.rCheekFur01.setRotationPoint(-1.9F, -1.0F, -0.6F);
        this.rCheekFur01.addBox(-1.4F, -1.0F, -1.0F, 2, 3, 1, 0.0F);
        this.setRotateAngle(this.rCheekFur01, 0.0F, 0.40980330836826856F, -0.27314402793711257F);
        this.snoot = new RendererModel(this, 23, 43);
        this.snoot.setRotationPoint(0.0F, -1.0F, -4.2F);
        this.snoot.addBox(-1.0F, -1.0F, -2.6F, 2, 1, 3, 0.0F);
        this.setRotateAngle(this.snoot, 0.22759093446006054F, 0.0F, 0.0F);
        this.lEar02 = new RendererModel(this, 21, 5);
        this.lEar02.setRotationPoint(0.5F, -1.7F, 0.0F);
        this.lEar02.addBox(-0.5F, -1.0F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(this.lEar02, 0.0F, 0.0F, -0.40980330836826856F);
        this.lCheekFur02 = new RendererModel(this, 0, 5);
        this.lCheekFur02.setRotationPoint(-0.2F, 0.7F, -0.4F);
        this.lCheekFur02.addBox(-0.9F, -1.4F, -1.0F, 3, 3, 1, 0.0F);
        this.setRotateAngle(this.lCheekFur02, 0.0F, -0.045553093477052F, 0.22759093446006054F);
        this.lCheekFur01 = new RendererModel(this, 0, 0);
        this.lCheekFur01.setRotationPoint(1.9F, -1.0F, -0.6F);
        this.lCheekFur01.addBox(-0.6F, -1.0F, -1.0F, 2, 3, 1, 0.0F);
        this.setRotateAngle(this.lCheekFur01, 0.0F, -0.40980330836826856F, 0.27314402793711257F);
        this.lEar03 = new RendererModel(this, 29, 0);
        this.lEar03.setRotationPoint(0.0F, 0.5F, 0.8F);
        this.lEar03.addBox(-0.5F, -3.7F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(this.lEar03, 0.22759093446006054F, 0.0F, 0.0F);
        this.rEar02 = new RendererModel(this, 21, 5);
        this.rEar02.mirror = true;
        this.rEar02.setRotationPoint(-0.5F, -1.7F, 0.0F);
        this.rEar02.addBox(-0.5F, -1.0F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(this.rEar02, 0.0F, 0.0F, 0.40980330836826856F);
        this.rEar01 = new RendererModel(this, 21, 0);
        this.rEar01.mirror = true;
        this.rEar01.setRotationPoint(-1.6F, -2.4F, -1.5F);
        this.rEar01.addBox(-1.0F, -1.9F, -0.5F, 2, 2, 1, 0.0F);
        this.setRotateAngle(this.rEar01, 0.0F, 0.40980330836826856F, -0.27314402793711257F);
        this.lowerJawB = new RendererModel(this, 34, 48);
        this.lowerJawB.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lowerJawB.addBox(0.2F, -0.6F, -2.6F, 1, 1, 3, 0.0F);
        this.lEar01 = new RendererModel(this, 21, 0);
        this.lEar01.setRotationPoint(1.6F, -2.4F, -1.5F);
        this.lEar01.addBox(-1.0F, -1.9F, -0.5F, 2, 2, 1, 0.0F);
        this.setRotateAngle(this.lEar01, 0.0F, -0.40980330836826856F, 0.27314402793711257F);
        this.rEar03 = new RendererModel(this, 29, 0);
        this.rEar03.mirror = true;
        this.rEar03.setRotationPoint(0.0F, 0.5F, 0.8F);
        this.rEar03.addBox(-0.5F, -3.7F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(this.rEar03, 0.22759093446006054F, 0.0F, 0.0F);
        this.lEar04 = new RendererModel(this, 21, 5);
        this.lEar04.mirror = true;
        this.lEar04.setRotationPoint(-0.5F, -1.7F, 0.0F);
        this.lEar04.addBox(-0.5F, -1.0F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(this.lEar04, 0.0F, 0.0F, 0.40980330836826856F);
        this.rEar04 = new RendererModel(this, 21, 5);
        this.rEar04.setRotationPoint(0.5F, -1.7F, 0.0F);
        this.rEar04.addBox(-0.5F, -1.0F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(this.rEar04, 0.0F, 0.0F, -0.40980330836826856F);
        this.rCheekFur01.addChild(this.rCheekFur02);
        this.head.addChild(this.upperJaw);
        this.head.addChild(this.lowerJawA);
        this.head.addChild(this.rCheekFur01);
        this.head.addChild(this.snoot);
        this.lEar01.addChild(this.lEar02);
        this.lCheekFur01.addChild(this.lCheekFur02);
        this.head.addChild(this.lCheekFur01);
        this.lEar01.addChild(this.lEar03);
        this.rEar01.addChild(this.rEar02);
        this.head.addChild(this.rEar01);
        this.lowerJawA.addChild(this.lowerJawB);
        this.head.addChild(this.lEar01);
        this.rEar01.addChild(this.rEar03);
        this.lEar01.addChild(this.lEar04);
        this.rEar01.addChild(this.rEar04);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.head.rotateAngleY = (float) Math.toRadians(f);
        // this.head.rotateAngleX = (float) Math.toRadians(f1);
        this.head.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(RendererModel modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
