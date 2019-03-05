package its_meow.betteranimalsplus.common.block;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockAnimalSkull extends BlockContainer {

	public static final DirectionProperty FACING = BlockStateProperties.FACING;
	private static final Map<EnumFacing, VoxelShape> SHAPES = Maps.newEnumMap(ImmutableMap.of(EnumFacing.NORTH, Block.makeCuboidShape(4.0D, 4.0D, 8.0D, 12.0D, 12.0D, 16.0D), EnumFacing.SOUTH, Block.makeCuboidShape(4.0D, 4.0D, 0.0D, 12.0D, 12.0D, 8.0D), EnumFacing.EAST, Block.makeCuboidShape(0.0D, 4.0D, 4.0D, 8.0D, 12.0D, 12.0D), EnumFacing.WEST, Block.makeCuboidShape(8.0D, 4.0D, 4.0D, 16.0D, 12.0D, 12.0D), EnumFacing.UP, Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D)));

	public BlockAnimalSkull() {
		super(Block.Properties.create(Material.CLOTH).sound(SoundType.STONE).hardnessAndResistance(0.8F));
		this.setDefaultState((this.stateContainer.getBaseState()).with(FACING, EnumFacing.NORTH));
	}

	public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos) {
		return SHAPES.get(state.get(FACING));
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

	@OnlyIn(Dist.CLIENT)
	public boolean hasCustomBreakingProgress(IBlockState state) {
		return true;
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
	}

	public IBlockState getStateForPlacement(BlockItemUseContext context) {
		IBlockState iblockstate = this.getDefaultState();
		IBlockReader iblockreader = context.getWorld();
		BlockPos blockpos = context.getPos();
		EnumFacing[] aenumfacing = context.getNearestLookingDirections();

		for(EnumFacing enumfacing : aenumfacing) {
			EnumFacing enumfacing1 = enumfacing.getOpposite();
			iblockstate = iblockstate.with(FACING, enumfacing1);
			if (!iblockreader.getBlockState(blockpos.offset(enumfacing)).isReplaceable(context)) {
				return iblockstate;
			}
		}

		return null;
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public IBlockState rotate(IBlockState state, Rotation rotation) {
		return (IBlockState) state.with(FACING,
				rotation.rotate((EnumFacing) state.get(FACING)));
	}

	@SuppressWarnings("deprecation")
	@Override
	public IBlockState mirror(IBlockState state, Mirror mirror) {
		return state.rotate(mirror.toRotation((EnumFacing) state.get(FACING)));
	}

	@Override
	public TileEntity createNewTileEntity(IBlockReader worldIn) {
		return null;
	}

}
