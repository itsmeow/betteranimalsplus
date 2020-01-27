package its_meow.betteranimalsplus.common.item;

import javax.annotation.Nullable;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.tileentity.TileEntityHead;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.WallOrFloorItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemBlockSkull extends WallOrFloorItem {

    public final boolean allowFloor;
    public final int typeNum;

    public ItemBlockSkull(Block block, boolean allowFloor, int typeNum) {
        super(block, block, new Properties().group(BetterAnimalsPlusMod.group));
        if (block.getRegistryName() != null) {
            this.setRegistryName(block.getRegistryName());
        }
        this.allowFloor = allowFloor;
        this.typeNum = typeNum;
    }

    public ItemBlockSkull(Block block, boolean allowFloor, int typeNum, Properties prop) {
        super(block, block, prop);
        if (block.getRegistryName() != null) {
            this.setRegistryName(block.getRegistryName());
        }
        this.allowFloor = allowFloor;
        this.typeNum = typeNum;
    }

    @SuppressWarnings("resource")
    @Override
    @Nullable
    protected BlockState getStateForPlacement(BlockItemUseContext ctx) {
        BlockState returnedState = null;
        World world = ctx.getWorld();
        BlockPos clickPos = ctx.getPos();
        for (Direction side : ctx.getNearestLookingDirections()) {
            BlockState newState;
            if (side == Direction.DOWN && !this.allowFloor)
                return returnedState;
            newState = this.getBlock().getStateForPlacement(ctx);
            if (newState == null || !newState.isValidPosition(world, clickPos))
                continue;
            returnedState = newState;
            break;
        }
        return returnedState;
    }

    @SuppressWarnings("resource")
    @Override
    public ActionResultType tryPlace(BlockItemUseContext ctx) {
        if (!ctx.canPlace()) {
            return ActionResultType.FAIL;
        } else {
            if (ctx.getFace() == Direction.DOWN) { 
                return ActionResultType.FAIL;
            }
            BlockState iblockstate = this.getStateForPlacement(ctx);
            if (iblockstate == null) {
                return ActionResultType.FAIL;
            } else if (!this.placeBlock(ctx, iblockstate)) {
                return ActionResultType.FAIL;
            } else if (ctx.getFace() == Direction.UP && !this.allowFloor) {
                return ActionResultType.FAIL;
            } else {
                BlockPos blockpos = ctx.getPos();
                World world = ctx.getWorld();
                PlayerEntity player = ctx.getPlayer();
                ItemStack stack = ctx.getItem();
                BlockState iblockstate1 = world.getBlockState(blockpos);
                Block block = iblockstate1.getBlock();
                if (block == iblockstate.getBlock()) {
                    this.onBlockPlaced(blockpos, world, player, stack, iblockstate1);
                    block.onBlockPlacedBy(world, blockpos, iblockstate1, player, stack);
                    if (player instanceof ServerPlayerEntity) {
                        CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity) player, blockpos, stack);
                    }
                    TileEntity tile = world.getTileEntity(blockpos);
                    this.populateTile(stack, ctx.getFace(), player, tile);
                }

                SoundType soundtype = iblockstate1.getSoundType(world, blockpos, ctx.getPlayer());
                world.playSound(player, blockpos, soundtype.getPlaceSound(), SoundCategory.BLOCKS,
                        (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
                stack.shrink(1);
                return ActionResultType.SUCCESS;
            }
        }
    }

    protected void populateTile(ItemStack stack, Direction side, PlayerEntity player, TileEntity tile) {
        if (tile instanceof TileEntityHead) {
            TileEntityHead tileSkull = (TileEntityHead) tile;
            float rotation = 0;
            if (side == Direction.UP || side == Direction.DOWN) {
                rotation = Direction.fromAngle(player.rotationYawHead).getHorizontalAngle();
            } else {
                rotation = (int) side.getHorizontalAngle();
            }
            tileSkull.setRotation(rotation);
            tileSkull.setType(typeNum);
        }
    }

    @Override
    public String getTranslationKey() {
        return "block" + "." + Ref.MOD_ID + "." + this.getRegistryName().getPath();
    }

}
