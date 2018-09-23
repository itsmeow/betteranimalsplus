package its_meow.betteranimalsplus.block;

import java.util.Random;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTrillium extends BlockBush implements ITileEntityProvider {
	
	public BlockTrillium() {
		super(Material.PLANTS);
		this.setRegistryName("trillium");
		this.setUnlocalizedName("trillium");
		this.translucent = true;
		this.fullBlock = false;
		this.setCreativeTab(BetterAnimalsPlusMod.tab);
	}
	
	
	
	
	@Override
	public void onNeighborChange(IBlockAccess world, BlockPos pos, BlockPos neighbor) {
		super.onNeighborChange(world, pos, neighbor);
		if(!world.getBlockState(neighbor).isTopSolid() && pos.down() == neighbor) {
			World world1 = (World) world;
			world1.destroyBlock(pos, true);
		}
	}
	
	
	



	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		super.onBlockAdded(worldIn, pos, state);
		if(!worldIn.getBlockState(pos.down()).isTopSolid()) {
			worldIn.destroyBlock(pos, true);
		}
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
        return new TileEntityTrillium();
    }
}
