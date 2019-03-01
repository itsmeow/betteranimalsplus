package its_meow.betteranimalsplus.common.block;

import java.util.Map;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import its_meow.betteranimalsplus.common.tileentity.TileEntityHead;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAbstractSkull;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.NonNullList;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BlockAnimalSkull extends BlockAbstractSkull {

	public static final DirectionProperty FACING = BlockStateProperties.FACING;
	private static final Map<EnumFacing, VoxelShape> SHAPES = Maps.newEnumMap(ImmutableMap.of(EnumFacing.NORTH, Block.makeCuboidShape(4.0D, 4.0D, 8.0D, 12.0D, 12.0D, 16.0D), EnumFacing.SOUTH, Block.makeCuboidShape(4.0D, 4.0D, 0.0D, 12.0D, 12.0D, 8.0D), EnumFacing.EAST, Block.makeCuboidShape(0.0D, 4.0D, 4.0D, 8.0D, 12.0D, 12.0D), EnumFacing.WEST, Block.makeCuboidShape(8.0D, 4.0D, 4.0D, 16.0D, 12.0D, 12.0D), EnumFacing.UP, Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D)));

	public BlockAnimalSkull() {
		super(null, Block.Properties.create(Material.CLOTH).sound(SoundType.STONE).hardnessAndResistance(0.8F));
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

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
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
	public IBlockState rotate(IBlockState p_185499_1_, Rotation p_185499_2_) {
		return (IBlockState) p_185499_1_.with(FACING,
				p_185499_2_.rotate((EnumFacing) p_185499_1_.get(FACING)));
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public IBlockState mirror(IBlockState p_185471_1_, Mirror p_185471_2_) {
		return p_185471_1_.rotate(p_185471_2_.toRotation((EnumFacing) p_185471_1_.get(FACING)));
	}

}
