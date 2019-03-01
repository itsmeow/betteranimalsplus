package its_meow.betteranimalsplus.client.renderer.tileentity;

import javax.annotation.Nullable;

import its_meow.betteranimalsplus.common.tileentity.TileEntityHead;
import net.minecraft.block.BlockSkull;
import net.minecraft.block.BlockSkullWall;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class RenderGenericHeadFloor extends TileEntityRenderer<TileEntityHead> {


	public void render(TileEntityHead te, double x, double y, double z, float partialTicks, int destroyStage) {

		IBlockState iblockstate = te.getBlockState();
		boolean flag = iblockstate.getBlock() instanceof BlockSkullWall;
		EnumFacing enumfacing = flag ? iblockstate.get(BlockSkullWall.FACING) : null;
		float f1 = 22.5F * (float)(flag ? (2 + enumfacing.getHorizontalIndex()) * 4 : iblockstate.get(BlockSkull.ROTATION));

		this.render((float)x, (float)y, (float)z, enumfacing, f1, destroyStage, te.getTexture(), te.getModel(), te.getOffset());
	}

	public void render(float x, float y, float z, @Nullable EnumFacing facing, float skullRotation, int destroyStage, ResourceLocation texture, ModelBase model, float yOffset) {
		if (destroyStage >= 0) {
			this.bindTexture(DESTROY_STAGES[destroyStage]);
			GlStateManager.matrixMode(5890);
			GlStateManager.pushMatrix();
			GlStateManager.scalef(4.0F, 2.0F, 1.0F);
			GlStateManager.translatef(0.0625F, 0.0625F, 0.0625F);
			GlStateManager.matrixMode(5888);
		} else {
			this.bindTexture(texture);
		}

		GlStateManager.pushMatrix();
		GlStateManager.disableCull();
		this.translateHead(x, y, z, facing, 1.5F + yOffset);

		GlStateManager.enableRescaleNormal();
		GlStateManager.scalef(-1.0F, -1.0F, 1.0F);
		GlStateManager.enableAlphaTest();

		model.render((Entity)null, skullRotation, facing == EnumFacing.UP ? -90.0F : 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GlStateManager.popMatrix();
		if (destroyStage >= 0) {
			GlStateManager.matrixMode(5890);
			GlStateManager.popMatrix();
			GlStateManager.matrixMode(5888);
		}

	}

	private void translateHead(float x, float y, float z, EnumFacing face, float yOffset) {
		if(face == null) {
			GlStateManager.translatef(x + 0.26F - 0.25F, y + 0.25F + yOffset + 0.3F, z + 0.5F);
			return;
		}
		switch(face) {
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
