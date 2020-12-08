package its_meow.betteranimalsplus.common.block;

import its_meow.betteranimalsplus.Ref;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.IWaterLoggable;
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
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    protected static final VoxelShape[] X_SHAPES = new VoxelShape[] {
    VoxelShapes.create(0.0625D * 2, 0.0D, 0.0625D * 3, 1D - (0.0625D * 2), 0.0625D * 7D, 1D - (0.0625D * 3)),
    VoxelShapes.create(0.0625D * 2, 0.0D, 0.0625D * 3, 1D - (0.0625D * 2), 0.0625D * 7D, 1D - (0.0625D * 3)),
    VoxelShapes.create(0.0625D * 2, 0.0D, 0.0625D * 3, 1D - (0.0625D * 2), 0.0625D * 7D, 1D - (0.0625D * 3)),
    VoxelShapes.create(0.0625D * 2, 0.0D, 0.0625D * 3, 1D - (0.0625D * 2), 0.0625D * 7D, 1D - (0.0625D * 4)),
    VoxelShapes.create(0.0625D * 2, 0.0D, 0.0625D * 4, 1D - (0.0625D * 2), 0.0625D * 7D, 1D - (0.0625D * 4)),
    VoxelShapes.create(0.0625D * 2, 0.0D, 0.0625D * 4, 1D - (0.0625D * 2), 0.0625D * 5D, 1D - (0.0625D * 4)),
    VoxelShapes.create(0.0625D * 2, 0.0D, 0.0625D * 4, 1D - (0.0625D * 2), 0.0625D * 3D, 1D - (0.0625D * 4)),
    VoxelShapes.create(0.0625D * 2, 0.0D, 0.0625D * 4, 1D - (0.0625D * 2), 0.0625D * 2D, 1D - (0.0625D * 4))
    };
    protected static final VoxelShape[] Y_SHAPES = new VoxelShape[] {
    VoxelShapes.create(0.0625D * 3, 0.0D, 0.0625D * 2, 1D - (0.0625D * 3), 0.0625D * 7D, 1D - (0.0625D * 2)),
    VoxelShapes.create(0.0625D * 3, 0.0D, 0.0625D * 2, 1D - (0.0625D * 3), 0.0625D * 7D, 1D - (0.0625D * 2)),
    VoxelShapes.create(0.0625D * 3, 0.0D, 0.0625D * 2, 1D - (0.0625D * 3), 0.0625D * 7D, 1D - (0.0625D * 2)),
    VoxelShapes.create(0.0625D * 4, 0.0D, 0.0625D * 2, 1D - (0.0625D * 3), 0.0625D * 7D, 1D - (0.0625D * 2)),
    VoxelShapes.create(0.0625D * 4, 0.0D, 0.0625D * 2, 1D - (0.0625D * 4), 0.0625D * 7D, 1D - (0.0625D * 2)),
    VoxelShapes.create(0.0625D * 4, 0.0D, 0.0625D * 2, 1D - (0.0625D * 4), 0.0625D * 5D, 1D - (0.0625D * 2)),
    VoxelShapes.create(0.0625D * 4, 0.0D, 0.0625D * 2, 1D - (0.0625D * 4), 0.0625D * 3D, 1D - (0.0625D * 2)),
    VoxelShapes.create(0.0625D * 4, 0.0D, 0.0625D * 2, 1D - (0.0625D * 4), 0.0625D * 2D, 1D - (0.0625D * 2))
    };

    public BlockTurkey() {
        super(Block.Properties.create(Material.SPONGE));
        this.setDefaultState(this.stateContainer.getBaseState().with(BITES, 0).with(FACING, Direction.NORTH).with(BlockStateProperties.WATERLOGGED, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return state.get(FACING).getAxis() == Axis.X ? X_SHAPES[state.get(BITES)] : Y_SHAPES[state.get(BITES)];
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        if(hand == Hand.MAIN_HAND) {
            if(!worldIn.isRemote) {
                return eat(worldIn, pos, state, player);
            } else {
                ItemStack itemstack = player.getHeldItem(hand);
                return itemstack.isEmpty() ? ActionResultType.FAIL : eat(worldIn, pos, state, player);
            }
        }
        return ActionResultType.FAIL;
    }

    protected ActionResultType eat(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        if(!player.canEat(false)) {
            return ActionResultType.FAIL;
        } else {
            int i = state.get(BITES);

            if(i < 7) {
                worldIn.setBlockState(pos, state.with(BITES, i + 1), 3);
                if(i < 2) {
                    player.getFoodStats().addStats(2, 0.3F);
                } else {
                    player.getFoodStats().addStats(4, 0.3F);
                }
            } else {
                worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
                player.getFoodStats().addStats(4, 0.3F);
            }

            return ActionResultType.CONSUME;
        }
    }

    @Override
    public void onBlockAdded(BlockState state1, World world, BlockPos pos, BlockState state2, boolean unknown) {
        if(!world.getBlockState(pos.down()).isNormalCube(world, pos)) {
            world.destroyBlock(pos, true);
        }
    }

    @Override
    public boolean canDropFromExplosion(BlockState state, IBlockReader world, BlockPos pos, Explosion explosion) {
        return super.canDropFromExplosion(state, world, pos, explosion) && state.get(BITES) == 0;
    }

    @Override
    public void onNeighborChange(BlockState state, IWorldReader world, BlockPos pos, BlockPos neighbor) {
        super.onNeighborChange(state, world, pos, neighbor);
        if(!world.getBlockState(neighbor).isNormalCube(world, pos) && pos.down() == neighbor && world instanceof World) {
            ((World) world).destroyBlock(pos, true);
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing());
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(BlockStateProperties.WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : Fluids.EMPTY.getDefaultState();
    }

    @Override
    protected void fillStateContainer(Builder<Block, BlockState> builder) {
        builder.add(BITES, FACING, BlockStateProperties.WATERLOGGED);
    }

}