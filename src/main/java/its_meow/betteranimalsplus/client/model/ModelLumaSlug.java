package its_meow.betteranimalsplus.client.model;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

/**
 * lumaslug - cybercat5555 Created using Tabula 5.1.0
 */
public class ModelLumaSlug<T extends LivingEntity> extends EntityModel<T> {
    public ModelRenderer body;
    public ModelRenderer head;
    public ModelRenderer tail01;
    public ModelRenderer antennaL;
    public ModelRenderer antennaR;
    public ModelRenderer tentacleL;
    public ModelRenderer tentacleR;
    public ModelRenderer tail02;
    public ModelRenderer tail03;

    public ModelLumaSlug() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.antennaL = new ModelRenderer(this, 18, 0);
        this.antennaL.setRotationPoint(0.9F, -0.9F, -2.5F);
        this.antennaL.addBox(-0.5F, 0.0F, -5.0F, 1, 0, 5, 0.0F);
        this.setRotateAngle(antennaL, -0.7853981633974483F, -0.41887902047863906F, 0.0F);
        this.tail03 = new ModelRenderer(this, 23, 25);
        this.tail03.setRotationPoint(0.0F, 0.0F, 5.0F);
        this.tail03.addBox(-1.5F, -1.0F, 0.0F, 3, 2, 5, 0.0F);
        this.tentacleR = new ModelRenderer(this, 19, 0);
        this.tentacleR.setRotationPoint(-0.5F, -0.5F, -2.5F);
        this.tentacleR.addBox(-0.5F, 0.0F, -3.5F, 1, 0, 4, 0.0F);
        this.setRotateAngle(tentacleR, 0.3141592653589793F, 0.5235987755982988F, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 0.4F, -3.4F);
        this.head.addBox(-2.5F, -1.0F, -3.0F, 5, 2, 3, 0.0F);
        this.tail02 = new ModelRenderer(this, 0, 24);
        this.tail02.setRotationPoint(0.0F, 0.4F, 5.0F);
        this.tail02.addBox(-2.0F, -1.0F, 0.0F, 4, 2, 5, 0.0F);
        this.antennaR = new ModelRenderer(this, 18, 0);
        this.antennaR.mirror = true;
        this.antennaR.setRotationPoint(-0.9F, -0.9F, -2.5F);
        this.antennaR.addBox(-0.5F, 0.0F, -5.0F, 1, 0, 5, 0.0F);
        this.setRotateAngle(antennaR, -0.7853981633974483F, 0.41887902047863906F, 0.0F);
        this.tail01 = new ModelRenderer(this, 27, 16);
        this.tail01.setRotationPoint(0.0F, 0.0F, 5.5F);
        this.tail01.addBox(-2.0F, -1.5F, 0.0F, 4, 3, 5, 0.0F);
        this.tentacleL = new ModelRenderer(this, 19, 0);
        this.tentacleL.setRotationPoint(0.5F, -0.5F, -2.5F);
        this.tentacleL.addBox(-0.5F, 0.0F, -3.5F, 1, 0, 4, 0.0F);
        this.setRotateAngle(tentacleL, 0.3141592653589793F, -0.5235987755982988F, 0.0F);
        this.body = new ModelRenderer(this, 0, 6);
        this.body.setRotationPoint(0.0F, 22.6F, -1.5F);
        this.body.addBox(-3.0F, -1.5F, -3.5F, 6, 3, 9, 0.0F);
        this.head.addChild(this.antennaL);
        this.tail02.addChild(this.tail03);
        this.head.addChild(this.tentacleR);
        this.body.addChild(this.head);
        this.tail01.addChild(this.tail02);
        this.head.addChild(this.antennaR);
        this.body.addChild(this.tail01);
        this.head.addChild(this.tentacleL);
    }

    @Override
    public void render(T entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.body.render(f5);
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
