package its_meow.betteranimalsplus.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class CraftingRegistry {

	public static final void register() {
		//Smelting
		GameRegistry.addSmelting(new ItemStack(ItemRegistry.venisonRaw), new ItemStack(ItemRegistry.venisonCooked), 0.0F);
		GameRegistry.addSmelting(new ItemStack(ItemRegistry.pheasantRaw), new ItemStack(ItemRegistry.pheasantCooked), 0.0F);
		
		//Register oredict
		OreDictionary.registerOre("listAllmeatraw", ItemRegistry.venisonRaw);
		OreDictionary.registerOre("listAllmeatcooked", ItemRegistry.venisonCooked);
		OreDictionary.registerOre("listAllmeatraw", ItemRegistry.pheasantRaw);
		OreDictionary.registerOre("listAllmeatcooked", ItemRegistry.pheasantCooked);
	}
}
