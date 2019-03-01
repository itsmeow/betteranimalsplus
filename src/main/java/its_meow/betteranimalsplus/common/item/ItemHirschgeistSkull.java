package its_meow.betteranimalsplus.common.item;

import java.util.List;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemHirschgeistSkull extends ItemBlockSkull {

	public ItemHirschgeistSkull(Block block) {
		super(block, true, 1, new Properties().maxStackSize(1).group(BetterAnimalsPlusMod.group));
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TextComponentString("It can be worn via placing it into an empty crafting table"));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}


}
