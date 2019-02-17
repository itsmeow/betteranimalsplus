package its_meow.betteranimalsplus.common.item;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import net.minecraft.item.Item;

public class ItemAntler extends Item {
	
	public ItemAntler() {
		super(new Properties().group(BetterAnimalsPlusMod.group));
		this.setRegistryName("antler");
	}
	
}
