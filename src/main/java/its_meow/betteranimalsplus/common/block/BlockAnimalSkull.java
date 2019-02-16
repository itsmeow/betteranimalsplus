package its_meow.betteranimalsplus.common.block;

import javax.annotation.Nullable;

import its_meow.betteranimalsplus.common.tileentity.TileEntityHead;
import net.minecraft.block.BlockSkull;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BlockAnimalSkull extends BlockSkull {

	public BlockAnimalSkull() {
		super(null, Properties.create(Material.CLOTH).sound(SoundType.STONE).hardnessAndResistance(0.8F));
	}

	@Override
	public boolean hasTileEntity() {
		return true;
	}

	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
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
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, IBlockReader world, BlockPos pos,
			EntityPlayer player) {
		TileEntity te2 = world.getTileEntity(pos);
		if(te2 instanceof TileEntityHead) {
			TileEntityHead te = (TileEntityHead) te2;
			return new ItemStack(this.getItemBlock(te.typeValue()));
		}
		return null;
	}

	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, IBlockState state) {
		TileEntity te2 = worldIn.getTileEntity(pos);
		if(te2 instanceof TileEntityHead) {
			TileEntityHead te = (TileEntityHead) te2;
			return new ItemStack(this.getItemBlock(te.typeValue()));
		}
		return null;
	}

	@Override
	public void getDrops(IBlockState state, NonNullList<ItemStack> drops, World world, BlockPos pos, int fortune) {
		if(!world.isRemote) {
			TileEntity te2 = world.getTileEntity(pos);
			if(te2 instanceof TileEntityHead) {
				TileEntityHead te = (TileEntityHead) te2;
				Item item = this.getItemBlock(te.typeValue());
				if (item != null && item != Items.AIR) {
					drops.add(new ItemStack(item));
				}
			}
		}
	}

	public ItemBlock getItemBlock(int typeValue) {
		return null;
	}

	/**
	 * Spawns the block's drops in the world. By the time this is called the Block has possibly been set to air via
	 * Block.removedByPlayer
	 */
	public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack)
	{
		player.addExhaustion(0.005F);
	}

	/**
	 * Get the Item that this Block should drop when harvested.
	 */
	@Override
	public Item getItemDropped(IBlockState state, World world, BlockPos pos, int fortune)
	{
		TileEntity te2 = world.getTileEntity(pos);
		if(te2 instanceof TileEntityHead) {
			TileEntityHead te = (TileEntityHead) te2;
			return this.getItemBlock(te.typeValue());
		}
		return null;
	}


	public ItemBlock getItemBlock() {
		return null;
	}
}
