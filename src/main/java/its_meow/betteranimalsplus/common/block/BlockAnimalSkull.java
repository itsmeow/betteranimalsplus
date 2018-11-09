package its_meow.betteranimalsplus.common.block;

import java.util.Random;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import net.minecraft.block.BlockSkull;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockAnimalSkull extends BlockSkull implements ITileEntityProvider {

	public BlockAnimalSkull() {
		this.setHardness(1.0F);
		this.setSoundType(SoundType.STONE);
		this.translucent = true;
		this.fullBlock = false;
		this.setCreativeTab(BetterAnimalsPlusMod.tab);
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
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
			EntityPlayer player) {
		return new ItemStack(this.getItemBlock(), 1);
	}

	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(this.getItemBlock(), 1);
	}


	public void getDrops(net.minecraft.util.NonNullList<ItemStack> drops, IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune)
	{
		if (!((Boolean)state.getValue(NODROP)).booleanValue())
		{
			drops.add(new ItemStack(this.getItemBlock(), 1));
		}
	}

	/**
	 * Get the Item that this Block should drop when harvested.
	 */
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return this.getItemBlock();
	}


	public ItemBlock getItemBlock() {
		return null;
	}
}
