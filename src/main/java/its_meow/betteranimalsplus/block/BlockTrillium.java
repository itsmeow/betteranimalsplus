package its_meow.betteranimalsplus.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockTrillium extends Block {
	
	private TileEntity te;
	
	public BlockTrillium() {
		super(Material.PLANTS);
		this.setRegistryName("trillium");
		this.setUnlocalizedName("trillium");
		this.translucent = true;
		this.fullBlock = false;
		this.setCreativeTab(CreativeTabs.DECORATIONS);
	}
	
	
	
	
	@Override
	public boolean hasTileEntity() {
		return true;
	}



	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return te = new TileEntityTrillium(world, state);
	}
	
	@Override
    public boolean isOpaqueCube(IBlockState state) { 
		return false; 
	}

    @Override
    public boolean isFullCube(IBlockState state) { 
    	return false; 
    }
}
