package its_meow.betteranimalsplus.block.render;

import its_meow.betteranimalsplus.block.TileEntityHandOfFate;
import its_meow.betteranimalsplus.entity.model.ModelHandOfFate;
import its_meow.betteranimalsplus.registry.TextureRegistry;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;

public class RenderBlockHandOfFate extends TileEntitySpecialRenderer<TileEntityHandOfFate> {
	
	ModelHandOfFate mainModel;


	public RenderBlockHandOfFate() {
		mainModel = new ModelHandOfFate();
	}



	@Override
    public void render(TileEntityHandOfFate tileentity, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
		GlStateManager.pushMatrix();
        GlStateManager.translate(x+ 0.5F,y + 1.5F, z + 0.5F);
        GlStateManager.rotate(180, 0, 0, 1);
        this.bindTexture(TextureRegistry.handoffate);
        this.mainModel.render((Entity) null, 0F, 0F, 0F, 0F, 0F, 0.0625F);
        GlStateManager.popMatrix();
    }
	
}
