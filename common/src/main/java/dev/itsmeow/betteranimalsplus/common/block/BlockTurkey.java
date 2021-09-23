package dev.itsmeow.betteranimalsplus.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BlockTurkey extends Block implements SimpleWaterloggedBlock {

    public static final IntegerProperty BITES = IntegerProperty.create("bites", 0, 7);
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    protected static final VoxelShape[] X_SHAPES = new VoxelShape[]{
            Shapes.box(0.0625D * 2, 0.0D, 0.0625D * 3, 1D - (0.0625D * 2), 0.0625D * 7D, 1D - (0.0625D * 3)),
            Shapes.box(0.0625D * 2, 0.0D, 0.0625D * 3, 1D - (0.0625D * 2), 0.0625D * 7D, 1D - (0.0625D * 3)),
            Shapes.box(0.0625D * 2, 0.0D, 0.0625D * 3, 1D - (0.0625D * 2), 0.0625D * 7D, 1D - (0.0625D * 3)),
            Shapes.box(0.0625D * 2, 0.0D, 0.0625D * 3, 1D - (0.0625D * 2), 0.0625D * 7D, 1D - (0.0625D * 4)),
            Shapes.box(0.0625D * 2, 0.0D, 0.0625D * 4, 1D - (0.0625D * 2), 0.0625D * 7D, 1D - (0.0625D * 4)),
            Shapes.box(0.0625D * 2, 0.0D, 0.0625D * 4, 1D - (0.0625D * 2), 0.0625D * 5D, 1D - (0.0625D * 4)),
            Shapes.box(0.0625D * 2, 0.0D, 0.0625D * 4, 1D - (0.0625D * 2), 0.0625D * 3D, 1D - (0.0625D * 4)),
            Shapes.box(0.0625D * 2, 0.0D, 0.0625D * 4, 1D - (0.0625D * 2), 0.0625D * 2D, 1D - (0.0625D * 4))
    };
    protected static final VoxelShape[] Y_SHAPES = new VoxelShape[]{
            Shapes.box(0.0625D * 3, 0.0D, 0.0625D * 2, 1D - (0.0625D * 3), 0.0625D * 7D, 1D - (0.0625D * 2)),
            Shapes.box(0.0625D * 3, 0.0D, 0.0625D * 2, 1D - (0.0625D * 3), 0.0625D * 7D, 1D - (0.0625D * 2)),
            Shapes.box(0.0625D * 3, 0.0D, 0.0625D * 2, 1D - (0.0625D * 3), 0.0625D * 7D, 1D - (0.0625D * 2)),
            Shapes.box(0.0625D * 4, 0.0D, 0.0625D * 2, 1D - (0.0625D * 3), 0.0625D * 7D, 1D - (0.0625D * 2)),
            Shapes.box(0.0625D * 4, 0.0D, 0.0625D * 2, 1D - (0.0625D * 4), 0.0625D * 7D, 1D - (0.0625D * 2)),
            Shapes.box(0.0625D * 4, 0.0D, 0.0625D * 2, 1D - (0.0625D * 4), 0.0625D * 5D, 1D - (0.0625D * 2)),
            Shapes.box(0.0625D * 4, 0.0D, 0.0625D * 2, 1D - (0.0625D * 4), 0.0625D * 3D, 1D - (0.0625D * 2)),
            Shapes.box(0.0625D * 4, 0.0D, 0.0625D * 2, 1D - (0.0625D * 4), 0.0625D * 2D, 1D - (0.0625D * 2))
    };

    public BlockTurkey() {
        super(Block.Properties.of(Material.SPONGE));
        this.registerDefaultState(this.stateDefinition.any().setValue(BITES, 0).setValue(FACING, Direction.NORTH).setValue(BlockStateProperties.WATERLOGGED, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return state.getValue(FACING).getAxis() == Axis.X ? X_SHAPES[state.getValue(BITES)] : Y_SHAPES[state.getValue(BITES)];
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (hand == InteractionHand.MAIN_HAND) {
            if (!worldIn.isClientSide) {
                return eat(worldIn, pos, state, player);
            } else {
                ItemStack itemstack = player.getItemInHand(hand);
                return itemstack.isEmpty() ? InteractionResult.FAIL : eat(worldIn, pos, state, player);
            }
        }
        return InteractionResult.FAIL;
    }

    protected InteractionResult eat(Level worldIn, BlockPos pos, BlockState state, Player player) {
        if (!player.canEat(false)) {
            return InteractionResult.FAIL;
        } else {
            int i = state.getValue(BITES);

            if (i < 7) {
                worldIn.setBlock(pos, state.setValue(BITES, i + 1), 3);
                if (i < 2) {
                    player.getFoodData().eat(2, 0.3F);
                } else {
                    player.getFoodData().eat(4, 0.3F);
                }
            } else {
                worldIn.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                player.getFoodData().eat(4, 0.3F);
            }

            return InteractionResult.CONSUME;
        }
    }

    @Override
    public void onPlace(BlockState state1, Level world, BlockPos pos, BlockState state2, boolean unknown) {
        if (!world.getBlockState(pos.below()).isRedstoneConductor(world, pos)) {
            world.destroyBlock(pos, true);
        }
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos neighbor, boolean bl) {
        super.neighborChanged(state, level, pos, block, neighbor, bl);
        if (!level.getBlockState(neighbor).isRedstoneConductor(level, pos) && pos.below() == neighbor) {
            level.destroyBlock(pos, true);
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection()).setValue(BlockStateProperties.WATERLOGGED, context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(BlockStateProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) : Fluids.EMPTY.defaultFluidState();
    }

    @Override
    protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
        builder.add(BITES, FACING, BlockStateProperties.WATERLOGGED);
    }

}