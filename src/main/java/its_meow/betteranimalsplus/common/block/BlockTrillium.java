package its_meow.betteranimalsplus.common.block;

import its_meow.betteranimalsplus.common.tileentity.TileEntityTrillium;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class BlockTrillium extends BlockHorizontal {

	public BlockTrillium() {
		super(Properties.create(Material.PLANTS).sound(SoundType.PLANT));
		this.setRegistryName("trillium");
		this.setDefaultState(this.getDefaultState().with(BlockHorizontal.HORIZONTAL_FACING, EnumFacing.NORTH));
	}


	@Override
	public void onNeighborChange(IBlockState state, IWorldReader world, BlockPos pos, BlockPos neighbor) {
		super.onNeighborChange(state, world, pos, neighbor);
		if(!world.getBlockState(neighbor).isTopSolid(world, pos) && pos.down() == neighbor) {
			World world1 = (World) world;
			world1.destroyBlock(pos, true);
		}
	}

	@Override
	protected void fillStateContainer(Builder<Block, IBlockState> builder) {
		builder.add(BlockHorizontal.HORIZONTAL_FACING);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onBlockAdded(IBlockState state, World worldIn, BlockPos pos, IBlockState oldState) {
		super.onBlockAdded(state, worldIn, pos, oldState);
		if(!worldIn.getBlockState(pos.down()).isTopSolid(worldIn, pos)) {
			worldIn.destroyBlock(pos, true);
		}
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
		return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
	}

	@Override
	public boolean isNormalCube(IBlockState state) {
		return false;
	}


	@Override
	public boolean isSolid(IBlockState state) {
		return false;
	}
	
	public static boolean isOpaque(VoxelShape shape) {
		return true;
	}


	@Override
	public boolean hasTileEntity() {
		return true;
	}

	@Override
	public TileEntity createTileEntity(IBlockState state, IBlockReader world) {
		return new TileEntityTrillium();
	}
}
