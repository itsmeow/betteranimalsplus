package its_meow.betteranimalsplus.common.block;

import java.awt.List;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.common.item.ItemHirschgeistSkull;
import its_meow.betteranimalsplus.common.tileentity.TileEntityHirschgeistSkull;
import its_meow.betteranimalsplus.init.BlockRegistry;
import its_meow.betteranimalsplus.init.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSkull;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockHirschgeistSkull extends BlockSkull implements ITileEntityProvider {

	public BlockHirschgeistSkull() {
		this.setHardness(1.0F);
		this.setSoundType(SoundType.STONE);
		this.setRegistryName("hirschgeistskull");
		this.setUnlocalizedName("hirschgeistskull");
		this.translucent = true;
		this.fullBlock = false;
		this.setCreativeTab(BetterAnimalsPlusMod.tab);
	}
	
	

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
			EntityPlayer player) {
		return new ItemStack(ItemRegistry.itemHirschgeistSkull, 1);
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
	public boolean canDispenserPlace(World world, BlockPos pos, ItemStack stack) {
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

	public static ItemBlock getItemBlock() {
		return ItemRegistry.itemHirschgeistSkull;
	}

}
