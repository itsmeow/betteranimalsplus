package its_meow.betteranimalsplus.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;

import its_meow.betteranimalsplus.client.model.ModelLamprey;
import its_meow.betteranimalsplus.common.entity.EntityLamprey;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderLamprey extends MobRenderer<EntityLamprey, ModelLamprey<EntityLamprey>> {

	public RenderLamprey(EntityRendererManager rendermanager) {
		super(rendermanager, new ModelLamprey<EntityLamprey>(), 0.4F);
	}

	@Override
	protected void preRenderCallback(EntityLamprey entity, MatrixStack matrixStackIn, float partialTickTime) {
	    matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		
		if(entity.getRidingEntity() != null) {
		    matrixStackIn.rotate(Vector3f.YP.rotationDegrees(180F));
		    matrixStackIn.translate(0, 0, 0.5F);
		}
	}

	@Override
	public ResourceLocation getEntityTexture(EntityLamprey entity) {
		int type = entity.getTypeNumber();
		switch(type) {
		case 1: return ModTextures.lamprey_1;
		case 2: return ModTextures.lamprey_2;
		case 3: return ModTextures.lamprey_3;
		default: return ModTextures.lamprey_1;
		}
	}

}
