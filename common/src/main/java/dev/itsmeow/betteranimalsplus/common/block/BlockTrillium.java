package dev.itsmeow.betteranimalsplus.common.block;

import dev.itsmeow.betteranimalsplus.init.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BlockTrillium extends BushBlock implements EntityBlock {

    private static final VoxelShape SHAPE = Shapes.box(0.15F, 0.0F, 0.15F, 0.85F, 0.9F, 0.85F);

    public BlockTrillium() {
        super(Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission());
        this.registerDefaultState(this.defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext ctx) {
        return SHAPE;
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos neighbor, boolean bl) {
        super.neighborChanged(state, level, pos, block, neighbor, bl);
        if (!level.getBlockState(neighbor).isRedstoneConductor(level, pos) && pos.below() == neighbor) {
            level.destroyBlock(pos, true);
        }
    }

    @Override
    protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
        builder.add(HorizontalDirectionalBlock.FACING);
    }

    @Override
    public void onPlace(BlockState state1, Level world, BlockPos pos, BlockState state2, boolean unknown) {
        if (!world.getBlockState(pos.below()).isRedstoneConductor(world, pos)) {
            world.destroyBlock(pos, true);
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, context.getHorizontalDirection());
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    public BlockEntity newBlockEntity(BlockGetter blockGetter) {
        return ModBlockEntities.TRILLIUM_TYPE.get().create();
    }
}
