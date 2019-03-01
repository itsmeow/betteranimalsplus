package its_meow.betteranimalsplus.common.block;

import javax.annotation.Nullable;

import its_meow.betteranimalsplus.common.tileentity.TileEntityHead;
import net.minecraft.block.BlockSkull;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
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
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.INVISIBLE;
	}

	@Override
	public void getDrops(IBlockState state, NonNullList<ItemStack> drops, World world, BlockPos pos, int fortune) {
		TileEntity te = world.getTileEntity(pos);
		if (te instanceof TileEntityHead) {
			TileEntityHead head = (TileEntityHead)te;
			if (head.shouldDrop()) {
				ItemStack ret = new ItemStack(this.asItem());
				drops.add(ret);
			}
		}
	}

	@Override
	public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state,
			@Nullable TileEntity te, ItemStack stack) {
		if (!worldIn.isRemote && player.abilities.isCreativeMode) {
			TileEntityHead.disableDrop(worldIn, pos);
		}
		player.addExhaustion(0.005F);
	}

}
