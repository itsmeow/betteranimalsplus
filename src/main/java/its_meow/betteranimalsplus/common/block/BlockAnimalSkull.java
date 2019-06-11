package its_meow.betteranimalsplus.common.block;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockAnimalSkull extends ContainerBlock {

    public static final DirectionProperty FACING_EXCEPT_DOWN = DirectionProperty.create("facing", Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST, Direction.UP);
    private static final Map<Direction, VoxelShape> SHAPES = Maps
            .newEnumMap(ImmutableMap.of(
                    Direction.NORTH, Block.makeCuboidShape(4.0D, 4.0D, 8.0D, 12.0D, 12.0D, 16.0D),
                    Direction.SOUTH, Block.makeCuboidShape(4.0D, 4.0D, 0.0D, 12.0D, 12.0D, 8.0D), 
                    Direction.EAST, Block.makeCuboidShape(0.0D, 4.0D, 4.0D, 8.0D, 12.0D, 12.0D), 
                    Direction.WEST, Block.makeCuboidShape(8.0D, 4.0D, 4.0D, 16.0D, 12.0D, 12.0D), 
                    Direction.UP, Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D)));

    public BlockAnimalSkull() {
        super(Block.Properties.create(Material.WOOL).sound(SoundType.STONE).hardnessAndResistance(0.8F));
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING_EXCEPT_DOWN, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos,
            ISelectionContext ctx) {
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
    @OnlyIn(Dist.CLIENT)
    public boolean hasCustomBreakingProgress(BlockState state) {
        return true;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockState iblockstate = this.getDefaultState();
        IBlockReader iblockreader = context.getWorld();
        BlockPos blockpos = context.getPos();
        Direction[] aenumfacing = context.getNearestLookingDirections();

        for (Direction enumfacing : aenumfacing) {
            Direction enumfacing1 = enumfacing.getOpposite();
            iblockstate = iblockstate.with(FACING_EXCEPT_DOWN, enumfacing1);
            if (!iblockreader.getBlockState(blockpos.offset(enumfacing)).isReplaceable(context)) {
                return iblockstate;
            }
        }

        return null;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING_EXCEPT_DOWN);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.with(FACING_EXCEPT_DOWN, rotation.rotate(state.get(FACING_EXCEPT_DOWN)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.toRotation(state.get(FACING_EXCEPT_DOWN)));
    }

    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return null;
    }

}
