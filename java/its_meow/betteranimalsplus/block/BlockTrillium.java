package its_meow.betteranimalsplus.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlockTrillium extends Block {

	public BlockTrillium() {
		super(Material.PLANTS);
		this.setRegistryName("trillium");
		this.setUnlocalizedName("trillium");
		this.translucent = true;
		this.fullBlock = false;
	}

	
	@Override
    public boolean isOpaqueCube(IBlockState state) { return false; }

    @Override
    public boolean isFullCube(IBlockState state) { return false; }
}
