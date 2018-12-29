package its_meow.betteranimalsplus.client.renderer.TESR;

import its_meow.betteranimalsplus.client.model.ModelTrilliumMulti;
import its_meow.betteranimalsplus.common.tileentity.TileEntityTrillium;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderBlockTrillium extends TileEntitySpecialRenderer<TileEntityTrillium> {

	ModelBase mainModel;


	public RenderBlockTrillium() {
		mainModel = new ModelTrilliumMulti();
	}



	@Override
	public void render(TileEntityTrillium tileentity, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
		GlStateManager.pushMatrix();
		GlStateManager.translate(x+ 0.5F,y + 1.5F, z + 0.5F);
		GlStateManager.rotate(180, 0, 0, 1);
		this.bindTexture(tileentity.getTexture());
		mainModel = tileentity.getModel();
		float rotate = 0F;
		if(!tileentity.getWorld().isAirBlock(tileentity.getPos())) {
			rotate = tileentity.getRotation();
		}
		this.mainModel.render((Entity) null, 0F, 0F, 0F, rotate, 0F, 0.0625F);
		GlStateManager.popMatrix();
	}



}
