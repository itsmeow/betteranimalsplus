package its_meow.betteranimalsplus.entity.render;

import its_meow.betteranimalsplus.entity.miniboss.hirschgeist.EntityHirschgeist;
import its_meow.betteranimalsplus.entity.model.ModelHirschgeistMain;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerHirschgeistGhost implements LayerRenderer<EntityHirschgeist>
{
    private RenderHirschgeist geistRenderer;
    private ModelHirschgeistMain geistModel;

    public LayerHirschgeistGhost(RenderHirschgeist geistRendererIn)
    {
        this.geistRenderer = geistRendererIn;
        this.geistModel = new ModelHirschgeistMain(false);
    }
    
    @Override
    public void doRenderLayer(EntityHirschgeist entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
    	
    	GlStateManager.pushMatrix();

		GlStateManager.enableBlend();
		GlStateManager.enableAlpha();

		GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);


		GlStateManager.depthMask(true);

		int i = 61680;
		int j = i % 65536;
		int k = i / 65536;
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j, (float)k);
		GlStateManager.color(1.0F, 1.0F, 1.0F, entity.isDaytime() ? 0.15F : 1.0F);
		Minecraft.getMinecraft().entityRenderer.setupFogColor(true);
		this.geistModel.setModelAttributes(this.geistRenderer.getMainModel());
		this.geistModel.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        //this.geistModel.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
		Minecraft.getMinecraft().entityRenderer.setupFogColor(false);
		i = entity.getBrightnessForRender();
		j = i % 65536;
		k = i / 65536;
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j, (float)k);
		geistRenderer.setLightmap(entity);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1F);
		GlStateManager.disableBlend();
		GlStateManager.disableAlpha();

		GlStateManager.popMatrix();
		
		/*
		float f = limbSwing;
		float f1 = limbSwingAmount;
		
		if(limbSwingAmount >= 0.65) {
			geistModel.setRotateAngle(geistModel.lArm01Ecto, 0.0F, 0.0F, -0.045553093477052F);
			geistModel.lArm01Ecto.rotateAngleX += MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
			geistModel.setRotateAngle(geistModel.rArm01Ecto, 0.0F, 0.0F, 0.045553093477052F);
			geistModel.rArm01Ecto.rotateAngleX += MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
			geistModel.setRotateAngle(geistModel.rLeg01Ecto, 1.1838568316277536F, 0.0F, 0.136659280431156F);
			geistModel.rLeg01Ecto.rotateAngleX += MathHelper.cos(f * 0.6662F) * 1.4F * f1;
			geistModel.setRotateAngle(geistModel.lLeg01Ecto, 1.1838568316277536F, 0.0F, -0.136659280431156F);
			geistModel.lLeg01Ecto.rotateAngleX += MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		} else {
			geistModel.setRotateAngle(geistModel.lArm01Ecto, 0.0F, 0.0F, -0.045553093477052F);
			geistModel.lArm01Ecto.rotateAngleX += MathHelper.cos(f * 0.6662F) * 1.4F * f1;
			geistModel.setRotateAngle(geistModel.rArm01Ecto, 0.0F, 0.0F, 0.045553093477052F);
			geistModel.rArm01Ecto.rotateAngleX += MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
			geistModel.setRotateAngle(geistModel.rLeg01Ecto, 1.1838568316277536F, 0.0F, 0.136659280431156F);
			geistModel.rLeg01Ecto.rotateAngleX += MathHelper.cos(f * 0.6662F) * 1.4F * f1;
			geistModel.setRotateAngle(geistModel.lLeg01Ecto, 1.1838568316277536F, 0.0F, -0.136659280431156F);
			geistModel.lLeg01Ecto.rotateAngleX += MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
		}
		*/
    	
    }

    public boolean shouldCombineTextures()
    {
        return true;
    }
}