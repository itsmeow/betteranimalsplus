package its_meow.betteranimalsplus.common.item;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucketMilk;

public class ItemGoatMilk extends ItemBucketMilk {

	public ItemGoatMilk() {
		super(new Properties().containerItem(Items.BUCKET).group(BetterAnimalsPlusMod.group));
		this.setRegistryName("goatmilk");
	}

}
