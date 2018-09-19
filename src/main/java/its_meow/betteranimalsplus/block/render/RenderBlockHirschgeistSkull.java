package its_meow.betteranimalsplus.block.render;

import org.lwjgl.opengl.GL11;

import com.mojang.authlib.GameProfile;

import its_meow.betteranimalsplus.block.TileEntityHirschgeistSkull;
import its_meow.betteranimalsplus.entity.model.ModelHirschgeistSkull;
import its_meow.betteranimalsplus.registry.TextureRegistry;
import net.minecraft.block.BlockDirectional;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

@SideOnly(Side.CLIENT)
public class RenderBlockHirschgeistSkull extends TileEntitySpecialRenderer<TileEntityHirschgeistSkull> {

	ModelHirschgeistSkull model;

	@Override
	public void render(TileEntityHirschgeistSkull tile, double x, double y, double z, float partialTickTime, int destroyStage, float alpha) {
		renderHead((float) x, (float) y, (float) z, tile.getBlockMetadata() & 7, tile.getSkullRotation() * 360 / 16.0F, tile.getPlayerProfile(), tile.getModel(), destroyStage);
	}

	private void renderHead(float x, float y, float z, int meta, float skullRotation, GameProfile profile, ModelHirschgeistSkull model, int destroyStage) {

		this.bindTexture(TextureRegistry.hirschgeist);

		GlStateManager.pushMatrix();

		this.translateHead(x, y, z, meta, 1.5F);

		skullRotation = adjustRotation(meta, skullRotation);
		float skullRotationX = adjustRotationX(meta);

		GlStateManager.scale(-1.0F, -1.0F, 1.0F);

		model.render((Entity) null, skullRotation, skullRotationX, 0, 0, 0, 0.0625F);

		GlStateManager.popMatrix();
	}

	private void translateHead(float x, float y, float z, int meta, float yOffset) {
		switch (meta) {
		case 1:
			GlStateManager.translate(x + 0.5F, y + yOffset, z + 0.5F);
			break;
		case 2:
			GlStateManager.translate(x + 0.5F, y + 0.25F + yOffset + 0.3F, z + 0.74F + 0.25F);
			break;
		case 3:
			GlStateManager.translate(x + 0.5F, y + 0.25F + yOffset + 0.3F, z + 0.26F - 0.25F);
			break;
		case 4:
			GlStateManager.translate(x + 0.74F + 0.25F, y + 0.25F + yOffset + 0.3F, z + 0.5F);
			break;
		default:
			GlStateManager.translate(x + 0.26F - 0.25F, y + 0.25F + yOffset + 0.3F, z + 0.5F);
			break;
		}
	}

	private float adjustRotation(int meta, float rotation) {
		switch (meta) {
		case 1:
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
	
	private float adjustRotationX(int meta) {
		if(meta != 1) {
			return 0.0F;
		}
		return -90F;
	}





	/*
	@Override
    public void render(TileEntityHirschgeistSkull tileentity, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
		GlStateManager.pushMatrix();
        GlStateManager.translate(x+ 0.5F,y + 1.5F, z + 0.5F);
        GlStateManager.rotate(180, 0, 0, 1);
        World world = tileentity.getWorld();
        Comparable facing = world.getBlockState(tileentity.getPos()).getProperties().get(BlockDirectional.FACING);
        if(facing == EnumFacing.NORTH) {
        	GlStateManager.rotate(90, 0, 1, 0);
        }
        if(facing == EnumFacing.EAST) {

        }
        if(facing == EnumFacing.WEST) {

        }
        if(facing == EnumFacing.SOUTH) {

        }
        this.bindTexture(TextureRegistry.hirschgeist);
        this.mainModel.render((Entity) null, 0F, 0F, 0F, 0F, 0F, 0.0625F);
        GlStateManager.popMatrix();
    }
	 */

}
