package its_meow.betteranimalsplus.block;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityTrillium extends TileEntity {

	public TileEntityTrillium(World world, IBlockState state) {
		this.world = world;
		this.blockType = state.getBlock();
	}

}
