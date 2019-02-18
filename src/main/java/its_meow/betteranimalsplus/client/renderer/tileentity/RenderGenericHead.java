package its_meow.betteranimalsplus.client.renderer.tileentity;

import its_meow.betteranimalsplus.common.tileentity.TileEntityHead;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderGenericHead extends TileEntityRenderer<TileEntityHead> {

	@Override
	public void render(TileEntityHead tile, double x, double y, double z, float partialTickTime, int destroyStage) {
		renderHead((float) x, (float) y, (float) z, tile.getRotationX(), tile.getSkullRotation() * 360 / 16.0F, tile.getBlockFacing(), tile.getModel(), destroyStage, tile.getTexture());
	}

	private void renderHead(float x, float y, float z, float rotX, float skullRotation, EnumFacing face, ModelBase model, int destroyStage, ResourceLocation texture) {
		this.bindTexture(texture);

		GlStateManager.pushMatrix();

		this.translateHead(x, y, z, face, 1.5F);

		float newRotation = skullRotation;
		float skullRotationX = rotX;

		GlStateManager.scalef(-1.0F, -1.0F, 1.0F);

		model.render((Entity) null, newRotation, skullRotationX, 0, 0, 0, 0.0625F);

		GlStateManager.popMatrix();
	}

	private void translateHead(float x, float y, float z, EnumFacing face, float yOffset) {
		switch (face) {
		case NORTH:
			GlStateManager.translatef(x + 0.5F, y + yOffset, z + 0.5F);
			break;
		case EAST:
			GlStateManager.translatef(x + 0.5F, y + 0.25F + yOffset + 0.3F, z + 0.74F + 0.25F);
			break;
		case SOUTH:
			GlStateManager.translatef(x + 0.5F, y + 0.25F + yOffset + 0.3F, z + 0.26F - 0.25F);
			break;
		case WEST:
			GlStateManager.translatef(x + 0.74F + 0.25F, y + 0.25F + yOffset + 0.3F, z + 0.5F);
			break;
		default:
			GlStateManager.translatef(x + 0.26F - 0.25F, y + 0.25F + yOffset + 0.3F, z + 0.5F);
			break;
		}
	}

}
