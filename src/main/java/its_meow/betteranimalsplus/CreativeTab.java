package its_meow.betteranimalsplus;

import its_meow.betteranimalsplus.init.EntityContainer;
import its_meow.betteranimalsplus.init.ItemRegistry;
import its_meow.betteranimalsplus.init.MobRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

public class CreativeTab extends CreativeTabs {

	public CreativeTab(String tab) {
		super(tab);
	}
	
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ItemRegistry.antler);
	}

	@Override
	public void displayAllRelevantItems(NonNullList<ItemStack> toDisplay) {
		super.displayAllRelevantItems(toDisplay);
		for(EntityContainer cont : MobRegistry.entityList) {
			ItemStack stack = new ItemStack(Items.SPAWN_EGG);
			ItemMonsterPlacer.applyEntityIdToItemStack(stack, new ResourceLocation(Ref.MOD_ID, cont.entityName));
			toDisplay.add(stack);
		}
	}
	
	

	
}
