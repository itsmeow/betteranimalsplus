package its_meow.betteranimalsplus.client.model;

import its_meow.betteranimalsplus.common.entity.EntityReindeer;
import net.minecraft.client.renderer.entity.model.ModelBase;
import net.minecraft.client.renderer.entity.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;

/**
 * reindeer - cybercat5555
 * Created using Tabula 5.1.0
 */
public class ModelReindeer extends ModelBase {
	public ModelRenderer body;
	public ModelRenderer ass;
	public ModelRenderer chest;
	public ModelRenderer lForeleg01;
	public ModelRenderer rForeleg01;
	public ModelRenderer bodyFur;
	public ModelRenderer lHindLeg01;
	public ModelRenderer rHindLeg01;
	public ModelRenderer tail;
	public ModelRenderer lHindLeg02;
	public ModelRenderer lHindLeg03;
	public ModelRenderer lHindHoof;
	public ModelRenderer rHindLeg02;
	public ModelRenderer rHindLeg03;
	public ModelRenderer rHindHoof;
	public ModelRenderer neck;
	public ModelRenderer mane03;
	public ModelRenderer mane04;
	public ModelRenderer head;
	public ModelRenderer mane01;
	public ModelRenderer mane02;
	public ModelRenderer lowerJaw;
	public ModelRenderer lEar;
	public ModelRenderer rEar;
	public ModelRenderer lAntler01;
	public ModelRenderer snout;
	public ModelRenderer rAntler01;
	public ModelRenderer lAntler02;
	public ModelRenderer lAntler14;
	public ModelRenderer lAntler03;
	public ModelRenderer lAntler10;
	public ModelRenderer lAntler04;
	public ModelRenderer lAntler06;
	public ModelRenderer lAntler05;
	public ModelRenderer lAntler08;
	public ModelRenderer lAntler09;
	public ModelRenderer lAntler07;
	public ModelRenderer lAntler11;
	public ModelRenderer lAntler12;
	public ModelRenderer lAntler13;
	public ModelRenderer lAntler15;
	public ModelRenderer lAntler16;
	public ModelRenderer rAntler02;
	public ModelRenderer rAntler14;
	public ModelRenderer rAntler03;
	public ModelRenderer rAntler10;
	public ModelRenderer rAntler04;
	public ModelRenderer rAntler06;
	public ModelRenderer rAntler05;
	public ModelRenderer rAntler08;
	public ModelRenderer rAntler09;
	public ModelRenderer rAntler07;
	public ModelRenderer rAntler11;
	public ModelRenderer rAntler12;
	public ModelRenderer rAntler13;
	public ModelRenderer rAntler15;
	public ModelRenderer rAntler16;
	public ModelRenderer lForeleg02;
	public ModelRenderer lForeleg03;
	public ModelRenderer lForeHoof;
	public ModelRenderer rForeleg02;
	public ModelRenderer rForeleg03;
	public ModelRenderer rForeHoof;

