package dev.itsmeow.betteranimalsplus.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import dev.itsmeow.imdlib.client.util.RenderUtil;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.vector.Vector3f;

/**
 * trilliummulti2 - cybercat5555 Created using Tabula 5.1.0
 */
public class ModelTrilliumMulti2<T extends Entity> extends EntityModel<T> {

    public ModelRenderer stem01;
    public ModelRenderer stem02;
    public ModelRenderer stem03;
    public ModelRenderer stem04;
    public ModelRenderer stem05;
    public ModelRenderer largeLeaf01a;
    public ModelRenderer largeLeaf02a;
    public ModelRenderer largeLeaf03a;
    public ModelRenderer largeLeaf01b;
    public ModelRenderer largeLeaf02b;
    public ModelRenderer largeLeaf03b;
    public ModelRenderer smallLeaf01a;
    public ModelRenderer smallLeaf02a;
    public ModelRenderer smallLeaf03a;
    public ModelRenderer petal01a;
    public ModelRenderer petal02a;
    public ModelRenderer petal03a;
    public ModelRenderer smallLeaf01b;
    public ModelRenderer smallLeaf02b;
    public ModelRenderer smallLeaf03b;
    public ModelRenderer petal01b;
    public ModelRenderer petal02b;
    public ModelRenderer petal03b;
    public ModelRenderer stem02_1;
    public ModelRenderer stem03_1;
    public ModelRenderer stem04_1;
    public ModelRenderer stem05_1;
    public ModelRenderer largeLeaf01a_1;
    public ModelRenderer largeLeaf02a_1;
    public ModelRenderer largeLeaf03a_1;
    public ModelRenderer largeLeaf01b_1;
    public ModelRenderer largeLeaf02b_1;
    public ModelRenderer largeLeaf03b_1;
    public ModelRenderer smallLeaf01a_1;
    public ModelRenderer smallLeaf02a_1;
    public ModelRenderer smallLeaf03a_1;
    public ModelRenderer petal01a_1;
    public ModelRenderer petal02a_1;
    public ModelRenderer petal03a_1;
    public ModelRenderer smallLeaf01b_1;
    public ModelRenderer smallLeaf02b_1;
    public ModelRenderer smallLeaf03b_1;
    public ModelRenderer petal01b_1;
    public ModelRenderer petal02b_1;
    public ModelRenderer petal03b_1;
    public ModelRenderer stem02_2;
    public ModelRenderer stem03_2;
    public ModelRenderer stem04_2;
    public ModelRenderer stem05_2;
    public ModelRenderer largeLeaf01a_2;
    public ModelRenderer largeLeaf02a_2;
    public ModelRenderer largeLeaf03a_2;
    public ModelRenderer largeLeaf01b_2;
    public ModelRenderer largeLeaf02b_2;
    public ModelRenderer largeLeaf03b_2;
    public ModelRenderer smallLeaf01a_2;
    public ModelRenderer smallLeaf02a_2;
    public ModelRenderer smallLeaf03a_2;
    public ModelRenderer petal01a_2;
    public ModelRenderer petal02a_2;
    public ModelRenderer petal03a_2;
    public ModelRenderer smallLeaf01b_2;
    public ModelRenderer smallLeaf02b_2;
    public ModelRenderer smallLeaf03b_2;
    public ModelRenderer petal01b_2;
    public ModelRenderer petal02b_2;
    public ModelRenderer petal03b_2;
    
    private float rotation = 0;

