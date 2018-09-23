package its_meow.betteranimalsplus.block;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.registry.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;

public class BlockHandOfFate extends Block implements ITileEntityProvider {

	public BlockHandOfFate() {
		super(Material.IRON);
		this.translucent = true;
		this.fullBlock = false;
		this.setRegistryName("handoffate");
		this.setUnlocalizedName("handoffate");
		this.setCreativeTab(BetterAnimalsPlusMod.tab);
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
	public boolean hasTileEntity() {
		return true;
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return null;
	}
	
	public static ItemBlock getItemBlock() {
		return ItemRegistry.itemHandOfFate;
	}

}
