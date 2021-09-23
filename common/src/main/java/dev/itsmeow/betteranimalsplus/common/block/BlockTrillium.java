package dev.itsmeow.betteranimalsplus.common.block;

import dev.itsmeow.betteranimalsplus.common.tileentity.TileEntityTrillium;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import net.minecraft.block.AbstractBlock.Properties;

public class BlockTrillium extends BushBlock {

    private static final VoxelShape SHAPE = VoxelShapes.box(0.15F, 0.0F, 0.15F, 0.85F, 0.9F, 0.85F);

    public BlockTrillium() {
        super(Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission());
        this.registerDefaultState(this.defaultBlockState().setValue(HorizontalBlock.FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext ctx) {
        return SHAPE;
    }

    @Override
    public void onNeighborChange(BlockState state, IWorldReader world, BlockPos pos, BlockPos neighbor) {
        super.onNeighborChange(state, world, pos, neighbor);
        if(!world.getBlockState(neighbor).isRedstoneConductor(world, pos) && pos.below() == neighbor) {
            World world1 = (World) world;
            world1.destroyBlock(pos, true);
        }
    }

    @Override
    protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
        builder.add(HorizontalBlock.FACING);
    }

    @Override
    public void onPlace(BlockState state1, World world, BlockPos pos, BlockState state2, boolean unknown) {
        if(!world.getBlockState(pos.below()).isRedstoneConductor(world, pos)) {
            world.destroyBlock(pos, true);
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.defaultBlockState().setValue(HorizontalBlock.FACING, context.getHorizontalDirection());
    }

    @Override
    public BlockRenderType getRenderShape(BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TileEntityTrillium();
    }
}