    public ModelTrilliumMulti2() {
        this.texWidth = 64;
        this.texHeight = 32;
        this.stem03_1 = new ModelRenderer(this, 0, 11);
        this.stem03_1.setPos(5.0F, 23.100000000000026F, 2.9000000000000012F);
        this.stem03_1.addBox(-0.5F, -6.1F, -0.5F, 1, 6, 1, 0.0F);
        this.setRotateAngle(this.stem03_1, 0.0F, 0.0F, 0.091106186954104F);
        this.petal01b_1 = new ModelRenderer(this, 19, 24);
        this.petal01b_1.setPos(0.0F, -5.6F, -0.7F);
        this.petal01b_1.addBox(-1.5F, -3.0F, 0.0F, 3, 3, 0, 0.0F);
        this.setRotateAngle(this.petal01b_1, -0.22759093446006054F, 0.0F, 0.0F);
        this.smallLeaf01a = new ModelRenderer(this, 31, 0);
        this.smallLeaf01a.setPos(0.5F, -0.1F, 0.0F);
        this.smallLeaf01a.addBox(0.0F, 0.0F, -4.5F, 9, 0, 9, 0.0F);
        this.setRotateAngle(this.smallLeaf01a, 0.0F, 3.141592653589793F, 0.091106186954104F);
        this.largeLeaf02b_2 = new ModelRenderer(this, 11, 10);
        this.largeLeaf02b_2.setPos(10.0F, 0.0F, 0.0F);
        this.largeLeaf02b_2.addBox(0.0F, 0.0F, -3.0F, 8, 0, 6, 0.0F);
        this.setRotateAngle(this.largeLeaf02b_2, 0.0F, 0.0F, 0.136659280431156F);
        this.smallLeaf02a = new ModelRenderer(this, 31, 0);
        this.smallLeaf02a.setPos(0.5F, -0.3F, 0.0F);
        this.smallLeaf02a.addBox(0.0F, 0.0F, -4.5F, 9, 0, 9, 0.0F);
        this.setRotateAngle(this.smallLeaf02a, -0.091106186954104F, 1.0471975511965976F, -0.091106186954104F);
        this.stem04 = new ModelRenderer(this, 0, 19);
        this.stem04.setPos(-2.2F, 13.4F, -4.9F);
        this.stem04.addBox(-1.0F, -1.7F, -1.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(this.stem04, 0.0F, 0.4000294645571003F, 0.0F);
        this.largeLeaf01a_1 = new ModelRenderer(this, 7, 0);
        this.largeLeaf01a_1.setPos(0.0F, -1.5F, 0.0F);
        this.largeLeaf01a_1.addBox(0.0F, 0.0F, -5.0F, 10, 0, 10, 0.0F);
        this.setRotateAngle(this.largeLeaf01a_1, 0.0F, 0.0F, 0.27314402793711257F);
        this.smallLeaf02b_2 = new ModelRenderer(this, 35, 9);
        this.smallLeaf02b_2.setPos(9.0F, 0.0F, 0.0F);
        this.smallLeaf02b_2.addBox(0.0F, 0.0F, -2.5F, 7, 0, 5, 0.0F);
        this.setRotateAngle(this.smallLeaf02b_2, 0.0F, 0.0F, 0.091106186954104F);
        this.petal01b_2 = new ModelRenderer(this, 19, 24);
        this.petal01b_2.setPos(0.0F, -5.6F, -0.7F);
        this.petal01b_2.addBox(-1.5F, -3.0F, 0.0F, 3, 3, 0, 0.0F);
        this.setRotateAngle(this.petal01b_2, -0.22759093446006054F, 0.0F, 0.0F);
        this.petal01b = new ModelRenderer(this, 19, 24);
        this.petal01b.setPos(0.0F, -5.6F, -0.7F);
        this.petal01b.addBox(-1.5F, -3.0F, 0.0F, 3, 3, 0, 0.0F);
        this.setRotateAngle(this.petal01b, -0.22759093446006054F, 0.0F, 0.0F);
        this.largeLeaf01a = new ModelRenderer(this, 7, 0);
        this.largeLeaf01a.setPos(0.0F, -1.5F, 0.0F);
        this.largeLeaf01a.addBox(0.0F, 0.0F, -5.0F, 10, 0, 10, 0.0F);
        this.setRotateAngle(this.largeLeaf01a, 0.0F, 0.0F, 0.27314402793711257F);
        this.petal03a_2 = new ModelRenderer(this, 18, 19);
        this.petal03a_2.setPos(0.0F, -0.3F, 0.0F);
        this.petal03a_2.addBox(-2.5F, -5.6F, -0.7F, 5, 5, 0, 0.0F);
        this.setRotateAngle(this.petal03a_2, 0.6373942428283291F, -2.0943951023931953F, 0.0F);
        this.stem04_1 = new ModelRenderer(this, 0, 19);
        this.stem04_1.setPos(5.499999999999999F, 17.099999999999998F, 2.9000000000000012F);
        this.stem04_1.addBox(-1.0F, -1.7F, -1.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(this.stem04_1, 0.0F, 0.0F, 0.091106186954104F);
        this.smallLeaf02a_1 = new ModelRenderer(this, 31, 0);
        this.smallLeaf02a_1.setPos(0.5F, -0.3F, 0.0F);
        this.smallLeaf02a_1.addBox(0.0F, 0.0F, -4.5F, 9, 0, 9, 0.0F);
        this.setRotateAngle(this.smallLeaf02a_1, -0.091106186954104F, 1.0471975511965976F, -0.091106186954104F);
        this.petal02a_1 = new ModelRenderer(this, 18, 19);
        this.petal02a_1.setPos(0.0F, -0.3F, 0.0F);
        this.petal02a_1.addBox(-2.5F, -5.6F, -0.7F, 5, 5, 0, 0.0F);
        this.setRotateAngle(this.petal02a_1, 0.6373942428283291F, 2.0943951023931953F, 0.0F);
        this.largeLeaf03a_1 = new ModelRenderer(this, 7, 0);
        this.largeLeaf03a_1.setPos(0.0F, -1.5F, 0.0F);
        this.largeLeaf03a_1.addBox(0.0F, 0.0F, -5.0F, 10, 0, 10, 0.0F);
        this.setRotateAngle(this.largeLeaf03a_1, 0.36425021489121656F, -2.0943951023931953F, -0.4553564018453205F);
        this.stem04_2 = new ModelRenderer(this, 0, 19);
        this.stem04_2.setPos(-6.3F, 18.6F, 4.200000000000002F);
        this.stem04_2.addBox(-1.0F, -1.7F, -1.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(this.stem04_2, -0.1340412865531645F, 0.0F, -0.091106186954104F);
        this.petal03b_2 = new ModelRenderer(this, 19, 24);
        this.petal03b_2.setPos(0.0F, -5.6F, -0.7F);
        this.petal03b_2.addBox(-1.5F, -3.0F, 0.0F, 3, 3, 0, 0.0F);
        this.setRotateAngle(this.petal03b_2, -0.22759093446006054F, 0.0F, 0.0F);
        this.stem05_1 = new ModelRenderer(this, 0, 25);
        this.stem05_1.setPos(5.599999999999999F, 15.699999999999987F, 2.9000000000000012F);
        this.stem05_1.addBox(-1.0F, -1.0F, -1.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(this.stem05_1, 0.0F, 0.0F, 0.091106186954104F);
        this.largeLeaf01a_2 = new ModelRenderer(this, 7, 0);
        this.largeLeaf01a_2.setPos(0.0F, -1.5F, 0.0F);
        this.largeLeaf01a_2.addBox(0.0F, 0.0F, -5.0F, 10, 0, 10, 0.0F);
        this.setRotateAngle(this.largeLeaf01a_2, 0.0F, 0.0F, 0.27314402793711257F);
        this.largeLeaf03b_2 = new ModelRenderer(this, 11, 10);
        this.largeLeaf03b_2.setPos(10.0F, 0.0F, 0.0F);
        this.largeLeaf03b_2.addBox(0.0F, 0.0F, -3.0F, 8, 0, 6, 0.0F);
        this.setRotateAngle(this.largeLeaf03b_2, 0.0F, 0.0F, 0.136659280431156F);
        this.petal03a = new ModelRenderer(this, 18, 19);
        this.petal03a.setPos(0.0F, -0.3F, 0.0F);
        this.petal03a.addBox(-2.5F, -5.6F, -0.7F, 5, 5, 0, 0.0F);
        this.setRotateAngle(this.petal03a, 0.6373942428283291F, -2.0943951023931953F, 0.0F);
        this.largeLeaf03b_1 = new ModelRenderer(this, 11, 10);
        this.largeLeaf03b_1.setPos(10.0F, 0.0F, 0.0F);
        this.largeLeaf03b_1.addBox(0.0F, 0.0F, -3.0F, 8, 0, 6, 0.0F);
        this.setRotateAngle(this.largeLeaf03b_1, 0.0F, 0.0F, 0.136659280431156F);
        this.stem03_2 = new ModelRenderer(this, 0, 11);
        this.stem03_2.setPos(-5.7F, 23.3F, 3.4000000000000004F);
        this.stem03_2.addBox(-0.5F, -6.1F, -0.5F, 1, 6, 1, 0.0F);
        this.setRotateAngle(this.stem03_2, -0.1340412865531645F, 0.0F, -0.091106186954104F);
        this.smallLeaf01b = new ModelRenderer(this, 35, 9);
        this.smallLeaf01b.setPos(9.0F, 0.0F, 0.0F);
        this.smallLeaf01b.addBox(0.0F, 0.0F, -2.5F, 7, 0, 5, 0.0F);
        this.setRotateAngle(this.smallLeaf01b, 0.0F, 0.0F, 0.091106186954104F);
        this.petal02b_1 = new ModelRenderer(this, 19, 24);
        this.petal02b_1.setPos(0.0F, -5.6F, -0.7F);
        this.petal02b_1.addBox(-1.5F, -3.0F, 0.0F, 3, 3, 0, 0.0F);
        this.setRotateAngle(this.petal02b_1, -0.22759093446006054F, 0.0F, 0.0F);
        this.petal03a_1 = new ModelRenderer(this, 18, 19);
        this.petal03a_1.setPos(0.0F, -0.3F, 0.0F);
        this.petal03a_1.addBox(-2.5F, -5.6F, -0.7F, 5, 5, 0, 0.0F);
        this.setRotateAngle(this.petal03a_1, 0.6373942428283291F, -2.0943951023931953F, 0.0F);
        this.stem02_2 = new ModelRenderer(this, 0, 5);
        this.stem02_2.setPos(-5.500000000000002F, 25.8F, 3.099999999999999F);
        this.stem02_2.addBox(-1.0F, -3.0F, -1.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(this.stem02_2, -0.1340412865531645F, 0.0F, -0.091106186954104F);
        this.petal02a_2 = new ModelRenderer(this, 18, 19);
        this.petal02a_2.setPos(0.0F, -0.3F, 0.0F);
        this.petal02a_2.addBox(-2.5F, -5.6F, -0.7F, 5, 5, 0, 0.0F);
        this.setRotateAngle(this.petal02a_2, 0.6373942428283291F, 2.0943951023931953F, 0.0F);
        this.smallLeaf01b_2 = new ModelRenderer(this, 35, 9);
        this.smallLeaf01b_2.setPos(9.0F, 0.0F, 0.0F);
        this.smallLeaf01b_2.addBox(0.0F, 0.0F, -2.5F, 7, 0, 5, 0.0F);
        this.setRotateAngle(this.smallLeaf01b_2, 0.0F, 0.0F, 0.091106186954104F);
        this.stem05 = new ModelRenderer(this, 0, 25);
        this.stem05.setPos(-2.2F, 12.0F, -4.9F);
        this.stem05.addBox(-1.0F, -1.0F, -1.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(this.stem05, 0.0F, 0.4000294645571003F, 0.0F);
        this.smallLeaf02b_1 = new ModelRenderer(this, 35, 9);
        this.smallLeaf02b_1.setPos(9.0F, 0.0F, 0.0F);
        this.smallLeaf02b_1.addBox(0.0F, 0.0F, -2.5F, 7, 0, 5, 0.0F);
        this.setRotateAngle(this.smallLeaf02b_1, 0.0F, 0.0F, 0.091106186954104F);
        this.petal01a_2 = new ModelRenderer(this, 18, 19);
        this.petal01a_2.setPos(0.0F, -0.3F, 0.0F);
        this.petal01a_2.addBox(-2.5F, -5.6F, -0.7F, 5, 5, 0, 0.0F);
        this.setRotateAngle(this.petal01a_2, 0.6373942428283291F, 0.0F, 0.0F);
        this.stem02 = new ModelRenderer(this, 0, 5);
        this.stem02.setPos(-2.1999999999999993F, 22.1F, -4.899999999999997F);
        this.stem02.addBox(-1.0F, -3.0F, -1.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(this.stem02, 0.0F, 0.6731734924942129F, 0.0F);
        this.smallLeaf03a_2 = new ModelRenderer(this, 31, 0);
        this.smallLeaf03a_2.setPos(0.5F, -0.3F, 0.0F);
        this.smallLeaf03a_2.addBox(0.0F, 0.0F, -4.5F, 9, 0, 9, 0.0F);
        this.setRotateAngle(this.smallLeaf03a_2, 0.091106186954104F, -1.0471975511965976F, -0.091106186954104F);
        this.petal01a = new ModelRenderer(this, 18, 19);
        this.petal01a.setPos(0.0F, -0.3F, 0.0F);
        this.petal01a.addBox(-2.5F, -5.6F, -0.7F, 5, 5, 0, 0.0F);
        this.setRotateAngle(this.petal01a, 0.6373942428283291F, 0.0F, 0.0F);
        this.smallLeaf02a_2 = new ModelRenderer(this, 31, 0);
        this.smallLeaf02a_2.setPos(0.5F, -0.3F, 0.0F);
        this.smallLeaf02a_2.addBox(0.0F, 0.0F, -4.5F, 9, 0, 9, 0.0F);
        this.setRotateAngle(this.smallLeaf02a_2, -0.091106186954104F, 1.0471975511965976F, -0.091106186954104F);
        this.smallLeaf03b_2 = new ModelRenderer(this, 35, 9);
        this.smallLeaf03b_2.setPos(9.0F, 0.0F, 0.0F);
        this.smallLeaf03b_2.addBox(0.0F, 0.0F, -2.5F, 7, 0, 5, 0.0F);
        this.setRotateAngle(this.smallLeaf03b_2, 0.0F, 0.0F, 0.091106186954104F);
        this.largeLeaf01b_2 = new ModelRenderer(this, 11, 10);
        this.largeLeaf01b_2.setPos(10.0F, 0.0F, 0.0F);
        this.largeLeaf01b_2.addBox(0.0F, 0.0F, -3.0F, 8, 0, 6, 0.0F);
        this.setRotateAngle(this.largeLeaf01b_2, 0.0F, 0.0F, 0.136659280431156F);
        this.smallLeaf02b = new ModelRenderer(this, 35, 9);
        this.smallLeaf02b.setPos(9.0F, 0.0F, 0.0F);
        this.smallLeaf02b.addBox(0.0F, 0.0F, -2.5F, 7, 0, 5, 0.0F);
        this.setRotateAngle(this.smallLeaf02b, 0.0F, 0.0F, 0.091106186954104F);
        this.petal03b = new ModelRenderer(this, 19, 24);
        this.petal03b.setPos(0.0F, -5.6F, -0.7F);
        this.petal03b.addBox(-1.5F, -3.0F, 0.0F, 3, 3, 0, 0.0F);
        this.setRotateAngle(this.petal03b, -0.22759093446006054F, 0.0F, 0.0F);
        this.petal02a = new ModelRenderer(this, 18, 19);
        this.petal02a.setPos(0.0F, -0.3F, 0.0F);
        this.petal02a.addBox(-2.5F, -5.6F, -0.7F, 5, 5, 0, 0.0F);
        this.setRotateAngle(this.petal02a, 0.6373942428283291F, 2.0943951023931953F, 0.0F);
        this.largeLeaf03a = new ModelRenderer(this, 7, 0);
        this.largeLeaf03a.setPos(0.0F, -1.5F, 0.0F);
        this.largeLeaf03a.addBox(0.0F, 0.0F, -5.0F, 10, 0, 10, 0.0F);
        this.setRotateAngle(this.largeLeaf03a, 0.36425021489121656F, -2.0943951023931953F, -0.4553564018453205F);
        this.smallLeaf03b = new ModelRenderer(this, 35, 9);
        this.smallLeaf03b.setPos(9.0F, 0.0F, 0.0F);
        this.smallLeaf03b.addBox(0.0F, 0.0F, -2.5F, 7, 0, 5, 0.0F);
        this.setRotateAngle(this.smallLeaf03b, 0.0F, 0.0F, 0.091106186954104F);
        this.largeLeaf01b_1 = new ModelRenderer(this, 11, 10);
        this.largeLeaf01b_1.setPos(10.0F, 0.0F, 0.0F);
        this.largeLeaf01b_1.addBox(0.0F, 0.0F, -3.0F, 8, 0, 6, 0.0F);
        this.setRotateAngle(this.largeLeaf01b_1, 0.0F, 0.0F, 0.136659280431156F);
        this.stem02_1 = new ModelRenderer(this, 0, 5);
        this.stem02_1.setPos(4.800000000000001F, 25.80000000000003F, 2.9000000000000012F);
        this.stem02_1.addBox(-1.0F, -3.0F, -1.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(this.stem02_1, 0.0F, 0.0F, 0.091106186954104F);
        this.largeLeaf01b = new ModelRenderer(this, 11, 10);
        this.largeLeaf01b.setPos(10.0F, 0.0F, 0.0F);
        this.largeLeaf01b.addBox(0.0F, 0.0F, -3.0F, 8, 0, 6, 0.0F);
        this.setRotateAngle(this.largeLeaf01b, 0.0F, 0.0F, 0.136659280431156F);
        this.petal01a_1 = new ModelRenderer(this, 18, 19);
        this.petal01a_1.setPos(0.0F, -0.3F, 0.0F);
        this.petal01a_1.addBox(-2.5F, -5.6F, -0.7F, 5, 5, 0, 0.0F);
        this.setRotateAngle(this.petal01a_1, 0.6373942428283291F, 0.0F, 0.0F);
        this.largeLeaf02a_1 = new ModelRenderer(this, 7, 0);
        this.largeLeaf02a_1.setPos(0.0F, -1.5F, 0.0F);
        this.largeLeaf02a_1.addBox(0.0F, 0.0F, -5.0F, 10, 0, 10, 0.0F);
        this.setRotateAngle(this.largeLeaf02a_1, -0.36425021489121656F, 2.0943951023931953F, -0.4553564018453205F);
        this.petal02b = new ModelRenderer(this, 19, 24);
        this.petal02b.setPos(0.0F, -5.6F, -0.7F);
        this.petal02b.addBox(-1.5F, -3.0F, 0.0F, 3, 3, 0, 0.0F);
        this.setRotateAngle(this.petal02b, -0.22759093446006054F, 0.0F, 0.0F);
        this.smallLeaf03a = new ModelRenderer(this, 31, 0);
        this.smallLeaf03a.setPos(0.5F, -0.3F, 0.0F);
        this.smallLeaf03a.addBox(0.0F, 0.0F, -4.5F, 9, 0, 9, 0.0F);
        this.setRotateAngle(this.smallLeaf03a, 0.091106186954104F, -1.0471975511965976F, -0.091106186954104F);
        this.petal02b_2 = new ModelRenderer(this, 19, 24);
        this.petal02b_2.setPos(0.0F, -5.6F, -0.7F);
        this.petal02b_2.addBox(-1.5F, -3.0F, 0.0F, 3, 3, 0, 0.0F);
        this.setRotateAngle(this.petal02b_2, -0.22759093446006054F, 0.0F, 0.0F);
        this.smallLeaf01a_2 = new ModelRenderer(this, 31, 0);
        this.smallLeaf01a_2.setPos(0.5F, -0.3F, 0.0F);
        this.smallLeaf01a_2.addBox(0.0F, 0.0F, -4.5F, 9, 0, 9, 0.0F);
        this.setRotateAngle(this.smallLeaf01a_2, 0.0F, 3.141592653589793F, 0.091106186954104F);
        this.smallLeaf01b_1 = new ModelRenderer(this, 35, 9);
        this.smallLeaf01b_1.setPos(9.0F, 0.0F, 0.0F);
        this.smallLeaf01b_1.addBox(0.0F, 0.0F, -2.5F, 7, 0, 5, 0.0F);
        this.setRotateAngle(this.smallLeaf01b_1, 0.0F, 0.0F, 0.091106186954104F);
        this.largeLeaf02a_2 = new ModelRenderer(this, 7, 0);
        this.largeLeaf02a_2.setPos(0.0F, -1.5F, 0.0F);
        this.largeLeaf02a_2.addBox(0.0F, 0.0F, -5.0F, 10, 0, 10, 0.0F);
        this.setRotateAngle(this.largeLeaf02a_2, -0.36425021489121656F, 2.0943951023931953F, -0.4553564018453205F);
        this.largeLeaf03a_2 = new ModelRenderer(this, 7, 0);
        this.largeLeaf03a_2.setPos(0.0F, -1.5F, 0.0F);
        this.largeLeaf03a_2.addBox(0.0F, 0.0F, -5.0F, 10, 0, 10, 0.0F);
        this.setRotateAngle(this.largeLeaf03a_2, 0.36425021489121656F, -2.0943951023931953F, -0.4553564018453205F);
        this.largeLeaf02b_1 = new ModelRenderer(this, 11, 10);
        this.largeLeaf02b_1.setPos(10.0F, 0.0F, 0.0F);
        this.largeLeaf02b_1.addBox(0.0F, 0.0F, -3.0F, 8, 0, 6, 0.0F);
        this.setRotateAngle(this.largeLeaf02b_1, 0.0F, 0.0F, 0.136659280431156F);
        this.stem03 = new ModelRenderer(this, 0, 11);
        this.stem03.setPos(-2.1999999999999993F, 19.4F, -4.899999999999997F);
        this.stem03.addBox(-0.5F, -6.1F, -0.5F, 1, 6, 1, 0.0F);
        this.setRotateAngle(this.stem03, 0.0F, 0.6731734924942129F, 0.0F);
        this.stem01 = new ModelRenderer(this, 0, 0);
        this.stem01.setPos(-2.2F, 24.0F, -4.8999999999999995F);
        this.stem01.addBox(-1.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(this.stem01, 0.0F, 0.6731734924942129F, 0.0F);
        this.largeLeaf03b = new ModelRenderer(this, 11, 10);
        this.largeLeaf03b.setPos(10.0F, 0.0F, 0.0F);
        this.largeLeaf03b.addBox(0.0F, 0.0F, -3.0F, 8, 0, 6, 0.0F);
        this.setRotateAngle(this.largeLeaf03b, 0.0F, 0.0F, 0.136659280431156F);
        this.smallLeaf03b_1 = new ModelRenderer(this, 35, 9);
        this.smallLeaf03b_1.setPos(9.0F, 0.0F, 0.0F);
        this.smallLeaf03b_1.addBox(0.0F, 0.0F, -2.5F, 7, 0, 5, 0.0F);
        this.setRotateAngle(this.smallLeaf03b_1, 0.0F, 0.0F, 0.091106186954104F);
        this.largeLeaf02a = new ModelRenderer(this, 7, 0);
        this.largeLeaf02a.setPos(0.0F, -1.5F, 0.0F);
        this.largeLeaf02a.addBox(0.0F, 0.0F, -5.0F, 10, 0, 10, 0.0F);
        this.setRotateAngle(this.largeLeaf02a, -0.36425021489121656F, 2.0943951023931953F, -0.4553564018453205F);
        this.smallLeaf01a_1 = new ModelRenderer(this, 31, 0);
        this.smallLeaf01a_1.setPos(0.5F, -0.3F, 0.0F);
        this.smallLeaf01a_1.addBox(0.0F, 0.0F, -4.5F, 9, 0, 9, 0.0F);
        this.setRotateAngle(this.smallLeaf01a_1, 0.0F, 3.141592653589793F, 0.091106186954104F);
        this.smallLeaf03a_1 = new ModelRenderer(this, 31, 0);
        this.smallLeaf03a_1.setPos(0.5F, -0.3F, 0.0F);
        this.smallLeaf03a_1.addBox(0.0F, 0.0F, -4.5F, 9, 0, 9, 0.0F);
        this.setRotateAngle(this.smallLeaf03a_1, 0.091106186954104F, -1.0471975511965976F, -0.091106186954104F);
        this.largeLeaf02b = new ModelRenderer(this, 11, 10);
        this.largeLeaf02b.setPos(10.0F, 0.0F, 0.0F);
        this.largeLeaf02b.addBox(0.0F, 0.0F, -3.0F, 8, 0, 6, 0.0F);
        this.setRotateAngle(this.largeLeaf02b, 0.0F, 0.0F, 0.136659280431156F);
        this.stem05_2 = new ModelRenderer(this, 0, 25);
        this.stem05_2.setPos(-6.4F, 17.5F, 4.300000000000002F);
        this.stem05_2.addBox(-1.0F, -1.0F, -1.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(this.stem05_2, -0.1340412865531645F, 0.0F, -0.091106186954104F);
        this.petal03b_1 = new ModelRenderer(this, 19, 24);
        this.petal03b_1.setPos(0.0F, -5.6F, -0.7F);
        this.petal03b_1.addBox(-1.5F, -3.0F, 0.0F, 3, 3, 0, 0.0F);
        this.setRotateAngle(this.petal03b_1, -0.22759093446006054F, 0.0F, 0.0F);
        this.petal01a_1.addChild(this.petal01b_1);
        this.stem05.addChild(this.smallLeaf01a);
        this.largeLeaf02a_2.addChild(this.largeLeaf02b_2);
        this.stem05.addChild(this.smallLeaf02a);
        this.stem04_1.addChild(this.largeLeaf01a_1);
        this.smallLeaf02a_2.addChild(this.smallLeaf02b_2);
        this.petal01a_2.addChild(this.petal01b_2);
        this.petal01a.addChild(this.petal01b);
        this.stem04.addChild(this.largeLeaf01a);
        this.stem05_2.addChild(this.petal03a_2);
        this.stem05_1.addChild(this.smallLeaf02a_1);
        this.stem05_1.addChild(this.petal02a_1);
        this.stem04_1.addChild(this.largeLeaf03a_1);
        this.petal03a_2.addChild(this.petal03b_2);
        this.stem04_2.addChild(this.largeLeaf01a_2);
        this.largeLeaf03a_2.addChild(this.largeLeaf03b_2);
        this.stem05.addChild(this.petal03a);
        this.largeLeaf03a_1.addChild(this.largeLeaf03b_1);
        this.smallLeaf01a.addChild(this.smallLeaf01b);
        this.petal02a_1.addChild(this.petal02b_1);
        this.stem05_1.addChild(this.petal03a_1);
        this.stem05_2.addChild(this.petal02a_2);
        this.smallLeaf01a_2.addChild(this.smallLeaf01b_2);
        this.smallLeaf02a_1.addChild(this.smallLeaf02b_1);
        this.stem05_2.addChild(this.petal01a_2);
        this.stem05_2.addChild(this.smallLeaf03a_2);
        this.stem05.addChild(this.petal01a);
        this.stem05_2.addChild(this.smallLeaf02a_2);
        this.smallLeaf03a_2.addChild(this.smallLeaf03b_2);
        this.largeLeaf01a_2.addChild(this.largeLeaf01b_2);
        this.smallLeaf02a.addChild(this.smallLeaf02b);
        this.petal03a.addChild(this.petal03b);
        this.stem05.addChild(this.petal02a);
        this.stem04.addChild(this.largeLeaf03a);
        this.smallLeaf03a.addChild(this.smallLeaf03b);
        this.largeLeaf01a_1.addChild(this.largeLeaf01b_1);
        this.largeLeaf01a.addChild(this.largeLeaf01b);
        this.stem05_1.addChild(this.petal01a_1);
        this.stem04_1.addChild(this.largeLeaf02a_1);
        this.petal02a.addChild(this.petal02b);
        this.stem05.addChild(this.smallLeaf03a);
        this.petal02a_2.addChild(this.petal02b_2);
        this.stem05_2.addChild(this.smallLeaf01a_2);
        this.smallLeaf01a_1.addChild(this.smallLeaf01b_1);
        this.stem04_2.addChild(this.largeLeaf02a_2);
        this.stem04_2.addChild(this.largeLeaf03a_2);
        this.largeLeaf02a_1.addChild(this.largeLeaf02b_1);
        this.largeLeaf03a.addChild(this.largeLeaf03b);
        this.smallLeaf03a_1.addChild(this.smallLeaf03b_1);
        this.stem04.addChild(this.largeLeaf02a);
        this.stem05_1.addChild(this.smallLeaf01a_1);
        this.stem05_1.addChild(this.smallLeaf03a_1);
        this.largeLeaf02a.addChild(this.largeLeaf02b);
        this.petal03a_1.addChild(this.petal03b_1);
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(rotation)); // Yaw
        this.stem03_1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        matrixStackIn.pushPose();
        {
            RenderUtil.partScaleTranslate(matrixStackIn, stem04, 0.8F, 1.0F, 0.8F);
            this.stem04.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        }
        matrixStackIn.popPose();
        matrixStackIn.pushPose();
        {
            RenderUtil.partScaleTranslate(matrixStackIn, stem04_1, 0.8F, 1.0F, 0.8F);
            this.stem04_1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        }
        matrixStackIn.popPose();
        matrixStackIn.pushPose();
        {
            RenderUtil.partScaleTranslate(matrixStackIn, stem04_2, 0.7F, 0.81F, 0.7F);
            this.stem04_2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        }
        matrixStackIn.popPose();
        matrixStackIn.pushPose();
        {
            RenderUtil.partScaleTranslate(matrixStackIn, stem05_1, 0.4F, 0.7F, 0.4F);
            this.stem05_1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        }
        matrixStackIn.popPose();
        matrixStackIn.pushPose();
        {
            RenderUtil.partScaleTranslate(matrixStackIn, stem03_2, 0.9F, 0.8F, 0.9F);
            this.stem03_2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        }
        matrixStackIn.popPose();
        matrixStackIn.pushPose();
        {
            RenderUtil.partScaleTranslate(matrixStackIn, stem02_2, 0.7F, 0.9F, 0.7F);
            this.stem02_2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        }
        matrixStackIn.popPose();
        matrixStackIn.pushPose();
        {
            RenderUtil.partScaleTranslate(matrixStackIn, stem05, 0.4F, 0.7F, 0.4F);
            this.stem05.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        }
        matrixStackIn.popPose();
        matrixStackIn.pushPose();
        {
            RenderUtil.partScaleTranslate(matrixStackIn, stem02, 0.7F, 1.0F, 0.7F);
            this.stem02.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        }
        matrixStackIn.popPose();
        matrixStackIn.pushPose();
        {
            RenderUtil.partScaleTranslate(matrixStackIn, stem02_1, 0.7F, 1.0F, 0.7F);
            this.stem02_1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        }
        matrixStackIn.popPose();
        this.stem03.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        matrixStackIn.pushPose();
        {
            RenderUtil.partScaleTranslate(matrixStackIn, stem01, 0.8F, 1.0F, 0.8F);
            this.stem01.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        }
        matrixStackIn.popPose();
        matrixStackIn.pushPose();
        {
            RenderUtil.partScaleTranslate(matrixStackIn, stem05_2, 0.3F, 0.54F, 0.3F);
            this.stem05_2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        }
        matrixStackIn.popPose();
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.rotation = netHeadYaw;
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
