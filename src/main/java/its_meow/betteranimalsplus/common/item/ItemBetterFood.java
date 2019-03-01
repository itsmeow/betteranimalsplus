package its_meow.betteranimalsplus.common.item;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class ItemBetterFood extends ItemFood {
	
	public final int itemUseDuration;

	public ItemBetterFood(String name, int foodToFill, float saturationMultiplier, int eatLength, boolean isMeat) {
		super(foodToFill, saturationMultiplier, isMeat, new Properties().group(BetterAnimalsPlusMod.group));
		this.setRegistryName(name);
		this.itemUseDuration = eatLength;
	}

	public int getMaxItemUseDuration(ItemStack stack) {
		return this.itemUseDuration;
	}
	
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.EAT;
	}
	
}
