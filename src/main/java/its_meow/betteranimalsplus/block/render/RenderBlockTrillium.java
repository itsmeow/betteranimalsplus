package its_meow.betteranimalsplus.block.render;

import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.block.TileEntityTrillium;
import its_meow.betteranimalsplus.entity.model.ModelTrilliumMulti;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderBlockTrillium extends TileEntitySpecialRenderer<TileEntityTrillium> {
	
	ModelTrilliumMulti mainModel;

    public static final ResourceLocation loc1 = new ResourceLocation(Ref.MOD_ID, "textures/entities/flora/trillium.png");
    public static final ResourceLocation loc2 = new ResourceLocation(Ref.MOD_ID, "textures/entities/flora/trillium_2.png");

	public RenderBlockTrillium() {
		mainModel = new ModelTrilliumMulti();
	}



	@Override
    public void render(TileEntityTrillium tileentity, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
		GlStateManager.pushMatrix();
        GlStateManager.translate(x+ 0.5F,y + 3.0F, z + 0.5F);
        GlStateManager.rotate(180, 0, 0, 1);
        //If you want to randomly choose the color of this plant, do it via the Tile Entity instance.
        //Save it there via NBT Tag and get the type from it. Even constructing something as simple as a 
        //new Random instance will hog tons of memory, because you're creating that instance X amount of 
        //times per second, where X is the refresh rate of your display.
        this.bindTexture(loc1);
        this.mainModel.render((Entity) null, 0F, 0F, 0F, 0F, 0F, 0.125F);
        GlStateManager.popMatrix();
    }


	
}
