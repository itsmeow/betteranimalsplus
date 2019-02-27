package its_meow.betteranimalsplus;

import its_meow.betteranimalsplus.init.ItemRegistry;
import its_meow.betteranimalsplus.init.MobRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemSpawnEgg;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class BetterAnimalsItemGroup extends ItemGroup {

	public BetterAnimalsItemGroup(String tab) {
		super(tab);
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(ItemRegistry.antler);
	}

	@Override
	public void fill(NonNullList<ItemStack> toDisplay) {
		super.fill(toDisplay);
		for(ItemSpawnEgg egg : MobRegistry.eggs) {
			ItemStack stack = new ItemStack(egg);
			toDisplay.add(stack);
		}
	}

}
