package its_meow.betteranimalsplus.client.renderer.TESR;

import java.util.Random;

import its_meow.betteranimalsplus.client.model.ModelHandOfFate;
import its_meow.betteranimalsplus.common.tileentity.TileEntityHandOfFate;
import its_meow.betteranimalsplus.init.TextureRegistry;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderBlockHandOfFate extends TileEntitySpecialRenderer<TileEntityHandOfFate> {
	
	ModelHandOfFate mainModel;
	Random rand = null;


	public RenderBlockHandOfFate() {
		mainModel = new ModelHandOfFate();
		rand = new Random();
	}

	private int i = 0;

	@Override
    public void render(TileEntityHandOfFate tileentity, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
		GlStateManager.pushMatrix();
		GlStateManager.translate(x + 0.5F, y + 1.5F, z + 0.5F);
        GlStateManager.rotate(180, 0, 0, 1);
		this.bindTexture(TextureRegistry.handoffate);
		float rotate = tileentity.getRotation();
        this.mainModel.render((Entity) null,(float) x + 0.5F,(float) y + 1.5F,(float) z + 0.5F, rotate, 0F, 0.0625F);
        
        if(tileentity.isOnFire() && i % 5 == 0) {
        	tileentity.getWorld().spawnParticle(EnumParticleTypes.FLAME, tileentity.getPos().getX() + ((rand.nextFloat() + 0.5F) / 2), tileentity.getPos().getY() + rand.nextFloat(), tileentity.getPos().getZ() + ((rand.nextFloat() + 0.5F) / 2), 0, 0.02F, 0);
        }
        
        if(i == 300) {
        	i = 0;
        }
        i++;
        GlStateManager.popMatrix();
    }
	
}
