package its_meow.betteranimalsplus.client.renderer.tileentity;

import its_meow.betteranimalsplus.common.tileentity.TileEntityHead;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderGenericHeadFloor extends TileEntityRenderer<TileEntityHead> {

	@Override
	public void render(TileEntityHead tile, double x, double y, double z, float partialTickTime, int destroyStage) {
		this.renderHead((float) x, (float) y, (float) z, tile.getRotationX(), tile.getSkullRotation() * 360 / 16.0F,
				tile.getModel(), destroyStage, tile.getTexture(), tile.getOffset());
	}

	private void renderHead(float x, float y, float z, float meta, float skullRotation, ModelBase model,
			int destroyStage, ResourceLocation texture, float offset) {

		this.bindTexture(texture);

		GlStateManager.pushMatrix();

		this.translateHead(x, y, z, (int) meta, 1.5F + offset);

		float newRotation = this.adjustRotation((int) meta, skullRotation);
		float skullRotationX = this.adjustRotationX(meta);

		GlStateManager.scalef(-1.0F, -1.0F, 1.0F);

		model.render((Entity) null, newRotation, skullRotationX, 0, 0, 0, 0.0625F);

		GlStateManager.popMatrix();
	}

	private void translateHead(float x, float y, float z, int meta, float yOffset) {
		switch(meta) {
		case 1:
			GlStateManager.translatef(x + 0.5F, y + yOffset + 0.15F, z + 0.5F);
			break;
		case 2:
			GlStateManager.translatef(x + 0.5F, y + 0.25F + yOffset + 0.3F, z + 0.74F + 0.25F);
			break;
		case 3:
			GlStateManager.translatef(x + 0.5F, y + 0.25F + yOffset + 0.3F, z + 0.26F - 0.25F);
			break;
		case 4:
			GlStateManager.translatef(x + 0.74F + 0.25F, y + 0.25F + yOffset + 0.3F, z + 0.5F);
			break;
		default:
			GlStateManager.translatef(x + 0.26F - 0.25F, y + 0.25F + yOffset + 0.3F, z + 0.5F);
			break;
		}
	}

	private float adjustRotation(int meta, float rotation) {
		switch(meta) {
		case 1:
			return rotation;
		case 2:
			return rotation;
		case 3:
			return 180.0F;
		case 4:
			return 270.0F;
		default:
			return 90.0F;
		}
	}

	private float adjustRotationX(float meta) {
		if(meta != 1) {
			return 0.0F;
		}
		return 0.0F;
	}

}
