package its_meow.betteranimalsplus.common.item;

import javax.annotation.Nullable;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.tileentity.TileEntityHead;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemWallOrFloor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReaderBase;
import net.minecraft.world.World;

public class ItemBlockSkull extends ItemWallOrFloor {

	public final boolean allowFloor;
	public final int typeNum;

	public ItemBlockSkull(Block block, boolean allowFloor, int typeNum) {
		super(block, block, new Properties().group(BetterAnimalsPlusMod.group));
		if(block.getRegistryName() != null) {
			this.setRegistryName(block.getRegistryName());
		}
		this.allowFloor = allowFloor;
		this.typeNum = typeNum;
	}

	public ItemBlockSkull(Block block, boolean allowFloor, int typeNum, Properties prop) {
		super(block, block, prop);
		if(block.getRegistryName() != null) {
			this.setRegistryName(block.getRegistryName());
		}
		this.allowFloor = allowFloor;
		this.typeNum = typeNum;
	}

	@Nullable
	protected IBlockState getStateForPlacement(BlockItemUseContext ctx) {
		IBlockState returnedState = null;
		World world = ctx.getWorld();
		BlockPos clickPos = ctx.getPos();
		for (EnumFacing side : ctx.getNearestLookingDirections()) {
			IBlockState newState;
			if (side == EnumFacing.DOWN && !this.allowFloor)
				return returnedState;
			newState = this.getBlock().getStateForPlacement(ctx);
			if (newState == null || !newState.isValidPosition((IWorldReaderBase) world, clickPos))
				continue;
			returnedState = newState;
			break;
		}
		return returnedState != null && world.checkNoEntityCollision(returnedState, clickPos) ? returnedState : null;
	}

	public EnumActionResult tryPlace(BlockItemUseContext ctx) {
		if (!ctx.canPlace()) {
			return EnumActionResult.FAIL;
		} else {
			IBlockState iblockstate = this.getStateForPlacement(ctx);
			if (iblockstate == null) {
				return EnumActionResult.FAIL;
			} else if (!this.placeBlock(ctx, iblockstate)) {
				return EnumActionResult.FAIL;
			} else if(ctx.getFace() == EnumFacing.UP && !this.allowFloor) {
				return EnumActionResult.FAIL;
			} else {
				BlockPos blockpos = ctx.getPos();
				World world = ctx.getWorld();
				EntityPlayer player = ctx.getPlayer();
				ItemStack stack = ctx.getItem();
				IBlockState iblockstate1 = world.getBlockState(blockpos);
				Block block = iblockstate1.getBlock();
				if (block == iblockstate.getBlock()) {
					this.onBlockPlaced(blockpos, world, player, stack, iblockstate1);
					block.onBlockPlacedBy(world, blockpos, iblockstate1, player, stack);
					if (player instanceof EntityPlayerMP) {
						CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)player, blockpos, stack);
					}
					TileEntity tile = world.getTileEntity(blockpos);
					this.populateTile(stack, ctx.getFace(), player, tile);
				}

				SoundType soundtype = iblockstate1.getSoundType(world, blockpos, ctx.getPlayer());
				world.playSound(player, blockpos, soundtype.getPlaceSound(), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
				stack.shrink(1);
				return EnumActionResult.SUCCESS;
			}
		}
	}

	protected void populateTile(ItemStack stack, EnumFacing side, EntityPlayer player, TileEntity tile) {
		if(tile instanceof TileEntityHead) {
			TileEntityHead tileSkull = (TileEntityHead) tile;
			float rotation = 0;
			if(side == EnumFacing.UP || side == EnumFacing.DOWN) {
				rotation = EnumFacing.fromAngle(player.rotationYawHead).getHorizontalAngle();
			} else {
				rotation = (int) side.getHorizontalAngle();
			}
			tileSkull.setRotation(rotation);
			tileSkull.setType(typeNum);
		}
	}

	public String getTranslationKey() {
		return "block" + "." + Ref.MOD_ID + "." + this.getRegistryName().getPath();
	}

}
