package its_meow.betteranimalsplus.client.renderer.tileentity;

import its_meow.betteranimalsplus.client.model.ModelTrilliumMulti;
import its_meow.betteranimalsplus.common.tileentity.TileEntityTrillium;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(value = Dist.CLIENT)
public class RenderBlockTrillium extends TileEntityRenderer<TileEntityTrillium> {

	ModelBase mainModel;


	public RenderBlockTrillium() {
		this.mainModel = new ModelTrilliumMulti();
	}


	@Override
	public void render(TileEntityTrillium tileentity, double x, double y, double z, float partialTicks,
			int destroyStage) {
		GlStateManager.pushMatrix();
		GlStateManager.translated(x + 0.5F, y + 1.5F, z + 0.5F);
		GlStateManager.rotatef(180, 0, 0, 1);
		this.bindTexture(tileentity.getTexture());
		this.mainModel = tileentity.getModel();
		float rotate = 0F;
		if(!tileentity.getWorld().isAirBlock(tileentity.getPos())) {
			rotate = tileentity.getRotation();
		}
		this.mainModel.render((Entity) null, 0F, 0F, 0F, rotate, 0F, 0.0625F);
		GlStateManager.popMatrix();
	}


}
