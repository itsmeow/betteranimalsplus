package dev.itsmeow.betteranimalsplus.common.block;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Direction.Axis;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class BlockTurkey extends Block implements IWaterLoggable {

    public static final IntegerProperty BITES = IntegerProperty.create("bites", 0, 7);
    public static final DirectionProperty FACING = HorizontalBlock.FACING;
    protected static final VoxelShape[] X_SHAPES = new VoxelShape[] {
    VoxelShapes.box(0.0625D * 2, 0.0D, 0.0625D * 3, 1D - (0.0625D * 2), 0.0625D * 7D, 1D - (0.0625D * 3)),
    VoxelShapes.box(0.0625D * 2, 0.0D, 0.0625D * 3, 1D - (0.0625D * 2), 0.0625D * 7D, 1D - (0.0625D * 3)),
    VoxelShapes.box(0.0625D * 2, 0.0D, 0.0625D * 3, 1D - (0.0625D * 2), 0.0625D * 7D, 1D - (0.0625D * 3)),
    VoxelShapes.box(0.0625D * 2, 0.0D, 0.0625D * 3, 1D - (0.0625D * 2), 0.0625D * 7D, 1D - (0.0625D * 4)),
    VoxelShapes.box(0.0625D * 2, 0.0D, 0.0625D * 4, 1D - (0.0625D * 2), 0.0625D * 7D, 1D - (0.0625D * 4)),
    VoxelShapes.box(0.0625D * 2, 0.0D, 0.0625D * 4, 1D - (0.0625D * 2), 0.0625D * 5D, 1D - (0.0625D * 4)),
    VoxelShapes.box(0.0625D * 2, 0.0D, 0.0625D * 4, 1D - (0.0625D * 2), 0.0625D * 3D, 1D - (0.0625D * 4)),
    VoxelShapes.box(0.0625D * 2, 0.0D, 0.0625D * 4, 1D - (0.0625D * 2), 0.0625D * 2D, 1D - (0.0625D * 4))
    };
    protected static final VoxelShape[] Y_SHAPES = new VoxelShape[] {
    VoxelShapes.box(0.0625D * 3, 0.0D, 0.0625D * 2, 1D - (0.0625D * 3), 0.0625D * 7D, 1D - (0.0625D * 2)),
    VoxelShapes.box(0.0625D * 3, 0.0D, 0.0625D * 2, 1D - (0.0625D * 3), 0.0625D * 7D, 1D - (0.0625D * 2)),
    VoxelShapes.box(0.0625D * 3, 0.0D, 0.0625D * 2, 1D - (0.0625D * 3), 0.0625D * 7D, 1D - (0.0625D * 2)),
    VoxelShapes.box(0.0625D * 4, 0.0D, 0.0625D * 2, 1D - (0.0625D * 3), 0.0625D * 7D, 1D - (0.0625D * 2)),
    VoxelShapes.box(0.0625D * 4, 0.0D, 0.0625D * 2, 1D - (0.0625D * 4), 0.0625D * 7D, 1D - (0.0625D * 2)),
    VoxelShapes.box(0.0625D * 4, 0.0D, 0.0625D * 2, 1D - (0.0625D * 4), 0.0625D * 5D, 1D - (0.0625D * 2)),
    VoxelShapes.box(0.0625D * 4, 0.0D, 0.0625D * 2, 1D - (0.0625D * 4), 0.0625D * 3D, 1D - (0.0625D * 2)),
    VoxelShapes.box(0.0625D * 4, 0.0D, 0.0625D * 2, 1D - (0.0625D * 4), 0.0625D * 2D, 1D - (0.0625D * 2))
    };

    public BlockTurkey() {
        super(Block.Properties.of(Material.SPONGE));
        this.registerDefaultState(this.stateDefinition.any().setValue(BITES, 0).setValue(FACING, Direction.NORTH).setValue(BlockStateProperties.WATERLOGGED, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return state.getValue(FACING).getAxis() == Axis.X ? X_SHAPES[state.getValue(BITES)] : Y_SHAPES[state.getValue(BITES)];
    }

    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        if(hand == Hand.MAIN_HAND) {
            if(!worldIn.isClientSide) {
                return eat(worldIn, pos, state, player);
            } else {
                ItemStack itemstack = player.getItemInHand(hand);
                return itemstack.isEmpty() ? ActionResultType.FAIL : eat(worldIn, pos, state, player);
            }
        }
        return ActionResultType.FAIL;
    }

    protected ActionResultType eat(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        if(!player.canEat(false)) {
            return ActionResultType.FAIL;
        } else {
            int i = state.getValue(BITES);

            if(i < 7) {
                worldIn.setBlock(pos, state.setValue(BITES, i + 1), 3);
                if(i < 2) {
                    player.getFoodData().eat(2, 0.3F);
                } else {
                    player.getFoodData().eat(4, 0.3F);
                }
            } else {
                worldIn.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                player.getFoodData().eat(4, 0.3F);
            }

            return ActionResultType.CONSUME;
        }
    }

    @Override
    public void onPlace(BlockState state1, World world, BlockPos pos, BlockState state2, boolean unknown) {
        if(!world.getBlockState(pos.below()).isRedstoneConductor(world, pos)) {
            world.destroyBlock(pos, true);
        }
    }

    @Override
    public boolean canDropFromExplosion(BlockState state, IBlockReader world, BlockPos pos, Explosion explosion) {
        return super.canDropFromExplosion(state, world, pos, explosion) && state.getValue(BITES) == 0;
    }

    @Override
    public void onNeighborChange(BlockState state, IWorldReader world, BlockPos pos, BlockPos neighbor) {
        super.onNeighborChange(state, world, pos, neighbor);
        if(!world.getBlockState(neighbor).isRedstoneConductor(world, pos) && pos.below() == neighbor && world instanceof World) {
            ((World) world).destroyBlock(pos, true);
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
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