package its_meow.betteranimalsplus;

import its_meow.betteranimalsplus.init.ItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTab extends CreativeTabs {

	public CreativeTab(String tab) {
		super(tab);
	}
	
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ItemRegistry.antler);
	}

	
}
