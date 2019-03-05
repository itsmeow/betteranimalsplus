package its_meow.betteranimalsplus.client.renderer.tileentity;

import java.awt.Color;

import its_meow.betteranimalsplus.client.model.ModelTrillium;
import its_meow.betteranimalsplus.client.model.ModelTrilliumMulti;
import its_meow.betteranimalsplus.client.model.ModelTrilliumMulti2;
import its_meow.betteranimalsplus.common.tileentity.TileEntityTrillium;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.entity.Entity;

public class RenderBlockTrillium extends TileEntityRenderer<TileEntityTrillium> {

	public static ModelTrillium singleT = new ModelTrillium();
	public static ModelTrilliumMulti doubleT = new ModelTrilliumMulti();
	public static ModelTrilliumMulti2 tripleT = new ModelTrilliumMulti2();

	@Override
	public void render(TileEntityTrillium tileentity, double x, double y, double z, float partialTicks,
			int destroyStage) {
		float rotate = 0F;
		if(!tileentity.getWorld().isAirBlock(tileentity.getPos())) {
			rotate = tileentity.getRotation();
		}
		int modelNum = tileentity.getModelNum();
		ModelBase mainModel = (modelNum == 0 ? doubleT : (modelNum == 1 ? singleT : tripleT));

		GlStateManager.pushMatrix();
		{
			GlStateManager.translated(x + 0.5F, y + 1.5F, z + 0.5F);
			GlStateManager.rotatef(180, 0, 0, 1);

			GlStateManager.pushMatrix();
			{
				Color color = new Color(tileentity.getWorld().getBiome(tileentity.getPos()).getGrassColor(tileentity.getPos()));
				float r = color.getRed() / 255F;
				float g = color.getGreen() / 255F;
				float b = color.getBlue() / 255F;
				r -= 20F / 255F;
				g -= 20F / 255F;
				b -= 20F / 255F;
				r = r > 255F ? 250F : r;
				g = g > 255F ? 250F : g;
				b = b > 255F ? 250F : b;
				GlStateManager.color3f(r, g, b);
				this.bindTexture(ModTextures.trillium_base);
				mainModel.render((Entity) null, 0F, 0F, 0F, rotate, 0F, 0.0625F);
				GlStateManager.color3f(1.0F, 1.0F, 1.0F);
			}
			GlStateManager.popMatrix();

			GlStateManager.pushMatrix();
			{
				this.bindTexture(tileentity.getTexture());
				mainModel.render((Entity) null, 0F, 0F, 0F, rotate, 0F, 0.0625F);
			}
			GlStateManager.popMatrix();
		}
		GlStateManager.popMatrix();
	}


}
