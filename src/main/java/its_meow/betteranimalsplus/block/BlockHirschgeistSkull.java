package its_meow.betteranimalsplus.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSkull;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;

public class BlockHirschgeistSkull extends BlockSkull implements ITileEntityProvider {

	public BlockHirschgeistSkull() {
		this.setRegistryName("hirschgeistskull");
		this.setUnlocalizedName("hirschgeistskull");
		this.translucent = true;
		this.fullBlock = false;
		this.setCreativeTab(CreativeTabs.DECORATIONS);
	}
	
	@Override
	public boolean hasTileEntity() {
		return true;
	}



	@Override
    public boolean isOpaqueCube(IBlockState state) { 
		return false; 
	}

    @Override
    public boolean isFullCube(IBlockState state) { 
    	return false; 
    }
    
    @Override
    public boolean isTopSolid(IBlockState state) {
    	return false;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.INVISIBLE;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityHirschgeistSkull();
    }
	
}
