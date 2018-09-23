package its_meow.betteranimalsplus;

import its_meow.betteranimalsplus.registry.ItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CreativeTab extends CreativeTabs {

	public CreativeTab(String tab) {
		super(tab);
	}
	
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ItemRegistry.antler);
	}

	
}
