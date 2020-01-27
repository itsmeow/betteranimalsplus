package its_meow.betteranimalsplus.common.block;

import its_meow.betteranimalsplus.common.tileentity.TileEntityHandOfFate;
import its_meow.betteranimalsplus.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockHandOfFate extends HorizontalBlock implements IWaterLoggable {

    private static VoxelShape SHAPE;

    static {
        double d = 0.0625D * 3;
        SHAPE = VoxelShapes.create(d, 0.0D, d, 1D - d, 1.2D, 1D - d);
    }

    public BlockHandOfFate() {
        super(Properties.create(Material.IRON).hardnessAndResistance(3.0F, 2.0F));
        this.setRegistryName("handoffate");
        this.setDefaultState(this.getDefaultState().with(HorizontalBlock.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.WATERLOGGED, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext ctx) {
        return SHAPE;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean hasCustomBreakingProgress(BlockState state) {
        return true;
    }

    @Override
    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TileEntityHandOfFate) {
            TileEntityHandOfFate tehof = (TileEntityHandOfFate) te;
            if (tehof.isOnFire()) {
                return 15;
            }
        }
        return super.getLightValue(state, world, pos);
    }

    @SuppressWarnings("deprecation")
    @Override
    public IFluidState getFluidState(BlockState state) {
        return state.get(BlockStateProperties.WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }

    @Override
    protected void fillStateContainer(Builder<Block, BlockState> builder) {
        builder.add(HorizontalBlock.HORIZONTAL_FACING, BlockStateProperties.WATERLOGGED);
    }

    @Override
    public int getOpacity(BlockState state, IBlockReader world, BlockPos pos) {
        return 1;
    }

    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand hand,
            BlockRayTraceResult hit) {
        ItemStack held = player.getHeldItem(hand);
        if (held.getItem() == Items.FLINT_AND_STEEL) {
            if (!player.isCreative()) {
                held.damageItem(1, player, p -> {});
            }
            worldIn.getPendingBlockTicks().scheduleTick(pos, state.getBlock(), 100);
            worldIn.notifyBlockUpdate(pos, worldIn.getBlockState(pos), worldIn.getBlockState(pos), 0);
            //worldIn.markBlockRangeForRenderUpdate(pos.down(5).west(5).north(5), pos.up(5).east(5).south(5));
            TileEntity te = worldIn.getTileEntity(pos);
            if (te instanceof TileEntityHandOfFate) {
                TileEntityHandOfFate tehof = (TileEntityHandOfFate) te;
                tehof.setOnFire(true);
                return true;
            }
        } else if (held.getItem() == Blocks.SAND.asItem() || held.getItem() == Items.WATER_BUCKET) {
            TileEntity te = worldIn.getTileEntity(pos);
            if (te instanceof TileEntityHandOfFate) {
                TileEntityHandOfFate tehof = (TileEntityHandOfFate) te;
                tehof.setOnFire(false);
                return true;
            }
        } else if (held.getItem() == Items.NETHER_WART) {
            TileEntity te = worldIn.getTileEntity(pos);
            if (te instanceof TileEntityHandOfFate) {
                TileEntityHandOfFate tehof = (TileEntityHandOfFate) te;
                if (!tehof.hasNetherWart() && tehof.isOnFire()) {
                    if (!player.isCreative()) {
                        held.shrink(1);
                    }
                    tehof.setHasNetherWart(player, true);
                    return true;
                }
            }
        } else if (held.getItem() == ModItems.ANTLER) {
            TileEntity te = worldIn.getTileEntity(pos);
            if (te instanceof TileEntityHandOfFate) {
                TileEntityHandOfFate tehof = (TileEntityHandOfFate) te;
                if (!tehof.hasAntler() && tehof.isOnFire()) {
                    if (!player.isCreative()) {
                        held.shrink(1);
                    }
                    tehof.setHasAntler(player, true);
                    return true;
                }
            }
        } else if (held.getItem() == ModItems.VENISON_RAW || held.getItem() == ModItems.VENISON_COOKED) {
            TileEntity te = worldIn.getTileEntity(pos);
            if (te instanceof TileEntityHandOfFate) {
                TileEntityHandOfFate tehof = (TileEntityHandOfFate) te;
                if (!tehof.hasVenison() && tehof.isOnFire()) {
                    if (!player.isCreative()) {
                        held.shrink(1);
                    }
                    tehof.setHasVenison(player, true);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing());
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
    public boolean isSolid(BlockState state) {
        return false;
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
    public TileEntity createTileEntity(BlockState state, IBlockReader worldIn) {
        return new TileEntityHandOfFate();
    }

}