	public ModelReindeer() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.lHindHoof = new ModelRenderer(this, 32, 12);
		this.lHindHoof.setRotationPoint(-0.0F, 7.1F, 0.3F);
		this.lHindHoof.addBox(-1.5F, 0.0F, -2.4F, 3, 2, 3, 0.0F);
		this.mane02 = new ModelRenderer(this, 20, 50);
		this.mane02.setRotationPoint(0.0F, 1.5F, -2.2F);
		this.mane02.addBox(-2.5F, 0.0F, 0.0F, 5, 1, 6, 0.0F);
		this.setRotateAngle(this.mane02, -0.5462880558742251F, 0.0F, 0.0F);
		this.lAntler02 = new ModelRenderer(this, 117, 0);
		this.lAntler02.setRotationPoint(0.0F, 0.3F, -2.1F);
		this.lAntler02.addBox(-0.5F, -6.0F, -0.5F, 1, 6, 1, 0.0F);
		this.setRotateAngle(this.lAntler02, 0.6981317007977318F, -0.17453292519943295F, 0.20943951023931953F);
		this.lAntler11 = new ModelRenderer(this, 117, 0);
		this.lAntler11.setRotationPoint(0.1F, 0.0F, -2.7F);
		this.lAntler11.addBox(-0.5F, -0.5F, -2.0F, 1, 1, 2, 0.0F);
		this.setRotateAngle(this.lAntler11, 0.0F, 0.5235987755982988F, 0.0F);
		this.rHindLeg01 = new ModelRenderer(this, 64, 0);
		this.rHindLeg01.mirror = true;
		this.rHindLeg01.setRotationPoint(-2.5F, -1.1F, 3.3F);
		this.rHindLeg01.addBox(-3.0F, -1.9F, -2.0F, 3, 8, 5, 0.0F);
		this.setRotateAngle(this.rHindLeg01, -0.22759093446006054F, 0.0F, 0.0F);
		this.lowerJaw = new ModelRenderer(this, 102, 28);
		this.lowerJaw.setRotationPoint(0.0F, 3.3F, -1.4F);
		this.lowerJaw.addBox(-1.5F, -0.4F, -1.0F, 3, 4, 2, 0.0F);
		this.snout = new ModelRenderer(this, 88, 36);
		this.snout.setRotationPoint(0.0F, 3.0F, -2.8F);
		this.snout.addBox(-2.0F, 0.3F, -1.2F, 4, 4, 2, 0.0F);
		this.setRotateAngle(this.snout, 0.2792526803190927F, 0.0F, 0.0F);
		this.bodyFur = new ModelRenderer(this, 94, 52);
		this.bodyFur.setRotationPoint(0.0F, 5.3F, 1.3F);
		this.bodyFur.addBox(-3.0F, 0.0F, 0.0F, 6, 2, 7, 0.0F);
		this.lAntler01 = new ModelRenderer(this, 117, 0);
		this.lAntler01.setRotationPoint(1.1F, 1.0F, -3.5F);
		this.lAntler01.addBox(-0.5F, -0.5F, -2.5F, 1, 1, 3, 0.0F);
		this.setRotateAngle(this.lAntler01, -0.2792526803190927F, -0.4363323129985824F, 0.0F);
		this.rAntler04 = new ModelRenderer(this, 117, 0);
		this.rAntler04.setRotationPoint(0.0F, -0.1F, -1.6F);
		this.rAntler04.addBox(-0.5F, -0.5F, -5.0F, 1, 1, 5, 0.0F);
		this.setRotateAngle(this.rAntler04, 0.6981317007977318F, -0.22689280275926282F, 0.0F);
		this.lHindLeg03 = new ModelRenderer(this, 68, 30);
		this.lHindLeg03.setRotationPoint(0.1F, 6.4F, 0.5F);
		this.lHindLeg03.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
		this.setRotateAngle(this.lHindLeg03, -0.5009094953223726F, 0.0F, 0.0F);
		this.lAntler16 = new ModelRenderer(this, 117, 0);
		this.lAntler16.setRotationPoint(0.0F, 2.5F, 0.0F);
		this.lAntler16.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(this.lAntler16, 0.41887902047863906F, 0.0F, 0.3665191429188092F);
		this.rAntler07 = new ModelRenderer(this, 117, 0);
		this.rAntler07.setRotationPoint(0.0F, -2.8F, 0.0F);
		this.rAntler07.addBox(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(this.rAntler07, 0.0F, 0.0F, 0.3490658503988659F);
		this.rAntler03 = new ModelRenderer(this, 117, 0);
		this.rAntler03.setRotationPoint(0.0F, -5.7F, 0.1F);
		this.rAntler03.addBox(-0.5F, -0.5F, -2.0F, 1, 1, 2, 0.0F);
		this.setRotateAngle(this.rAntler03, -0.9075712110370513F, -0.22689280275926282F, -0.22689280275926282F);
		this.lForeHoof = new ModelRenderer(this, 32, 12);
		this.lForeHoof.setRotationPoint(-0.0F, 8.3F, 0.3F);
		this.lForeHoof.addBox(-1.5F, 0.0F, -2.4F, 3, 2, 3, 0.0F);
		this.rForeleg03 = new ModelRenderer(this, 50, 25);
		this.rForeleg03.mirror = true;
		this.rForeleg03.setRotationPoint(0.0F, 2.7F, 0.0F);
		this.rForeleg03.addBox(-1.0F, 0.0F, -1.0F, 2, 9, 2, 0.0F);
		this.setRotateAngle(this.rForeleg03, -0.136659280431156F, 0.0F, 0.0F);
		this.rAntler15 = new ModelRenderer(this, 117, 0);
		this.rAntler15.mirror = true;
		this.rAntler15.setRotationPoint(0.0F, 2.8F, 0.0F);
		this.rAntler15.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(this.rAntler15, -0.3141592653589793F, 0.0F, -0.3665191429188092F);
		this.rForeleg02 = new ModelRenderer(this, 48, 14);
		this.rForeleg02.mirror = true;
		this.rForeleg02.setRotationPoint(-0.8F, 4.4F, 0.1F);
		this.rForeleg02.addBox(-1.0F, 0.0F, -1.5F, 2, 3, 3, 0.0F);
		this.setRotateAngle(this.rForeleg02, 0.0F, 0.0F, -0.091106186954104F);
		this.tail = new ModelRenderer(this, 33, 0);
		this.tail.setRotationPoint(0.0F, -2.7F, 5.1F);
		this.tail.addBox(-1.5F, 0.0F, -1.0F, 3, 4, 2, 0.0F);
		this.setRotateAngle(this.tail, 0.5918411493512771F, 0.0F, 0.0F);
		this.body = new ModelRenderer(this, 0, 13);
		this.body.setRotationPoint(0.0F, 6.5F, -9.2F);
		this.body.addBox(-4.0F, -3.5F, 0.0F, 8, 9, 13, 0.0F);
		this.chest = new ModelRenderer(this, 0, 0);
		this.chest.setRotationPoint(0.0F, 0.8F, 2.4F);
		this.chest.addBox(-3.5F, -3.0F, -5.0F, 7, 6, 5, 0.0F);
		this.setRotateAngle(this.chest, -0.6829473363053812F, 0.0F, 0.0F);
		this.rForeleg01 = new ModelRenderer(this, 45, 0);
		this.rForeleg01.mirror = true;
		this.rForeleg01.setRotationPoint(-3.1F, 0.6F, 2.3F);
		this.rForeleg01.addBox(-2.0F, -2.4F, -2.5F, 3, 7, 5, 0.0F);
		this.setRotateAngle(this.rForeleg01, 0.136659280431156F, 0.0F, 0.091106186954104F);
		this.lAntler13 = new ModelRenderer(this, 117, 0);
		this.lAntler13.mirror = true;
		this.lAntler13.setRotationPoint(0.1F, 0.2F, -0.7F);
		this.lAntler13.addBox(-0.5F, -0.5F, -3.8F, 1, 1, 4, 0.0F);
		this.setRotateAngle(this.lAntler13, 0.45378560551852565F, 0.3490658503988659F, 0.0F);
		this.rHindLeg03 = new ModelRenderer(this, 68, 30);
		this.rHindLeg03.mirror = true;
		this.rHindLeg03.setRotationPoint(-0.1F, 6.4F, 0.5F);
		this.rHindLeg03.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
		this.setRotateAngle(this.rHindLeg03, -0.5009094953223726F, 0.0F, 0.0F);
		this.lAntler09 = new ModelRenderer(this, 117, 0);
		this.lAntler09.mirror = true;
		this.lAntler09.setRotationPoint(0.0F, -1.8F, 0.0F);
		this.lAntler09.addBox(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(this.lAntler09, 0.0F, 0.0F, -0.3490658503988659F);
		this.mane01 = new ModelRenderer(this, 0, 50);
		this.mane01.setRotationPoint(0.0F, 1.5F, -4.3F);
		this.mane01.addBox(-2.0F, 0.0F, 0.0F, 4, 1, 5, 0.0F);
		this.setRotateAngle(this.mane01, -0.5462880558742251F, 0.0F, 0.0F);
		this.rAntler12 = new ModelRenderer(this, 117, 0);
		this.rAntler12.setRotationPoint(-0.1F, 0.0F, -1.7F);
		this.rAntler12.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F);
		this.setRotateAngle(this.rAntler12, -0.3665191429188092F, -0.5235987755982988F, 0.0F);
		this.head = new ModelRenderer(this, 88, 14);
		this.head.setRotationPoint(0.0F, 1.1F, -4.0F);
		this.head.addBox(-2.5F, -3.0F, -4.0F, 5, 7, 4, 0.0F);
		this.setRotateAngle(this.head, -0.3490658503988659F, 0.0F, 0.0F);
		this.rHindHoof = new ModelRenderer(this, 32, 12);
		this.rHindHoof.mirror = true;
		this.rHindHoof.setRotationPoint(-0.0F, 7.1F, 0.3F);
		this.rHindHoof.addBox(-1.5F, 0.0F, -2.4F, 3, 2, 3, 0.0F);
		this.lHindLeg02 = new ModelRenderer(this, 65, 15);
		this.lHindLeg02.setRotationPoint(1.4F, 5.0F, -1.1F);
		this.lHindLeg02.addBox(-1.5F, 0.0F, -1.5F, 3, 7, 3, 0.0F);
		this.setRotateAngle(this.lHindLeg02, 0.9105382707654417F, 0.0F, 0.0F);
		this.rAntler14 = new ModelRenderer(this, 117, 0);
		this.rAntler14.mirror = true;
		this.rAntler14.setRotationPoint(0.0F, 0.4F, -0.3F);
		this.rAntler14.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(this.rAntler14, -0.19198621771937624F, 0.0F, 0.0F);
		this.lForeleg01 = new ModelRenderer(this, 45, 0);
		this.lForeleg01.setRotationPoint(3.1F, 0.6F, 2.3F);
		this.lForeleg01.addBox(-1.0F, -2.4F, -2.5F, 3, 7, 5, 0.0F);
		this.setRotateAngle(this.lForeleg01, 0.136659280431156F, 0.0F, -0.091106186954104F);
		this.rForeHoof = new ModelRenderer(this, 32, 12);
		this.rForeHoof.mirror = true;
		this.rForeHoof.setRotationPoint(-0.0F, 8.3F, 0.3F);
		this.rForeHoof.addBox(-1.5F, 0.0F, -2.4F, 3, 2, 3, 0.0F);
		this.rAntler13 = new ModelRenderer(this, 117, 0);
		this.rAntler13.setRotationPoint(-0.1F, 0.2F, -0.7F);
		this.rAntler13.addBox(-0.5F, -0.5F, -3.8F, 1, 1, 4, 0.0F);
		this.setRotateAngle(this.rAntler13, 0.45378560551852565F, -0.3490658503988659F, 0.0F);
		this.rAntler16 = new ModelRenderer(this, 117, 0);
		this.rAntler16.mirror = true;
		this.rAntler16.setRotationPoint(0.0F, 2.5F, 0.0F);
		this.rAntler16.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(this.rAntler16, 0.41887902047863906F, 0.0F, -0.3665191429188092F);
		this.mane03 = new ModelRenderer(this, 46, 50);
		this.mane03.setRotationPoint(0.0F, 1.7F, -4.9F);
		this.mane03.addBox(-3.0F, 0.0F, 0.0F, 6, 1, 6, 0.0F);
		this.setRotateAngle(this.mane03, -0.767944870877505F, 0.0F, 0.0F);
		this.neck = new ModelRenderer(this, 88, 0);
		this.neck.setRotationPoint(0.0F, 0.3F, -4.0F);
		this.neck.addBox(-2.5F, -2.5F, -5.0F, 5, 5, 5, 0.0F);
		this.setRotateAngle(this.neck, -0.31869712141416456F, 0.0F, 0.0F);
		this.lAntler04 = new ModelRenderer(this, 117, 0);
		this.lAntler04.mirror = true;
		this.lAntler04.setRotationPoint(0.0F, -0.1F, -1.6F);
		this.lAntler04.addBox(-0.5F, -0.5F, -5.0F, 1, 1, 5, 0.0F);
		this.setRotateAngle(this.lAntler04, 0.6981317007977318F, 0.22689280275926282F, 0.0F);
		this.lAntler06 = new ModelRenderer(this, 117, 0);
		this.lAntler06.mirror = true;
		this.lAntler06.setRotationPoint(0.0F, -0.1F, -1.6F);
		this.lAntler06.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(this.lAntler06, 0.3490658503988659F, 0.22689280275926282F, -0.3141592653589793F);
		this.rAntler08 = new ModelRenderer(this, 117, 0);
		this.rAntler08.mirror = true;
		this.rAntler08.setRotationPoint(0.0F, -0.1F, -2.5F);
		this.rAntler08.addBox(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(this.rAntler08, 0.593411945678072F, 0.0F, 0.3141592653589793F);
		this.rAntler09 = new ModelRenderer(this, 117, 0);
		this.rAntler09.setRotationPoint(0.0F, -1.8F, 0.0F);
		this.rAntler09.addBox(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(this.rAntler09, 0.0F, 0.0F, 0.3490658503988659F);
		this.rAntler02 = new ModelRenderer(this, 117, 0);
		this.rAntler02.mirror = true;
		this.rAntler02.setRotationPoint(0.0F, 0.3F, -2.1F);
		this.rAntler02.addBox(-0.5F, -6.0F, -0.5F, 1, 6, 1, 0.0F);
		this.setRotateAngle(this.rAntler02, 0.6981317007977318F, 0.17453292519943295F, -0.20943951023931953F);
		this.rEar = new ModelRenderer(this, 0, 13);
		this.rEar.mirror = true;
		this.rEar.setRotationPoint(-1.8F, -1.0F, -3.0F);
		this.rEar.addBox(-1.0F, -0.7F, -3.1F, 2, 1, 3, 0.0F);
		this.setRotateAngle(this.rEar, 0.2617993877991494F, 1.1519173063162573F, 0.3665191429188092F);
		this.rAntler06 = new ModelRenderer(this, 117, 0);
		this.rAntler06.setRotationPoint(0.0F, -0.1F, -1.6F);
		this.rAntler06.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(this.rAntler06, 0.3490658503988659F, -0.22689280275926282F, 0.3141592653589793F);
		this.rHindLeg02 = new ModelRenderer(this, 65, 15);
		this.rHindLeg02.mirror = true;
		this.rHindLeg02.setRotationPoint(-1.4F, 5.0F, -1.1F);
		this.rHindLeg02.addBox(-1.5F, 0.0F, -1.5F, 3, 7, 3, 0.0F);
		this.setRotateAngle(this.rHindLeg02, 0.9105382707654417F, 0.0F, 0.0F);
		this.lAntler05 = new ModelRenderer(this, 117, 0);
		this.lAntler05.setRotationPoint(0.2F, 0.0F, -4.6F);
		this.lAntler05.addBox(-3.0F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
		this.setRotateAngle(this.lAntler05, 0.0F, -0.6981317007977318F, 0.0F);
		this.rAntler11 = new ModelRenderer(this, 117, 0);
		this.rAntler11.mirror = true;
		this.rAntler11.setRotationPoint(-0.1F, 0.0F, -2.7F);
		this.rAntler11.addBox(-0.5F, -0.5F, -2.0F, 1, 1, 2, 0.0F);
		this.setRotateAngle(this.rAntler11, 0.0F, -0.5235987755982988F, 0.0F);
		this.rAntler10 = new ModelRenderer(this, 117, 0);
		this.rAntler10.setRotationPoint(0.0F, -0.9F, 0.0F);
		this.rAntler10.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F);
		this.setRotateAngle(this.rAntler10, 0.4363323129985824F, 0.4363323129985824F, 0.22689280275926282F);
		this.lAntler10 = new ModelRenderer(this, 117, 0);
		this.lAntler10.mirror = true;
		this.lAntler10.setRotationPoint(0.0F, -0.9F, 0.0F);
		this.lAntler10.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F);
		this.setRotateAngle(this.lAntler10, 0.4363323129985824F, -0.4363323129985824F, -0.22689280275926282F);
		this.lAntler07 = new ModelRenderer(this, 117, 0);
		this.lAntler07.mirror = true;
		this.lAntler07.setRotationPoint(0.0F, -2.8F, 0.0F);
		this.lAntler07.addBox(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(this.lAntler07, 0.0F, 0.0F, -0.3490658503988659F);
		this.ass = new ModelRenderer(this, 0, 35);
		this.ass.setRotationPoint(0.0F, -0.3F, 12.3F);
		this.ass.addBox(-3.5F, -3.5F, 0.0F, 7, 8, 6, 0.0F);
		this.setRotateAngle(this.ass, -0.18203784098300857F, 0.0F, 0.0F);
		this.lHindLeg01 = new ModelRenderer(this, 64, 0);
		this.lHindLeg01.setRotationPoint(2.5F, -1.1F, 3.3F);
		this.lHindLeg01.addBox(0.0F, -1.9F, -2.0F, 3, 8, 5, 0.0F);
		this.setRotateAngle(this.lHindLeg01, -0.22759093446006054F, 0.0F, 0.0F);
		this.lForeleg03 = new ModelRenderer(this, 50, 25);
		this.lForeleg03.setRotationPoint(0.0F, 2.7F, 0.0F);
		this.lForeleg03.addBox(-1.0F, 0.0F, -1.0F, 2, 9, 2, 0.0F);
		this.setRotateAngle(this.lForeleg03, -0.136659280431156F, 0.0F, 0.0F);
		this.lAntler15 = new ModelRenderer(this, 117, 0);
		this.lAntler15.setRotationPoint(0.0F, 2.8F, 0.0F);
		this.lAntler15.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(this.lAntler15, -0.3141592653589793F, 0.0F, 0.3665191429188092F);
		this.rAntler05 = new ModelRenderer(this, 117, 0);
		this.rAntler05.mirror = true;
		this.rAntler05.setRotationPoint(-0.2F, 0.0F, -4.6F);
		this.rAntler05.addBox(0.0F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
		this.setRotateAngle(this.rAntler05, 0.0F, 0.6981317007977318F, 0.0F);
		this.lForeleg02 = new ModelRenderer(this, 48, 14);
		this.lForeleg02.setRotationPoint(0.8F, 4.4F, 0.1F);
		this.lForeleg02.addBox(-1.0F, 0.0F, -1.5F, 2, 3, 3, 0.0F);
		this.setRotateAngle(this.lForeleg02, 0.0F, 0.0F, 0.091106186954104F);
		this.lAntler08 = new ModelRenderer(this, 117, 0);
		this.lAntler08.setRotationPoint(0.0F, -0.1F, -2.5F);
		this.lAntler08.addBox(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(this.lAntler08, 0.593411945678072F, 0.0F, -0.3141592653589793F);
		this.mane04 = new ModelRenderer(this, 72, 50);
		this.mane04.setRotationPoint(0.0F, 1.8F, -3.1F);
		this.mane04.addBox(-3.0F, -1.0F, 0.0F, 6, 2, 6, 0.0F);
		this.setRotateAngle(this.mane04, -0.767944870877505F, 0.0F, 0.0F);
		this.lEar = new ModelRenderer(this, 0, 13);
		this.lEar.setRotationPoint(1.8F, -1.0F, -3.0F);
		this.lEar.addBox(-1.0F, -0.7F, -3.1F, 2, 1, 3, 0.0F);
		this.setRotateAngle(this.lEar, 0.2617993877991494F, -1.1519173063162573F, -0.3665191429188092F);
		this.rAntler01 = new ModelRenderer(this, 117, 0);
		this.rAntler01.mirror = true;
		this.rAntler01.setRotationPoint(-1.1F, 1.0F, -3.5F);
		this.rAntler01.addBox(-0.5F, -0.5F, -2.5F, 1, 1, 3, 0.0F);
		this.setRotateAngle(this.rAntler01, -0.2792526803190927F, 0.4363323129985824F, 0.0F);
		this.lAntler03 = new ModelRenderer(this, 117, 0);
		this.lAntler03.setRotationPoint(0.0F, -5.7F, 0.1F);
		this.lAntler03.addBox(-0.5F, -0.5F, -2.0F, 1, 1, 2, 0.0F);
		this.setRotateAngle(this.lAntler03, -0.9075712110370513F, 0.22689280275926282F, 0.22689280275926282F);
		this.lAntler12 = new ModelRenderer(this, 117, 0);
		this.lAntler12.mirror = true;
		this.lAntler12.setRotationPoint(0.1F, 0.0F, -1.7F);
		this.lAntler12.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F);
		this.setRotateAngle(this.lAntler12, -0.3665191429188092F, 0.5235987755982988F, 0.0F);
		this.lAntler14 = new ModelRenderer(this, 117, 0);
		this.lAntler14.setRotationPoint(0.0F, 0.4F, -0.3F);
		this.lAntler14.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(this.lAntler14, -0.19198621771937624F, 0.0F, 0.0F);
		this.lHindLeg03.addChild(this.lHindHoof);
		this.neck.addChild(this.mane02);
		this.lAntler01.addChild(this.lAntler02);
		this.lAntler10.addChild(this.lAntler11);
		this.ass.addChild(this.rHindLeg01);
		this.head.addChild(this.lowerJaw);
		this.head.addChild(this.snout);
		this.body.addChild(this.bodyFur);
		this.head.addChild(this.lAntler01);
		this.rAntler03.addChild(this.rAntler04);
		this.lHindLeg02.addChild(this.lHindLeg03);
		this.lAntler14.addChild(this.lAntler16);
		this.rAntler06.addChild(this.rAntler07);
		this.rAntler02.addChild(this.rAntler03);
		this.lForeleg03.addChild(this.lForeHoof);
		this.rForeleg02.addChild(this.rForeleg03);
		this.rAntler14.addChild(this.rAntler15);
		this.rForeleg01.addChild(this.rForeleg02);
		this.ass.addChild(this.tail);
		this.body.addChild(this.chest);
		this.body.addChild(this.rForeleg01);
		this.lAntler11.addChild(this.lAntler13);
		this.rHindLeg02.addChild(this.rHindLeg03);
		this.lAntler08.addChild(this.lAntler09);
		this.neck.addChild(this.mane01);
		this.rAntler11.addChild(this.rAntler12);
		this.neck.addChild(this.head);
		this.rHindLeg03.addChild(this.rHindHoof);
		this.lHindLeg01.addChild(this.lHindLeg02);
		this.rAntler01.addChild(this.rAntler14);
		this.body.addChild(this.lForeleg01);
		this.rForeleg03.addChild(this.rForeHoof);
		this.rAntler11.addChild(this.rAntler13);
		this.rAntler14.addChild(this.rAntler16);
		this.chest.addChild(this.mane03);
		this.chest.addChild(this.neck);
		this.lAntler03.addChild(this.lAntler04);
		this.lAntler03.addChild(this.lAntler06);
		this.rAntler04.addChild(this.rAntler08);
		this.rAntler08.addChild(this.rAntler09);
		this.rAntler01.addChild(this.rAntler02);
		this.head.addChild(this.rEar);
		this.rAntler03.addChild(this.rAntler06);
		this.rHindLeg01.addChild(this.rHindLeg02);
		this.lAntler04.addChild(this.lAntler05);
		this.rAntler10.addChild(this.rAntler11);
		this.rAntler02.addChild(this.rAntler10);
		this.lAntler02.addChild(this.lAntler10);
		this.lAntler06.addChild(this.lAntler07);
		this.body.addChild(this.ass);
		this.ass.addChild(this.lHindLeg01);
		this.lForeleg02.addChild(this.lForeleg03);
		this.lAntler14.addChild(this.lAntler15);
		this.rAntler04.addChild(this.rAntler05);
		this.lForeleg01.addChild(this.lForeleg02);
		this.lAntler04.addChild(this.lAntler08);
		this.chest.addChild(this.mane04);
		this.head.addChild(this.lEar);
		this.head.addChild(this.rAntler01);
		this.lAntler02.addChild(this.lAntler03);
		this.lAntler11.addChild(this.lAntler12);
		this.lAntler01.addChild(this.lAntler14);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
		this.body.render(f5);
	}



	/**
	 * Fixes and offsets a rotation
	 */
	private float updateReindeerRotation(float p_110683_1_, float p_110683_2_, float p_110683_3_)
	{
		float f;

		for (f = p_110683_2_ - p_110683_1_; f < -180.0F; f += 360.0F)
		{
			;
		}

		while (f >= 180.0F)
		{
			f -= 360.0F;
		}

		return p_110683_1_ + p_110683_3_ * f;
	}

	/**
	 * Used for easily adding entity-dependent animations. The second and third float params here are the same second
	 * and third as in the setRotationAngles method.
	 */
	public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime)
	{
		super.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTickTime);
		float f = this.updateReindeerRotation(entitylivingbaseIn.prevRenderYawOffset, entitylivingbaseIn.renderYawOffset, partialTickTime);
		float f1 = this.updateReindeerRotation(entitylivingbaseIn.prevRotationYawHead, entitylivingbaseIn.rotationYawHead, partialTickTime);
		float f2 = entitylivingbaseIn.prevRotationPitch + (entitylivingbaseIn.rotationPitch - entitylivingbaseIn.prevRotationPitch) * partialTickTime;
		float f3 = f1 - f;
		float f4 = f2 * 0.017453292F;

		if (f3 > 20.0F)
		{
			f3 = 20.0F;
		}

		if (f3 < -20.0F)
		{
			f3 = -20.0F;
		}

		if (limbSwingAmount > 0.2F)
		{
			f4 += MathHelper.cos(limbSwing * 0.4F) * 0.15F * limbSwingAmount;
		}

		EntityReindeer entityreindeer = (EntityReindeer)entitylivingbaseIn;
		float f5 = entityreindeer.getGrassEatingAmount(partialTickTime);
		float f6 = entityreindeer.getRearingAmount(partialTickTime);
		float f7 = 1.0F - f6;
		float f8 = entityreindeer.getMouthOpennessAngle(partialTickTime);
		this.body.rotateAngleX = 0.0F;
		float f16 = f3 * 0.017453292F;
		this.body.rotateAngleX = (f6 * -((float)Math.PI / 4F) + f7 * this.body.rotateAngleX) * 0.65F;
		this.chest.rotateAngleX = f6 * (0.2617994F + f4) + f5 * 2.1816616F + (1.0F - Math.max(f6, f5)) * (0.5235988F + f4) - (float) Math.toRadians(55);
		this.snout.rotateAngleX = -0.09424778F * f8;
		this.lowerJaw.rotateAngleX = 0.15707964F * f8;
		this.chest.rotateAngleY = f6 * f3 * 0.017453292F + (1.0F - Math.max(f6, f5)) * f16;
		
        float f9 = (float)entitylivingbaseIn.ticksExisted + partialTickTime;
        float f10 = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI);
        float f11 = f10 * 0.8F * limbSwingAmount;
        float f12 = 0.2617994F * f6;
        float f13 = MathHelper.cos(f9 * 0.6F + (float)Math.PI);
        float f14 = ((-1.0471976F + f13) * f6 + f11 * f7) * 0.8F;
        float f15 = ((-1.0471976F - f13) * f6 + -f11 * f7) * 0.8F;
		
        this.lHindLeg01.rotateAngleX = f12 + -f10 * 0.5F * limbSwingAmount * f7;
        this.rHindLeg01.rotateAngleX = f12 + f10 * 0.5F * limbSwingAmount * f7;
        this.lForeleg01.rotateAngleX = f14;
        this.rForeleg01.rotateAngleX = f15;
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
