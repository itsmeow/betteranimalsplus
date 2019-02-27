package its_meow.betteranimalsplus.common.item;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class ItemGoatCheese extends ItemFood {

	/** Number of ticks to run while 'EnumAction'ing until result. */
	public final int itemUseDuration;
	/** The amount this food item heals the player. */
	private final int healAmount;

	private final boolean isMeat = false;

	public ItemGoatCheese() {
		super(3, 1, false, new Properties().group(BetterAnimalsPlusMod.group));
		this.setRegistryName("goatcheese");
		this.itemUseDuration = 15;
		this.healAmount = 3;
	}

	/**
	 * How long it takes to use or consume an item
	 */
	public int getMaxItemUseDuration(ItemStack stack) {
		return this.itemUseDuration;
	}


	@Override
	public int getHealAmount(ItemStack stack) {
		return this.healAmount;
	}

	@Override
	public boolean isMeat() {
		return this.isMeat;
	}

	/**
	 * returns the action that specifies what animation to play when the items
	 * is being used
	 */
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.EAT;
	}

}
