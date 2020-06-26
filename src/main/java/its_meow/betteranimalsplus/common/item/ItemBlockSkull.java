package its_meow.betteranimalsplus.common.item;

import javax.annotation.Nullable;

import dev.itsmeow.imdlib.entity.util.IVariant;
import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.block.BlockAnimalSkull;
import its_meow.betteranimalsplus.util.HeadType.PlacementType;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.WallOrFloorItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemBlockSkull extends WallOrFloorItem {

    public final PlacementType placement;
    public final String id;
    public final IVariant variant;

    public ItemBlockSkull(Block block, PlacementType placement, String id, IVariant variant) {
        super(block, block, new Properties().group(BetterAnimalsPlusMod.group));
        if(block.getRegistryName() != null) {
            this.setRegistryName(block.getRegistryName());
        }
        this.placement = placement;
        this.id = id;
        this.variant = variant;
    }

    public ItemBlockSkull(Block block, PlacementType placement, String id, IVariant variant, Properties prop) {
        super(block, block, prop);
        if(block.getRegistryName() != null) {
            this.setRegistryName(block.getRegistryName());
        }
        this.placement = placement;
        this.id = id;
        this.variant = variant;
    }

    @Override
    @Nullable
    protected BlockState getStateForPlacement(BlockItemUseContext ctx) {
        BlockState returnedState = null;
        World world = ctx.getWorld();
        BlockPos clickPos = ctx.getPos();
        for(Direction side : ctx.getNearestLookingDirections()) {
            BlockState newState;
            if(side == Direction.DOWN && placement != PlacementType.FLOOR_AND_WALL) {
                return null;
            }
            newState = this.getBlock().getStateForPlacement(ctx);
            if(newState == null || !newState.isValidPosition(world, clickPos) || (newState.get(BlockAnimalSkull.FACING_EXCEPT_DOWN) == Direction.UP && placement != PlacementType.FLOOR_AND_WALL))
                continue;
            returnedState = newState;
            break;
        }
        return returnedState;
    }

    @Override
    public ActionResultType tryPlace(BlockItemUseContext ctx) {
        if(!ctx.canPlace()) {
            return ActionResultType.FAIL;
        } else {
            if(ctx.getFace() == Direction.DOWN) {
                return ActionResultType.FAIL;
            }
            BlockState placementState = this.getStateForPlacement(ctx);
            if(placementState == null) {
                return ActionResultType.FAIL;
            } else if(!this.placeBlock(ctx, placementState)) {
                return ActionResultType.FAIL;
            } else if(ctx.getFace() == Direction.UP && placement != PlacementType.FLOOR_AND_WALL) {
                return ActionResultType.FAIL;
            } else {
                BlockPos blockpos = ctx.getPos();
                World world = ctx.getWorld();
                PlayerEntity player = ctx.getPlayer();
                ItemStack stack = ctx.getItem();
                BlockState newState = world.getBlockState(blockpos);
                Block block = newState.getBlock();
                if(block == placementState.getBlock()) {
                    this.onBlockPlaced(blockpos, world, player, stack, newState);
                    block.onBlockPlacedBy(world, blockpos, newState, player, stack);
                    if(player instanceof ServerPlayerEntity) {
                        CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity) player, blockpos, stack);
                    }
                }

                SoundType soundtype = newState.getSoundType(world, blockpos, ctx.getPlayer());
                world.playSound(player, blockpos, soundtype.getPlaceSound(), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
                stack.shrink(1);
                return ActionResultType.SUCCESS;
            }
        }
    }

    @Override
    public String getTranslationKey() {
        return "block" + "." + Ref.MOD_ID + "." + this.getRegistryName().getPath();
    }

}
