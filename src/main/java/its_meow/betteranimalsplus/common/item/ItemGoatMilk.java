package its_meow.betteranimalsplus.common.item;

import net.minecraft.init.Items;
import net.minecraft.item.ItemBucketMilk;

public class ItemGoatMilk extends ItemBucketMilk {
	
	public ItemGoatMilk() {
		super();
		this.setRegistryName("goatmilk");
		this.setUnlocalizedName("betteranimalsplus.goatmilk");
		this.setContainerItem(Items.BUCKET);
	}
	
}
