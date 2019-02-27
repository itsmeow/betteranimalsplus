package its_meow.betteranimalsplus.common.item;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.common.tileentity.TileEntityHead;
import its_meow.betteranimalsplus.init.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSkull;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ItemBlockSkull extends ItemBlock {

	private boolean allowFloor = true;

	public ItemBlockSkull(Block block, boolean allowFloor, int i) {
		super(block, new Properties().group(BetterAnimalsPlusMod.group));
		this.setRegistryName(block.getRegistryName() + "_" + i);
		this.allowFloor = allowFloor;
	}

	public ItemBlockSkull(Block block, boolean allowFloor, int i, Properties prop) {
		super(block, prop);
		this.setRegistryName(block.getRegistryName() + "_" + i);
		this.allowFloor = allowFloor;
	}


	@Override
	protected boolean canPlace(BlockItemUseContext ctx, IBlockState state) {
		World world = ctx.getWorld();
		BlockPos pos = ctx.getPos();
		EnumFacing side = ctx.getFace();
		Block block = world.getBlockState(pos).getBlock();
		ItemStack stack = ctx.getItem();

		if(block == Blocks.SNOW && block.isReplaceable(state, ctx)) {
			side = EnumFacing.UP;
		} else if(!block.isReplaceable(state, ctx)) {
			pos = pos.offset(side);
		}
		return block.isReplaceable(state, ctx);
	}

	@Override
	public EnumActionResult onItemUse(ItemUseContext ctx) {
		EntityPlayer player = ctx.getPlayer();
		ItemStack stack = ctx.getItem();
		EnumFacing side = ctx.getFace();
		BlockPos pos = ctx.getPos();
		World world = ctx.getWorld();
		if(side == EnumFacing.DOWN || side == EnumFacing.UP && !this.allowFloor) {
			return EnumActionResult.FAIL;
		} else {
			BlockPos clickedPos = pos.offset(side);
			IBlockState clickedState = world.getBlockState(clickedPos);
			if(!clickedState.getBlock().isReplaceable(clickedState, new BlockItemUseContext(ctx))) {
				return EnumActionResult.FAIL;
			}
			if(!world.isRemote) {
				world.setBlockState(clickedPos,
						this.getBlock().getDefaultState().with(BlockSkull.ROTATION, side.getIndex()), 3);

				TileEntity tile = world.getTileEntity(clickedPos);
				this.populateTile(stack, side, player, tile);
			}
			if(!player.isCreative()) {
				stack.shrink(1);
			}
			return EnumActionResult.SUCCESS;
		}
	}

	protected void populateTile(ItemStack stack, EnumFacing side, EntityPlayer player, TileEntity tile) {
		if(tile instanceof TileEntityHead) {
			TileEntityHead tileSkull = (TileEntityHead) tile;
			int rotation = 0;
			if(side == EnumFacing.UP) {
				rotation = MathHelper.floor(player.rotationYaw * 16.0F / 360.0F + 0.5D) & 15;
			}
			tileSkull.setRotation(rotation);
			tileSkull.setType(BlockRegistry.getTypeForItem(stack.getItem().getRegistryName()));
		}
	}

}
