package its_meow.betteranimalsplus.common.block;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public abstract class BlockAnimalSkull extends ContainerBlock implements IWaterLoggable {

    public static final DirectionProperty FACING_EXCEPT_DOWN = DirectionProperty.create("facing", Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST, Direction.UP);
    public static final DirectionProperty TOP_FACING = DirectionProperty.create("top", Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST);
    private static final Map<Direction, VoxelShape> SHAPES = Maps.newEnumMap(ImmutableMap.of(
    Direction.NORTH, Block.makeCuboidShape(4.0D, 4.0D, 8.0D, 12.0D, 12.0D, 16.0D),
    Direction.SOUTH, Block.makeCuboidShape(4.0D, 4.0D, 0.0D, 12.0D, 12.0D, 8.0D),
    Direction.EAST, Block.makeCuboidShape(0.0D, 4.0D, 4.0D, 8.0D, 12.0D, 12.0D),
    Direction.WEST, Block.makeCuboidShape(8.0D, 4.0D, 4.0D, 16.0D, 12.0D, 12.0D),
    Direction.UP, Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D)));

    public BlockAnimalSkull() {
        super(Block.Properties.create(Material.WOOL).sound(SoundType.STONE).hardnessAndResistance(0.8F));
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING_EXCEPT_DOWN, Direction.NORTH).with(BlockStateProperties.WATERLOGGED, false).with(TOP_FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext ctx) {
        return SHAPES.get(state.get(FACING_EXCEPT_DOWN));
    }

    @Override
    public boolean hasTileEntity() {
        return true;
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public boolean isNormalCube(BlockState p_220081_1_, IBlockReader p_220081_2_, BlockPos p_220081_3_) {
        return false;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockState state = this.getDefaultState();
        BlockPos pos = context.getPos();
        Direction[] directions = context.getNearestLookingDirections();

        for(Direction dir : directions) {
            Direction direction = dir.getOpposite();
            if(direction == Direction.DOWN) {
                return null;
            } else if(direction == Direction.UP) {
                state = state.with(TOP_FACING, Direction.fromAngle(context.getPlayer().getRotationYawHead()));
            }
            state = state.with(FACING_EXCEPT_DOWN, direction);
            if(!context.getWorld().getBlockState(pos.offset(dir)).isReplaceable(context)) {
                return state;
            }
        }
        return null;
    }

    @SuppressWarnings("deprecation")
    @Override
    public IFluidState getFluidState(BlockState state) {
        return state.get(BlockStateProperties.WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING_EXCEPT_DOWN, BlockStateProperties.WATERLOGGED, TOP_FACING);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.with(FACING_EXCEPT_DOWN, rotation.rotate(state.get(FACING_EXCEPT_DOWN)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.toRotation(state.get(FACING_EXCEPT_DOWN)));
    }

}
