package its_meow.betteranimalsplus.client.model;

import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.entity.Entity;

/**
 * Jellyfish - Batman Created using Tabula 5.1.0
 */
public class ModelJellyfish extends Model {

    public RendererModel main;
    public RendererModel top01;
    public RendererModel body01;
    public RendererModel tentacles01;
    public RendererModel nub01;
    public RendererModel nub02;
    public RendererModel nub03;
    public RendererModel nub04;
    public RendererModel nub05;
    public RendererModel nub06;
    public RendererModel nub07;
    public RendererModel nub08;
    public RendererModel nub09;
    public RendererModel nub10;
    public RendererModel nub11;
    public RendererModel nub12;
    public RendererModel body02;
    public RendererModel tentacles02;
    public RendererModel tentaclesMid;

    public ModelJellyfish() {
        this.textureWidth = 120;
        this.textureHeight = 180;
        this.nub07 = new RendererModel(this, 0, 0);
        this.nub07.setRotationPoint(0.5F, -4.5F, 2.0F);
        this.nub07.addBox(0.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(this.nub07, -0.45378560551852565F, 0.0F, 0.0F);
        this.nub04 = new RendererModel(this, 0, 0);
        this.nub04.setRotationPoint(-1.5F, -4.0F, -3.0F);
        this.nub04.addBox(0.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(this.nub04, 0.45378560551852565F, 0.0F, 0.0F);
        this.tentacles02 = new RendererModel(this, 0, 50);
        this.tentacles02.setRotationPoint(0.0F, -0.1F, 0.0F);
        this.tentacles02.addBox(-9.5F, 0.0F, -9.5F, 19, 28, 19, 0.0F);
        this.setRotateAngle(this.tentacles02, -0.006283185307179587F, 0.0F, 0.0F);
        this.nub06 = new RendererModel(this, 0, 0);
        this.nub06.setRotationPoint(-1.5F, -4.5F, 2.0F);
        this.nub06.addBox(0.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(this.nub06, -0.45378560551852565F, 0.0F, 0.0F);
        this.tentaclesMid = new RendererModel(this, 30, 100);
        this.tentaclesMid.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.tentaclesMid.addBox(-9.0F, 0.0F, -9.0F, 18, 8, 18, 0.0F);
        this.main = new RendererModel(this, 0, 132);
        this.main.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.main.addBox(-4.0F, -7.0F, -4.0F, 8, 7, 8, 0.0F);
        this.nub10 = new RendererModel(this, 0, 0);
        this.nub10.setRotationPoint(2.5F, -4.5F, 2.0F);
        this.nub10.addBox(0.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(this.nub10, -0.45378560551852565F, 0.0F, 0.0F);
        this.nub11 = new RendererModel(this, 0, 0);
        this.nub11.setRotationPoint(2.5F, -4.5F, -0.5F);
        this.nub11.addBox(0.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(this.nub11, 0.0F, 0.0F, 0.45378560551852565F);
        this.nub01 = new RendererModel(this, 0, 0);
        this.nub01.setRotationPoint(-3.5F, -4.5F, 2.0F);
        this.nub01.addBox(0.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(this.nub01, -0.45378560551852565F, 0.0F, 0.0F);
        this.nub03 = new RendererModel(this, 0, 0);
        this.nub03.setRotationPoint(-3.5F, -4.0F, -3.0F);
        this.nub03.addBox(0.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(this.nub03, 0.45378560551852565F, 0.0F, 0.0F);
        this.body01 = new RendererModel(this, 0, 0);
        this.body01.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.body01.addBox(-10.0F, -5.0F, -10.0F, 20, 5, 20, 0.0F);
        this.nub09 = new RendererModel(this, 0, 0);
        this.nub09.setRotationPoint(0.5F, -4.0F, -3.0F);
        this.nub09.addBox(0.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(this.nub09, 0.45378560551852565F, 0.0F, 0.0F);
        this.nub12 = new RendererModel(this, 0, 0);
        this.nub12.setRotationPoint(2.5F, -4.0F, -3.0F);
        this.nub12.addBox(0.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(this.nub12, 0.45378560551852565F, 0.0F, 0.0F);
        this.top01 = new RendererModel(this, 37, 131);
        this.top01.setRotationPoint(0.0F, -6.0F, 0.0F);
        this.top01.addBox(-4.0F, -5.0F, -4.0F, 8, 5, 8, 0.0F);
        this.tentacles01 = new RendererModel(this, 0, 100);
        this.tentacles01.setRotationPoint(0.0F, -0.5F, 0.0F);
        this.tentacles01.addBox(-3.5F, 0.0F, -3.5F, 7, 21, 7, 0.0F);
        this.body02 = new RendererModel(this, 0, 27);
        this.body02.setRotationPoint(1.0F, -9.0F, 0.0F);
        this.body02.addBox(-10.0F, 1.0F, -9.0F, 18, 3, 18, 0.0F);
        this.nub02 = new RendererModel(this, 0, 0);
        this.nub02.setRotationPoint(-3.5F, -4.5F, -0.5F);
        this.nub02.addBox(0.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(this.nub02, 0.0F, 0.0F, -0.45378560551852565F);
        this.nub08 = new RendererModel(this, 0, 0);
        this.nub08.setRotationPoint(0.5F, -4.5F, -0.5F);
        this.nub08.addBox(0.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(this.nub08, 0.0F, 0.0F, 0.22689280275926282F);
        this.nub05 = new RendererModel(this, 0, 0);
        this.nub05.setRotationPoint(-1.5F, -4.5F, -0.5F);
        this.nub05.addBox(0.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(this.nub05, 0.0F, 0.0F, -0.22689280275926282F);
        this.top01.addChild(this.nub07);
        this.top01.addChild(this.nub04);
        this.body01.addChild(this.tentacles02);
        this.top01.addChild(this.nub06);
        this.tentacles01.addChild(this.tentaclesMid);
        this.top01.addChild(this.nub10);
        this.top01.addChild(this.nub11);
        this.top01.addChild(this.nub01);
        this.top01.addChild(this.nub03);
        this.main.addChild(this.body01);
        this.top01.addChild(this.nub09);
        this.top01.addChild(this.nub12);
        this.main.addChild(this.top01);
        this.main.addChild(this.tentacles01);
        this.body01.addChild(this.body02);
        this.top01.addChild(this.nub02);
        this.top01.addChild(this.nub08);
        this.top01.addChild(this.nub05);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.main.render(f5);
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
