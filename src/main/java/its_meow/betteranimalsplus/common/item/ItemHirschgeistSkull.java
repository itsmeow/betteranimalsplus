package its_meow.betteranimalsplus.common.item;

import java.util.List;

import its_meow.betteranimalsplus.common.tileentity.TileEntityHead;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSkull;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ItemHirschgeistSkull extends ItemBlockSkull {

	public ItemHirschgeistSkull(Block block) {
		super(block, true);
		setMaxDamage(0);
		this.setUnlocalizedName("betteranimalsplus.hirschgeistskull");
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("It can be worn via placing it into an empty crafting table");
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
	
	
	


}
